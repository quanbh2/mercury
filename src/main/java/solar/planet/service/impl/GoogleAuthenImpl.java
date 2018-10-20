package solar.planet.service.impl;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solar.planet.common.message.Text;
import solar.planet.entity.Resource;
import solar.planet.entity.Role;
import solar.planet.entity.User;
import solar.planet.entity.UserRole;
import solar.planet.exception.BadRequestEx;
import solar.planet.security.JwtTokenProvider;
import solar.planet.service.*;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@Transactional
public class GoogleAuthenImpl implements AuthenService {

    String clientId = "139427845825-fku0gb8l1k5go6t3ml1pp8cis5k5jd1h.apps.googleusercontent.com";
    long jwtExpirationInMs =86400000L;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public Map<String, Object> verify(String token) {

        GoogleIdTokenVerifier verifier =
                new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance())
                        .setAudience(Collections.singletonList(clientId)).build();

        // verify token
        GoogleIdToken idToken = null;
        try {
            idToken = verifier.verify(token);
        } catch (Exception ex) {
            throw new BadRequestEx(Text.UN_VERIFIED);
        }
        if (idToken == null) {
            throw new BadRequestEx(Text.NULL_TOKEN);
        }

        // parse data from token
        GoogleIdToken.Payload payload = idToken.getPayload();
        String email = payload.getEmail();
        String picture = (String) payload.get("picture");
        checkHustEmail(email);
        String userName = email.replaceAll("@gmail.com|@topica.edu.vn", "");
        User user = userService.findByEmail(email);
        if (user != null) {
            return getData(user);
        } else {
            User userNew = new User();
            userNew.setPicture(picture);
            userNew.setEmail(email);
            userNew.setUserName(userName);
            User userDb = userService.save(userNew);
            log.info("userDb : {}",userDb);
            Role roleGuest = roleService.findByName("GUEST");
            log.info("role : {}",roleGuest);
            Resource resource = resourceService.findByName("SENSOR");
            log.info("resource : {}",resource);
            if (roleGuest != null) {
                UserRole userRole = new UserRole();
                userRole.setRole(roleGuest);
                userRole.setUser(userDb);
                userRole.setResource(resource);
                userRoleService.save(userRole);
            }
            return getData(userDb);
        }

    }

    private Map<String, Object> getData(User user) {
        Date expirationDate = new Date(System.currentTimeMillis() + jwtExpirationInMs);
        Timestamp ts = new Timestamp(expirationDate.getTime());
        Long expiration = ts.getTime();

        String JWT = jwtTokenProvider.generateToken(user);
        Map<String, Object> data = new HashMap<>();
        data.put("user", user);
        data.put("jwt", JWT);
        data.put("expiration", expiration);
        return data;
    }

    private void checkHustEmail(String email) {

//        if (!email.matches(".*@topica.edu.vn|.*@topica.asia")) {
//            throw new BadRequestException(trans.convert("authentication.invalidTopicaEmail"));
//        }
    }
}

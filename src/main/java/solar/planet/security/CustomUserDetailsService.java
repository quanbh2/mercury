package solar.planet.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import solar.planet.entity.User;
import solar.planet.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        return null;
    }

    public UserDetails loadUserById(Integer id) {

        User user = userService.findById(id);

        Set<String> listPrivilege = new HashSet<>();
        user.getUserRoles().forEach(userRole -> {
            userRole.getRole().getRolePrivileges().forEach(rolePrivilege -> {
                String privilegeName = rolePrivilege.getPrivilege().getName();
                String resourceName = userRole.getResource().getName();
                listPrivilege.add("ROLE_" + resourceName + "_" + privilegeName);
            });
        });

        List<GrantedAuthority> authorities =
                listPrivilege.stream().map(privilege -> new SimpleGrantedAuthority(privilege))
                        .collect(Collectors.toList());
        log.info(" Authorities : {}",authorities);
        UserPrincipal userPrincipal = new UserPrincipal(user.getId(), user.getEmail(), authorities);

        return userPrincipal;
    }
}

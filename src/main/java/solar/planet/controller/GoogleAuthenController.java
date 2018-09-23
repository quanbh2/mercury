package solar.planet.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solar.planet.common.message.Text;
import solar.planet.service.impl.GoogleAuthenImpl;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/auth")
@Slf4j
public class GoogleAuthenController {

    @Autowired
    private GoogleAuthenImpl googleAuthen;

    @PostMapping("/verify")
    public ResponseEntity<Object> verify(@RequestBody Map<String, String> token) {
        log.info(" token : {} ", token.get("token"));
        return getResponse(Text.VERIFIED, HttpStatus.OK, googleAuthen.verify(token.get("token")));
    }

    public ResponseEntity<Object> getResponse(String message, HttpStatus httpStatus, Object... data) {
        Map<String, Object> mapResponse = new HashMap<>();
        if (data == null || (data.getClass().isArray() && data.length == 0)) {
            mapResponse.put("data", new HashMap<>());
        } else {
            mapResponse.put("data", data[0]);
        }
        mapResponse.put("message", message);
        return new ResponseEntity<>(mapResponse, httpStatus);
    }
}

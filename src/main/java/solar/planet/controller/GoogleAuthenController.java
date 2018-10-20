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

import java.util.Map;

@RestController
@RequestMapping("api/auth")
@Slf4j
public class GoogleAuthenController extends BaseController {

    @Autowired
    private GoogleAuthenImpl googleAuthen;

    @PostMapping("/verify")
    public ResponseEntity<Object> verify(@RequestBody Map<String, String> token) {
        log.info(" token : {} ", token.get("token"));

        return getResponse(Text.VERIFIED, HttpStatus.OK, googleAuthen.verify(token.get("token")));
    }
}

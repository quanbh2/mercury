package solar.planet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solar.planet.common.message.Text;
import solar.planet.service.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getRole(@PathVariable int id) {
        return getResponse(Text.OK, HttpStatus.OK, userService.findById(id));
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

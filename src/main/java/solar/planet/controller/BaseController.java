package solar.planet.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class BaseController {

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

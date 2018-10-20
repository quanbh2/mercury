package solar.planet.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class ExHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({BadRequestEx.class})
    protected ResponseEntity<Object> getBadRequest(RuntimeException ex, WebRequest request) {
        return getResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ResourceNotFoundEx.class})
    protected ResponseEntity<Object> notFoundResource(RuntimeException ex, WebRequest request) {
        return getResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Object> getResponse(String message, HttpStatus httpStatus, Object... data) {
        Map<String, Object> map = new HashMap<>();
        if (data == null || (data.getClass().isArray() && data.length == 0)) {
            map.put("data", new HashMap<>());
        } else {
            map.put("data", data[0]);
        }
        map.put("message", message);
        return new ResponseEntity<>(map, httpStatus);
    }
}

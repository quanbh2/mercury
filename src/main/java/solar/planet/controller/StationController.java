package solar.planet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solar.planet.common.message.Text;
import solar.planet.service.StationService;

@RestController
@RequestMapping("/api/stations")
public class StationController extends BaseController {

    @Autowired
    StationService stationService;

    @Secured({"ROLE_SENSOR_VIEW", "ROLE_ADMIN"})
    @GetMapping("/{id}")
    public ResponseEntity<Object> getRole(@PathVariable int id) {

        return getResponse(Text.OK, HttpStatus.OK, stationService.findById(id));
    }
}

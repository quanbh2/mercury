package solar.planet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solar.planet.common.message.Text;
import solar.planet.service.InitDataService;

@RestController
@RequestMapping("/api/initdata")
public class SampleDataController extends BaseController {

    @Autowired
    InitDataService initDataService;

    @GetMapping("")
    public ResponseEntity<Object> getRole() {

        return getResponse(Text.OK, HttpStatus.OK, initDataService.sampleData());
    }
}

package solar.planet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solar.planet.common.message.Text;
import solar.planet.service.NodeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

@RestController
@RequestMapping("/api/nodes")
public class NodeController extends BaseController{

    @Autowired
    NodeService nodeService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getRole(@PathVariable int id) {

        return getResponse(Text.OK, HttpStatus.OK, nodeService.findById(id));
    }

    @GetMapping("")
    public ResponseEntity<Object> list( @PageableDefault(size = 40) Pageable pageable) {

        return getResponse(Text.OK, HttpStatus.OK, nodeService.findAll(pageable));
    }

    @GetMapping("/{id}/day")
    public ResponseEntity<Object> getData(@PathVariable int id) {

        HashMap<String , ArrayList<String> > hm = new HashMap<>();
        ArrayList<String> hours = new ArrayList<>();
        ArrayList<String> green = new ArrayList<>();
        ArrayList<String> red = new ArrayList<>();
        ArrayList<String> orange = new ArrayList<>();

        for (int i = 0; i < 24; i++) {
            hours.add(i+":00");
            Integer data = getRandomNumberInRange(22,37);
            green.add(data.toString());
            orange.add("7");
            red.add("40");
        }

        hm.put("hours",hours);
        hm.put("green",green);
        hm.put("red",red);
        hm.put("orange",orange);



        return getResponse(Text.OK, HttpStatus.OK, hm);
    }

    @GetMapping("/{id}/week")
    public ResponseEntity<Object> getDataWeek(@PathVariable int id) {

        HashMap<String , ArrayList<String> > hm = new HashMap<>();
        ArrayList<String> data = new ArrayList<>();
        ArrayList<String> dayName = new ArrayList<>();


        for (int i = 1; i < 8; i++) {
            Integer x = getRandomNumberInRange(22,32);
            data.add(x.toString());
            dayName.add("Day0"+i);
        }

        hm.put("data",data);
        hm.put("dayName",dayName);

        return getResponse(Text.OK, HttpStatus.OK, hm);
    }

    @GetMapping("/{id}/month")
    public ResponseEntity<Object> getDataMonth(@PathVariable int id) {

        HashMap<String , ArrayList<String> > hm = new HashMap<>();
        ArrayList<String> data = new ArrayList<>();
        ArrayList<String> dayName = new ArrayList<>();


        for (int i = 1; i < 8; i++) {
            Float x = 27.77F;
            data.add(x.toString());
            dayName.add("Day0"+i);
        }

        hm.put("data",data);
        hm.put("dayName",dayName);

        return getResponse(Text.OK, HttpStatus.OK, hm);
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}

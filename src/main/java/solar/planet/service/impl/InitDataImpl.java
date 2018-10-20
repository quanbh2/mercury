package solar.planet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solar.planet.entity.Node;
import solar.planet.entity.Station;
import solar.planet.entity.User;
import solar.planet.entity.UserStation;
import solar.planet.enumeration.StatusEnum;
import solar.planet.repository.NodeRepository;
import solar.planet.repository.UserStationRepository;
import solar.planet.service.InitDataService;
import solar.planet.service.StationService;
import solar.planet.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class InitDataImpl implements InitDataService {

    @Autowired
    StationService stationService ;

    @Autowired
    UserService userService;

    @Autowired
    UserStationRepository userStationRepository ;

    @Autowired
    NodeRepository nodeRepository;

    @Override
    public Boolean sampleData() {

        // add Data Station
        List<Station> stationList = new ArrayList<>();
        for (Integer i = 0; i < 6; i++) {
            Station station = new Station();
            station.setCodeStation("BK-"+i+"S");
            if ( i % 2 == 0) {
                station.setStatus(StatusEnum.ACTIVE.getName());
            } else {
                station.setStatus(StatusEnum.INACTIVE.getName());
            }
            station.setStationName("Bk-Station "+i+"S");
            stationList.add(stationService.save(station));
        }

        User user = userService.findByEmail("quanbh2@topica.edu.vn");
        if ( user != null ) {
            for (Station s : stationList) {
                UserStation  userStation = new UserStation();
                userStation.setUser(user);
                userStation.setStation(s);
                userStationRepository.save(userStation);
            }

        }

        // add Node
        for (Integer i = 0; i < 10; i++) {
            Node node = new Node();
            node.setCodeNode("No-" + i);
            node.setStation(stationList.get(0));
            if ( i % 2 == 0 ) {
                node.setIsActive(true);
            } else {
                node.setIsActive(false);
            }
            nodeRepository.save(node);
        }

        for (Integer i = 10; i < 25; i++) {
            Node node = new Node();
            node.setCodeNode("No-" + i);
            node.setStation(stationList.get(1));
            if ( i % 2 == 0 ) {
                node.setIsActive(true);
            } else {
                node.setIsActive(false);
            }
            nodeRepository.save(node);
        }

        return  true;
    }
}

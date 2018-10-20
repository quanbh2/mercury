package solar.planet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solar.planet.common.message.Text;
import solar.planet.entity.Station;
import solar.planet.repository.StationRepository;
import solar.planet.service.StationService;

import javax.transaction.Transactional;

@Service
@Transactional
public class StationImpl implements StationService {

    @Autowired
    StationRepository stationRepository;


    @Override
    public Station save(Station station) {

        return stationRepository.save(station);
    }

    @Override
    public Station findById(Integer id) {

        return stationRepository.findById(id).orElseThrow(() -> new NullPointerException(Text.NOT_FOUND));
    }
}

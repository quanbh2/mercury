package solar.planet.service;

import solar.planet.entity.Station;

public interface StationService {

    Station save(Station station);

    Station findById(Integer id);
}

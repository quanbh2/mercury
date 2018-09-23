package solar.planet.service;

import solar.planet.entity.Resource;

public interface ResourceService {

    Resource findByName(String name);
}

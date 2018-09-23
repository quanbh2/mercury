package solar.planet.service;

import solar.planet.entity.Role;

public interface RoleService {

    Role findByName(String name);
}

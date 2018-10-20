package solar.planet.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import solar.planet.entity.Role;

public interface RoleService {

    Role findByName(String name);

    Role save(Role role);

    Role findById(Integer id);

    Page<Role> findAll(Pageable pageable);
}

package solar.planet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solar.planet.entity.Role;
import solar.planet.repository.RoleRepository;
import solar.planet.service.RoleService;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoleImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByName(String name) {

        return roleRepository.findByName(name);
    }
}

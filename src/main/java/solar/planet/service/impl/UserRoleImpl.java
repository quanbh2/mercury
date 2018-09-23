package solar.planet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solar.planet.entity.UserRole;
import solar.planet.repository.UserRoleRepository;
import solar.planet.service.UserRoleService;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserRoleImpl implements UserRoleService {

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserRole save(UserRole userRole) {

        return userRoleRepository.save(userRole);
    }
}

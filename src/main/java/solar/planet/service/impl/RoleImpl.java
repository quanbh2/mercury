package solar.planet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import solar.planet.common.message.Text;
import solar.planet.entity.Role;
import solar.planet.exception.ResourceNotFoundEx;
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

    @Override
    public Role save(Role role) {

        return roleRepository.save(role);
    }

    @Override
    public Role findById(Integer id) {

        return roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundEx(Text.ROLE + Text.NOT_FOUND));
    }

    @Override
    public Page<Role> findAll(Pageable pageable) {

        return roleRepository.findAll(pageable);
    }
}

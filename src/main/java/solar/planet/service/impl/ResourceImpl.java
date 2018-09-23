package solar.planet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solar.planet.entity.Resource;
import solar.planet.repository.ResourceRepository;
import solar.planet.service.ResourceService;

import javax.transaction.Transactional;

@Service
@Transactional
public class ResourceImpl implements ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public Resource findByName(String name) {

        return resourceRepository.findByName(name);
    }
}

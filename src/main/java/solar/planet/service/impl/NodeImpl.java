package solar.planet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import solar.planet.common.message.Text;
import solar.planet.entity.Node;
import solar.planet.exception.ResourceNotFoundEx;
import solar.planet.repository.NodeRepository;
import solar.planet.service.NodeService;

@Service
public class NodeImpl implements NodeService {

    @Autowired
    NodeRepository nodeRepository;

    @Override
    public Node findByName(String name) {

        return null;
    }

    @Override
    public Node save(Node node) {

        return nodeRepository.save(node);
    }

    @Override
    public Node findById(Integer id) {

        return nodeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundEx(Text.NOT_FOUND));
    }

    @Override
    public Page<Node> findAll(Pageable pageable) {

        return nodeRepository.findAll(pageable);
    }
}

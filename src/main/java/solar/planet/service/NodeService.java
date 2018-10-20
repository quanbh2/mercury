package solar.planet.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import solar.planet.entity.Node;

public interface NodeService {

    Node findByName(String name);

    Node save(Node node);

    Node findById(Integer id);

    Page<Node> findAll(Pageable pageable);
}

package solar.planet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import solar.planet.entity.Node;
import solar.planet.entity.Station;

import java.util.List;

@Repository
public interface NodeRepository extends JpaRepository<Node, Integer>, JpaSpecificationExecutor<Node>,
        PagingAndSortingRepository<Node, Integer> {

   // List<Node> findByStationOrderByCreatedAtAsc(Station station);
}

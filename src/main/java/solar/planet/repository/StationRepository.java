package solar.planet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import solar.planet.entity.Station;

@Repository
public interface StationRepository extends JpaRepository<Station, Integer>, JpaSpecificationExecutor<Station>,
        PagingAndSortingRepository<Station, Integer> {

}

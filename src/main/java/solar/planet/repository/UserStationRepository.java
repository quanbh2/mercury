package solar.planet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import solar.planet.entity.UserStation;

@Repository
public interface UserStationRepository extends JpaRepository<UserStation, Integer>, JpaSpecificationExecutor<UserStation>,
        PagingAndSortingRepository<UserStation, Integer> {
}

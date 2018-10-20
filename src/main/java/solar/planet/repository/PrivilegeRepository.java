package solar.planet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import solar.planet.entity.Privilege;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Integer>, JpaSpecificationExecutor<Privilege>,
        PagingAndSortingRepository<Privilege, Integer> {

    @Query("SELECT r from Privilege r where r.name= :name")
    Privilege findByName(@Param("name") String name);
}

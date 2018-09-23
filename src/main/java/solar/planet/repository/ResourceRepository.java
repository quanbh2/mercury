package solar.planet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import solar.planet.entity.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Integer>, JpaSpecificationExecutor<Resource>,
        PagingAndSortingRepository<Resource, Integer> {

    @Query("SELECT r from Resource r where r.name= :name")
    Resource findByName(@Param("name") String name);
}

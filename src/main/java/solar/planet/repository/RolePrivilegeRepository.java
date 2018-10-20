package solar.planet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import solar.planet.entity.Privilege;
import solar.planet.entity.Role;
import solar.planet.entity.RolePrivilege;

@Repository
public interface RolePrivilegeRepository extends JpaRepository<RolePrivilege, Integer>,
        JpaSpecificationExecutor<RolePrivilege>, PagingAndSortingRepository<RolePrivilege, Integer> {

    @Query("SELECT r from RolePrivilege r where r.privilege= :privilege and r.role= :role ")
    RolePrivilege findByRoleAndPrivilege(@Param("privilege") Privilege privilege, @Param("role") Role role);
}

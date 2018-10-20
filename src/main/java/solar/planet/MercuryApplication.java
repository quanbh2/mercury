package solar.planet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import solar.planet.entity.*;
import solar.planet.enumeration.PrivilegeEnum;
import solar.planet.enumeration.RoleEnum;
import solar.planet.repository.*;

import java.util.EnumSet;

@SpringBootApplication
@Slf4j
public class MercuryApplication implements CommandLineRunner {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ResourceRepository resourceRepository;

    @Autowired
    PrivilegeRepository privilegeRepository;

    @Autowired
    RolePrivilegeRepository rolePrivilegeRepository;

    @Autowired
    UserRepository userRepository ;

    public static void main(String[] args) {
        SpringApplication.run(MercuryApplication.class, args);
    }

    @Override
    public void run(String... args) {

        if (initData()) {
            log.info(" Init Data Success");
        }

    }

    private boolean initData() {

        // add Role
        EnumSet.allOf(RoleEnum.class).forEach(roleEnum -> {
            Role role = roleRepository.findByName(roleEnum.getName());
            if (role == null) {
                Role roleNew = new Role();
                roleNew.setName(roleEnum.getName());
                roleRepository.save(roleNew);
            }
        });

        // add Privilege
        EnumSet.allOf(PrivilegeEnum.class).forEach(privilegeEnum -> {
            Privilege privilege = privilegeRepository.findByName(privilegeEnum.getName());
            if (privilege == null) {
                Privilege newPrivilege = new Privilege();
                newPrivilege.setName(privilegeEnum.getName());
                privilegeRepository.save(newPrivilege);
            }
        });

        // add Resource
        Resource resource = resourceRepository.findByName("SENSOR");
        if ( resource == null ) {
            Resource resourceSensor = new Resource();
            resourceSensor.setName("SENSOR");
            resourceRepository.save(resourceSensor);
        }

        // add Role_Privilege
        Role roleGuest = roleRepository.findByName("GUEST");
        Privilege privilegeView = privilegeRepository.findByName("VIEW");
        RolePrivilege rolePrivilege = rolePrivilegeRepository.findByRoleAndPrivilege(privilegeView,roleGuest);
        if ( rolePrivilege == null ) {
            RolePrivilege newRolePrivilege = new RolePrivilege();
            newRolePrivilege.setRole(roleGuest);
            newRolePrivilege.setPrivilege(privilegeView);
            rolePrivilegeRepository.save(newRolePrivilege);
        }

        return true;
    }

}

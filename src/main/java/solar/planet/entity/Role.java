package solar.planet.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "roles")
@Where(clause = "soft_delete=0")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(unique = true)
    private String name;

    @Transient
    List<Privilege> privileges;

    @OneToMany(mappedBy = "role")
    @JsonManagedReference
    private List<RolePrivilege> rolePrivileges;

    private Boolean softDelete = false;

    public String toString(){

        return this.name+" | "+this.id;
    }

}

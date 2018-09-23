package solar.planet.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
@Where(clause = "soft_delete=0")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String picture;

    private String userName;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phone;

    @Column(columnDefinition = "TEXT")
    private String info;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT+07:00")
    private Date createdAt;

    private Boolean softDelete = false;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<UserRole> userRoles = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<UserStation> userStations = new ArrayList<>();
}

package solar.planet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "thresholds")
@Where(clause = "soft_delete = 0")
public class Threshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Float aboveTemp;
    private Float belowTemp;

    private Float abovePh;
    private Float belowPh;

    private Float aboveOxy;
    private Float belowOxy;

    private Float aboveSali;
    private Float belowSali;

    private Float aboveSulfi;
    private Float belowSulfi;

    private Boolean softDelete = false;
}

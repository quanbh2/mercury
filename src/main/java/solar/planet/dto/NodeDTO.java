package solar.planet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import solar.planet.entity.Node;
import solar.planet.entity.Station;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NodeDTO {

    private Integer id;

    private String codeNode;

    private Station station;

    private Date createdAt;

    private Boolean isActive;

    private Boolean softDelete;

    private Integer newRecordNumber;

    private Date lastRecordTime;

    public NodeDTO convertDTO(Integer newRecordNumber, Date lastRecordTime, Node node) {

//        this.id = node.getId();
//        this.codeNode = node.getCodeNode();
//        this.station = node.getStation();
//        this.createdAt = node.getCreatedAt();
//        this.isActive = node.getIsActive();
//        this.softDelete = node.getSoftDelete();

        this.newRecordNumber = newRecordNumber;
        this.lastRecordTime = lastRecordTime;

        BeanUtils.copyProperties(node,this);

        return this;
    }
}

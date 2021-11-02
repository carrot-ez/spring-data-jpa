package kr.carrot.springdatajpa.entity.id;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode
@Data
@Embeddable
public class EmployeeId implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long empId;

    private Long depId;

    public EmployeeId() {
    }

    public EmployeeId(Long empId, Long depId) {
        this.empId = empId;
        this.depId = depId;
    }
}

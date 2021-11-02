package kr.carrot.springdatajpa.entity.id;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode
@Data
//@Embeddable // using @EmbeddedId
public class EmployeeId implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long empId;

    private Long department;

    public EmployeeId() {
    }

    public EmployeeId(Long empId, Long department) {
        this.empId = empId;
        this.department = department;
    }
}

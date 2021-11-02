package kr.carrot.springdatajpa.entity.id;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
@Data
public class EmployeeId implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long empId;

    private Long depId;
}

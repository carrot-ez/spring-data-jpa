package kr.carrot.springdatajpa.entity;

import kr.carrot.springdatajpa.entity.id.EmployeeId;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@IdClass(EmployeeId.class)
public class EmployeeEntity {

    @Id
    @Column(name = "emp_id")
    private Long empId;

    @Id
    @Column(name = "dep_id")
    private Long depId;

    private String name;
    private Integer age;

    @Builder
    public EmployeeEntity(Long empId, Long depId, String name, Integer age) {
        this.empId = empId;
        this.depId = depId;
        this.name = name;
        this.age = age;
    }
}

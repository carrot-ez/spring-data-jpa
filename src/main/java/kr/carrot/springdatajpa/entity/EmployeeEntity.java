package kr.carrot.springdatajpa.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmployeeEntity {

    @Id @GeneratedValue
    @Column(name = "emp_id")
    private Long id;

    private String name;
    private Integer age;

    @Builder
    public EmployeeEntity(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}

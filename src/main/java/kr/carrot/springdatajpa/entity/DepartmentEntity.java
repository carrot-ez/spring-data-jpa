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
public class DepartmentEntity {

    @Id @GeneratedValue
    @Column(name = "dep_id")
    private Long id;

    private String name;

    @Builder
    public DepartmentEntity(String name) {
        this.name = name;
    }
}

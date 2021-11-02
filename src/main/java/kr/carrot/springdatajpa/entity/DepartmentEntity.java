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

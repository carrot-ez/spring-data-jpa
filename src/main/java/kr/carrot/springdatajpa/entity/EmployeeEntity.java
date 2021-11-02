package kr.carrot.springdatajpa.entity;

import kr.carrot.springdatajpa.entity.id.EmployeeId;
import lombok.*;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dep_id", updatable = false, insertable = false)
    private DepartmentEntity depId;

    private String name;
    private Integer age;


    @Builder
    public EmployeeEntity(Long empId, String name, Integer age) {
        this.empId = empId;
        this.name = name;
        this.age = age;
    }

    public void assignDepartment(DepartmentEntity departmentEntity) {
        this.depId = departmentEntity;
        departmentEntity.getEmployeeEntityList().add(this);
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "empId=" + empId +
                ", depId=" + depId.getId() +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

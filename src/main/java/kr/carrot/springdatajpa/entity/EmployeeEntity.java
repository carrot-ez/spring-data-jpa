package kr.carrot.springdatajpa.entity;

import kr.carrot.springdatajpa.entity.id.EmployeeId;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@IdClass(EmployeeId.class) // using @IdClass
public class EmployeeEntity {

    // using @IdClass
//    @Id
//    @Column(name = "emp_id")
//    private Long empId;
//
//    @Id
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "dep_id", updatable = false, insertable = false)
//    private DepartmentEntity depId;

    // using @EmbeddedId
    @EmbeddedId
    private EmployeeId empId;

    private String name;
    private Integer age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dep_id", updatable = false, insertable = false)
    @MapsId("depId")
    private DepartmentEntity depId;


    // using @IdClass
//    @Builder
//    public EmployeeEntity(Long empId, String name, Integer age) {
//        this.empId = empId;
//        this.name = name;
//        this.age = age;
//    }

    // using @EmbeddedId


//    @Builder
//    public EmployeeEntity(Long empId, Long depId, String name, Integer age) {
//        this.empId = new EmployeeId(empId, depId);
//        this.name = name;
//        this.age = age;
//    }


    @Builder
    public EmployeeEntity(EmployeeId empId, String name, Integer age) {
        this.empId = empId;
        this.name = name;
        this.age = age;
    }

//    public void assignDepartment(DepartmentEntity departmentEntity) {
//        this.depId = departmentEntity;
//        departmentEntity.getEmployeeEntityList().add(this);
//    }

    public void assignDepartment(DepartmentEntity departmentEntity) {
        this.depId = departmentEntity;
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

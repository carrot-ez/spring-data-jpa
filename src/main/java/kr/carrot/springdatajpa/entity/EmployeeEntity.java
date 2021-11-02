package kr.carrot.springdatajpa.entity;

import kr.carrot.springdatajpa.entity.id.EmployeeId;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@IdClass(EmployeeId.class) // using @IdClass
public class EmployeeEntity {

    /*
    @EmbeddedId보다 @IdClass가 코드 가독성이 더 좋음.
    pk <-> fk 매핑이 알아보기 쉽게 되는듯. 개인차.
    물론 기본적으로 @Id @GenerateValue 를 사용하여 굳이 복합키를 안 만드는 것이 가장 좋을 것 같음.
     */
    // using @EmbeddedId
//    @EmbeddedId
//    private EmployeeId empId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "dep_id", updatable = false, insertable = false)
//    @MapsId("depId")
//    private DepartmentEntity depId;


    // using @IdClass
    @Id
    @Column(name = "emp_id")
    private Long empId;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dep_id", updatable = false, insertable = false)
    private DepartmentEntity department;

    private String name;
    private Integer age;

    @Builder
    public EmployeeEntity(Long empId, String name, Integer age) {
        this.empId = empId;
        this.name = name;
        this.age = age;
    }

    public void assignDepartment(DepartmentEntity departmentEntity) {
        this.department = departmentEntity;
        departmentEntity.getEmployeeEntityList().add(this);
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "empId=" + empId +
                ", depId=" + department.getId() +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

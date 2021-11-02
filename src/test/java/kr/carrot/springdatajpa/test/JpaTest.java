package kr.carrot.springdatajpa.test;

import kr.carrot.springdatajpa.entity.DepartmentEntity;
import kr.carrot.springdatajpa.entity.EmployeeEntity;
import kr.carrot.springdatajpa.entity.id.EmployeeId;
import kr.carrot.springdatajpa.repository.DepartmentRepository;
import kr.carrot.springdatajpa.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
public class JpaTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EntityManager em;

    @BeforeEach
    @Transactional
    public void init() {
        DepartmentEntity departmentEntity = DepartmentEntity.builder()
                .name("part1")
                .build();

        EmployeeId employeeId = new EmployeeId(10L, 10L);
        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .empId(employeeId)
                .name("carrot")
                .age(26)
                .build();
//        employeeEntity.assignDepartment(departmentEntity);

        departmentEntity.addEmployee(employeeEntity);

        departmentRepository.save(departmentEntity);
        em.flush();
        em.clear();
    }

//    @Test
//    @Transactional
//    public void test_1() {
//        EmployeeEntity employeeEntity = EmployeeEntity.builder()
//                .empId(10L)
//                .name("carrot")
//                .age(26)
//                .build();
//        employeeRepository.save(employeeEntity);
//
//        DepartmentEntity departmentEntity = DepartmentEntity.builder()
//                .name("part1")
//                .build();
//        departmentRepository.save(departmentEntity);
//
//        em.flush();
//        em.clear();
//    }
//
//    @Test
//    @Transactional
//    public void test_2() {
//        DepartmentEntity departmentEntity = DepartmentEntity.builder()
//                .name("part1")
//                .build();
//
//        EmployeeEntity employeeEntity = EmployeeEntity.builder()
//                .empId(10L)
//                .name("carrot")
//                .age(26)
//                .build();
//        employeeEntity.assignDepartment(departmentEntity);
//
//
//        departmentRepository.save(departmentEntity);
//        em.flush();
//        em.clear();
//
//        System.out.println(employeeEntity);
//    }

    @Test
    @Transactional(readOnly = true)
    public void test_3() {
        EmployeeId employeeId = new EmployeeId();
        employeeId.setEmpId(10L);
        employeeId.setDepId(1L);

        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();

        System.out.println("employeeEntity = " + employeeEntity);
    }
}

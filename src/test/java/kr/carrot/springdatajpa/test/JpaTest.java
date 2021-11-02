package kr.carrot.springdatajpa.test;

import kr.carrot.springdatajpa.entity.DepartmentEntity;
import kr.carrot.springdatajpa.entity.EmployeeEntity;
import kr.carrot.springdatajpa.repository.DepartmentRepository;
import kr.carrot.springdatajpa.repository.EmployeeRepository;
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

    @Test
    @Transactional
    public void test_1() {
        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .name("carrot")
                .age(26)
                .build();
        employeeRepository.save(employeeEntity);

        DepartmentEntity departmentEntity = DepartmentEntity.builder()
                .name("part1")
                .build();
        departmentRepository.save(departmentEntity);

        em.flush();
    }
}

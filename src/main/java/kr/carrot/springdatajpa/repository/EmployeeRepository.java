package kr.carrot.springdatajpa.repository;

import kr.carrot.springdatajpa.entity.EmployeeEntity;
import kr.carrot.springdatajpa.entity.id.EmployeeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, EmployeeId> {
}

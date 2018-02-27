package com.mediac.app.repository;

import com.mediac.app.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

// JpaRepository<T,ID> 에서 T는 Entity의 클래스, ID는 PK의 데이터타입이다.
@PreAuthorize("hasRole('ROLE_MANAGER')")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Override
    @PreAuthorize("#employee?.manager == null or #employee?.manager?.name == authentication?.name")
    Employee save(@Param("employee") Employee employee); //@

    @Override
    @PreAuthorize("@employeeRepository.findOne(#id)?.manager?.name == authentication?.name")
    void delete(@Param("id") Long id);

    @Override
    @PreAuthorize("#employee?.manager?.name == authentication?.name")
    void delete(@Param("employee") Employee employee);


}

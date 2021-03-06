package com.thrinod.myvmtest.dao;

import com.thrinod.myvmtest.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}

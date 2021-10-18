package com.test.documents.dao;

import com.test.documents.model.DocType;
import com.test.documents.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CrudEmployeeRepo extends JpaRepository<Employee, Integer> {
    @Override
    Optional<Employee> findById(Integer id);

    @Override
    List<Employee> findAll();
}

package com.test.documents.dao;

import com.test.documents.model.DocUnit;
import com.test.documents.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepoImpl implements EmployeeRepo {

    private final CrudEmployeeRepo repository;

    public EmployeeRepoImpl(CrudEmployeeRepo repository) {
        this.repository = repository;
    }

    @Override
    public Employee get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }
}

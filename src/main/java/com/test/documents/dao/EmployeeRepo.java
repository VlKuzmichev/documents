package com.test.documents.dao;

import com.test.documents.model.DocType;
import com.test.documents.model.Employee;

import java.util.List;

public interface EmployeeRepo {
    // null if not found
    Employee get(int id);

    public List<Employee> getAll();
}

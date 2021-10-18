package com.test.documents.dao;

import com.test.documents.model.DocType;
import com.test.documents.model.Employee;

import java.util.List;

public interface DocTypeRepo {

    // null if not found
    DocType get(int id);

    public List<DocType> getAll();

}

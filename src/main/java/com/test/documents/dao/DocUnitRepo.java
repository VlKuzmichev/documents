package com.test.documents.dao;

import com.test.documents.model.DocUnit;

import java.util.List;

public interface DocUnitRepo {

    // null if not found
    DocUnit get(int id);

    public List<DocUnit> getAll();

}

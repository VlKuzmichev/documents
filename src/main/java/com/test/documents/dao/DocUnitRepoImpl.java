package com.test.documents.dao;

import com.test.documents.model.DocType;
import com.test.documents.model.DocUnit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DocUnitRepoImpl implements DocUnitRepo{
    private final CrudDocUnitRepo repository;

    public DocUnitRepoImpl(CrudDocUnitRepo repository) {
        this.repository = repository;
    }

    @Override
    public DocUnit get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<DocUnit> getAll() {
        return repository.findAll();
    }
}

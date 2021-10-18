package com.test.documents.dao;

import com.test.documents.model.DocType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DocTypeRepoImpl implements DocTypeRepo{
    private final CrudDocTypeRepo repository;

    public DocTypeRepoImpl(CrudDocTypeRepo repository) {
        this.repository = repository;
    }

    @Override
    public DocType get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<DocType> getAll() {
        return repository.findAll();
    }
}

package com.test.documents.dao;

import com.test.documents.model.Document;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DocumentRepoImpl implements DocumentRepo{
    private final CrudDocumentRepo repository;

    public DocumentRepoImpl(CrudDocumentRepo repository) {
        this.repository = repository;
    }

    @Override
    public Document save(Document document) {
        return repository.save(document);
    }
    @Override
    public Document get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Document> getAll() {
        return repository.findAll();
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }
}

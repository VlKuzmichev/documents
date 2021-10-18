package com.test.documents.dao;

import com.test.documents.model.Document;

import java.util.List;

public interface DocumentRepo {

    Document save(Document document);

    // null if not found
    Document get(int id);

    public List<Document> getAll();
    // false if not found
    boolean delete(int id);


}

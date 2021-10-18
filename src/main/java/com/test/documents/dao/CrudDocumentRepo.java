package com.test.documents.dao;

import com.test.documents.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface CrudDocumentRepo extends JpaRepository<Document, Integer> {
    @Override
    @Transactional
    Document save(Document document);

    @Override
    Optional<Document> findById(Integer id);

    @Override
    List<Document> findAll();

    @Transactional
    @Modifying
    @Query("DELETE FROM Document a WHERE a.id=:id")
    int delete(@Param("id") int id);
}

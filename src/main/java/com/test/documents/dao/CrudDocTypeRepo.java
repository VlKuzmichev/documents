package com.test.documents.dao;

import com.test.documents.model.DocType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CrudDocTypeRepo extends JpaRepository<DocType, Integer> {
    @Override
    Optional<DocType> findById(Integer id);

    @Override
    List<DocType> findAll();

}

package com.test.documents.dao;

import com.test.documents.model.DocType;
import com.test.documents.model.DocUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CrudDocUnitRepo  extends JpaRepository<DocUnit, Integer> {
    @Override
    Optional<DocUnit> findById(Integer id);

    @Override
    List<DocUnit> findAll();

}

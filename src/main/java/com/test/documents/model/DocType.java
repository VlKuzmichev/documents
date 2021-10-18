package com.test.documents.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doc_types", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"},
        name = "doc_types_unique_name_idx")})
public class DocType extends AbstractBaseEntity{
    @Column(name = "name", nullable = false)
    protected String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Document> Documents;

    public DocType() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Document> getDocuments() {
        return Documents;
    }

    public void setDocuments(List<Document> documents) {
        Documents = documents;
    }
}

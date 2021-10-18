package com.test.documents.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employees", uniqueConstraints = {@UniqueConstraint(columnNames = {"org_id"},
        name = "users_unique_org_id_idx")})
public class Employee extends AbstractBaseEntity{
    @Column(name = "org_id", nullable = false)
    protected Integer org_id;

    @Column(name = "full_name", nullable = false)
    protected String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Document> Documents;

    public Employee() {
    }

    public Integer getOrg_id() {
        return org_id;
    }

    public void setOrg_id(Integer org_id) {
        this.org_id = org_id;
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

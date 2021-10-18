package com.test.documents.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "units", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"},
        name = "units_unique_name_idx")})
public class Unit extends AbstractBaseEntity {

    @Column(name = "name", nullable = false)
    protected String name;

    //    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "units")
//    private List<Service> services;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "unit")
    private List<DocUnit> docUnits;

    public Unit() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

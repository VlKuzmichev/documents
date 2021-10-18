package com.test.documents.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "services", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"},
        name = "services_unique_name_idx")})
public class Service extends AbstractBaseEntity{
    @Column(name = "name", nullable = false)
    protected String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "service")
    private List<DocUnit> docUnits;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "doc_units", joinColumns = {@JoinColumn(name = "unit_id")},
//            inverseJoinColumns = {@JoinColumn(name = "service_id")})
//    private List<Unit> units;

    public Service() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.test.documents.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doc_units", uniqueConstraints = {@UniqueConstraint(columnNames = {"service_id", "unit_id"},
        name = "doc_units_unique_service_id_unit_id_idx")})
public class DocUnit extends AbstractBaseEntity{

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "unit_id", nullable = false)
    private Unit unit;

    public DocUnit() {
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}

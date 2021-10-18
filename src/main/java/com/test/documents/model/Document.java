package com.test.documents.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;

@Entity
@Table(name = "documents")
public class Document extends AbstractBaseEntity{
    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "value")
    private String value;

    @Column(name = "sum")
    private Integer sum;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doc_type_id", nullable = false)
    private DocType docType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doc_unit_id", nullable = false)
    private DocUnit docUnit;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    public Document() {
    }

    public Document(Integer id, LocalDateTime dateTime, String value, Integer sum, DocType docType, DocUnit docUnit, Employee employee) {
        super(id);
        this.dateTime = dateTime;
        this.value = value;
        this.sum = sum;
        this.docType = docType;
        this.docUnit = docUnit;
        this.employee = employee;
    }
//    public Answer(Integer id, String name, Boolean truth, Question question) {
//        super(id, name);
//        this.truth = truth;
//        this.question = question;
//    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }

    public DocUnit getDocUnit() {
        return docUnit;
    }

    public void setDocUnit(DocUnit docUnit) {
        this.docUnit = docUnit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

package org.example.jpa.company.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "titles")
@IdClass(TitleId.class)
public class Title {

    @Id
    @JoinColumn(name = "emp_no")
    @ManyToOne
    private Employee employee;

    @Id
    @Column(length = 50, nullable = false)
    private String title;

    @Id
    @Column(name = "from_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date from;

    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date to;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

}

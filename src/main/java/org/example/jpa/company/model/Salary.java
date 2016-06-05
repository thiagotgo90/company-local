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
@Table(name = "salaries")
@IdClass(SalaryId.class)
public class Salary {

    @Id
    @JoinColumn(name = "emp_no")
    @ManyToOne
    private Employee employee;

    @Id
    @Column(name = "from_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date from;

    @Column(length = 11, nullable = false)
    private int salary;

    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date to;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

}

package org.example.jpa.company.model.alocation;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.MapsId;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.example.jpa.company.model.Department;
import org.example.jpa.company.model.Employee;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Alocation implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -5736664256450840440L;

    @EmbeddedId
    private AlocationId id;

    @MapsId("department")
    @JoinColumn(name = "dept_no", columnDefinition = "CHAR(4)")
    @ManyToOne
    private Department department;

    @MapsId("employee")
    @JoinColumn(name = "emp_no")
    @ManyToOne
    private Employee employee;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Column(name = "from_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date from;

    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date to;

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

    public AlocationId getId() {
        return id;
    }

    public void setId(AlocationId id) {
        this.id = id;
    }

}

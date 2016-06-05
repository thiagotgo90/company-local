package org.example.jpa.company.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "emp_no")
    private int id;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birth;

    @Column(name = "first_name", length=14)
    private String firstName;

    @Column(name = "last_name", length=16)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition="ENUM('M','F')")
    private Gender gender;

    @Column(name = "hire_date")
    @Temporal(TemporalType.DATE)
    private Date hire;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birthDate) {
        this.birth = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getHire() {
        return hire;
    }

    public void setHire(Date hireDate) {
        this.hire = hireDate;
    }

}

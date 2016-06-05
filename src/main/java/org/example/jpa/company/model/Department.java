package org.example.jpa.company.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "departments", uniqueConstraints = @UniqueConstraint(columnNames = "dept_name"))
public class Department {

    @Id
    @Column(name = "dept_no", columnDefinition="CHAR(4)")
    private char id;

    @Column(name = "dept_name", length = 40, nullable = false)
    private String name;

    public char getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

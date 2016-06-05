package org.example.jpa.company.model.alocation;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AlocationId implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private char department;

    private int employee;

    public char getDepartment() {
        return department;
    }

    public void setDepartment(char department) {
        this.department = department;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + department;
        result = prime * result + employee;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AlocationId other = (AlocationId) obj;
        if (department != other.department)
            return false;
        if (employee != other.employee)
            return false;
        return true;
    }

}

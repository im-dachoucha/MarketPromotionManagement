package com.example.marketpromotionmanagement.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Department {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "department")
    private Collection<Departmentmanager> departmentmanagersById;
    @OneToMany(mappedBy = "department")
    private Collection<Subdepartment> subdepartmentsById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Collection<Departmentmanager> getDepartmentmanagersById() {
        return departmentmanagersById;
    }

    public void setDepartmentmanagersById(Collection<Departmentmanager> departmentmanagersById) {
        this.departmentmanagersById = departmentmanagersById;
    }

    public Collection<Subdepartment> getSubdepartmentsById() {
        return subdepartmentsById;
    }

    public void setSubdepartmentsById(Collection<Subdepartment> subdepartmentsById) {
        this.subdepartmentsById = subdepartmentsById;
    }
}

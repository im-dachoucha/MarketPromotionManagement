package com.example.marketpromotionmanagement.entities;

import jakarta.persistence.*;

@Entity
@NamedQuery(name = "DepartmentManager.getByEmail", query = "select dm from Departmentmanager dm where dm.email like ?1")
public class Departmentmanager {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "departmentid")
    private Integer departmentid;
    @Basic
    @Column(name = "storeid")
    private Integer storeid;
    @ManyToOne
    @JoinColumn(name = "departmentid", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Department department;
    @ManyToOne
    @JoinColumn(name = "storeid", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Store store;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public Integer getStoreid() {
        return storeid;
    }

    public void setStoreid(Integer storeid) {
        this.storeid = storeid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Departmentmanager that = (Departmentmanager) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (departmentid != null ? !departmentid.equals(that.departmentid) : that.departmentid != null) return false;
        if (storeid != null ? !storeid.equals(that.storeid) : that.storeid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (departmentid != null ? departmentid.hashCode() : 0);
        result = 31 * result + (storeid != null ? storeid.hashCode() : 0);
        return result;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department departmentByDepartmentid) {
        this.department = departmentByDepartmentid;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store storeByStoreid) {
        this.store = storeByStoreid;
    }
}

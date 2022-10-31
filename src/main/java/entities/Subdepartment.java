package entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Subdepartment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "departmentid")
    private Integer departmentid;
    @OneToMany(mappedBy = "subdepartmentBySubdepartmentid")
    private Collection<Promotion> promotionsById;
    @ManyToOne
    @JoinColumn(name = "departmentid", referencedColumnName = "id", nullable = false)
    private Department departmentByDepartmentid;

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

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subdepartment that = (Subdepartment) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (departmentid != null ? !departmentid.equals(that.departmentid) : that.departmentid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (departmentid != null ? departmentid.hashCode() : 0);
        return result;
    }

    public Collection<Promotion> getPromotionsById() {
        return promotionsById;
    }

    public void setPromotionsById(Collection<Promotion> promotionsById) {
        this.promotionsById = promotionsById;
    }

    public Department getDepartmentByDepartmentid() {
        return departmentByDepartmentid;
    }

    public void setDepartmentByDepartmentid(Department departmentByDepartmentid) {
        this.departmentByDepartmentid = departmentByDepartmentid;
    }
}

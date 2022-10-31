package entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Store {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "storeByStoreid")
    private Collection<Departmentmanager> departmentmanagersById;
    @OneToMany(mappedBy = "storeByStoreid")
    private Collection<Promotion> promotionsById;
    @OneToMany(mappedBy = "storeByStoreid")
    private Collection<Storeadmin> storeadminsById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Store store = (Store) o;

        if (id != null ? !id.equals(store.id) : store.id != null) return false;
        if (city != null ? !city.equals(store.city) : store.city != null) return false;
        if (phone != null ? !phone.equals(store.phone) : store.phone != null) return false;
        if (email != null ? !email.equals(store.email) : store.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    public Collection<Departmentmanager> getDepartmentmanagersById() {
        return departmentmanagersById;
    }

    public void setDepartmentmanagersById(Collection<Departmentmanager> departmentmanagersById) {
        this.departmentmanagersById = departmentmanagersById;
    }

    public Collection<Promotion> getPromotionsById() {
        return promotionsById;
    }

    public void setPromotionsById(Collection<Promotion> promotionsById) {
        this.promotionsById = promotionsById;
    }

    public Collection<Storeadmin> getStoreadminsById() {
        return storeadminsById;
    }

    public void setStoreadminsById(Collection<Storeadmin> storeadminsById) {
        this.storeadminsById = storeadminsById;
    }
}

package com.example.marketpromotionmanagement.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
public class Promotion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "comment")
    private String comment;
    @Basic
    @Column(name = "state")
    private String state;
    @Basic
    @Column(name = "startdate")
    private Date startdate;
    @Basic
    @Column(name = "enddate")
    private Date enddate;
    @Basic
    @Column(name = "discount")
    private BigDecimal discount;
    @Basic
    @Column(name = "subdepartmentid")
    private Integer subdepartmentid;
    @Basic
    @Column(name = "storeid")
    private Integer storeid;
    @ManyToOne
    @JoinColumn(name = "subdepartmentid", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Subdepartment subdepartment;
    @ManyToOne
    @JoinColumn(name = "storeid", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Store store;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Integer getSubdepartmentid() {
        return subdepartmentid;
    }

    public void setSubdepartmentid(Integer subdepartmentid) {
        this.subdepartmentid = subdepartmentid;
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

        Promotion promotion = (Promotion) o;

        if (id != null ? !id.equals(promotion.id) : promotion.id != null) return false;
        if (description != null ? !description.equals(promotion.description) : promotion.description != null)
            return false;
        if (comment != null ? !comment.equals(promotion.comment) : promotion.comment != null) return false;
        if (state != null ? !state.equals(promotion.state) : promotion.state != null) return false;
        if (startdate != null ? !startdate.equals(promotion.startdate) : promotion.startdate != null) return false;
        if (enddate != null ? !enddate.equals(promotion.enddate) : promotion.enddate != null) return false;
        if (discount != null ? !discount.equals(promotion.discount) : promotion.discount != null) return false;
        if (subdepartmentid != null ? !subdepartmentid.equals(promotion.subdepartmentid) : promotion.subdepartmentid != null)
            return false;
        if (storeid != null ? !storeid.equals(promotion.storeid) : promotion.storeid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (startdate != null ? startdate.hashCode() : 0);
        result = 31 * result + (enddate != null ? enddate.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        result = 31 * result + (subdepartmentid != null ? subdepartmentid.hashCode() : 0);
        result = 31 * result + (storeid != null ? storeid.hashCode() : 0);
        return result;
    }

    public Subdepartment getSubdepartment() {
        return subdepartment;
    }

    public void setSubdepartment(Subdepartment subdepartmentBySubdepartmentid) {
        this.subdepartment = subdepartmentBySubdepartmentid;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store storeByStoreid) {
        this.store = storeByStoreid;
    }
}

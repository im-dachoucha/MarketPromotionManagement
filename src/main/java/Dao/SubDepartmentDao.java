package Dao;

import entities.Subdepartment;

import java.util.List;

public class SubDepartmentDao implements DAO<Subdepartment> {
    @Override
    public Subdepartment get(Integer id) {
        return null;
    }

    @Override
    public List<Subdepartment> getAll() {
        return JPA.Utils.Helper.entityManager().createQuery("select s from Subdepartment s").getResultList();
    }

    @Override
    public void save(Subdepartment subdepartment) {

    }

    @Override
    public void update(Subdepartment subdepartment) {

    }

    @Override
    public void delete(Subdepartment subdepartment) {

    }
}

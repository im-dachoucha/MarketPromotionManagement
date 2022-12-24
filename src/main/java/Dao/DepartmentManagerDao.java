package Dao;

import entities.Departmentmanager;

import java.util.List;

public class DepartmentManagerDao implements DAO<Departmentmanager> {
    @Override
    public Departmentmanager get(Integer id) {
        return JPA.Utils.Helper.entityManager().find(Departmentmanager.class, id);
    }

    @Override
    public List<Departmentmanager> getAll() {
        return null;
    }

    @Override
    public void save(Departmentmanager departmentmanager) {
        JPA.Utils.Helper.executeInsideTransaction(em -> em.persist(departmentmanager));
    }

    @Override
    public void update(Departmentmanager departmentmanager) {
        JPA.Utils.Helper.executeInsideTransaction(em -> em.persist(departmentmanager));
    }

    @Override
    public void delete(Departmentmanager departmentmanager) {
        JPA.Utils.Helper.executeInsideTransaction(em -> em.persist(departmentmanager));
    }
}

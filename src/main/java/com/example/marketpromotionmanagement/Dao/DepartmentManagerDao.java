package com.example.marketpromotionmanagement.Dao;

import com.example.marketpromotionmanagement.Utils.Helper;
import com.example.marketpromotionmanagement.entities.Departmentmanager;

import java.util.List;

public class DepartmentManagerDao implements DAO<Departmentmanager> {
    @Override
    public Departmentmanager get(Integer id) {
        return Helper.entityManager().find(Departmentmanager.class, id);
    }

    @Override
    public List<Departmentmanager> getAll() {
        return null;
    }

    @Override
    public void save(Departmentmanager departmentmanager) {
        Helper.executeInsideTransaction(em -> em.persist(departmentmanager));
    }

    @Override
    public void update(Departmentmanager departmentmanager) {
        Helper.executeInsideTransaction(em -> em.persist(departmentmanager));
    }

    @Override
    public void delete(Departmentmanager departmentmanager) {
        Helper.executeInsideTransaction(em -> em.persist(departmentmanager));
    }
}

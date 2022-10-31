package Dao;

import entities.Admin;

import java.util.List;

public class AdminDao implements DAO<Admin> {
    @Override
    public Admin get(Integer id) {
        return JPA.Utils.Helper.entityManager().find(Admin.class, id);
    }

    @Override
    public List<Admin> getAll() {
        return null;
    }

    @Override
    public void save(Admin admin) {
    }

    @Override
    public void update(Admin admin) {
    }

    @Override
    public void delete(Admin admin) {
    }
}

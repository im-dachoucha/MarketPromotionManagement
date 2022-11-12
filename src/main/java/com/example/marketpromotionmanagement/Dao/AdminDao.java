package com.example.marketpromotionmanagement.Dao;

import com.example.marketpromotionmanagement.Utils.Helper;
import com.example.marketpromotionmanagement.entities.Admin;

import java.util.List;

public class AdminDao implements DAO<Admin> {
    @Override
    public Admin get(Integer id) {
        return Helper.entityManager().find(Admin.class, id);
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

package com.example.marketpromotionmanagement.Dao;

import com.example.marketpromotionmanagement.Utils.Helper;
import com.example.marketpromotionmanagement.entities.Store;

import java.util.List;

public class StoreDao implements DAO<Store>{
    @Override
    public Store get(Integer id) {
        return Helper.entityManager().find(Store.class, id);
    }

    @Override
    public List<Store> getAll() {
        return null;
    }

    @Override
    public void save(Store store) {
        Helper.executeInsideTransaction(em -> em.persist(store));
    }

    @Override
    public void update(Store store) {
        Helper.executeInsideTransaction(em -> em.merge(store));
    }

    @Override
    public void delete(Store store) {
        Helper.executeInsideTransaction(em -> em.remove(store));
    }
}

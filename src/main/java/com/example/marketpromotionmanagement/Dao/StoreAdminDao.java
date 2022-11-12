package com.example.marketpromotionmanagement.Dao;

import com.example.marketpromotionmanagement.Utils.Helper;
import com.example.marketpromotionmanagement.entities.Storeadmin;

import java.util.List;

public class StoreAdminDao implements DAO<Storeadmin>{
    @Override
    public Storeadmin get(Integer id) {
        return Helper.entityManager().find(Storeadmin.class, id);
    }

    @Override
    public List<Storeadmin> getAll() {
        return null;
    }

    @Override
    public void save(Storeadmin storeadmin) {
        Helper.executeInsideTransaction(em -> em.persist(storeadmin));
    }

    @Override
    public void update(Storeadmin storeadmin) {
        Helper.executeInsideTransaction(em -> em.merge(storeadmin));
    }

    @Override
    public void delete(Storeadmin storeadmin) {
        Helper.executeInsideTransaction(em -> em.remove(storeadmin));
    }
}

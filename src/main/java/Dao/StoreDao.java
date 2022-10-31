package Dao;

import entities.Store;

import java.util.List;

public class StoreDao implements DAO<Store>{
    @Override
    public Store get(Integer id) {
        return JPA.Utils.Helper.entityManager().find(Store.class, id);
    }

    @Override
    public List<Store> getAll() {
        return null;
    }

    @Override
    public void save(Store store) {
        JPA.Utils.Helper.executeInsideTransaction(em -> em.persist(store));
    }

    @Override
    public void update(Store store) {
        JPA.Utils.Helper.executeInsideTransaction(em -> em.merge(store));
    }

    @Override
    public void delete(Store store) {
        JPA.Utils.Helper.executeInsideTransaction(em -> em.remove(store));
    }
}

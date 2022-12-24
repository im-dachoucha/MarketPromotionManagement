package Dao;

import entities.Storeadmin;

import java.util.List;

public class StoreAdminDao implements DAO<Storeadmin>{
    @Override
    public Storeadmin get(Integer id) {
        return JPA.Utils.Helper.entityManager().find(Storeadmin.class, id);
    }

    @Override
    public List<Storeadmin> getAll() {
        return null;
    }

    @Override
    public void save(Storeadmin storeadmin) {
        JPA.Utils.Helper.executeInsideTransaction(em -> em.persist(storeadmin));
    }

    @Override
    public void update(Storeadmin storeadmin) {
        JPA.Utils.Helper.executeInsideTransaction(em -> em.merge(storeadmin));
    }

    @Override
    public void delete(Storeadmin storeadmin) {
        JPA.Utils.Helper.executeInsideTransaction(em -> em.remove(storeadmin));
    }
}

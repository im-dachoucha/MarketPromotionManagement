package Dao;

import entities.Promotion;

import java.util.List;

public class PromotionDao implements DAO<Promotion> {
    @Override
    public Promotion get(Integer id) {
        return JPA.Utils.Helper.entityManager().find(Promotion.class, id);
    }

    @Override
    public List<Promotion> getAll() {
        return null;
    }

    @Override
    public void save(Promotion promotion) {
        JPA.Utils.Helper.executeInsideTransaction(em -> em.persist(promotion));
    }

    @Override
    public void update(Promotion promotion) {
        JPA.Utils.Helper.executeInsideTransaction(em -> em.merge(promotion));
    }

    @Override
    public void delete(Promotion promotion) {
        JPA.Utils.Helper.executeInsideTransaction(em -> em.remove(promotion));
    }
}

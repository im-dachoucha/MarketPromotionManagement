package com.example.marketpromotionmanagement.Dao;

import com.example.marketpromotionmanagement.Utils.Helper;
import com.example.marketpromotionmanagement.entities.Promotion;

import java.util.List;

public class PromotionDao implements DAO<Promotion> {
    @Override
    public Promotion get(Integer id) {
        return Helper.entityManager().find(Promotion.class, id);
    }

    @Override
    public List<Promotion> getAll() {
        return null;
    }

    @Override
    public void save(Promotion promotion) {
        Helper.executeInsideTransaction(em -> em.persist(promotion));
    }

    @Override
    public void update(Promotion promotion) {
        Helper.executeInsideTransaction(em -> em.merge(promotion));
    }

    @Override
    public void delete(Promotion promotion) {
        Helper.executeInsideTransaction(em -> em.remove(promotion));
    }
}

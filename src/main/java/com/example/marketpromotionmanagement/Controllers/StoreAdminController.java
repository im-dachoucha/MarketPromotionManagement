package com.example.marketpromotionmanagement.Controllers;

import com.example.marketpromotionmanagement.Dao.StoreAdminDao;
import com.example.marketpromotionmanagement.Security.BCrypt;
import com.example.marketpromotionmanagement.Utils.Helper;
import com.example.marketpromotionmanagement.entities.Storeadmin;
import jakarta.persistence.Query;


public class StoreAdminController {
    public static Storeadmin login(String email, String password) {
        try {
            Query query = Helper.entityManager().createNamedQuery("StoreAdmin.getByEmail").setParameter(1, email);
            Storeadmin storeadmin = (Storeadmin) query.getResultList().get(0);

            if (!BCrypt.checkpw(password, storeadmin.getPassword()))
                return null;
            return storeadmin;
        }catch (Exception e){
            e.getStackTrace();
            return null;
        }
    }

    public static Storeadmin save(String email, String password, Integer storeId){
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));

        Storeadmin storeadmin = new Storeadmin();
        storeadmin.setEmail(email);
        storeadmin.setPassword(hashedPassword);
        storeadmin.setStoreid(storeId);

        StoreAdminDao storeAdminDao = new StoreAdminDao();
        storeAdminDao.save(storeadmin);
        return storeadmin;
    }
}

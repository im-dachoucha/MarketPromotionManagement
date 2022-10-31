package Controllers;

import Dao.StoreAdminDao;
import Security.BCrypt;
import entities.Storeadmin;
import jakarta.persistence.Query;


public class StoreAdminController {
    public static Storeadmin login(String email, String password) {
        try {
            Query query = JPA.Utils.Helper.entityManager().createNamedQuery("StoreAdmin.getByEmail").setParameter(1, email);
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

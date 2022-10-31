package Controllers;

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
}

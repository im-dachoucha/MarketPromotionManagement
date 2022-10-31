package Controllers;

import Dao.AdminDao;
import Security.BCrypt;
import entities.Admin;
import jakarta.persistence.Query;

public class AdminController {

    public static Admin getAdminById(Integer id) {
        AdminDao adminDao = new AdminDao();
        return adminDao.get(id);
    }

    public static Admin login(String email, String password) {
        try {
            AdminDao adminDao = new AdminDao();
            Query query = JPA.Utils.Helper.entityManager().createNamedQuery("Admin.getByEmail").setParameter(1, email);
            Admin admin = (Admin) query.getResultList().get(0);

            if(!BCrypt.checkpw(password, admin.getPassword()))
                return null;

            return admin;
        }catch (Exception e){
            e.getStackTrace();
            return null;
        }
    }
}

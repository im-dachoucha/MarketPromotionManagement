package Controllers;

import Dao.DepartmentManagerDao;
import Dao.StoreDao;
import Security.BCrypt;
import entities.Departmentmanager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentManagerController {
    public static Departmentmanager login(String email, String password) {
        try {
            Query query = JPA.Utils.Helper.entityManager().createNamedQuery("DepartmentManager.getByEmail").setParameter(1, email);
            Departmentmanager departmentmanager = (Departmentmanager) query.getResultList().get(0);

            if (!BCrypt.checkpw(password, departmentmanager.getPassword()))
                return null;
            return departmentmanager;
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    public static Departmentmanager save(String email, String password, Integer departmentId, Integer storeId) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));

        Departmentmanager departmentmanager = new Departmentmanager();

        departmentmanager.setEmail(email);
        departmentmanager.setPassword(hashedPassword);
        departmentmanager.setDepartmentid(departmentId);
        departmentmanager.setStoreid(storeId);

        DepartmentManagerDao departmentManagerDao = new DepartmentManagerDao();
        departmentManagerDao.save(departmentmanager);
        return departmentmanager;
    }

    public static List<Departmentmanager> getStoreDptManagers(Integer storeId) {
        return (List<Departmentmanager>) new StoreDao().get(storeId).getDepartmentmanagers();
    }
}

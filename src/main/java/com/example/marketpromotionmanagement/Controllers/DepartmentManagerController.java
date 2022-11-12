package com.example.marketpromotionmanagement.Controllers;

import com.example.marketpromotionmanagement.Dao.DepartmentManagerDao;
import com.example.marketpromotionmanagement.Dao.StoreDao;
import com.example.marketpromotionmanagement.Security.BCrypt;
import com.example.marketpromotionmanagement.Utils.Helper;
import com.example.marketpromotionmanagement.entities.Departmentmanager;
import jakarta.persistence.Query;

import java.util.List;

public class DepartmentManagerController {
    public static Departmentmanager login(String email, String password) {
        try {
            Query query = Helper.entityManager().createNamedQuery("DepartmentManager.getByEmail").setParameter(1, email);
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

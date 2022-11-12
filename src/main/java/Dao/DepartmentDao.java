package Dao;

import entities.Department;

import java.util.List;

public class DepartmentDao implements DAO<Department> {
    @Override
    public Department get(Integer id) {
        return null;
    }

    @Override
    public List<Department> getAll() {
        return JPA.Utils.Helper.entityManager().createQuery("select d from Department d").getResultList();
    }

    @Override
    public void save(Department department) {

    }

    @Override
    public void update(Department department) {

    }

    @Override
    public void delete(Department department) {

    }
}

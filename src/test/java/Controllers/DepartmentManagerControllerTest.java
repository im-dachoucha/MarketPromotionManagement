package Controllers;

import entities.Departmentmanager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentManagerControllerTest {

    @Test
    public void saveDepartmentManagerTest(){
        Departmentmanager departmentmanager = DepartmentManagerController.save("dpt1.manager@marjane.com", "dptmanager1", 1, 1);

        assertNotNull(departmentmanager);
        assertNotNull(departmentmanager.getId());
    }
}
package Controllers;

import com.example.marketpromotionmanagement.Controllers.DepartmentManagerController;
import com.example.marketpromotionmanagement.entities.Departmentmanager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentManagerControllerTest {
    /*
     * Save method test
     * */
    @Test
    public void saveDepartmentManagerTest(){
        Departmentmanager departmentmanager = DepartmentManagerController.save("dpt1.manager@marjane.com", "dptmanager1", 1, 1);

        assertNotNull(departmentmanager);
        assertNotNull(departmentmanager.getId());
    }

    /*
     * Login method tests
     * */
    @Test
    public void departmentManagerLoginTestWithValidEmailAndPassword(){
        Departmentmanager departmentmanager = DepartmentManagerController.login("dpt1.manager@marjane.com", "dptmanager1");

        assertNotNull(departmentmanager);
        assertNotNull(departmentmanager.getId());
    }
    @Test
    public void departmentManagerLoginTestWithInvalidEmailAndPassword(){
        Departmentmanager departmentmanager = DepartmentManagerController.login("dpt1.manager@marjane.com", "testing");

        assertNull(departmentmanager);
    }
}
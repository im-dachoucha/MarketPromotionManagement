package Controllers;

import com.example.marketpromotionmanagement.Controllers.AdminController;
import com.example.marketpromotionmanagement.entities.Admin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminControllerTest {

    @Test
    public void adminLoginTestWithValidEmailAndPassword(){
        Admin admin = AdminController.login("test@email.com", "test");
        assertNotNull(admin);
    }

    @Test
    public void adminLoginTestWithValidEmailAndInvalidPassword(){
        Admin admin = AdminController.login("test@email.com", "123");
        assertNull(admin);
    }

    @Test
    public void adminLoginTestWithInvalidEmailAndPassword(){
        Admin admin = AdminController.login("mail@email.com", "test");
        assertNull(admin);
    }
}
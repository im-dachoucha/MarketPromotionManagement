package Controllers;

import entities.Storeadmin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreAdminControllerTest {

    @Test
    public void storeAdminLoginTestWithValidEmailAndPassword(){
        Storeadmin storeadmin = StoreAdminController.login("email@email.com", "test");
        assertNotNull(storeadmin);
    }

    @Test
    public void storeAdminLoginTestWithInvalidEmailAndPassword(){
        Storeadmin storeadmin = StoreAdminController.login("test@email.com", "123");
        assertNull(storeadmin);
    }
}
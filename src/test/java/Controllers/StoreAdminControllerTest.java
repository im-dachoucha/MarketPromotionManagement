package Controllers;

import com.example.marketpromotionmanagement.Controllers.StoreAdminController;
import com.example.marketpromotionmanagement.entities.Storeadmin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreAdminControllerTest {

    /*
    * Login method tests
    * */
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

    /*
     * Save method tests
     * */
    @Test
    public void saveStoreAdminTest(){
        Storeadmin storeadmin = StoreAdminController.save("store.admin1@marjane.com", "storeadmin1", 1);

        assertNotNull(storeadmin);
        assertNotNull(storeadmin.getId());
    }
}
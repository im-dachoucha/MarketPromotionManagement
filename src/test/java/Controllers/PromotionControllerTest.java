package Controllers;

import Dao.DepartmentManagerDao;
import entities.Departmentmanager;
import entities.Promotion;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PromotionControllerTest {

    /*
     * Save method tests
     * */
    @Test
    public void savePromotionTestWithInvalidStartDate1(){
        Promotion promotion = PromotionController.save("desc", "2000-12-12", "2022-12-12", BigDecimal.valueOf(.3d), 1, 1);

        assertNull(promotion);
    }
    @Test
    public void savePromotionTestWithInvalidStartDate2(){
        Promotion promotion = PromotionController.save("desc", "2022-12-21", "2022-12-13", BigDecimal.valueOf(.3d), 1, 1);

        assertNull(promotion);
    }
    @Test
    public void savePromotionTestWithInvalidDiscount(){
        Promotion promotion = PromotionController.save("desc", "2022-12-01", "2022-12-15", BigDecimal.valueOf(.6d), 1, 1);

        assertNull(promotion);
    }
    @Test
    public void savePromotionWithValidData(){
        Promotion promotion = PromotionController.save("desc", "2022-12-01", "2022-12-15", BigDecimal.valueOf(.3d), 1, 1);

        assertNotNull(promotion);
        assertNotNull(promotion.getId());
    }

    /*
    * getPromotions tests
    * */
    @Test
    public void getPromotionTest(){
        Departmentmanager dptmentmanager = new DepartmentManagerDao().get(1);
        List<Promotion> promotions = PromotionController.getPromotions(dptmentmanager);
        assert promotions != null;
        System.out.println(promotions.size());
    }
}
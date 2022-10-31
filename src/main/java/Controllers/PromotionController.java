package Controllers;

import Dao.PromotionDao;
import entities.Promotion;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;

public class PromotionController {

    public static Promotion save(String description, String startDate, String endDate, BigDecimal discount, Integer subDptId, Integer storeId){
        Date start_date = Date.valueOf(startDate);
        Date end_date = Date.valueOf(endDate);

        if(start_date.before(Date.from(Instant.now())) || start_date.after(end_date))
            return null;

        if(discount.compareTo(BigDecimal.valueOf(0.5d)) > 0)
            return null;

        Promotion promotion = new Promotion();
        promotion.setStartdate(start_date);
        promotion.setEnddate(end_date);
        promotion.setDescription(description);
        promotion.setState("pending");
        promotion.setDiscount(discount);
        promotion.setSubdepartmentid(subDptId);
        promotion.setStoreid(storeId);

        PromotionDao promotionDao = new PromotionDao();
        promotionDao.save(promotion);
        return promotion;
    }
}

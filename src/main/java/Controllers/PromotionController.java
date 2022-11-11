package Controllers;

import Dao.PromotionDao;
import Dao.StoreDao;
import entities.Departmentmanager;
import entities.Promotion;
import entities.Storeadmin;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PromotionController {

    public static Promotion save(String description, String startDate, String endDate, BigDecimal discount, Integer subDptId, Integer storeId) {
        Date start_date = Date.valueOf(startDate);
        Date end_date = Date.valueOf(endDate);

        if (start_date.before(Date.from(Instant.now())) || start_date.after(end_date))
            return null;

        if (discount.compareTo(BigDecimal.valueOf(0.5d)) > 0)
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

    public static List<Promotion> getPromotionsForDptManager(Departmentmanager dptManager) {

//        Time now = (Time) Time.from(Instant.now());
//
//        if (now.before(Time.valueOf("08:00:00")) || now.after(Time.valueOf("12:00:00")))
//            return null;

        Integer storeId = dptManager.getStoreid();
        Integer dptId = dptManager.getDepartmentid();
        Date currentDate = Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(Date.from(Instant.now())));

        return new StoreDao()
                .get(storeId)
                .getPromotions()
                .stream()
                .filter(promotion -> promotion.getStartdate().compareTo(currentDate) >= 0)
                .filter(promotion -> promotion.getStoreid().equals(storeId) && promotion.getSubdepartment().getDepartmentid().equals(dptId))
                .collect(Collectors.toList());
    }

    public static List<Promotion> getPromotionsForStoreAdmin(Storeadmin storeadmin) {

        Integer storeId = storeadmin.getStoreid();

        return new StoreDao()
                .get(storeId)
                .getPromotions()
                .stream()
                .filter(promotion -> promotion.getStoreid().equals(storeId))
                .sorted(Comparator.comparing(Promotion::getId))
                .collect(Collectors.toList());
    }
    public static boolean deletePromotionById(Integer id){
        try{
            PromotionDao promotionDao = new PromotionDao();
            Promotion promotion = promotionDao.get(id);
            System.out.println(promotion.getId());
            promotionDao.delete(promotion);
            return true;
        }catch(Exception e){
            e.getStackTrace();
            return false;
        }
    }
}

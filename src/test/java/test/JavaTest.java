package test;


import com.qibao.model.StudentMapper;
import com.qibao.model.dao.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * Created by giozola on 2017/6/26.
 */
public class JavaTest {
    @Autowired
    StudentMapper studentMapper;

    @Test
    public void testOut(){
        BigDecimal shouru = new BigDecimal(1000);
        BigDecimal lilv = new BigDecimal(0.05);
        BigDecimal touzi = shouru;
        for (int i= 0;i<120 ;i++){
            BigDecimal benxi = benxi(touzi,lilv);
            if ((i+1)%12 == 0){
                System.out.println("第"+(i+1)/12+"年底的本溪为："+benxi);
                System.out.println("        利息为："+lixi(touzi,lilv));
            }
            touzi = benxi.add(shouru);
        }
    }

    /**
     * 月底的利息收入
     * @param touzi
     * @param lilv
     * @return
     */
    public BigDecimal lixi(BigDecimal touzi,BigDecimal lilv){
        return touzi.multiply(lilv).setScale(2,BigDecimal.ROUND_HALF_UP);
    }
    /**
     * 每月月底的利息+本金
     */
    public BigDecimal benxi(BigDecimal touzi,BigDecimal lilv){
         return  touzi.add(lixi(touzi,lilv));
    }
}

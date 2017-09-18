package test;


import com.core.util.PostHelper;
import com.qibao.model.StudentMapper;
import com.qibao.model.dao.Student;
import com.sun.tools.internal.xjc.reader.xmlschema.BGMBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import redis.clients.jedis.Jedis;
import test.common.BaseContextCase;

import java.math.BigDecimal;

/**
 * Created by giozola on 2017/6/26.
 */
public class JavaTest
//        extends BaseContextCase
{
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void testRedis(){
        ValueOperations<String,String> valueOperations= redisTemplate.opsForValue();
        valueOperations.set("valueOperaations","this is value");
        System.out.println(valueOperations.get("valueOperaations"));
    }

    @Test
    public void caculation(){
        BigDecimal temp = jisuan(120);
        System.out.println("temp:"+temp);
        BigDecimal numerator = new BigDecimal(100000).multiply(new BigDecimal(0.004083)).multiply(temp);
        BigDecimal denominator = temp.subtract(BigDecimal.ONE);
        System.out.printf(numerator.divide(denominator,4,BigDecimal.ROUND_HALF_UP).toString());
    }

    public BigDecimal jisuan(int j){
        BigDecimal b = BigDecimal.ONE;
        BigDecimal x = new BigDecimal(1.004083);
        for (int i = 0;i< j;i++){
            b = b.multiply(x);
        }
        return b;
    }

    @Test
    public void postHelper(){
        String url = "http://120.27.228.102:8180/tps/admin/order/getICBCOrders";
        String param = "";
        String reslult = PostHelper.sendPost(url,param);
        System.out.println(reslult);
    }
}

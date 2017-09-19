package test;


import com.core.util.PostHelper;
import com.modul.tps.OrderService;
import com.qibao.model.StudentMapper;
import com.qibao.model.dao.Student;
import com.sun.tools.internal.xjc.reader.xmlschema.BGMBuilder;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import redis.clients.jedis.Jedis;
import test.common.BaseContextCase;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

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
    public void postHelper() throws IOException {
        List<String> ICBCList = OrderService.getOrder(3);
        System.out.println(ICBCList.toString());
        OrderService.transOrder2LocalService(3,ICBCList);
    }
}

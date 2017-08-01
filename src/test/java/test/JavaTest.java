package test;


import com.qibao.model.StudentMapper;
import com.qibao.model.dao.Student;
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
public class JavaTest extends BaseContextCase{
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
}

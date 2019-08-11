package com.javahly.userservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/4/12
 */
@Component("springSessionDefaultRedisSerializer")
public class CustomSessionDefaultRedisSerializer extends JdkSerializationRedisSerializer {

    private static final Logger LOG = LoggerFactory.getLogger(CustomSessionDefaultRedisSerializer.class);

    public Object deserialize(@Nullable byte[] bytes) {
        Object deserialObj = null;
        try
        {
            deserialObj =  super.deserialize(bytes);
        }
        catch(Exception e)
        {
            //LOG.warn("deserialize session Object error!", e);
        }
        return deserialObj;
    }

}

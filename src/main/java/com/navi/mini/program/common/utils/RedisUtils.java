package com.navi.mini.program.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;


@Component
public class RedisUtils {

    private static Logger logger = Logger.getLogger(RedisUtils.class);

    @Autowired
	private JedisPool jedisPool;

    /**
     * 从jedis连接池中获取获取jedis对象
     */
    public Jedis getJedis() {
        Jedis jedis = null;
        try {
            if (jedisPool != null) {
                jedis = jedisPool.getResource();
            }
        } catch (Exception e) {
            logger.error("获取Jedis对象失败:" + e);
        }
        return jedis;
    }

    /**
     * 返还到连接池
     */
    public void returnResource(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

    /**
     * 将 key 中储存的数字值增一
     */
    public Long incr(String key) {
        Jedis jedis = getJedis();
        try {
            if (jedis == null) {
                return null;
            }
            if (StringUtils.isEmpty(key)) {
                return null;
            }
            return jedis.incr(key);
        } catch (Exception e) {
            logger.error("给key:" + key + "缓存递增一失败:" + e);
            return null;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 是否存在该key的值
     */
    public boolean exists(String key) {
        Jedis jedis = getJedis();
        try {
            if (jedis == null) {
                return Boolean.parseBoolean(null);
            }
            if (StringUtils.isEmpty(key)) {
                return Boolean.parseBoolean(null);
            }
            return jedis.exists(key);
        } catch (Exception e) {
            logger.error("判断缓存中的key:" + key + "是否存在失败:" + e);
            return Boolean.parseBoolean(null);
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 设置key的过期时间
     */
    public void expire(String key, int seconds) {
        Jedis jedis = getJedis();
        try {
            if (jedis == null) {
                return;
            }
            if (seconds <= 0) {
                return;
            }
            if (StringUtils.isEmpty(key)) {
                return;
            }
            jedis.expire(key, seconds);
        } catch (Exception e) {
            logger.error("设置key:" + key + "的过期时间失败:" + e);
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 以秒为单位，返回给定 key 的剩余生存时间
     *
     * @return 当 key 不存在时，返回 -2 。当 key 存在但没有设置剩余生存时间时，返回 -1 。否则，以秒为单位，返回 key
     * 的剩余生存时间。 发生异常 返回 0
     */
    public long ttl(String key) {
        Jedis jedis = getJedis();
        if (StringUtils.isEmpty(key)) {
            return 0L;
        }
        try {
            return jedis.ttl(key);
        } catch (Exception e) {
            logger.error("返回key:" + key + "的剩余时间失败：" + e);
            return 0L;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 移除给定 key 的生存时间，将这个 key 从『易失的』(带生存时间 key )转换成『持久的』(一个不带生存时间、永不过期的 key )
     */
    public void persist(String key) {
        Jedis jedis = getJedis();
        try {
            if (jedis == null) {
                return;
            }
            if (StringUtils.isEmpty(key)) {
                return;
            }
            jedis.persist(key);
        } catch (Exception e) {
            logger.error("将key：" + key + "设置为用不过期时失败:" + e);
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 删除指定的key,也可以传入一个包含key的数组
     *
     * @param keys 一个key 也可以使 string 数组
     * @return 返回删除成功的个数
     */
    public void del(String... keys) {
        Jedis jedis = getJedis();
        try {
            if (jedis == null) {
                return;
            }
            if (keys.length <= 0) {
                return;
            }
            jedis.del(keys);
        } catch (Exception e) {
            logger.error("批量删除keys：" + keys + "失败" + e);
        } finally {
            returnResource(jedis);
        }

    }

    /**
     * 新增key value 成功返回ok
     */
    public String set(String key, String value) {
        Jedis jedis = getJedis();
        try {
            if (jedis == null) {
                return "0";
            }
            if (StringUtils.isBlank(key)) {
                return "0";
            }
            if (StringUtils.isBlank(value)) {
                return "0";
            }
            return jedis.set(key, value);
        } catch (Exception e) {
            logger.error("新增或更新key:" + key + " 失败" + e);
            return null;
        } finally {
            returnResource(jedis);
        }


    }

    /**
     * 新增key,并将 key 的生存时间 (以秒为单位)
     *
     * @param key
     * @param seconds 生存时间 单位：秒
     * @param value
     * @return 设置成功时返回 OK 。当 seconds 参数不合法时，返回一个错误。
     */
    public String set(String key, String value, int seconds) {
        Jedis jedis = getJedis();
        try {
            if (jedis == null) {
                return "0";
            }
            if (StringUtils.isBlank(key)) {
                return "0";
            }
            if (StringUtils.isBlank(key)) {
                return "0";
            }
            if (seconds <= 0) {
                return "0";
            }
            return jedis.setex(key, seconds, value);
        } catch (Exception e) {
            logger.error("新增或更新key:" + key + " 并且设定失效时间时失败" + e);
            return null;
        } finally {
            returnResource(jedis);
        }
    }

    public String set(String key, Object value, int seconds) {
        if (value == null) {
            return "0";
        }
        if (StringUtils.isBlank(key)) {
            return "0";
        }
        if (value == null) {
            return "0";
        }
        if (seconds <= 0) {
            return "0";
        }
        String jsonStr = JSONObject.toJSONString(value);
        return set(key, jsonStr, seconds);
    }

    public String set(String key, Object value) {
        if (value == null) {
            return "0";
        }
        if (value == null) {
            return "0";
        }
        if (StringUtils.isBlank(key)) {
            return "0";
        }
        String jsonStr = JSONObject.toJSONString(value);
        return set(key, jsonStr);
    }

    public String set(String key, int value) {
        if (StringUtils.isBlank(key)) {
            return "0";
        }
        return set(key, String.valueOf(value));
    }

    public String set(String key, long value) {
        if (StringUtils.isBlank(key)) {
            return "0";
        }
        return set(key, String.valueOf(value));
    }

    public String set(String key, float value) {
        if (StringUtils.isBlank(key)) {
            return "0";
        }
        return set(key, String.valueOf(value));
    }

    public String set(String key, double value) {
        if (StringUtils.isBlank(key)) {
            return "0";
        }
        return set(key, String.valueOf(value));
    }

    public String set(String key, int value, int seconds) {
        if (StringUtils.isBlank(key)) {
            return "0";
        }
        if (seconds <= 0) {
            return "0";
        }
        return set(key, String.valueOf(value), seconds);
    }

    public String set(String key, long value, int seconds) {
        if (StringUtils.isBlank(key)) {
            return "0";
        }
        if (seconds <= 0) {
            return "0";
        }
        return set(key, String.valueOf(value), seconds);
    }

    public String set(String key, float value, int seconds) {
        if (StringUtils.isBlank(key)) {
            return "0";
        }
        if (seconds <= 0) {
            return "0";
        }
        return set(key, String.valueOf(value), seconds);
    }

    public String set(String key, double value, int seconds) {
        if (StringUtils.isBlank(key)) {
            return "0";
        }
        if (seconds <= 0) {
            return "0";
        }
        return set(key, String.valueOf(value), seconds);
    }

    /**
     * 通过key获取储存在redis中的value
     */
    public String getString(String key) {
        Jedis jedis = getJedis();
        try {
            if (jedis == null) {
                return null;
            }
            return jedis.get(key);
        } catch (Exception e) {
            logger.error("获取key:" + key + " 的值失败" + e);
            return null;
        } finally {
            returnResource(jedis);
        }
    }

    public <T> T getObj(String key, Class<T> clazz) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        String string = getString(key);
        if (StringUtils.isBlank(string)) {
            return null;
        }
        T t = JSON.parseObject(string, clazz);
        return t;
    }

    public <T> List<T> getList(String key, Class<T> clazz) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        List<T> list = new ArrayList<>();
        String string = getString(key);
        if (StringUtils.isBlank(string)) {
            return null;
        }
        list = JSON.parseArray(string, clazz);
        return list;
    }

    public Float getFloat(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        String value = getString(key);
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return Float.valueOf(value);
    }

    public Double getDouble(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        String value = getString(key);
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return Double.valueOf(value);
    }

    public Long getLong(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        String value = getString(key);
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return Long.valueOf(value);
    }

    public Integer getInt(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        String value = getString(key);
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return Integer.valueOf(value);
    }
}

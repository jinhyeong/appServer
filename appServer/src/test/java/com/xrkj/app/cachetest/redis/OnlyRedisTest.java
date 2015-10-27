/**
 * @Title: OnlyRedisTest.java 
 * @Package com.xrkj.app.cachetest.redis 
 * @Description: 
 * @author ww
 * @date 2015年6月15日 上午10:48:00 
 * @version V1.0  
 */
package com.xrkj.app.cachetest.redis;

import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * <pre>
 * 测试jedis
 * </pre>
 *
 * @author ww
 * @date 2015年6月15日 上午10:48:00
 *
 */
public class OnlyRedisTest {
    private static final Logger logger = LoggerFactory.getLogger(OnlyRedisTest.class);
    private static String HOST = "192.168.1.110";
    private static int PORT = 6379;

    @Test
    public void testDel() {
        Jedis jedis = new Jedis(HOST, PORT);
        String key = "testdel";
        String value = "testdel_value";
        String rt = jedis.set(key, value);
        logger.info("set执行结果：{}", rt);

        String rt_value = jedis.get(key);

        Assert.assertEquals(value, rt_value);

        Long rt_l = jedis.del(key);

        logger.info("del 执行结果：{}", rt_l);


        jedis.close();
    }

    // @Test
    public void testSingleThread() {

        Jedis jedis = new Jedis(HOST, PORT);
        // jedis.auth("redis");//验证密码

        System.out.println(jedis.get("single"));
        jedis.append("single", "test");
        System.out.println(jedis.get("single"));

        System.out.println("列出所有的key：");
        Set<String> keys = jedis.keys("*");// 列出所有的key
        for (String string : keys) {
            System.out.println(string);
        }
        // EXISTS 检查给定key是否存在。
        System.out.println("检查key 是否存在：" + jedis.exists("key"));
        // TTL 返回给定key的剩余生存时间(time to live)(以秒为单位)
        System.out.println("key 剩余TTL：" + jedis.ttl("key"));
        // EXPIRE key seconds 为给定key设置生存时间。当key过期时，它会被自动删除。
        jedis.expire("key", 5);// 5秒过期
        // EXPIREAT
        // EXPIREAT的作用和EXPIRE一样，都用于为key设置生存时间。不同在于EXPIREAT命令接受的时间参数是UNIX时间戳(unix
        // timestamp)。
        System.out.println("key 剩余TTL：" + jedis.ttl("key"));

        // ########################################################
        // 一般SORT用法 最简单的SORT使用方法是SORT key。
        jedis.lpush("sort", "1");
        jedis.lpush("sort", "4");
        jedis.lpush("sort", "6");
        jedis.lpush("sort", "3");
        jedis.lpush("sort", "0");

        List<String> list = jedis.sort("sort");// 默认是升序
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        jedis.hset("hset", "tt1", "hset Value");
        System.out.println(jedis.hget("hset", "tt1"));

        /*
         * ----------------------------------------------------------------------
         * -------------------------------------
         */
        /**
         * STRING 操作
         * 
         * //SET key value将字符串值value关联到key。 redis.set("name", "wangjun1");
         * redis.set("id", "123456"); redis.set("address", "guangzhou");
         * 
         * //SETEX key seconds value将值value关联到key，并将key的生存时间设为seconds(以秒为单位)。
         * redis.setex("foo", 5, "haha");
         * 
         * //MSET key value [key value ...]同时设置一个或多个key-value对。
         * redis.mset("haha","111","xixi","222");
         * 
         * //redis.flushAll();清空所有的key
         * System.out.println(redis.dbSize());//dbSize是多少个key的个数
         * 
         * //APPEND key value如果key已经存在并且是一个字符串，APPEND命令将value追加到key原来的值之后。
         * redis.append("foo",
         * "00");//如果key已经存在并且是一个字符串，APPEND命令将value追加到key原来的值之后。
         * 
         * //GET key 返回key所关联的字符串值 redis.get("foo");
         * 
         * //MGET key [key ...] 返回所有(一个或多个)给定key的值 List list =
         * redis.mget("haha","xixi"); for(int i=0;i<list.size();i++){
         * System.out.println(list.get(i)); }
         * 
         * //DECR key将key中储存的数字值减一。 //DECRBY key
         * decrement将key所储存的值减去减量decrement。 //INCR key 将key中储存的数字值增一。 //INCRBY
         * key increment 将key所储存的值加上增量increment。
         */
        /*
         * ----------------------------------------------------------------------
         * -------------------------------------
         */
        /**
         * Hash 操作
         * 
         * //HSET key field value将哈希表key中的域field的值设为value。 redis.hset("website",
         * "google", "www.google.cn"); redis.hset("website", "baidu",
         * "www.baidu.com"); redis.hset("website", "sina", "www.sina.com");
         * 
         * //HMSET key field value [field value ...] 同时将多个field -
         * value(域-值)对设置到哈希表key中。 Map map = new HashMap(); map.put("cardid",
         * "123456"); map.put("username", "jzkangta"); redis.hmset("hash", map);
         * 
         * //HGET key field返回哈希表key中给定域field的值。
         * System.out.println(redis.hget("hash", "username"));
         * 
         * //HMGET key field [field ...]返回哈希表key中，一个或多个给定域的值。 List list =
         * redis.hmget("website","google","baidu","sina"); for(int
         * i=0;i<list.size();i++){ System.out.println(list.get(i)); }
         * 
         * //HGETALL key返回哈希表key中，所有的域和值。 Map<String,String> map =
         * redis.hgetAll("hash"); for(Map.Entry entry: map.entrySet()) {
         * System.out.print(entry.getKey() + ":" + entry.getValue() + "\t"); }
         * 
         * //HDEL key field [field ...]删除哈希表key中的一个或多个指定域。 //HLEN key
         * 返回哈希表key中域的数量。 //HEXISTS key field查看哈希表key中，给定域field是否存在。 //HINCRBY
         * key field increment为哈希表key中的域field的值加上增量increment。 //HKEYS
         * key返回哈希表key中的所有域。 //HVALS key返回哈希表key中的所有值。
         */
        /*
         * ----------------------------------------------------------------------
         * -------------------------------------
         */
        /**
         * LIST 操作 //LPUSH key value [value ...]将值value插入到列表key的表头。
         * redis.lpush("list", "abc"); redis.lpush("list", "xzc");
         * redis.lpush("list", "erf"); redis.lpush("list", "bnh");
         * 
         * //LRANGE key start
         * stop返回列表key中指定区间内的元素，区间以偏移量start和stop指定。下标(index)参数start和stop都以0为底
         * ，也就是说，以0表示列表的第一个元素，以1表示列表的第二个元素，以此类推。你也可以使用负数下标，以-1表示列表的最后一个元素，-2
         * 表示列表的倒数第二个元素，以此类推。 List list = redis.lrange("list", 0, -1); for(int
         * i=0;i<list.size();i++){ System.out.println(list.get(i)); }
         * 
         * //LLEN key返回列表key的长度。 //LREM key count
         * value根据参数count的值，移除列表中与参数value相等的元素。
         */
        /*
         * ----------------------------------------------------------------------
         * -------------------------------------
         */
        /**
         * SET 操作 //SADD key member [member ...]将member元素加入到集合key当中。
         * redis.sadd("testSet", "s1"); redis.sadd("testSet", "s2");
         * redis.sadd("testSet", "s3"); redis.sadd("testSet", "s4");
         * redis.sadd("testSet", "s5");
         * 
         * //SREM key member移除集合中的member元素。 redis.srem("testSet", "s5");
         * 
         * //SMEMBERS key返回集合key中的所有成员。 Set set = redis.smembers("testSet");
         * Iterator t1=set.iterator() ; while(t1.hasNext()){ Object
         * obj1=t1.next(); System.out.println(obj1); }
         * 
         * //SISMEMBER key member判断member元素是否是集合key的成员。是（true），否则（false）
         * System.out.println(redis.sismember("testSet", "s4"));
         * 
         * //SCARD key返回集合key的基数(集合中元素的数量)。 //SMOVE source destination
         * member将member元素从source集合移动到destination集合。
         * 
         * //SINTER key [key ...]返回一个集合的全部成员，该集合是所有给定集合的交集。 //SINTERSTORE
         * destination key [key
         * ...]此命令等同于SINTER，但它将结果保存到destination集合，而不是简单地返回结果集 //SUNION key [key
         * ...]返回一个集合的全部成员，该集合是所有给定集合的并集。 //SUNIONSTORE destination key [key
         * ...]此命令等同于SUNION，但它将结果保存到destination集合，而不是简单地返回结果集。 //SDIFF key [key
         * ...]返回一个集合的全部成员，该集合是所有给定集合的差集 。 //SDIFFSTORE destination key [key
         * ...]此命令等同于SDIFF，但它将结果保存到destination集合，而不是简单地返回结果集。
         */

        jedis.close();
    }

    // 通过JedisPool对象与Redis建立连接池
    // @Test
    public void testMutiThread() {
        JedisPool pool = null;
        Jedis jedis = null;
        try {
            // JedisPool依赖于apache-commons-pools1
            pool = new JedisPool(new JedisPoolConfig(), HOST, PORT);
            jedis = pool.getResource();
            jedis.set("muti", "bar");
            System.out.println(jedis.get("muti"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != jedis) {
                // 释放已经用过的连接
                jedis.close();
                pool.destroy();
            }
        }
    }
}

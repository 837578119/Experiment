package Utils;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class RedisUtils {
    public static void main(String[] args) {
       // deleteKeys("219.216.65.44",6379, "TestMatriax*");
    }
    /**
     * 删除某些key
     */
    public static void deleteKeys(String url, int port, String keys){
        Jedis redis = new Jedis(url,port);
        Set<String> set = redis.keys(keys);
        if(set==null||set.size()==0){
            return;
        }
        for(String key:set){
            redis.del(key);
        }
        redis.close();
    }
}

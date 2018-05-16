package Predict;

import Utils.RedisUtils;

public class flushRedis {
    public static void main(String[] args) {
//        String keys = "Test*";
        String keys = "sensor*";
        RedisUtils.deleteKeys("219.216.65.44",6379,keys);
    }
}

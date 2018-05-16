package Predict;

import Utils.FileUtils;
import Utils.RedisUtils;
import redis.clients.jedis.Jedis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class cacheData {
    public static void main(String[] args) throws Exception{
        String key1 = "sensor*";
        RedisUtils.deleteKeys("219.216.65.44",6379,key1);
        String key2 = "Test*";
        RedisUtils.deleteKeys("219.216.65.44",6379,key2);
        String fileNames = "C:/Users/Administrator/Desktop/Test_pamap/960";
        int num = FileUtils.getNumFile(fileNames);
        Jedis redis = new Jedis("219.216.65.44",6379);
        String[]files = FileUtils.getFileName(fileNames);
//        redis.set("a","45");
//        long end = System.currentTimeMillis();
//        System.out.println(end-start);

        //插入测试数据
        int k=0;
        for(int i=0;i<num;i++){
            Map<String,String> map = new HashMap<String,String>();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(files[i])));
            String line = bufferedReader.readLine();
            k=0;
            while(line!=null){
                map.put(k+"",line);
                line = bufferedReader.readLine();
                k++;
            }
            redis.hmset("sensor"+i,map);
        }
        System.out.println(redis.hgetAll("sensor0").size());
    }
}

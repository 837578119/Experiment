import Utils.FileUtils;

import java.io.*;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) throws Exception{
        String fileName = "C:/Users/Administrator/Desktop/lxl.csv";
        getData(fileName);
    }
    public static void getData(String fileNames) throws Exception{
        TreeMap<String,Integer> treeMap = new TreeMap<String, Integer>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileNames)));
        String line = bufferedReader.readLine();
        while(line!=null){
            String str[] = line.split(",");
            int k = str.length-1;
            if(treeMap.keySet().contains(str[k])){
                int n = treeMap.get(str[k]) + 1;
                treeMap.put(str[k],n);
            }else{
                treeMap.put(str[k],1);
            }
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        for(String key:treeMap.keySet()){
            System.out.println(key+" "+treeMap.get(key));
        }
    }
}

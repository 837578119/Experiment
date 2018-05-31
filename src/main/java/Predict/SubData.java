package Predict;

import Utils.FileUtils;

import java.io.*;
import java.util.*;

public class SubData {
    public static void main(String[] args) throws Exception{
//        String fileNames = "C:/Users/Administrator/Desktop/Source_train_wrist/sensor_0.csv";
//        String fileNames = "C:/Users/Administrator/Desktop/experiment/DataSet/data5_28/preprocess/lefthand.csv";
        String fileNames = "C:/Users/Administrator/Desktop/right.csv";
        getData(fileNames);
    }
    public static void getData(String fileNames) throws Exception{
        TreeMap<String,Integer> treeMap = new TreeMap<String, Integer>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileNames)));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("C:/Users/Administrator/Desktop/right_test.csv")));
        String line = bufferedReader.readLine();
        while(line!=null){
            String str[] = line.split(",");
            if(treeMap.keySet().contains(str[str.length-1])){
                int n = treeMap.get(str[str.length-1]) + 1;
                treeMap.put(str[str.length-1],n);
            }else{
                treeMap.put(str[str.length-1],1);
            }
            if(treeMap.get(str[str.length-1])>400) {
                bufferedWriter.append(line+"\n");
            }
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
        for(String key:treeMap.keySet()){
            System.out.println(key+" "+treeMap.get(key));
        }
    }
}

package Predict;

import java.io.*;
import java.util.*;

public class SubData {
    public static void main(String[] args) throws Exception{
        String fileNames = "C:/Users/Administrator/Desktop/pamap/subject3_hand_chest_shoes.csv";
        getData(fileNames);
    }
    public static void getData(String fileNames) throws Exception{
        TreeMap<String,Integer> treeMap = new TreeMap<String, Integer>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileNames)));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("C:/Users/Administrator/Desktop/pamap/subject3_test_hand_chest_shoes.csv")));
        String line = bufferedReader.readLine();
        while(line!=null){
            String str[] = line.split(",");
            if(treeMap.keySet().contains(str[str.length-1])){
                int n = treeMap.get(str[str.length-1]) + 1;
                treeMap.put(str[str.length-1],n);
            }else{
                treeMap.put(str[str.length-1],1);
            }
            if(treeMap.get(str[str.length-1])>4000&&treeMap.get(str[str.length-1])<=8000) {
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

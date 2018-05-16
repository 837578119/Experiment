package Predict;

import java.io.*;
import java.util.*;

public class extractData {
    public static void main(String[] args) throws Exception{
        String fileNames = "C:/Users/Administrator/Desktop/pamap/subject2.csv";
        getData(fileNames);

    }
    public static void getData(String fileNames) throws Exception{
        TreeMap<String,Integer> treeMap = new TreeMap<String, Integer>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileNames)));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("C:/Users/Administrator/Desktop/pamap/subject2_hand_chest_shoes.csv")));
        String line = bufferedReader.readLine();
        while(line!=null){
            String currentLine = "";
            String str[] = line.split(",");
            int k=1;
            for(int i=3;i<str.length;i++,k++){
                if(k==15){
                    k=1;
                }
                if(k==1||k>=8){
                    continue;
                }
                currentLine+=str[i]+",";
            }
            currentLine+=str[1]+"\n";
            if(treeMap.keySet().contains(str[1])){
                int n = treeMap.get(str[1]) + 1;
                treeMap.put(str[1],n);
            }else{
                treeMap.put(str[1],1);
            }
            if(treeMap.get(str[1])<=10000&&!str[1].equals("0")) {
                bufferedWriter.append(currentLine);
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

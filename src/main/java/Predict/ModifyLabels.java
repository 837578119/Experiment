package Predict;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ModifyLabels {
    public static void main(String[] args) throws Exception{
        String fileName="C:/Users/Administrator/Desktop/zk_new.csv";
        change(fileName);
    }
    public static void change(String fileName) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("C:/Users/Administrator/Desktop/zk_new2.csv")));
        String line;
        Map<String,String> map = new HashMap<String, String>();
        map.put("����","0");
        map.put("��·","1");
        map.put("����","2");
        map.put("ɨ��","3");
        map.put("�ϵ�","4");
        map.put("д��","5");
        map.put("վ��","6");
        map.put("��ˮ","7");
        map.put("ˢ��","8");
        map.put("�ӵ绰","9");
        map.put("����վ��","10");
        map.put("�ô���","11");
        map.put("�ƶ����","12");
        map.put("����","13");
        map.put("������","14");
        line = bufferedReader.readLine();
        String str="";
        String currentLine[];
        int length;
        while(line!=null){
            str="";
            currentLine = line.split(",");
            length = currentLine.length;
            for(int i=0;i<length-1;i++){
                str = str + currentLine[i]+",";
            }
            currentLine[length-1] = map.get(currentLine[length-1]);
            str=str+currentLine[length-1]+"\n";
            bufferedWriter.append(str);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}

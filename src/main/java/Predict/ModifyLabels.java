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
        map.put("静坐","0");
        map.put("走路","1");
        map.put("推拉","2");
        map.put("扫地","3");
        map.put("拖地","4");
        map.put("写字","5");
        map.put("站立","6");
        map.put("喝水","7");
        map.put("刷牙","8");
        map.put("接电话","9");
        map.put("坐下站起","10");
        map.put("敲代码","11");
        map.put("移动鼠标","12");
        map.put("读书","13");
        map.put("打篮球","14");
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

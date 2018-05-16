package Predict;

import Utils.FileUtils;

import java.io.*;

public class generateData {

    public static void main(String[] args) throws Exception{
        getData();
    }
    public static void getData()throws Exception{
        String fileNames = "C:/Users/Administrator/Desktop/Source_train_pamap";
        String[]files = FileUtils.getFileName(fileNames);
        int[]dir = {192,384,576,768,960};
        int num_file = FileUtils.getNumFile(fileNames);
        BufferedReader bufferedReader[] = new BufferedReader[num_file];
        BufferedWriter bufferedWriter[] = new BufferedWriter[num_file];
        int k =0;
        int count=0;
        String kind ="";
        int num = 0;
        for(k=0;k<dir.length;k++){
            num = dir[k]/8;
            for(int i=0;i<num_file;i++){
                count = 0;
//                File file = new File("C:/Users/Administrator/Desktop/Test_wrist/"+dir[k]+"/sensor_"+i+".csv");

                bufferedReader[i] = new BufferedReader(new FileReader(new File(files[i])));
                bufferedWriter[i] = new BufferedWriter(new FileWriter(new File("C:/Users/Administrator/Desktop/Test_pamap/"+dir[k]+"/sensor_"+i+".csv")));
                String line = bufferedReader[i].readLine();
                while(line!=null){
                    line = line.replace("\"", "") ;
                    if((count<num)&&!(kind.equals(line.split(",")[line.split(",").length-1]))){
                        count++;
                        bufferedWriter[i].append(line+"\n");
                    }
                    if(count == num){
                        kind = line.split(",")[line.split(",").length-1];
                        count=0;
                    }
                    line = bufferedReader[i].readLine();
                }
                bufferedReader[i].close();
                bufferedWriter[i].close();
            }
        }
    }
}

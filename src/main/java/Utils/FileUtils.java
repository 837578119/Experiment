package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileUtils {
    public static void main(String[] args) {
//        System.out.println(getFileName("C:/Users/Administrator/Desktop/Source_train_wrist"));
        //getFileName("C:/Users/Administrator/Desktop/Source_train_wrist");
        String filePath = "C:/Users/Administrator/Desktop/pamap/pamap/subject3";
        String[] a =getFileName(filePath);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]+"  "+getNumColumn(a[i]));
        }
    }
    /**
     * 获取文件的列数
     */
    public static int getNumColumn(String fileName){
        int num=0;
        File file = new File(fileName);
        if(file.exists()){
            try {
                BufferedReader bufferedReader= bufferedReader = new BufferedReader(new FileReader(file));
                String str = bufferedReader.readLine();
                num = str.split(",").length;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return num;
    }
    /**
     * 查看文件夹下文件个数
     */
    public static int getNumFile(String dir){
        File files = new File(dir);
        if(files.isDirectory()){
            return files.listFiles().length;
        }
        return 0;
    }
    /**
     * 获取文件下子文件的名称
     */
    public static String[] getFileName(String dir){
        File files = new File(dir);
        String[]fileNames={""};
        if(files.isDirectory()){
            fileNames = files.list();
            for(int i=0;i<fileNames.length;i++){
                fileNames[i] = dir+"/"+fileNames[i];
            }
        }
        return fileNames;
    }
}

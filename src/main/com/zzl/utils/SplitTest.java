package zzl.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Class <code>Object</code> is the root of the class hierarchy.
 * Every class has <code>Object</code> as a superclass. All objects,
 * including arrays, implement the methods of this class.
 *
 * @author Administrator
 * @version 1.0
 * @see
 * @since JDK1.7
 * <p>
 * History
 * Created by Administrator on 2017/1/12 0012.
 * 分隔字符串
 */
public class SplitTest {

    public static void main(String[] args){
        String filePath = "C:/Users/Administrator/Desktop/FOK pin code all/FOK pin code all/T08 box_3000000/T08 box_3000000.txt";
        readTxtFile(filePath);
    }

    public static void readTxtFile(String filePath){
        try {
            String encoding="GBK";
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                int i = 0;
                while((lineTxt = bufferedReader.readLine()) != null){
//                    System.out.println(lineTxt);
                    if (i == 10000){
                        return;
                    }
                    String[] str = lineTxt.split(";");
                    System.out.println(str[0]);
                    i++;
//                    System.out.println("---------------");
//                    System.out.println(str[1]);
//                    System.out.println("---------------");
//                    System.out.println(str[2]);
//                    System.out.println("---------------");
//                    System.out.println(str[3]);
//                    System.out.println("---------------");
                }
                read.close();
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

    }
}

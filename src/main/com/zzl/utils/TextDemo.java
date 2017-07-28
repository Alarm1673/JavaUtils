package zzl.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
 * Created by Administrator on 2017/7/28 0028.
 * 比较两个txt文件相同的行
 */
public class TextDemo {

    public static List readTxtFile(String filePath){
        List list=new ArrayList();
        try {
            String encoding="GBK";
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                    list.add(lineTxt);
                }
                read.close();
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return list;

    }

    public static void main(String argv[]){
        String filePath = "C:\\Users\\Administrator\\Desktop\\a.txt";//主文件
        List list = readTxtFile(filePath);
        String filePath2 = "C:\\Users\\Administrator\\Desktop\\b.txt";//进行对比的文件
        List list2=readTxtFile(filePath2);
        for(int i = 0; i < list.size(); i++) {
            if(list2.contains(list.get(i))){
                System.out.println("相同的是=="+list.get(i));
            }
        }
    }

}

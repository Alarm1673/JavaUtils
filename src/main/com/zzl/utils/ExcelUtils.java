package zzl.utils;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

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
 * Created by zhangzilong on 2017/1/20 0020.
 * Excel表格工具类
 */
public class ExcelUtils {

    private static final Logger logger = Logger.getLogger(ExcelUtils.class);

    /**
     * 导出Excel
     * @param path  文件路径
     * @param response
     * @param fileName  文件名
     */
    public static void down(String path, HttpServletResponse response,String fileName){
        try {
            File file = new File(path);
            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            try {
                fis.read(buffer);
            } catch (Exception e) {
                logger.error(e);
            } finally {
                fis.close();
            }

            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition","attachment;fileName=" + URLEncoder.encode(fileName,"UTF-8") + ".xlsx");
            response.addHeader("Content-Length", "" + file.length());
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/vnd.ms-excel");
            try {
                outputStream.write(buffer);
                outputStream.flush();
            } catch (Exception e) {
                logger.error(e);
            } finally {
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException ex) {
            logger.error(ex);
        }
    }

}

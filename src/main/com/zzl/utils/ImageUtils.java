package zzl.utils;

import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

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
 * Created by zhangzilong on 2017/2/24 0024.
 * 图片工具类
 */
public class ImageUtils {

    private static final Logger logger = Logger.getLogger(ImageUtils.class);

    public static void main(String[] args)throws Exception{
//        File file = new File("C:/Users/Administrator/Pictures/2.jpg");
//        String path1 = "C:/Users/Administrator/Pictures/2_1.jpg";
//        zoomImage(file,100,100,path);
        String src = "C:/Users/Administrator/Pictures/2.jpg";
        String path2 = "C:/Users/Administrator/Pictures/2_2.jpg";
        cutImage(src, path2, 300, 180, 300, 200);
    }

    /**
     * 图片裁剪通用接口
     * @param src
     * @param dest
     * @param x
     * @param y
     * @param w
     * @param h
     * @throws IOException
     */
    public static void cutImage(String src,String dest,int x,int y,int w,int h) throws IOException{
        Iterator iterator = ImageIO.getImageReadersByFormatName("jpg");
        ImageReader reader = (ImageReader)iterator.next();
        InputStream in = new FileInputStream(src);
        // 获取图片流
        ImageInputStream iis = ImageIO.createImageInputStream(in);
        // iis:读取源。true:只向前搜索
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        /**
         * 图片裁剪区域,Rectangle 指定了坐标空间中的一个区域，
         * 通过 Rectangle 对象的左上顶点的坐标(x，y)、宽度和高度可以定义这个区域
         */
        Rectangle rect = new Rectangle(x, y, w,h);
        // 提供一个 BufferedImage，将其用作解码像素数据的目标。
        param.setSourceRegion(rect);
        /**
         * 使用所提供的 ImageReadParam 读取通过索引 imageIndex 指定的对象，并将
         * 它作为一个完整的 BufferedImage 返回。
         */
        BufferedImage bi = reader.read(0,param);
        ImageIO.write(bi, "jpg", new File(dest));
    }

    /**
     * 缩放图片
     * @param file 需要处理的图片文件
     * @param w	   缩放后宽度
     * @param h	   缩放后的高度
     * @param path
     * @throws Exception
     */
    public static void zoomImage(File file,int w,int h,String path)throws Exception{
        BufferedImage bufImg = ImageIO.read(file);
        //新生成结果图片
        BufferedImage zoomImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        //缩放 getScaledInstance(width,height,hints)
        zoomImg.getGraphics().drawImage(bufImg.getScaledInstance(w, h, Image.SCALE_SMOOTH), 0, 0, null);
        ImageIO.write(zoomImg,"jpg",new File(path));
    }

    /*
     * 根据尺寸图片居中裁剪
     */
    public static void cutCenterImage(String src,String dest,int w,int h) throws IOException {
        Iterator iterator = ImageIO.getImageReadersByFormatName("jpg");
        ImageReader reader = (ImageReader)iterator.next();
        InputStream in=new FileInputStream(src);
        ImageInputStream iis = ImageIO.createImageInputStream(in);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        int imageIndex = 0;
        Rectangle rect = new Rectangle((reader.getWidth(imageIndex)-w)/2, (reader.getHeight(imageIndex)-h)/2, w, h);
        param.setSourceRegion(rect);
        BufferedImage bi = reader.read(0,param);
        ImageIO.write(bi, "jpg", new File(dest));

    }
    /*
     * 图片裁剪二分之一
     */
    public static void cutHalfImage(String src,String dest) throws IOException{
        Iterator iterator = ImageIO.getImageReadersByFormatName("jpg");
        ImageReader reader = (ImageReader)iterator.next();
        InputStream in=new FileInputStream(src);
        ImageInputStream iis = ImageIO.createImageInputStream(in);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        int imageIndex = 0;
        int width = reader.getWidth(imageIndex)/2;
        int height = reader.getHeight(imageIndex)/2;
        Rectangle rect = new Rectangle(width/2, height/2, width, height);
        param.setSourceRegion(rect);
        BufferedImage bi = reader.read(0,param);
        ImageIO.write(bi, "jpg", new File(dest));
    }

    /*
     * 图片缩放
     */
//    public static void zoomImage(String src,String dest,int w,int h) throws Exception {
//        double wr = 0, hr = 0;
//        File srcFile = new File(src);
//        File destFile = new File(dest);
//        BufferedImage bufImg = ImageIO.read(srcFile);
//        Image Itemp = bufImg.getScaledInstance(w, h, bufImg.SCALE_SMOOTH);
//        wr = w * 1.0 / bufImg.getWidth();
//        hr = h * 1.0 / bufImg.getHeight();
//        AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(wr, hr), null);
//        Itemp = ato.filter(bufImg, null);
//        try {
//            ImageIO.write((BufferedImage) Itemp,dest.substring(dest.lastIndexOf(".") + 1), destFile);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }


}

package zzl.utils;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

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
 * Created by Administrator on 2017/2/21 0021.
 * 合成图片
 */
public class ComposeImg {

    public static void main(String args[]) {
        BufferedInputStream imagein = null;
        BufferedInputStream imagein2 = null;
        try {
            int rank = (int)(0.90 * 100);

            String imgUrl = "http://i2.dpfile.com/comm/userface/face7.gif";
            HttpURLConnection con1 = (HttpURLConnection) new URL(imgUrl).openConnection();
            if (con1.getResponseCode() == 200) {
                imagein = new BufferedInputStream(con1.getInputStream());

            }
            String imgUrl2 = "http://p1.meituan.net/codeman/ca92d9ceec25fc1ff7bfead6ee1d9842299472.jpg";
            HttpURLConnection con2 = (HttpURLConnection) new URL(imgUrl2).openConnection();
            if (con2.getResponseCode() == 200) {
                imagein2 = new BufferedInputStream(con2.getInputStream());

            }
            BufferedImage image= ImageIO.read(imagein);
            BufferedImage image2=ImageIO.read(imagein2);
            Graphics g=image2.getGraphics();
            g.drawImage(image, 49, 180, 180, 180, null);
            g.setFont(new Font(null, Font.BOLD, 40));
            g.setColor(Color.WHITE);
            g.drawString("dpuser_2665560727", 245, 222);
            g.setFont(new Font(null, Font.BOLD, 123));
            g.setColor(Color.WHITE);
            g.drawString(String.valueOf(rank), 458, 340);
            g.setFont(new Font(null, Font.BOLD, 40));
            g.setColor(Color.WHITE);
            g.drawString("%", 600, 290);

            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            ImageOutputStream imOut;
            imOut = ImageIO.createImageOutputStream(bs);
            ImageIO.write(image2, "gif",imOut);

            OutputStream outImage = new FileOutputStream("f:/img/6.png");
            JPEGImageEncoder enc= JPEGCodec.createJPEGEncoder(outImage);
            enc.encode(image2);
            imagein.close();
            imagein2.close();
            outImage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

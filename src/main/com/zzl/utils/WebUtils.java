package zzl.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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
 * Created by zhangzilong on 2017/1/22 0022.
 * Web 工具类
 */
public class WebUtils {

    private static final Logger logger = Logger.getLogger(WebUtils.class);

    /**
     * 获取Cookie指定键的值
     * @param request   请求对象
     * @param key       键
     * @return          值
     */
    public static String getCookie(ServletRequest request, String key){
        if (null == key){
            return null;
        }
        Cookie[] cookies = ((HttpServletRequest)request).getCookies();
        if (null == cookies){
            return null;
        }
        for (Cookie cookie : cookies){
            if (null == cookie){
                continue;
            }
            if (key.equals(cookie.getName())){
                return cookie.getValue();
            }
        }
        return null;
    }

    /**
     * 发送一个HTTP POST请求
     * @param url
     * @param jsonBody
     * @return
     * @throws IOException
     */
    public static String httpPost(String url, String jsonBody)throws IOException{
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse httpResponse = null;
        String result = null;
        try {
            httpPost.setEntity(new StringEntity(jsonBody,"UTF-8"));
            httpPost.setHeader(HttpHeaders.CONTENT_TYPE,"application/json");
            httpResponse = client.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            result = EntityUtils.toString(httpEntity);
            //关闭流并释放资源
            EntityUtils.consume(httpEntity);
        }catch (IOException io){
            logger.error("WEBUTILS_HTTP_POST_ERROR",io);
        }finally {
            if (httpResponse != null){
                try {
                    httpResponse.close();
                }catch (IOException e){
                    logger.error("WEBUTILS_HTTP_POST_CLOSE_ERROR",e);
                }
            }
            if (client != null){
                client.close();
            }
        }
        return result;
    }


    public static String doGet(String url){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200){
                return EntityUtils.toString(response.getEntity());
            }
            return null;
        }catch (Exception e){
            logger.error("WEBUTILS-DOGET_ERROR",e);
            return null;
        }finally {
            try {
                httpClient.close();
            }catch (Exception e){
                logger.error("WEBUTILS-DOGET_CLOSE_ERROR",e);
            }
        }
    }

}

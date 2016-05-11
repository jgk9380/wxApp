package org.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;

import org.pojo.Token;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ͨ�ù�����
 *
 * @author liufeng
 * @date 2013-10-17
 */
public class CommonUtil {
    private static Logger log = LoggerFactory.getLogger(CommonUtil.class);

    // ƾ֤��ȡ��GET��
    public final static String token_url =
        "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    /**
     * ����https����
     *
     * @param requestUrl �����ַ
     * @param requestMethod ����ʽ��GET��POST��
     * @param outputStr �ύ������
     * @return JSONObject(ͨ��JSONObject.get(key)�ķ�ʽ��ȡjson���������ֵ)
     */
    public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        try {
            // ����SSLContext���󣬲�ʹ������ָ�������ι�������ʼ��
            TrustManager[] tm = { new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // ������SSLContext�����еõ�SSLSocketFactory����
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

            /**
                    ���ϣ���WEBLOGICû�ж�ʹ�õ�SSLʵ����������õ�����£��ڳ������������ʹ��java.net.URL�Ĳ��� URLStreamHandler �����Ĺ��췽��new һ��URL����Ļ���url.openConnection()Ĭ���Ƿ���SOAPHttpsURLConnection���Ͷ����������ʹ�ô���URLStreamHandler�����Ĺ��췽��������
                    ���Ͽ����ڳ����н�����ص�HttpURLConnection����ľ������͡�����jar���ǵ������ṩ�ģ����ǲ��ܸ��Ĵ��룬����ֻ�ܴ�Weblogic���õĲ����Ͻ����������⡣

                    ��windows�����weblogic��

                    ���ڵ�����Weblogic���ã������������ű��У�����startWebLogic.cmd����set JAVA_OPTIONS=%SAVE_JAVA_OPTIONS%��������-DUseSunHttpHandler=true

                    ����������˼�Ⱥ���򲻱��������ű������Ӳ�����������weblogic����̨������ض�server���ô˲���

                    ���������Ŀ�ľ��Ǹ���WebLogicʹ��Sun��HttpHandler����Ҫʹ��WebLogic�Լ��ġ��������ú�ʹ��url.openConnection()�ͻ᷵��HttpsURLConnection���Ͷ����ˡ�
             */
            conn.setSSLSocketFactory(ssf);

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // ��������ʽ��GET/POST��
            conn.setRequestMethod(requestMethod);

            // ��outputStr��Ϊnullʱ�������д����
            if (null != outputStr) {
                OutputStream outputStream = conn.getOutputStream();
                // ע������ʽ
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // ����������ȡ��������
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

            // �ͷ���Դ
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            conn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (ConnectException ce) {
            log.error("���ӳ�ʱ��{}", ce);
        } catch (Exception e) {
            log.error("https�����쳣��{}", e);
        }
        return jsonObject;
    }


    public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        try {
            // ����SSLContext���󣬲�ʹ������ָ�������ι�������ʼ��

            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //conn.setSSLSocketFactory(ssf);

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // ��������ʽ��GET/POST��
            conn.setRequestMethod(requestMethod);
            conn.setUseCaches(false); // post��ʽ����ʹ�û���
            // ��������ͷ��Ϣ           
            if (null != outputStr) {
                OutputStream outputStream = conn.getOutputStream();
                // ע������ʽ
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // ����������ȡ��������
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

            // �ͷ���Դ
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            conn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (ConnectException ce) {
            log.error("���ӳ�ʱ��{}", ce);
        } catch (Exception e) {
            log.error("https�����쳣��{}", e);
        }
        return jsonObject;
    }

    /**
     * ��ȡ�ӿڷ���ƾ֤
     *
     * @param appid ƾ֤
     * @param appsecret ��Կ
     * @return
     */
    public static Token getToken(String appid, String appsecret) {
        Token token = null;
        String requestUrl = token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
        // ����GET�����ȡƾ֤
        JSONObject jsonObject = httpsRequest(requestUrl, "GET", null);

        if (null != jsonObject) {
            try {
                token = new Token();
                token.setAccessToken(jsonObject.getString("access_token"));
                token.setExpiresIn(jsonObject.getInt("expires_in"));
            } catch (JSONException e) {
                token = null;
                // ��ȡtokenʧ��
                log.error("��ȡtokenʧ�� errcode:{} errmsg:{}", jsonObject.getInt("errcode"),
                          jsonObject.getString("errmsg"));
            }
        }
        return token;
    }

    /**
     * URL���루utf-8��
     *
     * @param source
     * @return
     */
    public static String urlEncodeUTF8(String source) {
        String result = source;
        try {
            result = java.net.URLEncoder.encode(source, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * �������������ж��ļ���չ��
     *
     * @param contentType ��������
     * @return
     */
    public static String getFileExt(String contentType) {
        String fileExt = "";
        if ("image/jpeg".equals(contentType))
            fileExt = ".jpg";
        else if ("audio/mpeg".equals(contentType))
            fileExt = ".mp3";
        else if ("audio/amr".equals(contentType))
            fileExt = ".amr";
        else if ("video/mp4".equals(contentType))
            fileExt = ".mp4";
        else if ("video/mpeg4".equals(contentType))
            fileExt = ".mp4";
        return fileExt;
    }




}

package org.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

public class UnicomRobot {
    private static final String url = "http://www.tuling123.com/openapi/api?key=KEY&info=INFO&userid=UID";
    private static final String key = "0ba7a970a0331517868a87fb6050179e";

    public UnicomRobot() {
        super();
    }

    public static String getAnswer(String info, String userId) {
        String res = null;
        //1、查询数据库
        //2、转图灵处理
        try {
            res = askTuning(info, userId);
            res = res.replace("图灵机器人", "联通客服妹妹");
            res = res.replace("图灵", "联通");
            res = res.replace("<br>", "\n");
            return res+"【机器人客服】";
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(UnicomRobot.class).error("错误的图灵问答:" + e.getMessage());
        }
        return res;
    }

    public static String askTuning(String info, String userId) throws Exception {
        String tempUrl = url.replace("KEY", key);
        tempUrl = tempUrl.replace("INFO", URLEncoder.encode(info, "utf-8"));
        tempUrl = tempUrl.replace("UID", userId);
        URL getUrl = new URL(tempUrl);
        HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
        connection.connect();
        // 取得输入流，并使用Reader读取
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
        StringBuffer sb = new StringBuffer();
        String line = "";
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        // 断开连接
        connection.disconnect();
        JSONObject json = JSONObject.fromObject(sb.toString());
        String res = (String) json.get("text");
        
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(UnicomRobot.getAnswer("望子成龙", "1"));
    }
}

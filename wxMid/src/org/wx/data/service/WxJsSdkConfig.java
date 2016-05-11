package org.wx.data.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.WxSession;

import org.springframework.stereotype.Component;

@Component("wxJsSdkConfig")
public class WxJsSdkConfig implements DataServiceListener {
    public WxJsSdkConfig() {
        super();
    }

    @Override
    public JSONObject doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        WxSession wxSession = (WxSession) request.getSession(true).getAttribute("wxSession");
        if (wxSession == null)
            return new JSONObject();
        String path = request.getRequestURL().toString();
        //System.out.println("$$$$$path="+path+" p="+request.getQueryString());
        String param = request.getParameter("param");
        //param = new String(request.getParameter("param").getBytes("ISO8859-1"), "UTF-8");
  
        JSONObject paramJson = JSONObject.fromObject(param);
        String url = (String) paramJson.get("url");
        Map<String, String> map =
            org.util.JSSDKSignUtils.sign(wxSession.getWxUserBo().getWxAppManager().getOperator().getJsApiTicket().getTicket(),
                                         url);
        JSONObject res = JSONObject.fromObject(map);
        res.put("appId", wxSession.getWxUserBo().getWxUser().getWxApp().getId());
        //System.out.println("WxConfig=" + res.toString());
        return res;
    }

    public static void main(String[] args) {
        String param = "{\"url\":\"jajf?jkaf&akljdf\"}";
        System.out.println(param);
        JSONObject paramJson = JSONObject.fromObject(param);
        String url = (String) paramJson.get("url");
        System.out.println("utl=" + url);
    }
}

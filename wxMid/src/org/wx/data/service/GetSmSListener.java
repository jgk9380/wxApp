package org.wx.data.service;

import java.io.IOException;

import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.WxSession;

import org.apache.log4j.Logger;

import org.entity.WxUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import org.util.UserService;

@Component("sendsmscode")
public class GetSmSListener implements DataServiceListener {
    public GetSmSListener() {
        super();
    }
    @Autowired
    UserService userService;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public JSONObject doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String param = request.getParameter("param");
        //System.out.println("param=" + param);
        JSONObject paramJson = JSONObject.fromObject(param);
        String tele = (String) paramJson.get("tele");
        WxSession wxSession = (WxSession) request.getSession(true).getAttribute("wxSession");
        if (wxSession == null) {
            JSONObject json = new JSONObject();
            json.put("result", "error");
            json.put("resultInfo", "ÏµÍ³´íÎó:wxn");
            Logger.getLogger(GetSmSListener.class).error("wxUser is null");
            return json;
        }
        
        return wxSession.sendSmsCode(tele);
    }
}

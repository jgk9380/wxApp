package org.wx.data.service;


import java.io.IOException;

import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.WxSession;

import org.dao.WxUserDao;

import org.entity.WxUser;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import org.util.UserService;

@Component("bindtele")
public class bindListener implements DataServiceListener {
    public bindListener() {
        super();
    }


    @Override
    public JSONObject doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String param = request.getParameter("param"); 
        JSONObject paramJson = JSONObject.fromObject(param);     
        String yzm = paramJson.getString("yzm");     
        String tele = paramJson.getString("tele");
        WxSession wxSession = (WxSession) request.getSession(true).getAttribute("wxSession");
        return wxSession.bindTele(tele, yzm);
    }
}

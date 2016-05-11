package org.wx.data.service;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.WxSession;

import org.apache.log4j.Logger;

import org.entity.WxUser;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import org.util.UserService;


@Component("giveFee")
public class giveFee implements DataServiceListener {
    public giveFee() {
        super();
    }

    @Autowired
    UserService userService;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public JSONObject doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
                                                                                             IOException {
        String param = request.getParameter("param");
        //System.out.println("param=" + param);
        JSONObject paramJson = JSONObject.fromObject(param);
        String giveFee = (String) paramJson.get("giveFee");
        String tele = (String) paramJson.get("tele");
        //System.out.println("tele="+tele+" give");        
        WxSession wxSession = (WxSession) request.getSession(true).getAttribute("wxSession");      
        return wxSession.giveFee(tele, Double.parseDouble(giveFee));
    }
}


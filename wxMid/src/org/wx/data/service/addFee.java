package org.wx.data.service;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.WxBeanFactoryImpl;

import org.WxSession;

import org.entity.WxUser;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import org.util.UserService;


@Component("addFee")
public class addFee implements DataServiceListener {
    public addFee() {
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
        String addFee = (String) paramJson.get("addFee");
        WxSession wxSession = (WxSession) request.getSession(true).getAttribute("wxSession");
        double toAddFee = Double.parseDouble(addFee);
        return wxSession.addFee((int) toAddFee);
    }
}


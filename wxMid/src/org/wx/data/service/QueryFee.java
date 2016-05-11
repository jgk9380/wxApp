package org.wx.data.service;

import java.io.IOException;

import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.WxSession;

import org.entity.WxUser;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Component;

import org.util.UserService;


@Component("queryFee")
public class QueryFee implements DataServiceListener {
    public QueryFee() {
        super();
    }

    @Override
    public JSONObject doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
                                                                                             IOException {
        String param = request.getParameter("param");
        //System.out.println("param=" + param);  
        WxSession wxSession = (WxSession) request.getSession().getAttribute("wxSession");        
        return wxSession.getLeaveFee();
    }
}


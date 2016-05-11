package org.wx.data.service;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import org.WxBeanFactoryImpl;

import org.WxSession;

import org.dao.WxPromotionGiftDao;

import org.entity.WxPromotionGift;
import org.entity.WxUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component("submitGGK")
public class SubmitGGK implements DataServiceListener {
    public SubmitGGK() {
        super();
    }
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    WxPromotionGiftDao wxPromotionGiftDao;

    @Override
    public JSONObject doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
                                                                                             IOException {

        String ipAddress;
        if (request.getHeader("x-forwarded-for") == null) {
            ipAddress = request.getRemoteAddr();
        } else
            ipAddress = request.getHeader("x-forwarded-for");
        System.out.println("---------ipAddress=" + ipAddress);

        String param = request.getParameter("param");
        System.out.println("param=" + param);
        JSONObject paramJson = JSONObject.fromObject(param);
        WxSession wxSession = (WxSession) request.getSession(true).getAttribute("wxSession");
        WxUser wxUser = wxSession.getWxUserBo().getWxUser();
        if (wxUser == null) {
            Logger.getLogger(getGGK.class).error("wxUser is null 111");
            JSONObject json = new JSONObject();
            json.put("result", "error");
            json.put("resultInfo", "System Error!");
            return json;
        }
        String giftid = null;
        if (!paramJson.containsKey("giftid")) {
            Logger.getLogger(getGGK.class).error("没有编号：giftId");
            JSONObject json = new JSONObject();
            return json;
        }

        giftid = paramJson.getString("giftid");
        WxBeanFactoryImpl wbfi = (WxBeanFactoryImpl) WxBeanFactoryImpl.getInstance();
        wbfi.getPromotionManager().ggkIncomeGift(wxUser.getId(), giftid, ipAddress);
        WxPromotionGift wpg = wxPromotionGiftDao.findById(giftid);
        JSONObject json = new JSONObject();
        json.put("congration", "祝贺你获得" + wpg.getContent());
        return json;
    }
}

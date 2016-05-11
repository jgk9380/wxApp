package org.wx.data.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.WxBeanFactoryImpl;
import org.WxSession;

import org.dao.WxShareLogDao;

import org.entity.WxShareLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import org.util.WxUtils;
import org.util.UserService;

@Component("shareAdd")
public class ShareAdd implements DataServiceListener {
    @Autowired
    UserService userService;
    @Autowired
    WxShareLogDao wxShareLogDao;

    @Override
    public JSONObject doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
                                                                                             IOException {
        String param = request.getParameter("param");
        //System.out.println("param=" + param);
        JSONObject paramJson = JSONObject.fromObject(param);

        String shareFalg =  paramJson.get("shareFalg").toString();
        int shareType = (Integer)paramJson.get("shareType");
        String scence =  paramJson.get("scence").toString();
        String remark =  paramJson.get("remark").toString();

        WxSession wxSession = (WxSession) request.getSession(true).getAttribute("wxSession");
        Long userId;
        WxShareLog wxShareLog = new WxShareLog();
        if (wxSession == null) {
            userId = null;
            //wxShareLog.setUserId(userId);
        } else {
            userId = wxSession.getWxUserBo().getWxUser().getId();
            wxShareLog.setUserId(userId);
        }
 
       
        wxShareLog.setId(WxUtils.getSeqencesValue().longValue());
        wxShareLog.setRemark(remark);
        wxShareLog.setScence(scence);
        wxShareLog.setShareFlag(shareFalg);
        wxShareLog.setShareType(shareType);
        
        wxShareLogDao.save(wxShareLog);
        //ÎÞÐè·µ»Ø
        JSONObject json = new JSONObject();
        return json;
    }
}

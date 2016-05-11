package org.wx.data.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.WxSession;

import org.dao.WxUserDao;

import org.entity.WxUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.util.UserService;

@Component("addinfo")
public class AddInfoListener implements DataServiceListener {
    public AddInfoListener() {
        super();
    }

    @Autowired
    UserService userService;
    @Autowired
    WxUserDao wxUserDao;

    @Override
    public JSONObject doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
                                                                                             IOException {
        String param = request.getParameter("param");
        //System.out.println("param=" + param);
        JSONObject paramJson = JSONObject.fromObject(param);
        String longName = paramJson.getString("longName");
        String promId = paramJson.getString("promId");
        String address = paramJson.getString("address");
        WxSession wxSession = (WxSession) request.getSession(true).getAttribute("wxSession");
        WxUser wxUser = wxSession.getWxUserBo().getWxUser();
        wxUser.setLongName(longName);
        wxUser.setMailAddr(address);
        wxUser.setPromotionCode(promId);
        wxUserDao.save(wxUser);
        {
            JSONObject json = new JSONObject();
            json.put("result", "error");
            json.put("resultInfo", "资料提交成功");
            return json;
        }


    }


}

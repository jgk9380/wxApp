package org.util.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.WxBeanFactoryImpl;

import org.wx.WxOperator;

import org.pojo.WeixinUserInfo;
import org.pojo.WeixinUserList;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class UserExport implements Runnable {
    String openId;
    public UserExport(String openId) {
        super();
        this.openId=openId;
    }

    @Override
    public void run() {
//        String sql =
//            "insert into wxs_userinfo(id,openid,subscribe,subscribetime,nickname,headimgurl,state,usertype)     " +
//            "values(seq_wxs_userinfo.nextval,:openid,:subscribe,:subscribetime,:nickname,:headimgurl,:state,:usertype) ";
//        //WxOperator ycltWx = WxBeanFactoryImpl.getInstance().getYcltWxOperator();
//        NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(WxBeanFactoryImpl.getInstance().getJdbcTemplate());
//        //JdbcTemplate jdbcTemplate = WxBeanFactoryImpl.getInstance().getJdbcTemplate();
//        //WeixinUserList wul = ycltWx.getUserList(openId);       
//        //System.out.println("get UserSize=" + wul.getNextOpenId());
//        if(wul==null ) return;
////        Map<String, Object> param1 = new HashMap<>();
////        param1.put("openidList", wul.getOpenIdList());
////        List<String>  sl=npjt.queryForList("select openid from wxs_userinfo where open_id not in :openidList ", param1,String.class);
////       
//        for (String openId : wul.getOpenIdList()) {
//            Integer openIdC =
//                jdbcTemplate.queryForObject("select  count(*) from wxs_userinfo where openid='" + openId + "'",
//                                            Integer.class);
//            if (openIdC == 1)
//                continue;
//            WeixinUserInfo wxu = ycltWx.getUserInfo(openId);
//            System.out.println("openId=" + openId + "nickname=" + wxu.getNickname());
//            Map<String, Object> param = new HashMap<>();
//            param.put("openid", wxu.getOpenId());
//            param.put("subscribe", wxu.getSubscribe());
//            param.put("subscribetime", wxu.getSubscribeTime());
//            param.put("nickname", wxu.getNickname());
//            param.put("headimgurl", wxu.getHeadImgUrl());
//            param.put("state", 0);
//            param.put("usertype", 0);
//            npjt.update(sql, param);
//        }
    }
}

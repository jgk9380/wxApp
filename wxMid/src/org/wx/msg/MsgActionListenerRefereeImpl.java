package org.wx.msg;

import java.io.PrintWriter;

import java.util.Date;


import javax.transaction.Transactional;

import net.sf.json.JSONObject;

import org.WxBeanFactoryImpl;

import org.dao.WxAppDao;
import org.dao.WxUserMsgDao;

import org.entity.WxUserMsg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;



import org.wx.WxAppManager;

@Component("referMsgActionListener")

public class MsgActionListenerRefereeImpl implements MsgActionListener {
    public MsgActionListenerRefereeImpl() {
        super();
    }
    @Autowired
    WxUserMsgDao wxUserMsgDao;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    WxAppDao wxAppDao;

    @Override
    public String doAction(WxUserMsg wum) {
        String result = null;
        String jsonString = wum.getSceneArgs();
        JSONObject json = JSONObject.fromObject(jsonString);
        result = "你推荐的用户'" + json.getString("nickName") + "'关注了盐城联通，目前共成功推荐了(不含退订)";
        //TODO 修改 bo.getRefereeCount
        String sql =
            "select count(*) co from wx_user " +
            "where   SUBSCRIBE_status=1  and referee_id=" + wum.getWxUser().getId();
        System.out.println("sql=" + sql);
        int refereeCount = jdbcTemplate.queryForObject(sql, Integer.class);
        result = result + refereeCount + "用户关注,继续努力,大奖等着你！";
        wum.setHandleTime(new Date());
        wum.setHandleResult("回复用户：" + result);
        WxAppManager wam =
            WxBeanFactoryImpl.getInstance().getWxAppManager(wum.getWxUser().getWxApp().getAppName());
        wam.getOperator().sendTxtMessage(wum.getWxUser().getOpenId(), result);
        wxUserMsgDao.save(wum);
        return null;
       
    }
}

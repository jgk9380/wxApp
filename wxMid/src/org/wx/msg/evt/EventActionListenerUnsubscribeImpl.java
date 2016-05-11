package org.wx.msg.evt;

import java.io.PrintWriter;

import java.math.BigDecimal;
import javax.transaction.Transactional;

import org.dao.WxUserDao;
import org.dao.WxUserMsgDao;

import org.entity.WxUserMsg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("unsubscribeEvtActionListenBaseImpl")

public class EventActionListenerUnsubscribeImpl implements EventActionListener {
    public EventActionListenerUnsubscribeImpl() {
        super();
    }
    
    @Autowired
    WxUserMsgDao wxUserMsgDao;
    @Autowired
    WxUserDao wxUserDao;

    //@Override
    public void doAction(WxUserMsg wum, PrintWriter out) {
        
        wum.getWxUser().setSubscribeStatus(-1);
        wxUserMsgDao.save(wum);
        wxUserDao.save(wum.getWxUser());
        out.print("");
    };

    @Override
    public void doAction(WxUserMsg wum) {
        System.out.println("##########acton unsubs");
        wum.getWxUser().setSubscribeStatus(-1);
        wxUserMsgDao.save(wum);
        wxUserDao.save(wum.getWxUser());
        
    }
}

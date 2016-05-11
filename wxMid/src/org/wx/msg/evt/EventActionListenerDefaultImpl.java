package org.wx.msg.evt;

import java.io.PrintWriter;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import org.entity.WxUserMsg;

import org.springframework.stereotype.Component;

import org.wx.msg.MsgActionListenerDefaultImpl;

@Component("defaultEvtActionListenBaseImpl")

public class EventActionListenerDefaultImpl implements EventActionListener{
    public EventActionListenerDefaultImpl() {
        super();
    }
  
    @Override
    public void doAction(WxUserMsg wum) {
        Logger.getLogger(EventActionListenerDefaultImpl.class).error("EventActionListener");
    }
}


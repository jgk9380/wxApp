package org.wx.msg;

import java.io.PrintWriter;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import org.entity.WxUserMsg;

import org.springframework.stereotype.Component;

@Component("defaultMsgActionListener")
public class MsgActionListenerDefaultImpl implements MsgActionListener {
    public MsgActionListenerDefaultImpl() {
        super();
    }
  
    @Override
    public String doAction(WxUserMsg wum) {
        Logger.getLogger(MsgActionListenerDefaultImpl.class).error("没有对应的MsgActionListener");
        return null;
    }
}

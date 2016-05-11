package org.wx.msg;

import java.io.PrintWriter;

import java.math.BigDecimal;

import org.entity.WxUserMsg;

public interface MsgActionListener {
    //String doAction(WxUserMsg wum,PrintWriter out);
    String doAction(WxUserMsg wum);
}

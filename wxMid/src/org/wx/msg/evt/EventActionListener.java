package org.wx.msg.evt;

import java.io.PrintWriter;

import org.entity.WxUserMsg;

public interface EventActionListener {
    //TODO ��Ҫout����
    //void doAction(WxUserMsg wum,PrintWriter out);
    void doAction(WxUserMsg wum);
}

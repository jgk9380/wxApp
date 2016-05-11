package org.wx.msg.evt.menu;

import java.io.PrintWriter;

import org.entity.WxUserMsg;

public interface MenuActionListener {
    void doAction(WxUserMsg wum);
}

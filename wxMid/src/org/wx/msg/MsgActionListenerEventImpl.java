package org.wx.msg;

import java.io.PrintWriter;

import java.math.BigDecimal;

import java.util.Date;

import org.WxBeanFactory;

import org.WxBeanFactoryImpl;

import org.dao.WxUserMsgDao;

import org.entity.WxUserMsg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;

import org.wx.WxAppManagerImpl;
import org.wx.msg.evt.EventActionListener;

@Component("eventMsgActionListener")

public class MsgActionListenerEventImpl implements MsgActionListener {
    public MsgActionListenerEventImpl() {
        super();
    }
    @Autowired
    WxUserMsgDao wxUserMsgDao;
    //@Override
    public String doAction(WxUserMsg wum, PrintWriter out) {
        //System.out.println("处理Event类型");
        WxBeanFactory wbf= WxBeanFactoryImpl.getInstance();
        String evtActionListenerName=null;
        if(wum.getEvtType()!=null){
            evtActionListenerName=wum.getEvtType().getHandleClassName();
        }
        //System.out.println("*****EvtActionListener返回："+wum.getEvtType().getHandleClassName());
        EventActionListener eal=wbf.getEvtActionListener(evtActionListenerName);
        eal.doAction(wum);
        wum.setHandleTime(new Date());
        wxUserMsgDao.save(wum);
        return null;
    }
    
    public static void main(String[] args) {
       ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
       WxUserMsgDao wum = (WxUserMsgDao) ctx.getBean("wxUserMsgDao");
       //System.out.println(wum.findById(new BigDecimal(10349)).getEvtType().getHandleClassName());
   }

    @Override
    public String doAction(WxUserMsg wum) {
        //System.out.println("处理Event类型");
        WxBeanFactory wbf= WxBeanFactoryImpl.getInstance();
        String evtActionListenerName=null;
        if(wum.getEvtType()!=null){
            evtActionListenerName=wum.getEvtType().getHandleClassName();
        }
        //System.out.println("*****EvtActionListener返回："+wum.getEvtType().getHandleClassName());
        EventActionListener eal=wbf.getEvtActionListener(evtActionListenerName);
        eal.doAction(wum);
        wum.setHandleTime(new Date());
        wxUserMsgDao.save(wum);
        return null;       
    }
}

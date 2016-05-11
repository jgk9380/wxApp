package org.wx.msg.evt;

import java.io.PrintWriter;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import javax.transaction.Transactional;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import org.WxBeanFactory;

import org.WxBeanFactoryImpl;

import org.dao.WxAppDao;
import org.dao.WxMsgTypeDao;
import org.dao.WxPerQrCodeDao;
import org.dao.WxUserDao;
import org.dao.WxUserMsgDao;

import org.eclipse.persistence.internal.oxm.schema.model.Content;

import org.entity.WxMsgType;
import org.entity.WxPerQrCode;
import org.entity.WxUser;
import org.entity.WxUserMsg;

import org.message.resp.Article;
import org.message.resp.NewsMessage;
import org.message.resp.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


import org.util.AdvancedUtil;
import org.util.MessageUtil;
import org.util.UnicomRobot;

import org.wx.WxAppManager;

import org.wxenum.ArticleType;

@Component("subscribeEvtActionListenBaseImpl")

public class EventActionListenerSubscribeImpl implements EventActionListener {
    final String url = "http://www.ycunicom.com/wx2/welcome/wel.html";
    final String title = "�γ���ͨ��ӭ�㣡";
    final String pictUrl = "http://www.ycunicom.com/wx2/welcome/wel1.jpg";
    final String desc = "��л���ע�γ���ͨ����ע�ͺ���ÿ���к����Ƽ����Ѹ��ͺ���";

    public EventActionListenerSubscribeImpl() {
        super();
    }
    @Autowired
    WxUserMsgDao wxUserMsgDao;
    @Autowired
    WxUserDao wxUserDao;
    @Autowired
    WxAppDao wxAppDao;
    @Autowired
    WxPerQrCodeDao wxPerQrCodeDao;
    @Autowired
    WxMsgTypeDao wxMsgTypeDao;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void doAction(WxUserMsg wum) {

        System.out.println("######acton subs");
        int oldStatus = wum.getWxUser().getSubscribeStatus();
        wum.getWxUser().setSubscribeStatus(1);
        wum.getWxUser().setSubscribeDate(new Date());
        String eventKey = wum.getEventKey();
        if (eventKey != null && oldStatus != -1 && eventKey.length() > 8) {
            //TODO �����Ƽ���Ϣ���ع���wxUserBo��
            String scenenId = eventKey.substring(8, eventKey.length());
            WxPerQrCode pqc = wxPerQrCodeDao.findBySencenId(new BigDecimal(scenenId));
            if (pqc != null) {
                WxUser referee = wxUserDao.findById(pqc.getUserId());
                wum.getWxUser().setReferee(referee);
                //�����Ƽ���Ϣ
                int refereeCount = wxUserDao.getRefereeCount(referee) + 1;
                int refereeCanelCount = wxUserDao.getRefereeCacelCount(referee);
                String mailCont;
                if (refereeCanelCount == 0)
                    mailCont =
                        "���Ƽ����û�����" + wum.getWxUser().getNickname() + "����ע���γ���ͨ��Ŀǰ���ɹ��Ƽ���" + refereeCount +
                        "��������Ŭ�����󽱵����㣡";
                else
                    mailCont =
                        "���Ƽ����û�����" + wum.getWxUser().getNickname() + "����ע���γ���ͨ��Ŀǰ���ɹ��Ƽ���" +
                        (refereeCount + refereeCanelCount) + "��,����" + refereeCanelCount + "����ȡ����ע�����Ƽ�" + refereeCount +
                        "��������Ŭ�����󽱵����㣡";
                WxBeanFactoryImpl.getInstance().getWxAppManager(referee.getWxApp().getAppName()).sendWxMail(referee.getId(), mailCont, 0);
            }
        }
        String scenenArgs = wum.getSceneArgs();
        JSONObject json = JSONObject.fromObject(scenenArgs);
        String toUserName = (String) json.get("FromUserName");
        String fromUserName = (String) json.get("ToUserName");
        WxAppManager wam = WxBeanFactoryImpl.getInstance().getWxAppManager(wum.getWxUser().getWxApp().getAppName());
        if (oldStatus == -1) {
            Article art = new Article();
            art.setTitle(title);
            art.setUrl(url);
            art.setPicUrl(pictUrl);
            art.setDescription(desc);
            List<Article> artl = new ArrayList<>();
            artl.add(art);
            boolean xmlString1 = wam.getOperator().sendArticlesMessage(toUserName, artl);
            wam.getOperator().sendTxtMessage(toUserName, "��ӭ���¹�ע�γ���ͨ");
        } else {
            Article art = new Article();
            art.setTitle(title);
            art.setUrl(url);
            art.setPicUrl(pictUrl);
            art.setDescription(desc);
            List<Article> artl = new ArrayList<>();
            artl.add(art);
            boolean xmlString1 = wam.getOperator().sendArticlesMessage(toUserName, artl);
        }
        wxUserDao.save(wum.getWxUser());
        wxUserMsgDao.save(wum);
    }


    public static void main(String[] args) {
        WxUserDao wxUserDao = WxBeanFactoryImpl.getInstance().getBean("wxUserDao", WxUserDao.class);
        List<BigDecimal> idList = wxUserDao.findRefereeList();
        System.out.println(idList.size());
        int i = 0;
        for (java.math.BigDecimal id : idList) {
            WxUser referee = wxUserDao.findById(id.longValue());
            int refereeCount = wxUserDao.getRefereeCount(referee);
            int refereeCanelCount = wxUserDao.getRefereeCacelCount(referee);
            String mailCont;
            String uname = wxUserDao.findLastRefereeName(id.longValue());
            if (refereeCanelCount == 0)
                mailCont = "���Ƽ����û�����" + uname + "����ע���γ���ͨ��Ŀǰ���ɹ��Ƽ���" + refereeCount + "��������Ŭ�����󽱵����㣡";
            else
                mailCont =
                    "���Ƽ����û�����" + uname + "����ע���γ���ͨ��Ŀǰ���ɹ��Ƽ���" + (refereeCount + refereeCanelCount) + "��,����" +
                    refereeCanelCount + "����ȡ����ע�����Ƽ�" + refereeCount + "��������Ŭ�����󽱵����㣡";
            if (refereeCount > 0) {
                WxBeanFactoryImpl.getInstance().getWxAppManager(referee.getWxApp().getAppName()).sendWxMail(referee.getId(), mailCont, 0);

                //System.out.println((i++) + ":" + mailCont);
            }


        }
    }
}

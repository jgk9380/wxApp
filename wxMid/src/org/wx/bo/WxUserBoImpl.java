package org.wx.bo;

import java.awt.Image;
import java.awt.image.BufferedImage;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;

import java.util.HashMap;
import java.util.List;

import java.util.Map;

import net.sf.json.JSONObject;

import org.WxBeanFactory;

import org.apache.log4j.Logger;

import org.WxBeanFactoryImpl;

import org.dao.WxAppDao;
import org.dao.WxMailArticleDao;
import org.dao.WxMailDao;
import org.dao.WxPerQrCodeDao;

import org.dao.WxPromotionDao;
import org.dao.WxPromotionGiftDao;
import org.dao.WxUserDao;

import org.dao.WxUserMsgDao;

import org.dao.WxUserSpeedDao;

import org.entity.WxMail;
import org.entity.WxMailArticle;
import org.entity.WxPerQrCode;
import org.entity.WxPromotion;
import org.entity.WxPromotionGift;
import org.entity.WxUser;


import org.entity.WxUserSpeed;

import org.entity.qrcode.WxQrCode;

import org.message.resp.Article;

import org.pojo.WeixinMedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.stereotype.Component;

import org.util.PictUtils;

import org.wx.PromotionGiftSelector;
import org.wx.WxAppManager;
import org.wx.WxAppManagerImpl;

import org.wxenum.QrActionName;
import org.wxenum.ScenenFlag;


public class WxUserBoImpl implements WxUserBo {
    WxUser wxUser;

    Account account;
    WxUserDao wxUserDao = WxBeanFactoryImpl.getInstance().getBean("wxUserDao", WxUserDao.class);
    WxMailDao wxMailDao = WxBeanFactoryImpl.getInstance().getBean("wxMailDao", WxMailDao.class);
    WxMailArticleDao wxMailArticleDao =
        WxBeanFactoryImpl.getInstance().getBean("wxMailArticleDao", WxMailArticleDao.class);
    WxUserMsgDao wxUserMsgDao = WxBeanFactoryImpl.getInstance().getBean("wxUserMsgDao", WxUserMsgDao.class);
    JdbcTemplate jdbcTemplate = WxBeanFactoryImpl.getInstance().getJdbcTemplate();
    WxAppManager wxAppManager;

    public WxUserBoImpl(WxUser wxUser) { //�����ⲿ���ã�ͨ��spring�����ļ�ȡ��
        super();
        this.wxUser = wxUser;
        account = WxBeanFactoryImpl.getInstance().getAccount(wxUser.getId());
        WxAppDao wxAppDao = WxBeanFactoryImpl.getInstance().getBean("wxAppDao", WxAppDao.class);
        wxAppManager = WxBeanFactoryImpl.getInstance().getWxAppManager(wxUser.getWxApp().getAppName());
    }

    @Override
    public Account getAccount() {
        return account;
    }

    @Override
    public WxPromotionGift selectRandomGgkGift() { //��ȡ�����ƷID
        /**1��ȡ�����л
         * 2������ÿ���ȡ�����Ʒ����Ϊ�գ������ó�״̬Ϊ1��������
         * 3��ÿ�η���һ����Ʒ
         * */
        WxPromotionDao wxPromotionDao = WxBeanFactoryImpl.getInstance().getBean("wxPromotionDao", WxPromotionDao.class);
        List<WxPromotion> allProm = wxPromotionDao.findAll();
        WxPromotionGiftDao wxPromotionGiftDao =
            WxBeanFactoryImpl.getInstance().getBean("wxPromotionGiftDao", WxPromotionGiftDao.class);
        for (WxPromotion wp : allProm) {
            PromotionGiftSelector pgs =
                WxBeanFactoryImpl.getInstance().getPromotionGiftSelector(wp.getHandleClassName());
            //�޸�gift��״̬Ϊ1��Ԥռ��getPromotionGiftSelector�н���
            WxPromotionGift wpg = pgs.getGiftId(wxUser.getId(), wp.getId());
            if (wpg != null) {
                return wpg;
            }
        }
        return null;
    }


    @Override
    public int getRefereeCount() {
        return wxUserDao.getRefereeCount(wxUser);
    }

    @Override
    public String getShareImageMediaId() {
        WxQrCodeProxyImpl wqcp = new WxQrCodeProxyImpl();
        return wqcp.getShareImageMediaId(this.wxUser.getId());
    }

    @Override
    public String getQrCodeUrl() {
        // TODO Implement this method
        return this.getUserQrCode(wxUser.getId()).getPictureUrl();
    }

    @Override
    public boolean bindTele(String tele) {
        WxUser targetWxUser = wxUserDao.findByTeleAndAppId(tele, wxUser.getWxApp().getId());
        if (targetWxUser != null) {
            Logger.getLogger(WxUserBoImpl.class).error("�����Ѵ���");
            return false;
        }
        wxUser.setTele(tele);
        wxUserDao.save(wxUser);
        return true;
    }


    @Override
    public String getTele() {
        return wxUser.getTele();
    }

    @Override
    public boolean addUserData(String userName, String address, String promId) {
        wxUser.setLongName(userName);
        wxUser.setMailAddr(address);
        wxUser.setPromotionCode(promId);
        wxUserDao.save(wxUser);
        return true;
    }

    public static void main(String[] args) {
        //WxUserBo wub = new WxUserBoImpl(3007095);

        //        WxUserBoImpl wub = (WxUserBoImpl) WxBeanFactoryImpl.getInstance().getUserBo(276507);
        //        wub.getQrCode();
        BufferedImage shareImage = null;
        {
            PictUtils pictUtil = new PictUtils();
            BufferedImage sourceImage = pictUtil.loadImageLocal("D:\\image\\ssv3.jpg");
            BufferedImage qrImage = pictUtil.loadImageLocal("D:\\image\\wr.jpg");
            pictUtil.modifyImage(sourceImage, "" + "123456" + "", 500, 675);
            Image sizeQrImage = qrImage.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
            BufferedImage bufferedQrImage = pictUtil.convertImageToBuffer(sizeQrImage);
            shareImage = pictUtil.modifyImagetogeter(bufferedQrImage, sourceImage, 115, 625);
            pictUtil.writeImageLocal("D:\\image\\res.jpg", shareImage);
        }


    }


    public void setAccount(Account account) {
        this.account = account;
    }

    private WxQrCode getUserQrCode(long userId) {
        WxQrCodeProxyImpl wqpi=new WxQrCodeProxyImpl();
        return wqpi.getUserQrCode(userId);
        
    }

    @Override
    public WxAppManager getWxAppManager() { //TODO ΪʲôҪ��
        return this.wxAppManager;
    }


    @Override
    public byte[] getQrCode() {
        return this.getUserQrCode(wxUser.getId()).getWxMedia().getContent();
    }

    @Override
    public void receiveMail(boolean check) {
        if (check)
            if (wxUserMsgDao.get24HourMsgByUserId(wxUser.getId()) == 0)
                return;
        List<WxMail> wxMailList = wxMailDao.findNoSendedMailByUserId(wxUser.getId());
        //TODO if24Сʱ��½
        if (wxMailList.size() == 0)
            return;
        for (WxMail wm : wxMailList) {
            wm.setIsSend(true);
            wm.setSendDate(new Date());

            String content = null; //=wm.getContent();
            if (wm.getSendId() == null) {
                content = "系统留言：" + wm.getContent();
            } else {
                WxUser sendUser = wxUserDao.findById(wm.getSendId());
                content = "你的朋友：\'" + sendUser.getNickname() + "\'给你留言：" + wm.getContent();
            }
            this.getWxAppManager().getOperator().sendTxtMessage(wxUser.getOpenId(), content);
        }
        wxMailDao.save(wxMailList);
    }

    @Override
    public void receiveMailArticle(boolean check) {
        if (check)
            if (wxUserMsgDao.get24HourMsgByUserId(wxUser.getId()) == 0)
                return;

        List<WxMailArticle> wxMailList = wxMailArticleDao.findNoSendedMailByUserId(wxUser.getId());
        //TODO if24Сʱ��½
        if (wxMailList.size() == 0)
            return;
        for (WxMailArticle wm : wxMailList) {
            wm.setIsSend(true);
            wm.setSendDate(new Date());
            //this.getWxAppManager().getOperator().sendTxtMessage(wxUser.getOpenId(), content);
            Article article = new Article();
            article.setTitle(wm.getTitle());
            article.setDescription(wm.getDesc());
            article.setPicUrl(wm.getPictUrl());
            article.setUrl(wm.getUrl());
            List<Article> artList = new ArrayList<>();
            artList.add(article);
            this.getWxAppManager().getOperator().sendArticlesMessage(wxUser.getOpenId(), artList);
        }
        wxMailArticleDao.save(wxMailList);
    }

    @Override
    public String[] getSpeedInfo() {
        String[] res = new String[3];
        WxUserSpeedDao wxUserSpeedDao = WxBeanFactoryImpl.getInstance().getBean("wxUserSpeedDao", WxUserSpeedDao.class);
        WxUserSpeed wxUserSpeed = wxUserSpeedDao.findByUserId(wxUser.getId());
        if (wxUserSpeed == null) {
            res[0] = "0M";
            res[1] = "0��";
            res[2] = "0%";
            return res;
        } else {
            if (wxUserSpeed.getSpeed().doubleValue() > 1024) {
                BigDecimal b = new BigDecimal(wxUserSpeed.getSpeed().doubleValue() / 1024);
                res[0] = "" + b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "M";
            } else {
                BigDecimal b = new BigDecimal(wxUserSpeed.getSpeed().doubleValue());
                res[0] = "" + b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "K";
            }
            int rank = wxUserSpeedDao.findRankByUserid(wxUser.getId());
            res[1] = "" + rank + "��";
            int all = wxUserSpeedDao.findAllSpeedUser();
            res[2] = "" + ((all - rank) * 100 / all) + "%";
            return res;
        }

    }

    @Override
    public WxUser getWxUser() {
        return wxUser;
    }
}

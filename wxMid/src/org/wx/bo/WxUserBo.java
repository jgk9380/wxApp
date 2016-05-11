package org.wx.bo;

import java.awt.image.BufferedImage;

import org.entity.WxPerQrCode;
import org.entity.WxPromotionGift;
import org.entity.WxUser;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import org.wx.WxAppManager;


public interface WxUserBo {
    WxAppManager getWxAppManager();
    Account getAccount();
    WxPromotionGift selectRandomGgkGift(); //ѡȡ�����Ʒ  
    int getRefereeCount();
    String  getShareImageMediaId();
    String  getQrCodeUrl();
    boolean bindTele(String tele);
    String getTele();    
    boolean addUserData(String userName,String address,String promId);//�ύ�û�����    
    byte[] getQrCode();    
    void receiveMail(boolean check);
    void receiveMailArticle(boolean check);
    String[] getSpeedInfo();
    WxUser getWxUser();
}

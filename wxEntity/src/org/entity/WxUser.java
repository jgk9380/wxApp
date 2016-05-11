package org.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.wxenum.UserType;

/**
 * To create ID generator sequence wx_seq_generator:
 * CREATE SEQUENCE wx_seq_generator INCREMENT BY 50 START WITH 50;
 */
@Entity
@Table(name = "WX_USER")
//@SecondaryTable(name="WX_USER_ADD_INFO")

public class WxUser implements Serializable {
    private static final long serialVersionUID = -1107025096304448973L;
    @Id
    @Column(nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "APP_ID")
    private WxApp wxApp;
    @Column(length = 40)
    private String city;
    @Column(length = 40)
    private String country;
    @Column(length = 40)
    private String headimgurl;
    @Column(length = 40)
    private String language;
    @Column(length = 100)
    private String nickname;
    @Column(name = "OPEN_ID", length = 60)
    private String openId;
    @Column(length = 40)
    private String province;
    @Column(length = 6)
    private String sex;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SUBSCRIBE_DATE")
    private Date subscribeDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    private Date refereshDate;

    @Column(name = "SUBSCRIBE_STATUS")
    private int subscribeStatus;

    @Column(name = "USER_GROUP", length = 60)
    private String userGroup;

    //@Column(name = "USER_TYPE", length = 40,table="WX_USER_ADD_INFO")
    @Column(name = "USER_TYPE", length = 40)
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @ManyToOne
    @JoinColumn(name = "REFEREE_ID")
    private WxUser referee;
    @Column(length = 11)
    private String tele;
    @Column(name = "LONG_NAME", length = 40)
    private String longName;
    @Column(name = "MAIL_ADDR", length = 200)
    private String mailAddr;
    @Column(name = "PROMOTION_CODE", length = 20)
    private String promotionCode;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_LOGIN_DATE")
    private Date lastLoginDate;
    
   
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public WxUser() {
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getMailAddr() {
        return mailAddr;
    }

    public void setMailAddr(String mailAddr) {
        this.mailAddr = mailAddr;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getSubscribeDate() {
        return subscribeDate;
    }

    public void setSubscribeDate(Date subscribeDate) {
        this.subscribeDate = subscribeDate;
    }

    public int getSubscribeStatus() {
        return subscribeStatus;
    }

    public void setSubscribeStatus(int subscribeStatus) {
        this.subscribeStatus = subscribeStatus;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        System.out.println("selectTele");
        this.tele = tele;
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public void setReferee(WxUser referee) {
        this.referee = referee;
    }

    public WxUser getReferee() {
        return referee;
    }



    public void setRefereshDate(Date refereshDate) {
        this.refereshDate = refereshDate;
    }

    public Date getRefereshDate() {
        return refereshDate;
    }

    public void setWxApp(WxApp wxApp) {
        this.wxApp = wxApp;
    }

    public WxApp getWxApp() {
        return wxApp;
    }
}

package org.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "WxApp.findAll", query = "select o from WxApp o") })
@Table(name = "WX_APP")
public class WxApp implements Serializable {
    @SuppressWarnings("compatibility:-1272954700277914063")
    private static final long serialVersionUID = 113387208321234081L;

    @Id
    @Column(nullable = false, length = 100)
    private String id;
    @Column(name = "APP_SECRET", length = 100)
    private String appSecret;
    @Column(name = "APP_TOKEN", length = 100)
    private String appToken;  
    @Column()
    private String token;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TOKEN_DATE")
    private Date tokenDate;
    @Column(name = "TOKE_EXPIRE")
    private Number tokeExpire;
    @Column(name = "USER_NAME", unique = true, length = 100)
    private String userName;
    @Column(name = "APP_NAME", unique = true, length = 100)
    private String appName;
    @Column(name = "remark", unique = true, length = 100)
    private String remark;

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }


    @Column(name="JS_TICKET")
    private String jsTicket;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "JS_TICKET_DATE")
    private Date jsTicketDate;
    @Column(name = "JS_TICKET_EXPIRE")
    private int jsTicketExpire;


    public WxApp() {
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAppToken() {
        return appToken;
    }

    public void setAppToken(String appToken) {
        this.appToken = appToken;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getTokenDate() {
        return tokenDate;
    }

    public void setTokenDate(Date tokenDate) {
        this.tokenDate = tokenDate;
    }

    public Number getTokeExpire() {
        return tokeExpire;
    }

    public void setTokeExpire(Number tokeExpire) {
        this.tokeExpire = tokeExpire;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String toString(){
        String res="id="+id+" app_token="+this.appToken+" sercret="+this.getAppSecret();
        return res;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppName() {
        return appName;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof WxApp)) {
            return false;
        }
        final WxApp other = (WxApp) object;
        if (!(id == null ? other.id == null : id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 37;
        int result = 1;
        result = PRIME * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    public void setJsTicket(String jsTicket) {
        this.jsTicket = jsTicket;
    }

    public String getJsTicket() {
        return jsTicket;
    }

    public void setJsTicketDate(Date jsTicketDate) {
        this.jsTicketDate = jsTicketDate;
    }

    public Date getJsTicketDate() {
        return jsTicketDate;
    }

    public void setJsTicketExpire(int jsTicketExpire) {
        this.jsTicketExpire = jsTicketExpire;
    }

    public int getJsTicketExpire() {
        return jsTicketExpire;
    }
}

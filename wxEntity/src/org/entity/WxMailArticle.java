package org.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

@Table(name = "WX_mail_article")
public class WxMailArticle   implements Serializable{
    @SuppressWarnings("compatibility:-2528820679875009609")
    private static final long serialVersionUID = -5412030492893207921L;


    @Id
    @Column(nullable = false, length = 100)
    private Long id;
    
    @Column(name = "user_id")
    private long userId;    
     
    
    @Column(name = "title")
    private String title;   
    
    @Column(name = "tdesc")
    private String desc;  
    
    @Column(name = "pict_url")
    private String pictUrl;  
    
    @Column(name = "url")
    private String url;  
 
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prod_date")        
    private Date prodDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "send_date")        
    private Date sendDate;
    
    @Column(name = "flag")        
    private boolean isSend;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }


    public void setProdDate(Date prodDate) {
        this.prodDate = prodDate;
    }

    public Date getProdDate() {
        return prodDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setPictUrl(String pictUrl) {
        this.pictUrl = pictUrl;
    }

    public String getPictUrl() {
        return pictUrl;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setIsSend(boolean isSend) {
        this.isSend = isSend;
    }

    public boolean isIsSend() {
        return isSend;
    }
}

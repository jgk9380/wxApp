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

@Table(name = "WX_mail")
public class WxMail   implements Serializable{
    @SuppressWarnings("compatibility:3960486942449612455")
    private static final long serialVersionUID = 9143305327887283347L;


    @Id
    @Column(nullable = false, length = 100)
    private Long id;
    
    @Column(name = "user_id")
    private long userId;
    
    @Column(name = "sender_id")
    private Long sendId;   
    
    @Column(name = "content")
    private String content;   
 
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

    public void setSendId(Long sendId) {
        this.sendId = sendId;
    }

    public Long getSendId() {
        return sendId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
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

    public void setIsSend(boolean isSend) {
        this.isSend = isSend;
    }

    public boolean isIsSend() {
        return isSend;
    }
}

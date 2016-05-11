package org.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.wxenum.QrActionName;
import org.wxenum.ScenenFlag;

@Entity
@Table(name = "wx_per_qr_code")
public class WxPerQrCode implements Serializable {
    private static final long serialVersionUID = 3685350274000784968L;
    @Id
    @Column(nullable = false, length = 200)
    private String ticket;
    @Column(name = "ACTION_NAME", length = 20)
    @Enumerated(EnumType.STRING)
    private QrActionName actionName;    
    @Column(name = "ACTION_INFO")
    private String actionInfo;
    @Column(name = "SENCEN_ID")
    private BigDecimal sencenId;
    @Column(name = "SCENE_STR", length = 64)
    private String sceneStr; 
    @Column(name = "PICTURE_URL", length = 64)
    private String pictureUrl;  
    private byte[] picture;
    @Column(name = "SCENE_FLAG")
    @Enumerated(EnumType.STRING)
    private ScenenFlag sceneFlag; 
    @Column(name = "USER_ID")
    private long userId;       
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE")
    private Date createDate;
    @Column(name = "media_Id")
    String mediaId;
    @Column(name = "media_UpTime")
    Date mediaUpTime;

   

    public WxPerQrCode() {
    }


    public String getActionInfo() {
        return actionInfo;
    }

    public void setActionInfo(String actionInfo) {
        this.actionInfo = actionInfo;
    }

    public QrActionName getActionName() {
        return actionName;
    }

    public void setActionName(QrActionName actionName) {
        this.actionName = actionName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

  

   
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public ScenenFlag getSceneFlag() {
        return sceneFlag;
    }

    public void setSceneFlag(ScenenFlag sceneFlag) {
        this.sceneFlag = sceneFlag;
    }

    public String getSceneStr() {
        return sceneStr;
    }

    public void setSceneStr(String sceneStr) {
        this.sceneStr = sceneStr;
    }

    public BigDecimal getSencenId() {
        return sencenId;
    }

    public void setSencenId(BigDecimal sencenId) {
        this.sencenId = sencenId;
    }

   

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaUpTime(Date mediaUpTime) {
        this.mediaUpTime = mediaUpTime;
    }

    public Date getMediaUpTime() {
        return mediaUpTime;
    }
}

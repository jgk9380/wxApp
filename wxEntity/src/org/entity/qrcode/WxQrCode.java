package org.entity.qrcode;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.entity.media.WxMedia;

import org.wxenum.QrActionName;

@Entity
@Inheritance()
@DiscriminatorColumn(name = "ACTION_NAME", discriminatorType = DiscriminatorType.STRING)
@Table(name = "WX_QR_CODE")
//action_name in('QR_LIMIT_SCENE','QR_SCENE')
//dest_type in ('user','promotion','coupon')
public abstract class WxQrCode implements Serializable {
    @SuppressWarnings("compatibility:-317778836981741296")
    private static final long serialVersionUID = -6127991012541948069L;

    @Id
    @Column(nullable = false, length = 200)
    private String ticket;

     //�ɼ̳������
     @Column(name = "ACTION_NAME", length = 20)
    @Enumerated(EnumType.STRING) 
     private QrActionName actionName;
    
    @Column(name = "SENCEN_ID")
    private BigDecimal sencenId;

    @Column(name = "DEST_TYPE", length = 20)
    private String destType;

    @Column(name = "DEST_ID")
    private BigDecimal destId;

    @Column(name = "DEST_STR")
    private BigDecimal destStr;
    
    @Column(name = "PICTURE_URL", length = 200)
    private String pictureUrl;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "SHARE_IMAGE_MEDIA_ID", length = 300)
    private String shareImageMediaId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SHARE_IMAGE_MEDIA_UPTIME")
    private Date shareImageMediaUptime;

    @ManyToOne
    @JoinColumn(name = "PICTURE_ID")
    private WxMedia wxMedia;


    public WxQrCode() {

    }


    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigDecimal getDestId() {
        return destId;
    }

    public void setDestId(BigDecimal destId) {
        this.destId = destId;
    }

    public BigDecimal getDestStr() {
        return destStr;
    }

    public void setDestStr(BigDecimal destStr) {
        this.destStr = destStr;
    }

    public String getDestType() {
        return destType;
    }

    public void setDestType(String destType) {
        this.destType = destType;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public BigDecimal getSencenId() {
        return sencenId;
    }

    public void setSencenId(BigDecimal sencenId) {
        this.sencenId = sencenId;
    }


    public void setShareImageMediaId(String shareImageMediaId) {
        this.shareImageMediaId = shareImageMediaId;
    }

    public String getShareImageMediaId() {
        return shareImageMediaId;
    }

    public void setShareImageMediaUptime(Date shareImageMediaUptime) {
        this.shareImageMediaUptime = shareImageMediaUptime;
    }

    public Date getShareImageMediaUptime() {
        return shareImageMediaUptime;
    }


    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public WxMedia getWxMedia() {
        return wxMedia;
    }

    public void setWxMedia(WxMedia wxMedia) {
        this.wxMedia = wxMedia;
    }

    public abstract boolean isValid();

    public void setActionName(QrActionName actionName) {
        this.actionName = actionName;
    }

    public QrActionName getActionName() {
        return actionName;
    }
}

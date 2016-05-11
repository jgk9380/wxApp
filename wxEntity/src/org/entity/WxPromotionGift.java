package org.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.entity.asserts.model.WxAssetsType;

@Entity
@Table(name = "WX_PROMOTION_GIFT")
public class WxPromotionGift implements Serializable {
    private static final long serialVersionUID = -2016651406253029050L;
    @Id
    @Column(nullable = false, length = 30)
    private String id;    
    @Column(name = "face_value") 
    private BigDecimal faceVaule;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "GAIN_DATE")
    private Date gainDate;
    @Column(name = "GAIN_WAY", length = 200)
    private String gainWay;  
    @Column(length = 200)
    private String remark;
    @Column(length = 200)
    private Number status;    
    
    @ManyToOne
    @JoinColumn(name = "GAINER")
    private WxUser gainer;
    @ManyToOne
    @JoinColumn(name = "PROMOTION_ID")
    private WxPromotion wxPromotion;    
    @ManyToOne
    @JoinColumn(name = "GIFT_MODEL_ID")
    private WxAssetsType assertType;
    @Column(name ="IP_ADDRESS")
    private String ipAddress;
    
    
    public WxPromotionGift() {
    }

    public Date getGainDate() {
        return gainDate;
    }

    public void setGainDate(Date gainDate) {
        this.gainDate = gainDate;
    }

    public String getGainWay() {
        return gainWay;
    }

    public void setGainWay(String gainWay) {
        this.gainWay = gainWay;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }



    public WxPromotion getWxPromotion() {
        return wxPromotion;
    }

    public void setWxPromotion(WxPromotion wxPromotion) {
        this.wxPromotion = wxPromotion;
    }

    public void setFaceVaule(BigDecimal faceVaule) {
        this.faceVaule = faceVaule;
    }

    public BigDecimal getFaceVaule() {
        return faceVaule;
    }

    public void setGainer(WxUser gainer) {
        this.gainer = gainer;
    }

    public WxUser getGainer() {
        return gainer;
    }

    public void setStatus(Number status) {
        this.status = status;
    }

    public Number getStatus() {
        return status;
    }
    

    
    public String getContent(){
        if (this.getAssertType()!= null&&getAssertType().getId().intValue()!=0) {
            String res = getAssertType().getAlias() + ":" + getFaceVaule() + getAssertType().getUnit();
            return res;
        }
        return "–ª–ª≤Œ”Î";
    }

    public void setAssertType(WxAssetsType assertType) {
        this.assertType = assertType;
    }

    public WxAssetsType getAssertType() {
        return assertType;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }
}

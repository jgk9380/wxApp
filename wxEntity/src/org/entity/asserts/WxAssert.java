package org.entity.asserts;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.entity.WxPromotionGift;
import org.entity.WxUser;
import org.entity.asserts.model.WxAssetsType;


@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "gift_model", discriminatorType = DiscriminatorType.STRING)
@Table(name = "WX_ACCOUNT_REC")
public class WxAssert implements Serializable {
    private static final long serialVersionUID = 71502359319116066L;

    @Id
    @Column(nullable = false)
    private BigDecimal id;
    @JoinColumn(name = "GIFT_MODEL")
    private WxAssetsType assertType;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OCCUR_DATE")
    private Date occurDate;
    @Column(length = 200)
    private String remark;
    @ManyToOne
    @JoinColumn(name = "GIFT_ID")
    private WxPromotionGift wxPromotionGift;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private WxUser wxUser;
    @Column(name = "FACE_VAULE")
    private BigDecimal faceValue;
    
    @Column(name = "is_used")
    private boolean used;


    public WxAssert() {
    }


    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getOccurDate() {
        return occurDate;
    }

    public void setOccurDate(Date occurDate) {
        this.occurDate = occurDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public WxPromotionGift getWxPromotionGift() {
        return wxPromotionGift;
    }

    public void setWxPromotionGift(WxPromotionGift wxPromotionGift) {
        this.wxPromotionGift = wxPromotionGift;
    }


    public void setWxUser(WxUser wxUser) {
        this.wxUser = wxUser;
    }

    public WxUser getWxUser() {
        return wxUser;
    }

    public void setFaceValue(BigDecimal faceValue) {
        this.faceValue = faceValue;
    }

    public BigDecimal getFaceValue() {
        return faceValue;
    }

    public void setAssertType(WxAssetsType assertType) {
        this.assertType = assertType;
    }

    public WxAssetsType getAssertType() {
        return assertType;
    }


    public void setUsed(boolean used) {
        this.used = used;
    }

    public boolean isUsed() {
        return used;
    }
}



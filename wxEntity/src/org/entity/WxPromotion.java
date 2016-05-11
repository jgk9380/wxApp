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
@NamedQueries({ @NamedQuery(name = "WxPromotion.findAll", query = "select o from WxPromotion o") })
@Table(name = "WX_PROMOTION")
public class WxPromotion implements Serializable {
    private static final long serialVersionUID = 5510290048465690269L;
    @Id
    @Column(nullable = false)
    private Integer id;

    @Column(unique = true, length = 80)
    private String alias;

    @Column(name = "ALLOW_JOIN_SQL")
    private String allowJoinSql;

    @Column(name = "GIFT_SELECT_SQL")
    private String giftSelectSql;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "START_DATE")
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "END_DATE")
    private Date endDate;    
    
//    @Column(name = "IS_PASSIVE")
//    private boolean isPassive;

    @Column(length = 200)
    private String remark;

    @Column(length = 200)
    private String note;

    @Column(name="HANDLE_CLASS_NAME")
    private String handleClassName;

    public WxPromotion() {
        
    }


    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAllowJoinSql() {
        return allowJoinSql;
    }

    public void setAllowJoinSql(String allowJoinSql) {
        this.allowJoinSql = allowJoinSql;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getGiftSelectSql() {
        return giftSelectSql;
    }

    public void setGiftSelectSql(String giftSelectSql) {
        this.giftSelectSql = giftSelectSql;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public boolean getIsPassive() {
//        return isPassive;
//    }
//
//    public void setIsPassive(boolean isPassive) {
//        this.isPassive = isPassive;
//    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    public void setHandleClassName(String handleClassName) {
        this.handleClassName = handleClassName;
    }

    public String getHandleClassName() {
        return handleClassName;
    }
}

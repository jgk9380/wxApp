package org.entity.media;

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

@Table(name = "WX_MEDIA")
public class WxMedia implements Serializable {
    private static final long serialVersionUID = -8158556710163092523L;  
    @Id
    @Column(nullable = false)
    private BigDecimal id;
    
    private byte[] content;
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATE_DATE")
    private Date createDate;
  
    @Column(length = 200)
    private String remark;
    @Column(length = 200)
    private String reserverd1;
    @Column(length = 200)
    private String reserverd2;
    @Column(length = 20)
    private String suffix;
    @Column(length = 20)
    private String type;
  

    public WxMedia() {
        
    }

 

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getReserverd1() {
        return reserverd1;
    }

    public void setReserverd1(String reserverd1) {
        this.reserverd1 = reserverd1;
    }

    public String getReserverd2() {
        return reserverd2;
    }

    public void setReserverd2(String reserverd2) {
        this.reserverd2 = reserverd2;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

  
}

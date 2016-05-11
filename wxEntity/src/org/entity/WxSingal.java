package org.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "wx_singal")
public class WxSingal implements Serializable {
    @SuppressWarnings("compatibility:6491110743023415549")
    private static final long serialVersionUID = -7030047101441996430L;

    @Id
    @Column(nullable = false, length = 100)
    private BigDecimal id;
    @Column(name = "tele")
    String tele;
    @Column(name = "name")
    String name;
    @Column(name = "area")
    String area;
    @Column(name = "address")
    String address;
    @Column(name = "signalStrength")
    String signalStrength;
    @Column(name = "signalDesc")
    String signalDesc;
    @Column(name = "other")
    String other;
    @Column(name = "user_Id")
    Long userId;
    
    Number latitude;
    Number longitude;

    public void setLatitude(Number latitude) {
        this.latitude = latitude;
    }

    public Number getLatitude() {
        return latitude;
    }

    public void setLongitude(Number longitude) {
        this.longitude = longitude;
    }

    public Number getLongitude() {
        return longitude;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getTele() {
        return tele;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setSignalStrength(String signalStrength) {
        this.signalStrength = signalStrength;
    }

    public String getSignalStrength() {
        return signalStrength;
    }

    public void setSignalDesc(String signalDesc) {
        this.signalDesc = signalDesc;
    }

    public String getSignalDesc() {
        return signalDesc;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getOther() {
        return other;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
}

package org.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity@Table(name = "wx_test_speed_log")
public class WxTestSpeedLog  implements Serializable{
    @SuppressWarnings("compatibility:2896254320054372323")
    private static final long serialVersionUID = 4420979425745435961L;

    @Id
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false,name="user_id")
    private Long userId;
    @Column(nullable = false)
    private BigDecimal speed;
    @Column(nullable = false,name="test_Date")
    private Date speedDate;
    @Column(nullable = false,name="ip_address")
    private BigDecimal ipAddress;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setSpeed(BigDecimal speed) {
        this.speed = speed;
    }

    public BigDecimal getSpeed() {
        return speed;
    }

    public void setSpeedDate(Date speedDate) {
        this.speedDate = speedDate;
    }

    public Date getSpeedDate() {
        return speedDate;
    }

    public void setIpAddress(BigDecimal ipAddress) {
        this.ipAddress = ipAddress;
    }

    public BigDecimal getIpAddress() {
        return ipAddress;
    }
}

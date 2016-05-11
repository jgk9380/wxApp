package org.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity

@Table(name = "wx_user_speed")
public class WxUserSpeed implements Serializable {
    @SuppressWarnings("compatibility:-4127032376923017771")
    private static final long serialVersionUID = 3021606654873547223L;
    @Id
    @Column(nullable = false, name = "user_id")
    private Long userId;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "speed_date")
    private Date speedDate;
    @Column(name = "speed")
    private BigDecimal speed;

    public void setSpeedDate(Date speedDate) {
        this.speedDate = speedDate;
    }

    public Date getSpeedDate() {
        return speedDate;
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

}

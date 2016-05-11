package org.entity.qrcode;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import javax.persistence.Inheritance;


@Entity
//@Inheritance()
//@DiscriminatorColumn(name = "DEST_TYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("QR_SCENE")
public class WxTempQrCode extends WxQrCode implements Serializable {
    @SuppressWarnings("compatibility:1153511300419648919")
    private static final long serialVersionUID = 977776158789107721L;
    @Column(name = "EXPIRE_SECONDS")
    private int expireSeconds;
    public int getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(int expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    @Override
    public boolean isValid() {
        Date currentDate = new Date();
        if (((currentDate.getTime() - getCreateDate().getTime())/1000 - 3600) < expireSeconds)
            return true;
        return false;
    }
}

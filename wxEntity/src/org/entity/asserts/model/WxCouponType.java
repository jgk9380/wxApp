package org.entity.asserts.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("coupon")
public class WxCouponType extends WxAssetsType implements Serializable{
    public WxCouponType() {
        super();
    }
}

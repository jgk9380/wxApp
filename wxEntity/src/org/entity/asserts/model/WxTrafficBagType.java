package org.entity.asserts.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("trafficeBag")
public class WxTrafficBagType  extends WxAssetsType implements Serializable{
    public WxTrafficBagType() {
        super();
    }
}

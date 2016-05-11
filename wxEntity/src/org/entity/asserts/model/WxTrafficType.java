package org.entity.asserts.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("traffic")
public class WxTrafficType extends WxAssetsType implements Serializable{
    public WxTrafficType() {
        super();
    }
}

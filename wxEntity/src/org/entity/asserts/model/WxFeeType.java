package org.entity.asserts.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("fee")
public class WxFeeType extends WxAssetsType implements Serializable {
    public WxFeeType() {
        super();
    }
}

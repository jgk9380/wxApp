package org.entity.asserts.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("matter")
public class WxMatterType extends WxAssetsType implements Serializable {
    public WxMatterType() {
        super();
    }
}

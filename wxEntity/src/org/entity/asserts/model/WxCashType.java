package org.entity.asserts.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.entity.menu.WxMenu;

@Entity
@DiscriminatorValue("cash")
public class WxCashType extends WxAssetsType implements Serializable {
    @SuppressWarnings("compatibility:-9112251247094291551")
    private static final long serialVersionUID = 8626776081866185256L;


    public WxCashType() {
        super();
    }
}

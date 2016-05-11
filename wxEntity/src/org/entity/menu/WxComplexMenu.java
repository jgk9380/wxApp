package org.entity.menu;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("complex")
public class WxComplexMenu extends WxMenu implements Serializable {
    @SuppressWarnings("compatibility:-135729719956669356")
    private static final long serialVersionUID = 19858883509L;

}



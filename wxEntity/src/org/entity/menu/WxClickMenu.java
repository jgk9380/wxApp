package org.entity.menu;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("click")
public class WxClickMenu extends WxMenu implements Serializable {
    @SuppressWarnings("compatibility:862629023254930261")
    private static final long serialVersionUID = 18347509L;
    String key;    
    @Column(name="handel_class_name")
    String handelClassName;

    public void setHandelClassName(String handelClassName) {
        this.handelClassName = handelClassName;
    }
    
    public String getHandelClassName() {
        return handelClassName;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}


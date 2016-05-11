package org.entity.menu;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.entity.WxApp;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "wx_Menu")
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class WxMenu implements Serializable {
    @SuppressWarnings("compatibility:643445513090035811")
    private static final long serialVersionUID = 1940791176480188184L;
    @Id
    private String id;
    @Column(name = "name")
    private String name;

    @Column(name = "VALID")
    private boolean valid;

    @Column(name = "type")
    private String type;
    
    @ManyToOne
    @JoinColumn(name = "app_id")
    private WxApp wxApp;

    @JoinColumn(name = "parent_id")
    private WxMenu parentMenu;


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }


    public void setWxApp(WxApp wxApp) {
        this.wxApp = wxApp;
    }

    public WxApp getWxApp() {
        return wxApp;
    }

    public void setParentMenu(WxMenu parentMenu) {
        this.parentMenu = parentMenu;
    }

    public WxMenu getParentMenu() {
        return parentMenu;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }
}

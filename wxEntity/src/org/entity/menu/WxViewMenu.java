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
import javax.persistence.Table;

@Entity
@DiscriminatorValue("view")
public class WxViewMenu extends WxMenu implements Serializable {
    @SuppressWarnings("compatibility:-6253296993307071309")
    private static final long serialVersionUID = -5235373548970929980L;
    @Column(name = "target_Url")
    String targetUrl;
    boolean auth;
    String rtype;
    String scope;
    String state;
    @Column(name = "NO_ATTENATION_URL")
    String noAttenationUrl;
    @Column(name="base_addr")
    String baseAddr;

    public void setBaseAddr(String baseAddr) {
        this.baseAddr = baseAddr;
    }

    public String getBaseAddr() {
        return baseAddr;
    }

    public void setTargetUrl(String target) {        
        
        this.targetUrl = target;             
        
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }

    public boolean isAuth() {
        return auth;
    }

    public void setRtype(String rtype) {
        this.rtype = rtype;
    }

    public String getRtype() {
        return rtype;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getScope() {
        return scope;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setNoAttenationUrl(String noAttenationUrl) {
        this.noAttenationUrl = noAttenationUrl;
    }

    public String getNoAttenationUrl() {
        return noAttenationUrl;
    }
}

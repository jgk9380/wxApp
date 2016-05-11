package org.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

@Table(name = "wx_share_log")
public class WxShareLog   implements Serializable{
    @SuppressWarnings("compatibility:-641037965300647371")
    private static final long serialVersionUID = 6268586170742507084L;

    @Id
    @Column(nullable = false, length = 100)
    private Long id;
    
    @Column(name = "user_id")
    private Long userId;    
    
    @Column(name = "share_flag")
    private String shareFlag;
    
    @Column(name = "share_type")
    private int shareType;
    
 
    @Column(name = "scence")
    private String scence;
    
    @Column(name = "remark")
    private String remark;


    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setShareFlag(String shareFlag) {
        this.shareFlag = shareFlag;
    }

    public String getShareFlag() {
        return shareFlag;
    }

    public void setShareType(int share_type) {
        this.shareType = share_type;
    }

    public int getShareType() {
        return shareType;
    }

    public void setScence(String scence) {
        this.scence = scence;
    }

    public String getScence() {
        return scence;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }


}

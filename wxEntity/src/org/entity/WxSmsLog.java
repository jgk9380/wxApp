package org.entity;

import java.io.Serializable;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity@Table(name = "wx_sms_log")
public class WxSmsLog implements Serializable {
    @SuppressWarnings("compatibility:3988024930458899186")
    private static final long serialVersionUID = 7507660971741944116L;


    @Id
    @Column(nullable = false, length = 100)
    private BigDecimal id;
    @Column(name = "tele", length = 100)
    String tele;    
    @Column(name = "content")
    String content;
    @Column(name = "result", length = 100)
    String result;


    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getTele() {
        return tele;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

}

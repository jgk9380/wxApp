package org.entity.asserts.model;



import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "gift_type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "WX_GIFT_MODEL")
public class WxAssetsType  implements Serializable {
    @SuppressWarnings("compatibility:-4651573740809304840")
    private static final long serialVersionUID = 1L;
    @Id
    @Column(nullable = false, length = 30)
    private BigDecimal id;    
    @Column(name = "ALIAS") 
    private String alias;
    @Column(name = "UNIT") 
    private String unit;
    @Column(name = "GIFT_TYPE") 
    private String giftType;
    @Column(name = "NOTES") 
    private String note;
    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setGiftType(String giftType) {
        this.giftType = giftType;
    }

    public String getGiftType() {
        return giftType;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }
}

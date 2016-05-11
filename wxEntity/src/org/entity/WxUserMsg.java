package org.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * To create ID generator sequence wx_seq_generator:
 * CREATE SEQUENCE wx_seq_generator INCREMENT BY 50 START WITH 50;
 */
@Entity

@Table(name = "wx_user_msg")
@SequenceGenerator(name = "WxUserEvent_Id_Seq_Gen", sequenceName = "wx_seq_generator")
public class WxUserMsg implements Serializable {
    private static final long serialVersionUID = 7284372365080001876L;
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WxUserEvent_Id_Seq_Gen")
    private BigDecimal id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME")
    private Date createTime;   
    @Column(name = "HANDLED_FLAG", length = 20)
    private String handledFlag;
    @Column(name = "HANDLE_RESULT", length = 200)
    private String handleResult;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "HANDLE_TIME")
    private Date handleTime;
    @Column(name = "EVENT_KEY")
    private String eventKey; 
    @Column(name = "MSG_ID", length = 30)
    private String msgId;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OCCUR_DATE")
    private Date occurDate;
    @Column(length = 200)
    private String remark;
    @Column(name = "SCENE_ARGS", length = 1000)
    private String sceneArgs;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private WxUser user;
    @ManyToOne
    @JoinColumn(name = "MSG_TYPE")
    private WxMsgType msgType;

    @JoinColumn(name = "EVENT_TYPE")
    private WxEventType evtType;
    public WxUserMsg() {
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getHandledFlag() {
        return handledFlag;
    }

    public void setHandledFlag(String handledFlag) {
        this.handledFlag = handledFlag;
    }

    public String getHandleResult() {
        return handleResult;
    }

    public void setHandleResult(String handleResult) {
        this.handleResult = handleResult;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }


    public Date getOccurDate() {
        return occurDate;
    }

    public void setOccurDate(Date occurDate) {
        this.occurDate = occurDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSceneArgs() {
        return sceneArgs;
    }

    public void setSceneArgs(String sceneArgs) {
        this.sceneArgs = sceneArgs;
    }


    public WxUser getWxUser() {
        return user;
    }

    public void setWxUser(WxUser wxUser1) {
        this.user = wxUser1;
    }


    public void setMsgType(WxMsgType msgType) {
        this.msgType = msgType;
    }

    public WxMsgType getMsgType() {
        return msgType;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getEventKey() {
        return eventKey;
    }

  

    public void setEvtType(WxEventType evtType) {
        this.evtType = evtType;
    }

    public WxEventType getEvtType() {
        return evtType;
    }
}

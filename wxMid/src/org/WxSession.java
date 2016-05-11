package org;


import java.util.Date;

import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import org.dao.WxUserDao;

import org.entity.WxUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.util.UserService;

import org.wx.bo.WxUserBo;
import org.wx.data.service.GetSmSListener;
import org.wx.data.service.giveFee;

public class WxSession {
    WxUserBo wxUserBo;
    String inputSmsCode;
    int sendSmsCode = 0;
    String inputTele;

    public WxSession(WxUser wxUser) {
        wxUserBo = WxBeanFactoryImpl.getInstance().getUserBo(wxUser);
        inputTele = wxUser.getTele();
    }

    public WxUserBo getWxUserBo() {
        return wxUserBo;
    }


    public boolean isMobile(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$"); // ��֤�ֻ���
        m = p.matcher(str);
        b = m.matches();
        return b;
    }

    public JSONObject sendSmsCode(String tele) {
        if (!this.isMobile(tele)) {
            JSONObject json = new JSONObject();
            json.put("result", "error");
            json.put("resultInfo", "号码不正确");
            return json;
        }
        inputTele = tele;
        UserService userService = WxBeanFactoryImpl.getInstance().getUserService();
        WxUserDao wxUserDao = WxBeanFactoryImpl.getInstance().getBean("wxUserDao", WxUserDao.class);
        if (tele.equals(wxUserBo.getWxUser().getTele())) {
            JSONObject json = new JSONObject();
            json.put("result", "error");
            json.put("resultInfo", "号码已经存在");
            return json;
        }

        WxUser tempWxUserList = wxUserDao.findByTeleAndAppId(inputTele, wxUserBo.getWxUser().getWxApp().getId());
        if (tempWxUserList != null) {
            JSONObject json = new JSONObject();
            json.put("result", "error");
            json.put("resultInfo", "�ú����ѱ����˰�");
            return json;
        }
        if (sendSmsCode == 0) { //�����������Ͷ��ţ�sendSmsCode�ں̵ܶ�ʱ���ڲ�����
            sendSmsCode = (int) ((new Date()).getTime() % 10000);
            if (sendSmsCode < 1000)
                sendSmsCode = sendSmsCode + 1000;
            // String res= "ok";
        }
        String smsRes = userService.sendSmsCode(tele, "" + sendSmsCode);

        if (smsRes.contains("result=0")) {
            JSONObject json = new JSONObject();
            json.put("result", "ok");
            json.put("resultInfo", "�����ѷ����������");
            return json;
        } else {
            JSONObject json = new JSONObject();
            json.put("result", "error");
            json.put("resultInfo", "���ŷ���ʧ��,���Ժ�����");
            Logger.getLogger(GetSmSListener.class).error("���ŷ���ʧ��:" + smsRes + "   tele=" + tele);
            return json;
            //֪ͨ����Ԫ
        }
    }

    public JSONObject bindTele(String tele, String smsCode) {
        if (smsCode == null || smsCode.length() < 4) {
            JSONObject json = new JSONObject();
            json.put("result", "error");
            json.put("resultInfo", "��������ȷ����֤��");
            return json;
        }

        WxUserDao wxUserDao = WxBeanFactoryImpl.getInstance().getBean("wxUserDao", WxUserDao.class);
        //        {
        //            if (1 == 1) //�������֤���ں�ر�
        //            {
        //                JSONObject json = new JSONObject();
        //                wxUser.setTele(tele);
        //                json.put("result", "ok");
        //                json.put("resultInfo", "�����Ѱ�");
        //                wxUserDao.save(wxUser);
        //                return json;
        //            }
        //        }

        if (sendSmsCode == Integer.parseInt(smsCode) && tele.equals(inputTele)) {
            JSONObject json = new JSONObject();
            wxUserBo.getWxUser().setTele(tele);
            wxUserDao.save(wxUserBo.getWxUser());
            json.put("result", "ok");
            json.put("resultInfo", "�����Ѱ�");
            return json;
        } else {
            JSONObject json = new JSONObject();
            json.put("result", "error");
            json.put("resultInfo", "��֤��������󣬺����ʧ��");
            return json;
        }
    }

    public JSONObject getLeaveFee() {
        double leaveFee = this.wxUserBo.getAccount().getLeaveFee();
        JSONObject json = new JSONObject();
        json.put("leaveFee", leaveFee);
        String leaveFeeInfo = "��Ļ������Ϊ��" + leaveFee + "Ԫ";
        json.put("leaveFeeInfo", leaveFeeInfo);
        json.put("tele", wxUserBo.getWxUser().getTele());
        json.put("result", "ok");
        return json;
    }

    public JSONObject addFee(int fee) {
        JSONObject json = new JSONObject();
        if (fee > this.wxUserBo.getAccount().getLeaveFee() || fee < 1) {
            json.put("result", "error");
            json.put("resultInfo", "错误的充值金额");
            return json;
        }
        if (this.getWxUserBo().getWxUser().getTele() == null) {
            json.put("result", "error");
            json.put("resultInfo", "手机号码没有绑定");
            return json;
        }
        boolean addResult =
            WxBeanFactoryImpl.getInstance().getUserService().addFee(this.getWxUserBo().getWxUser().getTele(), fee);
        if (addResult == true) {
            this.getWxUserBo().getAccount().addFee(fee);
            double leaveFee = this.getWxUserBo().getAccount().getLeaveFee();
            //System.out.println("leaveFee=" + leaveFee);
            json.put("leaveFee", leaveFee);
            json.put("resultInfo", "缴费成功");
            return json;
        } else {
            double leaveFee = this.getWxUserBo().getAccount().getLeaveFee();
            json.put("result", "error");
            json.put("leaveFee", leaveFee);
            json.put("resultInfo", "缴费不成功，请稍后再试");
            return json;
        }
    }

    public JSONObject addTraffic(int Traffice) {
        JSONObject json = new JSONObject();
        if (Traffice > this.wxUserBo.getAccount().getLeaveTraffic() || Traffice < 1) {
            json.put("result", "error");
            json.put("resultInfo", "错误的流量额");
            return json;
        }
        if (this.getWxUserBo().getWxUser().getTele() == null) {
            json.put("result", "error");
            json.put("resultInfo", "手机号码没有绑定");
            return json;
        }
       
        this.getWxUserBo().getAccount().addTraffic(Traffice);
        double leaveTraffic = this.getWxUserBo().getAccount().getLeaveTraffic();
        //System.out.println("leaveFee=" + leaveFee);
        json.put("leaveTraffic", leaveTraffic);
        json.put("resultInfo", "流量充值成功");
        return json;

    }


    public JSONObject giveFee(String tele, double fee) {
        JSONObject json = new JSONObject();

        double leaveFee = this.getWxUserBo().getAccount().getLeaveFee();
        if (fee > leaveFee || fee < 0) {
            //System.out.println("����˻���������벻��ȷ=" + (fee) + "  leaveFee=" + leaveFee);
            json.put("result", "error");
            json.put("resultInfo", "赠送话费余额不足或赠送话费<0");
            return json;
        }
        WxUserDao wxUserDao = WxBeanFactoryImpl.getInstance().getBean("wxUserDao", WxUserDao.class);
        WxUser targetUser = wxUserDao.findByTeleAndAppId(tele, this.getWxUserBo().getWxUser().getWxApp().getId());
        //System.out.println("tele=" + tele + "   appId=" + this.getWxUser().getAppId());
        if (targetUser == null) {
            json.put("result", "error");
            json.put("resultInfo", "对方号码没有注册<br/>请通知你的好友绑定手机号码");
            return json;
        }
        this.getWxUserBo().getAccount().transferfee(tele, fee);
        leaveFee = this.getWxUserBo().getAccount().getLeaveFee();

        json.put("result", "ok");
        json.put("leaveFee", leaveFee);
        json.put("resultInfo", "话费赠送成功");
        getWxUserBo().getWxAppManager().sendWxMail(targetUser.getId(),
                                                   "我刚刚转了" + fee + "元话费给你，不用谢。",
                                                   this.getWxUserBo().getWxUser().getId());
        return json;
    }

    public JSONObject giveTraffic(String tele, double traffice) {
        JSONObject json = new JSONObject();

        double leaveTraffic = this.getWxUserBo().getAccount().getLeaveTraffic();
        if (traffice > leaveTraffic || traffice < 0) {
            //System.out.println("����˻���������벻��ȷ=" + (fee) + "  leaveFee=" + leaveFee);
            json.put("result", "error");
            json.put("resultInfo", "赠送流量余额不足");
            return json;
        }
        WxUserDao wxUserDao = WxBeanFactoryImpl.getInstance().getBean("wxUserDao", WxUserDao.class);
        WxUser targetUser = wxUserDao.findByTeleAndAppId(tele, this.getWxUserBo().getWxUser().getWxApp().getId());
        //System.out.println("tele=" + tele + "   appId=" + this.getWxUser().getAppId());
        if (targetUser == null) {
            json.put("result", "error");
            json.put("resultInfo", "对方号码没有注册<br/>请通知你的好友绑定手机号码");
            return json;
        }
        this.getWxUserBo().getAccount().transferTraffic(tele,(int) traffice);
        leaveTraffic = this.getWxUserBo().getAccount().getLeaveFee();

        json.put("result", "ok");
        json.put("leaveFee", leaveTraffic);
        json.put("resultInfo", "流量赠送成功");
        getWxUserBo().getWxAppManager().sendWxMail(targetUser.getId(),
                                                   "我刚刚转了" + traffice + "M流量给你，不用谢。",
                                                   this.getWxUserBo().getWxUser().getId());
        return json;
    }


}


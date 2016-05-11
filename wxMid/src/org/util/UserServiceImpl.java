package org.util;

import java.io.UnsupportedEncodingException;

import java.util.Calendar;
import java.util.Date;

import net.sf.json.JSONObject;

import org.WxBeanFactoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.stereotype.Component;

import org.util.sms.Sms;

import org.wx.WxAppManager;


/**
�ͻ����	Varchar(9)		10003
�ͻ�����	Varchar(40)		10004
ҵ������	Varchar(1)	ͬ��ҵ������	10002
�ʵ��·�	Number(6)	YYYYMM	10005
������01	Number(10)	��Ϊ��λ���ַ�������	FEE01
������02	Number(10)	ͬ��	FEE02
������03	Number(10)	ͬ��	FEE03
������	������	������	������
������0N	Number(10)	ͬ��	FEE0N
���ºϼ�	Number(10)	ͬ��	10006
����δ��	Number(10)	ͬ��	10007
���½���	Number(10)	ͬ��	10008
��������	Number(10)	ͬ��	10009
����Ӧ��	Number(10)	ͬ��	10010
ʵʱ����	Number(10)	ͬ��	10011
�û����	Varchar(1)	0-	Ԥ�����û�

 */
@Component("userService")
public class UserServiceImpl implements UserService {
    private   String userName ;
    private   String password ;
    @Autowired
    Sms sms;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    private static final String queryFeeUrl = "http://dl.365ywt.com/api/unicom_yc/userinfo.php";
    private static final String addFeeUrl = "http://dl.365ywt.com/api/unicom_yc/charge.php";

    public UserServiceImpl() {
        super();
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        UserService us = (UserService) ctx.getBean("userService");
        us.addFee("15651554341", 1);
    }

   


    @Override
    public String queryFee(String tele) {
        String ver = MD5.GetMD5Code(userName + tele + MD5.GetMD5Code(password));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("phone_num", tele);
        jsonObject.put("user_name", userName);
        jsonObject.put("verify", ver);
        //System.out.println("Query JSONObject=" + jsonObject);
        JSONObject jo = CommonUtil.httpRequest(queryFeeUrl, "POST", jsonObject.toString());
        //System.out.println(jo);
        int code = jo.getInt("code");
        //System.out.println(code);
        String info = "��ѯ���룺" + tele + "\n";
        if (code == 0) {
            String data = jo.getString("data");
            JSONObject dataObject = JSONObject.fromObject(data);
            info = info + "�û�����" + dataObject.getString("user_name") + "\n";
            info = info + "�ʵ��·�:" + dataObject.getString("T10005") + "\n";
            info = info + "�ʵ��ϼ�:" + dataObject.getDouble("T10006") / 100 + "\n";
            info = info + "���½���:" + dataObject.getDouble("T10008") / 100 + "\n";
            info = info + "����δ��:" + dataObject.getDouble("T10007") / 100 + "\n";
            info = info + "ʵʱ����:" + dataObject.getDouble("T10011") / 100 + "\n";
            return info;
        } else {
            //System.out.println("error:" + jsonObject.getString("word"));
            return null;
        }
    }

    @Override
    public boolean addFee(String tele, int fee) {
        Date d1 = new Date();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user_name", userName);
        jsonObject.put("phone_num", tele);
        //jsonObject.put("phone_name",phoneName );
        jsonObject.put("amount", fee);
        // String ver = MD5.GetMD5Code(userName + tele + phoneName  + fee + MD5.GetMD5Code(password));
        String ver = MD5.GetMD5Code(userName + tele + fee + MD5.GetMD5Code(password));
        //jsonObject.put("verify", "aa0a2b775cb0d5854ee1dfc633c08cd5");
        jsonObject.put("verify", ver);
        //System.out.println("add fee jsonObject=" + jsonObject);
        JSONObject jo = CommonUtil.httpRequest(addFeeUrl, "POST", jsonObject.toString());
        //System.out.println(jo.toString());
        int code = jo.getInt("code");       

        Date d2 = new Date();
        System.out.println((d2.getTime() - d1.getTime()) / 1000 + "秒");
        if (code != 0){
            System.out.println("add fee result="+jo.toString());
            return false;
        }
        else
            return true;
    }


    @Override
    public String sendSmsCode(String tele, String content) {       
        return sms.sendCode(tele, content);
    }
}

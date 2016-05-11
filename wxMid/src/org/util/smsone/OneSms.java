package org.util.smsone;

import java.text.SimpleDateFormat;

import java.util.Date;

import org.WxBeanFactory;
import org.WxBeanFactoryImpl;

import org.dao.WxSmsLogDao;

import org.entity.WxSmsLog;

import org.util.WxUtils;
import org.util.sms.Sms;
import org.util.smsone.cn.com.flaginfo.ws.SmsStub;

public class OneSms implements Sms {
    String corpId; //企业编号230698
    String loginId; //登录名yc_ycltscb
    String pwd; //密码yclt123
    String url; //"http://sms.api.ums86.com:8899/sms_hb/services/Sms?wsdl"

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    //    @Override
    //    public String sendSms(String tele, String content) {
    //        // TODO Implement this method
    //        return null;
    //    }

    @Override
    public String sendCode(String tele, String code) {
        //        输入      In0     string  企业编号
        //        输入      In1     string  用户名称
        //        输入      In2     string  用户密码
        //        输入      In3     string  短信内容, 最大402个字或字符
        //        输入      In4     string  手机号码(多个号码用”,”分隔)，最多1000个号码
        //        输入      In5     string  流水号，20位数字，唯一  （规则自定义,建议时间格式精确到毫秒）必填参数，不填后面无法使用回执接口。
        //        输入      In6     string  预约发送时间，格式:yyyyMMddHHmmss,如‘20090901010101’， 立即发送请填空（预约时间要写当前时间5分钟之后的时间，若预约时间少于5分钟，则为立即发送。）
        //        输入      In7     string  提交时检测方式
        //        1 --- 提交号码中有效的号码仍正常发出短信，无效的号码在返回参数faillist中列出
        //        不为1 或该参数不存在 --- 提交号码中只要有无效的号码，那么所有的号码都不发出短信，所有的号码在返回参数faillist中列出

        try {
            SmsStub stub = new SmsStub(url);
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            //发送接口
            SmsStub.Sms sms0 = new SmsStub.Sms();
            sms0.setIn0(corpId); //企业编号230698
            sms0.setIn1(loginId); //登录名yc_ycltscb
            sms0.setIn2(pwd); //密码yclt123
            String content="尊敬的用户，您本次验证码为:" + code + "，请在10分钟内使用。";
            sms0.setIn3(content); //短信内容
            sms0.setIn4(tele); //手机号码
            sms0.setIn5("000000" + format.format(new Date()));
            sms0.setIn6("");
            sms0.setIn7("1");
            sms0.setIn8("");
            SmsStub.SmsResponse resp = stub.Sms(sms0);          
            //短信日志
            String res= resp.getOut();
            WxSmsLog wxSmsLog =new   WxSmsLog();
            wxSmsLog.setId(WxUtils.getSeqencesValue());
            wxSmsLog.setTele(tele);
            wxSmsLog.setContent(content);
            wxSmsLog.setResult(res);
            WxSmsLogDao wxSmsLogDao= WxBeanFactoryImpl.getInstance().getBean("wxSmsLogDao", WxSmsLogDao.class);
            wxSmsLogDao.save(wxSmsLog);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public OneSms() {
        super();
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public String getCorpId() {
        return corpId;
    }


    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPwd() {
        return pwd;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginId() {
        return loginId;
    }

    public static void main(String[] args) {
        String re = WxBeanFactoryImpl.getInstance().getUserService().sendSmsCode("15651554341", "1234");
        System.out.println(re);
        if (re.contains("result=0")) {
            System.out.println("pl");
        }
    }
}

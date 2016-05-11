package org.util.smsone;

import java.text.SimpleDateFormat;

import java.util.Date;

import org.util.smsone.cn.com.flaginfo.ws.SmsStub;


public class WsTest {

    /**
     * @param args
     */

    public static void main(String[] args) {
        try {
            SmsStub stub = new SmsStub("http://sms.api.ums86.com:8899/sms_hb/services/Sms?wsdl");
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            //发送接口
            SmsStub.Sms sms0 = new SmsStub.Sms();
            sms0.setIn0("230698"); //企业编号
            sms0.setIn1("yc_ycltscb"); //登录名
            sms0.setIn2("yclt123"); //密码
            sms0.setIn3("尊敬的用户，您本次验证码为:1234，请在10分钟内使用。"); //短信内容
            sms0.setIn4("15651554341"); //手机号码
            sms0.setIn5("000000" + format.format(new Date()));
            sms0.setIn6("");
            sms0.setIn7("1");
            sms0.setIn8("");
            SmsStub.SmsResponse resp = stub.Sms(sms0);
            //System.out.println(resp.getOut());
            //			
            ////			//回复接口
            //			SmsStub.ReplyRequest replyRequest = new SmsStub.ReplyRequest();
            //			replyRequest.setIn0("103378");//企业编号
            //			replyRequest.setIn1("admin");//登录名
            //			replyRequest.setIn2("888888");//密码
            //			SmsStub.ReplyResponse resp1 = stub.Reply(replyRequest);
            //			System.out.println(resp1.getResult());
            //			SmsStub.Reply[] replys = resp1.getReplys();
            //			if(replys!=null){
            //				for(int i=0;i<replys.length;i++){
            //					System.out.println(replys[i].getMdn()+","+replys[i].getContent());
            //				}
            //			}

            //			
            //			//回复确认接口
            //			SmsStub.ReplyConfirmRequest confirm = new SmsStub.ReplyConfirmRequest();
            //			confirm.setIn0("100561");//企业编号
            //			confirm.setIn1("fs_qm");//登录名
            //			confirm.setIn2("111111");//密码
            //			confirm.setIn4(resp1.getId());
            //			SmsStub.ReplyConfirmResponse resp2 = stub.replyConfirm(confirm);
            //			System.out.println(resp2.getResult());
            //			
            //状态报告接口
            //			SmsStub.Report report = new SmsStub.Report();
            //			report.setIn0("103378");//企业编号
            //			report.setIn1("admin");//登录名
            //			report.setIn2("888888");//密码
            //			SmsStub.ReportResponse resp3= stub.Report(report);
            //			System.out.println(resp3.getOut());
            //			
            //查询余额接口
            //			SmsStub.SearchSmsNumRequest searchSmsNumRequest = new SmsStub.SearchSmsNumRequest();
            //			searchSmsNumRequest.setIn0("100561");//企业编号
            //			searchSmsNumRequest.setIn1("fs_qm");//登录名
            //			searchSmsNumRequest.setIn2("111111");//密码
            //			SmsStub.SearchSmsNumResponse resp4= stub.searchSmsNum(searchSmsNumRequest);
            //			System.out.println(resp4.getResult());
            //			System.out.println(resp4.getNumber());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

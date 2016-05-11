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
            //���ͽӿ�
            SmsStub.Sms sms0 = new SmsStub.Sms();
            sms0.setIn0("230698"); //��ҵ���
            sms0.setIn1("yc_ycltscb"); //��¼��
            sms0.setIn2("yclt123"); //����
            sms0.setIn3("�𾴵��û�����������֤��Ϊ:1234������10������ʹ�á�"); //��������
            sms0.setIn4("15651554341"); //�ֻ�����
            sms0.setIn5("000000" + format.format(new Date()));
            sms0.setIn6("");
            sms0.setIn7("1");
            sms0.setIn8("");
            SmsStub.SmsResponse resp = stub.Sms(sms0);
            //System.out.println(resp.getOut());
            //			
            ////			//�ظ��ӿ�
            //			SmsStub.ReplyRequest replyRequest = new SmsStub.ReplyRequest();
            //			replyRequest.setIn0("103378");//��ҵ���
            //			replyRequest.setIn1("admin");//��¼��
            //			replyRequest.setIn2("888888");//����
            //			SmsStub.ReplyResponse resp1 = stub.Reply(replyRequest);
            //			System.out.println(resp1.getResult());
            //			SmsStub.Reply[] replys = resp1.getReplys();
            //			if(replys!=null){
            //				for(int i=0;i<replys.length;i++){
            //					System.out.println(replys[i].getMdn()+","+replys[i].getContent());
            //				}
            //			}

            //			
            //			//�ظ�ȷ�Ͻӿ�
            //			SmsStub.ReplyConfirmRequest confirm = new SmsStub.ReplyConfirmRequest();
            //			confirm.setIn0("100561");//��ҵ���
            //			confirm.setIn1("fs_qm");//��¼��
            //			confirm.setIn2("111111");//����
            //			confirm.setIn4(resp1.getId());
            //			SmsStub.ReplyConfirmResponse resp2 = stub.replyConfirm(confirm);
            //			System.out.println(resp2.getResult());
            //			
            //״̬����ӿ�
            //			SmsStub.Report report = new SmsStub.Report();
            //			report.setIn0("103378");//��ҵ���
            //			report.setIn1("admin");//��¼��
            //			report.setIn2("888888");//����
            //			SmsStub.ReportResponse resp3= stub.Report(report);
            //			System.out.println(resp3.getOut());
            //			
            //��ѯ���ӿ�
            //			SmsStub.SearchSmsNumRequest searchSmsNumRequest = new SmsStub.SearchSmsNumRequest();
            //			searchSmsNumRequest.setIn0("100561");//��ҵ���
            //			searchSmsNumRequest.setIn1("fs_qm");//��¼��
            //			searchSmsNumRequest.setIn2("111111");//����
            //			SmsStub.SearchSmsNumResponse resp4= stub.searchSmsNum(searchSmsNumRequest);
            //			System.out.println(resp4.getResult());
            //			System.out.println(resp4.getNumber());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

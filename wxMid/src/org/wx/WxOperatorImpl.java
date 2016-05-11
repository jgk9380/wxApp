package org.wx;


import org.util.SignUtil;

public class WxOperatorImpl extends WxOperatorBaseImpl {
    public WxOperatorImpl(String appId) {        
        super(appId);//一个参数即可
    }

    public static void main(String[] args) {
        String signature = "c27deb4230571729e14484fb2ffc1795ea1b3932";
        String timestamp = "1454058590";
        String nonce = "c27deb4230571729e14484fb2ffc1795ea1b3932";
        String echostr = "c27deb4230571729e14484fb2ffc1795ea1b3932";
        WxOperatorImpl woi = new WxOperatorImpl("wx7dcc6b2e03a47c0b");//txq
        woi.setTokenString("jgk9380");
        //System.out.println(woi.checkSignature(signature, timestamp, nonce));
        //System.out.println(SignUtil.checkSignature("jgk9380",signature, timestamp, nonce));
    }


  
}

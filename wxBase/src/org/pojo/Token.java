package org.pojo;

import java.util.Date;

/**
 * 凭证
 *
 * @author liufeng
 * @date 2013-10-17
 */
public class Token {
    // 接口访问凭证
    private String accessToken;
    // 凭证有效期，单位：秒
    private int expiresIn;
    // 凭证获得时间 单位秒 判断是否失效
    private Date productTime;


    public Token() {
        productTime=new Date();
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }


  public  boolean isValid() {
        if (new Date().getTime() / 1000 - productTime.getTime()/1000 > (expiresIn-60*15))//余量15分钟
            return false;
        else
            return true;
    }

    public void setProductTime(Date productTime) {
        this.productTime = productTime;
    }

    public Date getProductTime() {
        return productTime;
    }
}

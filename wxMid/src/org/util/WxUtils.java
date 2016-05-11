package org.util;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.WxBeanFactoryImpl;

import org.apache.log4j.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

public class WxUtils {
    static JdbcTemplate jdbcTemplate; 
    static{
        jdbcTemplate=WxBeanFactoryImpl.getInstance().getJdbcTemplate();
    }

    public static BigDecimal getSeqencesValue() {
        BigDecimal l = jdbcTemplate.queryForObject("select wx_seq_generator.nextval from dual", BigDecimal.class);
        return l;
    }
    
    public static int getScenenIdSeqencesValue() {
        int l =
            jdbcTemplate.queryForObject("select wx_qr_scenen_id_seq_generator.nextval from dual", Integer.class);
         return l;
    }
     
    public static String getIpAddress(HttpServletRequest request){
        String ipAddress;
        if (request.getHeader("x-forwarded-for") == null) {
            ipAddress = request.getRemoteAddr();
        } else
            ipAddress = request.getHeader("x-forwarded-for");
        return ipAddress;
    }
    
      public static String getAppName(String url) {
        
        int pos = url.indexOf("appName=");
        if (pos == -1){
            Logger.getLogger(WxUtils.class).error("û���ҵ�appName");
            return null;
        }
        String res = url.substring(pos + 8);
        return res;
    }
      public static String getUrlHead(String url) {
        int pos = url.indexOf("?");
        if (pos == -1){
            Logger.getLogger(WxUtils.class).error("û���ҵ�appName");
            return null;
        }
        String res = url.substring(0 ,pos);
        return res;
    }
}

package org.util;



public interface UserService {
    String queryFee(String tele);
    boolean addFee(String tele,int fee);   
    String  sendSmsCode(String tele,String content);
}


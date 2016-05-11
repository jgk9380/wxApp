package org.wx.bo;

public interface MessageManager {

    String getPassiveSendTextXml(String fromUser,String toUser,String Content);
    String getPassiveSendArticleXml(String fromUser, String toUser, String title,String desc ,String pictureUrl,String contentUrl);   
    
}

//SystemMessage 系统发送给用户的消息
//UserMessage   用户行为发送给系统的消息



/**
 * SmsCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */

    package org.util.smsone.cn.com.flaginfo.ws;

    /**
     *  SmsCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class SmsCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public SmsCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public SmsCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for Sms method
            * override this method for handling normal response from Sms operation
            */
           public void receiveResultSms(
                    org.util.smsone.cn.com.flaginfo.ws.SmsStub.SmsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from Sms operation
           */
            public void receiveErrorSms(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for Reply method
            * override this method for handling normal response from Reply operation
            */
           public void receiveResultReply(
                    org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from Reply operation
           */
            public void receiveErrorReply(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for Report method
            * override this method for handling normal response from Report operation
            */
           public void receiveResultReport(
                    org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReportResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from Report operation
           */
            public void receiveErrorReport(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for SearchSmsNum method
            * override this method for handling normal response from SearchSmsNum operation
            */
           public void receiveResultSearchSmsNum(
                    org.util.smsone.cn.com.flaginfo.ws.SmsStub.SearchSmsNumResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from SearchSmsNum operation
           */
            public void receiveErrorSearchSmsNum(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for ReplyConfirm method
            * override this method for handling normal response from ReplyConfirm operation
            */
           public void receiveResultReplyConfirm(
                    org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyConfirmResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from ReplyConfirm operation
           */
            public void receiveErrorReplyConfirm(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for Auditing method
            * override this method for handling normal response from Auditing operation
            */
           public void receiveResultAuditing(
                    org.util.smsone.cn.com.flaginfo.ws.SmsStub.AuditingResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from Auditing operation
           */
            public void receiveErrorAuditing(java.lang.Exception e) {
            }
                


    }
    

/**
 * SmsStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */
package org.util.smsone.cn.com.flaginfo.ws;


/*
        *  SmsStub java implementation
        */


public class SmsStub extends org.apache.axis2.client.Stub {
    protected org.apache.axis2.description.AxisOperation[] _operations;

    //hashmaps to keep the fault mapping
    private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
    private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
    private java.util.HashMap faultMessageMap = new java.util.HashMap();

    private static int counter = 0;

    private static synchronized String getUniqueSuffix() {
        // reset the counter if it is greater than 99999
        if (counter > 99999) {
            counter = 0;
        }
        counter = counter + 1;
        return Long.toString(System.currentTimeMillis()) + "_" + counter;
    }


    private void populateAxisService() throws org.apache.axis2.AxisFault {

        //creating the Service with a unique name
        _service = new org.apache.axis2.description.AxisService("Sms" + getUniqueSuffix());
        addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[6];

        __operation = new org.apache.axis2.description.OutInAxisOperation();


        __operation.setName(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "Sms"));
        _service.addOperation(__operation);


        _operations[0] = __operation;


        __operation = new org.apache.axis2.description.OutInAxisOperation();


        __operation.setName(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "Reply"));
        _service.addOperation(__operation);


        _operations[1] = __operation;


        __operation = new org.apache.axis2.description.OutInAxisOperation();


        __operation.setName(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "Report"));
        _service.addOperation(__operation);


        _operations[2] = __operation;


        __operation = new org.apache.axis2.description.OutInAxisOperation();


        __operation.setName(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "SearchSmsNum"));
        _service.addOperation(__operation);


        _operations[3] = __operation;


        __operation = new org.apache.axis2.description.OutInAxisOperation();


        __operation.setName(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "ReplyConfirm"));
        _service.addOperation(__operation);


        _operations[4] = __operation;


        __operation = new org.apache.axis2.description.OutInAxisOperation();


        __operation.setName(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "Auditing"));
        _service.addOperation(__operation);


        _operations[5] = __operation;


    }

    //populates the faults
    private void populateFaults() {


    }

    /**
     *Constructor that takes in a configContext
     */

    public SmsStub(org.apache.axis2.context.ConfigurationContext configurationContext,
                   java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(configurationContext, targetEndpoint, false);
    }


    /**
     * Constructor that takes in a configContext  and useseperate listner
     */
    public SmsStub(org.apache.axis2.context.ConfigurationContext configurationContext, java.lang.String targetEndpoint,
                   boolean useSeparateListener) throws org.apache.axis2.AxisFault {
        //To populate AxisService
        populateAxisService();
        populateFaults();

        _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext, _service);


        configurationContext = _serviceClient.getServiceContext().getConfigurationContext();

        _serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);


    }

    /**
     * Default Constructor
     */
    public SmsStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {

        this(configurationContext, "http://112.65.228.88:8888/sms_hb/services/Sms/");

    }

    /**
     * Default Constructor
     */
    public SmsStub() throws org.apache.axis2.AxisFault {

        this("http://112.65.228.88:8888/sms_hb/services/Sms/");

    }

    /**
     * Constructor taking the target endpoint
     */
    public SmsStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null, targetEndpoint);
    }


    /**
     * Auto generated method signature
     *
     * @see cn.com.flaginfo.ws.Sms#Sms
     * @param sms0

     */


    public org.util.smsone.cn.com.flaginfo.ws.SmsStub.SmsResponse Sms(

        org.util.smsone.cn.com.flaginfo.ws.SmsStub.Sms sms0)


        throws java.rmi.RemoteException

    {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient =
                _serviceClient.createClient(_operations[0].getName());
            _operationClient.getOptions().setAction("\"\"");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


            addPropertyToOperationClient(_operationClient,
                                         org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                                         "&");


            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();


            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;


            env =
                toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), sms0,
                           optimizeContent(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "Sms")));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);


            org.apache.axis2.context.MessageContext _returnMessageContext =
                _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


            java.lang.Object object =
                fromOM(_returnEnv.getBody().getFirstElement(),
                       org.util.smsone.cn.com.flaginfo.ws.SmsStub.SmsResponse.class, getEnvelopeNamespaces(_returnEnv));


            return (org.util.smsone.cn.com.flaginfo.ws.SmsStub.SmsResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName =
                            (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m =
                            exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] { messageClass });
                        m.invoke(ex, new java.lang.Object[] { messageObject });


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            _messageContext.getTransportOut().getSender().cleanup(_messageContext);
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see cn.com.flaginfo.ws.Sms#startSms
     * @param sms0

     */
    public void startSms(

        org.util.smsone.cn.com.flaginfo.ws.SmsStub.Sms sms0,

        final org.util.smsone.cn.com.flaginfo.ws.SmsCallbackHandler callback)

        throws java.rmi.RemoteException {

        org.apache.axis2.client.OperationClient _operationClient =
            _serviceClient.createClient(_operations[0].getName());
        _operationClient.getOptions().setAction("\"\"");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


        addPropertyToOperationClient(_operationClient,
                                     org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                                     "&");


        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


        //Style is Doc.


        env =
            toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), sms0,
                       optimizeContent(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "Sms")));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    java.lang.Object object =
                        fromOM(resultEnv.getBody().getFirstElement(),
                               org.util.smsone.cn.com.flaginfo.ws.SmsStub.SmsResponse.class,
                               getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultSms((org.util.smsone.cn.com.flaginfo.ws.SmsStub.SmsResponse) object);

                } catch (org.apache.axis2.AxisFault e) {
                    callback.receiveErrorSms(e);
                }
            }

            public void onError(java.lang.Exception error) {
                if (error instanceof org.apache.axis2.AxisFault) {
                    org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();
                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                            //make the fault by reflection
                            try {
                                java.lang.String exceptionClassName =
                                    (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
                                java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                                java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();
                                //message class
                                java.lang.String messageClassName =
                                    (java.lang.String) faultMessageMap.get(faultElt.getQName());
                                java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                                java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                                java.lang.reflect.Method m =
                                    exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] { messageClass });
                                m.invoke(ex, new java.lang.Object[] { messageObject });


                                callback.receiveErrorSms(new java.rmi.RemoteException(ex.getMessage(), ex));
                            } catch (java.lang.ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorSms(f);
                            } catch (java.lang.ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorSms(f);
                            } catch (java.lang.NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorSms(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorSms(f);
                            } catch (java.lang.IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorSms(f);
                            } catch (java.lang.InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorSms(f);
                            } catch (org.apache.axis2.AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorSms(f);
                            }
                        } else {
                            callback.receiveErrorSms(f);
                        }
                    } else {
                        callback.receiveErrorSms(f);
                    }
                } else {
                    callback.receiveErrorSms(error);
                }
            }

            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                org.apache.axis2.AxisFault fault =
                    org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                } catch (org.apache.axis2.AxisFault axisFault) {
                    callback.receiveErrorSms(axisFault);
                }
            }
        });


        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if (_operations[0].getMessageReceiver() == null && _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[0].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);

    }

    /**
     * Auto generated method signature
     *
     * @see cn.com.flaginfo.ws.Sms#Reply
     * @param replyRequest2

     */


    public org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyResponse Reply(

        org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyRequest replyRequest2)


        throws java.rmi.RemoteException

    {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient =
                _serviceClient.createClient(_operations[1].getName());
            _operationClient.getOptions().setAction("\"\"");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


            addPropertyToOperationClient(_operationClient,
                                         org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                                         "&");


            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();


            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;


            env =
                toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), replyRequest2,
                           optimizeContent(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "Reply")));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);


            org.apache.axis2.context.MessageContext _returnMessageContext =
                _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


            java.lang.Object object =
                fromOM(_returnEnv.getBody().getFirstElement(),
                       org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyResponse.class,
                       getEnvelopeNamespaces(_returnEnv));


            return (org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName =
                            (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m =
                            exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] { messageClass });
                        m.invoke(ex, new java.lang.Object[] { messageObject });


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            _messageContext.getTransportOut().getSender().cleanup(_messageContext);
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see cn.com.flaginfo.ws.Sms#startReply
     * @param replyRequest2

     */
    public void startReply(

        org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyRequest replyRequest2,

        final org.util.smsone.cn.com.flaginfo.ws.SmsCallbackHandler callback)

        throws java.rmi.RemoteException {

        org.apache.axis2.client.OperationClient _operationClient =
            _serviceClient.createClient(_operations[1].getName());
        _operationClient.getOptions().setAction("\"\"");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


        addPropertyToOperationClient(_operationClient,
                                     org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                                     "&");


        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


        //Style is Doc.


        env =
            toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), replyRequest2,
                       optimizeContent(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "Reply")));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    java.lang.Object object =
                        fromOM(resultEnv.getBody().getFirstElement(),
                               org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyResponse.class,
                               getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultReply((org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyResponse) object);

                } catch (org.apache.axis2.AxisFault e) {
                    callback.receiveErrorReply(e);
                }
            }

            public void onError(java.lang.Exception error) {
                if (error instanceof org.apache.axis2.AxisFault) {
                    org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();
                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                            //make the fault by reflection
                            try {
                                java.lang.String exceptionClassName =
                                    (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
                                java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                                java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();
                                //message class
                                java.lang.String messageClassName =
                                    (java.lang.String) faultMessageMap.get(faultElt.getQName());
                                java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                                java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                                java.lang.reflect.Method m =
                                    exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] { messageClass });
                                m.invoke(ex, new java.lang.Object[] { messageObject });


                                callback.receiveErrorReply(new java.rmi.RemoteException(ex.getMessage(), ex));
                            } catch (java.lang.ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorReply(f);
                            } catch (java.lang.ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorReply(f);
                            } catch (java.lang.NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorReply(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorReply(f);
                            } catch (java.lang.IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorReply(f);
                            } catch (java.lang.InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorReply(f);
                            } catch (org.apache.axis2.AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorReply(f);
                            }
                        } else {
                            callback.receiveErrorReply(f);
                        }
                    } else {
                        callback.receiveErrorReply(f);
                    }
                } else {
                    callback.receiveErrorReply(error);
                }
            }

            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                org.apache.axis2.AxisFault fault =
                    org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                } catch (org.apache.axis2.AxisFault axisFault) {
                    callback.receiveErrorReply(axisFault);
                }
            }
        });


        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if (_operations[1].getMessageReceiver() == null && _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[1].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);

    }

    /**
     * Auto generated method signature
     *
     * @see cn.com.flaginfo.ws.Sms#Report
     * @param report4

     */


    public org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReportResponse Report(

        org.util.smsone.cn.com.flaginfo.ws.SmsStub.Report report4)


        throws java.rmi.RemoteException

    {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient =
                _serviceClient.createClient(_operations[2].getName());
            _operationClient.getOptions().setAction("\"\"");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


            addPropertyToOperationClient(_operationClient,
                                         org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                                         "&");


            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();


            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;


            env =
                toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), report4,
                           optimizeContent(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "Report")));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);


            org.apache.axis2.context.MessageContext _returnMessageContext =
                _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


            java.lang.Object object =
                fromOM(_returnEnv.getBody().getFirstElement(),
                       org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReportResponse.class,
                       getEnvelopeNamespaces(_returnEnv));


            return (org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReportResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName =
                            (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m =
                            exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] { messageClass });
                        m.invoke(ex, new java.lang.Object[] { messageObject });


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            _messageContext.getTransportOut().getSender().cleanup(_messageContext);
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see cn.com.flaginfo.ws.Sms#startReport
     * @param report4

     */
    public void startReport(

        org.util.smsone.cn.com.flaginfo.ws.SmsStub.Report report4,

        final org.util.smsone.cn.com.flaginfo.ws.SmsCallbackHandler callback)

        throws java.rmi.RemoteException {

        org.apache.axis2.client.OperationClient _operationClient =
            _serviceClient.createClient(_operations[2].getName());
        _operationClient.getOptions().setAction("\"\"");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


        addPropertyToOperationClient(_operationClient,
                                     org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                                     "&");


        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


        //Style is Doc.


        env =
            toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), report4,
                       optimizeContent(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "Report")));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    java.lang.Object object =
                        fromOM(resultEnv.getBody().getFirstElement(),
                               org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReportResponse.class,
                               getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultReport((org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReportResponse) object);

                } catch (org.apache.axis2.AxisFault e) {
                    callback.receiveErrorReport(e);
                }
            }

            public void onError(java.lang.Exception error) {
                if (error instanceof org.apache.axis2.AxisFault) {
                    org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();
                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                            //make the fault by reflection
                            try {
                                java.lang.String exceptionClassName =
                                    (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
                                java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                                java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();
                                //message class
                                java.lang.String messageClassName =
                                    (java.lang.String) faultMessageMap.get(faultElt.getQName());
                                java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                                java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                                java.lang.reflect.Method m =
                                    exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] { messageClass });
                                m.invoke(ex, new java.lang.Object[] { messageObject });


                                callback.receiveErrorReport(new java.rmi.RemoteException(ex.getMessage(), ex));
                            } catch (java.lang.ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorReport(f);
                            } catch (java.lang.ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorReport(f);
                            } catch (java.lang.NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorReport(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorReport(f);
                            } catch (java.lang.IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorReport(f);
                            } catch (java.lang.InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorReport(f);
                            } catch (org.apache.axis2.AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorReport(f);
                            }
                        } else {
                            callback.receiveErrorReport(f);
                        }
                    } else {
                        callback.receiveErrorReport(f);
                    }
                } else {
                    callback.receiveErrorReport(error);
                }
            }

            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                org.apache.axis2.AxisFault fault =
                    org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                } catch (org.apache.axis2.AxisFault axisFault) {
                    callback.receiveErrorReport(axisFault);
                }
            }
        });


        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if (_operations[2].getMessageReceiver() == null && _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[2].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);

    }

    /**
     * Auto generated method signature
     *
     * @see cn.com.flaginfo.ws.Sms#SearchSmsNum
     * @param searchSmsNumRequest6

     */


    public org.util.smsone.cn.com.flaginfo.ws.SmsStub.SearchSmsNumResponse SearchSmsNum(

        org.util.smsone.cn.com.flaginfo.ws.SmsStub.SearchSmsNumRequest searchSmsNumRequest6)


        throws java.rmi.RemoteException

    {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient =
                _serviceClient.createClient(_operations[3].getName());
            _operationClient.getOptions().setAction("\"\"");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


            addPropertyToOperationClient(_operationClient,
                                         org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                                         "&");


            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();


            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;


            env =
                toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), searchSmsNumRequest6,
                           optimizeContent(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "SearchSmsNum")));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);


            org.apache.axis2.context.MessageContext _returnMessageContext =
                _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


            java.lang.Object object =
                fromOM(_returnEnv.getBody().getFirstElement(),
                       org.util.smsone.cn.com.flaginfo.ws.SmsStub.SearchSmsNumResponse.class,
                       getEnvelopeNamespaces(_returnEnv));


            return (org.util.smsone.cn.com.flaginfo.ws.SmsStub.SearchSmsNumResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName =
                            (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m =
                            exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] { messageClass });
                        m.invoke(ex, new java.lang.Object[] { messageObject });


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            _messageContext.getTransportOut().getSender().cleanup(_messageContext);
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see cn.com.flaginfo.ws.Sms#startSearchSmsNum
     * @param searchSmsNumRequest6

     */
    public void startSearchSmsNum(

        org.util.smsone.cn.com.flaginfo.ws.SmsStub.SearchSmsNumRequest searchSmsNumRequest6,

        final org.util.smsone.cn.com.flaginfo.ws.SmsCallbackHandler callback)

        throws java.rmi.RemoteException {

        org.apache.axis2.client.OperationClient _operationClient =
            _serviceClient.createClient(_operations[3].getName());
        _operationClient.getOptions().setAction("\"\"");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


        addPropertyToOperationClient(_operationClient,
                                     org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                                     "&");


        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


        //Style is Doc.


        env =
            toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), searchSmsNumRequest6,
                       optimizeContent(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "SearchSmsNum")));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    java.lang.Object object =
                        fromOM(resultEnv.getBody().getFirstElement(),
                               org.util.smsone.cn.com.flaginfo.ws.SmsStub.SearchSmsNumResponse.class,
                               getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultSearchSmsNum((org.util.smsone.cn.com.flaginfo.ws.SmsStub.SearchSmsNumResponse) object);

                } catch (org.apache.axis2.AxisFault e) {
                    callback.receiveErrorSearchSmsNum(e);
                }
            }

            public void onError(java.lang.Exception error) {
                if (error instanceof org.apache.axis2.AxisFault) {
                    org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();
                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                            //make the fault by reflection
                            try {
                                java.lang.String exceptionClassName =
                                    (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
                                java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                                java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();
                                //message class
                                java.lang.String messageClassName =
                                    (java.lang.String) faultMessageMap.get(faultElt.getQName());
                                java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                                java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                                java.lang.reflect.Method m =
                                    exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] { messageClass });
                                m.invoke(ex, new java.lang.Object[] { messageObject });


                                callback.receiveErrorSearchSmsNum(new java.rmi.RemoteException(ex.getMessage(), ex));
                            } catch (java.lang.ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorSearchSmsNum(f);
                            } catch (java.lang.ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorSearchSmsNum(f);
                            } catch (java.lang.NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorSearchSmsNum(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorSearchSmsNum(f);
                            } catch (java.lang.IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorSearchSmsNum(f);
                            } catch (java.lang.InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorSearchSmsNum(f);
                            } catch (org.apache.axis2.AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorSearchSmsNum(f);
                            }
                        } else {
                            callback.receiveErrorSearchSmsNum(f);
                        }
                    } else {
                        callback.receiveErrorSearchSmsNum(f);
                    }
                } else {
                    callback.receiveErrorSearchSmsNum(error);
                }
            }

            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                org.apache.axis2.AxisFault fault =
                    org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                } catch (org.apache.axis2.AxisFault axisFault) {
                    callback.receiveErrorSearchSmsNum(axisFault);
                }
            }
        });


        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if (_operations[3].getMessageReceiver() == null && _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[3].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);

    }

    /**
     * Auto generated method signature
     *
     * @see cn.com.flaginfo.ws.Sms#ReplyConfirm
     * @param replyConfirmRequest8

     */


    public org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyConfirmResponse ReplyConfirm(

        org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyConfirmRequest replyConfirmRequest8)


        throws java.rmi.RemoteException

    {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient =
                _serviceClient.createClient(_operations[4].getName());
            _operationClient.getOptions().setAction("\"\"");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


            addPropertyToOperationClient(_operationClient,
                                         org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                                         "&");


            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();


            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;


            env =
                toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), replyConfirmRequest8,
                           optimizeContent(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "ReplyConfirm")));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);


            org.apache.axis2.context.MessageContext _returnMessageContext =
                _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


            java.lang.Object object =
                fromOM(_returnEnv.getBody().getFirstElement(),
                       org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyConfirmResponse.class,
                       getEnvelopeNamespaces(_returnEnv));


            return (org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyConfirmResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName =
                            (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m =
                            exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] { messageClass });
                        m.invoke(ex, new java.lang.Object[] { messageObject });


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            _messageContext.getTransportOut().getSender().cleanup(_messageContext);
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see cn.com.flaginfo.ws.Sms#startReplyConfirm
     * @param replyConfirmRequest8

     */
    public void startReplyConfirm(

        org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyConfirmRequest replyConfirmRequest8,

        final org.util.smsone.cn.com.flaginfo.ws.SmsCallbackHandler callback)

        throws java.rmi.RemoteException {

        org.apache.axis2.client.OperationClient _operationClient =
            _serviceClient.createClient(_operations[4].getName());
        _operationClient.getOptions().setAction("\"\"");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


        addPropertyToOperationClient(_operationClient,
                                     org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                                     "&");


        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


        //Style is Doc.


        env =
            toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), replyConfirmRequest8,
                       optimizeContent(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "ReplyConfirm")));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    java.lang.Object object =
                        fromOM(resultEnv.getBody().getFirstElement(),
                               org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyConfirmResponse.class,
                               getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultReplyConfirm((org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyConfirmResponse) object);

                } catch (org.apache.axis2.AxisFault e) {
                    callback.receiveErrorReplyConfirm(e);
                }
            }

            public void onError(java.lang.Exception error) {
                if (error instanceof org.apache.axis2.AxisFault) {
                    org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();
                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                            //make the fault by reflection
                            try {
                                java.lang.String exceptionClassName =
                                    (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
                                java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                                java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();
                                //message class
                                java.lang.String messageClassName =
                                    (java.lang.String) faultMessageMap.get(faultElt.getQName());
                                java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                                java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                                java.lang.reflect.Method m =
                                    exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] { messageClass });
                                m.invoke(ex, new java.lang.Object[] { messageObject });


                                callback.receiveErrorReplyConfirm(new java.rmi.RemoteException(ex.getMessage(), ex));
                            } catch (java.lang.ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorReplyConfirm(f);
                            } catch (java.lang.ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorReplyConfirm(f);
                            } catch (java.lang.NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorReplyConfirm(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorReplyConfirm(f);
                            } catch (java.lang.IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorReplyConfirm(f);
                            } catch (java.lang.InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorReplyConfirm(f);
                            } catch (org.apache.axis2.AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorReplyConfirm(f);
                            }
                        } else {
                            callback.receiveErrorReplyConfirm(f);
                        }
                    } else {
                        callback.receiveErrorReplyConfirm(f);
                    }
                } else {
                    callback.receiveErrorReplyConfirm(error);
                }
            }

            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                org.apache.axis2.AxisFault fault =
                    org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                } catch (org.apache.axis2.AxisFault axisFault) {
                    callback.receiveErrorReplyConfirm(axisFault);
                }
            }
        });


        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if (_operations[4].getMessageReceiver() == null && _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[4].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);

    }

    /**
     * Auto generated method signature
     *
     * @see cn.com.flaginfo.ws.Sms#Auditing
     * @param auditingRequest10

     */


    public org.util.smsone.cn.com.flaginfo.ws.SmsStub.AuditingResponse Auditing(

        org.util.smsone.cn.com.flaginfo.ws.SmsStub.AuditingRequest auditingRequest10)


        throws java.rmi.RemoteException

    {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient =
                _serviceClient.createClient(_operations[5].getName());
            _operationClient.getOptions().setAction("\"\"");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


            addPropertyToOperationClient(_operationClient,
                                         org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                                         "&");


            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();


            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;


            env =
                toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), auditingRequest10,
                           optimizeContent(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "Auditing")));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);


            org.apache.axis2.context.MessageContext _returnMessageContext =
                _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


            java.lang.Object object =
                fromOM(_returnEnv.getBody().getFirstElement(),
                       org.util.smsone.cn.com.flaginfo.ws.SmsStub.AuditingResponse.class,
                       getEnvelopeNamespaces(_returnEnv));


            return (org.util.smsone.cn.com.flaginfo.ws.SmsStub.AuditingResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName =
                            (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m =
                            exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] { messageClass });
                        m.invoke(ex, new java.lang.Object[] { messageObject });


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            _messageContext.getTransportOut().getSender().cleanup(_messageContext);
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see cn.com.flaginfo.ws.Sms#startAuditing
     * @param auditingRequest10

     */
    public void startAuditing(

        org.util.smsone.cn.com.flaginfo.ws.SmsStub.AuditingRequest auditingRequest10,

        final org.util.smsone.cn.com.flaginfo.ws.SmsCallbackHandler callback)

        throws java.rmi.RemoteException {

        org.apache.axis2.client.OperationClient _operationClient =
            _serviceClient.createClient(_operations[5].getName());
        _operationClient.getOptions().setAction("\"\"");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


        addPropertyToOperationClient(_operationClient,
                                     org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                                     "&");


        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


        //Style is Doc.


        env =
            toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), auditingRequest10,
                       optimizeContent(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "Auditing")));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    java.lang.Object object =
                        fromOM(resultEnv.getBody().getFirstElement(),
                               org.util.smsone.cn.com.flaginfo.ws.SmsStub.AuditingResponse.class,
                               getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultAuditing((org.util.smsone.cn.com.flaginfo.ws.SmsStub.AuditingResponse) object);

                } catch (org.apache.axis2.AxisFault e) {
                    callback.receiveErrorAuditing(e);
                }
            }

            public void onError(java.lang.Exception error) {
                if (error instanceof org.apache.axis2.AxisFault) {
                    org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();
                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                            //make the fault by reflection
                            try {
                                java.lang.String exceptionClassName =
                                    (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
                                java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                                java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();
                                //message class
                                java.lang.String messageClassName =
                                    (java.lang.String) faultMessageMap.get(faultElt.getQName());
                                java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                                java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                                java.lang.reflect.Method m =
                                    exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] { messageClass });
                                m.invoke(ex, new java.lang.Object[] { messageObject });


                                callback.receiveErrorAuditing(new java.rmi.RemoteException(ex.getMessage(), ex));
                            } catch (java.lang.ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorAuditing(f);
                            } catch (java.lang.ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorAuditing(f);
                            } catch (java.lang.NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorAuditing(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorAuditing(f);
                            } catch (java.lang.IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorAuditing(f);
                            } catch (java.lang.InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorAuditing(f);
                            } catch (org.apache.axis2.AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorAuditing(f);
                            }
                        } else {
                            callback.receiveErrorAuditing(f);
                        }
                    } else {
                        callback.receiveErrorAuditing(f);
                    }
                } else {
                    callback.receiveErrorAuditing(error);
                }
            }

            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                org.apache.axis2.AxisFault fault =
                    org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                } catch (org.apache.axis2.AxisFault axisFault) {
                    callback.receiveErrorAuditing(axisFault);
                }
            }
        });


        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if (_operations[5].getMessageReceiver() == null && _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[5].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);

    }


    /**
     *  A utility method that copies the namepaces from the SOAPEnvelope
     */
    private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env) {
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
            org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
            returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
        }
        return returnMap;
    }


    private javax.xml.namespace.QName[] opNameArray = null;

    private boolean optimizeContent(javax.xml.namespace.QName opName) {


        if (opNameArray == null) {
            return false;
        }
        for (int i = 0; i < opNameArray.length; i++) {
            if (opName.equals(opNameArray[i])) {
                return true;
            }
        }
        return false;
    }
    //http://112.65.228.88:8888/sms_hb/services/Sms/

    public static class SearchSmsNumResponse implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME =
            new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "SearchSmsNumResponse", "ns1");


        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://ws.flaginfo.com.cn")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }


        /**
         * field for Result
         */


        protected java.lang.String localResult;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getResult() {
            return localResult;
        }


        /**
         * Auto generated setter method
         * @param param Result
         */
        public void setResult(java.lang.String param) {

            this.localResult = param;


        }


        /**
         * field for Number
         */


        protected java.lang.String localNumber;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getNumber() {
            return localNumber;
        }


        /**
         * Auto generated setter method
         * @param param Number
         */
        public void setNumber(java.lang.String param) {

            this.localNumber = param;


        }


        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware =
                    java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
                                                          final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {

                public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                    SearchSmsNumResponse.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException,
                                                                                                                   org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType) throws javax.xml.stream.XMLStreamException,
                                                            org.apache.axis2.databinding.ADBException {


            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://ws.flaginfo.com.cn");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":SearchSmsNumResponse", xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "SearchSmsNumResponse",
                                   xmlWriter);
                }


            }

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "result", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "result");
                }

            } else {
                xmlWriter.writeStartElement("result");
            }


            if (localResult == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localResult);

            }

            xmlWriter.writeEndElement();

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "number", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "number");
                }

            } else {
                xmlWriter.writeStartElement("number");
            }


            if (localNumber == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localNumber);

            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {


            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();


            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "result"));

            elementList.add(localResult == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localResult));

            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "number"));

            elementList.add(localNumber == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNumber));


            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(),
                                                                                        attribList.toArray());


        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static SearchSmsNumResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                SearchSmsNumResponse object = new SearchSmsNumResponse();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName =
                            reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"SearchSmsNumResponse".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (SearchSmsNumResponse) SmsStub.ExtensionMapper.getTypeObject(nsUri, type,
                                                                                                    reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "result").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setResult(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "number").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setNumber(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        } //end of factory class


    }


    public static class Report implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME =
            new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "Report", "ns1");


        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://ws.flaginfo.com.cn")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }


        /**
         * field for In0
         */


        protected java.lang.String localIn0;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIn0() {
            return localIn0;
        }


        /**
         * Auto generated setter method
         * @param param In0
         */
        public void setIn0(java.lang.String param) {

            this.localIn0 = param;


        }


        /**
         * field for In1
         */


        protected java.lang.String localIn1;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIn1() {
            return localIn1;
        }


        /**
         * Auto generated setter method
         * @param param In1
         */
        public void setIn1(java.lang.String param) {

            this.localIn1 = param;


        }


        /**
         * field for In2
         */


        protected java.lang.String localIn2;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIn2() {
            return localIn2;
        }


        /**
         * Auto generated setter method
         * @param param In2
         */
        public void setIn2(java.lang.String param) {

            this.localIn2 = param;


        }


        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware =
                    java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
                                                          final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {

                public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                    Report.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException,
                                                                                                                   org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType) throws javax.xml.stream.XMLStreamException,
                                                            org.apache.axis2.databinding.ADBException {


            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://ws.flaginfo.com.cn");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":Report", xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "Report", xmlWriter);
                }


            }

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "in0", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "in0");
                }

            } else {
                xmlWriter.writeStartElement("in0");
            }


            if (localIn0 == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localIn0);

            }

            xmlWriter.writeEndElement();

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "in1", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "in1");
                }

            } else {
                xmlWriter.writeStartElement("in1");
            }


            if (localIn1 == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localIn1);

            }

            xmlWriter.writeEndElement();

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "in2", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "in2");
                }

            } else {
                xmlWriter.writeStartElement("in2");
            }


            if (localIn2 == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localIn2);

            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {


            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();


            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in0"));

            elementList.add(localIn0 == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIn0));

            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in1"));

            elementList.add(localIn1 == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIn1));

            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in2"));

            elementList.add(localIn2 == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIn2));


            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(),
                                                                                        attribList.toArray());


        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static Report parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                Report object = new Report();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName =
                            reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"Report".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (Report) SmsStub.ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in0").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setIn0(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in1").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setIn1(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in2").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setIn2(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        } //end of factory class


    }


    public static class AuditingResponse implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME =
            new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "AuditingResponse", "ns1");


        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://ws.flaginfo.com.cn")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }


        /**
         * field for Out
         */


        protected java.lang.String localOut;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getOut() {
            return localOut;
        }


        /**
         * Auto generated setter method
         * @param param Out
         */
        public void setOut(java.lang.String param) {

            this.localOut = param;


        }


        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware =
                    java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
                                                          final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {

                public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                    AuditingResponse.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException,
                                                                                                                   org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType) throws javax.xml.stream.XMLStreamException,
                                                            org.apache.axis2.databinding.ADBException {


            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://ws.flaginfo.com.cn");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":AuditingResponse", xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "AuditingResponse",
                                   xmlWriter);
                }


            }

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "out", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "out");
                }

            } else {
                xmlWriter.writeStartElement("out");
            }


            if (localOut == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localOut);

            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {


            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();


            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "out"));

            elementList.add(localOut == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOut));


            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(),
                                                                                        attribList.toArray());


        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static AuditingResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                AuditingResponse object = new AuditingResponse();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName =
                            reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"AuditingResponse".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (AuditingResponse) SmsStub.ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "out").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setOut(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        } //end of factory class


    }


    public static class SearchSmsNumRequest implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME =
            new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "SearchSmsNumRequest", "ns1");


        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://ws.flaginfo.com.cn")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }


        /**
         * field for In0
         */


        protected java.lang.String localIn0;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIn0() {
            return localIn0;
        }


        /**
         * Auto generated setter method
         * @param param In0
         */
        public void setIn0(java.lang.String param) {

            this.localIn0 = param;


        }


        /**
         * field for In1
         */


        protected java.lang.String localIn1;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIn1() {
            return localIn1;
        }


        /**
         * Auto generated setter method
         * @param param In1
         */
        public void setIn1(java.lang.String param) {

            this.localIn1 = param;


        }


        /**
         * field for In2
         */


        protected java.lang.String localIn2;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIn2() {
            return localIn2;
        }


        /**
         * Auto generated setter method
         * @param param In2
         */
        public void setIn2(java.lang.String param) {

            this.localIn2 = param;


        }


        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware =
                    java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
                                                          final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {

                public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                    SearchSmsNumRequest.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException,
                                                                                                                   org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType) throws javax.xml.stream.XMLStreamException,
                                                            org.apache.axis2.databinding.ADBException {


            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://ws.flaginfo.com.cn");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":SearchSmsNumRequest", xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "SearchSmsNumRequest",
                                   xmlWriter);
                }


            }

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "in0", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "in0");
                }

            } else {
                xmlWriter.writeStartElement("in0");
            }


            if (localIn0 == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localIn0);

            }

            xmlWriter.writeEndElement();

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "in1", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "in1");
                }

            } else {
                xmlWriter.writeStartElement("in1");
            }


            if (localIn1 == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localIn1);

            }

            xmlWriter.writeEndElement();

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "in2", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "in2");
                }

            } else {
                xmlWriter.writeStartElement("in2");
            }


            if (localIn2 == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localIn2);

            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {


            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();


            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in0"));

            elementList.add(localIn0 == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIn0));

            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in1"));

            elementList.add(localIn1 == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIn1));

            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in2"));

            elementList.add(localIn2 == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIn2));


            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(),
                                                                                        attribList.toArray());


        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static SearchSmsNumRequest parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                SearchSmsNumRequest object = new SearchSmsNumRequest();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName =
                            reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"SearchSmsNumRequest".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (SearchSmsNumRequest) SmsStub.ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in0").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setIn0(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in1").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setIn1(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in2").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setIn2(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        } //end of factory class


    }


    public static class ReplyConfirmRequest implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME =
            new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "ReplyConfirmRequest", "ns1");


        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://ws.flaginfo.com.cn")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }


        /**
         * field for In0
         */


        protected java.lang.String localIn0;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIn0() {
            return localIn0;
        }


        /**
         * Auto generated setter method
         * @param param In0
         */
        public void setIn0(java.lang.String param) {

            this.localIn0 = param;


        }


        /**
         * field for In1
         */


        protected java.lang.String localIn1;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIn1() {
            return localIn1;
        }


        /**
         * Auto generated setter method
         * @param param In1
         */
        public void setIn1(java.lang.String param) {

            this.localIn1 = param;


        }


        /**
         * field for In2
         */


        protected java.lang.String localIn2;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIn2() {
            return localIn2;
        }


        /**
         * Auto generated setter method
         * @param param In2
         */
        public void setIn2(java.lang.String param) {

            this.localIn2 = param;


        }


        /**
         * field for In3
         */


        protected java.lang.String localIn3;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIn3() {
            return localIn3;
        }


        /**
         * Auto generated setter method
         * @param param In3
         */
        public void setIn3(java.lang.String param) {

            this.localIn3 = param;


        }


        /**
         * field for In4
         */


        protected java.lang.String localIn4;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localIn4Tracker = false;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIn4() {
            return localIn4;
        }


        /**
         * Auto generated setter method
         * @param param In4
         */
        public void setIn4(java.lang.String param) {

            if (param != null) {
                //update the setting tracker
                localIn4Tracker = true;
            } else {
                localIn4Tracker = true;

            }

            this.localIn4 = param;


        }


        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware =
                    java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
                                                          final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {

                public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                    ReplyConfirmRequest.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException,
                                                                                                                   org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType) throws javax.xml.stream.XMLStreamException,
                                                            org.apache.axis2.databinding.ADBException {


            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://ws.flaginfo.com.cn");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":ReplyConfirmRequest", xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "ReplyConfirmRequest",
                                   xmlWriter);
                }


            }

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "in0", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "in0");
                }

            } else {
                xmlWriter.writeStartElement("in0");
            }


            if (localIn0 == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localIn0);

            }

            xmlWriter.writeEndElement();

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "in1", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "in1");
                }

            } else {
                xmlWriter.writeStartElement("in1");
            }


            if (localIn1 == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localIn1);

            }

            xmlWriter.writeEndElement();

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "in2", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "in2");
                }

            } else {
                xmlWriter.writeStartElement("in2");
            }


            if (localIn2 == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localIn2);

            }

            xmlWriter.writeEndElement();

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "in3", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "in3");
                }

            } else {
                xmlWriter.writeStartElement("in3");
            }


            if (localIn3 == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localIn3);

            }

            xmlWriter.writeEndElement();
            if (localIn4Tracker) {
                namespace = "http://ws.flaginfo.com.cn";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "in4", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "in4");
                    }

                } else {
                    xmlWriter.writeStartElement("in4");
                }


                if (localIn4 == null) {
                    // write the nil attribute

                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

                } else {


                    xmlWriter.writeCharacters(localIn4);

                }

                xmlWriter.writeEndElement();
            }
            xmlWriter.writeEndElement();


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {


            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();


            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in0"));

            elementList.add(localIn0 == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIn0));

            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in1"));

            elementList.add(localIn1 == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIn1));

            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in2"));

            elementList.add(localIn2 == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIn2));

            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in3"));

            elementList.add(localIn3 == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIn3));
            if (localIn4Tracker) {
                elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in4"));

                elementList.add(localIn4 == null ? null :
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIn4));
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(),
                                                                                        attribList.toArray());


        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ReplyConfirmRequest parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                ReplyConfirmRequest object = new ReplyConfirmRequest();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName =
                            reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"ReplyConfirmRequest".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ReplyConfirmRequest) SmsStub.ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in0").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setIn0(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in1").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setIn1(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in2").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setIn2(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in3").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setIn3(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in4").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setIn4(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        } //end of factory class


    }


    public static class SmsResponse implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME =
            new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "SmsResponse", "ns1");


        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://ws.flaginfo.com.cn")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }


        /**
         * field for Out
         */


        protected java.lang.String localOut;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getOut() {
            return localOut;
        }


        /**
         * Auto generated setter method
         * @param param Out
         */
        public void setOut(java.lang.String param) {

            this.localOut = param;


        }


        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware =
                    java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
                                                          final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {

                public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                    SmsResponse.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException,
                                                                                                                   org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType) throws javax.xml.stream.XMLStreamException,
                                                            org.apache.axis2.databinding.ADBException {


            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://ws.flaginfo.com.cn");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":SmsResponse", xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "SmsResponse",
                                   xmlWriter);
                }


            }

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "out", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "out");
                }

            } else {
                xmlWriter.writeStartElement("out");
            }


            if (localOut == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localOut);

            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {


            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();


            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "out"));

            elementList.add(localOut == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOut));


            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(),
                                                                                        attribList.toArray());


        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static SmsResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                SmsResponse object = new SmsResponse();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName =
                            reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"SmsResponse".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (SmsResponse) SmsStub.ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "out").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setOut(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        } //end of factory class


    }


    public static class AuditingRequest implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME =
            new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "AuditingRequest", "ns1");


        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://ws.flaginfo.com.cn")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }


        /**
         * field for In0
         */


        protected java.lang.String localIn0;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIn0() {
            return localIn0;
        }


        /**
         * Auto generated setter method
         * @param param In0
         */
        public void setIn0(java.lang.String param) {

            this.localIn0 = param;


        }


        /**
         * field for In1
         */


        protected java.lang.String localIn1;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIn1() {
            return localIn1;
        }


        /**
         * Auto generated setter method
         * @param param In1
         */
        public void setIn1(java.lang.String param) {

            this.localIn1 = param;


        }


        /**
         * field for In2
         */


        protected java.lang.String localIn2;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIn2() {
            return localIn2;
        }


        /**
         * Auto generated setter method
         * @param param In2
         */
        public void setIn2(java.lang.String param) {

            this.localIn2 = param;


        }


        /**
         * field for In3
         */


        protected java.lang.String localIn3;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIn3() {
            return localIn3;
        }


        /**
         * Auto generated setter method
         * @param param In3
         */
        public void setIn3(java.lang.String param) {

            this.localIn3 = param;


        }


        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware =
                    java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
                                                          final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {

                public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                    AuditingRequest.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException,
                                                                                                                   org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType) throws javax.xml.stream.XMLStreamException,
                                                            org.apache.axis2.databinding.ADBException {


            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://ws.flaginfo.com.cn");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":AuditingRequest", xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "AuditingRequest",
                                   xmlWriter);
                }


            }

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "in0", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "in0");
                }

            } else {
                xmlWriter.writeStartElement("in0");
            }


            if (localIn0 == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localIn0);

            }

            xmlWriter.writeEndElement();

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "in1", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "in1");
                }

            } else {
                xmlWriter.writeStartElement("in1");
            }


            if (localIn1 == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localIn1);

            }

            xmlWriter.writeEndElement();

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "in2", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "in2");
                }

            } else {
                xmlWriter.writeStartElement("in2");
            }


            if (localIn2 == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localIn2);

            }

            xmlWriter.writeEndElement();

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "in3", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "in3");
                }

            } else {
                xmlWriter.writeStartElement("in3");
            }


            if (localIn3 == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localIn3);

            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {


            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();


            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in0"));

            elementList.add(localIn0 == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIn0));

            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in1"));

            elementList.add(localIn1 == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIn1));

            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in2"));

            elementList.add(localIn2 == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIn2));

            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in3"));

            elementList.add(localIn3 == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIn3));


            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(),
                                                                                        attribList.toArray());


        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static AuditingRequest parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                AuditingRequest object = new AuditingRequest();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName =
                            reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"AuditingRequest".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (AuditingRequest) SmsStub.ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in0").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setIn0(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in1").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setIn1(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in2").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setIn2(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in3").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setIn3(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        } //end of factory class


    }


    public static class ReplyResponse implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME =
            new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "ReplyResponse", "ns1");


        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://ws.flaginfo.com.cn")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }


        /**
         * field for Result
         */


        protected java.lang.String localResult;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getResult() {
            return localResult;
        }


        /**
         * Auto generated setter method
         * @param param Result
         */
        public void setResult(java.lang.String param) {

            this.localResult = param;


        }


        /**
         * field for Confirm_time
         */


        protected java.lang.String localConfirm_time;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localConfirm_timeTracker = false;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getConfirm_time() {
            return localConfirm_time;
        }


        /**
         * Auto generated setter method
         * @param param Confirm_time
         */
        public void setConfirm_time(java.lang.String param) {

            if (param != null) {
                //update the setting tracker
                localConfirm_timeTracker = true;
            } else {
                localConfirm_timeTracker = true;

            }

            this.localConfirm_time = param;


        }


        /**
         * field for Id
         */


        protected java.lang.String localId;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localIdTracker = false;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getId() {
            return localId;
        }


        /**
         * Auto generated setter method
         * @param param Id
         */
        public void setId(java.lang.String param) {

            if (param != null) {
                //update the setting tracker
                localIdTracker = true;
            } else {
                localIdTracker = true;

            }

            this.localId = param;


        }


        /**
         * field for Replys
         * This was an Array!
         */


        protected Reply[] localReplys;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localReplysTracker = false;


        /**
         * Auto generated getter method
         * @return Reply[]
         */
        public Reply[] getReplys() {
            return localReplys;
        }


        /**
         * validate the array for Replys
         */
        protected void validateReplys(Reply[] param) {

        }


        /**
         * Auto generated setter method
         * @param param Replys
         */
        public void setReplys(Reply[] param) {

            validateReplys(param);


            if (param != null) {
                //update the setting tracker
                localReplysTracker = true;
            } else {
                localReplysTracker = true;

            }

            this.localReplys = param;
        }


        /**
         * Auto generated add method for the array for convenience
         * @param param Reply
         */
        public void addReplys(Reply param) {
            if (localReplys == null) {
                localReplys = new Reply[] { };
            }


            //update the setting tracker
            localReplysTracker = true;


            java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localReplys);
            list.add(param);
            this.localReplys = (Reply[]) list.toArray(new Reply[list.size()]);

        }


        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware =
                    java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
                                                          final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {

                public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                    ReplyResponse.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException,
                                                                                                                   org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType) throws javax.xml.stream.XMLStreamException,
                                                            org.apache.axis2.databinding.ADBException {


            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://ws.flaginfo.com.cn");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":ReplyResponse", xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "ReplyResponse",
                                   xmlWriter);
                }


            }

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "result", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "result");
                }

            } else {
                xmlWriter.writeStartElement("result");
            }


            if (localResult == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localResult);

            }

            xmlWriter.writeEndElement();
            if (localConfirm_timeTracker) {
                namespace = "http://ws.flaginfo.com.cn";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "confirm_time", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "confirm_time");
                    }

                } else {
                    xmlWriter.writeStartElement("confirm_time");
                }


                if (localConfirm_time == null) {
                    // write the nil attribute

                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

                } else {


                    xmlWriter.writeCharacters(localConfirm_time);

                }

                xmlWriter.writeEndElement();
            }
            if (localIdTracker) {
                namespace = "http://ws.flaginfo.com.cn";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "id", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "id");
                    }

                } else {
                    xmlWriter.writeStartElement("id");
                }


                if (localId == null) {
                    // write the nil attribute

                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

                } else {


                    xmlWriter.writeCharacters(localId);

                }

                xmlWriter.writeEndElement();
            }
            if (localReplysTracker) {
                if (localReplys != null) {
                    for (int i = 0; i < localReplys.length; i++) {
                        if (localReplys[i] != null) {
                            localReplys[i].serialize(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn",
                                                                                   "replys"), factory, xmlWriter);
                        } else {

                            // write null attribute
                            java.lang.String namespace2 = "http://ws.flaginfo.com.cn";
                            if (!namespace2.equals("")) {
                                java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                if (prefix2 == null) {
                                    prefix2 = generatePrefix(namespace2);

                                    xmlWriter.writeStartElement(prefix2, "replys", namespace2);
                                    xmlWriter.writeNamespace(prefix2, namespace2);
                                    xmlWriter.setPrefix(prefix2, namespace2);

                                } else {
                                    xmlWriter.writeStartElement(namespace2, "replys");
                                }

                            } else {
                                xmlWriter.writeStartElement("replys");
                            }

                            // write the nil attribute
                            writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                            xmlWriter.writeEndElement();

                        }

                    }
                } else {

                    // write null attribute
                    java.lang.String namespace2 = "http://ws.flaginfo.com.cn";
                    if (!namespace2.equals("")) {
                        java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                        if (prefix2 == null) {
                            prefix2 = generatePrefix(namespace2);

                            xmlWriter.writeStartElement(prefix2, "replys", namespace2);
                            xmlWriter.writeNamespace(prefix2, namespace2);
                            xmlWriter.setPrefix(prefix2, namespace2);

                        } else {
                            xmlWriter.writeStartElement(namespace2, "replys");
                        }

                    } else {
                        xmlWriter.writeStartElement("replys");
                    }

                    // write the nil attribute
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                    xmlWriter.writeEndElement();

                }
            }
            xmlWriter.writeEndElement();


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {


            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();


            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "result"));

            elementList.add(localResult == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localResult));
            if (localConfirm_timeTracker) {
                elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "confirm_time"));

                elementList.add(localConfirm_time == null ? null :
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localConfirm_time));
            }
            if (localIdTracker) {
                elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "id"));

                elementList.add(localId == null ? null :
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localId));
            }
            if (localReplysTracker) {
                if (localReplys != null) {
                    for (int i = 0; i < localReplys.length; i++) {

                        if (localReplys[i] != null) {
                            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "replys"));
                            elementList.add(localReplys[i]);
                        } else {

                            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "replys"));
                            elementList.add(null);

                        }

                    }
                } else {

                    elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "replys"));
                    elementList.add(localReplys);

                }

            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(),
                                                                                        attribList.toArray());


        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ReplyResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                ReplyResponse object = new ReplyResponse();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName =
                            reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"ReplyResponse".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ReplyResponse) SmsStub.ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();

                    java.util.ArrayList list4 = new java.util.ArrayList();


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "result").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setResult(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn",
                                                      "confirm_time").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setConfirm_time(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "id").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setId(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "replys").equals(reader.getName())) {


                        // Process the array and step past its final element's end.

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            list4.add(null);
                            reader.next();
                        } else {
                            list4.add(org.util.smsone.cn.com.flaginfo.ws.SmsStub.Reply.Factory.parse(reader));
                        }
                        //loop until we find a start element that is not part of this array
                        boolean loopDone4 = false;
                        while (!loopDone4) {
                            // We should be at the end element, but make sure
                            while (!reader.isEndElement())
                                reader.next();
                            // Step out of this element
                            reader.next();
                            // Step to next element event.
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            if (reader.isEndElement()) {
                                //two continuous end elements means we are exiting the xml structure
                                loopDone4 = true;
                            } else {
                                if (new javax.xml.namespace.QName("http://ws.flaginfo.com.cn",
                                                                  "replys").equals(reader.getName())) {

                                    nillableValue =
                                        reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                        list4.add(null);
                                        reader.next();
                                    } else {
                                        list4.add(org.util.smsone.cn.com.flaginfo.ws.SmsStub.Reply.Factory.parse(reader));
                                    }
                                } else {
                                    loopDone4 = true;
                                }
                            }
                        }
                        // call the converter utility  to convert and set the array

                        object.setReplys((Reply[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(Reply.class,
                                                                                                                   list4));

                    } // End of if for expected property start element

                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        } //end of factory class


    }


    public static class ExtensionMapper {

        public static java.lang.Object getTypeObject(java.lang.String namespaceURI, java.lang.String typeName,
                                                     javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {


            if ("http://ws.flaginfo.com.cn".equals(namespaceURI) && "Reply".equals(typeName)) {

                return org.util.smsone.cn.com.flaginfo.ws.SmsStub.Reply.Factory.parse(reader);


            }


            throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
        }

    }

    public static class ReplyConfirmResponse implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME =
            new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "ReplyConfirmResponse", "ns1");


        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://ws.flaginfo.com.cn")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }


        /**
         * field for Result
         */


        protected java.lang.String localResult;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getResult() {
            return localResult;
        }


        /**
         * Auto generated setter method
         * @param param Result
         */
        public void setResult(java.lang.String param) {

            this.localResult = param;


        }


        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware =
                    java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
                                                          final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {

                public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                    ReplyConfirmResponse.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException,
                                                                                                                   org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType) throws javax.xml.stream.XMLStreamException,
                                                            org.apache.axis2.databinding.ADBException {


            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://ws.flaginfo.com.cn");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":ReplyConfirmResponse", xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "ReplyConfirmResponse",
                                   xmlWriter);
                }


            }

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "result", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "result");
                }

            } else {
                xmlWriter.writeStartElement("result");
            }


            if (localResult == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localResult);

            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {


            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();


            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "result"));

            elementList.add(localResult == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localResult));


            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(),
                                                                                        attribList.toArray());


        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ReplyConfirmResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                ReplyConfirmResponse object = new ReplyConfirmResponse();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName =
                            reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"ReplyConfirmResponse".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ReplyConfirmResponse) SmsStub.ExtensionMapper.getTypeObject(nsUri, type,
                                                                                                    reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "result").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setResult(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        } //end of factory class


    }


    public static class ReplyRequest implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME =
            new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "ReplyRequest", "ns1");


        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://ws.flaginfo.com.cn")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }


        /**
         * field for In0
         */


        protected java.lang.String localIn0;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIn0() {
            return localIn0;
        }


        /**
         * Auto generated setter method
         * @param param In0
         */
        public void setIn0(java.lang.String param) {

            this.localIn0 = param;


        }


        /**
         * field for In1
         */


        protected java.lang.String localIn1;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIn1() {
            return localIn1;
        }


        /**
         * Auto generated setter method
         * @param param In1
         */
        public void setIn1(java.lang.String param) {

            this.localIn1 = param;


        }


        /**
         * field for In2
         */


        protected java.lang.String localIn2;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIn2() {
            return localIn2;
        }


        /**
         * Auto generated setter method
         * @param param In2
         */
        public void setIn2(java.lang.String param) {

            this.localIn2 = param;


        }


        /**
         * field for In3
         */


        protected java.lang.String localIn3;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localIn3Tracker = false;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIn3() {
            return localIn3;
        }


        /**
         * Auto generated setter method
         * @param param In3
         */
        public void setIn3(java.lang.String param) {

            if (param != null) {
                //update the setting tracker
                localIn3Tracker = true;
            } else {
                localIn3Tracker = true;

            }

            this.localIn3 = param;


        }


        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware =
                    java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
                                                          final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {

                public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                    ReplyRequest.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException,
                                                                                                                   org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType) throws javax.xml.stream.XMLStreamException,
                                                            org.apache.axis2.databinding.ADBException {


            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://ws.flaginfo.com.cn");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":ReplyRequest", xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "ReplyRequest",
                                   xmlWriter);
                }


            }

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "in0", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "in0");
                }

            } else {
                xmlWriter.writeStartElement("in0");
            }


            if (localIn0 == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localIn0);

            }

            xmlWriter.writeEndElement();

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "in1", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "in1");
                }

            } else {
                xmlWriter.writeStartElement("in1");
            }


            if (localIn1 == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localIn1);

            }

            xmlWriter.writeEndElement();

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "in2", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "in2");
                }

            } else {
                xmlWriter.writeStartElement("in2");
            }


            if (localIn2 == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localIn2);

            }

            xmlWriter.writeEndElement();
            if (localIn3Tracker) {
                namespace = "http://ws.flaginfo.com.cn";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "in3", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "in3");
                    }

                } else {
                    xmlWriter.writeStartElement("in3");
                }


                if (localIn3 == null) {
                    // write the nil attribute

                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

                } else {


                    xmlWriter.writeCharacters(localIn3);

                }

                xmlWriter.writeEndElement();
            }
            xmlWriter.writeEndElement();


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {


            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();


            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in0"));

            elementList.add(localIn0 == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIn0));

            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in1"));

            elementList.add(localIn1 == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIn1));

            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in2"));

            elementList.add(localIn2 == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIn2));
            if (localIn3Tracker) {
                elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in3"));

                elementList.add(localIn3 == null ? null :
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIn3));
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(),
                                                                                        attribList.toArray());


        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ReplyRequest parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                ReplyRequest object = new ReplyRequest();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName =
                            reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"ReplyRequest".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ReplyRequest) SmsStub.ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in0").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setIn0(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in1").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setIn1(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in2").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setIn2(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in3").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setIn3(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        } //end of factory class


    }


    public static class Sms implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME =
            new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "Sms", "ns1");


        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://ws.flaginfo.com.cn")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }


        /**
         * field for In0
         */


        protected java.lang.String localIn0;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIn0() {
            return localIn0;
        }


        /**
         * Auto generated setter method
         * @param param In0
         */
        public void setIn0(java.lang.String param) {

            this.localIn0 = param;


        }


        /**
         * field for In1
         */


        protected java.lang.String localIn1;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIn1() {
            return localIn1;
        }


        /**
         * Auto generated setter method
         * @param param In1
         */
        public void setIn1(java.lang.String param) {

            this.localIn1 = param;


        }


        /**
         * field for In2
         */


        protected java.lang.String localIn2;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIn2() {
            return localIn2;
        }


        /**
         * Auto generated setter method
         * @param param In2
         */
        public void setIn2(java.lang.String param) {

            this.localIn2 = param;


        }


        /**
         * field for In3
         */


        protected java.lang.String localIn3;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIn3() {
            return localIn3;
        }


        /**
         * Auto generated setter method
         * @param param In3
         */
        public void setIn3(java.lang.String param) {

            this.localIn3 = param;


        }


        /**
         * field for In4
         */


        protected java.lang.String localIn4;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIn4() {
            return localIn4;
        }


        /**
         * Auto generated setter method
         * @param param In4
         */
        public void setIn4(java.lang.String param) {

            this.localIn4 = param;


        }


        /**
         * field for In5
         */


        protected java.lang.String localIn5;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIn5() {
            return localIn5;
        }


        /**
         * Auto generated setter method
         * @param param In5
         */
        public void setIn5(java.lang.String param) {

            this.localIn5 = param;


        }


        /**
         * field for In6
         */


        protected java.lang.String localIn6;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIn6() {
            return localIn6;
        }


        /**
         * Auto generated setter method
         * @param param In6
         */
        public void setIn6(java.lang.String param) {

            this.localIn6 = param;


        }


        /**
         * field for In7
         */


        protected java.lang.String localIn7;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIn7() {
            return localIn7;
        }


        /**
         * Auto generated setter method
         * @param param In7
         */
        public void setIn7(java.lang.String param) {

            this.localIn7 = param;


        }


        /**
         * field for In8
         */


        protected java.lang.String localIn8;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIn8() {
            return localIn8;
        }


        /**
         * Auto generated setter method
         * @param param In8
         */
        public void setIn8(java.lang.String param) {

            this.localIn8 = param;


        }


        /**
         * field for In9
         */


        protected java.lang.String localIn9;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localIn9Tracker = false;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIn9() {
            return localIn9;
        }


        /**
         * Auto generated setter method
         * @param param In9
         */
        public void setIn9(java.lang.String param) {

            if (param != null) {
                //update the setting tracker
                localIn9Tracker = true;
            } else {
                localIn9Tracker = true;

            }

            this.localIn9 = param;


        }


        /**
         * field for In10
         */


        protected java.lang.String localIn10;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localIn10Tracker = false;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIn10() {
            return localIn10;
        }


        /**
         * Auto generated setter method
         * @param param In10
         */
        public void setIn10(java.lang.String param) {

            if (param != null) {
                //update the setting tracker
                localIn10Tracker = true;
            } else {
                localIn10Tracker = true;

            }

            this.localIn10 = param;


        }


        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware =
                    java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
                                                          final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {

                public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                    Sms.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException,
                                                                                                                   org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType) throws javax.xml.stream.XMLStreamException,
                                                            org.apache.axis2.databinding.ADBException {


            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://ws.flaginfo.com.cn");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":Sms",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "Sms", xmlWriter);
                }


            }

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "in0", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "in0");
                }

            } else {
                xmlWriter.writeStartElement("in0");
            }


            if (localIn0 == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localIn0);

            }

            xmlWriter.writeEndElement();

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "in1", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "in1");
                }

            } else {
                xmlWriter.writeStartElement("in1");
            }


            if (localIn1 == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localIn1);

            }

            xmlWriter.writeEndElement();

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "in2", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "in2");
                }

            } else {
                xmlWriter.writeStartElement("in2");
            }


            if (localIn2 == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localIn2);

            }

            xmlWriter.writeEndElement();

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "in3", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "in3");
                }

            } else {
                xmlWriter.writeStartElement("in3");
            }


            if (localIn3 == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localIn3);

            }

            xmlWriter.writeEndElement();

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "in4", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "in4");
                }

            } else {
                xmlWriter.writeStartElement("in4");
            }


            if (localIn4 == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localIn4);

            }

            xmlWriter.writeEndElement();

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "in5", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "in5");
                }

            } else {
                xmlWriter.writeStartElement("in5");
            }


            if (localIn5 == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localIn5);

            }

            xmlWriter.writeEndElement();

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "in6", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "in6");
                }

            } else {
                xmlWriter.writeStartElement("in6");
            }


            if (localIn6 == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localIn6);

            }

            xmlWriter.writeEndElement();

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "in7", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "in7");
                }

            } else {
                xmlWriter.writeStartElement("in7");
            }


            if (localIn7 == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localIn7);

            }

            xmlWriter.writeEndElement();

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "in8", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "in8");
                }

            } else {
                xmlWriter.writeStartElement("in8");
            }


            if (localIn8 == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localIn8);

            }

            xmlWriter.writeEndElement();
            if (localIn9Tracker) {
                namespace = "http://ws.flaginfo.com.cn";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "in9", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "in9");
                    }

                } else {
                    xmlWriter.writeStartElement("in9");
                }


                if (localIn9 == null) {
                    // write the nil attribute

                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

                } else {


                    xmlWriter.writeCharacters(localIn9);

                }

                xmlWriter.writeEndElement();
            }
            if (localIn10Tracker) {
                namespace = "http://ws.flaginfo.com.cn";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "in10", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "in10");
                    }

                } else {
                    xmlWriter.writeStartElement("in10");
                }


                if (localIn10 == null) {
                    // write the nil attribute

                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

                } else {


                    xmlWriter.writeCharacters(localIn10);

                }

                xmlWriter.writeEndElement();
            }
            xmlWriter.writeEndElement();


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {


            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();


            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in0"));

            elementList.add(localIn0 == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIn0));

            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in1"));

            elementList.add(localIn1 == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIn1));

            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in2"));

            elementList.add(localIn2 == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIn2));

            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in3"));

            elementList.add(localIn3 == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIn3));

            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in4"));

            elementList.add(localIn4 == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIn4));

            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in5"));

            elementList.add(localIn5 == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIn5));

            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in6"));

            elementList.add(localIn6 == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIn6));

            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in7"));

            elementList.add(localIn7 == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIn7));

            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in8"));

            elementList.add(localIn8 == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIn8));
            if (localIn9Tracker) {
                elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in9"));

                elementList.add(localIn9 == null ? null :
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIn9));
            }
            if (localIn10Tracker) {
                elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in10"));

                elementList.add(localIn10 == null ? null :
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIn10));
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(),
                                                                                        attribList.toArray());


        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static Sms parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                Sms object = new Sms();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName =
                            reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"Sms".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (Sms) SmsStub.ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in0").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setIn0(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in1").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setIn1(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in2").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setIn2(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in3").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setIn3(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in4").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setIn4(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in5").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setIn5(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in6").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setIn6(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in7").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setIn7(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in8").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setIn8(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in9").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setIn9(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "in10").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setIn10(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        } //end of factory class


    }


    public static class ReportResponse implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME =
            new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "ReportResponse", "ns1");


        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://ws.flaginfo.com.cn")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }


        /**
         * field for Out
         */


        protected java.lang.String localOut;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getOut() {
            return localOut;
        }


        /**
         * Auto generated setter method
         * @param param Out
         */
        public void setOut(java.lang.String param) {

            this.localOut = param;


        }


        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware =
                    java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
                                                          final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {

                public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                    ReportResponse.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException,
                                                                                                                   org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType) throws javax.xml.stream.XMLStreamException,
                                                            org.apache.axis2.databinding.ADBException {


            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://ws.flaginfo.com.cn");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":ReportResponse", xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "ReportResponse",
                                   xmlWriter);
                }


            }

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "out", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "out");
                }

            } else {
                xmlWriter.writeStartElement("out");
            }


            if (localOut == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localOut);

            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {


            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();


            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "out"));

            elementList.add(localOut == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOut));


            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(),
                                                                                        attribList.toArray());


        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ReportResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                ReportResponse object = new ReportResponse();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName =
                            reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"ReportResponse".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ReportResponse) SmsStub.ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "out").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setOut(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        } //end of factory class


    }


    public static class Reply implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
                name = Reply
                Namespace URI = http://ws.flaginfo.com.cn
                Namespace Prefix = ns1
                */


        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://ws.flaginfo.com.cn")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }


        /**
         * field for CallMdn
         */


        protected java.lang.String localCallMdn;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getCallMdn() {
            return localCallMdn;
        }


        /**
         * Auto generated setter method
         * @param param CallMdn
         */
        public void setCallMdn(java.lang.String param) {

            this.localCallMdn = param;


        }


        /**
         * field for Mdn
         */


        protected java.lang.String localMdn;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getMdn() {
            return localMdn;
        }


        /**
         * Auto generated setter method
         * @param param Mdn
         */
        public void setMdn(java.lang.String param) {

            this.localMdn = param;


        }


        /**
         * field for Content
         */


        protected java.lang.String localContent;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getContent() {
            return localContent;
        }


        /**
         * Auto generated setter method
         * @param param Content
         */
        public void setContent(java.lang.String param) {

            this.localContent = param;


        }


        /**
         * field for Reply_time
         */


        protected java.lang.String localReply_time;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getReply_time() {
            return localReply_time;
        }


        /**
         * Auto generated setter method
         * @param param Reply_time
         */
        public void setReply_time(java.lang.String param) {

            this.localReply_time = param;


        }


        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware =
                    java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
                                                          final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                new org.apache.axis2.databinding.ADBDataSource(this, parentQName) {

                    public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                        Reply.this.serialize(parentQName, factory, xmlWriter);
                    }
                };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(parentQName, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException,
                                                                                                                   org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType) throws javax.xml.stream.XMLStreamException,
                                                            org.apache.axis2.databinding.ADBException {


            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://ws.flaginfo.com.cn");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":Reply", xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "Reply", xmlWriter);
                }


            }

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "callMdn", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "callMdn");
                }

            } else {
                xmlWriter.writeStartElement("callMdn");
            }


            if (localCallMdn == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localCallMdn);

            }

            xmlWriter.writeEndElement();

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "mdn", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "mdn");
                }

            } else {
                xmlWriter.writeStartElement("mdn");
            }


            if (localMdn == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localMdn);

            }

            xmlWriter.writeEndElement();

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "content", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "content");
                }

            } else {
                xmlWriter.writeStartElement("content");
            }


            if (localContent == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localContent);

            }

            xmlWriter.writeEndElement();

            namespace = "http://ws.flaginfo.com.cn";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "reply_time", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "reply_time");
                }

            } else {
                xmlWriter.writeStartElement("reply_time");
            }


            if (localReply_time == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localReply_time);

            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {


            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();


            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "callMdn"));

            elementList.add(localCallMdn == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCallMdn));

            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "mdn"));

            elementList.add(localMdn == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMdn));

            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "content"));

            elementList.add(localContent == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localContent));

            elementList.add(new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "reply_time"));

            elementList.add(localReply_time == null ? null :
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localReply_time));


            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(),
                                                                                        attribList.toArray());


        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static Reply parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                Reply object = new Reply();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName =
                            reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"Reply".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (Reply) SmsStub.ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn",
                                                      "callMdn").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setCallMdn(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn", "mdn").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setMdn(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn",
                                                      "content").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setContent(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://ws.flaginfo.com.cn",
                                                      "reply_time").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setReply_time(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getLocalName());


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        } //end of factory class


    }


    private org.apache.axiom.om.OMElement toOM(org.util.smsone.cn.com.flaginfo.ws.SmsStub.Sms param,
                                               boolean optimizeContent) throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(org.util.smsone.cn.com.flaginfo.ws.SmsStub.Sms.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(org.util.smsone.cn.com.flaginfo.ws.SmsStub.SmsResponse param,
                                               boolean optimizeContent) throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(org.util.smsone.cn.com.flaginfo.ws.SmsStub.SmsResponse.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyRequest param,
                                               boolean optimizeContent) throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyRequest.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyResponse param,
                                               boolean optimizeContent) throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyResponse.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(org.util.smsone.cn.com.flaginfo.ws.SmsStub.Report param,
                                               boolean optimizeContent) throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(org.util.smsone.cn.com.flaginfo.ws.SmsStub.Report.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReportResponse param,
                                               boolean optimizeContent) throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReportResponse.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(org.util.smsone.cn.com.flaginfo.ws.SmsStub.SearchSmsNumRequest param,
                                               boolean optimizeContent) throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(org.util.smsone.cn.com.flaginfo.ws.SmsStub.SearchSmsNumRequest.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(org.util.smsone.cn.com.flaginfo.ws.SmsStub.SearchSmsNumResponse param,
                                               boolean optimizeContent) throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(org.util.smsone.cn.com.flaginfo.ws.SmsStub.SearchSmsNumResponse.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyConfirmRequest param,
                                               boolean optimizeContent) throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyConfirmRequest.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyConfirmResponse param,
                                               boolean optimizeContent) throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyConfirmResponse.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(org.util.smsone.cn.com.flaginfo.ws.SmsStub.AuditingRequest param,
                                               boolean optimizeContent) throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(org.util.smsone.cn.com.flaginfo.ws.SmsStub.AuditingRequest.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(org.util.smsone.cn.com.flaginfo.ws.SmsStub.AuditingResponse param,
                                               boolean optimizeContent) throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(org.util.smsone.cn.com.flaginfo.ws.SmsStub.AuditingResponse.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }


    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.util.smsone.cn.com.flaginfo.ws.SmsStub.Sms param,
                                                          boolean optimizeContent) throws org.apache.axis2.AxisFault {


        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(org.util.smsone.cn.com.flaginfo.ws.SmsStub.Sms.MY_QNAME,
                                                                factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }


    /* methods to provide back word compatibility */


    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyRequest param,
                                                          boolean optimizeContent) throws org.apache.axis2.AxisFault {


        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyRequest.MY_QNAME,
                                                                factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }


    /* methods to provide back word compatibility */


    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.util.smsone.cn.com.flaginfo.ws.SmsStub.Report param,
                                                          boolean optimizeContent) throws org.apache.axis2.AxisFault {


        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(org.util.smsone.cn.com.flaginfo.ws.SmsStub.Report.MY_QNAME,
                                                                factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }


    /* methods to provide back word compatibility */


    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.util.smsone.cn.com.flaginfo.ws.SmsStub.SearchSmsNumRequest param,
                                                          boolean optimizeContent) throws org.apache.axis2.AxisFault {


        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(org.util.smsone.cn.com.flaginfo.ws.SmsStub.SearchSmsNumRequest.MY_QNAME,
                                                                factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }


    /* methods to provide back word compatibility */


    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyConfirmRequest param,
                                                          boolean optimizeContent) throws org.apache.axis2.AxisFault {


        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyConfirmRequest.MY_QNAME,
                                                                factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }


    /* methods to provide back word compatibility */


    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.util.smsone.cn.com.flaginfo.ws.SmsStub.AuditingRequest param,
                                                          boolean optimizeContent) throws org.apache.axis2.AxisFault {


        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(org.util.smsone.cn.com.flaginfo.ws.SmsStub.AuditingRequest.MY_QNAME,
                                                                factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }


    /* methods to provide back word compatibility */


    /**
     *  get the default envelope
     */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }


    private java.lang.Object fromOM(org.apache.axiom.om.OMElement param, java.lang.Class type,
                                    java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault {

        try {

            if (org.util.smsone.cn.com.flaginfo.ws.SmsStub.Sms.class.equals(type)) {

                return org.util.smsone.cn.com.flaginfo.ws.SmsStub.Sms.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (org.util.smsone.cn.com.flaginfo.ws.SmsStub.SmsResponse.class.equals(type)) {

                return org.util.smsone.cn.com.flaginfo.ws.SmsStub.SmsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyRequest.class.equals(type)) {

                return org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyResponse.class.equals(type)) {

                return org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (org.util.smsone.cn.com.flaginfo.ws.SmsStub.Report.class.equals(type)) {

                return org.util.smsone.cn.com.flaginfo.ws.SmsStub.Report.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReportResponse.class.equals(type)) {

                return org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReportResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (org.util.smsone.cn.com.flaginfo.ws.SmsStub.SearchSmsNumRequest.class.equals(type)) {

                return org.util.smsone.cn.com.flaginfo.ws.SmsStub.SearchSmsNumRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (org.util.smsone.cn.com.flaginfo.ws.SmsStub.SearchSmsNumResponse.class.equals(type)) {

                return org.util.smsone.cn.com.flaginfo.ws.SmsStub.SearchSmsNumResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyConfirmRequest.class.equals(type)) {

                return org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyConfirmRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyConfirmResponse.class.equals(type)) {

                return org.util.smsone.cn.com.flaginfo.ws.SmsStub.ReplyConfirmResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (org.util.smsone.cn.com.flaginfo.ws.SmsStub.AuditingRequest.class.equals(type)) {

                return org.util.smsone.cn.com.flaginfo.ws.SmsStub.AuditingRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (org.util.smsone.cn.com.flaginfo.ws.SmsStub.AuditingResponse.class.equals(type)) {

                return org.util.smsone.cn.com.flaginfo.ws.SmsStub.AuditingResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
        return null;
    }


}

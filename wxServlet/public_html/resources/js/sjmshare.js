function wxConfig() {
    var param = new Object();
    param.url = location.href.split('#')[0];
    var jsonString = JSON.stringify(param)
    var url = baseAddr + "/commAjaxServlet?action=wxJsSdkConfig&param=" + encodeURIComponent(jsonString);
    console.log("param jsonString:" + jsonString);

    $.get(url, null, function (data) {
        console.log("wxJsSdkConfig return:" + data);

        var result = JSON.parse(data);
        wx.config( {
            debug : false, // ��������ģʽ,���õ�����api�ķ���ֵ���ڿͻ���alert��������Ҫ�鿴����Ĳ�����������pc�˴򿪣�������Ϣ��ͨ��log���������pc��ʱ�Ż��ӡ��
            appId : result.appId, // ������ںŵ�Ψһ��ʶ
            timestamp : result.timestamp, // �������ǩ����ʱ���
            nonceStr : result.nonceStr, // �������ǩ���������
            signature : result.signature, // ���ǩ��������¼1
            jsApiList : ['onMenuShareTimeline', 'onMenuShareAppMessage']// �����Ҫʹ�õ�JS�ӿ��б�����JS�ӿ��б����¼2
        });
        wx.ready(function () {
            wxShareConfig();
        })
        wx.error(function (res) {
            // config��Ϣ��֤ʧ�ܻ�ִ��error��������ǩ�����ڵ�����֤ʧ�ܣ�
            // ���������Ϣ���Դ�config��debugģʽ�鿴��Ҳ�����ڷ��ص�res�����в鿴��
            // ����SPA�������������ǩ����
            alert("error res=" + res);
        });
    });
}

function wxShareConfig() {
    var result;
    var queryShareInfourl = baseAddr + "/commAjaxServlet?action=queryShareInfo";
    queryShareInfourl = convertURL(queryShareInfourl);
    $.get(queryShareInfourl, null, function (data) {
        console.log("����return1:" + data);
        result = JSON.parse(data);       
        wx.onMenuShareTimeline( {
            title : shareTitle, // �������
            link : shareLink, // ��������
            imgUrl : result.shareImgUrl, // ����ͼ��
            success : function () {
                // �û�ȷ�Ϸ����ִ�еĻص���������¼����
                 shareLog('account', 2, shareTitle, shareLink);

            },
            cancel : function () {
                // �û�ȡ�������ִ�еĻص�����
                console.log("onMenuShareTimeline cancel");
            }
        });
        wx.onMenuShareAppMessage( {
            title : shareTitle, // �������
            link : shareLink, imgUrl : result.shareImgUrl, // ����ͼ��
            desc : shareDesc, // ��������       
            type : 'link', // ��������,music��video��link������Ĭ��Ϊlink           
            dataUrl : '', // ���type��music��video����Ҫ�ṩ�������ӣ�Ĭ��Ϊ��
            success : function () {
                shareLog('account', 1, shareTitle, shareLink);
            },
            cancel : function () {
                // �û�ȡ�������ִ�еĻص�����
            }
        });
    });
}
$(document).ready(function () {
    // wxShareConfig();
});
var giftId = "0";
var baseAddr = "/wx3";
//baseAddr = "/wx-service";
$(document).ready(function () {
    wxConfig();
    $("#shareit").hide();
    again();
});

function closeShare() {
    $("#shareit").hide();
}

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
    var shareInfo = new Object();
    var queryShareInfourl = baseAddr + "/commAjaxServlet?action=queryShareInfo";
    queryShareInfourl = convertURL(queryShareInfourl);
    $.get(queryShareInfourl, null, function (data) {
        console.log("����return1:" + data);
        shareInfo = JSON.parse(data);
        var sharetitle=('����"' + shareInfo.shareName + '",�γ���ͨ������' + shareInfo.allFeeGift + "Ԫ�ιο�����Ҳ������");// �������
        var shareLink="http://www.ycunicom.com/wx3/faces/shareAccount.jsf?shareName=" + shareInfo.shareName + "&imgUrl=" + shareInfo.shareImgUrl + "&qrCodeUrl=/wx-service/showqrcode&userId=" + shareInfo.shareUserId + "&allFee=" + shareInfo.allFeeGift + "&useFee=" + shareInfo.useFeeGift; // ��������
        wx.onMenuShareTimeline( {
            title : sharetitle,
            link : shareLink,
            imgUrl : shareInfo.shareImgUrl, // ����ͼ��
            success : function () {
                // �û�ȷ�Ϸ����ִ�еĻص���������¼����
                $("#again").removeClass("hide");//����ɹ�����ʾ
                $("#sharebtn").addClass("hide");//����ɹ�������
                shareLog('ggk', 2, sharetitle, shareLink);
            },
            cancel : function () {
            }
        });
        wx.onMenuShareAppMessage({
            title : '����"' + shareInfo.shareName + '",�γ���ͨ����' + shareInfo.allFeeGift + "Ԫ����Ҳ������.", // �������
            link : "http://www.ycunicom.com/wx3/faces/shareAccount.jsf?shareName=" + shareInfo.shareName + "&imgUrl=" + shareInfo.shareImgUrl + "&qrCodeUrl=/wx-service/showqrcode&userId=" + shareInfo.shareUserId + "&allFee=" + shareInfo.allFeeGift + "&useFee=" + shareInfo.useFeeGift, imgUrl : shareInfo.shareImgUrl, // ����ͼ��
            desc : '�������ڡ��γ���ͨ�����ںŲμ��˹ιο�������ε�' + shareInfo.allFeeGift + 'Ԫ���Ѿ��仰�ѣ����������ˣ�' + shareInfo.useFeeGift + 'Ԫ����Ҳ������', // ��������       
            type : '', // ��������,music��video��link������Ĭ��Ϊlink
            dataUrl : '', // ���type��music��video����Ҫ�ṩ�������ӣ�Ĭ��Ϊ��
            success : function () {
                $("#again").removeClass("hide");//����ɹ�����ʾ
                $("#sharebtn").addClass("hide");//����ɹ�������
                shareLog('ggk', 1, title, desc);
            },
            cancel : function (){
            
            }
        });
    });
}

function again() {
    $("#robot").addClass("hide");
    $("#redux").addClass("hide");
    $("#noggk").addClass("hide");
    $("#again").addClass("hide");
    $("#sharebtn").addClass("hide");
    $('#redux').eraser('reset');
    var url = baseAddr + '/commAjaxServlet?action=getGGKGift';
    $.get(url, null, function (data) {
        console.log("����222return1:" + data);
        var result = JSON.parse(data);
        if (result.error == 'noggk') {
            giftId = "0";
            $("#noggk").removeClass("hide");
            $("#redux").attr("src", "");
            $("#robot").attr("src", "");
        }
        else {
            var picurl = baseAddr + '/showGgkPicture?giftId=' + result.giftId;
            giftId = result.giftId;
            $("#robot").attr("src", picurl);
            $("#redux").attr("src", "resources/img/over.jpg");
            $("#robot").removeClass("hide");
            $("#redux").removeClass("hide");
            setTimeout(timer, 2000);
        }
    });
}
var i = 0;

function timer() {
    if (i % 10 == 0) {
        console.log("bengin id=" + giftId + " " + i);
        i++;
    }
    if (giftId != "0") {
        var progress = $('#redux').eraser('progress');
        console.log("submintggk  progress=" + progress);
        if (progress > 0.05) {
            console.log(" clear  submintggk id=" + giftId);
            $('#redux').eraser('clear');
            var json = new Object();
            json.giftid = giftId;
            var jsonString = JSON.stringify(json)
            var url = baseAddr + "/commAjaxServlet?action=submitGGK&param=" + jsonString;
            url = convertURL(url);
            $.get(url, null, function (data) {
                var result = JSON.parse(data);
                console.log("submit ggk returns reslut=" + result.congration);
                showToastInfo('#toast', result.congration);
            });
            giftId = "0";
            wxConfig();
            $("#again").addClass("hide");//��������һ��            
            console.log("hide again");
            $("#sharebtn").removeClass("hide");//��ʾ����ť            
        }
        setTimeout(timer, 1000);
    }
}

function share() {
    $("#shareit").show();
    //setTimeout(function(){$("#shareit").hide();}, 2000);
}
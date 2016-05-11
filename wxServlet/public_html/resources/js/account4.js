var giveFeeBtnUrl;
var addFeeBtnUrl;
var baseAddr = "/wx3";
//baseAddr = "/wx-service";
$(document).ready(function () {
    wxConfig();
});

function closeShare() {
    $("#shareit").hide();
}

function wxConfig() {
    var param = new Object();

    //java����Ĵ���Ϊ��
    //searchtext=java.net.URLDecoder.decode(searchtext,"UTF-8");
    //զһ������û���⣬һ��һ��ģ�Ӧ�ÿ����ˡ������ǳ��������롣
    param.url = location.href.split('#')[0];
    var jsonString = JSON.stringify(param)
    //�������α��������������̨�Զ����ǴξͿ��Ե�����һ�Σ�Ȼ����ʹ�ã�������Ҫ
    var url = baseAddr + "/commAjaxServlet?action=wxJsSdkConfig&param=" + encodeURIComponent(jsonString);
    //url=encodeURI(url);
    //url=url.replace(/\&/g,"%26");
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
        var shareLink = "http://www.ycunicom.com/wx3/faces/shareAccount.jsf?shareName=" + result.shareName + "&imgUrl=" + result.shareImgUrl + "&qrCodeUrl=/wx-service/showqrcode&userId=" + result.shareUserId + "&allFee=" + result.allFeeGift + "&useFee=" + result.useFeeGift;
        var shareTitle = ('����"' + result.shareName + '",�γ���ͨ����' + result.allFeeGift + "Ԫ����Ҳ������");
        var shareDesc = '�������ڡ��γ���ͨ�����ںŲμ��˹ιο�������ε�' + result.allFeeGift + 'Ԫ���Ѿ��仰�ѣ����������ˣ�' + result.useFeeGift + 'Ԫ����Ҳ������';

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

function shareMyAccount(event) {
    $("#shareit").show();
    setTimeout(function () {
        $("#shareit").hide();
    },
    2000);
}
$(document).ready(function () {
    //ҳ���ʼ��    
    var url = baseAddr + "/commAjaxServlet?action=queryFee";
    url = convertURL(url);
    $.get(url, null, function (data) {
        console.log("����return1:" + data);
        var result = JSON.parse(data);
        $("#feeInfo").html(result.leaveFee);
        giveFeeBtnUrl = $("#openGiveDialog").attr('href');
        addFeeBtnUrl = $("#openAddDialog").attr('href')
    });
});

function addFee(event) {
    //�򿪽ɷѶԻ���
    $('#openAddDialog').addClass('weui_btn_disabled');
    $("#openAddDialog").attr('href', '#');
    showDialog("#addFeedlg");
}

function addFeeCancel(event) {
    closeDialog("#addFeedlg");
    $('#openAddDialog').removeClass('weui_btn_disabled');
    $('#openAddDialog').attr('href', addFeeBtnUrl);
}

function giveFee(event) {
    //��ת�ͻ��ѶԻ���
    $('#openGiveDialog').addClass('weui_btn_disabled');
    $("#openGiveDialog").attr('href', '#');
    showDialog("#giveFeedlg");
}

function giveFeeCancel(event) {
    closeDialog("#giveFeedlg");
    $('#openGiveDialog').removeClass('weui_btn_disabled');
    $('#openGiveDialog').attr('href', giveFeeBtnUrl);
}

function addFeeSubmit(event) {
    console.log('addfee');
    var param = new Object();
    param.addFee = $("#addFeeCount").val()
    var jsonString = JSON.stringify(param)
    console.log('jsonString =' + jsonString);
    closeDialog("#addFeedlg");
    var url = baseAddr + "/commAjaxServlet?action=addFee&param=" + jsonString;
    url = convertURL(url);
    $('#submitAddFee').addClass('weui_btn_disabled');
    showLoading('#submitToast');
    $.get(url, null, function (data) {
        closeLoading("#submitToast");
        console.log("addFeeSubmit return:" + data);
        var result = JSON.parse(data);
        if (result.result == 'error') {
            showToastInfo('#toast', result.resultInfo);
            $('#openAddDialog').removeClass('weui_btn_disabled');
            $('#submitAddFee').addClass('weui_btn_disabled');
            $('#openAddDialog').attr('href', addFeeBtnUrl);
            return;
        }
        showToastInfo('#toast', result.resultInfo);
        $("#feeInfo").html(result.leaveFee)
        $('#openAddDialog').removeClass('weui_btn_disabled');
        $('#submitAddFee').addClass('weui_btn_disabled');
        $('#openAddDialog').attr('href', addFeeBtnUrl);
        //$('#getyzm').removeAttr("onclick"); //�Ƴ�disabled����  
    });
}

function giveFeeSubmit(event) {
    console.log('giveFee');
    var param = new Object();
    param.giveFee = $("#giveFeeCount").val();
    param.tele = $("#giveTele").val();
    var jsonString = JSON.stringify(param)
    console.log('jsonString =' + jsonString);
    var url = baseAddr + "/commAjaxServlet?action=giveFee&param=" + jsonString;
    console.log("url=" + url);
    url = convertURL(url);
    $('#submitGiveFee').addClass('weui_btn_disabled');
    closeDialog("#giveFeedlg");
    showLoading('#submitToast');
    $.get(url, null, function (data) {
        closeLoading("#submitToast");
        console.log("giveFeeSubmit:" + data);
        var result = JSON.parse(data);
        showToastInfo('#toast', result.resultInfo);
        $('#openGiveDialog').removeClass('weui_btn_disabled');
        $('#openGiveDialog').attr('href', giveFeeBtnUrl);
        if (result.result != 'error') {
            $("#feeInfo").html(result.leaveFee)
        }
    });
}

function showLoading(loadingName) {
    console.log("show toast");
    var $loadingToast = $(loadingName);
    if ($loadingToast.css('display') != 'none') {
        return;
    }
    $loadingToast.show();
}

function closeLoading(loadingName) {
    console.log("closeLoading");
    var $loadingToast = $(loadingName);
    $loadingToast.hide();
}

function showDialog(diagName) {
    var $toast = $(diagName);
    if ($toast.css('display') != 'none') {
        return;
    }
    $toast.show();
}

function closeDialog(diagName) {
    var $toast = $(diagName);
    $toast.hide();
}
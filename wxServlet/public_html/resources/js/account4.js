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

    //java处理的代码为：
    //searchtext=java.net.URLDecoder.decode(searchtext,"UTF-8");
    //咋一看觉的没问题，一编一解的，应该可以了。但还是出现了乱码。
    param.url = location.href.split('#')[0];
    var jsonString = JSON.stringify(param)
    //进行两次编码操作，这样后台自动的那次就可以抵消掉一次，然后在使用：好像不需要
    var url = baseAddr + "/commAjaxServlet?action=wxJsSdkConfig&param=" + encodeURIComponent(jsonString);
    //url=encodeURI(url);
    //url=url.replace(/\&/g,"%26");
    console.log("param jsonString:" + jsonString);

    $.get(url, null, function (data) {
        console.log("wxJsSdkConfig return:" + data);

        var result = JSON.parse(data);
        wx.config( {
            debug : false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
            appId : result.appId, // 必填，公众号的唯一标识
            timestamp : result.timestamp, // 必填，生成签名的时间戳
            nonceStr : result.nonceStr, // 必填，生成签名的随机串
            signature : result.signature, // 必填，签名，见附录1
            jsApiList : ['onMenuShareTimeline', 'onMenuShareAppMessage']// 必填，需要使用的JS接口列表，所有JS接口列表见附录2
        });
        wx.ready(function () {
            wxShareConfig();
        })
        wx.error(function (res) {
            // config信息验证失败会执行error函数，如签名过期导致验证失败，
            // 具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，
            // 对于SPA可以在这里更新签名。
            alert("error res=" + res);
        });
    });
}

function wxShareConfig() {
    var result;
    var queryShareInfourl = baseAddr + "/commAjaxServlet?action=queryShareInfo";
    queryShareInfourl = convertURL(queryShareInfourl);
    $.get(queryShareInfourl, null, function (data) {
        console.log("返回return1:" + data);
        result = JSON.parse(data);
        var shareLink = "http://www.ycunicom.com/wx3/faces/shareAccount.jsf?shareName=" + result.shareName + "&imgUrl=" + result.shareImgUrl + "&qrCodeUrl=/wx-service/showqrcode&userId=" + result.shareUserId + "&allFee=" + result.allFeeGift + "&useFee=" + result.useFeeGift;
        var shareTitle = ('我是"' + result.shareName + '",盐城联通送我' + result.allFeeGift + "元，你也来试试");
        var shareDesc = '今天我在“盐城联通”公众号参加了刮刮卡活动，共刮到' + result.allFeeGift + '元，已经充话费（含赠送他人）' + result.useFeeGift + '元，你也来试试';

        wx.onMenuShareTimeline( {
            title : shareTitle, // 分享标题
            link : shareLink, // 分享链接
            imgUrl : result.shareImgUrl, // 分享图标
            success : function () {
                // 用户确认分享后执行的回调函数，记录分享
                 shareLog('account', 2, shareTitle, shareLink);

            },
            cancel : function () {
                // 用户取消分享后执行的回调函数
                console.log("onMenuShareTimeline cancel");
            }
        });
        wx.onMenuShareAppMessage( {
            title : shareTitle, // 分享标题
            link : shareLink, imgUrl : result.shareImgUrl, // 分享图标
            desc : shareDesc, // 分享描述       
            type : 'link', // 分享类型,music、video或link，不填默认为link           
            dataUrl : '', // 如果type是music或video，则要提供数据链接，默认为空
            success : function () {
                shareLog('account', 1, shareTitle, shareLink);
            },
            cancel : function () {
                // 用户取消分享后执行的回调函数
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
    //页面初始化    
    var url = baseAddr + "/commAjaxServlet?action=queryFee";
    url = convertURL(url);
    $.get(url, null, function (data) {
        console.log("返回return1:" + data);
        var result = JSON.parse(data);
        $("#feeInfo").html(result.leaveFee);
        giveFeeBtnUrl = $("#openGiveDialog").attr('href');
        addFeeBtnUrl = $("#openAddDialog").attr('href')
    });
});

function addFee(event) {
    //打开缴费对话框
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
    //打开转送话费对话框
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
        //$('#getyzm').removeAttr("onclick"); //移除disabled属性  
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
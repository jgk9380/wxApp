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
    var shareInfo = new Object();
    var queryShareInfourl = baseAddr + "/commAjaxServlet?action=queryShareInfo";
    queryShareInfourl = convertURL(queryShareInfourl);
    $.get(queryShareInfourl, null, function (data) {
        console.log("返回return1:" + data);
        shareInfo = JSON.parse(data);
        var sharetitle=('我是"' + shareInfo.shareName + '",盐城联通已送我' + shareInfo.allFeeGift + "元刮刮卡，你也来试试");// 分享标题
        var shareLink="http://www.ycunicom.com/wx3/faces/shareAccount.jsf?shareName=" + shareInfo.shareName + "&imgUrl=" + shareInfo.shareImgUrl + "&qrCodeUrl=/wx-service/showqrcode&userId=" + shareInfo.shareUserId + "&allFee=" + shareInfo.allFeeGift + "&useFee=" + shareInfo.useFeeGift; // 分享链接
        wx.onMenuShareTimeline( {
            title : sharetitle,
            link : shareLink,
            imgUrl : shareInfo.shareImgUrl, // 分享图标
            success : function () {
                // 用户确认分享后执行的回调函数，记录分享
                $("#again").removeClass("hide");//分享成功后显示
                $("#sharebtn").addClass("hide");//分享成功后隐藏
                shareLog('ggk', 2, sharetitle, shareLink);
            },
            cancel : function () {
            }
        });
        wx.onMenuShareAppMessage({
            title : '我是"' + shareInfo.shareName + '",盐城联通送我' + shareInfo.allFeeGift + "元，你也来试试.", // 分享标题
            link : "http://www.ycunicom.com/wx3/faces/shareAccount.jsf?shareName=" + shareInfo.shareName + "&imgUrl=" + shareInfo.shareImgUrl + "&qrCodeUrl=/wx-service/showqrcode&userId=" + shareInfo.shareUserId + "&allFee=" + shareInfo.allFeeGift + "&useFee=" + shareInfo.useFeeGift, imgUrl : shareInfo.shareImgUrl, // 分享图标
            desc : '今天我在“盐城联通”公众号参加了刮刮卡活动，共刮到' + shareInfo.allFeeGift + '元，已经充话费（含赠送他人）' + shareInfo.useFeeGift + '元，你也来试试', // 分享描述       
            type : '', // 分享类型,music、video或link，不填默认为link
            dataUrl : '', // 如果type是music或video，则要提供数据链接，默认为空
            success : function () {
                $("#again").removeClass("hide");//分享成功后显示
                $("#sharebtn").addClass("hide");//分享成功后隐藏
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
        console.log("返回222return1:" + data);
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
            $("#again").addClass("hide");//隐藏再来一张            
            console.log("hide again");
            $("#sharebtn").removeClass("hide");//显示分享按钮            
        }
        setTimeout(timer, 1000);
    }
}

function share() {
    $("#shareit").show();
    //setTimeout(function(){$("#shareit").hide();}, 2000);
}
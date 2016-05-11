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
    var result;
    var queryShareInfourl = baseAddr + "/commAjaxServlet?action=queryShareInfo";
    queryShareInfourl = convertURL(queryShareInfourl);
    $.get(queryShareInfourl, null, function (data) {
        console.log("返回return1:" + data);
        result = JSON.parse(data);       
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
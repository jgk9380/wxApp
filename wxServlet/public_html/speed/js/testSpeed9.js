var baseAddr = "/wx3";
//baseAddr = "/wx-service";
var fileSize = 354;//文件大小598KK
var geturl = baseAddr + "/speed/testspeedMedia.zip";
var testTimes = 100;
var seq = 0;

$(document).ready(function () {
    //取上次测速结果    
    $('#testSpeedProgress').hide();
    $('#stop').hide();
    upload(0);//显示上次测速结果 
    $('#shareSpeed').hide();
    $('#velometer').speedometer( {
        percentage : 0
    });
    wxConfig();
});
var uploaded = 0;
$(document).ready(function () {
    $('#testSpeed').click(function () {
        //测速开始//每天最多上次       
        seq = 0;
        uploaded = 0;
        getSpeed();
    });
    $('#stop').click(function () {
        //测速开始//每天最多上次
        for (var j = 0;j < testTimes;j++)
            testSpeedAjax[j].abort();
        $('#testSpeed').show();
        $('#stop').hide();

    });
});
var testSpeedAjax = new Array();
var testSpeed;

function testSpeedSync() {
    $('#velometer').speedometer( {
        percentage : 0
    });
    var date1 = new Date();
    var speed = 0;
    for (var i = 0;i < testTimes;i++) {
        geturl = convertURL(geturl);
        testSpeedAjax[i] = $.ajax( {
            type : "get", timeout : 120 * 1000, cache : false, url : geturl, async : true, success : function (data) {
                if (data.length == 0) {
                    upload(speed);
                    return;
                }
                seq = seq + 1;
                var date2 = new Date();
                var times = (date2.getTime() - date1.getTime()) / 1000;
                var tempSpeed = fileSize * seq / times * 8;

                if (tempSpeed > speed)
                    speed = tempSpeed;
                showSpeed(speed);
                if (seq == testTimes) {
                    $('#testSpeed').show();
                    $('#stop').hide();
                    upload(speed);
                    return;
                }
            },
            complete : function (XMLHttpRequest, status) {
                //超时,status还有success,error等值的情况
                if (status == 'timeout') {
                    upload(speed);
                    $('#info').html("网路质量不好，测速超时，可重新测速");
                    for (var j = 0;j < testTimes;j++)
                        testSpeedAjax[j].abort();
                    $('#testSpeed').show();
                    $('#stop').hide();
                    return;
                }
            }
        });
    }
}

function showSpeed(speed) {
    var per = 0;
    var max = 0;
    var suffix = 'M';
    var maximum = 100;
    if (speed < 1024) {
        max = 4096;
        suffix = 'K';
    }
    if (speed >= 1024 && speed < 1024 * 10) {
        speed = speed / 1024;
        per = 25 + (speed - 1) / 9 * 25;
        max = speed / per * 100;
    }
    if (speed >= 1024 * 10 && speed < 50 * 1024) {
        speed = speed / 1024;
        per = 50 + (speed - 10) / 40 * 25;
        max = speed / per * 100;
    }

    if (speed >= 50 * 1024) {
        speed = speed / 1024;
        per = 75 + (speed - 50) / 50 * 25;
        max = speed / per * 100;

    }
    //显示测速表
    $('#velometer').speedometer( {
        percentage : speed.toFixed(2), scale : max, suffix : suffix, maximum : max, animate : false
    });
    //显示进度条
    $('#testSpeedProgress').jQMeter( {
        goal : "'" + testTimes + "'", raised : "'" + seq + "'", width : '268px', height : '30px', animationSpeed : 0, counterSpeed : 0, displayTotal : false
    });
}

function upload(speed) {
    if (uploaded == 1)
        return;
    var url = baseAddr + "/commAjaxServlet?action=testSpeed&type=uploadSpeed&speed=" + speed;
    $.get(url, null, function (data) {
        console.log("testSpeed.data return:" + data);
        var result = JSON.parse(data);
        console.log("testSpeed.getTimes return:" + result.info);
        $('#info').html(result.info);
        if (speed > 0)
            $('#shareSpeed').show();
        return 
    });
    if (speed >= 0) {
        uploaded = 1;
        wxConfig();
    }
}

function getSpeed() {
    var url = baseAddr + "/commAjaxServlet?action=testSpeed&type=getTimes";
    console.log("param jsonString:" + url);
    $.get(url, null, function (data) {
        console.log("testSpeed.data return:" + data);
        var result = JSON.parse(data);
        if (result.times >= 20) {
            $('#info').html("今日已测试过20次，请明日再测试");
            return;
        }
        else {
            $('#info').html("正在测试，请稍等...");
            $('#testSpeed').hide();
            $('#stop').show();
            $('#testSpeedProgress').show();
            testSpeedSync();
        }
    });
}

function convertURL(url) {
    //获取时间戳  
    var timstamp = (new Date()).valueOf();
    //将时间戳信息拼接到url上  
    if (url.indexOf("?") >= 0) {
        url = url + "&t=" + timstamp;
    }
    else {
        url = url + "?t=" + timstamp;
    }
    return url;
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
    console.log(" url:" + url);

    $.get(url, null, function (data) {

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
        result = JSON.parse(data);
        var shareLink = "http://www.ycunicom.com/wx3/faces/speed/shareSpeed.jsf?shareName=" + result.shareName + "&imgUrl=" + result.shareImgUrl + "&qrCodeUrl=/wx-service/showqrcode&userId=" + result.shareUserId + "&speed=" + result.speed + "&rank=" + result.rank + "&percent=" + result.percent;
        var shareTitle = ('我是"' + result.shareName + '",我的手机速度为' + result.speed + "，你的是多少？");
        var shareDesc = '今天我在“盐城联通”公众号进行了测速测试，我的网速为' + result.speed + '，排名' + result.rank + '，我击败了' + result.percent + '人';

        console.log("shareDesc=" + shareDesc);
        wx.onMenuShareTimeline( {
            title : shareTitle, // 分享标题
            link : shareLink, // 分享链接
            imgUrl : result.shareImgUrl, // 分享图标
            success : function () {
                // 用户确认分享后执行的回调函数，记录分享
                shareLog('speed', 2, shareTitle, shareLink);
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
                shareLog('speed', 1, shareTitle, shareLink);
            },
            cancel : function () {
                // 用户取消分享后执行的回调函数
            }
        });
    });
}

function shareMyAccount(event) {
    $("#shareit").show();
    setTimeout(function () {
        $("#shareit").hide();
    },
    3000);
}

function closeShare() {
    $("#shareit").hide();
}
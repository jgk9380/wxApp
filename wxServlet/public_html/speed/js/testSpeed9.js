var baseAddr = "/wx3";
//baseAddr = "/wx-service";
var fileSize = 354;//�ļ���С598KK
var geturl = baseAddr + "/speed/testspeedMedia.zip";
var testTimes = 100;
var seq = 0;

$(document).ready(function () {
    //ȡ�ϴβ��ٽ��    
    $('#testSpeedProgress').hide();
    $('#stop').hide();
    upload(0);//��ʾ�ϴβ��ٽ�� 
    $('#shareSpeed').hide();
    $('#velometer').speedometer( {
        percentage : 0
    });
    wxConfig();
});
var uploaded = 0;
$(document).ready(function () {
    $('#testSpeed').click(function () {
        //���ٿ�ʼ//ÿ������ϴ�       
        seq = 0;
        uploaded = 0;
        getSpeed();
    });
    $('#stop').click(function () {
        //���ٿ�ʼ//ÿ������ϴ�
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
                //��ʱ,status����success,error��ֵ�����
                if (status == 'timeout') {
                    upload(speed);
                    $('#info').html("��·�������ã����ٳ�ʱ�������²���");
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
    //��ʾ���ٱ�
    $('#velometer').speedometer( {
        percentage : speed.toFixed(2), scale : max, suffix : suffix, maximum : max, animate : false
    });
    //��ʾ������
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
            $('#info').html("�����Ѳ��Թ�20�Σ��������ٲ���");
            return;
        }
        else {
            $('#info').html("���ڲ��ԣ����Ե�...");
            $('#testSpeed').hide();
            $('#stop').show();
            $('#testSpeedProgress').show();
            testSpeedSync();
        }
    });
}

function convertURL(url) {
    //��ȡʱ���  
    var timstamp = (new Date()).valueOf();
    //��ʱ�����Ϣƴ�ӵ�url��  
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
    console.log(" url:" + url);

    $.get(url, null, function (data) {

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
        result = JSON.parse(data);
        var shareLink = "http://www.ycunicom.com/wx3/faces/speed/shareSpeed.jsf?shareName=" + result.shareName + "&imgUrl=" + result.shareImgUrl + "&qrCodeUrl=/wx-service/showqrcode&userId=" + result.shareUserId + "&speed=" + result.speed + "&rank=" + result.rank + "&percent=" + result.percent;
        var shareTitle = ('����"' + result.shareName + '",�ҵ��ֻ��ٶ�Ϊ' + result.speed + "������Ƕ��٣�");
        var shareDesc = '�������ڡ��γ���ͨ�����ںŽ����˲��ٲ��ԣ��ҵ�����Ϊ' + result.speed + '������' + result.rank + '���һ�����' + result.percent + '��';

        console.log("shareDesc=" + shareDesc);
        wx.onMenuShareTimeline( {
            title : shareTitle, // �������
            link : shareLink, // ��������
            imgUrl : result.shareImgUrl, // ����ͼ��
            success : function () {
                // �û�ȷ�Ϸ����ִ�еĻص���������¼����
                shareLog('speed', 2, shareTitle, shareLink);
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
                shareLog('speed', 1, shareTitle, shareLink);
            },
            cancel : function () {
                // �û�ȡ�������ִ�еĻص�����
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
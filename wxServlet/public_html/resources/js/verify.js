function verify() {
    //解决中文乱码问题的方法1,页面端发出的数据作一次encodeURI，服务端使用new String(old.getBytes("iso8859-1"),"UTF-8");  
    //解决中文乱码问题的方法2,页面端发出的数据作两次encodeURI,服务端使用String name = URLDecoder.decode(old,"UTF-8");  
    //alert("222")
    var url = "/wx-testWeb-context-root/ajaxServlet?name=" + encodeURI(encodeURI($("#name").val()));
    url = convertURL(url);
    //alert(url)
    $.get(url, null, function (data) {
        alert(data);
        $("#result").html(data);
    });
}
//给url地址增加时间蒫，难过浏览器，不读取缓存  
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

function showToast1() {

    var $toast = $('#toast');
    if ($toast.css('display') != 'none') {
        return;
    }
    $("#ywc").html("error");
    $toast.show();
    setTimeout(function () {
        $toast.hide();
    },
    2000);
}

function showToast2() {
    var $toast = $('#loadingToast');
    if ($toast.css('display') != 'none') {
        return;
    }

    $toast.show();
    setTimeout(function () {
        $toast.hide();
    },
    2000);
}

//监听手机摇动事件
if (window.DeviceMotionEvent) {
    window.addEventListener('devicemotion', deviceMotionHandler, false);
}
else {
    alert('你的设备不支持DeviceMotion事件');
}
var SHAKE_THRESHOLD = 100;
var last_update = 0;
var x = y = z = last_x = last_y = last_z = 0;
//摇一摇开关，1表示开，0表示关
var canShake = 1;

function deviceMotionHandler(eventData) {

    var acceleration = eventData.accelerationIncludingGravity;
    var curTime = new Date().getTime();

    //100ms监听一次，拒绝重复监听
    if ((curTime - last_update) > 500 && canShake == 1) {
        alert("yaole yica");
        var diffTime = curTime - last_update;
        last_update = curTime;
        x = acceleration.x;
        y = acceleration.y;
        z = acceleration.z;
        var speed = Math.abs(x + y + z - last_x - last_y - last_z) / diffTime * 10000;
        if (speed > SHAKE_THRESHOLD) {
            canShake = 0;
            var myAuto = document.getElementById('musicBox');
//            myAuto.play();
//
//            var httpurl = contextPath + "/servlet/chouJiangServlet?" + Math.random();
//            $.post(httpurl, 
//            {
//                "requestKey" : '', "choujiangProgram" : 'Yaoyiyao', 'choujiangGiftId' : document.getElementById("choujiangGiftId").value
//            },
//            function (data) {
//                try {
//                    var json = eval("(" + data + ")");
//                }
//                catch (e) {
//                    alert("网络通信故障，请刷新后再试。");
//                    return;
//                }
//                var status = json['status'];
//                var message = json['message'];
//                var awardId = json['data']['id'];
//
//                var yaoyiyaoJifen = json['data']['currUserJifen'];
//                document.getElementById("currUserJifen").value = yaoyiyaoJifen;
//
//                if (status == 1) {
//                    switch (awardId) {
//                        case 0:
//                            document.getElementById("interface1").style.display = "none";
//                            document.getElementById("interface2").style.display = "inline";
//
//                            break;
//                        case 1:
//                            document.getElementById("interface1").style.display = "none";
//                            document.getElementById("interface3").style.display = "inline";
//                            break;
//                    }
//
//                    //没有登录或登录超时，跳转登录    
//                }
//                else if (status == 3) {
//                    loading.goUrl("../user/login.shtml");
//
//                    //其他错误
//                }
//                else {
//                    alert(message);
//                }
//            });
        }
        last_x = x;
        last_y = y;
        last_z = z;
    }
}
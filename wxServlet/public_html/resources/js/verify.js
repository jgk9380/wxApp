function verify() {
    //���������������ķ���1,ҳ��˷�����������һ��encodeURI�������ʹ��new String(old.getBytes("iso8859-1"),"UTF-8");  
    //���������������ķ���2,ҳ��˷���������������encodeURI,�����ʹ��String name = URLDecoder.decode(old,"UTF-8");  
    //alert("222")
    var url = "/wx-testWeb-context-root/ajaxServlet?name=" + encodeURI(encodeURI($("#name").val()));
    url = convertURL(url);
    //alert(url)
    $.get(url, null, function (data) {
        alert(data);
        $("#result").html(data);
    });
}
//��url��ַ����ʱ���c���ѹ������������ȡ����  
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

//�����ֻ�ҡ���¼�
if (window.DeviceMotionEvent) {
    window.addEventListener('devicemotion', deviceMotionHandler, false);
}
else {
    alert('����豸��֧��DeviceMotion�¼�');
}
var SHAKE_THRESHOLD = 100;
var last_update = 0;
var x = y = z = last_x = last_y = last_z = 0;
//ҡһҡ���أ�1��ʾ����0��ʾ��
var canShake = 1;

function deviceMotionHandler(eventData) {

    var acceleration = eventData.accelerationIncludingGravity;
    var curTime = new Date().getTime();

    //100ms����һ�Σ��ܾ��ظ�����
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
//                    alert("����ͨ�Ź��ϣ���ˢ�º����ԡ�");
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
//                    //û�е�¼���¼��ʱ����ת��¼    
//                }
//                else if (status == 3) {
//                    loading.goUrl("../user/login.shtml");
//
//                    //��������
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
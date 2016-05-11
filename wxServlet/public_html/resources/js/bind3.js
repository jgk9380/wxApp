var baseAddr = "/wx3";
baseAddr = "/wx-service";
$(document).ready(function () {
    console.log("ready begin1:");
    var url = baseAddr + "/commAjaxServlet?action=queryInfo";
    url = convertURL(url);
    $.get(url, null, function (data) {
        console.log("返回return1:" + data);
        var result = JSON.parse(data);
        console.log("返回return2:" + result.tele);
        $('#tele').val( result.tele);
        $('#address').val( result.address);
        $('#longName').val( result.longName);
        $('#promId').val( result.promCode);

    });
});

var times = 0;
var hn;

$(document).ready(function () {
    hn = $('#getyzm').attr("text");
})

function timer() {
    $('#getyzm').attr("text", hn + '(' + times + ')');
    if (times < 60 && times > 0) {
        setTimeout(timer, 1000);
    }
    else {
        $('#getyzm').attr("text", hn);
        $('#getyzm').removeClass('weui_btn_disabled');
        times = 0;
        return;
    }
    times = times + 1;
}

function getsms(event) {
    if (times > 0) {
        return;
    }
    console.log('tele=' + $("#tele").val());   
    var json = new Object();
    json.tele = $("#tele").val();
    //alert("json.tele="+json.tele);
    var jsonString = JSON.stringify(json)
    var url = baseAddr + "/commAjaxServlet?action=sendsmscode&param=" + jsonString;
    console.log("url=" + url);
    url = convertURL(url);
    $.get(url, null, function (data) {
        console.log("返回return1:" + data);
        var result = JSON.parse(data);
        showToastInfo('#toast', result.resultInfo);

        if (result.result == 'error') {
            return;
        }
        $('#getyzm').addClass('weui_btn_disabled');
        $('#binding').removeClass('weui_btn_disabled');
        times = 1;
        setTimeout(timer, 1000);//修改点击验证码字样      
    });
}

function submitVrcode() {
    var json = new Object();
    json.yzm = $("#yzm").val();
    json.tele = $("#tele").val();
    var jsonString = JSON.stringify(json)
    var url = baseAddr + "/commAjaxServlet?action=bindtele&param=" + jsonString;
    url = convertURL(url);
    $.get(url, null, function (data) {
        console.log("返回return:" + data);
        var result = JSON.parse(data);
        showToastInfo('#toast', result.resultInfo);
    });
    times = 0;
}

function submitAddInfo(event) {
    var json = new Object();
    json.longName = $("#longName").val();
    json.address = $("#address").val();
    json.promId = $("#promId").val();
    var jsonString = JSON.stringify(json)
    var url = baseAddr + "/commAjaxServlet?action=addinfo&param=" + jsonString;
    url = convertURL(url);
    $.get(url, null, function (data) {
        console.log("返回return:" + data);
        var result = JSON.parse(data);
        showToastInfo('#toast', result.resultInfo);
    });
}

function showDialog(diagName) {
    var $dialog = $(diagName);
    if ($dialog.css('display') != 'none') {
        return;
    }
    $dialog.show();
}

function closeDialog(diagName) {
    var $toast = $(diagName);
    $toast.hide();
}
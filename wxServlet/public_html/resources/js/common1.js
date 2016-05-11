//var baseAddr = "/wx31";
//var baseAddr = "/wx-service";
function GetQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null)
        return unescape(r[2]);
    return null;
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

function checkMobile(tele) {
    var patrn = /^(13[0-9]{9})|(14[0-9])|(18[0-9])|(15[0-9][0-9]{8})$/;
    if (!patrn.exec(tele))
        return false
    return true
}

function showToastInfo(toastName, info) {
    console.log("show toast");
    var $toast = $(toastName);
    $('#toastinfo').html(info);
    if ($toast.css('display') != 'none') {
        return;
    }
    $toast.show();
    setTimeout(function () {
        $toast.hide();
    },
    2000);
}
function showLoading(toastName) {
    console.log("show toast");
    var $loadingToast = $(toastName); 
    if ($loadingToast.css('display') != 'none') {
        return;
    }
    $loadingToast.show();   
}
function closeLoading(toastName) {
    console.log("show toast");
    var $loadingToast = $(toastName); 
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

function showToast(toastName) {
    var $toast = $(toastName);
    if ($toast.css('display') != 'none') {
        return;
    }
    $toast.show();
    setTimeout(function () {
        $toast.hide();
    },
    2000);
}




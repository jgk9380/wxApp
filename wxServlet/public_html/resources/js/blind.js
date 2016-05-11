var baseAddr = "/wx3";
//baseAddr = "/wx-service";
$(document).ready(function () {
    $("area").selectedIndex =  - 1;

});
var latitude;
var longitude;

function submitSingleInfo() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(savePositionAndInfo);
    }
    else {
        console.log("��֧�ֵ���λ�ò�ѯ");
        showToastInfo('#toast', "����ֻ�û��֧�ֵ�ַλ�ò�ѯ���ύʧ��");
    }
}

function savePositionAndInfo(position) {
    latitude = position.coords.latitude;
    longitude = position.coords.longitude;
    var json = new Object();
    json.tele = $('#tele').val();
    json.name = $("#name").val();
    json.area = $("#area").val();
    json.adress = $("#adress").val();
    json.signalStrength = $("#signalStrength").val();
    json.signalDesc = $("#signalDesc").val();
    json.other = $("#other").val();
    json.latitude = latitude;
    json.longitude = longitude;
    var jsonString = JSON.stringify(json)
    var url = baseAddr + "/commAjaxServlet?action=submitSingalInfo&param=" + jsonString;
    //alert("url=" + url)
    url = convertURL(url);
    $.get(url, null, function (data) {
        console.log("����return:" + data);
        var result = JSON.parse(data);
        showToastInfo('#toast', result.resultInfo);
    });
}
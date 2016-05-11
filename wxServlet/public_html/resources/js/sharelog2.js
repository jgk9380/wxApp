var baseAddr = "/wx3";
//baseAddr = "/wx-service";

function shareLog(shareFlag, shareType, secen, remark) {
    var shareInfo1 = new Object();
    shareInfo1.shareFalg = shareFlag;
    shareInfo1.shareType = shareType;
    shareInfo1.scence = secen;
    shareInfo1.remark = remark;
    var jsonString = JSON.stringify(shareInfo1)
    var shareAddUrl = baseAddr + "/commAjaxServlet?action=shareAdd&param=" + encodeURIComponent(jsonString);
    $.get(shareAddUrl, null, function (data1) {
    
    });
}
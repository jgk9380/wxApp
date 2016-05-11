$(document).ready(function () {
    $("tr:odd").addClass("odd");
    $("tr:even").addClass("even");

    $("#conponUseDlg").dialog( {
        dialogClass : "no-close", autoOpen : false, modal : true, resizable : false, width : 200, buttons :  {
            "关闭" : function () {
                $(this).dialog("close");
            }
        }
    });

    $("tbody tr").click(function () {
        var hasSelected = $(this).hasClass("selected");
        $("tbody tr").removeClass("selected");
        if (hasSelected == true) {
            $(this).removeClass("selected");
        }
        if (hasSelected == false) {
            $(this).addClass("selected");
        }
    });
    $("td .useConpon").click(function () {
        console.log($(this).attr("value"));
        //$("#conponCont").html($(this).attr("value"));
        $("#couponPic").attr("src", '../image/couponQrCode/' + $(this).attr("value"));
        $("#conponUseDlg").dialog("open");
        //轮询conpon状态，如果改为use关闭窗口
        var couponId= $(this).attr("value");
        var component=$(this);
        var time1 = setInterval(function () {
            queryCouponStatus(couponId, component)
        },
        1500);

        function queryCouponStatus(value, comp) {
            console.log("query coupon");
            $.ajax( {
                type : "GET", url : "querycounponStatus/" + value, success : function (msg) {
                    console.log(msg.result)
                    if (msg.result == true) {
                        console.log(true);
                        $("#conponUseDlg").dialog("close");
                        comp.html("<span style='color:Red;'>已使用<\/span>")
                        clearInterval(time1);
                    }
                }
            });

        }

    });

    $("#tabs").tabs();
    $("#info").dialog( {
        dialogClass : "no-close", autoOpen : false, modal : true, resizable : false, width : 300, buttons :  {
            "关闭" : function () {
                $(this).dialog("close");
            }
        }
    });

    $("#addFeeDlg").dialog( {
        autoOpen : false, modal : true, resizable : false, width : 300, buttons :  {
            "缴费" : function () {
                var fee = $("#feeNum").val();
                console.log("fee=" + fee);
                var url = "addfee?fee=" + fee;
                console.log("addfee url=" + url);
                // url = convertURL(url);
                $(this).dialog("close");

                $("#info").html("正在提交，请稍等");
                $("#info").dialog( {
                    autoOpen : false, modal : true
                });
                $("#info").dialog("open");
                $.get(url, null, function (data) {
                    console.log(data.leaveFee);
                    $("#leaveFee").html(data.leaveFee);
                    $("#info").dialog("close");
                    $("#info").html(data.resultInfo);
                    $("#info").dialog("open");

                });
            },
            "取消" : function () {
                console.log("feenumber");
                $(this).dialog("close");
            }
        }
    });

    $("#giveFeeDlg").dialog( {
        autoOpen : false, modal : true, resizable : false, width : 300, buttons :  {
            "赠送" : function () {
                var fee = $("#givefeeNum").val();
                console.log("fee=" + fee);
                var url = "givefee?fee=" + fee + "&tele=" + $("#givetele").val();
                //url = convertURL(url);
                $(this).dialog("close");

                $("#info").html("正在提交，请稍等");
                $("#info").dialog( {
                    autoOpen : false, modal : true
                });
                $("#info").dialog("open");
                console.log("givefee url=" + url);
                $.get(url, null, function (data) {
                    console.log(data.leaveFee);
                    $("#leaveFee").html(data.leaveFee);
                    $("#info").dialog("close");
                    $("#info").html(data.resultInfo);
                    $("#info").dialog("open");
                    //console.log(result);                    
                });
            },
            "取消" : function () {
                //console.log("feenumber");
                $(this).dialog("close");
            }
        }
    });

    $("#addTraffDlg").dialog( {
        autoOpen : false, modal : true, resizable : false, width : 300, buttons :  {
            "充流量" : function () {
                var addTrafficCount = $("#addTrafficCount").val();
                console.log("fee=" + fee);
                var url = "addTraff?trafficCount=" + addTrafficCount;
                //url = convertURL(url);
                $(this).dialog("close");
                $("#info").html("正在提交，请稍等");
                $("#info").dialog( {
                    autoOpen : false, modal : true
                });
                $("#info").dialog("open");
                console.log("givefee url=" + url);
                $.get(url, null, function (data) {
                    console.log(data.leaveTraffic);
                    $("#leaveTraffic").html(data.leaveTraffic);
                    $("#info").dialog("close");
                    $("#info").html(data.resultInfo);
                    $("#info").dialog("open");
                    //console.log(result);                    
                });
            },
            "取消" : function () {
                //console.log("feenumber");
                $(this).dialog("close");
            }
        }
    });

    $("#giveTraffDlg").dialog( {
        autoOpen : false, modal : true, resizable : false, width : 300, buttons :  {
            "赠送流量" : function () {
                var giveTrffiicCount = $("#giveTrffiicCount").val();
                console.log("fee=" + fee);
                var url = "giveTraff?trafficCount=" + giveTrffiicCount + "&tele=" + $("#giveTrffiictele").val();
                //url = convertURL(url);
                $(this).dialog("close");

                $("#info").html("正在提交，请稍等");
                $("#info").dialog( {
                    autoOpen : false, modal : true
                });
                $("#info").dialog("open");
                console.log("givefee url=" + url);
                $.get(url, null, function (data) {
                    console.log(data.leaveTraffic);
                    $("#leaveTraffic").html(data.leaveTraffic);
                    $("#info").dialog("close");
                    $("#info").html(data.resultInfo);
                    $("#info").dialog("open");
                    //console.log(result);                    
                });
            },
            "取消" : function () {
                //console.log("feenumber");
                $(this).dialog("close");
            }
        }
    });

    $("a.button").button();

    $("#addFee").click(function (event) {
        event.preventDefault();
        $("#addFeeDlg").dialog("open");
    });

    $("#giveFee").click(function (event) {
        event.preventDefault();
        $("#giveFeeDlg").dialog("open");
    });

    $("#addTraffic").click(function (event) {
        event.preventDefault();
        $("#addTraffDlg").dialog("open");
    });

    $("#giveTraffic").click(function (event) {
        event.preventDefault();
        $("#giveTraffDlg").dialog("open");
    });

});
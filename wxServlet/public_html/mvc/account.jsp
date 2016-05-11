<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0"/>
        <title>
            ${wxSession.wxUserBo.wxUser.nickname}
            的微信账本
        </title>
        <link rel="stylesheet" href="../resources/css/weui.css"/>
        <link type="text/css" rel="stylesheet" href="../resources/js/jquery-ui-1.11.4.custom/jquery-ui.css"/>
        <link type="text/css" rel="stylesheet" href="../resources/css/share.css"/>
        <link type="text/css" rel="stylesheet" href="../resources/js/jquery-ui-1.11.4.custom/jquery-ui.theme.css"/>
        <link rel="stylesheet" href="../resources/css/common.css"/>
        <script type="text/javascript" src="../resources/js/jquery-ui-1.11.4.custom/external/jquery/jquery.js"></script>
        <script type="text/javascript" src="../resources/js/jquery-ui-1.11.4.custom/jquery-ui.js" charset="UTF-8"></script>
        <script type="text/javascript" src="../resources/js/account_sec1.js" charset="UTF-8"></script>
        <link type="text/css" rel="stylesheet" href="../resources/css/account1.css"/>
        <style type="text/css">
                input.text {
                    margin-bottom: 3px;
                    width: 50%;
                    padding: .4em;
                }

                fieldset {
                    padding: 1px;
                    border: 1px;
                    margin-top: 10px;
                }

                .ui-dialog .ui-state-error {
                    padding: .3em;
                }
            </style>
    </head>
    <body ontouchstart='ontouchstart' class="ui-themename">
        <div id="info" title="信息提示"></div>
        <div id="addFeeDlg" title="自助缴费">
            <fieldset>
                <!--<legend>缴费</legend>-->
                <label for="tele">手机号码:</label>
                <input name="tele" id="tele" pattern="[0-9]*" class="text ui-widget-content ui-corner-all"
                       value="${wxSession.wxUserBo.wxUser.tele}" disabled="disabled"/>
                <div style="height:0.5em"></div>
                <label for="feeNum">缴费金额:</label>
                <input name="feeNum" id="feeNum" value="" pattern="[0-9]*" placeholder="填写金额"
                       class="text  ui-widget-content ui-corner-all"/>
            </fieldset>
        </div>
        <div id="giveFeeDlg" title="赠送话费">
            <fieldset>
                <!--<legend>缴费</legend>-->
                <label for="givetele">手机号码:</label>
                <input pattern="[0-9]*" name="givetele" id="givetele" class="text ui-widget-content ui-corner-all"/>
                <div style="height:0.5em"></div>
                <label for="givefeeNum">赠送金额:</label>
                <input name="givefeeNum" id="givefeeNum" value="" pattern="[0-9]*" placeholder="赠送金额"
                       class="text  ui-widget-content ui-corner-all"/>
            </fieldset>
        </div>
        <div id="addTraffDlg" title="流量充值">
            <fieldset>
                <!--<legend>缴费</legend>-->
                <label for="addTraffictele">手机号码:</label>
                <input pattern="[0-9]*" name="addTraffictele" id="addTraffictele"
                       class="text ui-widget-content ui-corner-all" value="${wxSession.wxUserBo.wxUser.tele}"
                       disabled="disabled"/>
                <div style="height:0.5em"></div>
                <label for="AddTrfficCount">流量数(M):</label>
                <select name="cars" class="text  ui-widget-content ui-corner-all" id="addTrafficCount">
                    <option value="10">10M</option>
                    <option value="50">50M</option>
                    <option value="100">100M</option>
                    <option value="500">500M</option>
                </select>
                <!--<input name="givefeeNum" id="addTrafficCount" value="" pattern="[0-9]*" placeholder="填写流量数"
                       class="text  ui-widget-content ui-corner-all"/>-->
            </fieldset>
        </div>
        <div id="giveTraffDlg" title="赠送流量">
            <fieldset>
                <!--<legend>缴费</legend>-->
                <label for="giveTrffiictele">手机号码:</label>
                <input pattern="[0-9]*" name="giveTrffiictele" id="giveTrffiictele"
                       class="text ui-widget-content ui-corner-all"/>
                <div style="height:0.5em"></div>
                <label for="giveTrffiicCount">赠送金额:</label>
                <input name="giveTrffiicCount" id="giveTrffiicCount" value="" pattern="[0-9]*" placeholder="填写流量数"
                       class="text  ui-widget-content ui-corner-all"/>
            </fieldset>
        </div>
        <img src="${wxSession.wxUserBo.wxUser.headimgurl}" alt=" " height="90" width="90" id="pic"/>
        <div id="tabs">
            <ul>
                <li>
                    <a href="#fee">话费</a>
                </li>
                <li>
                    <a href="#traff">流量</a>
                </li>
                <li>
                    <a href="#conpon">代金券</a>
                </li>
                <!--<li>
                    <a href="#gift">礼品</a>
                </li>-->
            </ul>
            <div id="fee">
                话费余额： 
                <span style="color:Red;" id="leaveFee">
                    ${wxSession.wxUserBo.account.leaveFee}元</span><br/>
                 
                <a class="button btn" href="#" id="addFee">自助缴费</a><br/>
                 
                <a class="button btn" href="#" id="giveFee">转送话费</a>
            </div>
            <div id="traff">
                流量余额： 
                <span style="color:Red;" id="leaveTraffic">
                    ${wxSession.wxUserBo.account.leaveTraffic}M</span><br/>
                 
                <a class="button btn" href="#" id="addTraffic">流量充值</a><br/>
                 
                <a class="button btn" href="#" id="giveTraffic">转送流量</a>
            </div>
            <div id="conpon" align="center">
                <div id="conponUseDlg" title="请扫描二维码">
                    <img src="" alt=" " height="150" width="150" id="couponPic"/>
                </div>
                <br/>
                <table cellspacing="0" cellpadding="10px">
                    <!--<caption>代金券</caption>-->
                    <thead>
                        <tr>
                            <th>名称</th>
                            <th>面值</th>
                            <th>有效期</th>
                            <th>状态</th>
                        </tr>
                    </thead>
                     
                    <tbody>
                        <c:forEach var="item" items="${wxSession.wxUserBo.account.allCouponList}" varStatus="status">
                            <tr>
                                <td>
                                    ${item.assertType.alias}
                                </td>
                                <td>
                                    ${item.faceValue}
                                     
                                    ${item.assertType.unit}
                                </td>
                                <td></td>
                                <td>
                                    <c:if test="${item.used==true}">
                                        <span style="color:Red;">已使用</span>
                                    </c:if>  
                                    <c:if test="${item.used==false}">
                                        <a class="useConpon" value="${item.id}">使用</a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <br/>
            </div>
            <!--<div id="gift">
                <p>你目前没有礼品</p>
            </div>-->
        </div>
        <a class="button btn" href="#">分享账本</a>
    </body>
</html>
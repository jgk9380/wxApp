package org.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import java.io.UnsupportedEncodingException;

import java.math.BigDecimal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.WxBeanFactoryImpl;
import org.WxSession;

import org.dao.WxAssertDao;
import org.dao.WxQrCodeDao;

import org.entity.WxUser;

import org.entity.asserts.WxAssert;

import org.pojo.WeixinOauth2Token;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.util.WxUtils;

import org.wx.WxAppManager;

@Controller
@RequestMapping("/oa")
public class OAController {
    public OAController() {
        super();
    }
    WxSession wxSession;


    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public ModelAndView showUserAccount(@RequestParam(value = "state", required = false) String state,
                                        @RequestParam(value = "code", required = false) String code,
                                        HttpServletRequest request) {
        wxSession = WxWebUtils.initWxSession(state, code, request);
        ModelAndView mv = new ModelAndView("account");
        System.out.println(wxSession.getWxUserBo().getWxUser().getHeadimgurl());
        List<WxAssert> wxList = wxSession.getWxUserBo().getAccount().getAllCouponList();
        mv.addObject("wxSession", wxSession);
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/addfee", method = RequestMethod.GET)
    public JSONObject accountAddFee(@RequestParam(value = "fee") double fee) throws IOException {
        JSONObject json = wxSession.addFee((int) fee);
        json.put("leaveFee", wxSession.getWxUserBo().getAccount().getLeaveFee());
        json.put("leaveFee", wxSession.getWxUserBo().getAccount().getLeaveFee());
        return json;

    }


    @ResponseBody
    @RequestMapping(value = "/givefee", method = RequestMethod.GET)
    public JSONObject accountGiveFee(@RequestParam(value = "fee") double fee,
                                     @RequestParam(value = "tele") String tele) throws IOException {
        JSONObject json = wxSession.giveFee(tele, (int) fee);
        json.put("leaveFee", wxSession.getWxUserBo().getAccount().getLeaveFee());
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/addTraff", method = RequestMethod.GET)
    public JSONObject accountAddTraff(@RequestParam(value = "trafficCount") double trafficCount) throws IOException {
        System.out.println("trafficCount=" + trafficCount);
        JSONObject json = wxSession.addTraffic((int) trafficCount);
        json.put("leaveTraffic", wxSession.getWxUserBo().getAccount().getLeaveTraffic());
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/giveTraff", method = RequestMethod.GET)
    public JSONObject accountGiveTraff(@RequestParam(value = "trafficCount") double trafficCount,
                                       @RequestParam(value = "tele") String tele) throws IOException {
        System.out.println("trafficCount=" + trafficCount);
        JSONObject json = wxSession.giveTraffic(tele, (int) trafficCount);
        json.put("leaveTraffic", wxSession.getWxUserBo().getAccount().getLeaveTraffic());
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/querycounponStatus/{couponId}", method = RequestMethod.GET)
    public JSONObject queryCouponStatus(@PathVariable(value = "couponId") long couponId) throws IOException {
        System.out.println("--query couponId=" + couponId);
        WxAssertDao wxAssertDao = WxBeanFactoryImpl.getInstance().getBean("wxAssertDao", WxAssertDao.class);
        WxAssert wxCoupon = wxAssertDao.findById(new BigDecimal(couponId));
        JSONObject json = new JSONObject();
        if (wxCoupon.isUsed()) {
            json.put("result", true);
        }else{
            json.put("result", false);
        }
        return json;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        JSONObject json = new JSONObject();
        json.put("resultInfo", "测试Test");
        String str = "中文";
        //str = new String(str.getBytes("UTF-8"), "gb2312");
        System.out.println(str + "  " + json.toString());
        String encoding = System.getProperty("file.encoding");
        System.out.println("Default System Encoding: " + encoding);
    }
    
    
    @ResponseBody
    @RequestMapping(value = "/testjsonp", method = RequestMethod.GET)
    public String queryCouponStatus() throws IOException {
       
        String res="({\n" + 
        "    \"code\": \"CA1998\",\n" + 
        "    \"price\": 1780,\n" + 
        "    \"tickets\": 5\n" + 
        "});";
        return res;
    }
}

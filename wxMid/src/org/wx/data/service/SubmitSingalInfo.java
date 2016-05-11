package org.wx.data.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.WxBeanFactoryImpl;
import org.WxSession;

import org.dao.WxSingalDao;

import org.entity.WxSingal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.util.WxUtils;
//submitSingalInfo
@Component("submitSingalInfo")
public class SubmitSingalInfo implements DataServiceListener {
    @Autowired
    WxSingalDao wxSingalDao;

    public boolean isMobile(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$"); // 验证手机号
        m = p.matcher(str);
        b = m.matches();
        return b;
    }

    @Override
    public JSONObject doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject json = new JSONObject();
      
        try {
           // System.out.println("submitSingalInfo");
            String param = request.getParameter("param");
           // System.out.println("param=" + param);
            JSONObject paramJson = JSONObject.fromObject(param);
            String tele = paramJson.getString("tele");
            if (!this.isMobile(tele)) {
                json.put("resultInfo", "请检查你的号码！");
                return json;
            }
            String name = paramJson.getString("name");
            String area = paramJson.getString("area");
            String adress = paramJson.getString("adress");
            if (adress == null || adress.length() < 6) {
                json.put("resultInfo", "请填写详细地址！");
                return json;
            }
            String signalStrength = paramJson.getString("signalStrength");
            String signalDesc = paramJson.getString("signalDesc");
            String other = paramJson.getString("other");
            
            Number latitude = paramJson.getDouble("latitude");
            Number longitude = paramJson.getDouble("longitude");
            WxSingal wxSingal = new WxSingal();
            wxSingal.setId(WxUtils.getSeqencesValue());
            wxSingal.setTele(tele);
            wxSingal.setName(name);
            wxSingal.setArea(area);
            wxSingal.setAddress(adress);
            wxSingal.setSignalStrength(signalStrength);
            wxSingal.setSignalDesc(signalDesc);
            wxSingal.setOther(other);
            wxSingal.setLatitude(latitude);
            wxSingal.setLongitude(longitude);
            WxSession wxSession = (WxSession) request.getSession(true).getAttribute("wxSession");
            if(wxSession!=null){
                wxSingal.setUserId(wxSession.getWxUserBo().getWxUser().getId());
            }
            wxSingalDao.save(wxSingal);
            json.put("resultInfo", "你上报的问题我们以收到，我们的工作人员会及时与您联系！");
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            json.put("resultInfo", "请检查你的数据！");
            return json;
        }
    }
}

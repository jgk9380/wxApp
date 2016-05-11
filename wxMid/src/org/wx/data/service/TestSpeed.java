package org.wx.data.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.WxBeanFactoryImpl;
import org.WxSession;

import org.dao.WxTestSpeedLogDao;

import org.dao.WxUserDao;

import org.dao.WxUserSpeedDao;

import org.entity.WxTestSpeedLog;
import org.entity.WxUser;

import org.entity.WxUserSpeed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.util.WxUtils;

@Component("testSpeed")
public class TestSpeed implements DataServiceListener {
    public TestSpeed() {
        super();
    }
    @Autowired
    WxTestSpeedLogDao wxTestSpeedLogDao;
    @Autowired
    WxUserDao wxUserDao;
    @Autowired
    WxUserSpeedDao wxUserSpeedDao;

    @Override
    public JSONObject doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String type = request.getParameter("type");
        System.out.println("type=" + type);
        //       String param = request.getParameter("param");
        //       System.out.println("param=" + param);
        //       JSONObject paramJson = JSONObject.fromObject(param);
        //       String type = paramJson.getString("type");
        JSONObject res = new JSONObject();
        WxSession wxSession = (WxSession) request.getSession(true).getAttribute("wxSession");
        if (type.equals("getTimes")) {
            int times = wxTestSpeedLogDao.findTimesByUserId(wxSession.getWxUserBo().getWxUser().getId());
            res.put("times", times);
            return res;
        }

        if (type.equals("uploadSpeed")) {
            Double speed = Double.parseDouble(request.getParameter("speed"));
            WxUserSpeed wxUserSpeed = wxUserSpeedDao.findByUserId(wxSession.getWxUserBo().getWxUser().getId());
            if (speed == 0)
                return this.getLastSpeed(wxSession);
            if (speed >= 0)
                return this.getUploadInfo(wxSession, speed);

        }

        return res;
    }


    public JSONObject getLastSpeed(WxSession wxSession) {
        JSONObject res = new JSONObject();
        WxUserSpeed wxUserSpeed = wxUserSpeedDao.findByUserId(wxSession.getWxUserBo().getWxUser().getId());
        if (wxUserSpeed == null) {
            res.put("info", "你还没有测过速");
            return res;
        } else {
            String info;
            if (wxUserSpeed.getSpeed().doubleValue() > 1024) {
                BigDecimal b = new BigDecimal(wxUserSpeed.getSpeed().doubleValue() / 1024);
                info = "历史最高速度为：" + b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "M,";
            } else {
                BigDecimal b = new BigDecimal(wxUserSpeed.getSpeed().doubleValue());
                info = "历史最高速度为：" + b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "K,";
            }
            int rank = wxUserSpeedDao.findRankByUserid(wxSession.getWxUserBo().getWxUser().getId());
            info = info + "排名第" + rank + ".";
            int all = wxUserSpeedDao.findAllSpeedUser();
            double dall=all;
            double drank=rank;
            
            BigDecimal per = new BigDecimal(((dall - drank) * 100 / dall) );
            
            info = info + "<br/>你击败了" + per.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "%的人";
            res.put("info", info);
            return res;
        }
    }

    public JSONObject getUploadInfo(WxSession wxSession, double speed) {
        JSONObject res = new JSONObject();
        WxUserSpeed wxUserSpeed = wxUserSpeedDao.findByUserId(wxSession.getWxUserBo().getWxUser().getId());
        WxTestSpeedLog wxTestSpeedLog = new WxTestSpeedLog();
        wxTestSpeedLog.setId(WxUtils.getSeqencesValue().longValue());
        wxTestSpeedLog.setUserId(wxSession.getWxUserBo().getWxUser().getId());
        wxTestSpeedLog.setSpeed(new BigDecimal(speed));
        wxTestSpeedLog.setSpeedDate(new Date());
        wxTestSpeedLogDao.save(wxTestSpeedLog);
        if (wxUserSpeed == null) {
            wxUserSpeed = new WxUserSpeed();
            wxUserSpeed.setUserId(wxSession.getWxUserBo().getWxUser().getId());
            wxUserSpeed.setSpeed(new BigDecimal(speed));
            wxUserSpeed.setSpeedDate(new Date());
            wxUserSpeedDao.save(wxUserSpeed);
        } else {
            if (speed > wxUserSpeed.getSpeed().doubleValue()) {
                wxUserSpeed.setSpeed(new BigDecimal(speed));
                wxUserSpeed.setSpeedDate(new Date());
                wxUserSpeedDao.save(wxUserSpeed);
            }
        }
        String info = "";
        String lastSpeed = "";
        if (wxUserSpeed.getSpeed().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() < 1024)
            lastSpeed = "历时最高速度为" + wxUserSpeed.getSpeed().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "k,";
        else {
            BigDecimal bb = new BigDecimal(wxUserSpeed.getSpeed().doubleValue() / 1024);
            lastSpeed = "历时最高速度为" + bb.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "M,";
        }

        if (speed < 1024) {
            BigDecimal b = new BigDecimal(speed);
            info = "你本次的速度为：" + b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "K,<br/>" + lastSpeed;
        }
        if (speed > 1024 && speed < 100 * 1024) {
            BigDecimal b = new BigDecimal(speed / 1024);
            info = "你本次的速度为：" + b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "M,<br/>" + lastSpeed;
        }
        if (speed > 100 * 1024) {
            BigDecimal b = new BigDecimal(speed / 1024);
            info = "哇，本次速度爆表：" + b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "M,<br/>" + lastSpeed;
        }
        int rank = wxUserSpeedDao.findRankByUserid(wxUserSpeed.getUserId());
        info = info + "排名第" + rank + ".";
        int all = wxUserSpeedDao.findAllSpeedUser();
        info = info + "<br/>你击败了" + ((all - rank) * 100 /(all)) + "%的人,";
        res.put("info", info);
        return res;
    }

}



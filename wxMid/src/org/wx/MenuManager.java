package org.wx;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import org.WxBeanFactoryImpl;

import org.dao.WxAppDao;
import org.dao.WxMenuDao;

import org.entity.WxApp;
import org.entity.menu.WxClickMenu;
import org.entity.menu.WxComplexMenu;
import org.entity.menu.WxMenu;

import org.entity.menu.WxViewMenu;

import org.menu.Button;
import org.menu.ClickButton;
import org.menu.ComplexButton;
import org.menu.Menu;
import org.menu.ViewButton;

import org.pojo.Token;


import org.util.CommonUtil;
import org.util.MenuUtil;


public class MenuManager {
    private String viewMenuAuthUrl =
        "https://open.weixin.qq.com/connect/oauth2/authorize?" + "appid=APPID&redirect_uri=URI&response_type=RES_TYPE" +
        "&scope=SCOPE&state=STATE#wechat_redirect";
    String appName;
    WxMenuDao wxMenuDao;
    WxAppDao wxAppDao;


    public MenuManager(String appName) {
        this.appName = appName;
        wxMenuDao = WxBeanFactoryImpl.getInstance().getBean("wxMenuDao", WxMenuDao.class);
        wxAppDao = WxBeanFactoryImpl.getInstance().getBean("wxAppDao", WxAppDao.class);
    }


    private Menu initMenu() {
        WxApp wxApp = wxAppDao.findByAppName(appName);
        List<WxMenu> rootWxMenus = wxMenuDao.findAppRootMenus(wxApp.getId());
        List<Button> rootBottons = new ArrayList<>();
        for (WxMenu wm : rootWxMenus) {
            Button menu = this.init(wm);
            rootBottons.add(menu);
        }
        return new Menu(rootBottons.toArray(new Button[rootBottons.size()]));
    }


    private Button init(WxMenu wxMenu) {
        if (wxMenu instanceof WxClickMenu) {
            //System.out.println("clickBtn:" + wxMenu.getName());
            WxClickMenu wcm = (WxClickMenu) wxMenu;
            return this.init(wcm);
        }
        if (wxMenu instanceof WxViewMenu) {
            //System.out.println("ViewkBtn:" + wxMenu.getName());
            WxViewMenu wvm = (WxViewMenu) wxMenu;
            return this.init(wvm);
        }
        if (wxMenu instanceof WxComplexMenu) {
            //System.out.println("WxComplexMenu:" + wxMenu.getName());
            WxComplexMenu wcm = (WxComplexMenu) wxMenu;
            return this.init(wcm);
        }
        Logger.getLogger(MenuManager.class).error("url is null");
        return null;

    }

    private Button init(WxClickMenu wxMenu) {
        ClickButton btn = new ClickButton(wxMenu.getName(), wxMenu.getKey());
        return btn;
    }

    private Button init(WxViewMenu wvm) {
        WxApp wxApp = wxAppDao.findByAppName(appName);
        String url = viewMenuAuthUrl.replace("APPID", wxApp.getId());
        url = url.replace("URI", wvm.getBaseAddr() + wvm.getTargetUrl());
        url = url.replace("RES_TYPE", wvm.getRtype() == null ? "code" : wvm.getRtype());
        url = url.replace("SCOPE", wvm.getScope() == null ? "snsapi_base" : wvm.getScope());
        url = url.replace("STATE", wvm.getState() == null ? wxApp.getAppName() : wvm.getState());
        ViewButton btn = new ViewButton(wvm.getName(), url);
        System.out.println("name=" + btn.getName() + " url=" + btn.getUrl());
        return btn;

    }

    private Button init(WxComplexMenu wxMenu) {
        List<WxMenu> children = wxMenuDao.findByParentMenu(wxMenu);
        List<Button> childrenButtons = new ArrayList<>();
        for (WxMenu wm : children) {
            if (wm.isValid())
                childrenButtons.add(this.init(wm));
        }
        Button[] btnArray = childrenButtons.toArray(new Button[childrenButtons.size()]);
        ComplexButton btn = new ComplexButton(wxMenu.getName(), btnArray);
        return btn;
   }

    public void PushMenu() {
        Menu menu = this.initMenu();
        WxAppManager wam = WxBeanFactoryImpl.getInstance().getWxAppManager(appName);
        Token token = wam.getOperator().getToken();
        boolean result = MenuUtil.createMenu(menu, token.getAccessToken());
        // 判断菜单创建结果
        if (result)
            Logger.getLogger(MenuManager.class).info("菜单创建成功！");
        else
            Logger.getLogger(MenuManager.class).info("菜单创建失败！");
    }

    public static void main(String[] args) {
        MenuManager mm = new MenuManager("yctxq");
        mm.PushMenu();
    };
}


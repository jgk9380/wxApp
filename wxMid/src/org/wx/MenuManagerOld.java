package org.wx;

import org.menu.Button;
import org.menu.ClickButton;
import org.menu.ComplexButton;
import org.menu.Menu;
import org.menu.ViewButton;

import org.pojo.Token;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.util.CommonUtil;
import org.util.MenuUtil;


public class MenuManagerOld {
    String viewMenuAuthUrl="https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=URI&response_type=RTYPE&scope=SCOPE&state=STATE#wechat_redirect";
    String appName;
    public MenuManagerOld(String appName){
        this.appName=appName;
    }
    private static Logger log = LoggerFactory.getLogger(MenuManagerOld.class);

    /**
     * 定义菜单结构     
     * @return
     */
    private  Menu getMenuTest() {
        ClickButton btn11 = new ClickButton("二维推广", "ertg");
        ViewButton btn21 =
            new ViewButton("刮刮卡",
                           "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx7dcc6b2e03a47c0b" +
                           "&redirect_uri=http://www.ycunicom.com/wx2/oAuthServlet?target=ggk&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect");
        ClickButton btn22 = new ClickButton("开心一笑", "kxyx");
        ViewButton btn23 =
            new ViewButton("我的账本",
                           "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx7dcc6b2e03a47c0b&redirect_uri=http://www.ycunicom.com/wx2/oAuthServlet?target=account&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect");
        ViewButton btn24 =
            new ViewButton("抢钱了",
                           "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx7dcc6b2e03a47c0b&redirect_uri=http://www.ycunicom.com/wx2/oAuthServlet?target=money&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect");
        ViewButton btn25 =
            new ViewButton("神经猫",
                           "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx7dcc6b2e03a47c0b&redirect_uri=http://www.ycunicom.com/wx2/oAuthServlet?target=money&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect");
        ComplexButton mainBtn2 = new ComplexButton("娱乐有奖", new Button[] { btn21, btn22, btn23,btn24,btn25 });
        ViewButton btn31 =
            new ViewButton("绑定号码",
                           "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx7dcc6b2e03a47c0b&redirect_uri=http://www.ycunicom.com/wx2/oAuthServlet?target=bind&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect");
        
        ClickButton btn33 = new ClickButton("业务查询", "ywcx");
        ComplexButton mainBtn3 = new ComplexButton("自助服务", new Button[] { btn31,  btn33 });
        
        Menu menu = new Menu(new Button[] { btn11, mainBtn2,mainBtn3 });


        return menu;
    }
    
    private  static  Menu getMenu() {
        return null;
    }
    
    private void PushMenu(){
        
    }
    public static void main(String[] args) {
        
        // 第三方用户唯一凭证
        String appId = "wx7dcc6b2e03a47c0b";
        // 第三方用户唯一凭证密钥
        String appSecret = "fb845f65afd06d318e7a961d867f877f";

        // 调用接口获取凭证
        Token token = CommonUtil.getToken(appId, appSecret);

        if (null != token) {
            // 创建菜单
            boolean result = MenuUtil.createMenu(getMenu(), token.getAccessToken());
            // 判断菜单创建结果
            if (result)
                log.info("菜单创建成功！");
            else
                log.info("菜单创建失败！");
        }
    }
}


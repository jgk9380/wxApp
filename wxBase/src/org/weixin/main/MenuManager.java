
package org.weixin.main;

import org.menu.Button;
import org.menu.ClickButton;
import org.menu.ComplexButton;
import org.menu.Menu;
import org.menu.ViewButton;
import org.pojo.Token;
import org.util.CommonUtil;
import org.util.MenuUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * �˵���������
 *
 * @author liufeng
 * @date 2013-10-17
 */
public class MenuManager {
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);

    /**
     * ����˵��ṹ
     *
     * @return
     */
    private static Menu getMenu() {
        ClickButton btn11 = new ClickButton();
        btn11.setName("����1");
        btn11.setType("click");
        btn11.setKey("oschina");
        ViewButton btn13 = new ViewButton();
        btn13.setName("����21");
        btn13.setType("view");
        btn13.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx7dcc6b2e03a47c0b&redirect_uri=http%3A%2F%2F122.194.14.94%3A8003%2Fwechatservice%2Fbill%3Fdeveloperopenid%3oEsXmwWQkf6V5KaLUMHCQHpC8F1E&response_type=code&scope=snsapi_base&state=4#wechat_redirect");
        
        ViewButton btn14 = new ViewButton();
        btn14.setName("����3");
        btn14.setType("view");
        btn14.setUrl("http://www.ycunicom.com/wx06/oauthServlet");
        
        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("����");
        mainBtn1.setSub_button(new Button[] { btn11, btn13,btn14 });

//        ComplexButton mainBtn2 = new ComplexButton();
//        mainBtn2.setName("����");
//        mainBtn2.setSub_button(new Button[] { btn21, btn22, btn23, btn24, btn25 });
//        ComplexButton mainBtn3 = new ComplexButton();
//        mainBtn3.setName("��ҳ��Ϸ");
//        mainBtn3.setSub_button(new Button[] { btn31, btn32 });

        Menu menu = new Menu();
        menu.setButton(new Button[] { mainBtn1 });

        return menu;
    }

    public static void main(String[] args) {
        // �������û�Ψһƾ֤
        String appId = "wx7dcc6b2e03a47c0b";
        // �������û�Ψһƾ֤��Կ
        String appSecret = "fb845f65afd06d318e7a961d867f877f";

        // ���ýӿڻ�ȡƾ֤
        Token token = CommonUtil.getToken(appId, appSecret);

        if (null != token) {
            // �����˵�
            boolean result = MenuUtil.createMenu(getMenu(), token.getAccessToken());
            // �жϲ˵��������
            if (result)
                log.info("�˵������ɹ���");
            else
                log.info("�˵�����ʧ�ܣ�");
            
        }
    }
}

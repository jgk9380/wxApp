package org.dao;

import com.thoughtworks.xstream.core.JVM;


import java.lang.reflect.InvocationTargetException;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import java.util.function.Function;

import javax.transaction.Transactional;

import javax.xml.parsers.DocumentBuilderFactory;

import org.WxBeanFactoryImpl;

import org.entity.WxApp;

import org.entity.asserts.WxAssert;
import org.entity.WxPromotionGift;
import org.entity.WxUser;
import org.entity.menu.WxMenu;

import org.entity.menu.WxViewMenu;
import org.entity.qrcode.WxQrCode;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import org.wx.WxAppManager;

/**   You are using the buggy parser. Please define in the Eclipse Window->Preferences->Tomcat->JVM settings:
        -Djavax.xml.parsers.SAXParserFactory=com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl
        -Djavax.xml.parsers.DocumentBuilderFactory=com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl
        Or it must be defined in the VM-Parameters of your Run-Configuration if you use the main()-method.
 */

public class Test {


    public void testFind(String id) {
        //        WxPromotionGift wml = wxPromotionGiftDao.findById(id);
        // System.out.println(wml.getGiftModel().getClass());
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException,
                                                  InvocationTargetException {
        //property javax.xml.parsers.DocumentBuilderFactory with the value org.apache.xerces.jaxp.DocumentBuilderFactoryImpl
        //        WxQrCodeDao wxMenuDao = WxBeanFactoryImpl.getInstance().getBean("wxQrCodeDao", WxQrCodeDao.class);
        //        WxQrCode wqc=wxMenuDao.findCouponQrCodeByScenenId(112);
        //        System.out.println(wqc);

        ArrayList<Integer> arrayList3 = new ArrayList<Integer>();
        arrayList3.add(1); //这样调用add方法只能存储整形，因为泛型类型的实例为Integer
        arrayList3.getClass().getMethod("add", Object.class).invoke(arrayList3, "asd");
        for (int i = 0; i < arrayList3.size(); i++) {
            System.out.println(arrayList3.get(i));
        }

    }
}

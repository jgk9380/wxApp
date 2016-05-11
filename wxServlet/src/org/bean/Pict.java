package org.bean;

import java.awt.Image;

import java.awt.image.BufferedImage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.WxBeanFactoryImpl;

import org.util.PictUtils;

@ManagedBean(name = "pict")
@SessionScoped
public class Pict {
    public Pict() {
    }

    public Image getImage() {
        PictUtils pictUtil = new PictUtils();
        BufferedImage source = pictUtil.loadImageLocal("D:\\image\\sharebase.jpg");
        return source;
    }

    public static void main(String[] args) {
//        String ticket =
//            WxBeanFactoryImpl.getInstance().getConfigWxAppManager().getOperator().getJsApiTicket().getTicket();
    }
}

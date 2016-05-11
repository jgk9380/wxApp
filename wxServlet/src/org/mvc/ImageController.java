package org.mvc;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import java.awt.image.BufferedImage;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.WxBeanFactoryImpl;

import org.dao.WxAssertDao;
import org.dao.WxPromotionGiftDao;
import org.dao.WxUserDao;

import org.entity.WxPromotionGift;
import org.entity.WxUser;

import org.entity.asserts.WxAssert;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.util.GGKPicUtils;

import org.wx.bo.WxQrCodeProxyImpl;

@Controller
@RequestMapping("/image")
public class ImageController {
    private static final String JPG = "image/jpeg;charset=GB2312";

    public ImageController() {
        super();
    }

    @RequestMapping(value = "/userQrCode/{userId}", method = RequestMethod.GET)
    public void getUserQrImage(@PathVariable("userId") Long userId, HttpServletResponse response) throws IOException {
        WxBeanFactoryImpl wbfi = (WxBeanFactoryImpl) WxBeanFactoryImpl.getInstance();
        WxUser wxUser = wbfi.getBean("wxUserDao", WxUserDao.class).findById(userId);
        byte[] pictA = wbfi.getUserBo(wxUser).getQrCode();
        OutputStream output = response.getOutputStream();
        {
            response.setContentType(JPG);
            InputStream imageIn = new ByteArrayInputStream(pictA);
            JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(imageIn);
            BufferedImage image = decoder.decodeAsBufferedImage();
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(output);
            encoder.encode(image);
            imageIn.close();
        }
        output.close();
    }


    @RequestMapping(value = "/couponQrCode/{couponId}", method = RequestMethod.GET)
    public void getCouponQrImage(@PathVariable("couponId") Long couponId,
                                 HttpServletResponse response) throws IOException {
        WxQrCodeProxyImpl wxQrCodeProxyImpl = new WxQrCodeProxyImpl();
        byte[] pictA = wxQrCodeProxyImpl.getCouponQrCode(couponId).getWxMedia().getContent();
        OutputStream output = response.getOutputStream();
        {
            response.setContentType(JPG);
            InputStream imageIn = new ByteArrayInputStream(pictA);
            JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(imageIn);
            BufferedImage image = decoder.decodeAsBufferedImage();
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(output);
            encoder.encode(image);
            imageIn.close();
        }
        output.close();
    }

    @RequestMapping(value = "/ggk/{ggkId}", method = RequestMethod.GET)
    public void getGgkImage(@PathVariable("ggkId") String ggkId, HttpServletResponse response) throws IOException {
        WxBeanFactoryImpl wbfi = (WxBeanFactoryImpl) WxBeanFactoryImpl.getInstance();
        GGKPicUtils ggkp = new GGKPicUtils();
        WxPromotionGiftDao wxPromotionGiftDao = wbfi.getBean("wxPromotionGiftDao", WxPromotionGiftDao.class);
        WxPromotionGift wpg = wxPromotionGiftDao.findById(ggkId);
        byte[] pictA = ggkp.getGgkPictureBytes(wpg);
        OutputStream output = response.getOutputStream();
        {
            response.setContentType(JPG);
            InputStream imageIn = new ByteArrayInputStream(pictA);
            JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(imageIn);
            BufferedImage image = decoder.decodeAsBufferedImage();
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(output);
            encoder.encode(image);
            imageIn.close();
        }

        output.close();
    }
}

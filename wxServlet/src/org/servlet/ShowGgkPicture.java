package org.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.sun.image.codec.jpeg.*;

//sun公司仅提供了jpg图片文件的编码api
import javax.imageio.stream.*;

import java.awt.*;
import java.awt.image.BufferedImage;

import org.WxBeanFactoryImpl;

import org.dao.WxPromotionGiftDao;

import org.entity.WxPromotionGift;

import org.springframework.beans.factory.annotation.Autowired;

import org.util.GGKPicUtils;


@WebServlet(name = "ShowGgkPicture", urlPatterns = { "/showGgkPicture" })
public class ShowGgkPicture extends HttpServlet {
    @SuppressWarnings("compatibility:338074665803787209")
    private static final long serialVersionUID = 1L;
    private static final String GIF = "image/gif;charset=GB2312";
    //设定输出的类型
    private static final String JPG = "image/jpeg;charset=GB2312";


    public void init() throws ServletException {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("gb2312");
        response.setCharacterEncoding("gb2312");
        String userId = request.getParameter("userId");

        //输出图片的类型的标志　　　
        GGKPicUtils ggkp = new GGKPicUtils();
        String giftId = request.getParameter("giftId");
        if (giftId == null)
            return;
        WxBeanFactoryImpl wbfi = (WxBeanFactoryImpl) WxBeanFactoryImpl.getInstance();

        WxPromotionGiftDao wxPromotionGiftDao = wbfi.getBean("wxPromotionGiftDao", WxPromotionGiftDao.class);
        WxPromotionGift wpg = wxPromotionGiftDao.findById(giftId);
        byte[] pictA = ggkp.getGgkPictureBytes(wpg);
        OutputStream output = response.getOutputStream();
        //得到输出流

        //使用编码处理文件流的情况：
        {
            response.setContentType(JPG);
            //设定输出的类型
            //得到图片的真实路径
            //imagePath = getServletContext().getRealPath(imagePath);
            //得到图片的文件流
            InputStream imageIn = new ByteArrayInputStream(pictA);
            ;
            //得到输入的编码器，将文件流进行jpg格式编码
            JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(imageIn);
            //得到编码后的图片对象
            BufferedImage image = decoder.decodeAsBufferedImage();
            //得到输出的编码器
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(output);
            encoder.encode(image);
            //对图片进行输出编码
            imageIn.close();
            //关闭文件流
        }

        output.close();
    }
}

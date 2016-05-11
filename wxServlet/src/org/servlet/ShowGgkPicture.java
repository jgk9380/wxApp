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

//sun��˾���ṩ��jpgͼƬ�ļ��ı���api
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
    //�趨���������
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

        //���ͼƬ�����͵ı�־������
        GGKPicUtils ggkp = new GGKPicUtils();
        String giftId = request.getParameter("giftId");
        if (giftId == null)
            return;
        WxBeanFactoryImpl wbfi = (WxBeanFactoryImpl) WxBeanFactoryImpl.getInstance();

        WxPromotionGiftDao wxPromotionGiftDao = wbfi.getBean("wxPromotionGiftDao", WxPromotionGiftDao.class);
        WxPromotionGift wpg = wxPromotionGiftDao.findById(giftId);
        byte[] pictA = ggkp.getGgkPictureBytes(wpg);
        OutputStream output = response.getOutputStream();
        //�õ������

        //ʹ�ñ��봦���ļ����������
        {
            response.setContentType(JPG);
            //�趨���������
            //�õ�ͼƬ����ʵ·��
            //imagePath = getServletContext().getRealPath(imagePath);
            //�õ�ͼƬ���ļ���
            InputStream imageIn = new ByteArrayInputStream(pictA);
            ;
            //�õ�����ı����������ļ�������jpg��ʽ����
            JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(imageIn);
            //�õ�������ͼƬ����
            BufferedImage image = decoder.decodeAsBufferedImage();
            //�õ�����ı�����
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(output);
            encoder.encode(image);
            //��ͼƬ�����������
            imageIn.close();
            //�ر��ļ���
        }

        output.close();
    }
}

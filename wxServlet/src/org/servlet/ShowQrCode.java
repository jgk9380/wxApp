package org.servlet;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import java.awt.image.BufferedImage;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.WxBeanFactoryImpl;

import org.dao.WxUserDao;

import org.entity.WxUser;

import org.util.GGKPicUtils;

@WebServlet(name = "ShowQrCode", urlPatterns = { "/showqrcode" })
public class ShowQrCode extends HttpServlet {
    @SuppressWarnings("compatibility:475108535399448914")
    private static final long serialVersionUID = 1L;
    private static final String CONTENT_TYPE = "text/html; charset=GBK";
    private static final String JPG = "image/jpeg;charset=GB2312";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("gb2312");
        response.setCharacterEncoding("gb2312");
        String userId = request.getParameter("userId");
        
        if (userId == null)
            userId = "11333";
        //输出图片的类型的标志　　　
        GGKPicUtils ggkp = new GGKPicUtils();

        WxBeanFactoryImpl wbfi = (WxBeanFactoryImpl) WxBeanFactoryImpl.getInstance();
        WxUser wxUser=wbfi.getBean("wxUserDao", WxUserDao.class).findById(Long.parseLong(userId));
       
        byte[] pictA = wbfi.getUserBo(wxUser).getQrCode();
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


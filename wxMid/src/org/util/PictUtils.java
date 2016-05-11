package org.util;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import java.net.URL;


public class PictUtils {

    private Font font = new Font("����", Font.PLAIN, 40); // ����������������

    private Graphics2D g = null;

    private int fontsize = 0;

    private int x = 0;

    private int y = 0;

    /**
     * ���뱾��ͼƬ��������
     */
    public BufferedImage loadImageLocal(String imgName) {
        try {
            return ImageIO.read(new File(imgName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * ��������ͼƬ��������
     */
    public BufferedImage loadImageUrl(String imgName) {
        try {
            URL url = new URL(imgName);
            return ImageIO.read(url);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * ������ͼƬ������
     */
    public void writeImageLocal(String newImage, BufferedImage img) {
        //System.out.println("new Image="+newImage);
        if (newImage != null && img != null) {
            try {
                File outputfile = new File(newImage);
                ImageIO.write(img, "jpg", outputfile);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * �趨���ֵ������
     */
    public void setFont(String fontStyle, int fontSize) {
        this.fontsize = fontSize;
        this.font = new Font(fontStyle, Font.PLAIN, fontSize);
    }

    /**
     * �޸�ͼƬ,�����޸ĺ��ͼƬ��������ֻ���һ���ı���
     */
    public BufferedImage modifyImage(BufferedImage img, String content, int x, int y) {
        try {
            int w = img.getWidth();
            int h = img.getHeight();
            g = img.createGraphics();
            g.setBackground(Color.WHITE);
            g.setColor(Color.magenta); //����������ɫ
            if (this.font != null)
                g.setFont(this.font);
            // ��֤���λ�õ�������ͺ�����
            if (x >= h || y >= w) {
                this.x = h - this.fontsize + 2;
                this.y = w;
            } else {
                this.x = x;
                this.y = y;
            }
            if (content != null) {
                g.drawString(content, this.x, this.y);
            }
            g.dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return img;
    }


    /**
     * �޸�ͼƬ,�����޸ĺ��ͼƬ��������ֻ���һ���ı���
     *
     * ʱ��:2007-10-8
     *
     * @param img
     * @return
     */
    public BufferedImage modifyImageYe(BufferedImage img) {

        try {
            int w = img.getWidth();
            int h = img.getHeight();
            g = img.createGraphics();
            g.setBackground(Color.WHITE);
            g.setColor(Color.blue); //����������ɫ
            if (this.font != null)
                g.setFont(this.font);
            g.drawString("www.hi.baidu.com?xia_mingjian", w - 85, h - 5);
            g.dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return img;
    }

    public BufferedImage modifyImagetogeter(BufferedImage target, BufferedImage source, int xpos, int ypos) {

        try {
            int w = target.getWidth();
            int h = target.getHeight();
            g = source.createGraphics();
            g.drawImage(target, xpos, ypos, w, h, null);
            g.dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return source;
    }

    public BufferedImage convertImageToBuffer(Image pic) {
        BufferedImage bufferedImage =
            new BufferedImage(pic.getWidth(null), pic.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.createGraphics();
        g.drawImage(pic, 0, 0, null);
        g.dispose();
        return bufferedImage;
    }


    public BufferedImage convertByteArrayToImage(byte[] ba) {
        ByteArrayInputStream in = new ByteArrayInputStream(ba); //��b��Ϊ��������
        try {
            BufferedImage image = ImageIO.read(in);
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] getGgk(String ggkId, String giftConet) {
        return null;
    }

    public static void main(String[] args) {
        PictUtils pictUtil = new PictUtils();
        //        BufferedImage source = pictUtil.loadImageLocal("D:\\image\\cc.jpg");
        //        BufferedImage target = pictUtil.loadImageLocal("D:\\image\\11.jpg");
        //        pictUtil.writeImageLocal("D:\\image\\cc.jpg", pictUtil.modifyImage(source, "\"�����123\"", 100, 245));
        //        Image sc = target.getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        //        BufferedImage bi = pictUtil.convertImageToBuffer(sc);
        //        pictUtil.writeImageLocal("D:\\image\\cc.jpg", pictUtil.modifyImagetogeter(bi, source, 430, 700));
        //        //������ͼƬ����һ��
        //        System.out.println("success");
        //        String ggkId = "akjdfl;kj;";
        //        String giftConet = "����0.18Ԫ";
        //        BufferedImage source = pictUtil.loadImageLocal("D:\\image\\ggk.png");
        //        BufferedImage t1 = pictUtil.modifyImage(source, "���:" + ggkId, 20, 100);
        //        //BufferedImage t2 = pictUtil.modifyImage(source, giftConet, 20, 100);
        //        pictUtil.writeImageLocal("D:\\image\\ccdd.jpg", t1);

    }

}

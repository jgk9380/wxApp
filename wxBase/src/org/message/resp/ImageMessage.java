package org.message.resp;

/**
 * ͼƬ��Ϣ
 * 
 * @author liufeng
 * @date 2013-09-11
 */
public class ImageMessage extends BaseMessage {
	// ͼƬ
	private Image Image;

    public ImageMessage() {
         
    }

    public Image getImage() {
		return Image;
	}

	public void setImage(Image image) {
		Image = image;
	}
}

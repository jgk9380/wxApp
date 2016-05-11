package org.menu;

/**
 * ²Ëµ¥
 * 
 * @author liufeng
 * @date 2013-10-15
 */
public class Menu {
    public Menu() {
         
    }
    public Menu(Button[] button) {
        this.button = button;
    }
    private Button[] button;

	public Button[] getButton() {
		return button;
	}

	public void setButton(Button[] button) {
		this.button = button;
	}
}

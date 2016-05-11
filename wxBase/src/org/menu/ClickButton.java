package org.menu;

/**
 * click���͵İ�ť
 *
 * @author liufeng
 * @date 2013-10-14
 */
public class ClickButton extends Button {
    private String type;
    private String key;

    public ClickButton() {
        super();
    }

    public ClickButton(String name, String key) {
        super(name);
        this.type = "click";
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

package com.xrkj.app.webapp.common.viewObj;

public class TestVo {

    private String name;

    private int type;

    private byte[] image;

    /**
     * <pre>
     * 构造方法
     * </pre>
     *
     */
    public TestVo() {
    }

    /**
     * <pre>
     * 构造方法
     * </pre>
     *
     * @param name
     * @param type
     */
    public TestVo(String name, int type) {
        this.name = name;
        this.type = type;
    }

    /**
     * 获取 name
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 name
     *
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 type
     *
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * 设置 type
     *
     * @param type
     *            the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * 获取 image
     *
     * @return the image
     */
    public byte[] getImage() {
        return image;
    }

    /**
     * 设置 image
     *
     * @param image
     *            the image to set
     */
    public void setImage(byte[] image) {
        this.image = image;
    }

}

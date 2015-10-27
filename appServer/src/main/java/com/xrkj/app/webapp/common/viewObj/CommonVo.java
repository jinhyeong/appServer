package com.xrkj.app.webapp.common.viewObj;

/**
 * 通用传输层对象
 * 
 * @author ww
 *
 */
// 如果要支持XML，需要增加以下注解
// @XmlRootElement(name = "CommonVo")

public class CommonVo {
    private String key;
    private String value;

    /**
     * <pre>
     * 构造方法
     * </pre>
     *
     */
    public CommonVo() {
    }

    /**
     * <pre>
     * 构造方法
     * </pre>
     *
     * @param key
     * @param value
     */
    public CommonVo(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuffer sbf = new StringBuffer();
        sbf.append("key = ");
        sbf.append(getKey());
        sbf.append("    value = ");
        sbf.append(getValue());
        return sbf.toString();
    }
}

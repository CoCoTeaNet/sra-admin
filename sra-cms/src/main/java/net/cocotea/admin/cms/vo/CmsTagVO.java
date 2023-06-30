package net.cocotea.admin.cms.vo;

import java.io.Serializable;

/**
 * @date 2022-8-17 22:10:43
 * @author CoCoTea
 */
public class CmsTagVO implements Serializable {
    private static final long serialVersionUID = 1761282241292722215L;

    private String tagName;
    private String color;

    public String getTagName() {
        return tagName;
    }

    public CmsTagVO setTagName(String tagName) {
        this.tagName = tagName;
        return this;
    }

    public String getColor() {
        return color;
    }

    public CmsTagVO setColor(String color) {
        this.color = color;
        return this;
    }
}

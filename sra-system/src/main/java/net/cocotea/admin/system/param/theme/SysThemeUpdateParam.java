package net.cocotea.admin.system.param.theme;

import java.io.Serializable;
import com.alibaba.fastjson.JSONObject;

import javax.validation.constraints.NotBlank;

/**
* 系统主题表
*
* @author CoCoTea 572315466@qq.com
* @since 1.2.4 2023-02-25
*/
public class SysThemeUpdateParam implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *系统主题ID
	 */
	@NotBlank(message = "系统主题ID不能为空")
	private String ID;

	/**
	 *布局模式：0默认
	 */
	private Integer layoutMode;

	/**
	 *主题颜色
	 */
	private String primaryColor;

	/**
	 *颜色2
	 */
	private String color2;

	/**
	 *颜色3
	 */
	private String color3;

	/**
	 *颜色4
	 */
	private String color4;

	/**
	 *是否暗黑模式：0否 1是
	 */
	private Integer isDark;


	public String getID() {
		return ID;
	}

	public SysThemeUpdateParam setID(String ID) {
		this.ID = ID;
		return this;
	}
	public Integer getLayoutMode() {
		return layoutMode;
	}

	public SysThemeUpdateParam setLayoutMode(Integer layoutMode) {
		this.layoutMode = layoutMode;
		return this;
	}
	public String getPrimaryColor() {
		return primaryColor;
	}

	public SysThemeUpdateParam setPrimaryColor(String primaryColor) {
		this.primaryColor = primaryColor;
		return this;
	}
	public String getColor2() {
		return color2;
	}

	public SysThemeUpdateParam setColor2(String color2) {
		this.color2 = color2;
		return this;
	}
	public String getColor3() {
		return color3;
	}

	public SysThemeUpdateParam setColor3(String color3) {
		this.color3 = color3;
		return this;
	}
	public String getColor4() {
		return color4;
	}

	public SysThemeUpdateParam setColor4(String color4) {
		this.color4 = color4;
		return this;
	}
	public Integer getIsDark() {
		return isDark;
	}

	public SysThemeUpdateParam setIsDark(Integer isDark) {
		this.isDark = isDark;
		return this;
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
}
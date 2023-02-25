package net.cocotea.admin.system.entity;

import java.io.Serializable;
import org.sagacity.sqltoy.config.annotation.Entity;
import org.sagacity.sqltoy.config.annotation.Id;
import org.sagacity.sqltoy.config.annotation.Column;
import com.alibaba.fastjson.JSONObject;


/**
* 系统主题表
*
* @author CoCoTea 572315466@qq.com
* @since 1.2.4 2023-02-25
*/
@Entity(tableName="sys_theme")
public class SysTheme implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *系统主题ID
	 */
	@Id(strategy="generator",generator="org.sagacity.sqltoy.plugins.id.impl.UUIDGenerator")
	@Column(name="ID",type=java.sql.Types.VARCHAR)
	private String ID;
	/**
	 *用户ID
	 */
	@Column(name="USER_ID",type=java.sql.Types.VARCHAR)
	private String userId;
	/**
	 *布局模式：0默认
	 */
	@Column(name="LAYOUT_MODE",type=java.sql.Types.TINYINT)
	private Integer layoutMode;
	/**
	 *主题颜色
	 */
	@Column(name="PRIMARY_COLOR",type=java.sql.Types.VARCHAR)
	private String primaryColor;
	/**
	 *颜色2
	 */
	@Column(name="COLOR_2",type=java.sql.Types.VARCHAR)
	private String color2;
	/**
	 *颜色3
	 */
	@Column(name="COLOR_3",type=java.sql.Types.VARCHAR)
	private String color3;
	/**
	 *颜色4
	 */
	@Column(name="COLOR_4",type=java.sql.Types.VARCHAR)
	private String color4;
	/**
	 *是否暗黑模式：0否 1是
	 */
	@Column(name="IS_DARK",type=java.sql.Types.TINYINT)
	private Integer isDark;

	public String getID() {
		return ID;
	}

	public SysTheme setID(String ID) {
		this.ID = ID;
		return this;
	}
	public String getUserId() {
		return userId;
	}

	public SysTheme setUserId(String userId) {
		this.userId = userId;
		return this;
	}
	public Integer getLayoutMode() {
		return layoutMode;
	}

	public SysTheme setLayoutMode(Integer layoutMode) {
		this.layoutMode = layoutMode;
		return this;
	}
	public String getPrimaryColor() {
		return primaryColor;
	}

	public SysTheme setPrimaryColor(String primaryColor) {
		this.primaryColor = primaryColor;
		return this;
	}
	public String getColor2() {
		return color2;
	}

	public SysTheme setColor2(String color2) {
		this.color2 = color2;
		return this;
	}
	public String getColor3() {
		return color3;
	}

	public SysTheme setColor3(String color3) {
		this.color3 = color3;
		return this;
	}
	public String getColor4() {
		return color4;
	}

	public SysTheme setColor4(String color4) {
		this.color4 = color4;
		return this;
	}
	public Integer getIsDark() {
		return isDark;
	}

	public SysTheme setIsDark(Integer isDark) {
		this.isDark = isDark;
		return this;
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
}
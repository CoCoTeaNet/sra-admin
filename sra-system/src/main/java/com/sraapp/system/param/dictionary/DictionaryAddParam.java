package com.sraapp.system.param.dictionary;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author jwss
 * @project sss-rbac-admin
 * @version 1.0.0
 * @description sys_dictionary,系统字典表  
 */
public class DictionaryAddParam implements Serializable {
	private static final long serialVersionUID = -1767974905556894292L;

	@ApiModelProperty("父级ID")
	private String parentId;
	
	@ApiModelProperty("字典名称")
	private String dictionaryName;
	
	@ApiModelProperty("备注")
	private String remark;
	
	@ApiModelProperty("排序号")
	private Integer sort;
	
	@ApiModelProperty("启用状态;0关闭 1启用")
	private String enableStatus;

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getDictionaryName() {
		return dictionaryName;
	}

	public void setDictionaryName(String dictionaryName) {
		this.dictionaryName = dictionaryName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getEnableStatus() {
		return enableStatus;
	}

	public void setEnableStatus(String enableStatus) {
		this.enableStatus = enableStatus;
	}
}

package com.jwss.sra.system.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author jwss
 * @project sss-rbac-admin
 * @version 1.0.0
 * @description sys_dictionary,系统字典表  
 */
public class DictionaryVO implements Serializable {

	private static final long serialVersionUID = 79792592030448781L;
	
	@ApiModelProperty("主键id")
	private String id;
	
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

	@ApiModelProperty("创建人")
	private String createBy;

	@ApiModelProperty("子项")
	private List<DictionaryVO> children;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public List<DictionaryVO> getChildren() {
		return children;
	}

	public void setChildren(List<DictionaryVO> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "DictionaryVO{" +
				"id='" + id + '\'' +
				", parentId='" + parentId + '\'' +
				", dictionaryName='" + dictionaryName + '\'' +
				", remark='" + remark + '\'' +
				", sort=" + sort +
				", enableStatus='" + enableStatus + '\'' +
				", createBy='" + createBy + '\'' +
				", children=" + children +
				'}';
	}
}

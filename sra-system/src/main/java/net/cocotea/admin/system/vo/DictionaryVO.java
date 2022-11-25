package net.cocotea.admin.system.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author jwss
 * @project sss-rbac-admin
 * @version 1.0.0
 * @description sys_dictionary,系统字典表  
 */
public class DictionaryVO implements Serializable {

	private static final long serialVersionUID = 79792592030448781L;
	
	private String id;
	
	private String parentId;
	
	private String dictionaryName;
	
	private String remark;
	
	private Integer sort;
	
	private Integer enableStatus;

	private String createBy;

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

	public Integer getEnableStatus() {
		return enableStatus;
	}

	public DictionaryVO setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
		return this;
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

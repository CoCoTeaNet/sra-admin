package ${package}.${moduleName}.vo;

import java.io.Serializable;
import ${package}.framework.common.utils.DateUtils;
<#list importList as i>
import ${i!};
</#list>

/**
* ${tableComment}
*
* @author ${author} ${email}
* @since ${version} ${date}
*/
@Entity(tableName="${tableName}")
public class ${ClassName} implements Serializable {
	private static final long serialVersionUID = 1L;

<#list fieldList as field>
	<#if field.fieldComment!?length gt 0>
	/**
	 *${field.fieldComment}
	 */
	</#if>
	<#if field.fieldName == "ID">
	@Id(strategy="generator",generator="org.sagacity.sqltoy.plugins.id.impl.UUIDGenerator")
	</#if>
	@Column(name="${field.fieldName}",type=java.sql.Types.${field.fieldType?upper_case})
	private ${field.attrType} ${field.attrName};

</#list>

<#list fieldList as field>
	public ${field.attrType} getParentId() {
		return ${field.attrName};
	}

	public void setParentId(${field.attrType} ${field.attrName}) {
		this.${field.attrName} = ${field.attrName};
	}

</#list>

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
}
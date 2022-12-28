package ${package}.${moduleName}.entity;

import java.io.Serializable;
import org.sagacity.sqltoy.config.annotation.Entity;
import org.sagacity.sqltoy.config.annotation.Id;
import org.sagacity.sqltoy.config.annotation.Column;
import com.alibaba.fastjson.JSONObject;

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
	@Column(name="${field.fieldName}",type=java.sql.Types.<#if field.fieldType == "int">INTEGER<#elseif field.fieldType == "datetime">TIMESTAMP<#else>${field.fieldType?upper_case}</#if>)
	private ${field.attrType} ${field.attrName};
</#list>

<#list fieldList as field>
	public ${field.attrType} get${field.attrName?cap_first}() {
		return ${field.attrName};
	}

	public ${ClassName} set${field.attrName?cap_first}(${field.attrType} ${field.attrName}) {
		this.${field.attrName} = ${field.attrName};
		return this;
	}
</#list>

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
}
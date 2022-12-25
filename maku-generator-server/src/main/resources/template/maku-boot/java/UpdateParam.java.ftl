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
public class ${ClassName}UpdateParam implements Serializable {
	private static final long serialVersionUID = 1L;

<#list fieldList as field>
	<#if field.fieldComment!?length gt 0>
	/**
	 *${field.fieldComment}
	 */
	</#if>
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
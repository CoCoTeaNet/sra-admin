package ${package}.${moduleName}.param.${functionName};

import java.io.Serializable;
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
public class ${ClassName}AddParam implements Serializable {
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
	public ${field.attrType} get${field.attrName?cap_first}() {
		return ${field.attrName};
	}

	public ${ClassName}AddParam set${field.attrName?cap_first}(${field.attrType} ${field.attrName}) {
		this.${field.attrName} = ${field.attrName};
		return this;
	}
</#list>

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
}
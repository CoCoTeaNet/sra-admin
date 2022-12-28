/**
* @author ${author} ${email}
* @since ${version} ${date}
* ${tableComment}
*/
interface ${ClassName}Model {

<#list fieldList as field>
    <#if field.fieldComment!?length gt 0>
    // ${field.fieldComment}
    </#if>
    ${field.attrName}?: string,
</#list>

}
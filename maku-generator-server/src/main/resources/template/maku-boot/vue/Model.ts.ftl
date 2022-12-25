/**
* @author ${author} ${email}
* @since ${version} ${date}
* ${tableComment}
*/
interface VersionModel {

<#list fieldList as field>
    <#if field.fieldComment!?length gt 0>
        // ${field.fieldComment}
    </#if>
    ${field.attrName}?: string,
</#list>

}
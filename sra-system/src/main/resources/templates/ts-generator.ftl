/**
* @author ${objectMap.author}
* ${objectMap.table.tableComment}
*/
interface ${objectMap.table.javaClassName}Model {
<#list objectMap.colList as item>
	// ${item.columnComment}
	${item.javaColName}?: ${item.tsDataType},
</#list>
}
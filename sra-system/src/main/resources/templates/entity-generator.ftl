<link href="https://cdn.bootcdn.net/ajax/libs/highlight.js/11.5.1/styles/base16/default-light.min.css" rel="stylesheet">
<script src="https://cdn.bootcdn.net/ajax/libs/highlight.js/11.5.1/highlight.min.js"></script>
<script>hljs.highlightAll();</script>
<pre>
	<code class="java">


package ${objectMap.modulePackage}.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import org.sagacity.sqltoy.config.annotation.Entity;
import org.sagacity.sqltoy.config.annotation.Id;
import org.sagacity.sqltoy.config.annotation.Column;

/**
* @author ${objectMap.author}
* Table: ${objectMap.table.tableName},Remark:${objectMap.table.tableComment}
*/
@Entity(tableName="${objectMap.table.tableName}")
public class ${objectMap.table.javaClassName} implements Serializable {
	private static final long serialVersionUID = 1L;

	<#list objectMap.colList as item>
	/**
	* ${item.columnComment}
	*/
		<#if item_index == 0>
	@Id(strategy="generator",generator="org.sagacity.sqltoy.plugins.id.impl.UUIDGenerator")
		</#if>
	@Column(name="${item.columnName}"<#if (item.characterMaximumLength)??>,length=${item.characterMaximumLength}L</#if>,type=java.sql.Types.${item.dataType}<#if item.isNullable == 'NO'>,nullable=false</#if>)
	private ${item.javaDataType} ${item.javaColName};

	</#list>

	<#list objectMap.colList as item>
	public ${item.javaDataType} get${item.javaColNameBigHump}() {
		return this.${item.javaColName};
	}

	public ${objectMap.table.javaClassName} set${item.javaColNameBigHump}(${item.javaDataType} ${item.javaColName}) {
		this.${item.javaColName}=${item.javaColName};
		return this;
	}

	</#list>

	@Override
	public String toString() {
		StringBuilder columnsBuffer = new StringBuilder();
	<#list objectMap.colList as item>
		columnsBuffer.append("${item.javaColName}=").append(get${item.javaColNameBigHump}()).append("\n");
	</#list>
		return columnsBuffer.toString();
	}
}



	</code>
</pre>
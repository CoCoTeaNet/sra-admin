<pre style="background-color: aliceblue;padding: 1em">

<#list entityCode as item>
	<#if item_index == 0>
	package ${item.modulePackage}.entity;

	import java.io.Serializable;
	import org.sagacity.sqltoy.config.annotation.Entity;
	import org.sagacity.sqltoy.config.annotation.Id;
	import org.sagacity.sqltoy.config.annotation.Column;

	/**
	* @author ${item.author}
	* Table: ${item.tableName},Remark:用户角色关联表
	*/
	@Entity(tableName="${item.tableName}")
	public class ${item.javaClassName} implements Serializable {
	</#if>
</#list>

	private static final long serialVersionUID = -1L;

	<#list entityCode as item>
		<#if item_index == 0>
	@Id(strategy="generator",generator="org.sagacity.sqltoy.plugins.id.impl.UUIDGenerator")
		</#if>
	@Column(name="${item.columnName}",length=32L,type=java.sql.Types.${item.dataType},nullable=false)
	private ${item.javaDataType} ${item.javaColName};

    </#list>

	<#list entityCode as item>
	public ${item.javaDataType} get${item.javaColNameBigHump}() {
		return this.${item.javaColName};
	}

	public User set${item.javaColNameBigHump}(${item.javaDataType} ${item.javaColName}) {
		this.${item.javaColName}=${item.javaColName};
		return this;
	}

	</#list>

	@Override
	public String toString() {
		StringBuilder columnsBuffer = new StringBuilder();
	<#list entityCode as item>
		columnsBuffer.append("${item.javaColName}=").append(get${item.javaColNameBigHump}()).append("\n");
	</#list>
		return columnsBuffer.toString();
	}

}


</pre>
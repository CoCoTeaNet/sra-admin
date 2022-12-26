<?xml version="1.0" encoding="utf-8"?>
<sqltoy xmlns="http://www.sagframe.com/schema/sqltoy"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.sagframe.com/schema/sqltoy http://www.sagframe.com/schema/sqltoy/sqltoy.xsd">

    <sql id="${moduleName}_${className}_findByEntityParam">
        <value>
            <![CDATA[
            select *
            from ${tableName}
            ]]>
        </value>
    </sql>

    <sql id="${moduleName}_${className}_findByPageParam">
        <value>
            <![CDATA[
            select *
            from ${tableName}
            ]]>
        </value>
    </sql>

</sqltoy>
package net.cocotea.admin.system.vo;

import java.io.Serializable;

/**
 * 表返回信息
 *
 * @author jwss
 * @date 2022-4-20 22:05:32
 */
public class TableVO implements Serializable {
    private static final long serialVersionUID = 21132277961275875L;

    private String dbName;
    /**
     * 表描述
     */
    private String tableComment;
    /**
     * 表名称
     */
    private String tableName;
    /**
     * 字符编码
     */
    private String tableCollation;

    private String javaClassName;

    public String getJavaClassName() {
        return javaClassName;
    }

    public void setJavaClassName(String javaClassName) {
        this.javaClassName = javaClassName;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableCollation() {
        return tableCollation;
    }

    public void setTableCollation(String tableCollation) {
        this.tableCollation = tableCollation;
    }

    public String getDbName() {
        return dbName;
    }

    public TableVO setDbName(String dbName) {
        this.dbName = dbName;
        return this;
    }

    @Override
    public String toString() {
        return "TableVO{" +
                "dbName='" + dbName + '\'' +
                ", tableComment='" + tableComment + '\'' +
                ", tableName='" + tableName + '\'' +
                ", tableCollation='" + tableCollation + '\'' +
                ", javaClassName='" + javaClassName + '\'' +
                '}';
    }
}

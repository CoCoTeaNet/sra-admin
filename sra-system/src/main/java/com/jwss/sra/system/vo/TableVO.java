package com.jwss.sra.system.vo;

import java.io.Serializable;

/**
 * 表返回信息
 *
 * @author jwss
 * @date 2022-4-20 22:05:32
 */
public class TableVO implements Serializable {
    private static final long serialVersionUID = 21132277961275875L;

    private String tableComment;
    private String tableName;
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
}

package com.jwss.sra.system.entity;

import org.sagacity.sqltoy.config.annotation.Entity;

import java.io.Serializable;

/**
 * 表字段查询对象
 *
 * @author jwss
 * @date 2022-4-14 23:28:00
 */
@Entity(tableName="information_schema.COLUMNS")
public class TableCol implements Serializable {
    private static final long serialVersionUID = 3015540103154777811L;

    private String tableCatalog;
    private String tableSchema;
    private String tableName;
    private String columnName;
    private Integer ordinalPosition;
    private String columnDefault;
    private String isNullable;
    private String dataType;
    private Integer characterMaximumLength;
    private Integer characterOctetLength;
    private String numericPrecision;
    private String numericScale;
    private String datetimePrecision;
    private String characterSetName;
    private String collationName;
    private String columnType;
    private String columnKey;
    private String extra;
    private String privileges;
    private String columnComment;

    private String javaColName;
    private String javaDataType;
    private String javaColNameBigHump;

    public String getJavaColName() {
        return javaColName;
    }

    public void setJavaColName(String javaColName) {
        this.javaColName = javaColName;
    }

    public String getJavaDataType() {
        return javaDataType;
    }

    public void setJavaDataType(String javaDataType) {
        this.javaDataType = javaDataType;
    }

    public String getJavaColNameBigHump() {
        return javaColNameBigHump;
    }

    public void setJavaColNameBigHump(String javaColNameBigHump) {
        this.javaColNameBigHump = javaColNameBigHump;
    }

    public String getTableCatalog() {
        return tableCatalog;
    }

    public void setTableCatalog(String tableCatalog) {
        this.tableCatalog = tableCatalog;
    }

    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Integer getOrdinalPosition() {
        return ordinalPosition;
    }

    public void setOrdinalPosition(Integer ordinalPosition) {
        this.ordinalPosition = ordinalPosition;
    }

    public String getColumnDefault() {
        return columnDefault;
    }

    public void setColumnDefault(String columnDefault) {
        this.columnDefault = columnDefault;
    }

    public String getIsNullable() {
        return isNullable;
    }

    public void setIsNullable(String isNullable) {
        this.isNullable = isNullable;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Integer getCharacterMaximumLength() {
        return characterMaximumLength;
    }

    public void setCharacterMaximumLength(Integer characterMaximumLength) {
        this.characterMaximumLength = characterMaximumLength;
    }

    public Integer getCharacterOctetLength() {
        return characterOctetLength;
    }

    public void setCharacterOctetLength(Integer characterOctetLength) {
        this.characterOctetLength = characterOctetLength;
    }

    public String getNumericPrecision() {
        return numericPrecision;
    }

    public void setNumericPrecision(String numericPrecision) {
        this.numericPrecision = numericPrecision;
    }

    public String getNumericScale() {
        return numericScale;
    }

    public void setNumericScale(String numericScale) {
        this.numericScale = numericScale;
    }

    public String getDatetimePrecision() {
        return datetimePrecision;
    }

    public void setDatetimePrecision(String datetimePrecision) {
        this.datetimePrecision = datetimePrecision;
    }

    public String getCharacterSetName() {
        return characterSetName;
    }

    public void setCharacterSetName(String characterSetName) {
        this.characterSetName = characterSetName;
    }

    public String getCollationName() {
        return collationName;
    }

    public void setCollationName(String collationName) {
        this.collationName = collationName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getColumnKey() {
        return columnKey;
    }

    public void setColumnKey(String columnKey) {
        this.columnKey = columnKey;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    @Override
    public String toString() {
        return "TableColVO{" +
                "tableCatalog='" + tableCatalog + '\'' +
                ", tableSchema='" + tableSchema + '\'' +
                ", tableName='" + tableName + '\'' +
                ", columnName='" + columnName + '\'' +
                ", ordinalPosition='" + ordinalPosition + '\'' +
                ", columnDefault='" + columnDefault + '\'' +
                ", isNullable='" + isNullable + '\'' +
                ", dataType='" + dataType + '\'' +
                ", characterMaximumLength='" + characterMaximumLength + '\'' +
                ", characterOctetLength='" + characterOctetLength + '\'' +
                ", numericPrecision='" + numericPrecision + '\'' +
                ", numericScale='" + numericScale + '\'' +
                ", datetimePrecision='" + datetimePrecision + '\'' +
                ", characterSetName='" + characterSetName + '\'' +
                ", collationName='" + collationName + '\'' +
                ", columnType='" + columnType + '\'' +
                ", columnKey='" + columnKey + '\'' +
                ", extra='" + extra + '\'' +
                ", privileges='" + privileges + '\'' +
                ", columnComment='" + columnComment + '\'' +
                '}';
    }
}

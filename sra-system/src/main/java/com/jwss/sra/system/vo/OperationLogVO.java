package com.jwss.sra.system.vo;

import org.sagacity.sqltoy.config.annotation.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author jwss
 * Table: sys_operation_log,Remark:系统操作日志表
 */
@Entity(tableName="sys_operation_log")
public class OperationLogVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private String id;

    /**
     * 日志编号
     */
    private Long logNumber;

    /**
     * 请求IP地址
     */
    private String ipAddress;

    /**
     * 操作人员
     */
    private String operator;

    /**
     * 操作人员昵称
     */
    private String operatorName;

    /**
     * 请求方式
     */
    private String requestWay;

    /**
     * 操作状态;0异常 1成功
     */
    private String operationStatus;

    /**
     * 系统模块
     */
    private String systemModule;

    /**
     * 操作类型;0登录日志 1操作日志
     */
    private String operationType;

    /**
     * 操作地点
     */
    private String operationAddress;

    /**
     * 日志类型
     */
    private String logType;

    /**
     * 操作时间
     */
    private LocalDateTime operationTime;


    public String getId() {
        return this.id;
    }

    public OperationLogVO setId(String id) {
        this.id=id;
        return this;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Long getLogNumber() {
        return this.logNumber;
    }

    public OperationLogVO setLogNumber(Long logNumber) {
        this.logNumber=logNumber;
        return this;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public OperationLogVO setIpAddress(String ipAddress) {
        this.ipAddress=ipAddress;
        return this;
    }

    public String getOperator() {
        return this.operator;
    }

    public OperationLogVO setOperator(String operator) {
        this.operator=operator;
        return this;
    }

    public String getRequestWay() {
        return this.requestWay;
    }

    public OperationLogVO setRequestWay(String requestWay) {
        this.requestWay=requestWay;
        return this;
    }

    public String getOperationStatus() {
        return this.operationStatus;
    }

    public OperationLogVO setOperationStatus(String operationStatus) {
        this.operationStatus=operationStatus;
        return this;
    }

    public String getSystemModule() {
        return this.systemModule;
    }

    public OperationLogVO setSystemModule(String systemModule) {
        this.systemModule=systemModule;
        return this;
    }

    public String getOperationType() {
        return this.operationType;
    }

    public OperationLogVO setOperationType(String operationType) {
        this.operationType=operationType;
        return this;
    }

    public String getOperationAddress() {
        return this.operationAddress;
    }

    public OperationLogVO setOperationAddress(String operationAddress) {
        this.operationAddress=operationAddress;
        return this;
    }

    public String getLogType() {
        return this.logType;
    }

    public OperationLogVO setLogType(String logType) {
        this.logType=logType;
        return this;
    }

    public LocalDateTime getOperationTime() {
        return this.operationTime;
    }

    public OperationLogVO setOperationTime(LocalDateTime operationTime) {
        this.operationTime=operationTime;
        return this;
    }


    @Override
    public String toString() {
        StringBuilder columnsBuffer = new StringBuilder();
        columnsBuffer.append("id=").append(getId()).append("\n");
        columnsBuffer.append("logNumber=").append(getLogNumber()).append("\n");
        columnsBuffer.append("ipAddress=").append(getIpAddress()).append("\n");
        columnsBuffer.append("operator=").append(getOperator()).append("\n");
        columnsBuffer.append("requestWay=").append(getRequestWay()).append("\n");
        columnsBuffer.append("operationStatus=").append(getOperationStatus()).append("\n");
        columnsBuffer.append("systemModule=").append(getSystemModule()).append("\n");
        columnsBuffer.append("operationType=").append(getOperationType()).append("\n");
        columnsBuffer.append("operationAddress=").append(getOperationAddress()).append("\n");
        columnsBuffer.append("logType=").append(getLogType()).append("\n");
        columnsBuffer.append("operationTime=").append(getOperationTime()).append("\n");
        return columnsBuffer.toString();
    }
}

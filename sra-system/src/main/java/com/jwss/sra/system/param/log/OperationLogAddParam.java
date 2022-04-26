package com.jwss.sra.system.param.log;

import java.time.LocalDateTime;

/**
 * 新增操作日志参数
 *
 * @author jwss
 * @date 2022-4-26 23:11:52
 */
public class OperationLogAddParam {

    /**
     * 日志编号
     */
    private Integer logNumber;

    /**
     * 请求IP地址
     */
    private String ipAddress;

    /**
     * 操作人员
     */
    private String operator;

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

    public Integer getLogNumber() {
        return logNumber;
    }

    public void setLogNumber(Integer logNumber) {
        this.logNumber = logNumber;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getRequestWay() {
        return requestWay;
    }

    public void setRequestWay(String requestWay) {
        this.requestWay = requestWay;
    }

    public String getOperationStatus() {
        return operationStatus;
    }

    public void setOperationStatus(String operationStatus) {
        this.operationStatus = operationStatus;
    }

    public String getSystemModule() {
        return systemModule;
    }

    public void setSystemModule(String systemModule) {
        this.systemModule = systemModule;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getOperationAddress() {
        return operationAddress;
    }

    public void setOperationAddress(String operationAddress) {
        this.operationAddress = operationAddress;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public LocalDateTime getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(LocalDateTime operationTime) {
        this.operationTime = operationTime;
    }
}

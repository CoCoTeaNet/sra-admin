package net.cocotea.admin.system.param.log;

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
     * 请求方式
     */
    private String requestWay;

    /**
     * 操作状态;0异常 1成功
     */
    private Integer operationStatus;

    /**
     * 系统模块
     */
    private String systemModule;

    /**
     * 操作类型;0登录日志 1操作日志
     */
    private Integer operationType;

    /**
     * 操作地点
     */
    private String operationAddress;

    /**
     * 日志类型
     */
    private Integer logType;

    /**
     * 操作时间
     */
    private LocalDateTime operationTime;

    public Long getLogNumber() {
        return logNumber;
    }

    public OperationLogAddParam setLogNumber(Long logNumber) {
        this.logNumber = logNumber;
        return this;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public OperationLogAddParam setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public String getOperator() {
        return operator;
    }

    public OperationLogAddParam setOperator(String operator) {
        this.operator = operator;
        return this;
    }

    public String getRequestWay() {
        return requestWay;
    }

    public OperationLogAddParam setRequestWay(String requestWay) {
        this.requestWay = requestWay;
        return this;
    }

    public Integer getOperationStatus() {
        return operationStatus;
    }

    public OperationLogAddParam setOperationStatus(Integer operationStatus) {
        this.operationStatus = operationStatus;
        return this;
    }

    public String getSystemModule() {
        return systemModule;
    }

    public OperationLogAddParam setSystemModule(String systemModule) {
        this.systemModule = systemModule;
        return this;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public OperationLogAddParam setOperationType(Integer operationType) {
        this.operationType = operationType;
        return this;
    }

    public String getOperationAddress() {
        return operationAddress;
    }

    public OperationLogAddParam setOperationAddress(String operationAddress) {
        this.operationAddress = operationAddress;
        return this;
    }

    public Integer getLogType() {
        return logType;
    }

    public OperationLogAddParam setLogType(Integer logType) {
        this.logType = logType;
        return this;
    }

    public LocalDateTime getOperationTime() {
        return operationTime;
    }

    public OperationLogAddParam setOperationTime(LocalDateTime operationTime) {
        this.operationTime = operationTime;
        return this;
    }
}

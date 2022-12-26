package net.cocotea.admin.system.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author jwss
 * Table: sys_operation_log,Remark:系统操作日志表
 */
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

    public String getId() {
        return id;
    }

    public OperationLogVO setId(String id) {
        this.id = id;
        return this;
    }

    public Long getLogNumber() {
        return logNumber;
    }

    public OperationLogVO setLogNumber(Long logNumber) {
        this.logNumber = logNumber;
        return this;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public OperationLogVO setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public String getOperator() {
        return operator;
    }

    public OperationLogVO setOperator(String operator) {
        this.operator = operator;
        return this;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public OperationLogVO setOperatorName(String operatorName) {
        this.operatorName = operatorName;
        return this;
    }

    public String getRequestWay() {
        return requestWay;
    }

    public OperationLogVO setRequestWay(String requestWay) {
        this.requestWay = requestWay;
        return this;
    }

    public Integer getOperationStatus() {
        return operationStatus;
    }

    public OperationLogVO setOperationStatus(Integer operationStatus) {
        this.operationStatus = operationStatus;
        return this;
    }

    public String getSystemModule() {
        return systemModule;
    }

    public OperationLogVO setSystemModule(String systemModule) {
        this.systemModule = systemModule;
        return this;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public OperationLogVO setOperationType(Integer operationType) {
        this.operationType = operationType;
        return this;
    }

    public String getOperationAddress() {
        return operationAddress;
    }

    public OperationLogVO setOperationAddress(String operationAddress) {
        this.operationAddress = operationAddress;
        return this;
    }

    public Integer getLogType() {
        return logType;
    }

    public OperationLogVO setLogType(Integer logType) {
        this.logType = logType;
        return this;
    }

    public LocalDateTime getOperationTime() {
        return operationTime;
    }

    public OperationLogVO setOperationTime(LocalDateTime operationTime) {
        this.operationTime = operationTime;
        return this;
    }

    @Override
    public String toString() {
        return "OperationLogVO{" +
                "id='" + id + '\'' +
                ", logNumber=" + logNumber +
                ", ipAddress='" + ipAddress + '\'' +
                ", operator='" + operator + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", requestWay='" + requestWay + '\'' +
                ", operationStatus=" + operationStatus +
                ", systemModule='" + systemModule + '\'' +
                ", operationType=" + operationType +
                ", operationAddress='" + operationAddress + '\'' +
                ", logType=" + logType +
                ", operationTime=" + operationTime +
                '}';
    }
}

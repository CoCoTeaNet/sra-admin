package net.cocotea.admin.system.entity;

import java.sql.Types;
import java.time.LocalDateTime;
import java.io.Serializable;
import org.sagacity.sqltoy.config.annotation.Entity;
import org.sagacity.sqltoy.config.annotation.Id;
import org.sagacity.sqltoy.config.annotation.Column;

/**
 * @author jwss
 * Table: sys_operation_log,Remark:系统操作日志表
 */
@Entity(tableName="sys_operation_log")
public class OperationLog implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @Id(strategy="generator",generator="org.sagacity.sqltoy.plugins.id.impl.UUIDGenerator")
    @Column(name="ID",length=32L,type=java.sql.Types.VARCHAR,nullable=false)
    private String id;

    /**
     * 日志编号
     */
    @Column(name="LOG_NUMBER",type= Types.BIGINT,nullable=false)
    private Long logNumber;

    /**
     * 请求IP地址
     */
    @Column(name="IP_ADDRESS",length=128L,type=java.sql.Types.VARCHAR,nullable=false)
    private String ipAddress;

    /**
     * 操作人员
     */
    @Column(name="OPERATOR",length=32L,type=java.sql.Types.VARCHAR)
    private String operator;

    /**
     * 请求方式
     */
    @Column(name="REQUEST_WAY",length=10L,type=java.sql.Types.VARCHAR,nullable=false)
    private String requestWay;

    /**
     * 操作状态;0异常 1成功
     */
    @Column(name="OPERATION_STATUS",length=1L,type=java.sql.Types.CHAR)
    private Integer operationStatus;

    /**
     * 系统模块
     */
    @Column(name="SYSTEM_MODULE",length=100L,type=java.sql.Types.VARCHAR)
    private String systemModule;

    /**
     * 操作类型;0登录日志 1操作日志
     */
    @Column(name="OPERATION_TYPE",length=1L,type=java.sql.Types.CHAR)
    private Integer operationType;

    /**
     * 操作地点
     */
    @Column(name="OPERATION_ADDRESS",length=512L,type=java.sql.Types.VARCHAR)
    private String operationAddress;

    /**
     * 日志类型
     */
    @Column(name="LOG_TYPE",length=1L,type=java.sql.Types.CHAR)
    private String logType;

    /**
     * 操作时间
     */
    @Column(name="OPERATION_TIME",type=java.sql.Types.DATE)
    private LocalDateTime operationTime;

    public String getId() {
        return id;
    }

    public OperationLog setId(String id) {
        this.id = id;
        return this;
    }

    public Long getLogNumber() {
        return logNumber;
    }

    public OperationLog setLogNumber(Long logNumber) {
        this.logNumber = logNumber;
        return this;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public OperationLog setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public String getOperator() {
        return operator;
    }

    public OperationLog setOperator(String operator) {
        this.operator = operator;
        return this;
    }

    public String getRequestWay() {
        return requestWay;
    }

    public OperationLog setRequestWay(String requestWay) {
        this.requestWay = requestWay;
        return this;
    }

    public Integer getOperationStatus() {
        return operationStatus;
    }

    public OperationLog setOperationStatus(Integer operationStatus) {
        this.operationStatus = operationStatus;
        return this;
    }

    public String getSystemModule() {
        return systemModule;
    }

    public OperationLog setSystemModule(String systemModule) {
        this.systemModule = systemModule;
        return this;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public OperationLog setOperationType(Integer operationType) {
        this.operationType = operationType;
        return this;
    }

    public String getOperationAddress() {
        return operationAddress;
    }

    public OperationLog setOperationAddress(String operationAddress) {
        this.operationAddress = operationAddress;
        return this;
    }

    public String getLogType() {
        return logType;
    }

    public OperationLog setLogType(String logType) {
        this.logType = logType;
        return this;
    }

    public LocalDateTime getOperationTime() {
        return operationTime;
    }

    public OperationLog setOperationTime(LocalDateTime operationTime) {
        this.operationTime = operationTime;
        return this;
    }

    @Override
    public String toString() {
        return "OperationLog{" +
                "id='" + id + '\'' +
                ", logNumber=" + logNumber +
                ", ipAddress='" + ipAddress + '\'' +
                ", operator='" + operator + '\'' +
                ", requestWay='" + requestWay + '\'' +
                ", operationStatus=" + operationStatus +
                ", systemModule='" + systemModule + '\'' +
                ", operationType=" + operationType +
                ", operationAddress='" + operationAddress + '\'' +
                ", logType='" + logType + '\'' +
                ", operationTime=" + operationTime +
                '}';
    }
}

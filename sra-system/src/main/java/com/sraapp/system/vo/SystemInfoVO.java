package com.sraapp.system.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @date 2022-1-26 11:41:05
 * @author jwss
 */
@ApiModel("服务器系统信息")
public class SystemInfoVO implements Serializable {
    private static final long serialVersionUID = 8671770549214978920L;

    @ApiModelProperty("操作系统")
    private String os;

    @ApiModelProperty("服务器名称")
    private String serverName;

    @ApiModelProperty("服务器IP")
    private String serverIp;

    @ApiModelProperty("系统架构")
    private String serverArchitecture;

    @ApiModelProperty("Java名称")
    private String javaName;

    @ApiModelProperty("Java版本")
    private String javaVersion;

    @ApiModelProperty("java安装路径")
    private String javaPath;

    @ApiModelProperty("项目路径")
    private String projectPath;

    @ApiModelProperty("服务运行时长（单位秒）")
    private Long runningTime;

    @ApiModelProperty("CPU系统使用率")
    private Double cpuSystemUsed;

    @ApiModelProperty("CPU用户使用率")
    private Double cpuUserUsed;

    @ApiModelProperty("CPU空闲率")
    private Double cpuFree;

    @ApiModelProperty("CPU核心数")
    private Integer cpuCount;

    @ApiModelProperty("内存总大小")
    private Long memoryTotalSize;

    @ApiModelProperty("可用大小")
    private Long memoryAvailableSize;

    @ApiModelProperty("磁盘总大小（单位字节）")
    private Long diskTotalSize;

    @ApiModelProperty("磁盘剩余大小（单位字节）")
    private Long diskFreeSize;

    @ApiModelProperty("磁盘路径")
    private String diskPath;

    @ApiModelProperty("磁盘分隔符")
    private String diskSeparator;

    public Long getDiskFreeSize() {
        return diskFreeSize;
    }

    public void setDiskFreeSize(Long diskFreeSize) {
        this.diskFreeSize = diskFreeSize;
    }

    public String getDiskPath() {
        return diskPath;
    }

    public void setDiskPath(String diskPath) {
        this.diskPath = diskPath;
    }

    public String getDiskSeparator() {
        return diskSeparator;
    }

    public void setDiskSeparator(String diskSeparator) {
        this.diskSeparator = diskSeparator;
    }

    public Double getCpuSystemUsed() {
        return cpuSystemUsed;
    }

    public void setCpuSystemUsed(Double cpuSystemUsed) {
        this.cpuSystemUsed = cpuSystemUsed;
    }

    public Double getCpuUserUsed() {
        return cpuUserUsed;
    }

    public void setCpuUserUsed(Double cpuUserUsed) {
        this.cpuUserUsed = cpuUserUsed;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getServerArchitecture() {
        return serverArchitecture;
    }

    public void setServerArchitecture(String serverArchitecture) {
        this.serverArchitecture = serverArchitecture;
    }

    public String getJavaName() {
        return javaName;
    }

    public void setJavaName(String javaName) {
        this.javaName = javaName;
    }

    public String getJavaVersion() {
        return javaVersion;
    }

    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
    }

    public String getJavaPath() {
        return javaPath;
    }

    public void setJavaPath(String javaPath) {
        this.javaPath = javaPath;
    }

    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

    public Long getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(Long runningTime) {
        this.runningTime = runningTime;
    }

    public Double getCpuFree() {
        return cpuFree;
    }

    public void setCpuFree(Double cpuFree) {
        this.cpuFree = cpuFree;
    }

    public Integer getCpuCount() {
        return cpuCount;
    }

    public void setCpuCount(Integer cpuCount) {
        this.cpuCount = cpuCount;
    }

    public Long getMemoryTotalSize() {
        return memoryTotalSize;
    }

    public void setMemoryTotalSize(Long memoryTotalSize) {
        this.memoryTotalSize = memoryTotalSize;
    }

    public Long getDiskTotalSize() {
        return diskTotalSize;
    }

    public void setDiskTotalSize(Long diskTotalSize) {
        this.diskTotalSize = diskTotalSize;
    }

    public Long getMemoryAvailableSize() {
        return memoryAvailableSize;
    }

    public void setMemoryAvailableSize(Long memoryAvailableSize) {
        this.memoryAvailableSize = memoryAvailableSize;
    }

    @Override
    public String toString() {
        return "SystemInfoVO{" +
                "os='" + os + '\'' +
                ", serverName='" + serverName + '\'' +
                ", serverIp='" + serverIp + '\'' +
                ", serverArchitecture='" + serverArchitecture + '\'' +
                ", javaName='" + javaName + '\'' +
                ", javaVersion='" + javaVersion + '\'' +
                ", javaPath='" + javaPath + '\'' +
                ", projectPath='" + projectPath + '\'' +
                ", runningTime=" + runningTime +
                ", cpuSystemUsed=" + cpuSystemUsed +
                ", cpuUserUsed=" + cpuUserUsed +
                ", cpuFree=" + cpuFree +
                ", cpuCount=" + cpuCount +
                ", memoryTotalSize=" + memoryTotalSize +
                ", memoryAvailableSize=" + memoryAvailableSize +
                ", diskTotalSize=" + diskTotalSize +
                ", diskFreeSize=" + diskFreeSize +
                ", diskPath='" + diskPath + '\'' +
                ", diskSeparator='" + diskSeparator + '\'' +
                '}';
    }
}

package com.jwss.system.vo;

import cn.hutool.system.*;

import java.io.Serializable;

/**
 * @date 2022-1-26 11:41:05
 * @author jwss
 */
public class SystemInfoVO implements Serializable {
    private static final long serialVersionUID = 8671770549214978920L;

    private JvmSpecInfo jvmSpecInfo;
    private JvmInfo jvmInfo;
    private JavaSpecInfo javaSpecInfo;
    private JavaInfo javaInfo;
    private JavaRuntimeInfo javaRuntimeInfo;
    private OsInfo osInfo;
    private UserInfo userInfo;
    private HostInfo hostInfo;
    private RuntimeInfo runtimeInfo;

    public SystemInfoVO(){
        this.jvmSpecInfo=SystemUtil.getJvmSpecInfo();
        this.jvmInfo=SystemUtil.getJvmInfo();
        this.javaSpecInfo=SystemUtil.getJavaSpecInfo();
        this.javaInfo=SystemUtil.getJavaInfo();
        this.javaRuntimeInfo=SystemUtil.getJavaRuntimeInfo();
        this.osInfo=SystemUtil.getOsInfo();
        this.userInfo=SystemUtil.getUserInfo();
        this.hostInfo=SystemUtil.getHostInfo();
        this.runtimeInfo=SystemUtil.getRuntimeInfo();
    }

    public JvmSpecInfo getJvmSpecInfo() {
        return jvmSpecInfo;
    }

    public void setJvmSpecInfo(JvmSpecInfo jvmSpecInfo) {
        this.jvmSpecInfo = jvmSpecInfo;
    }

    public JvmInfo getJvmInfo() {
        return jvmInfo;
    }

    public void setJvmInfo(JvmInfo jvmInfo) {
        this.jvmInfo = jvmInfo;
    }

    public JavaSpecInfo getJavaSpecInfo() {
        return javaSpecInfo;
    }

    public void setJavaSpecInfo(JavaSpecInfo javaSpecInfo) {
        this.javaSpecInfo = javaSpecInfo;
    }

    public JavaInfo getJavaInfo() {
        return javaInfo;
    }

    public void setJavaInfo(JavaInfo javaInfo) {
        this.javaInfo = javaInfo;
    }

    public JavaRuntimeInfo getJavaRuntimeInfo() {
        return javaRuntimeInfo;
    }

    public void setJavaRuntimeInfo(JavaRuntimeInfo javaRuntimeInfo) {
        this.javaRuntimeInfo = javaRuntimeInfo;
    }

    public OsInfo getOsInfo() {
        return osInfo;
    }

    public void setOsInfo(OsInfo osInfo) {
        this.osInfo = osInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public HostInfo getHostInfo() {
        return hostInfo;
    }

    public void setHostInfo(HostInfo hostInfo) {
        this.hostInfo = hostInfo;
    }

    public RuntimeInfo getRuntimeInfo() {
        return runtimeInfo;
    }

    public void setRuntimeInfo(RuntimeInfo runtimeInfo) {
        this.runtimeInfo = runtimeInfo;
    }

    @Override
    public String toString() {
        return "SystemInfoVO{" +
                "jvmSpecInfo=" + jvmSpecInfo +
                ", jvmInfo=" + jvmInfo +
                ", javaSpecInfo=" + javaSpecInfo +
                ", javaInfo=" + javaInfo +
                ", javaRuntimeInfo=" + javaRuntimeInfo +
                ", osInfo=" + osInfo +
                ", userInfo=" + userInfo +
                ", hostInfo=" + hostInfo +
                ", runtimeInfo=" + runtimeInfo +
                '}';
    }
}

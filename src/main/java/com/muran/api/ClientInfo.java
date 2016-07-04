package com.muran.api;

/**
 * Created by Steven on 4/29/16.
 */
public class ClientInfo {
    private String ip;
    private String key;
    private String networkEnv;
    private String version;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNetworkEnv() {
        return networkEnv;
    }

    public void setNetworkEnv(String networkEnv) {
        this.networkEnv = networkEnv;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}

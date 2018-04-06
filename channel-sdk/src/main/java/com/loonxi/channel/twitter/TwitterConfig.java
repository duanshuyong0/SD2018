package com.loonxi.channel.twitter;

/**
 * xxx.
 *
 * @author xyy
 * @Date 2016/12/29
 */
public class TwitterConfig {
    private String consumerKey;
    private String consumerSecret;

    private boolean setProxy;
    private String proxyIp;
    private int proxyPort;

    public TwitterConfig(String consumerKey, String consumerSecret) {
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public void setConsumerSecret(String consumerSecret) {
        this.consumerSecret = consumerSecret;
    }

    public boolean isSetProxy() {
        return setProxy;
    }

    public void setSetProxy(boolean setProxy) {
        this.setProxy = setProxy;
    }

    public String getProxyIp() {
        return proxyIp;
    }

    public void setProxyIp(String proxyIp) {
        this.proxyIp = proxyIp;
    }

    public int getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
    }
}

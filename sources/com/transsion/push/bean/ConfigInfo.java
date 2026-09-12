package com.transsion.push.bean;

import fm.a;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class ConfigInfo {
    public String clientId;
    public Config config;
    public boolean configRefresh;
    public String[] destroyAppIds;
    public boolean nextWithApp;
    public boolean nextWithDetail;
    public boolean startPointReport;
    public int syncInfoInterval;
    public Whitelist whitelist;
    public boolean whitelistRefresh;

    /* loaded from: classes.dex */
    public static class Apps {

        /* renamed from: id, reason: collision with root package name */
        public String f50845id;
        public String pkg;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                Apps apps = (Apps) obj;
                String str = this.f50845id;
                if (str != null && this.pkg != null && str.equals(apps.f50845id) && this.pkg.equals(apps.pkg)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.f50845id.hashCode() * 19) + this.pkg.hashCode();
        }

        public String toString() {
            return "Apps{pkg='" + this.pkg + "', id='" + this.f50845id + "'}";
        }
    }

    /* loaded from: classes.dex */
    public static class Config {
        public int alarmCheckInterval;
        public int checkInterval;
        public int destroy;
        public int mobileUploadInterval;
        public int retryCount;
        public int retryInterval;
        public int uploadDelay;
        public int uploadInterval;
        public int version;

        public String toString() {
            return "Config{version=" + this.version + ", checkInterval=" + this.checkInterval + ", uploadInterval=" + this.uploadInterval + ", uploadDelay=" + this.uploadDelay + ", retryCount=" + this.retryCount + ", retryInterval=" + this.retryInterval + ", mobileUploadInterval=" + this.mobileUploadInterval + ", alarmCheckInterval=" + this.alarmCheckInterval + ", destroy=" + this.destroy + '}';
        }
    }

    /* loaded from: classes.dex */
    public static class Whitelist {

        @a(name = "apps")
        public List<Apps> apps;
        public int version;

        public String toString() {
            return "Whitelist{version=" + this.version + ", apps=" + this.apps + '}';
        }
    }

    public String toString() {
        return "ConfigInfo{clientId='" + this.clientId + "', nextWithApp=" + this.nextWithApp + ", nextWithDetail=" + this.nextWithDetail + ", configRefresh=" + this.configRefresh + ", whitelistRefresh=" + this.whitelistRefresh + ", config=" + this.config + ", whitelist=" + this.whitelist + ", startPointReport=" + this.startPointReport + ", destroyAppIds=" + Arrays.toString(this.destroyAppIds) + ", syncInfoInterval=" + this.syncInfoInterval + '}';
    }
}

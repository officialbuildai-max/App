package com.pgl.ssdk.ces.out;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes5.dex */
public final class PglSSConfig {
    public static final int COLLECT_MODE_DEFAULT = 0;
    public static final int COLLECT_MODE_ML_MINIMIZE = 1;
    public static final String CUSTOMINFO_KEY_ALLOWED_FIELDS = "fields_allowed";
    public static final String CUSTOMINFO_KEY_CHECKCLAZZ = "check_clz";
    public static final String CUSTOMINFO_KEY_IPV6 = "key_ipv6";
    public static final String CUSTOMINFO_KEY_SEC_CONFIG_STR = "sec_config";
    public static final String CUSTOMINFO_KEY_TARGET_IDC = "target-idc";
    public static final String CUSTOMINFO_KEY_TRANSFER_HOST = "key_transfer_host";
    public static final int OVREGION_TYPE_SG = 2;
    public static final int OVREGION_TYPE_UNKNOWN = -1;
    public static final int OVREGION_TYPE_VA = 1;

    /* renamed from: a, reason: collision with root package name */
    private String f40170a;

    /* renamed from: b, reason: collision with root package name */
    private final int f40171b;

    /* renamed from: c, reason: collision with root package name */
    private final int f40172c;

    /* renamed from: d, reason: collision with root package name */
    private String f40173d;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, Object> f40174e;

    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private String f40175a;

        /* renamed from: b, reason: collision with root package name */
        private int f40176b = -1;

        /* renamed from: c, reason: collision with root package name */
        private int f40177c = 0;

        /* renamed from: d, reason: collision with root package name */
        private String f40178d;

        public PglSSConfig build() {
            if (TextUtils.isEmpty(this.f40175a)) {
                return null;
            }
            return new PglSSConfig(this.f40175a, this.f40176b, this.f40177c, this.f40178d);
        }

        public Builder setAdsdkVersion(String str) {
            this.f40178d = str;
            return this;
        }

        public Builder setAppId(String str) {
            this.f40175a = str;
            return this;
        }

        public Builder setCollectMode(int i11) {
            this.f40177c = i11;
            return this;
        }

        public Builder setOVRegionType(int i11) {
            this.f40176b = i11;
            return this;
        }
    }

    private PglSSConfig(String str, int i11, int i12, String str2) {
        this.f40170a = str;
        this.f40171b = i11;
        this.f40172c = i12;
        this.f40173d = str2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getAdSdkVersion() {
        return this.f40173d;
    }

    public String getAppId() {
        return this.f40170a;
    }

    public int getCollectMode() {
        return this.f40172c;
    }

    public Map<String, Object> getCustomInfo() {
        return this.f40174e;
    }

    public int getOVRegionType() {
        return this.f40171b;
    }

    public void setCustomInfo(Map<String, Object> map) {
        this.f40174e = map;
    }
}

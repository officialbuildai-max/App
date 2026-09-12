package com.bytedance.sdk.openadsdk.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public interface PAGConstant {

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface PAGGDPRConsentType {
        public static final int PAG_GDPR_CONSENT_TYPE_CONSENT = 1;
        public static final int PAG_GDPR_CONSENT_TYPE_DEFAULT = -1;
        public static final int PAG_GDPR_CONSENT_TYPE_NO_CONSENT = 0;
    }

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface PAGPAConsentType {
        public static final int PAG_PA_CONSENT_TYPE_CONSENT = 1;
        public static final int PAG_PA_CONSENT_TYPE_NO_CONSENT = 0;
    }
}

package com.bytedance.sdk.openadsdk.api.factory;

/* loaded from: classes2.dex */
public class SDKTypeConfig {
    private static ISDKTypeFactory Sj;

    public static ISDKTypeFactory getSdkTypeFactory() {
        return Sj;
    }

    public static void setSdkTypeFactory(ISDKTypeFactory iSDKTypeFactory) {
        Sj = iSDKTypeFactory;
    }
}

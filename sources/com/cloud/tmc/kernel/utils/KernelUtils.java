package com.cloud.tmc.kernel.utils;

/* loaded from: classes3.dex */
public class KernelUtils {
    public static final String TAG = "TmcKernel";

    public static boolean isDebug() {
        return AppDynamicBuildConfig.isAppDebugAble();
    }
}

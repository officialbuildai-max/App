package com.cloud.tmc.integration.utils;

import android.text.TextUtils;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.network.IConfigStrategyProxy;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/cloud/tmc/integration/utils/VersionUtils;", "", "()V", "FRAMEWORK_VERSION_OFFLIEN_SUFFIX", "", "LAST_SUPPORT_H5_PAGE_STACK_FRAMEWORK_VERSION", "compareVersion", "", "newVersion", "oldVersion", "isSupportH5PageStack", "isSupportWarmupFramework", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes3.dex */
public final class VersionUtils {
    public static final String FRAMEWORK_VERSION_OFFLIEN_SUFFIX = "-offline";
    public static final VersionUtils INSTANCE = new VersionUtils();
    public static final String LAST_SUPPORT_H5_PAGE_STACK_FRAMEWORK_VERSION = "5.1.1";

    private VersionUtils() {
    }

    public final boolean compareVersion(String newVersion, String oldVersion) {
        int i11;
        int i12;
        Intrinsics.h(newVersion, "newVersion");
        Intrinsics.h(oldVersion, "oldVersion");
        try {
        } catch (Throwable th2) {
            TmcLogger.e("compareVersion", "compareVersion error", th2);
        }
        if (TextUtils.isEmpty(oldVersion)) {
            return true;
        }
        String miniAppVersion = ((IConfigStrategyProxy) TmcProxy.get(IConfigStrategyProxy.class)).getMiniAppVersion(newVersion);
        String miniAppVersion2 = ((IConfigStrategyProxy) TmcProxy.get(IConfigStrategyProxy.class)).getMiniAppVersion(oldVersion);
        int length = miniAppVersion.length();
        int length2 = miniAppVersion2.length();
        int i13 = 0;
        int i14 = 0;
        do {
            if (i13 >= length && i14 >= length2) {
                return false;
            }
            i11 = 0;
            while (i13 < length) {
                if (miniAppVersion.charAt(i13) == '.') {
                    break;
                }
                i11 = ((i11 * 10) + miniAppVersion.charAt(i13)) - 48;
                i13++;
            }
            i13++;
            i12 = 0;
            while (i14 < length2 && miniAppVersion2.charAt(i14) != '.') {
                i12 = ((i12 * 10) + miniAppVersion2.charAt(i14)) - 48;
                i14++;
            }
            i14++;
        } while (i11 == i12);
        return i11 > i12;
    }

    public final boolean isSupportH5PageStack(String oldVersion, String newVersion) {
        Intrinsics.h(oldVersion, "oldVersion");
        if (newVersion == null) {
            newVersion = "";
        }
        return compareVersion(newVersion, oldVersion);
    }

    public final boolean isSupportWarmupFramework(String newVersion, String oldVersion) {
        Intrinsics.h(newVersion, "newVersion");
        Intrinsics.h(oldVersion, "oldVersion");
        return compareVersion(StringsKt.Q(newVersion, FRAMEWORK_VERSION_OFFLIEN_SUFFIX, "", false, 4, null), StringsKt.Q(oldVersion, FRAMEWORK_VERSION_OFFLIEN_SUFFIX, "", false, 4, null));
    }
}

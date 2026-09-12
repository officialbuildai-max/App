package com.transsion.img;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0082 ¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0004H\u0082 ¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\bJ\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\nR\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/transsion/img/BuildInfo;", "", "<init>", "()V", "", "apkPath", "", "nInit", "(Ljava/lang/String;)V", "nGetBuildTag", "()Ljava/lang/String;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "a", "", "Z", "ready", "BaseLib_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class BuildInfo {

    /* renamed from: a, reason: collision with root package name */
    public static final BuildInfo f46045a = new BuildInfo();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean ready;

    private BuildInfo() {
    }

    private final native String nGetBuildTag();

    private final native void nInit(String apkPath);

    public final String a() {
        if (!ready) {
            return "";
        }
        try {
            String nGetBuildTag = nGetBuildTag();
            return nGetBuildTag == null ? "" : nGetBuildTag;
        } catch (Throwable th2) {
            a.C0856a.l(a.f68962a, "BuildInfo", "getBuildTag fail e:" + th2, false, 4, null);
            return "";
        }
    }

    public final void b(String apkPath) {
        Intrinsics.h(apkPath, "apkPath");
        try {
            a.C0856a c0856a = a.f68962a;
            a.C0856a.f(c0856a, "BuildInfo", "init apkPath:" + apkPath, false, 4, null);
            System.loadLibrary("img_utils");
            nInit(apkPath);
            a.C0856a.f(c0856a, "BuildInfo", "init success", false, 4, null);
            ready = true;
        } catch (Throwable th2) {
            a.C0856a.l(a.f68962a, "BuildInfo", "init fail e:" + th2, false, 4, null);
        }
    }
}

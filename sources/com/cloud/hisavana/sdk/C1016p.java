package com.cloud.hisavana.sdk;

import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.tmc.kernel.utils.NetworkUtil;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.cloud.hisavana.sdk.p, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1016p {

    /* renamed from: e, reason: collision with root package name */
    public static final d f22895e = new d(null);

    /* renamed from: a, reason: collision with root package name */
    private final int f22896a;

    /* renamed from: b, reason: collision with root package name */
    private final String f22897b;

    /* renamed from: c, reason: collision with root package name */
    private final b f22898c;

    /* renamed from: d, reason: collision with root package name */
    private final Throwable f22899d;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/cloud/hisavana/sdk/p$b;", "", "<init>", "(Ljava/lang/String;I)V", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "c", "d", "e", "api_release"}, k = 1, mv = {1, 9, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* renamed from: com.cloud.hisavana.sdk.p$b */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f22900a = new b("IO", 0);

        /* renamed from: b, reason: collision with root package name */
        public static final b f22901b = new b("DECODING", 1);

        /* renamed from: c, reason: collision with root package name */
        public static final b f22902c = new b("DRM", 2);

        /* renamed from: d, reason: collision with root package name */
        public static final b f22903d = new b("PLAYER_UNAVAILABLE", 3);

        /* renamed from: e, reason: collision with root package name */
        public static final b f22904e = new b(NetworkUtil.NETWORK_TYPE_UNKNOWN, 4);

        /* renamed from: f, reason: collision with root package name */
        private static final /* synthetic */ b[] f22905f;

        /* renamed from: g, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f22906g;

        static {
            b[] a11 = a();
            f22905f = a11;
            f22906g = EnumEntriesKt.a(a11);
        }

        private b(String str, int i11) {
        }

        private static final /* synthetic */ b[] a() {
            return new b[]{f22900a, f22901b, f22902c, f22903d, f22904e};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f22905f.clone();
        }
    }

    /* renamed from: com.cloud.hisavana.sdk.p$d */
    /* loaded from: classes3.dex */
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final C1016p a() {
            return new C1016p(TaErrorCode.CODE_SHOW_VIDEO_PLAYER_UNAVAILABLE, "ExoPlayer is not available, video ad skipped", b.f22903d, null, 8, null);
        }
    }

    public C1016p(int i11, String errorMessage, b errorType, Throwable th2) {
        Intrinsics.h(errorMessage, "errorMessage");
        Intrinsics.h(errorType, "errorType");
        this.f22896a = i11;
        this.f22897b = errorMessage;
        this.f22898c = errorType;
        this.f22899d = th2;
    }

    public /* synthetic */ C1016p(int i11, String str, b bVar, Throwable th2, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, str, (i12 & 4) != 0 ? b.f22904e : bVar, (i12 & 8) != 0 ? null : th2);
    }

    public final int a() {
        return this.f22896a;
    }

    public final String b() {
        return this.f22897b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1016p)) {
            return false;
        }
        C1016p c1016p = (C1016p) obj;
        return this.f22896a == c1016p.f22896a && Intrinsics.c(this.f22897b, c1016p.f22897b) && this.f22898c == c1016p.f22898c && Intrinsics.c(this.f22899d, c1016p.f22899d);
    }

    public int hashCode() {
        int hashCode = ((((this.f22896a * 31) + this.f22897b.hashCode()) * 31) + this.f22898c.hashCode()) * 31;
        Throwable th2 = this.f22899d;
        return hashCode + (th2 == null ? 0 : th2.hashCode());
    }

    public String toString() {
        return "AdVideoError(errorCode=" + this.f22896a + ", errorMessage=" + this.f22897b + ", errorType=" + this.f22898c + ", cause=" + this.f22899d + ')';
    }
}

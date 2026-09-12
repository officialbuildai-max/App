package androidx.work;

import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Build;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: j, reason: collision with root package name */
    public static final b f15543j = new b(null);

    /* renamed from: k, reason: collision with root package name */
    public static final d f15544k = new d(null, false, false, false, 15, null);

    /* renamed from: a, reason: collision with root package name */
    private final NetworkType f15545a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.work.impl.utils.v f15546b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f15547c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f15548d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f15549e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f15550f;

    /* renamed from: g, reason: collision with root package name */
    private final long f15551g;

    /* renamed from: h, reason: collision with root package name */
    private final long f15552h;

    /* renamed from: i, reason: collision with root package name */
    private final Set f15553i;

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f15554a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f15555b;

        /* renamed from: e, reason: collision with root package name */
        private boolean f15558e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f15559f;

        /* renamed from: c, reason: collision with root package name */
        private androidx.work.impl.utils.v f15556c = new androidx.work.impl.utils.v(null, 1, null);

        /* renamed from: d, reason: collision with root package name */
        private NetworkType f15557d = NetworkType.NOT_REQUIRED;

        /* renamed from: g, reason: collision with root package name */
        private long f15560g = -1;

        /* renamed from: h, reason: collision with root package name */
        private long f15561h = -1;

        /* renamed from: i, reason: collision with root package name */
        private Set f15562i = new LinkedHashSet();

        public final d a() {
            Set f11;
            long j11;
            long j12;
            if (Build.VERSION.SDK_INT >= 24) {
                f11 = CollectionsKt.W0(this.f15562i);
                j11 = this.f15560g;
                j12 = this.f15561h;
            } else {
                f11 = SetsKt.f();
                j11 = -1;
                j12 = -1;
            }
            return new d(this.f15556c, this.f15557d, this.f15554a, this.f15555b, this.f15558e, this.f15559f, j11, j12, f11);
        }

        public final a b(NetworkType networkType) {
            Intrinsics.h(networkType, "networkType");
            this.f15557d = networkType;
            this.f15556c = new androidx.work.impl.utils.v(null, 1, null);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final Uri f15563a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f15564b;

        public c(Uri uri, boolean z10) {
            Intrinsics.h(uri, "uri");
            this.f15563a = uri;
            this.f15564b = z10;
        }

        public final Uri a() {
            return this.f15563a;
        }

        public final boolean b() {
            return this.f15564b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!Intrinsics.c(c.class, obj != null ? obj.getClass() : null)) {
                return false;
            }
            Intrinsics.f(obj, "null cannot be cast to non-null type androidx.work.Constraints.ContentUriTrigger");
            c cVar = (c) obj;
            return Intrinsics.c(this.f15563a, cVar.f15563a) && this.f15564b == cVar.f15564b;
        }

        public int hashCode() {
            return (this.f15563a.hashCode() * 31) + androidx.compose.foundation.e.a(this.f15564b);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(NetworkType requiredNetworkType, boolean z10, boolean z11, boolean z12) {
        this(requiredNetworkType, z10, false, z11, z12);
        Intrinsics.h(requiredNetworkType, "requiredNetworkType");
    }

    public /* synthetic */ d(NetworkType networkType, boolean z10, boolean z11, boolean z12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? NetworkType.NOT_REQUIRED : networkType, (i11 & 2) != 0 ? false : z10, (i11 & 4) != 0 ? false : z11, (i11 & 8) != 0 ? false : z12);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(NetworkType requiredNetworkType, boolean z10, boolean z11, boolean z12, boolean z13) {
        this(requiredNetworkType, z10, z11, z12, z13, -1L, 0L, null, PsExtractor.AUDIO_STREAM, null);
        Intrinsics.h(requiredNetworkType, "requiredNetworkType");
    }

    public d(NetworkType requiredNetworkType, boolean z10, boolean z11, boolean z12, boolean z13, long j11, long j12, Set contentUriTriggers) {
        Intrinsics.h(requiredNetworkType, "requiredNetworkType");
        Intrinsics.h(contentUriTriggers, "contentUriTriggers");
        this.f15546b = new androidx.work.impl.utils.v(null, 1, null);
        this.f15545a = requiredNetworkType;
        this.f15547c = z10;
        this.f15548d = z11;
        this.f15549e = z12;
        this.f15550f = z13;
        this.f15551g = j11;
        this.f15552h = j12;
        this.f15553i = contentUriTriggers;
    }

    public /* synthetic */ d(NetworkType networkType, boolean z10, boolean z11, boolean z12, boolean z13, long j11, long j12, Set set, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? NetworkType.NOT_REQUIRED : networkType, (i11 & 2) != 0 ? false : z10, (i11 & 4) != 0 ? false : z11, (i11 & 8) != 0 ? false : z12, (i11 & 16) == 0 ? z13 : false, (i11 & 32) != 0 ? -1L : j11, (i11 & 64) == 0 ? j12 : -1L, (i11 & 128) != 0 ? SetsKt.f() : set);
    }

    public d(d other) {
        Intrinsics.h(other, "other");
        this.f15547c = other.f15547c;
        this.f15548d = other.f15548d;
        this.f15546b = other.f15546b;
        this.f15545a = other.f15545a;
        this.f15549e = other.f15549e;
        this.f15550f = other.f15550f;
        this.f15553i = other.f15553i;
        this.f15551g = other.f15551g;
        this.f15552h = other.f15552h;
    }

    public d(androidx.work.impl.utils.v requiredNetworkRequestCompat, NetworkType requiredNetworkType, boolean z10, boolean z11, boolean z12, boolean z13, long j11, long j12, Set contentUriTriggers) {
        Intrinsics.h(requiredNetworkRequestCompat, "requiredNetworkRequestCompat");
        Intrinsics.h(requiredNetworkType, "requiredNetworkType");
        Intrinsics.h(contentUriTriggers, "contentUriTriggers");
        this.f15546b = requiredNetworkRequestCompat;
        this.f15545a = requiredNetworkType;
        this.f15547c = z10;
        this.f15548d = z11;
        this.f15549e = z12;
        this.f15550f = z13;
        this.f15551g = j11;
        this.f15552h = j12;
        this.f15553i = contentUriTriggers;
    }

    public final long a() {
        return this.f15552h;
    }

    public final long b() {
        return this.f15551g;
    }

    public final Set c() {
        return this.f15553i;
    }

    public final NetworkRequest d() {
        return this.f15546b.b();
    }

    public final androidx.work.impl.utils.v e() {
        return this.f15546b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.c(d.class, obj.getClass())) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f15547c == dVar.f15547c && this.f15548d == dVar.f15548d && this.f15549e == dVar.f15549e && this.f15550f == dVar.f15550f && this.f15551g == dVar.f15551g && this.f15552h == dVar.f15552h && Intrinsics.c(d(), dVar.d()) && this.f15545a == dVar.f15545a) {
            return Intrinsics.c(this.f15553i, dVar.f15553i);
        }
        return false;
    }

    public final NetworkType f() {
        return this.f15545a;
    }

    public final boolean g() {
        return Build.VERSION.SDK_INT < 24 || !this.f15553i.isEmpty();
    }

    public final boolean h() {
        return this.f15549e;
    }

    public int hashCode() {
        int hashCode = ((((((((this.f15545a.hashCode() * 31) + (this.f15547c ? 1 : 0)) * 31) + (this.f15548d ? 1 : 0)) * 31) + (this.f15549e ? 1 : 0)) * 31) + (this.f15550f ? 1 : 0)) * 31;
        long j11 = this.f15551g;
        int i11 = (hashCode + ((int) (j11 ^ (j11 >>> 32)))) * 31;
        long j12 = this.f15552h;
        int hashCode2 = (((i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + this.f15553i.hashCode()) * 31;
        NetworkRequest d11 = d();
        return hashCode2 + (d11 != null ? d11.hashCode() : 0);
    }

    public final boolean i() {
        return this.f15547c;
    }

    public final boolean j() {
        return this.f15548d;
    }

    public final boolean k() {
        return this.f15550f;
    }

    public String toString() {
        return "Constraints{requiredNetworkType=" + this.f15545a + ", requiresCharging=" + this.f15547c + ", requiresDeviceIdle=" + this.f15548d + ", requiresBatteryNotLow=" + this.f15549e + ", requiresStorageNotLow=" + this.f15550f + ", contentTriggerUpdateDelayMillis=" + this.f15551g + ", contentTriggerMaxDelayMillis=" + this.f15552h + ", contentUriTriggers=" + this.f15553i + ", }";
    }
}

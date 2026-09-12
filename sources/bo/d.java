package bo;

import androidx.collection.s;
import androidx.compose.foundation.e;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.transsion.player.config.RenderType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final RenderType f16724a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f16725b;

    /* renamed from: c, reason: collision with root package name */
    private final int f16726c;

    /* renamed from: d, reason: collision with root package name */
    private final int f16727d;

    /* renamed from: e, reason: collision with root package name */
    private final int f16728e;

    /* renamed from: f, reason: collision with root package name */
    private final int f16729f;

    /* renamed from: g, reason: collision with root package name */
    private final int f16730g;

    /* renamed from: h, reason: collision with root package name */
    private final int f16731h;

    /* renamed from: i, reason: collision with root package name */
    private final long f16732i;

    /* renamed from: j, reason: collision with root package name */
    private final int f16733j;

    /* renamed from: k, reason: collision with root package name */
    private final int f16734k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f16735l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f16736m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f16737n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f16738o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f16739p;

    /* renamed from: q, reason: collision with root package name */
    private final String f16740q;

    public d() {
        this(null, false, 0, 0, 0, 0, 0, 0, 0L, 0, 0, false, false, false, false, false, null, 131071, null);
    }

    public d(RenderType type, boolean z10, int i11, int i12, int i13, int i14, int i15, int i16, long j11, int i17, int i18, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, String traceId) {
        Intrinsics.h(type, "type");
        Intrinsics.h(traceId, "traceId");
        this.f16724a = type;
        this.f16725b = z10;
        this.f16726c = i11;
        this.f16727d = i12;
        this.f16728e = i13;
        this.f16729f = i14;
        this.f16730g = i15;
        this.f16731h = i16;
        this.f16732i = j11;
        this.f16733j = i17;
        this.f16734k = i18;
        this.f16735l = z11;
        this.f16736m = z12;
        this.f16737n = z13;
        this.f16738o = z14;
        this.f16739p = z15;
        this.f16740q = traceId;
    }

    public /* synthetic */ d(RenderType renderType, boolean z10, int i11, int i12, int i13, int i14, int i15, int i16, long j11, int i17, int i18, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, String str, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? RenderType.SURFACE_VIEW : renderType, (i19 & 2) != 0 ? true : z10, (i19 & 4) != 0 ? 50 : i11, (i19 & 8) != 0 ? DefaultLoadControl.DEFAULT_MAX_BUFFER_MS : i12, (i19 & 16) != 0 ? AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS : i13, (i19 & 32) != 0 ? 500 : i14, (i19 & 64) != 0 ? 2 : i15, (i19 & 128) != 0 ? 3 : i16, (i19 & 256) != 0 ? 4000L : j11, (i19 & 512) == 0 ? i17 : 50, (i19 & 1024) != 0 ? 30000 : i18, (i19 & 2048) != 0 ? true : z11, (i19 & 4096) != 0 ? false : z12, (i19 & 8192) != 0 ? false : z13, (i19 & 16384) == 0 ? z14 : false, (32768 & i19) != 0 ? true : z15, (i19 & 65536) != 0 ? "" : str);
    }

    public final int a() {
        return this.f16733j;
    }

    public final boolean b() {
        return this.f16736m;
    }

    public final boolean c() {
        return this.f16738o;
    }

    public final boolean d() {
        return this.f16737n;
    }

    public final boolean e() {
        return this.f16735l;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f16724a == dVar.f16724a && this.f16725b == dVar.f16725b && this.f16726c == dVar.f16726c && this.f16727d == dVar.f16727d && this.f16728e == dVar.f16728e && this.f16729f == dVar.f16729f && this.f16730g == dVar.f16730g && this.f16731h == dVar.f16731h && this.f16732i == dVar.f16732i && this.f16733j == dVar.f16733j && this.f16734k == dVar.f16734k && this.f16735l == dVar.f16735l && this.f16736m == dVar.f16736m && this.f16737n == dVar.f16737n && this.f16738o == dVar.f16738o && this.f16739p == dVar.f16739p && Intrinsics.c(this.f16740q, dVar.f16740q);
    }

    public final int f() {
        return this.f16728e;
    }

    public final int g() {
        return this.f16727d;
    }

    public final int h() {
        return this.f16734k;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((this.f16724a.hashCode() * 31) + e.a(this.f16725b)) * 31) + this.f16726c) * 31) + this.f16727d) * 31) + this.f16728e) * 31) + this.f16729f) * 31) + this.f16730g) * 31) + this.f16731h) * 31) + s.a(this.f16732i)) * 31) + this.f16733j) * 31) + this.f16734k) * 31) + e.a(this.f16735l)) * 31) + e.a(this.f16736m)) * 31) + e.a(this.f16737n)) * 31) + e.a(this.f16738o)) * 31) + e.a(this.f16739p)) * 31) + this.f16740q.hashCode();
    }

    public final boolean i() {
        return this.f16739p;
    }

    public final boolean j() {
        return this.f16725b;
    }

    public final int k() {
        return this.f16726c;
    }

    public final long l() {
        return this.f16732i;
    }

    public final int m() {
        return this.f16730g;
    }

    public final int n() {
        return this.f16729f;
    }

    public final String o() {
        return this.f16740q;
    }

    public final RenderType p() {
        return this.f16724a;
    }

    public String toString() {
        return "VodConfig(type=" + this.f16724a + ", openCache=" + this.f16725b + ", positionTimerIntervalMs=" + this.f16726c + ", maxBufferDuration=" + this.f16727d + ", highBufferDuration=" + this.f16728e + ", startBufferDuration=" + this.f16729f + ", retryCount=" + this.f16730g + ", preloadCount=" + this.f16731h + ", preloadDuration=" + this.f16732i + ", cacheMaxSizeMB=" + this.f16733j + ", networkTimeout=" + this.f16734k + ", enableHardwareDecoder=" + this.f16735l + ", clearFrameWhenStop=" + this.f16736m + ", disableVideo=" + this.f16737n + ", disableAudio=" + this.f16738o + ", openAudioFocus=" + this.f16739p + ", traceId=" + this.f16740q + ")";
    }
}

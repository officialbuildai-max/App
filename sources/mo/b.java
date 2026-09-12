package mo;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final String f69778a;

    /* renamed from: b, reason: collision with root package name */
    private final String f69779b;

    /* renamed from: c, reason: collision with root package name */
    private final String f69780c;

    /* renamed from: d, reason: collision with root package name */
    private final int f69781d;

    /* renamed from: e, reason: collision with root package name */
    private final int f69782e;

    /* renamed from: f, reason: collision with root package name */
    private final int f69783f;

    /* renamed from: g, reason: collision with root package name */
    private final int f69784g;

    /* renamed from: h, reason: collision with root package name */
    private final String f69785h;

    /* renamed from: i, reason: collision with root package name */
    private final int f69786i;

    /* renamed from: j, reason: collision with root package name */
    private final int f69787j;

    /* renamed from: k, reason: collision with root package name */
    private final float f69788k;

    /* renamed from: l, reason: collision with root package name */
    private final int f69789l;

    /* renamed from: m, reason: collision with root package name */
    private final float f69790m;

    public b() {
        this(null, null, null, 0, 0, 0, 0, null, 0, 0, 0.0f, 0, 0.0f, 8191, null);
    }

    public b(String str, String str2, String str3, int i11, int i12, int i13, int i14, String str4, int i15, int i16, float f11, int i17, float f12) {
        this.f69778a = str;
        this.f69779b = str2;
        this.f69780c = str3;
        this.f69781d = i11;
        this.f69782e = i12;
        this.f69783f = i13;
        this.f69784g = i14;
        this.f69785h = str4;
        this.f69786i = i15;
        this.f69787j = i16;
        this.f69788k = f11;
        this.f69789l = i17;
        this.f69790m = f12;
    }

    public /* synthetic */ b(String str, String str2, String str3, int i11, int i12, int i13, int i14, String str4, int i15, int i16, float f11, int i17, float f12, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? null : str, (i18 & 2) != 0 ? null : str2, (i18 & 4) != 0 ? null : str3, (i18 & 8) != 0 ? 0 : i11, (i18 & 16) != 0 ? 0 : i12, (i18 & 32) != 0 ? 0 : i13, (i18 & 64) != 0 ? 0 : i14, (i18 & 128) == 0 ? str4 : null, (i18 & 256) != 0 ? 0 : i15, (i18 & 512) != 0 ? 0 : i16, (i18 & 1024) != 0 ? 0.0f : f11, (i18 & 2048) == 0 ? i17 : 0, (i18 & 4096) == 0 ? f12 : 0.0f);
    }

    public final int a() {
        return this.f69784g;
    }

    public final String b() {
        return this.f69785h;
    }

    public final int c() {
        return this.f69787j;
    }

    public final String d() {
        return this.f69778a;
    }

    public final int e() {
        return this.f69783f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.c(this.f69778a, bVar.f69778a) && Intrinsics.c(this.f69779b, bVar.f69779b) && Intrinsics.c(this.f69780c, bVar.f69780c) && this.f69781d == bVar.f69781d && this.f69782e == bVar.f69782e && this.f69783f == bVar.f69783f && this.f69784g == bVar.f69784g && Intrinsics.c(this.f69785h, bVar.f69785h) && this.f69786i == bVar.f69786i && this.f69787j == bVar.f69787j && Float.compare(this.f69788k, bVar.f69788k) == 0 && this.f69789l == bVar.f69789l && Float.compare(this.f69790m, bVar.f69790m) == 0;
    }

    public final int f() {
        return this.f69786i;
    }

    public int hashCode() {
        String str = this.f69778a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f69779b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f69780c;
        int hashCode3 = (((((((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f69781d) * 31) + this.f69782e) * 31) + this.f69783f) * 31) + this.f69784g) * 31;
        String str4 = this.f69785h;
        return ((((((((((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.f69786i) * 31) + this.f69787j) * 31) + Float.floatToIntBits(this.f69788k)) * 31) + this.f69789l) * 31) + Float.floatToIntBits(this.f69790m);
    }

    public String toString() {
        return "TnFormat(id=" + this.f69778a + ", label=" + this.f69779b + ", language=" + this.f69780c + ", selectionFlags=" + this.f69781d + ", averageBitrate=" + this.f69782e + ", peakBitrate=" + this.f69783f + ", bitrate=" + this.f69784g + ", codecs=" + this.f69785h + ", width=" + this.f69786i + ", height=" + this.f69787j + ", frameRate=" + this.f69788k + ", rotationDegrees=" + this.f69789l + ", pixelWidthHeightRatio=" + this.f69790m + ")";
    }
}

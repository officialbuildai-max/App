package go;

import com.transsion.player.p007enum.PlayMimeType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final PlayMimeType f64039a;

    /* renamed from: b, reason: collision with root package name */
    private final String f64040b;

    /* renamed from: c, reason: collision with root package name */
    private final String f64041c;

    /* renamed from: d, reason: collision with root package name */
    private final String f64042d;

    /* renamed from: e, reason: collision with root package name */
    private final String f64043e;

    /* renamed from: f, reason: collision with root package name */
    private final String f64044f;

    /* renamed from: g, reason: collision with root package name */
    private final String f64045g;

    /* renamed from: h, reason: collision with root package name */
    private String f64046h;

    /* renamed from: i, reason: collision with root package name */
    private String f64047i;

    public c(PlayMimeType format, String id2, String url, String resolutions, String size, String duration, String signCookie, String str) {
        Intrinsics.h(format, "format");
        Intrinsics.h(id2, "id");
        Intrinsics.h(url, "url");
        Intrinsics.h(resolutions, "resolutions");
        Intrinsics.h(size, "size");
        Intrinsics.h(duration, "duration");
        Intrinsics.h(signCookie, "signCookie");
        this.f64039a = format;
        this.f64040b = id2;
        this.f64041c = url;
        this.f64042d = resolutions;
        this.f64043e = size;
        this.f64044f = duration;
        this.f64045g = signCookie;
        this.f64046h = str;
    }

    public /* synthetic */ c(PlayMimeType playMimeType, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(playMimeType, str, str2, str3, str4, str5, str6, (i11 & 128) != 0 ? null : str7);
    }

    public final String a() {
        return this.f64044f;
    }

    public final PlayMimeType b() {
        return this.f64039a;
    }

    public final String c() {
        return this.f64040b;
    }

    public final String d() {
        return this.f64047i;
    }

    public final String e() {
        return this.f64042d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f64039a == cVar.f64039a && Intrinsics.c(this.f64040b, cVar.f64040b) && Intrinsics.c(this.f64041c, cVar.f64041c) && Intrinsics.c(this.f64042d, cVar.f64042d) && Intrinsics.c(this.f64043e, cVar.f64043e) && Intrinsics.c(this.f64044f, cVar.f64044f) && Intrinsics.c(this.f64045g, cVar.f64045g) && Intrinsics.c(this.f64046h, cVar.f64046h);
    }

    public final String f() {
        return this.f64045g;
    }

    public final String g() {
        return this.f64043e;
    }

    public final String h() {
        return this.f64041c;
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.f64039a.hashCode() * 31) + this.f64040b.hashCode()) * 31) + this.f64041c.hashCode()) * 31) + this.f64042d.hashCode()) * 31) + this.f64043e.hashCode()) * 31) + this.f64044f.hashCode()) * 31) + this.f64045g.hashCode()) * 31;
        String str = this.f64046h;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final boolean i() {
        return StringsKt.c0(this.f64041c, ".mp3", false, 2, null);
    }

    public final boolean j() {
        return StringsKt.W(this.f64041c, "http", false, 2, null);
    }

    public final boolean k() {
        PlayMimeType playMimeType = this.f64039a;
        return playMimeType == PlayMimeType.DASH || playMimeType == PlayMimeType.HLS;
    }

    public final void l(String str) {
        this.f64047i = str;
    }

    public String toString() {
        return "LongVdPlayerStreamBean(format=" + this.f64039a + ", id=" + this.f64040b + ", url=" + this.f64041c + ", resolutions=" + this.f64042d + ", size=" + this.f64043e + ", duration=" + this.f64044f + ", signCookie=" + this.f64045g + ", originalResolutions=" + this.f64046h + ")";
    }
}

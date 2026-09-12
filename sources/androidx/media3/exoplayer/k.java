package androidx.media3.exoplayer;

/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final String f12132a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.media3.common.r f12133b;

    /* renamed from: c, reason: collision with root package name */
    public final androidx.media3.common.r f12134c;

    /* renamed from: d, reason: collision with root package name */
    public final int f12135d;

    /* renamed from: e, reason: collision with root package name */
    public final int f12136e;

    public k(String str, androidx.media3.common.r rVar, androidx.media3.common.r rVar2, int i11, int i12) {
        androidx.media3.common.util.a.a(i11 == 0 || i12 == 0);
        this.f12132a = androidx.media3.common.util.a.d(str);
        this.f12133b = (androidx.media3.common.r) androidx.media3.common.util.a.e(rVar);
        this.f12134c = (androidx.media3.common.r) androidx.media3.common.util.a.e(rVar2);
        this.f12135d = i11;
        this.f12136e = i12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.f12135d == kVar.f12135d && this.f12136e == kVar.f12136e && this.f12132a.equals(kVar.f12132a) && this.f12133b.equals(kVar.f12133b) && this.f12134c.equals(kVar.f12134c);
    }

    public int hashCode() {
        return ((((((((527 + this.f12135d) * 31) + this.f12136e) * 31) + this.f12132a.hashCode()) * 31) + this.f12133b.hashCode()) * 31) + this.f12134c.hashCode();
    }
}

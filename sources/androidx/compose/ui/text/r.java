package androidx.compose.ui.text;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    private final int f6419a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6420b;

    /* renamed from: c, reason: collision with root package name */
    private final long f6421c;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.compose.ui.text.style.n f6422d;

    /* renamed from: e, reason: collision with root package name */
    private final u f6423e;

    /* renamed from: f, reason: collision with root package name */
    private final androidx.compose.ui.text.style.g f6424f;

    /* renamed from: g, reason: collision with root package name */
    private final int f6425g;

    /* renamed from: h, reason: collision with root package name */
    private final int f6426h;

    /* renamed from: i, reason: collision with root package name */
    private final androidx.compose.ui.text.style.o f6427i;

    private r(int i11, int i12, long j11, androidx.compose.ui.text.style.n nVar, u uVar, androidx.compose.ui.text.style.g gVar, int i13, int i14, androidx.compose.ui.text.style.o oVar) {
        this.f6419a = i11;
        this.f6420b = i12;
        this.f6421c = j11;
        this.f6422d = nVar;
        this.f6423e = uVar;
        this.f6424f = gVar;
        this.f6425g = i13;
        this.f6426h = i14;
        this.f6427i = oVar;
        if (o0.w.e(j11, o0.w.f70751b.a()) || o0.w.h(j11) >= 0.0f) {
            return;
        }
        throw new IllegalStateException(("lineHeight can't be negative (" + o0.w.h(j11) + ')').toString());
    }

    public /* synthetic */ r(int i11, int i12, long j11, androidx.compose.ui.text.style.n nVar, u uVar, androidx.compose.ui.text.style.g gVar, int i13, int i14, androidx.compose.ui.text.style.o oVar, int i15, DefaultConstructorMarker defaultConstructorMarker) {
        this((i15 & 1) != 0 ? androidx.compose.ui.text.style.h.f6475b.g() : i11, (i15 & 2) != 0 ? androidx.compose.ui.text.style.j.f6489b.f() : i12, (i15 & 4) != 0 ? o0.w.f70751b.a() : j11, (i15 & 8) != 0 ? null : nVar, (i15 & 16) != 0 ? null : uVar, (i15 & 32) != 0 ? null : gVar, (i15 & 64) != 0 ? androidx.compose.ui.text.style.e.f6441a.b() : i13, (i15 & 128) != 0 ? androidx.compose.ui.text.style.d.f6437a.c() : i14, (i15 & 256) == 0 ? oVar : null, null);
    }

    public /* synthetic */ r(int i11, int i12, long j11, androidx.compose.ui.text.style.n nVar, u uVar, androidx.compose.ui.text.style.g gVar, int i13, int i14, androidx.compose.ui.text.style.o oVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, i12, j11, nVar, uVar, gVar, i13, i14, oVar);
    }

    public final r a(int i11, int i12, long j11, androidx.compose.ui.text.style.n nVar, u uVar, androidx.compose.ui.text.style.g gVar, int i13, int i14, androidx.compose.ui.text.style.o oVar) {
        return new r(i11, i12, j11, nVar, uVar, gVar, i13, i14, oVar, null);
    }

    public final int c() {
        return this.f6426h;
    }

    public final int d() {
        return this.f6425g;
    }

    public final long e() {
        return this.f6421c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return androidx.compose.ui.text.style.h.k(this.f6419a, rVar.f6419a) && androidx.compose.ui.text.style.j.j(this.f6420b, rVar.f6420b) && o0.w.e(this.f6421c, rVar.f6421c) && Intrinsics.c(this.f6422d, rVar.f6422d) && Intrinsics.c(this.f6423e, rVar.f6423e) && Intrinsics.c(this.f6424f, rVar.f6424f) && androidx.compose.ui.text.style.e.d(this.f6425g, rVar.f6425g) && androidx.compose.ui.text.style.d.e(this.f6426h, rVar.f6426h) && Intrinsics.c(this.f6427i, rVar.f6427i);
    }

    public final androidx.compose.ui.text.style.g f() {
        return this.f6424f;
    }

    public final u g() {
        return this.f6423e;
    }

    public final int h() {
        return this.f6419a;
    }

    public int hashCode() {
        int l11 = ((((androidx.compose.ui.text.style.h.l(this.f6419a) * 31) + androidx.compose.ui.text.style.j.k(this.f6420b)) * 31) + o0.w.i(this.f6421c)) * 31;
        androidx.compose.ui.text.style.n nVar = this.f6422d;
        int hashCode = (l11 + (nVar != null ? nVar.hashCode() : 0)) * 31;
        u uVar = this.f6423e;
        int hashCode2 = (hashCode + (uVar != null ? uVar.hashCode() : 0)) * 31;
        androidx.compose.ui.text.style.g gVar = this.f6424f;
        int hashCode3 = (((((hashCode2 + (gVar != null ? gVar.hashCode() : 0)) * 31) + androidx.compose.ui.text.style.e.h(this.f6425g)) * 31) + androidx.compose.ui.text.style.d.f(this.f6426h)) * 31;
        androidx.compose.ui.text.style.o oVar = this.f6427i;
        return hashCode3 + (oVar != null ? oVar.hashCode() : 0);
    }

    public final int i() {
        return this.f6420b;
    }

    public final androidx.compose.ui.text.style.n j() {
        return this.f6422d;
    }

    public final androidx.compose.ui.text.style.o k() {
        return this.f6427i;
    }

    public final r l(r rVar) {
        return rVar == null ? this : s.a(this, rVar.f6419a, rVar.f6420b, rVar.f6421c, rVar.f6422d, rVar.f6423e, rVar.f6424f, rVar.f6425g, rVar.f6426h, rVar.f6427i);
    }

    public String toString() {
        return "ParagraphStyle(textAlign=" + ((Object) androidx.compose.ui.text.style.h.m(this.f6419a)) + ", textDirection=" + ((Object) androidx.compose.ui.text.style.j.l(this.f6420b)) + ", lineHeight=" + ((Object) o0.w.j(this.f6421c)) + ", textIndent=" + this.f6422d + ", platformStyle=" + this.f6423e + ", lineHeightStyle=" + this.f6424f + ", lineBreak=" + ((Object) androidx.compose.ui.text.style.e.i(this.f6425g)) + ", hyphens=" + ((Object) androidx.compose.ui.text.style.d.g(this.f6426h)) + ", textMotion=" + this.f6427i + ')';
    }
}

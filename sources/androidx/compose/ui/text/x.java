package androidx.compose.ui.text;

import androidx.compose.ui.graphics.j1;
import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.graphics.z4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.compose.ui.text.style.l f6529a;

    /* renamed from: b, reason: collision with root package name */
    private final long f6530b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.compose.ui.text.font.p f6531c;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.compose.ui.text.font.n f6532d;

    /* renamed from: e, reason: collision with root package name */
    private final androidx.compose.ui.text.font.o f6533e;

    /* renamed from: f, reason: collision with root package name */
    private final androidx.compose.ui.text.font.h f6534f;

    /* renamed from: g, reason: collision with root package name */
    private final String f6535g;

    /* renamed from: h, reason: collision with root package name */
    private final long f6536h;

    /* renamed from: i, reason: collision with root package name */
    private final androidx.compose.ui.text.style.a f6537i;

    /* renamed from: j, reason: collision with root package name */
    private final androidx.compose.ui.text.style.m f6538j;

    /* renamed from: k, reason: collision with root package name */
    private final n0.i f6539k;

    /* renamed from: l, reason: collision with root package name */
    private final long f6540l;

    /* renamed from: m, reason: collision with root package name */
    private final androidx.compose.ui.text.style.i f6541m;

    /* renamed from: n, reason: collision with root package name */
    private final z4 f6542n;

    /* renamed from: o, reason: collision with root package name */
    private final v f6543o;

    /* renamed from: p, reason: collision with root package name */
    private final z.h f6544p;

    private x(long j11, long j12, androidx.compose.ui.text.font.p pVar, androidx.compose.ui.text.font.n nVar, androidx.compose.ui.text.font.o oVar, androidx.compose.ui.text.font.h hVar, String str, long j13, androidx.compose.ui.text.style.a aVar, androidx.compose.ui.text.style.m mVar, n0.i iVar, long j14, androidx.compose.ui.text.style.i iVar2, z4 z4Var, v vVar, z.h hVar2) {
        this(androidx.compose.ui.text.style.l.f6497a.b(j11), j12, pVar, nVar, oVar, hVar, str, j13, aVar, mVar, iVar, j14, iVar2, z4Var, vVar, hVar2, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ x(long j11, long j12, androidx.compose.ui.text.font.p pVar, androidx.compose.ui.text.font.n nVar, androidx.compose.ui.text.font.o oVar, androidx.compose.ui.text.font.h hVar, String str, long j13, androidx.compose.ui.text.style.a aVar, androidx.compose.ui.text.style.m mVar, n0.i iVar, long j14, androidx.compose.ui.text.style.i iVar2, z4 z4Var, v vVar, z.h hVar2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? u1.f4733b.e() : j11, (i11 & 2) != 0 ? o0.w.f70751b.a() : j12, (i11 & 4) != 0 ? null : pVar, (i11 & 8) != 0 ? null : nVar, (i11 & 16) != 0 ? null : oVar, (i11 & 32) != 0 ? null : hVar, (i11 & 64) != 0 ? null : str, (i11 & 128) != 0 ? o0.w.f70751b.a() : j13, (i11 & 256) != 0 ? null : aVar, (i11 & 512) != 0 ? null : mVar, (i11 & 1024) != 0 ? null : iVar, (i11 & 2048) != 0 ? u1.f4733b.e() : j14, (i11 & 4096) != 0 ? null : iVar2, (i11 & 8192) != 0 ? null : z4Var, (i11 & 16384) != 0 ? null : vVar, (i11 & 32768) != 0 ? null : hVar2, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ x(long j11, long j12, androidx.compose.ui.text.font.p pVar, androidx.compose.ui.text.font.n nVar, androidx.compose.ui.text.font.o oVar, androidx.compose.ui.text.font.h hVar, String str, long j13, androidx.compose.ui.text.style.a aVar, androidx.compose.ui.text.style.m mVar, n0.i iVar, long j14, androidx.compose.ui.text.style.i iVar2, z4 z4Var, v vVar, z.h hVar2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, pVar, nVar, oVar, hVar, str, j13, aVar, mVar, iVar, j14, iVar2, z4Var, vVar, hVar2);
    }

    private x(androidx.compose.ui.text.style.l lVar, long j11, androidx.compose.ui.text.font.p pVar, androidx.compose.ui.text.font.n nVar, androidx.compose.ui.text.font.o oVar, androidx.compose.ui.text.font.h hVar, String str, long j12, androidx.compose.ui.text.style.a aVar, androidx.compose.ui.text.style.m mVar, n0.i iVar, long j13, androidx.compose.ui.text.style.i iVar2, z4 z4Var, v vVar, z.h hVar2) {
        this.f6529a = lVar;
        this.f6530b = j11;
        this.f6531c = pVar;
        this.f6532d = nVar;
        this.f6533e = oVar;
        this.f6534f = hVar;
        this.f6535g = str;
        this.f6536h = j12;
        this.f6537i = aVar;
        this.f6538j = mVar;
        this.f6539k = iVar;
        this.f6540l = j13;
        this.f6541m = iVar2;
        this.f6542n = z4Var;
        this.f6543o = vVar;
        this.f6544p = hVar2;
    }

    public /* synthetic */ x(androidx.compose.ui.text.style.l lVar, long j11, androidx.compose.ui.text.font.p pVar, androidx.compose.ui.text.font.n nVar, androidx.compose.ui.text.font.o oVar, androidx.compose.ui.text.font.h hVar, String str, long j12, androidx.compose.ui.text.style.a aVar, androidx.compose.ui.text.style.m mVar, n0.i iVar, long j13, androidx.compose.ui.text.style.i iVar2, z4 z4Var, v vVar, z.h hVar2, DefaultConstructorMarker defaultConstructorMarker) {
        this(lVar, j11, pVar, nVar, oVar, hVar, str, j12, aVar, mVar, iVar, j13, iVar2, z4Var, vVar, hVar2);
    }

    public final x a(long j11, long j12, androidx.compose.ui.text.font.p pVar, androidx.compose.ui.text.font.n nVar, androidx.compose.ui.text.font.o oVar, androidx.compose.ui.text.font.h hVar, String str, long j13, androidx.compose.ui.text.style.a aVar, androidx.compose.ui.text.style.m mVar, n0.i iVar, long j14, androidx.compose.ui.text.style.i iVar2, z4 z4Var, v vVar, z.h hVar2) {
        return new x(u1.m(j11, g()) ? this.f6529a : androidx.compose.ui.text.style.l.f6497a.b(j11), j12, pVar, nVar, oVar, hVar, str, j13, aVar, mVar, iVar, j14, iVar2, z4Var, vVar, hVar2, (DefaultConstructorMarker) null);
    }

    public final float c() {
        return this.f6529a.getAlpha();
    }

    public final long d() {
        return this.f6540l;
    }

    public final androidx.compose.ui.text.style.a e() {
        return this.f6537i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return v(xVar) && w(xVar);
    }

    public final j1 f() {
        return this.f6529a.d();
    }

    public final long g() {
        return this.f6529a.a();
    }

    public final z.h h() {
        return this.f6544p;
    }

    public int hashCode() {
        int s11 = u1.s(g()) * 31;
        j1 f11 = f();
        int hashCode = (((((s11 + (f11 != null ? f11.hashCode() : 0)) * 31) + Float.floatToIntBits(c())) * 31) + o0.w.i(this.f6530b)) * 31;
        androidx.compose.ui.text.font.p pVar = this.f6531c;
        int hashCode2 = (hashCode + (pVar != null ? pVar.hashCode() : 0)) * 31;
        androidx.compose.ui.text.font.n nVar = this.f6532d;
        int g11 = (hashCode2 + (nVar != null ? androidx.compose.ui.text.font.n.g(nVar.i()) : 0)) * 31;
        androidx.compose.ui.text.font.o oVar = this.f6533e;
        int i11 = (g11 + (oVar != null ? androidx.compose.ui.text.font.o.i(oVar.k()) : 0)) * 31;
        androidx.compose.ui.text.font.h hVar = this.f6534f;
        int hashCode3 = (i11 + (hVar != null ? hVar.hashCode() : 0)) * 31;
        String str = this.f6535g;
        int hashCode4 = (((hashCode3 + (str != null ? str.hashCode() : 0)) * 31) + o0.w.i(this.f6536h)) * 31;
        androidx.compose.ui.text.style.a aVar = this.f6537i;
        int f12 = (hashCode4 + (aVar != null ? androidx.compose.ui.text.style.a.f(aVar.h()) : 0)) * 31;
        androidx.compose.ui.text.style.m mVar = this.f6538j;
        int hashCode5 = (f12 + (mVar != null ? mVar.hashCode() : 0)) * 31;
        n0.i iVar = this.f6539k;
        int hashCode6 = (((hashCode5 + (iVar != null ? iVar.hashCode() : 0)) * 31) + u1.s(this.f6540l)) * 31;
        androidx.compose.ui.text.style.i iVar2 = this.f6541m;
        int hashCode7 = (hashCode6 + (iVar2 != null ? iVar2.hashCode() : 0)) * 31;
        z4 z4Var = this.f6542n;
        int hashCode8 = (hashCode7 + (z4Var != null ? z4Var.hashCode() : 0)) * 31;
        v vVar = this.f6543o;
        int hashCode9 = (hashCode8 + (vVar != null ? vVar.hashCode() : 0)) * 31;
        z.h hVar2 = this.f6544p;
        return hashCode9 + (hVar2 != null ? hVar2.hashCode() : 0);
    }

    public final androidx.compose.ui.text.font.h i() {
        return this.f6534f;
    }

    public final String j() {
        return this.f6535g;
    }

    public final long k() {
        return this.f6530b;
    }

    public final androidx.compose.ui.text.font.n l() {
        return this.f6532d;
    }

    public final androidx.compose.ui.text.font.o m() {
        return this.f6533e;
    }

    public final androidx.compose.ui.text.font.p n() {
        return this.f6531c;
    }

    public final long o() {
        return this.f6536h;
    }

    public final n0.i p() {
        return this.f6539k;
    }

    public final v q() {
        return this.f6543o;
    }

    public final z4 r() {
        return this.f6542n;
    }

    public final androidx.compose.ui.text.style.i s() {
        return this.f6541m;
    }

    public final androidx.compose.ui.text.style.l t() {
        return this.f6529a;
    }

    public String toString() {
        return "SpanStyle(color=" + ((Object) u1.t(g())) + ", brush=" + f() + ", alpha=" + c() + ", fontSize=" + ((Object) o0.w.j(this.f6530b)) + ", fontWeight=" + this.f6531c + ", fontStyle=" + this.f6532d + ", fontSynthesis=" + this.f6533e + ", fontFamily=" + this.f6534f + ", fontFeatureSettings=" + this.f6535g + ", letterSpacing=" + ((Object) o0.w.j(this.f6536h)) + ", baselineShift=" + this.f6537i + ", textGeometricTransform=" + this.f6538j + ", localeList=" + this.f6539k + ", background=" + ((Object) u1.t(this.f6540l)) + ", textDecoration=" + this.f6541m + ", shadow=" + this.f6542n + ", platformStyle=" + this.f6543o + ", drawStyle=" + this.f6544p + ')';
    }

    public final androidx.compose.ui.text.style.m u() {
        return this.f6538j;
    }

    public final boolean v(x xVar) {
        if (this == xVar) {
            return true;
        }
        return o0.w.e(this.f6530b, xVar.f6530b) && Intrinsics.c(this.f6531c, xVar.f6531c) && Intrinsics.c(this.f6532d, xVar.f6532d) && Intrinsics.c(this.f6533e, xVar.f6533e) && Intrinsics.c(this.f6534f, xVar.f6534f) && Intrinsics.c(this.f6535g, xVar.f6535g) && o0.w.e(this.f6536h, xVar.f6536h) && Intrinsics.c(this.f6537i, xVar.f6537i) && Intrinsics.c(this.f6538j, xVar.f6538j) && Intrinsics.c(this.f6539k, xVar.f6539k) && u1.m(this.f6540l, xVar.f6540l) && Intrinsics.c(this.f6543o, xVar.f6543o);
    }

    public final boolean w(x xVar) {
        return Intrinsics.c(this.f6529a, xVar.f6529a) && Intrinsics.c(this.f6541m, xVar.f6541m) && Intrinsics.c(this.f6542n, xVar.f6542n) && Intrinsics.c(this.f6544p, xVar.f6544p);
    }

    public final x x(x xVar) {
        return xVar == null ? this : SpanStyleKt.b(this, xVar.f6529a.a(), xVar.f6529a.d(), xVar.f6529a.getAlpha(), xVar.f6530b, xVar.f6531c, xVar.f6532d, xVar.f6533e, xVar.f6534f, xVar.f6535g, xVar.f6536h, xVar.f6537i, xVar.f6538j, xVar.f6539k, xVar.f6540l, xVar.f6541m, xVar.f6542n, xVar.f6543o, xVar.f6544p);
    }
}

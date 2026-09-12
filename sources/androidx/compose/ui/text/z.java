package androidx.compose.ui.text;

import androidx.compose.ui.text.style.ResolvedTextDirection;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    private final y f6556a;

    /* renamed from: b, reason: collision with root package name */
    private final MultiParagraph f6557b;

    /* renamed from: c, reason: collision with root package name */
    private final long f6558c;

    /* renamed from: d, reason: collision with root package name */
    private final float f6559d;

    /* renamed from: e, reason: collision with root package name */
    private final float f6560e;

    /* renamed from: f, reason: collision with root package name */
    private final List f6561f;

    private z(y yVar, MultiParagraph multiParagraph, long j11) {
        this.f6556a = yVar;
        this.f6557b = multiParagraph;
        this.f6558c = j11;
        this.f6559d = multiParagraph.g();
        this.f6560e = multiParagraph.j();
        this.f6561f = multiParagraph.v();
    }

    public /* synthetic */ z(y yVar, MultiParagraph multiParagraph, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(yVar, multiParagraph, j11);
    }

    public static /* synthetic */ z b(z zVar, y yVar, long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            yVar = zVar.f6556a;
        }
        if ((i11 & 2) != 0) {
            j11 = zVar.f6558c;
        }
        return zVar.a(yVar, j11);
    }

    public static /* synthetic */ int o(z zVar, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z10 = false;
        }
        return zVar.n(i11, z10);
    }

    public final z a(y yVar, long j11) {
        return new z(yVar, this.f6557b, j11, null);
    }

    public final ResolvedTextDirection c(int i11) {
        return this.f6557b.c(i11);
    }

    public final y.i d(int i11) {
        return this.f6557b.d(i11);
    }

    public final y.i e(int i11) {
        return this.f6557b.e(i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return Intrinsics.c(this.f6556a, zVar.f6556a) && Intrinsics.c(this.f6557b, zVar.f6557b) && o0.t.e(this.f6558c, zVar.f6558c) && this.f6559d == zVar.f6559d && this.f6560e == zVar.f6560e && Intrinsics.c(this.f6561f, zVar.f6561f);
    }

    public final boolean f() {
        return this.f6557b.f() || ((float) o0.t.f(this.f6558c)) < this.f6557b.h();
    }

    public final boolean g() {
        return ((float) o0.t.g(this.f6558c)) < this.f6557b.w();
    }

    public final float h() {
        return this.f6559d;
    }

    public int hashCode() {
        return (((((((((this.f6556a.hashCode() * 31) + this.f6557b.hashCode()) * 31) + o0.t.h(this.f6558c)) * 31) + Float.floatToIntBits(this.f6559d)) * 31) + Float.floatToIntBits(this.f6560e)) * 31) + this.f6561f.hashCode();
    }

    public final boolean i() {
        return g() || f();
    }

    public final float j() {
        return this.f6560e;
    }

    public final y k() {
        return this.f6556a;
    }

    public final float l(int i11) {
        return this.f6557b.k(i11);
    }

    public final int m() {
        return this.f6557b.l();
    }

    public final int n(int i11, boolean z10) {
        return this.f6557b.m(i11, z10);
    }

    public final int p(int i11) {
        return this.f6557b.n(i11);
    }

    public final int q(float f11) {
        return this.f6557b.o(f11);
    }

    public final float r(int i11) {
        return this.f6557b.p(i11);
    }

    public final float s(int i11) {
        return this.f6557b.q(i11);
    }

    public final int t(int i11) {
        return this.f6557b.r(i11);
    }

    public String toString() {
        return "TextLayoutResult(layoutInput=" + this.f6556a + ", multiParagraph=" + this.f6557b + ", size=" + ((Object) o0.t.i(this.f6558c)) + ", firstBaseline=" + this.f6559d + ", lastBaseline=" + this.f6560e + ", placeholderRects=" + this.f6561f + ')';
    }

    public final float u(int i11) {
        return this.f6557b.s(i11);
    }

    public final MultiParagraph v() {
        return this.f6557b;
    }

    public final ResolvedTextDirection w(int i11) {
        return this.f6557b.t(i11);
    }

    public final List x() {
        return this.f6561f;
    }

    public final long y() {
        return this.f6558c;
    }
}

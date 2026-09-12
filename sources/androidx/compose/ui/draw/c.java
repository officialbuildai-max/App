package androidx.compose.ui.draw;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import o0.m;

/* loaded from: classes.dex */
public final class c implements o0.e {

    /* renamed from: a, reason: collision with root package name */
    private a f4241a = i.f4247a;

    /* renamed from: b, reason: collision with root package name */
    private h f4242b;

    /* renamed from: c, reason: collision with root package name */
    private z.c f4243c;

    /* renamed from: d, reason: collision with root package name */
    private Function0 f4244d;

    public final void B(z.c cVar) {
        this.f4243c = cVar;
    }

    public final void C(h hVar) {
        this.f4242b = hVar;
    }

    @Override // o0.n
    public float C0() {
        return this.f4241a.getDensity().C0();
    }

    public final void D(Function0 function0) {
        this.f4244d = function0;
    }

    @Override // o0.e
    public /* synthetic */ float E0(float f11) {
        return o0.d.e(this, f11);
    }

    @Override // o0.n
    public /* synthetic */ long H(float f11) {
        return m.b(this, f11);
    }

    @Override // o0.n
    public /* synthetic */ float J(long j11) {
        return m.a(this, j11);
    }

    @Override // o0.e
    public /* synthetic */ long Q(float f11) {
        return o0.d.g(this, f11);
    }

    @Override // o0.e
    public /* synthetic */ long Q0(long j11) {
        return o0.d.f(this, j11);
    }

    @Override // o0.e
    public /* synthetic */ int c0(float f11) {
        return o0.d.a(this, f11);
    }

    @Override // o0.e
    public float getDensity() {
        return this.f4241a.getDensity().getDensity();
    }

    public final LayoutDirection getLayoutDirection() {
        return this.f4241a.getLayoutDirection();
    }

    @Override // o0.e
    public /* synthetic */ float h0(long j11) {
        return o0.d.d(this, j11);
    }

    public final long i() {
        return this.f4241a.i();
    }

    public final h n() {
        return this.f4242b;
    }

    public final h v(Function1 function1) {
        h hVar = new h(function1);
        this.f4242b = hVar;
        return hVar;
    }

    @Override // o0.e
    public /* synthetic */ float x0(int i11) {
        return o0.d.c(this, i11);
    }

    @Override // o0.e
    public /* synthetic */ float y0(float f11) {
        return o0.d.b(this, f11);
    }

    public final void z(a aVar) {
        this.f4241a = aVar;
    }
}

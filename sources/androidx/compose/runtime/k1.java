package androidx.compose.runtime;

/* loaded from: classes.dex */
public final class k1 implements f {

    /* renamed from: a, reason: collision with root package name */
    private final f f3872a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3873b;

    /* renamed from: c, reason: collision with root package name */
    private int f3874c;

    public k1(f fVar, int i11) {
        this.f3872a = fVar;
        this.f3873b = i11;
    }

    @Override // androidx.compose.runtime.f
    public void clear() {
        k.r("Clear is not valid on OffsetApplier");
    }

    @Override // androidx.compose.runtime.f
    public Object d() {
        return this.f3872a.d();
    }

    @Override // androidx.compose.runtime.f
    public void e(int i11, int i12) {
        this.f3872a.e(i11 + (this.f3874c == 0 ? this.f3873b : 0), i12);
    }

    @Override // androidx.compose.runtime.f
    public void f(int i11, int i12, int i13) {
        int i14 = this.f3874c == 0 ? this.f3873b : 0;
        this.f3872a.f(i11 + i14, i12 + i14, i13);
    }

    @Override // androidx.compose.runtime.f
    public void g(int i11, Object obj) {
        this.f3872a.g(i11 + (this.f3874c == 0 ? this.f3873b : 0), obj);
    }

    @Override // androidx.compose.runtime.f
    public /* synthetic */ void h() {
        e.b(this);
    }

    @Override // androidx.compose.runtime.f
    public void i(int i11, Object obj) {
        this.f3872a.i(i11 + (this.f3874c == 0 ? this.f3873b : 0), obj);
    }

    @Override // androidx.compose.runtime.f
    public void j(Object obj) {
        this.f3874c++;
        this.f3872a.j(obj);
    }

    @Override // androidx.compose.runtime.f
    public /* synthetic */ void k() {
        e.a(this);
    }

    @Override // androidx.compose.runtime.f
    public void l() {
        if (!(this.f3874c > 0)) {
            k.r("OffsetApplier up called with no corresponding down");
        }
        this.f3874c--;
        this.f3872a.l();
    }
}

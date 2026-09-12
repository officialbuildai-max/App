package androidx.compose.ui.platform;

import java.util.List;

/* loaded from: classes.dex */
public final class b2 implements androidx.compose.ui.node.z0 {

    /* renamed from: a, reason: collision with root package name */
    private final int f5813a;

    /* renamed from: b, reason: collision with root package name */
    private final List f5814b;

    /* renamed from: c, reason: collision with root package name */
    private Float f5815c;

    /* renamed from: d, reason: collision with root package name */
    private Float f5816d;

    /* renamed from: e, reason: collision with root package name */
    private androidx.compose.ui.semantics.g f5817e;

    /* renamed from: f, reason: collision with root package name */
    private androidx.compose.ui.semantics.g f5818f;

    public b2(int i11, List list, Float f11, Float f12, androidx.compose.ui.semantics.g gVar, androidx.compose.ui.semantics.g gVar2) {
        this.f5813a = i11;
        this.f5814b = list;
        this.f5815c = f11;
        this.f5816d = f12;
        this.f5817e = gVar;
        this.f5818f = gVar2;
    }

    public final androidx.compose.ui.semantics.g a() {
        return this.f5817e;
    }

    public final Float b() {
        return this.f5815c;
    }

    public final Float c() {
        return this.f5816d;
    }

    public final int d() {
        return this.f5813a;
    }

    public final androidx.compose.ui.semantics.g e() {
        return this.f5818f;
    }

    public final void f(androidx.compose.ui.semantics.g gVar) {
        this.f5817e = gVar;
    }

    public final void g(Float f11) {
        this.f5815c = f11;
    }

    public final void h(Float f11) {
        this.f5816d = f11;
    }

    public final void i(androidx.compose.ui.semantics.g gVar) {
        this.f5818f = gVar;
    }

    @Override // androidx.compose.ui.node.z0
    public boolean isValidOwnerScope() {
        return this.f5814b.contains(this);
    }
}

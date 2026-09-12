package q4;

import java.util.List;

/* loaded from: classes2.dex */
public class i implements o {

    /* renamed from: a, reason: collision with root package name */
    private final b f73211a;

    /* renamed from: b, reason: collision with root package name */
    private final b f73212b;

    public i(b bVar, b bVar2) {
        this.f73211a = bVar;
        this.f73212b = bVar2;
    }

    @Override // q4.o
    public n4.a a() {
        return new n4.n(this.f73211a.a(), this.f73212b.a());
    }

    @Override // q4.o
    public List b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // q4.o
    public boolean c() {
        return this.f73211a.c() && this.f73212b.c();
    }
}

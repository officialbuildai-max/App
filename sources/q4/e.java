package q4;

import java.util.List;

/* loaded from: classes2.dex */
public class e implements o {

    /* renamed from: a, reason: collision with root package name */
    private final List f73210a;

    public e(List list) {
        this.f73210a = list;
    }

    @Override // q4.o
    public n4.a a() {
        return ((w4.a) this.f73210a.get(0)).i() ? new n4.k(this.f73210a) : new n4.j(this.f73210a);
    }

    @Override // q4.o
    public List b() {
        return this.f73210a;
    }

    @Override // q4.o
    public boolean c() {
        return this.f73210a.size() == 1 && ((w4.a) this.f73210a.get(0)).i();
    }
}

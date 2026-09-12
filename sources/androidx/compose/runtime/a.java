package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class a implements f {

    /* renamed from: a, reason: collision with root package name */
    private final Object f3744a;

    /* renamed from: b, reason: collision with root package name */
    private final List f3745b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private Object f3746c;

    public a(Object obj) {
        this.f3744a = obj;
        this.f3746c = obj;
    }

    public final Object a() {
        return this.f3744a;
    }

    protected abstract void b();

    protected void c(Object obj) {
        this.f3746c = obj;
    }

    @Override // androidx.compose.runtime.f
    public final void clear() {
        this.f3745b.clear();
        c(this.f3744a);
        b();
    }

    @Override // androidx.compose.runtime.f
    public Object d() {
        return this.f3746c;
    }

    @Override // androidx.compose.runtime.f
    public /* synthetic */ void h() {
        e.b(this);
    }

    @Override // androidx.compose.runtime.f
    public void j(Object obj) {
        this.f3745b.add(d());
        c(obj);
    }

    @Override // androidx.compose.runtime.f
    public /* synthetic */ void k() {
        e.a(this);
    }

    @Override // androidx.compose.runtime.f
    public void l() {
        if (this.f3745b.isEmpty()) {
            o1.b("empty stack");
        }
        c(this.f3745b.remove(r0.size() - 1));
    }
}

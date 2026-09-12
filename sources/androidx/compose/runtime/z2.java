package androidx.compose.runtime;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class z2 {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f4157a = new ArrayList();

    public final void a() {
        this.f4157a.clear();
    }

    public final int b() {
        return this.f4157a.size();
    }

    public final boolean c() {
        return this.f4157a.isEmpty();
    }

    public final boolean d() {
        return !c();
    }

    public final Object e() {
        return this.f4157a.get(b() - 1);
    }

    public final Object f(int i11) {
        return this.f4157a.get(i11);
    }

    public final Object g() {
        return this.f4157a.remove(b() - 1);
    }

    public final boolean h(Object obj) {
        return this.f4157a.add(obj);
    }

    public final Object[] i() {
        int size = this.f4157a.size();
        Object[] objArr = new Object[size];
        for (int i11 = 0; i11 < size; i11++) {
            objArr[i11] = this.f4157a.get(i11);
        }
        return objArr;
    }
}

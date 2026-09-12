package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes7.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f67989a = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_cur$volatile");
    private volatile /* synthetic */ Object _cur$volatile;

    public l(boolean z10) {
        this._cur$volatile = new m(8, z10);
    }

    public final boolean a(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f67989a;
        while (true) {
            m mVar = (m) atomicReferenceFieldUpdater.get(this);
            int a11 = mVar.a(obj);
            if (a11 == 0) {
                return true;
            }
            if (a11 == 1) {
                androidx.concurrent.futures.a.a(f67989a, this, mVar, mVar.l());
            } else if (a11 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f67989a;
        while (true) {
            m mVar = (m) atomicReferenceFieldUpdater.get(this);
            if (mVar.d()) {
                return;
            } else {
                androidx.concurrent.futures.a.a(f67989a, this, mVar, mVar.l());
            }
        }
    }

    public final int c() {
        return ((m) f67989a.get(this)).g();
    }

    public final Object e() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f67989a;
        while (true) {
            m mVar = (m) atomicReferenceFieldUpdater.get(this);
            Object m11 = mVar.m();
            if (m11 != m.f67993h) {
                return m11;
            }
            androidx.concurrent.futures.a.a(f67989a, this, mVar, mVar.l());
        }
    }
}

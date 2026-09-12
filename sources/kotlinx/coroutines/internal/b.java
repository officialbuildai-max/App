package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f67971a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_next$volatile");

    /* renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f67972b = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_prev$volatile");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    public b(b bVar) {
        this._prev$volatile = bVar;
    }

    private final b d() {
        b h11 = h();
        while (h11 != null && h11.k()) {
            h11 = (b) f67972b.get(h11);
        }
        return h11;
    }

    private final b e() {
        b f11;
        b f12 = f();
        Intrinsics.e(f12);
        while (f12.k() && (f11 = f12.f()) != null) {
            f12 = f11;
        }
        return f12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object g() {
        return f67971a.get(this);
    }

    public final void c() {
        f67972b.set(this, null);
    }

    public final b f() {
        Object g11 = g();
        if (g11 == a.a()) {
            return null;
        }
        return (b) g11;
    }

    public final b h() {
        return (b) f67972b.get(this);
    }

    public abstract boolean k();

    public final boolean l() {
        return f() == null;
    }

    public final boolean m() {
        return androidx.concurrent.futures.a.a(f67971a, this, null, a.a());
    }

    public final void n() {
        Object obj;
        if (l()) {
            return;
        }
        while (true) {
            b d11 = d();
            b e11 = e();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f67972b;
            do {
                obj = atomicReferenceFieldUpdater.get(e11);
            } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, e11, obj, ((b) obj) == null ? null : d11));
            if (d11 != null) {
                f67971a.set(d11, e11);
            }
            if (!e11.k() || e11.l()) {
                if (d11 == null || !d11.k()) {
                    return;
                }
            }
        }
    }

    public final boolean o(b bVar) {
        return androidx.concurrent.futures.a.a(f67971a, this, null, bVar);
    }
}

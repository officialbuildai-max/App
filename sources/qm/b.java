package qm;

import android.os.Looper;
import androidx.view.b0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.t1;
import lg.a;

/* loaded from: classes6.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private final String f73762a = getClass().getSimpleName();

    /* renamed from: b, reason: collision with root package name */
    private volatile Object f73763b;

    /* renamed from: c, reason: collision with root package name */
    private volatile b0 f73764c;

    /* renamed from: d, reason: collision with root package name */
    private volatile io.reactivex.rxjava3.disposables.c f73765d;

    /* renamed from: e, reason: collision with root package name */
    private volatile t1 f73766e;

    private final boolean e(b0 b0Var) {
        if (this.f73763b == null) {
            this.f73764c = b0Var;
            return true;
        }
        if (b0Var == null) {
            return false;
        }
        a.C0856a c0856a = lg.a.f68962a;
        String TAG = this.f73762a;
        Intrinsics.g(TAG, "TAG");
        a.C0856a.f(c0856a, TAG, "load data from preload", false, 4, null);
        b0Var.q(this.f73763b);
        this.f73763b = null;
        return false;
    }

    public static /* synthetic */ void g(b bVar, b0 b0Var, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadData");
        }
        if ((i11 & 1) != 0) {
            b0Var = null;
        }
        bVar.f(b0Var);
    }

    public final synchronized Object a() {
        Object obj;
        obj = this.f73763b;
        this.f73763b = null;
        return obj;
    }

    public final String b() {
        return this.f73762a;
    }

    public final void c(Object obj) {
        if (this.f73764c == null) {
            a.C0856a c0856a = lg.a.f68962a;
            String TAG = this.f73762a;
            Intrinsics.g(TAG, "TAG");
            a.C0856a.f(c0856a, TAG, "load data handleFailureResult :", false, 4, null);
        } else {
            a.C0856a c0856a2 = lg.a.f68962a;
            String TAG2 = this.f73762a;
            Intrinsics.g(TAG2, "TAG");
            a.C0856a.f(c0856a2, TAG2, "load data handleFailureResult : return to ui", false, 4, null);
            if (Intrinsics.c(Thread.currentThread(), Looper.getMainLooper().getThread())) {
                b0 b0Var = this.f73764c;
                if (b0Var != null) {
                    b0Var.q(obj);
                }
            } else {
                b0 b0Var2 = this.f73764c;
                if (b0Var2 != null) {
                    b0Var2.n(obj);
                }
            }
        }
        io.reactivex.rxjava3.disposables.c cVar = this.f73765d;
        if (cVar != null) {
            d.a(cVar);
        }
    }

    public final void d(Object obj) {
        if (this.f73764c == null) {
            this.f73763b = obj;
            a.C0856a c0856a = lg.a.f68962a;
            String TAG = this.f73762a;
            Intrinsics.g(TAG, "TAG");
            a.C0856a.f(c0856a, TAG, "load data handleSuccessResult : cache data", false, 4, null);
        } else {
            a.C0856a c0856a2 = lg.a.f68962a;
            String TAG2 = this.f73762a;
            Intrinsics.g(TAG2, "TAG");
            a.C0856a.f(c0856a2, TAG2, "load data handleSuccessResult : return to ui", false, 4, null);
            if (Intrinsics.c(Thread.currentThread(), Looper.getMainLooper().getThread())) {
                b0 b0Var = this.f73764c;
                if (b0Var != null) {
                    b0Var.q(obj);
                }
            } else {
                b0 b0Var2 = this.f73764c;
                if (b0Var2 != null) {
                    b0Var2.n(obj);
                }
            }
        }
        io.reactivex.rxjava3.disposables.c cVar = this.f73765d;
        if (cVar != null) {
            d.a(cVar);
        }
    }

    public final void f(b0 b0Var) {
        t1 t1Var;
        if (e(b0Var)) {
            a.C0856a c0856a = lg.a.f68962a;
            String TAG = this.f73762a;
            Intrinsics.g(TAG, "TAG");
            a.C0856a.f(c0856a, TAG, "loadData  disposable:" + this.f73765d + "  this:" + this, false, 4, null);
            io.reactivex.rxjava3.disposables.c cVar = this.f73765d;
            if ((cVar != null && !cVar.isDisposed()) || ((t1Var = this.f73766e) != null && t1Var.isActive())) {
                String TAG2 = this.f73762a;
                Intrinsics.g(TAG2, "TAG");
                a.C0856a.f(c0856a, TAG2, "load data ing .. wait", false, 4, null);
            } else {
                String TAG3 = this.f73762a;
                Intrinsics.g(TAG3, "TAG");
                a.C0856a.f(c0856a, TAG3, "loadDataFromService", false, 4, null);
                h(b0Var);
            }
        }
    }

    public abstract void h(b0 b0Var);

    public final void i(io.reactivex.rxjava3.disposables.c cVar) {
        this.f73765d = cVar;
    }

    public final void j(t1 t1Var) {
        this.f73766e = t1Var;
    }
}

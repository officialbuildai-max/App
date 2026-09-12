package androidx.slidingpanelayout.widget;

import android.app.Activity;
import androidx.window.layout.a0;
import androidx.window.layout.l;
import androidx.window.layout.r;
import androidx.window.layout.x;
import java.util.Iterator;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m1;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;

/* loaded from: classes2.dex */
public final class FoldingFeatureObserver {

    /* renamed from: a, reason: collision with root package name */
    private final x f14920a;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f14921b;

    /* renamed from: c, reason: collision with root package name */
    private t1 f14922c;

    /* renamed from: d, reason: collision with root package name */
    private a f14923d;

    /* loaded from: classes2.dex */
    public interface a {
        void a(r rVar);
    }

    public FoldingFeatureObserver(x windowInfoTracker, Executor executor) {
        Intrinsics.h(windowInfoTracker, "windowInfoTracker");
        Intrinsics.h(executor, "executor");
        this.f14920a = windowInfoTracker;
        this.f14921b = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final r d(a0 a0Var) {
        Object obj;
        Iterator it = a0Var.a().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((l) obj) instanceof r) {
                break;
            }
        }
        if (obj instanceof r) {
            return (r) obj;
        }
        return null;
    }

    public final void e(Activity activity) {
        t1 d11;
        Intrinsics.h(activity, "activity");
        t1 t1Var = this.f14922c;
        if (t1Var != null) {
            t1.a.b(t1Var, null, 1, null);
        }
        d11 = k.d(o0.a(m1.b(this.f14921b)), null, null, new FoldingFeatureObserver$registerLayoutStateChangeCallback$1(this, activity, null), 3, null);
        this.f14922c = d11;
    }

    public final void f(a onFoldingFeatureChangeListener) {
        Intrinsics.h(onFoldingFeatureChangeListener, "onFoldingFeatureChangeListener");
        this.f14923d = onFoldingFeatureChangeListener;
    }

    public final void g() {
        t1 t1Var = this.f14922c;
        if (t1Var == null) {
            return;
        }
        t1.a.b(t1Var, null, 1, null);
    }
}

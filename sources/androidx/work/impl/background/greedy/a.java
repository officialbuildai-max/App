package androidx.work.impl.background.greedy;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.WorkInfo;
import androidx.work.d;
import androidx.work.d0;
import androidx.work.impl.a0;
import androidx.work.impl.b1;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.constraints.b;
import androidx.work.impl.constraints.h;
import androidx.work.impl.e;
import androidx.work.impl.model.j0;
import androidx.work.impl.model.s1;
import androidx.work.impl.model.x;
import androidx.work.impl.s;
import androidx.work.impl.u;
import androidx.work.impl.y;
import androidx.work.impl.z;
import androidx.work.t;
import i4.n;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlinx.coroutines.t1;

/* loaded from: classes2.dex */
public class a implements u, h, e {

    /* renamed from: o, reason: collision with root package name */
    private static final String f15630o = t.i("GreedyScheduler");

    /* renamed from: a, reason: collision with root package name */
    private final Context f15631a;

    /* renamed from: c, reason: collision with root package name */
    private DelayedWorkTracker f15633c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f15634d;

    /* renamed from: g, reason: collision with root package name */
    private final s f15637g;

    /* renamed from: h, reason: collision with root package name */
    private final b1 f15638h;

    /* renamed from: i, reason: collision with root package name */
    private final androidx.work.b f15639i;

    /* renamed from: k, reason: collision with root package name */
    Boolean f15641k;

    /* renamed from: l, reason: collision with root package name */
    private final WorkConstraintsTracker f15642l;

    /* renamed from: m, reason: collision with root package name */
    private final j4.c f15643m;

    /* renamed from: n, reason: collision with root package name */
    private final c f15644n;

    /* renamed from: b, reason: collision with root package name */
    private final Map f15632b = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private final Object f15635e = new Object();

    /* renamed from: f, reason: collision with root package name */
    private final a0 f15636f = z.b();

    /* renamed from: j, reason: collision with root package name */
    private final Map f15640j = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        final int f15645a;

        /* renamed from: b, reason: collision with root package name */
        final long f15646b;

        private b(int i11, long j11) {
            this.f15645a = i11;
            this.f15646b = j11;
        }
    }

    public a(Context context, androidx.work.b bVar, n nVar, s sVar, b1 b1Var, j4.c cVar) {
        this.f15631a = context;
        d0 k11 = bVar.k();
        this.f15633c = new DelayedWorkTracker(this, k11, bVar.a());
        this.f15644n = new c(k11, b1Var);
        this.f15643m = cVar;
        this.f15642l = new WorkConstraintsTracker(nVar);
        this.f15639i = bVar;
        this.f15637g = sVar;
        this.f15638h = b1Var;
    }

    private void f() {
        this.f15641k = Boolean.valueOf(androidx.work.impl.utils.a0.b(this.f15631a, this.f15639i));
    }

    private void g() {
        if (this.f15634d) {
            return;
        }
        this.f15637g.e(this);
        this.f15634d = true;
    }

    private void h(x xVar) {
        t1 t1Var;
        synchronized (this.f15635e) {
            t1Var = (t1) this.f15632b.remove(xVar);
        }
        if (t1Var != null) {
            t.e().a(f15630o, "Stopping tracking for " + xVar);
            t1Var.cancel(null);
        }
    }

    private long i(j0 j0Var) {
        long max;
        synchronized (this.f15635e) {
            try {
                x a11 = s1.a(j0Var);
                b bVar = (b) this.f15640j.get(a11);
                if (bVar == null) {
                    bVar = new b(j0Var.f15856k, this.f15639i.a().currentTimeMillis());
                    this.f15640j.put(a11, bVar);
                }
                max = bVar.f15646b + (Math.max((j0Var.f15856k - bVar.f15645a) - 5, 0) * 30000);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return max;
    }

    @Override // androidx.work.impl.u
    public void a(String str) {
        if (this.f15641k == null) {
            f();
        }
        if (!this.f15641k.booleanValue()) {
            t.e().f(f15630o, "Ignoring schedule request in non-main process");
            return;
        }
        g();
        t.e().a(f15630o, "Cancelling work ID " + str);
        DelayedWorkTracker delayedWorkTracker = this.f15633c;
        if (delayedWorkTracker != null) {
            delayedWorkTracker.b(str);
        }
        for (y yVar : this.f15636f.remove(str)) {
            this.f15644n.b(yVar);
            this.f15638h.e(yVar);
        }
    }

    @Override // androidx.work.impl.u
    public void b(j0... j0VarArr) {
        if (this.f15641k == null) {
            f();
        }
        if (!this.f15641k.booleanValue()) {
            t.e().f(f15630o, "Ignoring schedule request in a secondary process");
            return;
        }
        g();
        HashSet<j0> hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (j0 j0Var : j0VarArr) {
            if (!this.f15636f.a(s1.a(j0Var))) {
                long max = Math.max(j0Var.c(), i(j0Var));
                long currentTimeMillis = this.f15639i.a().currentTimeMillis();
                if (j0Var.f15847b == WorkInfo.State.ENQUEUED) {
                    if (currentTimeMillis < max) {
                        DelayedWorkTracker delayedWorkTracker = this.f15633c;
                        if (delayedWorkTracker != null) {
                            delayedWorkTracker.a(j0Var, max);
                        }
                    } else if (j0Var.m()) {
                        d dVar = j0Var.f15855j;
                        if (dVar.j()) {
                            t.e().a(f15630o, "Ignoring " + j0Var + ". Requires device idle.");
                        } else if (Build.VERSION.SDK_INT < 24 || !dVar.g()) {
                            hashSet.add(j0Var);
                            hashSet2.add(j0Var.f15846a);
                        } else {
                            t.e().a(f15630o, "Ignoring " + j0Var + ". Requires ContentUri triggers.");
                        }
                    } else if (!this.f15636f.a(s1.a(j0Var))) {
                        t.e().a(f15630o, "Starting work for " + j0Var.f15846a);
                        y c11 = this.f15636f.c(j0Var);
                        this.f15644n.c(c11);
                        this.f15638h.c(c11);
                    }
                }
            }
        }
        synchronized (this.f15635e) {
            try {
                if (!hashSet.isEmpty()) {
                    t.e().a(f15630o, "Starting tracking for " + TextUtils.join(",", hashSet2));
                    for (j0 j0Var2 : hashSet) {
                        x a11 = s1.a(j0Var2);
                        if (!this.f15632b.containsKey(a11)) {
                            this.f15632b.put(a11, WorkConstraintsTrackerKt.e(this.f15642l, j0Var2, this.f15643m.b(), this));
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.work.impl.e
    public void c(x xVar, boolean z10) {
        y b11 = this.f15636f.b(xVar);
        if (b11 != null) {
            this.f15644n.b(b11);
        }
        h(xVar);
        if (z10) {
            return;
        }
        synchronized (this.f15635e) {
            this.f15640j.remove(xVar);
        }
    }

    @Override // androidx.work.impl.u
    public boolean d() {
        return false;
    }

    @Override // androidx.work.impl.constraints.h
    public void e(j0 j0Var, androidx.work.impl.constraints.b bVar) {
        x a11 = s1.a(j0Var);
        if (bVar instanceof b.a) {
            if (this.f15636f.a(a11)) {
                return;
            }
            t.e().a(f15630o, "Constraints met: Scheduling work ID " + a11);
            y d11 = this.f15636f.d(a11);
            this.f15644n.c(d11);
            this.f15638h.c(d11);
            return;
        }
        t.e().a(f15630o, "Constraints not met: Cancelling work ID " + a11);
        y b11 = this.f15636f.b(a11);
        if (b11 != null) {
            this.f15644n.b(b11);
            this.f15638h.b(b11, ((b.C0142b) bVar).a());
        }
    }
}

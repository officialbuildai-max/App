package androidx.work.impl.background.greedy;

import androidx.work.d0;
import androidx.work.impl.model.j0;
import androidx.work.impl.u;
import androidx.work.t;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class DelayedWorkTracker {

    /* renamed from: e, reason: collision with root package name */
    static final String f15625e = t.i("DelayedWorkTracker");

    /* renamed from: a, reason: collision with root package name */
    final u f15626a;

    /* renamed from: b, reason: collision with root package name */
    private final d0 f15627b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.work.a f15628c;

    /* renamed from: d, reason: collision with root package name */
    private final Map f15629d = new HashMap();

    public DelayedWorkTracker(u uVar, d0 d0Var, androidx.work.a aVar) {
        this.f15626a = uVar;
        this.f15627b = d0Var;
        this.f15628c = aVar;
    }

    public void a(final j0 j0Var, long j11) {
        Runnable runnable = (Runnable) this.f15629d.remove(j0Var.f15846a);
        if (runnable != null) {
            this.f15627b.a(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: androidx.work.impl.background.greedy.DelayedWorkTracker.1
            @Override // java.lang.Runnable
            public void run() {
                t.e().a(DelayedWorkTracker.f15625e, "Scheduling work " + j0Var.f15846a);
                DelayedWorkTracker.this.f15626a.b(j0Var);
            }
        };
        this.f15629d.put(j0Var.f15846a, runnable2);
        this.f15627b.b(j11 - this.f15628c.currentTimeMillis(), runnable2);
    }

    public void b(String str) {
        Runnable runnable = (Runnable) this.f15629d.remove(str);
        if (runnable != null) {
            this.f15627b.a(runnable);
        }
    }
}

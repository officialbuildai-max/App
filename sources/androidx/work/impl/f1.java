package androidx.work.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import androidx.view.LiveData;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.b;
import androidx.work.impl.model.j0;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.LiveDataUtils;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.t;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes2.dex */
public class f1 extends WorkManager {

    /* renamed from: m, reason: collision with root package name */
    private static final String f15733m = androidx.work.t.i("WorkManagerImpl");

    /* renamed from: n, reason: collision with root package name */
    private static f1 f15734n = null;

    /* renamed from: o, reason: collision with root package name */
    private static f1 f15735o = null;

    /* renamed from: p, reason: collision with root package name */
    private static final Object f15736p = new Object();

    /* renamed from: b, reason: collision with root package name */
    private Context f15737b;

    /* renamed from: c, reason: collision with root package name */
    private androidx.work.b f15738c;

    /* renamed from: d, reason: collision with root package name */
    private WorkDatabase f15739d;

    /* renamed from: e, reason: collision with root package name */
    private j4.c f15740e;

    /* renamed from: f, reason: collision with root package name */
    private List f15741f;

    /* renamed from: g, reason: collision with root package name */
    private s f15742g;

    /* renamed from: h, reason: collision with root package name */
    private androidx.work.impl.utils.z f15743h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f15744i = false;

    /* renamed from: j, reason: collision with root package name */
    private BroadcastReceiver.PendingResult f15745j;

    /* renamed from: k, reason: collision with root package name */
    private final i4.n f15746k;

    /* renamed from: l, reason: collision with root package name */
    private final kotlinx.coroutines.n0 f15747l;

    /* loaded from: classes2.dex */
    class a implements l.a {
        a() {
        }

        @Override // l.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WorkInfo apply(List list) {
            if (list == null || list.size() <= 0) {
                return null;
            }
            return ((j0.c) list.get(0)).e();
        }
    }

    /* loaded from: classes2.dex */
    static class b {
        static boolean a(Context context) {
            boolean isDeviceProtectedStorage;
            isDeviceProtectedStorage = context.isDeviceProtectedStorage();
            return isDeviceProtectedStorage;
        }
    }

    public f1(Context context, androidx.work.b bVar, j4.c cVar, WorkDatabase workDatabase, List list, s sVar, i4.n nVar) {
        Context applicationContext = context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 24 && b.a(applicationContext)) {
            throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
        }
        androidx.work.t.h(new t.a(bVar.j()));
        this.f15737b = applicationContext;
        this.f15740e = cVar;
        this.f15739d = workDatabase;
        this.f15742g = sVar;
        this.f15746k = nVar;
        this.f15738c = bVar;
        this.f15741f = list;
        kotlinx.coroutines.n0 f11 = WorkManagerImplExtKt.f(cVar);
        this.f15747l = f11;
        this.f15743h = new androidx.work.impl.utils.z(this.f15739d);
        x.g(list, this.f15742g, cVar.c(), this.f15739d, bVar);
        this.f15740e.d(new ForceStopRunnable(applicationContext, this));
        UnfinishedWorkListenerKt.c(f11, this.f15737b, bVar, workDatabase);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0018, code lost:
    
        r3 = r3.getApplicationContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
    
        if (androidx.work.impl.f1.f15735o != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0020, code lost:
    
        androidx.work.impl.f1.f15735o = androidx.work.impl.WorkManagerImplExtKt.c(r3, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
    
        androidx.work.impl.f1.f15734n = androidx.work.impl.f1.f15735o;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void h(android.content.Context r3, androidx.work.b r4) {
        /*
            java.lang.Object r0 = androidx.work.impl.f1.f15736p
            monitor-enter(r0)
            androidx.work.impl.f1 r1 = androidx.work.impl.f1.f15734n     // Catch: java.lang.Throwable -> L14
            if (r1 == 0) goto L16
            androidx.work.impl.f1 r2 = androidx.work.impl.f1.f15735o     // Catch: java.lang.Throwable -> L14
            if (r2 != 0) goto Lc
            goto L16
        Lc:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L14
            java.lang.String r4 = "WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information."
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L14
            throw r3     // Catch: java.lang.Throwable -> L14
        L14:
            r3 = move-exception
            goto L2c
        L16:
            if (r1 != 0) goto L2a
            android.content.Context r3 = r3.getApplicationContext()     // Catch: java.lang.Throwable -> L14
            androidx.work.impl.f1 r1 = androidx.work.impl.f1.f15735o     // Catch: java.lang.Throwable -> L14
            if (r1 != 0) goto L26
            androidx.work.impl.f1 r3 = androidx.work.impl.WorkManagerImplExtKt.c(r3, r4)     // Catch: java.lang.Throwable -> L14
            androidx.work.impl.f1.f15735o = r3     // Catch: java.lang.Throwable -> L14
        L26:
            androidx.work.impl.f1 r3 = androidx.work.impl.f1.f15735o     // Catch: java.lang.Throwable -> L14
            androidx.work.impl.f1.f15734n = r3     // Catch: java.lang.Throwable -> L14
        L2a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            return
        L2c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.f1.h(android.content.Context, androidx.work.b):void");
    }

    public static f1 n() {
        synchronized (f15736p) {
            try {
                f1 f1Var = f15734n;
                if (f1Var != null) {
                    return f1Var;
                }
                return f15735o;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static f1 o(Context context) {
        f1 n11;
        synchronized (f15736p) {
            try {
                n11 = n();
                if (n11 == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (!(applicationContext instanceof b.c)) {
                        throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                    }
                    h(applicationContext, ((b.c) applicationContext).getWorkManagerConfiguration());
                    n11 = o(applicationContext);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return n11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit v() {
        h4.q.c(l());
        t().l0().n();
        x.h(m(), t(), r());
        return Unit.f67184a;
    }

    @Override // androidx.work.WorkManager
    public androidx.work.h0 b(String str, ExistingWorkPolicy existingWorkPolicy, List list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("beginUniqueWork needs at least one OneTimeWorkRequest.");
        }
        return new e0(this, str, existingWorkPolicy, list);
    }

    @Override // androidx.work.WorkManager
    public androidx.work.w d(List list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
        }
        return new e0(this, list).a();
    }

    @Override // androidx.work.WorkManager
    public androidx.work.w e(String str, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, androidx.work.b0 b0Var) {
        return existingPeriodicWorkPolicy == ExistingPeriodicWorkPolicy.UPDATE ? m1.e(this, str, b0Var) : k(str, existingPeriodicWorkPolicy, b0Var).a();
    }

    @Override // androidx.work.WorkManager
    public LiveData g(UUID uuid) {
        return LiveDataUtils.a(this.f15739d.l0().y(Collections.singletonList(uuid.toString())), new a(), this.f15740e);
    }

    public androidx.work.w j(UUID uuid) {
        return androidx.work.impl.utils.e.e(uuid, this);
    }

    public e0 k(String str, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, androidx.work.b0 b0Var) {
        return new e0(this, str, existingPeriodicWorkPolicy == ExistingPeriodicWorkPolicy.KEEP ? ExistingWorkPolicy.KEEP : ExistingWorkPolicy.REPLACE, Collections.singletonList(b0Var));
    }

    public Context l() {
        return this.f15737b;
    }

    public androidx.work.b m() {
        return this.f15738c;
    }

    public androidx.work.impl.utils.z p() {
        return this.f15743h;
    }

    public s q() {
        return this.f15742g;
    }

    public List r() {
        return this.f15741f;
    }

    public i4.n s() {
        return this.f15746k;
    }

    public WorkDatabase t() {
        return this.f15739d;
    }

    public j4.c u() {
        return this.f15740e;
    }

    public void w() {
        synchronized (f15736p) {
            try {
                this.f15744i = true;
                BroadcastReceiver.PendingResult pendingResult = this.f15745j;
                if (pendingResult != null) {
                    pendingResult.finish();
                    this.f15745j = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void x() {
        androidx.work.g0.a(m().n(), "ReschedulingWork", new Function0() { // from class: androidx.work.impl.e1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit v11;
                v11 = f1.this.v();
                return v11;
            }
        });
    }

    public void y(BroadcastReceiver.PendingResult pendingResult) {
        synchronized (f15736p) {
            try {
                BroadcastReceiver.PendingResult pendingResult2 = this.f15745j;
                if (pendingResult2 != null) {
                    pendingResult2.finish();
                }
                this.f15745j = pendingResult;
                if (this.f15744i) {
                    pendingResult.finish();
                    this.f15745j = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void z(androidx.work.impl.model.x xVar, int i11) {
        this.f15740e.d(new StopWorkRunnable(this.f15742g, new y(xVar), true, i11));
    }
}

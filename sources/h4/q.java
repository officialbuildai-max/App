package h4;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.model.j0;
import androidx.work.impl.model.k0;
import androidx.work.impl.model.s1;
import androidx.work.impl.model.w;
import androidx.work.impl.model.x;
import androidx.work.impl.u;
import androidx.work.t;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class q implements u {

    /* renamed from: f, reason: collision with root package name */
    private static final String f64488f = t.i("SystemJobScheduler");

    /* renamed from: a, reason: collision with root package name */
    private final Context f64489a;

    /* renamed from: b, reason: collision with root package name */
    private final JobScheduler f64490b;

    /* renamed from: c, reason: collision with root package name */
    private final o f64491c;

    /* renamed from: d, reason: collision with root package name */
    private final WorkDatabase f64492d;

    /* renamed from: e, reason: collision with root package name */
    private final androidx.work.b f64493e;

    public q(Context context, WorkDatabase workDatabase, androidx.work.b bVar) {
        this(context, workDatabase, bVar, d.c(context), new o(context, bVar.a(), bVar.s()));
    }

    public q(Context context, WorkDatabase workDatabase, androidx.work.b bVar, JobScheduler jobScheduler, o oVar) {
        this.f64489a = context;
        this.f64490b = jobScheduler;
        this.f64491c = oVar;
        this.f64492d = workDatabase;
        this.f64493e = bVar;
    }

    public static void c(Context context) {
        if (Build.VERSION.SDK_INT >= 34) {
            d.c(context).cancelAll();
        }
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        List g11 = g(context, jobScheduler);
        if (g11 == null || g11.isEmpty()) {
            return;
        }
        Iterator it = g11.iterator();
        while (it.hasNext()) {
            e(jobScheduler, ((JobInfo) it.next()).getId());
        }
    }

    private static void e(JobScheduler jobScheduler, int i11) {
        try {
            jobScheduler.cancel(i11);
        } catch (Throwable th2) {
            t.e().d(f64488f, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i11)), th2);
        }
    }

    private static List f(Context context, JobScheduler jobScheduler, String str) {
        List<JobInfo> g11 = g(context, jobScheduler);
        if (g11 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo jobInfo : g11) {
            x h11 = h(jobInfo);
            if (h11 != null && str.equals(h11.b())) {
                arrayList.add(Integer.valueOf(jobInfo.getId()));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List g(Context context, JobScheduler jobScheduler) {
        List<JobInfo> b11 = d.b(jobScheduler);
        if (b11 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(b11.size());
        ComponentName componentName = new ComponentName(context, (Class<?>) SystemJobService.class);
        for (JobInfo jobInfo : b11) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    private static x h(JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (!extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new x(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION", 0));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public static boolean i(Context context, WorkDatabase workDatabase) {
        JobScheduler c11 = d.c(context);
        List<JobInfo> g11 = g(context, c11);
        List c12 = workDatabase.i0().c();
        boolean z10 = false;
        HashSet hashSet = new HashSet(g11 != null ? g11.size() : 0);
        if (g11 != null && !g11.isEmpty()) {
            for (JobInfo jobInfo : g11) {
                x h11 = h(jobInfo);
                if (h11 != null) {
                    hashSet.add(h11.b());
                } else {
                    e(c11, jobInfo.getId());
                }
            }
        }
        Iterator it = c12.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (!hashSet.contains((String) it.next())) {
                t.e().a(f64488f, "Reconciling jobs");
                z10 = true;
                break;
            }
        }
        if (z10) {
            workDatabase.k();
            try {
                k0 l02 = workDatabase.l0();
                Iterator it2 = c12.iterator();
                while (it2.hasNext()) {
                    l02.o((String) it2.next(), -1L);
                }
                workDatabase.e0();
                workDatabase.t();
            } catch (Throwable th2) {
                workDatabase.t();
                throw th2;
            }
        }
        return z10;
    }

    @Override // androidx.work.impl.u
    public void a(String str) {
        List f11 = f(this.f64489a, this.f64490b, str);
        if (f11 == null || f11.isEmpty()) {
            return;
        }
        Iterator it = f11.iterator();
        while (it.hasNext()) {
            e(this.f64490b, ((Integer) it.next()).intValue());
        }
        this.f64492d.i0().e(str);
    }

    @Override // androidx.work.impl.u
    public void b(j0... j0VarArr) {
        List f11;
        androidx.work.impl.utils.m mVar = new androidx.work.impl.utils.m(this.f64492d);
        for (j0 j0Var : j0VarArr) {
            this.f64492d.k();
            try {
                j0 j11 = this.f64492d.l0().j(j0Var.f15846a);
                if (j11 == null) {
                    t.e().k(f64488f, "Skipping scheduling " + j0Var.f15846a + " because it's no longer in the DB");
                    this.f64492d.e0();
                } else if (j11.f15847b != WorkInfo.State.ENQUEUED) {
                    t.e().k(f64488f, "Skipping scheduling " + j0Var.f15846a + " because it is no longer enqueued");
                    this.f64492d.e0();
                } else {
                    x a11 = s1.a(j0Var);
                    androidx.work.impl.model.o a12 = this.f64492d.i0().a(a11);
                    int b11 = a12 != null ? a12.f15909c : mVar.b(this.f64493e.i(), this.f64493e.g());
                    if (a12 == null) {
                        this.f64492d.i0().d(w.a(a11, b11));
                    }
                    j(j0Var, b11);
                    if (Build.VERSION.SDK_INT == 23 && (f11 = f(this.f64489a, this.f64490b, j0Var.f15846a)) != null) {
                        int indexOf = f11.indexOf(Integer.valueOf(b11));
                        if (indexOf >= 0) {
                            f11.remove(indexOf);
                        }
                        j(j0Var, !f11.isEmpty() ? ((Integer) f11.get(0)).intValue() : mVar.b(this.f64493e.i(), this.f64493e.g()));
                    }
                    this.f64492d.e0();
                }
            } finally {
                this.f64492d.t();
            }
        }
    }

    @Override // androidx.work.impl.u
    public boolean d() {
        return true;
    }

    public void j(j0 j0Var, int i11) {
        JobInfo a11 = this.f64491c.a(j0Var, i11);
        t e11 = t.e();
        String str = f64488f;
        e11.a(str, "Scheduling work ID " + j0Var.f15846a + "Job ID " + i11);
        try {
            if (this.f64490b.schedule(a11) == 0) {
                t.e().k(str, "Unable to schedule work ID " + j0Var.f15846a);
                if (j0Var.f15862q && j0Var.f15863r == OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST) {
                    j0Var.f15862q = false;
                    t.e().a(str, String.format("Scheduling a non-expedited job (work ID %s)", j0Var.f15846a));
                    j(j0Var, i11);
                }
            }
        } catch (IllegalStateException e12) {
            String a12 = d.a(this.f64489a, this.f64492d, this.f64493e);
            t.e().c(f64488f, a12);
            IllegalStateException illegalStateException = new IllegalStateException(a12, e12);
            androidx.core.util.a l11 = this.f64493e.l();
            if (l11 == null) {
                throw illegalStateException;
            }
            l11.accept(illegalStateException);
        } catch (Throwable th2) {
            t.e().d(f64488f, "Unable to schedule " + j0Var, th2);
        }
    }
}

package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.net.Network;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.PersistableBundle;
import androidx.work.WorkerParameters;
import androidx.work.impl.a0;
import androidx.work.impl.b1;
import androidx.work.impl.d1;
import androidx.work.impl.e;
import androidx.work.impl.f1;
import androidx.work.impl.model.x;
import androidx.work.impl.s;
import androidx.work.impl.y;
import androidx.work.impl.z;
import androidx.work.t;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class SystemJobService extends JobService implements e {

    /* renamed from: e, reason: collision with root package name */
    private static final String f15655e = t.i("SystemJobService");

    /* renamed from: a, reason: collision with root package name */
    private f1 f15656a;

    /* renamed from: b, reason: collision with root package name */
    private final Map f15657b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final a0 f15658c = z.c(false);

    /* renamed from: d, reason: collision with root package name */
    private b1 f15659d;

    /* loaded from: classes2.dex */
    static class a {
        static String[] a(JobParameters jobParameters) {
            return jobParameters.getTriggeredContentAuthorities();
        }

        static Uri[] b(JobParameters jobParameters) {
            return jobParameters.getTriggeredContentUris();
        }
    }

    /* loaded from: classes2.dex */
    static class b {
        static Network a(JobParameters jobParameters) {
            return jobParameters.getNetwork();
        }
    }

    /* loaded from: classes2.dex */
    static class c {
        static int a(JobParameters jobParameters) {
            return SystemJobService.b(jobParameters.getStopReason());
        }
    }

    private static void a(String str) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    static int b(int i11) {
        switch (i11) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return i11;
            default:
                return -512;
        }
    }

    private static x d(JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new x(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION"));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // androidx.work.impl.e
    public void c(x xVar, boolean z10) {
        a("onExecuted");
        t.e().a(f15655e, xVar.b() + " executed on JobScheduler");
        JobParameters jobParameters = (JobParameters) this.f15657b.remove(xVar);
        this.f15658c.b(xVar);
        if (jobParameters != null) {
            jobFinished(jobParameters, z10);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            f1 o11 = f1.o(getApplicationContext());
            this.f15656a = o11;
            s q11 = o11.q();
            this.f15659d = new d1(q11, this.f15656a.u());
            q11.e(this);
        } catch (IllegalStateException e11) {
            if (!Application.class.equals(getApplication().getClass())) {
                throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e11);
            }
            t.e().k(f15655e, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.");
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        f1 f1Var = this.f15656a;
        if (f1Var != null) {
            f1Var.q().p(this);
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        WorkerParameters.a aVar;
        a("onStartJob");
        if (this.f15656a == null) {
            t.e().a(f15655e, "WorkManager is not initialized; requesting retry.");
            jobFinished(jobParameters, true);
            return false;
        }
        x d11 = d(jobParameters);
        if (d11 == null) {
            t.e().c(f15655e, "WorkSpec id not found!");
            return false;
        }
        if (this.f15657b.containsKey(d11)) {
            t.e().a(f15655e, "Job is already being executed by SystemJobService: " + d11);
            return false;
        }
        t.e().a(f15655e, "onStartJob for " + d11);
        this.f15657b.put(d11, jobParameters);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 24) {
            aVar = new WorkerParameters.a();
            if (a.b(jobParameters) != null) {
                aVar.f15496b = Arrays.asList(a.b(jobParameters));
            }
            if (a.a(jobParameters) != null) {
                aVar.f15495a = Arrays.asList(a.a(jobParameters));
            }
            if (i11 >= 28) {
                aVar.f15497c = b.a(jobParameters);
            }
        } else {
            aVar = null;
        }
        this.f15659d.a(this.f15658c.d(d11), aVar);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        a("onStopJob");
        if (this.f15656a == null) {
            t.e().a(f15655e, "WorkManager is not initialized; requesting retry.");
            return true;
        }
        x d11 = d(jobParameters);
        if (d11 == null) {
            t.e().c(f15655e, "WorkSpec id not found!");
            return false;
        }
        t.e().a(f15655e, "onStopJob for " + d11);
        this.f15657b.remove(d11);
        y b11 = this.f15658c.b(d11);
        if (b11 != null) {
            this.f15659d.b(b11, Build.VERSION.SDK_INT >= 31 ? c.a(jobParameters) : -512);
        }
        return !this.f15656a.q().j(d11.b());
    }
}

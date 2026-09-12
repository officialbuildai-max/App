package h4;

import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build;
import androidx.work.impl.WorkDatabase;
import androidx.work.t;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private static final String f64482a;

    static {
        String i11 = t.i("SystemJobScheduler");
        Intrinsics.g(i11, "tagWithPrefix(...)");
        f64482a = i11;
    }

    public static final String a(Context context, WorkDatabase workDatabase, androidx.work.b configuration) {
        String str;
        Intrinsics.h(context, "context");
        Intrinsics.h(workDatabase, "workDatabase");
        Intrinsics.h(configuration, "configuration");
        int i11 = Build.VERSION.SDK_INT;
        int i12 = i11 >= 31 ? 150 : 100;
        int size = workDatabase.l0().g().size();
        String str2 = "<faulty JobScheduler failed to getPendingJobs>";
        if (i11 >= 34) {
            JobScheduler c11 = c(context);
            List b11 = b(c11);
            if (b11 != null) {
                List g11 = q.g(context, c11);
                int size2 = g11 != null ? b11.size() - g11.size() : 0;
                String str3 = null;
                if (size2 == 0) {
                    str = null;
                } else {
                    str = size2 + " of which are not owned by WorkManager";
                }
                Object systemService = context.getSystemService("jobscheduler");
                Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.job.JobScheduler");
                List g12 = q.g(context, (JobScheduler) systemService);
                int size3 = g12 != null ? g12.size() : 0;
                if (size3 != 0) {
                    str3 = size3 + " from WorkManager in the default namespace";
                }
                str2 = CollectionsKt.s0(CollectionsKt.p(b11.size() + " jobs in \"androidx.work.systemjobscheduler\" namespace", str, str3), ",\n", null, null, 0, null, null, 62, null);
            }
        } else {
            List g13 = q.g(context, c(context));
            if (g13 != null) {
                str2 = g13.size() + " jobs from WorkManager";
            }
        }
        return "JobScheduler " + i12 + " job limit exceeded.\nIn JobScheduler there are " + str2 + ".\nThere are " + size + " jobs tracked by WorkManager's database;\nthe Configuration limit is " + configuration.h() + '.';
    }

    public static final List b(JobScheduler jobScheduler) {
        Intrinsics.h(jobScheduler, "<this>");
        try {
            return a.f64480a.a(jobScheduler);
        } catch (Throwable th2) {
            t.e().d(f64482a, "getAllPendingJobs() is not reliable on this device.", th2);
            return null;
        }
    }

    public static final JobScheduler c(Context context) {
        Intrinsics.h(context, "<this>");
        Object systemService = context.getSystemService("jobscheduler");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.job.JobScheduler");
        JobScheduler jobScheduler = (JobScheduler) systemService;
        return Build.VERSION.SDK_INT >= 34 ? c.f64481a.a(jobScheduler) : jobScheduler;
    }
}

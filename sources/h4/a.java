package h4;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f64480a = new a();

    private a() {
    }

    public final List a(JobScheduler jobScheduler) {
        Intrinsics.h(jobScheduler, "jobScheduler");
        List<JobInfo> allPendingJobs = jobScheduler.getAllPendingJobs();
        Intrinsics.g(allPendingJobs, "getAllPendingJobs(...)");
        return allPendingJobs;
    }
}

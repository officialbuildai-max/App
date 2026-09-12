package h4;

import android.app.job.JobScheduler;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f64481a = new c();

    private c() {
    }

    public final JobScheduler a(JobScheduler jobScheduler) {
        JobScheduler forNamespace;
        Intrinsics.h(jobScheduler, "jobScheduler");
        forNamespace = jobScheduler.forNamespace("androidx.work.systemjobscheduler");
        Intrinsics.g(forNamespace, "forNamespace(...)");
        return forNamespace;
    }
}

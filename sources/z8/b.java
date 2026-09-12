package z8;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.hisavana.common.tracking.TrackingKey;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;

/* loaded from: classes4.dex */
public class b implements u {

    /* renamed from: a, reason: collision with root package name */
    private final Context f79427a;

    /* renamed from: b, reason: collision with root package name */
    private final a9.d f79428b;

    /* renamed from: c, reason: collision with root package name */
    private final SchedulerConfig f79429c;

    public b(Context context, a9.d dVar, SchedulerConfig schedulerConfig) {
        this.f79427a = context;
        this.f79428b = dVar;
        this.f79429c = schedulerConfig;
    }

    private boolean d(JobScheduler jobScheduler, int i11, int i12) {
        for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
            int i13 = jobInfo.getExtras().getInt("attemptNumber");
            if (jobInfo.getId() == i11) {
                return i13 >= i12;
            }
        }
        return false;
    }

    @Override // z8.u
    public void a(com.google.android.datatransport.runtime.o oVar, int i11) {
        b(oVar, i11, false);
    }

    @Override // z8.u
    public void b(com.google.android.datatransport.runtime.o oVar, int i11, boolean z10) {
        ComponentName componentName = new ComponentName(this.f79427a, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f79427a.getSystemService("jobscheduler");
        int c11 = c(oVar);
        if (!z10 && d(jobScheduler, c11, i11)) {
            w8.a.b("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", oVar);
            return;
        }
        long O = this.f79428b.O(oVar);
        JobInfo.Builder c12 = this.f79429c.c(new JobInfo.Builder(c11, componentName), oVar.d(), O, i11);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i11);
        persistableBundle.putString("backendName", oVar.b());
        persistableBundle.putInt(TrackingKey.PRIORITY, d9.a.a(oVar.d()));
        if (oVar.c() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(oVar.c(), 0));
        }
        c12.setExtras(persistableBundle);
        w8.a.c("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", oVar, Integer.valueOf(c11), Long.valueOf(this.f79429c.g(oVar.d(), O, i11)), Long.valueOf(O), Integer.valueOf(i11));
        jobScheduler.schedule(c12.build());
    }

    int c(com.google.android.datatransport.runtime.o oVar) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.f79427a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(oVar.b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(d9.a.a(oVar.d())).array());
        if (oVar.c() != null) {
            adler32.update(oVar.c());
        }
        return (int) adler32.getValue();
    }
}

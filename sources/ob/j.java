package ob;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f71081a = new j();

    private j() {
    }

    public static /* synthetic */ CrashlyticsReport.e.d.a.c c(j jVar, String str, int i11, int i12, boolean z10, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = 0;
        }
        if ((i13 & 8) != 0) {
            z10 = false;
        }
        return jVar.b(str, i11, i12, z10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0016, code lost:
    
        r0 = android.app.Application.getProcessName();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String f() {
        /*
            r3 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 33
            if (r0 < r1) goto L10
            java.lang.String r0 = ob.i.a()
            java.lang.String r1 = "{\n      Process.myProcessName()\n    }"
            kotlin.jvm.internal.Intrinsics.g(r0, r1)
            goto L1d
        L10:
            r1 = 28
            java.lang.String r2 = ""
            if (r0 < r1) goto L1c
            java.lang.String r0 = com.apm.insight.l.o.a()
            if (r0 != 0) goto L1d
        L1c:
            r0 = r2
        L1d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ob.j.f():java.lang.String");
    }

    public final CrashlyticsReport.e.d.a.c a(String processName, int i11, int i12) {
        Intrinsics.h(processName, "processName");
        return c(this, processName, i11, i12, false, 8, null);
    }

    public final CrashlyticsReport.e.d.a.c b(String processName, int i11, int i12, boolean z10) {
        Intrinsics.h(processName, "processName");
        CrashlyticsReport.e.d.a.c a11 = CrashlyticsReport.e.d.a.c.a().e(processName).d(i11).c(i12).b(z10).a();
        Intrinsics.g(a11, "builder()\n      .setProc…ltProcess)\n      .build()");
        return a11;
    }

    public final List d(Context context) {
        Intrinsics.h(context, "context");
        int i11 = context.getApplicationInfo().uid;
        String str = context.getApplicationInfo().processName;
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager != null ? activityManager.getRunningAppProcesses() : null;
        if (runningAppProcesses == null) {
            runningAppProcesses = CollectionsKt.l();
        }
        List f02 = CollectionsKt.f0(runningAppProcesses);
        ArrayList<ActivityManager.RunningAppProcessInfo> arrayList = new ArrayList();
        for (Object obj : f02) {
            if (((ActivityManager.RunningAppProcessInfo) obj).uid == i11) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.v(arrayList, 10));
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : arrayList) {
            arrayList2.add(CrashlyticsReport.e.d.a.c.a().e(runningAppProcessInfo.processName).d(runningAppProcessInfo.pid).c(runningAppProcessInfo.importance).b(Intrinsics.c(runningAppProcessInfo.processName, str)).a());
        }
        return arrayList2;
    }

    public final CrashlyticsReport.e.d.a.c e(Context context) {
        Object obj;
        Intrinsics.h(context, "context");
        int myPid = Process.myPid();
        Iterator it = d(context).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((CrashlyticsReport.e.d.a.c) obj).c() == myPid) {
                break;
            }
        }
        CrashlyticsReport.e.d.a.c cVar = (CrashlyticsReport.e.d.a.c) obj;
        return cVar == null ? c(this, f(), myPid, 0, false, 12, null) : cVar;
    }
}

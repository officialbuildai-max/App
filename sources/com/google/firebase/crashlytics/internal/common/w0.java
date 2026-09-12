package com.google.firebase.crashlytics.internal.common;

import android.app.ApplicationExitInfo;
import android.content.Context;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public class w0 {

    /* renamed from: a, reason: collision with root package name */
    private final z f31313a;

    /* renamed from: b, reason: collision with root package name */
    private final vb.e f31314b;

    /* renamed from: c, reason: collision with root package name */
    private final com.google.firebase.crashlytics.internal.send.b f31315c;

    /* renamed from: d, reason: collision with root package name */
    private final rb.e f31316d;

    /* renamed from: e, reason: collision with root package name */
    private final rb.o f31317e;

    /* renamed from: f, reason: collision with root package name */
    private final g0 f31318f;

    /* renamed from: g, reason: collision with root package name */
    private final CrashlyticsWorkers f31319g;

    w0(z zVar, vb.e eVar, com.google.firebase.crashlytics.internal.send.b bVar, rb.e eVar2, rb.o oVar, g0 g0Var, CrashlyticsWorkers crashlyticsWorkers) {
        this.f31313a = zVar;
        this.f31314b = eVar;
        this.f31315c = bVar;
        this.f31316d = eVar2;
        this.f31317e = oVar;
        this.f31318f = g0Var;
        this.f31319g = crashlyticsWorkers;
    }

    private CrashlyticsReport.e.d d(CrashlyticsReport.e.d dVar, rb.e eVar, rb.o oVar) {
        CrashlyticsReport.e.d.b h11 = dVar.h();
        String c11 = eVar.c();
        if (c11 != null) {
            h11.d(CrashlyticsReport.e.d.AbstractC0436d.a().b(c11).a());
        } else {
            ob.g.f().i("No log data to include with this event.");
        }
        List n11 = n(oVar.g());
        List n12 = n(oVar.h());
        if (!n11.isEmpty() || !n12.isEmpty()) {
            h11.b(dVar.b().i().e(n11).g(n12).a());
        }
        return h11.a();
    }

    private CrashlyticsReport.e.d e(CrashlyticsReport.e.d dVar) {
        return f(d(dVar, this.f31316d, this.f31317e), this.f31317e);
    }

    private CrashlyticsReport.e.d f(CrashlyticsReport.e.d dVar, rb.o oVar) {
        List i11 = oVar.i();
        if (i11.isEmpty()) {
            return dVar;
        }
        CrashlyticsReport.e.d.b h11 = dVar.h();
        h11.e(CrashlyticsReport.e.d.f.a().b(i11).a());
        return h11.a();
    }

    private static CrashlyticsReport.a g(ApplicationExitInfo applicationExitInfo) {
        String applicationExitInfo2;
        int importance;
        String processName;
        int reason;
        long timestamp;
        int pid;
        long pss;
        long rss;
        InputStream traceInputStream;
        String str = null;
        try {
            traceInputStream = applicationExitInfo.getTraceInputStream();
            if (traceInputStream != null) {
                str = h(traceInputStream);
            }
        } catch (IOException e11) {
            ob.g f11 = ob.g.f();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Could not get input trace in application exit info: ");
            applicationExitInfo2 = applicationExitInfo.toString();
            sb2.append(applicationExitInfo2);
            sb2.append(" Error: ");
            sb2.append(e11);
            f11.k(sb2.toString());
        }
        CrashlyticsReport.a.b a11 = CrashlyticsReport.a.a();
        importance = applicationExitInfo.getImportance();
        CrashlyticsReport.a.b c11 = a11.c(importance);
        processName = applicationExitInfo.getProcessName();
        CrashlyticsReport.a.b e12 = c11.e(processName);
        reason = applicationExitInfo.getReason();
        CrashlyticsReport.a.b g11 = e12.g(reason);
        timestamp = applicationExitInfo.getTimestamp();
        CrashlyticsReport.a.b i11 = g11.i(timestamp);
        pid = applicationExitInfo.getPid();
        CrashlyticsReport.a.b d11 = i11.d(pid);
        pss = applicationExitInfo.getPss();
        CrashlyticsReport.a.b f12 = d11.f(pss);
        rss = applicationExitInfo.getRss();
        return f12.h(rss).j(str).a();
    }

    public static String h(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static w0 i(Context context, g0 g0Var, vb.g gVar, a aVar, rb.e eVar, rb.o oVar, xb.d dVar, wb.b bVar, l0 l0Var, k kVar, CrashlyticsWorkers crashlyticsWorkers) {
        return new w0(new z(context, g0Var, aVar, dVar, bVar), new vb.e(gVar, bVar, kVar), com.google.firebase.crashlytics.internal.send.b.b(context, bVar, l0Var), eVar, oVar, g0Var, crashlyticsWorkers);
    }

    private a0 j(a0 a0Var) {
        if (a0Var.b().h() != null && a0Var.b().g() != null) {
            return a0Var;
        }
        f0 d11 = this.f31318f.d(true);
        return a0.a(a0Var.b().t(d11.b()).s(d11.a()), a0Var.d(), a0Var.c());
    }

    private ApplicationExitInfo m(String str, List list) {
        long timestamp;
        int reason;
        long q11 = this.f31314b.q(str);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ApplicationExitInfo a11 = androidx.work.impl.utils.i.a(it.next());
            timestamp = a11.getTimestamp();
            if (timestamp < q11) {
                return null;
            }
            reason = a11.getReason();
            if (reason == 6) {
                return a11;
            }
        }
        return null;
    }

    private static List n(Map map) {
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(CrashlyticsReport.c.a().b((String) entry.getKey()).c((String) entry.getValue()).a());
        }
        Collections.sort(arrayList, new Comparator() { // from class: com.google.firebase.crashlytics.internal.common.v0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int p11;
                p11 = w0.p((CrashlyticsReport.c) obj, (CrashlyticsReport.c) obj2);
                return p11;
            }
        });
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int p(CrashlyticsReport.c cVar, CrashlyticsReport.c cVar2) {
        return cVar.b().compareTo(cVar2.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(CrashlyticsReport.e.d dVar, String str, boolean z10) {
        ob.g.f().b("disk worker: log non-fatal event to persistence");
        this.f31314b.y(dVar, str, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t(Task task) {
        if (!task.isSuccessful()) {
            ob.g.f().l("Crashlytics report could not be enqueued to DataTransport", task.getException());
            return false;
        }
        a0 a0Var = (a0) task.getResult();
        ob.g.f().b("Crashlytics report successfully enqueued to DataTransport: " + a0Var.d());
        File c11 = a0Var.c();
        if (c11.delete()) {
            ob.g.f().b("Deleted report file: " + c11.getPath());
            return true;
        }
        ob.g.f().k("Crashlytics could not delete report file: " + c11.getPath());
        return true;
    }

    private void u(Throwable th2, Thread thread, final String str, String str2, long j11, boolean z10) {
        final boolean equals = str2.equals(AppMeasurement.CRASH_ORIGIN);
        final CrashlyticsReport.e.d e11 = e(this.f31313a.d(th2, thread, str2, j11, 4, 8, z10));
        if (z10) {
            this.f31314b.y(e11, str, equals);
        } else {
            this.f31319g.f31352b.f(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.u0
                @Override // java.lang.Runnable
                public final void run() {
                    w0.this.q(e11, str, equals);
                }
            });
        }
    }

    public Task A(Executor executor, String str) {
        List<a0> w11 = this.f31314b.w();
        ArrayList arrayList = new ArrayList();
        for (a0 a0Var : w11) {
            if (str == null || str.equals(a0Var.d())) {
                arrayList.add(this.f31315c.c(j(a0Var), str != null).continueWith(executor, new Continuation() { // from class: com.google.firebase.crashlytics.internal.common.t0
                    @Override // com.google.android.gms.tasks.Continuation
                    public final Object then(Task task) {
                        boolean t11;
                        t11 = w0.this.t(task);
                        return Boolean.valueOf(t11);
                    }
                }));
            }
        }
        return Tasks.whenAll(arrayList);
    }

    public void k(String str, List list, CrashlyticsReport.a aVar) {
        ob.g.f().b("SessionReportingCoordinator#finalizeSessionWithNativeEvent");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CrashlyticsReport.d.b a11 = ((j0) it.next()).a();
            if (a11 != null) {
                arrayList.add(a11);
            }
        }
        this.f31314b.l(str, CrashlyticsReport.d.a().b(Collections.unmodifiableList(arrayList)).a(), aVar);
    }

    public void l(long j11, String str) {
        this.f31314b.k(str, j11);
    }

    public boolean o() {
        return this.f31314b.r();
    }

    public SortedSet r() {
        return this.f31314b.p();
    }

    public void s(String str, long j11) {
        this.f31314b.z(this.f31313a.e(str, j11));
    }

    public void v(Throwable th2, Thread thread, String str, long j11) {
        ob.g.f().i("Persisting fatal event for session " + str);
        u(th2, thread, str, AppMeasurement.CRASH_ORIGIN, j11, true);
    }

    public void w(Throwable th2, Thread thread, String str, long j11) {
        ob.g.f().i("Persisting non-fatal event for session " + str);
        u(th2, thread, str, "error", j11, false);
    }

    public void x(String str, List list, rb.e eVar, rb.o oVar) {
        ApplicationExitInfo m11 = m(str, list);
        if (m11 == null) {
            ob.g.f().i("No relevant ApplicationExitInfo occurred during session: " + str);
            return;
        }
        CrashlyticsReport.e.d c11 = this.f31313a.c(g(m11));
        ob.g.f().b("Persisting anr for session " + str);
        this.f31314b.y(f(d(c11, eVar, oVar), oVar), str, true);
    }

    public void y() {
        this.f31314b.i();
    }

    public Task z(Executor executor) {
        return A(executor, null);
    }
}

package com.google.firebase.crashlytics.internal.common;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.common.b0;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.SortedSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import sb.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n {

    /* renamed from: t, reason: collision with root package name */
    static final FilenameFilter f31254t = new FilenameFilter() { // from class: com.google.firebase.crashlytics.internal.common.m
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            boolean M;
            M = n.M(file, str);
            return M;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final Context f31255a;

    /* renamed from: b, reason: collision with root package name */
    private final d0 f31256b;

    /* renamed from: c, reason: collision with root package name */
    private final y f31257c;

    /* renamed from: d, reason: collision with root package name */
    private final rb.o f31258d;

    /* renamed from: e, reason: collision with root package name */
    private final CrashlyticsWorkers f31259e;

    /* renamed from: f, reason: collision with root package name */
    private final g0 f31260f;

    /* renamed from: g, reason: collision with root package name */
    private final vb.g f31261g;

    /* renamed from: h, reason: collision with root package name */
    private final com.google.firebase.crashlytics.internal.common.a f31262h;

    /* renamed from: i, reason: collision with root package name */
    private final rb.e f31263i;

    /* renamed from: j, reason: collision with root package name */
    private final ob.a f31264j;

    /* renamed from: k, reason: collision with root package name */
    private final pb.a f31265k;

    /* renamed from: l, reason: collision with root package name */
    private final k f31266l;

    /* renamed from: m, reason: collision with root package name */
    private final w0 f31267m;

    /* renamed from: n, reason: collision with root package name */
    private b0 f31268n;

    /* renamed from: o, reason: collision with root package name */
    private wb.b f31269o = null;

    /* renamed from: p, reason: collision with root package name */
    final TaskCompletionSource f31270p = new TaskCompletionSource();

    /* renamed from: q, reason: collision with root package name */
    final TaskCompletionSource f31271q = new TaskCompletionSource();

    /* renamed from: r, reason: collision with root package name */
    final TaskCompletionSource f31272r = new TaskCompletionSource();

    /* renamed from: s, reason: collision with root package name */
    final AtomicBoolean f31273s = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements b0.a {
        a() {
        }

        @Override // com.google.firebase.crashlytics.internal.common.b0.a
        public void a(wb.b bVar, Thread thread, Throwable th2) {
            n.this.I(bVar, thread, th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements Callable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f31275a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Throwable f31276b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Thread f31277c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ wb.b f31278d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f31279e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public class a implements SuccessContinuation {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f31281a;

            a(String str) {
                this.f31281a = str;
            }

            @Override // com.google.android.gms.tasks.SuccessContinuation
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Task then(com.google.firebase.crashlytics.internal.settings.c cVar) {
                if (cVar != null) {
                    return Tasks.whenAll((Task<?>[]) new Task[]{n.this.P(), n.this.f31267m.A(n.this.f31259e.f31351a, b.this.f31279e ? this.f31281a : null)});
                }
                ob.g.f().k("Received null app settings, cannot send reports at crash time.");
                return Tasks.forResult(null);
            }
        }

        b(long j11, Throwable th2, Thread thread, wb.b bVar, boolean z10) {
            this.f31275a = j11;
            this.f31276b = th2;
            this.f31277c = thread;
            this.f31278d = bVar;
            this.f31279e = z10;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Task call() {
            long G = n.G(this.f31275a);
            String C = n.this.C();
            if (C == null) {
                ob.g.f().d("Tried to write a fatal exception while no session was open.");
                return Tasks.forResult(null);
            }
            n.this.f31257c.a();
            n.this.f31267m.v(this.f31276b, this.f31277c, C, G);
            n.this.x(this.f31275a);
            n.this.u(this.f31278d);
            n.this.w(new g().c(), Boolean.valueOf(this.f31279e));
            return !n.this.f31256b.d() ? Tasks.forResult(null) : this.f31278d.a().onSuccessTask(n.this.f31259e.f31351a, new a(C));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements SuccessContinuation {
        c() {
        }

        @Override // com.google.android.gms.tasks.SuccessContinuation
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Task then(Void r12) {
            return Tasks.forResult(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements SuccessContinuation {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Task f31284a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public class a implements SuccessContinuation {
            a() {
            }

            @Override // com.google.android.gms.tasks.SuccessContinuation
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Task then(com.google.firebase.crashlytics.internal.settings.c cVar) {
                if (cVar == null) {
                    ob.g.f().k("Received null app settings at app startup. Cannot send cached reports");
                    return Tasks.forResult(null);
                }
                n.this.P();
                n.this.f31267m.z(n.this.f31259e.f31351a);
                n.this.f31272r.trySetResult(null);
                return Tasks.forResult(null);
            }
        }

        d(Task task) {
            this.f31284a = task;
        }

        @Override // com.google.android.gms.tasks.SuccessContinuation
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Task then(Boolean bool) {
            if (bool.booleanValue()) {
                ob.g.f().b("Sending cached crash reports...");
                n.this.f31256b.c(bool.booleanValue());
                return this.f31284a.onSuccessTask(n.this.f31259e.f31351a, new a());
            }
            ob.g.f().i("Deleting cached crash reports...");
            n.r(n.this.N());
            n.this.f31267m.y();
            n.this.f31272r.trySetResult(null);
            return Tasks.forResult(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements Callable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f31287a;

        e(long j11) {
            this.f31287a = j11;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            Bundle bundle = new Bundle();
            bundle.putInt("fatal", 1);
            bundle.putLong(CampaignEx.JSON_KEY_TIMESTAMP, this.f31287a);
            n.this.f31265k.a("_ae", bundle);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, g0 g0Var, d0 d0Var, vb.g gVar, y yVar, com.google.firebase.crashlytics.internal.common.a aVar, rb.o oVar, rb.e eVar, w0 w0Var, ob.a aVar2, pb.a aVar3, k kVar, CrashlyticsWorkers crashlyticsWorkers) {
        this.f31255a = context;
        this.f31260f = g0Var;
        this.f31256b = d0Var;
        this.f31261g = gVar;
        this.f31257c = yVar;
        this.f31262h = aVar;
        this.f31258d = oVar;
        this.f31263i = eVar;
        this.f31264j = aVar2;
        this.f31265k = aVar3;
        this.f31266l = kVar;
        this.f31267m = w0Var;
        this.f31259e = crashlyticsWorkers;
    }

    private static boolean B() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String C() {
        SortedSet r11 = this.f31267m.r();
        if (r11.isEmpty()) {
            return null;
        }
        return (String) r11.first();
    }

    private static long D() {
        return G(System.currentTimeMillis());
    }

    static List E(ob.h hVar, String str, vb.g gVar, byte[] bArr) {
        File q11 = gVar.q(str, "user-data");
        File q12 = gVar.q(str, "keys");
        File q13 = gVar.q(str, "rollouts-state");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new f("logs_file", "logs", bArr));
        arrayList.add(new e0("crash_meta_file", TtmlNode.TAG_METADATA, hVar.d()));
        arrayList.add(new e0("session_meta_file", "session", hVar.g()));
        arrayList.add(new e0("app_meta_file", "app", hVar.e()));
        arrayList.add(new e0("device_meta_file", "device", hVar.a()));
        arrayList.add(new e0("os_meta_file", "os", hVar.f()));
        arrayList.add(R(hVar));
        arrayList.add(new e0("user_meta_file", "user", q11));
        arrayList.add(new e0("keys_file", "keys", q12));
        arrayList.add(new e0("rollouts_file", "rollouts", q13));
        return arrayList;
    }

    private InputStream F(String str) {
        ClassLoader classLoader = getClass().getClassLoader();
        if (classLoader == null) {
            ob.g.f().k("Couldn't get Class Loader");
            return null;
        }
        InputStream resourceAsStream = classLoader.getResourceAsStream(str);
        if (resourceAsStream != null) {
            return resourceAsStream;
        }
        ob.g.f().g("No version control information found");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long G(long j11) {
        return j11 / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(String str) {
        w(str, Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean M(File file, String str) {
        return str.startsWith(".ae");
    }

    private Task O(long j11) {
        if (B()) {
            ob.g.f().k("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
            return Tasks.forResult(null);
        }
        ob.g.f().b("Logging app exception event to Firebase Analytics");
        return Tasks.call(new ScheduledThreadPoolExecutor(1), new e(j11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task P() {
        ArrayList arrayList = new ArrayList();
        for (File file : N()) {
            try {
                arrayList.add(O(Long.parseLong(file.getName().substring(3))));
            } catch (NumberFormatException unused) {
                ob.g.f().k("Could not parse app exception timestamp from file " + file.getName());
            }
            file.delete();
        }
        return Tasks.whenAll(arrayList);
    }

    private static boolean Q(String str, File file, CrashlyticsReport.a aVar) {
        if (file == null || !file.exists()) {
            ob.g.f().k("No minidump data found for session " + str);
        }
        if (aVar == null) {
            ob.g.f().g("No Tombstones data found for session " + str);
        }
        return (file == null || !file.exists()) && aVar == null;
    }

    private static j0 R(ob.h hVar) {
        File c11 = hVar.c();
        return (c11 == null || !c11.exists()) ? new f("minidump_file", "minidump", new byte[]{0}) : new e0("minidump_file", "minidump", c11);
    }

    private static byte[] T(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private Task a0() {
        if (this.f31256b.d()) {
            ob.g.f().b("Automatic data collection is enabled. Allowing upload.");
            this.f31270p.trySetResult(Boolean.FALSE);
            return Tasks.forResult(Boolean.TRUE);
        }
        ob.g.f().b("Automatic data collection is disabled.");
        ob.g.f().i("Notifying that unsent reports are available.");
        this.f31270p.trySetResult(Boolean.TRUE);
        Task onSuccessTask = this.f31256b.j().onSuccessTask(new c());
        ob.g.f().b("Waiting for send/deleteUnsentReports to be called.");
        return com.google.firebase.crashlytics.internal.concurrency.b.c(onSuccessTask, this.f31271q.getTask());
    }

    private void b0(String str) {
        List historicalProcessExitReasons;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 30) {
            ob.g.f().i("ANR feature enabled, but device is API " + i11);
            return;
        }
        historicalProcessExitReasons = ((ActivityManager) this.f31255a.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
        if (historicalProcessExitReasons.size() != 0) {
            this.f31267m.x(str, historicalProcessExitReasons, new rb.e(this.f31261g, str), rb.o.m(str, this.f31261g, this.f31259e));
        } else {
            ob.g.f().i("No ApplicationExitInfo available. Session: " + str);
        }
    }

    private static e.a o(g0 g0Var, com.google.firebase.crashlytics.internal.common.a aVar) {
        return e.a.b(g0Var.f(), aVar.f31196f, aVar.f31197g, g0Var.a().c(), DeliveryMechanism.determineFrom(aVar.f31194d).getId(), aVar.f31198h);
    }

    private static e.b p(Context context) {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return e.b.c(CommonUtils.k(), Build.MODEL, Runtime.getRuntime().availableProcessors(), CommonUtils.b(context), statFs.getBlockCount() * statFs.getBlockSize(), CommonUtils.w(), CommonUtils.l(), Build.MANUFACTURER, Build.PRODUCT);
    }

    private static e.c q() {
        return e.c.a(Build.VERSION.RELEASE, Build.VERSION.CODENAME, CommonUtils.x());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void v(boolean z10, wb.b bVar, boolean z11) {
        String str;
        CrashlyticsWorkers.c();
        ArrayList arrayList = new ArrayList(this.f31267m.r());
        if (arrayList.size() <= z10) {
            ob.g.f().i("No open sessions to be closed.");
            return;
        }
        String str2 = (String) arrayList.get(z10 ? 1 : 0);
        if (z11 && bVar.b().f31792b.f31800b) {
            b0(str2);
        } else {
            ob.g.f().i("ANR feature disabled.");
        }
        if (z11 && this.f31264j.d(str2)) {
            z(str2);
        }
        if (z10 != 0) {
            str = (String) arrayList.get(0);
        } else {
            this.f31266l.e(null);
            str = null;
        }
        this.f31267m.l(D(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, Boolean bool) {
        long D = D();
        ob.g.f().b("Opening a new session with ID " + str);
        this.f31264j.c(str, String.format(Locale.US, "Crashlytics Android SDK/%s", x.q()), D, sb.e.b(o(this.f31260f, this.f31262h), q(), p(this.f31255a)));
        if (bool.booleanValue() && str != null) {
            this.f31258d.r(str);
        }
        this.f31263i.e(str);
        this.f31266l.e(str);
        this.f31267m.s(str, D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(long j11) {
        try {
            if (this.f31261g.g(".ae" + j11).createNewFile()) {
            } else {
                throw new IOException("Create new file failed.");
            }
        } catch (IOException e11) {
            ob.g.f().l("Could not create app exception marker file.", e11);
        }
    }

    private void z(String str) {
        ob.g.f().i("Finalizing native report for session " + str);
        ob.h a11 = this.f31264j.a(str);
        File c11 = a11.c();
        CrashlyticsReport.a b11 = a11.b();
        if (Q(str, c11, b11)) {
            ob.g.f().k("No native core present");
            return;
        }
        long lastModified = c11.lastModified();
        rb.e eVar = new rb.e(this.f31261g, str);
        File k11 = this.f31261g.k(str);
        if (!k11.isDirectory()) {
            ob.g.f().k("Couldn't create directory to store native session files, aborting.");
            return;
        }
        x(lastModified);
        List E = E(a11, str, this.f31261g, eVar.b());
        k0.b(k11, E);
        ob.g.f().b("CrashlyticsController#finalizePreviousNativeSession");
        this.f31267m.k(str, E, b11);
        eVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean A(wb.b bVar) {
        CrashlyticsWorkers.c();
        if (K()) {
            ob.g.f().k("Skipping session finalization because a crash has already occurred.");
            return false;
        }
        ob.g.f().i("Finalizing previously open sessions.");
        try {
            v(true, bVar, true);
            ob.g.f().i("Closed all previously open sessions.");
            return true;
        } catch (Exception e11) {
            ob.g.f().e("Unable to finalize previously open sessions.", e11);
            return false;
        }
    }

    String H() {
        InputStream F = F("META-INF/version-control-info.textproto");
        if (F == null) {
            return null;
        }
        ob.g.f().b("Read version control info");
        return Base64.encodeToString(T(F), 0);
    }

    void I(wb.b bVar, Thread thread, Throwable th2) {
        J(bVar, thread, th2, false);
    }

    synchronized void J(wb.b bVar, Thread thread, Throwable th2, boolean z10) {
        ob.g.f().b("Handling uncaught exception \"" + th2 + "\" from thread " + thread.getName());
        Task g11 = this.f31259e.f31351a.g(new b(System.currentTimeMillis(), th2, thread, bVar, z10));
        if (!z10) {
            try {
                try {
                    z0.b(g11);
                } catch (TimeoutException unused) {
                    ob.g.f().d("Cannot send reports. Timed out while fetching settings.");
                }
            } catch (Exception e11) {
                ob.g.f().e("Error handling uncaught exception", e11);
            }
        }
    }

    boolean K() {
        b0 b0Var = this.f31268n;
        return b0Var != null && b0Var.a();
    }

    List N() {
        return this.f31261g.h(f31254t);
    }

    void S(final String str) {
        this.f31259e.f31351a.f(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.l
            @Override // java.lang.Runnable
            public final void run() {
                n.this.L(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U() {
        try {
            String H = H();
            if (H != null) {
                X("com.crashlytics.version-control-info", H);
                ob.g.f().g("Saved version control info");
            }
        } catch (IOException e11) {
            ob.g.f().l("Unable to save version control info", e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task V() {
        this.f31271q.trySetResult(Boolean.TRUE);
        return this.f31272r.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(String str, String str2) {
        try {
            this.f31258d.p(str, str2);
        } catch (IllegalArgumentException e11) {
            Context context = this.f31255a;
            if (context != null && CommonUtils.u(context)) {
                throw e11;
            }
            ob.g.f().d("Attempting to set custom attribute with null key, ignoring.");
        }
    }

    void X(String str, String str2) {
        try {
            this.f31258d.q(str, str2);
        } catch (IllegalArgumentException e11) {
            Context context = this.f31255a;
            if (context != null && CommonUtils.u(context)) {
                throw e11;
            }
            ob.g.f().d("Attempting to set custom attribute with null key, ignoring.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(String str) {
        this.f31258d.s(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z(Task task) {
        if (this.f31267m.o()) {
            ob.g.f().i("Crash reports are available to be sent.");
            a0().onSuccessTask(this.f31259e.f31351a, new d(task));
        } else {
            ob.g.f().i("No crash reports are available to be sent.");
            this.f31270p.trySetResult(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c0(Thread thread, Throwable th2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (K()) {
            return;
        }
        long G = G(currentTimeMillis);
        String C = C();
        if (C == null) {
            ob.g.f().k("Tried to write a non-fatal exception while no session was open.");
        } else {
            this.f31267m.w(th2, thread, C, G);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d0(long j11, String str) {
        if (K()) {
            return;
        }
        this.f31263i.g(j11, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task n() {
        if (this.f31273s.compareAndSet(false, true)) {
            return this.f31270p.getTask();
        }
        ob.g.f().k("checkForUnsentReports should only be called once per execution.");
        return Tasks.forResult(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task s() {
        this.f31271q.trySetResult(Boolean.FALSE);
        return this.f31272r.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t() {
        CrashlyticsWorkers.c();
        if (!this.f31257c.c()) {
            String C = C();
            return C != null && this.f31264j.d(C);
        }
        ob.g.f().i("Found previous crash marker.");
        this.f31257c.d();
        return true;
    }

    void u(wb.b bVar) {
        v(false, bVar, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(String str, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, wb.b bVar) {
        this.f31269o = bVar;
        S(str);
        b0 b0Var = new b0(new a(), bVar, uncaughtExceptionHandler, this.f31264j);
        this.f31268n = b0Var;
        Thread.setDefaultUncaughtExceptionHandler(b0Var);
    }
}

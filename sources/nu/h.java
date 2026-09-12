package nu;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.util.Log;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.service.PatchResult;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import com.transsion.tinker.lib.custom.api.PatchState;
import com.transsion.tinker.lib.custom.config.PatchInfoLoader;
import com.transsion.tinker.lib.custom.download.DownloadManager;
import com.transsion.tinker.lib.custom.service.CustomResultService;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import nu.h;

/* loaded from: classes7.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    private static ApplicationLike f70675a;

    /* renamed from: c, reason: collision with root package name */
    private static tu.a f70677c;

    /* renamed from: d, reason: collision with root package name */
    private static wu.a f70678d;

    /* renamed from: e, reason: collision with root package name */
    private static wu.b f70679e;

    /* renamed from: f, reason: collision with root package name */
    private static DownloadManager f70680f;

    /* renamed from: h, reason: collision with root package name */
    private static BroadcastReceiver f70682h;

    /* renamed from: b, reason: collision with root package name */
    private static final wu.f f70676b = new wu.f();

    /* renamed from: g, reason: collision with root package name */
    private static xu.b f70681g = xu.b.a();

    /* renamed from: i, reason: collision with root package name */
    private static final AtomicBoolean f70683i = new AtomicBoolean(false);

    /* renamed from: j, reason: collision with root package name */
    private static final ExecutorService f70684j = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: nu.a
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread C;
            C = h.C(runnable);
            return C;
        }
    });

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class a implements DownloadManager.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DownloadManager.a f70685a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f70686b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ou.d f70687c;

        a(DownloadManager.a aVar, Context context, ou.d dVar) {
            this.f70685a = aVar;
            this.f70686b = context;
            this.f70687c = dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void d(ou.d dVar, ou.c cVar) {
            cVar.c(dVar.f(), "guard_reject");
        }

        @Override // com.transsion.tinker.lib.custom.download.DownloadManager.a
        public void a(long j11, long j12) {
            DownloadManager.a aVar = this.f70685a;
            if (aVar != null) {
                aVar.a(j11, j12);
            }
        }

        @Override // com.transsion.tinker.lib.custom.download.DownloadManager.a
        public void b(Exception exc) {
            h.f70683i.set(false);
            String message = exc != null ? exc.getMessage() : "download_fail";
            yu.a.o(this.f70686b, PatchState.NONE, this.f70687c.f(), message);
            vu.a.d();
            uu.a.e(this.f70686b, "WARN", "Tinker.HotfixHelper", "download failed: " + this.f70687c.f() + " reason=" + message);
            DownloadManager.a aVar = this.f70685a;
            if (aVar != null) {
                aVar.b(exc);
            }
        }

        @Override // com.transsion.tinker.lib.custom.download.DownloadManager.a
        public void onSuccess(String str) {
            h.f70683i.set(false);
            if (!su.a.a(this.f70686b, this.f70687c, new File(str))) {
                yu.a.o(this.f70686b, PatchState.BLACKLISTED, this.f70687c.f(), "guard_reject");
                final ou.d dVar = this.f70687c;
                h.p(new f() { // from class: nu.g
                    @Override // nu.h.f
                    public final void a(ou.c cVar) {
                        h.a.d(ou.d.this, cVar);
                    }
                });
                DownloadManager.a aVar = this.f70685a;
                if (aVar != null) {
                    aVar.b(new IllegalStateException("patch guard reject"));
                    return;
                }
                return;
            }
            yu.a.o(this.f70686b, PatchState.READY, this.f70687c.f(), null);
            uu.a.e(this.f70686b, "INFO", "Tinker.HotfixHelper", "download ok, triggering install: " + this.f70687c.f());
            TinkerPatchService.i(this.f70686b, str);
            DownloadManager.a aVar2 = this.f70685a;
            if (aVar2 != null) {
                aVar2.onSuccess(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class b extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f70688a;

        b(Context context) {
            this.f70688a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(PatchResult patchResult, long j11, Context context, String str, String str2) {
            if (patchResult != null) {
                try {
                    h.f70676b.f();
                } catch (Throwable th2) {
                    ShareTinkerLog.e("Tinker.HotfixHelper", "reporter callback failed: %s", th2.getMessage());
                    return;
                }
            }
            if (patchResult != null && j11 >= 0) {
                h.f70676b.i(patchResult.patchVersion, patchResult.isSuccess, j11);
            }
            if (patchResult != null) {
                uu.a.e(context, patchResult.isSuccess ? "INFO" : "WARN", "Tinker.HotfixHelper", "install result: success=" + patchResult.isSuccess + " patchVersion=" + patchResult.patchVersion);
                h.f70676b.j(patchResult);
                if (!patchResult.isSuccess && patchResult.f40747e != null) {
                    h.f70676b.g(patchResult.patchVersion, patchResult.f40747e);
                }
            }
            if (str != null && patchResult != null) {
                uu.a.e(context, "WARN", "Tinker.HotfixHelper", "rollback triggered: " + patchResult.patchVersion + " reason=" + str);
                h.f70676b.h(patchResult.patchVersion, str);
                yu.a.m(context, true);
            }
            if (str2 == null || patchResult == null) {
                return;
            }
            h.f70676b.c(patchResult.patchVersion, str2);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("com.tencent.tinker.custom.action.PATCH_RESULT".equals(intent.getAction())) {
                ShareTinkerLog.i("Tinker.HotfixHelper", "onReceive PATCH_RESULT: sDeferredReporter=%s", h.f70676b);
                try {
                    final PatchResult patchResult = (PatchResult) intent.getSerializableExtra("patch_result");
                    final String stringExtra = intent.getStringExtra("rollback_reason");
                    final String stringExtra2 = intent.getStringExtra("blacklist_reason");
                    final long longExtra = intent.getLongExtra("install_cost_ms", -1L);
                    ExecutorService executorService = h.f70684j;
                    final Context context2 = this.f70688a;
                    executorService.execute(new Runnable() { // from class: nu.i
                        @Override // java.lang.Runnable
                        public final void run() {
                            h.b.b(PatchResult.this, longExtra, context2, stringExtra, stringExtra2);
                        }
                    });
                } catch (Throwable th2) {
                    ShareTinkerLog.e("Tinker.HotfixHelper", "onReceive error: %s", th2.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class c implements DownloadManager.a {
        c() {
        }

        @Override // com.transsion.tinker.lib.custom.download.DownloadManager.a
        public void a(long j11, long j12) {
        }

        @Override // com.transsion.tinker.lib.custom.download.DownloadManager.a
        public void b(Exception exc) {
            ShareTinkerLog.w("Tinker.HotfixHelper", "checkPendingPatch: download failed: %s", exc != null ? exc.getMessage() : TmcConstants.ROUTE_UNKNOWN);
        }

        @Override // com.transsion.tinker.lib.custom.download.DownloadManager.a
        public void onSuccess(String str) {
            ShareTinkerLog.i("Tinker.HotfixHelper", "checkPendingPatch: download success, localPath=%s", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class d implements ShareTinkerLog.TinkerLogImp {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f70689a;

        d(Context context) {
            this.f70689a = context;
        }

        private String a(String str, Object[] objArr) {
            if (objArr == null || objArr.length == 0) {
                return str != null ? str : "";
            }
            try {
                return String.format(str != null ? str : "", objArr);
            } catch (Exception unused) {
                return str != null ? str : "";
            }
        }

        private boolean b(Context context, int i11) {
            if (i11 < 5 && !ou.a.s().J()) {
                return new File(context.getFilesDir(), "tinker_log_on").exists();
            }
            return true;
        }

        @Override // com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp
        public void d(String str, String str2, Object... objArr) {
            if (b(this.f70689a, 3)) {
                Log.println(3, str, a(str2, objArr));
            }
        }

        @Override // com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp
        public void e(String str, String str2, Object... objArr) {
            if (b(this.f70689a, 6)) {
                Log.println(6, str, a(str2, objArr));
            }
        }

        @Override // com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp
        public void i(String str, String str2, Object... objArr) {
            if (b(this.f70689a, 4)) {
                Log.println(4, str, a(str2, objArr));
            }
        }

        @Override // com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp
        public void printErrStackTrace(String str, Throwable th2, String str2, Object... objArr) {
            if (b(this.f70689a, 6)) {
                Log.println(6, str, a(str2, objArr));
                if (th2 != null) {
                    Log.println(6, str, Log.getStackTraceString(th2));
                }
            }
        }

        @Override // com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp
        public void v(String str, String str2, Object... objArr) {
            if (b(this.f70689a, 2)) {
                Log.println(2, str, a(str2, objArr));
            }
        }

        @Override // com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp
        public void w(String str, String str2, Object... objArr) {
            if (b(this.f70689a, 5)) {
                Log.println(5, str, a(str2, objArr));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f70690a;

        static {
            int[] iArr = new int[PatchInfoLoader.LoadStatus.values().length];
            f70690a = iArr;
            try {
                iArr[PatchInfoLoader.LoadStatus.AVAILABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f70690a[PatchInfoLoader.LoadStatus.REVOKED_BY_SERVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f70690a[PatchInfoLoader.LoadStatus.NETWORK_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public interface f {
        void a(ou.c cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Thread C(Runnable runnable) {
        Thread thread = new Thread(runnable, "tinker-reporter");
        thread.setDaemon(true);
        return thread;
    }

    private static void D(Context context) {
        synchronized (h.class) {
            try {
                if (f70682h != null) {
                    return;
                }
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                f70682h = new b(context);
                IntentFilter intentFilter = new IntentFilter("com.tencent.tinker.custom.action.PATCH_RESULT");
                try {
                    if (Build.VERSION.SDK_INT >= 26) {
                        context.registerReceiver(f70682h, intentFilter, 2);
                    } else {
                        context.registerReceiver(f70682h, intentFilter);
                    }
                } catch (RuntimeException e11) {
                    f70682h = null;
                    ShareTinkerLog.e("Tinker.HotfixHelper", "register result receiver failed: " + e11, e11);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void k(Context context, long j11) {
        zu.c.c(context, j11);
    }

    public static void l(final Context context) {
        if (context == null) {
            return;
        }
        if (!ou.a.s().I()) {
            ShareTinkerLog.i("Tinker.HotfixHelper", "hotfix is disabled, skip checkPendingPatch", new Object[0]);
            return;
        }
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        f70684j.execute(new Runnable() { // from class: nu.b
            @Override // java.lang.Runnable
            public final void run() {
                h.y(context);
            }
        });
    }

    private static void m(File file) {
        File[] listFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isFile() && !file2.delete()) {
                ShareTinkerLog.w("Tinker.HotfixHelper", "failed to delete old patch cache: %s", file2.getName());
            }
        }
    }

    public static void n(ou.c cVar) {
        f70676b.p(cVar);
    }

    public static void o() {
        zu.c.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(final f fVar) {
        f70684j.execute(new Runnable() { // from class: nu.d
            @Override // java.lang.Runnable
            public final void run() {
                h.z(h.f.this);
            }
        });
    }

    public static void q(Context context, ou.d dVar, DownloadManager.a aVar) {
        if (context == null || dVar == null) {
            if (aVar != null) {
                aVar.b(new IllegalArgumentException("context or info is null"));
                return;
            }
            return;
        }
        if (dVar.c() == null || dVar.c().isEmpty()) {
            if (aVar != null) {
                aVar.b(new IllegalArgumentException("patch url is empty"));
                return;
            }
            return;
        }
        if (!ou.a.s().I()) {
            ShareTinkerLog.i("Tinker.HotfixHelper", "hotfix is disabled by remote config, skip downloadAndInstall", new Object[0]);
            if (aVar != null) {
                aVar.b(new IllegalStateException("hotfix disabled"));
                return;
            }
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (!dVar.m()) {
            r(applicationContext, dVar, aVar);
            return;
        }
        if (dVar.d() > 0 && System.currentTimeMillis() > dVar.d()) {
            ShareTinkerLog.w("Tinker.HotfixHelper", "patch %s expired at %d, reject download", dVar.f(), Long.valueOf(dVar.d()));
            yu.a.o(applicationContext, PatchState.EXPIRED, dVar.f(), "expired");
            if (aVar != null) {
                aVar.b(new IllegalStateException("patch expired: " + dVar.f()));
                return;
            }
            return;
        }
        PatchState e11 = yu.a.e(applicationContext);
        final String d11 = yu.a.d(applicationContext);
        if (e11 == PatchState.INSTALLED && dVar.f().equals(d11)) {
            ShareTinkerLog.i("Tinker.HotfixHelper", "patch %s already installed, skip re-download", dVar.f());
            return;
        }
        PatchState patchState = PatchState.BLACKLISTED;
        if (e11 == patchState && dVar.f().equals(d11) && !dVar.n()) {
            ShareTinkerLog.w("Tinker.HotfixHelper", "patch %s is blacklisted, reject download. reason: %s", dVar.f(), yu.a.c(applicationContext));
            final String f11 = dVar.f();
            p(new f() { // from class: nu.e
                @Override // nu.h.f
                public final void a(ou.c cVar) {
                    cVar.l(f11, "blacklisted");
                }
            });
            if (aVar != null) {
                aVar.b(new IllegalStateException("patch is blacklisted: " + yu.a.c(applicationContext)));
                return;
            }
            return;
        }
        if (e11 == patchState && dVar.f().equals(d11) && dVar.n()) {
            ShareTinkerLog.w("Tinker.HotfixHelper", "mandatory patch %s bypassing BLACKLISTED state", dVar.f());
            yu.a.a(applicationContext);
        }
        if (!f70683i.compareAndSet(false, true)) {
            ShareTinkerLog.w("Tinker.HotfixHelper", "a download is already in progress, reject new request", new Object[0]);
            if (aVar != null) {
                aVar.b(new IllegalStateException("A download task is already in progress"));
                return;
            }
            return;
        }
        File file = new File(applicationContext.getCacheDir(), ou.a.s().G());
        if (!dVar.f().equals(d11)) {
            if (d11 != null && !d11.isEmpty()) {
                yu.a.k(applicationContext, d11);
            }
            m(file);
            if (d11 != null && !d11.isEmpty()) {
                final String f12 = dVar.f();
                p(new f() { // from class: nu.f
                    @Override // nu.h.f
                    public final void a(ou.c cVar) {
                        cVar.b(d11, f12);
                    }
                });
            }
        }
        yu.a.o(applicationContext, PatchState.DOWNLOADING, dVar.f(), null);
        uu.a.e(applicationContext, "INFO", "Tinker.HotfixHelper", "start downloading patch: " + dVar.f());
        yu.a.j(applicationContext, dVar.d());
        if (f70680f == null) {
            f70680f = new DownloadManager(applicationContext);
        }
        f70676b.d(dVar.f(), dVar.c());
        f70680f.f(dVar, file, new a(aVar, applicationContext, dVar));
    }

    private static void r(Context context, ou.d dVar, DownloadManager.a aVar) {
        ShareTinkerLog.w("Tinker.HotfixHelper", "patch %s disabled by server", dVar.f());
        if (dVar.f().equals(yu.a.d(context))) {
            PatchState e11 = yu.a.e(context);
            if (e11 == PatchState.INSTALLED || e11 == PatchState.READY) {
                ShareTinkerLog.w("Tinker.HotfixHelper", "patch %s in state %s, rolling back due to server_invalidated", dVar.f(), e11);
                if (e11 == PatchState.READY) {
                    m(new File(context.getCacheDir(), ou.a.s().G()));
                }
                xu.a.a(context, dVar.f(), "server_invalidated", f70676b);
            } else {
                yu.a.o(context, PatchState.NONE, dVar.f(), "server_invalidated");
            }
        }
        if (aVar != null) {
            aVar.b(new IllegalStateException("patch disabled by server: " + dVar.f()));
        }
    }

    private static void s(Context context) {
        PatchState e11 = yu.a.e(context);
        String d11 = yu.a.d(context);
        if (e11 != PatchState.INSTALLED && e11 != PatchState.READY) {
            ShareTinkerLog.d("Tinker.HotfixHelper", "server revoked patch config, current state=%s, no rollback needed", e11);
            return;
        }
        ShareTinkerLog.i("Tinker.HotfixHelper", "server revoked patch config, cleaning up: patchId=%s state=%s", d11, e11);
        vf.a.x(context).a();
        yu.a.o(context, PatchState.ROLLBACK, d11, "server_revoked");
        if (e11 == PatchState.READY) {
            m(new File(context.getCacheDir(), ou.a.s().G()));
        }
    }

    public static void t(Context context, ou.c cVar) {
        if (context == null) {
            ShareTinkerLog.w("Tinker.HotfixHelper", "initialize: context is null, skip", new Object[0]);
            return;
        }
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        n(cVar);
        vu.a.c(context);
    }

    public static void u(ApplicationLike applicationLike) {
        v(applicationLike, null);
    }

    public static void v(ApplicationLike applicationLike, ou.c cVar) {
        if (applicationLike == null) {
            return;
        }
        f70675a = applicationLike;
        if (cVar != null) {
            f70676b.p(cVar);
        }
        Application application = applicationLike.getApplication();
        if (application == null) {
            ShareTinkerLog.e("Tinker.HotfixHelper", "install failed: application context is null", new Object[0]);
            return;
        }
        xu.b bVar = f70681g;
        wu.f fVar = f70676b;
        xu.d.b(application, bVar, fVar);
        tu.a aVar = new tu.a(application);
        f70677c = aVar;
        aVar.f(fVar);
        f70678d = new wu.a(application, fVar);
        f70679e = new wu.b(application, fVar);
        yu.a.l(application, f70681g);
        D(application);
        w(application);
        vf.b.a(applicationLike, f70678d, f70679e, f70677c, CustomResultService.class, new tf.g());
    }

    private static void w(Context context) {
        ShareTinkerLog.setTinkerLogImp(new d(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y(Context context) {
        PatchInfoLoader.a d11 = PatchInfoLoader.d(context);
        int i11 = e.f70690a[d11.f55199a.ordinal()];
        if (i11 != 1) {
            if (i11 == 2) {
                s(context);
                return;
            } else {
                if (i11 != 3) {
                    return;
                }
                ShareTinkerLog.i("Tinker.HotfixHelper", "checkPendingPatch: network error, skip", new Object[0]);
                return;
            }
        }
        ShareTinkerLog.i("Tinker.HotfixHelper", "checkPendingPatch: pending patch found, patchId=%s", d11.f55200b.f());
        final String b11 = yu.a.b(context);
        String f11 = d11.f55200b.f();
        if (b11 != null && b11.equals(f11)) {
            ShareTinkerLog.w("Tinker.HotfixHelper", "checkPendingPatch: patch %s is blacklisted, skip download to avoid rollback loop", b11);
            p(new f() { // from class: nu.c
                @Override // nu.h.f
                public final void a(ou.c cVar) {
                    cVar.l(b11, "blacklisted_rollback_loop");
                }
            });
            return;
        }
        if (b11 != null && !b11.equals(f11)) {
            ShareTinkerLog.i("Tinker.HotfixHelper", "checkPendingPatch: new patch available (blacklisted=%s, pending=%s), clearing blacklist", b11, f11);
            yu.a.a(context);
        }
        q(context, d11.f55200b, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z(f fVar) {
        try {
            fVar.a(f70676b);
        } catch (Throwable th2) {
            ShareTinkerLog.e("Tinker.HotfixHelper", "reporter dispatch failed: %s", th2.getMessage());
        }
    }
}

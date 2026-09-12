package com.tencent.tinker.lib.service;

import android.app.ActivityManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import tf.a;
import wf.b;

/* loaded from: classes5.dex */
public class TinkerPatchService extends IntentService {

    /* renamed from: a, reason: collision with root package name */
    private static a f40749a = null;

    /* renamed from: b, reason: collision with root package name */
    private static int f40750b = -1119860829;

    /* renamed from: c, reason: collision with root package name */
    private static Class f40751c;

    /* renamed from: d, reason: collision with root package name */
    private static AtomicBoolean f40752d = new AtomicBoolean(false);

    /* loaded from: classes5.dex */
    public static class InnerService extends Service {
        @Override // android.app.Service
        public IBinder onBind(Intent intent) {
            return null;
        }

        @Override // android.app.Service
        public void onCreate() {
            super.onCreate();
            try {
                startForeground(TinkerPatchService.f40750b, new Notification());
            } catch (Throwable th2) {
                ShareTinkerLog.e("Tinker.TinkerPatchService", "InnerService set service for push exception:%s.", th2);
            }
            stopSelf();
        }

        @Override // android.app.Service
        public void onDestroy() {
            stopForeground(true);
            super.onDestroy();
        }

        @Override // android.app.Service
        public int onStartCommand(Intent intent, int i11, int i12) {
            super.onStartCommand(intent, i11, i12);
            return 2;
        }
    }

    public TinkerPatchService() {
        super("TinkerPatchService");
        setIntentRedelivery(true);
    }

    private static void b(Context context, Intent intent) {
        Throwable th2;
        boolean z10;
        a aVar;
        if (!f40752d.compareAndSet(false, true)) {
            ShareTinkerLog.w("Tinker.TinkerPatchService", "TinkerPatchService doApplyPatch is running by another runner.", new Object[0]);
            return;
        }
        try {
            h(context);
            vf.a x10 = vf.a.x(context);
            x10.k().h(intent);
            if (intent == null) {
                ShareTinkerLog.e("Tinker.TinkerPatchService", "TinkerPatchService received a null intent, ignoring.", new Object[0]);
                return;
            }
            String c11 = c(intent);
            if (c11 == null) {
                ShareTinkerLog.e("Tinker.TinkerPatchService", "TinkerPatchService can't get the path extra, ignoring.", new Object[0]);
                return;
            }
            File file = new File(c11);
            boolean e11 = e(intent);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            PatchResult patchResult = new PatchResult();
            try {
                aVar = f40749a;
            } catch (Throwable th3) {
                th2 = th3;
                x10.k().d(file, th2);
                z10 = false;
            }
            if (aVar == null) {
                throw new TinkerRuntimeException("upgradePatchProcessor is null.");
            }
            z10 = aVar.a(context, c11, e11, patchResult);
            th2 = null;
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            x10.k().e(file, z10, elapsedRealtime2);
            patchResult.isSuccess = z10;
            patchResult.rawPatchFilePath = c11;
            patchResult.useEmergencyMode = e11;
            patchResult.totalCostTime = elapsedRealtime2;
            patchResult.type = x10.f() == null ? 0 : 1;
            patchResult.f40747e = th2;
            l(context);
            f40752d.set(false);
            AbstractResultService.b(context, patchResult, d(intent));
        } finally {
            l(context);
        }
    }

    public static String c(Intent intent) {
        if (intent != null) {
            return ShareIntentUtil.getStringExtra(intent, "patch_path_extra");
        }
        throw new TinkerRuntimeException("getPatchPathExtra, but intent is null");
    }

    public static String d(Intent intent) {
        if (intent != null) {
            return ShareIntentUtil.getStringExtra(intent, "patch_result_class");
        }
        throw new TinkerRuntimeException("getPatchResultExtra, but intent is null");
    }

    public static boolean e(Intent intent) {
        if (intent != null) {
            return ShareIntentUtil.getBooleanExtra(intent, "patch_use_emergency_mode", false);
        }
        throw new TinkerRuntimeException("getPatchUseEmergencyMode, but intent is null");
    }

    private void f() {
        if (Build.VERSION.SDK_INT >= 26) {
            ShareTinkerLog.i("Tinker.TinkerPatchService", "for system version >= Android O, we just ignore increasingPriority job to avoid crash or toasts.", new Object[0]);
            return;
        }
        if ("ZUK".equals(Build.MANUFACTURER)) {
            ShareTinkerLog.i("Tinker.TinkerPatchService", "for ZUK device, we just ignore increasingPriority job to avoid crash.", new Object[0]);
            return;
        }
        ShareTinkerLog.i("Tinker.TinkerPatchService", "try to increase patch process priority", new Object[0]);
        try {
            startForeground(f40750b, new Notification());
            startService(new Intent(this, (Class<?>) InnerService.class));
        } catch (Throwable th2) {
            ShareTinkerLog.i("Tinker.TinkerPatchService", "try to increase patch process priority error:" + th2, new Object[0]);
        }
    }

    public static boolean g(Context context) {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        int i11;
        try {
            String b11 = b.b(context);
            if (b11 != null && (activityManager = (ActivityManager) context.getSystemService("activity")) != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && runningAppProcesses.size() != 0) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        i11 = 0;
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.processName.equals(b11)) {
                        i11 = next.pid;
                        break;
                    }
                }
                if (i11 == 0) {
                    return false;
                }
                return new File(SharePatchFileUtil.getPatchDirectory(context), "patch_service_status/running_" + i11).exists();
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    static void h(Context context) {
        File file = new File(SharePatchFileUtil.getPatchDirectory(context), "patch_service_status/running_" + Process.myPid());
        if (file.exists()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile.exists()) {
            File[] listFiles = parentFile.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        } else {
            parentFile.mkdirs();
        }
        try {
            if (!file.createNewFile()) {
                throw new IllegalStateException();
            }
        } catch (Throwable th2) {
            ShareTinkerLog.printErrStackTrace("Tinker.TinkerPatchService", th2, "Fail to create running marker file.", new Object[0]);
        }
    }

    public static void i(Context context, String str) {
        j(context, str, false);
    }

    public static void j(Context context, String str, boolean z10) {
        ShareTinkerLog.i("Tinker.TinkerPatchService", "run patch service...", new Object[0]);
        Intent intent = new Intent(context, (Class<?>) TinkerPatchService.class);
        intent.putExtra("patch_path_extra", str);
        intent.putExtra("patch_use_emergency_mode", z10);
        intent.putExtra("patch_result_class", f40751c.getName());
        try {
            context.startService(intent);
        } catch (Throwable th2) {
            ShareTinkerLog.e("Tinker.TinkerPatchService", "run patch service fail, exception:" + th2, new Object[0]);
        }
    }

    public static void k(a aVar, Class cls) {
        f40749a = aVar;
        f40751c = cls;
        try {
            Class.forName(cls.getName());
        } catch (ClassNotFoundException e11) {
            ShareTinkerLog.printErrStackTrace("Tinker.TinkerPatchService", e11, "patch processor class not found.", new Object[0]);
        }
    }

    static void l(Context context) {
        File file = new File(SharePatchFileUtil.getPatchDirectory(context), "patch_service_status/running_" + Process.myPid());
        if (file.exists()) {
            file.delete();
        }
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        f();
        b(this, intent);
    }
}

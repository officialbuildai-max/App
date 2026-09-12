package wf;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Process;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.util.List;

/* loaded from: classes5.dex */
public class b extends ShareTinkerInternals {

    /* renamed from: a, reason: collision with root package name */
    private static String f77785a;

    private static String a(Context context, Class cls) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) cls), 0).processName;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(Context context) {
        String str = f77785a;
        if (str != null) {
            return str;
        }
        String a11 = a(context, TinkerPatchService.class);
        if (a11 == null) {
            return null;
        }
        f77785a = a11;
        return a11;
    }

    public static boolean c(Context context) {
        String processName = ShareTinkerInternals.getProcessName(context);
        String b11 = b(context);
        if (b11 == null || b11.length() == 0) {
            return false;
        }
        return processName.equals(b11);
    }

    public static boolean d(Context context) {
        return TinkerPatchService.g(context);
    }

    public static void e(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        String b11 = b(context);
        if (b11 == null || (runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) == null) {
            return;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(b11)) {
                Process.killProcess(runningAppProcessInfo.pid);
            }
        }
    }
}

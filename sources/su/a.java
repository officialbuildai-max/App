package su;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import ou.d;

/* loaded from: classes7.dex */
public abstract class a {
    public static boolean a(Context context, d dVar, File file) {
        String md5;
        if (context == null || dVar == null || file == null || !file.exists()) {
            ShareTinkerLog.w("Tinker.PatchGuard", "canApply early-exit: context=%s, info=%s, patchFile=%s, exists=%s", context, dVar, file != null ? file.getAbsolutePath() : "null", Boolean.valueOf(file != null && file.exists()));
            return false;
        }
        if (dVar.i() > 0 && file.length() != dVar.i()) {
            ShareTinkerLog.w("Tinker.PatchGuard", "size mismatch: expected=%d, actual=%d", Long.valueOf(dVar.i()), Long.valueOf(file.length()));
            return false;
        }
        if (dVar.e() != null && dVar.e().length() > 0 && ((md5 = SharePatchFileUtil.getMD5(file)) == null || !dVar.e().equalsIgnoreCase(md5))) {
            ShareTinkerLog.w("Tinker.PatchGuard", "md5 mismatch: expected=%s, actual=%s", dVar.e(), md5);
            return false;
        }
        if (dVar.a() != null && dVar.a().length() > 0 && !dVar.a().equals(context.getPackageName())) {
            ShareTinkerLog.w("Tinker.PatchGuard", "appId mismatch: expected=%s, actual=%s", dVar.a(), context.getPackageName());
            return false;
        }
        int b11 = b(context);
        if (dVar.l() > 0 && b11 < dVar.l()) {
            ShareTinkerLog.w("Tinker.PatchGuard", "versionCode %d < min %d", Integer.valueOf(b11), Integer.valueOf(dVar.l()));
            return false;
        }
        if (dVar.k() <= 0 || b11 <= dVar.k()) {
            return true;
        }
        ShareTinkerLog.w("Tinker.PatchGuard", "versionCode %d > max %d", Integer.valueOf(b11), Integer.valueOf(dVar.k()));
        return false;
    }

    private static int b(Context context) {
        long longVersionCode;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (Build.VERSION.SDK_INT < 28) {
                return packageInfo.versionCode;
            }
            longVersionCode = packageInfo.getLongVersionCode();
            return (int) longVersionCode;
        } catch (Throwable th2) {
            ShareTinkerLog.e("Tinker.PatchGuard", "getVersionCode failed, version range check will be skipped: %s", th2.getMessage());
            return 0;
        }
    }
}

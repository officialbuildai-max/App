package gy;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.InstallSourceInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.transsion.wrapperad.install.appinfo.AppChangeInfo;
import com.transsion.wrapperad.install.open.ChangeType;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f64158a = new c();

    private c() {
    }

    public final AppChangeInfo a(Context context, String packageName, ChangeType type) {
        Object m1185constructorimpl;
        Long valueOf;
        Long l11;
        long longVersionCode;
        Object m1185constructorimpl2;
        String str;
        InstallSourceInfo installSourceInfo;
        String installingPackageName;
        Drawable loadIcon;
        Object m1185constructorimpl3;
        ApplicationInfo applicationInfo;
        CharSequence loadLabel;
        Intrinsics.h(context, "context");
        Intrinsics.h(packageName, "packageName");
        Intrinsics.h(type, "type");
        PackageManager packageManager = context.getPackageManager();
        try {
            Result.Companion companion = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(packageManager.getPackageInfo(packageName, 0));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1191isFailureimpl(m1185constructorimpl)) {
            m1185constructorimpl = null;
        }
        PackageInfo packageInfo = (PackageInfo) m1185constructorimpl;
        ApplicationInfo applicationInfo2 = packageInfo != null ? packageInfo.applicationInfo : null;
        String obj = (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || (loadLabel = applicationInfo.loadLabel(packageManager)) == null) ? null : loadLabel.toString();
        String str2 = packageInfo != null ? packageInfo.versionName : null;
        if (packageInfo == null) {
            l11 = null;
        } else {
            if (Build.VERSION.SDK_INT >= 28) {
                longVersionCode = packageInfo.getLongVersionCode();
                valueOf = Long.valueOf(longVersionCode);
            } else {
                valueOf = Long.valueOf(packageInfo.versionCode);
            }
            l11 = valueOf;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                installSourceInfo = packageManager.getInstallSourceInfo(packageName);
                installingPackageName = installSourceInfo.getInstallingPackageName();
                m1185constructorimpl2 = Result.m1185constructorimpl(installingPackageName);
            } catch (Throwable th3) {
                Result.Companion companion3 = Result.INSTANCE;
                m1185constructorimpl2 = Result.m1185constructorimpl(ResultKt.a(th3));
            }
            if (Result.m1191isFailureimpl(m1185constructorimpl2)) {
                m1185constructorimpl2 = null;
            }
            str = (String) m1185constructorimpl2;
        } else {
            str = packageManager.getInstallerPackageName(packageName);
        }
        String str3 = str;
        if (applicationInfo2 != null) {
            try {
                loadIcon = applicationInfo2.loadIcon(packageManager);
            } catch (Throwable th4) {
                Result.Companion companion4 = Result.INSTANCE;
                m1185constructorimpl3 = Result.m1185constructorimpl(ResultKt.a(th4));
            }
        } else {
            loadIcon = null;
        }
        m1185constructorimpl3 = Result.m1185constructorimpl(loadIcon);
        return new AppChangeInfo(packageName, obj, str2, l11, str3, type, (Drawable) (Result.m1191isFailureimpl(m1185constructorimpl3) ? null : m1185constructorimpl3));
    }
}

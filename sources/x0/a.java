package x0;

import android.content.pm.PackageInfo;
import android.os.Build;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: x0.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0986a {
        static long a(PackageInfo packageInfo) {
            return packageInfo.getLongVersionCode();
        }
    }

    public static long a(PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? C0986a.a(packageInfo) : packageInfo.versionCode;
    }
}

package i4;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.work.t;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    private static final String f65078a;

    static {
        String i11 = t.i("NetworkStateTracker");
        Intrinsics.g(i11, "tagWithPrefix(...)");
        f65078a = i11;
    }

    public static final g a(Context context, j4.c taskExecutor) {
        Intrinsics.h(context, "context");
        Intrinsics.h(taskExecutor, "taskExecutor");
        return Build.VERSION.SDK_INT >= 24 ? new k(context, taskExecutor) : new j(context, taskExecutor);
    }

    public static final androidx.work.impl.constraints.g c(ConnectivityManager connectivityManager, boolean z10) {
        Intrinsics.h(connectivityManager, "connectivityManager");
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return new androidx.work.impl.constraints.g(activeNetworkInfo != null && activeNetworkInfo.isConnected(), d(connectivityManager), androidx.core.net.a.a(connectivityManager), (activeNetworkInfo == null || activeNetworkInfo.isRoaming()) ? false : true, z10);
        } catch (SecurityException e11) {
            t.e().d(f65078a, "Unable to get active network state", e11);
            return new androidx.work.impl.constraints.g(false, false, false, true, z10);
        }
    }

    public static final boolean d(ConnectivityManager connectivityManager) {
        Intrinsics.h(connectivityManager, "<this>");
        try {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities != null) {
                return networkCapabilities.hasCapability(16);
            }
            return false;
        } catch (SecurityException e11) {
            t.e().d(f65078a, "Unable to validate active network", e11);
            return false;
        }
    }
}

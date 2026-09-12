package mc;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.b;
import fc.c;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final Context f69631a;

    /* renamed from: b, reason: collision with root package name */
    private final SharedPreferences f69632b;

    /* renamed from: c, reason: collision with root package name */
    private final c f69633c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f69634d;

    public a(Context context, String str, c cVar) {
        Context a11 = a(context);
        this.f69631a = a11;
        this.f69632b = a11.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f69633c = cVar;
        this.f69634d = c();
    }

    private static Context a(Context context) {
        return Build.VERSION.SDK_INT < 24 ? context : b.createDeviceProtectedStorageContext(context);
    }

    private boolean c() {
        return this.f69632b.contains("firebase_data_collection_default_enabled") ? this.f69632b.getBoolean("firebase_data_collection_default_enabled", true) : d();
    }

    private boolean d() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = this.f69631a.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.f69631a.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_data_collection_default_enabled")) {
                return true;
            }
            return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    public synchronized boolean b() {
        return this.f69634d;
    }
}

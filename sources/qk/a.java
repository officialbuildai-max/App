package qk;

import android.content.Context;
import com.transsion.core.deviceinfo.DeviceInfo;
import com.transsion.core.utils.f;

/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static Context f73758a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f73759b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f73760c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f73761d;

    public static Context a() {
        Context context = f73758a;
        if (context != null) {
            return context;
        }
        throw new NullPointerException("u should init first");
    }

    public static void b(Context context) {
        if (d()) {
            return;
        }
        f73761d = true;
        f73758a = context.getApplicationContext();
        DeviceInfo.d();
        f.a(a());
    }

    public static boolean c() {
        return f73759b;
    }

    public static boolean d() {
        return f73761d && f73758a != null;
    }

    public static boolean e() {
        return f73760c;
    }

    public static void f(boolean z10) {
        f73759b = z10;
    }
}

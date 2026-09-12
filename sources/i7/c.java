package i7;

import android.os.Build;
import android.text.TextUtils;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.h;
import com.hisavana.common.BuildConfig;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static String f65122a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f65123b = null;

    /* renamed from: c, reason: collision with root package name */
    private static int f65124c = 0;

    /* renamed from: d, reason: collision with root package name */
    private static int f65125d = -1;

    /* renamed from: e, reason: collision with root package name */
    private static String f65126e = null;

    /* renamed from: f, reason: collision with root package name */
    private static int f65127f = -1;

    /* renamed from: g, reason: collision with root package name */
    private static int f65128g = -1;

    /* renamed from: h, reason: collision with root package name */
    private static int f65129h = -1;

    /* renamed from: i, reason: collision with root package name */
    private static String f65130i;

    /* renamed from: j, reason: collision with root package name */
    private static String f65131j;

    /* renamed from: k, reason: collision with root package name */
    private static String f65132k;

    /* renamed from: l, reason: collision with root package name */
    private static String f65133l;

    /* renamed from: m, reason: collision with root package name */
    private static String f65134m;

    /* renamed from: n, reason: collision with root package name */
    private static int f65135n;

    /* renamed from: o, reason: collision with root package name */
    private static String f65136o;

    /* renamed from: p, reason: collision with root package name */
    private static String f65137p;

    /* renamed from: q, reason: collision with root package name */
    private static String f65138q;

    /* renamed from: r, reason: collision with root package name */
    private static final AtomicInteger f65139r = new AtomicInteger(0);

    /* renamed from: s, reason: collision with root package name */
    private static final AtomicInteger f65140s = new AtomicInteger(0);

    public static String a() {
        if (TextUtils.isEmpty(f65132k)) {
            f65132k = Build.BRAND;
        }
        return f65132k;
    }

    public static String b() {
        if (TextUtils.isEmpty(f65138q)) {
            f65138q = DeviceUtil.c();
        }
        return f65138q;
    }

    public static String c() {
        if (TextUtils.isEmpty(f65126e)) {
            f65126e = Build.MANUFACTURER;
        }
        return f65126e;
    }

    public static String d() {
        if (DeviceUtil.b(f65130i, f65139r, 1)) {
            String l11 = DeviceUtil.l();
            if (!TextUtils.isEmpty(l11) && l11.length() >= 3) {
                f65130i = l11.substring(0, 3);
            }
        }
        return f65130i;
    }

    public static String e() {
        if (DeviceUtil.b(f65131j, f65140s, 1)) {
            String l11 = DeviceUtil.l();
            if (!TextUtils.isEmpty(l11) && l11.length() >= 3) {
                f65131j = l11.substring(3);
            }
        }
        return f65131j;
    }

    public static String f() {
        if (TextUtils.isEmpty(f65133l)) {
            f65133l = Build.MODEL;
        }
        return f65133l;
    }

    public static int g() {
        if (f65135n == 0) {
            f65135n = DeviceUtil.k();
        }
        return f65135n;
    }

    public static String h() {
        if (TextUtils.isEmpty(f65134m)) {
            f65134m = DeviceUtil.m();
        }
        return f65134m;
    }

    public static int i() {
        if (f65129h == -1) {
            f65129h = (int) h.b();
        }
        return f65129h;
    }

    public static int j() {
        if (f65128g == -1) {
            try {
                f65128g = h.f();
            } catch (Throwable unused) {
            }
        }
        return f65128g;
    }

    public static int k() {
        if (f65127f == -1) {
            try {
                f65127f = h.g();
            } catch (Throwable unused) {
            }
        }
        return f65127f;
    }

    public static String l() {
        if (TextUtils.isEmpty(f65123b)) {
            f65123b = BuildConfig.VERSION_NAME;
        }
        return f65123b;
    }

    public static int m() {
        if (f65124c == 0) {
            f65124c = 360200;
        }
        return f65124c;
    }

    public static String n() {
        if (TextUtils.isEmpty(f65122a)) {
            f65122a = DeviceUtil.o();
        }
        return f65122a;
    }

    public static int o() {
        if (f65125d == -1) {
            f65125d = DeviceUtil.q() ? 2 : 1;
        }
        return f65125d;
    }

    public static String p() {
        if (TextUtils.isEmpty(f65137p)) {
            f65137p = String.valueOf(com.cloud.sdk.commonutil.util.e.e());
        }
        return f65137p;
    }

    public static String q() {
        if (TextUtils.isEmpty(f65136o)) {
            f65136o = String.valueOf(com.cloud.sdk.commonutil.util.e.f());
        }
        return f65136o;
    }
}

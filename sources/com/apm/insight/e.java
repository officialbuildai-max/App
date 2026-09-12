package com.apm.insight;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.apm.insight.runtime.ConfigManager;
import com.apm.insight.runtime.g;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.meituan.android.walle.ChannelReader;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static Context f19536a = null;

    /* renamed from: b, reason: collision with root package name */
    private static Application f19537b = null;

    /* renamed from: c, reason: collision with root package name */
    private static long f19538c = 0;

    /* renamed from: d, reason: collision with root package name */
    private static String f19539d = "default";

    /* renamed from: e, reason: collision with root package name */
    private static boolean f19540e;

    /* renamed from: f, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static com.apm.insight.nativecrash.b f19541f;

    /* renamed from: i, reason: collision with root package name */
    private static volatile ConcurrentHashMap<Integer, String> f19544i;

    /* renamed from: n, reason: collision with root package name */
    private static volatile String f19549n;

    /* renamed from: g, reason: collision with root package name */
    private static ConfigManager f19542g = new ConfigManager();

    /* renamed from: h, reason: collision with root package name */
    private static a f19543h = new a();

    /* renamed from: j, reason: collision with root package name */
    private static g f19545j = null;

    /* renamed from: k, reason: collision with root package name */
    private static volatile String f19546k = null;

    /* renamed from: l, reason: collision with root package name */
    private static Object f19547l = new Object();

    /* renamed from: m, reason: collision with root package name */
    private static volatile int f19548m = 0;

    /* renamed from: o, reason: collision with root package name */
    private static int f19550o = 0;

    /* renamed from: p, reason: collision with root package name */
    private static boolean f19551p = true;

    /* renamed from: q, reason: collision with root package name */
    private static boolean f19552q = true;

    /* renamed from: r, reason: collision with root package name */
    private static boolean f19553r = false;

    /* renamed from: s, reason: collision with root package name */
    private static boolean f19554s = true;

    /* renamed from: t, reason: collision with root package name */
    private static boolean f19555t = true;

    /* renamed from: u, reason: collision with root package name */
    private static boolean f19556u = true;

    public static com.apm.insight.nativecrash.b a() {
        if (f19541f == null) {
            f19541f = g.a(f19536a);
        }
        return f19541f;
    }

    public static String a(long j11, CrashType crashType, boolean z10, boolean z11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(j11);
        sb2.append("_");
        sb2.append(crashType.getName());
        sb2.append('_');
        sb2.append(f());
        sb2.append('_');
        sb2.append(z10 ? "oom_" : "normal_");
        sb2.append(f19538c);
        sb2.append('_');
        sb2.append(z11 ? "ignore_" : "normal_");
        sb2.append(Long.toHexString(new Random().nextLong()));
        sb2.append("G");
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i11, String str) {
        if (f19544i == null) {
            synchronized (e.class) {
                try {
                    if (f19544i == null) {
                        f19544i = new ConcurrentHashMap<>();
                    }
                } finally {
                }
            }
        }
        f19544i.put(Integer.valueOf(i11), str);
    }

    public static void a(Application application) {
        if (application != null) {
            f19537b = application;
        }
    }

    public static void a(Application application, Context context) {
        if (f19537b == null) {
            f19538c = System.currentTimeMillis();
            f19536a = context;
            f19537b = application;
            f19546k = Long.toHexString(new Random().nextLong()) + "G";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Application application, Context context, ICommonParams iCommonParams) {
        a(application, context);
        f19541f = new com.apm.insight.nativecrash.b(f19536a, iCommonParams, a());
    }

    public static void a(com.apm.insight.nativecrash.b bVar) {
        f19541f = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str) {
        f19539d = str;
    }

    public static void a(boolean z10) {
        f19551p = z10;
    }

    public static a b() {
        return f19543h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(int i11, String str) {
        f19548m = i11;
        f19549n = str;
    }

    public static void b(boolean z10) {
        f19552q = z10;
    }

    public static g c() {
        if (f19545j == null) {
            synchronized (e.class) {
                f19545j = new g();
            }
        }
        return f19545j;
    }

    public static void c(boolean z10) {
        f19553r = z10;
    }

    public static void d(boolean z10) {
        f19554s = z10;
    }

    public static boolean d() {
        if (!f19542g.isDebugMode()) {
            return false;
        }
        Object obj = a().a().get(ChannelReader.CHANNEL_KEY);
        return (obj == null ? TmcConstants.ROUTE_UNKNOWN : String.valueOf(obj)).contains("local_test");
    }

    public static String e() {
        return f() + '_' + Long.toHexString(new Random().nextLong()) + "G";
    }

    public static void e(boolean z10) {
        f19556u = z10;
    }

    public static String f() {
        if (f19546k == null) {
            synchronized (f19547l) {
                try {
                    if (f19546k == null) {
                        f19546k = Long.toHexString(new Random().nextLong()) + "U";
                    }
                } finally {
                }
            }
        }
        return f19546k;
    }

    public static void f(boolean z10) {
        f19555t = z10;
    }

    public static Context g() {
        return f19536a;
    }

    public static Application h() {
        return f19537b;
    }

    public static ConfigManager i() {
        return f19542g;
    }

    public static long j() {
        return f19538c;
    }

    public static String k() {
        return f19539d;
    }

    public static void l() {
        f19550o = 1;
    }

    public static int m() {
        return f19550o;
    }

    public static boolean n() {
        return f19540e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void o() {
        f19540e = true;
    }

    public static ConcurrentHashMap<Integer, String> p() {
        return f19544i;
    }

    public static int q() {
        return f19548m;
    }

    public static String r() {
        return f19549n;
    }

    public static boolean s() {
        return f19551p;
    }

    public static boolean t() {
        return f19552q;
    }

    public static boolean u() {
        return f19553r;
    }

    public static boolean v() {
        return f19554s;
    }

    public static boolean w() {
        return f19556u;
    }

    public static boolean x() {
        return f19555t;
    }
}

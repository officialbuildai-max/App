package hi;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f64595a = new f();

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f64596b;

    /* renamed from: c, reason: collision with root package name */
    private static Boolean f64597c;

    /* renamed from: d, reason: collision with root package name */
    private static Boolean f64598d;

    /* renamed from: e, reason: collision with root package name */
    private static Boolean f64599e;

    private f() {
    }

    public final boolean a() {
        if (f64599e == null) {
            f64599e = Boolean.valueOf(com.transsion.ad.strategy.f.f42286a.b().getBoolean("isAdConfigTest", false));
        }
        return Intrinsics.c(f64599e, Boolean.TRUE);
    }

    public final boolean b() {
        Boolean bool = f64597c;
        if (bool == null) {
            Boolean valueOf = Boolean.valueOf(com.transsion.ad.strategy.f.f42286a.b().getBoolean("isDetailRequestLog", false));
            f64597c = valueOf;
            return valueOf.booleanValue();
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final boolean c() {
        return com.transsion.ad.strategy.f.f42286a.b().getBoolean("7uW91v8bQlbz4J4w", false);
    }

    public final Boolean d() {
        if (f64598d == null) {
            f64598d = Boolean.valueOf(com.transsion.ad.strategy.f.f42286a.b().getBoolean("isHitLog", false));
        }
        return f64598d;
    }

    public final boolean e() {
        Boolean bool = f64596b;
        if (bool == null) {
            Boolean valueOf = Boolean.valueOf(com.transsion.ad.strategy.f.f42286a.b().getBoolean("Sk39789136Q8224I", true));
            f64596b = valueOf;
            return valueOf.booleanValue();
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final void f(Boolean bool) {
        if (bool == null) {
            return;
        }
        com.transsion.ad.strategy.f.f42286a.b().putBoolean("isAdConfigTest", bool.booleanValue());
        f64599e = bool;
    }

    public final void g(boolean z10) {
        com.transsion.ad.strategy.f.f42286a.b().putBoolean("isDetailRequestLog", z10);
        f64597c = Boolean.valueOf(z10);
    }

    public final void h(boolean z10) {
        com.transsion.ad.strategy.f.f42286a.b().putBoolean("7uW91v8bQlbz4J4w", z10);
    }

    public final void i(Boolean bool) {
        if (bool == null) {
            return;
        }
        com.transsion.ad.strategy.f.f42286a.b().putBoolean("isHitLog", bool.booleanValue());
        f64598d = bool;
    }

    public final void j(boolean z10) {
        com.transsion.ad.strategy.f.f42286a.b().putBoolean("Sk39789136Q8224I", z10);
        f64596b = Boolean.valueOf(z10);
    }
}

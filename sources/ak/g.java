package ak;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f714a = new g();

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f715b;

    private g() {
    }

    private final boolean a() {
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
        return bVar.b().getBoolean("key_or_content_mode", false) || bVar.b().getInt("key_or_content_mode_local", -1) == 1;
    }

    private final void c(boolean z10) {
        yg.b.f79132a.b("X-Content-Mode", z10 ? "1" : "0");
    }

    private final void d(boolean z10) {
        com.transsion.baselib.report.launch.b.f43424a.b().putBoolean("key_or_content_mode", z10);
    }

    public final boolean b() {
        Boolean bool = f715b;
        if (bool != null) {
            Intrinsics.e(bool);
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(a());
        f715b = valueOf;
        Intrinsics.e(valueOf);
        c(valueOf.booleanValue());
        Boolean bool2 = f715b;
        Intrinsics.e(bool2);
        return bool2.booleanValue();
    }

    public final void e(boolean z10) {
        c(z10);
        f715b = Boolean.valueOf(z10);
        d(z10);
    }
}

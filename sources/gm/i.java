package gm;

import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f64006a = new i();

    private i() {
    }

    public final void a(String tag, String msg) {
        Intrinsics.h(tag, "tag");
        Intrinsics.h(msg, "msg");
        try {
            a.C0856a.f(lg.a.f68962a, "web_log", "<" + tag + ">: " + msg, false, 4, null);
        } catch (Throwable unused) {
        }
    }

    public final void b(String tag, String msg) {
        Intrinsics.h(tag, "tag");
        Intrinsics.h(msg, "msg");
        try {
            a.C0856a.l(lg.a.f68962a, "web_log", "<" + tag + ">: " + msg, false, 4, null);
        } catch (Throwable unused) {
        }
    }

    public final void c(String msg) {
        Intrinsics.h(msg, "msg");
        try {
            a.C0856a.f(lg.a.f68962a, "web_log", msg, false, 4, null);
        } catch (Throwable unused) {
        }
    }

    public final void d(String msg) {
        Intrinsics.h(msg, "msg");
        try {
            a.C0856a.l(lg.a.f68962a, "web_log", msg, false, 4, null);
        } catch (Throwable unused) {
        }
    }

    public final void e(String msg) {
        Intrinsics.h(msg, "msg");
        try {
            a.C0856a.z(lg.a.f68962a, "web_log", msg, false, 4, null);
        } catch (Throwable unused) {
        }
    }

    public final void f(String tag, String msg) {
        Intrinsics.h(tag, "tag");
        Intrinsics.h(msg, "msg");
        try {
            a.C0856a.z(lg.a.f68962a, "web_log", "<" + tag + ">: " + msg, false, 4, null);
        } catch (Throwable unused) {
        }
    }
}

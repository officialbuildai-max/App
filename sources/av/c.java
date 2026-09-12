package av;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f16229a = new c();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f16230b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f16231c;

    /* renamed from: d, reason: collision with root package name */
    private static Function0 f16232d;

    /* renamed from: e, reason: collision with root package name */
    private static Function0 f16233e;

    private c() {
    }

    public final boolean a() {
        return f16233e != null;
    }

    public final boolean b() {
        return f16232d != null;
    }

    public final boolean c() {
        return f16231c;
    }

    public final boolean d() {
        return f16230b;
    }

    public final void e() {
        f16231c = false;
        Function0 function0 = f16233e;
        if (function0 != null) {
            function0.invoke();
        }
        f16233e = null;
    }

    public final void f() {
        f16230b = false;
        Function0 function0 = f16232d;
        if (function0 != null) {
            function0.invoke();
        }
        f16232d = null;
    }

    public final void g(Function0 callback) {
        Intrinsics.h(callback, "callback");
        f16233e = callback;
    }

    public final void h(Function0 callback) {
        Intrinsics.h(callback, "callback");
        f16232d = callback;
    }

    public final void i() {
        f16231c = true;
    }

    public final void j() {
        f16230b = true;
    }
}

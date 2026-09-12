package ys;

import android.app.Application;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import zs.b;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f79179a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static tt.a f79180b;

    private a() {
    }

    public final void a(Function0 createFactory) {
        Intrinsics.h(createFactory, "createFactory");
        if (f79180b == null) {
            lg.a.f68962a.c("ShortTv", "checkCreateFactory, null create", true);
            f79180b = (tt.a) createFactory.invoke();
        }
    }

    public final tt.a b() {
        return f79180b;
    }

    public final void c(Application application, tt.a factory) {
        Intrinsics.h(application, "application");
        Intrinsics.h(factory, "factory");
        f79180b = factory;
        application.registerActivityLifecycleCallbacks(b.f79576a);
        kt.b.f68514a.c(application);
        wt.b.f78072a.b().init();
    }
}

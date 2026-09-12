package lr;

import android.app.Application;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    private static rs.a f69155b;

    /* renamed from: a, reason: collision with root package name */
    public static final c f69154a = new c();

    /* renamed from: c, reason: collision with root package name */
    private static b f69156c = b.f69144e.a();

    private c() {
    }

    public final void a(Function0 createFactory) {
        Intrinsics.h(createFactory, "createFactory");
        if (f69155b == null) {
            lg.a.f68962a.c("ShortTv", "checkCreateFactory, null create", true);
            f69155b = (rs.a) createFactory.invoke();
        }
    }

    public final b b() {
        return f69156c;
    }

    public final rs.a c() {
        return f69155b;
    }

    public final void d(Application application, rs.a factory) {
        Intrinsics.h(application, "application");
        Intrinsics.h(factory, "factory");
        f69155b = factory;
        application.registerActivityLifecycleCallbacks(vr.b.f77564a);
        fs.b.f62582a.c(application);
        com.transsnet.flow.event.b bVar = com.transsnet.flow.event.b.f60377a;
        if (bVar.b() == null) {
            bVar.c(application);
        }
        com.transsion.shorttv.subtitle.manager.b.f53144a.b().init();
    }
}

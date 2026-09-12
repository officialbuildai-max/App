package com.therouter;

import a.TheRouterServiceProvideInjecter;
import android.app.Application;
import android.content.Context;
import com.therouter.inject.DebugOnlyKt;
import com.therouter.inject.RouterInject;
import com.therouter.router.Navigator;
import com.therouter.router.RouteMapKt;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class TheRouter {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f40759b;

    /* renamed from: a, reason: collision with root package name */
    public static final TheRouter f40758a = new TheRouter();

    /* renamed from: c, reason: collision with root package name */
    private static final LinkedList f40760c = new LinkedList();

    /* renamed from: d, reason: collision with root package name */
    private static final RouterInject f40761d = new RouterInject();

    /* renamed from: e, reason: collision with root package name */
    private static Function2 f40762e = new Function2<String, String, Unit>() { // from class: com.therouter.TheRouter$logCat$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((String) obj, (String) obj2);
            return Unit.f67184a;
        }

        public final void invoke(String str, String str2) {
            Intrinsics.h(str, "<anonymous parameter 0>");
            Intrinsics.h(str2, "<anonymous parameter 1>");
        }
    };

    /* renamed from: f, reason: collision with root package name */
    private static final yf.b f40763f = new yf.b();

    private TheRouter() {
    }

    public static final Navigator c(String str) {
        return new Navigator(str);
    }

    public static final Object d(Class clazz, Object... params) {
        Intrinsics.h(clazz, "clazz");
        Intrinsics.h(params, "params");
        return f40761d.e(clazz, Arrays.copyOf(params, params.length));
    }

    public static final Function2 f() {
        return f40762e;
    }

    public static final LinkedList g() {
        return f40760c;
    }

    public static final RouterInject h() {
        return f40761d;
    }

    public static final void i(Context context) {
        j(context, true);
    }

    public static final void j(final Context context, boolean z10) {
        boolean z11;
        z11 = TheRouterKt.f40764a;
        if (z11) {
            return;
        }
        TheRouterKt.d("init", "TheRouter init start!", null, 4, null);
        f40763f.c(context);
        if (z10) {
            f40761d.b(context);
        } else {
            f40761d.g(context);
        }
        RouteMapKt.f(context);
        TheRouterThreadPool.f(new Runnable() { // from class: com.therouter.d
            @Override // java.lang.Runnable
            public final void run() {
                TheRouter.k(context);
            }
        });
        TheRouterKt.d("init", "TheRouter init finish!", null, 4, null);
        TheRouterKt.f40764a = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.f(applicationContext, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext).registerActivityLifecycleCallbacks(f.f40783a);
        }
        LinkedList linkedList = f40760c;
        linkedList.addFirst(new ag.b());
        linkedList.addFirst(new ag.c());
        linkedList.addFirst(new ag.d());
        linkedList.addFirst(new ag.a());
    }

    public static final void l(Object obj) {
        TheRouterServiceProvideInjecter.b(obj);
        if (TheRouterServiceProvideInjecter.asm || obj == null) {
            return;
        }
        for (Map.Entry entry : DebugOnlyKt.b().entrySet()) {
            if (((Class) entry.getKey()).isInstance(obj)) {
                ((Method) entry.getValue()).invoke(null, obj);
            }
        }
    }

    public static final boolean m() {
        return f40759b;
    }

    public static final void n(final String taskName) {
        Intrinsics.h(taskName, "taskName");
        yf.b bVar = f40763f;
        if (bVar.h()) {
            bVar.i(taskName).g();
        } else {
            bVar.b(new Runnable() { // from class: com.therouter.e
                @Override // java.lang.Runnable
                public final void run() {
                    TheRouter.o(taskName);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(String taskName) {
        Intrinsics.h(taskName, "$taskName");
        f40763f.i(taskName).g();
    }

    public static final void p(boolean z10) {
        f40759b = z10;
    }

    public final yf.b e() {
        return f40763f;
    }
}

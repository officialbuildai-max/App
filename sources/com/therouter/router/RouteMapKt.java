package com.therouter.router;

import a.TheRouterServiceProvideInjecter;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.therouter.TheRouter;
import com.therouter.TheRouterKt;
import com.therouter.TheRouterThreadPool;
import com.therouter.inject.DebugOnlyKt;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public abstract class RouteMapKt {

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f40830b;

    /* renamed from: a, reason: collision with root package name */
    private static final RegexpKeyedMap f40829a = new RegexpKeyedMap();

    /* renamed from: c, reason: collision with root package name */
    private static final Gson f40831c = new Gson();

    public static final void c(RouteItem routeItem) {
        Intrinsics.h(routeItem, "routeItem");
        if (Intrinsics.c(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            d(routeItem);
            return;
        }
        synchronized (f40829a) {
            d(routeItem);
        }
    }

    private static final void d(RouteItem routeItem) {
        String path = routeItem.getPath();
        if (StringsKt.G(path, "/", false, 2, null)) {
            path = path.substring(0, path.length() - 1);
            Intrinsics.g(path, "substring(...)");
        }
        TheRouterKt.f("addRouteItem", "add " + path, null, 4, null);
        f40829a.put(path, routeItem);
    }

    public static final void e(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            c((RouteItem) it.next());
        }
    }

    public static final void f(final Context context) {
        TheRouterThreadPool.f(new Runnable() { // from class: com.therouter.router.h
            @Override // java.lang.Runnable
            public final void run() {
                RouteMapKt.g(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Context context) {
        TheRouterKt.d("RouteMap", "will be add route map from： initDefaultRouteMap()", null, 4, null);
        TheRouterServiceProvideInjecter.c();
        if (!TheRouterServiceProvideInjecter.asm) {
            DebugOnlyKt.a(context);
            Iterator it = DebugOnlyKt.c().iterator();
            while (it.hasNext()) {
                ((d) it.next()).init();
            }
        }
        f40830b = true;
        j();
        TheRouterThreadPool.g(new Runnable() { // from class: com.therouter.router.i
            @Override // java.lang.Runnable
            public final void run() {
                RouteMapKt.h();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h() {
        NavigatorKt.k();
    }

    public static final boolean i() {
        return f40830b;
    }

    public static final void j() {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(a.a(com.therouter.c.c(), com.therouter.a.a()), Charset.forName("UTF-8"));
            try {
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    StringBuilder sb2 = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb2.append(readLine);
                        sb2.append("\n");
                    }
                    String sb3 = sb2.toString();
                    Intrinsics.g(sb3, "toString(...)");
                    TheRouterKt.d("RouteMap", "will be add route map from assets: " + sb3, null, 4, null);
                    if (!TextUtils.isEmpty(sb3)) {
                        Object fromJson = f40831c.fromJson(sb3, new TypeToken<List<? extends RouteItem>>() { // from class: com.therouter.router.RouteMapKt$initRouteMap$1$1$list$1
                        }.getType());
                        Intrinsics.g(fromJson, "fromJson(...)");
                        e((List) fromJson);
                    }
                    Unit unit = Unit.f67184a;
                    CloseableKt.a(bufferedReader, null);
                    CloseableKt.a(inputStreamReader, null);
                } finally {
                }
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.a(inputStreamReader, th2);
                    throw th3;
                }
            }
        } catch (Exception e11) {
            TheRouterKt.c("RouteMap", "initRouteMap InputStreamReader error", new Function0<Unit>() { // from class: com.therouter.router.RouteMapKt$initRouteMap$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m857invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m857invoke() {
                    e11.printStackTrace();
                }
            });
        }
    }

    public static final RouteItem k(String str) {
        RouteItem l11;
        if (Intrinsics.c(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            return l(str);
        }
        synchronized (f40829a) {
            l11 = l(str);
        }
        return l11;
    }

    private static final RouteItem l(String str) {
        if (str == null) {
            str = "";
        }
        String o11 = TheRouter.c(str).o();
        if (StringsKt.G(o11, "/", false, 2, null)) {
            o11 = o11.substring(0, o11.length() - 1);
            Intrinsics.g(o11, "substring(...)");
        }
        RouteItem routeItem = (RouteItem) f40829a.get((Object) o11);
        RouteItem copy = routeItem != null ? routeItem.copy() : null;
        if (copy != null) {
            copy.setPath(o11);
        }
        return copy;
    }
}

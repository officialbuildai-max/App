package com.therouter.router;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class NavigatorKt {

    /* renamed from: a, reason: collision with root package name */
    private static final LinkedList f40821a = new LinkedList();

    /* renamed from: b, reason: collision with root package name */
    private static final HashMap f40822b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private static final List f40823c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private static final List f40824d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private static final List f40825e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private static bg.c f40826f = new bg.c();

    /* renamed from: g, reason: collision with root package name */
    private static Function2 f40827g = new Function2<RouteItem, Function1<? super RouteItem, ? extends Unit>, Unit>() { // from class: com.therouter.router.NavigatorKt$routerInterceptor$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((RouteItem) obj, (Function1<? super RouteItem, Unit>) obj2);
            return Unit.f67184a;
        }

        public final void invoke(RouteItem route, Function1<? super RouteItem, Unit> callback) {
            Intrinsics.h(route, "route");
            Intrinsics.h(callback, "callback");
            callback.invoke(route);
        }
    };

    public static final void h(bg.e interceptor) {
        Intrinsics.h(interceptor, "interceptor");
        List list = f40824d;
        list.add(interceptor);
        Collections.sort(list, new Comparator() { // from class: com.therouter.router.f
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int i11;
                i11 = NavigatorKt.i((bg.e) obj, (bg.e) obj2);
                return i11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int i(bg.e eVar, bg.e eVar2) {
        if (eVar == null) {
            return -1;
        }
        if (eVar2 == null) {
            return 1;
        }
        return eVar2.a() - eVar.a();
    }

    public static final HashMap j() {
        return f40822b;
    }

    public static final void k() {
        Iterator it = f40821a.iterator();
        while (it.hasNext()) {
            ((g) it.next()).a().invoke();
        }
        f40821a.clear();
    }

    public static final void l(final bg.f interceptor) {
        Intrinsics.h(interceptor, "interceptor");
        f40827g = new Function2<RouteItem, Function1<? super RouteItem, ? extends Unit>, Unit>() { // from class: com.therouter.router.NavigatorKt$setRouterInterceptor$1

            /* loaded from: classes5.dex */
            public static final class a implements bg.b {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Function1 f40828a;

                a(Function1 function1) {
                    this.f40828a = function1;
                }

                @Override // bg.b
                public void a(RouteItem routeItem) {
                    Intrinsics.h(routeItem, "routeItem");
                    this.f40828a.invoke(routeItem);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((RouteItem) obj, (Function1<? super RouteItem, Unit>) obj2);
                return Unit.f67184a;
            }

            public final void invoke(RouteItem route, Function1<? super RouteItem, Unit> callback) {
                Intrinsics.h(route, "route");
                Intrinsics.h(callback, "callback");
                bg.f.this.a(route, new a(callback));
            }
        };
    }
}

package com.therouter.router.action;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.therouter.TheRouterKt;
import com.therouter.TheRouterThreadPool;
import com.therouter.c;
import com.therouter.history.HistoryRecorder;
import com.therouter.router.Navigator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class ActionManager {

    /* renamed from: a, reason: collision with root package name */
    public static final ActionManager f40832a = new ActionManager();

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap f40833b = new ConcurrentHashMap();

    private ActionManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Navigator navigator, Context context) {
        Context context2;
        Intrinsics.h(navigator, "$navigator");
        ArrayList<zf.a> arrayList = new ArrayList();
        List list = (List) f40833b.get(navigator.o());
        CopyOnWriteArrayList copyOnWriteArrayList = list != null ? new CopyOnWriteArrayList(list) : null;
        Bundle bundle = new Bundle();
        if (copyOnWriteArrayList != null) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                zf.a aVar = (zf.a) it.next();
                if (aVar != null) {
                    aVar.d(bundle);
                    HistoryRecorder.c(new com.therouter.history.a(navigator.p()));
                    if (context == null) {
                        context2 = c.c();
                        Intrinsics.e(context2);
                    } else {
                        context2 = context;
                    }
                    boolean b11 = aVar.b(context2, navigator);
                    Bundle a11 = aVar.a();
                    arrayList.add(aVar);
                    if (b11) {
                        bundle = a11;
                        break;
                    }
                    bundle = a11;
                }
            }
        }
        for (zf.a aVar2 : arrayList) {
            aVar2.d(bundle);
            aVar2.c();
        }
    }

    public final void c(final Navigator navigator, final Context context) {
        Intrinsics.h(navigator, "navigator");
        if (TextUtils.isEmpty(navigator.o())) {
            return;
        }
        TheRouterKt.c("ActionManager", "handleAction->" + navigator.p(), new Function0<Unit>() { // from class: com.therouter.router.action.ActionManager$handleAction$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m858invoke();
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m858invoke() {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                Intrinsics.g(stackTrace, "getStackTrace(...)");
                for (StackTraceElement stackTraceElement : stackTrace) {
                    TheRouterKt.d("ActionManager", String.valueOf(stackTraceElement), null, 4, null);
                }
            }
        });
        TheRouterThreadPool.g(new Runnable() { // from class: com.therouter.router.action.a
            @Override // java.lang.Runnable
            public final void run() {
                ActionManager.b(Navigator.this, context);
            }
        });
    }

    public final boolean d(Navigator navigator) {
        Intrinsics.h(navigator, "navigator");
        return f40833b.get(navigator.o()) != null;
    }
}

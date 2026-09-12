package com.therouter.inject;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.therouter.TheRouterKt;
import com.therouter.router.d;
import dalvik.system.DexFile;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public abstract class DebugOnlyKt {

    /* renamed from: a, reason: collision with root package name */
    private static final ArrayList f40795a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private static final ArrayList f40796b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private static final HashMap f40797c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private static volatile int f40798d = -1;

    public static final void a(Context context) {
        Enumeration<String> entries;
        if (context == null || f40798d >= 0) {
            return;
        }
        f40798d = 0;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            Intrinsics.g(applicationInfo, "getApplicationInfo(...)");
            entries = new DexFile(applicationInfo.sourceDir).entries();
        } catch (Exception e11) {
            TheRouterKt.c("RouterInject", "getAllDI error", new Function0<Unit>() { // from class: com.therouter.inject.DebugOnlyKt$getAllDI$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m852invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m852invoke() {
                    e11.printStackTrace();
                }
            });
            return;
        }
        while (entries.hasMoreElements()) {
            String nextElement = entries.nextElement();
            Intrinsics.e(nextElement);
            if (StringsKt.W(nextElement, "a.ServiceProvider__TheRouter__", false, 2, null) && !StringsKt.c0(nextElement, "$", false, 2, null)) {
                try {
                    Class<?> cls = Class.forName(nextElement);
                    if (b.class.isAssignableFrom(cls) && !Intrinsics.c(b.class, cls)) {
                        ArrayList arrayList = f40795a;
                        Object newInstance = cls.newInstance();
                        Intrinsics.f(newInstance, "null cannot be cast to non-null type com.therouter.inject.Interceptor");
                        arrayList.add((b) newInstance);
                    }
                } catch (Exception e12) {
                    TheRouterKt.c("RouterInject", "create class error for " + nextElement, new Function0<Unit>() { // from class: com.therouter.inject.DebugOnlyKt$getAllDI$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m849invoke();
                            return Unit.f67184a;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m849invoke() {
                            e12.printStackTrace();
                        }
                    });
                }
            } else if (StringsKt.W(nextElement, "a.RouterMap__TheRouter__", false, 2, null) && !StringsKt.c0(nextElement, "$", false, 2, null)) {
                try {
                    Class<?> cls2 = Class.forName(nextElement);
                    if (d.class.isAssignableFrom(cls2) && !Intrinsics.c(d.class, cls2)) {
                        ArrayList arrayList2 = f40796b;
                        Object newInstance2 = cls2.newInstance();
                        Intrinsics.f(newInstance2, "null cannot be cast to non-null type com.therouter.router.IRouterMapAPT");
                        arrayList2.add((d) newInstance2);
                    }
                } catch (Exception e13) {
                    TheRouterKt.c("RouterInject", "create class error for " + nextElement, new Function0<Unit>() { // from class: com.therouter.inject.DebugOnlyKt$getAllDI$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m850invoke();
                            return Unit.f67184a;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m850invoke() {
                            e13.printStackTrace();
                        }
                    });
                }
            } else if (StringsKt.G(nextElement, "__TheRouter__Autowired", false, 2, null) && !StringsKt.c0(nextElement, "$", false, 2, null)) {
                try {
                    Class<?> cls3 = Class.forName(nextElement);
                    Class<?> cls4 = Class.forName(StringsKt.Q(nextElement, "__TheRouter__Autowired", "", false, 4, null));
                    HashMap hashMap = f40797c;
                    Intrinsics.e(cls4);
                    Method declaredMethod = cls3.getDeclaredMethod("autowiredInject", Object.class);
                    Intrinsics.g(declaredMethod, "getDeclaredMethod(...)");
                    hashMap.put(cls4, declaredMethod);
                } catch (Exception e14) {
                    TheRouterKt.c("RouterInject", "create class error for " + nextElement, new Function0<Unit>() { // from class: com.therouter.inject.DebugOnlyKt$getAllDI$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m851invoke();
                            return Unit.f67184a;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m851invoke() {
                            e14.printStackTrace();
                        }
                    });
                }
            }
            TheRouterKt.c("RouterInject", "getAllDI error", new Function0<Unit>() { // from class: com.therouter.inject.DebugOnlyKt$getAllDI$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m852invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m852invoke() {
                    e11.printStackTrace();
                }
            });
            return;
        }
        f40798d = 1;
    }

    public static final HashMap b() {
        return f40797c;
    }

    public static final ArrayList c() {
        return f40796b;
    }

    public static final ArrayList d() {
        return f40795a;
    }
}

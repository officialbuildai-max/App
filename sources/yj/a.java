package yj;

import java.util.HashMap;
import java.util.ServiceLoader;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0997a f79145a = new C0997a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final HashMap f79146b = new HashMap();

    /* renamed from: yj.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0997a {
        private C0997a() {
        }

        public /* synthetic */ C0997a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Object a(Class clazz) {
            Intrinsics.h(clazz, "clazz");
            if (a.f79146b.containsKey(clazz.getName())) {
                Object obj = a.f79146b.get(clazz.getName());
                Intrinsics.f(obj, "null cannot be cast to non-null type T of com.transsion.baselib.service.BusinessServiceManager.Companion.getService");
                return obj;
            }
            ServiceLoader load = ServiceLoader.load(clazz);
            if (load.iterator().hasNext()) {
                Object next = load.iterator().next();
                a.f79146b.put(clazz.getName(), next);
                return next;
            }
            a.C0856a.m(lg.a.f68962a, "Service " + clazz + " has not implemented", false, 2, null);
            return null;
        }
    }
}

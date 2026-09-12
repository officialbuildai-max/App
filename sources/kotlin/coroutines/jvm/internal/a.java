package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f67308a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final C0840a f67309b = new C0840a(null, null, null);

    /* renamed from: c, reason: collision with root package name */
    private static C0840a f67310c;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: kotlin.coroutines.jvm.internal.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0840a {

        /* renamed from: a, reason: collision with root package name */
        public final Method f67311a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f67312b;

        /* renamed from: c, reason: collision with root package name */
        public final Method f67313c;

        public C0840a(Method method, Method method2, Method method3) {
            this.f67311a = method;
            this.f67312b = method2;
            this.f67313c = method3;
        }
    }

    private a() {
    }

    private final C0840a a(BaseContinuationImpl baseContinuationImpl) {
        try {
            C0840a c0840a = new C0840a(Class.class.getDeclaredMethod("getModule", null), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
            f67310c = c0840a;
            return c0840a;
        } catch (Exception unused) {
            C0840a c0840a2 = f67309b;
            f67310c = c0840a2;
            return c0840a2;
        }
    }

    public final String b(BaseContinuationImpl continuation) {
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        Intrinsics.h(continuation, "continuation");
        C0840a c0840a = f67310c;
        if (c0840a == null) {
            c0840a = a(continuation);
        }
        if (c0840a == f67309b || (method = c0840a.f67311a) == null || (invoke = method.invoke(continuation.getClass(), null)) == null || (method2 = c0840a.f67312b) == null || (invoke2 = method2.invoke(invoke, null)) == null) {
            return null;
        }
        Method method3 = c0840a.f67313c;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, null) : null;
        if (invoke3 instanceof String) {
            return (String) invoke3;
        }
        return null;
    }
}

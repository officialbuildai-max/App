package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.m2;

/* loaded from: classes.dex */
public abstract class g0 {

    /* renamed from: a, reason: collision with root package name */
    public static final z f67978a = new z("NO_THREAD_ELEMENTS");

    /* renamed from: b, reason: collision with root package name */
    private static final Function2 f67979b = new Function2() { // from class: kotlinx.coroutines.internal.d0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object d11;
            d11 = g0.d(obj, (CoroutineContext.Element) obj2);
            return d11;
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private static final Function2 f67980c = new Function2() { // from class: kotlinx.coroutines.internal.e0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            m2 e11;
            e11 = g0.e((m2) obj, (CoroutineContext.Element) obj2);
            return e11;
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private static final Function2 f67981d = new Function2() { // from class: kotlinx.coroutines.internal.f0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            m0 h11;
            h11 = g0.h((m0) obj, (CoroutineContext.Element) obj2);
            return h11;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object d(Object obj, CoroutineContext.Element element) {
        if (!(element instanceof m2)) {
            return obj;
        }
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        int intValue = num != null ? num.intValue() : 1;
        return intValue == 0 ? element : Integer.valueOf(intValue + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final m2 e(m2 m2Var, CoroutineContext.Element element) {
        if (m2Var != null) {
            return m2Var;
        }
        if (element instanceof m2) {
            return (m2) element;
        }
        return null;
    }

    public static final void f(CoroutineContext coroutineContext, Object obj) {
        if (obj == f67978a) {
            return;
        }
        if (obj instanceof m0) {
            ((m0) obj).b(coroutineContext);
            return;
        }
        Object fold = coroutineContext.fold(null, f67980c);
        Intrinsics.f(fold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((m2) fold).m(coroutineContext, obj);
    }

    public static final Object g(CoroutineContext coroutineContext) {
        Object fold = coroutineContext.fold(0, f67979b);
        Intrinsics.e(fold);
        return fold;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final m0 h(m0 m0Var, CoroutineContext.Element element) {
        if (element instanceof m2) {
            m2 m2Var = (m2) element;
            m0Var.a(m2Var, m2Var.r(m0Var.f67999a));
        }
        return m0Var;
    }

    public static final Object i(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = g(coroutineContext);
        }
        if (obj == 0) {
            return f67978a;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new m0(coroutineContext, ((Number) obj).intValue()), f67981d);
        }
        Intrinsics.f(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((m2) obj).r(coroutineContext);
    }
}

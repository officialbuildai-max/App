package kotlinx.coroutines.flow;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public abstract /* synthetic */ class u {

    /* renamed from: a, reason: collision with root package name */
    private static final Function1 f67948a = new Function1() { // from class: kotlinx.coroutines.flow.s
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            Object d11;
            d11 = u.d(obj);
            return d11;
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private static final Function2 f67949b = new Function2() { // from class: kotlinx.coroutines.flow.t
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            boolean c11;
            c11 = u.c(obj, obj2);
            return Boolean.valueOf(c11);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(Object obj, Object obj2) {
        return Intrinsics.c(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object d(Object obj) {
        return obj;
    }

    public static final b e(b bVar) {
        return bVar instanceof i1 ? bVar : f(bVar, f67948a, f67949b);
    }

    private static final b f(b bVar, Function1 function1, Function2 function2) {
        if (bVar instanceof DistinctFlowImpl) {
            DistinctFlowImpl distinctFlowImpl = (DistinctFlowImpl) bVar;
            if (distinctFlowImpl.f67838b == function1 && distinctFlowImpl.f67839c == function2) {
                return bVar;
            }
        }
        return new DistinctFlowImpl(bVar, function1, function2);
    }
}

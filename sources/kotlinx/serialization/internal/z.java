package kotlinx.serialization.internal;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* loaded from: classes7.dex */
final class z implements j1 {

    /* renamed from: a, reason: collision with root package name */
    private final Function2 f68342a;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap f68343b;

    public z(Function2 compute) {
        Intrinsics.h(compute, "compute");
        this.f68342a = compute;
        this.f68343b = new ConcurrentHashMap();
    }

    @Override // kotlinx.serialization.internal.j1
    public Object a(KClass key, List types) {
        ConcurrentHashMap concurrentHashMap;
        Object m1185constructorimpl;
        Object putIfAbsent;
        Intrinsics.h(key, "key");
        Intrinsics.h(types, "types");
        ConcurrentHashMap concurrentHashMap2 = this.f68343b;
        Class a11 = JvmClassMappingKt.a(key);
        Object obj = concurrentHashMap2.get(a11);
        if (obj == null && (putIfAbsent = concurrentHashMap2.putIfAbsent(a11, (obj = new i1()))) != null) {
            obj = putIfAbsent;
        }
        concurrentHashMap = ((i1) obj).f68277a;
        Object obj2 = concurrentHashMap.get(types);
        if (obj2 == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl((kotlinx.serialization.b) this.f68342a.invoke(key, types));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            Result m1184boximpl = Result.m1184boximpl(m1185constructorimpl);
            Object putIfAbsent2 = concurrentHashMap.putIfAbsent(types, m1184boximpl);
            obj2 = putIfAbsent2 == null ? m1184boximpl : putIfAbsent2;
        }
        Intrinsics.g(obj2, "serializers.getOrPut(typ… { producer() }\n        }");
        return ((Result) obj2).getValue();
    }
}

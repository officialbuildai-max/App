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
final class v implements j1 {

    /* renamed from: a, reason: collision with root package name */
    private final Function2 f68328a;

    /* renamed from: b, reason: collision with root package name */
    private final a f68329b;

    /* loaded from: classes7.dex */
    public static final class a extends ClassValue {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ClassValue
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i1 computeValue(Class type) {
            Intrinsics.h(type, "type");
            return new i1();
        }
    }

    public v(Function2 compute) {
        Intrinsics.h(compute, "compute");
        this.f68328a = compute;
        this.f68329b = b();
    }

    private final a b() {
        return new a();
    }

    @Override // kotlinx.serialization.internal.j1
    public Object a(KClass key, List types) {
        Object obj;
        ConcurrentHashMap concurrentHashMap;
        Object m1185constructorimpl;
        Intrinsics.h(key, "key");
        Intrinsics.h(types, "types");
        obj = this.f68329b.get(JvmClassMappingKt.a(key));
        concurrentHashMap = ((i1) obj).f68277a;
        Object obj2 = concurrentHashMap.get(types);
        if (obj2 == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl((kotlinx.serialization.b) this.f68328a.invoke(key, types));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            Result m1184boximpl = Result.m1184boximpl(m1185constructorimpl);
            Object putIfAbsent = concurrentHashMap.putIfAbsent(types, m1184boximpl);
            obj2 = putIfAbsent == null ? m1184boximpl : putIfAbsent;
        }
        Intrinsics.g(obj2, "serializers.getOrPut(typ… { producer() }\n        }");
        return ((Result) obj2).getValue();
    }
}

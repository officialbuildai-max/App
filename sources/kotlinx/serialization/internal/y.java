package kotlinx.serialization.internal;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* loaded from: classes7.dex */
final class y implements x1 {

    /* renamed from: a, reason: collision with root package name */
    private final Function1 f68336a;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap f68337b;

    public y(Function1 compute) {
        Intrinsics.h(compute, "compute");
        this.f68336a = compute;
        this.f68337b = new ConcurrentHashMap();
    }

    @Override // kotlinx.serialization.internal.x1
    public kotlinx.serialization.b a(KClass key) {
        Object putIfAbsent;
        Intrinsics.h(key, "key");
        ConcurrentHashMap concurrentHashMap = this.f68337b;
        Class a11 = JvmClassMappingKt.a(key);
        Object obj = concurrentHashMap.get(a11);
        if (obj == null && (putIfAbsent = concurrentHashMap.putIfAbsent(a11, (obj = new m((kotlinx.serialization.b) this.f68336a.invoke(key))))) != null) {
            obj = putIfAbsent;
        }
        return ((m) obj).f68291a;
    }
}

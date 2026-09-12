package kotlinx.serialization;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.internal.j1;
import kotlinx.serialization.internal.o;
import kotlinx.serialization.internal.x1;

/* loaded from: classes7.dex */
public abstract class SerializersCacheKt {

    /* renamed from: a, reason: collision with root package name */
    private static final x1 f68148a = o.a(new Function1<KClass<?>, b>() { // from class: kotlinx.serialization.SerializersCacheKt$SERIALIZERS_CACHE$1
        @Override // kotlin.jvm.functions.Function1
        public final b invoke(KClass<?> it) {
            Intrinsics.h(it, "it");
            return h.d(it);
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private static final x1 f68149b = o.a(new Function1<KClass<?>, b>() { // from class: kotlinx.serialization.SerializersCacheKt$SERIALIZERS_CACHE_NULLABLE$1
        @Override // kotlin.jvm.functions.Function1
        public final b invoke(KClass<?> it) {
            b s11;
            Intrinsics.h(it, "it");
            b d11 = h.d(it);
            if (d11 == null || (s11 = d00.a.s(d11)) == null) {
                return null;
            }
            return s11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private static final j1 f68150c = o.b(new Function2<KClass<Object>, List<? extends KType>, b>() { // from class: kotlinx.serialization.SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE$1
        @Override // kotlin.jvm.functions.Function2
        public final b invoke(KClass<Object> clazz, List<? extends KType> types) {
            Intrinsics.h(clazz, "clazz");
            Intrinsics.h(types, "types");
            List e11 = h.e(f00.d.a(), types, true);
            Intrinsics.e(e11);
            return h.a(clazz, types, e11);
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private static final j1 f68151d = o.b(new Function2<KClass<Object>, List<? extends KType>, b>() { // from class: kotlinx.serialization.SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1
        @Override // kotlin.jvm.functions.Function2
        public final b invoke(KClass<Object> clazz, List<? extends KType> types) {
            b s11;
            Intrinsics.h(clazz, "clazz");
            Intrinsics.h(types, "types");
            List e11 = h.e(f00.d.a(), types, true);
            Intrinsics.e(e11);
            b a11 = h.a(clazz, types, e11);
            if (a11 == null || (s11 = d00.a.s(a11)) == null) {
                return null;
            }
            return s11;
        }
    });

    public static final b a(KClass clazz, boolean z10) {
        Intrinsics.h(clazz, "clazz");
        if (z10) {
            return f68149b.a(clazz);
        }
        b a11 = f68148a.a(clazz);
        if (a11 != null) {
            return a11;
        }
        return null;
    }

    public static final Object b(KClass clazz, List types, boolean z10) {
        Intrinsics.h(clazz, "clazz");
        Intrinsics.h(types, "types");
        return !z10 ? f68150c.a(clazz, types) : f68151d.a(clazz, types);
    }
}

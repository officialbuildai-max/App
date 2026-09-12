package kotlinx.serialization.internal;

import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class t implements x1 {

    /* renamed from: a, reason: collision with root package name */
    private final Function1 f68320a;

    /* renamed from: b, reason: collision with root package name */
    private final a f68321b;

    /* loaded from: classes7.dex */
    public static final class a extends ClassValue {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ClassValue
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public m computeValue(Class type) {
            Intrinsics.h(type, "type");
            return new m((kotlinx.serialization.b) t.this.f68320a.invoke(JvmClassMappingKt.c(type)));
        }
    }

    public t(Function1 compute) {
        Intrinsics.h(compute, "compute");
        this.f68320a = compute;
        this.f68321b = c();
    }

    private final a c() {
        return new a();
    }

    @Override // kotlinx.serialization.internal.x1
    public kotlinx.serialization.b a(KClass key) {
        Object obj;
        Intrinsics.h(key, "key");
        obj = this.f68321b.get(JvmClassMappingKt.a(key));
        return ((m) obj).f68291a;
    }
}

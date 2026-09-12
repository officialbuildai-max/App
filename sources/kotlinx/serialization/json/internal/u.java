package kotlinx.serialization.json.internal;

import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    private final Map f68466a = t.a(1);

    /* loaded from: classes7.dex */
    public static final class a {
    }

    public final Object a(kotlinx.serialization.descriptors.f descriptor, a key) {
        Intrinsics.h(descriptor, "descriptor");
        Intrinsics.h(key, "key");
        Map map = (Map) this.f68466a.get(descriptor);
        Object obj = map != null ? map.get(key) : null;
        if (obj == null) {
            return null;
        }
        return obj;
    }

    public final Object b(kotlinx.serialization.descriptors.f descriptor, a key, Function0 defaultValue) {
        Intrinsics.h(descriptor, "descriptor");
        Intrinsics.h(key, "key");
        Intrinsics.h(defaultValue, "defaultValue");
        Object a11 = a(descriptor, key);
        if (a11 != null) {
            return a11;
        }
        Object invoke = defaultValue.invoke();
        c(descriptor, key, invoke);
        return invoke;
    }

    public final void c(kotlinx.serialization.descriptors.f descriptor, a key, Object value) {
        Intrinsics.h(descriptor, "descriptor");
        Intrinsics.h(key, "key");
        Intrinsics.h(value, "value");
        Map map = this.f68466a;
        Object obj = map.get(descriptor);
        if (obj == null) {
            obj = t.a(1);
            map.put(descriptor, obj);
        }
        ((Map) obj).put(key, value);
    }
}

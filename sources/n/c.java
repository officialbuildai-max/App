package n;

import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashMap f70177a;

    public c() {
        this(0, 0.0f, 3, null);
    }

    public c(int i11, float f11) {
        this.f70177a = new LinkedHashMap(i11, f11, true);
    }

    public /* synthetic */ c(int i11, float f11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 16 : i11, (i12 & 2) != 0 ? 0.75f : f11);
    }

    public final Object a(Object key) {
        Intrinsics.h(key, "key");
        return this.f70177a.get(key);
    }

    public final Set b() {
        Set entrySet = this.f70177a.entrySet();
        Intrinsics.g(entrySet, "map.entries");
        return entrySet;
    }

    public final boolean c() {
        return this.f70177a.isEmpty();
    }

    public final Object d(Object key, Object value) {
        Intrinsics.h(key, "key");
        Intrinsics.h(value, "value");
        return this.f70177a.put(key, value);
    }

    public final Object e(Object key) {
        Intrinsics.h(key, "key");
        return this.f70177a.remove(key);
    }
}

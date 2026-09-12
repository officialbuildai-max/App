package kotlinx.serialization.json;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    private final Map f68482a = new LinkedHashMap();

    @PublishedApi
    public s() {
    }

    public final JsonObject a() {
        return new JsonObject(this.f68482a);
    }

    public final h b(String key, h element) {
        Intrinsics.h(key, "key");
        Intrinsics.h(element, "element");
        return (h) this.f68482a.put(key, element);
    }
}

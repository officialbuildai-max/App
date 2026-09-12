package ep;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f62095a = new c();

    /* renamed from: b, reason: collision with root package name */
    private static final Map f62096b = new LinkedHashMap();

    private c() {
    }

    public final void a() {
        f62096b.clear();
    }

    public final Long b(String postId) {
        Intrinsics.h(postId, "postId");
        return (Long) f62096b.remove(postId);
    }

    public final void c(String postId, long j11) {
        Intrinsics.h(postId, "postId");
        f62096b.put(postId, Long.valueOf(j11));
    }
}

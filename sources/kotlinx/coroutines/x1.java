package kotlinx.coroutines;

/* loaded from: classes7.dex */
public abstract class x1 {

    /* renamed from: a, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.z f68128a = new kotlinx.coroutines.internal.z("COMPLETING_ALREADY");

    /* renamed from: b, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.z f68129b = new kotlinx.coroutines.internal.z("COMPLETING_WAITING_CHILDREN");

    /* renamed from: c, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.z f68130c = new kotlinx.coroutines.internal.z("COMPLETING_RETRY");

    /* renamed from: d, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.z f68131d = new kotlinx.coroutines.internal.z("TOO_LATE_TO_CANCEL");

    /* renamed from: e, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.z f68132e = new kotlinx.coroutines.internal.z("SEALED");

    /* renamed from: f, reason: collision with root package name */
    private static final d1 f68133f = new d1(false);

    /* renamed from: g, reason: collision with root package name */
    private static final d1 f68134g = new d1(true);

    public static final Object g(Object obj) {
        return obj instanceof p1 ? new q1((p1) obj) : obj;
    }

    public static final Object h(Object obj) {
        p1 p1Var;
        q1 q1Var = obj instanceof q1 ? (q1) obj : null;
        return (q1Var == null || (p1Var = q1Var.f68033a) == null) ? obj : p1Var;
    }
}

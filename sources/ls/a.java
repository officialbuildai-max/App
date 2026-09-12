package ls;

import qs.c;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f69157a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static c f69158b;

    private a() {
    }

    private final c a() {
        c cVar = f69158b;
        if (cVar == null) {
            rs.a c11 = lr.c.f69154a.c();
            cVar = c11 != null ? c11.k() : null;
            f69158b = cVar;
        }
        return cVar;
    }

    public final String b() {
        return d() ? "/ugc_shorts/detail" : "/shorts/detail";
    }

    public final String c() {
        return d() ? "/ugc_shorts/favorite" : "/shorts/favorite";
    }

    public final boolean d() {
        c a11 = a();
        if (a11 != null) {
            return a11.a();
        }
        return false;
    }
}

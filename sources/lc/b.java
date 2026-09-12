package lc;

/* loaded from: classes5.dex */
public class b implements a {

    /* renamed from: a, reason: collision with root package name */
    private static b f68928a;

    private b() {
    }

    public static b a() {
        if (f68928a == null) {
            f68928a = new b();
        }
        return f68928a;
    }

    @Override // lc.a
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}

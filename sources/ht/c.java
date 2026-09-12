package ht;

/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f64961a = new c();

    /* renamed from: b, reason: collision with root package name */
    private static long f64962b;

    /* renamed from: c, reason: collision with root package name */
    private static int f64963c;

    private c() {
    }

    public final boolean a(int i11, long j11) {
        if (f64963c != i11) {
            f64963c = i11;
            f64962b = System.currentTimeMillis();
            return false;
        }
        if (System.currentTimeMillis() - f64962b <= j11) {
            return true;
        }
        f64963c = i11;
        f64962b = System.currentTimeMillis();
        return false;
    }
}

package ds;

/* loaded from: classes7.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f61551a = new d();

    /* renamed from: b, reason: collision with root package name */
    private static long f61552b;

    /* renamed from: c, reason: collision with root package name */
    private static int f61553c;

    private d() {
    }

    public final boolean a(int i11, long j11) {
        if (f61553c != i11) {
            f61553c = i11;
            f61552b = System.currentTimeMillis();
            return false;
        }
        if (System.currentTimeMillis() - f61552b <= j11) {
            return true;
        }
        f61553c = i11;
        f61552b = System.currentTimeMillis();
        return false;
    }
}

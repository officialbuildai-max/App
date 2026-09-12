package h10;

/* loaded from: classes7.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    protected final int f64199a;

    /* renamed from: b, reason: collision with root package name */
    protected f f64200b;

    public f(int i11) {
        this(i11, null);
    }

    public f(int i11, f fVar) {
        if (i11 != 393216 && i11 != 327680 && i11 != 262144 && i11 != 458752) {
            throw new IllegalArgumentException();
        }
        this.f64199a = i11;
        this.f64200b = fVar;
    }

    public abstract void a(int i11, int i12, String str, String str2, String str3, String[] strArr);

    public abstract a b(String str, boolean z10);

    public abstract void c(c cVar);

    public abstract void d();

    public abstract l e(int i11, String str, String str2, String str3, Object obj);

    public abstract void f(String str, String str2, String str3, int i11);

    public abstract r g(int i11, String str, String str2, String str3, String[] strArr);

    public abstract t h(String str, int i11, String str2);

    public abstract void i(String str);

    public abstract void j(String str);

    public abstract void k(String str, String str2, String str3);

    public abstract void l(String str, String str2);

    public abstract a m(int i11, z zVar, String str, boolean z10);
}

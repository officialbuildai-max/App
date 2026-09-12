package xu;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f78561a;

    /* renamed from: b, reason: collision with root package name */
    public final int f78562b;

    /* renamed from: c, reason: collision with root package name */
    public final long f78563c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f78564d;

    public b(boolean z10, int i11, long j11) {
        this(z10, i11, j11, i11 <= 1);
    }

    public b(boolean z10, int i11, long j11, boolean z11) {
        this.f78561a = z10;
        this.f78562b = Math.max(1, i11);
        this.f78563c = Math.max(1L, j11);
        this.f78564d = z11;
    }

    public static b a() {
        ou.a s11 = ou.a.s();
        return new b(true, s11.v(), s11.w());
    }
}

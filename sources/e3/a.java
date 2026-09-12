package e3;

import l2.i0;

/* loaded from: classes2.dex */
final class a extends l2.i implements g {

    /* renamed from: h, reason: collision with root package name */
    private final long f61621h;

    /* renamed from: i, reason: collision with root package name */
    private final int f61622i;

    /* renamed from: j, reason: collision with root package name */
    private final int f61623j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f61624k;

    /* renamed from: l, reason: collision with root package name */
    private final long f61625l;

    public a(long j11, long j12, int i11, int i12, boolean z10) {
        super(j11, j12, i11, i12, z10);
        this.f61621h = j12;
        this.f61622i = i11;
        this.f61623j = i12;
        this.f61624k = z10;
        this.f61625l = j11 == -1 ? -1L : j11;
    }

    public a(long j11, long j12, i0.a aVar, boolean z10) {
        this(j11, j12, aVar.f68734f, aVar.f68731c, z10);
    }

    @Override // e3.g
    public long a() {
        return this.f61625l;
    }

    public a e(long j11) {
        return new a(j11, this.f61621h, this.f61622i, this.f61623j, this.f61624k);
    }

    @Override // e3.g
    public int g() {
        return this.f61622i;
    }

    @Override // e3.g
    public long getTimeUs(long j11) {
        return c(j11);
    }
}

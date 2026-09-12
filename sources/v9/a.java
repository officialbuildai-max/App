package v9;

import com.google.android.exoplayer2.o1;

/* loaded from: classes4.dex */
public abstract class a extends n {

    /* renamed from: k, reason: collision with root package name */
    public final long f77228k;

    /* renamed from: l, reason: collision with root package name */
    public final long f77229l;

    /* renamed from: m, reason: collision with root package name */
    private c f77230m;

    /* renamed from: n, reason: collision with root package name */
    private int[] f77231n;

    public a(com.google.android.exoplayer2.upstream.k kVar, com.google.android.exoplayer2.upstream.n nVar, o1 o1Var, int i11, Object obj, long j11, long j12, long j13, long j14, long j15) {
        super(kVar, nVar, o1Var, i11, obj, j11, j12, j15);
        this.f77228k = j13;
        this.f77229l = j14;
    }

    public final int g(int i11) {
        return ((int[]) com.google.android.exoplayer2.util.a.i(this.f77231n))[i11];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final c h() {
        return (c) com.google.android.exoplayer2.util.a.i(this.f77230m);
    }

    public void i(c cVar) {
        this.f77230m = cVar;
        this.f77231n = cVar.a();
    }
}

package h2;

import androidx.media3.common.r;

/* loaded from: classes2.dex */
public abstract class a extends m {

    /* renamed from: k, reason: collision with root package name */
    public final long f64389k;

    /* renamed from: l, reason: collision with root package name */
    public final long f64390l;

    /* renamed from: m, reason: collision with root package name */
    private c f64391m;

    /* renamed from: n, reason: collision with root package name */
    private int[] f64392n;

    public a(androidx.media3.datasource.a aVar, w1.h hVar, r rVar, int i11, Object obj, long j11, long j12, long j13, long j14, long j15) {
        super(aVar, hVar, rVar, i11, obj, j11, j12, j15);
        this.f64389k = j13;
        this.f64390l = j14;
    }

    public final int g(int i11) {
        return ((int[]) androidx.media3.common.util.a.i(this.f64392n))[i11];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final c h() {
        return (c) androidx.media3.common.util.a.i(this.f64391m);
    }

    public void i(c cVar) {
        this.f64391m = cVar;
        this.f64392n = cVar.a();
    }
}

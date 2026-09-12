package v9;

import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.upstream.i0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import v9.g;

/* loaded from: classes4.dex */
public final class m extends f {

    /* renamed from: j, reason: collision with root package name */
    private final g f77302j;

    /* renamed from: k, reason: collision with root package name */
    private g.b f77303k;

    /* renamed from: l, reason: collision with root package name */
    private long f77304l;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f77305m;

    public m(com.google.android.exoplayer2.upstream.k kVar, com.google.android.exoplayer2.upstream.n nVar, o1 o1Var, int i11, Object obj, g gVar) {
        super(kVar, nVar, 2, o1Var, i11, obj, C.TIME_UNSET, C.TIME_UNSET);
        this.f77302j = gVar;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void cancelLoad() {
        this.f77305m = true;
    }

    public void e(g.b bVar) {
        this.f77303k = bVar;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void load() {
        if (this.f77304l == 0) {
            this.f77302j.e(this.f77303k, C.TIME_UNSET, C.TIME_UNSET);
        }
        try {
            com.google.android.exoplayer2.upstream.n e11 = this.f77256b.e(this.f77304l);
            i0 i0Var = this.f77263i;
            g9.f fVar = new g9.f(i0Var, e11.f27497g, i0Var.a(e11));
            while (!this.f77305m && this.f77302j.a(fVar)) {
                try {
                } finally {
                    this.f77304l = fVar.getPosition() - this.f77256b.f27497g;
                }
            }
        } finally {
            com.google.android.exoplayer2.upstream.m.a(this.f77263i);
        }
    }
}

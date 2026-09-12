package s3;

import androidx.media3.common.r;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;
import java.util.List;
import l2.s0;
import s3.l0;

/* loaded from: classes2.dex */
public final class l implements m {

    /* renamed from: a, reason: collision with root package name */
    private final List f75157a;

    /* renamed from: b, reason: collision with root package name */
    private final String f75158b;

    /* renamed from: c, reason: collision with root package name */
    private final s0[] f75159c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f75160d;

    /* renamed from: e, reason: collision with root package name */
    private int f75161e;

    /* renamed from: f, reason: collision with root package name */
    private int f75162f;

    /* renamed from: g, reason: collision with root package name */
    private long f75163g = C.TIME_UNSET;

    public l(List list, String str) {
        this.f75157a = list;
        this.f75158b = str;
        this.f75159c = new s0[list.size()];
    }

    private boolean e(androidx.media3.common.util.j0 j0Var, int i11) {
        if (j0Var.a() == 0) {
            return false;
        }
        if (j0Var.H() != i11) {
            this.f75160d = false;
        }
        this.f75161e--;
        return this.f75160d;
    }

    @Override // s3.m
    public void a(androidx.media3.common.util.j0 j0Var) {
        if (this.f75160d) {
            if (this.f75161e != 2 || e(j0Var, 32)) {
                if (this.f75161e != 1 || e(j0Var, 0)) {
                    int f11 = j0Var.f();
                    int a11 = j0Var.a();
                    for (s0 s0Var : this.f75159c) {
                        j0Var.W(f11);
                        s0Var.b(j0Var, a11);
                    }
                    this.f75162f += a11;
                }
            }
        }
    }

    @Override // s3.m
    public void b(long j11, int i11) {
        if ((i11 & 4) == 0) {
            return;
        }
        this.f75160d = true;
        this.f75163g = j11;
        this.f75162f = 0;
        this.f75161e = 2;
    }

    @Override // s3.m
    public void c(boolean z10) {
        if (this.f75160d) {
            androidx.media3.common.util.a.g(this.f75163g != C.TIME_UNSET);
            for (s0 s0Var : this.f75159c) {
                s0Var.d(this.f75163g, 1, this.f75162f, 0, null);
            }
            this.f75160d = false;
        }
    }

    @Override // s3.m
    public void d(l2.t tVar, l0.d dVar) {
        for (int i11 = 0; i11 < this.f75159c.length; i11++) {
            l0.a aVar = (l0.a) this.f75157a.get(i11);
            dVar.a();
            s0 track = tVar.track(dVar.c(), 3);
            track.c(new r.b().f0(dVar.b()).U(this.f75158b).u0(MimeTypes.APPLICATION_DVBSUBS).g0(Collections.singletonList(aVar.f75166c)).j0(aVar.f75164a).N());
            this.f75159c[i11] = track;
        }
    }

    @Override // s3.m
    public void seek() {
        this.f75160d = false;
        this.f75163g = C.TIME_UNSET;
    }
}

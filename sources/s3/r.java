package s3;

import androidx.media3.common.r;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import l2.s0;
import s3.l0;

/* loaded from: classes2.dex */
public final class r implements m {

    /* renamed from: a, reason: collision with root package name */
    private final String f75309a;

    /* renamed from: c, reason: collision with root package name */
    private s0 f75311c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f75312d;

    /* renamed from: f, reason: collision with root package name */
    private int f75314f;

    /* renamed from: g, reason: collision with root package name */
    private int f75315g;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.media3.common.util.j0 f75310b = new androidx.media3.common.util.j0(10);

    /* renamed from: e, reason: collision with root package name */
    private long f75313e = C.TIME_UNSET;

    public r(String str) {
        this.f75309a = str;
    }

    @Override // s3.m
    public void a(androidx.media3.common.util.j0 j0Var) {
        androidx.media3.common.util.a.i(this.f75311c);
        if (this.f75312d) {
            int a11 = j0Var.a();
            int i11 = this.f75315g;
            if (i11 < 10) {
                int min = Math.min(a11, 10 - i11);
                System.arraycopy(j0Var.e(), j0Var.f(), this.f75310b.e(), this.f75315g, min);
                if (this.f75315g + min == 10) {
                    this.f75310b.W(0);
                    if (73 != this.f75310b.H() || 68 != this.f75310b.H() || 51 != this.f75310b.H()) {
                        androidx.media3.common.util.u.h("Id3Reader", "Discarding invalid ID3 tag");
                        this.f75312d = false;
                        return;
                    } else {
                        this.f75310b.X(3);
                        this.f75314f = this.f75310b.G() + 10;
                    }
                }
            }
            int min2 = Math.min(a11, this.f75314f - this.f75315g);
            this.f75311c.b(j0Var, min2);
            this.f75315g += min2;
        }
    }

    @Override // s3.m
    public void b(long j11, int i11) {
        if ((i11 & 4) == 0) {
            return;
        }
        this.f75312d = true;
        this.f75313e = j11;
        this.f75314f = 0;
        this.f75315g = 0;
    }

    @Override // s3.m
    public void c(boolean z10) {
        int i11;
        androidx.media3.common.util.a.i(this.f75311c);
        if (this.f75312d && (i11 = this.f75314f) != 0 && this.f75315g == i11) {
            androidx.media3.common.util.a.g(this.f75313e != C.TIME_UNSET);
            this.f75311c.d(this.f75313e, 1, this.f75314f, 0, null);
            this.f75312d = false;
        }
    }

    @Override // s3.m
    public void d(l2.t tVar, l0.d dVar) {
        dVar.a();
        s0 track = tVar.track(dVar.c(), 5);
        this.f75311c = track;
        track.c(new r.b().f0(dVar.b()).U(this.f75309a).u0(MimeTypes.APPLICATION_ID3).N());
    }

    @Override // s3.m
    public void seek() {
        this.f75312d = false;
        this.f75313e = C.TIME_UNSET;
    }
}

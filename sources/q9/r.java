package q9;

import com.google.android.exoplayer2.o1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import q9.i0;

/* loaded from: classes4.dex */
public final class r implements m {

    /* renamed from: b, reason: collision with root package name */
    private g9.e0 f73592b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f73593c;

    /* renamed from: e, reason: collision with root package name */
    private int f73595e;

    /* renamed from: f, reason: collision with root package name */
    private int f73596f;

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.d0 f73591a = new com.google.android.exoplayer2.util.d0(10);

    /* renamed from: d, reason: collision with root package name */
    private long f73594d = C.TIME_UNSET;

    @Override // q9.m
    public void a(com.google.android.exoplayer2.util.d0 d0Var) {
        com.google.android.exoplayer2.util.a.i(this.f73592b);
        if (this.f73593c) {
            int a11 = d0Var.a();
            int i11 = this.f73596f;
            if (i11 < 10) {
                int min = Math.min(a11, 10 - i11);
                System.arraycopy(d0Var.d(), d0Var.e(), this.f73591a.d(), this.f73596f, min);
                if (this.f73596f + min == 10) {
                    this.f73591a.P(0);
                    if (73 != this.f73591a.D() || 68 != this.f73591a.D() || 51 != this.f73591a.D()) {
                        com.google.android.exoplayer2.util.s.i("Id3Reader", "Discarding invalid ID3 tag");
                        this.f73593c = false;
                        return;
                    } else {
                        this.f73591a.Q(3);
                        this.f73595e = this.f73591a.C() + 10;
                    }
                }
            }
            int min2 = Math.min(a11, this.f73595e - this.f73596f);
            this.f73592b.c(d0Var, min2);
            this.f73596f += min2;
        }
    }

    @Override // q9.m
    public void b(long j11, int i11) {
        if ((i11 & 4) == 0) {
            return;
        }
        this.f73593c = true;
        if (j11 != C.TIME_UNSET) {
            this.f73594d = j11;
        }
        this.f73595e = 0;
        this.f73596f = 0;
    }

    @Override // q9.m
    public void c(g9.n nVar, i0.d dVar) {
        dVar.a();
        g9.e0 track = nVar.track(dVar.c(), 5);
        this.f73592b = track;
        track.e(new o1.b().S(dVar.b()).e0(MimeTypes.APPLICATION_ID3).E());
    }

    @Override // q9.m
    public void packetFinished() {
        int i11;
        com.google.android.exoplayer2.util.a.i(this.f73592b);
        if (this.f73593c && (i11 = this.f73595e) != 0 && this.f73596f == i11) {
            long j11 = this.f73594d;
            if (j11 != C.TIME_UNSET) {
                this.f73592b.d(j11, 1, i11, 0, null);
            }
            this.f73593c = false;
        }
    }

    @Override // q9.m
    public void seek() {
        this.f73593c = false;
        this.f73594d = C.TIME_UNSET;
    }
}

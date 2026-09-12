package q9;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import g9.b0;
import java.util.Map;
import q9.i0;

/* loaded from: classes4.dex */
public final class e implements g9.l {

    /* renamed from: d, reason: collision with root package name */
    public static final g9.r f73342d = new g9.r() { // from class: q9.d
        @Override // g9.r
        public /* synthetic */ g9.l[] c(Uri uri, Map map) {
            return g9.q.a(this, uri, map);
        }

        @Override // g9.r
        public final g9.l[] createExtractors() {
            g9.l[] e11;
            e11 = e.e();
            return e11;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final f f73343a = new f();

    /* renamed from: b, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.d0 f73344b = new com.google.android.exoplayer2.util.d0(16384);

    /* renamed from: c, reason: collision with root package name */
    private boolean f73345c;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ g9.l[] e() {
        return new g9.l[]{new e()};
    }

    @Override // g9.l
    public void b(g9.n nVar) {
        this.f73343a.c(nVar, new i0.d(0, 1));
        nVar.endTracks();
        nVar.d(new b0.b(C.TIME_UNSET));
    }

    @Override // g9.l
    public int c(g9.m mVar, g9.a0 a0Var) {
        int read = mVar.read(this.f73344b.d(), 0, 16384);
        if (read == -1) {
            return -1;
        }
        this.f73344b.P(0);
        this.f73344b.O(read);
        if (!this.f73345c) {
            this.f73343a.b(0L, 4);
            this.f73345c = true;
        }
        this.f73343a.a(this.f73344b);
        return 0;
    }

    @Override // g9.l
    public boolean d(g9.m mVar) {
        com.google.android.exoplayer2.util.d0 d0Var = new com.google.android.exoplayer2.util.d0(10);
        int i11 = 0;
        while (true) {
            mVar.peekFully(d0Var.d(), 0, 10);
            d0Var.P(0);
            if (d0Var.G() != 4801587) {
                break;
            }
            d0Var.Q(3);
            int C = d0Var.C();
            i11 += C + 10;
            mVar.advancePeekPosition(C);
        }
        mVar.resetPeekPosition();
        mVar.advancePeekPosition(i11);
        int i12 = 0;
        int i13 = i11;
        while (true) {
            mVar.peekFully(d0Var.d(), 0, 7);
            d0Var.P(0);
            int J = d0Var.J();
            if (J == 44096 || J == 44097) {
                i12++;
                if (i12 >= 4) {
                    return true;
                }
                int e11 = com.google.android.exoplayer2.audio.c.e(d0Var.d(), J);
                if (e11 == -1) {
                    return false;
                }
                mVar.advancePeekPosition(e11 - 7);
            } else {
                mVar.resetPeekPosition();
                i13++;
                if (i13 - i11 >= 8192) {
                    return false;
                }
                mVar.advancePeekPosition(i13);
                i12 = 0;
            }
        }
    }

    @Override // g9.l
    public void release() {
    }

    @Override // g9.l
    public void seek(long j11, long j12) {
        this.f73345c = false;
        this.f73343a.seek();
    }
}

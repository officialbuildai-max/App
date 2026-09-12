package q9;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import g9.b0;
import java.io.EOFException;
import java.util.Map;
import q9.i0;

/* loaded from: classes4.dex */
public final class h implements g9.l {

    /* renamed from: m, reason: collision with root package name */
    public static final g9.r f73372m = new g9.r() { // from class: q9.g
        @Override // g9.r
        public /* synthetic */ g9.l[] c(Uri uri, Map map) {
            return g9.q.a(this, uri, map);
        }

        @Override // g9.r
        public final g9.l[] createExtractors() {
            g9.l[] h11;
            h11 = h.h();
            return h11;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final int f73373a;

    /* renamed from: b, reason: collision with root package name */
    private final i f73374b;

    /* renamed from: c, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.d0 f73375c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.d0 f73376d;

    /* renamed from: e, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.c0 f73377e;

    /* renamed from: f, reason: collision with root package name */
    private g9.n f73378f;

    /* renamed from: g, reason: collision with root package name */
    private long f73379g;

    /* renamed from: h, reason: collision with root package name */
    private long f73380h;

    /* renamed from: i, reason: collision with root package name */
    private int f73381i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f73382j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f73383k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f73384l;

    public h() {
        this(0);
    }

    public h(int i11) {
        this.f73373a = (i11 & 2) != 0 ? i11 | 1 : i11;
        this.f73374b = new i(true);
        this.f73375c = new com.google.android.exoplayer2.util.d0(2048);
        this.f73381i = -1;
        this.f73380h = -1L;
        com.google.android.exoplayer2.util.d0 d0Var = new com.google.android.exoplayer2.util.d0(10);
        this.f73376d = d0Var;
        this.f73377e = new com.google.android.exoplayer2.util.c0(d0Var.d());
    }

    private void e(g9.m mVar) {
        if (this.f73382j) {
            return;
        }
        this.f73381i = -1;
        mVar.resetPeekPosition();
        long j11 = 0;
        if (mVar.getPosition() == 0) {
            j(mVar);
        }
        int i11 = 0;
        int i12 = 0;
        while (mVar.peekFully(this.f73376d.d(), 0, 2, true)) {
            try {
                this.f73376d.P(0);
                if (!i.k(this.f73376d.J())) {
                    break;
                }
                if (!mVar.peekFully(this.f73376d.d(), 0, 4, true)) {
                    break;
                }
                this.f73377e.p(14);
                int h11 = this.f73377e.h(13);
                if (h11 <= 6) {
                    this.f73382j = true;
                    throw ParserException.createForMalformedContainer("Malformed ADTS stream", null);
                }
                j11 += h11;
                i12++;
                if (i12 != 1000 && mVar.advancePeekPosition(h11 - 6, true)) {
                }
                break;
            } catch (EOFException unused) {
            }
        }
        i11 = i12;
        mVar.resetPeekPosition();
        if (i11 > 0) {
            this.f73381i = (int) (j11 / i11);
        } else {
            this.f73381i = -1;
        }
        this.f73382j = true;
    }

    private static int f(int i11, long j11) {
        return (int) ((i11 * 8000000) / j11);
    }

    private g9.b0 g(long j11, boolean z10) {
        return new g9.e(j11, this.f73380h, f(this.f73381i, this.f73374b.i()), this.f73381i, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ g9.l[] h() {
        return new g9.l[]{new h()};
    }

    private void i(long j11, boolean z10) {
        if (this.f73384l) {
            return;
        }
        boolean z11 = (this.f73373a & 1) != 0 && this.f73381i > 0;
        if (z11 && this.f73374b.i() == C.TIME_UNSET && !z10) {
            return;
        }
        if (!z11 || this.f73374b.i() == C.TIME_UNSET) {
            this.f73378f.d(new b0.b(C.TIME_UNSET));
        } else {
            this.f73378f.d(g(j11, (this.f73373a & 2) != 0));
        }
        this.f73384l = true;
    }

    private int j(g9.m mVar) {
        int i11 = 0;
        while (true) {
            mVar.peekFully(this.f73376d.d(), 0, 10);
            this.f73376d.P(0);
            if (this.f73376d.G() != 4801587) {
                break;
            }
            this.f73376d.Q(3);
            int C = this.f73376d.C();
            i11 += C + 10;
            mVar.advancePeekPosition(C);
        }
        mVar.resetPeekPosition();
        mVar.advancePeekPosition(i11);
        if (this.f73380h == -1) {
            this.f73380h = i11;
        }
        return i11;
    }

    @Override // g9.l
    public void b(g9.n nVar) {
        this.f73378f = nVar;
        this.f73374b.c(nVar, new i0.d(0, 1));
        nVar.endTracks();
    }

    @Override // g9.l
    public int c(g9.m mVar, g9.a0 a0Var) {
        com.google.android.exoplayer2.util.a.i(this.f73378f);
        long length = mVar.getLength();
        int i11 = this.f73373a;
        if ((i11 & 2) != 0 || ((i11 & 1) != 0 && length != -1)) {
            e(mVar);
        }
        int read = mVar.read(this.f73375c.d(), 0, 2048);
        boolean z10 = read == -1;
        i(length, z10);
        if (z10) {
            return -1;
        }
        this.f73375c.P(0);
        this.f73375c.O(read);
        if (!this.f73383k) {
            this.f73374b.b(this.f73379g, 4);
            this.f73383k = true;
        }
        this.f73374b.a(this.f73375c);
        return 0;
    }

    @Override // g9.l
    public boolean d(g9.m mVar) {
        int j11 = j(mVar);
        int i11 = j11;
        int i12 = 0;
        int i13 = 0;
        do {
            mVar.peekFully(this.f73376d.d(), 0, 2);
            this.f73376d.P(0);
            if (i.k(this.f73376d.J())) {
                i12++;
                if (i12 >= 4 && i13 > 188) {
                    return true;
                }
                mVar.peekFully(this.f73376d.d(), 0, 4);
                this.f73377e.p(14);
                int h11 = this.f73377e.h(13);
                if (h11 <= 6) {
                    i11++;
                    mVar.resetPeekPosition();
                    mVar.advancePeekPosition(i11);
                } else {
                    mVar.advancePeekPosition(h11 - 6);
                    i13 += h11;
                }
            } else {
                i11++;
                mVar.resetPeekPosition();
                mVar.advancePeekPosition(i11);
            }
            i12 = 0;
            i13 = 0;
        } while (i11 - j11 < 8192);
        return false;
    }

    @Override // g9.l
    public void release() {
    }

    @Override // g9.l
    public void seek(long j11, long j12) {
        this.f73383k = false;
        this.f73374b.seek();
        this.f73379g = j12;
    }
}

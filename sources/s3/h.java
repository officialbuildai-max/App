package s3;

import android.net.Uri;
import androidx.media3.common.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import i3.s;
import java.io.EOFException;
import java.util.List;
import java.util.Map;
import l2.m0;
import s3.l0;

/* loaded from: classes2.dex */
public final class h implements l2.r {

    /* renamed from: m, reason: collision with root package name */
    public static final l2.x f75059m = new l2.x() { // from class: s3.g
        @Override // l2.x
        public /* synthetic */ l2.x a(s.a aVar) {
            return l2.w.d(this, aVar);
        }

        @Override // l2.x
        public /* synthetic */ l2.x b(int i11) {
            return l2.w.b(this, i11);
        }

        @Override // l2.x
        public /* synthetic */ l2.r[] c(Uri uri, Map map) {
            return l2.w.a(this, uri, map);
        }

        @Override // l2.x
        public final l2.r[] createExtractors() {
            l2.r[] j11;
            j11 = h.j();
            return j11;
        }

        @Override // l2.x
        public /* synthetic */ l2.x d(boolean z10) {
            return l2.w.c(this, z10);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final int f75060a;

    /* renamed from: b, reason: collision with root package name */
    private final i f75061b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.media3.common.util.j0 f75062c;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.media3.common.util.j0 f75063d;

    /* renamed from: e, reason: collision with root package name */
    private final androidx.media3.common.util.i0 f75064e;

    /* renamed from: f, reason: collision with root package name */
    private l2.t f75065f;

    /* renamed from: g, reason: collision with root package name */
    private long f75066g;

    /* renamed from: h, reason: collision with root package name */
    private long f75067h;

    /* renamed from: i, reason: collision with root package name */
    private int f75068i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f75069j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f75070k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f75071l;

    public h() {
        this(0);
    }

    public h(int i11) {
        this.f75060a = (i11 & 2) != 0 ? i11 | 1 : i11;
        this.f75061b = new i(true, MimeTypes.AUDIO_AAC);
        this.f75062c = new androidx.media3.common.util.j0(2048);
        this.f75068i = -1;
        this.f75067h = -1L;
        androidx.media3.common.util.j0 j0Var = new androidx.media3.common.util.j0(10);
        this.f75063d = j0Var;
        this.f75064e = new androidx.media3.common.util.i0(j0Var.e());
    }

    private void g(l2.s sVar) {
        if (this.f75069j) {
            return;
        }
        this.f75068i = -1;
        sVar.resetPeekPosition();
        long j11 = 0;
        if (sVar.getPosition() == 0) {
            l(sVar);
        }
        int i11 = 0;
        int i12 = 0;
        while (sVar.peekFully(this.f75063d.e(), 0, 2, true)) {
            try {
                this.f75063d.W(0);
                if (!i.l(this.f75063d.P())) {
                    break;
                }
                if (!sVar.peekFully(this.f75063d.e(), 0, 4, true)) {
                    break;
                }
                this.f75064e.p(14);
                int h11 = this.f75064e.h(13);
                if (h11 <= 6) {
                    this.f75069j = true;
                    throw ParserException.createForMalformedContainer("Malformed ADTS stream", null);
                }
                j11 += h11;
                i12++;
                if (i12 != 1000 && sVar.advancePeekPosition(h11 - 6, true)) {
                }
                break;
            } catch (EOFException unused) {
            }
        }
        i11 = i12;
        sVar.resetPeekPosition();
        if (i11 > 0) {
            this.f75068i = (int) (j11 / i11);
        } else {
            this.f75068i = -1;
        }
        this.f75069j = true;
    }

    private static int h(int i11, long j11) {
        return (int) ((i11 * 8000000) / j11);
    }

    private l2.m0 i(long j11, boolean z10) {
        return new l2.i(j11, this.f75067h, h(this.f75068i, this.f75061b.j()), this.f75068i, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l2.r[] j() {
        return new l2.r[]{new h()};
    }

    private void k(long j11, boolean z10) {
        if (this.f75071l) {
            return;
        }
        boolean z11 = (this.f75060a & 1) != 0 && this.f75068i > 0;
        if (z11 && this.f75061b.j() == C.TIME_UNSET && !z10) {
            return;
        }
        if (!z11 || this.f75061b.j() == C.TIME_UNSET) {
            this.f75065f.f(new m0.b(C.TIME_UNSET));
        } else {
            this.f75065f.f(i(j11, (this.f75060a & 2) != 0));
        }
        this.f75071l = true;
    }

    private int l(l2.s sVar) {
        int i11 = 0;
        while (true) {
            sVar.peekFully(this.f75063d.e(), 0, 10);
            this.f75063d.W(0);
            if (this.f75063d.K() != 4801587) {
                break;
            }
            this.f75063d.X(3);
            int G = this.f75063d.G();
            i11 += G + 10;
            sVar.advancePeekPosition(G);
        }
        sVar.resetPeekPosition();
        sVar.advancePeekPosition(i11);
        if (this.f75067h == -1) {
            this.f75067h = i11;
        }
        return i11;
    }

    @Override // l2.r
    public void b(l2.t tVar) {
        this.f75065f = tVar;
        this.f75061b.d(tVar, new l0.d(0, 1));
        tVar.endTracks();
    }

    @Override // l2.r
    public int c(l2.s sVar, l2.l0 l0Var) {
        androidx.media3.common.util.a.i(this.f75065f);
        long length = sVar.getLength();
        int i11 = this.f75060a;
        if ((i11 & 2) != 0 || ((i11 & 1) != 0 && length != -1)) {
            g(sVar);
        }
        int read = sVar.read(this.f75062c.e(), 0, 2048);
        boolean z10 = read == -1;
        k(length, z10);
        if (z10) {
            return -1;
        }
        this.f75062c.W(0);
        this.f75062c.V(read);
        if (!this.f75070k) {
            this.f75061b.b(this.f75066g, 4);
            this.f75070k = true;
        }
        this.f75061b.a(this.f75062c);
        return 0;
    }

    @Override // l2.r
    public boolean d(l2.s sVar) {
        int l11 = l(sVar);
        int i11 = l11;
        int i12 = 0;
        int i13 = 0;
        do {
            sVar.peekFully(this.f75063d.e(), 0, 2);
            this.f75063d.W(0);
            if (i.l(this.f75063d.P())) {
                i12++;
                if (i12 >= 4 && i13 > 188) {
                    return true;
                }
                sVar.peekFully(this.f75063d.e(), 0, 4);
                this.f75064e.p(14);
                int h11 = this.f75064e.h(13);
                if (h11 <= 6) {
                    i11++;
                    sVar.resetPeekPosition();
                    sVar.advancePeekPosition(i11);
                } else {
                    sVar.advancePeekPosition(h11 - 6);
                    i13 += h11;
                }
            } else {
                i11++;
                sVar.resetPeekPosition();
                sVar.advancePeekPosition(i11);
            }
            i12 = 0;
            i13 = 0;
        } while (i11 - l11 < 8192);
        return false;
    }

    @Override // l2.r
    public /* synthetic */ l2.r e() {
        return l2.q.b(this);
    }

    @Override // l2.r
    public /* synthetic */ List f() {
        return l2.q.a(this);
    }

    @Override // l2.r
    public void release() {
    }

    @Override // l2.r
    public void seek(long j11, long j12) {
        this.f75070k = false;
        this.f75061b.seek();
        this.f75066g = j12;
    }
}

package s3;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import androidx.media3.common.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import i3.s;
import java.util.List;
import java.util.Map;
import l2.m0;
import s3.l0;

/* loaded from: classes2.dex */
public final class c0 implements l2.r {

    /* renamed from: l, reason: collision with root package name */
    public static final l2.x f75009l = new l2.x() { // from class: s3.b0
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
            l2.r[] g11;
            g11 = c0.g();
            return g11;
        }

        @Override // l2.x
        public /* synthetic */ l2.x d(boolean z10) {
            return l2.w.c(this, z10);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final p0 f75010a;

    /* renamed from: b, reason: collision with root package name */
    private final SparseArray f75011b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.media3.common.util.j0 f75012c;

    /* renamed from: d, reason: collision with root package name */
    private final a0 f75013d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f75014e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f75015f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f75016g;

    /* renamed from: h, reason: collision with root package name */
    private long f75017h;

    /* renamed from: i, reason: collision with root package name */
    private z f75018i;

    /* renamed from: j, reason: collision with root package name */
    private l2.t f75019j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f75020k;

    /* loaded from: classes2.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final m f75021a;

        /* renamed from: b, reason: collision with root package name */
        private final p0 f75022b;

        /* renamed from: c, reason: collision with root package name */
        private final androidx.media3.common.util.i0 f75023c = new androidx.media3.common.util.i0(new byte[64]);

        /* renamed from: d, reason: collision with root package name */
        private boolean f75024d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f75025e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f75026f;

        /* renamed from: g, reason: collision with root package name */
        private int f75027g;

        /* renamed from: h, reason: collision with root package name */
        private long f75028h;

        public a(m mVar, p0 p0Var) {
            this.f75021a = mVar;
            this.f75022b = p0Var;
        }

        private void b() {
            this.f75023c.r(8);
            this.f75024d = this.f75023c.g();
            this.f75025e = this.f75023c.g();
            this.f75023c.r(6);
            this.f75027g = this.f75023c.h(8);
        }

        private void c() {
            this.f75028h = 0L;
            if (this.f75024d) {
                this.f75023c.r(4);
                this.f75023c.r(1);
                this.f75023c.r(1);
                long h11 = (this.f75023c.h(3) << 30) | (this.f75023c.h(15) << 15) | this.f75023c.h(15);
                this.f75023c.r(1);
                if (!this.f75026f && this.f75025e) {
                    this.f75023c.r(4);
                    this.f75023c.r(1);
                    this.f75023c.r(1);
                    this.f75023c.r(1);
                    this.f75022b.b((this.f75023c.h(3) << 30) | (this.f75023c.h(15) << 15) | this.f75023c.h(15));
                    this.f75026f = true;
                }
                this.f75028h = this.f75022b.b(h11);
            }
        }

        public void a(androidx.media3.common.util.j0 j0Var) {
            j0Var.l(this.f75023c.f10470a, 0, 3);
            this.f75023c.p(0);
            b();
            j0Var.l(this.f75023c.f10470a, 0, this.f75027g);
            this.f75023c.p(0);
            c();
            this.f75021a.b(this.f75028h, 4);
            this.f75021a.a(j0Var);
            this.f75021a.c(false);
        }

        public void d() {
            this.f75026f = false;
            this.f75021a.seek();
        }
    }

    public c0() {
        this(new p0(0L));
    }

    public c0(p0 p0Var) {
        this.f75010a = p0Var;
        this.f75012c = new androidx.media3.common.util.j0(4096);
        this.f75011b = new SparseArray();
        this.f75013d = new a0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l2.r[] g() {
        return new l2.r[]{new c0()};
    }

    private void h(long j11) {
        if (this.f75020k) {
            return;
        }
        this.f75020k = true;
        if (this.f75013d.c() == C.TIME_UNSET) {
            this.f75019j.f(new m0.b(this.f75013d.c()));
            return;
        }
        z zVar = new z(this.f75013d.d(), this.f75013d.c(), j11);
        this.f75018i = zVar;
        this.f75019j.f(zVar.b());
    }

    @Override // l2.r
    public void b(l2.t tVar) {
        this.f75019j = tVar;
    }

    @Override // l2.r
    public int c(l2.s sVar, l2.l0 l0Var) {
        m mVar;
        androidx.media3.common.util.a.i(this.f75019j);
        long length = sVar.getLength();
        if (length != -1 && !this.f75013d.e()) {
            return this.f75013d.g(sVar, l0Var);
        }
        h(length);
        z zVar = this.f75018i;
        if (zVar != null && zVar.d()) {
            return this.f75018i.c(sVar, l0Var);
        }
        sVar.resetPeekPosition();
        long peekPosition = length != -1 ? length - sVar.getPeekPosition() : -1L;
        if ((peekPosition != -1 && peekPosition < 4) || !sVar.peekFully(this.f75012c.e(), 0, 4, true)) {
            return -1;
        }
        this.f75012c.W(0);
        int q11 = this.f75012c.q();
        if (q11 == 441) {
            return -1;
        }
        if (q11 == 442) {
            sVar.peekFully(this.f75012c.e(), 0, 10);
            this.f75012c.W(9);
            sVar.skipFully((this.f75012c.H() & 7) + 14);
            return 0;
        }
        if (q11 == 443) {
            sVar.peekFully(this.f75012c.e(), 0, 2);
            this.f75012c.W(0);
            sVar.skipFully(this.f75012c.P() + 6);
            return 0;
        }
        if (((q11 & InputDeviceCompat.SOURCE_ANY) >> 8) != 1) {
            sVar.skipFully(1);
            return 0;
        }
        int i11 = q11 & 255;
        a aVar = (a) this.f75011b.get(i11);
        if (!this.f75014e) {
            if (aVar == null) {
                if (i11 == 189) {
                    mVar = new c("video/mp2p");
                    this.f75015f = true;
                    this.f75017h = sVar.getPosition();
                } else if ((q11 & 224) == 192) {
                    mVar = new t("video/mp2p");
                    this.f75015f = true;
                    this.f75017h = sVar.getPosition();
                } else if ((q11 & 240) == 224) {
                    mVar = new n("video/mp2p");
                    this.f75016g = true;
                    this.f75017h = sVar.getPosition();
                } else {
                    mVar = null;
                }
                if (mVar != null) {
                    mVar.d(this.f75019j, new l0.d(i11, 256));
                    aVar = new a(mVar, this.f75010a);
                    this.f75011b.put(i11, aVar);
                }
            }
            if (sVar.getPosition() > ((this.f75015f && this.f75016g) ? this.f75017h + PlaybackStateCompat.ACTION_PLAY_FROM_URI : PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED)) {
                this.f75014e = true;
                this.f75019j.endTracks();
            }
        }
        sVar.peekFully(this.f75012c.e(), 0, 2);
        this.f75012c.W(0);
        int P = this.f75012c.P() + 6;
        if (aVar == null) {
            sVar.skipFully(P);
        } else {
            this.f75012c.S(P);
            sVar.readFully(this.f75012c.e(), 0, P);
            this.f75012c.W(6);
            aVar.a(this.f75012c);
            androidx.media3.common.util.j0 j0Var = this.f75012c;
            j0Var.V(j0Var.b());
        }
        return 0;
    }

    @Override // l2.r
    public boolean d(l2.s sVar) {
        byte[] bArr = new byte[14];
        sVar.peekFully(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        sVar.advancePeekPosition(bArr[13] & 7);
        sVar.peekFully(bArr, 0, 3);
        return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
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
        boolean z10 = this.f75010a.f() == C.TIME_UNSET;
        if (!z10) {
            long d11 = this.f75010a.d();
            z10 = (d11 == C.TIME_UNSET || d11 == 0 || d11 == j12) ? false : true;
        }
        if (z10) {
            this.f75010a.i(j12);
        }
        z zVar = this.f75018i;
        if (zVar != null) {
            zVar.h(j12);
        }
        for (int i11 = 0; i11 < this.f75011b.size(); i11++) {
            ((a) this.f75011b.valueAt(i11)).d();
        }
    }
}

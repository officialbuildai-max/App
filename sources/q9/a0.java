package q9;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.google.android.exoplayer2.util.l0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import g9.b0;
import java.util.Map;
import q9.i0;

/* loaded from: classes4.dex */
public final class a0 implements g9.l {

    /* renamed from: l, reason: collision with root package name */
    public static final g9.r f73298l = new g9.r() { // from class: q9.z
        @Override // g9.r
        public /* synthetic */ g9.l[] c(Uri uri, Map map) {
            return g9.q.a(this, uri, map);
        }

        @Override // g9.r
        public final g9.l[] createExtractors() {
            g9.l[] e11;
            e11 = a0.e();
            return e11;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final l0 f73299a;

    /* renamed from: b, reason: collision with root package name */
    private final SparseArray f73300b;

    /* renamed from: c, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.d0 f73301c;

    /* renamed from: d, reason: collision with root package name */
    private final y f73302d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f73303e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f73304f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f73305g;

    /* renamed from: h, reason: collision with root package name */
    private long f73306h;

    /* renamed from: i, reason: collision with root package name */
    private x f73307i;

    /* renamed from: j, reason: collision with root package name */
    private g9.n f73308j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f73309k;

    /* loaded from: classes4.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final m f73310a;

        /* renamed from: b, reason: collision with root package name */
        private final l0 f73311b;

        /* renamed from: c, reason: collision with root package name */
        private final com.google.android.exoplayer2.util.c0 f73312c = new com.google.android.exoplayer2.util.c0(new byte[64]);

        /* renamed from: d, reason: collision with root package name */
        private boolean f73313d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f73314e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f73315f;

        /* renamed from: g, reason: collision with root package name */
        private int f73316g;

        /* renamed from: h, reason: collision with root package name */
        private long f73317h;

        public a(m mVar, l0 l0Var) {
            this.f73310a = mVar;
            this.f73311b = l0Var;
        }

        private void b() {
            this.f73312c.r(8);
            this.f73313d = this.f73312c.g();
            this.f73314e = this.f73312c.g();
            this.f73312c.r(6);
            this.f73316g = this.f73312c.h(8);
        }

        private void c() {
            this.f73317h = 0L;
            if (this.f73313d) {
                this.f73312c.r(4);
                this.f73312c.r(1);
                this.f73312c.r(1);
                long h11 = (this.f73312c.h(3) << 30) | (this.f73312c.h(15) << 15) | this.f73312c.h(15);
                this.f73312c.r(1);
                if (!this.f73315f && this.f73314e) {
                    this.f73312c.r(4);
                    this.f73312c.r(1);
                    this.f73312c.r(1);
                    this.f73312c.r(1);
                    this.f73311b.b((this.f73312c.h(3) << 30) | (this.f73312c.h(15) << 15) | this.f73312c.h(15));
                    this.f73315f = true;
                }
                this.f73317h = this.f73311b.b(h11);
            }
        }

        public void a(com.google.android.exoplayer2.util.d0 d0Var) {
            d0Var.j(this.f73312c.f27614a, 0, 3);
            this.f73312c.p(0);
            b();
            d0Var.j(this.f73312c.f27614a, 0, this.f73316g);
            this.f73312c.p(0);
            c();
            this.f73310a.b(this.f73317h, 4);
            this.f73310a.a(d0Var);
            this.f73310a.packetFinished();
        }

        public void d() {
            this.f73315f = false;
            this.f73310a.seek();
        }
    }

    public a0() {
        this(new l0(0L));
    }

    public a0(l0 l0Var) {
        this.f73299a = l0Var;
        this.f73301c = new com.google.android.exoplayer2.util.d0(4096);
        this.f73300b = new SparseArray();
        this.f73302d = new y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ g9.l[] e() {
        return new g9.l[]{new a0()};
    }

    private void f(long j11) {
        if (this.f73309k) {
            return;
        }
        this.f73309k = true;
        if (this.f73302d.c() == C.TIME_UNSET) {
            this.f73308j.d(new b0.b(this.f73302d.c()));
            return;
        }
        x xVar = new x(this.f73302d.d(), this.f73302d.c(), j11);
        this.f73307i = xVar;
        this.f73308j.d(xVar.b());
    }

    @Override // g9.l
    public void b(g9.n nVar) {
        this.f73308j = nVar;
    }

    @Override // g9.l
    public int c(g9.m mVar, g9.a0 a0Var) {
        m mVar2;
        com.google.android.exoplayer2.util.a.i(this.f73308j);
        long length = mVar.getLength();
        if (length != -1 && !this.f73302d.e()) {
            return this.f73302d.g(mVar, a0Var);
        }
        f(length);
        x xVar = this.f73307i;
        if (xVar != null && xVar.d()) {
            return this.f73307i.c(mVar, a0Var);
        }
        mVar.resetPeekPosition();
        long peekPosition = length != -1 ? length - mVar.getPeekPosition() : -1L;
        if ((peekPosition != -1 && peekPosition < 4) || !mVar.peekFully(this.f73301c.d(), 0, 4, true)) {
            return -1;
        }
        this.f73301c.P(0);
        int n11 = this.f73301c.n();
        if (n11 == 441) {
            return -1;
        }
        if (n11 == 442) {
            mVar.peekFully(this.f73301c.d(), 0, 10);
            this.f73301c.P(9);
            mVar.skipFully((this.f73301c.D() & 7) + 14);
            return 0;
        }
        if (n11 == 443) {
            mVar.peekFully(this.f73301c.d(), 0, 2);
            this.f73301c.P(0);
            mVar.skipFully(this.f73301c.J() + 6);
            return 0;
        }
        if (((n11 & InputDeviceCompat.SOURCE_ANY) >> 8) != 1) {
            mVar.skipFully(1);
            return 0;
        }
        int i11 = n11 & 255;
        a aVar = (a) this.f73300b.get(i11);
        if (!this.f73303e) {
            if (aVar == null) {
                if (i11 == 189) {
                    mVar2 = new c();
                    this.f73304f = true;
                    this.f73306h = mVar.getPosition();
                } else if ((n11 & 224) == 192) {
                    mVar2 = new t();
                    this.f73304f = true;
                    this.f73306h = mVar.getPosition();
                } else if ((n11 & 240) == 224) {
                    mVar2 = new n();
                    this.f73305g = true;
                    this.f73306h = mVar.getPosition();
                } else {
                    mVar2 = null;
                }
                if (mVar2 != null) {
                    mVar2.c(this.f73308j, new i0.d(i11, 256));
                    aVar = new a(mVar2, this.f73299a);
                    this.f73300b.put(i11, aVar);
                }
            }
            if (mVar.getPosition() > ((this.f73304f && this.f73305g) ? this.f73306h + PlaybackStateCompat.ACTION_PLAY_FROM_URI : PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED)) {
                this.f73303e = true;
                this.f73308j.endTracks();
            }
        }
        mVar.peekFully(this.f73301c.d(), 0, 2);
        this.f73301c.P(0);
        int J = this.f73301c.J() + 6;
        if (aVar == null) {
            mVar.skipFully(J);
        } else {
            this.f73301c.L(J);
            mVar.readFully(this.f73301c.d(), 0, J);
            this.f73301c.P(6);
            aVar.a(this.f73301c);
            com.google.android.exoplayer2.util.d0 d0Var = this.f73301c;
            d0Var.O(d0Var.b());
        }
        return 0;
    }

    @Override // g9.l
    public boolean d(g9.m mVar) {
        byte[] bArr = new byte[14];
        mVar.peekFully(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        mVar.advancePeekPosition(bArr[13] & 7);
        mVar.peekFully(bArr, 0, 3);
        return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
    }

    @Override // g9.l
    public void release() {
    }

    @Override // g9.l
    public void seek(long j11, long j12) {
        boolean z10 = this.f73299a.e() == C.TIME_UNSET;
        if (!z10) {
            long c11 = this.f73299a.c();
            z10 = (c11 == C.TIME_UNSET || c11 == 0 || c11 == j12) ? false : true;
        }
        if (z10) {
            this.f73299a.g(j12);
        }
        x xVar = this.f73307i;
        if (xVar != null) {
            xVar.h(j12);
        }
        for (int i11 = 0; i11 < this.f73300b.size(); i11++) {
            ((a) this.f73300b.valueAt(i11)).d();
        }
    }
}

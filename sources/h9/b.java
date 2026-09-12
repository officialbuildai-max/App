package h9;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.p0;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import g9.a0;
import g9.b0;
import g9.e;
import g9.e0;
import g9.l;
import g9.m;
import g9.n;
import g9.q;
import g9.r;
import java.io.EOFException;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes4.dex */
public final class b implements l {

    /* renamed from: r, reason: collision with root package name */
    private static final int[] f64510r;

    /* renamed from: u, reason: collision with root package name */
    private static final int f64513u;

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f64514a;

    /* renamed from: b, reason: collision with root package name */
    private final int f64515b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f64516c;

    /* renamed from: d, reason: collision with root package name */
    private long f64517d;

    /* renamed from: e, reason: collision with root package name */
    private int f64518e;

    /* renamed from: f, reason: collision with root package name */
    private int f64519f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f64520g;

    /* renamed from: h, reason: collision with root package name */
    private long f64521h;

    /* renamed from: i, reason: collision with root package name */
    private int f64522i;

    /* renamed from: j, reason: collision with root package name */
    private int f64523j;

    /* renamed from: k, reason: collision with root package name */
    private long f64524k;

    /* renamed from: l, reason: collision with root package name */
    private n f64525l;

    /* renamed from: m, reason: collision with root package name */
    private e0 f64526m;

    /* renamed from: n, reason: collision with root package name */
    private b0 f64527n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f64528o;

    /* renamed from: p, reason: collision with root package name */
    public static final r f64508p = new r() { // from class: h9.a
        @Override // g9.r
        public /* synthetic */ l[] c(Uri uri, Map map) {
            return q.a(this, uri, map);
        }

        @Override // g9.r
        public final l[] createExtractors() {
            l[] l11;
            l11 = b.l();
            return l11;
        }
    };

    /* renamed from: q, reason: collision with root package name */
    private static final int[] f64509q = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};

    /* renamed from: s, reason: collision with root package name */
    private static final byte[] f64511s = p0.n0("#!AMR\n");

    /* renamed from: t, reason: collision with root package name */
    private static final byte[] f64512t = p0.n0("#!AMR-WB\n");

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        f64510r = iArr;
        f64513u = iArr[8];
    }

    public b() {
        this(0);
    }

    public b(int i11) {
        this.f64515b = (i11 & 2) != 0 ? i11 | 1 : i11;
        this.f64514a = new byte[1];
        this.f64522i = -1;
    }

    private void e() {
        com.google.android.exoplayer2.util.a.i(this.f64526m);
        p0.j(this.f64525l);
    }

    private static int f(int i11, long j11) {
        return (int) ((i11 * 8000000) / j11);
    }

    private b0 g(long j11, boolean z10) {
        return new e(j11, this.f64521h, f(this.f64522i, DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT), this.f64522i, z10);
    }

    private int h(int i11) {
        if (j(i11)) {
            return this.f64516c ? f64510r[i11] : f64509q[i11];
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Illegal AMR ");
        sb2.append(this.f64516c ? "WB" : "NB");
        sb2.append(" frame type ");
        sb2.append(i11);
        throw ParserException.createForMalformedContainer(sb2.toString(), null);
    }

    private boolean i(int i11) {
        return !this.f64516c && (i11 < 12 || i11 > 14);
    }

    private boolean j(int i11) {
        return i11 >= 0 && i11 <= 15 && (k(i11) || i(i11));
    }

    private boolean k(int i11) {
        return this.f64516c && (i11 < 10 || i11 > 13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] l() {
        return new l[]{new b()};
    }

    private void m() {
        if (this.f64528o) {
            return;
        }
        this.f64528o = true;
        boolean z10 = this.f64516c;
        this.f64526m.e(new o1.b().e0(z10 ? MimeTypes.AUDIO_AMR_WB : MimeTypes.AUDIO_AMR_NB).W(f64513u).H(1).f0(z10 ? 16000 : 8000).E());
    }

    private void n(long j11, int i11) {
        int i12;
        if (this.f64520g) {
            return;
        }
        int i13 = this.f64515b;
        if ((i13 & 1) == 0 || j11 == -1 || !((i12 = this.f64522i) == -1 || i12 == this.f64518e)) {
            b0.b bVar = new b0.b(C.TIME_UNSET);
            this.f64527n = bVar;
            this.f64525l.d(bVar);
            this.f64520g = true;
            return;
        }
        if (this.f64523j >= 20 || i11 == -1) {
            b0 g11 = g(j11, (i13 & 2) != 0);
            this.f64527n = g11;
            this.f64525l.d(g11);
            this.f64520g = true;
        }
    }

    private static boolean o(m mVar, byte[] bArr) {
        mVar.resetPeekPosition();
        byte[] bArr2 = new byte[bArr.length];
        mVar.peekFully(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    private int p(m mVar) {
        mVar.resetPeekPosition();
        mVar.peekFully(this.f64514a, 0, 1);
        byte b11 = this.f64514a[0];
        if ((b11 & 131) <= 0) {
            return h((b11 >> 3) & 15);
        }
        throw ParserException.createForMalformedContainer("Invalid padding bits for frame header " + ((int) b11), null);
    }

    private boolean q(m mVar) {
        byte[] bArr = f64511s;
        if (o(mVar, bArr)) {
            this.f64516c = false;
            mVar.skipFully(bArr.length);
            return true;
        }
        byte[] bArr2 = f64512t;
        if (!o(mVar, bArr2)) {
            return false;
        }
        this.f64516c = true;
        mVar.skipFully(bArr2.length);
        return true;
    }

    private int r(m mVar) {
        if (this.f64519f == 0) {
            try {
                int p11 = p(mVar);
                this.f64518e = p11;
                this.f64519f = p11;
                if (this.f64522i == -1) {
                    this.f64521h = mVar.getPosition();
                    this.f64522i = this.f64518e;
                }
                if (this.f64522i == this.f64518e) {
                    this.f64523j++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int b11 = this.f64526m.b(mVar, this.f64519f, true);
        if (b11 == -1) {
            return -1;
        }
        int i11 = this.f64519f - b11;
        this.f64519f = i11;
        if (i11 > 0) {
            return 0;
        }
        this.f64526m.d(this.f64524k + this.f64517d, 1, this.f64518e, 0, null);
        this.f64517d += DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT;
        return 0;
    }

    @Override // g9.l
    public void b(n nVar) {
        this.f64525l = nVar;
        this.f64526m = nVar.track(0, 1);
        nVar.endTracks();
    }

    @Override // g9.l
    public int c(m mVar, a0 a0Var) {
        e();
        if (mVar.getPosition() == 0 && !q(mVar)) {
            throw ParserException.createForMalformedContainer("Could not find AMR header.", null);
        }
        m();
        int r11 = r(mVar);
        n(mVar.getLength(), r11);
        return r11;
    }

    @Override // g9.l
    public boolean d(m mVar) {
        return q(mVar);
    }

    @Override // g9.l
    public void release() {
    }

    @Override // g9.l
    public void seek(long j11, long j12) {
        this.f64517d = 0L;
        this.f64518e = 0;
        this.f64519f = 0;
        if (j11 != 0) {
            b0 b0Var = this.f64527n;
            if (b0Var instanceof e) {
                this.f64524k = ((e) b0Var).c(j11);
                return;
            }
        }
        this.f64524k = 0L;
    }
}

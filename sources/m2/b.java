package m2;

import android.net.Uri;
import androidx.media3.common.ParserException;
import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import i3.s;
import java.io.EOFException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import l2.h0;
import l2.i;
import l2.l0;
import l2.m0;
import l2.n;
import l2.q;
import l2.r;
import l2.s0;
import l2.t;
import l2.w;
import l2.x;

/* loaded from: classes2.dex */
public final class b implements r {

    /* renamed from: s, reason: collision with root package name */
    public static final x f69223s = new x() { // from class: m2.a
        @Override // l2.x
        public /* synthetic */ x a(s.a aVar) {
            return w.d(this, aVar);
        }

        @Override // l2.x
        public /* synthetic */ x b(int i11) {
            return w.b(this, i11);
        }

        @Override // l2.x
        public /* synthetic */ r[] c(Uri uri, Map map) {
            return w.a(this, uri, map);
        }

        @Override // l2.x
        public final r[] createExtractors() {
            r[] o11;
            o11 = b.o();
            return o11;
        }

        @Override // l2.x
        public /* synthetic */ x d(boolean z10) {
            return w.c(this, z10);
        }
    };

    /* renamed from: t, reason: collision with root package name */
    private static final int[] f69224t = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};

    /* renamed from: u, reason: collision with root package name */
    private static final int[] f69225u = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};

    /* renamed from: v, reason: collision with root package name */
    private static final byte[] f69226v = a1.u0("#!AMR\n");

    /* renamed from: w, reason: collision with root package name */
    private static final byte[] f69227w = a1.u0("#!AMR-WB\n");

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f69228a;

    /* renamed from: b, reason: collision with root package name */
    private final int f69229b;

    /* renamed from: c, reason: collision with root package name */
    private final s0 f69230c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f69231d;

    /* renamed from: e, reason: collision with root package name */
    private long f69232e;

    /* renamed from: f, reason: collision with root package name */
    private int f69233f;

    /* renamed from: g, reason: collision with root package name */
    private int f69234g;

    /* renamed from: h, reason: collision with root package name */
    private long f69235h;

    /* renamed from: i, reason: collision with root package name */
    private int f69236i;

    /* renamed from: j, reason: collision with root package name */
    private int f69237j;

    /* renamed from: k, reason: collision with root package name */
    private long f69238k;

    /* renamed from: l, reason: collision with root package name */
    private t f69239l;

    /* renamed from: m, reason: collision with root package name */
    private s0 f69240m;

    /* renamed from: n, reason: collision with root package name */
    private s0 f69241n;

    /* renamed from: o, reason: collision with root package name */
    private m0 f69242o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f69243p;

    /* renamed from: q, reason: collision with root package name */
    private long f69244q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f69245r;

    public b() {
        this(0);
    }

    public b(int i11) {
        this.f69229b = (i11 & 2) != 0 ? i11 | 1 : i11;
        this.f69228a = new byte[1];
        this.f69236i = -1;
        n nVar = new n();
        this.f69230c = nVar;
        this.f69241n = nVar;
    }

    private void g() {
        androidx.media3.common.util.a.i(this.f69240m);
        a1.i(this.f69239l);
    }

    private static int h(int i11, long j11) {
        return (int) ((i11 * 8000000) / j11);
    }

    private m0 i(long j11, boolean z10) {
        return new i(j11, this.f69235h, h(this.f69236i, DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT), this.f69236i, z10);
    }

    private int j(int i11) {
        if (m(i11)) {
            return this.f69231d ? f69225u[i11] : f69224t[i11];
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Illegal AMR ");
        sb2.append(this.f69231d ? "WB" : "NB");
        sb2.append(" frame type ");
        sb2.append(i11);
        throw ParserException.createForMalformedContainer(sb2.toString(), null);
    }

    private boolean k(int i11) {
        return !this.f69231d && (i11 < 12 || i11 > 14);
    }

    private boolean l(long j11, long j12) {
        return Math.abs(j12 - j11) < DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT;
    }

    private boolean m(int i11) {
        return i11 >= 0 && i11 <= 15 && (n(i11) || k(i11));
    }

    private boolean n(int i11) {
        return this.f69231d && (i11 < 10 || i11 > 13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ r[] o() {
        return new r[]{new b()};
    }

    private void p() {
        if (this.f69245r) {
            return;
        }
        this.f69245r = true;
        boolean z10 = this.f69231d;
        String str = MimeTypes.AUDIO_AMR_WB;
        String str2 = z10 ? MimeTypes.AUDIO_AMR_WB : "audio/amr";
        if (!z10) {
            str = MimeTypes.AUDIO_AMR_NB;
        }
        this.f69240m.c(new r.b().U(str2).u0(str).k0(z10 ? f69225u[8] : f69224t[7]).R(1).v0(z10 ? 16000 : 8000).N());
    }

    private void q(long j11, int i11) {
        int i12;
        if (this.f69242o != null) {
            return;
        }
        int i13 = this.f69229b;
        if ((i13 & 4) != 0) {
            this.f69242o = new h0(new long[]{this.f69235h}, new long[]{0}, C.TIME_UNSET);
        } else if ((i13 & 1) == 0 || !((i12 = this.f69236i) == -1 || i12 == this.f69233f)) {
            this.f69242o = new m0.b(C.TIME_UNSET);
        } else if (this.f69237j >= 20 || i11 == -1) {
            m0 i14 = i(j11, (i13 & 2) != 0);
            this.f69242o = i14;
            this.f69240m.f(i14.getDurationUs());
        }
        m0 m0Var = this.f69242o;
        if (m0Var != null) {
            this.f69239l.f(m0Var);
        }
    }

    private static boolean r(l2.s sVar, byte[] bArr) {
        sVar.resetPeekPosition();
        byte[] bArr2 = new byte[bArr.length];
        sVar.peekFully(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    private int s(l2.s sVar) {
        sVar.resetPeekPosition();
        sVar.peekFully(this.f69228a, 0, 1);
        byte b11 = this.f69228a[0];
        if ((b11 & 131) <= 0) {
            return j((b11 >> 3) & 15);
        }
        throw ParserException.createForMalformedContainer("Invalid padding bits for frame header " + ((int) b11), null);
    }

    private boolean t(l2.s sVar) {
        byte[] bArr = f69226v;
        if (r(sVar, bArr)) {
            this.f69231d = false;
            sVar.skipFully(bArr.length);
            return true;
        }
        byte[] bArr2 = f69227w;
        if (!r(sVar, bArr2)) {
            return false;
        }
        this.f69231d = true;
        sVar.skipFully(bArr2.length);
        return true;
    }

    private int u(l2.s sVar) {
        if (this.f69234g == 0) {
            try {
                int s11 = s(sVar);
                this.f69233f = s11;
                this.f69234g = s11;
                if (this.f69236i == -1) {
                    this.f69235h = sVar.getPosition();
                    this.f69236i = this.f69233f;
                }
                if (this.f69236i == this.f69233f) {
                    this.f69237j++;
                }
                m0 m0Var = this.f69242o;
                if (m0Var instanceof h0) {
                    h0 h0Var = (h0) m0Var;
                    long j11 = this.f69238k + this.f69232e + DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT;
                    long position = sVar.getPosition() + this.f69233f;
                    if (!h0Var.c(j11, 100000L)) {
                        h0Var.b(j11, position);
                    }
                    if (this.f69243p && l(j11, this.f69244q)) {
                        this.f69243p = false;
                        this.f69241n = this.f69240m;
                    }
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int e11 = this.f69241n.e(sVar, this.f69234g, true);
        if (e11 == -1) {
            return -1;
        }
        int i11 = this.f69234g - e11;
        this.f69234g = i11;
        if (i11 > 0) {
            return 0;
        }
        this.f69241n.d(this.f69238k + this.f69232e, 1, this.f69233f, 0, null);
        this.f69232e += DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT;
        return 0;
    }

    @Override // l2.r
    public void b(t tVar) {
        this.f69239l = tVar;
        s0 track = tVar.track(0, 1);
        this.f69240m = track;
        this.f69241n = track;
        tVar.endTracks();
    }

    @Override // l2.r
    public int c(l2.s sVar, l0 l0Var) {
        g();
        if (sVar.getPosition() == 0 && !t(sVar)) {
            throw ParserException.createForMalformedContainer("Could not find AMR header.", null);
        }
        p();
        int u11 = u(sVar);
        q(sVar.getLength(), u11);
        if (u11 == -1) {
            m0 m0Var = this.f69242o;
            if (m0Var instanceof h0) {
                long j11 = this.f69238k + this.f69232e;
                ((h0) m0Var).d(j11);
                this.f69239l.f(this.f69242o);
                this.f69240m.f(j11);
            }
        }
        return u11;
    }

    @Override // l2.r
    public boolean d(l2.s sVar) {
        return t(sVar);
    }

    @Override // l2.r
    public /* synthetic */ l2.r e() {
        return q.b(this);
    }

    @Override // l2.r
    public /* synthetic */ List f() {
        return q.a(this);
    }

    @Override // l2.r
    public void release() {
    }

    @Override // l2.r
    public void seek(long j11, long j12) {
        this.f69232e = 0L;
        this.f69233f = 0;
        this.f69234g = 0;
        this.f69244q = j12;
        m0 m0Var = this.f69242o;
        if (!(m0Var instanceof h0)) {
            if (j11 == 0 || !(m0Var instanceof i)) {
                this.f69238k = 0L;
                return;
            } else {
                this.f69238k = ((i) m0Var).c(j11);
                return;
            }
        }
        long timeUs = ((h0) m0Var).getTimeUs(j11);
        this.f69238k = timeUs;
        if (l(timeUs, this.f69244q)) {
            return;
        }
        this.f69243p = true;
        this.f69241n = this.f69230c;
    }
}

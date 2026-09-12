package com.google.android.exoplayer2.video;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.l;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.m0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.video.w;
import com.google.android.exoplayer2.y2;
import com.google.android.gms.common.Scopes;
import com.google.common.collect.ImmutableList;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;

/* loaded from: classes3.dex */
public class g extends MediaCodecRenderer {
    private static final int[] G1 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static boolean H1;
    private static boolean I1;
    private float A1;
    private y B1;
    private boolean C1;
    private int D1;
    b E1;
    private i F1;
    private final Context G0;
    private final k H0;
    private final w.a I0;
    private final long J0;
    private final int K0;
    private final boolean L0;
    private a M0;
    private boolean N0;
    private boolean O0;
    private Surface P0;
    private PlaceholderSurface Q0;
    private boolean R0;
    private int S0;
    private boolean T0;
    private boolean U0;
    private boolean V0;
    private long W0;
    private long X0;

    /* renamed from: p1, reason: collision with root package name */
    private long f27908p1;

    /* renamed from: q1, reason: collision with root package name */
    private int f27909q1;

    /* renamed from: r1, reason: collision with root package name */
    private int f27910r1;

    /* renamed from: s1, reason: collision with root package name */
    private int f27911s1;

    /* renamed from: t1, reason: collision with root package name */
    private long f27912t1;

    /* renamed from: u1, reason: collision with root package name */
    private long f27913u1;

    /* renamed from: v1, reason: collision with root package name */
    private long f27914v1;

    /* renamed from: w1, reason: collision with root package name */
    private int f27915w1;

    /* renamed from: x1, reason: collision with root package name */
    private int f27916x1;

    /* renamed from: y1, reason: collision with root package name */
    private int f27917y1;

    /* renamed from: z1, reason: collision with root package name */
    private int f27918z1;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f27919a;

        /* renamed from: b, reason: collision with root package name */
        public final int f27920b;

        /* renamed from: c, reason: collision with root package name */
        public final int f27921c;

        public a(int i11, int i12, int i13) {
            this.f27919a = i11;
            this.f27920b = i12;
            this.f27921c = i13;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class b implements l.c, Handler.Callback {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f27922a;

        public b(com.google.android.exoplayer2.mediacodec.l lVar) {
            Handler x10 = p0.x(this);
            this.f27922a = x10;
            lVar.m(this, x10);
        }

        private void b(long j11) {
            g gVar = g.this;
            if (this != gVar.E1) {
                return;
            }
            if (j11 == Long.MAX_VALUE) {
                gVar.x1();
                return;
            }
            try {
                gVar.w1(j11);
            } catch (ExoPlaybackException e11) {
                g.this.M0(e11);
            }
        }

        @Override // com.google.android.exoplayer2.mediacodec.l.c
        public void a(com.google.android.exoplayer2.mediacodec.l lVar, long j11, long j12) {
            if (p0.f27680a >= 30) {
                b(j11);
            } else {
                this.f27922a.sendMessageAtFrontOfQueue(Message.obtain(this.f27922a, 0, (int) (j11 >> 32), (int) j11));
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b(p0.a1(message.arg1, message.arg2));
            return true;
        }
    }

    public g(Context context, l.b bVar, com.google.android.exoplayer2.mediacodec.o oVar, long j11, boolean z10, Handler handler, w wVar, int i11) {
        this(context, bVar, oVar, j11, z10, handler, wVar, i11, 30.0f);
    }

    public g(Context context, l.b bVar, com.google.android.exoplayer2.mediacodec.o oVar, long j11, boolean z10, Handler handler, w wVar, int i11, float f11) {
        super(2, bVar, oVar, z10, f11);
        this.J0 = j11;
        this.K0 = i11;
        Context applicationContext = context.getApplicationContext();
        this.G0 = applicationContext;
        this.H0 = new k(applicationContext);
        this.I0 = new w.a(handler, wVar);
        this.L0 = d1();
        this.X0 = C.TIME_UNSET;
        this.f27916x1 = -1;
        this.f27917y1 = -1;
        this.A1 = -1.0f;
        this.S0 = 1;
        this.D1 = 0;
        a1();
    }

    private static void B1(com.google.android.exoplayer2.mediacodec.l lVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        lVar.b(bundle);
    }

    private void C1() {
        this.X0 = this.J0 > 0 ? SystemClock.elapsedRealtime() + this.J0 : C.TIME_UNSET;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.h, com.google.android.exoplayer2.video.g] */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.view.Surface] */
    private void D1(Object obj) {
        PlaceholderSurface placeholderSurface = obj instanceof Surface ? (Surface) obj : null;
        if (placeholderSurface == null) {
            PlaceholderSurface placeholderSurface2 = this.Q0;
            if (placeholderSurface2 != null) {
                placeholderSurface = placeholderSurface2;
            } else {
                com.google.android.exoplayer2.mediacodec.m Y = Y();
                if (Y != null && I1(Y)) {
                    placeholderSurface = PlaceholderSurface.newInstanceV17(this.G0, Y.f25458g);
                    this.Q0 = placeholderSurface;
                }
            }
        }
        if (this.P0 == placeholderSurface) {
            if (placeholderSurface == null || placeholderSurface == this.Q0) {
                return;
            }
            u1();
            t1();
            return;
        }
        this.P0 = placeholderSurface;
        this.H0.m(placeholderSurface);
        this.R0 = false;
        int state = getState();
        com.google.android.exoplayer2.mediacodec.l X = X();
        if (X != null) {
            if (p0.f27680a < 23 || placeholderSurface == null || this.N0) {
                E0();
                p0();
            } else {
                E1(X, placeholderSurface);
            }
        }
        if (placeholderSurface == null || placeholderSurface == this.Q0) {
            a1();
            Z0();
            return;
        }
        u1();
        Z0();
        if (state == 2) {
            C1();
        }
    }

    private boolean I1(com.google.android.exoplayer2.mediacodec.m mVar) {
        return p0.f27680a >= 23 && !this.C1 && !b1(mVar.f25452a) && (!mVar.f25458g || PlaceholderSurface.isSecureSupported(this.G0));
    }

    private void Z0() {
        com.google.android.exoplayer2.mediacodec.l X;
        this.T0 = false;
        if (p0.f27680a < 23 || !this.C1 || (X = X()) == null) {
            return;
        }
        this.E1 = new b(X);
    }

    private void a1() {
        this.B1 = null;
    }

    private static void c1(MediaFormat mediaFormat, int i11) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i11);
    }

    private static boolean d1() {
        return "NVIDIA".equals(p0.f27682c);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:395:0x06c5, code lost:
    
        if (r10.equals("A10-70L") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x083b, code lost:
    
        if (r0.equals("AFTN") == false) goto L612;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:41:0x0824. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean f1() {
        /*
            Method dump skipped, instructions count: 3062
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.g.f1():boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x007b, code lost:
    
        if (r9.equals("video/av01") == false) goto L18;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0088. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int g1(com.google.android.exoplayer2.mediacodec.m r11, com.google.android.exoplayer2.o1 r12) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.g.g1(com.google.android.exoplayer2.mediacodec.m, com.google.android.exoplayer2.o1):int");
    }

    private static Point h1(com.google.android.exoplayer2.mediacodec.m mVar, o1 o1Var) {
        int i11 = o1Var.f25556r;
        int i12 = o1Var.f25555q;
        boolean z10 = i11 > i12;
        int i13 = z10 ? i11 : i12;
        if (z10) {
            i11 = i12;
        }
        float f11 = i11 / i13;
        for (int i14 : G1) {
            int i15 = (int) (i14 * f11);
            if (i14 <= i13 || i15 <= i11) {
                break;
            }
            if (p0.f27680a >= 21) {
                int i16 = z10 ? i15 : i14;
                if (!z10) {
                    i14 = i15;
                }
                Point b11 = mVar.b(i16, i14);
                if (mVar.u(b11.x, b11.y, o1Var.f25557s)) {
                    return b11;
                }
            } else {
                try {
                    int l11 = p0.l(i14, 16) * 16;
                    int l12 = p0.l(i15, 16) * 16;
                    if (l11 * l12 <= MediaCodecUtil.N()) {
                        int i17 = z10 ? l12 : l11;
                        if (!z10) {
                            l11 = l12;
                        }
                        return new Point(i17, l11);
                    }
                } catch (MediaCodecUtil.DecoderQueryException unused) {
                }
            }
        }
        return null;
    }

    private static List j1(com.google.android.exoplayer2.mediacodec.o oVar, o1 o1Var, boolean z10, boolean z11) {
        String str = o1Var.f25550l;
        if (str == null) {
            return ImmutableList.of();
        }
        List a11 = oVar.a(str, z10, z11);
        String m11 = MediaCodecUtil.m(o1Var);
        if (m11 == null) {
            return ImmutableList.copyOf((Collection) a11);
        }
        return ImmutableList.builder().l(a11).l(oVar.a(m11, z10, z11)).e();
    }

    protected static int k1(com.google.android.exoplayer2.mediacodec.m mVar, o1 o1Var) {
        if (o1Var.f25551m == -1) {
            return g1(mVar, o1Var);
        }
        int size = o1Var.f25552n.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 += ((byte[]) o1Var.f25552n.get(i12)).length;
        }
        return o1Var.f25551m + i11;
    }

    private static boolean m1(long j11) {
        return j11 < -30000;
    }

    private static boolean n1(long j11) {
        return j11 < -500000;
    }

    private void p1() {
        if (this.f27909q1 > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.I0.n(this.f27909q1, elapsedRealtime - this.f27908p1);
            this.f27909q1 = 0;
            this.f27908p1 = elapsedRealtime;
        }
    }

    private void r1() {
        int i11 = this.f27915w1;
        if (i11 != 0) {
            this.I0.B(this.f27914v1, i11);
            this.f27914v1 = 0L;
            this.f27915w1 = 0;
        }
    }

    private void s1() {
        int i11 = this.f27916x1;
        if (i11 == -1 && this.f27917y1 == -1) {
            return;
        }
        y yVar = this.B1;
        if (yVar != null && yVar.f28063a == i11 && yVar.f28064b == this.f27917y1 && yVar.f28065c == this.f27918z1 && yVar.f28066d == this.A1) {
            return;
        }
        y yVar2 = new y(this.f27916x1, this.f27917y1, this.f27918z1, this.A1);
        this.B1 = yVar2;
        this.I0.D(yVar2);
    }

    private void t1() {
        if (this.R0) {
            this.I0.A(this.P0);
        }
    }

    private void u1() {
        y yVar = this.B1;
        if (yVar != null) {
            this.I0.D(yVar);
        }
    }

    private void v1(long j11, long j12, o1 o1Var) {
        i iVar = this.F1;
        if (iVar != null) {
            iVar.f(j11, j12, o1Var, b0());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x1() {
        L0();
    }

    private void y1() {
        Surface surface = this.P0;
        PlaceholderSurface placeholderSurface = this.Q0;
        if (surface == placeholderSurface) {
            this.P0 = null;
        }
        placeholderSurface.release();
        this.Q0 = null;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean A0(long j11, long j12, com.google.android.exoplayer2.mediacodec.l lVar, ByteBuffer byteBuffer, int i11, int i12, int i13, long j13, boolean z10, boolean z11, o1 o1Var) {
        boolean z12;
        long j14;
        com.google.android.exoplayer2.util.a.e(lVar);
        if (this.W0 == C.TIME_UNSET) {
            this.W0 = j11;
        }
        if (j13 != this.f27912t1) {
            this.H0.h(j13);
            this.f27912t1 = j13;
        }
        long f02 = f0();
        long j15 = j13 - f02;
        if (z10 && !z11) {
            J1(lVar, i11, j15);
            return true;
        }
        double g02 = g0();
        boolean z13 = getState() == 2;
        long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        long j16 = (long) ((j13 - j11) / g02);
        if (z13) {
            j16 -= elapsedRealtime - j12;
        }
        if (this.P0 == this.Q0) {
            if (!m1(j16)) {
                return false;
            }
            J1(lVar, i11, j15);
            L1(j16);
            return true;
        }
        long j17 = elapsedRealtime - this.f27913u1;
        if (this.V0 ? this.T0 : !(z13 || this.U0)) {
            j14 = j17;
            z12 = false;
        } else {
            z12 = true;
            j14 = j17;
        }
        if (this.X0 == C.TIME_UNSET && j11 >= f02 && (z12 || (z13 && H1(j16, j14)))) {
            long nanoTime = System.nanoTime();
            v1(j15, nanoTime, o1Var);
            if (p0.f27680a >= 21) {
                A1(lVar, i11, j15, nanoTime);
            } else {
                z1(lVar, i11, j15);
            }
            L1(j16);
            return true;
        }
        if (z13 && j11 != this.W0) {
            long nanoTime2 = System.nanoTime();
            long b11 = this.H0.b((j16 * 1000) + nanoTime2);
            long j18 = (b11 - nanoTime2) / 1000;
            boolean z14 = this.X0 != C.TIME_UNSET;
            if (F1(j18, j12, z11) && o1(j11, z14)) {
                return false;
            }
            if (G1(j18, j12, z11)) {
                if (z14) {
                    J1(lVar, i11, j15);
                } else {
                    e1(lVar, i11, j15);
                }
                L1(j18);
                return true;
            }
            if (p0.f27680a >= 21) {
                if (j18 < 50000) {
                    v1(j15, b11, o1Var);
                    A1(lVar, i11, j15, b11);
                    L1(j18);
                    return true;
                }
            } else if (j18 < 30000) {
                if (j18 > 11000) {
                    try {
                        Thread.sleep((j18 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        return false;
                    }
                }
                v1(j15, b11, o1Var);
                z1(lVar, i11, j15);
                L1(j18);
                return true;
            }
        }
        return false;
    }

    protected void A1(com.google.android.exoplayer2.mediacodec.l lVar, int i11, long j11, long j12) {
        s1();
        m0.a("releaseOutputBuffer");
        lVar.h(i11, j12);
        m0.c();
        this.f27913u1 = SystemClock.elapsedRealtime() * 1000;
        this.B0.f24933e++;
        this.f27910r1 = 0;
        q1();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected com.google.android.exoplayer2.decoder.g B(com.google.android.exoplayer2.mediacodec.m mVar, o1 o1Var, o1 o1Var2) {
        com.google.android.exoplayer2.decoder.g e11 = mVar.e(o1Var, o1Var2);
        int i11 = e11.f24947e;
        int i12 = o1Var2.f25555q;
        a aVar = this.M0;
        if (i12 > aVar.f27919a || o1Var2.f25556r > aVar.f27920b) {
            i11 |= 256;
        }
        if (k1(mVar, o1Var2) > this.M0.f27921c) {
            i11 |= 64;
        }
        int i13 = i11;
        return new com.google.android.exoplayer2.decoder.g(mVar.f25452a, o1Var, o1Var2, i13 != 0 ? 0 : e11.f24946d, i13);
    }

    protected void E1(com.google.android.exoplayer2.mediacodec.l lVar, Surface surface) {
        lVar.e(surface);
    }

    protected boolean F1(long j11, long j12, boolean z10) {
        return n1(j11) && !z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void G0() {
        super.G0();
        this.f27911s1 = 0;
    }

    protected boolean G1(long j11, long j12, boolean z10) {
        return m1(j11) && !z10;
    }

    protected boolean H1(long j11, long j12) {
        return m1(j11) && j12 > 100000;
    }

    protected void J1(com.google.android.exoplayer2.mediacodec.l lVar, int i11, long j11) {
        m0.a("skipVideoBuffer");
        lVar.k(i11, false);
        m0.c();
        this.B0.f24934f++;
    }

    protected void K1(int i11, int i12) {
        com.google.android.exoplayer2.decoder.e eVar = this.B0;
        eVar.f24936h += i11;
        int i13 = i11 + i12;
        eVar.f24935g += i13;
        this.f27909q1 += i13;
        int i14 = this.f27910r1 + i13;
        this.f27910r1 = i14;
        eVar.f24937i = Math.max(i14, eVar.f24937i);
        int i15 = this.K0;
        if (i15 <= 0 || this.f27909q1 < i15) {
            return;
        }
        p1();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected MediaCodecDecoderException L(Throwable th2, com.google.android.exoplayer2.mediacodec.m mVar) {
        return new MediaCodecVideoDecoderException(th2, mVar, this.P0);
    }

    protected void L1(long j11) {
        this.B0.a(j11);
        this.f27914v1 += j11;
        this.f27915w1++;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean P0(com.google.android.exoplayer2.mediacodec.m mVar) {
        return this.P0 != null || I1(mVar);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int S0(com.google.android.exoplayer2.mediacodec.o oVar, o1 o1Var) {
        boolean z10;
        int i11 = 0;
        if (!com.google.android.exoplayer2.util.w.t(o1Var.f25550l)) {
            return y2.a(0);
        }
        boolean z11 = o1Var.f25553o != null;
        List j12 = j1(oVar, o1Var, z11, false);
        if (z11 && j12.isEmpty()) {
            j12 = j1(oVar, o1Var, false, false);
        }
        if (j12.isEmpty()) {
            return y2.a(1);
        }
        if (!MediaCodecRenderer.T0(o1Var)) {
            return y2.a(2);
        }
        com.google.android.exoplayer2.mediacodec.m mVar = (com.google.android.exoplayer2.mediacodec.m) j12.get(0);
        boolean m11 = mVar.m(o1Var);
        if (!m11) {
            for (int i12 = 1; i12 < j12.size(); i12++) {
                com.google.android.exoplayer2.mediacodec.m mVar2 = (com.google.android.exoplayer2.mediacodec.m) j12.get(i12);
                if (mVar2.m(o1Var)) {
                    z10 = false;
                    m11 = true;
                    mVar = mVar2;
                    break;
                }
            }
        }
        z10 = true;
        int i13 = m11 ? 4 : 3;
        int i14 = mVar.p(o1Var) ? 16 : 8;
        int i15 = mVar.f25459h ? 64 : 0;
        int i16 = z10 ? 128 : 0;
        if (m11) {
            List j13 = j1(oVar, o1Var, z11, true);
            if (!j13.isEmpty()) {
                com.google.android.exoplayer2.mediacodec.m mVar3 = (com.google.android.exoplayer2.mediacodec.m) MediaCodecUtil.u(j13, o1Var).get(0);
                if (mVar3.m(o1Var) && mVar3.p(o1Var)) {
                    i11 = 32;
                }
            }
        }
        return y2.c(i13, i14, i11, i15, i16);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean Z() {
        return this.C1 && p0.f27680a < 23;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected float a0(float f11, o1 o1Var, o1[] o1VarArr) {
        float f12 = -1.0f;
        for (o1 o1Var2 : o1VarArr) {
            float f13 = o1Var2.f25557s;
            if (f13 != -1.0f) {
                f12 = Math.max(f12, f13);
            }
        }
        if (f12 == -1.0f) {
            return -1.0f;
        }
        return f12 * f11;
    }

    protected boolean b1(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (g.class) {
            try {
                if (!H1) {
                    I1 = f1();
                    H1 = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return I1;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected List c0(com.google.android.exoplayer2.mediacodec.o oVar, o1 o1Var, boolean z10) {
        return MediaCodecUtil.u(j1(oVar, o1Var, z10, this.C1), o1Var);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.h, com.google.android.exoplayer2.x2
    public void d(float f11, float f12) {
        super.d(f11, f12);
        this.H0.i(f11);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected l.a e0(com.google.android.exoplayer2.mediacodec.m mVar, o1 o1Var, MediaCrypto mediaCrypto, float f11) {
        PlaceholderSurface placeholderSurface = this.Q0;
        if (placeholderSurface != null && placeholderSurface.secure != mVar.f25458g) {
            y1();
        }
        String str = mVar.f25454c;
        a i12 = i1(mVar, o1Var, n());
        this.M0 = i12;
        MediaFormat l12 = l1(o1Var, str, i12, f11, this.L0, this.C1 ? this.D1 : 0);
        if (this.P0 == null) {
            if (!I1(mVar)) {
                throw new IllegalStateException();
            }
            if (this.Q0 == null) {
                this.Q0 = PlaceholderSurface.newInstanceV17(this.G0, mVar.f25458g);
            }
            this.P0 = this.Q0;
        }
        return l.a.b(mVar, l12, o1Var, this.P0, mediaCrypto);
    }

    protected void e1(com.google.android.exoplayer2.mediacodec.l lVar, int i11, long j11) {
        m0.a("dropVideoBuffer");
        lVar.k(i11, false);
        m0.c();
        K1(0, 1);
    }

    @Override // com.google.android.exoplayer2.x2, com.google.android.exoplayer2.z2
    public String getName() {
        return "MediaCodecVideoRenderer";
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void h0(DecoderInputBuffer decoderInputBuffer) {
        if (this.O0) {
            ByteBuffer byteBuffer = (ByteBuffer) com.google.android.exoplayer2.util.a.e(decoderInputBuffer.f24900f);
            if (byteBuffer.remaining() >= 7) {
                byte b11 = byteBuffer.get();
                short s11 = byteBuffer.getShort();
                short s12 = byteBuffer.getShort();
                byte b12 = byteBuffer.get();
                byte b13 = byteBuffer.get();
                byteBuffer.position(0);
                if (b11 == -75 && s11 == 60 && s12 == 1 && b12 == 4 && b13 == 0) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    B1(X(), bArr);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.h, com.google.android.exoplayer2.s2.b
    public void handleMessage(int i11, Object obj) {
        if (i11 == 1) {
            D1(obj);
            return;
        }
        if (i11 == 7) {
            this.F1 = (i) obj;
            return;
        }
        if (i11 == 10) {
            int intValue = ((Integer) obj).intValue();
            if (this.D1 != intValue) {
                this.D1 = intValue;
                if (this.C1) {
                    E0();
                    return;
                }
                return;
            }
            return;
        }
        if (i11 != 4) {
            if (i11 != 5) {
                super.handleMessage(i11, obj);
                return;
            } else {
                this.H0.o(((Integer) obj).intValue());
                return;
            }
        }
        this.S0 = ((Integer) obj).intValue();
        com.google.android.exoplayer2.mediacodec.l X = X();
        if (X != null) {
            X.setVideoScalingMode(this.S0);
        }
    }

    protected a i1(com.google.android.exoplayer2.mediacodec.m mVar, o1 o1Var, o1[] o1VarArr) {
        int g12;
        int i11 = o1Var.f25555q;
        int i12 = o1Var.f25556r;
        int k12 = k1(mVar, o1Var);
        if (o1VarArr.length == 1) {
            if (k12 != -1 && (g12 = g1(mVar, o1Var)) != -1) {
                k12 = Math.min((int) (k12 * 1.5f), g12);
            }
            return new a(i11, i12, k12);
        }
        int length = o1VarArr.length;
        boolean z10 = false;
        for (int i13 = 0; i13 < length; i13++) {
            o1 o1Var2 = o1VarArr[i13];
            if (o1Var.f25562x != null && o1Var2.f25562x == null) {
                o1Var2 = o1Var2.b().J(o1Var.f25562x).E();
            }
            if (mVar.e(o1Var, o1Var2).f24946d != 0) {
                int i14 = o1Var2.f25555q;
                z10 |= i14 == -1 || o1Var2.f25556r == -1;
                i11 = Math.max(i11, i14);
                i12 = Math.max(i12, o1Var2.f25556r);
                k12 = Math.max(k12, k1(mVar, o1Var2));
            }
        }
        if (z10) {
            com.google.android.exoplayer2.util.s.i("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + i11 + "x" + i12);
            Point h12 = h1(mVar, o1Var);
            if (h12 != null) {
                i11 = Math.max(i11, h12.x);
                i12 = Math.max(i12, h12.y);
                k12 = Math.max(k12, g1(mVar, o1Var.b().j0(i11).Q(i12).E()));
                com.google.android.exoplayer2.util.s.i("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + i11 + "x" + i12);
            }
        }
        return new a(i11, i12, k12);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.x2
    public boolean isReady() {
        PlaceholderSurface placeholderSurface;
        if (super.isReady() && (this.T0 || (((placeholderSurface = this.Q0) != null && this.P0 == placeholderSurface) || X() == null || this.C1))) {
            this.X0 = C.TIME_UNSET;
            return true;
        }
        if (this.X0 == C.TIME_UNSET) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.X0) {
            return true;
        }
        this.X0 = C.TIME_UNSET;
        return false;
    }

    protected MediaFormat l1(o1 o1Var, String str, a aVar, float f11, boolean z10, int i11) {
        Pair q11;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", o1Var.f25555q);
        mediaFormat.setInteger("height", o1Var.f25556r);
        com.google.android.exoplayer2.util.v.e(mediaFormat, o1Var.f25552n);
        com.google.android.exoplayer2.util.v.c(mediaFormat, "frame-rate", o1Var.f25557s);
        com.google.android.exoplayer2.util.v.d(mediaFormat, "rotation-degrees", o1Var.f25558t);
        com.google.android.exoplayer2.util.v.b(mediaFormat, o1Var.f25562x);
        if ("video/dolby-vision".equals(o1Var.f25550l) && (q11 = MediaCodecUtil.q(o1Var)) != null) {
            com.google.android.exoplayer2.util.v.d(mediaFormat, Scopes.PROFILE, ((Integer) q11.first).intValue());
        }
        mediaFormat.setInteger("max-width", aVar.f27919a);
        mediaFormat.setInteger("max-height", aVar.f27920b);
        com.google.android.exoplayer2.util.v.d(mediaFormat, "max-input-size", aVar.f27921c);
        if (p0.f27680a >= 23) {
            mediaFormat.setInteger(TrackingKey.PRIORITY, 0);
            if (f11 != -1.0f) {
                mediaFormat.setFloat("operating-rate", f11);
            }
        }
        if (z10) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i11 != 0) {
            c1(mediaFormat, i11);
        }
        return mediaFormat;
    }

    protected boolean o1(long j11, boolean z10) {
        int y10 = y(j11);
        if (y10 == 0) {
            return false;
        }
        if (z10) {
            com.google.android.exoplayer2.decoder.e eVar = this.B0;
            eVar.f24932d += y10;
            eVar.f24934f += this.f27911s1;
        } else {
            this.B0.f24938j++;
            K1(y10, this.f27911s1);
        }
        U();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.h
    public void p() {
        a1();
        Z0();
        this.R0 = false;
        this.E1 = null;
        try {
            super.p();
        } finally {
            this.I0.m(this.B0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.h
    public void q(boolean z10, boolean z11) {
        super.q(z10, z11);
        boolean z12 = j().f24582a;
        com.google.android.exoplayer2.util.a.g((z12 && this.D1 == 0) ? false : true);
        if (this.C1 != z12) {
            this.C1 = z12;
            E0();
        }
        this.I0.o(this.B0);
        this.U0 = z11;
        this.V0 = false;
    }

    void q1() {
        this.V0 = true;
        if (this.T0) {
            return;
        }
        this.T0 = true;
        this.I0.A(this.P0);
        this.R0 = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.h
    public void r(long j11, boolean z10) {
        super.r(j11, z10);
        Z0();
        this.H0.j();
        this.f27912t1 = C.TIME_UNSET;
        this.W0 = C.TIME_UNSET;
        this.f27910r1 = 0;
        if (z10) {
            C1();
        } else {
            this.X0 = C.TIME_UNSET;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void r0(Exception exc) {
        com.google.android.exoplayer2.util.s.d("MediaCodecVideoRenderer", "Video codec error", exc);
        this.I0.C(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.h
    public void s() {
        try {
            super.s();
        } finally {
            if (this.Q0 != null) {
                y1();
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void s0(String str, l.a aVar, long j11, long j12) {
        this.I0.k(str, j11, j12);
        this.N0 = b1(str);
        this.O0 = ((com.google.android.exoplayer2.mediacodec.m) com.google.android.exoplayer2.util.a.e(Y())).n();
        if (p0.f27680a < 23 || !this.C1) {
            return;
        }
        this.E1 = new b((com.google.android.exoplayer2.mediacodec.l) com.google.android.exoplayer2.util.a.e(X()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.h
    public void t() {
        super.t();
        this.f27909q1 = 0;
        this.f27908p1 = SystemClock.elapsedRealtime();
        this.f27913u1 = SystemClock.elapsedRealtime() * 1000;
        this.f27914v1 = 0L;
        this.f27915w1 = 0;
        this.H0.k();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void t0(String str) {
        this.I0.l(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.h
    public void u() {
        this.X0 = C.TIME_UNSET;
        p1();
        r1();
        this.H0.l();
        super.u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public com.google.android.exoplayer2.decoder.g u0(p1 p1Var) {
        com.google.android.exoplayer2.decoder.g u02 = super.u0(p1Var);
        this.I0.p(p1Var.f25652b, u02);
        return u02;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void v0(o1 o1Var, MediaFormat mediaFormat) {
        com.google.android.exoplayer2.mediacodec.l X = X();
        if (X != null) {
            X.setVideoScalingMode(this.S0);
        }
        if (this.C1) {
            this.f27916x1 = o1Var.f25555q;
            this.f27917y1 = o1Var.f25556r;
        } else {
            com.google.android.exoplayer2.util.a.e(mediaFormat);
            boolean z10 = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            this.f27916x1 = z10 ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
            this.f27917y1 = z10 ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        }
        float f11 = o1Var.f25559u;
        this.A1 = f11;
        if (p0.f27680a >= 21) {
            int i11 = o1Var.f25558t;
            if (i11 == 90 || i11 == 270) {
                int i12 = this.f27916x1;
                this.f27916x1 = this.f27917y1;
                this.f27917y1 = i12;
                this.A1 = 1.0f / f11;
            }
        } else {
            this.f27918z1 = o1Var.f25558t;
        }
        this.H0.g(o1Var.f25557s);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void w0(long j11) {
        super.w0(j11);
        if (this.C1) {
            return;
        }
        this.f27911s1--;
    }

    protected void w1(long j11) {
        W0(j11);
        s1();
        this.B0.f24933e++;
        q1();
        w0(j11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void x0() {
        super.x0();
        Z0();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void y0(DecoderInputBuffer decoderInputBuffer) {
        boolean z10 = this.C1;
        if (!z10) {
            this.f27911s1++;
        }
        if (p0.f27680a >= 23 || !z10) {
            return;
        }
        w1(decoderInputBuffer.f24899e);
    }

    protected void z1(com.google.android.exoplayer2.mediacodec.l lVar, int i11, long j11) {
        s1();
        m0.a("releaseOutputBuffer");
        lVar.k(i11, true);
        m0.c();
        this.f27913u1 = SystemClock.elapsedRealtime() * 1000;
        this.B0.f24933e++;
        this.f27910r1 = 0;
        q1();
    }
}

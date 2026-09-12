package androidx.media3.exoplayer.video;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import android.view.Display;
import android.view.Surface;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.e0;
import androidx.media3.common.m0;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.l0;
import androidx.media3.common.util.q0;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.mediacodec.MediaCodecDecoderException;
import androidx.media3.exoplayer.mediacodec.MediaCodecRenderer;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.exoplayer.mediacodec.t;
import androidx.media3.exoplayer.s2;
import androidx.media3.exoplayer.source.r;
import androidx.media3.exoplayer.video.VideoSink;
import androidx.media3.exoplayer.video.i0;
import androidx.media3.exoplayer.video.q;
import androidx.media3.exoplayer.video.u;
import androidx.media3.exoplayer.w3;
import androidx.media3.exoplayer.x3;
import com.google.android.gms.common.Scopes;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.MoreExecutors;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.PriorityQueue;

/* loaded from: classes2.dex */
public class j extends MediaCodecRenderer implements u.b {
    private static final int[] L1 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static boolean M1;
    private static boolean N1;
    private m0 A1;
    private int B1;
    private boolean C1;
    private int D1;
    f E1;
    private final Context F0;
    private t F1;
    private final boolean G0;
    private long G1;
    private final i0.a H0;
    private long H1;
    private final int I0;
    private boolean I1;
    private final boolean J0;
    private boolean J1;
    private final u K0;
    private int K1;
    private final u.a L0;
    private final androidx.media3.exoplayer.video.a M0;
    private final long N0;
    private final PriorityQueue O0;
    private e P0;
    private boolean Q0;
    private boolean R0;
    private VideoSink S0;
    private boolean T0;
    private List U0;
    private Surface V0;
    private PlaceholderSurface W0;
    private l0 X0;

    /* renamed from: p1, reason: collision with root package name */
    private boolean f13219p1;

    /* renamed from: q1, reason: collision with root package name */
    private int f13220q1;

    /* renamed from: r1, reason: collision with root package name */
    private int f13221r1;

    /* renamed from: s1, reason: collision with root package name */
    private long f13222s1;

    /* renamed from: t1, reason: collision with root package name */
    private int f13223t1;

    /* renamed from: u1, reason: collision with root package name */
    private int f13224u1;

    /* renamed from: v1, reason: collision with root package name */
    private int f13225v1;

    /* renamed from: w1, reason: collision with root package name */
    private long f13226w1;

    /* renamed from: x1, reason: collision with root package name */
    private int f13227x1;

    /* renamed from: y1, reason: collision with root package name */
    private long f13228y1;

    /* renamed from: z1, reason: collision with root package name */
    private m0 f13229z1;

    /* loaded from: classes2.dex */
    class a implements VideoSink.a {
        a() {
        }

        @Override // androidx.media3.exoplayer.video.VideoSink.a
        public void a(VideoSink videoSink) {
            if (j.this.V0 != null) {
                j.this.f2();
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink.a
        public void b(VideoSink videoSink, m0 m0Var) {
        }

        @Override // androidx.media3.exoplayer.video.VideoSink.a
        public void c(VideoSink videoSink) {
            if (j.this.V0 != null) {
                j.this.A2(0, 1);
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements VideoSink.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ androidx.media3.exoplayer.mediacodec.t f13231a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f13232b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f13233c;

        b(androidx.media3.exoplayer.mediacodec.t tVar, int i11, long j11) {
            this.f13231a = tVar;
            this.f13232b = i11;
            this.f13233c = j11;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink.b
        public void a(long j11) {
            j.this.k2(this.f13231a, this.f13232b, this.f13233c, j11);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink.b
        public void b() {
            j.this.x2(this.f13231a, this.f13232b, this.f13233c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c {
        public static boolean a(Context context) {
            boolean isHdr;
            Display.HdrCapabilities hdrCapabilities;
            int[] supportedHdrTypes;
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            Display display = displayManager != null ? displayManager.getDisplay(0) : null;
            if (display == null) {
                return false;
            }
            isHdr = display.isHdr();
            if (!isHdr) {
                return false;
            }
            hdrCapabilities = display.getHdrCapabilities();
            supportedHdrTypes = hdrCapabilities.getSupportedHdrTypes();
            for (int i11 : supportedHdrTypes) {
                if (i11 == 1) {
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private final Context f13235a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f13236b;

        /* renamed from: d, reason: collision with root package name */
        private t.b f13238d;

        /* renamed from: e, reason: collision with root package name */
        private long f13239e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f13240f;

        /* renamed from: g, reason: collision with root package name */
        private Handler f13241g;

        /* renamed from: h, reason: collision with root package name */
        private i0 f13242h;

        /* renamed from: i, reason: collision with root package name */
        private int f13243i;

        /* renamed from: k, reason: collision with root package name */
        private VideoSink f13245k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f13246l;

        /* renamed from: c, reason: collision with root package name */
        private androidx.media3.exoplayer.mediacodec.h0 f13237c = androidx.media3.exoplayer.mediacodec.h0.f12293a;

        /* renamed from: j, reason: collision with root package name */
        private float f13244j = 30.0f;

        /* renamed from: m, reason: collision with root package name */
        private long f13247m = C.TIME_UNSET;

        public d(Context context) {
            this.f13235a = context;
            this.f13238d = androidx.media3.exoplayer.mediacodec.u.a(context);
        }

        public j m() {
            androidx.media3.common.util.a.g(!this.f13236b);
            Handler handler = this.f13241g;
            androidx.media3.common.util.a.g((handler == null && this.f13242h == null) || !(handler == null || this.f13242h == null));
            this.f13236b = true;
            return new j(this);
        }

        public d n(long j11) {
            this.f13247m = j11;
            return this;
        }

        public d o(boolean z10) {
            this.f13246l = z10;
            return this;
        }

        public d p(long j11) {
            this.f13239e = j11;
            return this;
        }

        public d q(t.b bVar) {
            this.f13238d = bVar;
            return this;
        }

        public d r(boolean z10) {
            this.f13240f = z10;
            return this;
        }

        public d s(Handler handler) {
            this.f13241g = handler;
            return this;
        }

        public d t(i0 i0Var) {
            this.f13242h = i0Var;
            return this;
        }

        public d u(int i11) {
            this.f13243i = i11;
            return this;
        }

        public d v(androidx.media3.exoplayer.mediacodec.h0 h0Var) {
            this.f13237c = h0Var;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final int f13248a;

        /* renamed from: b, reason: collision with root package name */
        public final int f13249b;

        /* renamed from: c, reason: collision with root package name */
        public final int f13250c;

        public e(int i11, int i12, int i13) {
            this.f13248a = i11;
            this.f13249b = i12;
            this.f13250c = i13;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class f implements t.d, Handler.Callback {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f13251a;

        public f(androidx.media3.exoplayer.mediacodec.t tVar) {
            Handler B = a1.B(this);
            this.f13251a = B;
            tVar.n(this, B);
        }

        private void b(long j11) {
            j jVar = j.this;
            if (this != jVar.E1 || jVar.l0() == null) {
                return;
            }
            if (j11 == Long.MAX_VALUE) {
                j.this.h2();
                return;
            }
            try {
                j.this.g2(j11);
            } catch (ExoPlaybackException e11) {
                j.this.k1(e11);
            }
        }

        @Override // androidx.media3.exoplayer.mediacodec.t.d
        public void a(androidx.media3.exoplayer.mediacodec.t tVar, long j11, long j12) {
            if (a1.f10432a >= 30) {
                b(j11);
            } else {
                this.f13251a.sendMessageAtFrontOfQueue(Message.obtain(this.f13251a, 0, (int) (j11 >> 32), (int) j11));
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b(a1.v1(message.arg1, message.arg2));
            return true;
        }
    }

    protected j(d dVar) {
        super(2, dVar.f13238d, dVar.f13237c, dVar.f13240f, dVar.f13244j);
        Context applicationContext = dVar.f13235a.getApplicationContext();
        this.F0 = applicationContext;
        this.I0 = dVar.f13243i;
        this.S0 = dVar.f13245k;
        this.H0 = new i0.a(dVar.f13241g, dVar.f13242h);
        this.G0 = this.S0 == null;
        this.K0 = new u(applicationContext, this, dVar.f13239e);
        this.L0 = new u.a();
        this.J0 = G1();
        this.X0 = l0.f10489c;
        this.f13220q1 = 1;
        this.f13221r1 = 0;
        this.f13229z1 = m0.f10193e;
        this.D1 = 0;
        this.A1 = null;
        this.B1 = -1000;
        long j11 = C.TIME_UNSET;
        this.G1 = C.TIME_UNSET;
        this.H1 = C.TIME_UNSET;
        this.M0 = dVar.f13246l ? new androidx.media3.exoplayer.video.a() : null;
        this.O0 = new PriorityQueue();
        this.N0 = dVar.f13247m != C.TIME_UNSET ? -dVar.f13247m : j11;
    }

    private void B2(long j11) {
        int i11 = 0;
        while (true) {
            Long l11 = (Long) this.O0.peek();
            if (l11 == null || l11.longValue() >= j11) {
                break;
            }
            i11++;
            this.O0.poll();
        }
        A2(i11, 0);
    }

    private void C2(r.b bVar) {
        androidx.media3.common.e0 A = A();
        if (A.q()) {
            this.H1 = C.TIME_UNSET;
        } else {
            this.H1 = A.h(((r.b) androidx.media3.common.util.a.e(bVar)).f12965a, new e0.b()).k();
        }
    }

    private static boolean G1() {
        return "NVIDIA".equals(Build.MANUFACTURER);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:389:0x073c, code lost:
    
        if (r11.equals("A10-70L") == false) goto L89;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:45:0x089a. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean I1() {
        /*
            Method dump skipped, instructions count: 3180
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.j.I1():boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0087, code lost:
    
        if (r9.equals("video/av01") == false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int K1(androidx.media3.exoplayer.mediacodec.w r11, androidx.media3.common.r r12) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.j.K1(androidx.media3.exoplayer.mediacodec.w, androidx.media3.common.r):int");
    }

    private static Point L1(androidx.media3.exoplayer.mediacodec.w wVar, androidx.media3.common.r rVar) {
        int i11 = rVar.f10251w;
        int i12 = rVar.f10250v;
        boolean z10 = i11 > i12;
        int i13 = z10 ? i11 : i12;
        if (z10) {
            i11 = i12;
        }
        float f11 = i11 / i13;
        for (int i14 : L1) {
            int i15 = (int) (i14 * f11);
            if (i14 <= i13 || i15 <= i11) {
                break;
            }
            int i16 = z10 ? i15 : i14;
            if (!z10) {
                i14 = i15;
            }
            Point c11 = wVar.c(i16, i14);
            float f12 = rVar.f10252x;
            if (c11 != null && wVar.u(c11.x, c11.y, f12)) {
                return c11;
            }
        }
        return null;
    }

    private static List N1(Context context, androidx.media3.exoplayer.mediacodec.h0 h0Var, androidx.media3.common.r rVar, boolean z10, boolean z11) {
        String str = rVar.f10243o;
        if (str == null) {
            return ImmutableList.of();
        }
        if (a1.f10432a >= 26 && "video/dolby-vision".equals(str) && !c.a(context)) {
            List g11 = MediaCodecUtil.g(h0Var, rVar, z10, z11);
            if (!g11.isEmpty()) {
                return g11;
            }
        }
        return MediaCodecUtil.m(h0Var, rVar, z10, z11);
    }

    protected static int O1(androidx.media3.exoplayer.mediacodec.w wVar, androidx.media3.common.r rVar) {
        if (rVar.f10244p == -1) {
            return K1(wVar, rVar);
        }
        int size = rVar.f10246r.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 += ((byte[]) rVar.f10246r.get(i12)).length;
        }
        return rVar.f10244p + i11;
    }

    private static int P1(int i11, int i12) {
        return (i11 * 3) / (i12 * 2);
    }

    private Surface R1(androidx.media3.exoplayer.mediacodec.w wVar) {
        VideoSink videoSink = this.S0;
        if (videoSink != null) {
            return videoSink.m();
        }
        Surface surface = this.V0;
        if (surface != null) {
            return surface;
        }
        if (v2(wVar)) {
            return null;
        }
        androidx.media3.common.util.a.g(w2(wVar));
        PlaceholderSurface placeholderSurface = this.W0;
        if (placeholderSurface != null && placeholderSurface.secure != wVar.f12343g) {
            j2();
        }
        if (this.W0 == null) {
            this.W0 = PlaceholderSurface.newInstance(this.F0, wVar.f12343g);
        }
        return this.W0;
    }

    private boolean S1(androidx.media3.exoplayer.mediacodec.w wVar) {
        Surface surface;
        return this.S0 != null || ((surface = this.V0) != null && surface.isValid()) || v2(wVar) || w2(wVar);
    }

    private boolean T1(DecoderInputBuffer decoderInputBuffer) {
        return decoderInputBuffer.f11002e < w();
    }

    private boolean U1(DecoderInputBuffer decoderInputBuffer) {
        if (hasReadStreamToEnd() || decoderInputBuffer.isLastSample() || this.H1 == C.TIME_UNSET) {
            return true;
        }
        return this.H1 - (decoderInputBuffer.f11002e - v0()) <= 100000;
    }

    private void W1() {
        if (this.f13223t1 > 0) {
            long elapsedRealtime = s().elapsedRealtime();
            this.H0.n(this.f13223t1, elapsedRealtime - this.f13222s1);
            this.f13223t1 = 0;
            this.f13222s1 = elapsedRealtime;
        }
    }

    private void X1() {
        if (!this.K0.i() || this.V0 == null) {
            return;
        }
        f2();
    }

    private void Y1() {
        int i11 = this.f13227x1;
        if (i11 != 0) {
            this.H0.B(this.f13226w1, i11);
            this.f13226w1 = 0L;
            this.f13227x1 = 0;
        }
    }

    private void Z1(m0 m0Var) {
        if (m0Var.equals(m0.f10193e) || m0Var.equals(this.A1)) {
            return;
        }
        this.A1 = m0Var;
        this.H0.D(m0Var);
    }

    private void a2() {
        Surface surface = this.V0;
        if (surface == null || !this.f13219p1) {
            return;
        }
        this.H0.A(surface);
    }

    private void b2() {
        m0 m0Var = this.A1;
        if (m0Var != null) {
            this.H0.D(m0Var);
        }
    }

    private void c2(MediaFormat mediaFormat) {
        if (this.S0 == null || a1.H0(this.F0)) {
            return;
        }
        mediaFormat.setInteger("allow-frame-drop", 0);
    }

    private void d2() {
        int i11;
        androidx.media3.exoplayer.mediacodec.t l02;
        if (!this.C1 || (i11 = a1.f10432a) < 23 || (l02 = l0()) == null) {
            return;
        }
        this.E1 = new f(l02);
        if (i11 >= 33) {
            Bundle bundle = new Bundle();
            bundle.putInt("tunnel-peek", 1);
            l02.b(bundle);
        }
    }

    private void e2(long j11, long j12, androidx.media3.common.r rVar) {
        t tVar = this.F1;
        if (tVar != null) {
            tVar.f(j11, j12, rVar, q0());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f2() {
        this.H0.A(this.V0);
        this.f13219p1 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h2() {
        j1();
    }

    private void i2(androidx.media3.exoplayer.mediacodec.t tVar, int i11, long j11, androidx.media3.common.r rVar) {
        long g11 = this.L0.g();
        long f11 = this.L0.f();
        if (u2() && g11 == this.f13228y1) {
            x2(tVar, i11, j11);
        } else {
            e2(j11, g11, rVar);
            l2(tVar, i11, j11, g11);
        }
        D2(f11);
        this.f13228y1 = g11;
    }

    private void j2() {
        PlaceholderSurface placeholderSurface = this.W0;
        if (placeholderSurface != null) {
            placeholderSurface.release();
            this.W0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k2(androidx.media3.exoplayer.mediacodec.t tVar, int i11, long j11, long j12) {
        l2(tVar, i11, j11, j12);
    }

    private static void m2(androidx.media3.exoplayer.mediacodec.t tVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        tVar.b(bundle);
    }

    private void n2(Object obj) {
        Surface surface = obj instanceof Surface ? (Surface) obj : null;
        if (this.V0 == surface) {
            if (surface != null) {
                b2();
                a2();
                return;
            }
            return;
        }
        this.V0 = surface;
        if (this.S0 == null) {
            this.K0.q(surface);
        }
        this.f13219p1 = false;
        int state = getState();
        androidx.media3.exoplayer.mediacodec.t l02 = l0();
        if (l02 != null && this.S0 == null) {
            androidx.media3.exoplayer.mediacodec.w wVar = (androidx.media3.exoplayer.mediacodec.w) androidx.media3.common.util.a.e(n0());
            boolean S1 = S1(wVar);
            if (a1.f10432a < 23 || !S1 || this.Q0) {
                b1();
                J0();
            } else {
                o2(l02, R1(wVar));
            }
        }
        if (surface != null) {
            b2();
        } else {
            this.A1 = null;
            VideoSink videoSink = this.S0;
            if (videoSink != null) {
                videoSink.s();
            }
        }
        if (state == 2) {
            VideoSink videoSink2 = this.S0;
            if (videoSink2 != null) {
                videoSink2.u(true);
            } else {
                this.K0.e(true);
            }
        }
        d2();
    }

    private void o2(androidx.media3.exoplayer.mediacodec.t tVar, Surface surface) {
        int i11 = a1.f10432a;
        if (i11 >= 23 && surface != null) {
            p2(tVar, surface);
        } else {
            if (i11 < 35) {
                throw new IllegalStateException();
            }
            F1(tVar);
        }
    }

    private static int y2(Context context, androidx.media3.exoplayer.mediacodec.h0 h0Var, androidx.media3.common.r rVar) {
        boolean z10;
        int i11 = 0;
        if (!androidx.media3.common.y.t(rVar.f10243o)) {
            return x3.a(0);
        }
        boolean z11 = rVar.f10247s != null;
        List N12 = N1(context, h0Var, rVar, z11, false);
        if (z11 && N12.isEmpty()) {
            N12 = N1(context, h0Var, rVar, false, false);
        }
        if (N12.isEmpty()) {
            return x3.a(1);
        }
        if (!MediaCodecRenderer.t1(rVar)) {
            return x3.a(2);
        }
        androidx.media3.exoplayer.mediacodec.w wVar = (androidx.media3.exoplayer.mediacodec.w) N12.get(0);
        boolean o11 = wVar.o(rVar);
        if (!o11) {
            for (int i12 = 1; i12 < N12.size(); i12++) {
                androidx.media3.exoplayer.mediacodec.w wVar2 = (androidx.media3.exoplayer.mediacodec.w) N12.get(i12);
                if (wVar2.o(rVar)) {
                    z10 = false;
                    o11 = true;
                    wVar = wVar2;
                    break;
                }
            }
        }
        z10 = true;
        int i13 = o11 ? 4 : 3;
        int i14 = wVar.r(rVar) ? 16 : 8;
        int i15 = wVar.f12344h ? 64 : 0;
        int i16 = z10 ? 128 : 0;
        if (a1.f10432a >= 26 && "video/dolby-vision".equals(rVar.f10243o) && !c.a(context)) {
            i16 = 256;
        }
        if (o11) {
            List N13 = N1(context, h0Var, rVar, z11, true);
            if (!N13.isEmpty()) {
                androidx.media3.exoplayer.mediacodec.w wVar3 = (androidx.media3.exoplayer.mediacodec.w) MediaCodecUtil.n(N13, rVar).get(0);
                if (wVar3.o(rVar) && wVar3.r(rVar)) {
                    i11 = 32;
                }
            }
        }
        return x3.d(i13, i14, i11, i15, i16);
    }

    private void z2() {
        androidx.media3.exoplayer.mediacodec.t l02 = l0();
        if (l02 != null && a1.f10432a >= 35) {
            Bundle bundle = new Bundle();
            bundle.putInt("importance", Math.max(0, -this.B1));
            l02.b(bundle);
        }
    }

    protected void A2(int i11, int i12) {
        androidx.media3.exoplayer.j jVar = this.f12249z0;
        jVar.f12120h += i11;
        int i13 = i11 + i12;
        jVar.f12119g += i13;
        this.f13223t1 += i13;
        int i14 = this.f13224u1 + i13;
        this.f13224u1 = i14;
        jVar.f12121i = Math.max(i14, jVar.f12121i);
        int i15 = this.I0;
        if (i15 <= 0 || this.f13223t1 < i15) {
            return;
        }
        W1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.i
    public void C() {
        this.A1 = null;
        this.H1 = C.TIME_UNSET;
        VideoSink videoSink = this.S0;
        if (videoSink != null) {
            videoSink.q();
        } else {
            this.K0.g();
        }
        d2();
        this.f13219p1 = false;
        this.E1 = null;
        try {
            super.C();
        } finally {
            this.H0.m(this.f12249z0);
            this.H0.D(m0.f10193e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.i
    public void D(boolean z10, boolean z11) {
        super.D(z10, z11);
        boolean z12 = t().f13482b;
        androidx.media3.common.util.a.g((z12 && this.D1 == 0) ? false : true);
        if (this.C1 != z12) {
            this.C1 = z12;
            b1();
        }
        this.H0.o(this.f12249z0);
        if (!this.T0) {
            if (this.U0 != null && this.S0 == null) {
                q h11 = new q.b(this.F0, this.K0).i(s()).h();
                h11.O(1);
                this.S0 = h11.B(0);
            }
            this.T0 = true;
        }
        VideoSink videoSink = this.S0;
        if (videoSink == null) {
            this.K0.o(s());
            this.K0.h(z11);
            return;
        }
        videoSink.v(new a(), MoreExecutors.a());
        t tVar = this.F1;
        if (tVar != null) {
            this.S0.d(tVar);
        }
        if (this.V0 != null && !this.X0.equals(l0.f10489c)) {
            this.S0.p(this.V0, this.X0);
        }
        this.S0.r(this.f13221r1);
        this.S0.a(x0());
        List list = this.U0;
        if (list != null) {
            this.S0.i(list);
        }
        this.S0.l(z11);
        w3.a y02 = y0();
        if (y02 != null) {
            this.S0.h(y02);
        }
    }

    protected void D1(VideoSink videoSink, int i11, androidx.media3.common.r rVar) {
        List list = this.U0;
        if (list == null) {
            list = ImmutableList.of();
        }
        videoSink.o(i11, rVar, list);
    }

    protected void D2(long j11) {
        this.f12249z0.a(j11);
        this.f13226w1 += j11;
        this.f13227x1++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.i
    public void E() {
        super.E();
    }

    protected boolean E1(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (j.class) {
            try {
                if (!M1) {
                    N1 = I1();
                    M1 = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return N1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.i
    public void F(long j11, boolean z10) {
        VideoSink videoSink = this.S0;
        if (videoSink != null) {
            if (!z10) {
                videoSink.t(true);
            }
            this.S0.f(w0(), J1());
            this.I1 = true;
        }
        super.F(j11, z10);
        if (this.S0 == null) {
            this.K0.m();
        }
        if (z10) {
            VideoSink videoSink2 = this.S0;
            if (videoSink2 != null) {
                videoSink2.u(false);
            } else {
                this.K0.e(false);
            }
        }
        d2();
        this.f13224u1 = 0;
    }

    protected void F1(androidx.media3.exoplayer.mediacodec.t tVar) {
        tVar.o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.i
    public void G() {
        super.G();
        VideoSink videoSink = this.S0;
        if (videoSink == null || !this.G0) {
            return;
        }
        videoSink.release();
    }

    protected void H1(androidx.media3.exoplayer.mediacodec.t tVar, int i11, long j11) {
        q0.a("dropVideoBuffer");
        tVar.k(i11, false);
        q0.b();
        A2(0, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.i
    public void I() {
        try {
            super.I();
        } finally {
            this.T0 = false;
            this.G1 = C.TIME_UNSET;
            j2();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.i
    public void J() {
        super.J();
        this.f13223t1 = 0;
        this.f13222s1 = s().elapsedRealtime();
        this.f13226w1 = 0L;
        this.f13227x1 = 0;
        VideoSink videoSink = this.S0;
        if (videoSink != null) {
            videoSink.n();
        } else {
            this.K0.k();
        }
    }

    protected long J1() {
        return -this.G1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.i
    public void K() {
        W1();
        Y1();
        VideoSink videoSink = this.S0;
        if (videoSink != null) {
            videoSink.g();
        } else {
            this.K0.l();
        }
        super.K();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.i
    public void L(androidx.media3.common.r[] rVarArr, long j11, long j12, r.b bVar) {
        super.L(rVarArr, j11, j12, bVar);
        if (this.G1 == C.TIME_UNSET) {
            this.G1 = j11;
        }
        C2(bVar);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected boolean L0(androidx.media3.common.r rVar) {
        VideoSink videoSink = this.S0;
        if (videoSink == null || videoSink.isInitialized()) {
            return true;
        }
        try {
            return this.S0.k(rVar);
        } catch (VideoSink.VideoSinkException e11) {
            throw q(e11, rVar, PlaybackException.ERROR_CODE_VIDEO_FRAME_PROCESSOR_INIT_FAILED);
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void M0(Exception exc) {
        androidx.media3.common.util.u.d("MediaCodecVideoRenderer", "Video codec error", exc);
        this.H0.C(exc);
    }

    protected e M1(androidx.media3.exoplayer.mediacodec.w wVar, androidx.media3.common.r rVar, androidx.media3.common.r[] rVarArr) {
        int K1;
        int i11 = rVar.f10250v;
        int i12 = rVar.f10251w;
        int O1 = O1(wVar, rVar);
        if (rVarArr.length == 1) {
            if (O1 != -1 && (K1 = K1(wVar, rVar)) != -1) {
                O1 = Math.min((int) (O1 * 1.5f), K1);
            }
            return new e(i11, i12, O1);
        }
        int length = rVarArr.length;
        boolean z10 = false;
        for (int i13 = 0; i13 < length; i13++) {
            androidx.media3.common.r rVar2 = rVarArr[i13];
            if (rVar.C != null && rVar2.C == null) {
                rVar2 = rVar2.b().T(rVar.C).N();
            }
            if (wVar.e(rVar, rVar2).f12135d != 0) {
                int i14 = rVar2.f10250v;
                z10 |= i14 == -1 || rVar2.f10251w == -1;
                i11 = Math.max(i11, i14);
                i12 = Math.max(i12, rVar2.f10251w);
                O1 = Math.max(O1, O1(wVar, rVar2));
            }
        }
        if (z10) {
            androidx.media3.common.util.u.h("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + i11 + "x" + i12);
            Point L12 = L1(wVar, rVar);
            if (L12 != null) {
                i11 = Math.max(i11, L12.x);
                i12 = Math.max(i12, L12.y);
                O1 = Math.max(O1, K1(wVar, rVar.b().B0(i11).d0(i12).N()));
                androidx.media3.common.util.u.h("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + i11 + "x" + i12);
            }
        }
        return new e(i11, i12, O1);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void N0(String str, t.a aVar, long j11, long j12) {
        this.H0.k(str, j11, j12);
        this.Q0 = E1(str);
        this.R0 = ((androidx.media3.exoplayer.mediacodec.w) androidx.media3.common.util.a.e(n0())).p();
        d2();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void O0(String str) {
        this.H0.l(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public androidx.media3.exoplayer.k P0(s2 s2Var) {
        androidx.media3.exoplayer.k P0 = super.P0(s2Var);
        this.H0.p((androidx.media3.common.r) androidx.media3.common.util.a.e(s2Var.f12652b), P0);
        return P0;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void Q0(androidx.media3.common.r rVar, MediaFormat mediaFormat) {
        int integer;
        int i11;
        androidx.media3.exoplayer.mediacodec.t l02 = l0();
        if (l02 != null) {
            l02.setVideoScalingMode(this.f13220q1);
        }
        if (this.C1) {
            i11 = rVar.f10250v;
            integer = rVar.f10251w;
        } else {
            androidx.media3.common.util.a.e(mediaFormat);
            boolean z10 = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            int integer2 = z10 ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
            integer = z10 ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
            i11 = integer2;
        }
        float f11 = rVar.f10254z;
        int i12 = rVar.f10253y;
        if (i12 == 90 || i12 == 270) {
            f11 = 1.0f / f11;
            int i13 = integer;
            integer = i11;
            i11 = i13;
        }
        this.f13229z1 = new m0(i11, integer, f11);
        VideoSink videoSink = this.S0;
        if (videoSink == null || !this.I1) {
            this.K0.p(rVar.f10252x);
        } else {
            D1(videoSink, 1, rVar.b().B0(i11).d0(integer).q0(f11).N());
        }
        this.I1 = false;
    }

    protected MediaFormat Q1(androidx.media3.common.r rVar, String str, e eVar, float f11, boolean z10, int i11) {
        Pair i12;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", rVar.f10250v);
        mediaFormat.setInteger("height", rVar.f10251w);
        androidx.media3.common.util.x.e(mediaFormat, rVar.f10246r);
        androidx.media3.common.util.x.c(mediaFormat, "frame-rate", rVar.f10252x);
        androidx.media3.common.util.x.d(mediaFormat, "rotation-degrees", rVar.f10253y);
        androidx.media3.common.util.x.b(mediaFormat, rVar.C);
        if ("video/dolby-vision".equals(rVar.f10243o) && (i12 = MediaCodecUtil.i(rVar)) != null) {
            androidx.media3.common.util.x.d(mediaFormat, Scopes.PROFILE, ((Integer) i12.first).intValue());
        }
        mediaFormat.setInteger("max-width", eVar.f13248a);
        mediaFormat.setInteger("max-height", eVar.f13249b);
        androidx.media3.common.util.x.d(mediaFormat, "max-input-size", eVar.f13250c);
        int i13 = a1.f10432a;
        if (i13 >= 23) {
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
            mediaFormat.setFeatureEnabled("tunneled-playback", true);
            mediaFormat.setInteger("audio-session-id", i11);
        }
        if (i13 >= 35) {
            mediaFormat.setInteger("importance", Math.max(0, -this.B1));
        }
        return mediaFormat;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public void S0(long j11) {
        super.S0(j11);
        if (this.C1) {
            return;
        }
        this.f13225v1--;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected androidx.media3.exoplayer.k T(androidx.media3.exoplayer.mediacodec.w wVar, androidx.media3.common.r rVar, androidx.media3.common.r rVar2) {
        androidx.media3.exoplayer.k e11 = wVar.e(rVar, rVar2);
        int i11 = e11.f12136e;
        e eVar = (e) androidx.media3.common.util.a.e(this.P0);
        if (rVar2.f10250v > eVar.f13248a || rVar2.f10251w > eVar.f13249b) {
            i11 |= 256;
        }
        if (O1(wVar, rVar2) > eVar.f13250c) {
            i11 |= 64;
        }
        int i12 = i11;
        return new androidx.media3.exoplayer.k(wVar.f12337a, rVar, rVar2, i12 != 0 ? 0 : e11.f12135d, i12);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public void T0() {
        super.T0();
        VideoSink videoSink = this.S0;
        if (videoSink != null) {
            videoSink.e();
            this.S0.f(w0(), J1());
        } else {
            this.K0.j();
        }
        this.I1 = true;
        d2();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void U0(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer;
        if (this.M0 != null && ((androidx.media3.exoplayer.mediacodec.w) androidx.media3.common.util.a.e(n0())).f12338b.equals("video/av01") && (byteBuffer = decoderInputBuffer.f11000c) != null) {
            this.M0.b(byteBuffer);
        }
        this.K1 = 0;
        boolean z10 = this.C1;
        if (!z10) {
            this.f13225v1++;
        }
        if (a1.f10432a >= 23 || !z10) {
            return;
        }
        g2(decoderInputBuffer.f11002e);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void V0(w3.a aVar) {
        VideoSink videoSink = this.S0;
        if (videoSink != null) {
            videoSink.h(aVar);
        }
    }

    protected boolean V1(long j11, boolean z10) {
        int P = P(j11);
        if (P == 0) {
            return false;
        }
        if (z10) {
            androidx.media3.exoplayer.j jVar = this.f12249z0;
            int i11 = jVar.f12116d + P;
            jVar.f12116d = i11;
            jVar.f12118f += this.f13225v1;
            jVar.f12116d = i11 + this.O0.size();
        } else {
            this.f12249z0.f12122j++;
            A2(P + this.O0.size(), this.f13225v1);
        }
        i0();
        VideoSink videoSink = this.S0;
        if (videoSink != null) {
            videoSink.t(false);
        }
        return true;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected boolean X0(long j11, long j12, androidx.media3.exoplayer.mediacodec.t tVar, ByteBuffer byteBuffer, int i11, int i12, int i13, long j13, boolean z10, boolean z11, androidx.media3.common.r rVar) {
        androidx.media3.common.util.a.e(tVar);
        long v02 = j13 - v0();
        B2(j13);
        if (this.S0 != null) {
            if (!z10 || z11) {
                return this.S0.b(J1() + j13, z11, new b(tVar, i11, v02));
            }
            x2(tVar, i11, v02);
            return true;
        }
        int c11 = this.K0.c(j13, j11, j12, w0(), z10, z11, this.L0);
        if (c11 == 0) {
            long nanoTime = s().nanoTime();
            e2(v02, nanoTime, rVar);
            k2(tVar, i11, v02, nanoTime);
            D2(this.L0.f());
            return true;
        }
        if (c11 == 1) {
            i2((androidx.media3.exoplayer.mediacodec.t) androidx.media3.common.util.a.i(tVar), i11, v02, rVar);
            return true;
        }
        if (c11 == 2) {
            H1(tVar, i11, v02);
            D2(this.L0.f());
            return true;
        }
        if (c11 == 3) {
            x2(tVar, i11, v02);
            D2(this.L0.f());
            return true;
        }
        if (c11 == 4 || c11 == 5) {
            return false;
        }
        throw new IllegalStateException(String.valueOf(c11));
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected MediaCodecDecoderException Z(Throwable th2, androidx.media3.exoplayer.mediacodec.w wVar) {
        return new MediaCodecVideoDecoderException(th2, wVar, this.V0);
    }

    @Override // androidx.media3.exoplayer.i, androidx.media3.exoplayer.w3
    public void c() {
        VideoSink videoSink = this.S0;
        if (videoSink != null) {
            videoSink.c();
        } else {
            this.K0.a();
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void c1() {
        VideoSink videoSink = this.S0;
        if (videoSink != null) {
            videoSink.e();
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.i, androidx.media3.exoplayer.w3
    public void d(float f11, float f12) {
        super.d(f11, f12);
        VideoSink videoSink = this.S0;
        if (videoSink != null) {
            videoSink.a(f11);
        } else {
            this.K0.r(f11);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public void d1() {
        super.d1();
        this.O0.clear();
        this.J1 = false;
        this.f13225v1 = 0;
        this.K1 = 0;
        androidx.media3.exoplayer.video.a aVar = this.M0;
        if (aVar != null) {
            aVar.c();
        }
    }

    protected void g2(long j11) {
        w1(j11);
        Z1(this.f13229z1);
        this.f12249z0.f12117e++;
        X1();
        S0(j11);
    }

    @Override // androidx.media3.exoplayer.w3, androidx.media3.exoplayer.y3
    public String getName() {
        return "MediaCodecVideoRenderer";
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.i, androidx.media3.exoplayer.t3.b
    public void handleMessage(int i11, Object obj) {
        if (i11 == 1) {
            n2(obj);
            return;
        }
        if (i11 == 7) {
            t tVar = (t) androidx.media3.common.util.a.e(obj);
            this.F1 = tVar;
            VideoSink videoSink = this.S0;
            if (videoSink != null) {
                videoSink.d(tVar);
                return;
            }
            return;
        }
        if (i11 == 10) {
            int intValue = ((Integer) androidx.media3.common.util.a.e(obj)).intValue();
            if (this.D1 != intValue) {
                this.D1 = intValue;
                if (this.C1) {
                    b1();
                    return;
                }
                return;
            }
            return;
        }
        if (i11 == 4) {
            this.f13220q1 = ((Integer) androidx.media3.common.util.a.e(obj)).intValue();
            androidx.media3.exoplayer.mediacodec.t l02 = l0();
            if (l02 != null) {
                l02.setVideoScalingMode(this.f13220q1);
                return;
            }
            return;
        }
        if (i11 == 5) {
            int intValue2 = ((Integer) androidx.media3.common.util.a.e(obj)).intValue();
            this.f13221r1 = intValue2;
            VideoSink videoSink2 = this.S0;
            if (videoSink2 != null) {
                videoSink2.r(intValue2);
                return;
            } else {
                this.K0.n(intValue2);
                return;
            }
        }
        if (i11 == 13) {
            q2((List) androidx.media3.common.util.a.e(obj));
            return;
        }
        if (i11 == 14) {
            l0 l0Var = (l0) androidx.media3.common.util.a.e(obj);
            if (l0Var.b() == 0 || l0Var.a() == 0) {
                return;
            }
            this.X0 = l0Var;
            VideoSink videoSink3 = this.S0;
            if (videoSink3 != null) {
                videoSink3.p((Surface) androidx.media3.common.util.a.i(this.V0), l0Var);
                return;
            }
            return;
        }
        if (i11 == 16) {
            this.B1 = ((Integer) androidx.media3.common.util.a.e(obj)).intValue();
            z2();
        } else {
            if (i11 != 17) {
                super.handleMessage(i11, obj);
                return;
            }
            Surface surface = this.V0;
            n2(null);
            ((j) androidx.media3.common.util.a.e(obj)).handleMessage(1, surface);
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.w3
    public boolean isEnded() {
        VideoSink videoSink;
        return super.isEnded() && ((videoSink = this.S0) == null || videoSink.isEnded());
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.w3
    public boolean isReady() {
        boolean isReady = super.isReady();
        VideoSink videoSink = this.S0;
        if (videoSink != null) {
            return videoSink.j(isReady);
        }
        if (isReady && (l0() == null || this.C1)) {
            return true;
        }
        return this.K0.d(isReady);
    }

    @Override // androidx.media3.exoplayer.video.u.b
    public boolean j(long j11, long j12) {
        return t2(j11, j12);
    }

    @Override // androidx.media3.exoplayer.video.u.b
    public boolean k(long j11, long j12, long j13, boolean z10, boolean z11) {
        if (this.N0 != C.TIME_UNSET) {
            this.J1 = j12 > w() + 200000 && j11 < this.N0;
        }
        return r2(j11, j13, z10) && V1(j12, z11);
    }

    protected void l2(androidx.media3.exoplayer.mediacodec.t tVar, int i11, long j11, long j12) {
        q0.a("releaseOutputBuffer");
        tVar.h(i11, j12);
        q0.b();
        this.f12249z0.f12117e++;
        this.f13224u1 = 0;
        if (this.S0 == null) {
            Z1(this.f13229z1);
            X1();
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected int m0(DecoderInputBuffer decoderInputBuffer) {
        return (a1.f10432a >= 34 && this.C1 && T1(decoderInputBuffer)) ? 32 : 0;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected boolean n1(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer;
        if (U1(decoderInputBuffer) || decoderInputBuffer.e()) {
            return false;
        }
        boolean T1 = T1(decoderInputBuffer);
        if ((!T1 && !this.J1) || decoderInputBuffer.hasSupplementalData()) {
            return false;
        }
        if (decoderInputBuffer.notDependedOn()) {
            decoderInputBuffer.clear();
            if (T1) {
                this.f12249z0.f12116d++;
            } else if (this.J1) {
                this.O0.add(Long.valueOf(decoderInputBuffer.f11002e));
                this.K1++;
            }
            return true;
        }
        if (this.M0 != null && ((androidx.media3.exoplayer.mediacodec.w) androidx.media3.common.util.a.e(n0())).f12338b.equals("video/av01") && (byteBuffer = decoderInputBuffer.f11000c) != null) {
            boolean z10 = T1 || this.K1 <= 0;
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            asReadOnlyBuffer.flip();
            int d11 = this.M0.d(asReadOnlyBuffer, z10);
            boolean z11 = ((e) androidx.media3.common.util.a.e(this.P0)).f13250c + d11 < asReadOnlyBuffer.capacity();
            if (d11 != asReadOnlyBuffer.limit() && z11) {
                ((ByteBuffer) androidx.media3.common.util.a.e(decoderInputBuffer.f11000c)).position(d11);
                if (T1) {
                    this.f12249z0.f12116d++;
                } else if (this.J1) {
                    this.O0.add(Long.valueOf(decoderInputBuffer.f11002e));
                    this.K1++;
                }
                return true;
            }
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.video.u.b
    public boolean o(long j11, long j12, boolean z10) {
        return s2(j11, j12, z10);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected boolean o0() {
        return this.C1 && a1.f10432a < 23;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected boolean o1(androidx.media3.exoplayer.mediacodec.w wVar) {
        return S1(wVar);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected float p0(float f11, androidx.media3.common.r rVar, androidx.media3.common.r[] rVarArr) {
        float f12 = -1.0f;
        for (androidx.media3.common.r rVar2 : rVarArr) {
            float f13 = rVar2.f10252x;
            if (f13 != -1.0f) {
                f12 = Math.max(f12, f13);
            }
        }
        if (f12 == -1.0f) {
            return -1.0f;
        }
        return f12 * f11;
    }

    protected void p2(androidx.media3.exoplayer.mediacodec.t tVar, Surface surface) {
        tVar.e(surface);
    }

    public void q2(List list) {
        this.U0 = list;
        VideoSink videoSink = this.S0;
        if (videoSink != null) {
            videoSink.i(list);
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected List r0(androidx.media3.exoplayer.mediacodec.h0 h0Var, androidx.media3.common.r rVar, boolean z10) {
        return MediaCodecUtil.n(N1(this.F0, h0Var, rVar, z10, this.C1), rVar);
    }

    protected boolean r2(long j11, long j12, boolean z10) {
        return j11 < -500000 && !z10;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.w3
    public void render(long j11, long j12) {
        VideoSink videoSink = this.S0;
        if (videoSink != null) {
            try {
                videoSink.render(j11, j12);
            } catch (VideoSink.VideoSinkException e11) {
                throw q(e11, e11.format, 7001);
            }
        }
        super.render(j11, j12);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected int s1(androidx.media3.exoplayer.mediacodec.h0 h0Var, androidx.media3.common.r rVar) {
        return y2(this.F0, h0Var, rVar);
    }

    protected boolean s2(long j11, long j12, boolean z10) {
        return j11 < -30000 && !z10;
    }

    protected boolean t2(long j11, long j12) {
        return j11 < -30000 && j12 > 100000;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected t.a u0(androidx.media3.exoplayer.mediacodec.w wVar, androidx.media3.common.r rVar, MediaCrypto mediaCrypto, float f11) {
        String str = wVar.f12339c;
        e M12 = M1(wVar, rVar, y());
        this.P0 = M12;
        MediaFormat Q1 = Q1(rVar, str, M12, f11, this.J0, this.C1 ? this.D1 : 0);
        Surface R1 = R1(wVar);
        c2(Q1);
        return t.a.b(wVar, Q1, rVar, R1, mediaCrypto);
    }

    protected boolean u2() {
        return true;
    }

    protected boolean v2(androidx.media3.exoplayer.mediacodec.w wVar) {
        return a1.f10432a >= 35 && wVar.f12347k;
    }

    protected boolean w2(androidx.media3.exoplayer.mediacodec.w wVar) {
        return a1.f10432a >= 23 && !this.C1 && !E1(wVar.f12337a) && (!wVar.f12343g || PlaceholderSurface.isSecureSupported(this.F0));
    }

    protected void x2(androidx.media3.exoplayer.mediacodec.t tVar, int i11, long j11) {
        q0.a("skipVideoBuffer");
        tVar.k(i11, false);
        q0.b();
        this.f12249z0.f12118f++;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void z0(DecoderInputBuffer decoderInputBuffer) {
        if (this.R0) {
            ByteBuffer byteBuffer = (ByteBuffer) androidx.media3.common.util.a.e(decoderInputBuffer.f11003f);
            if (byteBuffer.remaining() >= 7) {
                byte b11 = byteBuffer.get();
                short s11 = byteBuffer.getShort();
                short s12 = byteBuffer.getShort();
                byte b12 = byteBuffer.get();
                byte b13 = byteBuffer.get();
                byteBuffer.position(0);
                if (b11 == -75 && s11 == 60 && s12 == 1 && b12 == 4) {
                    if (b13 == 0 || b13 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        m2((androidx.media3.exoplayer.mediacodec.t) androidx.media3.common.util.a.e(l0()), bArr);
                    }
                }
            }
        }
    }
}

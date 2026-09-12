package d2;

import android.graphics.Bitmap;
import androidx.media3.common.r;
import androidx.media3.common.util.q0;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.i;
import androidx.media3.exoplayer.image.ImageDecoderException;
import androidx.media3.exoplayer.image.ImageOutput;
import androidx.media3.exoplayer.s2;
import androidx.media3.exoplayer.x3;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import d2.c;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;

/* loaded from: classes2.dex */
public class e extends i {
    private int A;
    private r B;
    private c C;
    private DecoderInputBuffer D;
    private ImageOutput E;
    private Bitmap F;
    private boolean G;
    private b H;
    private b I;
    private int J;
    private boolean K;

    /* renamed from: r, reason: collision with root package name */
    private final c.a f61254r;

    /* renamed from: s, reason: collision with root package name */
    private final DecoderInputBuffer f61255s;

    /* renamed from: t, reason: collision with root package name */
    private final ArrayDeque f61256t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f61257u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f61258v;

    /* renamed from: w, reason: collision with root package name */
    private a f61259w;

    /* renamed from: x, reason: collision with root package name */
    private long f61260x;

    /* renamed from: y, reason: collision with root package name */
    private long f61261y;

    /* renamed from: z, reason: collision with root package name */
    private int f61262z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: c, reason: collision with root package name */
        public static final a f61263c = new a(C.TIME_UNSET, C.TIME_UNSET);

        /* renamed from: a, reason: collision with root package name */
        public final long f61264a;

        /* renamed from: b, reason: collision with root package name */
        public final long f61265b;

        public a(long j11, long j12) {
            this.f61264a = j11;
            this.f61265b = j12;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f61266a;

        /* renamed from: b, reason: collision with root package name */
        private final long f61267b;

        /* renamed from: c, reason: collision with root package name */
        private Bitmap f61268c;

        public b(int i11, long j11) {
            this.f61266a = i11;
            this.f61267b = j11;
        }

        public long a() {
            return this.f61267b;
        }

        public Bitmap b() {
            return this.f61268c;
        }

        public int c() {
            return this.f61266a;
        }

        public boolean d() {
            return this.f61268c != null;
        }

        public void e(Bitmap bitmap) {
            this.f61268c = bitmap;
        }
    }

    public e(c.a aVar, ImageOutput imageOutput) {
        super(4);
        this.f61254r = aVar;
        this.E = U(imageOutput);
        this.f61255s = DecoderInputBuffer.f();
        this.f61259w = a.f61263c;
        this.f61256t = new ArrayDeque();
        this.f61261y = C.TIME_UNSET;
        this.f61260x = C.TIME_UNSET;
        this.f61262z = 0;
        this.A = 1;
    }

    private boolean Q(r rVar) {
        int a11 = this.f61254r.a(rVar);
        return a11 == x3.a(4) || a11 == x3.a(3);
    }

    private Bitmap R(int i11) {
        androidx.media3.common.util.a.i(this.F);
        int width = this.F.getWidth() / ((r) androidx.media3.common.util.a.i(this.B)).L;
        int height = this.F.getHeight() / ((r) androidx.media3.common.util.a.i(this.B)).M;
        int i12 = this.B.L;
        return Bitmap.createBitmap(this.F, (i11 % i12) * width, (i11 / i12) * height, width, height);
    }

    private boolean S(long j11, long j12) {
        if (this.F != null && this.H == null) {
            return false;
        }
        if (this.A == 0 && getState() != 2) {
            return false;
        }
        if (this.F == null) {
            androidx.media3.common.util.a.i(this.C);
            d dequeueOutputBuffer = this.C.dequeueOutputBuffer();
            if (dequeueOutputBuffer == null) {
                return false;
            }
            if (((d) androidx.media3.common.util.a.i(dequeueOutputBuffer)).isEndOfStream()) {
                if (this.f61262z == 3) {
                    c0();
                    androidx.media3.common.util.a.i(this.B);
                    Y();
                } else {
                    ((d) androidx.media3.common.util.a.i(dequeueOutputBuffer)).release();
                    if (this.f61256t.isEmpty()) {
                        this.f61258v = true;
                    }
                }
                return false;
            }
            androidx.media3.common.util.a.j(dequeueOutputBuffer.f61253a, "Non-EOS buffer came back from the decoder without bitmap.");
            this.F = dequeueOutputBuffer.f61253a;
            ((d) androidx.media3.common.util.a.i(dequeueOutputBuffer)).release();
        }
        if (!this.G || this.F == null || this.H == null) {
            return false;
        }
        androidx.media3.common.util.a.i(this.B);
        r rVar = this.B;
        int i11 = rVar.L;
        boolean z10 = ((i11 == 1 && rVar.M == 1) || i11 == -1 || rVar.M == -1) ? false : true;
        if (!this.H.d()) {
            b bVar = this.H;
            bVar.e(z10 ? R(bVar.c()) : (Bitmap) androidx.media3.common.util.a.i(this.F));
        }
        if (!b0(j11, j12, (Bitmap) androidx.media3.common.util.a.i(this.H.b()), this.H.a())) {
            return false;
        }
        a0(((b) androidx.media3.common.util.a.i(this.H)).a());
        this.A = 3;
        if (!z10 || ((b) androidx.media3.common.util.a.i(this.H)).c() == (((r) androidx.media3.common.util.a.i(this.B)).M * ((r) androidx.media3.common.util.a.i(this.B)).L) - 1) {
            this.F = null;
        }
        this.H = this.I;
        this.I = null;
        return true;
    }

    private boolean T(long j11) {
        if (this.G && this.H != null) {
            return false;
        }
        s2 u11 = u();
        c cVar = this.C;
        if (cVar == null || this.f61262z == 3 || this.f61257u) {
            return false;
        }
        if (this.D == null) {
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) cVar.dequeueInputBuffer();
            this.D = decoderInputBuffer;
            if (decoderInputBuffer == null) {
                return false;
            }
        }
        if (this.f61262z == 2) {
            androidx.media3.common.util.a.i(this.D);
            this.D.setFlags(4);
            ((c) androidx.media3.common.util.a.i(this.C)).b(this.D);
            this.D = null;
            this.f61262z = 3;
            return false;
        }
        int N = N(u11, this.D, 0);
        if (N == -5) {
            this.B = (r) androidx.media3.common.util.a.i(u11.f12652b);
            this.K = true;
            this.f61262z = 2;
            return true;
        }
        if (N != -4) {
            if (N == -3) {
                return false;
            }
            throw new IllegalStateException();
        }
        this.D.d();
        ByteBuffer byteBuffer = this.D.f11000c;
        boolean z10 = (byteBuffer != null && byteBuffer.remaining() > 0) || ((DecoderInputBuffer) androidx.media3.common.util.a.i(this.D)).isEndOfStream();
        if (z10) {
            ((c) androidx.media3.common.util.a.i(this.C)).b((DecoderInputBuffer) androidx.media3.common.util.a.i(this.D));
            this.J = 0;
        }
        X(j11, (DecoderInputBuffer) androidx.media3.common.util.a.i(this.D));
        if (((DecoderInputBuffer) androidx.media3.common.util.a.i(this.D)).isEndOfStream()) {
            this.f61257u = true;
            this.D = null;
            return false;
        }
        this.f61261y = Math.max(this.f61261y, ((DecoderInputBuffer) androidx.media3.common.util.a.i(this.D)).f11002e);
        if (z10) {
            this.D = null;
        } else {
            ((DecoderInputBuffer) androidx.media3.common.util.a.i(this.D)).clear();
        }
        return !this.G;
    }

    private static ImageOutput U(ImageOutput imageOutput) {
        return imageOutput == null ? ImageOutput.f12112a : imageOutput;
    }

    private boolean V(b bVar) {
        return ((r) androidx.media3.common.util.a.i(this.B)).L == -1 || this.B.M == -1 || bVar.c() == (((r) androidx.media3.common.util.a.i(this.B)).M * this.B.L) - 1;
    }

    private void W(int i11) {
        this.A = Math.min(this.A, i11);
    }

    private void X(long j11, DecoderInputBuffer decoderInputBuffer) {
        boolean z10 = true;
        if (decoderInputBuffer.isEndOfStream()) {
            this.G = true;
            return;
        }
        b bVar = new b(this.J, decoderInputBuffer.f11002e);
        this.I = bVar;
        this.J++;
        if (!this.G) {
            long a11 = bVar.a();
            boolean z11 = a11 - 30000 <= j11 && j11 <= 30000 + a11;
            b bVar2 = this.H;
            boolean z12 = bVar2 != null && bVar2.a() <= j11 && j11 < a11;
            boolean V = V((b) androidx.media3.common.util.a.i(this.I));
            if (!z11 && !z12 && !V) {
                z10 = false;
            }
            this.G = z10;
            if (z12 && !z11) {
                return;
            }
        }
        this.H = this.I;
        this.I = null;
    }

    private boolean Y() {
        if (!Z()) {
            return false;
        }
        if (!this.K) {
            return true;
        }
        if (!Q((r) androidx.media3.common.util.a.e(this.B))) {
            throw q(new ImageDecoderException("Provided decoder factory can't create decoder for format."), this.B, 4005);
        }
        c cVar = this.C;
        if (cVar != null) {
            cVar.release();
        }
        this.C = this.f61254r.b();
        this.K = false;
        return true;
    }

    private void a0(long j11) {
        this.f61260x = j11;
        while (!this.f61256t.isEmpty() && j11 >= ((a) this.f61256t.peek()).f61264a) {
            this.f61259w = (a) this.f61256t.removeFirst();
        }
    }

    private void c0() {
        this.D = null;
        this.f61262z = 0;
        this.f61261y = C.TIME_UNSET;
        c cVar = this.C;
        if (cVar != null) {
            cVar.release();
            this.C = null;
        }
    }

    private void d0(ImageOutput imageOutput) {
        this.E = U(imageOutput);
    }

    private boolean e0() {
        boolean z10 = getState() == 2;
        int i11 = this.A;
        if (i11 == 0) {
            return z10;
        }
        if (i11 == 1) {
            return true;
        }
        if (i11 == 3) {
            return false;
        }
        throw new IllegalStateException();
    }

    @Override // androidx.media3.exoplayer.i
    protected void C() {
        this.B = null;
        this.f61259w = a.f61263c;
        this.f61256t.clear();
        c0();
        this.E.a();
    }

    @Override // androidx.media3.exoplayer.i
    protected void D(boolean z10, boolean z11) {
        this.A = z11 ? 1 : 0;
    }

    @Override // androidx.media3.exoplayer.i
    protected void F(long j11, boolean z10) {
        W(1);
        this.f61258v = false;
        this.f61257u = false;
        this.F = null;
        this.H = null;
        this.I = null;
        this.G = false;
        this.D = null;
        c cVar = this.C;
        if (cVar != null) {
            cVar.flush();
        }
        this.f61256t.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.i
    public void G() {
        c0();
    }

    @Override // androidx.media3.exoplayer.i
    protected void I() {
        c0();
        W(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        if (r2 >= r5) goto L14;
     */
    @Override // androidx.media3.exoplayer.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void L(androidx.media3.common.r[] r5, long r6, long r8, androidx.media3.exoplayer.source.r.b r10) {
        /*
            r4 = this;
            super.L(r5, r6, r8, r10)
            d2.e$a r5 = r4.f61259w
            long r5 = r5.f61265b
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r5 == 0) goto L36
            java.util.ArrayDeque r5 = r4.f61256t
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L29
            long r5 = r4.f61261y
            int r7 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r7 == 0) goto L36
            long r2 = r4.f61260x
            int r7 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r7 == 0) goto L29
            int r5 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r5 < 0) goto L29
            goto L36
        L29:
            java.util.ArrayDeque r5 = r4.f61256t
            d2.e$a r6 = new d2.e$a
            long r0 = r4.f61261y
            r6.<init>(r0, r8)
            r5.add(r6)
            goto L3d
        L36:
            d2.e$a r5 = new d2.e$a
            r5.<init>(r0, r8)
            r4.f61259w = r5
        L3d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.e.L(androidx.media3.common.r[], long, long, androidx.media3.exoplayer.source.r$b):void");
    }

    protected boolean Z() {
        return true;
    }

    @Override // androidx.media3.exoplayer.y3
    public int a(r rVar) {
        return this.f61254r.a(rVar);
    }

    protected boolean b0(long j11, long j12, Bitmap bitmap, long j13) {
        long j14 = j13 - j11;
        if (!e0() && j14 >= 30000) {
            return false;
        }
        this.E.onImageAvailable(j13 - this.f61259w.f61265b, bitmap);
        return true;
    }

    @Override // androidx.media3.exoplayer.w3, androidx.media3.exoplayer.y3
    public String getName() {
        return "ImageRenderer";
    }

    @Override // androidx.media3.exoplayer.i, androidx.media3.exoplayer.t3.b
    public void handleMessage(int i11, Object obj) {
        if (i11 != 15) {
            super.handleMessage(i11, obj);
        } else {
            d0(obj instanceof ImageOutput ? (ImageOutput) obj : null);
        }
    }

    @Override // androidx.media3.exoplayer.w3
    public boolean isEnded() {
        return this.f61258v;
    }

    @Override // androidx.media3.exoplayer.w3
    public boolean isReady() {
        int i11 = this.A;
        return i11 == 3 || (i11 == 0 && this.G);
    }

    @Override // androidx.media3.exoplayer.w3
    public void render(long j11, long j12) {
        if (this.f61258v) {
            return;
        }
        if (this.B == null) {
            s2 u11 = u();
            this.f61255s.clear();
            int N = N(u11, this.f61255s, 2);
            if (N != -5) {
                if (N == -4) {
                    androidx.media3.common.util.a.g(this.f61255s.isEndOfStream());
                    this.f61257u = true;
                    this.f61258v = true;
                    return;
                }
                return;
            }
            this.B = (r) androidx.media3.common.util.a.i(u11.f12652b);
            this.K = true;
        }
        if (this.C != null || Y()) {
            try {
                q0.a("drainAndFeedDecoder");
                do {
                } while (S(j11, j12));
                do {
                } while (T(j11));
                q0.b();
            } catch (ImageDecoderException e11) {
                throw q(e11, null, 4003);
            }
        }
    }
}

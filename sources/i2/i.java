package i2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.u;
import androidx.media3.common.y;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.s2;
import androidx.media3.exoplayer.source.r;
import androidx.media3.exoplayer.x3;
import androidx.media3.extractor.text.SubtitleDecoderException;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import i3.k;
import i3.l;
import i3.o;
import i3.p;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class i extends androidx.media3.exoplayer.i implements Handler.Callback {
    private p A;
    private int B;
    private final Handler C;
    private final h D;
    private final s2 E;
    private boolean F;
    private boolean G;
    private r H;
    private long I;
    private long J;
    private boolean K;
    private IOException L;

    /* renamed from: r, reason: collision with root package name */
    private final i3.b f65010r;

    /* renamed from: s, reason: collision with root package name */
    private final DecoderInputBuffer f65011s;

    /* renamed from: t, reason: collision with root package name */
    private a f65012t;

    /* renamed from: u, reason: collision with root package name */
    private final g f65013u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f65014v;

    /* renamed from: w, reason: collision with root package name */
    private int f65015w;

    /* renamed from: x, reason: collision with root package name */
    private l f65016x;

    /* renamed from: y, reason: collision with root package name */
    private o f65017y;

    /* renamed from: z, reason: collision with root package name */
    private p f65018z;

    public i(h hVar, Looper looper) {
        this(hVar, looper, g.f65008a);
    }

    public i(h hVar, Looper looper, g gVar) {
        super(3);
        this.D = (h) androidx.media3.common.util.a.e(hVar);
        this.C = looper == null ? null : a1.z(looper, this);
        this.f65013u = gVar;
        this.f65010r = new i3.b();
        this.f65011s = new DecoderInputBuffer(1);
        this.E = new s2();
        this.J = C.TIME_UNSET;
        this.I = C.TIME_UNSET;
        this.K = false;
    }

    private void Q() {
        androidx.media3.common.util.a.h(this.K || Objects.equals(this.H.f10243o, MimeTypes.APPLICATION_CEA608) || Objects.equals(this.H.f10243o, MimeTypes.APPLICATION_MP4CEA608) || Objects.equals(this.H.f10243o, MimeTypes.APPLICATION_CEA708), "Legacy decoding is disabled, can't handle " + this.H.f10243o + " samples (expected application/x-media3-cues).");
    }

    private void R() {
        h0(new u1.b(ImmutableList.of(), U(this.I)));
    }

    private long S(long j11) {
        int nextEventTimeIndex = this.f65018z.getNextEventTimeIndex(j11);
        if (nextEventTimeIndex == 0 || this.f65018z.getEventTimeCount() == 0) {
            return this.f65018z.timeUs;
        }
        if (nextEventTimeIndex != -1) {
            return this.f65018z.getEventTime(nextEventTimeIndex - 1);
        }
        return this.f65018z.getEventTime(r2.getEventTimeCount() - 1);
    }

    private long T() {
        if (this.B == -1) {
            return Long.MAX_VALUE;
        }
        androidx.media3.common.util.a.e(this.f65018z);
        if (this.B >= this.f65018z.getEventTimeCount()) {
            return Long.MAX_VALUE;
        }
        return this.f65018z.getEventTime(this.B);
    }

    private long U(long j11) {
        androidx.media3.common.util.a.g(j11 != C.TIME_UNSET);
        return j11 - z();
    }

    private void V(SubtitleDecoderException subtitleDecoderException) {
        u.d("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.H, subtitleDecoderException);
        R();
        f0();
    }

    private static boolean W(k kVar, long j11) {
        return kVar == null || kVar.getEventTime(kVar.getEventTimeCount() - 1) <= j11;
    }

    private void X() {
        this.f65014v = true;
        l b11 = this.f65013u.b((r) androidx.media3.common.util.a.e(this.H));
        this.f65016x = b11;
        b11.a(w());
    }

    private void Y(u1.b bVar) {
        this.D.onCues(bVar.f76718a);
        this.D.onCues(bVar);
    }

    private static boolean Z(r rVar) {
        return Objects.equals(rVar.f10243o, "application/x-media3-cues");
    }

    private boolean a0(long j11) {
        if (this.F || N(this.E, this.f65011s, 0) != -4) {
            return false;
        }
        if (this.f65011s.isEndOfStream()) {
            this.F = true;
            return false;
        }
        this.f65011s.d();
        ByteBuffer byteBuffer = (ByteBuffer) androidx.media3.common.util.a.e(this.f65011s.f11000c);
        i3.e a11 = this.f65010r.a(this.f65011s.f11002e, byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
        this.f65011s.clear();
        return this.f65012t.d(a11, j11);
    }

    private void b0() {
        this.f65017y = null;
        this.B = -1;
        p pVar = this.f65018z;
        if (pVar != null) {
            pVar.release();
            this.f65018z = null;
        }
        p pVar2 = this.A;
        if (pVar2 != null) {
            pVar2.release();
            this.A = null;
        }
    }

    private void c0() {
        b0();
        ((l) androidx.media3.common.util.a.e(this.f65016x)).release();
        this.f65016x = null;
        this.f65015w = 0;
    }

    private void d0(long j11) {
        boolean a02 = a0(j11);
        long c11 = this.f65012t.c(this.I);
        if (c11 == Long.MIN_VALUE && this.F && !a02) {
            this.G = true;
        }
        if (c11 != Long.MIN_VALUE && c11 <= j11) {
            a02 = true;
        }
        if (a02) {
            ImmutableList a11 = this.f65012t.a(j11);
            long b11 = this.f65012t.b(j11);
            h0(new u1.b(a11, U(b11)));
            this.f65012t.e(b11);
        }
        this.I = j11;
    }

    private void e0(long j11) {
        boolean z10;
        this.I = j11;
        if (this.A == null) {
            ((l) androidx.media3.common.util.a.e(this.f65016x)).setPositionUs(j11);
            try {
                this.A = (p) ((l) androidx.media3.common.util.a.e(this.f65016x)).dequeueOutputBuffer();
            } catch (SubtitleDecoderException e11) {
                V(e11);
                return;
            }
        }
        if (getState() != 2) {
            return;
        }
        if (this.f65018z != null) {
            long T = T();
            z10 = false;
            while (T <= j11) {
                this.B++;
                T = T();
                z10 = true;
            }
        } else {
            z10 = false;
        }
        p pVar = this.A;
        if (pVar != null) {
            if (pVar.isEndOfStream()) {
                if (!z10 && T() == Long.MAX_VALUE) {
                    if (this.f65015w == 2) {
                        f0();
                    } else {
                        b0();
                        this.G = true;
                    }
                }
            } else if (pVar.timeUs <= j11) {
                p pVar2 = this.f65018z;
                if (pVar2 != null) {
                    pVar2.release();
                }
                this.B = pVar.getNextEventTimeIndex(j11);
                this.f65018z = pVar;
                this.A = null;
                z10 = true;
            }
        }
        if (z10) {
            androidx.media3.common.util.a.e(this.f65018z);
            h0(new u1.b(this.f65018z.getCues(j11), U(S(j11))));
        }
        if (this.f65015w == 2) {
            return;
        }
        while (!this.F) {
            try {
                o oVar = this.f65017y;
                if (oVar == null) {
                    oVar = (o) ((l) androidx.media3.common.util.a.e(this.f65016x)).dequeueInputBuffer();
                    if (oVar == null) {
                        return;
                    } else {
                        this.f65017y = oVar;
                    }
                }
                if (this.f65015w == 1) {
                    oVar.setFlags(4);
                    ((l) androidx.media3.common.util.a.e(this.f65016x)).queueInputBuffer(oVar);
                    this.f65017y = null;
                    this.f65015w = 2;
                    return;
                }
                int N = N(this.E, oVar, 0);
                if (N == -4) {
                    if (oVar.isEndOfStream()) {
                        this.F = true;
                        this.f65014v = false;
                    } else {
                        r rVar = this.E.f12652b;
                        if (rVar == null) {
                            return;
                        }
                        oVar.f65042i = rVar.f10248t;
                        oVar.d();
                        this.f65014v &= !oVar.isKeyFrame();
                    }
                    if (!this.f65014v) {
                        ((l) androidx.media3.common.util.a.e(this.f65016x)).queueInputBuffer(oVar);
                        this.f65017y = null;
                    }
                } else if (N == -3) {
                    return;
                }
            } catch (SubtitleDecoderException e12) {
                V(e12);
                return;
            }
        }
    }

    private void f0() {
        c0();
        X();
    }

    private void h0(u1.b bVar) {
        Handler handler = this.C;
        if (handler != null) {
            handler.obtainMessage(1, bVar).sendToTarget();
        } else {
            Y(bVar);
        }
    }

    @Override // androidx.media3.exoplayer.i
    protected void C() {
        this.H = null;
        this.J = C.TIME_UNSET;
        R();
        this.I = C.TIME_UNSET;
        if (this.f65016x != null) {
            c0();
        }
    }

    @Override // androidx.media3.exoplayer.i
    protected void F(long j11, boolean z10) {
        this.I = j11;
        a aVar = this.f65012t;
        if (aVar != null) {
            aVar.clear();
        }
        R();
        this.F = false;
        this.G = false;
        this.J = C.TIME_UNSET;
        r rVar = this.H;
        if (rVar == null || Z(rVar)) {
            return;
        }
        if (this.f65015w != 0) {
            f0();
            return;
        }
        b0();
        l lVar = (l) androidx.media3.common.util.a.e(this.f65016x);
        lVar.flush();
        lVar.a(w());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.i
    public void L(r[] rVarArr, long j11, long j12, r.b bVar) {
        androidx.media3.common.r rVar = rVarArr[0];
        this.H = rVar;
        if (Z(rVar)) {
            this.f65012t = this.H.K == 1 ? new e() : new f();
            return;
        }
        Q();
        if (this.f65016x != null) {
            this.f65015w = 1;
        } else {
            X();
        }
    }

    @Override // androidx.media3.exoplayer.y3
    public int a(androidx.media3.common.r rVar) {
        if (Z(rVar) || this.f65013u.a(rVar)) {
            return x3.a(rVar.N == 0 ? 4 : 2);
        }
        return y.s(rVar.f10243o) ? x3.a(1) : x3.a(0);
    }

    public void g0(long j11) {
        androidx.media3.common.util.a.g(isCurrentStreamFinal());
        this.J = j11;
    }

    @Override // androidx.media3.exoplayer.w3, androidx.media3.exoplayer.y3
    public String getName() {
        return "TextRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            throw new IllegalStateException();
        }
        Y((u1.b) message.obj);
        return true;
    }

    @Override // androidx.media3.exoplayer.w3
    public boolean isEnded() {
        return this.G;
    }

    @Override // androidx.media3.exoplayer.w3
    public boolean isReady() {
        if (this.H == null) {
            return true;
        }
        if (this.L == null) {
            try {
                maybeThrowStreamError();
            } catch (IOException e11) {
                this.L = e11;
            }
        }
        if (this.L != null) {
            if (Z((androidx.media3.common.r) androidx.media3.common.util.a.e(this.H))) {
                return ((a) androidx.media3.common.util.a.e(this.f65012t)).c(this.I) != Long.MIN_VALUE;
            }
            if (this.G || (this.F && W(this.f65018z, this.I) && W(this.A, this.I) && this.f65017y != null)) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.media3.exoplayer.w3
    public void render(long j11, long j12) {
        if (isCurrentStreamFinal()) {
            long j13 = this.J;
            if (j13 != C.TIME_UNSET && j11 >= j13) {
                b0();
                this.G = true;
            }
        }
        if (this.G) {
            return;
        }
        if (Z((androidx.media3.common.r) androidx.media3.common.util.a.e(this.H))) {
            androidx.media3.common.util.a.e(this.f65012t);
            d0(j11);
        } else {
            Q();
            e0(j11);
        }
    }
}

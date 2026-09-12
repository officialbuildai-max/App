package ba;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.w;
import com.google.android.exoplayer2.y2;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class p extends com.google.android.exoplayer2.h implements Handler.Callback {
    private int A;
    private long B;

    /* renamed from: n, reason: collision with root package name */
    private final Handler f16395n;

    /* renamed from: o, reason: collision with root package name */
    private final o f16396o;

    /* renamed from: p, reason: collision with root package name */
    private final k f16397p;

    /* renamed from: q, reason: collision with root package name */
    private final p1 f16398q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f16399r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f16400s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f16401t;

    /* renamed from: u, reason: collision with root package name */
    private int f16402u;

    /* renamed from: v, reason: collision with root package name */
    private o1 f16403v;

    /* renamed from: w, reason: collision with root package name */
    private j f16404w;

    /* renamed from: x, reason: collision with root package name */
    private m f16405x;

    /* renamed from: y, reason: collision with root package name */
    private n f16406y;

    /* renamed from: z, reason: collision with root package name */
    private n f16407z;

    public p(o oVar, Looper looper) {
        this(oVar, looper, k.f16380a);
    }

    public p(o oVar, Looper looper, k kVar) {
        super(3);
        this.f16396o = (o) com.google.android.exoplayer2.util.a.e(oVar);
        this.f16395n = looper == null ? null : p0.v(looper, this);
        this.f16397p = kVar;
        this.f16398q = new p1();
        this.B = C.TIME_UNSET;
    }

    private long A() {
        if (this.A == -1) {
            return Long.MAX_VALUE;
        }
        com.google.android.exoplayer2.util.a.e(this.f16406y);
        if (this.A >= this.f16406y.getEventTimeCount()) {
            return Long.MAX_VALUE;
        }
        return this.f16406y.getEventTime(this.A);
    }

    private void B(SubtitleDecoderException subtitleDecoderException) {
        s.d("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.f16403v, subtitleDecoderException);
        z();
        G();
    }

    private void C() {
        this.f16401t = true;
        this.f16404w = this.f16397p.b((o1) com.google.android.exoplayer2.util.a.e(this.f16403v));
    }

    private void D(List list) {
        this.f16396o.onCues(list);
        this.f16396o.onCues(new f(list));
    }

    private void E() {
        this.f16405x = null;
        this.A = -1;
        n nVar = this.f16406y;
        if (nVar != null) {
            nVar.l();
            this.f16406y = null;
        }
        n nVar2 = this.f16407z;
        if (nVar2 != null) {
            nVar2.l();
            this.f16407z = null;
        }
    }

    private void F() {
        E();
        ((j) com.google.android.exoplayer2.util.a.e(this.f16404w)).release();
        this.f16404w = null;
        this.f16402u = 0;
    }

    private void G() {
        F();
        C();
    }

    private void I(List list) {
        Handler handler = this.f16395n;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            D(list);
        }
    }

    private void z() {
        I(Collections.emptyList());
    }

    public void H(long j11) {
        com.google.android.exoplayer2.util.a.g(isCurrentStreamFinal());
        this.B = j11;
    }

    @Override // com.google.android.exoplayer2.z2
    public int a(o1 o1Var) {
        if (this.f16397p.a(o1Var)) {
            return y2.a(o1Var.E == 0 ? 4 : 2);
        }
        return w.s(o1Var.f25550l) ? y2.a(1) : y2.a(0);
    }

    @Override // com.google.android.exoplayer2.x2, com.google.android.exoplayer2.z2
    public String getName() {
        return "TextRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        D((List) message.obj);
        return true;
    }

    @Override // com.google.android.exoplayer2.x2
    public boolean isEnded() {
        return this.f16400s;
    }

    @Override // com.google.android.exoplayer2.x2
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.h
    protected void p() {
        this.f16403v = null;
        this.B = C.TIME_UNSET;
        z();
        F();
    }

    @Override // com.google.android.exoplayer2.h
    protected void r(long j11, boolean z10) {
        z();
        this.f16399r = false;
        this.f16400s = false;
        this.B = C.TIME_UNSET;
        if (this.f16402u != 0) {
            G();
        } else {
            E();
            ((j) com.google.android.exoplayer2.util.a.e(this.f16404w)).flush();
        }
    }

    @Override // com.google.android.exoplayer2.x2
    public void render(long j11, long j12) {
        boolean z10;
        if (isCurrentStreamFinal()) {
            long j13 = this.B;
            if (j13 != C.TIME_UNSET && j11 >= j13) {
                E();
                this.f16400s = true;
            }
        }
        if (this.f16400s) {
            return;
        }
        if (this.f16407z == null) {
            ((j) com.google.android.exoplayer2.util.a.e(this.f16404w)).setPositionUs(j11);
            try {
                this.f16407z = (n) ((j) com.google.android.exoplayer2.util.a.e(this.f16404w)).dequeueOutputBuffer();
            } catch (SubtitleDecoderException e11) {
                B(e11);
                return;
            }
        }
        if (getState() != 2) {
            return;
        }
        if (this.f16406y != null) {
            long A = A();
            z10 = false;
            while (A <= j11) {
                this.A++;
                A = A();
                z10 = true;
            }
        } else {
            z10 = false;
        }
        n nVar = this.f16407z;
        if (nVar != null) {
            if (nVar.h()) {
                if (!z10 && A() == Long.MAX_VALUE) {
                    if (this.f16402u == 2) {
                        G();
                    } else {
                        E();
                        this.f16400s = true;
                    }
                }
            } else if (nVar.f24941b <= j11) {
                n nVar2 = this.f16406y;
                if (nVar2 != null) {
                    nVar2.l();
                }
                this.A = nVar.getNextEventTimeIndex(j11);
                this.f16406y = nVar;
                this.f16407z = null;
                z10 = true;
            }
        }
        if (z10) {
            com.google.android.exoplayer2.util.a.e(this.f16406y);
            I(this.f16406y.getCues(j11));
        }
        if (this.f16402u == 2) {
            return;
        }
        while (!this.f16399r) {
            try {
                m mVar = this.f16405x;
                if (mVar == null) {
                    mVar = (m) ((j) com.google.android.exoplayer2.util.a.e(this.f16404w)).dequeueInputBuffer();
                    if (mVar == null) {
                        return;
                    } else {
                        this.f16405x = mVar;
                    }
                }
                if (this.f16402u == 1) {
                    mVar.k(4);
                    ((j) com.google.android.exoplayer2.util.a.e(this.f16404w)).queueInputBuffer(mVar);
                    this.f16405x = null;
                    this.f16402u = 2;
                    return;
                }
                int w11 = w(this.f16398q, mVar, 0);
                if (w11 == -4) {
                    if (mVar.h()) {
                        this.f16399r = true;
                        this.f16401t = false;
                    } else {
                        o1 o1Var = this.f16398q.f25652b;
                        if (o1Var == null) {
                            return;
                        }
                        mVar.f16392i = o1Var.f25554p;
                        mVar.n();
                        this.f16401t &= !mVar.j();
                    }
                    if (!this.f16401t) {
                        ((j) com.google.android.exoplayer2.util.a.e(this.f16404w)).queueInputBuffer(mVar);
                        this.f16405x = null;
                    }
                } else if (w11 == -3) {
                    return;
                }
            } catch (SubtitleDecoderException e12) {
                B(e12);
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.h
    protected void v(o1[] o1VarArr, long j11, long j12) {
        this.f16403v = o1VarArr[0];
        if (this.f16404w != null) {
            this.f16402u = 1;
        } else {
            C();
        }
    }
}

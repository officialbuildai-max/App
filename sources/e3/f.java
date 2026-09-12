package e3;

import android.net.Uri;
import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.j0;
import androidx.media3.common.util.u;
import androidx.media3.common.x;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import e3.g;
import i3.s;
import java.io.EOFException;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import l2.e0;
import l2.g0;
import l2.i0;
import l2.l0;
import l2.n;
import l2.q;
import l2.r;
import l2.s0;
import l2.t;
import l2.w;
import l2.x;
import z2.h;
import z2.l;

/* loaded from: classes2.dex */
public final class f implements r {

    /* renamed from: v, reason: collision with root package name */
    public static final x f61632v = new x() { // from class: e3.d
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
            r[] q11;
            q11 = f.q();
            return q11;
        }

        @Override // l2.x
        public /* synthetic */ x d(boolean z10) {
            return w.c(this, z10);
        }
    };

    /* renamed from: w, reason: collision with root package name */
    private static final h.a f61633w = new h.a() { // from class: e3.e
        @Override // z2.h.a
        public final boolean evaluate(int i11, int i12, int i13, int i14, int i15) {
            boolean r11;
            r11 = f.r(i11, i12, i13, i14, i15);
            return r11;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final int f61634a;

    /* renamed from: b, reason: collision with root package name */
    private final long f61635b;

    /* renamed from: c, reason: collision with root package name */
    private final j0 f61636c;

    /* renamed from: d, reason: collision with root package name */
    private final i0.a f61637d;

    /* renamed from: e, reason: collision with root package name */
    private final e0 f61638e;

    /* renamed from: f, reason: collision with root package name */
    private final g0 f61639f;

    /* renamed from: g, reason: collision with root package name */
    private final s0 f61640g;

    /* renamed from: h, reason: collision with root package name */
    private t f61641h;

    /* renamed from: i, reason: collision with root package name */
    private s0 f61642i;

    /* renamed from: j, reason: collision with root package name */
    private s0 f61643j;

    /* renamed from: k, reason: collision with root package name */
    private int f61644k;

    /* renamed from: l, reason: collision with root package name */
    private androidx.media3.common.x f61645l;

    /* renamed from: m, reason: collision with root package name */
    private long f61646m;

    /* renamed from: n, reason: collision with root package name */
    private long f61647n;

    /* renamed from: o, reason: collision with root package name */
    private long f61648o;

    /* renamed from: p, reason: collision with root package name */
    private long f61649p;

    /* renamed from: q, reason: collision with root package name */
    private int f61650q;

    /* renamed from: r, reason: collision with root package name */
    private g f61651r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f61652s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f61653t;

    /* renamed from: u, reason: collision with root package name */
    private long f61654u;

    public f() {
        this(0);
    }

    public f(int i11) {
        this(i11, C.TIME_UNSET);
    }

    public f(int i11, long j11) {
        this.f61634a = (i11 & 2) != 0 ? i11 | 1 : i11;
        this.f61635b = j11;
        this.f61636c = new j0(10);
        this.f61637d = new i0.a();
        this.f61638e = new e0();
        this.f61646m = C.TIME_UNSET;
        this.f61639f = new g0();
        n nVar = new n();
        this.f61640g = nVar;
        this.f61643j = nVar;
        this.f61649p = -1L;
    }

    private void h() {
        androidx.media3.common.util.a.i(this.f61642i);
        a1.i(this.f61641h);
    }

    private g i(l2.s sVar) {
        long n11;
        long j11;
        g t11 = t(sVar);
        c s11 = s(this.f61645l, sVar.getPosition());
        if (this.f61652s) {
            return new g.a();
        }
        if ((this.f61634a & 4) != 0) {
            if (s11 != null) {
                n11 = s11.getDurationUs();
                j11 = s11.a();
            } else if (t11 != null) {
                n11 = t11.getDurationUs();
                j11 = t11.a();
            } else {
                n11 = n(this.f61645l);
                j11 = -1;
            }
            t11 = new b(n11, sVar.getPosition(), j11);
        } else if (s11 != null) {
            t11 = s11;
        } else if (t11 == null) {
            t11 = null;
        }
        if (t11 == null || (!t11.isSeekable() && (this.f61634a & 1) != 0)) {
            t11 = m(sVar, (this.f61634a & 2) != 0);
        }
        if (t11 != null) {
            this.f61642i.f(t11.getDurationUs());
        }
        return t11;
    }

    private long j(long j11) {
        return this.f61646m + ((j11 * 1000000) / this.f61637d.f68732d);
    }

    private g l(long j11, i iVar, long j12) {
        long j13;
        long j14;
        long a11 = iVar.a();
        if (a11 == C.TIME_UNSET) {
            return null;
        }
        long j15 = iVar.f61662c;
        if (j15 != -1) {
            long j16 = j11 + j15;
            j13 = j15 - iVar.f61660a.f68731c;
            j14 = j16;
        } else {
            if (j12 == -1) {
                return null;
            }
            j13 = (j12 - j11) - iVar.f61660a.f68731c;
            j14 = j12;
        }
        long j17 = j13;
        RoundingMode roundingMode = RoundingMode.HALF_UP;
        return new a(j14, j11 + iVar.f61660a.f68731c, Ints.d(a1.g1(j17, 8000000L, a11, roundingMode)), Ints.d(com.google.common.math.f.c(j17, iVar.f61661b, roundingMode)), false);
    }

    private g m(l2.s sVar, boolean z10) {
        sVar.peekFully(this.f61636c.e(), 0, 4);
        this.f61636c.W(0);
        this.f61637d.a(this.f61636c.q());
        return new a(sVar.getLength(), sVar.getPosition(), this.f61637d, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static long n(androidx.media3.common.x xVar) {
        if (xVar == null) {
            return C.TIME_UNSET;
        }
        int e11 = xVar.e();
        for (int i11 = 0; i11 < e11; i11++) {
            x.a d11 = xVar.d(i11);
            if (d11 instanceof z2.n) {
                z2.n nVar = (z2.n) d11;
                if (nVar.f79315a.equals("TLEN")) {
                    return a1.R0(Long.parseLong((String) nVar.f79329d.get(0)));
                }
            }
        }
        return C.TIME_UNSET;
    }

    private static int o(j0 j0Var, int i11) {
        if (j0Var.g() >= i11 + 4) {
            j0Var.W(i11);
            int q11 = j0Var.q();
            if (q11 == 1483304551 || q11 == 1231971951) {
                return q11;
            }
        }
        if (j0Var.g() < 40) {
            return 0;
        }
        j0Var.W(36);
        return j0Var.q() == 1447187017 ? 1447187017 : 0;
    }

    private static boolean p(int i11, long j11) {
        return ((long) (i11 & (-128000))) == (j11 & (-128000));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ r[] q() {
        return new r[]{new f()};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean r(int i11, int i12, int i13, int i14, int i15) {
        return (i12 == 67 && i13 == 79 && i14 == 77 && (i15 == 77 || i11 == 2)) || (i12 == 77 && i13 == 76 && i14 == 76 && (i15 == 84 || i11 == 2));
    }

    private static c s(androidx.media3.common.x xVar, long j11) {
        if (xVar == null) {
            return null;
        }
        int e11 = xVar.e();
        for (int i11 = 0; i11 < e11; i11++) {
            x.a d11 = xVar.d(i11);
            if (d11 instanceof l) {
                return c.b(j11, (l) d11, n(xVar));
            }
        }
        return null;
    }

    private g t(l2.s sVar) {
        int i11;
        int i12;
        j0 j0Var = new j0(this.f61637d.f68731c);
        sVar.peekFully(j0Var.e(), 0, this.f61637d.f68731c);
        i0.a aVar = this.f61637d;
        int i13 = 21;
        if ((aVar.f68729a & 1) != 0) {
            if (aVar.f68733e != 1) {
                i13 = 36;
            }
        } else if (aVar.f68733e == 1) {
            i13 = 13;
        }
        int o11 = o(j0Var, i13);
        if (o11 != 1231971951) {
            if (o11 == 1447187017) {
                h b11 = h.b(sVar.getLength(), sVar.getPosition(), this.f61637d, j0Var);
                sVar.skipFully(this.f61637d.f68731c);
                return b11;
            }
            if (o11 != 1483304551) {
                sVar.resetPeekPosition();
                return null;
            }
        }
        i b12 = i.b(this.f61637d, j0Var);
        if (!this.f61638e.a() && (i11 = b12.f61663d) != -1 && (i12 = b12.f61664e) != -1) {
            e0 e0Var = this.f61638e;
            e0Var.f68688a = i11;
            e0Var.f68689b = i12;
        }
        long position = sVar.getPosition();
        if (sVar.getLength() != -1 && b12.f61662c != -1 && sVar.getLength() != b12.f61662c + position) {
            u.f("Mp3Extractor", "Data size mismatch between stream (" + sVar.getLength() + ") and Xing frame (" + (b12.f61662c + position) + "), using Xing value.");
        }
        sVar.skipFully(this.f61637d.f68731c);
        return o11 == 1483304551 ? j.b(b12, position) : l(position, b12, sVar.getLength());
    }

    private void u() {
        g gVar = this.f61651r;
        if ((gVar instanceof a) && gVar.isSeekable()) {
            long j11 = this.f61649p;
            if (j11 == -1 || j11 == this.f61651r.a()) {
                return;
            }
            this.f61651r = ((a) this.f61651r).e(this.f61649p);
            ((t) androidx.media3.common.util.a.e(this.f61641h)).f(this.f61651r);
            ((s0) androidx.media3.common.util.a.e(this.f61642i)).f(this.f61651r.getDurationUs());
        }
    }

    private boolean v(l2.s sVar) {
        g gVar = this.f61651r;
        if (gVar != null) {
            long a11 = gVar.a();
            if (a11 != -1 && sVar.getPeekPosition() > a11 - 4) {
                return true;
            }
        }
        try {
            return !sVar.peekFully(this.f61636c.e(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    private int w(l2.s sVar) {
        if (this.f61644k == 0) {
            try {
                y(sVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.f61651r == null) {
            g i11 = i(sVar);
            this.f61651r = i11;
            this.f61641h.f(i11);
            r.b n02 = new r.b().U(MimeTypes.AUDIO_MPEG).u0(this.f61637d.f68730b).k0(4096).R(this.f61637d.f68733e).v0(this.f61637d.f68732d).Z(this.f61638e.f68688a).a0(this.f61638e.f68689b).n0((this.f61634a & 8) != 0 ? null : this.f61645l);
            if (this.f61651r.g() != -2147483647) {
                n02.Q(this.f61651r.g());
            }
            this.f61643j.c(n02.N());
            this.f61648o = sVar.getPosition();
        } else if (this.f61648o != 0) {
            long position = sVar.getPosition();
            long j11 = this.f61648o;
            if (position < j11) {
                sVar.skipFully((int) (j11 - position));
            }
        }
        return x(sVar);
    }

    private int x(l2.s sVar) {
        if (this.f61650q == 0) {
            sVar.resetPeekPosition();
            if (v(sVar)) {
                return -1;
            }
            this.f61636c.W(0);
            int q11 = this.f61636c.q();
            if (!p(q11, this.f61644k) || i0.j(q11) == -1) {
                sVar.skipFully(1);
                this.f61644k = 0;
                return 0;
            }
            this.f61637d.a(q11);
            if (this.f61646m == C.TIME_UNSET) {
                this.f61646m = this.f61651r.getTimeUs(sVar.getPosition());
                if (this.f61635b != C.TIME_UNSET) {
                    this.f61646m += this.f61635b - this.f61651r.getTimeUs(0L);
                }
            }
            this.f61650q = this.f61637d.f68731c;
            long position = sVar.getPosition();
            i0.a aVar = this.f61637d;
            this.f61649p = position + aVar.f68731c;
            g gVar = this.f61651r;
            if (gVar instanceof b) {
                b bVar = (b) gVar;
                bVar.c(j(this.f61647n + aVar.f68735g), this.f61649p);
                if (this.f61653t && bVar.b(this.f61654u)) {
                    this.f61653t = false;
                    this.f61643j = this.f61642i;
                }
            }
        }
        int e11 = this.f61643j.e(sVar, this.f61650q, true);
        if (e11 == -1) {
            return -1;
        }
        int i11 = this.f61650q - e11;
        this.f61650q = i11;
        if (i11 > 0) {
            return 0;
        }
        this.f61643j.d(j(this.f61647n), 1, this.f61637d.f68731c, 0, null);
        this.f61647n += this.f61637d.f68735g;
        this.f61650q = 0;
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x009e, code lost:
    
        if (r12 == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a0, code lost:
    
        r11.skipFully(r1 + r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a8, code lost:
    
        r10.f61644k = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00aa, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a5, code lost:
    
        r11.resetPeekPosition();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean y(l2.s r11, boolean r12) {
        /*
            r10 = this;
            if (r12 == 0) goto L6
            r0 = 32768(0x8000, float:4.5918E-41)
            goto L8
        L6:
            r0 = 131072(0x20000, float:1.83671E-40)
        L8:
            r11.resetPeekPosition()
            long r1 = r11.getPosition()
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r2 = 0
            if (r1 != 0) goto L3d
            int r1 = r10.f61634a
            r1 = r1 & 8
            if (r1 != 0) goto L1e
            r1 = 0
            goto L20
        L1e:
            z2.h$a r1 = e3.f.f61633w
        L20:
            l2.g0 r3 = r10.f61639f
            androidx.media3.common.x r1 = r3.a(r11, r1)
            r10.f61645l = r1
            if (r1 == 0) goto L2f
            l2.e0 r3 = r10.f61638e
            r3.c(r1)
        L2f:
            long r3 = r11.getPeekPosition()
            int r1 = (int) r3
            if (r12 != 0) goto L39
            r11.skipFully(r1)
        L39:
            r3 = r2
        L3a:
            r4 = r3
            r5 = r4
            goto L40
        L3d:
            r1 = r2
            r3 = r1
            goto L3a
        L40:
            boolean r6 = r10.v(r11)
            r7 = 1
            if (r6 == 0) goto L53
            if (r4 <= 0) goto L4a
            goto L9e
        L4a:
            r10.u()
            java.io.EOFException r11 = new java.io.EOFException
            r11.<init>()
            throw r11
        L53:
            androidx.media3.common.util.j0 r6 = r10.f61636c
            r6.W(r2)
            androidx.media3.common.util.j0 r6 = r10.f61636c
            int r6 = r6.q()
            if (r3 == 0) goto L67
            long r8 = (long) r3
            boolean r8 = p(r6, r8)
            if (r8 == 0) goto L6e
        L67:
            int r8 = l2.i0.j(r6)
            r9 = -1
            if (r8 != r9) goto L90
        L6e:
            int r3 = r5 + 1
            if (r5 != r0) goto L7e
            if (r12 == 0) goto L75
            return r2
        L75:
            r10.u()
            java.io.EOFException r11 = new java.io.EOFException
            r11.<init>()
            throw r11
        L7e:
            if (r12 == 0) goto L89
            r11.resetPeekPosition()
            int r4 = r1 + r3
            r11.advancePeekPosition(r4)
            goto L8c
        L89:
            r11.skipFully(r7)
        L8c:
            r4 = r2
            r5 = r3
            r3 = r4
            goto L40
        L90:
            int r4 = r4 + 1
            if (r4 != r7) goto L9b
            l2.i0$a r3 = r10.f61637d
            r3.a(r6)
            r3 = r6
            goto Lab
        L9b:
            r6 = 4
            if (r4 != r6) goto Lab
        L9e:
            if (r12 == 0) goto La5
            int r1 = r1 + r5
            r11.skipFully(r1)
            goto La8
        La5:
            r11.resetPeekPosition()
        La8:
            r10.f61644k = r3
            return r7
        Lab:
            int r8 = r8 + (-4)
            r11.advancePeekPosition(r8)
            goto L40
        */
        throw new UnsupportedOperationException("Method not decompiled: e3.f.y(l2.s, boolean):boolean");
    }

    @Override // l2.r
    public void b(t tVar) {
        this.f61641h = tVar;
        s0 track = tVar.track(0, 1);
        this.f61642i = track;
        this.f61643j = track;
        this.f61641h.endTracks();
    }

    @Override // l2.r
    public int c(l2.s sVar, l0 l0Var) {
        h();
        int w11 = w(sVar);
        if (w11 == -1 && (this.f61651r instanceof b)) {
            long j11 = j(this.f61647n);
            if (this.f61651r.getDurationUs() != j11) {
                ((b) this.f61651r).d(j11);
                this.f61641h.f(this.f61651r);
                this.f61642i.f(this.f61651r.getDurationUs());
            }
        }
        return w11;
    }

    @Override // l2.r
    public boolean d(l2.s sVar) {
        return y(sVar, true);
    }

    @Override // l2.r
    public /* synthetic */ l2.r e() {
        return q.b(this);
    }

    @Override // l2.r
    public /* synthetic */ List f() {
        return q.a(this);
    }

    public void k() {
        this.f61652s = true;
    }

    @Override // l2.r
    public void release() {
    }

    @Override // l2.r
    public void seek(long j11, long j12) {
        this.f61644k = 0;
        this.f61646m = C.TIME_UNSET;
        this.f61647n = 0L;
        this.f61650q = 0;
        this.f61654u = j12;
        g gVar = this.f61651r;
        if (!(gVar instanceof b) || ((b) gVar).b(j12)) {
            return;
        }
        this.f61653t = true;
        this.f61643j = this.f61640g;
    }
}

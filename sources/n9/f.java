package n9;

import android.net.Uri;
import com.google.android.exoplayer2.audio.b0;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.b;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import g9.a0;
import g9.e0;
import g9.k;
import g9.l;
import g9.m;
import g9.n;
import g9.q;
import g9.r;
import g9.x;
import g9.y;
import java.io.EOFException;
import java.util.Map;
import n9.g;

/* loaded from: classes4.dex */
public final class f implements l {

    /* renamed from: u, reason: collision with root package name */
    public static final r f70382u = new r() { // from class: n9.d
        @Override // g9.r
        public /* synthetic */ l[] c(Uri uri, Map map) {
            return q.a(this, uri, map);
        }

        @Override // g9.r
        public final l[] createExtractors() {
            l[] n11;
            n11 = f.n();
            return n11;
        }
    };

    /* renamed from: v, reason: collision with root package name */
    private static final b.a f70383v = new b.a() { // from class: n9.e
        @Override // com.google.android.exoplayer2.metadata.id3.b.a
        public final boolean evaluate(int i11, int i12, int i13, int i14, int i15) {
            boolean o11;
            o11 = f.o(i11, i12, i13, i14, i15);
            return o11;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final int f70384a;

    /* renamed from: b, reason: collision with root package name */
    private final long f70385b;

    /* renamed from: c, reason: collision with root package name */
    private final d0 f70386c;

    /* renamed from: d, reason: collision with root package name */
    private final b0.a f70387d;

    /* renamed from: e, reason: collision with root package name */
    private final x f70388e;

    /* renamed from: f, reason: collision with root package name */
    private final y f70389f;

    /* renamed from: g, reason: collision with root package name */
    private final e0 f70390g;

    /* renamed from: h, reason: collision with root package name */
    private n f70391h;

    /* renamed from: i, reason: collision with root package name */
    private e0 f70392i;

    /* renamed from: j, reason: collision with root package name */
    private e0 f70393j;

    /* renamed from: k, reason: collision with root package name */
    private int f70394k;

    /* renamed from: l, reason: collision with root package name */
    private Metadata f70395l;

    /* renamed from: m, reason: collision with root package name */
    private long f70396m;

    /* renamed from: n, reason: collision with root package name */
    private long f70397n;

    /* renamed from: o, reason: collision with root package name */
    private long f70398o;

    /* renamed from: p, reason: collision with root package name */
    private int f70399p;

    /* renamed from: q, reason: collision with root package name */
    private g f70400q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f70401r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f70402s;

    /* renamed from: t, reason: collision with root package name */
    private long f70403t;

    public f() {
        this(0);
    }

    public f(int i11) {
        this(i11, C.TIME_UNSET);
    }

    public f(int i11, long j11) {
        this.f70384a = (i11 & 2) != 0 ? i11 | 1 : i11;
        this.f70385b = j11;
        this.f70386c = new d0(10);
        this.f70387d = new b0.a();
        this.f70388e = new x();
        this.f70396m = C.TIME_UNSET;
        this.f70389f = new y();
        k kVar = new k();
        this.f70390g = kVar;
        this.f70393j = kVar;
    }

    private void f() {
        com.google.android.exoplayer2.util.a.i(this.f70392i);
        p0.j(this.f70391h);
    }

    private g g(m mVar) {
        long k11;
        long j11;
        g q11 = q(mVar);
        c p11 = p(this.f70395l, mVar.getPosition());
        if (this.f70401r) {
            return new g.a();
        }
        if ((this.f70384a & 4) != 0) {
            if (p11 != null) {
                k11 = p11.getDurationUs();
                j11 = p11.a();
            } else if (q11 != null) {
                k11 = q11.getDurationUs();
                j11 = q11.a();
            } else {
                k11 = k(this.f70395l);
                j11 = -1;
            }
            q11 = new b(k11, mVar.getPosition(), j11);
        } else if (p11 != null) {
            q11 = p11;
        } else if (q11 == null) {
            q11 = null;
        }
        if (q11 == null || !(q11.isSeekable() || (this.f70384a & 1) == 0)) {
            return j(mVar, (this.f70384a & 2) != 0);
        }
        return q11;
    }

    private long h(long j11) {
        return this.f70396m + ((j11 * 1000000) / this.f70387d.f24678d);
    }

    private g j(m mVar, boolean z10) {
        mVar.peekFully(this.f70386c.d(), 0, 4);
        this.f70386c.P(0);
        this.f70387d.a(this.f70386c.n());
        return new a(mVar.getLength(), mVar.getPosition(), this.f70387d, z10);
    }

    private static long k(Metadata metadata) {
        if (metadata == null) {
            return C.TIME_UNSET;
        }
        int length = metadata.length();
        for (int i11 = 0; i11 < length; i11++) {
            Metadata.Entry entry = metadata.get(i11);
            if (entry instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) entry;
                if (textInformationFrame.f25489id.equals("TLEN")) {
                    return p0.B0(Long.parseLong(textInformationFrame.value));
                }
            }
        }
        return C.TIME_UNSET;
    }

    private static int l(d0 d0Var, int i11) {
        if (d0Var.f() >= i11 + 4) {
            d0Var.P(i11);
            int n11 = d0Var.n();
            if (n11 == 1483304551 || n11 == 1231971951) {
                return n11;
            }
        }
        if (d0Var.f() < 40) {
            return 0;
        }
        d0Var.P(36);
        return d0Var.n() == 1447187017 ? 1447187017 : 0;
    }

    private static boolean m(int i11, long j11) {
        return ((long) (i11 & (-128000))) == (j11 & (-128000));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] n() {
        return new l[]{new f()};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean o(int i11, int i12, int i13, int i14, int i15) {
        return (i12 == 67 && i13 == 79 && i14 == 77 && (i15 == 77 || i11 == 2)) || (i12 == 77 && i13 == 76 && i14 == 76 && (i15 == 84 || i11 == 2));
    }

    private static c p(Metadata metadata, long j11) {
        if (metadata == null) {
            return null;
        }
        int length = metadata.length();
        for (int i11 = 0; i11 < length; i11++) {
            Metadata.Entry entry = metadata.get(i11);
            if (entry instanceof MlltFrame) {
                return c.b(j11, (MlltFrame) entry, k(metadata));
            }
        }
        return null;
    }

    private g q(m mVar) {
        d0 d0Var = new d0(this.f70387d.f24677c);
        mVar.peekFully(d0Var.d(), 0, this.f70387d.f24677c);
        b0.a aVar = this.f70387d;
        int i11 = 21;
        if ((aVar.f24675a & 1) != 0) {
            if (aVar.f24679e != 1) {
                i11 = 36;
            }
        } else if (aVar.f24679e == 1) {
            i11 = 13;
        }
        int i12 = i11;
        int l11 = l(d0Var, i12);
        if (l11 != 1483304551 && l11 != 1231971951) {
            if (l11 != 1447187017) {
                mVar.resetPeekPosition();
                return null;
            }
            h b11 = h.b(mVar.getLength(), mVar.getPosition(), this.f70387d, d0Var);
            mVar.skipFully(this.f70387d.f24677c);
            return b11;
        }
        i b12 = i.b(mVar.getLength(), mVar.getPosition(), this.f70387d, d0Var);
        if (b12 != null && !this.f70388e.a()) {
            mVar.resetPeekPosition();
            mVar.advancePeekPosition(i12 + 141);
            mVar.peekFully(this.f70386c.d(), 0, 3);
            this.f70386c.P(0);
            this.f70388e.d(this.f70386c.G());
        }
        mVar.skipFully(this.f70387d.f24677c);
        return (b12 == null || b12.isSeekable() || l11 != 1231971951) ? b12 : j(mVar, false);
    }

    private boolean r(m mVar) {
        g gVar = this.f70400q;
        if (gVar != null) {
            long a11 = gVar.a();
            if (a11 != -1 && mVar.getPeekPosition() > a11 - 4) {
                return true;
            }
        }
        try {
            return !mVar.peekFully(this.f70386c.d(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    private int s(m mVar) {
        if (this.f70394k == 0) {
            try {
                u(mVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.f70400q == null) {
            g g11 = g(mVar);
            this.f70400q = g11;
            this.f70391h.d(g11);
            this.f70393j.e(new o1.b().e0(this.f70387d.f24676b).W(4096).H(this.f70387d.f24679e).f0(this.f70387d.f24678d).N(this.f70388e.f63598a).O(this.f70388e.f63599b).X((this.f70384a & 8) != 0 ? null : this.f70395l).E());
            this.f70398o = mVar.getPosition();
        } else if (this.f70398o != 0) {
            long position = mVar.getPosition();
            long j11 = this.f70398o;
            if (position < j11) {
                mVar.skipFully((int) (j11 - position));
            }
        }
        return t(mVar);
    }

    private int t(m mVar) {
        if (this.f70399p == 0) {
            mVar.resetPeekPosition();
            if (r(mVar)) {
                return -1;
            }
            this.f70386c.P(0);
            int n11 = this.f70386c.n();
            if (!m(n11, this.f70394k) || b0.j(n11) == -1) {
                mVar.skipFully(1);
                this.f70394k = 0;
                return 0;
            }
            this.f70387d.a(n11);
            if (this.f70396m == C.TIME_UNSET) {
                this.f70396m = this.f70400q.getTimeUs(mVar.getPosition());
                if (this.f70385b != C.TIME_UNSET) {
                    this.f70396m += this.f70385b - this.f70400q.getTimeUs(0L);
                }
            }
            this.f70399p = this.f70387d.f24677c;
            g gVar = this.f70400q;
            if (gVar instanceof b) {
                b bVar = (b) gVar;
                bVar.c(h(this.f70397n + r0.f24681g), mVar.getPosition() + this.f70387d.f24677c);
                if (this.f70402s && bVar.b(this.f70403t)) {
                    this.f70402s = false;
                    this.f70393j = this.f70392i;
                }
            }
        }
        int b11 = this.f70393j.b(mVar, this.f70399p, true);
        if (b11 == -1) {
            return -1;
        }
        int i11 = this.f70399p - b11;
        this.f70399p = i11;
        if (i11 > 0) {
            return 0;
        }
        this.f70393j.d(h(this.f70397n), 1, this.f70387d.f24677c, 0, null);
        this.f70397n += this.f70387d.f24681g;
        this.f70399p = 0;
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x009a, code lost:
    
        if (r13 == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x009c, code lost:
    
        r12.skipFully(r1 + r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a4, code lost:
    
        r11.f70394k = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a6, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a1, code lost:
    
        r12.resetPeekPosition();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean u(g9.m r12, boolean r13) {
        /*
            r11 = this;
            if (r13 == 0) goto L6
            r0 = 32768(0x8000, float:4.5918E-41)
            goto L8
        L6:
            r0 = 131072(0x20000, float:1.83671E-40)
        L8:
            r12.resetPeekPosition()
            long r1 = r12.getPosition()
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r2 = 0
            r3 = 0
            if (r1 != 0) goto L3e
            int r1 = r11.f70384a
            r1 = r1 & 8
            if (r1 != 0) goto L1f
            r1 = r2
            goto L21
        L1f:
            com.google.android.exoplayer2.metadata.id3.b$a r1 = n9.f.f70383v
        L21:
            g9.y r4 = r11.f70389f
            com.google.android.exoplayer2.metadata.Metadata r1 = r4.a(r12, r1)
            r11.f70395l = r1
            if (r1 == 0) goto L30
            g9.x r4 = r11.f70388e
            r4.c(r1)
        L30:
            long r4 = r12.getPeekPosition()
            int r1 = (int) r4
            if (r13 != 0) goto L3a
            r12.skipFully(r1)
        L3a:
            r4 = r3
        L3b:
            r5 = r4
            r6 = r5
            goto L41
        L3e:
            r1 = r3
            r4 = r1
            goto L3b
        L41:
            boolean r7 = r11.r(r12)
            r8 = 1
            if (r7 == 0) goto L51
            if (r5 <= 0) goto L4b
            goto L9a
        L4b:
            java.io.EOFException r12 = new java.io.EOFException
            r12.<init>()
            throw r12
        L51:
            com.google.android.exoplayer2.util.d0 r7 = r11.f70386c
            r7.P(r3)
            com.google.android.exoplayer2.util.d0 r7 = r11.f70386c
            int r7 = r7.n()
            if (r4 == 0) goto L65
            long r9 = (long) r4
            boolean r9 = m(r7, r9)
            if (r9 == 0) goto L6c
        L65:
            int r9 = com.google.android.exoplayer2.audio.b0.j(r7)
            r10 = -1
            if (r9 != r10) goto L8c
        L6c:
            int r4 = r6 + 1
            if (r6 != r0) goto L7a
            if (r13 == 0) goto L73
            return r3
        L73:
            java.lang.String r12 = "Searched too many bytes."
            com.google.android.exoplayer2.ParserException r12 = com.google.android.exoplayer2.ParserException.createForMalformedContainer(r12, r2)
            throw r12
        L7a:
            if (r13 == 0) goto L85
            r12.resetPeekPosition()
            int r5 = r1 + r4
            r12.advancePeekPosition(r5)
            goto L88
        L85:
            r12.skipFully(r8)
        L88:
            r5 = r3
            r6 = r4
            r4 = r5
            goto L41
        L8c:
            int r5 = r5 + 1
            if (r5 != r8) goto L97
            com.google.android.exoplayer2.audio.b0$a r4 = r11.f70387d
            r4.a(r7)
            r4 = r7
            goto La7
        L97:
            r7 = 4
            if (r5 != r7) goto La7
        L9a:
            if (r13 == 0) goto La1
            int r1 = r1 + r6
            r12.skipFully(r1)
            goto La4
        La1:
            r12.resetPeekPosition()
        La4:
            r11.f70394k = r4
            return r8
        La7:
            int r9 = r9 + (-4)
            r12.advancePeekPosition(r9)
            goto L41
        */
        throw new UnsupportedOperationException("Method not decompiled: n9.f.u(g9.m, boolean):boolean");
    }

    @Override // g9.l
    public void b(n nVar) {
        this.f70391h = nVar;
        e0 track = nVar.track(0, 1);
        this.f70392i = track;
        this.f70393j = track;
        this.f70391h.endTracks();
    }

    @Override // g9.l
    public int c(m mVar, a0 a0Var) {
        f();
        int s11 = s(mVar);
        if (s11 == -1 && (this.f70400q instanceof b)) {
            long h11 = h(this.f70397n);
            if (this.f70400q.getDurationUs() != h11) {
                ((b) this.f70400q).d(h11);
                this.f70391h.d(this.f70400q);
            }
        }
        return s11;
    }

    @Override // g9.l
    public boolean d(m mVar) {
        return u(mVar, true);
    }

    public void i() {
        this.f70401r = true;
    }

    @Override // g9.l
    public void release() {
    }

    @Override // g9.l
    public void seek(long j11, long j12) {
        this.f70394k = 0;
        this.f70396m = C.TIME_UNSET;
        this.f70397n = 0L;
        this.f70399p = 0;
        this.f70403t = j12;
        g gVar = this.f70400q;
        if (!(gVar instanceof b) || ((b) gVar).b(j12)) {
            return;
        }
        this.f70402s = true;
        this.f70393j = this.f70390g;
    }
}

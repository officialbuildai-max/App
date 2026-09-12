package o9;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.x;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import g9.a0;
import g9.b0;
import g9.e0;
import g9.f0;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import o9.a;

/* loaded from: classes4.dex */
public final class k implements g9.l, b0 {

    /* renamed from: y, reason: collision with root package name */
    public static final g9.r f70957y = new g9.r() { // from class: o9.j
        @Override // g9.r
        public /* synthetic */ g9.l[] c(Uri uri, Map map) {
            return g9.q.a(this, uri, map);
        }

        @Override // g9.r
        public final g9.l[] createExtractors() {
            g9.l[] n11;
            n11 = k.n();
            return n11;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final int f70958a;

    /* renamed from: b, reason: collision with root package name */
    private final d0 f70959b;

    /* renamed from: c, reason: collision with root package name */
    private final d0 f70960c;

    /* renamed from: d, reason: collision with root package name */
    private final d0 f70961d;

    /* renamed from: e, reason: collision with root package name */
    private final d0 f70962e;

    /* renamed from: f, reason: collision with root package name */
    private final ArrayDeque f70963f;

    /* renamed from: g, reason: collision with root package name */
    private final m f70964g;

    /* renamed from: h, reason: collision with root package name */
    private final List f70965h;

    /* renamed from: i, reason: collision with root package name */
    private int f70966i;

    /* renamed from: j, reason: collision with root package name */
    private int f70967j;

    /* renamed from: k, reason: collision with root package name */
    private long f70968k;

    /* renamed from: l, reason: collision with root package name */
    private int f70969l;

    /* renamed from: m, reason: collision with root package name */
    private d0 f70970m;

    /* renamed from: n, reason: collision with root package name */
    private int f70971n;

    /* renamed from: o, reason: collision with root package name */
    private int f70972o;

    /* renamed from: p, reason: collision with root package name */
    private int f70973p;

    /* renamed from: q, reason: collision with root package name */
    private int f70974q;

    /* renamed from: r, reason: collision with root package name */
    private g9.n f70975r;

    /* renamed from: s, reason: collision with root package name */
    private a[] f70976s;

    /* renamed from: t, reason: collision with root package name */
    private long[][] f70977t;

    /* renamed from: u, reason: collision with root package name */
    private int f70978u;

    /* renamed from: v, reason: collision with root package name */
    private long f70979v;

    /* renamed from: w, reason: collision with root package name */
    private int f70980w;

    /* renamed from: x, reason: collision with root package name */
    private MotionPhotoMetadata f70981x;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final o f70982a;

        /* renamed from: b, reason: collision with root package name */
        public final r f70983b;

        /* renamed from: c, reason: collision with root package name */
        public final e0 f70984c;

        /* renamed from: d, reason: collision with root package name */
        public final f0 f70985d;

        /* renamed from: e, reason: collision with root package name */
        public int f70986e;

        public a(o oVar, r rVar, e0 e0Var) {
            this.f70982a = oVar;
            this.f70983b = rVar;
            this.f70984c = e0Var;
            this.f70985d = MimeTypes.AUDIO_TRUEHD.equals(oVar.f71004f.f25550l) ? new f0() : null;
        }
    }

    public k() {
        this(0);
    }

    public k(int i11) {
        this.f70958a = i11;
        this.f70966i = (i11 & 4) != 0 ? 3 : 0;
        this.f70964g = new m();
        this.f70965h = new ArrayList();
        this.f70962e = new d0(16);
        this.f70963f = new ArrayDeque();
        this.f70959b = new d0(x.f27718a);
        this.f70960c = new d0(4);
        this.f70961d = new d0();
        this.f70971n = -1;
        this.f70975r = g9.n.f63576i1;
        this.f70976s = new a[0];
    }

    private static boolean A(int i11) {
        return i11 == 1835296868 || i11 == 1836476516 || i11 == 1751411826 || i11 == 1937011556 || i11 == 1937011827 || i11 == 1937011571 || i11 == 1668576371 || i11 == 1701606260 || i11 == 1937011555 || i11 == 1937011578 || i11 == 1937013298 || i11 == 1937007471 || i11 == 1668232756 || i11 == 1953196132 || i11 == 1718909296 || i11 == 1969517665 || i11 == 1801812339 || i11 == 1768715124;
    }

    private void B(a aVar, long j11) {
        r rVar = aVar.f70983b;
        int a11 = rVar.a(j11);
        if (a11 == -1) {
            a11 = rVar.b(j11);
        }
        aVar.f70986e = a11;
    }

    private static int g(int i11) {
        if (i11 != 1751476579) {
            return i11 != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    private static long[][] h(a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length];
        int[] iArr = new int[aVarArr.length];
        long[] jArr2 = new long[aVarArr.length];
        boolean[] zArr = new boolean[aVarArr.length];
        for (int i11 = 0; i11 < aVarArr.length; i11++) {
            jArr[i11] = new long[aVarArr[i11].f70983b.f71034b];
            jArr2[i11] = aVarArr[i11].f70983b.f71038f[0];
        }
        long j11 = 0;
        int i12 = 0;
        while (i12 < aVarArr.length) {
            long j12 = Long.MAX_VALUE;
            int i13 = -1;
            for (int i14 = 0; i14 < aVarArr.length; i14++) {
                if (!zArr[i14]) {
                    long j13 = jArr2[i14];
                    if (j13 <= j12) {
                        i13 = i14;
                        j12 = j13;
                    }
                }
            }
            int i15 = iArr[i13];
            long[] jArr3 = jArr[i13];
            jArr3[i15] = j11;
            r rVar = aVarArr[i13].f70983b;
            j11 += rVar.f71036d[i15];
            int i16 = i15 + 1;
            iArr[i13] = i16;
            if (i16 < jArr3.length) {
                jArr2[i13] = rVar.f71038f[i16];
            } else {
                zArr[i13] = true;
                i12++;
            }
        }
        return jArr;
    }

    private void i() {
        this.f70966i = 0;
        this.f70969l = 0;
    }

    private static int k(r rVar, long j11) {
        int a11 = rVar.a(j11);
        return a11 == -1 ? rVar.b(j11) : a11;
    }

    private int l(long j11) {
        int i11 = -1;
        int i12 = -1;
        int i13 = 0;
        long j12 = Long.MAX_VALUE;
        boolean z10 = true;
        long j13 = Long.MAX_VALUE;
        boolean z11 = true;
        long j14 = Long.MAX_VALUE;
        while (true) {
            a[] aVarArr = this.f70976s;
            if (i13 >= aVarArr.length) {
                break;
            }
            a aVar = aVarArr[i13];
            int i14 = aVar.f70986e;
            r rVar = aVar.f70983b;
            if (i14 != rVar.f71034b) {
                long j15 = rVar.f71035c[i14];
                long j16 = ((long[][]) p0.j(this.f70977t))[i13][i14];
                long j17 = j15 - j11;
                boolean z12 = j17 < 0 || j17 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                if ((!z12 && z11) || (z12 == z11 && j17 < j14)) {
                    z11 = z12;
                    j14 = j17;
                    i12 = i13;
                    j13 = j16;
                }
                if (j16 < j12) {
                    z10 = z12;
                    i11 = i13;
                    j12 = j16;
                }
            }
            i13++;
        }
        return (j12 == Long.MAX_VALUE || !z10 || j13 < j12 + 10485760) ? i12 : i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ o m(o oVar) {
        return oVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ g9.l[] n() {
        return new g9.l[]{new k()};
    }

    private static long o(r rVar, long j11, long j12) {
        int k11 = k(rVar, j11);
        return k11 == -1 ? j12 : Math.min(rVar.f71035c[k11], j12);
    }

    private void p(g9.m mVar) {
        this.f70961d.L(8);
        mVar.peekFully(this.f70961d.d(), 0, 8);
        b.e(this.f70961d);
        mVar.skipFully(this.f70961d.e());
        mVar.resetPeekPosition();
    }

    private void q(long j11) {
        while (!this.f70963f.isEmpty() && ((a.C0886a) this.f70963f.peek()).f70871b == j11) {
            a.C0886a c0886a = (a.C0886a) this.f70963f.pop();
            if (c0886a.f70870a == 1836019574) {
                t(c0886a);
                this.f70963f.clear();
                this.f70966i = 2;
            } else if (!this.f70963f.isEmpty()) {
                ((a.C0886a) this.f70963f.peek()).d(c0886a);
            }
        }
        if (this.f70966i != 2) {
            i();
        }
    }

    private void r() {
        if (this.f70980w != 2 || (this.f70958a & 2) == 0) {
            return;
        }
        this.f70975r.track(0, 4).e(new o1.b().X(this.f70981x == null ? null : new Metadata(this.f70981x)).E());
        this.f70975r.endTracks();
        this.f70975r.d(new b0.b(C.TIME_UNSET));
    }

    private static int s(d0 d0Var) {
        d0Var.P(8);
        int g11 = g(d0Var.n());
        if (g11 != 0) {
            return g11;
        }
        d0Var.Q(4);
        while (d0Var.a() > 0) {
            int g12 = g(d0Var.n());
            if (g12 != 0) {
                return g12;
            }
        }
        return 0;
    }

    private void t(a.C0886a c0886a) {
        Metadata metadata;
        Metadata metadata2;
        List list;
        int i11;
        Metadata metadata3;
        ArrayList arrayList;
        int i12;
        int i13;
        ArrayList arrayList2 = new ArrayList();
        boolean z10 = this.f70980w == 1;
        g9.x xVar = new g9.x();
        a.b g11 = c0886a.g(1969517665);
        if (g11 != null) {
            Pair B = b.B(g11);
            Metadata metadata4 = (Metadata) B.first;
            Metadata metadata5 = (Metadata) B.second;
            if (metadata4 != null) {
                xVar.c(metadata4);
            }
            metadata2 = metadata5;
            metadata = metadata4;
        } else {
            metadata = null;
            metadata2 = null;
        }
        a.C0886a f11 = c0886a.f(1835365473);
        Metadata n11 = f11 != null ? b.n(f11) : null;
        Metadata metadata6 = metadata;
        List A = b.A(c0886a, xVar, C.TIME_UNSET, null, (this.f70958a & 1) != 0, z10, new com.google.common.base.f() { // from class: o9.i
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                o m11;
                m11 = k.m((o) obj);
                return m11;
            }
        });
        int size = A.size();
        long j11 = C.TIME_UNSET;
        long j12 = -9223372036854775807L;
        int i14 = 0;
        int i15 = -1;
        while (i14 < size) {
            r rVar = (r) A.get(i14);
            if (rVar.f71034b == 0) {
                list = A;
                i11 = size;
                arrayList = arrayList2;
                metadata3 = metadata6;
                i12 = 1;
            } else {
                o oVar = rVar.f71033a;
                ArrayList arrayList3 = arrayList2;
                long j13 = oVar.f71003e;
                if (j13 == j11) {
                    j13 = rVar.f71040h;
                }
                j12 = Math.max(j12, j13);
                list = A;
                a aVar = new a(oVar, rVar, this.f70975r.track(i14, oVar.f71000b));
                int i16 = MimeTypes.AUDIO_TRUEHD.equals(oVar.f71004f.f25550l) ? rVar.f71037e * 16 : rVar.f71037e + 30;
                o1.b b11 = oVar.f71004f.b();
                b11.W(i16);
                i11 = size;
                if (oVar.f71000b == 2 && j13 > 0 && (i13 = rVar.f71034b) > 1) {
                    b11.P(i13 / (((float) j13) / 1000000.0f));
                }
                h.k(oVar.f71000b, xVar, b11);
                metadata3 = metadata6;
                h.l(oVar.f71000b, metadata3, n11, b11, metadata2, this.f70965h.isEmpty() ? null : new Metadata((List<? extends Metadata.Entry>) this.f70965h));
                aVar.f70984c.e(b11.E());
                if (oVar.f71000b == 2 && i15 == -1) {
                    i15 = arrayList3.size();
                }
                arrayList = arrayList3;
                arrayList.add(aVar);
                i12 = 1;
            }
            i14 += i12;
            metadata6 = metadata3;
            arrayList2 = arrayList;
            A = list;
            size = i11;
            j11 = C.TIME_UNSET;
        }
        this.f70978u = i15;
        this.f70979v = j12;
        a[] aVarArr = (a[]) arrayList2.toArray(new a[0]);
        this.f70976s = aVarArr;
        this.f70977t = h(aVarArr);
        this.f70975r.endTracks();
        this.f70975r.d(this);
    }

    private void u(long j11) {
        if (this.f70967j == 1836086884) {
            int i11 = this.f70969l;
            this.f70981x = new MotionPhotoMetadata(0L, j11, C.TIME_UNSET, j11 + i11, this.f70968k - i11);
        }
    }

    private boolean v(g9.m mVar) {
        a.C0886a c0886a;
        if (this.f70969l == 0) {
            if (!mVar.readFully(this.f70962e.d(), 0, 8, true)) {
                r();
                return false;
            }
            this.f70969l = 8;
            this.f70962e.P(0);
            this.f70968k = this.f70962e.F();
            this.f70967j = this.f70962e.n();
        }
        long j11 = this.f70968k;
        if (j11 == 1) {
            mVar.readFully(this.f70962e.d(), 8, 8);
            this.f70969l += 8;
            this.f70968k = this.f70962e.I();
        } else if (j11 == 0) {
            long length = mVar.getLength();
            if (length == -1 && (c0886a = (a.C0886a) this.f70963f.peek()) != null) {
                length = c0886a.f70871b;
            }
            if (length != -1) {
                this.f70968k = (length - mVar.getPosition()) + this.f70969l;
            }
        }
        if (this.f70968k < this.f70969l) {
            throw ParserException.createForUnsupportedContainerFeature("Atom size less than header length (unsupported).");
        }
        if (z(this.f70967j)) {
            long position = mVar.getPosition();
            long j12 = this.f70968k;
            int i11 = this.f70969l;
            long j13 = (position + j12) - i11;
            if (j12 != i11 && this.f70967j == 1835365473) {
                p(mVar);
            }
            this.f70963f.push(new a.C0886a(this.f70967j, j13));
            if (this.f70968k == this.f70969l) {
                q(j13);
            } else {
                i();
            }
        } else if (A(this.f70967j)) {
            com.google.android.exoplayer2.util.a.g(this.f70969l == 8);
            com.google.android.exoplayer2.util.a.g(this.f70968k <= 2147483647L);
            d0 d0Var = new d0((int) this.f70968k);
            System.arraycopy(this.f70962e.d(), 0, d0Var.d(), 0, 8);
            this.f70970m = d0Var;
            this.f70966i = 1;
        } else {
            u(mVar.getPosition() - this.f70969l);
            this.f70970m = null;
            this.f70966i = 1;
        }
        return true;
    }

    private boolean w(g9.m mVar, a0 a0Var) {
        boolean z10;
        long j11 = this.f70968k - this.f70969l;
        long position = mVar.getPosition() + j11;
        d0 d0Var = this.f70970m;
        if (d0Var != null) {
            mVar.readFully(d0Var.d(), this.f70969l, (int) j11);
            if (this.f70967j == 1718909296) {
                this.f70980w = s(d0Var);
            } else if (!this.f70963f.isEmpty()) {
                ((a.C0886a) this.f70963f.peek()).e(new a.b(this.f70967j, d0Var));
            }
        } else {
            if (j11 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                a0Var.f63492a = mVar.getPosition() + j11;
                z10 = true;
                q(position);
                return (z10 || this.f70966i == 2) ? false : true;
            }
            mVar.skipFully((int) j11);
        }
        z10 = false;
        q(position);
        if (z10) {
        }
    }

    private int x(g9.m mVar, a0 a0Var) {
        int i11;
        a0 a0Var2;
        long position = mVar.getPosition();
        if (this.f70971n == -1) {
            int l11 = l(position);
            this.f70971n = l11;
            if (l11 == -1) {
                return -1;
            }
        }
        a aVar = this.f70976s[this.f70971n];
        e0 e0Var = aVar.f70984c;
        int i12 = aVar.f70986e;
        r rVar = aVar.f70983b;
        long j11 = rVar.f71035c[i12];
        int i13 = rVar.f71036d[i12];
        f0 f0Var = aVar.f70985d;
        long j12 = (j11 - position) + this.f70972o;
        if (j12 < 0) {
            i11 = 1;
            a0Var2 = a0Var;
        } else {
            if (j12 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                if (aVar.f70982a.f71005g == 1) {
                    j12 += 8;
                    i13 -= 8;
                }
                mVar.skipFully((int) j12);
                o oVar = aVar.f70982a;
                if (oVar.f71008j == 0) {
                    if ("audio/ac4".equals(oVar.f71004f.f25550l)) {
                        if (this.f70973p == 0) {
                            com.google.android.exoplayer2.audio.c.a(i13, this.f70961d);
                            e0Var.c(this.f70961d, 7);
                            this.f70973p += 7;
                        }
                        i13 += 7;
                    } else if (f0Var != null) {
                        f0Var.d(mVar);
                    }
                    while (true) {
                        int i14 = this.f70973p;
                        if (i14 >= i13) {
                            break;
                        }
                        int b11 = e0Var.b(mVar, i13 - i14, false);
                        this.f70972o += b11;
                        this.f70973p += b11;
                        this.f70974q -= b11;
                    }
                } else {
                    byte[] d11 = this.f70960c.d();
                    d11[0] = 0;
                    d11[1] = 0;
                    d11[2] = 0;
                    int i15 = aVar.f70982a.f71008j;
                    int i16 = 4 - i15;
                    while (this.f70973p < i13) {
                        int i17 = this.f70974q;
                        if (i17 == 0) {
                            mVar.readFully(d11, i16, i15);
                            this.f70972o += i15;
                            this.f70960c.P(0);
                            int n11 = this.f70960c.n();
                            if (n11 < 0) {
                                throw ParserException.createForMalformedContainer("Invalid NAL length", null);
                            }
                            this.f70974q = n11;
                            this.f70959b.P(0);
                            e0Var.c(this.f70959b, 4);
                            this.f70973p += 4;
                            i13 += i16;
                        } else {
                            int b12 = e0Var.b(mVar, i17, false);
                            this.f70972o += b12;
                            this.f70973p += b12;
                            this.f70974q -= b12;
                        }
                    }
                }
                int i18 = i13;
                r rVar2 = aVar.f70983b;
                long j13 = rVar2.f71038f[i12];
                int i19 = rVar2.f71039g[i12];
                if (f0Var != null) {
                    f0Var.c(e0Var, j13, i19, i18, 0, null);
                    if (i12 + 1 == aVar.f70983b.f71034b) {
                        f0Var.a(e0Var, null);
                    }
                } else {
                    e0Var.d(j13, i19, i18, 0, null);
                }
                aVar.f70986e++;
                this.f70971n = -1;
                this.f70972o = 0;
                this.f70973p = 0;
                this.f70974q = 0;
                return 0;
            }
            a0Var2 = a0Var;
            i11 = 1;
        }
        a0Var2.f63492a = j11;
        return i11;
    }

    private int y(g9.m mVar, a0 a0Var) {
        int c11 = this.f70964g.c(mVar, a0Var, this.f70965h);
        if (c11 == 1 && a0Var.f63492a == 0) {
            i();
        }
        return c11;
    }

    private static boolean z(int i11) {
        return i11 == 1836019574 || i11 == 1953653099 || i11 == 1835297121 || i11 == 1835626086 || i11 == 1937007212 || i11 == 1701082227 || i11 == 1835365473;
    }

    @Override // g9.l
    public void b(g9.n nVar) {
        this.f70975r = nVar;
    }

    @Override // g9.l
    public int c(g9.m mVar, a0 a0Var) {
        while (true) {
            int i11 = this.f70966i;
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 == 2) {
                        return x(mVar, a0Var);
                    }
                    if (i11 == 3) {
                        return y(mVar, a0Var);
                    }
                    throw new IllegalStateException();
                }
                if (w(mVar, a0Var)) {
                    return 1;
                }
            } else if (!v(mVar)) {
                return -1;
            }
        }
    }

    @Override // g9.l
    public boolean d(g9.m mVar) {
        return n.d(mVar, (this.f70958a & 2) != 0);
    }

    @Override // g9.b0
    public long getDurationUs() {
        return this.f70979v;
    }

    @Override // g9.b0
    public b0.a getSeekPoints(long j11) {
        return j(j11, -1);
    }

    @Override // g9.b0
    public boolean isSeekable() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public g9.b0.a j(long r17, int r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r19
            o9.k$a[] r4 = r0.f70976s
            int r5 = r4.length
            if (r5 != 0) goto L13
            g9.b0$a r1 = new g9.b0$a
            g9.c0 r2 = g9.c0.f63497c
            r1.<init>(r2)
            return r1
        L13:
            r5 = -1
            if (r3 == r5) goto L18
            r6 = r3
            goto L1a
        L18:
            int r6 = r0.f70978u
        L1a:
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r9 = -1
            if (r6 == r5) goto L58
            r4 = r4[r6]
            o9.r r4 = r4.f70983b
            int r6 = k(r4, r1)
            if (r6 != r5) goto L35
            g9.b0$a r1 = new g9.b0$a
            g9.c0 r2 = g9.c0.f63497c
            r1.<init>(r2)
            return r1
        L35:
            long[] r11 = r4.f71038f
            r12 = r11[r6]
            long[] r11 = r4.f71035c
            r14 = r11[r6]
            int r11 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r11 >= 0) goto L5e
            int r11 = r4.f71034b
            int r11 = r11 + (-1)
            if (r6 >= r11) goto L5e
            int r1 = r4.b(r1)
            if (r1 == r5) goto L5e
            if (r1 == r6) goto L5e
            long[] r2 = r4.f71038f
            r9 = r2[r1]
            long[] r2 = r4.f71035c
            r1 = r2[r1]
            goto L60
        L58:
            r14 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r12 = r1
        L5e:
            r1 = r9
            r9 = r7
        L60:
            if (r3 != r5) goto L80
            r3 = 0
        L63:
            o9.k$a[] r4 = r0.f70976s
            int r5 = r4.length
            if (r3 >= r5) goto L80
            int r5 = r0.f70978u
            if (r3 == r5) goto L7d
            r4 = r4[r3]
            o9.r r4 = r4.f70983b
            long r5 = o(r4, r12, r14)
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L7c
            long r1 = o(r4, r9, r1)
        L7c:
            r14 = r5
        L7d:
            int r3 = r3 + 1
            goto L63
        L80:
            g9.c0 r3 = new g9.c0
            r3.<init>(r12, r14)
            int r4 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r4 != 0) goto L8f
            g9.b0$a r1 = new g9.b0$a
            r1.<init>(r3)
            return r1
        L8f:
            g9.c0 r4 = new g9.c0
            r4.<init>(r9, r1)
            g9.b0$a r1 = new g9.b0$a
            r1.<init>(r3, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: o9.k.j(long, int):g9.b0$a");
    }

    @Override // g9.l
    public void release() {
    }

    @Override // g9.l
    public void seek(long j11, long j12) {
        this.f70963f.clear();
        this.f70969l = 0;
        this.f70971n = -1;
        this.f70972o = 0;
        this.f70973p = 0;
        this.f70974q = 0;
        if (j11 == 0) {
            if (this.f70966i != 3) {
                i();
                return;
            } else {
                this.f70964g.g();
                this.f70965h.clear();
                return;
            }
        }
        for (a aVar : this.f70976s) {
            B(aVar, j12);
            f0 f0Var = aVar.f70985d;
            if (f0Var != null) {
                f0Var.b();
            }
        }
    }
}

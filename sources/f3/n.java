package f3;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.media3.common.ParserException;
import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.j0;
import androidx.media3.container.d;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import i3.s;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import l2.e0;
import l2.l0;
import l2.m0;
import l2.q0;
import l2.s0;
import l2.t0;

/* loaded from: classes2.dex */
public final class n implements l2.r, m0 {
    public static final l2.x G = new l2.x() { // from class: f3.m
        @Override // l2.x
        public /* synthetic */ l2.x a(s.a aVar) {
            return l2.w.d(this, aVar);
        }

        @Override // l2.x
        public /* synthetic */ l2.x b(int i11) {
            return l2.w.b(this, i11);
        }

        @Override // l2.x
        public /* synthetic */ l2.r[] c(Uri uri, Map map) {
            return l2.w.a(this, uri, map);
        }

        @Override // l2.x
        public final l2.r[] createExtractors() {
            l2.r[] u11;
            u11 = n.u();
            return u11;
        }

        @Override // l2.x
        public /* synthetic */ l2.x d(boolean z10) {
            return l2.w.c(this, z10);
        }
    };
    private a[] A;
    private long[][] B;
    private int C;
    private long D;
    private int E;
    private a3.a F;

    /* renamed from: a, reason: collision with root package name */
    private final s.a f62369a;

    /* renamed from: b, reason: collision with root package name */
    private final int f62370b;

    /* renamed from: c, reason: collision with root package name */
    private final j0 f62371c;

    /* renamed from: d, reason: collision with root package name */
    private final j0 f62372d;

    /* renamed from: e, reason: collision with root package name */
    private final j0 f62373e;

    /* renamed from: f, reason: collision with root package name */
    private final j0 f62374f;

    /* renamed from: g, reason: collision with root package name */
    private final ArrayDeque f62375g;

    /* renamed from: h, reason: collision with root package name */
    private final q f62376h;

    /* renamed from: i, reason: collision with root package name */
    private final List f62377i;

    /* renamed from: j, reason: collision with root package name */
    private ImmutableList f62378j;

    /* renamed from: k, reason: collision with root package name */
    private int f62379k;

    /* renamed from: l, reason: collision with root package name */
    private int f62380l;

    /* renamed from: m, reason: collision with root package name */
    private long f62381m;

    /* renamed from: n, reason: collision with root package name */
    private int f62382n;

    /* renamed from: o, reason: collision with root package name */
    private j0 f62383o;

    /* renamed from: p, reason: collision with root package name */
    private int f62384p;

    /* renamed from: q, reason: collision with root package name */
    private int f62385q;

    /* renamed from: r, reason: collision with root package name */
    private int f62386r;

    /* renamed from: s, reason: collision with root package name */
    private int f62387s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f62388t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f62389u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f62390v;

    /* renamed from: w, reason: collision with root package name */
    private long f62391w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f62392x;

    /* renamed from: y, reason: collision with root package name */
    private long f62393y;

    /* renamed from: z, reason: collision with root package name */
    private l2.t f62394z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final t f62395a;

        /* renamed from: b, reason: collision with root package name */
        public final w f62396b;

        /* renamed from: c, reason: collision with root package name */
        public final s0 f62397c;

        /* renamed from: d, reason: collision with root package name */
        public final t0 f62398d;

        /* renamed from: e, reason: collision with root package name */
        public int f62399e;

        public a(t tVar, w wVar, s0 s0Var) {
            this.f62395a = tVar;
            this.f62396b = wVar;
            this.f62397c = s0Var;
            this.f62398d = MimeTypes.AUDIO_TRUEHD.equals(tVar.f62420g.f10243o) ? new t0() : null;
        }
    }

    @Deprecated
    public n() {
        this(s.a.f65046a, 16);
    }

    public n(s.a aVar, int i11) {
        this.f62369a = aVar;
        this.f62370b = i11;
        this.f62378j = ImmutableList.of();
        this.f62379k = (i11 & 4) != 0 ? 3 : 0;
        this.f62376h = new q();
        this.f62377i = new ArrayList();
        this.f62374f = new j0(16);
        this.f62375g = new ArrayDeque();
        this.f62371c = new j0(androidx.media3.container.g.f10675a);
        this.f62372d = new j0(6);
        this.f62373e = new j0();
        this.f62384p = -1;
        this.f62394z = l2.t.f68806n1;
        this.A = new a[0];
    }

    private static int A(j0 j0Var) {
        j0Var.W(8);
        int j11 = j(j0Var.q());
        if (j11 != 0) {
            return j11;
        }
        j0Var.X(4);
        while (j0Var.a() > 0) {
            int j12 = j(j0Var.q());
            if (j12 != 0) {
                return j12;
            }
        }
        return 0;
    }

    private void B(d.b bVar) {
        List list;
        androidx.media3.common.x xVar;
        androidx.media3.common.x xVar2;
        List list2;
        int i11;
        String str;
        androidx.media3.common.x xVar3;
        long j11;
        int i12;
        d.b d11 = bVar.d(1835365473);
        List arrayList = new ArrayList();
        int i13 = 1;
        if (d11 != null) {
            androidx.media3.common.x t11 = b.t(d11);
            if (this.f62392x) {
                androidx.media3.common.util.a.i(t11);
                w(t11);
                arrayList = o(t11);
            } else if (J(t11)) {
                this.f62390v = true;
                return;
            }
            xVar = t11;
            list = arrayList;
        } else {
            list = arrayList;
            xVar = null;
        }
        ArrayList arrayList2 = new ArrayList();
        boolean z10 = this.E == 1;
        e0 e0Var = new e0();
        d.c e11 = bVar.e(1969517665);
        if (e11 != null) {
            androidx.media3.common.x H = b.H(e11);
            e0Var.c(H);
            xVar2 = H;
        } else {
            xVar2 = null;
        }
        androidx.media3.common.x xVar4 = new androidx.media3.common.x(b.v(((d.c) androidx.media3.common.util.a.e(bVar.e(1836476516))).f10669b));
        List G2 = b.G(bVar, e0Var, C.TIME_UNSET, null, (this.f62370b & 1) != 0, z10, new com.google.common.base.f() { // from class: f3.l
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                t t12;
                t12 = n.t((t) obj);
                return t12;
            }
        });
        if (this.f62392x) {
            androidx.media3.common.util.a.h(list.size() == G2.size(), String.format(Locale.US, "The number of auxiliary track types from metadata (%d) is not same as the number of auxiliary tracks (%d)", Integer.valueOf(list.size()), Integer.valueOf(G2.size())));
        }
        String b11 = k.b(G2);
        int i14 = 0;
        int i15 = 0;
        int i16 = -1;
        long j12 = C.TIME_UNSET;
        while (i14 < G2.size()) {
            w wVar = (w) G2.get(i14);
            if (wVar.f62450b == 0) {
                list2 = G2;
                i11 = i15;
                int i17 = i13;
                str = b11;
                i12 = i17;
            } else {
                t tVar = wVar.f62449a;
                list2 = G2;
                i11 = i15 + 1;
                a aVar = new a(tVar, wVar, this.f62394z.track(i15, tVar.f62415b));
                str = b11;
                long j13 = tVar.f62418e;
                if (j13 == C.TIME_UNSET) {
                    j13 = wVar.f62456h;
                }
                aVar.f62397c.f(j13);
                long max = Math.max(j12, j13);
                int i18 = MimeTypes.AUDIO_TRUEHD.equals(tVar.f62420g.f10243o) ? wVar.f62453e * 16 : wVar.f62453e + 30;
                r.b b12 = tVar.f62420g.b();
                b12.k0(i18);
                if (tVar.f62415b == 2) {
                    int i19 = tVar.f62420g.f10234f;
                    if ((this.f62370b & 8) != 0) {
                        i19 |= i16 == -1 ? 1 : 2;
                    }
                    if (this.f62392x) {
                        i19 |= 32768;
                        b12.P(((Integer) list.get(i14)).intValue());
                    }
                    b12.s0(i19);
                }
                j.l(tVar.f62415b, e0Var, b12);
                int i20 = tVar.f62415b;
                androidx.media3.common.x xVar5 = tVar.f62420g.f10240l;
                if (this.f62377i.isEmpty()) {
                    j11 = max;
                    xVar3 = null;
                } else {
                    j11 = max;
                    xVar3 = new androidx.media3.common.x(this.f62377i);
                }
                j.m(i20, xVar, b12, xVar5, xVar3, xVar2, xVar4);
                b12.U(str);
                aVar.f62397c.c(b12.N());
                if (tVar.f62415b == 2 && i16 == -1) {
                    i16 = arrayList2.size();
                }
                arrayList2.add(aVar);
                j12 = j11;
                i12 = 1;
            }
            i14 += i12;
            G2 = list2;
            i15 = i11;
            String str2 = str;
            i13 = i12;
            b11 = str2;
        }
        this.C = i16;
        this.D = j12;
        a[] aVarArr = (a[]) arrayList2.toArray(new a[0]);
        this.A = aVarArr;
        this.B = k(aVarArr);
        this.f62394z.endTracks();
        this.f62394z.f(this);
    }

    private void C(long j11) {
        if (this.f62380l == 1836086884) {
            int i11 = this.f62382n;
            this.F = new a3.a(0L, j11, C.TIME_UNSET, j11 + i11, this.f62381m - i11);
        }
    }

    private boolean D(l2.s sVar) {
        d.b bVar;
        if (this.f62382n == 0) {
            if (!sVar.readFully(this.f62374f.e(), 0, 8, true)) {
                z();
                return false;
            }
            this.f62382n = 8;
            this.f62374f.W(0);
            this.f62381m = this.f62374f.J();
            this.f62380l = this.f62374f.q();
        }
        long j11 = this.f62381m;
        if (j11 == 1) {
            sVar.readFully(this.f62374f.e(), 8, 8);
            this.f62382n += 8;
            this.f62381m = this.f62374f.O();
        } else if (j11 == 0) {
            long length = sVar.getLength();
            if (length == -1 && (bVar = (d.b) this.f62375g.peek()) != null) {
                length = bVar.f10666b;
            }
            if (length != -1) {
                this.f62381m = (length - sVar.getPosition()) + this.f62382n;
            }
        }
        if (this.f62381m < this.f62382n) {
            throw ParserException.createForUnsupportedContainerFeature("Atom size less than header length (unsupported).");
        }
        if (H(this.f62380l)) {
            long position = sVar.getPosition();
            long j12 = this.f62381m;
            int i11 = this.f62382n;
            long j13 = (position + j12) - i11;
            if (j12 != i11 && this.f62380l == 1835365473) {
                x(sVar);
            }
            this.f62375g.push(new d.b(this.f62380l, j13));
            if (this.f62381m == this.f62382n) {
                y(j13);
            } else {
                n();
            }
        } else if (I(this.f62380l)) {
            androidx.media3.common.util.a.g(this.f62382n == 8);
            androidx.media3.common.util.a.g(this.f62381m <= 2147483647L);
            j0 j0Var = new j0((int) this.f62381m);
            System.arraycopy(this.f62374f.e(), 0, j0Var.e(), 0, 8);
            this.f62383o = j0Var;
            this.f62379k = 1;
        } else {
            C(sVar.getPosition() - this.f62382n);
            this.f62383o = null;
            this.f62379k = 1;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean E(l2.s r10, l2.l0 r11) {
        /*
            r9 = this;
            long r0 = r9.f62381m
            int r2 = r9.f62382n
            long r2 = (long) r2
            long r0 = r0 - r2
            long r2 = r10.getPosition()
            long r2 = r2 + r0
            androidx.media3.common.util.j0 r4 = r9.f62383o
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L46
            byte[] r7 = r4.e()
            int r8 = r9.f62382n
            int r0 = (int) r0
            r10.readFully(r7, r8, r0)
            int r10 = r9.f62380l
            r0 = 1718909296(0x66747970, float:2.8862439E23)
            if (r10 != r0) goto L2b
            r9.f62389u = r5
            int r10 = A(r4)
            r9.E = r10
            goto L5e
        L2b:
            java.util.ArrayDeque r10 = r9.f62375g
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto L5e
            java.util.ArrayDeque r10 = r9.f62375g
            java.lang.Object r10 = r10.peek()
            androidx.media3.container.d$b r10 = (androidx.media3.container.d.b) r10
            androidx.media3.container.d$c r0 = new androidx.media3.container.d$c
            int r1 = r9.f62380l
            r0.<init>(r1, r4)
            r10.c(r0)
            goto L5e
        L46:
            boolean r4 = r9.f62389u
            if (r4 != 0) goto L53
            int r4 = r9.f62380l
            r7 = 1835295092(0x6d646174, float:4.4175247E27)
            if (r4 != r7) goto L53
            r9.E = r5
        L53:
            r7 = 262144(0x40000, double:1.295163E-318)
            int r4 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r4 >= 0) goto L60
            int r0 = (int) r0
            r10.skipFully(r0)
        L5e:
            r10 = r6
            goto L68
        L60:
            long r7 = r10.getPosition()
            long r7 = r7 + r0
            r11.f68743a = r7
            r10 = r5
        L68:
            r9.y(r2)
            boolean r0 = r9.f62390v
            if (r0 == 0) goto L78
            r9.f62392x = r5
            long r0 = r9.f62391w
            r11.f68743a = r0
            r9.f62390v = r6
            r10 = r5
        L78:
            if (r10 == 0) goto L80
            int r10 = r9.f62379k
            r11 = 2
            if (r10 == r11) goto L80
            goto L81
        L80:
            r5 = r6
        L81:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.n.E(l2.s, l2.l0):boolean");
    }

    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [int, boolean] */
    private int F(l2.s sVar, l0 l0Var) {
        int i11;
        l0 l0Var2;
        s0.a aVar;
        ?? r52;
        int i12;
        long position = sVar.getPosition();
        if (this.f62384p == -1) {
            int s11 = s(position);
            this.f62384p = s11;
            if (s11 == -1) {
                return -1;
            }
        }
        a aVar2 = this.A[this.f62384p];
        s0 s0Var = aVar2.f62397c;
        int i13 = aVar2.f62399e;
        w wVar = aVar2.f62396b;
        long j11 = wVar.f62451c[i13] + this.f62393y;
        int i14 = wVar.f62452d[i13];
        t0 t0Var = aVar2.f62398d;
        long j12 = (j11 - position) + this.f62385q;
        if (j12 < 0) {
            i11 = 1;
            l0Var2 = l0Var;
        } else {
            if (j12 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                if (aVar2.f62395a.f62421h == 1) {
                    j12 += 8;
                    i14 -= 8;
                }
                sVar.skipFully((int) j12);
                if (!l(aVar2.f62395a.f62420g)) {
                    this.f62388t = true;
                }
                t tVar = aVar2.f62395a;
                if (tVar.f62424k == 0) {
                    aVar = null;
                    if ("audio/ac4".equals(tVar.f62420g.f10243o)) {
                        if (this.f62386r == 0) {
                            l2.c.a(i14, this.f62373e);
                            s0Var.b(this.f62373e, 7);
                            this.f62386r += 7;
                        }
                        i14 += 7;
                    } else if (t0Var != null) {
                        t0Var.d(sVar);
                    }
                    while (true) {
                        int i15 = this.f62386r;
                        if (i15 >= i14) {
                            break;
                        }
                        int e11 = s0Var.e(sVar, i14 - i15, false);
                        this.f62385q += e11;
                        this.f62386r += e11;
                        this.f62387s -= e11;
                    }
                } else {
                    byte[] e12 = this.f62372d.e();
                    e12[0] = 0;
                    e12[1] = 0;
                    e12[2] = 0;
                    int i16 = 4 - aVar2.f62395a.f62424k;
                    i14 += i16;
                    while (this.f62386r < i14) {
                        int i17 = this.f62387s;
                        if (i17 == 0) {
                            t tVar2 = aVar2.f62395a;
                            int i18 = tVar2.f62424k;
                            if (this.f62388t || androidx.media3.container.g.o(tVar2.f62420g) + i18 > aVar2.f62396b.f62452d[i13] - this.f62385q) {
                                i12 = 0;
                            } else {
                                i12 = androidx.media3.container.g.o(aVar2.f62395a.f62420g);
                                i18 = aVar2.f62395a.f62424k + i12;
                            }
                            sVar.readFully(e12, i16, i18);
                            this.f62385q += i18;
                            this.f62372d.W(0);
                            int q11 = this.f62372d.q();
                            if (q11 < 0) {
                                throw ParserException.createForMalformedContainer("Invalid NAL length", null);
                            }
                            this.f62387s = q11 - i12;
                            this.f62371c.W(0);
                            s0Var.b(this.f62371c, 4);
                            this.f62386r += 4;
                            if (i12 > 0) {
                                s0Var.b(this.f62372d, i12);
                                this.f62386r += i12;
                                if (androidx.media3.container.g.k(e12, 4, i12, aVar2.f62395a.f62420g)) {
                                    this.f62388t = true;
                                }
                            }
                        } else {
                            int e13 = s0Var.e(sVar, i17, false);
                            this.f62385q += e13;
                            this.f62386r += e13;
                            this.f62387s -= e13;
                        }
                    }
                    aVar = null;
                }
                int i19 = i14;
                w wVar2 = aVar2.f62396b;
                long j13 = wVar2.f62454f[i13];
                int i20 = wVar2.f62455g[i13];
                if (!this.f62388t) {
                    i20 |= 67108864;
                }
                if (t0Var != null) {
                    int i21 = i20;
                    s0.a aVar3 = aVar;
                    boolean z10 = false;
                    t0Var.c(s0Var, j13, i21, i19, 0, null);
                    r52 = z10;
                    if (i13 + 1 == aVar2.f62396b.f62450b) {
                        t0Var.a(s0Var, aVar3);
                        r52 = z10;
                    }
                } else {
                    r52 = 0;
                    s0Var.d(j13, i20, i19, 0, null);
                }
                aVar2.f62399e++;
                this.f62384p = -1;
                this.f62385q = r52;
                this.f62386r = r52;
                this.f62387s = r52;
                this.f62388t = r52;
                return r52;
            }
            l0Var2 = l0Var;
            i11 = 1;
        }
        l0Var2.f68743a = j11;
        return i11;
    }

    private int G(l2.s sVar, l0 l0Var) {
        int c11 = this.f62376h.c(sVar, l0Var, this.f62377i);
        if (c11 == 1 && l0Var.f68743a == 0) {
            n();
        }
        return c11;
    }

    private static boolean H(int i11) {
        return i11 == 1836019574 || i11 == 1953653099 || i11 == 1835297121 || i11 == 1835626086 || i11 == 1937007212 || i11 == 1701082227 || i11 == 1835365473 || i11 == 1635284069;
    }

    private static boolean I(int i11) {
        return i11 == 1835296868 || i11 == 1836476516 || i11 == 1751411826 || i11 == 1937011556 || i11 == 1937011827 || i11 == 1937011571 || i11 == 1668576371 || i11 == 1701606260 || i11 == 1937011555 || i11 == 1937011578 || i11 == 1937013298 || i11 == 1937007471 || i11 == 1668232756 || i11 == 1953196132 || i11 == 1718909296 || i11 == 1969517665 || i11 == 1801812339 || i11 == 1768715124;
    }

    private boolean J(androidx.media3.common.x xVar) {
        androidx.media3.container.b a11;
        if (xVar != null && (this.f62370b & 64) != 0 && (a11 = j.a(xVar, "auxiliary.tracks.offset")) != null) {
            long O = new j0(a11.f10661b).O();
            if (O > 0) {
                this.f62391w = O;
                return true;
            }
        }
        return false;
    }

    private void K(a aVar, long j11) {
        w wVar = aVar.f62396b;
        int a11 = wVar.a(j11);
        if (a11 == -1) {
            a11 = wVar.b(j11);
        }
        aVar.f62399e = a11;
    }

    private static int j(int i11) {
        if (i11 != 1751476579) {
            return i11 != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    private static long[][] k(a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length];
        int[] iArr = new int[aVarArr.length];
        long[] jArr2 = new long[aVarArr.length];
        boolean[] zArr = new boolean[aVarArr.length];
        for (int i11 = 0; i11 < aVarArr.length; i11++) {
            jArr[i11] = new long[aVarArr[i11].f62396b.f62450b];
            jArr2[i11] = aVarArr[i11].f62396b.f62454f[0];
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
            w wVar = aVarArr[i13].f62396b;
            j11 += wVar.f62452d[i15];
            int i16 = i15 + 1;
            iArr[i13] = i16;
            if (i16 < jArr3.length) {
                jArr2[i13] = wVar.f62454f[i16];
            } else {
                zArr[i13] = true;
                i12++;
            }
        }
        return jArr;
    }

    private boolean l(androidx.media3.common.r rVar) {
        return Objects.equals(rVar.f10243o, MimeTypes.VIDEO_H264) ? (this.f62370b & 32) != 0 : Objects.equals(rVar.f10243o, MimeTypes.VIDEO_H265) && (this.f62370b & 128) != 0;
    }

    public static int m(int i11) {
        int i12 = (i11 & 1) != 0 ? 32 : 0;
        return (i11 & 2) != 0 ? i12 | 128 : i12;
    }

    private void n() {
        this.f62379k = 0;
        this.f62382n = 0;
    }

    private List o(androidx.media3.common.x xVar) {
        List b11 = ((androidx.media3.container.b) androidx.media3.common.util.a.i(j.a(xVar, "auxiliary.tracks.map"))).b();
        ArrayList arrayList = new ArrayList(b11.size());
        for (int i11 = 0; i11 < b11.size(); i11++) {
            int intValue = ((Integer) b11.get(i11)).intValue();
            int i12 = 1;
            if (intValue != 0) {
                if (intValue != 1) {
                    i12 = 3;
                    if (intValue != 2) {
                        i12 = intValue != 3 ? 0 : 4;
                    }
                } else {
                    i12 = 2;
                }
            }
            arrayList.add(Integer.valueOf(i12));
        }
        return arrayList;
    }

    private static int r(w wVar, long j11) {
        int a11 = wVar.a(j11);
        return a11 == -1 ? wVar.b(j11) : a11;
    }

    private int s(long j11) {
        int i11 = -1;
        int i12 = -1;
        int i13 = 0;
        long j12 = Long.MAX_VALUE;
        boolean z10 = true;
        long j13 = Long.MAX_VALUE;
        boolean z11 = true;
        long j14 = Long.MAX_VALUE;
        while (true) {
            a[] aVarArr = this.A;
            if (i13 >= aVarArr.length) {
                break;
            }
            a aVar = aVarArr[i13];
            int i14 = aVar.f62399e;
            w wVar = aVar.f62396b;
            if (i14 != wVar.f62450b) {
                long j15 = wVar.f62451c[i14];
                long j16 = ((long[][]) a1.i(this.B))[i13][i14];
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
    public static /* synthetic */ t t(t tVar) {
        return tVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l2.r[] u() {
        return new l2.r[]{new n(s.a.f65046a, 16)};
    }

    private static long v(w wVar, long j11, long j12) {
        int r11 = r(wVar, j11);
        return r11 == -1 ? j12 : Math.min(wVar.f62451c[r11], j12);
    }

    private void w(androidx.media3.common.x xVar) {
        androidx.media3.container.b a11 = j.a(xVar, "auxiliary.tracks.interleaved");
        if (a11 == null || a11.f10661b[0] != 0) {
            return;
        }
        this.f62393y = this.f62391w + 16;
    }

    private void x(l2.s sVar) {
        this.f62373e.S(8);
        sVar.peekFully(this.f62373e.e(), 0, 8);
        b.f(this.f62373e);
        sVar.skipFully(this.f62373e.f());
        sVar.resetPeekPosition();
    }

    private void y(long j11) {
        while (!this.f62375g.isEmpty() && ((d.b) this.f62375g.peek()).f10666b == j11) {
            d.b bVar = (d.b) this.f62375g.pop();
            if (bVar.f10665a == 1836019574) {
                B(bVar);
                this.f62375g.clear();
                if (!this.f62390v) {
                    this.f62379k = 2;
                }
            } else if (!this.f62375g.isEmpty()) {
                ((d.b) this.f62375g.peek()).b(bVar);
            }
        }
        if (this.f62379k != 2) {
            n();
        }
    }

    private void z() {
        if (this.E != 2 || (this.f62370b & 2) == 0) {
            return;
        }
        s0 track = this.f62394z.track(0, 4);
        a3.a aVar = this.F;
        track.c(new r.b().n0(aVar == null ? null : new androidx.media3.common.x(aVar)).N());
        this.f62394z.endTracks();
        this.f62394z.f(new m0.b(C.TIME_UNSET));
    }

    @Override // l2.r
    public void b(l2.t tVar) {
        if ((this.f62370b & 16) == 0) {
            tVar = new i3.t(tVar, this.f62369a);
        }
        this.f62394z = tVar;
    }

    @Override // l2.r
    public int c(l2.s sVar, l0 l0Var) {
        while (true) {
            int i11 = this.f62379k;
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 == 2) {
                        return F(sVar, l0Var);
                    }
                    if (i11 == 3) {
                        return G(sVar, l0Var);
                    }
                    throw new IllegalStateException();
                }
                if (E(sVar, l0Var)) {
                    return 1;
                }
            } else if (!D(sVar)) {
                return -1;
            }
        }
    }

    @Override // l2.r
    public boolean d(l2.s sVar) {
        q0 d11 = s.d(sVar, (this.f62370b & 2) != 0);
        this.f62378j = d11 != null ? ImmutableList.of(d11) : ImmutableList.of();
        return d11 == null;
    }

    @Override // l2.r
    public /* synthetic */ l2.r e() {
        return l2.q.b(this);
    }

    @Override // l2.m0
    public long getDurationUs() {
        return this.D;
    }

    @Override // l2.m0
    public m0.a getSeekPoints(long j11) {
        return p(j11, -1);
    }

    @Override // l2.m0
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
    public l2.m0.a p(long r17, int r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r19
            f3.n$a[] r4 = r0.A
            int r5 = r4.length
            if (r5 != 0) goto L13
            l2.m0$a r1 = new l2.m0$a
            l2.n0 r2 = l2.n0.f68772c
            r1.<init>(r2)
            return r1
        L13:
            r5 = -1
            if (r3 == r5) goto L18
            r6 = r3
            goto L1a
        L18:
            int r6 = r0.C
        L1a:
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r9 = -1
            if (r6 == r5) goto L58
            r4 = r4[r6]
            f3.w r4 = r4.f62396b
            int r6 = r(r4, r1)
            if (r6 != r5) goto L35
            l2.m0$a r1 = new l2.m0$a
            l2.n0 r2 = l2.n0.f68772c
            r1.<init>(r2)
            return r1
        L35:
            long[] r11 = r4.f62454f
            r12 = r11[r6]
            long[] r11 = r4.f62451c
            r14 = r11[r6]
            int r11 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r11 >= 0) goto L5e
            int r11 = r4.f62450b
            int r11 = r11 + (-1)
            if (r6 >= r11) goto L5e
            int r1 = r4.b(r1)
            if (r1 == r5) goto L5e
            if (r1 == r6) goto L5e
            long[] r2 = r4.f62454f
            r9 = r2[r1]
            long[] r2 = r4.f62451c
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
            f3.n$a[] r4 = r0.A
            int r5 = r4.length
            if (r3 >= r5) goto L80
            int r5 = r0.C
            if (r3 == r5) goto L7d
            r4 = r4[r3]
            f3.w r4 = r4.f62396b
            long r5 = v(r4, r12, r14)
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L7c
            long r1 = v(r4, r9, r1)
        L7c:
            r14 = r5
        L7d:
            int r3 = r3 + 1
            goto L63
        L80:
            l2.n0 r3 = new l2.n0
            r3.<init>(r12, r14)
            int r4 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r4 != 0) goto L8f
            l2.m0$a r1 = new l2.m0$a
            r1.<init>(r3)
            return r1
        L8f:
            l2.n0 r4 = new l2.n0
            r4.<init>(r9, r1)
            l2.m0$a r1 = new l2.m0$a
            r1.<init>(r3, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.n.p(long, int):l2.m0$a");
    }

    @Override // l2.r
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public ImmutableList f() {
        return this.f62378j;
    }

    @Override // l2.r
    public void release() {
    }

    @Override // l2.r
    public void seek(long j11, long j12) {
        this.f62375g.clear();
        this.f62382n = 0;
        this.f62384p = -1;
        this.f62385q = 0;
        this.f62386r = 0;
        this.f62387s = 0;
        this.f62388t = false;
        if (j11 == 0) {
            if (this.f62379k != 3) {
                n();
                return;
            } else {
                this.f62376h.g();
                this.f62377i.clear();
                return;
            }
        }
        for (a aVar : this.A) {
            K(aVar, j12);
            t0 t0Var = aVar.f62398d;
            if (t0Var != null) {
                t0Var.b();
            }
        }
    }
}

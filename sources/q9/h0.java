package q9;

import android.net.Uri;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import g9.b0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import q9.i0;

/* loaded from: classes4.dex */
public final class h0 implements g9.l {

    /* renamed from: t, reason: collision with root package name */
    public static final g9.r f73385t = new g9.r() { // from class: q9.g0
        @Override // g9.r
        public /* synthetic */ g9.l[] c(Uri uri, Map map) {
            return g9.q.a(this, uri, map);
        }

        @Override // g9.r
        public final g9.l[] createExtractors() {
            g9.l[] v11;
            v11 = h0.v();
            return v11;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final int f73386a;

    /* renamed from: b, reason: collision with root package name */
    private final int f73387b;

    /* renamed from: c, reason: collision with root package name */
    private final List f73388c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.d0 f73389d;

    /* renamed from: e, reason: collision with root package name */
    private final SparseIntArray f73390e;

    /* renamed from: f, reason: collision with root package name */
    private final i0.c f73391f;

    /* renamed from: g, reason: collision with root package name */
    private final SparseArray f73392g;

    /* renamed from: h, reason: collision with root package name */
    private final SparseBooleanArray f73393h;

    /* renamed from: i, reason: collision with root package name */
    private final SparseBooleanArray f73394i;

    /* renamed from: j, reason: collision with root package name */
    private final f0 f73395j;

    /* renamed from: k, reason: collision with root package name */
    private e0 f73396k;

    /* renamed from: l, reason: collision with root package name */
    private g9.n f73397l;

    /* renamed from: m, reason: collision with root package name */
    private int f73398m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f73399n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f73400o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f73401p;

    /* renamed from: q, reason: collision with root package name */
    private i0 f73402q;

    /* renamed from: r, reason: collision with root package name */
    private int f73403r;

    /* renamed from: s, reason: collision with root package name */
    private int f73404s;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a implements b0 {

        /* renamed from: a, reason: collision with root package name */
        private final com.google.android.exoplayer2.util.c0 f73405a = new com.google.android.exoplayer2.util.c0(new byte[4]);

        public a() {
        }

        @Override // q9.b0
        public void a(com.google.android.exoplayer2.util.d0 d0Var) {
            if (d0Var.D() == 0 && (d0Var.D() & 128) != 0) {
                d0Var.Q(6);
                int a11 = d0Var.a() / 4;
                for (int i11 = 0; i11 < a11; i11++) {
                    d0Var.i(this.f73405a, 4);
                    int h11 = this.f73405a.h(16);
                    this.f73405a.r(3);
                    if (h11 == 0) {
                        this.f73405a.r(13);
                    } else {
                        int h12 = this.f73405a.h(13);
                        if (h0.this.f73392g.get(h12) == null) {
                            h0.this.f73392g.put(h12, new c0(new b(h12)));
                            h0.j(h0.this);
                        }
                    }
                }
                if (h0.this.f73386a != 2) {
                    h0.this.f73392g.remove(0);
                }
            }
        }

        @Override // q9.b0
        public void b(l0 l0Var, g9.n nVar, i0.d dVar) {
        }
    }

    /* loaded from: classes4.dex */
    private class b implements b0 {

        /* renamed from: a, reason: collision with root package name */
        private final com.google.android.exoplayer2.util.c0 f73407a = new com.google.android.exoplayer2.util.c0(new byte[5]);

        /* renamed from: b, reason: collision with root package name */
        private final SparseArray f73408b = new SparseArray();

        /* renamed from: c, reason: collision with root package name */
        private final SparseIntArray f73409c = new SparseIntArray();

        /* renamed from: d, reason: collision with root package name */
        private final int f73410d;

        public b(int i11) {
            this.f73410d = i11;
        }

        private i0.b c(com.google.android.exoplayer2.util.d0 d0Var, int i11) {
            int e11 = d0Var.e();
            int i12 = i11 + e11;
            int i13 = -1;
            String str = null;
            ArrayList arrayList = null;
            while (d0Var.e() < i12) {
                int D = d0Var.D();
                int e12 = d0Var.e() + d0Var.D();
                if (e12 > i12) {
                    break;
                }
                if (D == 5) {
                    long F = d0Var.F();
                    if (F != 1094921523) {
                        if (F != 1161904947) {
                            if (F != 1094921524) {
                                if (F == 1212503619) {
                                    i13 = 36;
                                }
                            }
                            i13 = 172;
                        }
                        i13 = 135;
                    }
                    i13 = 129;
                } else {
                    if (D != 106) {
                        if (D != 122) {
                            if (D == 127) {
                                if (d0Var.D() != 21) {
                                }
                                i13 = 172;
                            } else if (D == 123) {
                                i13 = 138;
                            } else if (D == 10) {
                                str = d0Var.A(3).trim();
                            } else if (D == 89) {
                                ArrayList arrayList2 = new ArrayList();
                                while (d0Var.e() < e12) {
                                    String trim = d0Var.A(3).trim();
                                    int D2 = d0Var.D();
                                    byte[] bArr = new byte[4];
                                    d0Var.j(bArr, 0, 4);
                                    arrayList2.add(new i0.a(trim, D2, bArr));
                                }
                                arrayList = arrayList2;
                                i13 = 89;
                            } else if (D == 111) {
                                i13 = InputDeviceCompat.SOURCE_KEYBOARD;
                            }
                        }
                        i13 = 135;
                    }
                    i13 = 129;
                }
                d0Var.Q(e12 - d0Var.e());
            }
            d0Var.P(i12);
            return new i0.b(i13, str, arrayList, Arrays.copyOfRange(d0Var.d(), e11, i12));
        }

        @Override // q9.b0
        public void a(com.google.android.exoplayer2.util.d0 d0Var) {
            l0 l0Var;
            if (d0Var.D() != 2) {
                return;
            }
            if (h0.this.f73386a == 1 || h0.this.f73386a == 2 || h0.this.f73398m == 1) {
                l0Var = (l0) h0.this.f73388c.get(0);
            } else {
                l0Var = new l0(((l0) h0.this.f73388c.get(0)).c());
                h0.this.f73388c.add(l0Var);
            }
            if ((d0Var.D() & 128) == 0) {
                return;
            }
            d0Var.Q(1);
            int J = d0Var.J();
            int i11 = 3;
            d0Var.Q(3);
            d0Var.i(this.f73407a, 2);
            this.f73407a.r(3);
            int i12 = 13;
            h0.this.f73404s = this.f73407a.h(13);
            d0Var.i(this.f73407a, 2);
            int i13 = 4;
            this.f73407a.r(4);
            d0Var.Q(this.f73407a.h(12));
            if (h0.this.f73386a == 2 && h0.this.f73402q == null) {
                i0.b bVar = new i0.b(21, null, null, p0.f27685f);
                h0 h0Var = h0.this;
                h0Var.f73402q = h0Var.f73391f.a(21, bVar);
                if (h0.this.f73402q != null) {
                    h0.this.f73402q.b(l0Var, h0.this.f73397l, new i0.d(J, 21, 8192));
                }
            }
            this.f73408b.clear();
            this.f73409c.clear();
            int a11 = d0Var.a();
            while (a11 > 0) {
                d0Var.i(this.f73407a, 5);
                int h11 = this.f73407a.h(8);
                this.f73407a.r(i11);
                int h12 = this.f73407a.h(i12);
                this.f73407a.r(i13);
                int h13 = this.f73407a.h(12);
                i0.b c11 = c(d0Var, h13);
                if (h11 == 6 || h11 == 5) {
                    h11 = c11.f73437a;
                }
                a11 -= h13 + 5;
                int i14 = h0.this.f73386a == 2 ? h11 : h12;
                if (!h0.this.f73393h.get(i14)) {
                    i0 a12 = (h0.this.f73386a == 2 && h11 == 21) ? h0.this.f73402q : h0.this.f73391f.a(h11, c11);
                    if (h0.this.f73386a != 2 || h12 < this.f73409c.get(i14, 8192)) {
                        this.f73409c.put(i14, h12);
                        this.f73408b.put(i14, a12);
                    }
                }
                i11 = 3;
                i13 = 4;
                i12 = 13;
            }
            int size = this.f73409c.size();
            for (int i15 = 0; i15 < size; i15++) {
                int keyAt = this.f73409c.keyAt(i15);
                int valueAt = this.f73409c.valueAt(i15);
                h0.this.f73393h.put(keyAt, true);
                h0.this.f73394i.put(valueAt, true);
                i0 i0Var = (i0) this.f73408b.valueAt(i15);
                if (i0Var != null) {
                    if (i0Var != h0.this.f73402q) {
                        i0Var.b(l0Var, h0.this.f73397l, new i0.d(J, keyAt, 8192));
                    }
                    h0.this.f73392g.put(valueAt, i0Var);
                }
            }
            if (h0.this.f73386a == 2) {
                if (h0.this.f73399n) {
                    return;
                }
                h0.this.f73397l.endTracks();
                h0.this.f73398m = 0;
                h0.this.f73399n = true;
                return;
            }
            h0.this.f73392g.remove(this.f73410d);
            h0 h0Var2 = h0.this;
            h0Var2.f73398m = h0Var2.f73386a == 1 ? 0 : h0.this.f73398m - 1;
            if (h0.this.f73398m == 0) {
                h0.this.f73397l.endTracks();
                h0.this.f73399n = true;
            }
        }

        @Override // q9.b0
        public void b(l0 l0Var, g9.n nVar, i0.d dVar) {
        }
    }

    public h0() {
        this(0);
    }

    public h0(int i11) {
        this(1, i11, 112800);
    }

    public h0(int i11, int i12, int i13) {
        this(i11, new l0(0L), new j(i12), i13);
    }

    public h0(int i11, l0 l0Var, i0.c cVar) {
        this(i11, l0Var, cVar, 112800);
    }

    public h0(int i11, l0 l0Var, i0.c cVar, int i12) {
        this.f73391f = (i0.c) com.google.android.exoplayer2.util.a.e(cVar);
        this.f73387b = i12;
        this.f73386a = i11;
        if (i11 == 1 || i11 == 2) {
            this.f73388c = Collections.singletonList(l0Var);
        } else {
            ArrayList arrayList = new ArrayList();
            this.f73388c = arrayList;
            arrayList.add(l0Var);
        }
        this.f73389d = new com.google.android.exoplayer2.util.d0(new byte[9400], 0);
        this.f73393h = new SparseBooleanArray();
        this.f73394i = new SparseBooleanArray();
        this.f73392g = new SparseArray();
        this.f73390e = new SparseIntArray();
        this.f73395j = new f0(i12);
        this.f73397l = g9.n.f63576i1;
        this.f73404s = -1;
        x();
    }

    static /* synthetic */ int j(h0 h0Var) {
        int i11 = h0Var.f73398m;
        h0Var.f73398m = i11 + 1;
        return i11;
    }

    private boolean t(g9.m mVar) {
        byte[] d11 = this.f73389d.d();
        if (9400 - this.f73389d.e() < 188) {
            int a11 = this.f73389d.a();
            if (a11 > 0) {
                System.arraycopy(d11, this.f73389d.e(), d11, 0, a11);
            }
            this.f73389d.N(d11, a11);
        }
        while (this.f73389d.a() < 188) {
            int f11 = this.f73389d.f();
            int read = mVar.read(d11, f11, 9400 - f11);
            if (read == -1) {
                return false;
            }
            this.f73389d.O(f11 + read);
        }
        return true;
    }

    private int u() {
        int e11 = this.f73389d.e();
        int f11 = this.f73389d.f();
        int a11 = j0.a(this.f73389d.d(), e11, f11);
        this.f73389d.P(a11);
        int i11 = a11 + 188;
        if (i11 > f11) {
            int i12 = this.f73403r + (a11 - e11);
            this.f73403r = i12;
            if (this.f73386a == 2 && i12 > 376) {
                throw ParserException.createForMalformedContainer("Cannot find sync byte. Most likely not a Transport Stream.", null);
            }
        } else {
            this.f73403r = 0;
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ g9.l[] v() {
        return new g9.l[]{new h0()};
    }

    private void w(long j11) {
        if (this.f73400o) {
            return;
        }
        this.f73400o = true;
        if (this.f73395j.b() == C.TIME_UNSET) {
            this.f73397l.d(new b0.b(this.f73395j.b()));
            return;
        }
        e0 e0Var = new e0(this.f73395j.c(), this.f73395j.b(), j11, this.f73404s, this.f73387b);
        this.f73396k = e0Var;
        this.f73397l.d(e0Var.b());
    }

    private void x() {
        this.f73393h.clear();
        this.f73392g.clear();
        SparseArray createInitialPayloadReaders = this.f73391f.createInitialPayloadReaders();
        int size = createInitialPayloadReaders.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f73392g.put(createInitialPayloadReaders.keyAt(i11), (i0) createInitialPayloadReaders.valueAt(i11));
        }
        this.f73392g.put(0, new c0(new a()));
        this.f73402q = null;
    }

    private boolean y(int i11) {
        return this.f73386a == 2 || this.f73399n || !this.f73394i.get(i11, false);
    }

    @Override // g9.l
    public void b(g9.n nVar) {
        this.f73397l = nVar;
    }

    @Override // g9.l
    public int c(g9.m mVar, g9.a0 a0Var) {
        long length = mVar.getLength();
        if (this.f73399n) {
            if (length != -1 && this.f73386a != 2 && !this.f73395j.d()) {
                return this.f73395j.e(mVar, a0Var, this.f73404s);
            }
            w(length);
            if (this.f73401p) {
                this.f73401p = false;
                seek(0L, 0L);
                if (mVar.getPosition() != 0) {
                    a0Var.f63492a = 0L;
                    return 1;
                }
            }
            e0 e0Var = this.f73396k;
            if (e0Var != null && e0Var.d()) {
                return this.f73396k.c(mVar, a0Var);
            }
        }
        if (!t(mVar)) {
            return -1;
        }
        int u11 = u();
        int f11 = this.f73389d.f();
        if (u11 > f11) {
            return 0;
        }
        int n11 = this.f73389d.n();
        if ((8388608 & n11) != 0) {
            this.f73389d.P(u11);
            return 0;
        }
        int i11 = (4194304 & n11) != 0 ? 1 : 0;
        int i12 = (2096896 & n11) >> 8;
        boolean z10 = (n11 & 32) != 0;
        i0 i0Var = (n11 & 16) != 0 ? (i0) this.f73392g.get(i12) : null;
        if (i0Var == null) {
            this.f73389d.P(u11);
            return 0;
        }
        if (this.f73386a != 2) {
            int i13 = n11 & 15;
            int i14 = this.f73390e.get(i12, i13 - 1);
            this.f73390e.put(i12, i13);
            if (i14 == i13) {
                this.f73389d.P(u11);
                return 0;
            }
            if (i13 != ((i14 + 1) & 15)) {
                i0Var.seek();
            }
        }
        if (z10) {
            int D = this.f73389d.D();
            i11 |= (this.f73389d.D() & 64) != 0 ? 2 : 0;
            this.f73389d.Q(D - 1);
        }
        boolean z11 = this.f73399n;
        if (y(i12)) {
            this.f73389d.O(u11);
            i0Var.a(this.f73389d, i11);
            this.f73389d.O(f11);
        }
        if (this.f73386a != 2 && !z11 && this.f73399n && length != -1) {
            this.f73401p = true;
        }
        this.f73389d.P(u11);
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
    
        r1 = r1 + 1;
     */
    @Override // g9.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean d(g9.m r7) {
        /*
            r6 = this;
            com.google.android.exoplayer2.util.d0 r0 = r6.f73389d
            byte[] r0 = r0.d()
            r1 = 940(0x3ac, float:1.317E-42)
            r2 = 0
            r7.peekFully(r0, r2, r1)
            r1 = r2
        Ld:
            r3 = 188(0xbc, float:2.63E-43)
            if (r1 >= r3) goto L29
            r3 = r2
        L12:
            r4 = 5
            if (r3 >= r4) goto L24
            int r4 = r3 * 188
            int r4 = r4 + r1
            r4 = r0[r4]
            r5 = 71
            if (r4 == r5) goto L21
            int r1 = r1 + 1
            goto Ld
        L21:
            int r3 = r3 + 1
            goto L12
        L24:
            r7.skipFully(r1)
            r7 = 1
            return r7
        L29:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: q9.h0.d(g9.m):boolean");
    }

    @Override // g9.l
    public void release() {
    }

    @Override // g9.l
    public void seek(long j11, long j12) {
        e0 e0Var;
        com.google.android.exoplayer2.util.a.g(this.f73386a != 2);
        int size = this.f73388c.size();
        for (int i11 = 0; i11 < size; i11++) {
            l0 l0Var = (l0) this.f73388c.get(i11);
            boolean z10 = l0Var.e() == C.TIME_UNSET;
            if (!z10) {
                long c11 = l0Var.c();
                z10 = (c11 == C.TIME_UNSET || c11 == 0 || c11 == j12) ? false : true;
            }
            if (z10) {
                l0Var.g(j12);
            }
        }
        if (j12 != 0 && (e0Var = this.f73396k) != null) {
            e0Var.h(j12);
        }
        this.f73389d.L(0);
        this.f73390e.clear();
        for (int i12 = 0; i12 < this.f73392g.size(); i12++) {
            ((i0) this.f73392g.valueAt(i12)).seek();
        }
        this.f73403r = 0;
    }
}

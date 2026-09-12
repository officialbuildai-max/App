package s3;

import android.net.Uri;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import i3.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import l2.m0;
import s3.l0;

/* loaded from: classes2.dex */
public final class k0 implements l2.r {

    /* renamed from: v, reason: collision with root package name */
    public static final l2.x f75128v = new l2.x() { // from class: s3.j0
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
            l2.r[] x10;
            x10 = k0.x();
            return x10;
        }

        @Override // l2.x
        public /* synthetic */ l2.x d(boolean z10) {
            return l2.w.c(this, z10);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final int f75129a;

    /* renamed from: b, reason: collision with root package name */
    private final int f75130b;

    /* renamed from: c, reason: collision with root package name */
    private final int f75131c;

    /* renamed from: d, reason: collision with root package name */
    private final List f75132d;

    /* renamed from: e, reason: collision with root package name */
    private final androidx.media3.common.util.j0 f75133e;

    /* renamed from: f, reason: collision with root package name */
    private final SparseIntArray f75134f;

    /* renamed from: g, reason: collision with root package name */
    private final l0.c f75135g;

    /* renamed from: h, reason: collision with root package name */
    private final s.a f75136h;

    /* renamed from: i, reason: collision with root package name */
    private final SparseArray f75137i;

    /* renamed from: j, reason: collision with root package name */
    private final SparseBooleanArray f75138j;

    /* renamed from: k, reason: collision with root package name */
    private final SparseBooleanArray f75139k;

    /* renamed from: l, reason: collision with root package name */
    private final i0 f75140l;

    /* renamed from: m, reason: collision with root package name */
    private h0 f75141m;

    /* renamed from: n, reason: collision with root package name */
    private l2.t f75142n;

    /* renamed from: o, reason: collision with root package name */
    private int f75143o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f75144p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f75145q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f75146r;

    /* renamed from: s, reason: collision with root package name */
    private l0 f75147s;

    /* renamed from: t, reason: collision with root package name */
    private int f75148t;

    /* renamed from: u, reason: collision with root package name */
    private int f75149u;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements d0 {

        /* renamed from: a, reason: collision with root package name */
        private final androidx.media3.common.util.i0 f75150a = new androidx.media3.common.util.i0(new byte[4]);

        public a() {
        }

        @Override // s3.d0
        public void a(androidx.media3.common.util.j0 j0Var) {
            if (j0Var.H() == 0 && (j0Var.H() & 128) != 0) {
                j0Var.X(6);
                int a11 = j0Var.a() / 4;
                for (int i11 = 0; i11 < a11; i11++) {
                    j0Var.k(this.f75150a, 4);
                    int h11 = this.f75150a.h(16);
                    this.f75150a.r(3);
                    if (h11 == 0) {
                        this.f75150a.r(13);
                    } else {
                        int h12 = this.f75150a.h(13);
                        if (k0.this.f75137i.get(h12) == null) {
                            k0.this.f75137i.put(h12, new e0(new b(h12)));
                            k0.l(k0.this);
                        }
                    }
                }
                if (k0.this.f75129a != 2) {
                    k0.this.f75137i.remove(0);
                }
            }
        }

        @Override // s3.d0
        public void b(p0 p0Var, l2.t tVar, l0.d dVar) {
        }
    }

    /* loaded from: classes2.dex */
    private class b implements d0 {

        /* renamed from: a, reason: collision with root package name */
        private final androidx.media3.common.util.i0 f75152a = new androidx.media3.common.util.i0(new byte[5]);

        /* renamed from: b, reason: collision with root package name */
        private final SparseArray f75153b = new SparseArray();

        /* renamed from: c, reason: collision with root package name */
        private final SparseIntArray f75154c = new SparseIntArray();

        /* renamed from: d, reason: collision with root package name */
        private final int f75155d;

        public b(int i11) {
            this.f75155d = i11;
        }

        private l0.b c(androidx.media3.common.util.j0 j0Var, int i11) {
            int i12;
            int f11 = j0Var.f();
            int i13 = f11 + i11;
            int i14 = -1;
            String str = null;
            ArrayList arrayList = null;
            int i15 = 0;
            while (j0Var.f() < i13) {
                int H = j0Var.H();
                int f12 = j0Var.f() + j0Var.H();
                if (f12 > i13) {
                    break;
                }
                if (H == 5) {
                    long J = j0Var.J();
                    if (J != 1094921523) {
                        if (J != 1161904947) {
                            if (J != 1094921524) {
                                if (J == 1212503619) {
                                    i14 = 36;
                                }
                            }
                            i14 = 172;
                        }
                        i14 = 135;
                    }
                    i14 = 129;
                } else {
                    if (H != 106) {
                        if (H != 122) {
                            if (H == 127) {
                                int H2 = j0Var.H();
                                if (H2 != 21) {
                                    if (H2 == 14) {
                                        i14 = Sdk$SDKError.Reason.PRIVACY_URL_ERROR_VALUE;
                                    } else if (H2 == 33) {
                                        i14 = 139;
                                    }
                                }
                                i14 = 172;
                            } else {
                                if (H == 123) {
                                    i12 = 138;
                                } else if (H == 10) {
                                    String trim = j0Var.E(3).trim();
                                    i15 = j0Var.H();
                                    str = trim;
                                } else if (H == 89) {
                                    ArrayList arrayList2 = new ArrayList();
                                    while (j0Var.f() < f12) {
                                        String trim2 = j0Var.E(3).trim();
                                        int H3 = j0Var.H();
                                        byte[] bArr = new byte[4];
                                        j0Var.l(bArr, 0, 4);
                                        arrayList2.add(new l0.a(trim2, H3, bArr));
                                    }
                                    arrayList = arrayList2;
                                    i14 = 89;
                                } else if (H == 111) {
                                    i12 = InputDeviceCompat.SOURCE_KEYBOARD;
                                }
                                i14 = i12;
                            }
                        }
                        i14 = 135;
                    }
                    i14 = 129;
                }
                j0Var.X(f12 - j0Var.f());
            }
            j0Var.W(i13);
            return new l0.b(i14, str, i15, arrayList, Arrays.copyOfRange(j0Var.e(), f11, i13));
        }

        @Override // s3.d0
        public void a(androidx.media3.common.util.j0 j0Var) {
            p0 p0Var;
            if (j0Var.H() != 2) {
                return;
            }
            if (k0.this.f75129a == 1 || k0.this.f75129a == 2 || k0.this.f75143o == 1) {
                p0Var = (p0) k0.this.f75132d.get(0);
            } else {
                p0Var = new p0(((p0) k0.this.f75132d.get(0)).d());
                k0.this.f75132d.add(p0Var);
            }
            if ((j0Var.H() & 128) == 0) {
                return;
            }
            j0Var.X(1);
            int P = j0Var.P();
            int i11 = 3;
            j0Var.X(3);
            j0Var.k(this.f75152a, 2);
            this.f75152a.r(3);
            int i12 = 13;
            k0.this.f75149u = this.f75152a.h(13);
            j0Var.k(this.f75152a, 2);
            int i13 = 4;
            this.f75152a.r(4);
            j0Var.X(this.f75152a.h(12));
            if (k0.this.f75129a == 2 && k0.this.f75147s == null) {
                l0.b bVar = new l0.b(21, null, 0, null, a1.f10437f);
                k0 k0Var = k0.this;
                k0Var.f75147s = k0Var.f75135g.a(21, bVar);
                if (k0.this.f75147s != null) {
                    k0.this.f75147s.b(p0Var, k0.this.f75142n, new l0.d(P, 21, 8192));
                }
            }
            this.f75153b.clear();
            this.f75154c.clear();
            int a11 = j0Var.a();
            while (a11 > 0) {
                j0Var.k(this.f75152a, 5);
                int h11 = this.f75152a.h(8);
                this.f75152a.r(i11);
                int h12 = this.f75152a.h(i12);
                this.f75152a.r(i13);
                int h13 = this.f75152a.h(12);
                l0.b c11 = c(j0Var, h13);
                if (h11 == 6 || h11 == 5) {
                    h11 = c11.f75167a;
                }
                a11 -= h13 + 5;
                int i14 = k0.this.f75129a == 2 ? h11 : h12;
                if (!k0.this.f75138j.get(i14)) {
                    l0 a12 = (k0.this.f75129a == 2 && h11 == 21) ? k0.this.f75147s : k0.this.f75135g.a(h11, c11);
                    if (k0.this.f75129a != 2 || h12 < this.f75154c.get(i14, 8192)) {
                        this.f75154c.put(i14, h12);
                        this.f75153b.put(i14, a12);
                    }
                }
                i11 = 3;
                i13 = 4;
                i12 = 13;
            }
            int size = this.f75154c.size();
            for (int i15 = 0; i15 < size; i15++) {
                int keyAt = this.f75154c.keyAt(i15);
                int valueAt = this.f75154c.valueAt(i15);
                k0.this.f75138j.put(keyAt, true);
                k0.this.f75139k.put(valueAt, true);
                l0 l0Var = (l0) this.f75153b.valueAt(i15);
                if (l0Var != null) {
                    if (l0Var != k0.this.f75147s) {
                        l0Var.b(p0Var, k0.this.f75142n, new l0.d(P, keyAt, 8192));
                    }
                    k0.this.f75137i.put(valueAt, l0Var);
                }
            }
            if (k0.this.f75129a == 2) {
                if (k0.this.f75144p) {
                    return;
                }
                k0.this.f75142n.endTracks();
                k0.this.f75143o = 0;
                k0.this.f75144p = true;
                return;
            }
            k0.this.f75137i.remove(this.f75155d);
            k0 k0Var2 = k0.this;
            k0Var2.f75143o = k0Var2.f75129a == 1 ? 0 : k0.this.f75143o - 1;
            if (k0.this.f75143o == 0) {
                k0.this.f75142n.endTracks();
                k0.this.f75144p = true;
            }
        }

        @Override // s3.d0
        public void b(p0 p0Var, l2.t tVar, l0.d dVar) {
        }
    }

    @Deprecated
    public k0() {
        this(1, 1, s.a.f65046a, new p0(0L), new j(0), 112800);
    }

    public k0(int i11, int i12, s.a aVar, p0 p0Var, l0.c cVar, int i13) {
        this.f75135g = (l0.c) androidx.media3.common.util.a.e(cVar);
        this.f75131c = i13;
        this.f75129a = i11;
        this.f75130b = i12;
        this.f75136h = aVar;
        if (i11 == 1 || i11 == 2) {
            this.f75132d = Collections.singletonList(p0Var);
        } else {
            ArrayList arrayList = new ArrayList();
            this.f75132d = arrayList;
            arrayList.add(p0Var);
        }
        this.f75133e = new androidx.media3.common.util.j0(new byte[9400], 0);
        this.f75138j = new SparseBooleanArray();
        this.f75139k = new SparseBooleanArray();
        this.f75137i = new SparseArray();
        this.f75134f = new SparseIntArray();
        this.f75140l = new i0(i13);
        this.f75142n = l2.t.f68806n1;
        this.f75149u = -1;
        z();
    }

    public k0(int i11, s.a aVar) {
        this(1, i11, aVar, new p0(0L), new j(0), 112800);
    }

    private boolean A(int i11) {
        return this.f75129a == 2 || this.f75144p || !this.f75139k.get(i11, false);
    }

    static /* synthetic */ int l(k0 k0Var) {
        int i11 = k0Var.f75143o;
        k0Var.f75143o = i11 + 1;
        return i11;
    }

    private boolean v(l2.s sVar) {
        byte[] e11 = this.f75133e.e();
        if (9400 - this.f75133e.f() < 188) {
            int a11 = this.f75133e.a();
            if (a11 > 0) {
                System.arraycopy(e11, this.f75133e.f(), e11, 0, a11);
            }
            this.f75133e.U(e11, a11);
        }
        while (this.f75133e.a() < 188) {
            int g11 = this.f75133e.g();
            int read = sVar.read(e11, g11, 9400 - g11);
            if (read == -1) {
                return false;
            }
            this.f75133e.V(g11 + read);
        }
        return true;
    }

    private int w() {
        int f11 = this.f75133e.f();
        int g11 = this.f75133e.g();
        int a11 = m0.a(this.f75133e.e(), f11, g11);
        this.f75133e.W(a11);
        int i11 = a11 + 188;
        if (i11 > g11) {
            int i12 = this.f75148t + (a11 - f11);
            this.f75148t = i12;
            if (this.f75129a == 2 && i12 > 376) {
                throw ParserException.createForMalformedContainer("Cannot find sync byte. Most likely not a Transport Stream.", null);
            }
        } else {
            this.f75148t = 0;
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l2.r[] x() {
        return new l2.r[]{new k0(1, s.a.f65046a)};
    }

    private void y(long j11) {
        if (this.f75145q) {
            return;
        }
        this.f75145q = true;
        if (this.f75140l.b() == C.TIME_UNSET) {
            this.f75142n.f(new m0.b(this.f75140l.b()));
            return;
        }
        h0 h0Var = new h0(this.f75140l.c(), this.f75140l.b(), j11, this.f75149u, this.f75131c);
        this.f75141m = h0Var;
        this.f75142n.f(h0Var.b());
    }

    private void z() {
        this.f75138j.clear();
        this.f75137i.clear();
        SparseArray createInitialPayloadReaders = this.f75135g.createInitialPayloadReaders();
        int size = createInitialPayloadReaders.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f75137i.put(createInitialPayloadReaders.keyAt(i11), (l0) createInitialPayloadReaders.valueAt(i11));
        }
        this.f75137i.put(0, new e0(new a()));
        this.f75147s = null;
    }

    @Override // l2.r
    public void b(l2.t tVar) {
        if ((this.f75130b & 1) == 0) {
            tVar = new i3.t(tVar, this.f75136h);
        }
        this.f75142n = tVar;
    }

    @Override // l2.r
    public int c(l2.s sVar, l2.l0 l0Var) {
        long length = sVar.getLength();
        boolean z10 = this.f75129a == 2;
        if (this.f75144p) {
            if (length != -1 && !z10 && !this.f75140l.d()) {
                return this.f75140l.e(sVar, l0Var, this.f75149u);
            }
            y(length);
            if (this.f75146r) {
                this.f75146r = false;
                seek(0L, 0L);
                if (sVar.getPosition() != 0) {
                    l0Var.f68743a = 0L;
                    return 1;
                }
            }
            h0 h0Var = this.f75141m;
            if (h0Var != null && h0Var.d()) {
                return this.f75141m.c(sVar, l0Var);
            }
        }
        if (!v(sVar)) {
            for (int i11 = 0; i11 < this.f75137i.size(); i11++) {
                l0 l0Var2 = (l0) this.f75137i.valueAt(i11);
                if (l0Var2 instanceof y) {
                    y yVar = (y) l0Var2;
                    if (yVar.c(z10)) {
                        yVar.a(new androidx.media3.common.util.j0(), 1);
                    }
                }
            }
            return -1;
        }
        int w11 = w();
        int g11 = this.f75133e.g();
        if (w11 > g11) {
            return 0;
        }
        int q11 = this.f75133e.q();
        if ((8388608 & q11) != 0) {
            this.f75133e.W(w11);
            return 0;
        }
        int i12 = (4194304 & q11) != 0 ? 1 : 0;
        int i13 = (2096896 & q11) >> 8;
        boolean z11 = (q11 & 32) != 0;
        l0 l0Var3 = (q11 & 16) != 0 ? (l0) this.f75137i.get(i13) : null;
        if (l0Var3 == null) {
            this.f75133e.W(w11);
            return 0;
        }
        if (this.f75129a != 2) {
            int i14 = q11 & 15;
            int i15 = this.f75134f.get(i13, i14 - 1);
            this.f75134f.put(i13, i14);
            if (i15 == i14) {
                this.f75133e.W(w11);
                return 0;
            }
            if (i14 != ((i15 + 1) & 15)) {
                l0Var3.seek();
            }
        }
        if (z11) {
            int H = this.f75133e.H();
            i12 |= (this.f75133e.H() & 64) != 0 ? 2 : 0;
            this.f75133e.X(H - 1);
        }
        boolean z12 = this.f75144p;
        if (A(i13)) {
            this.f75133e.V(w11);
            l0Var3.a(this.f75133e, i12);
            this.f75133e.V(g11);
        }
        if (this.f75129a != 2 && !z12 && this.f75144p && length != -1) {
            this.f75146r = true;
        }
        this.f75133e.W(w11);
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
    
        r1 = r1 + 1;
     */
    @Override // l2.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean d(l2.s r7) {
        /*
            r6 = this;
            androidx.media3.common.util.j0 r0 = r6.f75133e
            byte[] r0 = r0.e()
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
        throw new UnsupportedOperationException("Method not decompiled: s3.k0.d(l2.s):boolean");
    }

    @Override // l2.r
    public /* synthetic */ l2.r e() {
        return l2.q.b(this);
    }

    @Override // l2.r
    public /* synthetic */ List f() {
        return l2.q.a(this);
    }

    @Override // l2.r
    public void release() {
    }

    @Override // l2.r
    public void seek(long j11, long j12) {
        h0 h0Var;
        androidx.media3.common.util.a.g(this.f75129a != 2);
        int size = this.f75132d.size();
        for (int i11 = 0; i11 < size; i11++) {
            p0 p0Var = (p0) this.f75132d.get(i11);
            boolean z10 = p0Var.f() == C.TIME_UNSET;
            if (!z10) {
                long d11 = p0Var.d();
                z10 = (d11 == C.TIME_UNSET || d11 == 0 || d11 == j12) ? false : true;
            }
            if (z10) {
                p0Var.i(j12);
            }
        }
        if (j12 != 0 && (h0Var = this.f75141m) != null) {
            h0Var.h(j12);
        }
        this.f75133e.S(0);
        this.f75134f.clear();
        for (int i12 = 0; i12 < this.f75137i.size(); i12++) {
            ((l0) this.f75137i.valueAt(i12)).seek();
        }
        this.f75148t = 0;
    }
}

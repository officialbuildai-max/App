package com.google.android.exoplayer2.source.dash;

import android.os.SystemClock;
import com.google.android.exoplayer2.c3;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.e;
import com.google.android.exoplayer2.trackselection.h;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import e9.u1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import v9.f;
import v9.g;
import v9.m;
import v9.n;
import v9.o;
import v9.p;
import x9.i;
import x9.j;

/* loaded from: classes3.dex */
public class c implements com.google.android.exoplayer2.source.dash.a {

    /* renamed from: a, reason: collision with root package name */
    private final a0 f25902a;

    /* renamed from: b, reason: collision with root package name */
    private final w9.b f25903b;

    /* renamed from: c, reason: collision with root package name */
    private final int[] f25904c;

    /* renamed from: d, reason: collision with root package name */
    private final int f25905d;

    /* renamed from: e, reason: collision with root package name */
    private final k f25906e;

    /* renamed from: f, reason: collision with root package name */
    private final long f25907f;

    /* renamed from: g, reason: collision with root package name */
    private final int f25908g;

    /* renamed from: h, reason: collision with root package name */
    private final e.c f25909h;

    /* renamed from: i, reason: collision with root package name */
    protected final b[] f25910i;

    /* renamed from: j, reason: collision with root package name */
    private h f25911j;

    /* renamed from: k, reason: collision with root package name */
    private x9.c f25912k;

    /* renamed from: l, reason: collision with root package name */
    private int f25913l;

    /* renamed from: m, reason: collision with root package name */
    private IOException f25914m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f25915n;

    /* loaded from: classes3.dex */
    public static final class a implements a.InterfaceC0370a {

        /* renamed from: a, reason: collision with root package name */
        private final k.a f25916a;

        /* renamed from: b, reason: collision with root package name */
        private final int f25917b;

        /* renamed from: c, reason: collision with root package name */
        private final g.a f25918c;

        public a(k.a aVar) {
            this(aVar, 1);
        }

        public a(k.a aVar, int i11) {
            this(v9.e.f77237j, aVar, i11);
        }

        public a(g.a aVar, k.a aVar2, int i11) {
            this.f25918c = aVar;
            this.f25916a = aVar2;
            this.f25917b = i11;
        }

        @Override // com.google.android.exoplayer2.source.dash.a.InterfaceC0370a
        public com.google.android.exoplayer2.source.dash.a a(a0 a0Var, x9.c cVar, w9.b bVar, int i11, int[] iArr, h hVar, int i12, long j11, boolean z10, List list, e.c cVar2, k0 k0Var, u1 u1Var) {
            k createDataSource = this.f25916a.createDataSource();
            if (k0Var != null) {
                createDataSource.e(k0Var);
            }
            return new c(this.f25918c, a0Var, cVar, bVar, i11, iArr, hVar, i12, createDataSource, j11, this.f25917b, z10, list, cVar2, u1Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final g f25919a;

        /* renamed from: b, reason: collision with root package name */
        public final j f25920b;

        /* renamed from: c, reason: collision with root package name */
        public final x9.b f25921c;

        /* renamed from: d, reason: collision with root package name */
        public final w9.e f25922d;

        /* renamed from: e, reason: collision with root package name */
        private final long f25923e;

        /* renamed from: f, reason: collision with root package name */
        private final long f25924f;

        b(long j11, j jVar, x9.b bVar, g gVar, long j12, w9.e eVar) {
            this.f25923e = j11;
            this.f25920b = jVar;
            this.f25921c = bVar;
            this.f25924f = j12;
            this.f25919a = gVar;
            this.f25922d = eVar;
        }

        b b(long j11, j jVar) {
            long e11;
            w9.e k11 = this.f25920b.k();
            w9.e k12 = jVar.k();
            if (k11 == null) {
                return new b(j11, jVar, this.f25921c, this.f25919a, this.f25924f, k11);
            }
            if (!k11.g()) {
                return new b(j11, jVar, this.f25921c, this.f25919a, this.f25924f, k12);
            }
            long f11 = k11.f(j11);
            if (f11 == 0) {
                return new b(j11, jVar, this.f25921c, this.f25919a, this.f25924f, k12);
            }
            long h11 = k11.h();
            long timeUs = k11.getTimeUs(h11);
            long j12 = f11 + h11;
            long j13 = j12 - 1;
            long timeUs2 = k11.getTimeUs(j13) + k11.a(j13, j11);
            long h12 = k12.h();
            long timeUs3 = k12.getTimeUs(h12);
            long j14 = this.f25924f;
            if (timeUs2 != timeUs3) {
                if (timeUs2 < timeUs3) {
                    throw new BehindLiveWindowException();
                }
                if (timeUs3 < timeUs) {
                    e11 = j14 - (k12.e(timeUs, j11) - h11);
                    return new b(j11, jVar, this.f25921c, this.f25919a, e11, k12);
                }
                j12 = k11.e(timeUs3, j11);
            }
            e11 = j14 + (j12 - h12);
            return new b(j11, jVar, this.f25921c, this.f25919a, e11, k12);
        }

        b c(w9.e eVar) {
            return new b(this.f25923e, this.f25920b, this.f25921c, this.f25919a, this.f25924f, eVar);
        }

        b d(x9.b bVar) {
            return new b(this.f25923e, this.f25920b, bVar, this.f25919a, this.f25924f, this.f25922d);
        }

        public long e(long j11) {
            return this.f25922d.b(this.f25923e, j11) + this.f25924f;
        }

        public long f() {
            return this.f25922d.h() + this.f25924f;
        }

        public long g(long j11) {
            return (e(j11) + this.f25922d.i(this.f25923e, j11)) - 1;
        }

        public long h() {
            return this.f25922d.f(this.f25923e);
        }

        public long i(long j11) {
            return k(j11) + this.f25922d.a(j11 - this.f25924f, this.f25923e);
        }

        public long j(long j11) {
            return this.f25922d.e(j11, this.f25923e) + this.f25924f;
        }

        public long k(long j11) {
            return this.f25922d.getTimeUs(j11 - this.f25924f);
        }

        public i l(long j11) {
            return this.f25922d.d(j11 - this.f25924f);
        }

        public boolean m(long j11, long j12) {
            return this.f25922d.g() || j12 == C.TIME_UNSET || i(j11) <= j12;
        }
    }

    /* renamed from: com.google.android.exoplayer2.source.dash.c$c, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    protected static final class C0371c extends v9.b {

        /* renamed from: e, reason: collision with root package name */
        private final b f25925e;

        /* renamed from: f, reason: collision with root package name */
        private final long f25926f;

        public C0371c(b bVar, long j11, long j12, long j13) {
            super(j11, j12);
            this.f25925e = bVar;
            this.f25926f = j13;
        }

        @Override // v9.o
        public long a() {
            c();
            return this.f25925e.k(d());
        }

        @Override // v9.o
        public long b() {
            c();
            return this.f25925e.i(d());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(g.a aVar, a0 a0Var, x9.c cVar, w9.b bVar, int i11, int[] iArr, h hVar, int i12, k kVar, long j11, int i13, boolean z10, List list, e.c cVar2, u1 u1Var) {
        this.f25902a = a0Var;
        this.f25912k = cVar;
        this.f25903b = bVar;
        this.f25904c = iArr;
        this.f25911j = hVar;
        this.f25905d = i12;
        this.f25906e = kVar;
        this.f25913l = i11;
        this.f25907f = j11;
        this.f25908g = i13;
        this.f25909h = cVar2;
        long f11 = cVar.f(i11);
        ArrayList l11 = l();
        this.f25910i = new b[hVar.length()];
        int i14 = 0;
        while (i14 < this.f25910i.length) {
            j jVar = (j) l11.get(hVar.getIndexInTrackGroup(i14));
            x9.b j12 = bVar.j(jVar.f78235c);
            int i15 = i14;
            this.f25910i[i15] = new b(f11, jVar, j12 == null ? (x9.b) jVar.f78235c.get(0) : j12, aVar.a(i12, jVar.f78234b, z10, list, cVar2, u1Var), 0L, jVar.k());
            i14 = i15 + 1;
        }
    }

    private z.a i(h hVar, List list) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int length = hVar.length();
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            if (hVar.e(i12, elapsedRealtime)) {
                i11++;
            }
        }
        int f11 = w9.b.f(list);
        return new z.a(f11, f11 - this.f25903b.g(list), length, i11);
    }

    private long j(long j11, long j12) {
        if (!this.f25912k.f78187d) {
            return C.TIME_UNSET;
        }
        return Math.max(0L, Math.min(k(j11), this.f25910i[0].i(this.f25910i[0].g(j11))) - j12);
    }

    private long k(long j11) {
        x9.c cVar = this.f25912k;
        long j12 = cVar.f78184a;
        return j12 == C.TIME_UNSET ? C.TIME_UNSET : j11 - p0.B0(j12 + cVar.c(this.f25913l).f78220b);
    }

    private ArrayList l() {
        List list = this.f25912k.c(this.f25913l).f78221c;
        ArrayList arrayList = new ArrayList();
        for (int i11 : this.f25904c) {
            arrayList.addAll(((x9.a) list.get(i11)).f78176c);
        }
        return arrayList;
    }

    private long m(b bVar, n nVar, long j11, long j12, long j13) {
        return nVar != null ? nVar.e() : p0.r(bVar.j(j11), j12, j13);
    }

    private b p(int i11) {
        b bVar = this.f25910i[i11];
        x9.b j11 = this.f25903b.j(bVar.f25920b.f78235c);
        if (j11 == null || j11.equals(bVar.f25921c)) {
            return bVar;
        }
        b d11 = bVar.d(j11);
        this.f25910i[i11] = d11;
        return d11;
    }

    @Override // v9.j
    public long a(long j11, c3 c3Var) {
        for (b bVar : this.f25910i) {
            if (bVar.f25922d != null) {
                long j12 = bVar.j(j11);
                long k11 = bVar.k(j12);
                long h11 = bVar.h();
                return c3Var.a(j11, k11, (k11 >= j11 || (h11 != -1 && j12 >= (bVar.f() + h11) - 1)) ? k11 : bVar.k(j12 + 1));
            }
        }
        return j11;
    }

    @Override // com.google.android.exoplayer2.source.dash.a
    public void b(h hVar) {
        this.f25911j = hVar;
    }

    @Override // v9.j
    public boolean d(f fVar, boolean z10, z.c cVar, z zVar) {
        z.b d11;
        if (!z10) {
            return false;
        }
        e.c cVar2 = this.f25909h;
        if (cVar2 != null && cVar2.j(fVar)) {
            return true;
        }
        if (!this.f25912k.f78187d && (fVar instanceof n)) {
            IOException iOException = cVar.f27598c;
            if ((iOException instanceof HttpDataSource$InvalidResponseCodeException) && ((HttpDataSource$InvalidResponseCodeException) iOException).responseCode == 404) {
                b bVar = this.f25910i[this.f25911j.g(fVar.f77258d)];
                long h11 = bVar.h();
                if (h11 != -1 && h11 != 0) {
                    if (((n) fVar).e() > (bVar.f() + h11) - 1) {
                        this.f25915n = true;
                        return true;
                    }
                }
            }
        }
        b bVar2 = this.f25910i[this.f25911j.g(fVar.f77258d)];
        x9.b j11 = this.f25903b.j(bVar2.f25920b.f78235c);
        if (j11 != null && !bVar2.f25921c.equals(j11)) {
            return true;
        }
        z.a i11 = i(this.f25911j, bVar2.f25920b.f78235c);
        if ((!i11.a(2) && !i11.a(1)) || (d11 = zVar.d(i11, cVar)) == null || !i11.a(d11.f27594a)) {
            return false;
        }
        int i12 = d11.f27594a;
        if (i12 == 2) {
            h hVar = this.f25911j;
            return hVar.blacklist(hVar.g(fVar.f77258d), d11.f27595b);
        }
        if (i12 != 1) {
            return false;
        }
        this.f25903b.e(bVar2.f25921c, d11.f27595b);
        return true;
    }

    @Override // com.google.android.exoplayer2.source.dash.a
    public void e(x9.c cVar, int i11) {
        try {
            this.f25912k = cVar;
            this.f25913l = i11;
            long f11 = cVar.f(i11);
            ArrayList l11 = l();
            for (int i12 = 0; i12 < this.f25910i.length; i12++) {
                j jVar = (j) l11.get(this.f25911j.getIndexInTrackGroup(i12));
                b[] bVarArr = this.f25910i;
                bVarArr[i12] = bVarArr[i12].b(f11, jVar);
            }
        } catch (BehindLiveWindowException e11) {
            this.f25914m = e11;
        }
    }

    @Override // v9.j
    public void f(long j11, long j12, List list, v9.h hVar) {
        int i11;
        int i12;
        o[] oVarArr;
        long j13;
        long j14;
        if (this.f25914m != null) {
            return;
        }
        long j15 = j12 - j11;
        long B0 = p0.B0(this.f25912k.f78184a) + p0.B0(this.f25912k.c(this.f25913l).f78220b) + j12;
        e.c cVar = this.f25909h;
        if (cVar == null || !cVar.h(B0)) {
            long B02 = p0.B0(p0.b0(this.f25907f));
            long k11 = k(B02);
            n nVar = list.isEmpty() ? null : (n) list.get(list.size() - 1);
            int length = this.f25911j.length();
            o[] oVarArr2 = new o[length];
            int i13 = 0;
            while (i13 < length) {
                b bVar = this.f25910i[i13];
                if (bVar.f25922d == null) {
                    oVarArr2[i13] = o.f77307a;
                    i11 = i13;
                    i12 = length;
                    oVarArr = oVarArr2;
                    j13 = j15;
                    j14 = B02;
                } else {
                    long e11 = bVar.e(B02);
                    long g11 = bVar.g(B02);
                    i11 = i13;
                    i12 = length;
                    oVarArr = oVarArr2;
                    j13 = j15;
                    j14 = B02;
                    long m11 = m(bVar, nVar, j12, e11, g11);
                    if (m11 < e11) {
                        oVarArr[i11] = o.f77307a;
                    } else {
                        oVarArr[i11] = new C0371c(p(i11), m11, g11, k11);
                    }
                }
                i13 = i11 + 1;
                B02 = j14;
                length = i12;
                oVarArr2 = oVarArr;
                j15 = j13;
            }
            long j16 = j15;
            long j17 = B02;
            this.f25911j.d(j11, j16, j(j17, j11), list, oVarArr2);
            b p11 = p(this.f25911j.getSelectedIndex());
            g gVar = p11.f25919a;
            if (gVar != null) {
                j jVar = p11.f25920b;
                i m12 = gVar.c() == null ? jVar.m() : null;
                i l11 = p11.f25922d == null ? jVar.l() : null;
                if (m12 != null || l11 != null) {
                    hVar.f77264a = n(p11, this.f25906e, this.f25911j.getSelectedFormat(), this.f25911j.getSelectionReason(), this.f25911j.getSelectionData(), m12, l11);
                    return;
                }
            }
            long j18 = p11.f25923e;
            long j19 = C.TIME_UNSET;
            boolean z10 = j18 != C.TIME_UNSET;
            if (p11.h() == 0) {
                hVar.f77265b = z10;
                return;
            }
            long e12 = p11.e(j17);
            long g12 = p11.g(j17);
            long m13 = m(p11, nVar, j12, e12, g12);
            if (m13 < e12) {
                this.f25914m = new BehindLiveWindowException();
                return;
            }
            if (m13 > g12 || (this.f25915n && m13 >= g12)) {
                hVar.f77265b = z10;
                return;
            }
            if (z10 && p11.k(m13) >= j18) {
                hVar.f77265b = true;
                return;
            }
            int min = (int) Math.min(this.f25908g, (g12 - m13) + 1);
            if (j18 != C.TIME_UNSET) {
                while (min > 1 && p11.k((min + m13) - 1) >= j18) {
                    min--;
                }
            }
            int i14 = min;
            if (list.isEmpty()) {
                j19 = j12;
            }
            hVar.f77264a = o(p11, this.f25906e, this.f25905d, this.f25911j.getSelectedFormat(), this.f25911j.getSelectionReason(), this.f25911j.getSelectionData(), m13, i14, j19, k11);
        }
    }

    @Override // v9.j
    public void g(f fVar) {
        g9.d b11;
        if (fVar instanceof m) {
            int g11 = this.f25911j.g(((m) fVar).f77258d);
            b bVar = this.f25910i[g11];
            if (bVar.f25922d == null && (b11 = bVar.f25919a.b()) != null) {
                this.f25910i[g11] = bVar.c(new w9.g(b11, bVar.f25920b.f78236d));
            }
        }
        e.c cVar = this.f25909h;
        if (cVar != null) {
            cVar.i(fVar);
        }
    }

    @Override // v9.j
    public int getPreferredQueueSize(long j11, List list) {
        return (this.f25914m != null || this.f25911j.length() < 2) ? list.size() : this.f25911j.evaluateQueueSize(j11, list);
    }

    @Override // v9.j
    public boolean h(long j11, f fVar, List list) {
        if (this.f25914m != null) {
            return false;
        }
        return this.f25911j.f(j11, fVar, list);
    }

    @Override // v9.j
    public void maybeThrowError() {
        IOException iOException = this.f25914m;
        if (iOException != null) {
            throw iOException;
        }
        this.f25902a.maybeThrowError();
    }

    protected f n(b bVar, k kVar, o1 o1Var, int i11, Object obj, i iVar, i iVar2) {
        i iVar3 = iVar;
        j jVar = bVar.f25920b;
        if (iVar3 != null) {
            i a11 = iVar3.a(iVar2, bVar.f25921c.f78180a);
            if (a11 != null) {
                iVar3 = a11;
            }
        } else {
            iVar3 = iVar2;
        }
        return new m(kVar, w9.f.a(jVar, bVar.f25921c.f78180a, iVar3, 0), o1Var, i11, obj, bVar.f25919a);
    }

    protected f o(b bVar, k kVar, int i11, o1 o1Var, int i12, Object obj, long j11, int i13, long j12, long j13) {
        j jVar = bVar.f25920b;
        long k11 = bVar.k(j11);
        i l11 = bVar.l(j11);
        if (bVar.f25919a == null) {
            return new p(kVar, w9.f.a(jVar, bVar.f25921c.f78180a, l11, bVar.m(j11, j13) ? 0 : 8), o1Var, i12, obj, k11, bVar.i(j11), j11, i11, o1Var);
        }
        int i14 = 1;
        int i15 = 1;
        while (i14 < i13) {
            i a11 = l11.a(bVar.l(i14 + j11), bVar.f25921c.f78180a);
            if (a11 == null) {
                break;
            }
            i15++;
            i14++;
            l11 = a11;
        }
        long j14 = (i15 + j11) - 1;
        long i16 = bVar.i(j14);
        long j15 = bVar.f25923e;
        return new v9.k(kVar, w9.f.a(jVar, bVar.f25921c.f78180a, l11, bVar.m(j14, j13) ? 0 : 8), o1Var, i12, obj, k11, i16, j12, (j15 == C.TIME_UNSET || j15 > i16) ? -9223372036854775807L : j15, j11, i15, -jVar.f78236d, bVar.f25919a);
    }

    @Override // v9.j
    public void release() {
        for (b bVar : this.f25910i) {
            g gVar = bVar.f25919a;
            if (gVar != null) {
                gVar.release();
            }
        }
    }
}

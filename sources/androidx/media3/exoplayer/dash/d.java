package androidx.media3.exoplayer.dash;

import a2.i;
import a2.j;
import android.os.SystemClock;
import android.util.Pair;
import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.r0;
import androidx.media3.common.y;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.datasource.a;
import androidx.media3.exoplayer.c4;
import androidx.media3.exoplayer.dash.a;
import androidx.media3.exoplayer.dash.f;
import androidx.media3.exoplayer.source.BehindLiveWindowException;
import androidx.media3.exoplayer.upstream.g;
import androidx.media3.exoplayer.upstream.m;
import androidx.media3.exoplayer.upstream.p;
import com.google.common.collect.ImmutableMap;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import h2.d;
import h2.f;
import h2.l;
import h2.o;
import i3.s;
import j2.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import l2.h;
import w1.n;
import y1.f4;
import z1.g;

/* loaded from: classes2.dex */
public class d implements androidx.media3.exoplayer.dash.a {

    /* renamed from: a, reason: collision with root package name */
    private final p f11517a;

    /* renamed from: b, reason: collision with root package name */
    private final z1.b f11518b;

    /* renamed from: c, reason: collision with root package name */
    private final int[] f11519c;

    /* renamed from: d, reason: collision with root package name */
    private final int f11520d;

    /* renamed from: e, reason: collision with root package name */
    private final androidx.media3.datasource.a f11521e;

    /* renamed from: f, reason: collision with root package name */
    private final long f11522f;

    /* renamed from: g, reason: collision with root package name */
    private final int f11523g;

    /* renamed from: h, reason: collision with root package name */
    private final f.c f11524h;

    /* renamed from: i, reason: collision with root package name */
    protected final b[] f11525i;

    /* renamed from: j, reason: collision with root package name */
    private z f11526j;

    /* renamed from: k, reason: collision with root package name */
    private a2.c f11527k;

    /* renamed from: l, reason: collision with root package name */
    private int f11528l;

    /* renamed from: m, reason: collision with root package name */
    private IOException f11529m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f11530n;

    /* renamed from: o, reason: collision with root package name */
    private long f11531o = C.TIME_UNSET;

    /* loaded from: classes2.dex */
    public static final class a implements a.InterfaceC0103a {

        /* renamed from: a, reason: collision with root package name */
        private final a.InterfaceC0099a f11532a;

        /* renamed from: b, reason: collision with root package name */
        private final int f11533b;

        /* renamed from: c, reason: collision with root package name */
        private final f.a f11534c;

        public a(a.InterfaceC0099a interfaceC0099a) {
            this(interfaceC0099a, 1);
        }

        public a(a.InterfaceC0099a interfaceC0099a, int i11) {
            this(new d.b(), interfaceC0099a, i11);
        }

        public a(f.a aVar, a.InterfaceC0099a interfaceC0099a, int i11) {
            this.f11534c = aVar;
            this.f11532a = interfaceC0099a;
            this.f11533b = i11;
        }

        @Override // androidx.media3.exoplayer.dash.a.InterfaceC0103a
        public r d(r rVar) {
            return this.f11534c.d(rVar);
        }

        @Override // androidx.media3.exoplayer.dash.a.InterfaceC0103a
        public androidx.media3.exoplayer.dash.a e(p pVar, a2.c cVar, z1.b bVar, int i11, int[] iArr, z zVar, int i12, long j11, boolean z10, List list, f.c cVar2, n nVar, f4 f4Var, androidx.media3.exoplayer.upstream.f fVar) {
            androidx.media3.datasource.a createDataSource = this.f11532a.createDataSource();
            if (nVar != null) {
                createDataSource.c(nVar);
            }
            return new d(this.f11534c, pVar, cVar, bVar, i11, iArr, zVar, i12, createDataSource, j11, this.f11533b, z10, list, cVar2, f4Var, fVar);
        }

        @Override // androidx.media3.exoplayer.dash.a.InterfaceC0103a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public a c(boolean z10) {
            this.f11534c.c(z10);
            return this;
        }

        @Override // androidx.media3.exoplayer.dash.a.InterfaceC0103a
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public a b(int i11) {
            this.f11534c.b(i11);
            return this;
        }

        @Override // androidx.media3.exoplayer.dash.a.InterfaceC0103a
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public a a(s.a aVar) {
            this.f11534c.a(aVar);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final h2.f f11535a;

        /* renamed from: b, reason: collision with root package name */
        public final j f11536b;

        /* renamed from: c, reason: collision with root package name */
        public final a2.b f11537c;

        /* renamed from: d, reason: collision with root package name */
        public final z1.e f11538d;

        /* renamed from: e, reason: collision with root package name */
        private final long f11539e;

        /* renamed from: f, reason: collision with root package name */
        private final long f11540f;

        b(long j11, j jVar, a2.b bVar, h2.f fVar, long j12, z1.e eVar) {
            this.f11539e = j11;
            this.f11536b = jVar;
            this.f11537c = bVar;
            this.f11540f = j12;
            this.f11535a = fVar;
            this.f11538d = eVar;
        }

        b b(long j11, j jVar) {
            long e11;
            z1.e k11 = this.f11536b.k();
            z1.e k12 = jVar.k();
            if (k11 == null) {
                return new b(j11, jVar, this.f11537c, this.f11535a, this.f11540f, k11);
            }
            if (!k11.g()) {
                return new b(j11, jVar, this.f11537c, this.f11535a, this.f11540f, k12);
            }
            long f11 = k11.f(j11);
            if (f11 == 0) {
                return new b(j11, jVar, this.f11537c, this.f11535a, this.f11540f, k12);
            }
            androidx.media3.common.util.a.i(k12);
            long h11 = k11.h();
            long timeUs = k11.getTimeUs(h11);
            long j12 = f11 + h11;
            long j13 = j12 - 1;
            long timeUs2 = k11.getTimeUs(j13) + k11.a(j13, j11);
            long h12 = k12.h();
            long timeUs3 = k12.getTimeUs(h12);
            long j14 = this.f11540f;
            if (timeUs2 != timeUs3) {
                if (timeUs2 < timeUs3) {
                    throw new BehindLiveWindowException();
                }
                if (timeUs3 < timeUs) {
                    e11 = j14 - (k12.e(timeUs, j11) - h11);
                    return new b(j11, jVar, this.f11537c, this.f11535a, e11, k12);
                }
                j12 = k11.e(timeUs3, j11);
            }
            e11 = j14 + (j12 - h12);
            return new b(j11, jVar, this.f11537c, this.f11535a, e11, k12);
        }

        b c(z1.e eVar) {
            return new b(this.f11539e, this.f11536b, this.f11537c, this.f11535a, this.f11540f, eVar);
        }

        b d(a2.b bVar) {
            return new b(this.f11539e, this.f11536b, bVar, this.f11535a, this.f11540f, this.f11538d);
        }

        public long e(long j11) {
            return ((z1.e) androidx.media3.common.util.a.i(this.f11538d)).b(this.f11539e, j11) + this.f11540f;
        }

        public long f() {
            return ((z1.e) androidx.media3.common.util.a.i(this.f11538d)).h() + this.f11540f;
        }

        public long g(long j11) {
            return (e(j11) + ((z1.e) androidx.media3.common.util.a.i(this.f11538d)).i(this.f11539e, j11)) - 1;
        }

        public long h() {
            return ((z1.e) androidx.media3.common.util.a.i(this.f11538d)).f(this.f11539e);
        }

        public long i(long j11) {
            return k(j11) + ((z1.e) androidx.media3.common.util.a.i(this.f11538d)).a(j11 - this.f11540f, this.f11539e);
        }

        public long j(long j11) {
            return ((z1.e) androidx.media3.common.util.a.i(this.f11538d)).e(j11, this.f11539e) + this.f11540f;
        }

        public long k(long j11) {
            return ((z1.e) androidx.media3.common.util.a.i(this.f11538d)).getTimeUs(j11 - this.f11540f);
        }

        public i l(long j11) {
            return ((z1.e) androidx.media3.common.util.a.i(this.f11538d)).d(j11 - this.f11540f);
        }

        public boolean m(long j11, long j12) {
            return ((z1.e) androidx.media3.common.util.a.i(this.f11538d)).g() || j12 == C.TIME_UNSET || i(j11) <= j12;
        }
    }

    /* loaded from: classes2.dex */
    protected static final class c extends h2.b {

        /* renamed from: e, reason: collision with root package name */
        private final b f11541e;

        /* renamed from: f, reason: collision with root package name */
        private final long f11542f;

        public c(b bVar, long j11, long j12, long j13) {
            super(j11, j12);
            this.f11541e = bVar;
            this.f11542f = j13;
        }

        @Override // h2.n
        public long a() {
            c();
            return this.f11541e.k(d());
        }

        @Override // h2.n
        public long b() {
            c();
            return this.f11541e.i(d());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(f.a aVar, p pVar, a2.c cVar, z1.b bVar, int i11, int[] iArr, z zVar, int i12, androidx.media3.datasource.a aVar2, long j11, int i13, boolean z10, List list, f.c cVar2, f4 f4Var, androidx.media3.exoplayer.upstream.f fVar) {
        this.f11517a = pVar;
        this.f11527k = cVar;
        this.f11518b = bVar;
        this.f11519c = iArr;
        this.f11526j = zVar;
        this.f11520d = i12;
        this.f11521e = aVar2;
        this.f11528l = i11;
        this.f11522f = j11;
        this.f11523g = i13;
        this.f11524h = cVar2;
        long f11 = cVar.f(i11);
        ArrayList l11 = l();
        this.f11525i = new b[zVar.length()];
        int i14 = 0;
        while (i14 < this.f11525i.length) {
            j jVar = (j) l11.get(zVar.getIndexInTrackGroup(i14));
            a2.b j12 = bVar.j(jVar.f172c);
            int i15 = i14;
            this.f11525i[i15] = new b(f11, jVar, j12 == null ? (a2.b) jVar.f172c.get(0) : j12, aVar.e(i12, jVar.f171b, z10, list, cVar2, f4Var), 0L, jVar.k());
            i14 = i15 + 1;
        }
    }

    private m.a h(z zVar, List list) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int length = zVar.length();
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            if (zVar.d(i12, elapsedRealtime)) {
                i11++;
            }
        }
        int f11 = z1.b.f(list);
        return new m.a(f11, f11 - this.f11518b.g(list), length, i11);
    }

    private long i(long j11, long j12) {
        if (!this.f11527k.f123d || this.f11525i[0].h() == 0) {
            return C.TIME_UNSET;
        }
        return Math.max(0L, Math.min(k(j11), this.f11525i[0].i(this.f11525i[0].g(j11))) - j12);
    }

    private Pair j(long j11, i iVar, b bVar) {
        long j12 = j11 + 1;
        if (j12 >= bVar.h()) {
            return null;
        }
        i l11 = bVar.l(j12);
        String a11 = r0.a(iVar.b(bVar.f11537c.f116a), l11.b(bVar.f11537c.f116a));
        String str = l11.f166a + "-";
        if (l11.f167b != -1) {
            str = str + (l11.f166a + l11.f167b);
        }
        return new Pair(a11, str);
    }

    private long k(long j11) {
        a2.c cVar = this.f11527k;
        long j12 = cVar.f120a;
        return j12 == C.TIME_UNSET ? C.TIME_UNSET : j11 - a1.R0(j12 + cVar.c(this.f11528l).f157b);
    }

    private ArrayList l() {
        List list = this.f11527k.c(this.f11528l).f158c;
        ArrayList arrayList = new ArrayList();
        for (int i11 : this.f11519c) {
            arrayList.addAll(((a2.a) list.get(i11)).f112c);
        }
        return arrayList;
    }

    private long m(b bVar, h2.m mVar, long j11, long j12, long j13) {
        return mVar != null ? mVar.e() : a1.q(bVar.j(j11), j12, j13);
    }

    private b p(int i11) {
        b bVar = this.f11525i[i11];
        a2.b j11 = this.f11518b.j(bVar.f11536b.f172c);
        if (j11 == null || j11.equals(bVar.f11537c)) {
            return bVar;
        }
        b d11 = bVar.d(j11);
        this.f11525i[i11] = d11;
        return d11;
    }

    @Override // h2.i
    public void a(h2.e eVar) {
        h b11;
        if (eVar instanceof l) {
            int f11 = this.f11526j.f(((l) eVar).f64422d);
            b bVar = this.f11525i[f11];
            if (bVar.f11538d == null && (b11 = ((h2.f) androidx.media3.common.util.a.i(bVar.f11535a)).b()) != null) {
                this.f11525i[f11] = bVar.c(new g(b11, bVar.f11536b.f173d));
            }
        }
        f.c cVar = this.f11524h;
        if (cVar != null) {
            cVar.j(eVar);
        }
    }

    @Override // h2.i
    public long b(long j11, c4 c4Var) {
        for (b bVar : this.f11525i) {
            if (bVar.f11538d != null) {
                long h11 = bVar.h();
                if (h11 != 0) {
                    long j12 = bVar.j(j11);
                    long k11 = bVar.k(j12);
                    return c4Var.a(j11, k11, (k11 >= j11 || (h11 != -1 && j12 >= (bVar.f() + h11) - 1)) ? k11 : bVar.k(j12 + 1));
                }
            }
        }
        return j11;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0161  */
    /* JADX WARN: Type inference failed for: r10v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    @Override // h2.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(androidx.media3.exoplayer.v2 r33, long r34, java.util.List r36, h2.g r37) {
        /*
            Method dump skipped, instructions count: 519
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.d.c(androidx.media3.exoplayer.v2, long, java.util.List, h2.g):void");
    }

    @Override // h2.i
    public boolean d(long j11, h2.e eVar, List list) {
        if (this.f11529m != null) {
            return false;
        }
        return this.f11526j.h(j11, eVar, list);
    }

    @Override // androidx.media3.exoplayer.dash.a
    public void e(z zVar) {
        this.f11526j = zVar;
    }

    @Override // h2.i
    public boolean f(h2.e eVar, boolean z10, m.c cVar, m mVar) {
        m.b d11;
        if (!z10) {
            return false;
        }
        f.c cVar2 = this.f11524h;
        if (cVar2 != null && cVar2.k(eVar)) {
            return true;
        }
        if (!this.f11527k.f123d && (eVar instanceof h2.m)) {
            IOException iOException = cVar.f13094c;
            if ((iOException instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) iOException).responseCode == 404) {
                b bVar = this.f11525i[this.f11526j.f(eVar.f64422d)];
                long h11 = bVar.h();
                if (h11 != -1 && h11 != 0) {
                    if (((h2.m) eVar).e() > (bVar.f() + h11) - 1) {
                        this.f11530n = true;
                        return true;
                    }
                }
            }
        }
        b bVar2 = this.f11525i[this.f11526j.f(eVar.f64422d)];
        a2.b j11 = this.f11518b.j(bVar2.f11536b.f172c);
        if (j11 != null && !bVar2.f11537c.equals(j11)) {
            return true;
        }
        m.a h12 = h(this.f11526j, bVar2.f11536b.f172c);
        if ((!h12.a(2) && !h12.a(1)) || (d11 = mVar.d(h12, cVar)) == null || !h12.a(d11.f13090a)) {
            return false;
        }
        int i11 = d11.f13090a;
        if (i11 == 2) {
            z zVar = this.f11526j;
            return zVar.g(zVar.f(eVar.f64422d), d11.f13091b);
        }
        if (i11 != 1) {
            return false;
        }
        this.f11518b.e(bVar2.f11537c, d11.f13091b);
        return true;
    }

    @Override // androidx.media3.exoplayer.dash.a
    public void g(a2.c cVar, int i11) {
        try {
            this.f11527k = cVar;
            this.f11528l = i11;
            long f11 = cVar.f(i11);
            ArrayList l11 = l();
            for (int i12 = 0; i12 < this.f11525i.length; i12++) {
                j jVar = (j) l11.get(this.f11526j.getIndexInTrackGroup(i12));
                b[] bVarArr = this.f11525i;
                bVarArr[i12] = bVarArr[i12].b(f11, jVar);
            }
        } catch (BehindLiveWindowException e11) {
            this.f11529m = e11;
        }
    }

    @Override // h2.i
    public int getPreferredQueueSize(long j11, List list) {
        return (this.f11529m != null || this.f11526j.length() < 2) ? list.size() : this.f11526j.evaluateQueueSize(j11, list);
    }

    @Override // h2.i
    public void maybeThrowError() {
        IOException iOException = this.f11529m;
        if (iOException != null) {
            throw iOException;
        }
        this.f11517a.maybeThrowError();
    }

    protected h2.e n(b bVar, androidx.media3.datasource.a aVar, r rVar, int i11, Object obj, i iVar, i iVar2, g.a aVar2) {
        i iVar3 = iVar;
        j jVar = bVar.f11536b;
        if (iVar3 != null) {
            i a11 = iVar3.a(iVar2, bVar.f11537c.f116a);
            if (a11 != null) {
                iVar3 = a11;
            }
        } else {
            iVar3 = (i) androidx.media3.common.util.a.e(iVar2);
        }
        return new l(aVar, z1.f.a(jVar, bVar.f11537c.f116a, iVar3, 0, ImmutableMap.of()), rVar, i11, obj, bVar.f11535a);
    }

    protected h2.e o(b bVar, androidx.media3.datasource.a aVar, int i11, r rVar, int i12, Object obj, long j11, int i13, long j12, long j13, g.a aVar2) {
        j jVar = bVar.f11536b;
        long k11 = bVar.k(j11);
        i l11 = bVar.l(j11);
        if (bVar.f11535a == null) {
            return new o(aVar, z1.f.a(jVar, bVar.f11537c.f116a, l11, bVar.m(j11, j13) ? 0 : 8, ImmutableMap.of()), rVar, i12, obj, k11, bVar.i(j11), j11, i11, rVar);
        }
        int i14 = 1;
        int i15 = 1;
        while (i14 < i13) {
            i a11 = l11.a(bVar.l(i14 + j11), bVar.f11537c.f116a);
            if (a11 == null) {
                break;
            }
            i15++;
            i14++;
            l11 = a11;
        }
        long j14 = (i15 + j11) - 1;
        long i16 = bVar.i(j14);
        long j15 = bVar.f11539e;
        if (j15 == C.TIME_UNSET || j15 > i16) {
            j15 = -9223372036854775807L;
        }
        w1.h a12 = z1.f.a(jVar, bVar.f11537c.f116a, l11, bVar.m(j14, j13) ? 0 : 8, ImmutableMap.of());
        long j16 = -jVar.f173d;
        if (y.q(rVar.f10243o)) {
            j16 += k11;
        }
        return new h2.j(aVar, a12, rVar, i12, obj, k11, i16, j12, j15, j11, i15, j16, bVar.f11535a);
    }

    @Override // h2.i
    public void release() {
        for (b bVar : this.f11525i) {
            h2.f fVar = bVar.f11535a;
            if (fVar != null) {
                fVar.release();
            }
        }
    }
}

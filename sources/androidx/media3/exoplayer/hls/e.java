package androidx.media3.exoplayer.hls;

import android.net.Uri;
import android.os.SystemClock;
import android.util.Pair;
import androidx.media3.common.f0;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.r0;
import androidx.media3.exoplayer.c4;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker;
import androidx.media3.exoplayer.hls.playlist.c;
import androidx.media3.exoplayer.source.BehindLiveWindowException;
import androidx.media3.exoplayer.upstream.g;
import androidx.media3.exoplayer.v2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.g3;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import j2.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import w1.h;
import y1.f4;

/* loaded from: classes2.dex */
class e {

    /* renamed from: a, reason: collision with root package name */
    private final g f11789a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.media3.datasource.a f11790b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.media3.datasource.a f11791c;

    /* renamed from: d, reason: collision with root package name */
    private final t f11792d;

    /* renamed from: e, reason: collision with root package name */
    private final Uri[] f11793e;

    /* renamed from: f, reason: collision with root package name */
    private final androidx.media3.common.r[] f11794f;

    /* renamed from: g, reason: collision with root package name */
    private final HlsPlaylistTracker f11795g;

    /* renamed from: h, reason: collision with root package name */
    private final f0 f11796h;

    /* renamed from: i, reason: collision with root package name */
    private final List f11797i;

    /* renamed from: k, reason: collision with root package name */
    private final f4 f11799k;

    /* renamed from: l, reason: collision with root package name */
    private final long f11800l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f11801m;

    /* renamed from: o, reason: collision with root package name */
    private IOException f11803o;

    /* renamed from: p, reason: collision with root package name */
    private Uri f11804p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f11805q;

    /* renamed from: r, reason: collision with root package name */
    private z f11806r;

    /* renamed from: t, reason: collision with root package name */
    private boolean f11808t;

    /* renamed from: u, reason: collision with root package name */
    private long f11809u = C.TIME_UNSET;

    /* renamed from: j, reason: collision with root package name */
    private final FullSegmentEncryptionKeyCache f11798j = new FullSegmentEncryptionKeyCache(4);

    /* renamed from: n, reason: collision with root package name */
    private byte[] f11802n = a1.f10437f;

    /* renamed from: s, reason: collision with root package name */
    private long f11807s = C.TIME_UNSET;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a extends h2.k {

        /* renamed from: l, reason: collision with root package name */
        private byte[] f11810l;

        public a(androidx.media3.datasource.a aVar, w1.h hVar, androidx.media3.common.r rVar, int i11, Object obj, byte[] bArr) {
            super(aVar, hVar, 3, rVar, i11, obj, bArr);
        }

        @Override // h2.k
        protected void e(byte[] bArr, int i11) {
            this.f11810l = Arrays.copyOf(bArr, i11);
        }

        public byte[] h() {
            return this.f11810l;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public h2.e f11811a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f11812b;

        /* renamed from: c, reason: collision with root package name */
        public Uri f11813c;

        public b() {
            a();
        }

        public void a() {
            this.f11811a = null;
            this.f11812b = false;
            this.f11813c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends h2.b {

        /* renamed from: e, reason: collision with root package name */
        private final List f11814e;

        /* renamed from: f, reason: collision with root package name */
        private final long f11815f;

        /* renamed from: g, reason: collision with root package name */
        private final String f11816g;

        public c(String str, long j11, List list) {
            super(0L, list.size() - 1);
            this.f11816g = str;
            this.f11815f = j11;
            this.f11814e = list;
        }

        @Override // h2.n
        public long a() {
            c();
            return this.f11815f + ((c.g) this.f11814e.get((int) d())).f12002e;
        }

        @Override // h2.n
        public long b() {
            c();
            c.g gVar = (c.g) this.f11814e.get((int) d());
            return this.f11815f + gVar.f12002e + gVar.f12000c;
        }
    }

    /* loaded from: classes2.dex */
    private static final class d extends j2.c {

        /* renamed from: i, reason: collision with root package name */
        private int f11817i;

        public d(f0 f0Var, int[] iArr) {
            super(f0Var, iArr);
            this.f11817i = f(f0Var.a(iArr[0]));
        }

        @Override // j2.z
        public void e(long j11, long j12, long j13, List list, h2.n[] nVarArr) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (d(this.f11817i, elapsedRealtime)) {
                for (int i11 = this.f65867b - 1; i11 >= 0; i11--) {
                    if (!d(i11, elapsedRealtime)) {
                        this.f11817i = i11;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        @Override // j2.z
        public int getSelectedIndex() {
            return this.f11817i;
        }

        @Override // j2.z
        public Object getSelectionData() {
            return null;
        }

        @Override // j2.z
        public int getSelectionReason() {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.media3.exoplayer.hls.e$e, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0105e {

        /* renamed from: a, reason: collision with root package name */
        public final c.g f11818a;

        /* renamed from: b, reason: collision with root package name */
        public final long f11819b;

        /* renamed from: c, reason: collision with root package name */
        public final int f11820c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f11821d;

        public C0105e(c.g gVar, long j11, int i11) {
            this.f11818a = gVar;
            this.f11819b = j11;
            this.f11820c = i11;
            this.f11821d = (gVar instanceof c.d) && ((c.d) gVar).f11992m;
        }
    }

    public e(g gVar, HlsPlaylistTracker hlsPlaylistTracker, Uri[] uriArr, androidx.media3.common.r[] rVarArr, f fVar, w1.n nVar, t tVar, long j11, List list, f4 f4Var, androidx.media3.exoplayer.upstream.f fVar2) {
        this.f11789a = gVar;
        this.f11795g = hlsPlaylistTracker;
        this.f11793e = uriArr;
        this.f11794f = rVarArr;
        this.f11792d = tVar;
        this.f11800l = j11;
        this.f11797i = list;
        this.f11799k = f4Var;
        androidx.media3.datasource.a a11 = fVar.a(1);
        this.f11790b = a11;
        if (nVar != null) {
            a11.c(nVar);
        }
        this.f11791c = fVar.a(3);
        this.f11796h = new f0(rVarArr);
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < uriArr.length; i11++) {
            if ((rVarArr[i11].f10234f & 16384) == 0) {
                arrayList.add(Integer.valueOf(i11));
            }
        }
        this.f11806r = new d(this.f11796h, Ints.o(arrayList));
    }

    private void b() {
        this.f11795g.l(this.f11793e[this.f11806r.getSelectedIndexInTrackGroup()]);
    }

    private static Uri e(androidx.media3.exoplayer.hls.playlist.c cVar, c.g gVar) {
        String str;
        if (gVar == null || (str = gVar.f12004g) == null) {
            return null;
        }
        return r0.f(cVar.f17066a, str);
    }

    private Pair g(i iVar, boolean z10, androidx.media3.exoplayer.hls.playlist.c cVar, long j11, long j12) {
        if (iVar != null && !z10) {
            if (!iVar.f()) {
                return new Pair(Long.valueOf(iVar.f64473j), Integer.valueOf(iVar.f11828o));
            }
            Long valueOf = Long.valueOf(iVar.f11828o == -1 ? iVar.e() : iVar.f64473j);
            int i11 = iVar.f11828o;
            return new Pair(valueOf, Integer.valueOf(i11 != -1 ? i11 + 1 : -1));
        }
        long j13 = cVar.f11970u + j11;
        if (iVar != null && !this.f11805q) {
            j12 = iVar.f64425g;
        }
        if (!cVar.f11964o && j12 >= j13) {
            return new Pair(Long.valueOf(cVar.f11960k + cVar.f11967r.size()), -1);
        }
        long j14 = j12 - j11;
        int i12 = 0;
        int f11 = a1.f(cVar.f11967r, Long.valueOf(j14), true, !this.f11795g.f() || iVar == null);
        long j15 = f11 + cVar.f11960k;
        if (f11 >= 0) {
            c.f fVar = (c.f) cVar.f11967r.get(f11);
            List list = j14 < fVar.f12002e + fVar.f12000c ? fVar.f11997m : cVar.f11968s;
            while (true) {
                if (i12 >= list.size()) {
                    break;
                }
                c.d dVar = (c.d) list.get(i12);
                if (j14 >= dVar.f12002e + dVar.f12000c) {
                    i12++;
                } else if (dVar.f11991l) {
                    j15 += list == cVar.f11968s ? 1L : 0L;
                    r1 = i12;
                }
            }
        }
        return new Pair(Long.valueOf(j15), Integer.valueOf(r1));
    }

    private static C0105e h(androidx.media3.exoplayer.hls.playlist.c cVar, long j11, int i11) {
        int i12 = (int) (j11 - cVar.f11960k);
        if (i12 == cVar.f11967r.size()) {
            if (i11 == -1) {
                i11 = 0;
            }
            if (i11 < cVar.f11968s.size()) {
                return new C0105e((c.g) cVar.f11968s.get(i11), j11, i11);
            }
            return null;
        }
        c.f fVar = (c.f) cVar.f11967r.get(i12);
        if (i11 == -1) {
            return new C0105e(fVar, j11, -1);
        }
        if (i11 < fVar.f11997m.size()) {
            return new C0105e((c.g) fVar.f11997m.get(i11), j11, i11);
        }
        int i13 = i12 + 1;
        if (i13 < cVar.f11967r.size()) {
            return new C0105e((c.g) cVar.f11967r.get(i13), j11 + 1, -1);
        }
        if (cVar.f11968s.isEmpty()) {
            return null;
        }
        return new C0105e((c.g) cVar.f11968s.get(0), j11 + 1, 0);
    }

    static List j(androidx.media3.exoplayer.hls.playlist.c cVar, long j11, int i11) {
        int i12 = (int) (j11 - cVar.f11960k);
        if (i12 < 0 || cVar.f11967r.size() < i12) {
            return ImmutableList.of();
        }
        ArrayList arrayList = new ArrayList();
        if (i12 < cVar.f11967r.size()) {
            if (i11 != -1) {
                c.f fVar = (c.f) cVar.f11967r.get(i12);
                if (i11 == 0) {
                    arrayList.add(fVar);
                } else if (i11 < fVar.f11997m.size()) {
                    List list = fVar.f11997m;
                    arrayList.addAll(list.subList(i11, list.size()));
                }
                i12++;
            }
            List list2 = cVar.f11967r;
            arrayList.addAll(list2.subList(i12, list2.size()));
            i11 = 0;
        }
        if (cVar.f11963n != C.TIME_UNSET) {
            int i13 = i11 != -1 ? i11 : 0;
            if (i13 < cVar.f11968s.size()) {
                List list3 = cVar.f11968s;
                arrayList.addAll(list3.subList(i13, list3.size()));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private h2.e n(Uri uri, int i11, boolean z10, g.a aVar) {
        if (uri == null) {
            return null;
        }
        byte[] c11 = this.f11798j.c(uri);
        if (c11 != null) {
            this.f11798j.b(uri, c11);
            return null;
        }
        return new a(this.f11791c, new h.b().i(uri).b(1).a(), this.f11794f[i11], this.f11806r.getSelectionReason(), this.f11806r.getSelectionData(), this.f11802n);
    }

    private long u(long j11) {
        long j12 = this.f11807s;
        return j12 != C.TIME_UNSET ? j12 - j11 : C.TIME_UNSET;
    }

    private void y(androidx.media3.exoplayer.hls.playlist.c cVar) {
        this.f11807s = cVar.f11964o ? C.TIME_UNSET : cVar.d() - this.f11795g.b();
    }

    public h2.n[] a(i iVar, long j11) {
        int i11;
        int b11 = iVar == null ? -1 : this.f11796h.b(iVar.f64422d);
        int length = this.f11806r.length();
        h2.n[] nVarArr = new h2.n[length];
        boolean z10 = false;
        int i12 = 0;
        while (i12 < length) {
            int indexInTrackGroup = this.f11806r.getIndexInTrackGroup(i12);
            Uri uri = this.f11793e[indexInTrackGroup];
            if (this.f11795g.e(uri)) {
                androidx.media3.exoplayer.hls.playlist.c i13 = this.f11795g.i(uri, z10);
                androidx.media3.common.util.a.e(i13);
                long b12 = i13.f11957h - this.f11795g.b();
                i11 = i12;
                Pair g11 = g(iVar, indexInTrackGroup != b11 ? true : z10, i13, b12, j11);
                nVarArr[i11] = new c(i13.f17066a, b12, j(i13, ((Long) g11.first).longValue(), ((Integer) g11.second).intValue()));
            } else {
                nVarArr[i12] = h2.n.f64474a;
                i11 = i12;
            }
            i12 = i11 + 1;
            z10 = false;
        }
        return nVarArr;
    }

    public long c(long j11, c4 c4Var) {
        int selectedIndex = this.f11806r.getSelectedIndex();
        Uri[] uriArr = this.f11793e;
        androidx.media3.exoplayer.hls.playlist.c i11 = (selectedIndex >= uriArr.length || selectedIndex == -1) ? null : this.f11795g.i(uriArr[this.f11806r.getSelectedIndexInTrackGroup()], true);
        if (i11 == null || i11.f11967r.isEmpty()) {
            return j11;
        }
        long b11 = i11.f11957h - this.f11795g.b();
        long j12 = j11 - b11;
        int f11 = a1.f(i11.f11967r, Long.valueOf(j12), true, true);
        long j13 = ((c.f) i11.f11967r.get(f11)).f12002e;
        return c4Var.a(j12, j13, (!i11.f17068c || f11 == i11.f11967r.size() - 1) ? j13 : ((c.f) i11.f11967r.get(f11 + 1)).f12002e) + b11;
    }

    public int d(i iVar) {
        if (iVar.f11828o == -1) {
            return 1;
        }
        androidx.media3.exoplayer.hls.playlist.c cVar = (androidx.media3.exoplayer.hls.playlist.c) androidx.media3.common.util.a.e(this.f11795g.i(this.f11793e[this.f11796h.b(iVar.f64422d)], false));
        int i11 = (int) (iVar.f64473j - cVar.f11960k);
        if (i11 < 0) {
            return 1;
        }
        List list = i11 < cVar.f11967r.size() ? ((c.f) cVar.f11967r.get(i11)).f11997m : cVar.f11968s;
        if (iVar.f11828o >= list.size()) {
            return 2;
        }
        c.d dVar = (c.d) list.get(iVar.f11828o);
        if (dVar.f11992m) {
            return 0;
        }
        return Objects.equals(Uri.parse(r0.e(cVar.f17066a, dVar.f11998a)), iVar.f64420b.f77634a) ? 1 : 2;
    }

    public void f(v2 v2Var, long j11, List list, boolean z10, b bVar) {
        int b11;
        v2 v2Var2;
        androidx.media3.exoplayer.hls.playlist.c cVar;
        long j12;
        i iVar = list.isEmpty() ? null : (i) g3.g(list);
        if (iVar == null) {
            v2Var2 = v2Var;
            b11 = -1;
        } else {
            b11 = this.f11796h.b(iVar.f64422d);
            v2Var2 = v2Var;
        }
        long j13 = v2Var2.f13132a;
        long j14 = j11 - j13;
        long u11 = u(j13);
        if (iVar != null && !this.f11805q) {
            long b12 = iVar.b();
            j14 = Math.max(0L, j14 - b12);
            if (u11 != C.TIME_UNSET) {
                u11 = Math.max(0L, u11 - b12);
            }
        }
        this.f11806r.e(j13, j14, u11, list, a(iVar, j11));
        int selectedIndexInTrackGroup = this.f11806r.getSelectedIndexInTrackGroup();
        boolean z11 = b11 != selectedIndexInTrackGroup;
        Uri uri = this.f11793e[selectedIndexInTrackGroup];
        if (!this.f11795g.e(uri)) {
            bVar.f11813c = uri;
            this.f11808t &= uri.equals(this.f11804p);
            this.f11804p = uri;
            return;
        }
        androidx.media3.exoplayer.hls.playlist.c i11 = this.f11795g.i(uri, true);
        androidx.media3.common.util.a.e(i11);
        this.f11805q = i11.f17068c;
        y(i11);
        long b13 = i11.f11957h - this.f11795g.b();
        Uri uri2 = uri;
        Pair g11 = g(iVar, z11, i11, b13, j11);
        long longValue = ((Long) g11.first).longValue();
        int intValue = ((Integer) g11.second).intValue();
        if (longValue >= i11.f11960k || iVar == null || !z11) {
            cVar = i11;
            j12 = b13;
        } else {
            uri2 = this.f11793e[b11];
            androidx.media3.exoplayer.hls.playlist.c i12 = this.f11795g.i(uri2, true);
            androidx.media3.common.util.a.e(i12);
            j12 = i12.f11957h - this.f11795g.b();
            Pair g12 = g(iVar, false, i12, j12, j11);
            longValue = ((Long) g12.first).longValue();
            intValue = ((Integer) g12.second).intValue();
            cVar = i12;
            selectedIndexInTrackGroup = b11;
        }
        if (selectedIndexInTrackGroup != b11 && b11 != -1) {
            this.f11795g.l(this.f11793e[b11]);
        }
        if (longValue < cVar.f11960k) {
            this.f11803o = new BehindLiveWindowException();
            return;
        }
        C0105e h11 = h(cVar, longValue, intValue);
        if (h11 == null) {
            if (!cVar.f11964o) {
                bVar.f11813c = uri2;
                this.f11808t &= uri2.equals(this.f11804p);
                this.f11804p = uri2;
                return;
            } else {
                if (z10 || cVar.f11967r.isEmpty()) {
                    bVar.f11812b = true;
                    return;
                }
                h11 = new C0105e((c.g) g3.g(cVar.f11967r), (cVar.f11960k + cVar.f11967r.size()) - 1, -1);
            }
        }
        this.f11808t = false;
        this.f11804p = null;
        this.f11809u = SystemClock.elapsedRealtime();
        Uri e11 = e(cVar, h11.f11818a.f11999b);
        h2.e n11 = n(e11, selectedIndexInTrackGroup, true, null);
        bVar.f11811a = n11;
        if (n11 != null) {
            return;
        }
        Uri e12 = e(cVar, h11.f11818a);
        h2.e n12 = n(e12, selectedIndexInTrackGroup, false, null);
        bVar.f11811a = n12;
        if (n12 != null) {
            return;
        }
        boolean u12 = i.u(iVar, uri2, cVar, h11, j12);
        if (u12 && h11.f11821d) {
            return;
        }
        bVar.f11811a = i.h(this.f11789a, this.f11790b, this.f11794f[selectedIndexInTrackGroup], j12, cVar, h11, uri2, this.f11797i, this.f11806r.getSelectionReason(), this.f11806r.getSelectionData(), this.f11801m, this.f11792d, this.f11800l, iVar, this.f11798j.a(e12), this.f11798j.a(e11), u12, this.f11799k, null);
    }

    public int i(long j11, List list) {
        return (this.f11803o != null || this.f11806r.length() < 2) ? list.size() : this.f11806r.evaluateQueueSize(j11, list);
    }

    public f0 k() {
        return this.f11796h;
    }

    public z l() {
        return this.f11806r;
    }

    public boolean m() {
        return this.f11805q;
    }

    public boolean o(h2.e eVar, long j11) {
        z zVar = this.f11806r;
        return zVar.g(zVar.indexOf(this.f11796h.b(eVar.f64422d)), j11);
    }

    public void p() {
        IOException iOException = this.f11803o;
        if (iOException != null) {
            throw iOException;
        }
        Uri uri = this.f11804p;
        if (uri == null || !this.f11808t) {
            return;
        }
        this.f11795g.a(uri);
    }

    public boolean q(Uri uri) {
        return a1.s(this.f11793e, uri);
    }

    public void r(h2.e eVar) {
        if (eVar instanceof a) {
            a aVar = (a) eVar;
            this.f11802n = aVar.f();
            this.f11798j.b(aVar.f64420b.f77634a, (byte[]) androidx.media3.common.util.a.e(aVar.h()));
        }
    }

    public boolean s(Uri uri, long j11) {
        int indexOf;
        int i11 = 0;
        while (true) {
            Uri[] uriArr = this.f11793e;
            if (i11 >= uriArr.length) {
                i11 = -1;
                break;
            }
            if (uriArr[i11].equals(uri)) {
                break;
            }
            i11++;
        }
        if (i11 == -1 || (indexOf = this.f11806r.indexOf(i11)) == -1) {
            return true;
        }
        this.f11808t |= uri.equals(this.f11804p);
        return j11 == C.TIME_UNSET || (this.f11806r.g(indexOf, j11) && this.f11795g.g(uri, j11));
    }

    public void t() {
        b();
        this.f11803o = null;
    }

    public void v(boolean z10) {
        this.f11801m = z10;
    }

    public void w(z zVar) {
        b();
        this.f11806r = zVar;
    }

    public boolean x(long j11, h2.e eVar, List list) {
        if (this.f11803o != null) {
            return false;
        }
        return this.f11806r.h(j11, eVar, list);
    }
}

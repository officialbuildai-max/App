package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.c3;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.d;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.util.n0;
import com.google.android.exoplayer2.util.p0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.g3;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import e9.u1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
class e {

    /* renamed from: a, reason: collision with root package name */
    private final g f26001a;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.k f26002b;

    /* renamed from: c, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.k f26003c;

    /* renamed from: d, reason: collision with root package name */
    private final q f26004d;

    /* renamed from: e, reason: collision with root package name */
    private final Uri[] f26005e;

    /* renamed from: f, reason: collision with root package name */
    private final o1[] f26006f;

    /* renamed from: g, reason: collision with root package name */
    private final HlsPlaylistTracker f26007g;

    /* renamed from: h, reason: collision with root package name */
    private final TrackGroup f26008h;

    /* renamed from: i, reason: collision with root package name */
    private final List f26009i;

    /* renamed from: k, reason: collision with root package name */
    private final u1 f26011k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f26012l;

    /* renamed from: n, reason: collision with root package name */
    private IOException f26014n;

    /* renamed from: o, reason: collision with root package name */
    private Uri f26015o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f26016p;

    /* renamed from: q, reason: collision with root package name */
    private com.google.android.exoplayer2.trackselection.h f26017q;

    /* renamed from: s, reason: collision with root package name */
    private boolean f26019s;

    /* renamed from: j, reason: collision with root package name */
    private final FullSegmentEncryptionKeyCache f26010j = new FullSegmentEncryptionKeyCache(4);

    /* renamed from: m, reason: collision with root package name */
    private byte[] f26013m = p0.f27685f;

    /* renamed from: r, reason: collision with root package name */
    private long f26018r = C.TIME_UNSET;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a extends v9.l {

        /* renamed from: l, reason: collision with root package name */
        private byte[] f26020l;

        public a(com.google.android.exoplayer2.upstream.k kVar, com.google.android.exoplayer2.upstream.n nVar, o1 o1Var, int i11, Object obj, byte[] bArr) {
            super(kVar, nVar, 3, o1Var, i11, obj, bArr);
        }

        @Override // v9.l
        protected void e(byte[] bArr, int i11) {
            this.f26020l = Arrays.copyOf(bArr, i11);
        }

        public byte[] h() {
            return this.f26020l;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public v9.f f26021a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f26022b;

        /* renamed from: c, reason: collision with root package name */
        public Uri f26023c;

        public b() {
            a();
        }

        public void a() {
            this.f26021a = null;
            this.f26022b = false;
            this.f26023c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class c extends v9.b {

        /* renamed from: e, reason: collision with root package name */
        private final List f26024e;

        /* renamed from: f, reason: collision with root package name */
        private final long f26025f;

        /* renamed from: g, reason: collision with root package name */
        private final String f26026g;

        public c(String str, long j11, List list) {
            super(0L, list.size() - 1);
            this.f26026g = str;
            this.f26025f = j11;
            this.f26024e = list;
        }

        @Override // v9.o
        public long a() {
            c();
            return this.f26025f + ((d.e) this.f26024e.get((int) d())).f26207e;
        }

        @Override // v9.o
        public long b() {
            c();
            d.e eVar = (d.e) this.f26024e.get((int) d());
            return this.f26025f + eVar.f26207e + eVar.f26205c;
        }
    }

    /* loaded from: classes3.dex */
    private static final class d extends la.b {

        /* renamed from: h, reason: collision with root package name */
        private int f26027h;

        public d(TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
            this.f26027h = g(trackGroup.c(iArr[0]));
        }

        @Override // com.google.android.exoplayer2.trackselection.h
        public void d(long j11, long j12, long j13, List list, v9.o[] oVarArr) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (e(this.f26027h, elapsedRealtime)) {
                for (int i11 = this.f68902b - 1; i11 >= 0; i11--) {
                    if (!e(i11, elapsedRealtime)) {
                        this.f26027h = i11;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        @Override // com.google.android.exoplayer2.trackselection.h
        public int getSelectedIndex() {
            return this.f26027h;
        }

        @Override // com.google.android.exoplayer2.trackselection.h
        public Object getSelectionData() {
            return null;
        }

        @Override // com.google.android.exoplayer2.trackselection.h
        public int getSelectionReason() {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.android.exoplayer2.source.hls.e$e, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0372e {

        /* renamed from: a, reason: collision with root package name */
        public final d.e f26028a;

        /* renamed from: b, reason: collision with root package name */
        public final long f26029b;

        /* renamed from: c, reason: collision with root package name */
        public final int f26030c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f26031d;

        public C0372e(d.e eVar, long j11, int i11) {
            this.f26028a = eVar;
            this.f26029b = j11;
            this.f26030c = i11;
            this.f26031d = (eVar instanceof d.b) && ((d.b) eVar).f26197m;
        }
    }

    public e(g gVar, HlsPlaylistTracker hlsPlaylistTracker, Uri[] uriArr, o1[] o1VarArr, f fVar, k0 k0Var, q qVar, List list, u1 u1Var) {
        this.f26001a = gVar;
        this.f26007g = hlsPlaylistTracker;
        this.f26005e = uriArr;
        this.f26006f = o1VarArr;
        this.f26004d = qVar;
        this.f26009i = list;
        this.f26011k = u1Var;
        com.google.android.exoplayer2.upstream.k a11 = fVar.a(1);
        this.f26002b = a11;
        if (k0Var != null) {
            a11.e(k0Var);
        }
        this.f26003c = fVar.a(3);
        this.f26008h = new TrackGroup(o1VarArr);
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < uriArr.length; i11++) {
            if ((o1VarArr[i11].f25543e & 16384) == 0) {
                arrayList.add(Integer.valueOf(i11));
            }
        }
        this.f26017q = new d(this.f26008h, Ints.o(arrayList));
    }

    private static Uri d(com.google.android.exoplayer2.source.hls.playlist.d dVar, d.e eVar) {
        String str;
        if (eVar == null || (str = eVar.f26209g) == null) {
            return null;
        }
        return n0.e(dVar.f79073a, str);
    }

    private Pair f(i iVar, boolean z10, com.google.android.exoplayer2.source.hls.playlist.d dVar, long j11, long j12) {
        if (iVar != null && !z10) {
            if (!iVar.f()) {
                return new Pair(Long.valueOf(iVar.f77306j), Integer.valueOf(iVar.f26040o));
            }
            Long valueOf = Long.valueOf(iVar.f26040o == -1 ? iVar.e() : iVar.f77306j);
            int i11 = iVar.f26040o;
            return new Pair(valueOf, Integer.valueOf(i11 != -1 ? i11 + 1 : -1));
        }
        long j13 = dVar.f26194u + j11;
        if (iVar != null && !this.f26016p) {
            j12 = iVar.f77261g;
        }
        if (!dVar.f26188o && j12 >= j13) {
            return new Pair(Long.valueOf(dVar.f26184k + dVar.f26191r.size()), -1);
        }
        long j14 = j12 - j11;
        int i12 = 0;
        int g11 = p0.g(dVar.f26191r, Long.valueOf(j14), true, !this.f26007g.f() || iVar == null);
        long j15 = g11 + dVar.f26184k;
        if (g11 >= 0) {
            d.C0374d c0374d = (d.C0374d) dVar.f26191r.get(g11);
            List list = j14 < c0374d.f26207e + c0374d.f26205c ? c0374d.f26202m : dVar.f26192s;
            while (true) {
                if (i12 >= list.size()) {
                    break;
                }
                d.b bVar = (d.b) list.get(i12);
                if (j14 >= bVar.f26207e + bVar.f26205c) {
                    i12++;
                } else if (bVar.f26196l) {
                    j15 += list == dVar.f26192s ? 1L : 0L;
                    r1 = i12;
                }
            }
        }
        return new Pair(Long.valueOf(j15), Integer.valueOf(r1));
    }

    private static C0372e g(com.google.android.exoplayer2.source.hls.playlist.d dVar, long j11, int i11) {
        int i12 = (int) (j11 - dVar.f26184k);
        if (i12 == dVar.f26191r.size()) {
            if (i11 == -1) {
                i11 = 0;
            }
            if (i11 < dVar.f26192s.size()) {
                return new C0372e((d.e) dVar.f26192s.get(i11), j11, i11);
            }
            return null;
        }
        d.C0374d c0374d = (d.C0374d) dVar.f26191r.get(i12);
        if (i11 == -1) {
            return new C0372e(c0374d, j11, -1);
        }
        if (i11 < c0374d.f26202m.size()) {
            return new C0372e((d.e) c0374d.f26202m.get(i11), j11, i11);
        }
        int i13 = i12 + 1;
        if (i13 < dVar.f26191r.size()) {
            return new C0372e((d.e) dVar.f26191r.get(i13), j11 + 1, -1);
        }
        if (dVar.f26192s.isEmpty()) {
            return null;
        }
        return new C0372e((d.e) dVar.f26192s.get(0), j11 + 1, 0);
    }

    static List i(com.google.android.exoplayer2.source.hls.playlist.d dVar, long j11, int i11) {
        int i12 = (int) (j11 - dVar.f26184k);
        if (i12 < 0 || dVar.f26191r.size() < i12) {
            return ImmutableList.of();
        }
        ArrayList arrayList = new ArrayList();
        if (i12 < dVar.f26191r.size()) {
            if (i11 != -1) {
                d.C0374d c0374d = (d.C0374d) dVar.f26191r.get(i12);
                if (i11 == 0) {
                    arrayList.add(c0374d);
                } else if (i11 < c0374d.f26202m.size()) {
                    List list = c0374d.f26202m;
                    arrayList.addAll(list.subList(i11, list.size()));
                }
                i12++;
            }
            List list2 = dVar.f26191r;
            arrayList.addAll(list2.subList(i12, list2.size()));
            i11 = 0;
        }
        if (dVar.f26187n != C.TIME_UNSET) {
            int i13 = i11 != -1 ? i11 : 0;
            if (i13 < dVar.f26192s.size()) {
                List list3 = dVar.f26192s;
                arrayList.addAll(list3.subList(i13, list3.size()));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private v9.f l(Uri uri, int i11) {
        if (uri == null) {
            return null;
        }
        byte[] c11 = this.f26010j.c(uri);
        if (c11 != null) {
            this.f26010j.b(uri, c11);
            return null;
        }
        return new a(this.f26003c, new n.b().i(uri).b(1).a(), this.f26006f[i11], this.f26017q.getSelectionReason(), this.f26017q.getSelectionData(), this.f26013m);
    }

    private long s(long j11) {
        long j12 = this.f26018r;
        return j12 != C.TIME_UNSET ? j12 - j11 : C.TIME_UNSET;
    }

    private void w(com.google.android.exoplayer2.source.hls.playlist.d dVar) {
        this.f26018r = dVar.f26188o ? C.TIME_UNSET : dVar.d() - this.f26007g.b();
    }

    public v9.o[] a(i iVar, long j11) {
        int i11;
        int d11 = iVar == null ? -1 : this.f26008h.d(iVar.f77258d);
        int length = this.f26017q.length();
        v9.o[] oVarArr = new v9.o[length];
        boolean z10 = false;
        int i12 = 0;
        while (i12 < length) {
            int indexInTrackGroup = this.f26017q.getIndexInTrackGroup(i12);
            Uri uri = this.f26005e[indexInTrackGroup];
            if (this.f26007g.e(uri)) {
                com.google.android.exoplayer2.source.hls.playlist.d i13 = this.f26007g.i(uri, z10);
                com.google.android.exoplayer2.util.a.e(i13);
                long b11 = i13.f26181h - this.f26007g.b();
                i11 = i12;
                Pair f11 = f(iVar, indexInTrackGroup != d11 ? true : z10, i13, b11, j11);
                oVarArr[i11] = new c(i13.f79073a, b11, i(i13, ((Long) f11.first).longValue(), ((Integer) f11.second).intValue()));
            } else {
                oVarArr[i12] = v9.o.f77307a;
                i11 = i12;
            }
            i12 = i11 + 1;
            z10 = false;
        }
        return oVarArr;
    }

    public long b(long j11, c3 c3Var) {
        int selectedIndex = this.f26017q.getSelectedIndex();
        Uri[] uriArr = this.f26005e;
        com.google.android.exoplayer2.source.hls.playlist.d i11 = (selectedIndex >= uriArr.length || selectedIndex == -1) ? null : this.f26007g.i(uriArr[this.f26017q.getSelectedIndexInTrackGroup()], true);
        if (i11 == null || i11.f26191r.isEmpty() || !i11.f79075c) {
            return j11;
        }
        long b11 = i11.f26181h - this.f26007g.b();
        long j12 = j11 - b11;
        int g11 = p0.g(i11.f26191r, Long.valueOf(j12), true, true);
        long j13 = ((d.C0374d) i11.f26191r.get(g11)).f26207e;
        return c3Var.a(j12, j13, g11 != i11.f26191r.size() - 1 ? ((d.C0374d) i11.f26191r.get(g11 + 1)).f26207e : j13) + b11;
    }

    public int c(i iVar) {
        if (iVar.f26040o == -1) {
            return 1;
        }
        com.google.android.exoplayer2.source.hls.playlist.d dVar = (com.google.android.exoplayer2.source.hls.playlist.d) com.google.android.exoplayer2.util.a.e(this.f26007g.i(this.f26005e[this.f26008h.d(iVar.f77258d)], false));
        int i11 = (int) (iVar.f77306j - dVar.f26184k);
        if (i11 < 0) {
            return 1;
        }
        List list = i11 < dVar.f26191r.size() ? ((d.C0374d) dVar.f26191r.get(i11)).f26202m : dVar.f26192s;
        if (iVar.f26040o >= list.size()) {
            return 2;
        }
        d.b bVar = (d.b) list.get(iVar.f26040o);
        if (bVar.f26197m) {
            return 0;
        }
        return p0.c(Uri.parse(n0.d(dVar.f79073a, bVar.f26203a)), iVar.f77256b.f27491a) ? 1 : 2;
    }

    public void e(long j11, long j12, List list, boolean z10, b bVar) {
        com.google.android.exoplayer2.source.hls.playlist.d dVar;
        long j13;
        Uri uri;
        int i11;
        i iVar = list.isEmpty() ? null : (i) g3.g(list);
        int d11 = iVar == null ? -1 : this.f26008h.d(iVar.f77258d);
        long j14 = j12 - j11;
        long s11 = s(j11);
        if (iVar != null && !this.f26016p) {
            long b11 = iVar.b();
            j14 = Math.max(0L, j14 - b11);
            if (s11 != C.TIME_UNSET) {
                s11 = Math.max(0L, s11 - b11);
            }
        }
        this.f26017q.d(j11, j14, s11, list, a(iVar, j12));
        int selectedIndexInTrackGroup = this.f26017q.getSelectedIndexInTrackGroup();
        boolean z11 = d11 != selectedIndexInTrackGroup;
        Uri uri2 = this.f26005e[selectedIndexInTrackGroup];
        if (!this.f26007g.e(uri2)) {
            bVar.f26023c = uri2;
            this.f26019s &= uri2.equals(this.f26015o);
            this.f26015o = uri2;
            return;
        }
        com.google.android.exoplayer2.source.hls.playlist.d i12 = this.f26007g.i(uri2, true);
        com.google.android.exoplayer2.util.a.e(i12);
        this.f26016p = i12.f79075c;
        w(i12);
        long b12 = i12.f26181h - this.f26007g.b();
        Pair f11 = f(iVar, z11, i12, b12, j12);
        long longValue = ((Long) f11.first).longValue();
        int intValue = ((Integer) f11.second).intValue();
        if (longValue >= i12.f26184k || iVar == null || !z11) {
            dVar = i12;
            j13 = b12;
            uri = uri2;
            i11 = selectedIndexInTrackGroup;
        } else {
            Uri uri3 = this.f26005e[d11];
            com.google.android.exoplayer2.source.hls.playlist.d i13 = this.f26007g.i(uri3, true);
            com.google.android.exoplayer2.util.a.e(i13);
            j13 = i13.f26181h - this.f26007g.b();
            Pair f12 = f(iVar, false, i13, j13, j12);
            longValue = ((Long) f12.first).longValue();
            intValue = ((Integer) f12.second).intValue();
            i11 = d11;
            uri = uri3;
            dVar = i13;
        }
        if (longValue < dVar.f26184k) {
            this.f26014n = new BehindLiveWindowException();
            return;
        }
        C0372e g11 = g(dVar, longValue, intValue);
        if (g11 == null) {
            if (!dVar.f26188o) {
                bVar.f26023c = uri;
                this.f26019s &= uri.equals(this.f26015o);
                this.f26015o = uri;
                return;
            } else {
                if (z10 || dVar.f26191r.isEmpty()) {
                    bVar.f26022b = true;
                    return;
                }
                g11 = new C0372e((d.e) g3.g(dVar.f26191r), (dVar.f26184k + dVar.f26191r.size()) - 1, -1);
            }
        }
        this.f26019s = false;
        this.f26015o = null;
        Uri d12 = d(dVar, g11.f26028a.f26204b);
        v9.f l11 = l(d12, i11);
        bVar.f26021a = l11;
        if (l11 != null) {
            return;
        }
        Uri d13 = d(dVar, g11.f26028a);
        v9.f l12 = l(d13, i11);
        bVar.f26021a = l12;
        if (l12 != null) {
            return;
        }
        boolean u11 = i.u(iVar, uri, dVar, g11, j13);
        if (u11 && g11.f26031d) {
            return;
        }
        bVar.f26021a = i.h(this.f26001a, this.f26002b, this.f26006f[i11], j13, dVar, g11, uri, this.f26009i, this.f26017q.getSelectionReason(), this.f26017q.getSelectionData(), this.f26012l, this.f26004d, iVar, this.f26010j.a(d13), this.f26010j.a(d12), u11, this.f26011k);
    }

    public int h(long j11, List list) {
        return (this.f26014n != null || this.f26017q.length() < 2) ? list.size() : this.f26017q.evaluateQueueSize(j11, list);
    }

    public TrackGroup j() {
        return this.f26008h;
    }

    public com.google.android.exoplayer2.trackselection.h k() {
        return this.f26017q;
    }

    public boolean m(v9.f fVar, long j11) {
        com.google.android.exoplayer2.trackselection.h hVar = this.f26017q;
        return hVar.blacklist(hVar.indexOf(this.f26008h.d(fVar.f77258d)), j11);
    }

    public void n() {
        IOException iOException = this.f26014n;
        if (iOException != null) {
            throw iOException;
        }
        Uri uri = this.f26015o;
        if (uri == null || !this.f26019s) {
            return;
        }
        this.f26007g.a(uri);
    }

    public boolean o(Uri uri) {
        return p0.s(this.f26005e, uri);
    }

    public void p(v9.f fVar) {
        if (fVar instanceof a) {
            a aVar = (a) fVar;
            this.f26013m = aVar.f();
            this.f26010j.b(aVar.f77256b.f27491a, (byte[]) com.google.android.exoplayer2.util.a.e(aVar.h()));
        }
    }

    public boolean q(Uri uri, long j11) {
        int indexOf;
        int i11 = 0;
        while (true) {
            Uri[] uriArr = this.f26005e;
            if (i11 >= uriArr.length) {
                i11 = -1;
                break;
            }
            if (uriArr[i11].equals(uri)) {
                break;
            }
            i11++;
        }
        if (i11 == -1 || (indexOf = this.f26017q.indexOf(i11)) == -1) {
            return true;
        }
        this.f26019s |= uri.equals(this.f26015o);
        return j11 == C.TIME_UNSET || (this.f26017q.blacklist(indexOf, j11) && this.f26007g.g(uri, j11));
    }

    public void r() {
        this.f26014n = null;
    }

    public void t(boolean z10) {
        this.f26012l = z10;
    }

    public void u(com.google.android.exoplayer2.trackselection.h hVar) {
        this.f26017q = hVar;
    }

    public boolean v(long j11, v9.f fVar, List list) {
        if (this.f26014n != null) {
            return false;
        }
        return this.f26017q.f(j11, fVar, list);
    }
}

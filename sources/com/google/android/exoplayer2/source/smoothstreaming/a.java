package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import com.google.android.exoplayer2.c3;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.smoothstreaming.b;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.a;
import com.google.android.exoplayer2.trackselection.h;
import com.google.android.exoplayer2.trackselection.j;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.upstream.z;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.List;
import o9.o;
import o9.p;
import v9.e;
import v9.f;
import v9.g;
import v9.n;

/* loaded from: classes3.dex */
public class a implements com.google.android.exoplayer2.source.smoothstreaming.b {

    /* renamed from: a, reason: collision with root package name */
    private final a0 f26606a;

    /* renamed from: b, reason: collision with root package name */
    private final int f26607b;

    /* renamed from: c, reason: collision with root package name */
    private final g[] f26608c;

    /* renamed from: d, reason: collision with root package name */
    private final k f26609d;

    /* renamed from: e, reason: collision with root package name */
    private h f26610e;

    /* renamed from: f, reason: collision with root package name */
    private com.google.android.exoplayer2.source.smoothstreaming.manifest.a f26611f;

    /* renamed from: g, reason: collision with root package name */
    private int f26612g;

    /* renamed from: h, reason: collision with root package name */
    private IOException f26613h;

    /* renamed from: com.google.android.exoplayer2.source.smoothstreaming.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0377a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        private final k.a f26614a;

        public C0377a(k.a aVar) {
            this.f26614a = aVar;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.b.a
        public com.google.android.exoplayer2.source.smoothstreaming.b a(a0 a0Var, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, int i11, h hVar, k0 k0Var) {
            k createDataSource = this.f26614a.createDataSource();
            if (k0Var != null) {
                createDataSource.e(k0Var);
            }
            return new a(a0Var, aVar, i11, hVar, createDataSource);
        }
    }

    /* loaded from: classes3.dex */
    private static final class b extends v9.b {

        /* renamed from: e, reason: collision with root package name */
        private final a.b f26615e;

        /* renamed from: f, reason: collision with root package name */
        private final int f26616f;

        public b(a.b bVar, int i11, int i12) {
            super(i12, bVar.f26684k - 1);
            this.f26615e = bVar;
            this.f26616f = i11;
        }

        @Override // v9.o
        public long a() {
            c();
            return this.f26615e.e((int) d());
        }

        @Override // v9.o
        public long b() {
            return a() + this.f26615e.c((int) d());
        }
    }

    public a(a0 a0Var, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, int i11, h hVar, k kVar) {
        this.f26606a = a0Var;
        this.f26611f = aVar;
        this.f26607b = i11;
        this.f26610e = hVar;
        this.f26609d = kVar;
        a.b bVar = aVar.f26668f[i11];
        this.f26608c = new g[hVar.length()];
        for (int i12 = 0; i12 < this.f26608c.length; i12++) {
            int indexInTrackGroup = hVar.getIndexInTrackGroup(i12);
            o1 o1Var = bVar.f26683j[indexInTrackGroup];
            p[] pVarArr = o1Var.f25553o != null ? ((a.C0378a) com.google.android.exoplayer2.util.a.e(aVar.f26667e)).f26673c : null;
            int i13 = bVar.f26674a;
            this.f26608c[i12] = new e(new o9.g(3, null, new o(indexInTrackGroup, i13, bVar.f26676c, C.TIME_UNSET, aVar.f26669g, o1Var, 0, pVarArr, i13 == 2 ? 4 : 0, null, null)), bVar.f26674a, o1Var);
        }
    }

    private static n i(o1 o1Var, k kVar, Uri uri, int i11, long j11, long j12, long j13, int i12, Object obj, g gVar) {
        return new v9.k(kVar, new com.google.android.exoplayer2.upstream.n(uri), o1Var, i12, obj, j11, j12, j13, C.TIME_UNSET, i11, 1, j11, gVar);
    }

    private long j(long j11) {
        com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar = this.f26611f;
        if (!aVar.f26666d) {
            return C.TIME_UNSET;
        }
        a.b bVar = aVar.f26668f[this.f26607b];
        int i11 = bVar.f26684k - 1;
        return (bVar.e(i11) + bVar.c(i11)) - j11;
    }

    @Override // v9.j
    public long a(long j11, c3 c3Var) {
        a.b bVar = this.f26611f.f26668f[this.f26607b];
        int d11 = bVar.d(j11);
        long e11 = bVar.e(d11);
        return c3Var.a(j11, e11, (e11 >= j11 || d11 >= bVar.f26684k + (-1)) ? e11 : bVar.e(d11 + 1));
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.b
    public void b(h hVar) {
        this.f26610e = hVar;
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.b
    public void c(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
        a.b[] bVarArr = this.f26611f.f26668f;
        int i11 = this.f26607b;
        a.b bVar = bVarArr[i11];
        int i12 = bVar.f26684k;
        a.b bVar2 = aVar.f26668f[i11];
        if (i12 == 0 || bVar2.f26684k == 0) {
            this.f26612g += i12;
        } else {
            int i13 = i12 - 1;
            long e11 = bVar.e(i13) + bVar.c(i13);
            long e12 = bVar2.e(0);
            if (e11 <= e12) {
                this.f26612g += i12;
            } else {
                this.f26612g += bVar.d(e12);
            }
        }
        this.f26611f = aVar;
    }

    @Override // v9.j
    public boolean d(f fVar, boolean z10, z.c cVar, z zVar) {
        z.b d11 = zVar.d(j.c(this.f26610e), cVar);
        if (z10 && d11 != null && d11.f27594a == 2) {
            h hVar = this.f26610e;
            if (hVar.blacklist(hVar.g(fVar.f77258d), d11.f27595b)) {
                return true;
            }
        }
        return false;
    }

    @Override // v9.j
    public final void f(long j11, long j12, List list, v9.h hVar) {
        int e11;
        long j13 = j12;
        if (this.f26613h != null) {
            return;
        }
        a.b bVar = this.f26611f.f26668f[this.f26607b];
        if (bVar.f26684k == 0) {
            hVar.f77265b = !r4.f26666d;
            return;
        }
        if (list.isEmpty()) {
            e11 = bVar.d(j13);
        } else {
            e11 = (int) (((n) list.get(list.size() - 1)).e() - this.f26612g);
            if (e11 < 0) {
                this.f26613h = new BehindLiveWindowException();
                return;
            }
        }
        if (e11 >= bVar.f26684k) {
            hVar.f77265b = !this.f26611f.f26666d;
            return;
        }
        long j14 = j13 - j11;
        long j15 = j(j11);
        int length = this.f26610e.length();
        v9.o[] oVarArr = new v9.o[length];
        for (int i11 = 0; i11 < length; i11++) {
            oVarArr[i11] = new b(bVar, this.f26610e.getIndexInTrackGroup(i11), e11);
        }
        this.f26610e.d(j11, j14, j15, list, oVarArr);
        long e12 = bVar.e(e11);
        long c11 = e12 + bVar.c(e11);
        if (!list.isEmpty()) {
            j13 = C.TIME_UNSET;
        }
        long j16 = j13;
        int i12 = e11 + this.f26612g;
        int selectedIndex = this.f26610e.getSelectedIndex();
        hVar.f77264a = i(this.f26610e.getSelectedFormat(), this.f26609d, bVar.a(this.f26610e.getIndexInTrackGroup(selectedIndex), e11), i12, e12, c11, j16, this.f26610e.getSelectionReason(), this.f26610e.getSelectionData(), this.f26608c[selectedIndex]);
    }

    @Override // v9.j
    public void g(f fVar) {
    }

    @Override // v9.j
    public int getPreferredQueueSize(long j11, List list) {
        return (this.f26613h != null || this.f26610e.length() < 2) ? list.size() : this.f26610e.evaluateQueueSize(j11, list);
    }

    @Override // v9.j
    public boolean h(long j11, f fVar, List list) {
        if (this.f26613h != null) {
            return false;
        }
        return this.f26610e.f(j11, fVar, list);
    }

    @Override // v9.j
    public void maybeThrowError() {
        IOException iOException = this.f26613h;
        if (iOException != null) {
            throw iOException;
        }
        this.f26606a.maybeThrowError();
    }

    @Override // v9.j
    public void release() {
        for (g gVar : this.f26608c) {
            gVar.release();
        }
    }
}

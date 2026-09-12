package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.google.android.exoplayer2.upstream.d0;
import com.google.android.exoplayer2.upstream.e0;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.upstream.j0;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.p0;
import java.io.File;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes3.dex */
public final class a implements com.google.android.exoplayer2.upstream.k {

    /* renamed from: a, reason: collision with root package name */
    private final Cache f27356a;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.k f27357b;

    /* renamed from: c, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.k f27358c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.k f27359d;

    /* renamed from: e, reason: collision with root package name */
    private final g f27360e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f27361f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f27362g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f27363h;

    /* renamed from: i, reason: collision with root package name */
    private Uri f27364i;

    /* renamed from: j, reason: collision with root package name */
    private com.google.android.exoplayer2.upstream.n f27365j;

    /* renamed from: k, reason: collision with root package name */
    private com.google.android.exoplayer2.upstream.n f27366k;

    /* renamed from: l, reason: collision with root package name */
    private com.google.android.exoplayer2.upstream.k f27367l;

    /* renamed from: m, reason: collision with root package name */
    private long f27368m;

    /* renamed from: n, reason: collision with root package name */
    private long f27369n;

    /* renamed from: o, reason: collision with root package name */
    private long f27370o;

    /* renamed from: p, reason: collision with root package name */
    private h f27371p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f27372q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f27373r;

    /* renamed from: s, reason: collision with root package name */
    private long f27374s;

    /* renamed from: t, reason: collision with root package name */
    private long f27375t;

    /* loaded from: classes3.dex */
    public interface b {
    }

    /* loaded from: classes3.dex */
    public static final class c implements k.a {

        /* renamed from: a, reason: collision with root package name */
        private Cache f27376a;

        /* renamed from: c, reason: collision with root package name */
        private i.a f27378c;

        /* renamed from: e, reason: collision with root package name */
        private boolean f27380e;

        /* renamed from: f, reason: collision with root package name */
        private k.a f27381f;

        /* renamed from: g, reason: collision with root package name */
        private PriorityTaskManager f27382g;

        /* renamed from: h, reason: collision with root package name */
        private int f27383h;

        /* renamed from: i, reason: collision with root package name */
        private int f27384i;

        /* renamed from: b, reason: collision with root package name */
        private k.a f27377b = new FileDataSource.b();

        /* renamed from: d, reason: collision with root package name */
        private g f27379d = g.f27390a;

        private a d(com.google.android.exoplayer2.upstream.k kVar, int i11, int i12) {
            com.google.android.exoplayer2.upstream.i iVar;
            Cache cache = (Cache) com.google.android.exoplayer2.util.a.e(this.f27376a);
            if (this.f27380e || kVar == null) {
                iVar = null;
            } else {
                i.a aVar = this.f27378c;
                iVar = aVar != null ? aVar.createDataSink() : new CacheDataSink.a().a(cache).createDataSink();
            }
            return new a(cache, kVar, this.f27377b.createDataSource(), iVar, this.f27379d, i11, this.f27382g, i12, null);
        }

        @Override // com.google.android.exoplayer2.upstream.k.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createDataSource() {
            k.a aVar = this.f27381f;
            return d(aVar != null ? aVar.createDataSource() : null, this.f27384i, this.f27383h);
        }

        public a b() {
            k.a aVar = this.f27381f;
            return d(aVar != null ? aVar.createDataSource() : null, this.f27384i | 1, -1000);
        }

        public a c() {
            return d(null, this.f27384i | 1, -1000);
        }

        public Cache e() {
            return this.f27376a;
        }

        public g f() {
            return this.f27379d;
        }

        public PriorityTaskManager g() {
            return this.f27382g;
        }

        public c h(Cache cache) {
            this.f27376a = cache;
            return this;
        }

        public c i(k.a aVar) {
            this.f27381f = aVar;
            return this;
        }
    }

    private a(Cache cache, com.google.android.exoplayer2.upstream.k kVar, com.google.android.exoplayer2.upstream.k kVar2, com.google.android.exoplayer2.upstream.i iVar, g gVar, int i11, PriorityTaskManager priorityTaskManager, int i12, b bVar) {
        this.f27356a = cache;
        this.f27357b = kVar2;
        this.f27360e = gVar == null ? g.f27390a : gVar;
        this.f27361f = (i11 & 1) != 0;
        this.f27362g = (i11 & 2) != 0;
        this.f27363h = (i11 & 4) != 0;
        if (kVar == null) {
            this.f27359d = d0.f27448a;
            this.f27358c = null;
        } else {
            kVar = priorityTaskManager != null ? new e0(kVar, priorityTaskManager, i12) : kVar;
            this.f27359d = kVar;
            this.f27358c = iVar != null ? new j0(kVar, iVar) : null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f() {
        com.google.android.exoplayer2.upstream.k kVar = this.f27367l;
        if (kVar == null) {
            return;
        }
        try {
            kVar.close();
        } finally {
            this.f27366k = null;
            this.f27367l = null;
            h hVar = this.f27371p;
            if (hVar != null) {
                this.f27356a.g(hVar);
                this.f27371p = null;
            }
        }
    }

    private static Uri j(Cache cache, String str, Uri uri) {
        Uri b11 = l.b(cache.getContentMetadata(str));
        return b11 != null ? b11 : uri;
    }

    private void k(Throwable th2) {
        if (m() || (th2 instanceof Cache.CacheException)) {
            this.f27372q = true;
        }
    }

    private boolean l() {
        return this.f27367l == this.f27359d;
    }

    private boolean m() {
        return this.f27367l == this.f27357b;
    }

    private boolean n() {
        return !m();
    }

    private boolean o() {
        return this.f27367l == this.f27358c;
    }

    private void p() {
    }

    private void q(int i11) {
    }

    private void r(com.google.android.exoplayer2.upstream.n nVar, boolean z10) {
        h c11;
        long j11;
        com.google.android.exoplayer2.upstream.n a11;
        com.google.android.exoplayer2.upstream.k kVar;
        String str = (String) p0.j(nVar.f27499i);
        if (this.f27373r) {
            c11 = null;
        } else if (this.f27361f) {
            try {
                c11 = this.f27356a.c(str, this.f27369n, this.f27370o);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            c11 = this.f27356a.b(str, this.f27369n, this.f27370o);
        }
        if (c11 == null) {
            kVar = this.f27359d;
            a11 = nVar.a().h(this.f27369n).g(this.f27370o).a();
        } else if (c11.f27394d) {
            Uri fromFile = Uri.fromFile((File) p0.j(c11.f27395e));
            long j12 = c11.f27392b;
            long j13 = this.f27369n - j12;
            long j14 = c11.f27393c - j13;
            long j15 = this.f27370o;
            if (j15 != -1) {
                j14 = Math.min(j14, j15);
            }
            a11 = nVar.a().i(fromFile).k(j12).h(j13).g(j14).a();
            kVar = this.f27357b;
        } else {
            if (c11.d()) {
                j11 = this.f27370o;
            } else {
                j11 = c11.f27393c;
                long j16 = this.f27370o;
                if (j16 != -1) {
                    j11 = Math.min(j11, j16);
                }
            }
            a11 = nVar.a().h(this.f27369n).g(j11).a();
            kVar = this.f27358c;
            if (kVar == null) {
                kVar = this.f27359d;
                this.f27356a.g(c11);
                c11 = null;
            }
        }
        this.f27375t = (this.f27373r || kVar != this.f27359d) ? Long.MAX_VALUE : this.f27369n + OSSConstants.MIN_PART_SIZE_LIMIT;
        if (z10) {
            com.google.android.exoplayer2.util.a.g(l());
            if (kVar == this.f27359d) {
                return;
            }
            try {
                f();
            } finally {
            }
        }
        if (c11 != null && c11.b()) {
            this.f27371p = c11;
        }
        this.f27367l = kVar;
        this.f27366k = a11;
        this.f27368m = 0L;
        long a12 = kVar.a(a11);
        n nVar2 = new n();
        if (a11.f27498h == -1 && a12 != -1) {
            this.f27370o = a12;
            n.g(nVar2, this.f27369n + a12);
        }
        if (n()) {
            Uri uri = kVar.getUri();
            this.f27364i = uri;
            n.h(nVar2, nVar.f27491a.equals(uri) ? null : this.f27364i);
        }
        if (o()) {
            this.f27356a.f(str, nVar2);
        }
    }

    private void s(String str) {
        this.f27370o = 0L;
        if (o()) {
            n nVar = new n();
            n.g(nVar, this.f27369n);
            this.f27356a.f(str, nVar);
        }
    }

    private int t(com.google.android.exoplayer2.upstream.n nVar) {
        if (this.f27362g && this.f27372q) {
            return 0;
        }
        return (this.f27363h && nVar.f27498h == -1) ? 1 : -1;
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public long a(com.google.android.exoplayer2.upstream.n nVar) {
        try {
            String a11 = this.f27360e.a(nVar);
            com.google.android.exoplayer2.upstream.n a12 = nVar.a().f(a11).a();
            this.f27365j = a12;
            this.f27364i = j(this.f27356a, a11, a12.f27491a);
            this.f27369n = nVar.f27497g;
            int t11 = t(nVar);
            boolean z10 = t11 != -1;
            this.f27373r = z10;
            if (z10) {
                q(t11);
            }
            if (this.f27373r) {
                this.f27370o = -1L;
            } else {
                long a13 = l.a(this.f27356a.getContentMetadata(a11));
                this.f27370o = a13;
                if (a13 != -1) {
                    long j11 = a13 - nVar.f27497g;
                    this.f27370o = j11;
                    if (j11 < 0) {
                        throw new DataSourceException(2008);
                    }
                }
            }
            long j12 = nVar.f27498h;
            if (j12 != -1) {
                long j13 = this.f27370o;
                if (j13 != -1) {
                    j12 = Math.min(j13, j12);
                }
                this.f27370o = j12;
            }
            long j14 = this.f27370o;
            if (j14 > 0 || j14 == -1) {
                r(a12, false);
            }
            long j15 = nVar.f27498h;
            return j15 != -1 ? j15 : this.f27370o;
        } catch (Throwable th2) {
            k(th2);
            throw th2;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void close() {
        this.f27365j = null;
        this.f27364i = null;
        this.f27369n = 0L;
        p();
        try {
            f();
        } catch (Throwable th2) {
            k(th2);
            throw th2;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void e(k0 k0Var) {
        com.google.android.exoplayer2.util.a.e(k0Var);
        this.f27357b.e(k0Var);
        this.f27359d.e(k0Var);
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public Map getResponseHeaders() {
        return n() ? this.f27359d.getResponseHeaders() : Collections.emptyMap();
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public Uri getUri() {
        return this.f27364i;
    }

    public Cache h() {
        return this.f27356a;
    }

    public g i() {
        return this.f27360e;
    }

    @Override // com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        if (this.f27370o == 0) {
            return -1;
        }
        com.google.android.exoplayer2.upstream.n nVar = (com.google.android.exoplayer2.upstream.n) com.google.android.exoplayer2.util.a.e(this.f27365j);
        com.google.android.exoplayer2.upstream.n nVar2 = (com.google.android.exoplayer2.upstream.n) com.google.android.exoplayer2.util.a.e(this.f27366k);
        try {
            if (this.f27369n >= this.f27375t) {
                r(nVar, true);
            }
            int read = ((com.google.android.exoplayer2.upstream.k) com.google.android.exoplayer2.util.a.e(this.f27367l)).read(bArr, i11, i12);
            if (read == -1) {
                if (n()) {
                    long j11 = nVar2.f27498h;
                    if (j11 == -1 || this.f27368m < j11) {
                        s((String) p0.j(nVar.f27499i));
                    }
                }
                long j12 = this.f27370o;
                if (j12 <= 0) {
                    if (j12 == -1) {
                    }
                }
                f();
                r(nVar, false);
                return read(bArr, i11, i12);
            }
            if (m()) {
                this.f27374s += read;
            }
            long j13 = read;
            this.f27369n += j13;
            this.f27368m += j13;
            long j14 = this.f27370o;
            if (j14 != -1) {
                this.f27370o = j14 - j13;
            }
            return read;
        } catch (Throwable th2) {
            k(th2);
            throw th2;
        }
    }
}

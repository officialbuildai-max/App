package com.mbridge.msdk.thrid.okhttp.internal.connection;

import com.mbridge.msdk.thrid.okhttp.a0;
import com.mbridge.msdk.thrid.okhttp.h;
import com.mbridge.msdk.thrid.okhttp.internal.connection.f;
import com.mbridge.msdk.thrid.okhttp.n;
import com.mbridge.msdk.thrid.okhttp.r;
import com.mbridge.msdk.thrid.okhttp.t;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

/* loaded from: classes5.dex */
public final class g {

    /* renamed from: o, reason: collision with root package name */
    static final /* synthetic */ boolean f38022o = true;

    /* renamed from: a, reason: collision with root package name */
    public final com.mbridge.msdk.thrid.okhttp.a f38023a;

    /* renamed from: b, reason: collision with root package name */
    private f.a f38024b;

    /* renamed from: c, reason: collision with root package name */
    private a0 f38025c;

    /* renamed from: d, reason: collision with root package name */
    private final h f38026d;

    /* renamed from: e, reason: collision with root package name */
    public final com.mbridge.msdk.thrid.okhttp.d f38027e;

    /* renamed from: f, reason: collision with root package name */
    public final n f38028f;

    /* renamed from: g, reason: collision with root package name */
    private final Object f38029g;

    /* renamed from: h, reason: collision with root package name */
    private final f f38030h;

    /* renamed from: i, reason: collision with root package name */
    private int f38031i;

    /* renamed from: j, reason: collision with root package name */
    private c f38032j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f38033k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f38034l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f38035m;

    /* renamed from: n, reason: collision with root package name */
    private com.mbridge.msdk.thrid.okhttp.internal.http.c f38036n;

    /* loaded from: classes5.dex */
    public static final class a extends WeakReference<g> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f38037a;

        a(g gVar, Object obj) {
            super(gVar);
            this.f38037a = obj;
        }
    }

    public g(h hVar, com.mbridge.msdk.thrid.okhttp.a aVar, com.mbridge.msdk.thrid.okhttp.d dVar, n nVar, Object obj) {
        this.f38026d = hVar;
        this.f38023a = aVar;
        this.f38027e = dVar;
        this.f38028f = nVar;
        this.f38030h = new f(aVar, i(), dVar, nVar);
        this.f38029g = obj;
    }

    private c a(int i11, int i12, int i13, int i14, boolean z10) throws IOException {
        c cVar;
        Socket g11;
        c cVar2;
        Socket socket;
        a0 a0Var;
        boolean z11;
        boolean z12;
        f.a aVar;
        synchronized (this.f38026d) {
            try {
                if (this.f38034l) {
                    throw new IllegalStateException("released");
                }
                if (this.f38036n != null) {
                    throw new IllegalStateException("codec != null");
                }
                if (this.f38035m) {
                    throw new IOException("Canceled");
                }
                cVar = this.f38032j;
                g11 = g();
                cVar2 = this.f38032j;
                socket = null;
                if (cVar2 != null) {
                    cVar = null;
                } else {
                    cVar2 = null;
                }
                if (!this.f38033k) {
                    cVar = null;
                }
                if (cVar2 == null) {
                    com.mbridge.msdk.thrid.okhttp.internal.a.f37953a.a(this.f38026d, this.f38023a, this, null);
                    c cVar3 = this.f38032j;
                    if (cVar3 != null) {
                        z11 = true;
                        cVar2 = cVar3;
                        a0Var = null;
                    } else {
                        a0Var = this.f38025c;
                    }
                } else {
                    a0Var = null;
                }
                z11 = false;
            } finally {
            }
        }
        com.mbridge.msdk.thrid.okhttp.internal.c.a(g11);
        if (cVar != null) {
            this.f38028f.connectionReleased(this.f38027e, cVar);
        }
        if (z11) {
            this.f38028f.connectionAcquired(this.f38027e, cVar2);
        }
        if (cVar2 != null) {
            this.f38025c = this.f38032j.c();
            return cVar2;
        }
        if (a0Var != null || ((aVar = this.f38024b) != null && aVar.b())) {
            z12 = false;
        } else {
            this.f38024b = this.f38030h.c();
            z12 = true;
        }
        synchronized (this.f38026d) {
            try {
                if (this.f38035m) {
                    throw new IOException("Canceled");
                }
                if (z12) {
                    List<a0> a11 = this.f38024b.a();
                    int size = a11.size();
                    int i15 = 0;
                    while (true) {
                        if (i15 >= size) {
                            break;
                        }
                        a0 a0Var2 = a11.get(i15);
                        com.mbridge.msdk.thrid.okhttp.internal.a.f37953a.a(this.f38026d, this.f38023a, this, a0Var2);
                        c cVar4 = this.f38032j;
                        if (cVar4 != null) {
                            this.f38025c = a0Var2;
                            z11 = true;
                            cVar2 = cVar4;
                            break;
                        }
                        i15++;
                    }
                }
                if (!z11) {
                    if (a0Var == null) {
                        a0Var = this.f38024b.c();
                    }
                    this.f38025c = a0Var;
                    this.f38031i = 0;
                    cVar2 = new c(this.f38026d, a0Var);
                    a(cVar2, false);
                }
            } finally {
            }
        }
        if (z11) {
            this.f38028f.connectionAcquired(this.f38027e, cVar2);
            return cVar2;
        }
        cVar2.a(i11, i12, i13, i14, z10, this.f38027e, this.f38028f);
        i().a(cVar2.c());
        synchronized (this.f38026d) {
            try {
                this.f38033k = true;
                com.mbridge.msdk.thrid.okhttp.internal.a.f37953a.b(this.f38026d, cVar2);
                if (cVar2.f()) {
                    socket = com.mbridge.msdk.thrid.okhttp.internal.a.f37953a.a(this.f38026d, this.f38023a, this);
                    cVar2 = this.f38032j;
                }
            } finally {
            }
        }
        com.mbridge.msdk.thrid.okhttp.internal.c.a(socket);
        this.f38028f.connectionAcquired(this.f38027e, cVar2);
        return cVar2;
    }

    private c a(int i11, int i12, int i13, int i14, boolean z10, boolean z11) throws IOException {
        while (true) {
            c a11 = a(i11, i12, i13, i14, z10);
            synchronized (this.f38026d) {
                try {
                    if (a11.f38005l == 0 && !a11.f()) {
                        return a11;
                    }
                    if (a11.a(z11)) {
                        return a11;
                    }
                    e();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    private Socket a(boolean z10, boolean z11, boolean z12) {
        Socket socket;
        if (!f38022o && !Thread.holdsLock(this.f38026d)) {
            throw new AssertionError();
        }
        if (z12) {
            this.f38036n = null;
        }
        if (z11) {
            this.f38034l = true;
        }
        c cVar = this.f38032j;
        if (cVar == null) {
            return null;
        }
        if (z10) {
            cVar.f38004k = true;
        }
        if (this.f38036n != null) {
            return null;
        }
        if (!this.f38034l && !cVar.f38004k) {
            return null;
        }
        a(cVar);
        if (this.f38032j.f38007n.isEmpty()) {
            this.f38032j.f38008o = System.nanoTime();
            if (com.mbridge.msdk.thrid.okhttp.internal.a.f37953a.a(this.f38026d, this.f38032j)) {
                socket = this.f38032j.g();
                this.f38032j = null;
                return socket;
            }
        }
        socket = null;
        this.f38032j = null;
        return socket;
    }

    private void a(c cVar) {
        int size = cVar.f38007n.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (cVar.f38007n.get(i11).get() == this) {
                cVar.f38007n.remove(i11);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private Socket g() {
        if (!f38022o && !Thread.holdsLock(this.f38026d)) {
            throw new AssertionError();
        }
        c cVar = this.f38032j;
        if (cVar == null || !cVar.f38004k) {
            return null;
        }
        return a(false, false, true);
    }

    private d i() {
        return com.mbridge.msdk.thrid.okhttp.internal.a.f37953a.a(this.f38026d);
    }

    public com.mbridge.msdk.thrid.okhttp.internal.http.c a(t tVar, r.a aVar, boolean z10) {
        try {
            com.mbridge.msdk.thrid.okhttp.internal.http.c a11 = a(aVar.a(), aVar.b(), aVar.c(), tVar.t(), tVar.z(), z10).a(tVar, aVar, this);
            synchronized (this.f38026d) {
                this.f38036n = a11;
            }
            return a11;
        } catch (IOException e11) {
            throw new e(e11);
        }
    }

    public void a() {
        com.mbridge.msdk.thrid.okhttp.internal.http.c cVar;
        c cVar2;
        synchronized (this.f38026d) {
            this.f38035m = true;
            cVar = this.f38036n;
            cVar2 = this.f38032j;
        }
        if (cVar != null) {
            cVar.cancel();
        } else if (cVar2 != null) {
            cVar2.d();
        }
    }

    public void a(c cVar, boolean z10) {
        if (!f38022o && !Thread.holdsLock(this.f38026d)) {
            throw new AssertionError();
        }
        if (this.f38032j != null) {
            throw new IllegalStateException();
        }
        this.f38032j = cVar;
        this.f38033k = z10;
        cVar.f38007n.add(new a(this, this.f38029g));
    }

    public void a(IOException iOException) {
        c cVar;
        boolean z10;
        Socket a11;
        synchronized (this.f38026d) {
            try {
                cVar = null;
                if (iOException instanceof com.mbridge.msdk.thrid.okhttp.internal.http2.n) {
                    com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar = ((com.mbridge.msdk.thrid.okhttp.internal.http2.n) iOException).f38273a;
                    if (bVar == com.mbridge.msdk.thrid.okhttp.internal.http2.b.REFUSED_STREAM) {
                        int i11 = this.f38031i + 1;
                        this.f38031i = i11;
                        if (i11 > 1) {
                            this.f38025c = null;
                            z10 = true;
                        }
                        z10 = false;
                    } else {
                        if (bVar != com.mbridge.msdk.thrid.okhttp.internal.http2.b.CANCEL) {
                            this.f38025c = null;
                            z10 = true;
                        }
                        z10 = false;
                    }
                } else {
                    c cVar2 = this.f38032j;
                    if (cVar2 != null && (!cVar2.f() || (iOException instanceof com.mbridge.msdk.thrid.okhttp.internal.http2.a))) {
                        if (this.f38032j.f38005l == 0) {
                            a0 a0Var = this.f38025c;
                            if (a0Var != null && iOException != null) {
                                this.f38030h.a(a0Var, iOException);
                            }
                            this.f38025c = null;
                        }
                        z10 = true;
                    }
                    z10 = false;
                }
                c cVar3 = this.f38032j;
                a11 = a(z10, false, true);
                if (this.f38032j == null && this.f38033k) {
                    cVar = cVar3;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        com.mbridge.msdk.thrid.okhttp.internal.c.a(a11);
        if (cVar != null) {
            this.f38028f.connectionReleased(this.f38027e, cVar);
        }
    }

    public void a(boolean z10, com.mbridge.msdk.thrid.okhttp.internal.http.c cVar, long j11, IOException iOException) {
        c cVar2;
        Socket a11;
        boolean z11;
        this.f38028f.responseBodyEnd(this.f38027e, j11);
        synchronized (this.f38026d) {
            if (cVar != null) {
                try {
                    if (cVar == this.f38036n) {
                        if (!z10) {
                            this.f38032j.f38005l++;
                        }
                        cVar2 = this.f38032j;
                        a11 = a(z10, false, true);
                        if (this.f38032j != null) {
                            cVar2 = null;
                        }
                        z11 = this.f38034l;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            throw new IllegalStateException("expected " + this.f38036n + " but was " + cVar);
        }
        com.mbridge.msdk.thrid.okhttp.internal.c.a(a11);
        if (cVar2 != null) {
            this.f38028f.connectionReleased(this.f38027e, cVar2);
        }
        if (iOException != null) {
            this.f38028f.callFailed(this.f38027e, com.mbridge.msdk.thrid.okhttp.internal.a.f37953a.a(this.f38027e, iOException));
        } else if (z11) {
            com.mbridge.msdk.thrid.okhttp.internal.a.f37953a.a(this.f38027e, (IOException) null);
            this.f38028f.callEnd(this.f38027e);
        }
    }

    public com.mbridge.msdk.thrid.okhttp.internal.http.c b() {
        com.mbridge.msdk.thrid.okhttp.internal.http.c cVar;
        synchronized (this.f38026d) {
            cVar = this.f38036n;
        }
        return cVar;
    }

    public Socket b(c cVar) {
        if (!f38022o && !Thread.holdsLock(this.f38026d)) {
            throw new AssertionError();
        }
        if (this.f38036n != null || this.f38032j.f38007n.size() != 1) {
            throw new IllegalStateException();
        }
        Reference<g> reference = this.f38032j.f38007n.get(0);
        Socket a11 = a(true, false, false);
        this.f38032j = cVar;
        cVar.f38007n.add(reference);
        return a11;
    }

    public synchronized c c() {
        return this.f38032j;
    }

    public boolean d() {
        f.a aVar;
        return this.f38025c != null || ((aVar = this.f38024b) != null && aVar.b()) || this.f38030h.a();
    }

    public void e() {
        c cVar;
        Socket a11;
        synchronized (this.f38026d) {
            cVar = this.f38032j;
            a11 = a(true, false, false);
            if (this.f38032j != null) {
                cVar = null;
            }
        }
        com.mbridge.msdk.thrid.okhttp.internal.c.a(a11);
        if (cVar != null) {
            this.f38028f.connectionReleased(this.f38027e, cVar);
        }
    }

    public void f() {
        c cVar;
        Socket a11;
        synchronized (this.f38026d) {
            cVar = this.f38032j;
            a11 = a(false, true, false);
            if (this.f38032j != null) {
                cVar = null;
            }
        }
        com.mbridge.msdk.thrid.okhttp.internal.c.a(a11);
        if (cVar != null) {
            com.mbridge.msdk.thrid.okhttp.internal.a.f37953a.a(this.f38027e, (IOException) null);
            this.f38028f.connectionReleased(this.f38027e, cVar);
            this.f38028f.callEnd(this.f38027e);
        }
    }

    public a0 h() {
        return this.f38025c;
    }

    public String toString() {
        c c11 = c();
        return c11 != null ? c11.toString() : this.f38023a.toString();
    }
}

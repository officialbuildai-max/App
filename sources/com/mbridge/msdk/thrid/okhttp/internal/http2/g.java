package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.thrid.okhttp.internal.http2.h;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.http2.Settings;

/* loaded from: classes5.dex */
public final class g implements Closeable {
    static final /* synthetic */ boolean A = true;

    /* renamed from: z, reason: collision with root package name */
    private static final ExecutorService f38150z = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.mbridge.msdk.thrid.okhttp.internal.c.a("OkHttp Http2Connection", true));

    /* renamed from: a, reason: collision with root package name */
    final boolean f38151a;

    /* renamed from: b, reason: collision with root package name */
    final j f38152b;

    /* renamed from: d, reason: collision with root package name */
    final String f38154d;

    /* renamed from: e, reason: collision with root package name */
    int f38155e;

    /* renamed from: f, reason: collision with root package name */
    int f38156f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f38157g;

    /* renamed from: h, reason: collision with root package name */
    private final ScheduledExecutorService f38158h;

    /* renamed from: i, reason: collision with root package name */
    private final ExecutorService f38159i;

    /* renamed from: j, reason: collision with root package name */
    final com.mbridge.msdk.thrid.okhttp.internal.http2.l f38160j;

    /* renamed from: s, reason: collision with root package name */
    long f38169s;

    /* renamed from: u, reason: collision with root package name */
    final m f38171u;

    /* renamed from: v, reason: collision with root package name */
    final Socket f38172v;

    /* renamed from: w, reason: collision with root package name */
    final com.mbridge.msdk.thrid.okhttp.internal.http2.j f38173w;

    /* renamed from: x, reason: collision with root package name */
    final l f38174x;

    /* renamed from: y, reason: collision with root package name */
    final Set<Integer> f38175y;

    /* renamed from: c, reason: collision with root package name */
    final Map<Integer, com.mbridge.msdk.thrid.okhttp.internal.http2.i> f38153c = new LinkedHashMap();

    /* renamed from: k, reason: collision with root package name */
    private long f38161k = 0;

    /* renamed from: l, reason: collision with root package name */
    private long f38162l = 0;

    /* renamed from: m, reason: collision with root package name */
    private long f38163m = 0;

    /* renamed from: n, reason: collision with root package name */
    private long f38164n = 0;

    /* renamed from: o, reason: collision with root package name */
    private long f38165o = 0;

    /* renamed from: p, reason: collision with root package name */
    private long f38166p = 0;

    /* renamed from: q, reason: collision with root package name */
    private long f38167q = 0;

    /* renamed from: r, reason: collision with root package name */
    long f38168r = 0;

    /* renamed from: t, reason: collision with root package name */
    m f38170t = new m();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends com.mbridge.msdk.thrid.okhttp.internal.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f38176b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.thrid.okhttp.internal.http2.b f38177c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Object[] objArr, int i11, com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar) {
            super(str, objArr);
            this.f38176b = i11;
            this.f38177c = bVar;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.b
        public void b() {
            try {
                g.this.b(this.f38176b, this.f38177c);
            } catch (IOException unused) {
                g.this.h();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b extends com.mbridge.msdk.thrid.okhttp.internal.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f38179b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f38180c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr, int i11, long j11) {
            super(str, objArr);
            this.f38179b = i11;
            this.f38180c = j11;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.b
        public void b() {
            try {
                g.this.f38173w.a(this.f38179b, this.f38180c);
            } catch (IOException unused) {
                g.this.h();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c extends com.mbridge.msdk.thrid.okhttp.internal.b {
        c(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.b
        public void b() {
            g.this.a(false, 2, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d extends com.mbridge.msdk.thrid.okhttp.internal.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f38183b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f38184c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, Object[] objArr, int i11, List list) {
            super(str, objArr);
            this.f38183b = i11;
            this.f38184c = list;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.b
        public void b() {
            if (g.this.f38160j.a(this.f38183b, this.f38184c)) {
                try {
                    g.this.f38173w.a(this.f38183b, com.mbridge.msdk.thrid.okhttp.internal.http2.b.CANCEL);
                    synchronized (g.this) {
                        g.this.f38175y.remove(Integer.valueOf(this.f38183b));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e extends com.mbridge.msdk.thrid.okhttp.internal.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f38186b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f38187c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f38188d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, Object[] objArr, int i11, List list, boolean z10) {
            super(str, objArr);
            this.f38186b = i11;
            this.f38187c = list;
            this.f38188d = z10;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.b
        public void b() {
            boolean a11 = g.this.f38160j.a(this.f38186b, this.f38187c, this.f38188d);
            if (a11) {
                try {
                    g.this.f38173w.a(this.f38186b, com.mbridge.msdk.thrid.okhttp.internal.http2.b.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (a11 || this.f38188d) {
                synchronized (g.this) {
                    g.this.f38175y.remove(Integer.valueOf(this.f38186b));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class f extends com.mbridge.msdk.thrid.okhttp.internal.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f38190b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.thrid.okio.c f38191c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f38192d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f38193e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, Object[] objArr, int i11, com.mbridge.msdk.thrid.okio.c cVar, int i12, boolean z10) {
            super(str, objArr);
            this.f38190b = i11;
            this.f38191c = cVar;
            this.f38192d = i12;
            this.f38193e = z10;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.b
        public void b() {
            try {
                boolean a11 = g.this.f38160j.a(this.f38190b, this.f38191c, this.f38192d, this.f38193e);
                if (a11) {
                    g.this.f38173w.a(this.f38190b, com.mbridge.msdk.thrid.okhttp.internal.http2.b.CANCEL);
                }
                if (a11 || this.f38193e) {
                    synchronized (g.this) {
                        g.this.f38175y.remove(Integer.valueOf(this.f38190b));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.thrid.okhttp.internal.http2.g$g, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0551g extends com.mbridge.msdk.thrid.okhttp.internal.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f38195b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.thrid.okhttp.internal.http2.b f38196c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0551g(String str, Object[] objArr, int i11, com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar) {
            super(str, objArr);
            this.f38195b = i11;
            this.f38196c = bVar;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.b
        public void b() {
            g.this.f38160j.a(this.f38195b, this.f38196c);
            synchronized (g.this) {
                g.this.f38175y.remove(Integer.valueOf(this.f38195b));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        Socket f38198a;

        /* renamed from: b, reason: collision with root package name */
        String f38199b;

        /* renamed from: c, reason: collision with root package name */
        com.mbridge.msdk.thrid.okio.e f38200c;

        /* renamed from: d, reason: collision with root package name */
        com.mbridge.msdk.thrid.okio.d f38201d;

        /* renamed from: e, reason: collision with root package name */
        j f38202e = j.f38207a;

        /* renamed from: f, reason: collision with root package name */
        com.mbridge.msdk.thrid.okhttp.internal.http2.l f38203f = com.mbridge.msdk.thrid.okhttp.internal.http2.l.f38270a;

        /* renamed from: g, reason: collision with root package name */
        boolean f38204g;

        /* renamed from: h, reason: collision with root package name */
        int f38205h;

        public h(boolean z10) {
            this.f38204g = z10;
        }

        public h a(int i11) {
            this.f38205h = i11;
            return this;
        }

        public h a(j jVar) {
            this.f38202e = jVar;
            return this;
        }

        public h a(Socket socket, String str, com.mbridge.msdk.thrid.okio.e eVar, com.mbridge.msdk.thrid.okio.d dVar) {
            this.f38198a = socket;
            this.f38199b = str;
            this.f38200c = eVar;
            this.f38201d = dVar;
            return this;
        }

        public g a() {
            return new g(this);
        }
    }

    /* loaded from: classes5.dex */
    final class i extends com.mbridge.msdk.thrid.okhttp.internal.b {
        i() {
            super("OkHttp %s ping", g.this.f38154d);
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.b
        public void b() {
            boolean z10;
            synchronized (g.this) {
                if (g.this.f38162l < g.this.f38161k) {
                    z10 = true;
                } else {
                    g.e(g.this);
                    z10 = false;
                }
            }
            if (z10) {
                g.this.h();
            } else {
                g.this.a(false, 1, 0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class j {

        /* renamed from: a, reason: collision with root package name */
        public static final j f38207a = new a();

        /* loaded from: classes5.dex */
        static class a extends j {
            a() {
            }

            @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.g.j
            public void a(com.mbridge.msdk.thrid.okhttp.internal.http2.i iVar) throws IOException {
                iVar.a(com.mbridge.msdk.thrid.okhttp.internal.http2.b.REFUSED_STREAM);
            }
        }

        public void a(g gVar) {
        }

        public abstract void a(com.mbridge.msdk.thrid.okhttp.internal.http2.i iVar) throws IOException;
    }

    /* loaded from: classes5.dex */
    final class k extends com.mbridge.msdk.thrid.okhttp.internal.b {

        /* renamed from: b, reason: collision with root package name */
        final boolean f38208b;

        /* renamed from: c, reason: collision with root package name */
        final int f38209c;

        /* renamed from: d, reason: collision with root package name */
        final int f38210d;

        k(boolean z10, int i11, int i12) {
            super("OkHttp %s ping %08x%08x", g.this.f38154d, Integer.valueOf(i11), Integer.valueOf(i12));
            this.f38208b = z10;
            this.f38209c = i11;
            this.f38210d = i12;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.b
        public void b() {
            g.this.a(this.f38208b, this.f38209c, this.f38210d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class l extends com.mbridge.msdk.thrid.okhttp.internal.b implements h.b {

        /* renamed from: b, reason: collision with root package name */
        final com.mbridge.msdk.thrid.okhttp.internal.http2.h f38212b;

        /* loaded from: classes5.dex */
        class a extends com.mbridge.msdk.thrid.okhttp.internal.b {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.mbridge.msdk.thrid.okhttp.internal.http2.i f38214b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, Object[] objArr, com.mbridge.msdk.thrid.okhttp.internal.http2.i iVar) {
                super(str, objArr);
                this.f38214b = iVar;
            }

            @Override // com.mbridge.msdk.thrid.okhttp.internal.b
            public void b() {
                try {
                    g.this.f38152b.a(this.f38214b);
                } catch (IOException e11) {
                    com.mbridge.msdk.thrid.okhttp.internal.platform.g.d().a(4, "Http2Connection.Listener failure for " + g.this.f38154d, e11);
                    try {
                        this.f38214b.a(com.mbridge.msdk.thrid.okhttp.internal.http2.b.PROTOCOL_ERROR);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        /* loaded from: classes5.dex */
        class b extends com.mbridge.msdk.thrid.okhttp.internal.b {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ boolean f38216b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ m f38217c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(String str, Object[] objArr, boolean z10, m mVar) {
                super(str, objArr);
                this.f38216b = z10;
                this.f38217c = mVar;
            }

            @Override // com.mbridge.msdk.thrid.okhttp.internal.b
            public void b() {
                l.this.b(this.f38216b, this.f38217c);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public class c extends com.mbridge.msdk.thrid.okhttp.internal.b {
            c(String str, Object... objArr) {
                super(str, objArr);
            }

            @Override // com.mbridge.msdk.thrid.okhttp.internal.b
            public void b() {
                g gVar = g.this;
                gVar.f38152b.a(gVar);
            }
        }

        l(com.mbridge.msdk.thrid.okhttp.internal.http2.h hVar) {
            super("OkHttp %s", g.this.f38154d);
            this.f38212b = hVar;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.h.b
        public void a() {
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.h.b
        public void a(int i11, int i12, int i13, boolean z10) {
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.h.b
        public void a(int i11, int i12, List<com.mbridge.msdk.thrid.okhttp.internal.http2.c> list) {
            g.this.a(i12, list);
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.h.b
        public void a(int i11, long j11) {
            if (i11 == 0) {
                synchronized (g.this) {
                    g gVar = g.this;
                    gVar.f38169s += j11;
                    gVar.notifyAll();
                }
                return;
            }
            com.mbridge.msdk.thrid.okhttp.internal.http2.i a11 = g.this.a(i11);
            if (a11 != null) {
                synchronized (a11) {
                    a11.a(j11);
                }
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.h.b
        public void a(int i11, com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar) {
            if (g.this.b(i11)) {
                g.this.a(i11, bVar);
                return;
            }
            com.mbridge.msdk.thrid.okhttp.internal.http2.i c11 = g.this.c(i11);
            if (c11 != null) {
                c11.d(bVar);
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.h.b
        public void a(int i11, com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar, com.mbridge.msdk.thrid.okio.f fVar) {
            com.mbridge.msdk.thrid.okhttp.internal.http2.i[] iVarArr;
            fVar.e();
            synchronized (g.this) {
                iVarArr = (com.mbridge.msdk.thrid.okhttp.internal.http2.i[]) g.this.f38153c.values().toArray(new com.mbridge.msdk.thrid.okhttp.internal.http2.i[g.this.f38153c.size()]);
                g.this.f38157g = true;
            }
            for (com.mbridge.msdk.thrid.okhttp.internal.http2.i iVar : iVarArr) {
                if (iVar.c() > i11 && iVar.f()) {
                    iVar.d(com.mbridge.msdk.thrid.okhttp.internal.http2.b.REFUSED_STREAM);
                    g.this.c(iVar.c());
                }
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.h.b
        public void a(boolean z10, int i11, int i12) {
            if (!z10) {
                try {
                    g.this.f38158h.execute(new k(true, i11, i12));
                    return;
                } catch (RejectedExecutionException unused) {
                    return;
                }
            }
            synchronized (g.this) {
                try {
                    if (i11 == 1) {
                        g.c(g.this);
                    } else if (i11 == 2) {
                        g.h(g.this);
                    } else if (i11 == 3) {
                        g.i(g.this);
                        g.this.notifyAll();
                    }
                } finally {
                }
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.h.b
        public void a(boolean z10, int i11, int i12, List<com.mbridge.msdk.thrid.okhttp.internal.http2.c> list) {
            if (g.this.b(i11)) {
                g.this.b(i11, list, z10);
                return;
            }
            synchronized (g.this) {
                try {
                    com.mbridge.msdk.thrid.okhttp.internal.http2.i a11 = g.this.a(i11);
                    if (a11 != null) {
                        a11.a(list);
                        if (z10) {
                            a11.i();
                            return;
                        }
                        return;
                    }
                    if (g.this.f38157g) {
                        return;
                    }
                    g gVar = g.this;
                    if (i11 <= gVar.f38155e) {
                        return;
                    }
                    if (i11 % 2 == gVar.f38156f % 2) {
                        return;
                    }
                    com.mbridge.msdk.thrid.okhttp.internal.http2.i iVar = new com.mbridge.msdk.thrid.okhttp.internal.http2.i(i11, g.this, false, z10, com.mbridge.msdk.thrid.okhttp.internal.c.b(list));
                    g gVar2 = g.this;
                    gVar2.f38155e = i11;
                    gVar2.f38153c.put(Integer.valueOf(i11), iVar);
                    g.f38150z.execute(new a("OkHttp %s stream %d", new Object[]{g.this.f38154d, Integer.valueOf(i11)}, iVar));
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.h.b
        public void a(boolean z10, int i11, com.mbridge.msdk.thrid.okio.e eVar, int i12) throws IOException {
            if (g.this.b(i11)) {
                g.this.a(i11, eVar, i12, z10);
                return;
            }
            com.mbridge.msdk.thrid.okhttp.internal.http2.i a11 = g.this.a(i11);
            if (a11 == null) {
                g.this.c(i11, com.mbridge.msdk.thrid.okhttp.internal.http2.b.PROTOCOL_ERROR);
                long j11 = i12;
                g.this.g(j11);
                eVar.skip(j11);
                return;
            }
            a11.a(eVar, i12);
            if (z10) {
                a11.i();
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.h.b
        public void a(boolean z10, m mVar) {
            try {
                g.this.f38158h.execute(new b("OkHttp %s ACK Settings", new Object[]{g.this.f38154d}, z10, mVar));
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.b
        protected void b() {
            Throwable th2;
            com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar;
            com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar2 = com.mbridge.msdk.thrid.okhttp.internal.http2.b.INTERNAL_ERROR;
            try {
                try {
                    this.f38212b.a(this);
                    do {
                    } while (this.f38212b.a(false, (h.b) this));
                    bVar = com.mbridge.msdk.thrid.okhttp.internal.http2.b.NO_ERROR;
                    try {
                        try {
                            g.this.a(bVar, com.mbridge.msdk.thrid.okhttp.internal.http2.b.CANCEL);
                        } catch (IOException unused) {
                            com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar3 = com.mbridge.msdk.thrid.okhttp.internal.http2.b.PROTOCOL_ERROR;
                            g.this.a(bVar3, bVar3);
                            com.mbridge.msdk.thrid.okhttp.internal.c.a(this.f38212b);
                        }
                    } catch (Throwable th3) {
                        th2 = th3;
                        try {
                            g.this.a(bVar, bVar2);
                        } catch (IOException unused2) {
                        }
                        com.mbridge.msdk.thrid.okhttp.internal.c.a(this.f38212b);
                        throw th2;
                    }
                } catch (IOException unused3) {
                }
            } catch (IOException unused4) {
                bVar = bVar2;
            } catch (Throwable th4) {
                th2 = th4;
                bVar = bVar2;
                g.this.a(bVar, bVar2);
                com.mbridge.msdk.thrid.okhttp.internal.c.a(this.f38212b);
                throw th2;
            }
            com.mbridge.msdk.thrid.okhttp.internal.c.a(this.f38212b);
        }

        void b(boolean z10, m mVar) {
            com.mbridge.msdk.thrid.okhttp.internal.http2.i[] iVarArr;
            long j11;
            synchronized (g.this.f38173w) {
                synchronized (g.this) {
                    try {
                        int c11 = g.this.f38171u.c();
                        if (z10) {
                            g.this.f38171u.a();
                        }
                        g.this.f38171u.a(mVar);
                        int c12 = g.this.f38171u.c();
                        iVarArr = null;
                        if (c12 == -1 || c12 == c11) {
                            j11 = 0;
                        } else {
                            j11 = c12 - c11;
                            if (!g.this.f38153c.isEmpty()) {
                                iVarArr = (com.mbridge.msdk.thrid.okhttp.internal.http2.i[]) g.this.f38153c.values().toArray(new com.mbridge.msdk.thrid.okhttp.internal.http2.i[g.this.f38153c.size()]);
                            }
                        }
                    } finally {
                    }
                }
                try {
                    g gVar = g.this;
                    gVar.f38173w.a(gVar.f38171u);
                } catch (IOException unused) {
                    g.this.h();
                }
            }
            if (iVarArr != null) {
                for (com.mbridge.msdk.thrid.okhttp.internal.http2.i iVar : iVarArr) {
                    synchronized (iVar) {
                        iVar.a(j11);
                    }
                }
            }
            g.f38150z.execute(new c("OkHttp %s settings", g.this.f38154d));
        }
    }

    g(h hVar) {
        m mVar = new m();
        this.f38171u = mVar;
        this.f38175y = new LinkedHashSet();
        this.f38160j = hVar.f38203f;
        boolean z10 = hVar.f38204g;
        this.f38151a = z10;
        this.f38152b = hVar.f38202e;
        int i11 = z10 ? 1 : 2;
        this.f38156f = i11;
        if (z10) {
            this.f38156f = i11 + 2;
        }
        if (z10) {
            this.f38170t.a(7, 16777216);
        }
        String str = hVar.f38199b;
        this.f38154d = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, com.mbridge.msdk.thrid.okhttp.internal.c.a(com.mbridge.msdk.thrid.okhttp.internal.c.a("OkHttp %s Writer", str), false));
        this.f38158h = scheduledThreadPoolExecutor;
        if (hVar.f38205h != 0) {
            i iVar = new i();
            long j11 = hVar.f38205h;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(iVar, j11, j11, TimeUnit.MILLISECONDS);
        }
        this.f38159i = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.mbridge.msdk.thrid.okhttp.internal.c.a(com.mbridge.msdk.thrid.okhttp.internal.c.a("OkHttp %s Push Observer", str), true));
        mVar.a(7, Settings.DEFAULT_INITIAL_WINDOW_SIZE);
        mVar.a(5, 16384);
        this.f38169s = mVar.c();
        this.f38172v = hVar.f38198a;
        this.f38173w = new com.mbridge.msdk.thrid.okhttp.internal.http2.j(hVar.f38201d, z10);
        this.f38174x = new l(new com.mbridge.msdk.thrid.okhttp.internal.http2.h(hVar.f38200c, z10));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0044 A[Catch: all -> 0x0013, TryCatch #0 {all -> 0x0013, blocks: (B:6:0x0006, B:8:0x000d, B:9:0x0015, B:11:0x0019, B:13:0x002c, B:15:0x0034, B:19:0x003e, B:21:0x0044, B:22:0x004d, B:36:0x0072, B:37:0x0077), top: B:5:0x0006, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.mbridge.msdk.thrid.okhttp.internal.http2.i a(int r11, java.util.List<com.mbridge.msdk.thrid.okhttp.internal.http2.c> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            com.mbridge.msdk.thrid.okhttp.internal.http2.j r7 = r10.f38173w
            monitor-enter(r7)
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L56
            int r0 = r10.f38156f     // Catch: java.lang.Throwable -> L13
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L15
            com.mbridge.msdk.thrid.okhttp.internal.http2.b r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.b.REFUSED_STREAM     // Catch: java.lang.Throwable -> L13
            r10.a(r0)     // Catch: java.lang.Throwable -> L13
            goto L15
        L13:
            r11 = move-exception
            goto L78
        L15:
            boolean r0 = r10.f38157g     // Catch: java.lang.Throwable -> L13
            if (r0 != 0) goto L72
            int r8 = r10.f38156f     // Catch: java.lang.Throwable -> L13
            int r0 = r8 + 2
            r10.f38156f = r0     // Catch: java.lang.Throwable -> L13
            com.mbridge.msdk.thrid.okhttp.internal.http2.i r9 = new com.mbridge.msdk.thrid.okhttp.internal.http2.i     // Catch: java.lang.Throwable -> L13
            r5 = 0
            r4 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L13
            if (r13 == 0) goto L3d
            long r0 = r10.f38169s     // Catch: java.lang.Throwable -> L13
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L3d
            long r0 = r9.f38233b     // Catch: java.lang.Throwable -> L13
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L3b
            goto L3d
        L3b:
            r13 = 0
            goto L3e
        L3d:
            r13 = 1
        L3e:
            boolean r0 = r9.g()     // Catch: java.lang.Throwable -> L13
            if (r0 == 0) goto L4d
            java.util.Map<java.lang.Integer, com.mbridge.msdk.thrid.okhttp.internal.http2.i> r0 = r10.f38153c     // Catch: java.lang.Throwable -> L13
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L13
            r0.put(r1, r9)     // Catch: java.lang.Throwable -> L13
        L4d:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L13
            if (r11 != 0) goto L58
            com.mbridge.msdk.thrid.okhttp.internal.http2.j r0 = r10.f38173w     // Catch: java.lang.Throwable -> L56
            r0.a(r6, r8, r11, r12)     // Catch: java.lang.Throwable -> L56
            goto L61
        L56:
            r11 = move-exception
            goto L7a
        L58:
            boolean r0 = r10.f38151a     // Catch: java.lang.Throwable -> L56
            if (r0 != 0) goto L6a
            com.mbridge.msdk.thrid.okhttp.internal.http2.j r0 = r10.f38173w     // Catch: java.lang.Throwable -> L56
            r0.a(r11, r8, r12)     // Catch: java.lang.Throwable -> L56
        L61:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L56
            if (r13 == 0) goto L69
            com.mbridge.msdk.thrid.okhttp.internal.http2.j r11 = r10.f38173w
            r11.flush()
        L69:
            return r9
        L6a:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L56
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch: java.lang.Throwable -> L56
            throw r11     // Catch: java.lang.Throwable -> L56
        L72:
            com.mbridge.msdk.thrid.okhttp.internal.http2.a r11 = new com.mbridge.msdk.thrid.okhttp.internal.http2.a     // Catch: java.lang.Throwable -> L13
            r11.<init>()     // Catch: java.lang.Throwable -> L13
            throw r11     // Catch: java.lang.Throwable -> L13
        L78:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L13
            throw r11     // Catch: java.lang.Throwable -> L56
        L7a:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L56
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.http2.g.a(int, java.util.List, boolean):com.mbridge.msdk.thrid.okhttp.internal.http2.i");
    }

    private synchronized void a(com.mbridge.msdk.thrid.okhttp.internal.b bVar) {
        if (!this.f38157g) {
            this.f38159i.execute(bVar);
        }
    }

    static /* synthetic */ long c(g gVar) {
        long j11 = gVar.f38162l;
        gVar.f38162l = 1 + j11;
        return j11;
    }

    static /* synthetic */ long e(g gVar) {
        long j11 = gVar.f38161k;
        gVar.f38161k = 1 + j11;
        return j11;
    }

    static /* synthetic */ long h(g gVar) {
        long j11 = gVar.f38164n;
        gVar.f38164n = 1 + j11;
        return j11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        try {
            com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar = com.mbridge.msdk.thrid.okhttp.internal.http2.b.PROTOCOL_ERROR;
            a(bVar, bVar);
        } catch (IOException unused) {
        }
    }

    static /* synthetic */ long i(g gVar) {
        long j11 = gVar.f38166p;
        gVar.f38166p = 1 + j11;
        return j11;
    }

    synchronized com.mbridge.msdk.thrid.okhttp.internal.http2.i a(int i11) {
        return this.f38153c.get(Integer.valueOf(i11));
    }

    public com.mbridge.msdk.thrid.okhttp.internal.http2.i a(List<com.mbridge.msdk.thrid.okhttp.internal.http2.c> list, boolean z10) throws IOException {
        return a(0, list, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i11, long j11) {
        try {
            this.f38158h.execute(new b("OkHttp Window Update %s stream %d", new Object[]{this.f38154d, Integer.valueOf(i11)}, i11, j11));
        } catch (RejectedExecutionException unused) {
        }
    }

    void a(int i11, com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar) {
        a(new C0551g("OkHttp %s Push Reset[%s]", new Object[]{this.f38154d, Integer.valueOf(i11)}, i11, bVar));
    }

    void a(int i11, com.mbridge.msdk.thrid.okio.e eVar, int i12, boolean z10) throws IOException {
        com.mbridge.msdk.thrid.okio.c cVar = new com.mbridge.msdk.thrid.okio.c();
        long j11 = i12;
        eVar.e(j11);
        eVar.b(cVar, j11);
        if (cVar.size() == j11) {
            a(new f("OkHttp %s Push Data[%s]", new Object[]{this.f38154d, Integer.valueOf(i11)}, i11, cVar, i12, z10));
            return;
        }
        throw new IOException(cVar.size() + " != " + i12);
    }

    void a(int i11, List<com.mbridge.msdk.thrid.okhttp.internal.http2.c> list) {
        synchronized (this) {
            try {
                if (this.f38175y.contains(Integer.valueOf(i11))) {
                    c(i11, com.mbridge.msdk.thrid.okhttp.internal.http2.b.PROTOCOL_ERROR);
                    return;
                }
                this.f38175y.add(Integer.valueOf(i11));
                try {
                    a(new d("OkHttp %s Push Request[%s]", new Object[]{this.f38154d, Integer.valueOf(i11)}, i11, list));
                } catch (RejectedExecutionException unused) {
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
    
        throw new java.io.IOException("stream closed");
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r4), r8.f38173w.h());
        r6 = r2;
        r8.f38169s -= r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(int r9, boolean r10, com.mbridge.msdk.thrid.okio.c r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            com.mbridge.msdk.thrid.okhttp.internal.http2.j r12 = r8.f38173w
            r12.a(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L67
            monitor-enter(r8)
        L12:
            long r4 = r8.f38169s     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 > 0) goto L32
            java.util.Map<java.lang.Integer, com.mbridge.msdk.thrid.okhttp.internal.http2.i> r2 = r8.f38153c     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            boolean r2 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            if (r2 == 0) goto L2a
            r8.wait()     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            goto L12
        L28:
            r9 = move-exception
            goto L65
        L2a:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            throw r9     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
        L32:
            long r4 = java.lang.Math.min(r12, r4)     // Catch: java.lang.Throwable -> L28
            int r2 = (int) r4     // Catch: java.lang.Throwable -> L28
            com.mbridge.msdk.thrid.okhttp.internal.http2.j r4 = r8.f38173w     // Catch: java.lang.Throwable -> L28
            int r4 = r4.h()     // Catch: java.lang.Throwable -> L28
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L28
            long r4 = r8.f38169s     // Catch: java.lang.Throwable -> L28
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L28
            long r4 = r4 - r6
            r8.f38169s = r4     // Catch: java.lang.Throwable -> L28
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            long r12 = r12 - r6
            com.mbridge.msdk.thrid.okhttp.internal.http2.j r4 = r8.f38173w
            if (r10 == 0) goto L53
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L53
            r5 = 1
            goto L54
        L53:
            r5 = r3
        L54:
            r4.a(r5, r9, r11, r2)
            goto Ld
        L58:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L28
            r9.interrupt()     // Catch: java.lang.Throwable -> L28
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L28
            r9.<init>()     // Catch: java.lang.Throwable -> L28
            throw r9     // Catch: java.lang.Throwable -> L28
        L65:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            throw r9
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.http2.g.a(int, boolean, com.mbridge.msdk.thrid.okio.c, long):void");
    }

    public void a(com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar) throws IOException {
        synchronized (this.f38173w) {
            synchronized (this) {
                if (this.f38157g) {
                    return;
                }
                this.f38157g = true;
                this.f38173w.a(this.f38155e, bVar, com.mbridge.msdk.thrid.okhttp.internal.c.f37955a);
            }
        }
    }

    void a(com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar, com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar2) throws IOException {
        if (!A && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        com.mbridge.msdk.thrid.okhttp.internal.http2.i[] iVarArr = null;
        try {
            a(bVar);
            e = null;
        } catch (IOException e11) {
            e = e11;
        }
        synchronized (this) {
            try {
                if (!this.f38153c.isEmpty()) {
                    iVarArr = (com.mbridge.msdk.thrid.okhttp.internal.http2.i[]) this.f38153c.values().toArray(new com.mbridge.msdk.thrid.okhttp.internal.http2.i[this.f38153c.size()]);
                    this.f38153c.clear();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (iVarArr != null) {
            for (com.mbridge.msdk.thrid.okhttp.internal.http2.i iVar : iVarArr) {
                try {
                    iVar.a(bVar2);
                } catch (IOException e12) {
                    if (e != null) {
                        e = e12;
                    }
                }
            }
        }
        try {
            this.f38173w.close();
        } catch (IOException e13) {
            if (e == null) {
                e = e13;
            }
        }
        try {
            this.f38172v.close();
        } catch (IOException e14) {
            e = e14;
        }
        this.f38158h.shutdown();
        this.f38159i.shutdown();
        if (e != null) {
            throw e;
        }
    }

    void a(boolean z10) throws IOException {
        if (z10) {
            this.f38173w.d();
            this.f38173w.b(this.f38170t);
            if (this.f38170t.c() != 65535) {
                this.f38173w.a(0, r5 - Settings.DEFAULT_INITIAL_WINDOW_SIZE);
            }
        }
        new Thread(this.f38174x).start();
    }

    void a(boolean z10, int i11, int i12) {
        try {
            this.f38173w.a(z10, i11, i12);
        } catch (IOException unused) {
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i11, com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar) throws IOException {
        this.f38173w.a(i11, bVar);
    }

    void b(int i11, List<com.mbridge.msdk.thrid.okhttp.internal.http2.c> list, boolean z10) {
        try {
            a(new e("OkHttp %s Push Headers[%s]", new Object[]{this.f38154d, Integer.valueOf(i11)}, i11, list, z10));
        } catch (RejectedExecutionException unused) {
        }
    }

    boolean b(int i11) {
        return i11 != 0 && (i11 & 1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized com.mbridge.msdk.thrid.okhttp.internal.http2.i c(int i11) {
        com.mbridge.msdk.thrid.okhttp.internal.http2.i remove;
        remove = this.f38153c.remove(Integer.valueOf(i11));
        notifyAll();
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i11, com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar) {
        try {
            this.f38158h.execute(new a("OkHttp %s stream %d", new Object[]{this.f38154d, Integer.valueOf(i11)}, i11, bVar));
        } catch (RejectedExecutionException unused) {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a(com.mbridge.msdk.thrid.okhttp.internal.http2.b.NO_ERROR, com.mbridge.msdk.thrid.okhttp.internal.http2.b.CANCEL);
    }

    public synchronized boolean f(long j11) {
        if (this.f38157g) {
            return false;
        }
        if (this.f38164n < this.f38163m) {
            if (j11 >= this.f38167q) {
                return false;
            }
        }
        return true;
    }

    public void flush() throws IOException {
        this.f38173w.flush();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void g(long j11) {
        long j12 = this.f38168r + j11;
        this.f38168r = j12;
        if (j12 >= this.f38170t.c() / 2) {
            a(0, this.f38168r);
            this.f38168r = 0L;
        }
    }

    public synchronized int k() {
        return this.f38171u.b(Integer.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        synchronized (this) {
            try {
                long j11 = this.f38164n;
                long j12 = this.f38163m;
                if (j11 < j12) {
                    return;
                }
                this.f38163m = j12 + 1;
                this.f38167q = System.nanoTime() + C.NANOS_PER_SECOND;
                try {
                    this.f38158h.execute(new c("OkHttp %s ping", this.f38154d));
                } catch (RejectedExecutionException unused) {
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void m() throws IOException {
        a(true);
    }
}

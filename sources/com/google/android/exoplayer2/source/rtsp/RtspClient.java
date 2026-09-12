package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.rtsp.RtspClient;
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource;
import com.google.android.exoplayer2.source.rtsp.o;
import com.google.android.exoplayer2.source.rtsp.p;
import com.google.android.exoplayer2.source.rtsp.u;
import com.google.android.exoplayer2.source.rtsp.y;
import com.google.android.exoplayer2.util.p0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.g3;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.SocketFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class RtspClient implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private final e f26317a;

    /* renamed from: b, reason: collision with root package name */
    private final d f26318b;

    /* renamed from: c, reason: collision with root package name */
    private final String f26319c;

    /* renamed from: d, reason: collision with root package name */
    private final SocketFactory f26320d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f26321e;

    /* renamed from: i, reason: collision with root package name */
    private Uri f26325i;

    /* renamed from: k, reason: collision with root package name */
    private y.a f26327k;

    /* renamed from: l, reason: collision with root package name */
    private String f26328l;

    /* renamed from: m, reason: collision with root package name */
    private KeepAliveMonitor f26329m;

    /* renamed from: n, reason: collision with root package name */
    private l f26330n;

    /* renamed from: p, reason: collision with root package name */
    private boolean f26332p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f26333q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f26334r;

    /* renamed from: f, reason: collision with root package name */
    private final ArrayDeque f26322f = new ArrayDeque();

    /* renamed from: g, reason: collision with root package name */
    private final SparseArray f26323g = new SparseArray();

    /* renamed from: h, reason: collision with root package name */
    private final c f26324h = new c();

    /* renamed from: j, reason: collision with root package name */
    private u f26326j = new u(new b());

    /* renamed from: s, reason: collision with root package name */
    private long f26335s = C.TIME_UNSET;

    /* renamed from: o, reason: collision with root package name */
    private int f26331o = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class KeepAliveMonitor implements Runnable, Closeable {
        private final long intervalMs;
        private boolean isStarted;
        private final Handler keepAliveHandler = p0.w();

        public KeepAliveMonitor(long j11) {
            this.intervalMs = j11;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.isStarted = false;
            this.keepAliveHandler.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            RtspClient.this.f26324h.e(RtspClient.this.f26325i, RtspClient.this.f26328l);
            this.keepAliveHandler.postDelayed(this, this.intervalMs);
        }

        public void start() {
            if (this.isStarted) {
                return;
            }
            this.isStarted = true;
            this.keepAliveHandler.postDelayed(this, this.intervalMs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class b implements u.d {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f26336a = p0.w();

        public b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void h(List list) {
            RtspClient.this.u0(list);
            if (y.d(list)) {
                g(list);
            } else {
                f(list);
            }
        }

        private void f(List list) {
            RtspClient.this.f26324h.d(Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(y.j(list).f26385c.d("CSeq"))));
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void g(List list) {
            int i11;
            ImmutableList of2;
            c0 k11 = y.k(list);
            int parseInt = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(k11.f26388b.d("CSeq")));
            b0 b0Var = (b0) RtspClient.this.f26323g.get(parseInt);
            if (b0Var == null) {
                return;
            }
            RtspClient.this.f26323g.remove(parseInt);
            int i12 = b0Var.f26384b;
            try {
                i11 = k11.f26387a;
            } catch (ParserException e11) {
                RtspClient.this.p0(new RtspMediaSource.RtspPlaybackException(e11));
                return;
            }
            if (i11 == 200) {
                switch (i12) {
                    case 1:
                    case 3:
                    case 7:
                    case 8:
                    case 9:
                    case 11:
                    case 12:
                        return;
                    case 2:
                        i(new n(i11, h0.b(k11.f26389c)));
                        return;
                    case 4:
                        j(new z(i11, y.i(k11.f26388b.d("Public"))));
                        return;
                    case 5:
                        k();
                        return;
                    case 6:
                        String d11 = k11.f26388b.d("Range");
                        d0 d12 = d11 == null ? d0.f26393c : d0.d(d11);
                        try {
                            String d13 = k11.f26388b.d("RTP-Info");
                            of2 = d13 == null ? ImmutableList.of() : f0.a(d13, RtspClient.this.f26325i);
                        } catch (ParserException unused) {
                            of2 = ImmutableList.of();
                        }
                        l(new a0(k11.f26387a, d12, of2));
                        return;
                    case 10:
                        String d14 = k11.f26388b.d("Session");
                        String d15 = k11.f26388b.d("Transport");
                        if (d14 == null || d15 == null) {
                            throw ParserException.createForMalformedManifest("Missing mandatory session or transport header", null);
                        }
                        m(new e0(k11.f26387a, y.l(d14), d15));
                        return;
                    default:
                        throw new IllegalStateException();
                }
                RtspClient.this.p0(new RtspMediaSource.RtspPlaybackException(e11));
                return;
            }
            if (i11 != 401) {
                if (i11 == 301 || i11 == 302) {
                    if (RtspClient.this.f26331o != -1) {
                        RtspClient.this.f26331o = 0;
                    }
                    String d16 = k11.f26388b.d(HttpHeaders.LOCATION);
                    if (d16 == null) {
                        RtspClient.this.f26317a.a("Redirection without new location.", null);
                        return;
                    }
                    Uri parse = Uri.parse(d16);
                    RtspClient.this.f26325i = y.o(parse);
                    RtspClient.this.f26327k = y.m(parse);
                    RtspClient.this.f26324h.c(RtspClient.this.f26325i, RtspClient.this.f26328l);
                    return;
                }
            } else if (RtspClient.this.f26327k != null && !RtspClient.this.f26333q) {
                ImmutableList e12 = k11.f26388b.e("WWW-Authenticate");
                if (e12.isEmpty()) {
                    throw ParserException.createForMalformedManifest("Missing WWW-Authenticate header in a 401 response.", null);
                }
                for (int i13 = 0; i13 < e12.size(); i13++) {
                    RtspClient.this.f26330n = y.n((String) e12.get(i13));
                    if (RtspClient.this.f26330n.f26490a == 2) {
                        break;
                    }
                }
                RtspClient.this.f26324h.b();
                RtspClient.this.f26333q = true;
                return;
            }
            RtspClient rtspClient = RtspClient.this;
            String s11 = y.s(i12);
            int i14 = k11.f26387a;
            StringBuilder sb2 = new StringBuilder(String.valueOf(s11).length() + 12);
            sb2.append(s11);
            sb2.append(" ");
            sb2.append(i14);
            rtspClient.p0(new RtspMediaSource.RtspPlaybackException(sb2.toString()));
        }

        private void i(n nVar) {
            d0 d0Var = d0.f26393c;
            String str = (String) nVar.f26498b.f26446a.get("range");
            if (str != null) {
                try {
                    d0Var = d0.d(str);
                } catch (ParserException e11) {
                    RtspClient.this.f26317a.a("SDP format error.", e11);
                    return;
                }
            }
            ImmutableList m02 = RtspClient.m0(nVar.f26498b, RtspClient.this.f26325i);
            if (m02.isEmpty()) {
                RtspClient.this.f26317a.a("No playable track.", null);
            } else {
                RtspClient.this.f26317a.g(d0Var, m02);
                RtspClient.this.f26332p = true;
            }
        }

        private void j(z zVar) {
            if (RtspClient.this.f26329m != null) {
                return;
            }
            if (RtspClient.z0(zVar.f26578b)) {
                RtspClient.this.f26324h.c(RtspClient.this.f26325i, RtspClient.this.f26328l);
            } else {
                RtspClient.this.f26317a.a("DESCRIBE not supported.", null);
            }
        }

        private void k() {
            com.google.android.exoplayer2.util.a.g(RtspClient.this.f26331o == 2);
            RtspClient.this.f26331o = 1;
            RtspClient.this.f26334r = false;
            if (RtspClient.this.f26335s != C.TIME_UNSET) {
                RtspClient rtspClient = RtspClient.this;
                rtspClient.E0(p0.e1(rtspClient.f26335s));
            }
        }

        private void l(a0 a0Var) {
            com.google.android.exoplayer2.util.a.g(RtspClient.this.f26331o == 1);
            RtspClient.this.f26331o = 2;
            if (RtspClient.this.f26329m == null) {
                RtspClient rtspClient = RtspClient.this;
                rtspClient.f26329m = new KeepAliveMonitor(30000L);
                RtspClient.this.f26329m.start();
            }
            RtspClient.this.f26335s = C.TIME_UNSET;
            RtspClient.this.f26318b.f(p0.B0(a0Var.f26381b.f26395a), a0Var.f26382c);
        }

        private void m(e0 e0Var) {
            com.google.android.exoplayer2.util.a.g(RtspClient.this.f26331o != -1);
            RtspClient.this.f26331o = 1;
            RtspClient.this.f26328l = e0Var.f26408b.f26575a;
            RtspClient.this.o0();
        }

        @Override // com.google.android.exoplayer2.source.rtsp.u.d
        public /* synthetic */ void a(Exception exc) {
            v.a(this, exc);
        }

        @Override // com.google.android.exoplayer2.source.rtsp.u.d
        public /* synthetic */ void b(List list, Exception exc) {
            v.b(this, list, exc);
        }

        @Override // com.google.android.exoplayer2.source.rtsp.u.d
        public void c(final List list) {
            this.f26336a.post(new Runnable() { // from class: com.google.android.exoplayer2.source.rtsp.m
                @Override // java.lang.Runnable
                public final void run() {
                    RtspClient.b.this.h(list);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class c {

        /* renamed from: a, reason: collision with root package name */
        private int f26338a;

        /* renamed from: b, reason: collision with root package name */
        private b0 f26339b;

        private c() {
        }

        private b0 a(int i11, String str, Map map, Uri uri) {
            String str2 = RtspClient.this.f26319c;
            int i12 = this.f26338a;
            this.f26338a = i12 + 1;
            o.b bVar = new o.b(str2, str, i12);
            if (RtspClient.this.f26330n != null) {
                com.google.android.exoplayer2.util.a.i(RtspClient.this.f26327k);
                try {
                    bVar.b(HttpHeaders.AUTHORIZATION, RtspClient.this.f26330n.a(RtspClient.this.f26327k, uri, i11));
                } catch (ParserException e11) {
                    RtspClient.this.p0(new RtspMediaSource.RtspPlaybackException(e11));
                }
            }
            bVar.d(map);
            return new b0(uri, i11, bVar.e(), "");
        }

        private void h(b0 b0Var) {
            int parseInt = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(b0Var.f26385c.d("CSeq")));
            com.google.android.exoplayer2.util.a.g(RtspClient.this.f26323g.get(parseInt) == null);
            RtspClient.this.f26323g.append(parseInt, b0Var);
            ImmutableList p11 = y.p(b0Var);
            RtspClient.this.u0(p11);
            RtspClient.this.f26326j.l(p11);
            this.f26339b = b0Var;
        }

        private void i(c0 c0Var) {
            ImmutableList q11 = y.q(c0Var);
            RtspClient.this.u0(q11);
            RtspClient.this.f26326j.l(q11);
        }

        public void b() {
            com.google.android.exoplayer2.util.a.i(this.f26339b);
            ImmutableListMultimap b11 = this.f26339b.f26385c.b();
            HashMap hashMap = new HashMap();
            for (String str : b11.keySet()) {
                if (!str.equals("CSeq") && !str.equals("User-Agent") && !str.equals("Session") && !str.equals(HttpHeaders.AUTHORIZATION)) {
                    hashMap.put(str, (String) g3.g(b11.get((Object) str)));
                }
            }
            h(a(this.f26339b.f26384b, RtspClient.this.f26328l, hashMap, this.f26339b.f26383a));
        }

        public void c(Uri uri, String str) {
            h(a(2, str, ImmutableMap.of(), uri));
        }

        public void d(int i11) {
            i(new c0(TTAdConstant.DEEPLINK_FALLBACK_TYPE_CODE, new o.b(RtspClient.this.f26319c, RtspClient.this.f26328l, i11).e()));
            this.f26338a = Math.max(this.f26338a, i11 + 1);
        }

        public void e(Uri uri, String str) {
            h(a(4, str, ImmutableMap.of(), uri));
        }

        public void f(Uri uri, String str) {
            com.google.android.exoplayer2.util.a.g(RtspClient.this.f26331o == 2);
            h(a(5, str, ImmutableMap.of(), uri));
            RtspClient.this.f26334r = true;
        }

        public void g(Uri uri, long j11, String str) {
            boolean z10 = true;
            if (RtspClient.this.f26331o != 1 && RtspClient.this.f26331o != 2) {
                z10 = false;
            }
            com.google.android.exoplayer2.util.a.g(z10);
            h(a(6, str, ImmutableMap.of("Range", d0.b(j11)), uri));
        }

        public void j(Uri uri, String str, String str2) {
            RtspClient.this.f26331o = 0;
            h(a(10, str2, ImmutableMap.of("Transport", str), uri));
        }

        public void k(Uri uri, String str) {
            if (RtspClient.this.f26331o == -1 || RtspClient.this.f26331o == 0) {
                return;
            }
            RtspClient.this.f26331o = 0;
            h(a(12, str, ImmutableMap.of(), uri));
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void b(RtspMediaSource.RtspPlaybackException rtspPlaybackException);

        void e();

        void f(long j11, ImmutableList immutableList);
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(String str, Throwable th2);

        void g(d0 d0Var, ImmutableList immutableList);
    }

    public RtspClient(e eVar, d dVar, String str, Uri uri, SocketFactory socketFactory, boolean z10) {
        this.f26317a = eVar;
        this.f26318b = dVar;
        this.f26319c = str;
        this.f26320d = socketFactory;
        this.f26321e = z10;
        this.f26325i = y.o(uri);
        this.f26327k = y.m(uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static ImmutableList m0(g0 g0Var, Uri uri) {
        ImmutableList.a aVar = new ImmutableList.a();
        for (int i11 = 0; i11 < g0Var.f26447b.size(); i11++) {
            com.google.android.exoplayer2.source.rtsp.a aVar2 = (com.google.android.exoplayer2.source.rtsp.a) g0Var.f26447b.get(i11);
            if (j.b(aVar2)) {
                aVar.a(new t(aVar2, uri));
            }
        }
        return aVar.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        p.d dVar = (p.d) this.f26322f.pollFirst();
        if (dVar == null) {
            this.f26318b.e();
        } else {
            this.f26324h.j(dVar.c(), dVar.d(), this.f26328l);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(Throwable th2) {
        RtspMediaSource.RtspPlaybackException rtspPlaybackException = th2 instanceof RtspMediaSource.RtspPlaybackException ? (RtspMediaSource.RtspPlaybackException) th2 : new RtspMediaSource.RtspPlaybackException(th2);
        if (this.f26332p) {
            this.f26318b.b(rtspPlaybackException);
        } else {
            this.f26317a.a(com.google.common.base.p.e(th2.getMessage()), th2);
        }
    }

    private Socket q0(Uri uri) {
        com.google.android.exoplayer2.util.a.a(uri.getHost() != null);
        return this.f26320d.createSocket((String) com.google.android.exoplayer2.util.a.e(uri.getHost()), uri.getPort() > 0 ? uri.getPort() : 554);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(List list) {
        if (this.f26321e) {
            com.google.android.exoplayer2.util.s.b("RtspClient", com.google.common.base.g.h("\n").d(list));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean z0(List list) {
        return list.isEmpty() || list.contains(2);
    }

    public void B0(List list) {
        this.f26322f.addAll(list);
        o0();
    }

    public void C0() {
        try {
            this.f26326j.i(q0(this.f26325i));
            this.f26324h.e(this.f26325i, this.f26328l);
        } catch (IOException e11) {
            p0.n(this.f26326j);
            throw e11;
        }
    }

    public void E0(long j11) {
        this.f26324h.g(this.f26325i, j11, (String) com.google.android.exoplayer2.util.a.e(this.f26328l));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        KeepAliveMonitor keepAliveMonitor = this.f26329m;
        if (keepAliveMonitor != null) {
            keepAliveMonitor.close();
            this.f26329m = null;
            this.f26324h.k(this.f26325i, (String) com.google.android.exoplayer2.util.a.e(this.f26328l));
        }
        this.f26326j.close();
    }

    public int r0() {
        return this.f26331o;
    }

    public void v0(int i11, u.b bVar) {
        this.f26326j.k(i11, bVar);
    }

    public void x0() {
        try {
            close();
            u uVar = new u(new b());
            this.f26326j = uVar;
            uVar.i(q0(this.f26325i));
            this.f26328l = null;
            this.f26333q = false;
            this.f26330n = null;
        } catch (IOException e11) {
            this.f26318b.b(new RtspMediaSource.RtspPlaybackException(e11));
        }
    }

    public void y0(long j11) {
        if (this.f26331o == 2 && !this.f26334r) {
            this.f26324h.f(this.f26325i, (String) com.google.android.exoplayer2.util.a.e(this.f26328l));
        }
        this.f26335s = j11;
    }
}

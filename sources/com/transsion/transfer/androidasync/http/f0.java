package com.transsion.transfer.androidasync.http;

import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.transsion.api.gateway.utils.EncoderUtil;
import com.transsion.transfer.androidasync.AsyncServer;
import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.http.b0;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.LinkedList;
import java.util.UUID;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes6.dex */
public class f0 implements b0 {

    /* renamed from: a, reason: collision with root package name */
    private LinkedList f55460a;

    /* renamed from: b, reason: collision with root package name */
    private com.transsion.transfer.androidasync.j f55461b;

    /* renamed from: c, reason: collision with root package name */
    com.transsion.transfer.androidasync.n f55462c;

    /* renamed from: d, reason: collision with root package name */
    String f55463d;

    /* renamed from: e, reason: collision with root package name */
    HybiParser f55464e;

    /* renamed from: f, reason: collision with root package name */
    bv.a f55465f;

    /* renamed from: g, reason: collision with root package name */
    private b0.c f55466g;

    /* renamed from: h, reason: collision with root package name */
    private bv.d f55467h;

    /* renamed from: i, reason: collision with root package name */
    private b0.b f55468i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a extends HybiParser {
        a(com.transsion.transfer.androidasync.p pVar) {
            super(pVar);
        }

        @Override // com.transsion.transfer.androidasync.http.HybiParser
        protected void A(String str) {
            f0.k(f0.this);
        }

        @Override // com.transsion.transfer.androidasync.http.HybiParser
        protected void B(String str) {
            if (f0.this.f55468i != null) {
                f0.this.f55468i.a(str);
            }
        }

        @Override // com.transsion.transfer.androidasync.http.HybiParser
        protected void H(Exception exc) {
            bv.a aVar = f0.this.f55465f;
            if (aVar != null) {
                aVar.g(exc);
            }
        }

        @Override // com.transsion.transfer.androidasync.http.HybiParser
        protected void J(byte[] bArr) {
            f0.this.f55462c.l(new ByteBufferList(bArr));
        }

        @Override // com.transsion.transfer.androidasync.http.HybiParser
        protected void x(int i11, String str) {
            f0.this.f55461b.close();
        }

        @Override // com.transsion.transfer.androidasync.http.HybiParser
        protected void y(String str) {
            if (f0.this.f55466g != null) {
                f0.this.f55466g.a(str);
            }
        }

        @Override // com.transsion.transfer.androidasync.http.HybiParser
        protected void z(byte[] bArr) {
            f0.this.y(new ByteBufferList(bArr));
        }
    }

    public f0(com.transsion.transfer.androidasync.http.server.b bVar, com.transsion.transfer.androidasync.http.server.d dVar) {
        this(bVar.getSocket());
        String w11 = w(bVar.getHeaders().c("Sec-WebSocket-Key") + WebSocketProtocol.ACCEPT_MAGIC);
        bVar.getHeaders().c("Origin");
        dVar.c(101);
        dVar.getHeaders().f("Upgrade", "WebSocket");
        dVar.getHeaders().f("Connection", "Upgrade");
        dVar.getHeaders().f("Sec-WebSocket-Accept", w11);
        String c11 = bVar.getHeaders().c("Sec-WebSocket-Protocol");
        if (!TextUtils.isEmpty(c11)) {
            dVar.getHeaders().f("Sec-WebSocket-Protocol", c11);
        }
        dVar.x();
        N(false, false);
    }

    public f0(com.transsion.transfer.androidasync.j jVar) {
        this.f55461b = jVar;
        this.f55462c = new com.transsion.transfer.androidasync.n(jVar);
    }

    public static void C(j jVar, String... strArr) {
        Headers h11 = jVar.h();
        String encodeToString = Base64.encodeToString(O(UUID.randomUUID()), 2);
        h11.f("Sec-WebSocket-Version", PrepareException.ERROR_WARMUP_DOWNLOAD_EXCEPTION);
        h11.f("Sec-WebSocket-Key", encodeToString);
        h11.f("Sec-WebSocket-Extensions", "x-webkit-deflate-frame");
        h11.f("Connection", "Upgrade");
        h11.f("Upgrade", "websocket");
        if (strArr != null) {
            for (String str : strArr) {
                h11.a("Sec-WebSocket-Protocol", str);
            }
        }
        h11.f("Pragma", "no-cache");
        h11.f(HttpHeaders.CACHE_CONTROL, "no-cache");
        if (TextUtils.isEmpty(jVar.h().c("User-Agent"))) {
            jVar.h().f("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.15 Safari/537.36");
        }
    }

    public static b0 F(Headers headers, k kVar) {
        String c11;
        String c12;
        if (kVar == null || kVar.b() != 101 || !"websocket".equalsIgnoreCase(kVar.e().c("Upgrade")) || (c11 = kVar.e().c("Sec-WebSocket-Accept")) == null || (c12 = headers.c("Sec-WebSocket-Key")) == null) {
            return null;
        }
        if (!c11.equalsIgnoreCase(w(c12 + WebSocketProtocol.ACCEPT_MAGIC).trim())) {
            return null;
        }
        String c13 = headers.c("Sec-WebSocket-Extensions");
        boolean z10 = c13 != null && c13.equals("x-webkit-deflate-frame");
        f0 f0Var = new f0(kVar.z());
        f0Var.f55463d = kVar.e().c("Sec-WebSocket-Protocol");
        f0Var.N(true, z10);
        return f0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(String str) {
        this.f55462c.l(new ByteBufferList(ByteBuffer.wrap(this.f55464e.G(str))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(byte[] bArr) {
        this.f55462c.l(new ByteBufferList(this.f55464e.t(bArr)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(String str) {
        this.f55462c.l(new ByteBufferList(this.f55464e.s(str)));
    }

    private void N(boolean z10, boolean z11) {
        a aVar = new a(this.f55461b);
        this.f55464e = aVar;
        aVar.L(z10);
        this.f55464e.K(z11);
        if (this.f55461b.isPaused()) {
            this.f55461b.resume();
        }
    }

    private static byte[] O(UUID uuid) {
        byte[] bArr = new byte[16];
        ByteBuffer.wrap(bArr).asLongBuffer().put(new long[]{uuid.getMostSignificantBits(), uuid.getLeastSignificantBits()});
        return bArr;
    }

    static /* bridge */ /* synthetic */ b0.a k(f0 f0Var) {
        f0Var.getClass();
        return null;
    }

    private static String w(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncoderUtil.ALGORITHM_SHA_1);
            messageDigest.update(str.getBytes("iso-8859-1"), 0, str.length());
            return Base64.encodeToString(messageDigest.digest(), 2);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(ByteBufferList byteBufferList) {
        if (this.f55460a == null) {
            com.transsion.transfer.androidasync.a0.a(this, byteBufferList);
            if (byteBufferList.C() > 0) {
                LinkedList linkedList = new LinkedList();
                this.f55460a = linkedList;
                linkedList.add(byteBufferList);
                return;
            }
            return;
        }
        while (!isPaused()) {
            ByteBufferList byteBufferList2 = (ByteBufferList) this.f55460a.remove();
            com.transsion.transfer.androidasync.a0.a(this, byteBufferList2);
            if (byteBufferList2.C() > 0) {
                this.f55460a.add(0, byteBufferList2);
            }
        }
        if (this.f55460a.size() == 0) {
            this.f55460a = null;
        }
    }

    @Override // com.transsion.transfer.androidasync.http.b0
    public void A(final String str) {
        a().D(new Runnable() { // from class: com.transsion.transfer.androidasync.http.c0
            @Override // java.lang.Runnable
            public final void run() {
                f0.this.H(str);
            }
        });
    }

    @Override // com.transsion.transfer.androidasync.http.b0
    public void G(b0.b bVar) {
        this.f55468i = bVar;
    }

    @Override // com.transsion.transfer.androidasync.p
    public bv.d I() {
        return this.f55467h;
    }

    @Override // com.transsion.transfer.androidasync.http.b0
    public void J(b0.c cVar) {
        this.f55466g = cVar;
    }

    public void M(final byte[] bArr) {
        a().D(new Runnable() { // from class: com.transsion.transfer.androidasync.http.d0
            @Override // java.lang.Runnable
            public final void run() {
                f0.this.K(bArr);
            }
        });
    }

    @Override // com.transsion.transfer.androidasync.j, com.transsion.transfer.androidasync.p, com.transsion.transfer.androidasync.s
    public AsyncServer a() {
        return this.f55461b.a();
    }

    @Override // com.transsion.transfer.androidasync.p
    public void close() {
        this.f55461b.close();
    }

    @Override // com.transsion.transfer.androidasync.s
    public void d() {
        this.f55461b.d();
    }

    @Override // com.transsion.transfer.androidasync.s
    public bv.j i() {
        return this.f55462c.i();
    }

    @Override // com.transsion.transfer.androidasync.s
    public boolean isOpen() {
        return this.f55461b.isOpen();
    }

    @Override // com.transsion.transfer.androidasync.p
    public boolean isPaused() {
        return this.f55461b.isPaused();
    }

    @Override // com.transsion.transfer.androidasync.s
    public void l(ByteBufferList byteBufferList) {
        M(byteBufferList.l());
    }

    @Override // com.transsion.transfer.androidasync.s
    public void o(bv.j jVar) {
        this.f55462c.o(jVar);
    }

    @Override // com.transsion.transfer.androidasync.s
    public void p(bv.a aVar) {
        this.f55461b.p(aVar);
    }

    @Override // com.transsion.transfer.androidasync.p
    public void pause() {
        this.f55461b.pause();
    }

    @Override // com.transsion.transfer.androidasync.p
    public void resume() {
        this.f55461b.resume();
    }

    @Override // com.transsion.transfer.androidasync.p
    public void s(bv.a aVar) {
        this.f55465f = aVar;
    }

    @Override // com.transsion.transfer.androidasync.http.b0
    public void send(final String str) {
        a().D(new Runnable() { // from class: com.transsion.transfer.androidasync.http.e0
            @Override // java.lang.Runnable
            public final void run() {
                f0.this.L(str);
            }
        });
    }

    @Override // com.transsion.transfer.androidasync.p
    public void t(bv.d dVar) {
        this.f55467h = dVar;
    }

    @Override // com.transsion.transfer.androidasync.p
    public String v() {
        return null;
    }
}

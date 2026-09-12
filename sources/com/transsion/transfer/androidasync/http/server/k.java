package com.transsion.transfer.androidasync.http.server;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.cloud.tmc.integration.audio.recording.RecorderConstants;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.transsion.transfer.androidasync.AsyncServer;
import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.a0;
import com.transsion.transfer.androidasync.http.Headers;
import com.transsion.transfer.androidasync.http.HttpUtil;
import com.transsion.transfer.androidasync.http.Protocol;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

/* loaded from: classes6.dex */
public abstract class k implements d {

    /* renamed from: c, reason: collision with root package name */
    private bv.e f55586c;

    /* renamed from: d, reason: collision with root package name */
    com.transsion.transfer.androidasync.j f55587d;

    /* renamed from: e, reason: collision with root package name */
    c f55588e;

    /* renamed from: g, reason: collision with root package name */
    com.transsion.transfer.androidasync.s f55590g;

    /* renamed from: h, reason: collision with root package name */
    bv.j f55591h;

    /* renamed from: i, reason: collision with root package name */
    boolean f55592i;

    /* renamed from: j, reason: collision with root package name */
    boolean f55593j;

    /* renamed from: m, reason: collision with root package name */
    bv.a f55596m;

    /* renamed from: a, reason: collision with root package name */
    private Headers f55584a = new Headers();

    /* renamed from: b, reason: collision with root package name */
    private long f55585b = -1;

    /* renamed from: f, reason: collision with root package name */
    boolean f55589f = false;

    /* renamed from: k, reason: collision with root package name */
    int f55594k = 200;

    /* renamed from: l, reason: collision with root package name */
    String f55595l = "HTTP/1.1";

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(com.transsion.transfer.androidasync.j jVar, c cVar) {
        this.f55587d = jVar;
        this.f55588e = cVar;
        if (HttpUtil.d(Protocol.HTTP_1_1, cVar.getHeaders())) {
            this.f55584a.f("Connection", "Keep-Alive");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(final InputStream inputStream) {
        a0.e(inputStream, this.f55585b, this, new bv.a() { // from class: com.transsion.transfer.androidasync.http.server.j
            @Override // bv.a
            public final void g(Exception exc) {
                k.this.z(inputStream, exc);
            }
        }, this.f55586c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t() {
        bv.j i11 = i();
        if (i11 != null) {
            i11.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(boolean z10, Exception exc) {
        if (exc != null) {
            D(exc);
            return;
        }
        if (z10) {
            ev.a aVar = new ev.a(this.f55587d);
            aVar.q(0);
            this.f55590g = aVar;
        } else {
            this.f55590g = this.f55587d;
        }
        this.f55590g.p(this.f55596m);
        this.f55596m = null;
        this.f55590g.o(this.f55591h);
        this.f55591h = null;
        if (this.f55592i) {
            d();
        } else {
            a().D(new Runnable() { // from class: com.transsion.transfer.androidasync.http.server.g
                @Override // java.lang.Runnable
                public final void run() {
                    k.this.t();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(Exception exc) {
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(ByteBufferList byteBufferList, String str) {
        long C = byteBufferList.C();
        this.f55585b = C;
        this.f55584a.f(HttpHeaders.CONTENT_LENGTH, Long.toString(C));
        if (str != null) {
            this.f55584a.f(HttpHeaders.CONTENT_TYPE, str);
        }
        a0.g(this, byteBufferList, new bv.a() { // from class: com.transsion.transfer.androidasync.http.server.h
            @Override // bv.a
            public final void g(Exception exc) {
                k.this.v(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(InputStream inputStream, Exception exc) {
        com.transsion.transfer.androidasync.util.d.a(inputStream);
        C();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C() {
        this.f55593j = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(Exception exc) {
    }

    @Override // com.transsion.transfer.androidasync.http.server.d
    public String E() {
        return this.f55595l;
    }

    public void F(final String str, final ByteBufferList byteBufferList) {
        a().D(new Runnable() { // from class: com.transsion.transfer.androidasync.http.server.f
            @Override // java.lang.Runnable
            public final void run() {
                k.this.y(byteBufferList, str);
            }
        });
    }

    public void H(String str, String str2) {
        try {
            I(str, str2.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e11) {
            throw new AssertionError(e11);
        }
    }

    public void I(String str, byte[] bArr) {
        F(str, new ByteBufferList(bArr));
    }

    public void K(final InputStream inputStream, long j11) {
        long j12;
        long j13 = j11 - 1;
        String c11 = this.f55588e.getHeaders().c("Range");
        if (c11 != null) {
            String[] split = c11.split(UrlUtils.EQUAL_MARK);
            if (split.length != 2 || !"bytes".equals(split[0])) {
                c(TTAdConstant.PACKAGE_NAME_CODE);
                d();
                return;
            }
            String[] split2 = split[1].split("-");
            try {
                if (split2.length > 2) {
                    throw new MalformedRangeException();
                }
                long parseLong = !TextUtils.isEmpty(split2[0]) ? Long.parseLong(split2[0]) : 0L;
                if (split2.length == 2 && !TextUtils.isEmpty(split2[1])) {
                    j13 = Long.parseLong(split2[1]);
                }
                c(Sdk$SDKError.Reason.AD_ALREADY_FAILED_VALUE);
                getHeaders().f("Content-Range", String.format(Locale.ENGLISH, "bytes %d-%d/%d", Long.valueOf(parseLong), Long.valueOf(j13), Long.valueOf(j11)));
                j12 = parseLong;
            } catch (Exception unused) {
                c(TTAdConstant.PACKAGE_NAME_CODE);
                d();
                return;
            }
        } else {
            j12 = 0;
        }
        try {
            if (j12 != inputStream.skip(j12)) {
                throw new StreamSkipException("skip failed to skip requested amount");
            }
            long j14 = (j13 - j12) + 1;
            this.f55585b = j14;
            this.f55584a.f(HttpHeaders.CONTENT_LENGTH, String.valueOf(j14));
            this.f55584a.f("Accept-Ranges", "bytes");
            if (this.f55588e.B().equals("HEAD")) {
                x();
                C();
            } else {
                if (this.f55585b != 0) {
                    a().D(new Runnable() { // from class: com.transsion.transfer.androidasync.http.server.i
                        @Override // java.lang.Runnable
                        public final void run() {
                            k.this.B(inputStream);
                        }
                    });
                    return;
                }
                x();
                com.transsion.transfer.androidasync.util.d.a(inputStream);
                C();
            }
        } catch (Exception unused2) {
            c(500);
            d();
        }
    }

    @Override // com.transsion.transfer.androidasync.s
    public AsyncServer a() {
        return this.f55587d.a();
    }

    @Override // com.transsion.transfer.androidasync.http.server.d
    public int b() {
        return this.f55594k;
    }

    @Override // com.transsion.transfer.androidasync.http.server.d
    public d c(int i11) {
        this.f55594k = i11;
        return this;
    }

    @Override // com.transsion.transfer.androidasync.http.server.d, com.transsion.transfer.androidasync.s
    public void d() {
        if (this.f55592i) {
            return;
        }
        this.f55592i = true;
        boolean z10 = this.f55589f;
        if (z10 && this.f55590g == null) {
            return;
        }
        if (!z10) {
            this.f55584a.d("Transfer-Encoding");
        }
        com.transsion.transfer.androidasync.s sVar = this.f55590g;
        if (sVar instanceof ev.a) {
            sVar.d();
            return;
        }
        if (this.f55589f) {
            C();
        } else if (!this.f55588e.B().equalsIgnoreCase("HEAD")) {
            H("text/html", "");
        } else {
            x();
            C();
        }
    }

    @Override // bv.a
    public void g(Exception exc) {
        d();
    }

    @Override // com.transsion.transfer.androidasync.http.server.d
    public Headers getHeaders() {
        return this.f55584a;
    }

    @Override // com.transsion.transfer.androidasync.s
    public bv.j i() {
        com.transsion.transfer.androidasync.s sVar = this.f55590g;
        return sVar != null ? sVar.i() : this.f55591h;
    }

    @Override // com.transsion.transfer.androidasync.s
    public void l(ByteBufferList byteBufferList) {
        com.transsion.transfer.androidasync.s sVar;
        if (!this.f55589f) {
            s();
        }
        if (byteBufferList.C() == 0 || (sVar = this.f55590g) == null) {
            return;
        }
        sVar.l(byteBufferList);
    }

    @Override // com.transsion.transfer.androidasync.http.server.d
    public void n(File file, bv.e eVar) {
        try {
            this.f55586c = eVar;
            if (this.f55584a.c(HttpHeaders.CONTENT_TYPE) == null) {
                this.f55584a.f(HttpHeaders.CONTENT_TYPE, n.g(file.getAbsolutePath()));
            }
            K(new BufferedInputStream(new FileInputStream(file), RecorderConstants.RECORD_ENCODING_BITRATE_64000), file.length());
        } catch (FileNotFoundException unused) {
            c(TTAdConstant.DEEPLINK_FALLBACK_CODE);
            d();
        }
    }

    @Override // com.transsion.transfer.androidasync.s
    public void o(bv.j jVar) {
        com.transsion.transfer.androidasync.s sVar = this.f55590g;
        if (sVar != null) {
            sVar.o(jVar);
        } else {
            this.f55591h = jVar;
        }
    }

    @Override // com.transsion.transfer.androidasync.s
    public void p(bv.a aVar) {
        com.transsion.transfer.androidasync.s sVar = this.f55590g;
        if (sVar != null) {
            sVar.p(aVar);
        } else {
            this.f55596m = aVar;
        }
    }

    public b r() {
        return this.f55588e;
    }

    void s() {
        final boolean z10;
        if (this.f55589f) {
            return;
        }
        this.f55589f = true;
        String c11 = this.f55584a.c("Transfer-Encoding");
        if ("".equals(c11)) {
            this.f55584a.e("Transfer-Encoding");
        }
        boolean z11 = ("Chunked".equalsIgnoreCase(c11) || c11 == null) && !"close".equalsIgnoreCase(this.f55584a.c("Connection"));
        if (this.f55585b < 0) {
            String c12 = this.f55584a.c(HttpHeaders.CONTENT_LENGTH);
            if (!TextUtils.isEmpty(c12)) {
                this.f55585b = Long.valueOf(c12).longValue();
            }
        }
        if (this.f55585b >= 0 || !z11) {
            z10 = false;
        } else {
            this.f55584a.f("Transfer-Encoding", "Chunked");
            z10 = true;
        }
        a0.h(this.f55587d, this.f55584a.g(String.format(Locale.ENGLISH, "%s %s %s", this.f55595l, Integer.valueOf(this.f55594k), AsyncHttpServer.l(this.f55594k))).getBytes(), new bv.a() { // from class: com.transsion.transfer.androidasync.http.server.e
            @Override // bv.a
            public final void g(Exception exc) {
                k.this.u(z10, exc);
            }
        });
    }

    @Override // com.transsion.transfer.androidasync.http.server.d
    public void send(String str) {
        String c11 = this.f55584a.c(HttpHeaders.CONTENT_TYPE);
        if (c11 == null) {
            c11 = "text/html; charset=utf-8";
        }
        H(c11, str);
    }

    public String toString() {
        return this.f55584a == null ? super.toString() : this.f55584a.g(String.format(Locale.ENGLISH, "%s %s %s", this.f55595l, Integer.valueOf(this.f55594k), AsyncHttpServer.l(this.f55594k)));
    }

    @Override // com.transsion.transfer.androidasync.http.server.d
    public void x() {
        s();
    }
}

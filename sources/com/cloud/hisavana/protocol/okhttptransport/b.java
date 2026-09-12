package com.cloud.hisavana.protocol.okhttptransport;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

/* loaded from: classes3.dex */
abstract class b extends ResponseBody {

    /* renamed from: a, reason: collision with root package name */
    private final ResponseBody f21547a;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(ResponseBody responseBody) {
        this.f21547a = responseBody;
    }

    @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f21547a.close();
        d();
    }

    @Override // okhttp3.ResponseBody
    /* renamed from: contentLength */
    public final long get$contentLength() {
        return this.f21547a.get$contentLength();
    }

    @Override // okhttp3.ResponseBody
    /* renamed from: contentType */
    public final MediaType get$contentType() {
        return this.f21547a.get$contentType();
    }

    abstract void d();

    @Override // okhttp3.ResponseBody
    /* renamed from: source */
    public final BufferedSource get$this_asResponseBody() {
        return this.f21547a.get$this_asResponseBody();
    }
}

package com.squareup.okhttp.internal.http;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.ResponseBody;
import okio.BufferedSource;

/* loaded from: classes5.dex */
public final class i extends ResponseBody {

    /* renamed from: a, reason: collision with root package name */
    private final Headers f40581a;

    /* renamed from: b, reason: collision with root package name */
    private final BufferedSource f40582b;

    public i(Headers headers, BufferedSource bufferedSource) {
        this.f40581a = headers;
        this.f40582b = bufferedSource;
    }

    @Override // com.squareup.okhttp.ResponseBody
    public long contentLength() {
        return OkHeaders.c(this.f40581a);
    }

    @Override // com.squareup.okhttp.ResponseBody
    public MediaType contentType() {
        String str = this.f40581a.get(HttpHeaders.CONTENT_TYPE);
        if (str != null) {
            return MediaType.parse(str);
        }
        return null;
    }

    @Override // com.squareup.okhttp.ResponseBody
    public BufferedSource source() {
        return this.f40582b;
    }
}

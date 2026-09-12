package com.amazonaws.http;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.amazonaws.util.StringUtils;
import java.io.InputStream;
import java.net.URI;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public class HttpRequest {

    /* renamed from: a, reason: collision with root package name */
    private final String f18471a;

    /* renamed from: b, reason: collision with root package name */
    private URI f18472b;

    /* renamed from: c, reason: collision with root package name */
    private final Map f18473c;

    /* renamed from: d, reason: collision with root package name */
    private final InputStream f18474d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f18475e;

    public HttpRequest(String str, URI uri, Map map, InputStream inputStream) {
        this.f18471a = StringUtils.c(str);
        this.f18472b = uri;
        this.f18473c = map == null ? Collections.EMPTY_MAP : Collections.unmodifiableMap(map);
        this.f18474d = inputStream;
    }

    public InputStream a() {
        return this.f18474d;
    }

    public long b() {
        String str;
        Map map = this.f18473c;
        if (map == null || (str = (String) map.get(HttpHeaders.CONTENT_LENGTH)) == null || str.isEmpty()) {
            return 0L;
        }
        return Long.valueOf(str).longValue();
    }

    public Map c() {
        return this.f18473c;
    }

    public String d() {
        return this.f18471a;
    }

    public URI e() {
        return this.f18472b;
    }

    public boolean f() {
        return this.f18475e;
    }

    public void g(boolean z10) {
        this.f18475e = z10;
    }
}

package com.amazonaws.http;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* loaded from: classes2.dex */
public class HttpResponse {

    /* renamed from: a, reason: collision with root package name */
    private final String f18476a;

    /* renamed from: b, reason: collision with root package name */
    private final int f18477b;

    /* renamed from: c, reason: collision with root package name */
    private final InputStream f18478c;

    /* renamed from: d, reason: collision with root package name */
    private final Map f18479d;

    /* renamed from: e, reason: collision with root package name */
    private InputStream f18480e;

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private String f18481a;

        /* renamed from: b, reason: collision with root package name */
        private int f18482b;

        /* renamed from: c, reason: collision with root package name */
        private InputStream f18483c;

        /* renamed from: d, reason: collision with root package name */
        private final Map f18484d = new HashMap();

        public HttpResponse a() {
            return new HttpResponse(this.f18481a, this.f18482b, Collections.unmodifiableMap(this.f18484d), this.f18483c);
        }

        public Builder b(InputStream inputStream) {
            this.f18483c = inputStream;
            return this;
        }

        public Builder c(String str, String str2) {
            this.f18484d.put(str, str2);
            return this;
        }

        public Builder d(int i11) {
            this.f18482b = i11;
            return this;
        }

        public Builder e(String str) {
            this.f18481a = str;
            return this;
        }
    }

    private HttpResponse(String str, int i11, Map map, InputStream inputStream) {
        this.f18476a = str;
        this.f18477b = i11;
        this.f18479d = map;
        this.f18478c = inputStream;
    }

    public static Builder a() {
        return new Builder();
    }

    public InputStream b() {
        if (this.f18480e == null) {
            synchronized (this) {
                try {
                    if (this.f18478c == null || !"gzip".equals(this.f18479d.get(HttpHeaders.CONTENT_ENCODING))) {
                        this.f18480e = this.f18478c;
                    } else {
                        this.f18480e = new GZIPInputStream(this.f18478c);
                    }
                } finally {
                }
            }
        }
        return this.f18480e;
    }

    public Map c() {
        return this.f18479d;
    }

    public InputStream d() {
        return this.f18478c;
    }

    public int e() {
        return this.f18477b;
    }

    public String f() {
        return this.f18476a;
    }
}

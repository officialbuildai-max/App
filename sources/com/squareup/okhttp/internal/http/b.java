package com.squareup.okhttp.internal.http;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Request f40496a;

    /* renamed from: b, reason: collision with root package name */
    public final Response f40497b;

    /* renamed from: com.squareup.okhttp.internal.http.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0581b {

        /* renamed from: a, reason: collision with root package name */
        final long f40498a;

        /* renamed from: b, reason: collision with root package name */
        final Request f40499b;

        /* renamed from: c, reason: collision with root package name */
        final Response f40500c;

        /* renamed from: d, reason: collision with root package name */
        private Date f40501d;

        /* renamed from: e, reason: collision with root package name */
        private String f40502e;

        /* renamed from: f, reason: collision with root package name */
        private Date f40503f;

        /* renamed from: g, reason: collision with root package name */
        private String f40504g;

        /* renamed from: h, reason: collision with root package name */
        private Date f40505h;

        /* renamed from: i, reason: collision with root package name */
        private long f40506i;

        /* renamed from: j, reason: collision with root package name */
        private long f40507j;

        /* renamed from: k, reason: collision with root package name */
        private String f40508k;

        /* renamed from: l, reason: collision with root package name */
        private int f40509l;

        public C0581b(long j11, Request request, Response response) {
            this.f40509l = -1;
            this.f40498a = j11;
            this.f40499b = request;
            this.f40500c = response;
            if (response != null) {
                Headers headers = response.headers();
                int size = headers.size();
                for (int i11 = 0; i11 < size; i11++) {
                    String name = headers.name(i11);
                    String value = headers.value(i11);
                    if (HttpHeaders.DATE.equalsIgnoreCase(name)) {
                        this.f40501d = f.b(value);
                        this.f40502e = value;
                    } else if (HttpHeaders.EXPIRES.equalsIgnoreCase(name)) {
                        this.f40505h = f.b(value);
                    } else if ("Last-Modified".equalsIgnoreCase(name)) {
                        this.f40503f = f.b(value);
                        this.f40504g = value;
                    } else if ("ETag".equalsIgnoreCase(name)) {
                        this.f40508k = value;
                    } else if ("Age".equalsIgnoreCase(name)) {
                        this.f40509l = c.a(value, -1);
                    } else if (OkHeaders.f40491c.equalsIgnoreCase(name)) {
                        this.f40506i = Long.parseLong(value);
                    } else if (OkHeaders.f40492d.equalsIgnoreCase(name)) {
                        this.f40507j = Long.parseLong(value);
                    }
                }
            }
        }

        private long a() {
            Date date = this.f40501d;
            long max = date != null ? Math.max(0L, this.f40507j - date.getTime()) : 0L;
            int i11 = this.f40509l;
            if (i11 != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(i11));
            }
            long j11 = this.f40507j;
            return max + (j11 - this.f40506i) + (this.f40498a - j11);
        }

        private long b() {
            if (this.f40500c.cacheControl().maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.maxAgeSeconds());
            }
            if (this.f40505h != null) {
                Date date = this.f40501d;
                long time = this.f40505h.getTime() - (date != null ? date.getTime() : this.f40507j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f40503f == null || this.f40500c.request().httpUrl().query() != null) {
                return 0L;
            }
            Date date2 = this.f40501d;
            long time2 = (date2 != null ? date2.getTime() : this.f40506i) - this.f40503f.getTime();
            if (time2 > 0) {
                return time2 / 10;
            }
            return 0L;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private b d() {
            Response response = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            Object[] objArr4 = 0;
            Object[] objArr5 = 0;
            Object[] objArr6 = 0;
            Object[] objArr7 = 0;
            Object[] objArr8 = 0;
            Object[] objArr9 = 0;
            Object[] objArr10 = 0;
            Object[] objArr11 = 0;
            Object[] objArr12 = 0;
            if (this.f40500c == null) {
                return new b(this.f40499b, response);
            }
            if (this.f40499b.isHttps() && this.f40500c.handshake() == null) {
                return new b(this.f40499b, objArr11 == true ? 1 : 0);
            }
            if (!b.a(this.f40500c, this.f40499b)) {
                return new b(this.f40499b, objArr9 == true ? 1 : 0);
            }
            CacheControl cacheControl = this.f40499b.cacheControl();
            if (cacheControl.noCache() || e(this.f40499b)) {
                return new b(this.f40499b, objArr2 == true ? 1 : 0);
            }
            long a11 = a();
            long b11 = b();
            if (cacheControl.maxAgeSeconds() != -1) {
                b11 = Math.min(b11, TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds()));
            }
            long j11 = 0;
            long millis = cacheControl.minFreshSeconds() != -1 ? TimeUnit.SECONDS.toMillis(cacheControl.minFreshSeconds()) : 0L;
            CacheControl cacheControl2 = this.f40500c.cacheControl();
            if (!cacheControl2.mustRevalidate() && cacheControl.maxStaleSeconds() != -1) {
                j11 = TimeUnit.SECONDS.toMillis(cacheControl.maxStaleSeconds());
            }
            if (!cacheControl2.noCache()) {
                long j12 = millis + a11;
                if (j12 < j11 + b11) {
                    Response.Builder newBuilder = this.f40500c.newBuilder();
                    if (j12 >= b11) {
                        newBuilder.addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (a11 > 86400000 && f()) {
                        newBuilder.addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new b(objArr7 == true ? 1 : 0, newBuilder.build());
                }
            }
            Request.Builder newBuilder2 = this.f40499b.newBuilder();
            String str = this.f40508k;
            if (str != null) {
                newBuilder2.header("If-None-Match", str);
            } else if (this.f40503f != null) {
                newBuilder2.header("If-Modified-Since", this.f40504g);
            } else if (this.f40501d != null) {
                newBuilder2.header("If-Modified-Since", this.f40502e);
            }
            Request build = newBuilder2.build();
            return e(build) ? new b(build, this.f40500c) : new b(build, objArr4 == true ? 1 : 0);
        }

        private static boolean e(Request request) {
            return (request.header("If-Modified-Since") == null && request.header("If-None-Match") == null) ? false : true;
        }

        private boolean f() {
            return this.f40500c.cacheControl().maxAgeSeconds() == -1 && this.f40505h == null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b c() {
            b d11 = d();
            return (d11.f40496a == null || !this.f40499b.cacheControl().onlyIfCached()) ? d11 : new b(null, 0 == true ? 1 : 0);
        }
    }

    private b(Request request, Response response) {
        this.f40496a = request;
        this.f40497b = response;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.cacheControl().isPrivate() == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(com.squareup.okhttp.Response r3, com.squareup.okhttp.Request r4) {
        /*
            int r0 = r3.code()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L5a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L5a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L5a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L5a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L5a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L5a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L5a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L5a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L5a
            switch(r0) {
                case 300: goto L5a;
                case 301: goto L5a;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L59
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.header(r0)
            if (r0 != 0) goto L5a
            com.squareup.okhttp.CacheControl r0 = r3.cacheControl()
            int r0 = r0.maxAgeSeconds()
            r1 = -1
            if (r0 != r1) goto L5a
            com.squareup.okhttp.CacheControl r0 = r3.cacheControl()
            boolean r0 = r0.isPublic()
            if (r0 != 0) goto L5a
            com.squareup.okhttp.CacheControl r0 = r3.cacheControl()
            boolean r0 = r0.isPrivate()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            com.squareup.okhttp.CacheControl r3 = r3.cacheControl()
            boolean r3 = r3.noStore()
            if (r3 != 0) goto L6f
            com.squareup.okhttp.CacheControl r3 = r4.cacheControl()
            boolean r3 = r3.noStore()
            if (r3 != 0) goto L6f
            r2 = 1
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.http.b.a(com.squareup.okhttp.Response, com.squareup.okhttp.Request):boolean");
    }
}

package com.mbridge.msdk.thrid.okhttp.internal.cache;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.mbridge.msdk.thrid.okhttp.internal.http.d;
import com.mbridge.msdk.thrid.okhttp.internal.http.e;
import com.mbridge.msdk.thrid.okhttp.p;
import com.mbridge.msdk.thrid.okhttp.w;
import com.mbridge.msdk.thrid.okhttp.y;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final w f37976a;

    /* renamed from: b, reason: collision with root package name */
    public final y f37977b;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final long f37978a;

        /* renamed from: b, reason: collision with root package name */
        final w f37979b;

        /* renamed from: c, reason: collision with root package name */
        final y f37980c;

        /* renamed from: d, reason: collision with root package name */
        private Date f37981d;

        /* renamed from: e, reason: collision with root package name */
        private String f37982e;

        /* renamed from: f, reason: collision with root package name */
        private Date f37983f;

        /* renamed from: g, reason: collision with root package name */
        private String f37984g;

        /* renamed from: h, reason: collision with root package name */
        private Date f37985h;

        /* renamed from: i, reason: collision with root package name */
        private long f37986i;

        /* renamed from: j, reason: collision with root package name */
        private long f37987j;

        /* renamed from: k, reason: collision with root package name */
        private String f37988k;

        /* renamed from: l, reason: collision with root package name */
        private int f37989l;

        public a(long j11, w wVar, y yVar) {
            this.f37989l = -1;
            this.f37978a = j11;
            this.f37979b = wVar;
            this.f37980c = yVar;
            if (yVar != null) {
                this.f37986i = yVar.s();
                this.f37987j = yVar.q();
                p m11 = yVar.m();
                int b11 = m11.b();
                for (int i11 = 0; i11 < b11; i11++) {
                    String a11 = m11.a(i11);
                    String b12 = m11.b(i11);
                    if (HttpHeaders.DATE.equalsIgnoreCase(a11)) {
                        this.f37981d = d.a(b12);
                        this.f37982e = b12;
                    } else if (HttpHeaders.EXPIRES.equalsIgnoreCase(a11)) {
                        this.f37985h = d.a(b12);
                    } else if ("Last-Modified".equalsIgnoreCase(a11)) {
                        this.f37983f = d.a(b12);
                        this.f37984g = b12;
                    } else if ("ETag".equalsIgnoreCase(a11)) {
                        this.f37988k = b12;
                    } else if ("Age".equalsIgnoreCase(a11)) {
                        this.f37989l = e.a(b12, -1);
                    }
                }
            }
        }

        private long a() {
            Date date = this.f37981d;
            long max = date != null ? Math.max(0L, this.f37987j - date.getTime()) : 0L;
            int i11 = this.f37989l;
            if (i11 != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(i11));
            }
            long j11 = this.f37987j;
            return max + (j11 - this.f37986i) + (this.f37978a - j11);
        }

        private static boolean a(w wVar) {
            return (wVar.a("If-Modified-Since") == null && wVar.a("If-None-Match") == null) ? false : true;
        }

        private long b() {
            if (this.f37980c.h().d() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.d());
            }
            if (this.f37985h != null) {
                Date date = this.f37981d;
                long time = this.f37985h.getTime() - (date != null ? date.getTime() : this.f37987j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f37983f == null || this.f37980c.r().g().k() != null) {
                return 0L;
            }
            Date date2 = this.f37981d;
            long time2 = (date2 != null ? date2.getTime() : this.f37986i) - this.f37983f.getTime();
            if (time2 > 0) {
                return time2 / 10;
            }
            return 0L;
        }

        private b d() {
            String str;
            if (this.f37980c == null) {
                return new b(this.f37979b, null);
            }
            if ((!this.f37979b.d() || this.f37980c.l() != null) && b.a(this.f37980c, this.f37979b)) {
                com.mbridge.msdk.thrid.okhttp.c b11 = this.f37979b.b();
                if (b11.h() || a(this.f37979b)) {
                    return new b(this.f37979b, null);
                }
                com.mbridge.msdk.thrid.okhttp.c h11 = this.f37980c.h();
                long a11 = a();
                long b12 = b();
                if (b11.d() != -1) {
                    b12 = Math.min(b12, TimeUnit.SECONDS.toMillis(b11.d()));
                }
                long j11 = 0;
                long millis = b11.f() != -1 ? TimeUnit.SECONDS.toMillis(b11.f()) : 0L;
                if (!h11.g() && b11.e() != -1) {
                    j11 = TimeUnit.SECONDS.toMillis(b11.e());
                }
                if (!h11.h()) {
                    long j12 = millis + a11;
                    if (j12 < j11 + b12) {
                        y.a o11 = this.f37980c.o();
                        if (j12 >= b12) {
                            o11.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (a11 > 86400000 && e()) {
                            o11.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new b(null, o11.a());
                    }
                }
                String str2 = this.f37988k;
                if (str2 != null) {
                    str = "If-None-Match";
                } else {
                    if (this.f37983f != null) {
                        str2 = this.f37984g;
                    } else {
                        if (this.f37981d == null) {
                            return new b(this.f37979b, null);
                        }
                        str2 = this.f37982e;
                    }
                    str = "If-Modified-Since";
                }
                p.a a12 = this.f37979b.c().a();
                com.mbridge.msdk.thrid.okhttp.internal.a.f37953a.a(a12, str, str2);
                return new b(this.f37979b.f().a(a12.a()).a(), this.f37980c);
            }
            return new b(this.f37979b, null);
        }

        private boolean e() {
            return this.f37980c.h().d() == -1 && this.f37985h == null;
        }

        public b c() {
            b d11 = d();
            return (d11.f37976a == null || !this.f37979b.b().j()) ? d11 : new b(null, null);
        }
    }

    b(w wVar, y yVar) {
        this.f37976a = wVar;
        this.f37977b = yVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.h().b() == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(com.mbridge.msdk.thrid.okhttp.y r3, com.mbridge.msdk.thrid.okhttp.w r4) {
        /*
            int r0 = r3.k()
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
            java.lang.String r0 = r3.b(r0)
            if (r0 != 0) goto L5a
            com.mbridge.msdk.thrid.okhttp.c r0 = r3.h()
            int r0 = r0.d()
            r1 = -1
            if (r0 != r1) goto L5a
            com.mbridge.msdk.thrid.okhttp.c r0 = r3.h()
            boolean r0 = r0.c()
            if (r0 != 0) goto L5a
            com.mbridge.msdk.thrid.okhttp.c r0 = r3.h()
            boolean r0 = r0.b()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            com.mbridge.msdk.thrid.okhttp.c r3 = r3.h()
            boolean r3 = r3.i()
            if (r3 != 0) goto L6f
            com.mbridge.msdk.thrid.okhttp.c r3 = r4.b()
            boolean r3 = r3.i()
            if (r3 != 0) goto L6f
            r2 = 1
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.cache.b.a(com.mbridge.msdk.thrid.okhttp.y, com.mbridge.msdk.thrid.okhttp.w):boolean");
    }
}

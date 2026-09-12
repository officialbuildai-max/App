package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.m1;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f27491a;

    /* renamed from: b, reason: collision with root package name */
    public final long f27492b;

    /* renamed from: c, reason: collision with root package name */
    public final int f27493c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f27494d;

    /* renamed from: e, reason: collision with root package name */
    public final Map f27495e;

    /* renamed from: f, reason: collision with root package name */
    public final long f27496f;

    /* renamed from: g, reason: collision with root package name */
    public final long f27497g;

    /* renamed from: h, reason: collision with root package name */
    public final long f27498h;

    /* renamed from: i, reason: collision with root package name */
    public final String f27499i;

    /* renamed from: j, reason: collision with root package name */
    public final int f27500j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f27501k;

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private Uri f27502a;

        /* renamed from: b, reason: collision with root package name */
        private long f27503b;

        /* renamed from: c, reason: collision with root package name */
        private int f27504c;

        /* renamed from: d, reason: collision with root package name */
        private byte[] f27505d;

        /* renamed from: e, reason: collision with root package name */
        private Map f27506e;

        /* renamed from: f, reason: collision with root package name */
        private long f27507f;

        /* renamed from: g, reason: collision with root package name */
        private long f27508g;

        /* renamed from: h, reason: collision with root package name */
        private String f27509h;

        /* renamed from: i, reason: collision with root package name */
        private int f27510i;

        /* renamed from: j, reason: collision with root package name */
        private Object f27511j;

        public b() {
            this.f27504c = 1;
            this.f27506e = Collections.emptyMap();
            this.f27508g = -1L;
        }

        private b(n nVar) {
            this.f27502a = nVar.f27491a;
            this.f27503b = nVar.f27492b;
            this.f27504c = nVar.f27493c;
            this.f27505d = nVar.f27494d;
            this.f27506e = nVar.f27495e;
            this.f27507f = nVar.f27497g;
            this.f27508g = nVar.f27498h;
            this.f27509h = nVar.f27499i;
            this.f27510i = nVar.f27500j;
            this.f27511j = nVar.f27501k;
        }

        public n a() {
            com.google.android.exoplayer2.util.a.j(this.f27502a, "The uri must be set.");
            return new n(this.f27502a, this.f27503b, this.f27504c, this.f27505d, this.f27506e, this.f27507f, this.f27508g, this.f27509h, this.f27510i, this.f27511j);
        }

        public b b(int i11) {
            this.f27510i = i11;
            return this;
        }

        public b c(byte[] bArr) {
            this.f27505d = bArr;
            return this;
        }

        public b d(int i11) {
            this.f27504c = i11;
            return this;
        }

        public b e(Map map) {
            this.f27506e = map;
            return this;
        }

        public b f(String str) {
            this.f27509h = str;
            return this;
        }

        public b g(long j11) {
            this.f27508g = j11;
            return this;
        }

        public b h(long j11) {
            this.f27507f = j11;
            return this;
        }

        public b i(Uri uri) {
            this.f27502a = uri;
            return this;
        }

        public b j(String str) {
            this.f27502a = Uri.parse(str);
            return this;
        }

        public b k(long j11) {
            this.f27503b = j11;
            return this;
        }
    }

    static {
        m1.a("goog.exo.datasource");
    }

    public n(Uri uri) {
        this(uri, 0L, -1L);
    }

    private n(Uri uri, long j11, int i11, byte[] bArr, Map map, long j12, long j13, String str, int i12, Object obj) {
        byte[] bArr2 = bArr;
        long j14 = j11 + j12;
        com.google.android.exoplayer2.util.a.a(j14 >= 0);
        com.google.android.exoplayer2.util.a.a(j12 >= 0);
        com.google.android.exoplayer2.util.a.a(j13 > 0 || j13 == -1);
        this.f27491a = uri;
        this.f27492b = j11;
        this.f27493c = i11;
        this.f27494d = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.f27495e = Collections.unmodifiableMap(new HashMap(map));
        this.f27497g = j12;
        this.f27496f = j14;
        this.f27498h = j13;
        this.f27499i = str;
        this.f27500j = i12;
        this.f27501k = obj;
    }

    public n(Uri uri, long j11, long j12) {
        this(uri, 0L, 1, null, Collections.emptyMap(), j11, j12, null, 0, null);
    }

    public static String c(int i11) {
        if (i11 == 1) {
            return "GET";
        }
        if (i11 == 2) {
            return "POST";
        }
        if (i11 == 3) {
            return "HEAD";
        }
        throw new IllegalStateException();
    }

    public b a() {
        return new b();
    }

    public final String b() {
        return c(this.f27493c);
    }

    public boolean d(int i11) {
        return (this.f27500j & i11) == i11;
    }

    public n e(long j11) {
        long j12 = this.f27498h;
        return f(j11, j12 != -1 ? j12 - j11 : -1L);
    }

    public n f(long j11, long j12) {
        return (j11 == 0 && this.f27498h == j12) ? this : new n(this.f27491a, this.f27492b, this.f27493c, this.f27494d, this.f27495e, this.f27497g + j11, j12, this.f27499i, this.f27500j, this.f27501k);
    }

    public String toString() {
        return "DataSpec[" + b() + " " + this.f27491a + ", " + this.f27497g + ", " + this.f27498h + ", " + this.f27499i + ", " + this.f27500j + "]";
    }
}

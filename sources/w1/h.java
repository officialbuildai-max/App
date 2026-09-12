package w1;

import android.net.Uri;
import androidx.media3.common.u;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f77634a;

    /* renamed from: b, reason: collision with root package name */
    public final long f77635b;

    /* renamed from: c, reason: collision with root package name */
    public final int f77636c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f77637d;

    /* renamed from: e, reason: collision with root package name */
    public final Map f77638e;

    /* renamed from: f, reason: collision with root package name */
    public final long f77639f;

    /* renamed from: g, reason: collision with root package name */
    public final long f77640g;

    /* renamed from: h, reason: collision with root package name */
    public final long f77641h;

    /* renamed from: i, reason: collision with root package name */
    public final String f77642i;

    /* renamed from: j, reason: collision with root package name */
    public final int f77643j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f77644k;

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private Uri f77645a;

        /* renamed from: b, reason: collision with root package name */
        private long f77646b;

        /* renamed from: c, reason: collision with root package name */
        private int f77647c;

        /* renamed from: d, reason: collision with root package name */
        private byte[] f77648d;

        /* renamed from: e, reason: collision with root package name */
        private Map f77649e;

        /* renamed from: f, reason: collision with root package name */
        private long f77650f;

        /* renamed from: g, reason: collision with root package name */
        private long f77651g;

        /* renamed from: h, reason: collision with root package name */
        private String f77652h;

        /* renamed from: i, reason: collision with root package name */
        private int f77653i;

        /* renamed from: j, reason: collision with root package name */
        private Object f77654j;

        public b() {
            this.f77647c = 1;
            this.f77649e = Collections.emptyMap();
            this.f77651g = -1L;
        }

        private b(h hVar) {
            this.f77645a = hVar.f77634a;
            this.f77646b = hVar.f77635b;
            this.f77647c = hVar.f77636c;
            this.f77648d = hVar.f77637d;
            this.f77649e = hVar.f77638e;
            this.f77650f = hVar.f77640g;
            this.f77651g = hVar.f77641h;
            this.f77652h = hVar.f77642i;
            this.f77653i = hVar.f77643j;
            this.f77654j = hVar.f77644k;
        }

        public h a() {
            androidx.media3.common.util.a.j(this.f77645a, "The uri must be set.");
            return new h(this.f77645a, this.f77646b, this.f77647c, this.f77648d, this.f77649e, this.f77650f, this.f77651g, this.f77652h, this.f77653i, this.f77654j);
        }

        public b b(int i11) {
            this.f77653i = i11;
            return this;
        }

        public b c(byte[] bArr) {
            this.f77648d = bArr;
            return this;
        }

        public b d(int i11) {
            this.f77647c = i11;
            return this;
        }

        public b e(Map map) {
            this.f77649e = map;
            return this;
        }

        public b f(String str) {
            this.f77652h = str;
            return this;
        }

        public b g(long j11) {
            this.f77651g = j11;
            return this;
        }

        public b h(long j11) {
            this.f77650f = j11;
            return this;
        }

        public b i(Uri uri) {
            this.f77645a = uri;
            return this;
        }

        public b j(String str) {
            this.f77645a = Uri.parse(str);
            return this;
        }

        public b k(long j11) {
            this.f77646b = j11;
            return this;
        }
    }

    static {
        u.a("media3.datasource");
    }

    private h(Uri uri, long j11, int i11, byte[] bArr, Map map, long j12, long j13, String str, int i12, Object obj) {
        byte[] bArr2 = bArr;
        long j14 = j11 + j12;
        androidx.media3.common.util.a.a(j14 >= 0);
        androidx.media3.common.util.a.a(j12 >= 0);
        androidx.media3.common.util.a.a(j13 > 0 || j13 == -1);
        this.f77634a = (Uri) androidx.media3.common.util.a.e(uri);
        this.f77635b = j11;
        this.f77636c = i11;
        this.f77637d = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.f77638e = Collections.unmodifiableMap(new HashMap(map));
        this.f77640g = j12;
        this.f77639f = j14;
        this.f77641h = j13;
        this.f77642i = str;
        this.f77643j = i12;
        this.f77644k = obj;
    }

    public h(Uri uri, long j11, long j12) {
        this(uri, j11, j12, null);
    }

    public h(Uri uri, long j11, long j12, String str) {
        this(uri, 0L, 1, null, Collections.emptyMap(), j11, j12, str, 0, null);
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
        return c(this.f77636c);
    }

    public boolean d(int i11) {
        return (this.f77643j & i11) == i11;
    }

    public h e(long j11) {
        long j12 = this.f77641h;
        return f(j11, j12 != -1 ? j12 - j11 : -1L);
    }

    public h f(long j11, long j12) {
        return (j11 == 0 && this.f77641h == j12) ? this : new h(this.f77634a, this.f77635b, this.f77636c, this.f77637d, this.f77638e, this.f77640g + j11, j12, this.f77642i, this.f77643j, this.f77644k);
    }

    public h g(Uri uri) {
        return new h(uri, this.f77635b, this.f77636c, this.f77637d, this.f77638e, this.f77640g, this.f77641h, this.f77642i, this.f77643j, this.f77644k);
    }

    public String toString() {
        return "DataSpec[" + b() + " " + this.f77634a + ", " + this.f77640g + ", " + this.f77641h + ", " + this.f77642i + ", " + this.f77643j + "]";
    }
}

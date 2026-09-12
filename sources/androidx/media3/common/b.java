package androidx.media3.common;

import android.net.Uri;
import androidx.media3.common.t;
import androidx.media3.common.util.a1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: g, reason: collision with root package name */
    public static final b f9955g = new b(null, new a[0], 0, C.TIME_UNSET, 0);

    /* renamed from: h, reason: collision with root package name */
    private static final a f9956h = new a(0).h(0);

    /* renamed from: i, reason: collision with root package name */
    private static final String f9957i = a1.C0(1);

    /* renamed from: j, reason: collision with root package name */
    private static final String f9958j = a1.C0(2);

    /* renamed from: k, reason: collision with root package name */
    private static final String f9959k = a1.C0(3);

    /* renamed from: l, reason: collision with root package name */
    private static final String f9960l = a1.C0(4);

    /* renamed from: a, reason: collision with root package name */
    public final Object f9961a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9962b;

    /* renamed from: c, reason: collision with root package name */
    public final long f9963c;

    /* renamed from: d, reason: collision with root package name */
    public final long f9964d;

    /* renamed from: e, reason: collision with root package name */
    public final int f9965e;

    /* renamed from: f, reason: collision with root package name */
    private final a[] f9966f;

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: l, reason: collision with root package name */
        private static final String f9967l = a1.C0(0);

        /* renamed from: m, reason: collision with root package name */
        private static final String f9968m = a1.C0(1);

        /* renamed from: n, reason: collision with root package name */
        private static final String f9969n = a1.C0(2);

        /* renamed from: o, reason: collision with root package name */
        private static final String f9970o = a1.C0(3);

        /* renamed from: p, reason: collision with root package name */
        private static final String f9971p = a1.C0(4);

        /* renamed from: q, reason: collision with root package name */
        private static final String f9972q = a1.C0(5);

        /* renamed from: r, reason: collision with root package name */
        private static final String f9973r = a1.C0(6);

        /* renamed from: s, reason: collision with root package name */
        private static final String f9974s = a1.C0(7);

        /* renamed from: t, reason: collision with root package name */
        static final String f9975t = a1.C0(8);

        /* renamed from: u, reason: collision with root package name */
        static final String f9976u = a1.C0(9);

        /* renamed from: v, reason: collision with root package name */
        static final String f9977v = a1.C0(10);

        /* renamed from: a, reason: collision with root package name */
        public final long f9978a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9979b;

        /* renamed from: c, reason: collision with root package name */
        public final int f9980c;

        /* renamed from: d, reason: collision with root package name */
        public final Uri[] f9981d;

        /* renamed from: e, reason: collision with root package name */
        public final t[] f9982e;

        /* renamed from: f, reason: collision with root package name */
        public final int[] f9983f;

        /* renamed from: g, reason: collision with root package name */
        public final long[] f9984g;

        /* renamed from: h, reason: collision with root package name */
        public final String[] f9985h;

        /* renamed from: i, reason: collision with root package name */
        public final long f9986i;

        /* renamed from: j, reason: collision with root package name */
        public final boolean f9987j;

        /* renamed from: k, reason: collision with root package name */
        public final boolean f9988k;

        public a(long j11) {
            this(j11, -1, -1, new int[0], new t[0], new long[0], 0L, false, new String[0], false);
        }

        private a(long j11, int i11, int i12, int[] iArr, t[] tVarArr, long[] jArr, long j12, boolean z10, String[] strArr, boolean z11) {
            int i13 = 0;
            androidx.media3.common.util.a.a(iArr.length == tVarArr.length);
            this.f9978a = j11;
            this.f9979b = i11;
            this.f9980c = i12;
            this.f9983f = iArr;
            this.f9982e = tVarArr;
            this.f9984g = jArr;
            this.f9986i = j12;
            this.f9987j = z10;
            this.f9981d = new Uri[tVarArr.length];
            while (true) {
                Uri[] uriArr = this.f9981d;
                if (i13 >= uriArr.length) {
                    this.f9985h = strArr;
                    this.f9988k = z11;
                    return;
                } else {
                    t tVar = tVarArr[i13];
                    uriArr[i13] = tVar == null ? null : ((t.h) androidx.media3.common.util.a.e(tVar.f10293b)).f10385a;
                    i13++;
                }
            }
        }

        private static long[] a(long[] jArr, int i11) {
            int length = jArr.length;
            int max = Math.max(i11, length);
            long[] copyOf = Arrays.copyOf(jArr, max);
            Arrays.fill(copyOf, length, max, C.TIME_UNSET);
            return copyOf;
        }

        private static int[] b(int[] iArr, int i11) {
            int length = iArr.length;
            int max = Math.max(i11, length);
            int[] copyOf = Arrays.copyOf(iArr, max);
            Arrays.fill(copyOf, length, max, 0);
            return copyOf;
        }

        public int c() {
            return d(-1);
        }

        public int d(int i11) {
            int i12;
            int i13 = i11 + 1;
            while (true) {
                int[] iArr = this.f9983f;
                if (i13 >= iArr.length || this.f9987j || (i12 = iArr[i13]) == 0 || i12 == 1) {
                    break;
                }
                i13++;
            }
            return i13;
        }

        public boolean e() {
            if (this.f9979b == -1) {
                return true;
            }
            for (int i11 = 0; i11 < this.f9979b; i11++) {
                int i12 = this.f9983f[i11];
                if (i12 == 0 || i12 == 1) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f9978a == aVar.f9978a && this.f9979b == aVar.f9979b && this.f9980c == aVar.f9980c && Arrays.equals(this.f9982e, aVar.f9982e) && Arrays.equals(this.f9983f, aVar.f9983f) && Arrays.equals(this.f9984g, aVar.f9984g) && this.f9986i == aVar.f9986i && this.f9987j == aVar.f9987j && Arrays.equals(this.f9985h, aVar.f9985h) && this.f9988k == aVar.f9988k;
        }

        public boolean f() {
            return this.f9988k && this.f9978a == Long.MIN_VALUE && this.f9979b == -1;
        }

        public boolean g() {
            return this.f9979b == -1 || c() < this.f9979b;
        }

        public a h(int i11) {
            int[] b11 = b(this.f9983f, i11);
            long[] a11 = a(this.f9984g, i11);
            return new a(this.f9978a, i11, this.f9980c, b11, (t[]) Arrays.copyOf(this.f9982e, i11), a11, this.f9986i, this.f9987j, (String[]) Arrays.copyOf(this.f9985h, i11), this.f9988k);
        }

        public int hashCode() {
            int i11 = ((this.f9979b * 31) + this.f9980c) * 31;
            long j11 = this.f9978a;
            int hashCode = (((((((i11 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + Arrays.hashCode(this.f9982e)) * 31) + Arrays.hashCode(this.f9983f)) * 31) + Arrays.hashCode(this.f9984g)) * 31;
            long j12 = this.f9986i;
            return ((((((hashCode + ((int) (j12 ^ (j12 >>> 32)))) * 31) + (this.f9987j ? 1 : 0)) * 31) + Arrays.hashCode(this.f9985h)) * 31) + (this.f9988k ? 1 : 0);
        }
    }

    private b(Object obj, a[] aVarArr, long j11, long j12, int i11) {
        this.f9961a = obj;
        this.f9963c = j11;
        this.f9964d = j12;
        this.f9962b = aVarArr.length + i11;
        this.f9966f = aVarArr;
        this.f9965e = i11;
    }

    private boolean e(long j11, long j12, int i11) {
        if (j11 == Long.MIN_VALUE) {
            return false;
        }
        a a11 = a(i11);
        long j13 = a11.f9978a;
        return j13 == Long.MIN_VALUE ? j12 == C.TIME_UNSET || a11.f() || j11 < j12 : j11 < j13;
    }

    public a a(int i11) {
        int i12 = this.f9965e;
        return i11 < i12 ? f9956h : this.f9966f[i11 - i12];
    }

    public int b(long j11, long j12) {
        if (j11 == Long.MIN_VALUE) {
            return -1;
        }
        if (j12 != C.TIME_UNSET && j11 >= j12) {
            return -1;
        }
        int i11 = this.f9965e;
        while (i11 < this.f9962b && ((a(i11).f9978a != Long.MIN_VALUE && a(i11).f9978a <= j11) || !a(i11).g())) {
            i11++;
        }
        if (i11 < this.f9962b) {
            return i11;
        }
        return -1;
    }

    public int c(long j11, long j12) {
        int i11 = this.f9962b - 1;
        int i12 = i11 - (d(i11) ? 1 : 0);
        while (i12 >= 0 && e(j11, j12, i12)) {
            i12--;
        }
        if (i12 < 0 || !a(i12).e()) {
            return -1;
        }
        return i12;
    }

    public boolean d(int i11) {
        return i11 == this.f9962b - 1 && a(i11).f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return Objects.equals(this.f9961a, bVar.f9961a) && this.f9962b == bVar.f9962b && this.f9963c == bVar.f9963c && this.f9964d == bVar.f9964d && this.f9965e == bVar.f9965e && Arrays.equals(this.f9966f, bVar.f9966f);
    }

    public int hashCode() {
        int i11 = this.f9962b * 31;
        Object obj = this.f9961a;
        return ((((((((i11 + (obj == null ? 0 : obj.hashCode())) * 31) + ((int) this.f9963c)) * 31) + ((int) this.f9964d)) * 31) + this.f9965e) * 31) + Arrays.hashCode(this.f9966f);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("AdPlaybackState(adsId=");
        sb2.append(this.f9961a);
        sb2.append(", adResumePositionUs=");
        sb2.append(this.f9963c);
        sb2.append(", adGroups=[");
        for (int i11 = 0; i11 < this.f9966f.length; i11++) {
            sb2.append("adGroup(timeUs=");
            sb2.append(this.f9966f[i11].f9978a);
            sb2.append(", ads=[");
            for (int i12 = 0; i12 < this.f9966f[i11].f9983f.length; i12++) {
                sb2.append("ad(state=");
                int i13 = this.f9966f[i11].f9983f[i12];
                if (i13 == 0) {
                    sb2.append('_');
                } else if (i13 == 1) {
                    sb2.append('R');
                } else if (i13 == 2) {
                    sb2.append('S');
                } else if (i13 == 3) {
                    sb2.append('P');
                } else if (i13 != 4) {
                    sb2.append('?');
                } else {
                    sb2.append('!');
                }
                sb2.append(", durationUs=");
                sb2.append(this.f9966f[i11].f9984g[i12]);
                sb2.append(')');
                if (i12 < this.f9966f[i11].f9983f.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("])");
            if (i11 < this.f9966f.length - 1) {
                sb2.append(", ");
            }
        }
        sb2.append("])");
        return sb2.toString();
    }
}

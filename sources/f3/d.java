package f3;

import androidx.media3.common.util.a1;

/* loaded from: classes2.dex */
abstract class d {

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final long[] f62315a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f62316b;

        /* renamed from: c, reason: collision with root package name */
        public final int f62317c;

        /* renamed from: d, reason: collision with root package name */
        public final long[] f62318d;

        /* renamed from: e, reason: collision with root package name */
        public final int[] f62319e;

        /* renamed from: f, reason: collision with root package name */
        public final long f62320f;

        /* renamed from: g, reason: collision with root package name */
        public final long f62321g;

        private b(long[] jArr, int[] iArr, int i11, long[] jArr2, int[] iArr2, long j11, long j12) {
            this.f62315a = jArr;
            this.f62316b = iArr;
            this.f62317c = i11;
            this.f62318d = jArr2;
            this.f62319e = iArr2;
            this.f62320f = j11;
            this.f62321g = j12;
        }
    }

    public static b a(int i11, long[] jArr, int[] iArr, long j11) {
        int[] iArr2 = iArr;
        int i12 = 8192 / i11;
        int i13 = 0;
        int i14 = 0;
        for (int i15 : iArr2) {
            i14 += a1.k(i15, i12);
        }
        long[] jArr2 = new long[i14];
        int[] iArr3 = new int[i14];
        long[] jArr3 = new long[i14];
        int[] iArr4 = new int[i14];
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (i13 < iArr2.length) {
            int i20 = iArr2[i13];
            long j12 = jArr[i13];
            while (i20 > 0) {
                int min = Math.min(i12, i20);
                jArr2[i18] = j12;
                int i21 = i11 * min;
                iArr3[i18] = i21;
                i17 += i21;
                i19 = Math.max(i19, i21);
                jArr3[i18] = i16 * j11;
                iArr4[i18] = 1;
                j12 += iArr3[i18];
                i16 += min;
                i20 -= min;
                i18++;
                i12 = i12;
            }
            i13++;
            iArr2 = iArr;
        }
        return new b(jArr2, iArr3, i19, jArr3, iArr4, j11 * i16, i17);
    }
}

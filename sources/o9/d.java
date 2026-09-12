package o9;

import com.google.android.exoplayer2.util.p0;

/* loaded from: classes4.dex */
abstract class d {

    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final long[] f70908a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f70909b;

        /* renamed from: c, reason: collision with root package name */
        public final int f70910c;

        /* renamed from: d, reason: collision with root package name */
        public final long[] f70911d;

        /* renamed from: e, reason: collision with root package name */
        public final int[] f70912e;

        /* renamed from: f, reason: collision with root package name */
        public final long f70913f;

        private b(long[] jArr, int[] iArr, int i11, long[] jArr2, int[] iArr2, long j11) {
            this.f70908a = jArr;
            this.f70909b = iArr;
            this.f70910c = i11;
            this.f70911d = jArr2;
            this.f70912e = iArr2;
            this.f70913f = j11;
        }
    }

    public static b a(int i11, long[] jArr, int[] iArr, long j11) {
        int i12 = 8192 / i11;
        int i13 = 0;
        for (int i14 : iArr) {
            i13 += p0.l(i14, i12);
        }
        long[] jArr2 = new long[i13];
        int[] iArr2 = new int[i13];
        long[] jArr3 = new long[i13];
        int[] iArr3 = new int[i13];
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < iArr.length; i18++) {
            int i19 = iArr[i18];
            long j12 = jArr[i18];
            while (i19 > 0) {
                int min = Math.min(i12, i19);
                jArr2[i16] = j12;
                int i20 = i11 * min;
                iArr2[i16] = i20;
                i17 = Math.max(i17, i20);
                jArr3[i16] = i15 * j11;
                iArr3[i16] = 1;
                j12 += iArr2[i16];
                i15 += min;
                i19 -= min;
                i16++;
            }
        }
        return new b(jArr2, iArr2, i17, jArr3, iArr3, j11 * i15);
    }
}

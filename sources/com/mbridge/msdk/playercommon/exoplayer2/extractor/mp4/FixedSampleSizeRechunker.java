package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4;

import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

/* loaded from: classes5.dex */
final class FixedSampleSizeRechunker {
    private static final int MAX_SAMPLE_SIZE = 8192;

    /* loaded from: classes5.dex */
    public static final class Results {
        public final long duration;
        public final int[] flags;
        public final int maximumSize;
        public final long[] offsets;
        public final int[] sizes;
        public final long[] timestamps;

        private Results(long[] jArr, int[] iArr, int i11, long[] jArr2, int[] iArr2, long j11) {
            this.offsets = jArr;
            this.sizes = iArr;
            this.maximumSize = i11;
            this.timestamps = jArr2;
            this.flags = iArr2;
            this.duration = j11;
        }
    }

    private FixedSampleSizeRechunker() {
    }

    public static Results rechunk(int i11, long[] jArr, int[] iArr, long j11) {
        int i12 = 8192 / i11;
        int i13 = 0;
        for (int i14 : iArr) {
            i13 += Util.ceilDivide(i14, i12);
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
        return new Results(jArr2, iArr2, i17, jArr3, iArr3, j11 * i15);
    }
}

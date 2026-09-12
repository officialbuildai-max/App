package m9;

import g9.m;

/* loaded from: classes4.dex */
final class g {

    /* renamed from: d, reason: collision with root package name */
    private static final long[] f69544d = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f69545a = new byte[8];

    /* renamed from: b, reason: collision with root package name */
    private int f69546b;

    /* renamed from: c, reason: collision with root package name */
    private int f69547c;

    public static long a(byte[] bArr, int i11, boolean z10) {
        long j11 = bArr[0] & 255;
        if (z10) {
            j11 &= ~f69544d[i11 - 1];
        }
        for (int i12 = 1; i12 < i11; i12++) {
            j11 = (j11 << 8) | (bArr[i12] & 255);
        }
        return j11;
    }

    public static int c(int i11) {
        int i12 = 0;
        while (true) {
            long[] jArr = f69544d;
            if (i12 >= jArr.length) {
                return -1;
            }
            if ((jArr[i12] & i11) != 0) {
                return i12 + 1;
            }
            i12++;
        }
    }

    public int b() {
        return this.f69547c;
    }

    public long d(m mVar, boolean z10, boolean z11, int i11) {
        if (this.f69546b == 0) {
            if (!mVar.readFully(this.f69545a, 0, 1, z10)) {
                return -1L;
            }
            int c11 = c(this.f69545a[0] & 255);
            this.f69547c = c11;
            if (c11 == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.f69546b = 1;
        }
        int i12 = this.f69547c;
        if (i12 > i11) {
            this.f69546b = 0;
            return -2L;
        }
        if (i12 != 1) {
            mVar.readFully(this.f69545a, 1, i12 - 1);
        }
        this.f69546b = 0;
        return a(this.f69545a, this.f69547c, z11);
    }

    public void e() {
        this.f69546b = 0;
        this.f69547c = 0;
    }
}

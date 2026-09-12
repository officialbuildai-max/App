package d3;

import l2.s;

/* loaded from: classes2.dex */
final class g {

    /* renamed from: d, reason: collision with root package name */
    private static final long[] f61346d = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f61347a = new byte[8];

    /* renamed from: b, reason: collision with root package name */
    private int f61348b;

    /* renamed from: c, reason: collision with root package name */
    private int f61349c;

    public static long a(byte[] bArr, int i11, boolean z10) {
        long j11 = bArr[0] & 255;
        if (z10) {
            j11 &= ~f61346d[i11 - 1];
        }
        for (int i12 = 1; i12 < i11; i12++) {
            j11 = (j11 << 8) | (bArr[i12] & 255);
        }
        return j11;
    }

    public static int c(int i11) {
        int i12 = 0;
        while (true) {
            long[] jArr = f61346d;
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
        return this.f61349c;
    }

    public long d(s sVar, boolean z10, boolean z11, int i11) {
        if (this.f61348b == 0) {
            if (!sVar.readFully(this.f61347a, 0, 1, z10)) {
                return -1L;
            }
            int c11 = c(this.f61347a[0] & 255);
            this.f61349c = c11;
            if (c11 == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.f61348b = 1;
        }
        int i12 = this.f61349c;
        if (i12 > i11) {
            this.f61348b = 0;
            return -2L;
        }
        if (i12 != 1) {
            sVar.readFully(this.f61347a, 1, i12 - 1);
        }
        this.f61348b = 0;
        return a(this.f61347a, this.f61349c, z11);
    }

    public void e() {
        this.f61348b = 0;
        this.f61349c = 0;
    }
}

package androidx.media3.common.util;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    private int f10547a;

    /* renamed from: b, reason: collision with root package name */
    private long[] f10548b;

    public v() {
        this(32);
    }

    public v(int i11) {
        this.f10548b = new long[i11];
    }

    public void a(long j11) {
        int i11 = this.f10547a;
        long[] jArr = this.f10548b;
        if (i11 == jArr.length) {
            this.f10548b = Arrays.copyOf(jArr, i11 * 2);
        }
        long[] jArr2 = this.f10548b;
        int i12 = this.f10547a;
        this.f10547a = i12 + 1;
        jArr2[i12] = j11;
    }

    public void b(long[] jArr) {
        int length = this.f10547a + jArr.length;
        long[] jArr2 = this.f10548b;
        if (length > jArr2.length) {
            this.f10548b = Arrays.copyOf(jArr2, Math.max(jArr2.length * 2, length));
        }
        System.arraycopy(jArr, 0, this.f10548b, this.f10547a, jArr.length);
        this.f10547a = length;
    }

    public long c(int i11) {
        if (i11 >= 0 && i11 < this.f10547a) {
            return this.f10548b[i11];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i11 + ", size is " + this.f10547a);
    }

    public int d() {
        return this.f10547a;
    }
}

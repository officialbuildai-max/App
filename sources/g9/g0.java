package g9;

/* loaded from: classes4.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f63531a;

    /* renamed from: b, reason: collision with root package name */
    private final int f63532b;

    /* renamed from: c, reason: collision with root package name */
    private int f63533c;

    /* renamed from: d, reason: collision with root package name */
    private int f63534d;

    public g0(byte[] bArr) {
        this.f63531a = bArr;
        this.f63532b = bArr.length;
    }

    private void a() {
        int i11;
        int i12 = this.f63533c;
        com.google.android.exoplayer2.util.a.g(i12 >= 0 && (i12 < (i11 = this.f63532b) || (i12 == i11 && this.f63534d == 0)));
    }

    public int b() {
        return (this.f63533c * 8) + this.f63534d;
    }

    public boolean c() {
        boolean z10 = (((this.f63531a[this.f63533c] & 255) >> this.f63534d) & 1) == 1;
        e(1);
        return z10;
    }

    public int d(int i11) {
        int i12 = this.f63533c;
        int min = Math.min(i11, 8 - this.f63534d);
        int i13 = i12 + 1;
        int i14 = ((this.f63531a[i12] & 255) >> this.f63534d) & (255 >> (8 - min));
        while (min < i11) {
            i14 |= (this.f63531a[i13] & 255) << min;
            min += 8;
            i13++;
        }
        int i15 = i14 & ((-1) >>> (32 - i11));
        e(i11);
        return i15;
    }

    public void e(int i11) {
        int i12 = i11 / 8;
        int i13 = this.f63533c + i12;
        this.f63533c = i13;
        int i14 = this.f63534d + (i11 - (i12 * 8));
        this.f63534d = i14;
        if (i14 > 7) {
            this.f63533c = i13 + 1;
            this.f63534d = i14 - 8;
        }
        a();
    }
}

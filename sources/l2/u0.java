package l2;

/* loaded from: classes2.dex */
public final class u0 {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f68814a;

    /* renamed from: b, reason: collision with root package name */
    private final int f68815b;

    /* renamed from: c, reason: collision with root package name */
    private int f68816c;

    /* renamed from: d, reason: collision with root package name */
    private int f68817d;

    public u0(byte[] bArr) {
        this.f68814a = bArr;
        this.f68815b = bArr.length;
    }

    private void a() {
        int i11;
        int i12 = this.f68816c;
        androidx.media3.common.util.a.g(i12 >= 0 && (i12 < (i11 = this.f68815b) || (i12 == i11 && this.f68817d == 0)));
    }

    public int b() {
        return (this.f68816c * 8) + this.f68817d;
    }

    public boolean c() {
        boolean z10 = (((this.f68814a[this.f68816c] & 255) >> this.f68817d) & 1) == 1;
        e(1);
        return z10;
    }

    public int d(int i11) {
        int i12 = this.f68816c;
        int min = Math.min(i11, 8 - this.f68817d);
        int i13 = i12 + 1;
        int i14 = ((this.f68814a[i12] & 255) >> this.f68817d) & (255 >> (8 - min));
        while (min < i11) {
            i14 |= (this.f68814a[i13] & 255) << min;
            min += 8;
            i13++;
        }
        int i15 = i14 & ((-1) >>> (32 - i11));
        e(i11);
        return i15;
    }

    public void e(int i11) {
        int i12 = i11 / 8;
        int i13 = this.f68816c + i12;
        this.f68816c = i13;
        int i14 = this.f68817d + (i11 - (i12 * 8));
        this.f68817d = i14;
        if (i14 > 7) {
            this.f68816c = i13 + 1;
            this.f68817d = i14 - 8;
        }
        a();
    }
}

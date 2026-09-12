package androidx.media3.common.util;

import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    private int f10549a;

    /* renamed from: b, reason: collision with root package name */
    private int f10550b;

    /* renamed from: c, reason: collision with root package name */
    private int f10551c;

    /* renamed from: d, reason: collision with root package name */
    private long[] f10552d;

    /* renamed from: e, reason: collision with root package name */
    private int f10553e;

    public w() {
        this(16);
    }

    public w(int i11) {
        a.a(i11 >= 0 && i11 <= 1073741824);
        i11 = i11 == 0 ? 1 : i11;
        i11 = Integer.bitCount(i11) != 1 ? Integer.highestOneBit(i11 - 1) << 1 : i11;
        this.f10549a = 0;
        this.f10550b = -1;
        this.f10551c = 0;
        long[] jArr = new long[i11];
        this.f10552d = jArr;
        this.f10553e = jArr.length - 1;
    }

    private void c() {
        long[] jArr = this.f10552d;
        int length = jArr.length << 1;
        if (length < 0) {
            throw new IllegalStateException();
        }
        long[] jArr2 = new long[length];
        int length2 = jArr.length;
        int i11 = this.f10549a;
        int i12 = length2 - i11;
        System.arraycopy(jArr, i11, jArr2, 0, i12);
        System.arraycopy(this.f10552d, 0, jArr2, i12, i11);
        this.f10549a = 0;
        this.f10550b = this.f10551c - 1;
        this.f10552d = jArr2;
        this.f10553e = jArr2.length - 1;
    }

    public void a(long j11) {
        if (this.f10551c == this.f10552d.length) {
            c();
        }
        int i11 = (this.f10550b + 1) & this.f10553e;
        this.f10550b = i11;
        this.f10552d[i11] = j11;
        this.f10551c++;
    }

    public void b() {
        this.f10549a = 0;
        this.f10550b = -1;
        this.f10551c = 0;
    }

    public long d() {
        if (this.f10551c != 0) {
            return this.f10552d[this.f10549a];
        }
        throw new NoSuchElementException();
    }

    public boolean e() {
        return this.f10551c == 0;
    }

    public long f() {
        int i11 = this.f10551c;
        if (i11 == 0) {
            throw new NoSuchElementException();
        }
        long[] jArr = this.f10552d;
        int i12 = this.f10549a;
        long j11 = jArr[i12];
        this.f10549a = this.f10553e & (i12 + 1);
        this.f10551c = i11 - 1;
        return j11;
    }
}

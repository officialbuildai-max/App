package s3;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    private final int f75382a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f75383b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f75384c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f75385d;

    /* renamed from: e, reason: collision with root package name */
    public int f75386e;

    public w(int i11, int i12) {
        this.f75382a = i11;
        byte[] bArr = new byte[i12 + 3];
        this.f75385d = bArr;
        bArr[2] = 1;
    }

    public void a(byte[] bArr, int i11, int i12) {
        if (this.f75383b) {
            int i13 = i12 - i11;
            byte[] bArr2 = this.f75385d;
            int length = bArr2.length;
            int i14 = this.f75386e;
            if (length < i14 + i13) {
                this.f75385d = Arrays.copyOf(bArr2, (i14 + i13) * 2);
            }
            System.arraycopy(bArr, i11, this.f75385d, this.f75386e, i13);
            this.f75386e += i13;
        }
    }

    public boolean b(int i11) {
        if (!this.f75383b) {
            return false;
        }
        this.f75386e -= i11;
        this.f75383b = false;
        this.f75384c = true;
        return true;
    }

    public boolean c() {
        return this.f75384c;
    }

    public void d() {
        this.f75383b = false;
        this.f75384c = false;
    }

    public void e(int i11) {
        androidx.media3.common.util.a.g(!this.f75383b);
        boolean z10 = i11 == this.f75382a;
        this.f75383b = z10;
        if (z10) {
            this.f75386e = 3;
            this.f75384c = false;
        }
    }
}

package q9;

import java.util.Arrays;

/* loaded from: classes4.dex */
final class u {

    /* renamed from: a, reason: collision with root package name */
    private final int f73630a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f73631b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f73632c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f73633d;

    /* renamed from: e, reason: collision with root package name */
    public int f73634e;

    public u(int i11, int i12) {
        this.f73630a = i11;
        byte[] bArr = new byte[i12 + 3];
        this.f73633d = bArr;
        bArr[2] = 1;
    }

    public void a(byte[] bArr, int i11, int i12) {
        if (this.f73631b) {
            int i13 = i12 - i11;
            byte[] bArr2 = this.f73633d;
            int length = bArr2.length;
            int i14 = this.f73634e;
            if (length < i14 + i13) {
                this.f73633d = Arrays.copyOf(bArr2, (i14 + i13) * 2);
            }
            System.arraycopy(bArr, i11, this.f73633d, this.f73634e, i13);
            this.f73634e += i13;
        }
    }

    public boolean b(int i11) {
        if (!this.f73631b) {
            return false;
        }
        this.f73634e -= i11;
        this.f73631b = false;
        this.f73632c = true;
        return true;
    }

    public boolean c() {
        return this.f73632c;
    }

    public void d() {
        this.f73631b = false;
        this.f73632c = false;
    }

    public void e(int i11) {
        com.google.android.exoplayer2.util.a.g(!this.f73631b);
        boolean z10 = i11 == this.f73630a;
        this.f73631b = z10;
        if (z10) {
            this.f73634e = 3;
            this.f73632c = false;
        }
    }
}

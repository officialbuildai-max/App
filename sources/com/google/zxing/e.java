package com.google.zxing;

/* loaded from: classes4.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    private final int f32953a;

    /* renamed from: b, reason: collision with root package name */
    private final int f32954b;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(int i11, int i12) {
        this.f32953a = i11;
        this.f32954b = i12;
    }

    public final int a() {
        return this.f32954b;
    }

    public abstract byte[] b();

    public abstract byte[] c(int i11, byte[] bArr);

    public final int d() {
        return this.f32953a;
    }

    public e e() {
        return new d(this);
    }

    public boolean f() {
        return false;
    }

    public e g() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        int i11 = this.f32953a;
        byte[] bArr = new byte[i11];
        StringBuilder sb2 = new StringBuilder(this.f32954b * (i11 + 1));
        for (int i12 = 0; i12 < this.f32954b; i12++) {
            bArr = c(i12, bArr);
            for (int i13 = 0; i13 < this.f32953a; i13++) {
                int i14 = bArr[i13] & 255;
                sb2.append(i14 < 64 ? '#' : i14 < 128 ? '+' : i14 < 192 ? '.' : ' ');
            }
            sb2.append('\n');
        }
        return sb2.toString();
    }
}

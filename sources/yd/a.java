package yd;

import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final byte[][] f79106a;

    /* renamed from: b, reason: collision with root package name */
    private final int f79107b;

    /* renamed from: c, reason: collision with root package name */
    private final int f79108c;

    public a(int i11, int i12) {
        this.f79106a = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i12, i11);
        this.f79107b = i11;
        this.f79108c = i12;
    }

    public void a(byte b11) {
        for (byte[] bArr : this.f79106a) {
            Arrays.fill(bArr, b11);
        }
    }

    public byte b(int i11, int i12) {
        return this.f79106a[i12][i11];
    }

    public byte[][] c() {
        return this.f79106a;
    }

    public int d() {
        return this.f79108c;
    }

    public int e() {
        return this.f79107b;
    }

    public void f(int i11, int i12, int i13) {
        this.f79106a[i12][i11] = (byte) i13;
    }

    public void g(int i11, int i12, boolean z10) {
        this.f79106a[i12][i11] = z10 ? (byte) 1 : (byte) 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder((this.f79107b * 2 * this.f79108c) + 2);
        for (int i11 = 0; i11 < this.f79108c; i11++) {
            byte[] bArr = this.f79106a[i11];
            for (int i12 = 0; i12 < this.f79107b; i12++) {
                byte b11 = bArr[i12];
                if (b11 == 0) {
                    sb2.append(" 0");
                } else if (b11 != 1) {
                    sb2.append("  ");
                } else {
                    sb2.append(" 1");
                }
            }
            sb2.append('\n');
        }
        return sb2.toString();
    }
}

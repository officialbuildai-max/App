package wd;

import java.lang.reflect.Array;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final b[] f77762a;

    /* renamed from: b, reason: collision with root package name */
    private int f77763b;

    /* renamed from: c, reason: collision with root package name */
    private final int f77764c;

    /* renamed from: d, reason: collision with root package name */
    private final int f77765d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i11, int i12) {
        b[] bVarArr = new b[i11];
        this.f77762a = bVarArr;
        int length = bVarArr.length;
        for (int i13 = 0; i13 < length; i13++) {
            this.f77762a[i13] = new b(((i12 + 4) * 17) + 1);
        }
        this.f77765d = i12 * 17;
        this.f77764c = i11;
        this.f77763b = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a() {
        return this.f77762a[this.f77763b];
    }

    public byte[][] b(int i11, int i12) {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, this.f77764c * i12, this.f77765d * i11);
        int i13 = this.f77764c * i12;
        for (int i14 = 0; i14 < i13; i14++) {
            bArr[(i13 - i14) - 1] = this.f77762a[i14 / i12].b(i11);
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f77763b++;
    }
}

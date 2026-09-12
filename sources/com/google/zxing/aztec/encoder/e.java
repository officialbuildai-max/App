package com.google.zxing.aztec.encoder;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class e {

    /* renamed from: f, reason: collision with root package name */
    static final e f32896f = new e(f.f32902b, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    private final int f32897a;

    /* renamed from: b, reason: collision with root package name */
    private final f f32898b;

    /* renamed from: c, reason: collision with root package name */
    private final int f32899c;

    /* renamed from: d, reason: collision with root package name */
    private final int f32900d;

    /* renamed from: e, reason: collision with root package name */
    private final int f32901e;

    private e(f fVar, int i11, int i12, int i13) {
        this.f32898b = fVar;
        this.f32897a = i11;
        this.f32899c = i12;
        this.f32900d = i13;
        this.f32901e = c(i12);
    }

    private static int c(int i11) {
        if (i11 > 62) {
            return 21;
        }
        if (i11 > 31) {
            return 20;
        }
        return i11 > 0 ? 10 : 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e a(int i11) {
        f fVar = this.f32898b;
        int i12 = this.f32897a;
        int i13 = this.f32900d;
        if (i12 == 4 || i12 == 2) {
            int i14 = HighLevelEncoder.f32881d[i12][0];
            int i15 = 65535 & i14;
            int i16 = i14 >> 16;
            fVar = fVar.a(i15, i16);
            i13 += i16;
            i12 = 0;
        }
        int i17 = this.f32899c;
        e eVar = new e(fVar, i12, i17 + 1, i13 + ((i17 == 0 || i17 == 31) ? 18 : i17 == 62 ? 9 : 8));
        return eVar.f32899c == 2078 ? eVar.d(i11 + 1) : eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e b(int i11) {
        f fVar;
        f fVar2 = j(4, 0).f32898b;
        int i12 = 3;
        if (i11 < 0) {
            fVar = fVar2.a(0, 3);
        } else {
            if (i11 > 999999) {
                throw new IllegalArgumentException("ECI code must be between 0 and 999999");
            }
            byte[] bytes = Integer.toString(i11).getBytes(StandardCharsets.ISO_8859_1);
            f a11 = fVar2.a(bytes.length, 3);
            for (byte b11 : bytes) {
                a11 = a11.a(b11 - 46, 4);
            }
            i12 = 3 + (bytes.length * 4);
            fVar = a11;
        }
        return new e(fVar, this.f32897a, 0, this.f32900d + i12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e d(int i11) {
        int i12 = this.f32899c;
        return i12 == 0 ? this : new e(this.f32898b.b(i11 - i12, i12), this.f32897a, 0, this.f32900d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f32899c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f32900d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f32897a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(e eVar) {
        int i11 = this.f32900d + (HighLevelEncoder.f32881d[this.f32897a][eVar.f32897a] >> 16);
        int i12 = this.f32899c;
        int i13 = eVar.f32899c;
        if (i12 < i13) {
            i11 += eVar.f32901e - this.f32901e;
        } else if (i12 > i13 && i13 > 0) {
            i11 += 10;
        }
        return i11 <= eVar.f32900d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e i(int i11, int i12) {
        int i13 = this.f32900d;
        f fVar = this.f32898b;
        int i14 = this.f32897a;
        if (i11 != i14) {
            int i15 = HighLevelEncoder.f32881d[i14][i11];
            int i16 = 65535 & i15;
            int i17 = i15 >> 16;
            fVar = fVar.a(i16, i17);
            i13 += i17;
        }
        int i18 = i11 == 2 ? 4 : 5;
        return new e(fVar.a(i12, i18), i11, 0, i13 + i18);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e j(int i11, int i12) {
        f fVar = this.f32898b;
        int i13 = this.f32897a;
        int i14 = i13 == 2 ? 4 : 5;
        return new e(fVar.a(HighLevelEncoder.f32883f[i13][i11], i14).a(i12, 5), this.f32897a, 0, this.f32900d + i14 + 5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public id.a k(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        for (f fVar = d(bArr.length).f32898b; fVar != null; fVar = fVar.d()) {
            arrayList.add(fVar);
        }
        id.a aVar = new id.a();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((f) arrayList.get(size)).c(aVar, bArr);
        }
        return aVar;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", HighLevelEncoder.f32880c[this.f32897a], Integer.valueOf(this.f32900d), Integer.valueOf(this.f32899c));
    }
}

package com.google.zxing.qrcode.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.l;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final id.b f33065a;

    /* renamed from: c, reason: collision with root package name */
    private final int f33067c;

    /* renamed from: d, reason: collision with root package name */
    private final int f33068d;

    /* renamed from: e, reason: collision with root package name */
    private final int f33069e;

    /* renamed from: f, reason: collision with root package name */
    private final int f33070f;

    /* renamed from: g, reason: collision with root package name */
    private final float f33071g;

    /* renamed from: i, reason: collision with root package name */
    private final l f33073i;

    /* renamed from: b, reason: collision with root package name */
    private final List f33066b = new ArrayList(5);

    /* renamed from: h, reason: collision with root package name */
    private final int[] f33072h = new int[3];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(id.b bVar, int i11, int i12, int i13, int i14, float f11, l lVar) {
        this.f33065a = bVar;
        this.f33067c = i11;
        this.f33068d = i12;
        this.f33069e = i13;
        this.f33070f = i14;
        this.f33071g = f11;
        this.f33073i = lVar;
    }

    private static float a(int[] iArr, int i11) {
        return (i11 - iArr[2]) - (iArr[1] / 2.0f);
    }

    private float b(int i11, int i12, int i13, int i14) {
        id.b bVar = this.f33065a;
        int k11 = bVar.k();
        int[] iArr = this.f33072h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i15 = i11;
        while (i15 >= 0 && bVar.g(i12, i15)) {
            int i16 = iArr[1];
            if (i16 > i13) {
                break;
            }
            iArr[1] = i16 + 1;
            i15--;
        }
        if (i15 < 0 || iArr[1] > i13) {
            return Float.NaN;
        }
        while (i15 >= 0 && !bVar.g(i12, i15)) {
            int i17 = iArr[0];
            if (i17 > i13) {
                break;
            }
            iArr[0] = i17 + 1;
            i15--;
        }
        if (iArr[0] > i13) {
            return Float.NaN;
        }
        int i18 = i11 + 1;
        while (i18 < k11 && bVar.g(i12, i18)) {
            int i19 = iArr[1];
            if (i19 > i13) {
                break;
            }
            iArr[1] = i19 + 1;
            i18++;
        }
        if (i18 == k11 || iArr[1] > i13) {
            return Float.NaN;
        }
        while (i18 < k11 && !bVar.g(i12, i18)) {
            int i20 = iArr[2];
            if (i20 > i13) {
                break;
            }
            iArr[2] = i20 + 1;
            i18++;
        }
        int i21 = iArr[2];
        if (i21 <= i13 && Math.abs(((iArr[0] + iArr[1]) + i21) - i14) * 5 < i14 * 2 && d(iArr)) {
            return a(iArr, i18);
        }
        return Float.NaN;
    }

    private boolean d(int[] iArr) {
        float f11 = this.f33071g;
        float f12 = f11 / 2.0f;
        for (int i11 = 0; i11 < 3; i11++) {
            if (Math.abs(f11 - iArr[i11]) >= f12) {
                return false;
            }
        }
        return true;
    }

    private a e(int[] iArr, int i11, int i12) {
        int i13 = iArr[0] + iArr[1] + iArr[2];
        float a11 = a(iArr, i12);
        float b11 = b(i11, (int) a11, iArr[1] * 2, i13);
        if (Float.isNaN(b11)) {
            return null;
        }
        float f11 = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (a aVar : this.f33066b) {
            if (aVar.f(f11, b11, a11)) {
                return aVar.g(b11, a11, f11);
            }
        }
        a aVar2 = new a(a11, b11, f11);
        this.f33066b.add(aVar2);
        l lVar = this.f33073i;
        if (lVar == null) {
            return null;
        }
        lVar.a(aVar2);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a c() {
        a e11;
        a e12;
        int i11 = this.f33067c;
        int i12 = this.f33070f;
        int i13 = this.f33069e + i11;
        int i14 = this.f33068d + (i12 / 2);
        int[] iArr = new int[3];
        for (int i15 = 0; i15 < i12; i15++) {
            int i16 = ((i15 & 1) == 0 ? (i15 + 1) / 2 : -((i15 + 1) / 2)) + i14;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i17 = i11;
            while (i17 < i13 && !this.f33065a.g(i17, i16)) {
                i17++;
            }
            int i18 = 0;
            while (i17 < i13) {
                if (!this.f33065a.g(i17, i16)) {
                    if (i18 == 1) {
                        i18++;
                    }
                    iArr[i18] = iArr[i18] + 1;
                } else if (i18 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i18 != 2) {
                    i18++;
                    iArr[i18] = iArr[i18] + 1;
                } else {
                    if (d(iArr) && (e12 = e(iArr, i16, i17)) != null) {
                        return e12;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i18 = 1;
                }
                i17++;
            }
            if (d(iArr) && (e11 = e(iArr, i16, i13)) != null) {
                return e11;
            }
        }
        if (this.f33066b.isEmpty()) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (a) this.f33066b.get(0);
    }
}

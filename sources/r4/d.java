package r4;

import java.util.Arrays;

/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f74219a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f74220b;

    public d(float[] fArr, int[] iArr) {
        this.f74219a = fArr;
        this.f74220b = iArr;
    }

    private void a(d dVar) {
        int i11 = 0;
        while (true) {
            int[] iArr = dVar.f74220b;
            if (i11 >= iArr.length) {
                return;
            }
            this.f74219a[i11] = dVar.f74219a[i11];
            this.f74220b[i11] = iArr[i11];
            i11++;
        }
    }

    private int c(float f11) {
        int binarySearch = Arrays.binarySearch(this.f74219a, f11);
        if (binarySearch >= 0) {
            return this.f74220b[binarySearch];
        }
        int i11 = -(binarySearch + 1);
        if (i11 == 0) {
            return this.f74220b[0];
        }
        int[] iArr = this.f74220b;
        if (i11 == iArr.length - 1) {
            return iArr[iArr.length - 1];
        }
        float[] fArr = this.f74219a;
        int i12 = i11 - 1;
        float f12 = fArr[i12];
        return v4.d.c((f11 - f12) / (fArr[i11] - f12), iArr[i12], iArr[i11]);
    }

    public d b(float[] fArr) {
        int[] iArr = new int[fArr.length];
        for (int i11 = 0; i11 < fArr.length; i11++) {
            iArr[i11] = c(fArr[i11]);
        }
        return new d(fArr, iArr);
    }

    public int[] d() {
        return this.f74220b;
    }

    public float[] e() {
        return this.f74219a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return Arrays.equals(this.f74219a, dVar.f74219a) && Arrays.equals(this.f74220b, dVar.f74220b);
    }

    public int f() {
        return this.f74220b.length;
    }

    public void g(d dVar, d dVar2, float f11) {
        int[] iArr;
        if (dVar.equals(dVar2)) {
            a(dVar);
            return;
        }
        if (f11 <= 0.0f) {
            a(dVar);
            return;
        }
        if (f11 >= 1.0f) {
            a(dVar2);
            return;
        }
        if (dVar.f74220b.length != dVar2.f74220b.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + dVar.f74220b.length + " vs " + dVar2.f74220b.length + ")");
        }
        int i11 = 0;
        while (true) {
            iArr = dVar.f74220b;
            if (i11 >= iArr.length) {
                break;
            }
            this.f74219a[i11] = v4.k.i(dVar.f74219a[i11], dVar2.f74219a[i11], f11);
            this.f74220b[i11] = v4.d.c(f11, dVar.f74220b[i11], dVar2.f74220b[i11]);
            i11++;
        }
        int length = iArr.length;
        while (true) {
            float[] fArr = this.f74219a;
            if (length >= fArr.length) {
                return;
            }
            int[] iArr2 = dVar.f74220b;
            fArr[length] = fArr[iArr2.length - 1];
            int[] iArr3 = this.f74220b;
            iArr3[length] = iArr3[iArr2.length - 1];
            length++;
        }
    }

    public int hashCode() {
        return (Arrays.hashCode(this.f74219a) * 31) + Arrays.hashCode(this.f74220b);
    }
}

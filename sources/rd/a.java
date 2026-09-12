package rd;

import com.google.zxing.NotFoundException;
import qd.p;

/* loaded from: classes5.dex */
public abstract class a extends p {

    /* renamed from: b, reason: collision with root package name */
    private final int[] f74434b;

    /* renamed from: e, reason: collision with root package name */
    private final int[] f74437e;

    /* renamed from: f, reason: collision with root package name */
    private final int[] f74438f;

    /* renamed from: a, reason: collision with root package name */
    private final int[] f74433a = new int[4];

    /* renamed from: c, reason: collision with root package name */
    private final float[] f74435c = new float[4];

    /* renamed from: d, reason: collision with root package name */
    private final float[] f74436d = new float[4];

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        int[] iArr = new int[8];
        this.f74434b = iArr;
        this.f74437e = new int[iArr.length / 2];
        this.f74438f = new int[iArr.length / 2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void h(int[] iArr, float[] fArr) {
        int i11 = 0;
        float f11 = fArr[0];
        for (int i12 = 1; i12 < iArr.length; i12++) {
            float f12 = fArr[i12];
            if (f12 < f11) {
                i11 = i12;
                f11 = f12;
            }
        }
        iArr[i11] = iArr[i11] - 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void o(int[] iArr, float[] fArr) {
        int i11 = 0;
        float f11 = fArr[0];
        for (int i12 = 1; i12 < iArr.length; i12++) {
            float f12 = fArr[i12];
            if (f12 > f11) {
                i11 = i12;
                f11 = f12;
            }
        }
        iArr[i11] = iArr[i11] + 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean p(int[] iArr) {
        float f11 = (iArr[0] + iArr[1]) / ((iArr[2] + r1) + iArr[3]);
        if (f11 < 0.7916667f || f11 > 0.89285713f) {
            return false;
        }
        int i11 = Integer.MAX_VALUE;
        int i12 = Integer.MIN_VALUE;
        for (int i13 : iArr) {
            if (i13 > i12) {
                i12 = i13;
            }
            if (i13 < i11) {
                i11 = i13;
            }
        }
        return i12 < i11 * 10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int q(int[] iArr, int[][] iArr2) {
        for (int i11 = 0; i11 < iArr2.length; i11++) {
            if (p.e(iArr, iArr2[i11], 0.45f) < 0.2f) {
                return i11;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int[] i() {
        return this.f74434b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int[] j() {
        return this.f74433a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int[] k() {
        return this.f74438f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float[] l() {
        return this.f74436d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int[] m() {
        return this.f74437e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float[] n() {
        return this.f74435c;
    }
}

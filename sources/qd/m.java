package qd;

import com.google.zxing.BarcodeFormat;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes5.dex */
public final class m extends q {

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f73703b = {1, 1, 1, 1};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f73704c = {3, 1, 1};

    /* renamed from: d, reason: collision with root package name */
    private static final int[][] f73705d = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    @Override // qd.q
    public boolean[] d(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        }
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        q.c(str);
        boolean[] zArr = new boolean[(length * 9) + 9];
        int b11 = q.b(zArr, 0, f73703b, true);
        for (int i11 = 0; i11 < length; i11 += 2) {
            int digit = Character.digit(str.charAt(i11), 10);
            int digit2 = Character.digit(str.charAt(i11 + 1), 10);
            int[] iArr = new int[10];
            for (int i12 = 0; i12 < 5; i12++) {
                int i13 = i12 * 2;
                int[][] iArr2 = f73705d;
                iArr[i13] = iArr2[digit][i12];
                iArr[i13 + 1] = iArr2[digit2][i12];
            }
            b11 += q.b(zArr, b11, iArr, true);
        }
        q.b(zArr, b11, f73704c, true);
        return zArr;
    }

    @Override // qd.q
    protected Collection g() {
        return Collections.singleton(BarcodeFormat.ITF);
    }
}

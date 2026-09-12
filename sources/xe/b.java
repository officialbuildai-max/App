package xe;

import android.graphics.Bitmap;
import androidx.core.view.ViewCompat;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;

/* loaded from: classes5.dex */
public class b {
    public Bitmap a(id.b bVar) {
        int n11 = bVar.n();
        int k11 = bVar.k();
        int[] iArr = new int[n11 * k11];
        for (int i11 = 0; i11 < k11; i11++) {
            int i12 = i11 * n11;
            for (int i13 = 0; i13 < n11; i13++) {
                iArr[i12 + i13] = bVar.g(i13, i11) ? ViewCompat.MEASURED_STATE_MASK : -1;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(n11, k11, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, n11, 0, 0, n11, k11);
        return createBitmap;
    }

    public id.b b(String str, BarcodeFormat barcodeFormat, int i11, int i12) {
        try {
            return new com.google.zxing.g().b(str, barcodeFormat, i11, i12);
        } catch (WriterException e11) {
            throw e11;
        } catch (Exception e12) {
            throw new WriterException(e12);
        }
    }
}

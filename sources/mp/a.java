package mp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes6.dex */
public class a {
    public static Bitmap a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        for (int i11 = 90; byteArrayOutputStream.toByteArray().length / 1024 > 100 && i11 > 50; i11 -= 10) {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.PNG, i11, byteArrayOutputStream);
        }
        return BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0038 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap b(java.lang.String r6) {
        /*
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
            r0.<init>()
            r1 = 1
            r0.inJustDecodeBounds = r1
            android.graphics.BitmapFactory.decodeFile(r6, r0)
            r2 = 0
            r0.inJustDecodeBounds = r2
            int r2 = r0.outWidth
            int r3 = r0.outHeight
            if (r2 <= r3) goto L1f
            float r4 = (float) r2
            r5 = 1139802112(0x43f00000, float:480.0)
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L1f
            float r2 = (float) r2
            float r2 = r2 / r5
        L1d:
            int r2 = (int) r2
            goto L2c
        L1f:
            if (r2 >= r3) goto L2b
            float r2 = (float) r3
            r4 = 1145569280(0x44480000, float:800.0)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L2b
            float r2 = (float) r3
            float r2 = r2 / r4
            goto L1d
        L2b:
            r2 = r1
        L2c:
            if (r2 > 0) goto L2f
            goto L30
        L2f:
            r1 = r2
        L30:
            r0.inSampleSize = r1
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeFile(r6, r0)
            if (r6 != 0) goto L3a
            r6 = 0
            return r6
        L3a:
            android.graphics.Bitmap r6 = a(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: mp.a.b(java.lang.String):android.graphics.Bitmap");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x001b -> B:10:0x002d). Please report as a decompilation issue!!! */
    public static void c(Bitmap bitmap, File file, int i11) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
            } catch (FileNotFoundException e12) {
                e = e12;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, i11, fileOutputStream);
                try {
                    fileOutputStream.flush();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
                fileOutputStream.close();
            } catch (FileNotFoundException e14) {
                e = e14;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                bitmap.recycle();
            }
            bitmap.recycle();
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e15) {
                    e15.printStackTrace();
                }
            }
            throw th;
        }
    }
}

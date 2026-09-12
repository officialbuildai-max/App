package xe;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import java.io.ByteArrayOutputStream;

/* loaded from: classes5.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private n f78359a;

    /* renamed from: b, reason: collision with root package name */
    private int f78360b;

    /* renamed from: c, reason: collision with root package name */
    private int f78361c;

    /* renamed from: d, reason: collision with root package name */
    private Rect f78362d;

    /* renamed from: e, reason: collision with root package name */
    private int f78363e = 1;

    /* renamed from: f, reason: collision with root package name */
    private boolean f78364f;

    public r(byte[] bArr, int i11, int i12, int i13, int i14) {
        this.f78359a = new n(bArr, i11, i12);
        this.f78361c = i14;
        this.f78360b = i13;
        if (i11 * i12 <= bArr.length) {
            return;
        }
        throw new IllegalArgumentException("Image data does not match the resolution. " + i11 + "x" + i12 + " > " + bArr.length);
    }

    public com.google.zxing.h a() {
        n a11 = this.f78359a.h(this.f78361c).a(this.f78362d, this.f78363e);
        return new com.google.zxing.h(a11.b(), a11.d(), a11.c(), 0, 0, a11.d(), a11.c(), false);
    }

    public Bitmap b(Rect rect, int i11) {
        if (rect == null) {
            rect = new Rect(0, 0, this.f78359a.d(), this.f78359a.c());
        } else if (c()) {
            rect = new Rect(rect.top, rect.left, rect.bottom, rect.right);
        }
        YuvImage yuvImage = new YuvImage(this.f78359a.b(), this.f78360b, this.f78359a.d(), this.f78359a.c(), null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(rect, 90, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = i11;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
        if (this.f78361c == 0) {
            return decodeByteArray;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(this.f78361c);
        return Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, false);
    }

    public boolean c() {
        return this.f78361c % 180 != 0;
    }

    public void d(Rect rect) {
        this.f78362d = rect;
    }

    public void e(boolean z10) {
        this.f78364f = z10;
    }

    public com.google.zxing.k f(com.google.zxing.k kVar) {
        float c11 = (kVar.c() * this.f78363e) + this.f78362d.left;
        float d11 = (kVar.d() * this.f78363e) + this.f78362d.top;
        if (this.f78364f) {
            c11 = this.f78359a.d() - c11;
        }
        return new com.google.zxing.k(c11, d11);
    }
}

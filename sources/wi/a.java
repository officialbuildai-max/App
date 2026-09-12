package wi;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.blankj.utilcode.util.ImageUtils;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import java.security.MessageDigest;

/* loaded from: classes6.dex */
public class a extends BitmapTransformation {

    /* renamed from: a, reason: collision with root package name */
    private final int f77811a;

    /* renamed from: b, reason: collision with root package name */
    private final int f77812b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f77813c;

    public a() {
        this(25, 1);
    }

    public a(int i11) {
        this(i11, 1);
    }

    public a(int i11, int i12) {
        this.f77813c = false;
        this.f77811a = i11;
        this.f77812b = i12;
    }

    public a(int i11, int i12, boolean z10) {
        this.f77811a = i11;
        this.f77812b = i12;
        this.f77813c = z10;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.f77811a == this.f77811a && aVar.f77812b == this.f77812b) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return 589067571 + (this.f77811a * 1000) + (this.f77812b * 10);
    }

    public String toString() {
        return "BlurTransformation(radius=" + this.f77811a + ", sampling=" + this.f77812b + ")";
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i11, int i12) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i13 = this.f77812b;
        Bitmap bitmap2 = bitmapPool.get(width / i13, height / i13, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap2);
        int i14 = this.f77812b;
        canvas.scale(1.0f / i14, 1.0f / i14);
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return this.f77813c ? b.a(bitmap2, this.f77811a, true) : ImageUtils.a(bitmap2, 1.0f, this.f77811a);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(("BlurTransformation.1" + this.f77811a + this.f77812b).getBytes(Key.CHARSET));
    }
}

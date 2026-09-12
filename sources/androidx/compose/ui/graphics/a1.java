package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.util.DisplayMetrics;
import kotlin.jvm.JvmStatic;

/* loaded from: classes.dex */
public final class a1 {

    /* renamed from: a, reason: collision with root package name */
    public static final a1 f4365a = new a1();

    private a1() {
    }

    @JvmStatic
    public static final androidx.compose.ui.graphics.colorspace.c a(Bitmap bitmap) {
        ColorSpace colorSpace;
        androidx.compose.ui.graphics.colorspace.c b11;
        colorSpace = bitmap.getColorSpace();
        return (colorSpace == null || (b11 = j0.b(colorSpace)) == null) ? androidx.compose.ui.graphics.colorspace.g.f4428a.w() : b11;
    }

    @JvmStatic
    public static final Bitmap b(int i11, int i12, int i13, boolean z10, androidx.compose.ui.graphics.colorspace.c cVar) {
        Bitmap createBitmap;
        createBitmap = Bitmap.createBitmap((DisplayMetrics) null, i11, i12, q0.d(i13), z10, j0.a(cVar));
        return createBitmap;
    }
}

package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.compose.ui.graphics.f4;

/* loaded from: classes.dex */
public abstract class q0 {
    public static final e4 a(int i11, int i12, int i13, boolean z10, androidx.compose.ui.graphics.colorspace.c cVar) {
        Bitmap createBitmap;
        Bitmap.Config d11 = d(i13);
        if (Build.VERSION.SDK_INT >= 26) {
            createBitmap = a1.b(i11, i12, i13, z10, cVar);
        } else {
            createBitmap = Bitmap.createBitmap((DisplayMetrics) null, i11, i12, d11);
            createBitmap.setHasAlpha(z10);
        }
        return new n0(createBitmap);
    }

    public static final Bitmap b(e4 e4Var) {
        if (e4Var instanceof n0) {
            return ((n0) e4Var).c();
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Bitmap");
    }

    public static final e4 c(Bitmap bitmap) {
        return new n0(bitmap);
    }

    public static final Bitmap.Config d(int i11) {
        Bitmap.Config config;
        Bitmap.Config config2;
        f4.a aVar = f4.f4514b;
        if (f4.i(i11, aVar.b())) {
            return Bitmap.Config.ARGB_8888;
        }
        if (f4.i(i11, aVar.a())) {
            return Bitmap.Config.ALPHA_8;
        }
        if (f4.i(i11, aVar.e())) {
            return Bitmap.Config.RGB_565;
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 26 && f4.i(i11, aVar.c())) {
            config2 = Bitmap.Config.RGBA_F16;
            return config2;
        }
        if (i12 < 26 || !f4.i(i11, aVar.d())) {
            return Bitmap.Config.ARGB_8888;
        }
        config = Bitmap.Config.HARDWARE;
        return config;
    }

    public static final int e(Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3;
        if (config == Bitmap.Config.ALPHA_8) {
            return f4.f4514b.a();
        }
        if (config == Bitmap.Config.RGB_565) {
            return f4.f4514b.e();
        }
        if (config == Bitmap.Config.ARGB_4444) {
            return f4.f4514b.b();
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26) {
            config3 = Bitmap.Config.RGBA_F16;
            if (config == config3) {
                return f4.f4514b.c();
            }
        }
        if (i11 >= 26) {
            config2 = Bitmap.Config.HARDWARE;
            if (config == config2) {
                return f4.f4514b.d();
            }
        }
        return f4.f4514b.b();
    }
}

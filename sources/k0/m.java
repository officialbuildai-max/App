package k0;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;

/* loaded from: classes2.dex */
final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f66669a = new m();

    private m() {
    }

    public final boolean a(Canvas canvas, Path path) {
        boolean clipOutPath;
        clipOutPath = canvas.clipOutPath(path);
        return clipOutPath;
    }

    public final boolean b(Canvas canvas, float f11, float f12, float f13, float f14) {
        boolean clipOutRect;
        clipOutRect = canvas.clipOutRect(f11, f12, f13, f14);
        return clipOutRect;
    }

    public final boolean c(Canvas canvas, int i11, int i12, int i13, int i14) {
        boolean clipOutRect;
        clipOutRect = canvas.clipOutRect(i11, i12, i13, i14);
        return clipOutRect;
    }

    public final boolean d(Canvas canvas, Rect rect) {
        boolean clipOutRect;
        clipOutRect = canvas.clipOutRect(rect);
        return clipOutRect;
    }

    public final boolean e(Canvas canvas, RectF rectF) {
        boolean clipOutRect;
        clipOutRect = canvas.clipOutRect(rectF);
        return clipOutRect;
    }
}

package k0;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;

/* loaded from: classes2.dex */
final class w {

    /* renamed from: a, reason: collision with root package name */
    public static final w f66673a = new w();

    private w() {
    }

    public final boolean a(Canvas canvas, float f11, float f12, float f13, float f14) {
        boolean quickReject;
        quickReject = canvas.quickReject(f11, f12, f13, f14);
        return quickReject;
    }

    public final boolean b(Canvas canvas, Path path) {
        boolean quickReject;
        quickReject = canvas.quickReject(path);
        return quickReject;
    }

    public final boolean c(Canvas canvas, RectF rectF) {
        boolean quickReject;
        quickReject = canvas.quickReject(rectF);
        return quickReject;
    }
}

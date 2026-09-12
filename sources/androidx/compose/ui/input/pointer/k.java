package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;

/* loaded from: classes.dex */
final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f5079a = new k();

    private k() {
    }

    public final long a(MotionEvent motionEvent, int i11) {
        float rawX;
        float rawY;
        rawX = motionEvent.getRawX(i11);
        rawY = motionEvent.getRawY(i11);
        return y.h.a(rawX, rawY);
    }
}

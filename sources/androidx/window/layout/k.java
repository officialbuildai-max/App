package androidx.window.layout;

import android.view.DisplayCutout;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f15422a = new k();

    private k() {
    }

    public final int a(DisplayCutout displayCutout) {
        int safeInsetBottom;
        Intrinsics.h(displayCutout, "displayCutout");
        safeInsetBottom = displayCutout.getSafeInsetBottom();
        return safeInsetBottom;
    }

    public final int b(DisplayCutout displayCutout) {
        int safeInsetLeft;
        Intrinsics.h(displayCutout, "displayCutout");
        safeInsetLeft = displayCutout.getSafeInsetLeft();
        return safeInsetLeft;
    }

    public final int c(DisplayCutout displayCutout) {
        int safeInsetRight;
        Intrinsics.h(displayCutout, "displayCutout");
        safeInsetRight = displayCutout.getSafeInsetRight();
        return safeInsetRight;
    }

    public final int d(DisplayCutout displayCutout) {
        int safeInsetTop;
        Intrinsics.h(displayCutout, "displayCutout");
        safeInsetTop = displayCutout.getSafeInsetTop();
        return safeInsetTop;
    }
}

package androidx.window.layout;

import android.app.Activity;
import android.graphics.Rect;
import android.view.WindowMetrics;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f15418a = new e();

    private e() {
    }

    public final Rect a(Activity activity) {
        WindowMetrics currentWindowMetrics;
        Rect bounds;
        Intrinsics.h(activity, "activity");
        currentWindowMetrics = activity.getWindowManager().getCurrentWindowMetrics();
        bounds = currentWindowMetrics.getBounds();
        Intrinsics.g(bounds, "activity.windowManager.currentWindowMetrics.bounds");
        return bounds;
    }
}

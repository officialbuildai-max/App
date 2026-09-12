package androidx.window.layout;

import android.app.Activity;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f15416a = new b();

    private b() {
    }

    public final boolean a(Activity activity) {
        boolean isInMultiWindowMode;
        Intrinsics.h(activity, "activity");
        isInMultiWindowMode = activity.isInMultiWindowMode();
        return isInMultiWindowMode;
    }
}

package gk;

import android.content.Context;
import android.util.DisplayMetrics;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f63748a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static DisplayMetrics f63749b;

    private a() {
    }

    public final int a(Context context) {
        Intrinsics.h(context, "context");
        if (f63749b == null) {
            f63749b = context.getResources().getDisplayMetrics();
        }
        DisplayMetrics displayMetrics = f63749b;
        if (displayMetrics != null) {
            return displayMetrics.widthPixels;
        }
        return 0;
    }
}

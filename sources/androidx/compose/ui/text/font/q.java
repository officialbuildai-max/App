package androidx.compose.ui.text.font;

import android.content.Context;
import android.os.Build;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f6245a = new q();

    private q() {
    }

    public final int a(Context context) {
        if (Build.VERSION.SDK_INT >= 31) {
            return r.f6246a.a(context);
        }
        return 0;
    }
}

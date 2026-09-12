package o0;

import android.content.Context;

/* loaded from: classes2.dex */
public abstract class a {
    public static final e a(Context context) {
        float f11 = context.getResources().getConfiguration().fontScale;
        float f12 = context.getResources().getDisplayMetrics().density;
        p0.a b11 = p0.b.f72344a.b(f11);
        if (b11 == null) {
            b11 = new v(f11);
        }
        return new h(f12, f11, b11);
    }
}

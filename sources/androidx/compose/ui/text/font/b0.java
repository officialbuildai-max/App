package androidx.compose.ui.text.font;

import android.os.Build;

/* loaded from: classes.dex */
public abstract class b0 {
    public static final x a() {
        return Build.VERSION.SDK_INT >= 28 ? new z() : new a0();
    }

    public static final String b(String str, p pVar) {
        int h11 = pVar.h() / 100;
        if (h11 >= 0 && h11 < 2) {
            return str + "-thin";
        }
        if (2 <= h11 && h11 < 4) {
            return str + "-light";
        }
        if (h11 == 4) {
            return str;
        }
        if (h11 == 5) {
            return str + "-medium";
        }
        if ((6 <= h11 && h11 < 8) || 8 > h11 || h11 >= 11) {
            return str;
        }
        return str + "-black";
    }
}

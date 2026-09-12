package androidx.core.app;

import android.app.LocaleManager;
import android.content.Context;
import android.os.Build;
import android.os.LocaleList;

/* loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }
    }

    public static androidx.core.os.i a(Context context) {
        if (Build.VERSION.SDK_INT < 33) {
            return androidx.core.os.i.c(d.b(context));
        }
        Object b11 = b(context);
        return b11 != null ? androidx.core.os.i.j(a.a(b11)) : androidx.core.os.i.e();
    }

    private static Object b(Context context) {
        return context.getSystemService("locale");
    }
}

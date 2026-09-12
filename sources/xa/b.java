package xa;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;

/* loaded from: classes5.dex */
public class b {
    public static TypedValue a(Context context, int i11) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i11, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean b(Context context, int i11, boolean z10) {
        TypedValue a11 = a(context, i11);
        return (a11 == null || a11.type != 18) ? z10 : a11.data != 0;
    }

    public static int c(Context context, int i11, int i12) {
        TypedValue a11 = a(context, i11);
        return (a11 == null || a11.type != 16) ? i12 : a11.data;
    }

    public static int d(Context context, int i11, String str) {
        return e(context, i11, str).data;
    }

    public static TypedValue e(Context context, int i11, String str) {
        TypedValue a11 = a(context, i11);
        if (a11 != null) {
            return a11;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i11)));
    }

    public static TypedValue f(View view, int i11) {
        return e(view.getContext(), i11, view.getClass().getCanonicalName());
    }
}

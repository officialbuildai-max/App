package xa;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build;

/* loaded from: classes5.dex */
public abstract class h {
    public static Typeface a(Context context, Typeface typeface) {
        return b(context.getResources().getConfiguration(), typeface);
    }

    public static Typeface b(Configuration configuration, Typeface typeface) {
        int i11;
        int i12;
        int weight;
        int i13;
        Typeface create;
        if (Build.VERSION.SDK_INT < 31) {
            return null;
        }
        i11 = configuration.fontWeightAdjustment;
        if (i11 == Integer.MAX_VALUE) {
            return null;
        }
        i12 = configuration.fontWeightAdjustment;
        if (i12 == 0 || typeface == null) {
            return null;
        }
        weight = typeface.getWeight();
        i13 = configuration.fontWeightAdjustment;
        create = Typeface.create(typeface, d1.a.b(weight + i13, 1, 1000), typeface.isItalic());
        return create;
    }
}

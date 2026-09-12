package bb;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.view.d;
import com.google.android.material.R$attr;

/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f16408a = {R.attr.theme, R$attr.theme};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f16409b = {R$attr.materialThemeOverlay};

    private static int a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f16408a);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        return resourceId != 0 ? resourceId : resourceId2;
    }

    private static int b(Context context, AttributeSet attributeSet, int i11, int i12) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f16409b, i11, i12);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public static Context c(Context context, AttributeSet attributeSet, int i11, int i12) {
        int b11 = b(context, attributeSet, i11, i12);
        boolean z10 = (context instanceof d) && ((d) context).c() == b11;
        if (b11 == 0 || z10) {
            return context;
        }
        d dVar = new d(context, b11);
        int a11 = a(context, attributeSet);
        if (a11 != 0) {
            dVar.getTheme().applyStyle(a11, true);
        }
        return dVar;
    }
}

package com.google.android.material.textview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import bb.a;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import xa.b;
import xa.c;

/* loaded from: classes.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(@NonNull Context context) {
        this(context, null);
    }

    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(a.c(context, attributeSet, i11, 0), attributeSet, i11);
        e(attributeSet, i11, 0);
    }

    @Deprecated
    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        super(a.c(context, attributeSet, i11, i12), attributeSet, i11);
        e(attributeSet, i11, i12);
    }

    private void b(Resources.Theme theme, int i11) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(i11, R$styleable.MaterialTextAppearance);
        int f11 = f(getContext(), obtainStyledAttributes, R$styleable.MaterialTextAppearance_android_lineHeight, R$styleable.MaterialTextAppearance_lineHeight);
        obtainStyledAttributes.recycle();
        if (f11 >= 0) {
            setLineHeight(f11);
        }
    }

    private static boolean c(Context context) {
        return b.b(context, R$attr.textAppearanceLineHeightEnabled, true);
    }

    private static int d(Resources.Theme theme, AttributeSet attributeSet, int i11, int i12) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R$styleable.MaterialTextView, i11, i12);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.MaterialTextView_android_textAppearance, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private void e(AttributeSet attributeSet, int i11, int i12) {
        int d11;
        Context context = getContext();
        if (c(context)) {
            Resources.Theme theme = context.getTheme();
            if (g(context, theme, attributeSet, i11, i12) || (d11 = d(theme, attributeSet, i11, i12)) == -1) {
                return;
            }
            b(theme, d11);
        }
    }

    private static int f(Context context, TypedArray typedArray, int... iArr) {
        int i11 = -1;
        for (int i12 = 0; i12 < iArr.length && i11 < 0; i12++) {
            i11 = c.d(context, typedArray, iArr[i12], -1);
        }
        return i11;
    }

    private static boolean g(Context context, Resources.Theme theme, AttributeSet attributeSet, int i11, int i12) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R$styleable.MaterialTextView, i11, i12);
        int f11 = f(context, obtainStyledAttributes, R$styleable.MaterialTextView_android_lineHeight, R$styleable.MaterialTextView_lineHeight);
        obtainStyledAttributes.recycle();
        return f11 != -1;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(@NonNull Context context, int i11) {
        super.setTextAppearance(context, i11);
        if (c(context)) {
            b(context.getTheme(), i11);
        }
    }
}

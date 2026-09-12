package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: classes4.dex */
class a extends c {
    private static float e(float f11) {
        return (float) (1.0d - Math.cos((f11 * 3.141592653589793d) / 2.0d));
    }

    private static float f(float f11) {
        return (float) Math.sin((f11 * 3.141592653589793d) / 2.0d);
    }

    @Override // com.google.android.material.tabs.c
    void d(TabLayout tabLayout, View view, View view2, float f11, Drawable drawable) {
        float f12;
        float e11;
        RectF a11 = c.a(tabLayout, view);
        RectF a12 = c.a(tabLayout, view2);
        if (a11.left < a12.left) {
            f12 = e(f11);
            e11 = f(f11);
        } else {
            f12 = f(f11);
            e11 = e(f11);
        }
        drawable.setBounds(oa.a.c((int) a11.left, (int) a12.left, f12), drawable.getBounds().top, oa.a.c((int) a11.right, (int) a12.right, e11), drawable.getBounds().bottom);
    }
}

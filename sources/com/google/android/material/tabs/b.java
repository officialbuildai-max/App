package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: classes4.dex */
class b extends c {
    @Override // com.google.android.material.tabs.c
    void d(TabLayout tabLayout, View view, View view2, float f11, Drawable drawable) {
        if (f11 >= 0.5f) {
            view = view2;
        }
        RectF a11 = c.a(tabLayout, view);
        float b11 = f11 < 0.5f ? oa.a.b(1.0f, 0.0f, 0.0f, 0.5f, f11) : oa.a.b(0.0f, 1.0f, 0.5f, 1.0f, f11);
        drawable.setBounds((int) a11.left, drawable.getBounds().top, (int) a11.right, drawable.getBounds().bottom);
        drawable.setAlpha((int) (b11 * 255.0f));
    }
}

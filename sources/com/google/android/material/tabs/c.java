package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.internal.f0;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static RectF a(TabLayout tabLayout, View view) {
        return view == null ? new RectF() : (tabLayout.isTabIndicatorFullWidth() || !(view instanceof TabLayout.TabView)) ? new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) : b((TabLayout.TabView) view, 24);
    }

    static RectF b(TabLayout.TabView tabView, int i11) {
        int contentWidth = tabView.getContentWidth();
        int contentHeight = tabView.getContentHeight();
        int g11 = (int) f0.g(tabView.getContext(), i11);
        if (contentWidth < g11) {
            contentWidth = g11;
        }
        int left = (tabView.getLeft() + tabView.getRight()) / 2;
        int top = (tabView.getTop() + tabView.getBottom()) / 2;
        int i12 = contentWidth / 2;
        return new RectF(left - i12, top - (contentHeight / 2), i12 + left, top + (left / 2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(TabLayout tabLayout, View view, Drawable drawable) {
        RectF a11 = a(tabLayout, view);
        drawable.setBounds((int) a11.left, drawable.getBounds().top, (int) a11.right, drawable.getBounds().bottom);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(TabLayout tabLayout, View view, View view2, float f11, Drawable drawable) {
        RectF a11 = a(tabLayout, view);
        RectF a12 = a(tabLayout, view2);
        drawable.setBounds(oa.a.c((int) a11.left, (int) a12.left, f11), drawable.getBounds().top, oa.a.c((int) a11.right, (int) a12.right, f11), drawable.getBounds().bottom);
    }
}

package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class ToolbarUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final Comparator f29188a = new Comparator<View>() { // from class: com.google.android.material.internal.ToolbarUtils.1
        @Override // java.util.Comparator
        public int compare(View view, View view2) {
            return view.getTop() - view2.getTop();
        }
    };

    public static ActionMenuItemView a(Toolbar toolbar, int i11) {
        ActionMenuView b11 = b(toolbar);
        if (b11 == null) {
            return null;
        }
        for (int i12 = 0; i12 < b11.getChildCount(); i12++) {
            View childAt = b11.getChildAt(i12);
            if (childAt instanceof ActionMenuItemView) {
                ActionMenuItemView actionMenuItemView = (ActionMenuItemView) childAt;
                if (actionMenuItemView.getItemData().getItemId() == i11) {
                    return actionMenuItemView;
                }
            }
        }
        return null;
    }

    public static ActionMenuView b(Toolbar toolbar) {
        for (int i11 = 0; i11 < toolbar.getChildCount(); i11++) {
            View childAt = toolbar.getChildAt(i11);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    private static ImageView c(Toolbar toolbar, Drawable drawable) {
        ImageView imageView;
        Drawable drawable2;
        if (drawable == null) {
            return null;
        }
        for (int i11 = 0; i11 < toolbar.getChildCount(); i11++) {
            View childAt = toolbar.getChildAt(i11);
            if ((childAt instanceof ImageView) && (drawable2 = (imageView = (ImageView) childAt).getDrawable()) != null && drawable2.getConstantState() != null && drawable2.getConstantState().equals(drawable.getConstantState())) {
                return imageView;
            }
        }
        return null;
    }

    public static ImageView d(Toolbar toolbar) {
        return c(toolbar, toolbar.getLogo());
    }

    public static ImageButton e(Toolbar toolbar) {
        Drawable navigationIcon = toolbar.getNavigationIcon();
        if (navigationIcon == null) {
            return null;
        }
        for (int i11 = 0; i11 < toolbar.getChildCount(); i11++) {
            View childAt = toolbar.getChildAt(i11);
            if (childAt instanceof ImageButton) {
                ImageButton imageButton = (ImageButton) childAt;
                if (imageButton.getDrawable() == navigationIcon) {
                    return imageButton;
                }
            }
        }
        return null;
    }

    public static View f(Toolbar toolbar) {
        ActionMenuView b11 = b(toolbar);
        if (b11 == null || b11.getChildCount() <= 1) {
            return null;
        }
        return b11.getChildAt(0);
    }

    public static TextView g(Toolbar toolbar) {
        List h11 = h(toolbar, toolbar.getSubtitle());
        if (h11.isEmpty()) {
            return null;
        }
        return (TextView) Collections.max(h11, f29188a);
    }

    private static List h(Toolbar toolbar, CharSequence charSequence) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < toolbar.getChildCount(); i11++) {
            View childAt = toolbar.getChildAt(i11);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    arrayList.add(textView);
                }
            }
        }
        return arrayList;
    }

    public static TextView i(Toolbar toolbar) {
        List h11 = h(toolbar, toolbar.getTitle());
        if (h11.isEmpty()) {
            return null;
        }
        return (TextView) Collections.min(h11, f29188a);
    }
}

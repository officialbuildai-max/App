package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.f;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$dimen;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class BottomNavigationMenuView extends NavigationBarMenuView {
    private final int H;
    private final int I;
    private final int J;
    private final int K;
    private boolean L;
    private final List M;

    public BottomNavigationMenuView(@NonNull Context context) {
        super(context);
        this.M = new ArrayList();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.H = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_item_max_width);
        this.I = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_item_min_width);
        this.J = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_active_item_max_width);
        this.K = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_active_item_min_width);
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    protected NavigationBarItemView d(Context context) {
        return new BottomNavigationItemView(context);
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.L;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        int childCount = getChildCount();
        int i15 = i13 - i11;
        int i16 = i14 - i12;
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                if (ViewCompat.getLayoutDirection(this) == 1) {
                    int i19 = i15 - i17;
                    childAt.layout(i19 - childAt.getMeasuredWidth(), 0, i19, i16);
                } else {
                    childAt.layout(i17, 0, childAt.getMeasuredWidth() + i17, i16);
                }
                i17 += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        int i13;
        int i14;
        f menu = getMenu();
        int size = View.MeasureSpec.getSize(i11);
        int size2 = menu.G().size();
        int childCount = getChildCount();
        this.M.clear();
        int size3 = View.MeasureSpec.getSize(i12);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size3, 1073741824);
        if (f(getLabelVisibilityMode(), size2) && isItemHorizontalTranslationEnabled()) {
            View childAt = getChildAt(getSelectedItemPosition());
            int i15 = this.K;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.J, Integer.MIN_VALUE), makeMeasureSpec);
                i15 = Math.max(i15, childAt.getMeasuredWidth());
            }
            int i16 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int min = Math.min(size - (this.I * i16), Math.min(i15, this.J));
            int i17 = size - min;
            int min2 = Math.min(i17 / (i16 != 0 ? i16 : 1), this.H);
            int i18 = i17 - (i16 * min2);
            int i19 = 0;
            while (i19 < childCount) {
                if (getChildAt(i19).getVisibility() != 8) {
                    i14 = i19 == getSelectedItemPosition() ? min : min2;
                    if (i18 > 0) {
                        i14++;
                        i18--;
                    }
                } else {
                    i14 = 0;
                }
                this.M.add(Integer.valueOf(i14));
                i19++;
            }
        } else {
            int min3 = Math.min(size / (size2 != 0 ? size2 : 1), this.J);
            int i20 = size - (size2 * min3);
            for (int i21 = 0; i21 < childCount; i21++) {
                if (getChildAt(i21).getVisibility() == 8) {
                    i13 = 0;
                } else if (i20 > 0) {
                    i13 = min3 + 1;
                    i20--;
                } else {
                    i13 = min3;
                }
                this.M.add(Integer.valueOf(i13));
            }
        }
        int i22 = 0;
        for (int i23 = 0; i23 < childCount; i23++) {
            View childAt2 = getChildAt(i23);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(((Integer) this.M.get(i23)).intValue(), 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i22 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(i22, size3);
    }

    public void setItemHorizontalTranslationEnabled(boolean z10) {
        this.L = z10;
    }
}

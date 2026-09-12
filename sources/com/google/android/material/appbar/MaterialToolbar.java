package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.internal.ToolbarUtils;

/* loaded from: classes4.dex */
public class MaterialToolbar extends Toolbar {

    /* renamed from: c0, reason: collision with root package name */
    private static final int f28308c0 = R$style.Widget_MaterialComponents_Toolbar;

    /* renamed from: d0, reason: collision with root package name */
    private static final ImageView.ScaleType[] f28309d0 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    private Integer U;
    private boolean V;
    private boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private ImageView.ScaleType f28310a0;

    /* renamed from: b0, reason: collision with root package name */
    private Boolean f28311b0;

    public MaterialToolbar(@NonNull Context context) {
        this(context, null);
    }

    public MaterialToolbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.toolbarStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialToolbar(@androidx.annotation.NonNull android.content.Context r8, @androidx.annotation.Nullable android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = com.google.android.material.appbar.MaterialToolbar.f28308c0
            android.content.Context r8 = bb.a.c(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.content.Context r8 = r7.getContext()
            int[] r2 = com.google.android.material.R$styleable.MaterialToolbar
            r6 = 0
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.b0.i(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.R$styleable.MaterialToolbar_navigationIconTint
            boolean r10 = r9.hasValue(r10)
            r0 = -1
            if (r10 == 0) goto L2b
            int r10 = com.google.android.material.R$styleable.MaterialToolbar_navigationIconTint
            int r10 = r9.getColor(r10, r0)
            r7.setNavigationIconTint(r10)
        L2b:
            int r10 = com.google.android.material.R$styleable.MaterialToolbar_titleCentered
            boolean r10 = r9.getBoolean(r10, r6)
            r7.V = r10
            int r10 = com.google.android.material.R$styleable.MaterialToolbar_subtitleCentered
            boolean r10 = r9.getBoolean(r10, r6)
            r7.W = r10
            int r10 = com.google.android.material.R$styleable.MaterialToolbar_logoScaleType
            int r10 = r9.getInt(r10, r0)
            if (r10 < 0) goto L4c
            android.widget.ImageView$ScaleType[] r0 = com.google.android.material.appbar.MaterialToolbar.f28309d0
            int r1 = r0.length
            if (r10 >= r1) goto L4c
            r10 = r0[r10]
            r7.f28310a0 = r10
        L4c:
            int r10 = com.google.android.material.R$styleable.MaterialToolbar_logoAdjustViewBounds
            boolean r10 = r9.hasValue(r10)
            if (r10 == 0) goto L60
            int r10 = com.google.android.material.R$styleable.MaterialToolbar_logoAdjustViewBounds
            boolean r10 = r9.getBoolean(r10, r6)
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            r7.f28311b0 = r10
        L60:
            r9.recycle()
            r7.D(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.MaterialToolbar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private Pair C(TextView textView, TextView textView2) {
        int measuredWidth = getMeasuredWidth();
        int i11 = measuredWidth / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = measuredWidth - getPaddingRight();
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                if (childAt.getRight() < i11 && childAt.getRight() > paddingLeft) {
                    paddingLeft = childAt.getRight();
                }
                if (childAt.getLeft() > i11 && childAt.getLeft() < paddingRight) {
                    paddingRight = childAt.getLeft();
                }
            }
        }
        return new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
    }

    private void D(Context context) {
        Drawable background = getBackground();
        ColorStateList valueOf = background == null ? ColorStateList.valueOf(0) : com.google.android.material.drawable.d.g(background);
        if (valueOf != null) {
            ab.i iVar = new ab.i();
            iVar.d0(valueOf);
            iVar.S(context);
            iVar.c0(ViewCompat.getElevation(this));
            ViewCompat.setBackground(this, iVar);
        }
    }

    private void E(View view, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = view.getMeasuredWidth();
        int i11 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i12 = measuredWidth2 + i11;
        int max = Math.max(Math.max(((Integer) pair.first).intValue() - i11, 0), Math.max(i12 - ((Integer) pair.second).intValue(), 0));
        if (max > 0) {
            i11 += max;
            i12 -= max;
            view.measure(View.MeasureSpec.makeMeasureSpec(i12 - i11, 1073741824), view.getMeasuredHeightAndState());
        }
        view.layout(i11, view.getTop(), i12, view.getBottom());
    }

    private void F() {
        if (this.V || this.W) {
            TextView i11 = ToolbarUtils.i(this);
            TextView g11 = ToolbarUtils.g(this);
            if (i11 == null && g11 == null) {
                return;
            }
            Pair C = C(i11, g11);
            if (this.V && i11 != null) {
                E(i11, C);
            }
            if (!this.W || g11 == null) {
                return;
            }
            E(g11, C);
        }
    }

    private Drawable G(Drawable drawable) {
        if (drawable == null || this.U == null) {
            return drawable;
        }
        Drawable r11 = a1.a.r(drawable.mutate());
        a1.a.n(r11, this.U.intValue());
        return r11;
    }

    private void H() {
        ImageView d11 = ToolbarUtils.d(this);
        if (d11 != null) {
            Boolean bool = this.f28311b0;
            if (bool != null) {
                d11.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.f28310a0;
            if (scaleType != null) {
                d11.setScaleType(scaleType);
            }
        }
    }

    public void clearNavigationIconTint() {
        this.U = null;
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            a1.a.o(a1.a.r(navigationIcon.mutate()), null);
            setNavigationIcon(navigationIcon);
        }
    }

    @Nullable
    public ImageView.ScaleType getLogoScaleType() {
        return this.f28310a0;
    }

    @Nullable
    public Integer getNavigationIconTint() {
        return this.U;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void inflateMenu(int i11) {
        Menu menu = getMenu();
        boolean z10 = menu instanceof androidx.appcompat.view.menu.f;
        if (z10) {
            ((androidx.appcompat.view.menu.f) menu).i0();
        }
        super.inflateMenu(i11);
        if (z10) {
            ((androidx.appcompat.view.menu.f) menu).h0();
        }
    }

    public boolean isLogoAdjustViewBounds() {
        Boolean bool = this.f28311b0;
        return bool != null && bool.booleanValue();
    }

    public boolean isSubtitleCentered() {
        return this.W;
    }

    public boolean isTitleCentered() {
        return this.V;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ab.j.e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        super.onLayout(z10, i11, i12, i13, i14);
        F();
        H();
    }

    @Override // android.view.View
    public void setElevation(float f11) {
        super.setElevation(f11);
        ab.j.d(this, f11);
    }

    public void setLogoAdjustViewBounds(boolean z10) {
        Boolean bool = this.f28311b0;
        if (bool == null || bool.booleanValue() != z10) {
            this.f28311b0 = Boolean.valueOf(z10);
            requestLayout();
        }
    }

    public void setLogoScaleType(@NonNull ImageView.ScaleType scaleType) {
        if (this.f28310a0 != scaleType) {
            this.f28310a0 = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@Nullable Drawable drawable) {
        super.setNavigationIcon(G(drawable));
    }

    public void setNavigationIconTint(int i11) {
        this.U = Integer.valueOf(i11);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z10) {
        if (this.W != z10) {
            this.W = z10;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z10) {
        if (this.V != z10) {
            this.V = z10;
            requestLayout();
        }
    }
}

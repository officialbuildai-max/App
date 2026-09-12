package com.google.android.material.navigationrail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.j0;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.f0;
import com.google.android.material.navigation.NavigationBarView;
import z0.c;

/* loaded from: classes4.dex */
public class NavigationRailView extends NavigationBarView {

    /* renamed from: e, reason: collision with root package name */
    private final int f29449e;

    /* renamed from: f, reason: collision with root package name */
    private View f29450f;

    /* renamed from: g, reason: collision with root package name */
    private Boolean f29451g;

    /* renamed from: h, reason: collision with root package name */
    private Boolean f29452h;

    /* renamed from: i, reason: collision with root package name */
    private Boolean f29453i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements f0.d {
        a() {
        }

        @Override // com.google.android.material.internal.f0.d
        public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, f0.e eVar) {
            c insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
            NavigationRailView navigationRailView = NavigationRailView.this;
            if (navigationRailView.l(navigationRailView.f29451g)) {
                eVar.f29262b += insets.f79249b;
            }
            NavigationRailView navigationRailView2 = NavigationRailView.this;
            if (navigationRailView2.l(navigationRailView2.f29452h)) {
                eVar.f29264d += insets.f79251d;
            }
            NavigationRailView navigationRailView3 = NavigationRailView.this;
            if (navigationRailView3.l(navigationRailView3.f29453i)) {
                eVar.f29261a += f0.p(view) ? insets.f79250c : insets.f79248a;
            }
            eVar.a(view);
            return windowInsetsCompat;
        }
    }

    public NavigationRailView(@NonNull Context context) {
        this(context, null);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.navigationRailStyle);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, R$style.Widget_MaterialComponents_NavigationRailView);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f29451g = null;
        this.f29452h = null;
        this.f29453i = null;
        this.f29449e = getResources().getDimensionPixelSize(R$dimen.mtrl_navigation_rail_margin);
        Context context2 = getContext();
        j0 j11 = b0.j(context2, attributeSet, R$styleable.NavigationRailView, i11, i12, new int[0]);
        int n11 = j11.n(R$styleable.NavigationRailView_headerLayout, 0);
        if (n11 != 0) {
            addHeaderView(n11);
        }
        setMenuGravity(j11.k(R$styleable.NavigationRailView_menuGravity, 49));
        if (j11.s(R$styleable.NavigationRailView_itemMinHeight)) {
            setItemMinimumHeight(j11.f(R$styleable.NavigationRailView_itemMinHeight, -1));
        }
        if (j11.s(R$styleable.NavigationRailView_paddingTopSystemWindowInsets)) {
            this.f29451g = Boolean.valueOf(j11.a(R$styleable.NavigationRailView_paddingTopSystemWindowInsets, false));
        }
        if (j11.s(R$styleable.NavigationRailView_paddingBottomSystemWindowInsets)) {
            this.f29452h = Boolean.valueOf(j11.a(R$styleable.NavigationRailView_paddingBottomSystemWindowInsets, false));
        }
        if (j11.s(R$styleable.NavigationRailView_paddingStartSystemWindowInsets)) {
            this.f29453i = Boolean.valueOf(j11.a(R$styleable.NavigationRailView_paddingStartSystemWindowInsets, false));
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.m3_navigation_rail_item_padding_top_with_large_font);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R$dimen.m3_navigation_rail_item_padding_bottom_with_large_font);
        float b11 = oa.a.b(0.0f, 1.0f, 0.3f, 1.0f, xa.c.f(context2) - 1.0f);
        float c11 = oa.a.c(getItemPaddingTop(), dimensionPixelOffset, b11);
        float c12 = oa.a.c(getItemPaddingBottom(), dimensionPixelOffset2, b11);
        setItemPaddingTop(Math.round(c11));
        setItemPaddingBottom(Math.round(c12));
        j11.x();
        h();
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView) getMenuView();
    }

    private void h() {
        f0.f(this, new a());
    }

    private boolean j() {
        View view = this.f29450f;
        return (view == null || view.getVisibility() == 8) ? false : true;
    }

    private int k(int i11) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i11) == 1073741824 || suggestedMinimumWidth <= 0) {
            return i11;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i11), suggestedMinimumWidth + getPaddingLeft() + getPaddingRight()), 1073741824);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(Boolean bool) {
        return bool != null ? bool.booleanValue() : ViewCompat.getFitsSystemWindows(this);
    }

    public void addHeaderView(int i11) {
        addHeaderView(LayoutInflater.from(getContext()).inflate(i11, (ViewGroup) this, false));
    }

    public void addHeaderView(@NonNull View view) {
        removeHeaderView();
        this.f29450f = view;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = this.f29449e;
        addView(view, 0, layoutParams);
    }

    @Nullable
    public View getHeaderView() {
        return this.f29450f;
    }

    public int getItemMinimumHeight() {
        return ((NavigationRailMenuView) getMenuView()).getItemMinimumHeight();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 7;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.navigation.NavigationBarView
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public NavigationRailMenuView c(Context context) {
        return new NavigationRailMenuView(context);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        super.onLayout(z10, i11, i12, i13, i14);
        NavigationRailMenuView navigationRailMenuView = getNavigationRailMenuView();
        int i15 = 0;
        if (j()) {
            int bottom = this.f29450f.getBottom() + this.f29449e;
            int top = navigationRailMenuView.getTop();
            if (top < bottom) {
                i15 = bottom - top;
            }
        } else if (navigationRailMenuView.m()) {
            i15 = this.f29449e;
        }
        if (i15 > 0) {
            navigationRailMenuView.layout(navigationRailMenuView.getLeft(), navigationRailMenuView.getTop() + i15, navigationRailMenuView.getRight(), navigationRailMenuView.getBottom() + i15);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i11, int i12) {
        int k11 = k(i11);
        super.onMeasure(k11, i12);
        if (j()) {
            measureChild(getNavigationRailMenuView(), k11, View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.f29450f.getMeasuredHeight()) - this.f29449e, Integer.MIN_VALUE));
        }
    }

    public void removeHeaderView() {
        View view = this.f29450f;
        if (view != null) {
            removeView(view);
            this.f29450f = null;
        }
    }

    public void setItemMinimumHeight(int i11) {
        ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(i11);
    }

    public void setMenuGravity(int i11) {
        getNavigationRailMenuView().setMenuGravity(i11);
    }
}

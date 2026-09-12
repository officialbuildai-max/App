package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;

/* loaded from: classes.dex */
public class ActionBarContextView extends AbsActionBarView {

    /* renamed from: i, reason: collision with root package name */
    private CharSequence f1640i;

    /* renamed from: j, reason: collision with root package name */
    private CharSequence f1641j;

    /* renamed from: k, reason: collision with root package name */
    private View f1642k;

    /* renamed from: l, reason: collision with root package name */
    private View f1643l;

    /* renamed from: m, reason: collision with root package name */
    private View f1644m;

    /* renamed from: n, reason: collision with root package name */
    private LinearLayout f1645n;

    /* renamed from: o, reason: collision with root package name */
    private TextView f1646o;

    /* renamed from: p, reason: collision with root package name */
    private TextView f1647p;

    /* renamed from: q, reason: collision with root package name */
    private int f1648q;

    /* renamed from: r, reason: collision with root package name */
    private int f1649r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f1650s;

    /* renamed from: t, reason: collision with root package name */
    private int f1651t;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ androidx.appcompat.view.b f1652a;

        a(androidx.appcompat.view.b bVar) {
            this.f1652a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f1652a.c();
        }
    }

    public ActionBarContextView(@NonNull Context context) {
        this(context, null);
    }

    public ActionBarContextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.actionModeStyle);
    }

    public ActionBarContextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        j0 v11 = j0.v(context, attributeSet, R$styleable.ActionMode, i11, 0);
        setBackground(v11.g(R$styleable.ActionMode_background));
        this.f1648q = v11.n(R$styleable.ActionMode_titleTextStyle, 0);
        this.f1649r = v11.n(R$styleable.ActionMode_subtitleTextStyle, 0);
        this.f1623e = v11.m(R$styleable.ActionMode_height, 0);
        this.f1651t = v11.n(R$styleable.ActionMode_closeItemLayout, R$layout.abc_action_mode_close_item_material);
        v11.x();
    }

    private void f() {
        if (this.f1645n == null) {
            LayoutInflater.from(getContext()).inflate(R$layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1645n = linearLayout;
            this.f1646o = (TextView) linearLayout.findViewById(R$id.action_bar_title);
            this.f1647p = (TextView) this.f1645n.findViewById(R$id.action_bar_subtitle);
            if (this.f1648q != 0) {
                this.f1646o.setTextAppearance(getContext(), this.f1648q);
            }
            if (this.f1649r != 0) {
                this.f1647p.setTextAppearance(getContext(), this.f1649r);
            }
        }
        this.f1646o.setText(this.f1640i);
        this.f1647p.setText(this.f1641j);
        boolean isEmpty = TextUtils.isEmpty(this.f1640i);
        boolean isEmpty2 = TextUtils.isEmpty(this.f1641j);
        this.f1647p.setVisibility(!isEmpty2 ? 0 : 8);
        this.f1645n.setVisibility((isEmpty && isEmpty2) ? 8 : 0);
        if (this.f1645n.getParent() == null) {
            addView(this.f1645n);
        }
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void animateToVisibility(int i11) {
        super.animateToVisibility(i11);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean canShowOverflowMenu() {
        return super.canShowOverflowMenu();
    }

    public void closeMode() {
        if (this.f1642k == null) {
            killMode();
        }
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void dismissPopupMenus() {
        super.dismissPopupMenus();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f1641j;
    }

    public CharSequence getTitle() {
        return this.f1640i;
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.f1622d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.D();
        }
        return false;
    }

    public void initForMode(androidx.appcompat.view.b bVar) {
        View view = this.f1642k;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.f1651t, (ViewGroup) this, false);
            this.f1642k = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.f1642k);
        }
        View findViewById = this.f1642k.findViewById(R$id.action_mode_close_button);
        this.f1643l = findViewById;
        findViewById.setOnClickListener(new a(bVar));
        androidx.appcompat.view.menu.f fVar = (androidx.appcompat.view.menu.f) bVar.e();
        ActionMenuPresenter actionMenuPresenter = this.f1622d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.A();
        }
        ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
        this.f1622d = actionMenuPresenter2;
        actionMenuPresenter2.M(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        fVar.c(this.f1622d, this.f1620b);
        ActionMenuView actionMenuView = (ActionMenuView) this.f1622d.q(this);
        this.f1621c = actionMenuView;
        actionMenuView.setBackground(null);
        addView(this.f1621c, layoutParams);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean isOverflowMenuShowPending() {
        return super.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter actionMenuPresenter = this.f1622d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.G();
        }
        return false;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean isOverflowReserved() {
        return super.isOverflowReserved();
    }

    public boolean isTitleOptional() {
        return this.f1650s;
    }

    public void killMode() {
        removeAllViews();
        this.f1644m = null;
        this.f1621c = null;
        this.f1622d = null;
        View view = this.f1643l;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.f1622d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.D();
            this.f1622d.E();
        }
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        boolean b11 = u0.b(this);
        int paddingRight = b11 ? (i13 - i11) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i14 - i12) - getPaddingTop()) - getPaddingBottom();
        View view = this.f1642k;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1642k.getLayoutParams();
            int i15 = b11 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i16 = b11 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int d11 = AbsActionBarView.d(paddingRight, i15, b11);
            paddingRight = AbsActionBarView.d(d11 + e(this.f1642k, d11, paddingTop, paddingTop2, b11), i16, b11);
        }
        int i17 = paddingRight;
        LinearLayout linearLayout = this.f1645n;
        if (linearLayout != null && this.f1644m == null && linearLayout.getVisibility() != 8) {
            i17 += e(this.f1645n, i17, paddingTop, paddingTop2, b11);
        }
        int i18 = i17;
        View view2 = this.f1644m;
        if (view2 != null) {
            e(view2, i18, paddingTop, paddingTop2, b11);
        }
        int paddingLeft = b11 ? getPaddingLeft() : (i13 - i11) - getPaddingRight();
        ActionMenuView actionMenuView = this.f1621c;
        if (actionMenuView != null) {
            e(actionMenuView, paddingLeft, paddingTop, paddingTop2, !b11);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        if (View.MeasureSpec.getMode(i11) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i12) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i11);
        int i13 = this.f1623e;
        if (i13 <= 0) {
            i13 = View.MeasureSpec.getSize(i12);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int i14 = i13 - paddingTop;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i14, Integer.MIN_VALUE);
        View view = this.f1642k;
        if (view != null) {
            int c11 = c(view, paddingLeft, makeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1642k.getLayoutParams();
            paddingLeft = c11 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f1621c;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = c(this.f1621c, paddingLeft, makeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.f1645n;
        if (linearLayout != null && this.f1644m == null) {
            if (this.f1650s) {
                this.f1645n.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                int measuredWidth = this.f1645n.getMeasuredWidth();
                boolean z10 = measuredWidth <= paddingLeft;
                if (z10) {
                    paddingLeft -= measuredWidth;
                }
                this.f1645n.setVisibility(z10 ? 0 : 8);
            } else {
                paddingLeft = c(linearLayout, paddingLeft, makeMeasureSpec, 0);
            }
        }
        View view2 = this.f1644m;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i15 = layoutParams.width;
            int i16 = i15 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i15 >= 0) {
                paddingLeft = Math.min(i15, paddingLeft);
            }
            int i17 = layoutParams.height;
            int i18 = i17 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i17 >= 0) {
                i14 = Math.min(i17, i14);
            }
            this.f1644m.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i16), View.MeasureSpec.makeMeasureSpec(i14, i18));
        }
        if (this.f1623e > 0) {
            setMeasuredDimension(size, i13);
            return;
        }
        int childCount = getChildCount();
        int i19 = 0;
        for (int i20 = 0; i20 < childCount; i20++) {
            int measuredHeight = getChildAt(i20).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i19) {
                i19 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i19);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void postShowOverflowMenu() {
        super.postShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public void setContentHeight(int i11) {
        this.f1623e = i11;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f1644m;
        if (view2 != null) {
            removeView(view2);
        }
        this.f1644m = view;
        if (view != null && (linearLayout = this.f1645n) != null) {
            removeView(linearLayout);
            this.f1645n = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1641j = charSequence;
        f();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1640i = charSequence;
        f();
        ViewCompat.setAccessibilityPaneTitle(this, charSequence);
    }

    public void setTitleOptional(boolean z10) {
        if (z10 != this.f1650s) {
            requestLayout();
        }
        this.f1650s = z10;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i11) {
        super.setVisibility(i11);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ ViewPropertyAnimatorCompat setupAnimatorToVisibility(int i11, long j11) {
        return super.setupAnimatorToVisibility(i11, j11);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public boolean showOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.f1622d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.N();
        }
        return false;
    }
}

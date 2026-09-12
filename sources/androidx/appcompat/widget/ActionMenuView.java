package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.LinearLayoutCompat;

/* loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements f.b, androidx.appcompat.view.menu.m {

    /* renamed from: a, reason: collision with root package name */
    private androidx.appcompat.view.menu.f f1704a;

    /* renamed from: b, reason: collision with root package name */
    private Context f1705b;

    /* renamed from: c, reason: collision with root package name */
    private int f1706c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f1707d;

    /* renamed from: e, reason: collision with root package name */
    private ActionMenuPresenter f1708e;

    /* renamed from: f, reason: collision with root package name */
    private l.a f1709f;

    /* renamed from: g, reason: collision with root package name */
    f.a f1710g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1711h;

    /* renamed from: i, reason: collision with root package name */
    private int f1712i;

    /* renamed from: j, reason: collision with root package name */
    private int f1713j;

    /* renamed from: k, reason: collision with root package name */
    private int f1714k;

    /* renamed from: l, reason: collision with root package name */
    e f1715l;

    /* loaded from: classes.dex */
    public interface a {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements l.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.l.a
        public void b(androidx.appcompat.view.menu.f fVar, boolean z10) {
        }

        @Override // androidx.appcompat.view.menu.l.a
        public boolean c(androidx.appcompat.view.menu.f fVar) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends LinearLayoutCompat.a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1716a;

        /* renamed from: b, reason: collision with root package name */
        public int f1717b;

        /* renamed from: c, reason: collision with root package name */
        public int f1718c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f1719d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f1720e;

        /* renamed from: f, reason: collision with root package name */
        boolean f1721f;

        public c(int i11, int i12) {
            super(i11, i12);
            this.f1716a = false;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super((ViewGroup.LayoutParams) cVar);
            this.f1716a = cVar.f1716a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements f.a {
        d() {
        }

        @Override // androidx.appcompat.view.menu.f.a
        public boolean a(androidx.appcompat.view.menu.f fVar, MenuItem menuItem) {
            e eVar = ActionMenuView.this.f1715l;
            return eVar != null && eVar.onMenuItemClick(menuItem);
        }

        @Override // androidx.appcompat.view.menu.f.a
        public void b(androidx.appcompat.view.menu.f fVar) {
            f.a aVar = ActionMenuView.this.f1710g;
            if (aVar != null) {
                aVar.b(fVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(@NonNull Context context) {
        this(context, null);
    }

    public ActionMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f11 = context.getResources().getDisplayMetrics().density;
        this.f1713j = (int) (56.0f * f11);
        this.f1714k = (int) (f11 * 4.0f);
        this.f1705b = context;
        this.f1706c = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(View view, int i11, int i12, int i13, int i14) {
        int i15;
        c cVar = (c) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i13) - i14, View.MeasureSpec.getMode(i13));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z10 = false;
        boolean z11 = actionMenuItemView != null && actionMenuItemView.hasText();
        if (i12 > 0) {
            i15 = 2;
            if (!z11 || i12 >= 2) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i12 * i11, Integer.MIN_VALUE), makeMeasureSpec);
                int measuredWidth = view.getMeasuredWidth();
                int i16 = measuredWidth / i11;
                if (measuredWidth % i11 != 0) {
                    i16++;
                }
                if (!z11 || i16 >= 2) {
                    i15 = i16;
                }
                if (!cVar.f1716a && z11) {
                    z10 = true;
                }
                cVar.f1719d = z10;
                cVar.f1717b = i15;
                view.measure(View.MeasureSpec.makeMeasureSpec(i11 * i15, 1073741824), makeMeasureSpec);
                return i15;
            }
        }
        i15 = 0;
        if (!cVar.f1716a) {
            z10 = true;
        }
        cVar.f1719d = z10;
        cVar.f1717b = i15;
        view.measure(View.MeasureSpec.makeMeasureSpec(i11 * i15, 1073741824), makeMeasureSpec);
        return i15;
    }

    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r14v14 */
    private void h(int i11, int i12) {
        int i13;
        int i14;
        boolean z10;
        int i15;
        int i16;
        boolean z11;
        boolean z12;
        int i17;
        ?? r14;
        int mode = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i12, paddingTop, -2);
        int i18 = size - paddingLeft;
        int i19 = this.f1713j;
        int i20 = i18 / i19;
        int i21 = i18 % i19;
        if (i20 == 0) {
            setMeasuredDimension(i18, 0);
            return;
        }
        int i22 = i19 + (i21 / i20);
        int childCount = getChildCount();
        int i23 = 0;
        int i24 = 0;
        boolean z13 = false;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        long j11 = 0;
        while (i24 < childCount) {
            View childAt = getChildAt(i24);
            int i28 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z14 = childAt instanceof ActionMenuItemView;
                int i29 = i25 + 1;
                if (z14) {
                    int i30 = this.f1714k;
                    i17 = i29;
                    r14 = 0;
                    childAt.setPadding(i30, 0, i30, 0);
                } else {
                    i17 = i29;
                    r14 = 0;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.f1721f = r14;
                cVar.f1718c = r14;
                cVar.f1717b = r14;
                cVar.f1719d = r14;
                ((LinearLayout.LayoutParams) cVar).leftMargin = r14;
                ((LinearLayout.LayoutParams) cVar).rightMargin = r14;
                cVar.f1720e = z14 && ((ActionMenuItemView) childAt).hasText();
                int g11 = g(childAt, i22, cVar.f1716a ? 1 : i20, childMeasureSpec, paddingTop);
                i26 = Math.max(i26, g11);
                if (cVar.f1719d) {
                    i27++;
                }
                if (cVar.f1716a) {
                    z13 = true;
                }
                i20 -= g11;
                i23 = Math.max(i23, childAt.getMeasuredHeight());
                if (g11 == 1) {
                    j11 |= 1 << i24;
                    i23 = i23;
                }
                i25 = i17;
            }
            i24++;
            size2 = i28;
        }
        int i31 = size2;
        boolean z15 = z13 && i25 == 2;
        boolean z16 = false;
        while (i27 > 0 && i20 > 0) {
            int i32 = Integer.MAX_VALUE;
            int i33 = 0;
            int i34 = 0;
            long j12 = 0;
            while (i34 < childCount) {
                boolean z17 = z16;
                c cVar2 = (c) getChildAt(i34).getLayoutParams();
                int i35 = i23;
                if (cVar2.f1719d) {
                    int i36 = cVar2.f1717b;
                    if (i36 < i32) {
                        j12 = 1 << i34;
                        i32 = i36;
                        i33 = 1;
                    } else if (i36 == i32) {
                        i33++;
                        j12 |= 1 << i34;
                    }
                }
                i34++;
                i23 = i35;
                z16 = z17;
            }
            z10 = z16;
            i15 = i23;
            j11 |= j12;
            if (i33 > i20) {
                i13 = mode;
                i14 = i18;
                break;
            }
            int i37 = i32 + 1;
            int i38 = 0;
            while (i38 < childCount) {
                View childAt2 = getChildAt(i38);
                c cVar3 = (c) childAt2.getLayoutParams();
                int i39 = i18;
                int i40 = mode;
                long j13 = 1 << i38;
                if ((j12 & j13) == 0) {
                    if (cVar3.f1717b == i37) {
                        j11 |= j13;
                    }
                    z12 = z15;
                } else {
                    if (z15 && cVar3.f1720e && i20 == 1) {
                        int i41 = this.f1714k;
                        z12 = z15;
                        childAt2.setPadding(i41 + i22, 0, i41, 0);
                    } else {
                        z12 = z15;
                    }
                    cVar3.f1717b++;
                    cVar3.f1721f = true;
                    i20--;
                }
                i38++;
                mode = i40;
                i18 = i39;
                z15 = z12;
            }
            i23 = i15;
            z16 = true;
        }
        i13 = mode;
        i14 = i18;
        z10 = z16;
        i15 = i23;
        boolean z18 = !z13 && i25 == 1;
        if (i20 <= 0 || j11 == 0 || (i20 >= i25 - 1 && !z18 && i26 <= 1)) {
            i16 = 0;
            z11 = z10;
        } else {
            float bitCount = Long.bitCount(j11);
            if (z18) {
                i16 = 0;
            } else {
                i16 = 0;
                if ((j11 & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).f1720e) {
                    bitCount -= 0.5f;
                }
                int i42 = childCount - 1;
                if ((j11 & (1 << i42)) != 0 && !((c) getChildAt(i42).getLayoutParams()).f1720e) {
                    bitCount -= 0.5f;
                }
            }
            int i43 = bitCount > 0.0f ? (int) ((i20 * i22) / bitCount) : i16;
            z11 = z10;
            for (int i44 = i16; i44 < childCount; i44++) {
                if ((j11 & (1 << i44)) != 0) {
                    View childAt3 = getChildAt(i44);
                    c cVar4 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar4.f1718c = i43;
                        cVar4.f1721f = true;
                        if (i44 == 0 && !cVar4.f1720e) {
                            ((LinearLayout.LayoutParams) cVar4).leftMargin = (-i43) / 2;
                        }
                        z11 = true;
                    } else if (cVar4.f1716a) {
                        cVar4.f1718c = i43;
                        cVar4.f1721f = true;
                        ((LinearLayout.LayoutParams) cVar4).rightMargin = (-i43) / 2;
                        z11 = true;
                    } else {
                        if (i44 != 0) {
                            ((LinearLayout.LayoutParams) cVar4).leftMargin = i43 / 2;
                        }
                        if (i44 != childCount - 1) {
                            ((LinearLayout.LayoutParams) cVar4).rightMargin = i43 / 2;
                        }
                    }
                }
            }
        }
        if (z11) {
            for (int i45 = i16; i45 < childCount; i45++) {
                View childAt4 = getChildAt(i45);
                c cVar5 = (c) childAt4.getLayoutParams();
                if (cVar5.f1721f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.f1717b * i22) + cVar5.f1718c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i14, i13 != 1073741824 ? i15 : i31);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        c cVar = new c(-2, -2);
        ((LinearLayout.LayoutParams) cVar).gravity = 16;
        return cVar;
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter actionMenuPresenter = this.f1708e;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.A();
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (((LinearLayout.LayoutParams) cVar).gravity <= 0) {
            ((LinearLayout.LayoutParams) cVar).gravity = 16;
        }
        return cVar;
    }

    protected boolean f(int i11) {
        boolean z10 = false;
        if (i11 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i11 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i11);
        if (i11 < getChildCount() && (childAt instanceof a)) {
            z10 = ((a) childAt).needsDividerAfter();
        }
        return (i11 <= 0 || !(childAt2 instanceof a)) ? z10 : z10 | ((a) childAt2).needsDividerBefore();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public c generateOverflowButtonLayoutParams() {
        c generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.f1716a = true;
        return generateDefaultLayoutParams;
    }

    public Menu getMenu() {
        if (this.f1704a == null) {
            Context context = getContext();
            androidx.appcompat.view.menu.f fVar = new androidx.appcompat.view.menu.f(context);
            this.f1704a = fVar;
            fVar.W(new d());
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.f1708e = actionMenuPresenter;
            actionMenuPresenter.M(true);
            ActionMenuPresenter actionMenuPresenter2 = this.f1708e;
            l.a aVar = this.f1709f;
            if (aVar == null) {
                aVar = new b();
            }
            actionMenuPresenter2.d(aVar);
            this.f1704a.c(this.f1708e, this.f1705b);
            this.f1708e.K(this);
        }
        return this.f1704a;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        getMenu();
        return this.f1708e.C();
    }

    public int getPopupTheme() {
        return this.f1706c;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.f1708e;
        return actionMenuPresenter != null && actionMenuPresenter.D();
    }

    @Override // androidx.appcompat.view.menu.m
    public void initialize(androidx.appcompat.view.menu.f fVar) {
        this.f1704a = fVar;
    }

    @Override // androidx.appcompat.view.menu.f.b
    public boolean invokeItem(androidx.appcompat.view.menu.h hVar) {
        return this.f1704a.O(hVar, 0);
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter actionMenuPresenter = this.f1708e;
        return actionMenuPresenter != null && actionMenuPresenter.F();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter actionMenuPresenter = this.f1708e;
        return actionMenuPresenter != null && actionMenuPresenter.G();
    }

    public boolean isOverflowReserved() {
        return this.f1707d;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.f1708e;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.h(false);
            if (this.f1708e.G()) {
                this.f1708e.D();
                this.f1708e.N();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        int width;
        int i15;
        if (!this.f1711h) {
            super.onLayout(z10, i11, i12, i13, i14);
            return;
        }
        int childCount = getChildCount();
        int i16 = (i14 - i12) / 2;
        int dividerWidth = getDividerWidth();
        int i17 = i13 - i11;
        int paddingRight = (i17 - getPaddingRight()) - getPaddingLeft();
        boolean b11 = u0.b(this);
        int i18 = 0;
        int i19 = 0;
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt = getChildAt(i20);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f1716a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (f(i20)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (b11) {
                        i15 = getPaddingLeft() + ((LinearLayout.LayoutParams) cVar).leftMargin;
                        width = i15 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) cVar).rightMargin;
                        i15 = width - measuredWidth;
                    }
                    int i21 = i16 - (measuredHeight / 2);
                    childAt.layout(i15, i21, width, measuredHeight + i21);
                    paddingRight -= measuredWidth;
                    i18 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) cVar).leftMargin) + ((LinearLayout.LayoutParams) cVar).rightMargin;
                    f(i20);
                    i19++;
                }
            }
        }
        if (childCount == 1 && i18 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i22 = (i17 / 2) - (measuredWidth2 / 2);
            int i23 = i16 - (measuredHeight2 / 2);
            childAt2.layout(i22, i23, measuredWidth2 + i22, measuredHeight2 + i23);
            return;
        }
        int i24 = i19 - (i18 ^ 1);
        int max = Math.max(0, i24 > 0 ? paddingRight / i24 : 0);
        if (b11) {
            int width2 = getWidth() - getPaddingRight();
            for (int i25 = 0; i25 < childCount; i25++) {
                View childAt3 = getChildAt(i25);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f1716a) {
                    int i26 = width2 - ((LinearLayout.LayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i27 = i16 - (measuredHeight3 / 2);
                    childAt3.layout(i26 - measuredWidth3, i27, i26, measuredHeight3 + i27);
                    width2 = i26 - ((measuredWidth3 + ((LinearLayout.LayoutParams) cVar2).leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i28 = 0; i28 < childCount; i28++) {
            View childAt4 = getChildAt(i28);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f1716a) {
                int i29 = paddingLeft + ((LinearLayout.LayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i30 = i16 - (measuredHeight4 / 2);
                childAt4.layout(i29, i30, i29 + measuredWidth4, measuredHeight4 + i30);
                paddingLeft = i29 + measuredWidth4 + ((LinearLayout.LayoutParams) cVar3).rightMargin + max;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i11, int i12) {
        androidx.appcompat.view.menu.f fVar;
        boolean z10 = this.f1711h;
        boolean z11 = View.MeasureSpec.getMode(i11) == 1073741824;
        this.f1711h = z11;
        if (z10 != z11) {
            this.f1712i = 0;
        }
        int size = View.MeasureSpec.getSize(i11);
        if (this.f1711h && (fVar = this.f1704a) != null && size != this.f1712i) {
            this.f1712i = size;
            fVar.N(true);
        }
        int childCount = getChildCount();
        if (this.f1711h && childCount > 0) {
            h(i11, i12);
            return;
        }
        for (int i13 = 0; i13 < childCount; i13++) {
            c cVar = (c) getChildAt(i13).getLayoutParams();
            ((LinearLayout.LayoutParams) cVar).rightMargin = 0;
            ((LinearLayout.LayoutParams) cVar).leftMargin = 0;
        }
        super.onMeasure(i11, i12);
    }

    public androidx.appcompat.view.menu.f peekMenu() {
        return this.f1704a;
    }

    public void setExpandedActionViewsExclusive(boolean z10) {
        this.f1708e.J(z10);
    }

    public void setMenuCallbacks(l.a aVar, f.a aVar2) {
        this.f1709f = aVar;
        this.f1710g = aVar2;
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.f1715l = eVar;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        getMenu();
        this.f1708e.L(drawable);
    }

    public void setOverflowReserved(boolean z10) {
        this.f1707d = z10;
    }

    public void setPopupTheme(int i11) {
        if (this.f1706c != i11) {
            this.f1706c = i11;
            if (i11 == 0) {
                this.f1705b = getContext();
            } else {
                this.f1705b = new ContextThemeWrapper(getContext(), i11);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f1708e = actionMenuPresenter;
        actionMenuPresenter.K(this);
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.f1708e;
        return actionMenuPresenter != null && actionMenuPresenter.N();
    }
}

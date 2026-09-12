package androidx.appcompat.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.view.menu.l;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements s, NestedScrollingParent, NestedScrollingParent2, NestedScrollingParent3 {
    static final int[] G = {R$attr.actionBarSize, R.attr.windowContentOverlay};
    private static final WindowInsetsCompat H = new WindowInsetsCompat.Builder().setSystemWindowInsets(z0.c.c(0, 1, 0, 1)).build();
    private static final Rect I = new Rect();
    ViewPropertyAnimator A;
    final AnimatorListenerAdapter B;
    private final Runnable C;
    private final Runnable D;
    private final NestedScrollingParentHelper E;
    private final d F;

    /* renamed from: a, reason: collision with root package name */
    private int f1654a;

    /* renamed from: b, reason: collision with root package name */
    private int f1655b;

    /* renamed from: c, reason: collision with root package name */
    private ContentFrameLayout f1656c;

    /* renamed from: d, reason: collision with root package name */
    ActionBarContainer f1657d;

    /* renamed from: e, reason: collision with root package name */
    private t f1658e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f1659f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f1660g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1661h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f1662i;

    /* renamed from: j, reason: collision with root package name */
    boolean f1663j;

    /* renamed from: k, reason: collision with root package name */
    private int f1664k;

    /* renamed from: l, reason: collision with root package name */
    private int f1665l;

    /* renamed from: m, reason: collision with root package name */
    private final Rect f1666m;

    /* renamed from: n, reason: collision with root package name */
    private final Rect f1667n;

    /* renamed from: o, reason: collision with root package name */
    private final Rect f1668o;

    /* renamed from: p, reason: collision with root package name */
    private final Rect f1669p;

    /* renamed from: q, reason: collision with root package name */
    private final Rect f1670q;

    /* renamed from: r, reason: collision with root package name */
    private final Rect f1671r;

    /* renamed from: s, reason: collision with root package name */
    private final Rect f1672s;

    /* renamed from: t, reason: collision with root package name */
    private final Rect f1673t;

    /* renamed from: u, reason: collision with root package name */
    private WindowInsetsCompat f1674u;

    /* renamed from: v, reason: collision with root package name */
    private WindowInsetsCompat f1675v;

    /* renamed from: w, reason: collision with root package name */
    private WindowInsetsCompat f1676w;

    /* renamed from: x, reason: collision with root package name */
    private WindowInsetsCompat f1677x;

    /* renamed from: y, reason: collision with root package name */
    private b f1678y;

    /* renamed from: z, reason: collision with root package name */
    private OverScroller f1679z;

    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.A = null;
            actionBarOverlayLayout.f1663j = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.A = null;
            actionBarOverlayLayout.f1663j = false;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        void b(int i11);

        void c();

        void d(boolean z10);

        void e();

        void f();
    }

    /* loaded from: classes.dex */
    public static class c extends ViewGroup.MarginLayoutParams {
        public c(int i11, int i12) {
            super(i11, i12);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class d extends View {
        d(Context context) {
            super(context);
            setWillNotDraw(true);
        }

        @Override // android.view.View
        public int getWindowSystemUiVisibility() {
            return 0;
        }
    }

    public ActionBarOverlayLayout(@NonNull Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1655b = 0;
        this.f1666m = new Rect();
        this.f1667n = new Rect();
        this.f1668o = new Rect();
        this.f1669p = new Rect();
        this.f1670q = new Rect();
        this.f1671r = new Rect();
        this.f1672s = new Rect();
        this.f1673t = new Rect();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.CONSUMED;
        this.f1674u = windowInsetsCompat;
        this.f1675v = windowInsetsCompat;
        this.f1676w = windowInsetsCompat;
        this.f1677x = windowInsetsCompat;
        this.B = new a();
        this.C = new Runnable() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.2
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.f();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.A = actionBarOverlayLayout.f1657d.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.B);
            }
        };
        this.D = new Runnable() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.3
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.f();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.A = actionBarOverlayLayout.f1657d.animate().translationY(-ActionBarOverlayLayout.this.f1657d.getHeight()).setListener(ActionBarOverlayLayout.this.B);
            }
        };
        g(context);
        this.E = new NestedScrollingParentHelper(this);
        d dVar = new d(context);
        this.F = dVar;
        addView(dVar);
    }

    private void a() {
        f();
        this.D.run();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean b(android.view.View r3, android.graphics.Rect r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        /*
            r2 = this;
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.ActionBarOverlayLayout$c r3 = (androidx.appcompat.widget.ActionBarOverlayLayout.c) r3
            r0 = 1
            if (r5 == 0) goto L13
            int r5 = r3.leftMargin
            int r1 = r4.left
            if (r5 == r1) goto L13
            r3.leftMargin = r1
            r5 = r0
            goto L14
        L13:
            r5 = 0
        L14:
            if (r6 == 0) goto L1f
            int r6 = r3.topMargin
            int r1 = r4.top
            if (r6 == r1) goto L1f
            r3.topMargin = r1
            r5 = r0
        L1f:
            if (r8 == 0) goto L2a
            int r6 = r3.rightMargin
            int r8 = r4.right
            if (r6 == r8) goto L2a
            r3.rightMargin = r8
            r5 = r0
        L2a:
            if (r7 == 0) goto L35
            int r6 = r3.bottomMargin
            int r4 = r4.bottom
            if (r6 == r4) goto L35
            r3.bottomMargin = r4
            goto L36
        L35:
            r0 = r5
        L36:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.b(android.view.View, android.graphics.Rect, boolean, boolean, boolean, boolean):boolean");
    }

    private boolean c() {
        ViewCompat.computeSystemWindowInsets(this.F, H, this.f1669p);
        return !this.f1669p.equals(I);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private t e(View view) {
        if (view instanceof t) {
            return (t) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void g(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(G);
        this.f1654a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f1659f = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        this.f1679z = new OverScroller(context);
    }

    private void h() {
        f();
        postDelayed(this.D, 600L);
    }

    private void i() {
        f();
        postDelayed(this.C, 600L);
    }

    private void k() {
        f();
        this.C.run();
    }

    private boolean l(float f11) {
        this.f1679z.fling(0, 0, 0, (int) f11, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f1679z.getFinalY() > this.f1657d.getHeight();
    }

    @Override // androidx.appcompat.widget.s
    public boolean canShowOverflowMenu() {
        j();
        return this.f1658e.canShowOverflowMenu();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        return new c(-1, -1);
    }

    @Override // androidx.appcompat.widget.s
    public void dismissPopups() {
        j();
        this.f1658e.k();
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (this.f1659f != null) {
            int bottom = this.f1657d.getVisibility() == 0 ? (int) (this.f1657d.getBottom() + this.f1657d.getTranslationY() + 0.5f) : 0;
            this.f1659f.setBounds(0, bottom, getWidth(), this.f1659f.getIntrinsicHeight() + bottom);
            this.f1659f.draw(canvas);
        }
    }

    void f() {
        removeCallbacks(this.C);
        removeCallbacks(this.D);
        ViewPropertyAnimator viewPropertyAnimator = this.A;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new c(layoutParams);
    }

    @Override // android.view.ViewGroup
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f1657d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.E.getNestedScrollAxes();
    }

    public CharSequence getTitle() {
        j();
        return this.f1658e.getTitle();
    }

    public boolean hasIcon() {
        j();
        return this.f1658e.f();
    }

    public boolean hasLogo() {
        j();
        return this.f1658e.q();
    }

    @Override // androidx.appcompat.widget.s
    public boolean hideOverflowMenu() {
        j();
        return this.f1658e.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.s
    public void initFeature(int i11) {
        j();
        if (i11 == 2) {
            this.f1658e.i();
        } else if (i11 == 5) {
            this.f1658e.s();
        } else {
            if (i11 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.f1662i;
    }

    public boolean isInOverlayMode() {
        return this.f1660g;
    }

    @Override // androidx.appcompat.widget.s
    public boolean isOverflowMenuShowPending() {
        j();
        return this.f1658e.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.s
    public boolean isOverflowMenuShowing() {
        j();
        return this.f1658e.isOverflowMenuShowing();
    }

    void j() {
        if (this.f1656c == null) {
            this.f1656c = (ContentFrameLayout) findViewById(R$id.action_bar_activity_content);
            this.f1657d = (ActionBarContainer) findViewById(R$id.action_bar_container);
            this.f1658e = e(findViewById(R$id.action_bar));
        }
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(@NonNull WindowInsets windowInsets) {
        j();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, this);
        boolean b11 = b(this.f1657d, new Rect(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom()), true, true, false, true);
        ViewCompat.computeSystemWindowInsets(this, windowInsetsCompat, this.f1666m);
        Rect rect = this.f1666m;
        WindowInsetsCompat inset = windowInsetsCompat.inset(rect.left, rect.top, rect.right, rect.bottom);
        this.f1674u = inset;
        boolean z10 = true;
        if (!this.f1675v.equals(inset)) {
            this.f1675v = this.f1674u;
            b11 = true;
        }
        if (this.f1667n.equals(this.f1666m)) {
            z10 = b11;
        } else {
            this.f1667n.set(this.f1666m);
        }
        if (z10) {
            requestLayout();
        }
        return windowInsetsCompat.consumeDisplayCutout().consumeSystemWindowInsets().consumeStableInsets().toWindowInsets();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        g(getContext());
        ViewCompat.requestApplyInsets(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i16 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin + paddingLeft;
                int i17 = ((ViewGroup.MarginLayoutParams) cVar).topMargin + paddingTop;
                childAt.layout(i16, i17, measuredWidth + i16, measuredHeight + i17);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        int measuredHeight;
        j();
        measureChildWithMargins(this.f1657d, i11, 0, i12, 0);
        c cVar = (c) this.f1657d.getLayoutParams();
        int max = Math.max(0, this.f1657d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) cVar).leftMargin + ((ViewGroup.MarginLayoutParams) cVar).rightMargin);
        int max2 = Math.max(0, this.f1657d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) cVar).topMargin + ((ViewGroup.MarginLayoutParams) cVar).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f1657d.getMeasuredState());
        boolean z10 = (ViewCompat.getWindowSystemUiVisibility(this) & 256) != 0;
        if (z10) {
            measuredHeight = this.f1654a;
            if (this.f1661h && this.f1657d.getTabContainer() != null) {
                measuredHeight += this.f1654a;
            }
        } else {
            measuredHeight = this.f1657d.getVisibility() != 8 ? this.f1657d.getMeasuredHeight() : 0;
        }
        this.f1668o.set(this.f1666m);
        this.f1676w = this.f1674u;
        if (this.f1660g || z10 || !c()) {
            this.f1676w = new WindowInsetsCompat.Builder(this.f1676w).setSystemWindowInsets(z0.c.c(this.f1676w.getSystemWindowInsetLeft(), this.f1676w.getSystemWindowInsetTop() + measuredHeight, this.f1676w.getSystemWindowInsetRight(), this.f1676w.getSystemWindowInsetBottom())).build();
        } else {
            Rect rect = this.f1668o;
            rect.top += measuredHeight;
            rect.bottom = rect.bottom;
            this.f1676w = this.f1676w.inset(0, measuredHeight, 0, 0);
        }
        b(this.f1656c, this.f1668o, true, true, true, true);
        if (!this.f1677x.equals(this.f1676w)) {
            WindowInsetsCompat windowInsetsCompat = this.f1676w;
            this.f1677x = windowInsetsCompat;
            ViewCompat.dispatchApplyWindowInsets(this.f1656c, windowInsetsCompat);
        }
        measureChildWithMargins(this.f1656c, i11, 0, i12, 0);
        c cVar2 = (c) this.f1656c.getLayoutParams();
        int max3 = Math.max(max, this.f1656c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) cVar2).leftMargin + ((ViewGroup.MarginLayoutParams) cVar2).rightMargin);
        int max4 = Math.max(max2, this.f1656c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) cVar2).topMargin + ((ViewGroup.MarginLayoutParams) cVar2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f1656c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i11, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i12, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f11, float f12, boolean z10) {
        if (!this.f1662i || !z10) {
            return false;
        }
        if (l(f12)) {
            a();
        } else {
            k();
        }
        this.f1663j = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f11, float f12) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i11, int i12, int[] iArr) {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i11, int i12, int[] iArr, int i13) {
        if (i13 == 0) {
            onNestedPreScroll(view, i11, i12, iArr);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i11, int i12, int i13, int i14) {
        int i15 = this.f1664k + i12;
        this.f1664k = i15;
        setActionBarHideOffset(i15);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i11, int i12, int i13, int i14, int i15) {
        if (i15 == 0) {
            onNestedScroll(view, i11, i12, i13, i14);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View view, int i11, int i12, int i13, int i14, int i15, int[] iArr) {
        onNestedScroll(view, i11, i12, i13, i14, i15);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i11) {
        this.E.onNestedScrollAccepted(view, view2, i11);
        this.f1664k = getActionBarHideOffset();
        f();
        b bVar = this.f1678y;
        if (bVar != null) {
            bVar.f();
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i11, int i12) {
        if (i12 == 0) {
            onNestedScrollAccepted(view, view2, i11);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i11) {
        if ((i11 & 2) == 0 || this.f1657d.getVisibility() != 0) {
            return false;
        }
        return this.f1662i;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i11, int i12) {
        return i12 == 0 && onStartNestedScroll(view, view2, i11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        if (this.f1662i && !this.f1663j) {
            if (this.f1664k <= this.f1657d.getHeight()) {
                i();
            } else {
                h();
            }
        }
        b bVar = this.f1678y;
        if (bVar != null) {
            bVar.c();
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i11) {
        if (i11 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i11) {
        super.onWindowSystemUiVisibilityChanged(i11);
        j();
        int i12 = this.f1665l ^ i11;
        this.f1665l = i11;
        boolean z10 = (i11 & 4) == 0;
        boolean z11 = (i11 & 256) != 0;
        b bVar = this.f1678y;
        if (bVar != null) {
            bVar.d(!z11);
            if (z10 || !z11) {
                this.f1678y.a();
            } else {
                this.f1678y.e();
            }
        }
        if ((i12 & 256) == 0 || this.f1678y == null) {
            return;
        }
        ViewCompat.requestApplyInsets(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i11) {
        super.onWindowVisibilityChanged(i11);
        this.f1655b = i11;
        b bVar = this.f1678y;
        if (bVar != null) {
            bVar.b(i11);
        }
    }

    public void restoreToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        j();
        this.f1658e.p(sparseArray);
    }

    public void saveToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        j();
        this.f1658e.m(sparseArray);
    }

    public void setActionBarHideOffset(int i11) {
        f();
        this.f1657d.setTranslationY(-Math.max(0, Math.min(i11, this.f1657d.getHeight())));
    }

    public void setActionBarVisibilityCallback(b bVar) {
        this.f1678y = bVar;
        if (getWindowToken() != null) {
            this.f1678y.b(this.f1655b);
            int i11 = this.f1665l;
            if (i11 != 0) {
                onWindowSystemUiVisibilityChanged(i11);
                ViewCompat.requestApplyInsets(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z10) {
        this.f1661h = z10;
    }

    public void setHideOnContentScrollEnabled(boolean z10) {
        if (z10 != this.f1662i) {
            this.f1662i = z10;
            if (z10) {
                return;
            }
            f();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i11) {
        j();
        this.f1658e.setIcon(i11);
    }

    public void setIcon(Drawable drawable) {
        j();
        this.f1658e.setIcon(drawable);
    }

    public void setLogo(int i11) {
        j();
        this.f1658e.n(i11);
    }

    @Override // androidx.appcompat.widget.s
    public void setMenu(Menu menu, l.a aVar) {
        j();
        this.f1658e.setMenu(menu, aVar);
    }

    @Override // androidx.appcompat.widget.s
    public void setMenuPrepared() {
        j();
        this.f1658e.setMenuPrepared();
    }

    public void setOverlayMode(boolean z10) {
        this.f1660g = z10;
    }

    public void setShowingForActionMode(boolean z10) {
    }

    public void setUiOptions(int i11) {
    }

    @Override // androidx.appcompat.widget.s
    public void setWindowCallback(Window.Callback callback) {
        j();
        this.f1658e.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.s
    public void setWindowTitle(CharSequence charSequence) {
        j();
        this.f1658e.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // androidx.appcompat.widget.s
    public boolean showOverflowMenu() {
        j();
        return this.f1658e.showOverflowMenu();
    }
}

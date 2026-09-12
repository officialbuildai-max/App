package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.x;

/* loaded from: classes4.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    private static final int F = R$style.Widget_Design_CollapsingToolbar;
    public static final int TITLE_COLLAPSE_MODE_FADE = 1;
    public static final int TITLE_COLLAPSE_MODE_SCALE = 0;
    WindowInsetsCompat A;
    private int B;
    private boolean C;
    private int D;
    private boolean E;

    /* renamed from: a, reason: collision with root package name */
    private boolean f28270a;

    /* renamed from: b, reason: collision with root package name */
    private int f28271b;

    /* renamed from: c, reason: collision with root package name */
    private ViewGroup f28272c;

    /* renamed from: d, reason: collision with root package name */
    private View f28273d;

    /* renamed from: e, reason: collision with root package name */
    private View f28274e;

    /* renamed from: f, reason: collision with root package name */
    private int f28275f;

    /* renamed from: g, reason: collision with root package name */
    private int f28276g;

    /* renamed from: h, reason: collision with root package name */
    private int f28277h;

    /* renamed from: i, reason: collision with root package name */
    private int f28278i;

    /* renamed from: j, reason: collision with root package name */
    private final Rect f28279j;

    /* renamed from: k, reason: collision with root package name */
    final com.google.android.material.internal.b f28280k;

    /* renamed from: l, reason: collision with root package name */
    final ta.a f28281l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f28282m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f28283n;

    /* renamed from: o, reason: collision with root package name */
    private Drawable f28284o;

    /* renamed from: p, reason: collision with root package name */
    Drawable f28285p;

    /* renamed from: q, reason: collision with root package name */
    private int f28286q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f28287r;

    /* renamed from: s, reason: collision with root package name */
    private ValueAnimator f28288s;

    /* renamed from: t, reason: collision with root package name */
    private long f28289t;

    /* renamed from: u, reason: collision with root package name */
    private final TimeInterpolator f28290u;

    /* renamed from: v, reason: collision with root package name */
    private final TimeInterpolator f28291v;

    /* renamed from: w, reason: collision with root package name */
    private int f28292w;

    /* renamed from: x, reason: collision with root package name */
    private AppBarLayout.g f28293x;

    /* renamed from: y, reason: collision with root package name */
    int f28294y;

    /* renamed from: z, reason: collision with root package name */
    private int f28295z;

    /* loaded from: classes4.dex */
    class a implements OnApplyWindowInsetsListener {
        a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return CollapsingToolbarLayout.this.o(windowInsetsCompat);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends FrameLayout.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        int f28298a;

        /* renamed from: b, reason: collision with root package name */
        float f28299b;

        public c(int i11, int i12) {
            super(i11, i12);
            this.f28298a = 0;
            this.f28299b = 0.5f;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f28298a = 0;
            this.f28299b = 0.5f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CollapsingToolbarLayout_Layout);
            this.f28298a = obtainStyledAttributes.getInt(R$styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            a(obtainStyledAttributes.getFloat(R$styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f28298a = 0;
            this.f28299b = 0.5f;
        }

        public void a(float f11) {
            this.f28299b = f11;
        }
    }

    /* loaded from: classes4.dex */
    private class d implements AppBarLayout.g {
        d() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.b
        public void onOffsetChanged(AppBarLayout appBarLayout, int i11) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.f28294y = i11;
            WindowInsetsCompat windowInsetsCompat = collapsingToolbarLayout.A;
            int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i12);
                c cVar = (c) childAt.getLayoutParams();
                j k11 = CollapsingToolbarLayout.k(childAt);
                int i13 = cVar.f28298a;
                if (i13 == 1) {
                    k11.f(d1.a.b(-i11, 0, CollapsingToolbarLayout.this.i(childAt)));
                } else if (i13 == 2) {
                    k11.f(Math.round((-i11) * cVar.f28299b));
                }
            }
            CollapsingToolbarLayout.this.u();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.f28285p != null && systemWindowInsetTop > 0) {
                ViewCompat.postInvalidateOnAnimation(collapsingToolbarLayout2);
            }
            int height = (CollapsingToolbarLayout.this.getHeight() - ViewCompat.getMinimumHeight(CollapsingToolbarLayout.this)) - systemWindowInsetTop;
            float f11 = height;
            CollapsingToolbarLayout.this.f28280k.B0(Math.min(1.0f, (r0 - CollapsingToolbarLayout.this.getScrimVisibleHeightTrigger()) / f11));
            CollapsingToolbarLayout collapsingToolbarLayout3 = CollapsingToolbarLayout.this;
            collapsingToolbarLayout3.f28280k.o0(collapsingToolbarLayout3.f28294y + height);
            CollapsingToolbarLayout.this.f28280k.z0(Math.abs(i11) / f11);
        }
    }

    /* loaded from: classes4.dex */
    public interface e extends x {
    }

    public CollapsingToolbarLayout(@NonNull Context context) {
        this(context, null);
    }

    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.collapsingToolbarLayoutStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public CollapsingToolbarLayout(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.Nullable android.util.AttributeSet r12, int r13) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void a(int i11) {
        d();
        ValueAnimator valueAnimator = this.f28288s;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.f28288s = valueAnimator2;
            valueAnimator2.setInterpolator(i11 > this.f28286q ? this.f28290u : this.f28291v);
            this.f28288s.addUpdateListener(new b());
        } else if (valueAnimator.isRunning()) {
            this.f28288s.cancel();
        }
        this.f28288s.setDuration(this.f28289t);
        this.f28288s.setIntValues(this.f28286q, i11);
        this.f28288s.start();
    }

    private TextUtils.TruncateAt b(int i11) {
        return i11 != 0 ? i11 != 1 ? i11 != 3 ? TextUtils.TruncateAt.END : TextUtils.TruncateAt.MARQUEE : TextUtils.TruncateAt.MIDDLE : TextUtils.TruncateAt.START;
    }

    private void c(AppBarLayout appBarLayout) {
        if (l()) {
            appBarLayout.setLiftOnScroll(false);
        }
    }

    private void d() {
        if (this.f28270a) {
            ViewGroup viewGroup = null;
            this.f28272c = null;
            this.f28273d = null;
            int i11 = this.f28271b;
            if (i11 != -1) {
                ViewGroup viewGroup2 = (ViewGroup) findViewById(i11);
                this.f28272c = viewGroup2;
                if (viewGroup2 != null) {
                    this.f28273d = e(viewGroup2);
                }
            }
            if (this.f28272c == null) {
                int childCount = getChildCount();
                int i12 = 0;
                while (true) {
                    if (i12 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i12);
                    if (m(childAt)) {
                        viewGroup = (ViewGroup) childAt;
                        break;
                    }
                    i12++;
                }
                this.f28272c = viewGroup;
            }
            t();
            this.f28270a = false;
        }
    }

    private View e(View view) {
        for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof View) {
                view = parent;
            }
        }
        return view;
    }

    private int getDefaultContentScrimColorForTitleCollapseFadeMode() {
        ColorStateList g11 = com.google.android.material.color.b.g(getContext(), R$attr.colorSurfaceContainer);
        if (g11 != null) {
            return g11.getDefaultColor();
        }
        return this.f28281l.d(getResources().getDimension(R$dimen.design_appbar_elevation));
    }

    private static int h(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getMeasuredHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private static CharSequence j(View view) {
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getTitle();
        }
        if (view instanceof android.widget.Toolbar) {
            return ((android.widget.Toolbar) view).getTitle();
        }
        return null;
    }

    static j k(View view) {
        j jVar = (j) view.getTag(R$id.view_offset_helper);
        if (jVar != null) {
            return jVar;
        }
        j jVar2 = new j(view);
        view.setTag(R$id.view_offset_helper, jVar2);
        return jVar2;
    }

    private boolean l() {
        return this.f28295z == 1;
    }

    private static boolean m(View view) {
        return (view instanceof Toolbar) || (view instanceof android.widget.Toolbar);
    }

    private boolean n(View view) {
        View view2 = this.f28273d;
        if (view2 == null || view2 == this) {
            if (view != this.f28272c) {
                return false;
            }
        } else if (view != view2) {
            return false;
        }
        return true;
    }

    private void p(boolean z10) {
        int i11;
        int i12;
        int i13;
        int i14;
        View view = this.f28273d;
        if (view == null) {
            view = this.f28272c;
        }
        int i15 = i(view);
        com.google.android.material.internal.d.a(this, this.f28274e, this.f28279j);
        ViewGroup viewGroup = this.f28272c;
        if (viewGroup instanceof Toolbar) {
            Toolbar toolbar = (Toolbar) viewGroup;
            i11 = toolbar.getTitleMarginStart();
            i13 = toolbar.getTitleMarginEnd();
            i14 = toolbar.getTitleMarginTop();
            i12 = toolbar.getTitleMarginBottom();
        } else if (Build.VERSION.SDK_INT < 24 || !(viewGroup instanceof android.widget.Toolbar)) {
            i11 = 0;
            i12 = 0;
            i13 = 0;
            i14 = 0;
        } else {
            android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
            i11 = toolbar2.getTitleMarginStart();
            i13 = toolbar2.getTitleMarginEnd();
            i14 = toolbar2.getTitleMarginTop();
            i12 = toolbar2.getTitleMarginBottom();
        }
        com.google.android.material.internal.b bVar = this.f28280k;
        Rect rect = this.f28279j;
        int i16 = rect.left + (z10 ? i13 : i11);
        int i17 = rect.top + i15 + i14;
        int i18 = rect.right;
        if (!z10) {
            i11 = i13;
        }
        bVar.f0(i16, i17, i18 - i11, (rect.bottom + i15) - i12);
    }

    private void q() {
        setContentDescription(getTitle());
    }

    private void r(Drawable drawable, int i11, int i12) {
        s(drawable, this.f28272c, i11, i12);
    }

    private void s(Drawable drawable, View view, int i11, int i12) {
        if (l() && view != null && this.f28282m) {
            i12 = view.getBottom();
        }
        drawable.setBounds(0, 0, i11, i12);
    }

    private void t() {
        View view;
        if (!this.f28282m && (view = this.f28274e) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f28274e);
            }
        }
        if (!this.f28282m || this.f28272c == null) {
            return;
        }
        if (this.f28274e == null) {
            this.f28274e = new View(getContext());
        }
        if (this.f28274e.getParent() == null) {
            this.f28272c.addView(this.f28274e, -1, -1);
        }
    }

    private void v(int i11, int i12, int i13, int i14, boolean z10) {
        View view;
        if (!this.f28282m || (view = this.f28274e) == null) {
            return;
        }
        boolean z11 = ViewCompat.isAttachedToWindow(view) && this.f28274e.getVisibility() == 0;
        this.f28283n = z11;
        if (z11 || z10) {
            boolean z12 = ViewCompat.getLayoutDirection(this) == 1;
            p(z12);
            this.f28280k.p0(z12 ? this.f28277h : this.f28275f, this.f28279j.top + this.f28276g, (i13 - i11) - (z12 ? this.f28275f : this.f28277h), (i14 - i12) - this.f28278i);
            this.f28280k.c0(z10);
        }
    }

    private void w() {
        if (this.f28272c != null && this.f28282m && TextUtils.isEmpty(this.f28280k.O())) {
            setTitle(j(this.f28272c));
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        d();
        if (this.f28272c == null && (drawable = this.f28284o) != null && this.f28286q > 0) {
            drawable.mutate().setAlpha(this.f28286q);
            this.f28284o.draw(canvas);
        }
        if (this.f28282m && this.f28283n) {
            if (this.f28272c == null || this.f28284o == null || this.f28286q <= 0 || !l() || this.f28280k.F() >= this.f28280k.G()) {
                this.f28280k.l(canvas);
            } else {
                int save = canvas.save();
                canvas.clipRect(this.f28284o.getBounds(), Region.Op.DIFFERENCE);
                this.f28280k.l(canvas);
                canvas.restoreToCount(save);
            }
        }
        if (this.f28285p == null || this.f28286q <= 0) {
            return;
        }
        WindowInsetsCompat windowInsetsCompat = this.A;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.f28285p.setBounds(0, -this.f28294y, getWidth(), systemWindowInsetTop - this.f28294y);
            this.f28285p.mutate().setAlpha(this.f28286q);
            this.f28285p.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j11) {
        boolean z10;
        if (this.f28284o == null || this.f28286q <= 0 || !n(view)) {
            z10 = false;
        } else {
            s(this.f28284o, view, getWidth(), getHeight());
            this.f28284o.mutate().setAlpha(this.f28286q);
            this.f28284o.draw(canvas);
            z10 = true;
        }
        return super.drawChild(canvas, view, j11) || z10;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f28285p;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f28284o;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        com.google.android.material.internal.b bVar = this.f28280k;
        if (bVar != null) {
            state |= bVar.J0(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        return new c(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new c(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public int getCollapsedTitleGravity() {
        return this.f28280k.q();
    }

    public float getCollapsedTitleTextSize() {
        return this.f28280k.u();
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        return this.f28280k.v();
    }

    @Nullable
    public Drawable getContentScrim() {
        return this.f28284o;
    }

    public int getExpandedTitleGravity() {
        return this.f28280k.B();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f28278i;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f28277h;
    }

    public int getExpandedTitleMarginStart() {
        return this.f28275f;
    }

    public int getExpandedTitleMarginTop() {
        return this.f28276g;
    }

    public float getExpandedTitleTextSize() {
        return this.f28280k.D();
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        return this.f28280k.E();
    }

    public int getHyphenationFrequency() {
        return this.f28280k.H();
    }

    public int getLineCount() {
        return this.f28280k.I();
    }

    public float getLineSpacingAdd() {
        return this.f28280k.J();
    }

    public float getLineSpacingMultiplier() {
        return this.f28280k.K();
    }

    public int getMaxLines() {
        return this.f28280k.L();
    }

    int getScrimAlpha() {
        return this.f28286q;
    }

    public long getScrimAnimationDuration() {
        return this.f28289t;
    }

    public int getScrimVisibleHeightTrigger() {
        int i11 = this.f28292w;
        if (i11 >= 0) {
            return i11 + this.B + this.D;
        }
        WindowInsetsCompat windowInsetsCompat = this.A;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        return minimumHeight > 0 ? Math.min((minimumHeight * 2) + systemWindowInsetTop, getHeight()) : getHeight() / 3;
    }

    @Nullable
    public Drawable getStatusBarScrim() {
        return this.f28285p;
    }

    @Nullable
    public CharSequence getTitle() {
        if (this.f28282m) {
            return this.f28280k.O();
        }
        return null;
    }

    public int getTitleCollapseMode() {
        return this.f28295z;
    }

    @Nullable
    public TimeInterpolator getTitlePositionInterpolator() {
        return this.f28280k.N();
    }

    @NonNull
    public TextUtils.TruncateAt getTitleTextEllipsize() {
        return this.f28280k.R();
    }

    final int i(View view) {
        return ((getHeight() - k(view).b()) - view.getHeight()) - ((FrameLayout.LayoutParams) ((c) view.getLayoutParams())).bottomMargin;
    }

    public boolean isExtraMultilineHeightEnabled() {
        return this.E;
    }

    public boolean isForceApplySystemWindowInsetTop() {
        return this.C;
    }

    public boolean isRtlTextDirectionHeuristicsEnabled() {
        return this.f28280k.V();
    }

    public boolean isTitleEnabled() {
        return this.f28282m;
    }

    WindowInsetsCompat o(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
        if (!androidx.core.util.d.a(this.A, windowInsetsCompat2)) {
            this.A = windowInsetsCompat2;
            requestLayout();
        }
        return windowInsetsCompat.consumeSystemWindowInsets();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            c(appBarLayout);
            ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows(appBarLayout));
            if (this.f28293x == null) {
                this.f28293x = new d();
            }
            appBarLayout.addOnOffsetChangedListener(this.f28293x);
            ViewCompat.requestApplyInsets(this);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f28280k.Z(configuration);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.g gVar = this.f28293x;
        if (gVar != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).removeOnOffsetChangedListener(gVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        super.onLayout(z10, i11, i12, i13, i14);
        WindowInsetsCompat windowInsetsCompat = this.A;
        if (windowInsetsCompat != null) {
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            int childCount = getChildCount();
            for (int i15 = 0; i15 < childCount; i15++) {
                View childAt = getChildAt(i15);
                if (!ViewCompat.getFitsSystemWindows(childAt) && childAt.getTop() < systemWindowInsetTop) {
                    ViewCompat.offsetTopAndBottom(childAt, systemWindowInsetTop);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i16 = 0; i16 < childCount2; i16++) {
            k(getChildAt(i16)).d();
        }
        v(i11, i12, i13, i14, false);
        w();
        u();
        int childCount3 = getChildCount();
        for (int i17 = 0; i17 < childCount3; i17++) {
            k(getChildAt(i17)).a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i11, int i12) {
        d();
        super.onMeasure(i11, i12);
        int mode = View.MeasureSpec.getMode(i12);
        WindowInsetsCompat windowInsetsCompat = this.A;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        if ((mode == 0 || this.C) && systemWindowInsetTop > 0) {
            this.B = systemWindowInsetTop;
            super.onMeasure(i11, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + systemWindowInsetTop, 1073741824));
        }
        if (this.E && this.f28280k.L() > 1) {
            w();
            v(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
            int z10 = this.f28280k.z();
            if (z10 > 1) {
                this.D = Math.round(this.f28280k.A()) * (z10 - 1);
                super.onMeasure(i11, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + this.D, 1073741824));
            }
        }
        ViewGroup viewGroup = this.f28272c;
        if (viewGroup != null) {
            View view = this.f28273d;
            if (view == null || view == this) {
                setMinimumHeight(h(viewGroup));
            } else {
                setMinimumHeight(h(view));
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        Drawable drawable = this.f28284o;
        if (drawable != null) {
            r(drawable, i11, i12);
        }
    }

    public void setCollapsedTitleGravity(int i11) {
        this.f28280k.k0(i11);
    }

    public void setCollapsedTitleTextAppearance(int i11) {
        this.f28280k.h0(i11);
    }

    public void setCollapsedTitleTextColor(int i11) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i11));
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.f28280k.j0(colorStateList);
    }

    public void setCollapsedTitleTextSize(float f11) {
        this.f28280k.l0(f11);
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface typeface) {
        this.f28280k.m0(typeface);
    }

    public void setContentScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f28284o;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.f28284o = mutate;
            if (mutate != null) {
                r(mutate, getWidth(), getHeight());
                this.f28284o.setCallback(this);
                this.f28284o.setAlpha(this.f28286q);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setContentScrimColor(int i11) {
        setContentScrim(new ColorDrawable(i11));
    }

    public void setContentScrimResource(int i11) {
        setContentScrim(androidx.core.content.b.getDrawable(getContext(), i11));
    }

    public void setExpandedTitleColor(int i11) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i11));
    }

    public void setExpandedTitleGravity(int i11) {
        this.f28280k.v0(i11);
    }

    public void setExpandedTitleMargin(int i11, int i12, int i13, int i14) {
        this.f28275f = i11;
        this.f28276g = i12;
        this.f28277h = i13;
        this.f28278i = i14;
        requestLayout();
    }

    public void setExpandedTitleMarginBottom(int i11) {
        this.f28278i = i11;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i11) {
        this.f28277h = i11;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i11) {
        this.f28275f = i11;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i11) {
        this.f28276g = i11;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i11) {
        this.f28280k.s0(i11);
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.f28280k.u0(colorStateList);
    }

    public void setExpandedTitleTextSize(float f11) {
        this.f28280k.w0(f11);
    }

    public void setExpandedTitleTypeface(@Nullable Typeface typeface) {
        this.f28280k.x0(typeface);
    }

    public void setExtraMultilineHeightEnabled(boolean z10) {
        this.E = z10;
    }

    public void setForceApplySystemWindowInsetTop(boolean z10) {
        this.C = z10;
    }

    public void setHyphenationFrequency(int i11) {
        this.f28280k.C0(i11);
    }

    public void setLineSpacingAdd(float f11) {
        this.f28280k.E0(f11);
    }

    public void setLineSpacingMultiplier(float f11) {
        this.f28280k.F0(f11);
    }

    public void setMaxLines(int i11) {
        this.f28280k.G0(i11);
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean z10) {
        this.f28280k.I0(z10);
    }

    void setScrimAlpha(int i11) {
        ViewGroup viewGroup;
        if (i11 != this.f28286q) {
            if (this.f28284o != null && (viewGroup = this.f28272c) != null) {
                ViewCompat.postInvalidateOnAnimation(viewGroup);
            }
            this.f28286q = i11;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setScrimAnimationDuration(long j11) {
        this.f28289t = j11;
    }

    public void setScrimVisibleHeightTrigger(int i11) {
        if (this.f28292w != i11) {
            this.f28292w = i11;
            u();
        }
    }

    public void setScrimsShown(boolean z10) {
        setScrimsShown(z10, ViewCompat.isLaidOut(this) && !isInEditMode());
    }

    public void setScrimsShown(boolean z10, boolean z11) {
        if (this.f28287r != z10) {
            if (z11) {
                a(z10 ? 255 : 0);
            } else {
                setScrimAlpha(z10 ? 255 : 0);
            }
            this.f28287r = z10;
        }
    }

    public void setStaticLayoutBuilderConfigurer(@Nullable e eVar) {
        this.f28280k.K0(eVar);
    }

    public void setStatusBarScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f28285p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.f28285p = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.f28285p.setState(getDrawableState());
                }
                a1.a.m(this.f28285p, ViewCompat.getLayoutDirection(this));
                this.f28285p.setVisible(getVisibility() == 0, false);
                this.f28285p.setCallback(this);
                this.f28285p.setAlpha(this.f28286q);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarScrimColor(int i11) {
        setStatusBarScrim(new ColorDrawable(i11));
    }

    public void setStatusBarScrimResource(int i11) {
        setStatusBarScrim(androidx.core.content.b.getDrawable(getContext(), i11));
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.f28280k.L0(charSequence);
        q();
    }

    public void setTitleCollapseMode(int i11) {
        this.f28295z = i11;
        boolean l11 = l();
        this.f28280k.A0(l11);
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            c((AppBarLayout) parent);
        }
        if (l11 && this.f28284o == null) {
            setContentScrimColor(getDefaultContentScrimColorForTitleCollapseFadeMode());
        }
    }

    public void setTitleEllipsize(@NonNull TextUtils.TruncateAt truncateAt) {
        this.f28280k.N0(truncateAt);
    }

    public void setTitleEnabled(boolean z10) {
        if (z10 != this.f28282m) {
            this.f28282m = z10;
            q();
            t();
            requestLayout();
        }
    }

    public void setTitlePositionInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        this.f28280k.H0(timeInterpolator);
    }

    @Override // android.view.View
    public void setVisibility(int i11) {
        super.setVisibility(i11);
        boolean z10 = i11 == 0;
        Drawable drawable = this.f28285p;
        if (drawable != null && drawable.isVisible() != z10) {
            this.f28285p.setVisible(z10, false);
        }
        Drawable drawable2 = this.f28284o;
        if (drawable2 == null || drawable2.isVisible() == z10) {
            return;
        }
        this.f28284o.setVisible(z10, false);
    }

    final void u() {
        if (this.f28284o == null && this.f28285p == null) {
            return;
        }
        setScrimsShown(getHeight() + this.f28294y < getScrimVisibleHeightTrigger());
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f28284o || drawable == this.f28285p;
    }
}

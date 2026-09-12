package com.google.android.material.navigation;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.o0;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$integer;
import com.google.android.material.R$string;
import com.google.android.material.badge.BadgeDrawable;
import wa.j;

/* loaded from: classes4.dex */
public abstract class NavigationBarItemView extends FrameLayout implements m.a {
    private static final int[] G = {R.attr.state_checked};
    private static final c H;
    private static final c I;
    private boolean A;
    private int B;
    private int C;
    private boolean D;
    private int E;
    private BadgeDrawable F;

    /* renamed from: a, reason: collision with root package name */
    private boolean f29354a;

    /* renamed from: b, reason: collision with root package name */
    private ColorStateList f29355b;

    /* renamed from: c, reason: collision with root package name */
    Drawable f29356c;

    /* renamed from: d, reason: collision with root package name */
    private int f29357d;

    /* renamed from: e, reason: collision with root package name */
    private int f29358e;

    /* renamed from: f, reason: collision with root package name */
    private int f29359f;

    /* renamed from: g, reason: collision with root package name */
    private float f29360g;

    /* renamed from: h, reason: collision with root package name */
    private float f29361h;

    /* renamed from: i, reason: collision with root package name */
    private float f29362i;

    /* renamed from: j, reason: collision with root package name */
    private int f29363j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f29364k;

    /* renamed from: l, reason: collision with root package name */
    private final FrameLayout f29365l;

    /* renamed from: m, reason: collision with root package name */
    private final View f29366m;

    /* renamed from: n, reason: collision with root package name */
    private final ImageView f29367n;

    /* renamed from: o, reason: collision with root package name */
    private final ViewGroup f29368o;

    /* renamed from: p, reason: collision with root package name */
    private final TextView f29369p;

    /* renamed from: q, reason: collision with root package name */
    private final TextView f29370q;

    /* renamed from: r, reason: collision with root package name */
    private int f29371r;

    /* renamed from: s, reason: collision with root package name */
    private int f29372s;

    /* renamed from: t, reason: collision with root package name */
    private h f29373t;

    /* renamed from: u, reason: collision with root package name */
    private ColorStateList f29374u;

    /* renamed from: v, reason: collision with root package name */
    private Drawable f29375v;

    /* renamed from: w, reason: collision with root package name */
    private Drawable f29376w;

    /* renamed from: x, reason: collision with root package name */
    private ValueAnimator f29377x;

    /* renamed from: y, reason: collision with root package name */
    private c f29378y;

    /* renamed from: z, reason: collision with root package name */
    private float f29379z;

    /* loaded from: classes4.dex */
    class a implements View.OnLayoutChangeListener {
        a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            if (NavigationBarItemView.this.f29367n.getVisibility() == 0) {
                NavigationBarItemView navigationBarItemView = NavigationBarItemView.this;
                navigationBarItemView.u(navigationBarItemView.f29367n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f29381a;

        b(float f11) {
            this.f29381a = f11;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            NavigationBarItemView.this.o(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.f29381a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c {
        private c() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }

        protected float a(float f11, float f12) {
            return oa.a.b(0.0f, 1.0f, f12 == 0.0f ? 0.8f : 0.0f, f12 == 0.0f ? 1.0f : 0.2f, f11);
        }

        protected float b(float f11, float f12) {
            return oa.a.a(0.4f, 1.0f, f11);
        }

        protected float c(float f11, float f12) {
            return 1.0f;
        }

        public void d(float f11, float f12, View view) {
            view.setScaleX(b(f11, f12));
            view.setScaleY(c(f11, f12));
            view.setAlpha(a(f11, f12));
        }
    }

    /* loaded from: classes4.dex */
    private static class d extends c {
        private d() {
            super(null);
        }

        /* synthetic */ d(a aVar) {
            this();
        }

        @Override // com.google.android.material.navigation.NavigationBarItemView.c
        protected float c(float f11, float f12) {
            return b(f11, f12);
        }
    }

    static {
        a aVar = null;
        H = new c(aVar);
        I = new d(aVar);
    }

    public NavigationBarItemView(@NonNull Context context) {
        super(context);
        this.f29354a = false;
        this.f29371r = -1;
        this.f29372s = 0;
        this.f29378y = H;
        this.f29379z = 0.0f;
        this.A = false;
        this.B = 0;
        this.C = 0;
        this.D = false;
        this.E = 0;
        LayoutInflater.from(context).inflate(getItemLayoutResId(), (ViewGroup) this, true);
        this.f29365l = (FrameLayout) findViewById(R$id.navigation_bar_item_icon_container);
        this.f29366m = findViewById(R$id.navigation_bar_item_active_indicator_view);
        ImageView imageView = (ImageView) findViewById(R$id.navigation_bar_item_icon_view);
        this.f29367n = imageView;
        ViewGroup viewGroup = (ViewGroup) findViewById(R$id.navigation_bar_item_labels_group);
        this.f29368o = viewGroup;
        TextView textView = (TextView) findViewById(R$id.navigation_bar_item_small_label_view);
        this.f29369p = textView;
        TextView textView2 = (TextView) findViewById(R$id.navigation_bar_item_large_label_view);
        this.f29370q = textView2;
        setBackgroundResource(getItemBackgroundResId());
        this.f29357d = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.f29358e = viewGroup.getPaddingBottom();
        this.f29359f = getResources().getDimensionPixelSize(R$dimen.m3_navigation_item_active_indicator_label_padding);
        ViewCompat.setImportantForAccessibility(textView, 2);
        ViewCompat.setImportantForAccessibility(textView2, 2);
        setFocusable(true);
        e(textView.getTextSize(), textView2.getTextSize());
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new a());
        }
    }

    private void e(float f11, float f12) {
        this.f29360g = f11 - f12;
        this.f29361h = (f12 * 1.0f) / f11;
        this.f29362i = (f11 * 1.0f) / f12;
    }

    private static Drawable g(ColorStateList colorStateList) {
        return new RippleDrawable(ya.b.a(colorStateList), null, null);
    }

    private View getIconOrContainer() {
        FrameLayout frameLayout = this.f29365l;
        return frameLayout != null ? frameLayout : this.f29367n;
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int indexOfChild = viewGroup.indexOfChild(this);
        int i11 = 0;
        for (int i12 = 0; i12 < indexOfChild; i12++) {
            View childAt = viewGroup.getChildAt(i12);
            if ((childAt instanceof NavigationBarItemView) && childAt.getVisibility() == 0) {
                i11++;
            }
        }
        return i11;
    }

    private int getSuggestedIconHeight() {
        return ((FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams()).topMargin + getIconOrContainer().getMeasuredHeight();
    }

    private int getSuggestedIconWidth() {
        BadgeDrawable badgeDrawable = this.F;
        int minimumWidth = badgeDrawable == null ? 0 : badgeDrawable.getMinimumWidth() - this.F.l();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams();
        return Math.max(minimumWidth, layoutParams.leftMargin) + this.f29367n.getMeasuredWidth() + Math.max(minimumWidth, layoutParams.rightMargin);
    }

    private FrameLayout h(View view) {
        ImageView imageView = this.f29367n;
        if (view == imageView && com.google.android.material.badge.c.f28360a) {
            return (FrameLayout) imageView.getParent();
        }
        return null;
    }

    private boolean i() {
        return this.F != null;
    }

    private boolean j() {
        return this.D && this.f29363j == 2;
    }

    private void k(float f11) {
        if (!this.A || !this.f29354a || !ViewCompat.isAttachedToWindow(this)) {
            o(f11, f11);
            return;
        }
        ValueAnimator valueAnimator = this.f29377x;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f29377x = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f29379z, f11);
        this.f29377x = ofFloat;
        ofFloat.addUpdateListener(new b(f11));
        this.f29377x.setInterpolator(j.g(getContext(), R$attr.motionEasingEmphasizedInterpolator, oa.a.f71042b));
        this.f29377x.setDuration(j.f(getContext(), R$attr.motionDurationLong2, getResources().getInteger(R$integer.material_motion_duration_long_1)));
        this.f29377x.start();
    }

    private void l() {
        h hVar = this.f29373t;
        if (hVar != null) {
            setChecked(hVar.isChecked());
        }
    }

    private void m() {
        Drawable drawable = this.f29356c;
        RippleDrawable rippleDrawable = null;
        boolean z10 = true;
        if (this.f29355b != null) {
            Drawable activeIndicatorDrawable = getActiveIndicatorDrawable();
            if (this.A && getActiveIndicatorDrawable() != null && this.f29365l != null && activeIndicatorDrawable != null) {
                rippleDrawable = new RippleDrawable(ya.b.d(this.f29355b), null, activeIndicatorDrawable);
                z10 = false;
            } else if (drawable == null) {
                drawable = g(this.f29355b);
            }
        }
        FrameLayout frameLayout = this.f29365l;
        if (frameLayout != null) {
            frameLayout.setPadding(0, 0, 0, 0);
            this.f29365l.setForeground(rippleDrawable);
        }
        ViewCompat.setBackground(this, drawable);
        if (Build.VERSION.SDK_INT >= 26) {
            setDefaultFocusHighlightEnabled(z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(float f11, float f12) {
        View view = this.f29366m;
        if (view != null) {
            this.f29378y.d(f11, f12, view);
        }
        this.f29379z = f11;
    }

    private static void p(TextView textView, int i11) {
        androidx.core.widget.m.q(textView, i11);
        int i12 = xa.c.i(textView.getContext(), i11, 0);
        if (i12 != 0) {
            textView.setTextSize(0, i12);
        }
    }

    private static void q(View view, float f11, float f12, int i11) {
        view.setScaleX(f11);
        view.setScaleY(f12);
        view.setVisibility(i11);
    }

    private static void r(View view, int i11, int i12) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i11;
        layoutParams.bottomMargin = i11;
        layoutParams.gravity = i12;
        view.setLayoutParams(layoutParams);
    }

    private void s(View view) {
        if (i() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            com.google.android.material.badge.c.c(this.F, view, h(view));
        }
    }

    private void t(View view) {
        if (i()) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                com.google.android.material.badge.c.f(this.F, view);
            }
            this.F = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(View view) {
        if (i()) {
            com.google.android.material.badge.c.g(this.F, view, h(view));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i11) {
        if (this.f29366m == null || i11 <= 0) {
            return;
        }
        int min = Math.min(this.B, i11 - (this.E * 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f29366m.getLayoutParams();
        layoutParams.height = j() ? min : this.C;
        layoutParams.width = min;
        this.f29366m.setLayoutParams(layoutParams);
    }

    private void w() {
        if (j()) {
            this.f29378y = I;
        } else {
            this.f29378y = H;
        }
    }

    private static void x(View view, int i11) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i11);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        FrameLayout frameLayout = this.f29365l;
        if (frameLayout != null && this.A) {
            frameLayout.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        n();
        this.f29373t = null;
        this.f29379z = 0.0f;
        this.f29354a = false;
    }

    @Nullable
    public Drawable getActiveIndicatorDrawable() {
        View view = this.f29366m;
        if (view == null) {
            return null;
        }
        return view.getBackground();
    }

    @Nullable
    public BadgeDrawable getBadge() {
        return this.F;
    }

    protected int getItemBackgroundResId() {
        return R$drawable.mtrl_navigation_bar_item_background;
    }

    @Override // androidx.appcompat.view.menu.m.a
    @Nullable
    public h getItemData() {
        return this.f29373t;
    }

    protected int getItemDefaultMarginResId() {
        return R$dimen.mtrl_navigation_bar_item_default_margin;
    }

    protected abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.f29371r;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f29368o.getLayoutParams();
        return getSuggestedIconHeight() + (this.f29368o.getVisibility() == 0 ? this.f29359f : 0) + layoutParams.topMargin + this.f29368o.getMeasuredHeight() + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f29368o.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), layoutParams.leftMargin + this.f29368o.getMeasuredWidth() + layoutParams.rightMargin);
    }

    @Override // androidx.appcompat.view.menu.m.a
    public void initialize(@NonNull h hVar, int i11) {
        this.f29373t = hVar;
        setCheckable(hVar.isCheckable());
        setChecked(hVar.isChecked());
        setEnabled(hVar.isEnabled());
        setIcon(hVar.getIcon());
        setTitle(hVar.getTitle());
        setId(hVar.getItemId());
        if (!TextUtils.isEmpty(hVar.getContentDescription())) {
            setContentDescription(hVar.getContentDescription());
        }
        CharSequence tooltipText = !TextUtils.isEmpty(hVar.getTooltipText()) ? hVar.getTooltipText() : hVar.getTitle();
        if (Build.VERSION.SDK_INT > 23) {
            o0.a(this, tooltipText);
        }
        setVisibility(hVar.isVisible() ? 0 : 8);
        this.f29354a = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        t(this.f29367n);
    }

    @Override // android.view.ViewGroup, android.view.View
    @NonNull
    public int[] onCreateDrawableState(int i11) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i11 + 1);
        h hVar = this.f29373t;
        if (hVar != null && hVar.isCheckable() && this.f29373t.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, G);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable = this.F;
        if (badgeDrawable != null && badgeDrawable.isVisible()) {
            CharSequence title = this.f29373t.getTitle();
            if (!TextUtils.isEmpty(this.f29373t.getContentDescription())) {
                title = this.f29373t.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(((Object) title) + ", " + ((Object) this.F.i()));
        }
        AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
        wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            wrap.setClickable(false);
            wrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        }
        wrap.setRoleDescription(getResources().getString(R$string.item_view_role_description));
    }

    @Override // android.view.View
    protected void onSizeChanged(final int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        post(new Runnable() { // from class: com.google.android.material.navigation.NavigationBarItemView.2
            @Override // java.lang.Runnable
            public void run() {
                NavigationBarItemView.this.v(i11);
            }
        });
    }

    @Override // androidx.appcompat.view.menu.m.a
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setActiveIndicatorDrawable(@Nullable Drawable drawable) {
        View view = this.f29366m;
        if (view == null) {
            return;
        }
        view.setBackgroundDrawable(drawable);
        m();
    }

    public void setActiveIndicatorEnabled(boolean z10) {
        this.A = z10;
        m();
        View view = this.f29366m;
        if (view != null) {
            view.setVisibility(z10 ? 0 : 8);
            requestLayout();
        }
    }

    public void setActiveIndicatorHeight(int i11) {
        this.C = i11;
        v(getWidth());
    }

    public void setActiveIndicatorLabelPadding(int i11) {
        if (this.f29359f != i11) {
            this.f29359f = i11;
            l();
        }
    }

    public void setActiveIndicatorMarginHorizontal(int i11) {
        this.E = i11;
        v(getWidth());
    }

    public void setActiveIndicatorResizeable(boolean z10) {
        this.D = z10;
    }

    public void setActiveIndicatorWidth(int i11) {
        this.B = i11;
        v(getWidth());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBadge(@NonNull BadgeDrawable badgeDrawable) {
        if (this.F == badgeDrawable) {
            return;
        }
        if (i() && this.f29367n != null) {
            Log.w("NavigationBar", "Multiple badges shouldn't be attached to one item.");
            t(this.f29367n);
        }
        this.F = badgeDrawable;
        ImageView imageView = this.f29367n;
        if (imageView != null) {
            s(imageView);
        }
    }

    public void setCheckable(boolean z10) {
        refreshDrawableState();
    }

    public void setChecked(boolean z10) {
        this.f29370q.setPivotX(r0.getWidth() / 2);
        this.f29370q.setPivotY(r0.getBaseline());
        this.f29369p.setPivotX(r0.getWidth() / 2);
        this.f29369p.setPivotY(r0.getBaseline());
        k(z10 ? 1.0f : 0.0f);
        int i11 = this.f29363j;
        if (i11 != -1) {
            if (i11 == 0) {
                if (z10) {
                    r(getIconOrContainer(), this.f29357d, 49);
                    x(this.f29368o, this.f29358e);
                    this.f29370q.setVisibility(0);
                } else {
                    r(getIconOrContainer(), this.f29357d, 17);
                    x(this.f29368o, 0);
                    this.f29370q.setVisibility(4);
                }
                this.f29369p.setVisibility(4);
            } else if (i11 == 1) {
                x(this.f29368o, this.f29358e);
                if (z10) {
                    r(getIconOrContainer(), (int) (this.f29357d + this.f29360g), 49);
                    q(this.f29370q, 1.0f, 1.0f, 0);
                    TextView textView = this.f29369p;
                    float f11 = this.f29361h;
                    q(textView, f11, f11, 4);
                } else {
                    r(getIconOrContainer(), this.f29357d, 49);
                    TextView textView2 = this.f29370q;
                    float f12 = this.f29362i;
                    q(textView2, f12, f12, 4);
                    q(this.f29369p, 1.0f, 1.0f, 0);
                }
            } else if (i11 == 2) {
                r(getIconOrContainer(), this.f29357d, 17);
                this.f29370q.setVisibility(8);
                this.f29369p.setVisibility(8);
            }
        } else if (this.f29364k) {
            if (z10) {
                r(getIconOrContainer(), this.f29357d, 49);
                x(this.f29368o, this.f29358e);
                this.f29370q.setVisibility(0);
            } else {
                r(getIconOrContainer(), this.f29357d, 17);
                x(this.f29368o, 0);
                this.f29370q.setVisibility(4);
            }
            this.f29369p.setVisibility(4);
        } else {
            x(this.f29368o, this.f29358e);
            if (z10) {
                r(getIconOrContainer(), (int) (this.f29357d + this.f29360g), 49);
                q(this.f29370q, 1.0f, 1.0f, 0);
                TextView textView3 = this.f29369p;
                float f13 = this.f29361h;
                q(textView3, f13, f13, 4);
            } else {
                r(getIconOrContainer(), this.f29357d, 49);
                TextView textView4 = this.f29370q;
                float f14 = this.f29362i;
                q(textView4, f14, f14, 4);
                q(this.f29369p, 1.0f, 1.0f, 0);
            }
        }
        refreshDrawableState();
        setSelected(z10);
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        this.f29369p.setEnabled(z10);
        this.f29370q.setEnabled(z10);
        this.f29367n.setEnabled(z10);
        if (z10) {
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        } else {
            ViewCompat.setPointerIcon(this, null);
        }
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (drawable == this.f29375v) {
            return;
        }
        this.f29375v = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = a1.a.r(drawable).mutate();
            this.f29376w = drawable;
            ColorStateList colorStateList = this.f29374u;
            if (colorStateList != null) {
                a1.a.o(drawable, colorStateList);
            }
        }
        this.f29367n.setImageDrawable(drawable);
    }

    public void setIconSize(int i11) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f29367n.getLayoutParams();
        layoutParams.width = i11;
        layoutParams.height = i11;
        this.f29367n.setLayoutParams(layoutParams);
    }

    public void setIconTintList(@Nullable ColorStateList colorStateList) {
        Drawable drawable;
        this.f29374u = colorStateList;
        if (this.f29373t == null || (drawable = this.f29376w) == null) {
            return;
        }
        a1.a.o(drawable, colorStateList);
        this.f29376w.invalidateSelf();
    }

    public void setItemBackground(int i11) {
        setItemBackground(i11 == 0 ? null : androidx.core.content.b.getDrawable(getContext(), i11));
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        this.f29356c = drawable;
        m();
    }

    public void setItemPaddingBottom(int i11) {
        if (this.f29358e != i11) {
            this.f29358e = i11;
            l();
        }
    }

    public void setItemPaddingTop(int i11) {
        if (this.f29357d != i11) {
            this.f29357d = i11;
            l();
        }
    }

    public void setItemPosition(int i11) {
        this.f29371r = i11;
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        this.f29355b = colorStateList;
        m();
    }

    public void setLabelVisibilityMode(int i11) {
        if (this.f29363j != i11) {
            this.f29363j = i11;
            w();
            v(getWidth());
            l();
        }
    }

    public void setShifting(boolean z10) {
        if (this.f29364k != z10) {
            this.f29364k = z10;
            l();
        }
    }

    public void setShortcut(boolean z10, char c11) {
    }

    public void setTextAppearanceActive(int i11) {
        this.f29372s = i11;
        p(this.f29370q, i11);
        e(this.f29369p.getTextSize(), this.f29370q.getTextSize());
    }

    public void setTextAppearanceActiveBoldEnabled(boolean z10) {
        setTextAppearanceActive(this.f29372s);
        TextView textView = this.f29370q;
        textView.setTypeface(textView.getTypeface(), z10 ? 1 : 0);
    }

    public void setTextAppearanceInactive(int i11) {
        p(this.f29369p, i11);
        e(this.f29369p.getTextSize(), this.f29370q.getTextSize());
    }

    public void setTextColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f29369p.setTextColor(colorStateList);
            this.f29370q.setTextColor(colorStateList);
        }
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.f29369p.setText(charSequence);
        this.f29370q.setText(charSequence);
        h hVar = this.f29373t;
        if (hVar == null || TextUtils.isEmpty(hVar.getContentDescription())) {
            setContentDescription(charSequence);
        }
        h hVar2 = this.f29373t;
        if (hVar2 != null && !TextUtils.isEmpty(hVar2.getTooltipText())) {
            charSequence = this.f29373t.getTooltipText();
        }
        if (Build.VERSION.SDK_INT > 23) {
            o0.a(this, charSequence);
        }
    }

    public boolean showsIcon() {
        return true;
    }
}

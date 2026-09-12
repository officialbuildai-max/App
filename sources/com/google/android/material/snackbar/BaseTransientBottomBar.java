package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.f0;
import com.google.android.material.internal.g0;
import com.google.android.material.snackbar.d;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class BaseTransientBottomBar {

    /* renamed from: a, reason: collision with root package name */
    private final int f29792a;

    /* renamed from: b, reason: collision with root package name */
    private final int f29793b;

    /* renamed from: c, reason: collision with root package name */
    private final int f29794c;

    /* renamed from: d, reason: collision with root package name */
    private final TimeInterpolator f29795d;

    /* renamed from: e, reason: collision with root package name */
    private final TimeInterpolator f29796e;

    /* renamed from: f, reason: collision with root package name */
    private final TimeInterpolator f29797f;

    /* renamed from: g, reason: collision with root package name */
    private final ViewGroup f29798g;

    /* renamed from: h, reason: collision with root package name */
    private final Context f29799h;

    /* renamed from: i, reason: collision with root package name */
    protected final SnackbarBaseLayout f29800i;

    /* renamed from: j, reason: collision with root package name */
    private final com.google.android.material.snackbar.a f29801j;

    /* renamed from: k, reason: collision with root package name */
    private int f29802k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f29803l;

    /* renamed from: o, reason: collision with root package name */
    private int f29806o;

    /* renamed from: p, reason: collision with root package name */
    private int f29807p;

    /* renamed from: q, reason: collision with root package name */
    private int f29808q;

    /* renamed from: r, reason: collision with root package name */
    private int f29809r;

    /* renamed from: s, reason: collision with root package name */
    private int f29810s;

    /* renamed from: t, reason: collision with root package name */
    private int f29811t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f29812u;

    /* renamed from: v, reason: collision with root package name */
    private List f29813v;

    /* renamed from: w, reason: collision with root package name */
    private Behavior f29814w;

    /* renamed from: x, reason: collision with root package name */
    private final AccessibilityManager f29815x;

    /* renamed from: z, reason: collision with root package name */
    private static final TimeInterpolator f29791z = oa.a.f71042b;
    private static final TimeInterpolator A = oa.a.f71041a;
    private static final TimeInterpolator B = oa.a.f71044d;
    private static final boolean D = false;
    private static final int[] E = {R$attr.snackbarStyle};
    private static final String F = BaseTransientBottomBar.class.getSimpleName();
    static final Handler C = new Handler(Looper.getMainLooper(), new h());

    /* renamed from: m, reason: collision with root package name */
    private boolean f29804m = false;

    /* renamed from: n, reason: collision with root package name */
    private final Runnable f29805n = new Runnable() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.2
        @Override // java.lang.Runnable
        public void run() {
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.f29800i == null || baseTransientBottomBar.f29799h == null) {
                return;
            }
            int height = (g0.a(BaseTransientBottomBar.this.f29799h).height() - BaseTransientBottomBar.this.I()) + ((int) BaseTransientBottomBar.this.f29800i.getTranslationY());
            if (height >= BaseTransientBottomBar.this.f29810s) {
                BaseTransientBottomBar baseTransientBottomBar2 = BaseTransientBottomBar.this;
                baseTransientBottomBar2.f29811t = baseTransientBottomBar2.f29810s;
                return;
            }
            ViewGroup.LayoutParams layoutParams = BaseTransientBottomBar.this.f29800i.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                Log.w(BaseTransientBottomBar.F, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                return;
            }
            BaseTransientBottomBar baseTransientBottomBar3 = BaseTransientBottomBar.this;
            baseTransientBottomBar3.f29811t = baseTransientBottomBar3.f29810s;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += BaseTransientBottomBar.this.f29810s - height;
            BaseTransientBottomBar.this.f29800i.requestLayout();
        }
    };

    /* renamed from: y, reason: collision with root package name */
    d.b f29816y = new k();

    /* loaded from: classes4.dex */
    public static class Behavior extends SwipeDismissBehavior<View> {

        /* renamed from: l, reason: collision with root package name */
        private final o f29817l = new o(this);

        /* JADX INFO: Access modifiers changed from: private */
        public void Q(BaseTransientBottomBar baseTransientBottomBar) {
            this.f29817l.c(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean F(View view) {
            return this.f29817l.a(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.f29817l.b(coordinatorLayout, view, motionEvent);
            return super.k(coordinatorLayout, view, motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes4.dex */
    public static class SnackbarBaseLayout extends FrameLayout {

        /* renamed from: l, reason: collision with root package name */
        private static final View.OnTouchListener f29818l = new a();

        /* renamed from: a, reason: collision with root package name */
        private BaseTransientBottomBar f29819a;

        /* renamed from: b, reason: collision with root package name */
        ab.n f29820b;

        /* renamed from: c, reason: collision with root package name */
        private int f29821c;

        /* renamed from: d, reason: collision with root package name */
        private final float f29822d;

        /* renamed from: e, reason: collision with root package name */
        private final float f29823e;

        /* renamed from: f, reason: collision with root package name */
        private final int f29824f;

        /* renamed from: g, reason: collision with root package name */
        private final int f29825g;

        /* renamed from: h, reason: collision with root package name */
        private ColorStateList f29826h;

        /* renamed from: i, reason: collision with root package name */
        private PorterDuff.Mode f29827i;

        /* renamed from: j, reason: collision with root package name */
        private Rect f29828j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f29829k;

        /* loaded from: classes4.dex */
        class a implements View.OnTouchListener {
            a() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public SnackbarBaseLayout(Context context) {
            this(context, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public SnackbarBaseLayout(Context context, AttributeSet attributeSet) {
            super(bb.a.c(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.SnackbarLayout);
            if (obtainStyledAttributes.hasValue(R$styleable.SnackbarLayout_elevation)) {
                ViewCompat.setElevation(this, obtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_elevation, 0));
            }
            this.f29821c = obtainStyledAttributes.getInt(R$styleable.SnackbarLayout_animationMode, 0);
            if (obtainStyledAttributes.hasValue(R$styleable.SnackbarLayout_shapeAppearance) || obtainStyledAttributes.hasValue(R$styleable.SnackbarLayout_shapeAppearanceOverlay)) {
                this.f29820b = ab.n.e(context2, attributeSet, 0, 0).m();
            }
            this.f29822d = obtainStyledAttributes.getFloat(R$styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(xa.c.a(context2, obtainStyledAttributes, R$styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(f0.r(obtainStyledAttributes.getInt(R$styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.f29823e = obtainStyledAttributes.getFloat(R$styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            this.f29824f = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_android_maxWidth, -1);
            this.f29825g = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_maxActionInlineWidth, -1);
            obtainStyledAttributes.recycle();
            setOnTouchListener(f29818l);
            setFocusable(true);
            if (getBackground() == null) {
                ViewCompat.setBackground(this, d());
            }
        }

        private Drawable d() {
            int k11 = com.google.android.material.color.b.k(this, R$attr.colorSurface, R$attr.colorOnSurface, getBackgroundOverlayColorAlpha());
            ab.n nVar = this.f29820b;
            Drawable w11 = nVar != null ? BaseTransientBottomBar.w(k11, nVar) : BaseTransientBottomBar.v(k11, getResources());
            if (this.f29826h == null) {
                return a1.a.r(w11);
            }
            Drawable r11 = a1.a.r(w11);
            a1.a.o(r11, this.f29826h);
            return r11;
        }

        private void e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f29828j = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBaseTransientBottomBar(BaseTransientBottomBar baseTransientBottomBar) {
            this.f29819a = baseTransientBottomBar;
        }

        void c(ViewGroup viewGroup) {
            this.f29829k = true;
            viewGroup.addView(this);
            this.f29829k = false;
        }

        float getActionTextColorAlpha() {
            return this.f29823e;
        }

        int getAnimationMode() {
            return this.f29821c;
        }

        float getBackgroundOverlayColorAlpha() {
            return this.f29822d;
        }

        int getMaxInlineActionWidth() {
            return this.f29825g;
        }

        int getMaxWidth() {
            return this.f29824f;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            BaseTransientBottomBar baseTransientBottomBar = this.f29819a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.N();
            }
            ViewCompat.requestApplyInsets(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            BaseTransientBottomBar baseTransientBottomBar = this.f29819a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.O();
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
            super.onLayout(z10, i11, i12, i13, i14);
            BaseTransientBottomBar baseTransientBottomBar = this.f29819a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.P();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i11, int i12) {
            super.onMeasure(i11, i12);
            if (this.f29824f > 0) {
                int measuredWidth = getMeasuredWidth();
                int i13 = this.f29824f;
                if (measuredWidth > i13) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i13, 1073741824), i12);
                }
            }
        }

        void setAnimationMode(int i11) {
            this.f29821c = i11;
        }

        @Override // android.view.View
        public void setBackground(@Nullable Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(@Nullable Drawable drawable) {
            if (drawable != null && this.f29826h != null) {
                drawable = a1.a.r(drawable.mutate());
                a1.a.o(drawable, this.f29826h);
                a1.a.p(drawable, this.f29827i);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            this.f29826h = colorStateList;
            if (getBackground() != null) {
                Drawable r11 = a1.a.r(getBackground().mutate());
                a1.a.o(r11, colorStateList);
                a1.a.p(r11, this.f29827i);
                if (r11 != getBackground()) {
                    super.setBackgroundDrawable(r11);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            this.f29827i = mode;
            if (getBackground() != null) {
                Drawable r11 = a1.a.r(getBackground().mutate());
                a1.a.p(r11, mode);
                if (r11 != getBackground()) {
                    super.setBackgroundDrawable(r11);
                }
            }
        }

        @Override // android.view.View
        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
            if (this.f29829k || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            e((ViewGroup.MarginLayoutParams) layoutParams);
            BaseTransientBottomBar baseTransientBottomBar = this.f29819a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.e0();
            }
        }

        @Override // android.view.View
        public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f29818l);
            super.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f29830a;

        a(int i11) {
            this.f29830a = i11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.Q(this.f29830a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.f29800i.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BaseTransientBottomBar.this.f29800i.setScaleX(floatValue);
            BaseTransientBottomBar.this.f29800i.setScaleY(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.R();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f29801j.animateContentIn(BaseTransientBottomBar.this.f29794c - BaseTransientBottomBar.this.f29792a, BaseTransientBottomBar.this.f29792a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        private int f29835a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f29836b;

        e(int i11) {
            this.f29836b = i11;
            this.f29835a = i11;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.D) {
                ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.f29800i, intValue - this.f29835a);
            } else {
                BaseTransientBottomBar.this.f29800i.setTranslationY(intValue);
            }
            this.f29835a = intValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class f extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f29838a;

        f(int i11) {
            this.f29838a = i11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.Q(this.f29838a);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f29801j.animateContentOut(0, BaseTransientBottomBar.this.f29793b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        private int f29840a = 0;

        g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.D) {
                ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.f29800i, intValue - this.f29840a);
            } else {
                BaseTransientBottomBar.this.f29800i.setTranslationY(intValue);
            }
            this.f29840a = intValue;
        }
    }

    /* loaded from: classes4.dex */
    class h implements Handler.Callback {
        h() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == 0) {
                ((BaseTransientBottomBar) message.obj).Y();
                return true;
            }
            if (i11 != 1) {
                return false;
            }
            ((BaseTransientBottomBar) message.obj).K(message.arg1);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    class i implements OnApplyWindowInsetsListener {
        i() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            BaseTransientBottomBar.this.f29806o = windowInsetsCompat.getSystemWindowInsetBottom();
            BaseTransientBottomBar.this.f29807p = windowInsetsCompat.getSystemWindowInsetLeft();
            BaseTransientBottomBar.this.f29808q = windowInsetsCompat.getSystemWindowInsetRight();
            BaseTransientBottomBar.this.e0();
            return windowInsetsCompat;
        }
    }

    /* loaded from: classes4.dex */
    class j extends AccessibilityDelegateCompat {
        j() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.addAction(1048576);
            accessibilityNodeInfoCompat.setDismissable(true);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i11, Bundle bundle) {
            if (i11 != 1048576) {
                return super.performAccessibilityAction(view, i11, bundle);
            }
            BaseTransientBottomBar.this.x();
            return true;
        }
    }

    /* loaded from: classes4.dex */
    class k implements d.b {
        k() {
        }

        @Override // com.google.android.material.snackbar.d.b
        public void a(int i11) {
            Handler handler = BaseTransientBottomBar.C;
            handler.sendMessage(handler.obtainMessage(1, i11, 0, BaseTransientBottomBar.this));
        }

        @Override // com.google.android.material.snackbar.d.b
        public void show() {
            Handler handler = BaseTransientBottomBar.C;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class l implements SwipeDismissBehavior.c {
        l() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void a(View view) {
            if (view.getParent() != null) {
                view.setVisibility(8);
            }
            BaseTransientBottomBar.this.y(0);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void b(int i11) {
            if (i11 == 0) {
                com.google.android.material.snackbar.d.c().k(BaseTransientBottomBar.this.f29816y);
            } else if (i11 == 1 || i11 == 2) {
                com.google.android.material.snackbar.d.c().j(BaseTransientBottomBar.this.f29816y);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class m extends AnimatorListenerAdapter {
        m() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.R();
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class n {
        public void a(Object obj, int i11) {
        }

        public void b(Object obj) {
        }
    }

    /* loaded from: classes4.dex */
    public static class o {

        /* renamed from: a, reason: collision with root package name */
        private d.b f29847a;

        public o(SwipeDismissBehavior swipeDismissBehavior) {
            swipeDismissBehavior.M(0.1f);
            swipeDismissBehavior.K(0.6f);
            swipeDismissBehavior.N(0);
        }

        public boolean a(View view) {
            return view instanceof SnackbarBaseLayout;
        }

        public void b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    com.google.android.material.snackbar.d.c().j(this.f29847a);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                com.google.android.material.snackbar.d.c().k(this.f29847a);
            }
        }

        public void c(BaseTransientBottomBar baseTransientBottomBar) {
            this.f29847a = baseTransientBottomBar.f29816y;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseTransientBottomBar(Context context, ViewGroup viewGroup, View view, com.google.android.material.snackbar.a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        }
        if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
        this.f29798g = viewGroup;
        this.f29801j = aVar;
        this.f29799h = context;
        b0.a(context);
        SnackbarBaseLayout snackbarBaseLayout = (SnackbarBaseLayout) LayoutInflater.from(context).inflate(F(), viewGroup, false);
        this.f29800i = snackbarBaseLayout;
        snackbarBaseLayout.setBaseTransientBottomBar(this);
        if (view instanceof SnackbarContentLayout) {
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) view;
            snackbarContentLayout.a(snackbarBaseLayout.getActionTextColorAlpha());
            snackbarContentLayout.setMaxInlineActionWidth(snackbarBaseLayout.getMaxInlineActionWidth());
        }
        snackbarBaseLayout.addView(view);
        ViewCompat.setAccessibilityLiveRegion(snackbarBaseLayout, 1);
        ViewCompat.setImportantForAccessibility(snackbarBaseLayout, 1);
        ViewCompat.setFitsSystemWindows(snackbarBaseLayout, true);
        ViewCompat.setOnApplyWindowInsetsListener(snackbarBaseLayout, new i());
        ViewCompat.setAccessibilityDelegate(snackbarBaseLayout, new j());
        this.f29815x = (AccessibilityManager) context.getSystemService("accessibility");
        this.f29794c = wa.j.f(context, R$attr.motionDurationLong2, 250);
        this.f29792a = wa.j.f(context, R$attr.motionDurationLong2, 150);
        this.f29793b = wa.j.f(context, R$attr.motionDurationMedium1, 75);
        this.f29795d = wa.j.g(context, R$attr.motionEasingEmphasizedInterpolator, A);
        this.f29797f = wa.j.g(context, R$attr.motionEasingEmphasizedInterpolator, B);
        this.f29796e = wa.j.g(context, R$attr.motionEasingEmphasizedInterpolator, f29791z);
    }

    private ValueAnimator E(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(this.f29797f);
        ofFloat.addUpdateListener(new c());
        return ofFloat;
    }

    private int G() {
        int height = this.f29800i.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f29800i.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int I() {
        int[] iArr = new int[2];
        this.f29800i.getLocationInWindow(iArr);
        return iArr[1] + this.f29800i.getHeight();
    }

    private boolean M() {
        ViewGroup.LayoutParams layoutParams = this.f29800i.getLayoutParams();
        return (layoutParams instanceof CoordinatorLayout.f) && (((CoordinatorLayout.f) layoutParams).f() instanceof SwipeDismissBehavior);
    }

    private void S() {
        this.f29809r = u();
        e0();
    }

    private void U(CoordinatorLayout.f fVar) {
        SwipeDismissBehavior swipeDismissBehavior = this.f29814w;
        if (swipeDismissBehavior == null) {
            swipeDismissBehavior = D();
        }
        if (swipeDismissBehavior instanceof Behavior) {
            ((Behavior) swipeDismissBehavior).Q(this);
        }
        swipeDismissBehavior.L(new l());
        fVar.o(swipeDismissBehavior);
        if (A() == null) {
            fVar.f7988g = 80;
        }
    }

    private boolean W() {
        return this.f29810s > 0 && !this.f29803l && M();
    }

    private void Z() {
        if (V()) {
            s();
            return;
        }
        if (this.f29800i.getParent() != null) {
            this.f29800i.setVisibility(0);
        }
        R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        ValueAnimator z10 = z(0.0f, 1.0f);
        ValueAnimator E2 = E(0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(z10, E2);
        animatorSet.setDuration(this.f29792a);
        animatorSet.addListener(new m());
        animatorSet.start();
    }

    private void b0(int i11) {
        ValueAnimator z10 = z(1.0f, 0.0f);
        z10.setDuration(this.f29793b);
        z10.addListener(new a(i11));
        z10.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0() {
        int G = G();
        if (D) {
            ViewCompat.offsetTopAndBottom(this.f29800i, G);
        } else {
            this.f29800i.setTranslationY(G);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(G, 0);
        valueAnimator.setInterpolator(this.f29796e);
        valueAnimator.setDuration(this.f29794c);
        valueAnimator.addListener(new d());
        valueAnimator.addUpdateListener(new e(G));
        valueAnimator.start();
    }

    private void d0(int i11) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, G());
        valueAnimator.setInterpolator(this.f29796e);
        valueAnimator.setDuration(this.f29794c);
        valueAnimator.addListener(new f(i11));
        valueAnimator.addUpdateListener(new g());
        valueAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        ViewGroup.LayoutParams layoutParams = this.f29800i.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            Log.w(F, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }
        if (this.f29800i.f29828j == null) {
            Log.w(F, "Unable to update margins because original view margins are not set");
            return;
        }
        if (this.f29800i.getParent() == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int i11 = this.f29800i.f29828j.bottom + (A() != null ? this.f29809r : this.f29806o);
        int i12 = this.f29800i.f29828j.left + this.f29807p;
        int i13 = this.f29800i.f29828j.right + this.f29808q;
        int i14 = this.f29800i.f29828j.top;
        boolean z10 = (marginLayoutParams.bottomMargin == i11 && marginLayoutParams.leftMargin == i12 && marginLayoutParams.rightMargin == i13 && marginLayoutParams.topMargin == i14) ? false : true;
        if (z10) {
            marginLayoutParams.bottomMargin = i11;
            marginLayoutParams.leftMargin = i12;
            marginLayoutParams.rightMargin = i13;
            marginLayoutParams.topMargin = i14;
            this.f29800i.requestLayout();
        }
        if ((z10 || this.f29811t != this.f29810s) && Build.VERSION.SDK_INT >= 29 && W()) {
            this.f29800i.removeCallbacks(this.f29805n);
            this.f29800i.post(this.f29805n);
        }
    }

    private void t(int i11) {
        if (this.f29800i.getAnimationMode() == 1) {
            b0(i11);
        } else {
            d0(i11);
        }
    }

    private int u() {
        if (A() == null) {
            return 0;
        }
        int[] iArr = new int[2];
        A().getLocationOnScreen(iArr);
        int i11 = iArr[1];
        int[] iArr2 = new int[2];
        this.f29798g.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.f29798g.getHeight()) - i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static GradientDrawable v(int i11, Resources resources) {
        float dimension = resources.getDimension(R$dimen.mtrl_snackbar_background_corner_radius);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(dimension);
        gradientDrawable.setColor(i11);
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ab.i w(int i11, ab.n nVar) {
        ab.i iVar = new ab.i(nVar);
        iVar.d0(ColorStateList.valueOf(i11));
        return iVar;
    }

    private ValueAnimator z(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(this.f29795d);
        ofFloat.addUpdateListener(new b());
        return ofFloat;
    }

    public View A() {
        return null;
    }

    public Context B() {
        return this.f29799h;
    }

    public int C() {
        return this.f29802k;
    }

    protected SwipeDismissBehavior D() {
        return new Behavior();
    }

    protected int F() {
        return J() ? R$layout.mtrl_layout_snackbar : R$layout.design_layout_snackbar;
    }

    public View H() {
        return this.f29800i;
    }

    protected boolean J() {
        TypedArray obtainStyledAttributes = this.f29799h.obtainStyledAttributes(E);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    final void K(int i11) {
        if (V() && this.f29800i.getVisibility() == 0) {
            t(i11);
        } else {
            Q(i11);
        }
    }

    public boolean L() {
        return com.google.android.material.snackbar.d.c().e(this.f29816y);
    }

    void N() {
        WindowInsets rootWindowInsets;
        Insets mandatorySystemGestureInsets;
        int i11;
        if (Build.VERSION.SDK_INT < 29 || (rootWindowInsets = this.f29800i.getRootWindowInsets()) == null) {
            return;
        }
        mandatorySystemGestureInsets = rootWindowInsets.getMandatorySystemGestureInsets();
        i11 = mandatorySystemGestureInsets.bottom;
        this.f29810s = i11;
        e0();
    }

    void O() {
        if (L()) {
            C.post(new Runnable() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.6
                @Override // java.lang.Runnable
                public void run() {
                    BaseTransientBottomBar.this.Q(3);
                }
            });
        }
    }

    void P() {
        if (this.f29812u) {
            Z();
            this.f29812u = false;
        }
    }

    void Q(int i11) {
        com.google.android.material.snackbar.d.c().h(this.f29816y);
        List list = this.f29813v;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((n) this.f29813v.get(size)).a(this, i11);
            }
        }
        ViewParent parent = this.f29800i.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f29800i);
        }
    }

    void R() {
        com.google.android.material.snackbar.d.c().i(this.f29816y);
        List list = this.f29813v;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((n) this.f29813v.get(size)).b(this);
            }
        }
    }

    public BaseTransientBottomBar T(int i11) {
        this.f29802k = i11;
        return this;
    }

    boolean V() {
        AccessibilityManager accessibilityManager = this.f29815x;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    public void X() {
        com.google.android.material.snackbar.d.c().m(C(), this.f29816y);
    }

    final void Y() {
        if (this.f29800i.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f29800i.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                U((CoordinatorLayout.f) layoutParams);
            }
            this.f29800i.c(this.f29798g);
            S();
            this.f29800i.setVisibility(4);
        }
        if (ViewCompat.isLaidOut(this.f29800i)) {
            Z();
        } else {
            this.f29812u = true;
        }
    }

    void s() {
        this.f29800i.post(new Runnable() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.8
            @Override // java.lang.Runnable
            public void run() {
                SnackbarBaseLayout snackbarBaseLayout = BaseTransientBottomBar.this.f29800i;
                if (snackbarBaseLayout == null) {
                    return;
                }
                if (snackbarBaseLayout.getParent() != null) {
                    BaseTransientBottomBar.this.f29800i.setVisibility(0);
                }
                if (BaseTransientBottomBar.this.f29800i.getAnimationMode() == 1) {
                    BaseTransientBottomBar.this.a0();
                } else {
                    BaseTransientBottomBar.this.c0();
                }
            }
        });
    }

    public void x() {
        y(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(int i11) {
        com.google.android.material.snackbar.d.c().b(this.f29816y, i11);
    }
}

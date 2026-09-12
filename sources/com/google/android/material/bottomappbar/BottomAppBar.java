package com.google.android.material.bottomappbar;

import ab.i;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$animator;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.f0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import oa.k;
import wa.j;

/* loaded from: classes4.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.b {
    public static final int FAB_ALIGNMENT_MODE_CENTER = 0;
    public static final int FAB_ALIGNMENT_MODE_END = 1;
    public static final int FAB_ANCHOR_MODE_CRADLE = 1;
    public static final int FAB_ANCHOR_MODE_EMBED = 0;
    public static final int FAB_ANIMATION_MODE_SCALE = 0;
    public static final int FAB_ANIMATION_MODE_SLIDE = 1;
    public static final int MENU_ALIGNMENT_MODE_AUTO = 0;
    public static final int MENU_ALIGNMENT_MODE_START = 1;

    /* renamed from: x0, reason: collision with root package name */
    private static final int f28391x0 = R$style.Widget_MaterialComponents_BottomAppBar;

    /* renamed from: y0, reason: collision with root package name */
    private static final int f28392y0 = R$attr.motionDurationLong2;

    /* renamed from: z0, reason: collision with root package name */
    private static final int f28393z0 = R$attr.motionEasingEmphasizedInterpolator;
    private Integer U;
    private final i V;
    private Animator W;

    /* renamed from: a0, reason: collision with root package name */
    private Animator f28394a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f28395b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f28396c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f28397d0;

    /* renamed from: e0, reason: collision with root package name */
    private final int f28398e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f28399f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f28400g0;

    /* renamed from: h0, reason: collision with root package name */
    private final boolean f28401h0;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f28402i0;

    /* renamed from: j0, reason: collision with root package name */
    private final boolean f28403j0;

    /* renamed from: k0, reason: collision with root package name */
    private final boolean f28404k0;

    /* renamed from: l0, reason: collision with root package name */
    private final boolean f28405l0;

    /* renamed from: m0, reason: collision with root package name */
    private int f28406m0;

    /* renamed from: n0, reason: collision with root package name */
    private ArrayList f28407n0;

    /* renamed from: o0, reason: collision with root package name */
    private int f28408o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f28409p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f28410q0;

    /* renamed from: r0, reason: collision with root package name */
    private Behavior f28411r0;

    /* renamed from: s0, reason: collision with root package name */
    private int f28412s0;

    /* renamed from: t0, reason: collision with root package name */
    private int f28413t0;

    /* renamed from: u0, reason: collision with root package name */
    private int f28414u0;

    /* renamed from: v0, reason: collision with root package name */
    AnimatorListenerAdapter f28415v0;

    /* renamed from: w0, reason: collision with root package name */
    k f28416w0;

    /* loaded from: classes4.dex */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: m, reason: collision with root package name */
        private final Rect f28417m;

        /* renamed from: n, reason: collision with root package name */
        private WeakReference f28418n;

        /* renamed from: o, reason: collision with root package name */
        private int f28419o;

        /* renamed from: p, reason: collision with root package name */
        private final View.OnLayoutChangeListener f28420p;

        /* loaded from: classes4.dex */
        class a implements View.OnLayoutChangeListener {
            a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f28418n.get();
                if (bottomAppBar == null || !((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton))) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                int height = view.getHeight();
                if (view instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                    floatingActionButton.getMeasuredContentRect(Behavior.this.f28417m);
                    int height2 = Behavior.this.f28417m.height();
                    bottomAppBar.F0(height2);
                    bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().r().a(new RectF(Behavior.this.f28417m)));
                    height = height2;
                }
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
                if (Behavior.this.f28419o == 0) {
                    if (bottomAppBar.f28397d0 == 1) {
                        ((ViewGroup.MarginLayoutParams) fVar).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R$dimen.mtrl_bottomappbar_fab_bottom_margin) - ((view.getMeasuredHeight() - height) / 2));
                    }
                    ((ViewGroup.MarginLayoutParams) fVar).leftMargin = bottomAppBar.getLeftInset();
                    ((ViewGroup.MarginLayoutParams) fVar).rightMargin = bottomAppBar.getRightInset();
                    if (f0.p(view)) {
                        ((ViewGroup.MarginLayoutParams) fVar).leftMargin += bottomAppBar.f28398e0;
                    } else {
                        ((ViewGroup.MarginLayoutParams) fVar).rightMargin += bottomAppBar.f28398e0;
                    }
                }
                bottomAppBar.E0();
            }
        }

        public Behavior() {
            this.f28420p = new a();
            this.f28417m = new Rect();
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f28420p = new a();
            this.f28417m = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: U, reason: merged with bridge method [inline-methods] */
        public boolean l(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i11) {
            this.f28418n = new WeakReference(bottomAppBar);
            View v02 = bottomAppBar.v0();
            if (v02 != null && !ViewCompat.isLaidOut(v02)) {
                BottomAppBar.I0(bottomAppBar, v02);
                this.f28419o = ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) v02.getLayoutParams())).bottomMargin;
                if (v02 instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) v02;
                    if (bottomAppBar.f28397d0 == 0 && bottomAppBar.f28401h0) {
                        ViewCompat.setElevation(floatingActionButton, 0.0f);
                        floatingActionButton.setCompatElevation(0.0f);
                    }
                    if (floatingActionButton.getShowMotionSpec() == null) {
                        floatingActionButton.setShowMotionSpecResource(R$animator.mtrl_fab_show_motion_spec);
                    }
                    if (floatingActionButton.getHideMotionSpec() == null) {
                        floatingActionButton.setHideMotionSpecResource(R$animator.mtrl_fab_hide_motion_spec);
                    }
                    bottomAppBar.n0(floatingActionButton);
                }
                v02.addOnLayoutChangeListener(this.f28420p);
                bottomAppBar.E0();
            }
            coordinatorLayout.onLayoutChild(bottomAppBar, i11);
            return super.l(coordinatorLayout, bottomAppBar, i11);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: V, reason: merged with bridge method [inline-methods] */
        public boolean A(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i11, int i12) {
            return bottomAppBar.getHideOnScroll() && super.A(coordinatorLayout, bottomAppBar, view, view2, i11, i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        int f28422a;

        /* renamed from: b, reason: collision with root package name */
        boolean f28423b;

        /* loaded from: classes4.dex */
        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f28422a = parcel.readInt();
            this.f28423b = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.f28422a);
            parcel.writeInt(this.f28423b ? 1 : 0);
        }
    }

    /* loaded from: classes4.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (BottomAppBar.this.f28409p0) {
                return;
            }
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.A0(bottomAppBar.f28395b0, BottomAppBar.this.f28410q0);
        }
    }

    /* loaded from: classes4.dex */
    class b implements k {
        b() {
        }

        @Override // oa.k
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(FloatingActionButton floatingActionButton) {
            BottomAppBar.this.V.e0((floatingActionButton.getVisibility() == 0 && BottomAppBar.this.f28397d0 == 1) ? floatingActionButton.getScaleY() : 0.0f);
        }

        @Override // oa.k
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(FloatingActionButton floatingActionButton) {
            if (BottomAppBar.this.f28397d0 != 1) {
                return;
            }
            float translationX = floatingActionButton.getTranslationX();
            if (BottomAppBar.this.getTopEdgeTreatment().j() != translationX) {
                BottomAppBar.this.getTopEdgeTreatment().p(translationX);
                BottomAppBar.this.V.invalidateSelf();
            }
            float max = Math.max(0.0f, -floatingActionButton.getTranslationY());
            if (BottomAppBar.this.getTopEdgeTreatment().c() != max) {
                BottomAppBar.this.getTopEdgeTreatment().k(max);
                BottomAppBar.this.V.invalidateSelf();
            }
            BottomAppBar.this.V.e0(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
        }
    }

    /* loaded from: classes4.dex */
    class c implements f0.d {
        c() {
        }

        @Override // com.google.android.material.internal.f0.d
        public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, f0.e eVar) {
            boolean z10;
            if (BottomAppBar.this.f28403j0) {
                BottomAppBar.this.f28412s0 = windowInsetsCompat.getSystemWindowInsetBottom();
            }
            boolean z11 = false;
            if (BottomAppBar.this.f28404k0) {
                z10 = BottomAppBar.this.f28414u0 != windowInsetsCompat.getSystemWindowInsetLeft();
                BottomAppBar.this.f28414u0 = windowInsetsCompat.getSystemWindowInsetLeft();
            } else {
                z10 = false;
            }
            if (BottomAppBar.this.f28405l0) {
                boolean z12 = BottomAppBar.this.f28413t0 != windowInsetsCompat.getSystemWindowInsetRight();
                BottomAppBar.this.f28413t0 = windowInsetsCompat.getSystemWindowInsetRight();
                z11 = z12;
            }
            if (z10 || z11) {
                BottomAppBar.this.o0();
                BottomAppBar.this.E0();
                BottomAppBar.this.D0();
            }
            return windowInsetsCompat;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.s0();
            BottomAppBar.this.W = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.t0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e extends FloatingActionButton.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f28428a;

        /* loaded from: classes4.dex */
        class a extends FloatingActionButton.b {
            a() {
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
            public void b(FloatingActionButton floatingActionButton) {
                BottomAppBar.this.s0();
            }
        }

        e(int i11) {
            this.f28428a = i11;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
        public void a(FloatingActionButton floatingActionButton) {
            floatingActionButton.setTranslationX(BottomAppBar.this.x0(this.f28428a));
            floatingActionButton.show(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.s0();
            BottomAppBar.this.f28409p0 = false;
            BottomAppBar.this.f28394a0 = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.t0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class g extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f28432a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ActionMenuView f28433b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f28434c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f28435d;

        g(ActionMenuView actionMenuView, int i11, boolean z10) {
            this.f28433b = actionMenuView;
            this.f28434c = i11;
            this.f28435d = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f28432a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f28432a) {
                return;
            }
            boolean z10 = BottomAppBar.this.f28408o0 != 0;
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.replaceMenu(bottomAppBar.f28408o0);
            BottomAppBar.this.H0(this.f28433b, this.f28434c, this.f28435d, z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class h extends AnimatorListenerAdapter {
        h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.f28415v0.onAnimationStart(animator);
            FloatingActionButton u02 = BottomAppBar.this.u0();
            if (u02 != null) {
                u02.setTranslationX(BottomAppBar.this.getFabTranslationX());
            }
        }
    }

    public BottomAppBar(@NonNull Context context) {
        this(context, null);
    }

    public BottomAppBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.bottomAppBarStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public BottomAppBar(@androidx.annotation.NonNull android.content.Context r13, @androidx.annotation.Nullable android.util.AttributeSet r14, int r15) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomappbar.BottomAppBar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(int i11, boolean z10) {
        if (!ViewCompat.isLaidOut(this)) {
            this.f28409p0 = false;
            replaceMenu(this.f28408o0);
            return;
        }
        Animator animator = this.f28394a0;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!y0()) {
            i11 = 0;
            z10 = false;
        }
        r0(i11, z10, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.f28394a0 = animatorSet;
        animatorSet.addListener(new f());
        this.f28394a0.start();
    }

    private void B0(int i11) {
        if (this.f28395b0 == i11 || !ViewCompat.isLaidOut(this)) {
            return;
        }
        Animator animator = this.W;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (this.f28396c0 == 1) {
            q0(i11, arrayList);
        } else {
            p0(i11, arrayList);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.setInterpolator(j.g(getContext(), f28393z0, oa.a.f71041a));
        this.W = animatorSet;
        animatorSet.addListener(new d());
        this.W.start();
    }

    private Drawable C0(Drawable drawable) {
        if (drawable == null || this.U == null) {
            return drawable;
        }
        Drawable r11 = a1.a.r(drawable.mutate());
        a1.a.n(r11, this.U.intValue());
        return r11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null || this.f28394a0 != null) {
            return;
        }
        actionMenuView.setAlpha(1.0f);
        if (y0()) {
            G0(actionMenuView, this.f28395b0, this.f28410q0);
        } else {
            G0(actionMenuView, 0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        getTopEdgeTreatment().p(getFabTranslationX());
        this.V.e0((this.f28410q0 && y0() && this.f28397d0 == 1) ? 1.0f : 0.0f);
        View v02 = v0();
        if (v02 != null) {
            v02.setTranslationY(getFabTranslationY());
            v02.setTranslationX(getFabTranslationX());
        }
    }

    private void G0(ActionMenuView actionMenuView, int i11, boolean z10) {
        H0(actionMenuView, i11, z10, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(final ActionMenuView actionMenuView, final int i11, final boolean z10, boolean z11) {
        Runnable runnable = new Runnable() { // from class: com.google.android.material.bottomappbar.BottomAppBar.8
            @Override // java.lang.Runnable
            public void run() {
                actionMenuView.setTranslationX(BottomAppBar.this.w0(r0, i11, z10));
            }
        };
        if (z11) {
            actionMenuView.post(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void I0(BottomAppBar bottomAppBar, View view) {
        CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
        fVar.f7985d = 17;
        int i11 = bottomAppBar.f28397d0;
        if (i11 == 1) {
            fVar.f7985d = 17 | 48;
        }
        if (i11 == 0) {
            fVar.f7985d |= 80;
        }
    }

    @Nullable
    private ActionMenuView getActionMenuView() {
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return this.f28412s0;
    }

    private int getFabAlignmentAnimationDuration() {
        return j.f(getContext(), f28392y0, 300);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        return x0(this.f28395b0);
    }

    private float getFabTranslationY() {
        if (this.f28397d0 == 1) {
            return -getTopEdgeTreatment().c();
        }
        return v0() != null ? (-((getMeasuredHeight() + getBottomInset()) - r0.getMeasuredHeight())) / 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return this.f28414u0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return this.f28413t0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public com.google.android.material.bottomappbar.d getTopEdgeTreatment() {
        return (com.google.android.material.bottomappbar.d) this.V.G().p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(FloatingActionButton floatingActionButton) {
        floatingActionButton.addOnHideAnimationListener(this.f28415v0);
        floatingActionButton.addOnShowAnimationListener(new h());
        floatingActionButton.addTransformationCallback(this.f28416w0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        Animator animator = this.f28394a0;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.W;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    private void q0(int i11, List list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(u0(), "translationX", x0(i11));
        ofFloat.setDuration(getFabAlignmentAnimationDuration());
        list.add(ofFloat);
    }

    private void r0(int i11, boolean z10, List list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        float fabAlignmentAnimationDuration = getFabAlignmentAnimationDuration();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        ofFloat.setDuration(0.8f * fabAlignmentAnimationDuration);
        if (Math.abs(actionMenuView.getTranslationX() - w0(actionMenuView, i11, z10)) <= 1.0f) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(ofFloat);
            }
        } else {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
            ofFloat2.setDuration(fabAlignmentAnimationDuration * 0.2f);
            ofFloat2.addListener(new g(actionMenuView, i11, z10));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(ofFloat2, ofFloat);
            list.add(animatorSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        ArrayList arrayList;
        int i11 = this.f28406m0 - 1;
        this.f28406m0 = i11;
        if (i11 != 0 || (arrayList = this.f28407n0) == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.c.a(it.next());
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        ArrayList arrayList;
        int i11 = this.f28406m0;
        this.f28406m0 = i11 + 1;
        if (i11 != 0 || (arrayList = this.f28407n0) == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.c.a(it.next());
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FloatingActionButton u0() {
        View v02 = v0();
        if (v02 instanceof FloatingActionButton) {
            return (FloatingActionButton) v02;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View v0() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).getDependents(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float x0(int i11) {
        boolean p11 = f0.p(this);
        if (i11 != 1) {
            return 0.0f;
        }
        return ((getMeasuredWidth() / 2) - ((p11 ? this.f28414u0 : this.f28413t0) + ((this.f28399f0 == -1 || v0() == null) ? this.f28398e0 : (r6.getMeasuredWidth() / 2) + this.f28399f0))) * (p11 ? -1 : 1);
    }

    private boolean y0() {
        FloatingActionButton u02 = u0();
        return u02 != null && u02.isOrWillBeShown();
    }

    boolean F0(int i11) {
        float f11 = i11;
        if (f11 == getTopEdgeTreatment().i()) {
            return false;
        }
        getTopEdgeTreatment().o(f11);
        this.V.invalidateSelf();
        return true;
    }

    public void addOnScrollStateChangedListener(@NonNull HideBottomViewOnScrollBehavior.b bVar) {
        getBehavior().F(bVar);
    }

    public void clearOnScrollStateChangedListeners() {
        getBehavior().H();
    }

    @Nullable
    public ColorStateList getBackgroundTint() {
        return this.V.K();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    @NonNull
    public Behavior getBehavior() {
        if (this.f28411r0 == null) {
            this.f28411r0 = new Behavior();
        }
        return this.f28411r0;
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().c();
    }

    public int getFabAlignmentMode() {
        return this.f28395b0;
    }

    public int getFabAlignmentModeEndMargin() {
        return this.f28399f0;
    }

    public int getFabAnchorMode() {
        return this.f28397d0;
    }

    public int getFabAnimationMode() {
        return this.f28396c0;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().f();
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().g();
    }

    public boolean getHideOnScroll() {
        return this.f28402i0;
    }

    public int getMenuAlignmentMode() {
        return this.f28400g0;
    }

    public boolean isScrolledDown() {
        return getBehavior().I();
    }

    public boolean isScrolledUp() {
        return getBehavior().J();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ab.j.f(this, this.V);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        super.onLayout(z10, i11, i12, i13, i14);
        if (z10) {
            o0();
            E0();
            final View v02 = v0();
            if (v02 != null && ViewCompat.isLaidOut(v02)) {
                v02.post(new Runnable() { // from class: com.google.android.material.bottomappbar.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        v02.requestLayout();
                    }
                });
            }
        }
        D0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f28395b0 = savedState.f28422a;
        this.f28410q0 = savedState.f28423b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f28422a = this.f28395b0;
        savedState.f28423b = this.f28410q0;
        return savedState;
    }

    protected void p0(int i11, List list) {
        FloatingActionButton u02 = u0();
        if (u02 == null || u02.isOrWillBeHidden()) {
            return;
        }
        t0();
        u02.hide(new e(i11));
    }

    public void performHide() {
        performHide(true);
    }

    public void performHide(boolean z10) {
        getBehavior().N(this, z10);
    }

    public void performShow() {
        performShow(true);
    }

    public void performShow(boolean z10) {
        getBehavior().P(this, z10);
    }

    public void removeOnScrollStateChangedListener(@NonNull HideBottomViewOnScrollBehavior.b bVar) {
        getBehavior().K(bVar);
    }

    public void replaceMenu(int i11) {
        if (i11 != 0) {
            this.f28408o0 = 0;
            getMenu().clear();
            inflateMenu(i11);
        }
    }

    public void setBackgroundTint(@Nullable ColorStateList colorStateList) {
        a1.a.o(this.V, colorStateList);
    }

    public void setCradleVerticalOffset(float f11) {
        if (f11 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().k(f11);
            this.V.invalidateSelf();
            E0();
        }
    }

    @Override // android.view.View
    public void setElevation(float f11) {
        this.V.c0(f11);
        getBehavior().L(this, this.V.F() - this.V.E());
    }

    public void setFabAlignmentMode(int i11) {
        setFabAlignmentModeAndReplaceMenu(i11, 0);
    }

    public void setFabAlignmentModeAndReplaceMenu(int i11, int i12) {
        this.f28408o0 = i12;
        this.f28409p0 = true;
        A0(i11, this.f28410q0);
        B0(i11);
        this.f28395b0 = i11;
    }

    public void setFabAlignmentModeEndMargin(int i11) {
        if (this.f28399f0 != i11) {
            this.f28399f0 = i11;
            E0();
        }
    }

    public void setFabAnchorMode(int i11) {
        this.f28397d0 = i11;
        E0();
        View v02 = v0();
        if (v02 != null) {
            I0(this, v02);
            v02.requestLayout();
            this.V.invalidateSelf();
        }
    }

    public void setFabAnimationMode(int i11) {
        this.f28396c0 = i11;
    }

    void setFabCornerSize(float f11) {
        if (f11 != getTopEdgeTreatment().e()) {
            getTopEdgeTreatment().l(f11);
            this.V.invalidateSelf();
        }
    }

    public void setFabCradleMargin(float f11) {
        if (f11 != getFabCradleMargin()) {
            getTopEdgeTreatment().m(f11);
            this.V.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(float f11) {
        if (f11 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().n(f11);
            this.V.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z10) {
        this.f28402i0 = z10;
    }

    public void setMenuAlignmentMode(int i11) {
        if (this.f28400g0 != i11) {
            this.f28400g0 = i11;
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                G0(actionMenuView, this.f28395b0, y0());
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@Nullable Drawable drawable) {
        super.setNavigationIcon(C0(drawable));
    }

    public void setNavigationIconTint(int i11) {
        this.U = Integer.valueOf(i11);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    protected int w0(ActionMenuView actionMenuView, int i11, boolean z10) {
        int i12 = 0;
        if (this.f28400g0 != 1 && (i11 != 1 || !z10)) {
            return 0;
        }
        boolean p11 = f0.p(this);
        int measuredWidth = p11 ? getMeasuredWidth() : 0;
        for (int i13 = 0; i13 < getChildCount(); i13++) {
            View childAt = getChildAt(i13);
            if ((childAt.getLayoutParams() instanceof Toolbar.f) && (((Toolbar.f) childAt.getLayoutParams()).f1179a & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 8388611) {
                measuredWidth = p11 ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        int right = p11 ? actionMenuView.getRight() : actionMenuView.getLeft();
        int i14 = p11 ? this.f28413t0 : -this.f28414u0;
        if (getNavigationIcon() == null) {
            i12 = getResources().getDimensionPixelOffset(R$dimen.m3_bottomappbar_horizontal_padding);
            if (!p11) {
                i12 = -i12;
            }
        }
        return measuredWidth - ((right + i14) + i12);
    }
}

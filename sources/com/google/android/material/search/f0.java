package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.search.SearchView;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class f0 {

    /* renamed from: a, reason: collision with root package name */
    private final SearchView f29628a;

    /* renamed from: b, reason: collision with root package name */
    private final View f29629b;

    /* renamed from: c, reason: collision with root package name */
    private final ClippableRoundedCornerLayout f29630c;

    /* renamed from: d, reason: collision with root package name */
    private final FrameLayout f29631d;

    /* renamed from: e, reason: collision with root package name */
    private final FrameLayout f29632e;

    /* renamed from: f, reason: collision with root package name */
    private final Toolbar f29633f;

    /* renamed from: g, reason: collision with root package name */
    private final Toolbar f29634g;

    /* renamed from: h, reason: collision with root package name */
    private final TextView f29635h;

    /* renamed from: i, reason: collision with root package name */
    private final EditText f29636i;

    /* renamed from: j, reason: collision with root package name */
    private final ImageButton f29637j;

    /* renamed from: k, reason: collision with root package name */
    private final View f29638k;

    /* renamed from: l, reason: collision with root package name */
    private final TouchObserverFrameLayout f29639l;

    /* renamed from: m, reason: collision with root package name */
    private final wa.h f29640m;

    /* renamed from: n, reason: collision with root package name */
    private AnimatorSet f29641n;

    /* renamed from: o, reason: collision with root package name */
    private SearchBar f29642o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!f0.this.f29628a.k()) {
                f0.this.f29628a.x();
            }
            f0.this.f29628a.setTransitionState(SearchView.TransitionState.SHOWN);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            f0.this.f29630c.setVisibility(0);
            f0.this.f29642o.stopOnLoadAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f0.this.f29630c.setVisibility(8);
            if (!f0.this.f29628a.k()) {
                f0.this.f29628a.clearFocusAndHideKeyboard();
            }
            f0.this.f29628a.setTransitionState(SearchView.TransitionState.HIDDEN);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            f0.this.f29628a.setTransitionState(SearchView.TransitionState.HIDING);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!f0.this.f29628a.k()) {
                f0.this.f29628a.x();
            }
            f0.this.f29628a.setTransitionState(SearchView.TransitionState.SHOWN);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            f0.this.f29630c.setVisibility(0);
            f0.this.f29628a.setTransitionState(SearchView.TransitionState.SHOWING);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f0.this.f29630c.setVisibility(8);
            if (!f0.this.f29628a.k()) {
                f0.this.f29628a.clearFocusAndHideKeyboard();
            }
            f0.this.f29628a.setTransitionState(SearchView.TransitionState.HIDDEN);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            f0.this.f29628a.setTransitionState(SearchView.TransitionState.HIDING);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f29647a;

        e(boolean z10) {
            this.f29647a = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f0.this.U(this.f29647a ? 1.0f : 0.0f);
            f0.this.f29630c.resetClipBoundsAndCornerRadius();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            f0.this.U(this.f29647a ? 0.0f : 1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f0(SearchView searchView) {
        this.f29628a = searchView;
        this.f29629b = searchView.f29585a;
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = searchView.f29586b;
        this.f29630c = clippableRoundedCornerLayout;
        this.f29631d = searchView.f29589e;
        this.f29632e = searchView.f29590f;
        this.f29633f = searchView.f29591g;
        this.f29634g = searchView.f29592h;
        this.f29635h = searchView.f29593i;
        this.f29636i = searchView.f29594j;
        this.f29637j = searchView.f29595k;
        this.f29638k = searchView.f29596l;
        this.f29639l = searchView.f29597m;
        this.f29640m = new wa.h(clippableRoundedCornerLayout);
    }

    private Animator A(boolean z10) {
        return K(z10, true, this.f29636i);
    }

    private AnimatorSet B(boolean z10) {
        AnimatorSet animatorSet = new AnimatorSet();
        if (this.f29641n == null) {
            animatorSet.playTogether(s(z10), t(z10));
        }
        animatorSet.playTogether(H(z10), G(z10), u(z10), w(z10), F(z10), z(z10), q(z10), A(z10), I(z10));
        animatorSet.addListener(new e(z10));
        return animatorSet;
    }

    private int C(View view) {
        int marginEnd = MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) view.getLayoutParams());
        return com.google.android.material.internal.f0.p(this.f29642o) ? this.f29642o.getLeft() - marginEnd : (this.f29642o.getRight() - this.f29628a.getWidth()) + marginEnd;
    }

    private int D(View view) {
        int marginStart = MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) view.getLayoutParams());
        int paddingStart = ViewCompat.getPaddingStart(this.f29642o);
        return com.google.android.material.internal.f0.p(this.f29642o) ? ((this.f29642o.getWidth() - this.f29642o.getRight()) + marginStart) - paddingStart : (this.f29642o.getLeft() - marginStart) + paddingStart;
    }

    private int E() {
        return ((this.f29642o.getTop() + this.f29642o.getBottom()) / 2) - ((this.f29632e.getTop() + this.f29632e.getBottom()) / 2);
    }

    private Animator F(boolean z10) {
        return K(z10, false, this.f29631d);
    }

    private Animator G(boolean z10) {
        Rect m11 = this.f29640m.m();
        Rect l11 = this.f29640m.l();
        if (m11 == null) {
            m11 = com.google.android.material.internal.f0.c(this.f29628a);
        }
        if (l11 == null) {
            l11 = com.google.android.material.internal.f0.b(this.f29630c, this.f29642o);
        }
        final Rect rect = new Rect(l11);
        final float cornerSize = this.f29642o.getCornerSize();
        final float max = Math.max(this.f29630c.getCornerRadius(), this.f29640m.k());
        ValueAnimator ofObject = ValueAnimator.ofObject(new com.google.android.material.internal.u(rect), l11, m11);
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.z
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                f0.this.P(cornerSize, max, rect, valueAnimator);
            }
        });
        ofObject.setDuration(z10 ? 300L : 250L);
        ofObject.setInterpolator(com.google.android.material.internal.v.a(z10, oa.a.f71042b));
        return ofObject;
    }

    private Animator H(boolean z10) {
        TimeInterpolator timeInterpolator = z10 ? oa.a.f71041a : oa.a.f71042b;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(z10 ? 300L : 250L);
        ofFloat.setInterpolator(com.google.android.material.internal.v.a(z10, timeInterpolator));
        ofFloat.addUpdateListener(com.google.android.material.internal.q.f(this.f29629b));
        return ofFloat;
    }

    private Animator I(boolean z10) {
        return K(z10, true, this.f29635h);
    }

    private AnimatorSet J(boolean z10) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(L());
        k(animatorSet);
        animatorSet.setInterpolator(com.google.android.material.internal.v.a(z10, oa.a.f71042b));
        animatorSet.setDuration(z10 ? 350L : 300L);
        return animatorSet;
    }

    private Animator K(boolean z10, boolean z11, View view) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(z11 ? D(view) : C(view), 0.0f);
        ofFloat.addUpdateListener(com.google.android.material.internal.q.m(view));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(E(), 0.0f);
        ofFloat2.addUpdateListener(com.google.android.material.internal.q.n(view));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setDuration(z10 ? 300L : 250L);
        animatorSet.setInterpolator(com.google.android.material.internal.v.a(z10, oa.a.f71042b));
        return animatorSet;
    }

    private Animator L() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f29630c.getHeight(), 0.0f);
        ofFloat.addUpdateListener(com.google.android.material.internal.q.n(this.f29630c));
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void N(androidx.appcompat.graphics.drawable.c cVar, ValueAnimator valueAnimator) {
        cVar.setProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void O(com.google.android.material.internal.h hVar, ValueAnimator valueAnimator) {
        hVar.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(float f11, float f12, Rect rect, ValueAnimator valueAnimator) {
        this.f29630c.updateClipBoundsAndCornerRadius(rect, oa.a.a(f11, f12, valueAnimator.getAnimatedFraction()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q() {
        AnimatorSet B = B(true);
        B.addListener(new a());
        B.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R() {
        this.f29630c.setTranslationY(r0.getHeight());
        AnimatorSet J = J(true);
        J.addListener(new c());
        J.start();
    }

    private void T(float f11) {
        ActionMenuView b11;
        if (!this.f29628a.isMenuItemsAnimated() || (b11 = ToolbarUtils.b(this.f29633f)) == null) {
            return;
        }
        b11.setAlpha(f11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(float f11) {
        this.f29637j.setAlpha(f11);
        this.f29638k.setAlpha(f11);
        this.f29639l.setAlpha(f11);
        T(f11);
    }

    private void V(Drawable drawable) {
        if (drawable instanceof androidx.appcompat.graphics.drawable.c) {
            ((androidx.appcompat.graphics.drawable.c) drawable).setProgress(1.0f);
        }
        if (drawable instanceof com.google.android.material.internal.h) {
            ((com.google.android.material.internal.h) drawable).a(1.0f);
        }
    }

    private void W(Toolbar toolbar) {
        ActionMenuView b11 = ToolbarUtils.b(toolbar);
        if (b11 != null) {
            for (int i11 = 0; i11 < b11.getChildCount(); i11++) {
                View childAt = b11.getChildAt(i11);
                childAt.setClickable(false);
                childAt.setFocusable(false);
                childAt.setFocusableInTouchMode(false);
            }
        }
    }

    private void Y() {
        Menu menu = this.f29634g.getMenu();
        if (menu != null) {
            menu.clear();
        }
        if (this.f29642o.getMenuResId() == -1 || !this.f29628a.isMenuItemsAnimated()) {
            this.f29634g.setVisibility(8);
            return;
        }
        this.f29634g.inflateMenu(this.f29642o.getMenuResId());
        W(this.f29634g);
        this.f29634g.setVisibility(0);
    }

    private AnimatorSet b0() {
        if (this.f29628a.k()) {
            this.f29628a.clearFocusAndHideKeyboard();
        }
        AnimatorSet B = B(false);
        B.addListener(new b());
        B.start();
        return B;
    }

    private AnimatorSet c0() {
        if (this.f29628a.k()) {
            this.f29628a.clearFocusAndHideKeyboard();
        }
        AnimatorSet J = J(false);
        J.addListener(new d());
        J.start();
        return J;
    }

    private void d0() {
        if (this.f29628a.k()) {
            this.f29628a.x();
        }
        this.f29628a.setTransitionState(SearchView.TransitionState.SHOWING);
        Y();
        this.f29636i.setText(this.f29642o.getText());
        EditText editText = this.f29636i;
        editText.setSelection(editText.getText().length());
        this.f29630c.setVisibility(4);
        this.f29630c.post(new Runnable() { // from class: com.google.android.material.search.b0
            @Override // java.lang.Runnable
            public final void run() {
                f0.this.Q();
            }
        });
    }

    private void e0() {
        if (this.f29628a.k()) {
            final SearchView searchView = this.f29628a;
            Objects.requireNonNull(searchView);
            searchView.postDelayed(new Runnable() { // from class: com.google.android.material.search.d0
                @Override // java.lang.Runnable
                public final void run() {
                    SearchView.this.x();
                }
            }, 150L);
        }
        this.f29630c.setVisibility(4);
        this.f29630c.post(new Runnable() { // from class: com.google.android.material.search.e0
            @Override // java.lang.Runnable
            public final void run() {
                f0.this.R();
            }
        });
    }

    private void j(AnimatorSet animatorSet) {
        ActionMenuView b11 = ToolbarUtils.b(this.f29633f);
        if (b11 == null) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(C(b11), 0.0f);
        ofFloat.addUpdateListener(com.google.android.material.internal.q.m(b11));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(E(), 0.0f);
        ofFloat2.addUpdateListener(com.google.android.material.internal.q.n(b11));
        animatorSet.playTogether(ofFloat, ofFloat2);
    }

    private void k(AnimatorSet animatorSet) {
        ImageButton e11 = ToolbarUtils.e(this.f29633f);
        if (e11 == null) {
            return;
        }
        Drawable q11 = a1.a.q(e11.getDrawable());
        if (!this.f29628a.isAnimatedNavigationIcon()) {
            V(q11);
        } else {
            m(animatorSet, q11);
            n(animatorSet, q11);
        }
    }

    private void l(AnimatorSet animatorSet) {
        ImageButton e11 = ToolbarUtils.e(this.f29633f);
        if (e11 == null) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(D(e11), 0.0f);
        ofFloat.addUpdateListener(com.google.android.material.internal.q.m(e11));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(E(), 0.0f);
        ofFloat2.addUpdateListener(com.google.android.material.internal.q.n(e11));
        animatorSet.playTogether(ofFloat, ofFloat2);
    }

    private void m(AnimatorSet animatorSet, Drawable drawable) {
        if (drawable instanceof androidx.appcompat.graphics.drawable.c) {
            final androidx.appcompat.graphics.drawable.c cVar = (androidx.appcompat.graphics.drawable.c) drawable;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.a0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    f0.N(androidx.appcompat.graphics.drawable.c.this, valueAnimator);
                }
            });
            animatorSet.playTogether(ofFloat);
        }
    }

    private void n(AnimatorSet animatorSet, Drawable drawable) {
        if (drawable instanceof com.google.android.material.internal.h) {
            final com.google.android.material.internal.h hVar = (com.google.android.material.internal.h) drawable;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.c0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    f0.O(com.google.android.material.internal.h.this, valueAnimator);
                }
            });
            animatorSet.playTogether(ofFloat);
        }
    }

    private Animator q(boolean z10) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(z10 ? 300L : 250L);
        ofFloat.setInterpolator(com.google.android.material.internal.v.a(z10, oa.a.f71042b));
        if (this.f29628a.isMenuItemsAnimated()) {
            ofFloat.addUpdateListener(new com.google.android.material.internal.i(ToolbarUtils.b(this.f29634g), ToolbarUtils.b(this.f29633f)));
        }
        return ofFloat;
    }

    private AnimatorSet s(boolean z10) {
        AnimatorSet animatorSet = new AnimatorSet();
        k(animatorSet);
        animatorSet.setDuration(z10 ? 300L : 250L);
        animatorSet.setInterpolator(com.google.android.material.internal.v.a(z10, oa.a.f71042b));
        return animatorSet;
    }

    private AnimatorSet t(boolean z10) {
        AnimatorSet animatorSet = new AnimatorSet();
        l(animatorSet);
        j(animatorSet);
        animatorSet.setDuration(z10 ? 300L : 250L);
        animatorSet.setInterpolator(com.google.android.material.internal.v.a(z10, oa.a.f71042b));
        return animatorSet;
    }

    private Animator u(boolean z10) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(z10 ? 50L : 42L);
        ofFloat.setStartDelay(z10 ? 250L : 0L);
        ofFloat.setInterpolator(com.google.android.material.internal.v.a(z10, oa.a.f71041a));
        ofFloat.addUpdateListener(com.google.android.material.internal.q.f(this.f29637j));
        return ofFloat;
    }

    private Animator v(boolean z10) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(z10 ? 150L : 83L);
        ofFloat.setStartDelay(z10 ? 75L : 0L);
        ofFloat.setInterpolator(com.google.android.material.internal.v.a(z10, oa.a.f71041a));
        ofFloat.addUpdateListener(com.google.android.material.internal.q.f(this.f29638k, this.f29639l));
        return ofFloat;
    }

    private Animator w(boolean z10) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(v(z10), y(z10), x(z10));
        return animatorSet;
    }

    private Animator x(boolean z10) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.95f, 1.0f);
        ofFloat.setDuration(z10 ? 300L : 250L);
        ofFloat.setInterpolator(com.google.android.material.internal.v.a(z10, oa.a.f71042b));
        ofFloat.addUpdateListener(com.google.android.material.internal.q.g(this.f29639l));
        return ofFloat;
    }

    private Animator y(boolean z10) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat((this.f29639l.getHeight() * 0.050000012f) / 2.0f, 0.0f);
        ofFloat.setDuration(z10 ? 300L : 250L);
        ofFloat.setInterpolator(com.google.android.material.internal.v.a(z10, oa.a.f71042b));
        ofFloat.addUpdateListener(com.google.android.material.internal.q.n(this.f29638k));
        return ofFloat;
    }

    private Animator z(boolean z10) {
        return K(z10, false, this.f29634g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnimatorSet M() {
        return this.f29642o != null ? b0() : c0();
    }

    public androidx.activity.b S() {
        return this.f29640m.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X(SearchBar searchBar) {
        this.f29642o = searchBar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z() {
        if (this.f29642o != null) {
            d0();
        } else {
            e0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a0(androidx.activity.b bVar) {
        this.f29640m.t(bVar, this.f29642o);
    }

    public void f0(androidx.activity.b bVar) {
        if (bVar.a() <= 0.0f) {
            return;
        }
        wa.h hVar = this.f29640m;
        SearchBar searchBar = this.f29642o;
        hVar.v(bVar, searchBar, searchBar.getCornerSize());
        AnimatorSet animatorSet = this.f29641n;
        if (animatorSet != null) {
            animatorSet.setCurrentPlayTime(bVar.a() * ((float) this.f29641n.getDuration()));
            return;
        }
        if (this.f29628a.k()) {
            this.f29628a.clearFocusAndHideKeyboard();
        }
        if (this.f29628a.isAnimatedNavigationIcon()) {
            AnimatorSet s11 = s(false);
            this.f29641n = s11;
            s11.start();
            this.f29641n.pause();
        }
    }

    public void o() {
        this.f29640m.g(this.f29642o);
        AnimatorSet animatorSet = this.f29641n;
        if (animatorSet != null) {
            animatorSet.reverse();
        }
        this.f29641n = null;
    }

    public void p() {
        long totalDuration;
        totalDuration = M().getTotalDuration();
        this.f29640m.j(totalDuration, this.f29642o);
        if (this.f29641n != null) {
            t(false).start();
            this.f29641n.resume();
        }
        this.f29641n = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public wa.h r() {
        return this.f29640m;
    }
}

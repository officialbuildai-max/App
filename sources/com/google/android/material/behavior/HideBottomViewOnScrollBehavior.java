package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.support.v4.media.session.c;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$attr;
import java.util.Iterator;
import java.util.LinkedHashSet;
import wa.j;

/* loaded from: classes4.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c {

    /* renamed from: j, reason: collision with root package name */
    private static final int f28363j = R$attr.motionDurationLong2;

    /* renamed from: k, reason: collision with root package name */
    private static final int f28364k = R$attr.motionDurationMedium4;

    /* renamed from: l, reason: collision with root package name */
    private static final int f28365l = R$attr.motionEasingEmphasizedInterpolator;

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashSet f28366a;

    /* renamed from: b, reason: collision with root package name */
    private int f28367b;

    /* renamed from: c, reason: collision with root package name */
    private int f28368c;

    /* renamed from: d, reason: collision with root package name */
    private TimeInterpolator f28369d;

    /* renamed from: e, reason: collision with root package name */
    private TimeInterpolator f28370e;

    /* renamed from: f, reason: collision with root package name */
    private int f28371f;

    /* renamed from: g, reason: collision with root package name */
    private int f28372g;

    /* renamed from: h, reason: collision with root package name */
    private int f28373h;

    /* renamed from: i, reason: collision with root package name */
    private ViewPropertyAnimator f28374i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f28374i = null;
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
    }

    public HideBottomViewOnScrollBehavior() {
        this.f28366a = new LinkedHashSet();
        this.f28371f = 0;
        this.f28372g = 2;
        this.f28373h = 0;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28366a = new LinkedHashSet();
        this.f28371f = 0;
        this.f28372g = 2;
        this.f28373h = 0;
    }

    private void G(View view, int i11, long j11, TimeInterpolator timeInterpolator) {
        this.f28374i = view.animate().translationY(i11).setInterpolator(timeInterpolator).setDuration(j11).setListener(new a());
    }

    private void Q(View view, int i11) {
        this.f28372g = i11;
        Iterator it = this.f28366a.iterator();
        if (it.hasNext()) {
            c.a(it.next());
            throw null;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i11, int i12) {
        return i11 == 2;
    }

    public void F(b bVar) {
        this.f28366a.add(bVar);
    }

    public void H() {
        this.f28366a.clear();
    }

    public boolean I() {
        return this.f28372g == 1;
    }

    public boolean J() {
        return this.f28372g == 2;
    }

    public void K(b bVar) {
        this.f28366a.remove(bVar);
    }

    public void L(View view, int i11) {
        this.f28373h = i11;
        if (this.f28372g == 1) {
            view.setTranslationY(this.f28371f + i11);
        }
    }

    public void M(View view) {
        N(view, true);
    }

    public void N(View view, boolean z10) {
        if (I()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f28374i;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        Q(view, 1);
        int i11 = this.f28371f + this.f28373h;
        if (z10) {
            G(view, i11, this.f28368c, this.f28370e);
        } else {
            view.setTranslationY(i11);
        }
    }

    public void O(View view) {
        P(view, true);
    }

    public void P(View view, boolean z10) {
        if (J()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f28374i;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        Q(view, 2);
        if (z10) {
            G(view, 0, this.f28367b, this.f28369d);
        } else {
            view.setTranslationY(0);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i11) {
        this.f28371f = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        this.f28367b = j.f(view.getContext(), f28363j, 225);
        this.f28368c = j.f(view.getContext(), f28364k, 175);
        Context context = view.getContext();
        int i12 = f28365l;
        this.f28369d = j.g(context, i12, oa.a.f71044d);
        this.f28370e = j.g(view.getContext(), i12, oa.a.f71043c);
        return super.l(coordinatorLayout, view, i11);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void t(CoordinatorLayout coordinatorLayout, View view, View view2, int i11, int i12, int i13, int i14, int i15, int[] iArr) {
        if (i12 > 0) {
            M(view);
        } else if (i12 < 0) {
            O(view);
        }
    }
}

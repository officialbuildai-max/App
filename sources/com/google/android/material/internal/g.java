package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final View f29265a;

    /* renamed from: b, reason: collision with root package name */
    private final View f29266b;

    /* renamed from: c, reason: collision with root package name */
    private final List f29267c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final List f29268d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f29269e;

    /* renamed from: f, reason: collision with root package name */
    private long f29270f;

    /* renamed from: g, reason: collision with root package name */
    private int f29271g;

    /* renamed from: h, reason: collision with root package name */
    private int f29272h;

    /* loaded from: classes4.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            g.this.f29266b.setVisibility(0);
        }
    }

    /* loaded from: classes4.dex */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            g.this.f29266b.setVisibility(8);
        }
    }

    public g(View view, View view2) {
        this.f29265a = view;
        this.f29266b = view2;
    }

    private void e(Animator animator, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            animator.addListener((AnimatorListenerAdapter) it.next());
        }
    }

    private AnimatorSet f(boolean z10) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(j(z10), k(z10), h(z10));
        return animatorSet;
    }

    private Animator h(boolean z10) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat((this.f29266b.getLeft() - this.f29265a.getLeft()) + (this.f29265a.getRight() - this.f29266b.getRight()), 0.0f);
        ofFloat.addUpdateListener(q.l(this.f29268d));
        ofFloat.setDuration(this.f29270f);
        ofFloat.setInterpolator(v.a(z10, oa.a.f71042b));
        return ofFloat;
    }

    private Animator j(boolean z10) {
        Rect d11 = f0.d(this.f29265a, this.f29271g);
        Rect d12 = f0.d(this.f29266b, this.f29272h);
        final Rect rect = new Rect(d11);
        ValueAnimator ofObject = ValueAnimator.ofObject(new u(rect), d11, d12);
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.internal.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                g.this.l(rect, valueAnimator);
            }
        });
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f29269e;
        if (animatorUpdateListener != null) {
            ofObject.addUpdateListener(animatorUpdateListener);
        }
        ofObject.setDuration(this.f29270f);
        ofObject.setInterpolator(v.a(z10, oa.a.f71042b));
        return ofObject;
    }

    private Animator k(boolean z10) {
        List i11 = f0.i(this.f29266b);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(q.e(i11));
        ofFloat.setDuration(this.f29270f);
        ofFloat.setInterpolator(v.a(z10, oa.a.f71041a));
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(Rect rect, ValueAnimator valueAnimator) {
        f0.u(this.f29266b, rect);
    }

    public g c(Collection collection) {
        this.f29268d.addAll(collection);
        return this;
    }

    public g d(AnimatorListenerAdapter animatorListenerAdapter) {
        this.f29267c.add(animatorListenerAdapter);
        return this;
    }

    public Animator g() {
        AnimatorSet f11 = f(false);
        f11.addListener(new b());
        e(f11, this.f29267c);
        return f11;
    }

    public Animator i() {
        AnimatorSet f11 = f(true);
        f11.addListener(new a());
        e(f11, this.f29267c);
        return f11;
    }

    public g m(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f29269e = animatorUpdateListener;
        return this;
    }

    public g n(int i11) {
        this.f29271g = i11;
        return this;
    }

    public g o(long j11) {
        this.f29270f = j11;
        return this;
    }
}

package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.view.View;
import java.util.Collection;

/* loaded from: classes4.dex */
public class q implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    private final a f29282a;

    /* renamed from: b */
    private final View[] f29283b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        void a(ValueAnimator valueAnimator, View view);
    }

    public q(a aVar, Collection collection) {
        this.f29282a = aVar;
        this.f29283b = (View[]) collection.toArray(new View[0]);
    }

    public q(a aVar, View... viewArr) {
        this.f29282a = aVar;
        this.f29283b = viewArr;
    }

    public static q e(Collection collection) {
        return new q(new p(), collection);
    }

    public static q f(View... viewArr) {
        return new q(new p(), viewArr);
    }

    public static q g(View... viewArr) {
        return new q(new a() { // from class: com.google.android.material.internal.o
            @Override // com.google.android.material.internal.q.a
            public final void a(ValueAnimator valueAnimator, View view) {
                q.i(valueAnimator, view);
            }
        }, viewArr);
    }

    public static void h(ValueAnimator valueAnimator, View view) {
        view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static void i(ValueAnimator valueAnimator, View view) {
        Float f11 = (Float) valueAnimator.getAnimatedValue();
        view.setScaleX(f11.floatValue());
        view.setScaleY(f11.floatValue());
    }

    public static void j(ValueAnimator valueAnimator, View view) {
        view.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static void k(ValueAnimator valueAnimator, View view) {
        view.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static q l(Collection collection) {
        return new q(new m(), collection);
    }

    public static q m(View... viewArr) {
        return new q(new m(), viewArr);
    }

    public static q n(View... viewArr) {
        return new q(new a() { // from class: com.google.android.material.internal.n
            @Override // com.google.android.material.internal.q.a
            public final void a(ValueAnimator valueAnimator, View view) {
                q.k(valueAnimator, view);
            }
        }, viewArr);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        for (View view : this.f29283b) {
            this.f29282a.a(valueAnimator, view);
        }
    }
}

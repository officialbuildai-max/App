package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f29325a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private b f29326b = null;

    /* renamed from: c, reason: collision with root package name */
    ValueAnimator f29327c = null;

    /* renamed from: d, reason: collision with root package name */
    private final Animator.AnimatorListener f29328d = new a();

    /* loaded from: classes4.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            w wVar = w.this;
            if (wVar.f29327c == animator) {
                wVar.f29327c = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        final int[] f29330a;

        /* renamed from: b, reason: collision with root package name */
        final ValueAnimator f29331b;

        b(int[] iArr, ValueAnimator valueAnimator) {
            this.f29330a = iArr;
            this.f29331b = valueAnimator;
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f29328d);
        this.f29325a.add(bVar);
    }
}

package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class g extends Drawable implements Animatable {

    /* renamed from: o, reason: collision with root package name */
    private static final Property f29508o = new c(Float.class, "growFraction");

    /* renamed from: a, reason: collision with root package name */
    final Context f29509a;

    /* renamed from: b, reason: collision with root package name */
    final com.google.android.material.progressindicator.b f29510b;

    /* renamed from: d, reason: collision with root package name */
    private ValueAnimator f29512d;

    /* renamed from: e, reason: collision with root package name */
    private ValueAnimator f29513e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f29514f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f29515g;

    /* renamed from: h, reason: collision with root package name */
    private float f29516h;

    /* renamed from: i, reason: collision with root package name */
    private List f29517i;

    /* renamed from: j, reason: collision with root package name */
    private androidx.vectordrawable.graphics.drawable.b f29518j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f29519k;

    /* renamed from: l, reason: collision with root package name */
    private float f29520l;

    /* renamed from: n, reason: collision with root package name */
    private int f29522n;

    /* renamed from: m, reason: collision with root package name */
    final Paint f29521m = new Paint();

    /* renamed from: c, reason: collision with root package name */
    com.google.android.material.progressindicator.a f29511c = new com.google.android.material.progressindicator.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            g.this.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            g.super.setVisible(false, false);
            g.this.e();
        }
    }

    /* loaded from: classes4.dex */
    class c extends Property {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(g gVar) {
            return Float.valueOf(gVar.h());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(g gVar, Float f11) {
            gVar.n(f11.floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Context context, com.google.android.material.progressindicator.b bVar) {
        this.f29509a = context;
        this.f29510b = bVar;
        setAlpha(255);
    }

    private void d(ValueAnimator... valueAnimatorArr) {
        boolean z10 = this.f29519k;
        this.f29519k = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.cancel();
        }
        this.f29519k = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        androidx.vectordrawable.graphics.drawable.b bVar = this.f29518j;
        if (bVar != null) {
            bVar.onAnimationEnd(this);
        }
        List list = this.f29517i;
        if (list == null || this.f29519k) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((androidx.vectordrawable.graphics.drawable.b) it.next()).onAnimationEnd(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        androidx.vectordrawable.graphics.drawable.b bVar = this.f29518j;
        if (bVar != null) {
            bVar.onAnimationStart(this);
        }
        List list = this.f29517i;
        if (list == null || this.f29519k) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((androidx.vectordrawable.graphics.drawable.b) it.next()).onAnimationStart(this);
        }
    }

    private void g(ValueAnimator... valueAnimatorArr) {
        boolean z10 = this.f29519k;
        this.f29519k = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.end();
        }
        this.f29519k = z10;
    }

    private void l() {
        if (this.f29512d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<g, Float>) f29508o, 0.0f, 1.0f);
            this.f29512d = ofFloat;
            ofFloat.setDuration(500L);
            this.f29512d.setInterpolator(oa.a.f71042b);
            p(this.f29512d);
        }
        if (this.f29513e == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, (Property<g, Float>) f29508o, 1.0f, 0.0f);
            this.f29513e = ofFloat2;
            ofFloat2.setDuration(500L);
            this.f29513e.setInterpolator(oa.a.f71042b);
            o(this.f29513e);
        }
    }

    private void o(ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f29513e;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
        }
        this.f29513e = valueAnimator;
        valueAnimator.addListener(new b());
    }

    private void p(ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f29512d;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
        }
        this.f29512d = valueAnimator;
        valueAnimator.addListener(new a());
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f29522n;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float h() {
        if (this.f29510b.b() || this.f29510b.a()) {
            return (this.f29515g || this.f29514f) ? this.f29516h : this.f29520l;
        }
        return 1.0f;
    }

    public boolean i() {
        return q(false, false, false);
    }

    public boolean isRunning() {
        return k() || j();
    }

    public boolean j() {
        ValueAnimator valueAnimator = this.f29513e;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.f29515g;
    }

    public boolean k() {
        ValueAnimator valueAnimator = this.f29512d;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.f29514f;
    }

    public void m(androidx.vectordrawable.graphics.drawable.b bVar) {
        if (this.f29517i == null) {
            this.f29517i = new ArrayList();
        }
        if (this.f29517i.contains(bVar)) {
            return;
        }
        this.f29517i.add(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(float f11) {
        if (this.f29520l != f11) {
            this.f29520l = f11;
            invalidateSelf();
        }
    }

    public boolean q(boolean z10, boolean z11, boolean z12) {
        return r(z10, z11, z12 && this.f29511c.a(this.f29509a.getContentResolver()) > 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r(boolean z10, boolean z11, boolean z12) {
        l();
        if (!isVisible() && !z10) {
            return false;
        }
        ValueAnimator valueAnimator = z10 ? this.f29512d : this.f29513e;
        ValueAnimator valueAnimator2 = z10 ? this.f29513e : this.f29512d;
        if (!z12) {
            if (valueAnimator2.isRunning()) {
                d(valueAnimator2);
            }
            if (valueAnimator.isRunning()) {
                valueAnimator.end();
            } else {
                g(valueAnimator);
            }
            return super.setVisible(z10, false);
        }
        if (valueAnimator.isRunning()) {
            return false;
        }
        boolean z13 = !z10 || super.setVisible(z10, false);
        if (!(z10 ? this.f29510b.b() : this.f29510b.a())) {
            g(valueAnimator);
            return z13;
        }
        if (z11 || !valueAnimator.isPaused()) {
            valueAnimator.start();
        } else {
            valueAnimator.resume();
        }
        return z13;
    }

    public boolean s(androidx.vectordrawable.graphics.drawable.b bVar) {
        List list = this.f29517i;
        if (list == null || !list.contains(bVar)) {
            return false;
        }
        this.f29517i.remove(bVar);
        if (!this.f29517i.isEmpty()) {
            return true;
        }
        this.f29517i = null;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        this.f29522n = i11;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f29521m.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        return q(z10, z11, true);
    }

    public void start() {
        r(true, true, false);
    }

    public void stop() {
        r(false, true, false);
    }
}

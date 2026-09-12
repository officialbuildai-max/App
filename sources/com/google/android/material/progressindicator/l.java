package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import com.google.android.material.progressindicator.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class l extends i {

    /* renamed from: i, reason: collision with root package name */
    private static final Property f29540i = new b(Float.class, "animationFraction");

    /* renamed from: c, reason: collision with root package name */
    private ObjectAnimator f29541c;

    /* renamed from: d, reason: collision with root package name */
    private o1.b f29542d;

    /* renamed from: e, reason: collision with root package name */
    private final com.google.android.material.progressindicator.b f29543e;

    /* renamed from: f, reason: collision with root package name */
    private int f29544f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f29545g;

    /* renamed from: h, reason: collision with root package name */
    private float f29546h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            l lVar = l.this;
            lVar.f29544f = (lVar.f29544f + 1) % l.this.f29543e.f29474c.length;
            l.this.f29545g = true;
        }
    }

    /* loaded from: classes4.dex */
    class b extends Property {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(l lVar) {
            return Float.valueOf(lVar.n());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(l lVar, Float f11) {
            lVar.r(f11.floatValue());
        }
    }

    public l(n nVar) {
        super(3);
        this.f29544f = 1;
        this.f29543e = nVar;
        this.f29542d = new o1.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float n() {
        return this.f29546h;
    }

    private void o() {
        if (this.f29541c == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<l, Float>) f29540i, 0.0f, 1.0f);
            this.f29541c = ofFloat;
            ofFloat.setDuration(333L);
            this.f29541c.setInterpolator(null);
            this.f29541c.setRepeatCount(-1);
            this.f29541c.addListener(new a());
        }
    }

    private void p() {
        if (!this.f29545g || ((h.a) this.f29531b.get(1)).f29527b >= 1.0f) {
            return;
        }
        ((h.a) this.f29531b.get(2)).f29528c = ((h.a) this.f29531b.get(1)).f29528c;
        ((h.a) this.f29531b.get(1)).f29528c = ((h.a) this.f29531b.get(0)).f29528c;
        ((h.a) this.f29531b.get(0)).f29528c = this.f29543e.f29474c[this.f29544f];
        this.f29545g = false;
    }

    private void s(int i11) {
        ((h.a) this.f29531b.get(0)).f29526a = 0.0f;
        float b11 = b(i11, 0, 667);
        h.a aVar = (h.a) this.f29531b.get(0);
        h.a aVar2 = (h.a) this.f29531b.get(1);
        float interpolation = this.f29542d.getInterpolation(b11);
        aVar2.f29526a = interpolation;
        aVar.f29527b = interpolation;
        h.a aVar3 = (h.a) this.f29531b.get(1);
        h.a aVar4 = (h.a) this.f29531b.get(2);
        float interpolation2 = this.f29542d.getInterpolation(b11 + 0.49925038f);
        aVar4.f29526a = interpolation2;
        aVar3.f29527b = interpolation2;
        ((h.a) this.f29531b.get(2)).f29527b = 1.0f;
    }

    @Override // com.google.android.material.progressindicator.i
    public void a() {
        ObjectAnimator objectAnimator = this.f29541c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.i
    public void c() {
        q();
    }

    @Override // com.google.android.material.progressindicator.i
    public void d(androidx.vectordrawable.graphics.drawable.b bVar) {
    }

    @Override // com.google.android.material.progressindicator.i
    public void f() {
    }

    @Override // com.google.android.material.progressindicator.i
    public void g() {
        o();
        q();
        this.f29541c.start();
    }

    @Override // com.google.android.material.progressindicator.i
    public void h() {
    }

    void q() {
        this.f29545g = true;
        this.f29544f = 1;
        for (h.a aVar : this.f29531b) {
            com.google.android.material.progressindicator.b bVar = this.f29543e;
            aVar.f29528c = bVar.f29474c[0];
            aVar.f29529d = bVar.f29478g / 2;
        }
    }

    void r(float f11) {
        this.f29546h = f11;
        s((int) (f11 * 333.0f));
        p();
        this.f29530a.invalidateSelf();
    }
}

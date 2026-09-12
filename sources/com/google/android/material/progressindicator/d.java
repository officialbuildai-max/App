package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import com.google.android.material.progressindicator.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class d extends i {

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f29484k = {0, 1350, 2700, 4050};

    /* renamed from: l, reason: collision with root package name */
    private static final int[] f29485l = {667, 2017, 3367, 4717};

    /* renamed from: m, reason: collision with root package name */
    private static final int[] f29486m = {1000, 2350, 3700, 5050};

    /* renamed from: n, reason: collision with root package name */
    private static final Property f29487n = new c(Float.class, "animationFraction");

    /* renamed from: o, reason: collision with root package name */
    private static final Property f29488o = new C0400d(Float.class, "completeEndFraction");

    /* renamed from: c, reason: collision with root package name */
    private ObjectAnimator f29489c;

    /* renamed from: d, reason: collision with root package name */
    private ObjectAnimator f29490d;

    /* renamed from: e, reason: collision with root package name */
    private final o1.b f29491e;

    /* renamed from: f, reason: collision with root package name */
    private final com.google.android.material.progressindicator.b f29492f;

    /* renamed from: g, reason: collision with root package name */
    private int f29493g;

    /* renamed from: h, reason: collision with root package name */
    private float f29494h;

    /* renamed from: i, reason: collision with root package name */
    private float f29495i;

    /* renamed from: j, reason: collision with root package name */
    androidx.vectordrawable.graphics.drawable.b f29496j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            d dVar = d.this;
            dVar.f29493g = (dVar.f29493g + 4) % d.this.f29492f.f29474c.length;
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
            d.this.a();
            d dVar = d.this;
            androidx.vectordrawable.graphics.drawable.b bVar = dVar.f29496j;
            if (bVar != null) {
                bVar.onAnimationEnd(dVar.f29530a);
            }
        }
    }

    /* loaded from: classes4.dex */
    class c extends Property {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(d dVar) {
            return Float.valueOf(dVar.o());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, Float f11) {
            dVar.t(f11.floatValue());
        }
    }

    /* renamed from: com.google.android.material.progressindicator.d$d, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0400d extends Property {
        C0400d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(d dVar) {
            return Float.valueOf(dVar.p());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, Float f11) {
            dVar.u(f11.floatValue());
        }
    }

    public d(e eVar) {
        super(1);
        this.f29493g = 0;
        this.f29496j = null;
        this.f29492f = eVar;
        this.f29491e = new o1.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float o() {
        return this.f29494h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float p() {
        return this.f29495i;
    }

    private void q() {
        if (this.f29489c == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<d, Float>) f29487n, 0.0f, 1.0f);
            this.f29489c = ofFloat;
            ofFloat.setDuration(5400L);
            this.f29489c.setInterpolator(null);
            this.f29489c.setRepeatCount(-1);
            this.f29489c.addListener(new a());
        }
        if (this.f29490d == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, (Property<d, Float>) f29488o, 0.0f, 1.0f);
            this.f29490d = ofFloat2;
            ofFloat2.setDuration(333L);
            this.f29490d.setInterpolator(this.f29491e);
            this.f29490d.addListener(new b());
        }
    }

    private void r(int i11) {
        for (int i12 = 0; i12 < 4; i12++) {
            float b11 = b(i11, f29486m[i12], 333);
            if (b11 >= 0.0f && b11 <= 1.0f) {
                int i13 = i12 + this.f29493g;
                int[] iArr = this.f29492f.f29474c;
                int length = i13 % iArr.length;
                int length2 = (length + 1) % iArr.length;
                int i14 = iArr[length];
                int i15 = iArr[length2];
                ((h.a) this.f29531b.get(0)).f29528c = oa.c.b().evaluate(this.f29491e.getInterpolation(b11), Integer.valueOf(i14), Integer.valueOf(i15)).intValue();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(float f11) {
        this.f29495i = f11;
    }

    private void v(int i11) {
        h.a aVar = (h.a) this.f29531b.get(0);
        float f11 = this.f29494h;
        aVar.f29526a = (f11 * 1520.0f) - 20.0f;
        aVar.f29527b = f11 * 1520.0f;
        for (int i12 = 0; i12 < 4; i12++) {
            aVar.f29527b += this.f29491e.getInterpolation(b(i11, f29484k[i12], 667)) * 250.0f;
            aVar.f29526a += this.f29491e.getInterpolation(b(i11, f29485l[i12], 667)) * 250.0f;
        }
        float f12 = aVar.f29526a;
        float f13 = aVar.f29527b;
        aVar.f29526a = (f12 + ((f13 - f12) * this.f29495i)) / 360.0f;
        aVar.f29527b = f13 / 360.0f;
    }

    @Override // com.google.android.material.progressindicator.i
    void a() {
        ObjectAnimator objectAnimator = this.f29489c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.i
    public void c() {
        s();
    }

    @Override // com.google.android.material.progressindicator.i
    public void d(androidx.vectordrawable.graphics.drawable.b bVar) {
        this.f29496j = bVar;
    }

    @Override // com.google.android.material.progressindicator.i
    void f() {
        ObjectAnimator objectAnimator = this.f29490d;
        if (objectAnimator == null || objectAnimator.isRunning()) {
            return;
        }
        if (this.f29530a.isVisible()) {
            this.f29490d.start();
        } else {
            a();
        }
    }

    @Override // com.google.android.material.progressindicator.i
    void g() {
        q();
        s();
        this.f29489c.start();
    }

    @Override // com.google.android.material.progressindicator.i
    public void h() {
        this.f29496j = null;
    }

    void s() {
        this.f29493g = 0;
        ((h.a) this.f29531b.get(0)).f29528c = this.f29492f.f29474c[0];
        this.f29495i = 0.0f;
    }

    void t(float f11) {
        this.f29494h = f11;
        int i11 = (int) (f11 * 5400.0f);
        v(i11);
        r(i11);
        this.f29530a.invalidateSelf();
    }
}

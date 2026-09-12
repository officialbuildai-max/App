package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import com.google.android.material.R$anim;
import com.google.android.material.progressindicator.h;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class m extends i {

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f29548k = {533, 567, 850, 750};

    /* renamed from: l, reason: collision with root package name */
    private static final int[] f29549l = {1267, 1000, 333, 0};

    /* renamed from: m, reason: collision with root package name */
    private static final Property f29550m = new c(Float.class, "animationFraction");

    /* renamed from: c, reason: collision with root package name */
    private ObjectAnimator f29551c;

    /* renamed from: d, reason: collision with root package name */
    private ObjectAnimator f29552d;

    /* renamed from: e, reason: collision with root package name */
    private final Interpolator[] f29553e;

    /* renamed from: f, reason: collision with root package name */
    private final com.google.android.material.progressindicator.b f29554f;

    /* renamed from: g, reason: collision with root package name */
    private int f29555g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f29556h;

    /* renamed from: i, reason: collision with root package name */
    private float f29557i;

    /* renamed from: j, reason: collision with root package name */
    androidx.vectordrawable.graphics.drawable.b f29558j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            m mVar = m.this;
            mVar.f29555g = (mVar.f29555g + 1) % m.this.f29554f.f29474c.length;
            m.this.f29556h = true;
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
            m.this.a();
            m mVar = m.this;
            androidx.vectordrawable.graphics.drawable.b bVar = mVar.f29558j;
            if (bVar != null) {
                bVar.onAnimationEnd(mVar.f29530a);
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
        public Float get(m mVar) {
            return Float.valueOf(mVar.n());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(m mVar, Float f11) {
            mVar.r(f11.floatValue());
        }
    }

    public m(Context context, n nVar) {
        super(2);
        this.f29555g = 0;
        this.f29558j = null;
        this.f29554f = nVar;
        this.f29553e = new Interpolator[]{androidx.vectordrawable.graphics.drawable.d.a(context, R$anim.linear_indeterminate_line1_head_interpolator), androidx.vectordrawable.graphics.drawable.d.a(context, R$anim.linear_indeterminate_line1_tail_interpolator), androidx.vectordrawable.graphics.drawable.d.a(context, R$anim.linear_indeterminate_line2_head_interpolator), androidx.vectordrawable.graphics.drawable.d.a(context, R$anim.linear_indeterminate_line2_tail_interpolator)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float n() {
        return this.f29557i;
    }

    private void o() {
        if (this.f29551c == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<m, Float>) f29550m, 0.0f, 1.0f);
            this.f29551c = ofFloat;
            ofFloat.setDuration(1800L);
            this.f29551c.setInterpolator(null);
            this.f29551c.setRepeatCount(-1);
            this.f29551c.addListener(new a());
        }
        if (this.f29552d == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, (Property<m, Float>) f29550m, 1.0f);
            this.f29552d = ofFloat2;
            ofFloat2.setDuration(1800L);
            this.f29552d.setInterpolator(null);
            this.f29552d.addListener(new b());
        }
    }

    private void p() {
        if (this.f29556h) {
            Iterator it = this.f29531b.iterator();
            while (it.hasNext()) {
                ((h.a) it.next()).f29528c = this.f29554f.f29474c[this.f29555g];
            }
            this.f29556h = false;
        }
    }

    private void s(int i11) {
        for (int i12 = 0; i12 < this.f29531b.size(); i12++) {
            h.a aVar = (h.a) this.f29531b.get(i12);
            int[] iArr = f29549l;
            int i13 = i12 * 2;
            int i14 = iArr[i13];
            int[] iArr2 = f29548k;
            aVar.f29526a = d1.a.a(this.f29553e[i13].getInterpolation(b(i11, i14, iArr2[i13])), 0.0f, 1.0f);
            int i15 = i13 + 1;
            aVar.f29527b = d1.a.a(this.f29553e[i15].getInterpolation(b(i11, iArr[i15], iArr2[i15])), 0.0f, 1.0f);
        }
    }

    @Override // com.google.android.material.progressindicator.i
    public void a() {
        ObjectAnimator objectAnimator = this.f29551c;
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
        this.f29558j = bVar;
    }

    @Override // com.google.android.material.progressindicator.i
    public void f() {
        ObjectAnimator objectAnimator = this.f29552d;
        if (objectAnimator == null || objectAnimator.isRunning()) {
            return;
        }
        a();
        if (this.f29530a.isVisible()) {
            this.f29552d.setFloatValues(this.f29557i, 1.0f);
            this.f29552d.setDuration((1.0f - this.f29557i) * 1800.0f);
            this.f29552d.start();
        }
    }

    @Override // com.google.android.material.progressindicator.i
    public void g() {
        o();
        q();
        this.f29551c.start();
    }

    @Override // com.google.android.material.progressindicator.i
    public void h() {
        this.f29558j = null;
    }

    void q() {
        this.f29555g = 0;
        Iterator it = this.f29531b.iterator();
        while (it.hasNext()) {
            ((h.a) it.next()).f29528c = this.f29554f.f29474c[0];
        }
    }

    void r(float f11) {
        this.f29557i = f11;
        s((int) (f11 * 1800.0f));
        p();
        this.f29530a.invalidateSelf();
    }
}

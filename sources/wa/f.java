package wa;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.R$dimen;

/* loaded from: classes5.dex */
public class f extends wa.a {

    /* renamed from: g, reason: collision with root package name */
    private final float f77743g;

    /* renamed from: h, reason: collision with root package name */
    private final float f77744h;

    /* loaded from: classes5.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.f77731b.setTranslationY(0.0f);
            f.this.k(0.0f);
        }
    }

    public f(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f77743g = resources.getDimension(R$dimen.m3_back_progress_bottom_container_max_scale_x_distance);
        this.f77744h = resources.getDimension(R$dimen.m3_back_progress_bottom_container_max_scale_y_distance);
    }

    private Animator g() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f77731b, (Property<View, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.f77731b, (Property<View, Float>) View.SCALE_Y, 1.0f));
        View view = this.f77731b;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i11), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setInterpolator(new o1.b());
        return animatorSet;
    }

    public void f() {
        if (super.b() == null) {
            return;
        }
        Animator g11 = g();
        g11.setDuration(this.f77734e);
        g11.start();
    }

    public void h(androidx.activity.b bVar, Animator.AnimatorListener animatorListener) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f77731b, (Property<View, Float>) View.TRANSLATION_Y, this.f77731b.getHeight() * this.f77731b.getScaleY());
        ofFloat.setInterpolator(new o1.b());
        ofFloat.setDuration(oa.a.c(this.f77732c, this.f77733d, bVar.a()));
        ofFloat.addListener(new a());
        if (animatorListener != null) {
            ofFloat.addListener(animatorListener);
        }
        ofFloat.start();
    }

    public void i(androidx.activity.b bVar, Animator.AnimatorListener animatorListener) {
        Animator g11 = g();
        g11.setDuration(oa.a.c(this.f77732c, this.f77733d, bVar.a()));
        if (animatorListener != null) {
            g11.addListener(animatorListener);
        }
        g11.start();
    }

    public void j(androidx.activity.b bVar) {
        super.d(bVar);
    }

    public void k(float f11) {
        float a11 = a(f11);
        float width = this.f77731b.getWidth();
        float height = this.f77731b.getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            return;
        }
        float f12 = this.f77743g / width;
        float f13 = this.f77744h / height;
        float a12 = 1.0f - oa.a.a(0.0f, f12, a11);
        float a13 = 1.0f - oa.a.a(0.0f, f13, a11);
        this.f77731b.setScaleX(a12);
        this.f77731b.setPivotY(height);
        this.f77731b.setScaleY(a13);
        View view = this.f77731b;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                View childAt = viewGroup.getChildAt(i11);
                childAt.setPivotY(-childAt.getTop());
                childAt.setScaleY(a13 != 0.0f ? a12 / a13 : 1.0f);
            }
        }
    }

    public void l(androidx.activity.b bVar) {
        if (super.e(bVar) == null) {
            return;
        }
        k(bVar.a());
    }
}

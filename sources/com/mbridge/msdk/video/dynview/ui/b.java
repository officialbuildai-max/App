package com.mbridge.msdk.video.dynview.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.foundation.tools.t0;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class b {

    /* loaded from: classes5.dex */
    class a implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f39146a;

        a(View view) {
            this.f39146a = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            View view = this.f39146a;
            if (view == null || !(view instanceof ViewGroup)) {
                return;
            }
            ((ViewGroup) view).removeAllViews();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View view = this.f39146a;
            if (view == null || !(view instanceof ViewGroup)) {
                return;
            }
            ((ViewGroup) view).removeAllViews();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* renamed from: com.mbridge.msdk.video.dynview.ui.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C0563b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f39148a;

        C0563b(List list) {
            this.f39148a = list;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            List list = this.f39148a;
            if (list == null || list.size() <= 0) {
                return;
            }
            for (View view : this.f39148a) {
                if (view != null) {
                    view.setPadding(0, 0, 0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    view.requestLayout();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f39150a;

        c(View view) {
            this.f39150a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            View view = this.f39150a;
            if (view != null) {
                view.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.f39150a.requestLayout();
            }
        }
    }

    /* loaded from: classes5.dex */
    class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f39152a;

        d(View view) {
            this.f39152a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            View view = this.f39152a;
            if (view != null) {
                view.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.f39152a.requestLayout();
                if (this.f39152a.getVisibility() != 0) {
                    this.f39152a.setVisibility(0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f39154a;

        e(View view) {
            this.f39154a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ViewGroup.LayoutParams layoutParams = this.f39154a.getLayoutParams();
            layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            this.f39154a.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f39156a;

        f(View view) {
            this.f39156a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f39156a.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            this.f39156a.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    private ObjectAnimator a(View view, float f11, float f12, float f13, long j11) {
        return ObjectAnimator.ofPropertyValuesHolder(view, b(View.SCALE_X, f11), b(View.SCALE_Y, f12), c(View.ROTATION_X, f13)).setDuration(j11);
    }

    private ObjectAnimator a(View view, float f11, float f12, long j11) {
        return ObjectAnimator.ofPropertyValuesHolder(view, a(View.SCALE_X, f11), a(View.SCALE_Y, f12)).setDuration(j11);
    }

    private PropertyValuesHolder a(Property property, float f11) {
        float f12 = f11 - 0.4f;
        return PropertyValuesHolder.ofKeyframe(property, Keyframe.ofFloat(0.0f, f11), Keyframe.ofFloat(0.1f, f12), Keyframe.ofFloat(0.2f, f12), Keyframe.ofFloat(0.3f, f11), Keyframe.ofFloat(0.4f, f11), Keyframe.ofFloat(0.5f, f11), Keyframe.ofFloat(0.6f, f11), Keyframe.ofFloat(0.7f, f11), Keyframe.ofFloat(0.8f, f11), Keyframe.ofFloat(0.9f, f11), Keyframe.ofFloat(1.0f, f11));
    }

    private void a(View view, int i11, int i12, long j11) {
        ValueAnimator ofInt = view.getLayoutParams().width == 0 ? ValueAnimator.ofInt(i11, i12) : ValueAnimator.ofInt(i12, i11);
        ofInt.setDuration(j11);
        ofInt.addUpdateListener(new e(view));
        ValueAnimator ofFloat = view.getLayoutParams().width == 0 ? ValueAnimator.ofFloat(0.0f, 1.0f) : ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setDuration(j11);
        ofFloat.addUpdateListener(new f(view));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofInt, ofFloat);
        animatorSet.start();
    }

    private PropertyValuesHolder b(Property property, float f11) {
        float f12 = f11 - 0.2f;
        float f13 = f11 + 0.3f;
        return PropertyValuesHolder.ofKeyframe(property, Keyframe.ofFloat(0.0f, f11), Keyframe.ofFloat(0.1f, f11 - 0.4f), Keyframe.ofFloat(0.2f, f12), Keyframe.ofFloat(0.3f, f13), Keyframe.ofFloat(0.4f, f12), Keyframe.ofFloat(0.5f, f13), Keyframe.ofFloat(0.6f, f11 - 0.1f), Keyframe.ofFloat(0.7f, f13), Keyframe.ofFloat(0.8f, f11), Keyframe.ofFloat(0.9f, 0.1f + f11), Keyframe.ofFloat(1.0f, f11));
    }

    private PropertyValuesHolder c(Property property, float f11) {
        float f12 = (-2.0f) * f11;
        float f13 = f11 * 2.0f;
        return PropertyValuesHolder.ofKeyframe(property, Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.1f, f12), Keyframe.ofFloat(0.2f, f12), Keyframe.ofFloat(0.3f, f13), Keyframe.ofFloat(0.4f, f12), Keyframe.ofFloat(0.5f, f13), Keyframe.ofFloat(0.6f, f12), Keyframe.ofFloat(0.7f, f13), Keyframe.ofFloat(0.8f, f12), Keyframe.ofFloat(0.9f, f13), Keyframe.ofFloat(1.0f, 0.0f));
    }

    public ObjectAnimator a(View view) {
        ObjectAnimator a11 = a(view, 2.0f, 1000L);
        a11.setRepeatCount(-1);
        return a11;
    }

    public ObjectAnimator a(View view, float f11, long j11) {
        return ObjectAnimator.ofPropertyValuesHolder(view, c(View.ROTATION, f11)).setDuration(j11);
    }

    public void a(View view, int i11, int i12, int i13, int i14, long j11) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i11, i12);
        ofInt.addUpdateListener(new c(view));
        ValueAnimator ofInt2 = ValueAnimator.ofInt(i13, i14);
        ofInt2.addUpdateListener(new d(view));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofInt, ofInt2);
        animatorSet.setDuration(j11);
        animatorSet.start();
    }

    public void a(View view, long j11) {
        if (view != null) {
            view.setVisibility(0);
            view.setAlpha(0.0f);
            view.animate().alpha(1.0f).setDuration(j11);
        }
    }

    public void a(List<View> list, int i11, int i12, long j11) {
        ValueAnimator duration = ValueAnimator.ofInt(i11, i12).setDuration(j11);
        duration.addUpdateListener(new C0563b(list));
        duration.start();
    }

    public void a(Map<String, Bitmap> map, com.mbridge.msdk.video.dynview.c cVar, View view) {
        if (view != null) {
            com.mbridge.msdk.video.dynview.util.draw.a.a().a(map, cVar, view);
        }
    }

    public ObjectAnimator b(View view) {
        ObjectAnimator a11 = a(view, 1.0f, 1.0f, 5.0f, 2000L);
        a11.setRepeatCount(-1);
        return a11;
    }

    public void b(View view, long j11) {
        if (view != null) {
            view.setAlpha(1.0f);
            view.animate().alpha(0.0f).setDuration(j11).setListener(new a(view));
        }
    }

    public ObjectAnimator c(View view) {
        ObjectAnimator a11 = a(view, 1.0f, 1.0f, 2000L);
        a11.setRepeatCount(-1);
        return a11;
    }

    public void c(View view, long j11) {
        if (view == null) {
            return;
        }
        a(view, 0, t0.g(view.getContext().getApplicationContext()), j11);
    }
}

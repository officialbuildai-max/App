package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;

/* loaded from: classes4.dex */
public class z extends androidx.transition.j {

    /* loaded from: classes4.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f29340a;

        a(TextView textView) {
            this.f29340a = textView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f29340a.setScaleX(floatValue);
            this.f29340a.setScaleY(floatValue);
        }
    }

    private void f0(androidx.transition.w wVar) {
        View view = wVar.f15192b;
        if (view instanceof TextView) {
            wVar.f15191a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // androidx.transition.j
    public void f(androidx.transition.w wVar) {
        f0(wVar);
    }

    @Override // androidx.transition.j
    public void j(androidx.transition.w wVar) {
        f0(wVar);
    }

    @Override // androidx.transition.j
    public Animator n(ViewGroup viewGroup, androidx.transition.w wVar, androidx.transition.w wVar2) {
        if (wVar == null || wVar2 == null || !(wVar.f15192b instanceof TextView)) {
            return null;
        }
        View view = wVar2.f15192b;
        if (!(view instanceof TextView)) {
            return null;
        }
        TextView textView = (TextView) view;
        Map map = wVar.f15191a;
        Map map2 = wVar2.f15191a;
        float floatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
        float floatValue2 = map2.get("android:textscale:scale") != null ? ((Float) map2.get("android:textscale:scale")).floatValue() : 1.0f;
        if (floatValue == floatValue2) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(floatValue, floatValue2);
        ofFloat.addUpdateListener(new a(textView));
        return ofFloat;
    }
}

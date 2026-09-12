package com.bytedance.sdk.component.adexpress.vS;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* loaded from: classes2.dex */
public class HiB extends FrameLayout {
    private ImageView Sj;
    private AnimatorSet sP;

    public HiB(Context context) {
        super(context);
        TKC();
        EjP();
    }

    private void EjP() {
        this.sP = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.Sj, "scaleX", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        ofFloat.setDuration(2000L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.Sj, "scaleY", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        ofFloat2.setDuration(2000L);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        this.sP.playTogether(ofFloat, ofFloat2);
    }

    private void TKC() {
        ImageView imageView = new ImageView(getContext());
        this.Sj = imageView;
        imageView.setImageResource(com.bytedance.sdk.component.utils.ib.EjP(getContext(), "tt_white_hand"));
        int Sj = (int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(getContext(), 20.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(Sj, Sj);
        layoutParams.gravity = 17;
        addView(this.Sj, layoutParams);
    }

    public void Sj() {
        AnimatorSet animatorSet = this.sP;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    public void sP() {
        AnimatorSet animatorSet = this.sP;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }
}

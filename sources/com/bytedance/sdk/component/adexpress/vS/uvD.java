package com.bytedance.sdk.component.adexpress.vS;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes2.dex */
public class uvD extends FrameLayout {
    private AnimatorSet EjP;
    private boolean HiB;
    private Context Sj;
    private ib TKC;
    private ImageView sP;
    private TextView vS;

    public uvD(@NonNull Context context) {
        super(context);
        this.HiB = true;
        this.Sj = context;
        this.EjP = new AnimatorSet();
        TKC();
        EjP();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.vS.uvD.1
            @Override // java.lang.Runnable
            public void run() {
                int Sj = (int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(uvD.this.Sj, 50.0f);
                int Sj2 = (int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(uvD.this.Sj, 50.0f);
                if (uvD.this.TKC.getMeasuredHeight() > 0) {
                    Sj = uvD.this.TKC.getMeasuredHeight();
                }
                if (uvD.this.TKC.getMeasuredWidth() > 0) {
                    Sj2 = uvD.this.TKC.getMeasuredWidth();
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) uvD.this.sP.getLayoutParams();
                layoutParams.topMargin = ((int) ((Sj / 2.0f) - com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(uvD.this.getContext(), 5.0f))) + ((int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(uvD.this.Sj, 40.0f));
                layoutParams.leftMargin = ((int) ((Sj2 / 2.0f) - com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(uvD.this.getContext(), 5.0f))) + ((int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(uvD.this.Sj, 20.0f));
                layoutParams.bottomMargin = (int) (((-Sj) / 2.0f) + com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(uvD.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-Sj2) / 2.0f) + com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(uvD.this.getContext(), 5.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                uvD.this.sP.setLayoutParams(layoutParams);
            }
        });
    }

    private void EjP() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.sP, "scaleX", 1.0f, 1.0f, 1.0f, 0.9f);
        ofFloat.setDuration(600L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.vS.uvD.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (uvD.this.HiB) {
                    uvD.this.TKC.Sj();
                }
                uvD.this.HiB = !r2.HiB;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(uvD.this.sP, "alpha", 0.0f, 1.0f);
                ofFloat2.setDuration(200L);
                ofFloat2.setInterpolator(new LinearInterpolator());
                ofFloat2.start();
                uvD.this.sP.setVisibility(0);
            }
        });
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.sP, "scaleY", 1.0f, 1.0f, 1.0f, 0.9f);
        ofFloat2.setDuration(600L);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        this.EjP.playTogether(ofFloat, ofFloat2);
    }

    private void TKC() {
        this.TKC = new ib(this.Sj);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Sj, 50.0f), (int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Sj, 50.0f));
        layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START;
        layoutParams.topMargin = (int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Sj, 40.0f);
        int Sj = (int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Sj, 20.0f);
        layoutParams.leftMargin = Sj;
        layoutParams.setMarginStart(Sj);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        addView(this.TKC, layoutParams);
        this.sP = new ImageView(this.Sj);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Sj, 78.0f), (int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Sj, 78.0f));
        this.sP.setImageResource(com.bytedance.sdk.component.utils.ib.EjP(this.Sj, "tt_splash_hand"));
        addView(this.sP, layoutParams2);
        TextView textView = new TextView(this.Sj);
        this.vS = textView;
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Sj, 10.0f);
        addView(this.vS, layoutParams3);
        this.vS.setVisibility(8);
    }

    public void Sj() {
        this.EjP.start();
    }

    public void sP() {
        AnimatorSet animatorSet = this.EjP;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        ib ibVar = this.TKC;
        if (ibVar != null) {
            ibVar.sP();
        }
        ImageView imageView = this.sP;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }

    public void setGuideText(String str) {
        this.vS.setVisibility(0);
        this.vS.setText(str);
    }

    public void setGuideTextColor(int i11) {
        this.vS.setTextColor(i11);
    }
}

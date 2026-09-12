package com.bytedance.sdk.openadsdk.component.reward.Sj;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.core.model.uP;

/* loaded from: classes3.dex */
public class uvD {
    private final int EjP;
    private final Sj HiB;
    private AnimatorSet Jcg;
    com.bytedance.sdk.openadsdk.core.widget.Dq Sj;
    private final Context TKC;
    private final sU sP;
    private com.bytedance.sdk.openadsdk.core.widget.Jcg vS;

    public uvD(Sj sj2) {
        this.TKC = sj2.Ei;
        this.sP = sj2.sP;
        this.EjP = sj2.sdp;
        this.HiB = sj2;
    }

    public View EjP() {
        return this.vS;
    }

    public void Sj() {
        try {
            if (uP.TKC(this.sP)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.widget.Jcg jcg = new com.bytedance.sdk.openadsdk.core.widget.Jcg(this.TKC);
            this.vS = jcg;
            this.Sj = jcg.getLoadingProgressBar();
            com.bytedance.sdk.openadsdk.core.HiB.Dq downloadButton = this.vS.getDownloadButton();
            if (downloadButton != null) {
                downloadButton.setOnClickListener(this.HiB.LqL.HiB());
            }
            this.vS.Sj(this.sP, this.EjP);
        } catch (Throwable unused) {
        }
    }

    public void TKC() {
        AnimatorSet animatorSet = this.Jcg;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void sP() {
        ValueAnimator ofInt = ValueAnimator.ofInt(1, 80);
        ofInt.setDuration(2000L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.uvD.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                com.bytedance.sdk.openadsdk.core.widget.Dq dq2 = uvD.this.Sj;
                if (dq2 != null) {
                    dq2.setProgress(intValue);
                }
            }
        });
        ValueAnimator ofInt2 = ValueAnimator.ofInt(81, 99);
        ofInt2.setDuration(3000L);
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.uvD.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                com.bytedance.sdk.openadsdk.core.widget.Dq dq2 = uvD.this.Sj;
                if (dq2 != null) {
                    dq2.setProgress(intValue);
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.Jcg = animatorSet;
        animatorSet.play(ofInt).before(ofInt2);
        this.Jcg.start();
    }
}

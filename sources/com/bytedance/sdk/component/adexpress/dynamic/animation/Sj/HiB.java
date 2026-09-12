package com.bytedance.sdk.component.adexpress.dynamic.animation.Sj;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class HiB extends EjP {
    public HiB(View view, com.bytedance.sdk.component.adexpress.dynamic.EjP.Sj sj2) {
        super(view, sj2);
    }

    private void EjP(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.TKC, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(com.bytedance.sdk.component.adexpress.EjP.Sj(), this.sP.sU())).setDuration((int) (this.sP.TEQ() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        list.add(Sj(duration));
    }

    private void Sj(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.TKC, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(com.bytedance.sdk.component.adexpress.EjP.Sj(), this.sP.sU())).setDuration(((int) (this.sP.TEQ() * 1000.0d)) / 2);
        duration.setInterpolator(new LinearInterpolator());
        duration.setRepeatMode(2);
        com.bytedance.sdk.component.adexpress.dynamic.EjP.Sj sj2 = this.sP;
        sj2.vS(sj2.Zq() * 2);
        list.add(Sj(duration));
    }

    private void TKC(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.TKC, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(com.bytedance.sdk.component.adexpress.EjP.Sj(), this.sP.sU())).setDuration((int) (this.sP.TEQ() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        duration.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.Sj.HiB.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                HiB.this.TKC.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        list.add(Sj(duration));
    }

    private void sP(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.TKC, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(com.bytedance.sdk.component.adexpress.EjP.Sj(), this.sP.sU())).setDuration((int) (this.sP.TEQ() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        duration.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.Sj.HiB.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                HiB.this.TKC.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        list.add(Sj(duration));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.Sj.EjP
    List<ObjectAnimator> Sj() {
        char c11;
        ArrayList arrayList = new ArrayList();
        String dx2 = this.sP.dx();
        switch (dx2.hashCode()) {
            case 3029889:
                if (dx2.equals("both")) {
                    c11 = 0;
                    break;
                }
                c11 = 65535;
                break;
            case 3387192:
                if (dx2.equals("none")) {
                    c11 = 3;
                    break;
                }
                c11 = 65535;
                break;
            case 483313230:
                if (dx2.equals("forwards")) {
                    c11 = 1;
                    break;
                }
                c11 = 65535;
                break;
            case 1356771568:
                if (dx2.equals("backwards")) {
                    c11 = 2;
                    break;
                }
                c11 = 65535;
                break;
            default:
                c11 = 65535;
                break;
        }
        if (c11 == 0) {
            Sj(arrayList);
        } else if (c11 == 1) {
            EjP(arrayList);
        } else if (c11 != 2) {
            TKC(arrayList);
        } else {
            sP(arrayList);
        }
        return arrayList;
    }
}

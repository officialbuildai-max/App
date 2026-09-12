package com.bytedance.adsdk.ugeno.core;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.adsdk.ugeno.core.Sj;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class Jcg {
    private View EjP;
    private int HiB;
    private String Jcg;
    Paint Sj;
    private AnimatorSet TKC = new AnimatorSet();
    private Sj sP;
    private int vS;

    public Jcg(View view, Sj sj2) {
        this.EjP = view;
        this.sP = sj2;
        Paint paint = new Paint();
        this.Sj = paint;
        paint.setAntiAlias(true);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:41:0x0144. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:57:0x017e. Please report as an issue. */
    public void Sj() {
        ArrayList arrayList = new ArrayList();
        List<Sj.C0211Sj> TKC = this.sP.TKC();
        if (TKC == null || TKC.size() <= 0) {
            return;
        }
        for (Sj.C0211Sj c0211Sj : TKC) {
            if (c0211Sj != null) {
                ObjectAnimator objectAnimator = new ObjectAnimator();
                objectAnimator.setDuration(c0211Sj.Sj());
                if (TextUtils.equals(c0211Sj.HiB(), "translateX")) {
                    objectAnimator.setPropertyName("translationX");
                } else if (TextUtils.equals(c0211Sj.HiB(), "translateY")) {
                    objectAnimator.setPropertyName("translationY");
                } else {
                    objectAnimator.setPropertyName(c0211Sj.HiB());
                }
                objectAnimator.setStartDelay(c0211Sj.EjP());
                objectAnimator.setTarget(this.EjP);
                if (TextUtils.equals(c0211Sj.HiB(), "backgroundColor")) {
                    objectAnimator.setIntValues((int) c0211Sj.vS(), (int) c0211Sj.Jcg());
                    StringBuilder sb2 = new StringBuilder("playAnimation: from = ");
                    sb2.append(c0211Sj.vS());
                    sb2.append("; to=");
                    sb2.append(c0211Sj.Jcg());
                } else {
                    objectAnimator.setFloatValues(c0211Sj.vS(), c0211Sj.Jcg());
                }
                int sP = (int) this.sP.sP();
                if (sP != 0) {
                    objectAnimator.setRepeatCount(sP);
                } else {
                    objectAnimator.setRepeatCount((int) c0211Sj.sP());
                }
                if (TextUtils.equals(c0211Sj.HiB(), "backgroundColor")) {
                    objectAnimator.setEvaluator(new ArgbEvaluator());
                }
                String vS = this.sP.vS();
                if (TextUtils.isEmpty(vS)) {
                    vS = c0211Sj.TKC();
                }
                if (TextUtils.equals(vS, "reverse")) {
                    objectAnimator.setRepeatMode(2);
                } else {
                    objectAnimator.setRepeatMode(1);
                }
                if (c0211Sj.Dq() != null && c0211Sj.Dq().length > 0) {
                    objectAnimator.setFloatValues(c0211Sj.Dq());
                }
                if (TextUtils.equals(c0211Sj.HiB(), "rotationX")) {
                    this.EjP.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.core.Jcg.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Jcg.this.EjP.setPivotX(Jcg.this.EjP.getWidth() / 2.0f);
                            Jcg.this.EjP.setPivotY(Jcg.this.EjP.getHeight());
                        }
                    });
                }
                if (TextUtils.equals(c0211Sj.HiB(), "ripple")) {
                    this.Jcg = c0211Sj.TEQ();
                }
                String uA = c0211Sj.uA();
                uA.hashCode();
                char c11 = 65535;
                switch (uA.hashCode()) {
                    case -1354466595:
                        if (uA.equals("accelerate")) {
                            c11 = 0;
                            break;
                        }
                        break;
                    case -1263948740:
                        if (uA.equals("decelerate")) {
                            c11 = 1;
                            break;
                        }
                        break;
                    case -1102672091:
                        if (uA.equals("linear")) {
                            c11 = 2;
                            break;
                        }
                        break;
                    case 475910905:
                        if (uA.equals("accelerateDecelerate")) {
                            c11 = 3;
                            break;
                        }
                        break;
                    case 1312628413:
                        if (uA.equals("standard")) {
                            c11 = 4;
                            break;
                        }
                        break;
                }
                switch (c11) {
                    case 0:
                        objectAnimator.setInterpolator(new AccelerateInterpolator());
                        break;
                    case 1:
                        objectAnimator.setInterpolator(new DecelerateInterpolator());
                        break;
                    case 2:
                    case 4:
                        objectAnimator.setInterpolator(new LinearInterpolator());
                        break;
                    case 3:
                        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                        break;
                }
                arrayList.add(objectAnimator);
            }
        }
        if (this.sP.EjP() != 0) {
            this.TKC.setDuration(this.sP.EjP());
        }
        this.TKC.setStartDelay(this.sP.HiB());
        if (TextUtils.equals(this.sP.Sj(), "sequentially")) {
            this.TKC.playSequentially(arrayList);
        } else {
            this.TKC.playTogether(arrayList);
        }
        this.TKC.start();
    }

    public void Sj(int i11, int i12) {
        this.HiB = i11 / 2;
        this.vS = i12 / 2;
    }

    public void Sj(Canvas canvas, IAnimation iAnimation) {
        try {
            if (iAnimation.getRipple() == 0.0f || TextUtils.isEmpty(this.Jcg)) {
                return;
            }
            this.Sj.setColor(com.bytedance.adsdk.ugeno.Jcg.Sj.Sj(this.Jcg));
            this.Sj.setAlpha(90);
            ((ViewGroup) this.EjP.getParent()).setClipChildren(true);
            canvas.drawCircle(this.HiB, this.vS, Math.min(r0, r2) * 2 * iAnimation.getRipple(), this.Sj);
        } catch (Throwable th2) {
            new StringBuilder("ripple animation error ").append(th2.getMessage());
        }
    }

    public void sP() {
        AnimatorSet animatorSet = this.TKC;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }
}

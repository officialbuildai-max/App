package com.bytedance.sdk.component.adexpress.vS;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.Yf;

/* loaded from: classes2.dex */
public class TKC extends FrameLayout {
    private TextView EjP;
    private dNu HiB;
    private Context Sj;
    private ImageView TKC;
    private ImageView sP;
    private AnimatorSet vS;

    public TKC(@NonNull Context context) {
        super(context);
        this.vS = new AnimatorSet();
        this.Sj = context;
        HiB();
        vS();
    }

    private void HiB() {
        FrameLayout frameLayout = new FrameLayout(this.Sj);
        this.HiB = new dNu(this.Sj);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Sj, 95.0f), (int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Sj, 95.0f));
        layoutParams.gravity = 17;
        frameLayout.addView(this.HiB, layoutParams);
        this.sP = new ImageView(this.Sj);
        int Sj = Yf.Sj(this.Sj, 60.0f);
        this.sP.setImageDrawable(com.bytedance.sdk.component.adexpress.EjP.Dq.Sj(1, null, null, new int[]{Sj, Sj}, Integer.valueOf(Yf.Sj(this.Sj, 1.0f)), Integer.valueOf(Color.parseColor("#80FFFFFF"))));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Sj, 75.0f), (int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Sj, 75.0f));
        layoutParams2.gravity = 17;
        frameLayout.addView(this.sP, layoutParams2);
        this.TKC = new ImageView(this.Sj);
        int Sj2 = Yf.Sj(this.Sj, 50.0f);
        this.TKC.setImageDrawable(com.bytedance.sdk.component.adexpress.EjP.Dq.Sj(1, Integer.valueOf(Color.parseColor("#80FFFFFF")), null, new int[]{Sj2, Sj2}, null, null));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Sj, 63.0f), (int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Sj, 63.0f));
        layoutParams3.gravity = 17;
        frameLayout.addView(this.TKC, layoutParams3);
        addView(frameLayout);
        TextView textView = new TextView(this.Sj);
        this.EjP = textView;
        textView.setTextColor(-1);
        this.EjP.setMaxLines(1);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 81;
        addView(this.EjP, layoutParams4);
    }

    private void vS() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.TKC, "scaleX", 1.0f, 0.9f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.TKC, "scaleY", 1.0f, 0.9f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.vS.setDuration(800L);
        this.vS.playTogether(ofFloat, ofFloat2);
    }

    public void EjP() {
        this.HiB.sP();
        this.HiB.TKC();
    }

    public void Sj() {
        this.vS.start();
    }

    public void TKC() {
        this.HiB.Sj();
    }

    public void sP() {
        this.vS.cancel();
    }

    public void setGuideText(String str) {
        this.EjP.setText(str);
    }
}

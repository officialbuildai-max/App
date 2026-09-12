package com.bytedance.sdk.openadsdk.sef;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.uvD;
import com.bytedance.sdk.openadsdk.utils.FPG;

/* loaded from: classes3.dex */
public class EjP extends TEQ {
    public EjP(Context context) {
        this(context, null);
    }

    public EjP(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EjP(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    @Override // com.bytedance.sdk.openadsdk.sef.TEQ
    protected void Sj(Context context) {
        int sP = FPG.sP(context, 10.0f);
        com.bytedance.sdk.openadsdk.core.HiB.HiB hiB = new com.bytedance.sdk.openadsdk.core.HiB.HiB(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        hiB.setLayoutParams(layoutParams);
        layoutParams.gravity = 17;
        hiB.setOrientation(1);
        hiB.setPadding(sP, sP, sP, sP);
        addView(hiB);
        com.bytedance.sdk.openadsdk.core.HiB.TKC tkc = new com.bytedance.sdk.openadsdk.core.HiB.TKC(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 3.0f;
        tkc.setLayoutParams(layoutParams2);
        hiB.addView(tkc);
        com.bytedance.sdk.openadsdk.core.HiB.TKC HiB = HiB(context);
        this.Sj = HiB;
        HiB.setId(com.bytedance.sdk.openadsdk.utils.Zq.zwV);
        this.Sj.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        tkc.addView(this.Sj);
        com.bytedance.sdk.openadsdk.core.HiB.EjP vS = vS(context);
        this.sP = vS;
        vS.setId(com.bytedance.sdk.openadsdk.utils.Zq.dLt);
        this.sP.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        tkc.addView(this.sP);
        PAGLogoView Dq = Dq(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 80;
        layoutParams3.leftMargin = sP;
        layoutParams3.topMargin = sP;
        layoutParams3.bottomMargin = sP;
        Dq.setLayoutParams(layoutParams3);
        tkc.addView(Dq);
        com.bytedance.sdk.openadsdk.core.HiB.Jcg jcg = new com.bytedance.sdk.openadsdk.core.HiB.Jcg(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams4.weight = 1.0f;
        jcg.setLayoutParams(layoutParams4);
        hiB.addView(jcg);
        uvD Jcg = Jcg(context);
        this.TKC = Jcg;
        int i11 = com.bytedance.sdk.openadsdk.utils.Zq.QZ;
        Jcg.setId(i11);
        int sP2 = FPG.sP(context, 40.0f);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(sP2, sP2);
        layoutParams5.addRule(15);
        this.TKC.setLayoutParams(layoutParams5);
        jcg.addView(this.TKC);
        com.bytedance.sdk.openadsdk.core.HiB.Dq sP3 = sP(context);
        this.EjP = sP3;
        sP3.setId(com.bytedance.sdk.openadsdk.utils.Zq.RrR);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(15);
        layoutParams6.leftMargin = sP;
        layoutParams6.setMarginStart(sP);
        layoutParams6.addRule(1, i11);
        layoutParams6.addRule(17, i11);
        this.EjP.setLayoutParams(layoutParams6);
        jcg.addView(this.EjP);
        com.bytedance.sdk.openadsdk.core.HiB.Dq EjP = EjP(context);
        this.vS = EjP;
        EjP.setId(com.bytedance.sdk.openadsdk.utils.Zq.nP);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(FPG.sP(context, 100.0f), FPG.sP(context, 32.0f));
        layoutParams7.addRule(11);
        layoutParams7.addRule(21);
        layoutParams7.addRule(15);
        this.vS.setLayoutParams(layoutParams7);
        jcg.addView(this.vS);
    }
}

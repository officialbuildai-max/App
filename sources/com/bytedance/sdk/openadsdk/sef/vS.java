package com.bytedance.sdk.openadsdk.sef;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.widget.uvD;
import com.bytedance.sdk.openadsdk.utils.FPG;

/* loaded from: classes3.dex */
public class vS extends TEQ {
    public vS(Context context) {
        this(context, null);
    }

    public vS(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public vS(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.sef.TEQ
    public com.bytedance.sdk.openadsdk.core.HiB.Dq EjP(Context context) {
        com.bytedance.sdk.openadsdk.core.HiB.Dq EjP = super.EjP(context);
        EjP.setBackground(com.bytedance.sdk.openadsdk.utils.TEQ.Sj(context, "tt_download_corner_bg"));
        EjP.setTextSize(2, 8.0f);
        return EjP;
    }

    @Override // com.bytedance.sdk.openadsdk.sef.TEQ
    protected void Sj(Context context) {
        int sP = FPG.sP(context, 10.0f);
        int sP2 = FPG.sP(context, 5.0f);
        int sP3 = FPG.sP(context, 6.0f);
        int sP4 = FPG.sP(context, 16.0f);
        com.bytedance.sdk.openadsdk.core.HiB.Jcg jcg = new com.bytedance.sdk.openadsdk.core.HiB.Jcg(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        jcg.setLayoutParams(layoutParams);
        addView(jcg);
        com.bytedance.sdk.openadsdk.core.HiB.TKC HiB = HiB(context);
        this.Sj = HiB;
        HiB.setId(com.bytedance.sdk.openadsdk.utils.Zq.zwV);
        this.Sj.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        jcg.addView(this.Sj);
        com.bytedance.sdk.openadsdk.core.HiB.EjP vS = vS(context);
        this.sP = vS;
        vS.setId(com.bytedance.sdk.openadsdk.utils.Zq.dLt);
        this.sP.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        jcg.addView(this.sP);
        com.bytedance.sdk.openadsdk.core.HiB.Jcg jcg2 = new com.bytedance.sdk.openadsdk.core.HiB.Jcg(context);
        int i11 = com.bytedance.sdk.openadsdk.utils.Zq.eI;
        jcg2.setId(i11);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, FPG.sP(context, 48.0f));
        layoutParams2.setMargins(sP2, sP2, sP2, sP2);
        layoutParams2.addRule(12);
        jcg2.setBackgroundColor(Color.parseColor("#26000000"));
        jcg2.setGravity(16);
        jcg2.setLayoutParams(layoutParams2);
        jcg.addView(jcg2);
        uvD Jcg = Jcg(context);
        this.TKC = Jcg;
        int i12 = com.bytedance.sdk.openadsdk.utils.Zq.QZ;
        Jcg.setId(i12);
        int sP5 = FPG.sP(context, 25.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(sP5, sP5);
        layoutParams3.addRule(20);
        layoutParams3.addRule(9);
        layoutParams3.addRule(15);
        this.TKC.setLayoutParams(layoutParams3);
        jcg2.addView(this.TKC);
        com.bytedance.sdk.openadsdk.core.HiB.HiB hiB = new com.bytedance.sdk.openadsdk.core.HiB.HiB(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams4.addRule(17, i12);
        layoutParams4.addRule(1, i12);
        hiB.setLayoutParams(layoutParams4);
        hiB.setGravity(16);
        hiB.setOrientation(1);
        jcg2.addView(hiB);
        com.bytedance.sdk.openadsdk.core.HiB.Dq sP6 = sP(context);
        this.EjP = sP6;
        sP6.setId(com.bytedance.sdk.openadsdk.utils.Zq.RrR);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.leftMargin = sP3;
        layoutParams5.setMarginStart(sP3);
        this.EjP.setLayoutParams(layoutParams5);
        hiB.addView(this.EjP);
        com.bytedance.sdk.openadsdk.core.HiB.Dq TKC = TKC(context);
        this.HiB = TKC;
        TKC.setId(com.bytedance.sdk.openadsdk.utils.Zq.SP);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.leftMargin = sP3;
        layoutParams6.setMarginStart(sP3);
        this.HiB.setLayoutParams(layoutParams6);
        hiB.addView(this.HiB);
        com.bytedance.sdk.openadsdk.core.HiB.Dq EjP = EjP(context);
        this.vS = EjP;
        EjP.setId(com.bytedance.sdk.openadsdk.utils.Zq.nP);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(21);
        layoutParams7.addRule(11);
        layoutParams7.addRule(15);
        this.vS.setLayoutParams(layoutParams7);
        int sP7 = FPG.sP(context, 4.0f);
        this.vS.setPadding(sP7, sP7, sP7, sP7);
        jcg2.addView(this.vS);
        View Dq = Dq(context);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(2, i11);
        layoutParams8.leftMargin = sP4;
        layoutParams8.bottomMargin = sP;
        Dq.setLayoutParams(layoutParams8);
        jcg.addView(Dq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.sef.TEQ
    public com.bytedance.sdk.openadsdk.core.HiB.Dq TKC(Context context) {
        com.bytedance.sdk.openadsdk.core.HiB.Dq TKC = super.TKC(context);
        TKC.setGravity(16);
        TKC.setMaxWidth(FPG.sP(context, 53.0f));
        TKC.setTextColor(-1);
        TKC.setTextSize(2, 8.0f);
        return TKC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.sef.TEQ
    public com.bytedance.sdk.openadsdk.core.HiB.Dq sP(Context context) {
        com.bytedance.sdk.openadsdk.core.HiB.Dq sP = super.sP(context);
        sP.setGravity(16);
        sP.setMaxWidth(FPG.sP(context, 53.0f));
        sP.setTextColor(-1);
        sP.setTextSize(2, 10.0f);
        return sP;
    }
}

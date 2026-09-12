package com.bytedance.sdk.openadsdk.sef;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.widget.uvD;
import com.bytedance.sdk.openadsdk.utils.FPG;

/* loaded from: classes3.dex */
public class uA extends TEQ {
    public uA(Context context) {
        this(context, null);
    }

    public uA(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public uA(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.sef.TEQ
    public com.bytedance.sdk.openadsdk.core.HiB.Dq EjP(Context context) {
        com.bytedance.sdk.openadsdk.core.HiB.Dq EjP = super.EjP(context);
        EjP.setBackground(com.bytedance.sdk.openadsdk.utils.TEQ.Sj(context, "tt_download_corner_bg"));
        EjP.setTextSize(2, 14.0f);
        return EjP;
    }

    @Override // com.bytedance.sdk.openadsdk.sef.TEQ
    protected void Sj(Context context) {
        int sP = FPG.sP(context, 10.0f);
        int sP2 = FPG.sP(context, 6.0f);
        int sP3 = FPG.sP(context, 16.0f);
        int sP4 = FPG.sP(context, 15.0f);
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
        layoutParams2.addRule(12);
        jcg2.setLayoutParams(layoutParams2);
        jcg2.setBackgroundColor(Color.parseColor("#26000000"));
        jcg2.setGravity(16);
        jcg2.setPadding(sP4, 0, 0, 0);
        jcg.addView(jcg2);
        uvD Jcg = Jcg(context);
        this.TKC = Jcg;
        int i12 = com.bytedance.sdk.openadsdk.utils.Zq.QZ;
        Jcg.setId(i12);
        int sP5 = FPG.sP(context, 40.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(sP5, sP5);
        layoutParams3.addRule(20);
        layoutParams3.addRule(9);
        layoutParams3.addRule(15);
        layoutParams3.leftMargin = sP;
        layoutParams3.setMarginStart(sP);
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
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(FPG.sP(context, 130.0f), FPG.sP(context, 20.0f));
        layoutParams5.leftMargin = sP2;
        layoutParams5.setMarginStart(sP2);
        this.EjP.setLayoutParams(layoutParams5);
        hiB.addView(this.EjP);
        com.bytedance.sdk.openadsdk.core.HiB.Dq TKC = TKC(context);
        this.HiB = TKC;
        TKC.setId(com.bytedance.sdk.openadsdk.utils.Zq.SP);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.leftMargin = sP2;
        layoutParams6.setMarginStart(sP2);
        this.HiB.setLayoutParams(layoutParams6);
        hiB.addView(this.HiB);
        com.bytedance.sdk.openadsdk.core.HiB.Dq EjP = EjP(context);
        this.vS = EjP;
        EjP.setId(com.bytedance.sdk.openadsdk.utils.Zq.nP);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(FPG.sP(context, 80.0f), FPG.sP(context, 30.0f));
        layoutParams7.addRule(21);
        layoutParams7.addRule(11);
        layoutParams7.addRule(15);
        layoutParams7.rightMargin = sP;
        layoutParams7.setMarginEnd(sP);
        this.vS.setLayoutParams(layoutParams7);
        jcg2.addView(this.vS);
        View Dq = Dq(context);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(2, i11);
        layoutParams8.leftMargin = sP3;
        layoutParams8.bottomMargin = sP;
        Dq.setLayoutParams(layoutParams8);
        jcg.addView(Dq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.sef.TEQ
    public com.bytedance.sdk.openadsdk.core.HiB.Dq TKC(Context context) {
        com.bytedance.sdk.openadsdk.core.HiB.Dq TKC = super.TKC(context);
        TKC.setGravity(16);
        TKC.setMaxWidth(FPG.sP(context, 153.0f));
        TKC.setTextColor(-1);
        TKC.setTextSize(2, 13.0f);
        return TKC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.sef.TEQ
    public com.bytedance.sdk.openadsdk.core.HiB.Dq sP(Context context) {
        com.bytedance.sdk.openadsdk.core.HiB.Dq dq2 = new com.bytedance.sdk.openadsdk.core.HiB.Dq(context);
        dq2.setEllipsize(TextUtils.TruncateAt.END);
        dq2.setGravity(16);
        dq2.setMaxWidth(FPG.sP(context, 153.0f));
        dq2.setSingleLine();
        dq2.setText("Pangle");
        dq2.setTextColor(-1);
        dq2.setTextSize(2, 14.0f);
        return dq2;
    }
}

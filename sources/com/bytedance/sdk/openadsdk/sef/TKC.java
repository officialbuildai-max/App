package com.bytedance.sdk.openadsdk.sef;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.uvD;
import com.bytedance.sdk.openadsdk.utils.FPG;

/* loaded from: classes3.dex */
public class TKC extends TEQ {
    public TKC(Context context) {
        this(context, null);
    }

    public TKC(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TKC(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    @Override // com.bytedance.sdk.openadsdk.sef.TEQ
    protected void Sj(Context context) {
        com.bytedance.sdk.openadsdk.core.HiB.HiB hiB = new com.bytedance.sdk.openadsdk.core.HiB.HiB(context);
        hiB.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        hiB.setOrientation(1);
        addView(hiB);
        com.bytedance.sdk.openadsdk.core.HiB.TKC tkc = new com.bytedance.sdk.openadsdk.core.HiB.TKC(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 337.0f;
        tkc.setLayoutParams(layoutParams);
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
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 80;
        int sP = FPG.sP(context, 10.0f);
        layoutParams2.leftMargin = sP;
        layoutParams2.topMargin = sP;
        layoutParams2.bottomMargin = sP;
        Dq.setLayoutParams(layoutParams2);
        tkc.addView(Dq);
        com.bytedance.sdk.openadsdk.core.HiB.HiB hiB2 = new com.bytedance.sdk.openadsdk.core.HiB.HiB(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams3.weight = 263.0f;
        hiB2.setLayoutParams(layoutParams3);
        hiB2.setOrientation(1);
        hiB2.setGravity(81);
        int sP2 = FPG.sP(context, 16.0f);
        hiB2.setPadding(sP2, sP2, sP2, sP2);
        hiB.addView(hiB2);
        uvD Jcg = Jcg(context);
        this.TKC = Jcg;
        Jcg.setId(com.bytedance.sdk.openadsdk.utils.Zq.QZ);
        int sP3 = FPG.sP(context, 45.0f);
        this.TKC.setLayoutParams(new LinearLayout.LayoutParams(sP3, sP3));
        hiB2.addView(this.TKC);
        com.bytedance.sdk.openadsdk.core.HiB.Dq sP4 = sP(context);
        this.EjP = sP4;
        sP4.setId(com.bytedance.sdk.openadsdk.utils.Zq.RrR);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = FPG.sP(context, 4.0f);
        this.EjP.setLayoutParams(layoutParams4);
        hiB2.addView(this.EjP);
        com.bytedance.sdk.openadsdk.core.HiB.Dq TKC = TKC(context);
        this.HiB = TKC;
        TKC.setId(com.bytedance.sdk.openadsdk.utils.Zq.SP);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.topMargin = sP;
        layoutParams5.bottomMargin = FPG.sP(context, 25.0f);
        this.HiB.setLayoutParams(layoutParams5);
        hiB2.addView(this.HiB);
        com.bytedance.sdk.openadsdk.core.HiB.Dq EjP = EjP(context);
        this.vS = EjP;
        EjP.setId(com.bytedance.sdk.openadsdk.utils.Zq.nP);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, FPG.sP(context, 32.0f));
        layoutParams6.topMargin = sP2;
        this.vS.setLayoutParams(layoutParams6);
        hiB2.addView(this.vS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.sef.TEQ
    public com.bytedance.sdk.openadsdk.core.HiB.Dq sP(Context context) {
        com.bytedance.sdk.openadsdk.core.HiB.Dq sP = super.sP(context);
        sP.setTextColor(-1);
        return sP;
    }
}

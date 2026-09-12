package com.bytedance.sdk.openadsdk.component.uA;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.ib;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.utils.FPG;

/* loaded from: classes3.dex */
public class Jcg extends com.bytedance.sdk.openadsdk.core.HiB.Jcg {
    private final com.bytedance.sdk.openadsdk.core.HiB.EjP Sj;
    private final com.bytedance.sdk.openadsdk.core.HiB.Dq TKC;
    private final com.bytedance.sdk.openadsdk.core.HiB.EjP sP;

    public Jcg(@NonNull Context context) {
        super(context);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        int sP = FPG.sP(context, 12.0f);
        int sP2 = FPG.sP(context, 16.0f);
        int sP3 = FPG.sP(context, 20.0f);
        int sP4 = FPG.sP(context, 24.0f);
        int sP5 = FPG.sP(context, 28.0f);
        com.bytedance.sdk.openadsdk.core.HiB.EjP ejP = new com.bytedance.sdk.openadsdk.core.HiB.EjP(context);
        this.Sj = ejP;
        ejP.setId(520093713);
        int sP6 = FPG.sP(getContext(), 5.0f);
        ejP.setPadding(sP6, sP6, sP6, sP6);
        ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER;
        ejP.setScaleType(scaleType);
        ejP.setBackground(com.bytedance.sdk.openadsdk.core.widget.EjP.Sj());
        ejP.setImageResource(ib.EjP(dNu.Sj(), "tt_reward_full_feedback"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(sP5, sP5);
        layoutParams.topMargin = sP3;
        layoutParams.leftMargin = sP2;
        layoutParams.setMarginStart(sP2);
        ejP.setLayoutParams(layoutParams);
        com.bytedance.sdk.openadsdk.core.HiB.EjP ejP2 = new com.bytedance.sdk.openadsdk.core.HiB.EjP(context);
        this.sP = ejP2;
        ejP2.setId(520093714);
        ejP2.setPadding(sP6, sP6, sP6, sP6);
        ejP2.setScaleType(scaleType);
        ejP2.setBackground(com.bytedance.sdk.openadsdk.core.widget.EjP.Sj());
        ejP2.setImageResource(ib.EjP(dNu.Sj(), "tt_close_btn"));
        if (ejP2.getDrawable() != null) {
            ejP2.getDrawable().setAutoMirrored(true);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(sP5, sP5);
        layoutParams2.topMargin = sP3;
        layoutParams2.rightMargin = sP2;
        layoutParams2.setMarginEnd(sP2);
        layoutParams2.addRule(11);
        layoutParams2.addRule(21);
        ejP2.setLayoutParams(layoutParams2);
        ejP2.setVisibility(4);
        com.bytedance.sdk.openadsdk.core.HiB.Dq dq2 = new com.bytedance.sdk.openadsdk.core.HiB.Dq(context);
        this.TKC = dq2;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, sP4);
        layoutParams3.topMargin = sP3;
        layoutParams3.rightMargin = sP2;
        layoutParams3.addRule(11);
        layoutParams3.setMarginEnd(sP2);
        layoutParams3.addRule(21);
        dq2.setLayoutParams(layoutParams3);
        dq2.setBackground(com.bytedance.sdk.openadsdk.core.widget.EjP.sP());
        dq2.setGravity(17);
        dq2.setPadding(sP, 0, sP, 0);
        dq2.setTextColor(-1);
        dq2.setTextSize(1, 14.0f);
        dq2.setVisibility(4);
        addView(ejP);
        addView(dq2);
        addView(ejP2);
    }

    public com.bytedance.sdk.openadsdk.core.HiB.Dq getTopCountDown() {
        return this.TKC;
    }

    public View getTopDislike() {
        return this.Sj;
    }

    public com.bytedance.sdk.openadsdk.core.HiB.EjP getTopSkip() {
        return this.sP;
    }
}

package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.widget.FrameLayout;

/* loaded from: classes2.dex */
public class kF extends vS {
    private int Sj;

    public kF(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2) {
        super(context, dynamicRootView, dq2);
        this.Sj = 0;
        com.bytedance.sdk.component.adexpress.vS.kF kFVar = new com.bytedance.sdk.component.adexpress.vS.kF(context, null);
        this.Zq = kFVar;
        kFVar.setTag(Integer.valueOf(getClickArea()));
        addView(this.Zq, getWidgetLayoutParams());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vS
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        int Sj = (int) ((com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(com.bytedance.sdk.component.adexpress.EjP.Sj(), this.f20971aa.HiB()) * 5.0f) + com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(com.bytedance.sdk.component.adexpress.EjP.Sj(), this.f20971aa.TKC() + com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(com.bytedance.sdk.component.adexpress.EjP.Sj(), this.f20971aa.EjP())));
        if (this.Jcg > Sj && 4 == this.f20971aa.Dq()) {
            this.Sj = (this.Jcg - Sj) / 2;
        }
        this.Jcg = Sj;
        return new FrameLayout.LayoutParams(this.Jcg, this.Dq);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vS, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.WMZ
    public boolean uA() {
        DynamicRootView dynamicRootView;
        super.uA();
        double Fmk = this.f20971aa.Fmk();
        if (com.bytedance.sdk.component.adexpress.EjP.sP() && (Fmk < 0.0d || Fmk > 5.0d || ((dynamicRootView = this.sef) != null && dynamicRootView.getRenderRequest() != null && this.sef.getRenderRequest().TEQ() != 4))) {
            this.Zq.setVisibility(8);
            return true;
        }
        double d11 = (Fmk < 0.0d || Fmk > 5.0d) ? 5.0d : Fmk;
        this.Zq.setVisibility(0);
        ((com.bytedance.sdk.component.adexpress.vS.kF) this.Zq).Sj(d11, this.f20971aa.Jcg(), (int) this.f20971aa.HiB(), ((int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Ym, this.f20971aa.sP())) + ((int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Ym, this.f20971aa.Sj())) + ((int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Ym, this.f20971aa.HiB())));
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.HiB
    public void vS() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.Jcg, this.Dq);
        layoutParams.topMargin = this.TEQ;
        int i11 = this.uA + this.Sj;
        layoutParams.leftMargin = i11;
        layoutParams.setMarginStart(i11);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }
}

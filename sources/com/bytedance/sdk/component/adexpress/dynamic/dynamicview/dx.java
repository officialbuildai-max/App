package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/* loaded from: classes2.dex */
public class dx extends Jcg implements com.bytedance.sdk.component.adexpress.dynamic.TKC {
    private int[] Sj;
    private int sP;
    private int sU;

    public dx(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2) {
        super(context, dynamicRootView, dq2);
        dynamicRootView.setTimeOutListener(this);
    }

    private void Sj() {
        int Sj = (int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Ym, this.f20971aa.HiB());
        this.sP = ((this.Dq - Sj) / 2) - this.f20971aa.Sj();
        this.sU = 0;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.TKC
    @SuppressLint({"SetTextI18n"})
    public void Sj(CharSequence charSequence, boolean z10, int i11, boolean z11) {
        String Sj = com.bytedance.sdk.component.utils.ib.Sj(com.bytedance.sdk.component.adexpress.EjP.Sj(), "tt_reward_screen_skip_tx");
        if (i11 == 0) {
            this.Zq.setVisibility(0);
            ((TextView) this.Zq).setText("| ".concat(String.valueOf(Sj)));
            this.Zq.measure(-2, -2);
            this.Sj = new int[]{this.Zq.getMeasuredWidth() + 1, this.Zq.getMeasuredHeight()};
            View view = this.Zq;
            int[] iArr = this.Sj;
            view.setLayoutParams(new FrameLayout.LayoutParams(iArr[0], iArr[1]));
            ((TextView) this.Zq).setGravity(17);
            ((TextView) this.Zq).setIncludeFontPadding(false);
            Sj();
            this.Zq.setPadding(this.f20971aa.TKC(), this.sP, this.f20971aa.EjP(), this.sU);
        }
        requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (TextUtils.isEmpty(((TextView) this.Zq).getText())) {
            setMeasuredDimension(0, this.Dq);
        } else {
            setMeasuredDimension(this.Jcg, this.Dq);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Jcg, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vS, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.WMZ
    public boolean uA() {
        super.uA();
        ((TextView) this.Zq).setText("");
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.HiB
    public void vS() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.Jcg, this.Dq);
        layoutParams.gravity = 8388629;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }
}

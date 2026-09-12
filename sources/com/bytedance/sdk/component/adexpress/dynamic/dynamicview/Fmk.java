package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

/* loaded from: classes2.dex */
public class Fmk extends vS {
    public Fmk(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2) {
        super(context, dynamicRootView, dq2);
        TextView textView = new TextView(context);
        this.Zq = textView;
        textView.setTag(Integer.valueOf(getClickArea()));
        addView(this.Zq, getWidgetLayoutParams());
    }

    private boolean Sj() {
        if (com.bytedance.sdk.component.adexpress.EjP.sP()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.f20971aa.sP) && this.f20971aa.sP.contains("adx:")) || com.bytedance.sdk.component.adexpress.dynamic.HiB.Ym.sP();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vS, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.WMZ
    public boolean uA() {
        com.bytedance.sdk.component.adexpress.sP.Fmk renderRequest;
        super.uA();
        this.Zq.setTextAlignment(this.f20971aa.Dq());
        ((TextView) this.Zq).setTextColor(this.f20971aa.Jcg());
        ((TextView) this.Zq).setTextSize(this.f20971aa.HiB());
        if (!com.bytedance.sdk.component.adexpress.EjP.sP()) {
            if (!Sj()) {
                ((TextView) this.Zq).setText(com.bytedance.sdk.component.utils.ib.sP(getContext(), "tt_logo_cn"));
                return true;
            }
            if (com.bytedance.sdk.component.adexpress.dynamic.HiB.Ym.sP()) {
                ((TextView) this.Zq).setText(com.bytedance.sdk.component.adexpress.dynamic.HiB.Ym.Sj());
                return true;
            }
            ((TextView) this.Zq).setText(com.bytedance.sdk.component.adexpress.dynamic.HiB.Ym.Sj(this.f20971aa.sP));
            return true;
        }
        int i11 = 0;
        ((TextView) this.Zq).setIncludeFontPadding(false);
        ((TextView) this.Zq).setTextSize(Math.min(((com.bytedance.sdk.component.adexpress.EjP.Jcg.sP(com.bytedance.sdk.component.adexpress.EjP.Sj(), this.Dq) - this.f20971aa.sP()) - this.f20971aa.Sj()) - 0.5f, this.f20971aa.HiB()));
        DynamicRootView dynamicRootView = this.sef;
        if (dynamicRootView != null && (renderRequest = dynamicRootView.getRenderRequest()) != null) {
            String ley = renderRequest.ley();
            if (!TextUtils.isEmpty(ley)) {
                ((TextView) this.Zq).setText(ley);
                ((TextView) this.Zq).setVisibility(i11);
                return true;
            }
        }
        i11 = 8;
        ((TextView) this.Zq).setVisibility(i11);
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.HiB
    public void vS() {
        com.bytedance.sdk.component.adexpress.sP.Fmk renderRequest = this.sef.getRenderRequest();
        if (renderRequest == null || !TextUtils.isEmpty(renderRequest.wE())) {
            super.vS();
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.Jcg, this.Dq);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
    }
}

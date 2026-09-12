package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

/* loaded from: classes2.dex */
public class TEQ extends vS {
    public TEQ(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2) {
        super(context, dynamicRootView, dq2);
        if (com.bytedance.sdk.component.adexpress.EjP.sP()) {
            ImageView imageView = new ImageView(context);
            this.Zq = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.Jcg = this.Dq;
        } else {
            this.Zq = new TextView(context);
        }
        this.Zq.setTag(3);
        addView(this.Zq, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.Zq);
        if (dynamicRootView.getRenderRequest() != null) {
            if (dynamicRootView.getRenderRequest().Dq() && dynamicRootView.getRenderRequest().uP()) {
                return;
            }
            this.Zq.setVisibility(8);
            setVisibility(8);
        }
    }

    public String getText() {
        return com.bytedance.sdk.component.utils.ib.Sj(com.bytedance.sdk.component.adexpress.EjP.Sj(), "tt_reward_feedback");
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vS, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.WMZ
    public boolean uA() {
        super.uA();
        if (com.bytedance.sdk.component.adexpress.EjP.sP()) {
            Drawable Sj = com.bytedance.sdk.component.adexpress.EjP.TKC.Sj(getContext(), this.f20971aa);
            if (Sj != null) {
                ((ImageView) this.Zq).setBackground(Sj);
            }
            ((ImageView) this.Zq).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            int EjP = com.bytedance.sdk.component.utils.ib.EjP(getContext(), "tt_reward_full_feedback");
            if (EjP > 0) {
                ((ImageView) this.Zq).setImageResource(EjP);
            }
            return true;
        }
        ((TextView) this.Zq).setText(getText());
        this.Zq.setTextAlignment(this.f20971aa.Dq());
        ((TextView) this.Zq).setTextColor(this.f20971aa.Jcg());
        ((TextView) this.Zq).setTextSize(this.f20971aa.HiB());
        this.Zq.setBackground(getBackgroundDrawable());
        if (this.f20971aa.zR()) {
            int ib2 = this.f20971aa.ib();
            if (ib2 > 0) {
                ((TextView) this.Zq).setLines(ib2);
                ((TextView) this.Zq).setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            ((TextView) this.Zq).setMaxLines(1);
            ((TextView) this.Zq).setGravity(17);
            ((TextView) this.Zq).setEllipsize(TextUtils.TruncateAt.END);
        }
        this.Zq.setPadding((int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(com.bytedance.sdk.component.adexpress.EjP.Sj(), this.f20971aa.TKC()), (int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(com.bytedance.sdk.component.adexpress.EjP.Sj(), this.f20971aa.sP()), (int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(com.bytedance.sdk.component.adexpress.EjP.Sj(), this.f20971aa.EjP()), (int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(com.bytedance.sdk.component.adexpress.EjP.Sj(), this.f20971aa.Sj()));
        ((TextView) this.Zq).setGravity(17);
        return true;
    }
}

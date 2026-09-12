package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* loaded from: classes2.dex */
public class LqL extends vS implements com.bytedance.sdk.component.adexpress.dynamic.TKC {
    private boolean Sj;

    public LqL(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2) {
        super(context, dynamicRootView, dq2);
        if (dynamicRootView.getRenderRequest() != null) {
            this.Sj = dynamicRootView.getRenderRequest().Fmk();
        }
        this.Jcg = this.Dq;
        ImageView imageView = new ImageView(context);
        this.Zq = imageView;
        imageView.setTag(Integer.valueOf(getClickArea()));
        addView(this.Zq, getWidgetLayoutParams());
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().uP()) {
            return;
        }
        this.Zq.setVisibility(8);
        setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.TKC
    public void Sj(CharSequence charSequence, boolean z10, int i11, boolean z11) {
        int i12 = 0;
        if (!z10 && !z11) {
            i12 = 8;
        }
        setVisibility(i12);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vS, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.WMZ
    public boolean uA() {
        Drawable TKC;
        super.uA();
        ((ImageView) this.Zq).setScaleType(ImageView.ScaleType.CENTER_CROP);
        Drawable Sj = com.bytedance.sdk.component.adexpress.EjP.TKC.Sj(getContext(), this.f20971aa);
        if (Sj != null) {
            ((ImageView) this.Zq).setBackground(Sj);
        }
        if (this.Sj) {
            TKC = com.bytedance.sdk.component.utils.ib.TKC(getContext(), "tt_close_btn");
        } else {
            TKC = com.bytedance.sdk.component.utils.ib.TKC(getContext(), "tt_skip_btn");
            if (TKC != null) {
                TKC.setAutoMirrored(true);
            }
        }
        if (TKC != null) {
            ((ImageView) this.Zq).setImageDrawable(TKC);
        }
        setVisibility(8);
        return true;
    }
}

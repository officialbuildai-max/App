package com.bytedance.sdk.component.adexpress.dynamic.TKC;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.vS.RiZ;
import com.bytedance.sdk.component.adexpress.vS.sU;
import com.bytedance.sdk.component.adexpress.vS.zR;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class vS extends dNu<com.bytedance.sdk.component.adexpress.vS.vS> {
    public vS(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.HiB hiB, com.bytedance.sdk.component.adexpress.dynamic.EjP.Jcg jcg, int i11, int i12, int i13, JSONObject jSONObject) {
        super(context, hiB, jcg);
        this.sP = context;
        this.EjP = jcg;
        this.TKC = hiB;
        Sj(i11, i12, i13, jSONObject, jcg);
    }

    private void Sj(int i11, int i12, int i13, JSONObject jSONObject, com.bytedance.sdk.component.adexpress.dynamic.EjP.Jcg jcg) {
        this.Sj = new com.bytedance.sdk.component.adexpress.vS.vS(this.sP, i11, i12, i13, jSONObject);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.sP, 300.0f));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.sP, jcg.ndK() > 0 ? jcg.ndK() : com.bytedance.sdk.component.adexpress.EjP.sP() ? 0 : 120);
        this.Sj.setLayoutParams(layoutParams);
        this.Sj.setClipChildren(false);
        this.Sj.setSlideText(this.EjP.sdp());
        zR zRVar = this.Sj;
        if (zRVar instanceof com.bytedance.sdk.component.adexpress.vS.vS) {
            ((com.bytedance.sdk.component.adexpress.vS.vS) zRVar).setShakeText(this.EjP.IOh());
            final sU shakeView = ((com.bytedance.sdk.component.adexpress.vS.vS) this.Sj).getShakeView();
            if (shakeView != null) {
                shakeView.setOnShakeViewListener(new RiZ.Sj() { // from class: com.bytedance.sdk.component.adexpress.dynamic.TKC.vS.1
                });
                shakeView.setOnClickListener((View.OnClickListener) this.TKC.getDynamicClickListener());
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.TKC.dNu
    protected void EjP() {
    }
}

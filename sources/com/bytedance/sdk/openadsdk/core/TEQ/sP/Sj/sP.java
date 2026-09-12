package com.bytedance.sdk.openadsdk.core.TEQ.sP.Sj;

import android.content.Context;
import com.bytedance.adsdk.sP.vS;
import com.bytedance.adsdk.ugeno.EjP;

/* loaded from: classes3.dex */
public class sP extends vS {
    private EjP Sj;

    public sP(Context context) {
        super(context);
    }

    public void Sj(EjP ejP) {
        this.Sj = ejP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.adsdk.sP.vS, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        EjP ejP = this.Sj;
        if (ejP != null) {
            ejP.Jcg();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.adsdk.sP.vS, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EjP ejP = this.Sj;
        if (ejP != null) {
            ejP.Dq();
        }
    }
}

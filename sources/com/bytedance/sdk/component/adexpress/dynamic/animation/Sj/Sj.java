package com.bytedance.sdk.component.adexpress.dynamic.animation.Sj;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class Sj extends EjP {
    public Sj(View view, com.bytedance.sdk.component.adexpress.dynamic.EjP.Sj sj2) {
        super(view, sj2);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.Sj.EjP
    List<ObjectAnimator> Sj() {
        float TzV = this.sP.TzV() / 100.0f;
        float RiZ = this.sP.RiZ() / 100.0f;
        if ("reverse".equals(this.sP.uvD()) && this.sP.sef() <= 0.0d) {
            RiZ = TzV;
            TzV = RiZ;
        }
        this.TKC.setAlpha(TzV);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.TKC, "alpha", TzV, RiZ).setDuration((int) (this.sP.TEQ() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(Sj(duration));
        return arrayList;
    }
}

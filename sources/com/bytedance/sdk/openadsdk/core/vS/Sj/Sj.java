package com.bytedance.sdk.openadsdk.core.vS.Sj;

import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.component.adexpress.sP.Ym;
import com.bytedance.sdk.openadsdk.core.model.sef;
import com.bytedance.sdk.openadsdk.core.sP.TKC;
import com.bytedance.sdk.openadsdk.utils.FPG;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class Sj extends TKC implements com.bytedance.sdk.component.adexpress.dynamic.vS.Sj {
    protected WeakReference<View> Sj;
    private Ym TKC;
    protected WeakReference<View> sP;

    private void Sj(View view, int i11, float f11, float f12, float f13, float f14, SparseArray<TKC.Sj> sparseArray) {
        if (this.TKC != null) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            WeakReference<View> weakReference = this.sP;
            if (weakReference != null) {
                int[] Sj = FPG.Sj(weakReference.get());
                if (Sj != null) {
                    iArr = Sj;
                }
                int[] TKC = FPG.TKC(this.sP.get());
                if (TKC != null) {
                    iArr2 = TKC;
                }
            }
            String str = "";
            try {
                int i12 = com.bytedance.sdk.component.adexpress.dynamic.Sj.f20966dx;
                if (view.getTag(i12) != null) {
                    str = String.valueOf(view.getTag(i12));
                }
            } catch (Exception unused) {
            }
            this.TKC.Sj(view, i11, new sef.Sj().EjP(f11).TKC(f12).sP(f13).Sj(f14).sP(this.uP).Sj(this.wE).TKC(iArr[0]).EjP(iArr[1]).HiB(iArr2[0]).vS(iArr2[1]).Sj(sparseArray).Sj(this.fF).Sj(str).Sj());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.vS.Sj
    public void Sj(View view) {
        this.Sj = new WeakReference<>(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.sP.TKC
    public void Sj(View view, float f11, float f12, float f13, float f14, SparseArray<TKC.Sj> sparseArray, boolean z10) {
        Sj(view, ((Integer) view.getTag()).intValue(), f11, f12, f13, f14, sparseArray);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.vS.Sj
    public void Sj(Ym ym2) {
        this.TKC = ym2;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.vS.Sj
    public void sP(View view) {
        this.sP = new WeakReference<>(view);
    }
}

package com.bytedance.sdk.component.HiB.EjP.sP;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.HiB.RiZ;

/* loaded from: classes2.dex */
public class Sj<T> implements vS {
    private boolean Sj(com.bytedance.sdk.component.HiB.EjP.TKC.TKC tkc) {
        int aa2 = tkc.aa();
        return aa2 == 1 || aa2 == 2;
    }

    @Override // com.bytedance.sdk.component.HiB.EjP.sP.vS
    public String Sj() {
        return "bitmap_cache";
    }

    @Override // com.bytedance.sdk.component.HiB.EjP.sP.vS
    public boolean Sj(com.bytedance.sdk.component.HiB.EjP.TKC.TKC tkc, RiZ riZ, com.bytedance.sdk.component.HiB.EjP.TKC.Sj sj2) {
        Bitmap Sj;
        String TEQ = tkc.TEQ();
        tkc.Sj();
        com.bytedance.sdk.component.HiB.sP TzV = tkc.TzV();
        com.bytedance.sdk.component.HiB.EjP.TKC.vS dNu = tkc.dNu();
        if (TzV == null || dNu == null || !TzV.HiB() || !Sj(tkc) || (Sj = dNu.Sj(TzV).Sj(TEQ)) == null) {
            return true;
        }
        tkc.Sj();
        sj2.Sj(new com.bytedance.sdk.component.HiB.EjP.TKC.EjP().Sj(tkc, Sj, null, false));
        return false;
    }
}

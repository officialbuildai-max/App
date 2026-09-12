package com.bytedance.sdk.component.HiB.EjP.sP;

import android.text.TextUtils;
import com.bytedance.sdk.component.HiB.RiZ;
import com.bytedance.sdk.component.utils.uvD;

/* loaded from: classes2.dex */
public class sP implements vS {
    private String Sj(com.bytedance.sdk.component.HiB.EjP.TKC.TKC tkc) {
        return uvD.Sj(tkc.Sj());
    }

    @Override // com.bytedance.sdk.component.HiB.EjP.sP.vS
    public String Sj() {
        return "generate_key";
    }

    @Override // com.bytedance.sdk.component.HiB.EjP.sP.vS
    public boolean Sj(com.bytedance.sdk.component.HiB.EjP.TKC.TKC tkc, RiZ riZ, com.bytedance.sdk.component.HiB.EjP.TKC.Sj sj2) {
        if (TextUtils.isEmpty(tkc.TEQ())) {
            String Sj = Sj(tkc);
            tkc.sP(Sj);
            tkc.Sj(Sj);
        }
        tkc.Sj();
        return true;
    }
}

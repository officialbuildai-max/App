package com.bytedance.sdk.component.HiB.EjP.sP;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.HiB.RiZ;
import com.bytedance.sdk.component.utils.Ym;

/* loaded from: classes2.dex */
public class EjP<T> implements vS {
    private void Sj(com.bytedance.sdk.component.HiB.EjP.TKC.TKC tkc, byte[] bArr, com.bytedance.sdk.component.HiB.EjP.TKC.Sj sj2) {
        try {
            com.bytedance.sdk.component.HiB.EjP.TKC.vS dNu = tkc.dNu();
            Bitmap Sj = dNu.Sj(tkc).Sj(bArr);
            if (Sj == null) {
                tkc.TEQ();
                tkc.Sj();
                sj2.Sj(1002, "decode failed bitmap null", new Exception("decode failed bitmap null"));
                return;
            }
            tkc.TEQ();
            tkc.Sj();
            Sj.getWidth();
            Sj.getHeight();
            Sj.getByteCount();
            sj2.Sj(new com.bytedance.sdk.component.HiB.EjP.TKC.EjP().Sj(tkc, Sj, null, false));
            Sj(tkc.TzV(), dNu, tkc.TEQ(), Sj);
        } catch (Throwable th2) {
            tkc.TEQ();
            tkc.Sj();
            sj2.Sj(1002, "decode failed:" + th2.getMessage(), th2);
        }
    }

    private void Sj(com.bytedance.sdk.component.HiB.sP sPVar, com.bytedance.sdk.component.HiB.EjP.TKC.vS vSVar, String str, Bitmap bitmap) {
        if (sPVar == null || vSVar == null || !sPVar.HiB()) {
            return;
        }
        vSVar.Sj(sPVar).Sj(str, bitmap);
    }

    @Override // com.bytedance.sdk.component.HiB.EjP.sP.vS
    public String Sj() {
        return "decode";
    }

    @Override // com.bytedance.sdk.component.HiB.EjP.sP.vS
    public boolean Sj(com.bytedance.sdk.component.HiB.EjP.TKC.TKC tkc, RiZ riZ, com.bytedance.sdk.component.HiB.EjP.TKC.Sj sj2) {
        byte[] sef = tkc.sef();
        if (sef == null) {
            sj2.Sj(2000, "imageData is empty", new Exception("imageData is empty"));
            return false;
        }
        int aa2 = tkc.aa();
        tkc.Sj(sef.length);
        if (aa2 != 2) {
            if (aa2 != 3) {
                boolean sP = com.bytedance.sdk.component.utils.vS.sP(sef);
                boolean Sj = Ym.Sj(sef, 0);
                if (sP || Sj) {
                    sj2.Sj(new com.bytedance.sdk.component.HiB.EjP.TKC.EjP().Sj(tkc, sef, null, sP));
                } else if (com.bytedance.sdk.component.utils.vS.Sj(sef)) {
                    Sj(tkc, sef, sj2);
                } else {
                    sj2.Sj(new com.bytedance.sdk.component.HiB.EjP.TKC.EjP().Sj(tkc, sef, null, false));
                }
            } else {
                sj2.Sj(new com.bytedance.sdk.component.HiB.EjP.TKC.EjP().Sj(tkc, sef, null, com.bytedance.sdk.component.utils.vS.sP(sef)));
            }
        } else if (com.bytedance.sdk.component.utils.vS.Sj(sef)) {
            Sj(tkc, sef, sj2);
        } else {
            sj2.Sj(1001, "result type is bit but data not image", new Exception("not image format"));
        }
        return false;
    }
}

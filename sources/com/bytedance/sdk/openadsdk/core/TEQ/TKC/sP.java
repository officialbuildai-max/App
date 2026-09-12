package com.bytedance.sdk.openadsdk.core.TEQ.TKC;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.Dq.sef;
import com.bytedance.sdk.openadsdk.core.Yf;
import com.bytedance.sdk.openadsdk.core.model.Zq;
import com.bytedance.sdk.openadsdk.core.model.sU;

/* loaded from: classes3.dex */
public class sP {
    private com.bytedance.sdk.openadsdk.core.TEQ.TKC.Sj EjP;
    private TKC Sj;
    private sU TKC;
    private Context sP;

    /* loaded from: classes3.dex */
    public static class Sj {
        public static TKC Sj(Context context, sU sUVar) {
            if (Zq.Sj(sUVar)) {
                return new EjP(context, sUVar);
            }
            return null;
        }
    }

    public sP(Context context, sU sUVar) {
        this.sP = context;
        this.TKC = sUVar;
    }

    public void Sj() {
        TKC tkc = this.Sj;
        if (tkc != null) {
            tkc.sP();
        }
    }

    public void Sj(int i11) {
        Yf HiB;
        TKC tkc = this.Sj;
        if (!(tkc instanceof EjP) || (HiB = ((EjP) tkc).HiB()) == null || HiB.Sj() == null) {
            return;
        }
        HiB.Sj().Sj(i11);
    }

    public void Sj(sef sefVar) {
        TKC Sj2 = Sj.Sj(this.sP, this.TKC);
        this.Sj = Sj2;
        if (Sj2 != null) {
            Sj2.Sj();
            this.Sj.Sj(sefVar);
        }
    }

    public void Sj(com.bytedance.sdk.openadsdk.core.TEQ.TKC.Sj sj2) {
        this.EjP = sj2;
        TKC tkc = this.Sj;
        if (tkc != null) {
            tkc.Sj(sj2);
        }
    }

    public void TKC() {
        TKC tkc = this.Sj;
        if (tkc != null) {
            tkc.TKC();
        }
    }

    public View sP() {
        TKC tkc = this.Sj;
        if (tkc != null) {
            return tkc.EjP();
        }
        return null;
    }
}

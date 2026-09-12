package com.bytedance.adsdk.ugeno.EjP.EjP;

import android.content.Context;

/* loaded from: classes2.dex */
public class sP extends Sj implements com.bytedance.adsdk.ugeno.EjP.Sj.EjP {
    private com.bytedance.adsdk.ugeno.EjP.Sj.TKC Ym;

    public sP(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.EjP.Sj.EjP
    public void Sj(String str) {
        this.Sj.Sj(this.sP, this.vS, this.TKC.sP());
    }

    @Override // com.bytedance.adsdk.ugeno.EjP.EjP.Sj
    public boolean Sj(Object... objArr) {
        com.bytedance.adsdk.ugeno.EjP.Sj.Sj Fm = this.sP.Fm();
        if (Fm == null) {
            return false;
        }
        com.bytedance.adsdk.ugeno.EjP.Sj.TKC Sj = Fm.Sj(this.vS);
        this.Ym = Sj;
        if (Sj != null) {
            Sj.Sj(this);
            return false;
        }
        Fm.Sj(this.vS, new com.bytedance.adsdk.ugeno.EjP.Sj.sP());
        return false;
    }
}

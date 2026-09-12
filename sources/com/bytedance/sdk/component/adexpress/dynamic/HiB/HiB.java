package com.bytedance.sdk.component.adexpress.dynamic.HiB;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.HiB.sP;
import com.bytedance.sdk.component.adexpress.sP.Fmk;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class HiB {
    private Sj EjP;
    public com.bytedance.sdk.component.adexpress.dynamic.EjP.sP Sj;
    private com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq TKC;
    protected sP sP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class Sj {
        float Sj;
        float TKC;
        float sP;
    }

    public HiB(double d11, int i11, double d12, String str, Fmk fmk) {
        this.sP = new sP(d11, i11, d12, str, fmk);
    }

    private com.bytedance.sdk.component.adexpress.dynamic.EjP.uA Sj(com.bytedance.sdk.component.adexpress.dynamic.EjP.sP sPVar, com.bytedance.sdk.component.adexpress.dynamic.EjP.vS vSVar, float f11, float f12) {
        float f13;
        float f14;
        float f15 = sPVar.Sj;
        float f16 = sPVar.sP;
        float HS = vSVar.HS();
        float TFd = vSVar.TFd();
        float tz2 = vSVar.tz();
        float mZN = vSVar.mZN();
        boolean Chv = vSVar.Chv();
        boolean Bml = vSVar.Bml();
        boolean aNB = vSVar.aNB();
        boolean cX = vSVar.cX();
        String gY = vSVar.gY();
        float f17 = sPVar.TKC;
        float f18 = sPVar.EjP;
        if (TextUtils.equals(gY, "0")) {
            if (Chv) {
                f15 = sPVar.Sj + HS;
            } else if (Bml) {
                f15 = ((sPVar.Sj + f17) - tz2) - f11;
            }
            if (aNB) {
                f14 = sPVar.sP;
                f16 = f14 + TFd;
            } else if (cX) {
                f13 = sPVar.sP;
                f16 = ((f13 + f18) - mZN) - f12;
            }
        } else if (TextUtils.equals(gY, "1")) {
            f15 = sPVar.Sj + ((f17 - f11) / 2.0f);
            if (aNB) {
                f14 = sPVar.sP;
                f16 = f14 + TFd;
            } else if (cX) {
                f13 = sPVar.sP;
                f16 = ((f13 + f18) - mZN) - f12;
            }
        } else if (TextUtils.equals(gY, "2")) {
            f16 = sPVar.sP + ((f18 - f12) / 2.0f);
            if (Chv) {
                f15 = sPVar.Sj + HS;
            } else if (Bml) {
                f15 = ((sPVar.Sj + f17) - tz2) - f11;
            }
        } else if (TextUtils.equals(gY, "3")) {
            f15 = sPVar.Sj + ((f17 - f11) / 2.0f);
            f16 = sPVar.sP + ((f18 - f12) / 2.0f);
        }
        return new com.bytedance.sdk.component.adexpress.dynamic.EjP.uA(f15, f16);
    }

    private com.bytedance.sdk.component.adexpress.dynamic.EjP.uA Sj(com.bytedance.sdk.component.adexpress.dynamic.EjP.vS vSVar, sP.TKC tkc, sP.TKC tkc2) {
        float HS = vSVar.HS();
        float TFd = vSVar.TFd();
        float tz2 = vSVar.tz();
        float mZN = vSVar.mZN();
        boolean Chv = vSVar.Chv();
        boolean Bml = vSVar.Bml();
        boolean aNB = vSVar.aNB();
        boolean cX = vSVar.cX();
        if (!Chv) {
            if (Bml) {
                float f11 = this.EjP.Sj;
                HS = ((f11 != 0.0f ? Math.min(f11, tkc.Sj) : tkc.Sj) - tz2) - tkc2.Sj;
            } else {
                HS = 0.0f;
            }
        }
        if (!aNB) {
            if (cX) {
                float f12 = this.EjP.sP;
                if (f12 == 0.0f) {
                    f12 = tkc.sP;
                }
                TFd = (f12 - mZN) - tkc2.sP;
            } else {
                TFd = 0.0f;
            }
        }
        return new com.bytedance.sdk.component.adexpress.dynamic.EjP.uA(HS, TFd);
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x025c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.bytedance.sdk.component.adexpress.dynamic.EjP.sP Sj(com.bytedance.sdk.component.adexpress.dynamic.EjP.sP r37, float r38) {
        /*
            Method dump skipped, instructions count: 1013
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.HiB.HiB.Sj(com.bytedance.sdk.component.adexpress.dynamic.EjP.sP, float):com.bytedance.sdk.component.adexpress.dynamic.EjP.sP");
    }

    public void Sj() {
        this.sP.Sj();
    }

    public void Sj(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2, float f11, float f12) {
        if (dq2 != null) {
            this.TKC = dq2;
        }
        com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq3 = this.TKC;
        float Dq = dq3.Dq();
        float uA = dq3.uA();
        float f13 = TextUtils.equals(dq3.TEQ().HiB().ley(), "fixed") ? uA : 65536.0f;
        this.sP.Sj();
        this.sP.TKC(dq3, Dq, f13);
        sP.TKC Sj2 = this.sP.Sj(dq3);
        com.bytedance.sdk.component.adexpress.dynamic.EjP.sP sPVar = new com.bytedance.sdk.component.adexpress.dynamic.EjP.sP();
        sPVar.Sj = f11;
        sPVar.sP = f12;
        if (Sj2 != null) {
            Dq = Sj2.Sj;
        }
        sPVar.TKC = Dq;
        if (Sj2 != null) {
            uA = Sj2.sP;
        }
        sPVar.EjP = uA;
        sPVar.HiB = "root";
        sPVar.uA = 1280.0f;
        sPVar.vS = dq3;
        dq3.TKC(f11);
        sPVar.vS.EjP(sPVar.sP);
        sPVar.vS.HiB(sPVar.TKC);
        sPVar.vS.vS(sPVar.EjP);
        com.bytedance.sdk.component.adexpress.dynamic.EjP.sP Sj3 = Sj(sPVar, 0.0f);
        this.Sj = Sj3;
        Sj(Sj3);
    }

    public void Sj(com.bytedance.sdk.component.adexpress.dynamic.EjP.sP sPVar) {
        if (sPVar == null) {
            return;
        }
        sPVar.vS.TEQ().sP();
        List<List<com.bytedance.sdk.component.adexpress.dynamic.EjP.sP>> list = sPVar.Jcg;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (List<com.bytedance.sdk.component.adexpress.dynamic.EjP.sP> list2 : list) {
            if (list2 != null && list2.size() > 0) {
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.EjP.sP> it = list2.iterator();
                while (it.hasNext()) {
                    Sj(it.next());
                }
            }
        }
    }

    public void Sj(Sj sj2) {
        this.EjP = sj2;
    }
}

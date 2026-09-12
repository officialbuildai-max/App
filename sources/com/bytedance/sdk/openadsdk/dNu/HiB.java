package com.bytedance.sdk.openadsdk.dNu;

import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.sef;
import com.bytedance.sdk.openadsdk.core.uA;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class HiB implements EjP {
    private int EjP;
    private int HiB;
    long Sj = System.currentTimeMillis();
    private int TKC;
    private EjP sP;

    public HiB(EjP ejP, int i11, int i12, int i13) {
        this.sP = ejP;
        this.TKC = i11;
        this.EjP = i12;
        this.HiB = i13;
    }

    @Override // com.bytedance.sdk.openadsdk.dNu.EjP
    public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
        com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel = this.sP.generatorModel();
        generatorModel.Sj(BuildConfig.VERSION_NAME);
        generatorModel.Sj(this.TKC);
        generatorModel.sP(this.EjP);
        generatorModel.TKC(this.HiB);
        generatorModel.sP(this.Sj);
        generatorModel.vS(uA.sP().Jcg());
        generatorModel.EjP(sef.EjP());
        return generatorModel;
    }
}

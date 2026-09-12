package com.bytedance.sdk.component.HiB.HiB;

/* loaded from: classes2.dex */
public class EjP extends Sj {
    @Override // com.bytedance.sdk.component.HiB.HiB.uA
    public String Sj() {
        return "cache_policy";
    }

    @Override // com.bytedance.sdk.component.HiB.HiB.uA
    public void Sj(com.bytedance.sdk.component.HiB.TKC.TKC tkc) {
        com.bytedance.sdk.component.HiB.sP RiZ = tkc.RiZ();
        if (RiZ != null) {
            if (RiZ.HiB()) {
                tkc.Sj(new TEQ());
                return;
            } else if (RiZ.Jcg()) {
                tkc.Sj(new vS());
                return;
            }
        }
        tkc.Sj(new Ym());
    }
}

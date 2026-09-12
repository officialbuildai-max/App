package com.bytedance.sdk.component.HiB.HiB;

/* loaded from: classes2.dex */
public class sP implements uA {
    private byte[] Sj;
    private com.bytedance.sdk.component.HiB.vS sP;

    public sP(byte[] bArr, com.bytedance.sdk.component.HiB.vS vSVar) {
        this.Sj = bArr;
        this.sP = vSVar;
    }

    @Override // com.bytedance.sdk.component.HiB.HiB.uA
    public String Sj() {
        return "image_type";
    }

    @Override // com.bytedance.sdk.component.HiB.HiB.uA
    public void Sj(com.bytedance.sdk.component.HiB.TKC.TKC tkc) {
        uA hiB;
        int aa2 = tkc.aa();
        tkc.Sj(this.Sj.length);
        if (aa2 == 2) {
            hiB = com.bytedance.sdk.component.utils.vS.Sj(this.Sj) ? new HiB(this.Sj, this.sP) : this.sP == null ? new Ym() : new Dq(1001, "not image format", null);
        } else if (aa2 != 3) {
            boolean sP = com.bytedance.sdk.component.utils.vS.sP(this.Sj);
            hiB = sP ? new Fmk(this.Sj, this.sP, sP) : com.bytedance.sdk.component.utils.vS.Sj(this.Sj) ? new HiB(this.Sj, this.sP) : new Fmk(this.Sj, this.sP, sP);
        } else {
            byte[] bArr = this.Sj;
            hiB = new Fmk(bArr, this.sP, com.bytedance.sdk.component.utils.vS.sP(bArr));
        }
        tkc.Sj(hiB);
    }
}

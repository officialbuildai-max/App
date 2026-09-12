package com.bytedance.sdk.component.HiB.HiB;

import android.graphics.Bitmap;

/* loaded from: classes2.dex */
public class HiB extends Sj {
    private byte[] Sj;
    private com.bytedance.sdk.component.HiB.vS sP;

    public HiB(byte[] bArr, com.bytedance.sdk.component.HiB.vS vSVar) {
        this.Sj = bArr;
        this.sP = vSVar;
    }

    private void Sj(int i11, String str, Throwable th2, com.bytedance.sdk.component.HiB.TKC.TKC tkc) {
        if (this.sP == null) {
            tkc.Sj(new Ym());
        } else {
            tkc.Sj(new Dq(i11, str, th2));
        }
    }

    @Override // com.bytedance.sdk.component.HiB.HiB.uA
    public String Sj() {
        return "decode";
    }

    @Override // com.bytedance.sdk.component.HiB.HiB.uA
    public void Sj(com.bytedance.sdk.component.HiB.TKC.TKC tkc) {
        com.bytedance.sdk.component.HiB.TKC.vS TzV = tkc.TzV();
        com.bytedance.sdk.component.HiB.TKC.sP.Sj Sj = TzV.Sj(tkc);
        try {
            tkc.dx();
            Bitmap Sj2 = Sj.Sj(this.Sj);
            if (Sj2 == null) {
                Sj(1002, "decode failed bitmap null", null, tkc);
                return;
            }
            tkc.Sj(new Fmk(Sj2, this.sP, false));
            TzV.Sj(tkc.RiZ()).Sj(tkc.TEQ(), Sj2);
        } catch (Throwable th2) {
            Sj(1002, "decode failed:" + th2.getMessage(), th2, tkc);
        }
    }
}

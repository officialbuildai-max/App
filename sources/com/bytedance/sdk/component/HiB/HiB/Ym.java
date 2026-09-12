package com.bytedance.sdk.component.HiB.HiB;

/* loaded from: classes2.dex */
public class Ym extends Sj {
    private void Sj(int i11, String str, Throwable th2, com.bytedance.sdk.component.HiB.TKC.TKC tkc) {
        tkc.Sj(new Dq(i11, str, th2));
    }

    @Override // com.bytedance.sdk.component.HiB.HiB.uA
    public String Sj() {
        return "net_request";
    }

    @Override // com.bytedance.sdk.component.HiB.HiB.uA
    public void Sj(final com.bytedance.sdk.component.HiB.TKC.TKC tkc) {
        final com.bytedance.sdk.component.HiB.TKC.vS TzV = tkc.TzV();
        com.bytedance.sdk.component.HiB.EjP EjP = TzV.EjP();
        tkc.Sj(false);
        try {
            com.bytedance.sdk.component.HiB.vS Sj = EjP.Sj(new com.bytedance.sdk.component.HiB.sP.sP(tkc.Sj(), tkc.Fmk(), tkc.sef(), tkc.dx()));
            int sP = Sj.sP();
            tkc.Sj(Sj.Sj());
            if (Sj.sP() != 200) {
                String.valueOf(Sj);
                Object TKC = Sj.TKC();
                Sj(sP, Sj.EjP(), TKC instanceof Throwable ? (Throwable) TKC : null, tkc);
                return;
            }
            final byte[] bArr = (byte[]) Sj.TKC();
            tkc.Sj(new sP(bArr, Sj));
            final String uA = tkc.uA();
            final com.bytedance.sdk.component.HiB.sP RiZ = tkc.RiZ();
            if (RiZ.HiB()) {
                TzV.sP(tkc.RiZ()).Sj(uA, bArr);
            }
            TzV.Jcg().submit(new Runnable() { // from class: com.bytedance.sdk.component.HiB.HiB.Ym.1
                @Override // java.lang.Runnable
                public void run() {
                    if (RiZ.Jcg()) {
                        TzV.TKC(tkc.RiZ()).Sj(uA, bArr);
                    }
                }
            });
        } catch (Throwable th2) {
            Sj(1004, "net request failed!", th2, tkc);
        }
    }
}

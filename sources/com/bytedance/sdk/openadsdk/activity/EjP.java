package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.bytedance.sdk.component.utils.ib;
import com.bytedance.sdk.openadsdk.EjP.HiB.sP.Zq;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.core.model.TzV;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.core.model.uP;

/* loaded from: classes2.dex */
public class EjP extends Sj {
    int HiB;
    private boolean vS;

    public EjP(sP sPVar, sU sUVar, int i11) {
        super(sPVar, sUVar, i11);
    }

    private void HiB(int i11) {
        this.TKC.Mts.Sj(null, new SpannableStringBuilder(String.format(ib.Sj(dNu.Sj(), "tt_skip_ad_time_text"), Integer.valueOf(i11))));
    }

    private boolean Sj(sU sUVar) {
        return sUVar == null || sUVar.tY() == 100.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TKC(int i11) {
        sU sUVar;
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.TKC;
        int RiZ = (sj2 == null || (sUVar = sj2.sP) == null) ? sj2 != null ? dNu.EjP().RiZ(String.valueOf(this.TKC.vS)) : 5 : sUVar.Sj();
        if (!dNu.EjP().vS(String.valueOf(this.TKC.vS)) || (!sU.HiB(this.TKC.sP) && !this.TKC.TKC)) {
            if (i11 >= RiZ) {
                com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj3 = this.TKC;
                if (!sj3.gY) {
                    sj3.Sj(true);
                }
                sP();
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj4 = this.TKC;
        if (!sj4.gY) {
            sj4.Sj(true);
        }
        if (i11 > RiZ) {
            sP();
        } else {
            HiB(RiZ - i11);
            this.TKC.Mts.HiB(false);
        }
    }

    private boolean sP(sU sUVar) {
        if (sUVar == null) {
            return false;
        }
        return dNu.EjP().sU(String.valueOf(this.TKC.vS));
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Sj
    protected void Jcg() {
        Yf();
        if (this.Dq.EjP()) {
            this.TKC.wE.TEQ();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Sj, com.bytedance.sdk.openadsdk.core.aa.EjP.sP
    public void Sj(Bundle bundle) {
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0058  */
    @Override // com.bytedance.sdk.openadsdk.core.aa.EjP.sP
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean Sj(long r10, boolean r12) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.EjP.Sj(long, boolean):boolean");
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Sj
    protected void TKC() {
        final View TEQ = this.TKC.Wjd.TEQ();
        if (TEQ != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.EjP.1
                /* JADX WARN: Removed duplicated region for block: B:21:0x00d7 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:22:0x00d8  */
                @Override // android.view.View.OnClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void onClick(android.view.View r5) {
                    /*
                        Method dump skipped, instructions count: 249
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.EjP.AnonymousClass1.onClick(android.view.View):void");
                }
            };
            TEQ.setOnClickListener(onClickListener);
            TEQ.setTag(TEQ.getId(), onClickListener);
        }
        this.TKC.Mts.Sj(new com.bytedance.sdk.openadsdk.component.reward.top.sP() { // from class: com.bytedance.sdk.openadsdk.activity.EjP.2
            @Override // com.bytedance.sdk.openadsdk.component.reward.top.sP
            public void Sj(View view) {
                if (uP.Dq(EjP.this.TKC.sP) && (uP.TzV(EjP.this.TKC.sP) || EjP.this.TKC.TEQ.get())) {
                    if (EjP.this.TKC.uP.Sj()) {
                        EjP.this.TKC.uP.Sj(5);
                        return;
                    } else {
                        EjP.this.TKC.JcM.Dq();
                        return;
                    }
                }
                if (uP.TzV(EjP.this.TKC.sP) || (TzV.Sj(EjP.this.TKC.sP) && !EjP.this.TKC.uvD.get())) {
                    if (!uP.Dq(EjP.this.TKC.sP) && EjP.this.TKC.uP.Sj()) {
                        EjP.this.TKC.uP.Sj(4);
                    }
                    EjP.this.ley();
                    return;
                }
                if (EjP.this.TKC.sP.yr()) {
                    if (EjP.this.TKC.Wjd.Ym() != null) {
                        EjP.this.TKC.sP.xD(2);
                        EjP.this.TKC.Wjd.dNu();
                        return;
                    }
                    return;
                }
                com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = EjP.this.TKC;
                if (!sj2.TKC && sj2.sP.Snq() && !EjP.this.TKC.sP.Ph()) {
                    EjP.this.TKC.sP.xD(13);
                    try {
                        EjP.this.TKC.Wjd.dNu();
                        return;
                    } catch (Exception unused) {
                    }
                }
                Zq.Sj sj3 = new Zq.Sj();
                sj3.Sj(EjP.this.TKC.f21074ib.Jcg());
                sj3.TKC(EjP.this.TKC.f21074ib.sU());
                sj3.sP(EjP.this.TKC.f21074ib.Ym());
                sj3.TKC(3);
                sj3.EjP(EjP.this.TKC.f21074ib.RiZ());
                com.bytedance.sdk.openadsdk.EjP.HiB.Sj.Sj.Sj(EjP.this.TKC.f21074ib.TKC(), sj3, EjP.this.TKC.f21074ib.Sj());
                com.bytedance.sdk.openadsdk.core.ib.TKC(EjP.this.TKC.vS);
                EjP.this.TKC.f21074ib.Sj("skip", false);
                EjP.this.TKC.Mts.EjP(false);
                EjP ejP = EjP.this;
                if (ejP.TKC.TKC) {
                    ejP.Sj(true, 4);
                } else {
                    ejP.ley();
                }
                sU sUVar = EjP.this.TKC.sP;
                if (sUVar != null && sUVar.GMp() != null) {
                    com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj4 = EjP.this.TKC;
                    if (sj4.f21074ib != null) {
                        sj4.sP.GMp().Sj().vS(EjP.this.TKC.f21074ib.Jcg());
                        EjP.this.TKC.sP.GMp().Sj().HiB(EjP.this.TKC.f21074ib.Jcg());
                    }
                }
                com.bytedance.sdk.openadsdk.kF.sP.HiB.Sj(EjP.this.TKC.sP, 5);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.sP
            public void Sj(View view, String str) {
                EjP ejP = EjP.this;
                ejP.TKC.ndK = !r0.ndK;
                com.bytedance.sdk.openadsdk.component.reward.sP.sP sPVar = ejP.sP;
                if (sPVar != null && sPVar.EjP() != null) {
                    EjP.this.sP.EjP().Sj(EjP.this.TKC.ndK);
                }
                com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = EjP.this.TKC;
                sj2.f21074ib.Sj(sj2.ndK, str);
                if (!uP.RiZ(EjP.this.TKC.sP) || EjP.this.TKC.TEQ.get()) {
                    com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj3 = EjP.this.TKC;
                    sj3.JcM.HiB(sj3.ndK);
                    sU sUVar = EjP.this.TKC.sP;
                    if (sUVar == null || sUVar.GMp() == null || EjP.this.TKC.sP.GMp().Sj() == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj4 = EjP.this.TKC;
                    if (sj4.f21074ib != null) {
                        if (sj4.ndK) {
                            sj4.sP.GMp().Sj().Dq(EjP.this.TKC.f21074ib.Jcg());
                        } else {
                            sj4.sP.GMp().Sj().uA(EjP.this.TKC.f21074ib.Jcg());
                        }
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.sP
            public void TKC(View view) {
                View view2 = TEQ;
                if (view2 != null) {
                    view2.performClick();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.sP
            public void sP(View view) {
                EjP ejP = EjP.this;
                ejP.TKC.LD.Sj(ejP.sP);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Sj, com.bytedance.sdk.openadsdk.activity.vS
    public void TKC(Activity activity) {
        super.TKC(activity);
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.TKC;
        if (sj2 == null || !sP(sj2.sP) || Sj(this.TKC.sP)) {
            return;
        }
        if (this.vS) {
            this.vS = false;
            ley();
        } else if (this.TKC.JcM.WMZ()) {
            ley();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vS
    protected boolean a_() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vS
    public String b_() {
        return "fullscreen_interstitial_ad";
    }

    @Override // com.bytedance.sdk.openadsdk.core.aa.EjP.sP
    public void c_() {
        if (this.TKC.sP.tY() != 100.0f) {
            this.vS = true;
        }
        LD();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Sj
    public void sP() {
        if (!sU.HiB(this.TKC.sP)) {
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.TKC;
            if (!sj2.TKC) {
                sj2.Mts.Sj(null, "X");
                this.TKC.Mts.HiB(true);
            }
        }
        this.TKC.Mts.Sj(null, TTAdDislikeToast.getSkipText());
        this.TKC.Mts.HiB(true);
    }
}

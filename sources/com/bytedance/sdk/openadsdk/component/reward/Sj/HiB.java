package com.bytedance.sdk.openadsdk.component.reward.Sj;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.EjP.sP;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.Yf;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.core.model.uP;
import com.bytedance.sdk.openadsdk.utils.FPG;
import com.bytedance.sdk.openadsdk.utils.dx;
import com.google.logging.type.LogSeverity;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class HiB {
    private final com.bytedance.sdk.openadsdk.component.reward.Sj.Sj Sj;
    private Sj TKC;
    private final com.bytedance.sdk.openadsdk.component.reward.view.vS sP;

    /* loaded from: classes2.dex */
    public interface Sj {
        void Sj(boolean z10, boolean z11, boolean z12, com.bytedance.sdk.openadsdk.component.reward.sP.sP sPVar, int i11);

        void uvD();
    }

    public HiB(com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2) {
        this.Sj = sj2;
        this.sP = new com.bytedance.sdk.openadsdk.component.reward.view.vS(sj2);
    }

    private int Dq() {
        int gq2 = this.Sj.sP.gq();
        if (gq2 <= 5000 && gq2 >= 0) {
            if (gq2 < 1000) {
                gq2 += 1000;
            }
            int Sj2 = com.bytedance.sdk.openadsdk.core.dNu.EjP().Sj(this.Sj.sP.If());
            if (Sj2 <= 5000 && Sj2 >= 0) {
                if (Sj2 < 1000) {
                    Sj2 += 1000;
                }
                return Math.min(gq2, Sj2);
            }
        }
        return -1;
    }

    private boolean sP(boolean z10) {
        com.bytedance.sdk.openadsdk.component.reward.view.sP Sj2;
        if (!com.bytedance.sdk.openadsdk.core.model.TzV.TKC(this.Sj.sP) || (Sj2 = this.Sj.wE.Sj()) == null || Sj2.EjP != 0 || z10) {
            return true;
        }
        this.Sj.Mts.TKC(false);
        return false;
    }

    private void uA() {
        if (uP.RiZ(this.Sj.sP)) {
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.Sj;
            if (sj2.ndK) {
                sj2.Mts.sP(true);
                this.Sj.uP.HiB(true);
            }
        }
    }

    public void EjP() {
        Sj(true);
    }

    public boolean HiB() {
        com.bytedance.sdk.openadsdk.component.reward.view.vS vSVar = this.sP;
        if (vSVar != null) {
            return vSVar.HiB();
        }
        return false;
    }

    public boolean Jcg() {
        return this.sP.vS();
    }

    public void Sj() {
        this.sP.Sj();
    }

    public void Sj(Sj sj2) {
        this.TKC = sj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Sj(com.bytedance.sdk.openadsdk.component.reward.sP.sP sPVar) {
        this.Sj.JcM.Sj(0.0f);
        this.Sj.Wjd.Sj(0.0f);
        if (sU.TKC(this.Sj.sP)) {
            this.Sj.JcM.Sj(8);
            this.Sj.WMZ.Sj(0);
            this.Sj.WMZ.Jcg();
        } else {
            this.Sj.WMZ.Sj(8);
            this.Sj.JcM.Sj(0);
            this.Sj.JcM.jb();
        }
        if (this.Sj.Jcg) {
            FPG.Sj((View) sPVar.sef, 0);
            this.Sj.Wjd.HiB(8);
        }
        this.Sj.Wjd.TKC(8);
        this.Sj.Wjd.Jcg();
        if (sU.TKC(this.Sj.sP)) {
            this.Sj.HpB.sendEmptyMessageDelayed(LogSeverity.EMERGENCY_VALUE, 100L);
            return;
        }
        this.Sj.HpB.sendEmptyMessageDelayed(500, 100L);
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.Sj;
        sj2.JcM.Sj(sj2.ndK, true);
        this.Sj.JcM.TKC(true);
        this.Sj.JcM.sP(true);
        Yf aa2 = this.Sj.JcM.aa();
        if (aa2 != null) {
            aa2.Sj("prerender_page_show", (JSONObject) null);
        }
    }

    public void Sj(com.bytedance.sdk.openadsdk.core.sP.HiB hiB) {
        this.sP.Sj(hiB);
    }

    public void Sj(boolean z10) {
        if (!sU.EjP(this.Sj.sP)) {
            this.Sj.JcM.Sj(false, TTAdConstant.DOWNLOAD_URL_CODE, "end_card_timeout");
        }
        this.Sj.JcM.fF();
        this.Sj.JcM.Sj(8);
        this.Sj.WMZ.Sj(8);
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.Sj;
        if (sj2.Jcg) {
            FPG.Sj((View) sj2.f21076kb.sef, 8);
            this.Sj.Wjd.HiB(0);
        }
        this.Sj.Wjd.TKC(8);
        if (!this.Sj.sP.Ph()) {
            com.bytedance.sdk.openadsdk.activity.vS vSVar = this.Sj.HS;
            if (vSVar != null) {
                this.sP.Sj(vSVar.uP().Dq());
            }
            this.sP.sP();
        } else if (!this.sP.Sj(this.Sj.f21074ib)) {
            this.Sj.Fm.finish();
        }
        this.Sj.Wjd.Jcg();
        if (z10) {
            TKC(this.Sj.f21076kb);
        }
        this.Sj.Mts.TKC(false);
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj3 = this.Sj;
        sj3.LqL.Sj(sj3.sP.TT());
    }

    public void Sj(boolean z10, com.bytedance.sdk.openadsdk.component.reward.sP.sP sPVar) {
        Zq zq2;
        if (uP.TzV(this.Sj.sP)) {
            return;
        }
        this.Sj.TzV.set(z10);
        sPVar.sef();
        if (this.Sj.sP.Ph()) {
            this.Sj.Mts.EjP(false);
        } else {
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.Sj;
            sj2.Mts.EjP(uP.TzV(sj2.sP));
        }
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj3 = this.Sj;
        sj3.Mts.TKC(uP.Jcg(sj3.sP));
        if (this.Sj.sP.EjP() && uP.Jcg(this.Sj.sP) && z10) {
            this.Sj.Mts.EjP(true);
        }
        this.Sj.JcM.Yf();
        com.bytedance.sdk.openadsdk.core.model.TzV tzV = this.Sj.Wjd.Zq;
        if (tzV != null) {
            tzV.HiB();
        }
        this.Sj.Wjd.TKC();
        com.bytedance.sdk.openadsdk.component.reward.view.Dq dq2 = this.Sj.wE;
        if (dq2 != null) {
            dq2.vS();
        }
        Dq dq3 = this.Sj.uP;
        if (dq3 != null) {
            dq3.Jcg(Dq.sP);
        }
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj4 = this.Sj;
        if (!TextUtils.isEmpty(sU.Sj(sj4.Ei, sj4.sP))) {
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj5 = this.Sj;
            dx.Sj(sj5.Fm, uP.Fmk(sj5.sP), this.Sj.sP, sP.Sj.TKC);
            return;
        }
        if (sU.TKC(this.Sj.sP) && (zq2 = this.Sj.WMZ) != null) {
            zq2.vS();
        }
        if (!sU.Sj(this.Sj.sP) && (sU.TKC(this.Sj.sP) || !this.Sj.JcM.Fm())) {
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj6 = this.Sj;
            if (sU.Sj(sj6.sP, sj6.JcM.TzV(), this.Sj.JcM.HpB(), this.Sj.WMZ.aa(), this.Sj.JcM.LD()) || uP.Jcg(this.Sj.sP)) {
                if (!sU.EjP(this.Sj.sP) && !uP.Jcg(this.Sj.sP) && !sU.TKC(this.Sj.sP)) {
                    this.Sj.JcM.Sj(true, 0, (String) null);
                }
                if (!uP.Jcg(this.Sj.sP)) {
                    TKC(sPVar);
                } else {
                    if (uP.ib(this.Sj.sP) && !this.Sj.JcM.Wjd()) {
                        if (!this.Sj.JcM.TzV()) {
                            if (this.Sj.uP.EjP() != null) {
                                this.Sj.uP.EjP().Sj(2);
                            }
                            this.Sj.uP.HiB();
                            return;
                        } else {
                            if (this.Sj.uP.EjP() != null) {
                                this.Sj.uP.EjP().Sj(-1);
                            }
                            this.Sj.uP.vS();
                            this.Sj.Mts.EjP(false);
                            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj7 = this.Sj;
                            sj7.uP.Sj(sj7.LqL.HiB());
                            return;
                        }
                    }
                    if (this.Sj.JcM.Wjd() && this.Sj.uP.EjP() != null) {
                        this.Sj.uP.EjP().Sj(1);
                    }
                    sP(sPVar);
                }
                Sj(sPVar);
                return;
            }
        }
        EjP();
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x0124, code lost:
    
        if (r1.kF() == false) goto L68;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Sj(boolean r11, boolean r12, boolean r13, com.bytedance.sdk.openadsdk.component.reward.sP.sP r14, int r15) {
        /*
            Method dump skipped, instructions count: 510
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.Sj.HiB.Sj(boolean, boolean, boolean, com.bytedance.sdk.openadsdk.component.reward.sP.sP, int):void");
    }

    public void TKC() {
        this.sP.EjP();
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0072, code lost:
    
        if (com.bytedance.sdk.openadsdk.core.model.uP.uA(r5.Sj.sP) == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean TKC(com.bytedance.sdk.openadsdk.component.reward.sP.sP r6) {
        /*
            r5 = this;
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r0 = r5.Sj
            int r1 = r5.Dq()
            r0.Dq = r1
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r0 = r5.Sj
            int r1 = r0.Dq
            com.bytedance.sdk.openadsdk.core.model.sU r0 = r0.sP
            boolean r0 = r0.uA()
            r1 = 0
            if (r0 != 0) goto La4
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r0 = r5.Sj
            int r2 = r0.Dq
            r3 = -1
            r4 = 1
            if (r2 != r3) goto L50
            com.bytedance.sdk.openadsdk.core.model.sU r0 = r0.sP
            boolean r0 = com.bytedance.sdk.openadsdk.core.model.uP.Dq(r0)
            if (r0 == 0) goto L33
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r0 = r5.Sj
            com.bytedance.sdk.openadsdk.component.reward.Sj.TzV r0 = r0.JcM
            boolean r0 = r0.TzV()
            if (r0 == 0) goto L33
            r6.kF()
            goto L75
        L33:
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r0 = r5.Sj
            com.bytedance.sdk.openadsdk.core.model.sU r0 = r0.sP
            boolean r0 = com.bytedance.sdk.openadsdk.core.model.uP.TEQ(r0)
            if (r0 == 0) goto L4b
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r0 = r5.Sj
            com.bytedance.sdk.openadsdk.component.reward.Sj.TzV r0 = r0.JcM
            boolean r0 = r0.TzV()
            if (r0 == 0) goto L4b
            r6.kF()
            goto L75
        L4b:
            r6.Zq()
        L4e:
            r6 = r4
            goto L76
        L50:
            if (r2 < 0) goto L75
            java.util.concurrent.atomic.AtomicBoolean r6 = r0.f21073dx
            r6.set(r1)
            android.os.Message r6 = android.os.Message.obtain()
            r0 = 700(0x2bc, float:9.81E-43)
            r6.what = r0
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r0 = r5.Sj
            int r2 = r0.Dq
            r6.arg1 = r2
            com.bytedance.sdk.component.utils.LqL r0 = r0.HpB
            r0.sendMessage(r6)
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r6 = r5.Sj
            com.bytedance.sdk.openadsdk.core.model.sU r6 = r6.sP
            boolean r6 = com.bytedance.sdk.openadsdk.core.model.uP.uA(r6)
            if (r6 != 0) goto L75
            goto L4e
        L75:
            r6 = r1
        L76:
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r0 = r5.Sj
            com.bytedance.sdk.openadsdk.component.reward.Sj.TzV r0 = r0.JcM
            boolean r0 = r0.wE()
            if (r0 == 0) goto L81
            goto L82
        L81:
            r1 = r6
        L82:
            if (r1 == 0) goto La3
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r6 = r5.Sj
            com.bytedance.sdk.openadsdk.utils.Fmk r0 = r6.f21078xu
            if (r0 == 0) goto La3
            boolean r0 = r6.Ir
            if (r0 == 0) goto L99
            com.bytedance.sdk.openadsdk.activity.vS r6 = r6.HS
            if (r6 == 0) goto L99
            boolean r6 = r6.kF()
            if (r6 != 0) goto L99
            return r4
        L99:
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r6 = r5.Sj
            com.bytedance.sdk.openadsdk.utils.Fmk r0 = r6.f21078xu
            int r6 = r6.Dq
            long r1 = (long) r6
            r0.Sj(r1)
        La3:
            return r4
        La4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.Sj.HiB.TKC(com.bytedance.sdk.openadsdk.component.reward.sP.sP):boolean");
    }

    public void sP() {
        this.sP.TKC();
    }

    public void sP(com.bytedance.sdk.openadsdk.component.reward.sP.sP sPVar) {
        int mj2 = this.Sj.sP.mj();
        if (uP.TzV(this.Sj.sP)) {
            mj2 = (this.Sj.sP.oWa() + 1) * 1000;
        }
        if (mj2 == -1) {
            if (uP.Dq(this.Sj.sP)) {
                if (uP.ib(this.Sj.sP) && this.Sj.uP.Jcg()) {
                    sPVar.Zq();
                    return;
                } else {
                    sPVar.kF();
                    return;
                }
            }
            sPVar.Zq();
        } else {
            if (mj2 < 0) {
                return;
            }
            this.Sj.Mts.EjP(false);
            if (!uP.Dq(this.Sj.sP)) {
                this.Sj.HpB.sendEmptyMessageDelayed(600, mj2);
            } else {
                if (!uP.ib(this.Sj.sP) || !this.Sj.uP.Jcg()) {
                    this.Sj.HpB.sendEmptyMessageDelayed(1, mj2);
                    return;
                }
                this.Sj.HpB.sendEmptyMessageDelayed(600, mj2);
            }
        }
        com.bytedance.sdk.openadsdk.utils.Fmk fmk = this.Sj.f21078xu;
        if (fmk != null) {
            fmk.Sj(mj2);
        }
    }

    public Sj vS() {
        return this.TKC;
    }
}

package com.bytedance.sdk.openadsdk.component.reward.Sj;

import android.app.Activity;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.core.model.uP;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class TEQ {
    protected final Activity Dq;
    protected boolean Fmk;
    protected volatile boolean Jcg;
    protected final String TEQ;
    protected AtomicBoolean TzV = new AtomicBoolean(false);
    protected final Sj Ym;
    protected boolean Zq;

    /* renamed from: aa, reason: collision with root package name */
    protected boolean f21079aa;
    protected com.bytedance.sdk.openadsdk.sU.Sj.Sj dNu;
    protected boolean sef;

    @NonNull
    protected final sU uA;
    protected FrameLayout uvD;

    public TEQ(Sj sj2) {
        this.Ym = sj2;
        this.Dq = sj2.Fm;
        this.TEQ = sj2.HiB;
        sU sUVar = sj2.sP;
        this.uA = sUVar;
        this.Fmk = uP.HiB(sUVar);
    }

    private void Jcg() {
        int mj2 = this.uA.mj();
        if (mj2 == -1) {
            if (uP.uA(this.uA)) {
                com.bytedance.sdk.openadsdk.sU.Sj.Sj sj2 = this.dNu;
                if (sj2 == null || !sj2.HiB()) {
                    this.Ym.f21076kb.kF();
                    return;
                } else {
                    this.Ym.RiZ.set(true);
                    this.Ym.f21076kb.Zq();
                }
            } else {
                this.Ym.RiZ.set(true);
                this.Ym.f21076kb.Zq();
            }
        } else {
            if (mj2 < 0) {
                return;
            }
            this.Ym.Mts.EjP(false);
            if (uP.uA(this.uA)) {
                com.bytedance.sdk.openadsdk.sU.Sj.Sj sj3 = this.dNu;
                if (sj3 == null || !sj3.HiB()) {
                    this.Ym.HpB.sendEmptyMessageDelayed(1, mj2);
                    return;
                }
                this.Ym.HpB.sendEmptyMessageDelayed(600, mj2);
            } else {
                this.Ym.HpB.sendEmptyMessageDelayed(600, mj2);
            }
        }
        com.bytedance.sdk.openadsdk.utils.Fmk fmk = this.Ym.f21078xu;
        if (fmk != null) {
            fmk.Sj(mj2);
        }
    }

    public void Dq() {
    }

    public void EjP() {
        com.bytedance.sdk.openadsdk.sU.Sj.Sj sj2;
        if (!this.Fmk || this.TzV.get() || (sj2 = this.dNu) == null) {
            return;
        }
        sj2.sP();
    }

    public void HiB() {
        com.bytedance.sdk.openadsdk.sU.Sj.Sj sj2;
        if (!this.Fmk || this.TzV.get() || (sj2 = this.dNu) == null) {
            return;
        }
        sj2.TKC();
    }

    public void Sj() {
        if (this.Fmk && !this.f21079aa) {
            this.f21079aa = true;
        }
    }

    public void Sj(int i11) {
    }

    public void Sj(long j11) {
    }

    public void Sj(com.bytedance.sdk.openadsdk.core.sP.HiB hiB) {
        com.bytedance.sdk.openadsdk.sU.Sj.Sj sj2;
        if (this.Fmk && (sj2 = this.dNu) != null) {
            sj2.Sj(hiB);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Sj(boolean z10) {
        FrameLayout frameLayout = this.uvD;
        if (frameLayout != null) {
            Sj sj2 = this.Ym;
            com.bytedance.sdk.openadsdk.sU.Sj.Sj sj3 = new com.bytedance.sdk.openadsdk.sU.Sj.Sj(sj2.Ei, this.uA, sj2.sdp, z10, frameLayout);
            this.dNu = sj3;
            sj3.Sj(this.Ym.f21075jb);
            this.dNu.Sj(true, sP());
        }
    }

    public boolean TEQ() {
        return this.Jcg;
    }

    public void TKC() {
        if (this.Fmk) {
            this.Jcg = true;
            TKC(this.Ym.ndK);
            this.dNu.Sj();
            Jcg();
            if (uP.TEQ(this.uA)) {
                this.Ym.JcM.vS();
            }
        }
    }

    public void TKC(boolean z10) {
        if (this.Fmk && this.dNu != null && this.Jcg) {
            this.dNu.Sj(z10);
        }
    }

    public void Ym() {
        if (!this.TzV.compareAndSet(false, true)) {
            this.Ym.JcM.uA();
            return;
        }
        com.bytedance.sdk.openadsdk.sU.Sj.Sj sj2 = this.dNu;
        if (sj2 != null) {
            sj2.Sj(true);
        }
        this.Ym.JcM.Jcg(true);
        Sj sj3 = this.Ym;
        sj3.FPG.Sj(true, sj3.f21076kb);
        if (this.Ym.FPG.Jcg()) {
            this.Ym.f21078xu.Sj(r0.Dq);
            return;
        }
        Sj sj4 = this.Ym;
        sj4.JcM.Sj(sj4.ndK, true);
        this.Ym.JcM.TKC(true);
        this.Ym.JcM.sP(true);
        this.Ym.HpB.removeMessages(600);
    }

    protected com.bytedance.sdk.openadsdk.aa.vS sP() {
        return new com.bytedance.sdk.openadsdk.aa.vS() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.TEQ.1
            @Override // com.bytedance.sdk.openadsdk.aa.vS
            public void Sj() {
                TEQ.this.Ym.f21075jb.Sj(false);
            }
        };
    }

    public void sP(boolean z10) {
        if (this.Fmk) {
            Sj sj2 = this.Ym;
            if (sj2.xhi) {
                this.uvD = (FrameLayout) sj2.xD.findViewById(com.bytedance.sdk.openadsdk.utils.Zq.yfI);
                Sj(z10);
            }
        }
    }

    public boolean uA() {
        return false;
    }

    public void vS() {
        if (this.Fmk && !this.Zq) {
            this.Zq = true;
            com.bytedance.sdk.openadsdk.sU.Sj.Sj sj2 = this.dNu;
            if (sj2 != null) {
                sj2.EjP();
            }
            FrameLayout frameLayout = this.uvD;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        }
    }
}

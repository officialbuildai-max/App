package com.bytedance.sdk.openadsdk.component.reward.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.Dq.RiZ;
import com.bytedance.sdk.openadsdk.core.Dq.ib;
import com.bytedance.sdk.openadsdk.core.Dq.sef;
import com.bytedance.sdk.openadsdk.core.Dq.uvD;
import com.bytedance.sdk.openadsdk.core.model.dx;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.kF.sP.HiB;
import com.bytedance.sdk.openadsdk.utils.FPG;
import com.bytedance.sdk.openadsdk.utils.JcM;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class sP extends RiZ {
    public static float Sj = 100.0f;
    public int EjP;
    private final com.bytedance.sdk.openadsdk.component.reward.Sj.Sj HiB;
    uvD TKC;
    sef sP;
    private float vS;

    public sP(com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2, AdSlot adSlot, String str) {
        super(sj2.Fm, sj2.sP, adSlot, str, sj2.ndK, !sj2.gR);
        this.EjP = 1;
        this.vS = -1.0f;
        this.HiB = sj2;
    }

    private void Jcg() {
        setBackupListener(new com.bytedance.sdk.component.adexpress.sP.TKC() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.sP.2
            @Override // com.bytedance.sdk.component.adexpress.sP.TKC
            public boolean Sj(ViewGroup viewGroup, int i11) {
                try {
                    ((RiZ) viewGroup).aa();
                    sP.this.TKC = new uvD(viewGroup.getContext());
                    sP sPVar = sP.this;
                    sPVar.TKC.Sj(((RiZ) sPVar).Ym, (RiZ) viewGroup, sP.this.HiB.xD);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TKC(com.bytedance.sdk.component.adexpress.sP.sef sefVar) {
        if (sefVar == null) {
            return;
        }
        double vS = sefVar.vS();
        double Jcg = sefVar.Jcg();
        double Dq = sefVar.Dq();
        double uA = sefVar.uA();
        int sP = FPG.sP(this.Dq, (float) vS);
        int sP2 = FPG.sP(this.Dq, (float) Jcg);
        int sP3 = FPG.sP(this.Dq, (float) Dq);
        int sP4 = FPG.sP(this.Dq, (float) uA);
        if ((uA != 0.0d && Dq != 0.0d) || this.Yf.TKC() == 7 || this.Yf.TKC() == 10) {
            if ((this.Yf.TKC() == 7 || this.Yf.TKC() == 10) && (sefVar instanceof com.bytedance.sdk.openadsdk.core.TEQ.HiB.sP)) {
                FrameLayout uvD = ((com.bytedance.sdk.openadsdk.core.TEQ.HiB.sP) sefVar).uvD();
                if (uvD != null) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    layoutParams.gravity = 17;
                    uvD.addView(this.f21096aa, layoutParams);
                    return;
                }
                return;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f21096aa.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(sP3, sP4);
            }
            layoutParams2.width = sP3;
            layoutParams2.height = sP4;
            layoutParams2.topMargin = sP2;
            layoutParams2.leftMargin = sP;
            layoutParams2.setMarginStart(sP);
            layoutParams2.setMarginEnd(layoutParams2.rightMargin);
            this.f21096aa.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Dq.RiZ, com.bytedance.sdk.openadsdk.core.Dq.sef
    public int EjP() {
        sef sefVar = this.sP;
        if (sefVar != null) {
            return sefVar.EjP();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Dq.RiZ, com.bytedance.sdk.openadsdk.core.Dq.sef
    public void HiB() {
        sef sefVar = this.sP;
        if (sefVar != null) {
            sefVar.HiB();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Dq.RiZ, com.bytedance.sdk.openadsdk.core.Dq.sef
    public void Sj() {
        sef sefVar = this.sP;
        if (sefVar != null) {
            sefVar.Sj();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Dq.RiZ, com.bytedance.sdk.openadsdk.core.Dq.sef
    public void Sj(int i11) {
        sef sefVar = this.sP;
        if (sefVar != null) {
            sefVar.Sj(i11);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Dq.RiZ, com.bytedance.sdk.openadsdk.core.Dq.sef
    public void Sj(int i11, com.bytedance.sdk.component.adexpress.sP.sef sefVar) {
        sef sefVar2 = this.sP;
        if (sefVar2 != null) {
            sefVar2.Sj(i11, sefVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Dq.RiZ, com.bytedance.sdk.openadsdk.core.Dq.sef
    public void Sj(int i11, String str) {
        sef sefVar = this.sP;
        if (sefVar != null) {
            sefVar.Sj(i11, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Dq.RiZ, com.bytedance.sdk.component.adexpress.sP.Dq
    public void Sj(View view, int i11, com.bytedance.sdk.component.adexpress.TKC tkc) {
        if (i11 == -1 || tkc == null || i11 != 3) {
            super.Sj(view, i11, tkc);
        } else {
            HiB();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Dq.RiZ, com.bytedance.sdk.component.adexpress.sP.Zq
    public void Sj(com.bytedance.sdk.component.adexpress.sP.EjP<? extends View> ejP, com.bytedance.sdk.component.adexpress.sP.sef sefVar) {
        this.Yf = ejP;
        sU sUVar = this.Ym;
        if (sUVar != null && sUVar.Fqk()) {
            super.Sj(ejP, sefVar);
            return;
        }
        if (ejP instanceof ib) {
            ib ibVar = (ib) ejP;
            if (ibVar.uvD() != null) {
                ibVar.uvD().Sj((sef) this);
            }
        }
        if (sefVar != null && sefVar.TKC()) {
            sP(sefVar);
            this.EjP = ejP.TKC();
        }
        super.Sj(ejP, sefVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Dq.RiZ, com.bytedance.sdk.openadsdk.core.Dq.sef
    public void Sj(String str, JSONObject jSONObject) {
        super.Sj(str, jSONObject);
        sef sefVar = this.sP;
        if (sefVar != null) {
            sefVar.Sj(str, jSONObject);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Dq.RiZ, com.bytedance.sdk.openadsdk.core.Dq.sef
    public void Sj(boolean z10, String str) {
        sef sefVar = this.sP;
        if (sefVar != null) {
            sefVar.Sj(z10, str);
        }
        setSoundMute(z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.Dq.RiZ
    public boolean Sj(com.bytedance.sdk.component.adexpress.sP.sef sefVar) {
        sU sUVar = this.Ym;
        if ((sUVar instanceof dx) && ((dx) sUVar).Qne() && sefVar.TKC() && sefVar.sP() == 1) {
            return false;
        }
        return super.Sj(sefVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Dq.RiZ, com.bytedance.sdk.openadsdk.core.Dq.sef
    public long TKC() {
        sef sefVar = this.sP;
        if (sefVar != null) {
            return sefVar.TKC();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.Dq.RiZ
    public HiB.Sj TKC(int i11) {
        com.bytedance.sdk.openadsdk.activity.vS vSVar;
        HiB.Sj TKC = super.TKC(i11);
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.HiB;
        if (sj2.gR && (vSVar = sj2.HS) != null) {
            if (sj2.Ir && vSVar.uP() != null) {
                TKC.sP = this.HiB.HS.uP().Sj(this.HiB.HS);
            } else if (this.HiB.HS.uP() != null) {
                TKC.sP = this.HiB.HS.uA;
            }
        }
        return TKC;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
    
        if (r1 != 1) goto L17;
     */
    @Override // com.bytedance.sdk.openadsdk.core.Dq.RiZ, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r0 = r4.HiB
            com.bytedance.sdk.openadsdk.component.reward.view.TEQ r0 = r0.Wjd
            if (r0 == 0) goto L32
            com.bytedance.sdk.openadsdk.core.model.TzV r0 = r0.Zq
            if (r0 == 0) goto L32
            boolean r1 = r0.uA()
            if (r1 == 0) goto L32
            int r1 = r5.getAction()
            if (r1 == 0) goto L1a
            r2 = 1
            if (r1 == r2) goto L20
            goto L32
        L1a:
            float r1 = r5.getY()
            r4.vS = r1
        L20:
            float r1 = r5.getY()
            float r2 = r4.vS
            android.content.Context r3 = r4.Dq
            boolean r1 = com.bytedance.sdk.openadsdk.utils.FPG.Sj(r2, r1, r3)
            if (r1 == 0) goto L32
            r1 = 5
            r0.Sj(r1)
        L32:
            boolean r5 = super.dispatchTouchEvent(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.view.sP.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public View getBackupContainerBackgroundView() {
        if (Fmk()) {
            return this.TKC.getBackupContainerBackgroundView();
        }
        return null;
    }

    public FrameLayout getVideoFrameLayout() {
        return Fmk() ? this.TKC.getVideoContainer() : this.f21096aa;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Dq.RiZ, com.bytedance.sdk.openadsdk.core.Dq.sef
    public void sP() {
        sef sefVar = this.sP;
        if (sefVar != null) {
            sefVar.sP();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Dq.RiZ, com.bytedance.sdk.openadsdk.core.Dq.sef
    public void sP(int i11) {
        sef sefVar = this.sP;
        if (sefVar != null) {
            sefVar.sP(i11);
        }
    }

    public void sP(final com.bytedance.sdk.component.adexpress.sP.sef sefVar) {
        if (sefVar == null) {
            return;
        }
        JcM.Sj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.sP.3
            @Override // java.lang.Runnable
            public void run() {
                sP.this.TKC(sefVar);
            }
        });
    }

    public void setExpressVideoListenerProxy(sef sefVar) {
        this.sP = sefVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.Dq.RiZ
    public void vS() {
        this.sef = true;
        this.f21096aa = new FrameLayout(this.Dq);
        if (!com.bytedance.sdk.openadsdk.core.TEQ.EjP.Sj(this.Ym) && !com.bytedance.sdk.openadsdk.core.TEQ.EjP.sP(this.Ym)) {
            addView(this.f21096aa, new FrameLayout.LayoutParams(-1, -1));
        }
        super.vS();
        com.bytedance.sdk.component.uA.vS webView = getWebView();
        if (webView != null) {
            webView.setBackgroundColor(0);
        }
        Jcg();
        setVideoFrameChangeListener(new com.bytedance.sdk.openadsdk.aa.Jcg() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.sP.1
            @Override // com.bytedance.sdk.openadsdk.aa.Jcg
            public void Sj(com.bytedance.sdk.component.adexpress.sP.sef sefVar) {
                sP.this.sP(sefVar);
            }
        });
    }
}

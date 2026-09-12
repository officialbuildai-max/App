package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.bytedance.sdk.component.utils.TzV;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.EjP.Jcg;
import com.bytedance.sdk.openadsdk.activity.sP;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.component.reward.view.Dq;
import com.bytedance.sdk.openadsdk.core.RiZ;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.core.model.uP;
import com.bytedance.sdk.openadsdk.core.sU;
import com.bytedance.sdk.openadsdk.core.widget.sP;
import com.bytedance.sdk.openadsdk.utils.Fmk;
import com.bytedance.sdk.openadsdk.utils.Mts;
import com.bytedance.sdk.openadsdk.utils.ib;
import com.bytedance.sdk.openadsdk.utils.sef;
import com.cloud.tmc.integration.net.UrlKt;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import u5.b;

/* loaded from: classes2.dex */
public class HiB extends Sj {
    private static String Fmk;
    private static String Zq;
    private static String dNu;
    private static String sef;
    private static String uvD;
    protected int HiB;
    int Jcg;
    private String RiZ;
    private String TzV;
    private int sU;
    protected int vS;

    public HiB(sP sPVar, sU sUVar, int i11) {
        super(sPVar, sUVar, i11);
        this.sU = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0076, code lost:
    
        if (r3.TKC.uvD.get() == false) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void JcM() {
        /*
            r3 = this;
            com.bytedance.sdk.openadsdk.EjP.HiB.sP.Zq$Sj r0 = new com.bytedance.sdk.openadsdk.EjP.HiB.sP.Zq$Sj
            r0.<init>()
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r1 = r3.TKC
            com.bytedance.sdk.openadsdk.component.reward.Sj.dNu r1 = r1.f21074ib
            long r1 = r1.Jcg()
            r0.Sj(r1)
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r1 = r3.TKC
            com.bytedance.sdk.openadsdk.component.reward.Sj.dNu r1 = r1.f21074ib
            long r1 = r1.sU()
            r0.TKC(r1)
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r1 = r3.TKC
            com.bytedance.sdk.openadsdk.component.reward.Sj.dNu r1 = r1.f21074ib
            long r1 = r1.Ym()
            r0.sP(r1)
            r1 = 3
            r0.TKC(r1)
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r1 = r3.TKC
            com.bytedance.sdk.openadsdk.component.reward.Sj.dNu r1 = r1.f21074ib
            int r1 = r1.RiZ()
            r0.EjP(r1)
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r1 = r3.TKC
            com.bytedance.sdk.openadsdk.component.reward.Sj.dNu r1 = r1.f21074ib
            z5.a r1 = r1.TKC()
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r2 = r3.TKC
            com.bytedance.sdk.openadsdk.component.reward.Sj.dNu r2 = r2.f21074ib
            com.bytedance.sdk.openadsdk.EjP.Jcg r2 = r2.Sj()
            com.bytedance.sdk.openadsdk.EjP.HiB.Sj.Sj.Sj(r1, r0, r2)
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r0 = r3.TKC
            int r0 = r0.vS
            com.bytedance.sdk.openadsdk.core.ib.TKC(r0)
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r0 = r3.TKC
            com.bytedance.sdk.openadsdk.component.reward.Sj.dNu r0 = r0.f21074ib
            java.lang.String r1 = "skip"
            r2 = 0
            r0.Sj(r1, r2)
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r0 = r3.TKC
            boolean r0 = r0.TKC
            if (r0 == 0) goto L78
            r0 = 1
            r1 = 4
            r3.Sj(r0, r1)
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r0 = r3.TKC
            com.bytedance.sdk.openadsdk.core.model.sU r0 = r0.sP
            boolean r0 = com.bytedance.sdk.openadsdk.core.model.TzV.Sj(r0)
            if (r0 == 0) goto L7b
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r0 = r3.TKC
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.uvD
            boolean r0 = r0.get()
            if (r0 != 0) goto L7b
        L78:
            r3.ley()
        L7b:
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r0 = r3.TKC
            com.bytedance.sdk.openadsdk.core.model.sU r0 = r0.sP
            com.bytedance.sdk.openadsdk.core.Ym.Sj r0 = r0.GMp()
            if (r0 == 0) goto L97
            com.bytedance.sdk.openadsdk.core.Ym.EjP r0 = r0.Sj()
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r1 = r3.TKC
            com.bytedance.sdk.openadsdk.component.reward.Sj.dNu r1 = r1.f21074ib
            long r1 = r1.Jcg()
            r0.vS(r1)
            r0.HiB(r1)
        L97:
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r0 = r3.TKC
            com.bytedance.sdk.openadsdk.core.model.sU r0 = r0.sP
            r1 = 5
            com.bytedance.sdk.openadsdk.kF.sP.HiB.Sj(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.HiB.JcM():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Sj(final boolean z10, boolean z11, final Runnable runnable) {
        if (!z11 && uP().Ym().getBoolean("user_has_give_up_reward", false) && (uP.Dq(this.TKC.sP) || runnable != null)) {
            if (runnable == null) {
                JcM();
            }
            return false;
        }
        if (!dNu.EjP().Dq(String.valueOf(this.TKC.vS))) {
            if (runnable == null) {
                if (z10) {
                    ley();
                    return false;
                }
                JcM();
            }
            return false;
        }
        if (uP().Ym().getBoolean("reward_verify", false)) {
            if (runnable == null) {
                if (uP.Dq(this.TKC.sP)) {
                    JcM();
                    return false;
                }
                if (z10) {
                    ley();
                    return false;
                }
                JcM();
            }
            return false;
        }
        this.TKC.sU.set(true);
        this.TKC.f21074ib.uvD();
        if (z10) {
            this.TKC.uP.sef();
        }
        final com.bytedance.sdk.openadsdk.core.widget.sP sPVar = new com.bytedance.sdk.openadsdk.core.widget.sP(wE());
        this.sP.Fmk = sPVar;
        if (z10) {
            sPVar.Sj(Fmk).sP(sef).TKC(Zq);
        } else {
            sPVar.Sj(uvD).sP(dNu).TKC(Zq);
        }
        this.sP.Fmk.Sj(new sP.Sj() { // from class: com.bytedance.sdk.openadsdk.activity.HiB.5
            @Override // com.bytedance.sdk.openadsdk.core.widget.sP.Sj
            public void Sj() {
                HiB.this.TKC.f21074ib.Zq();
                if (z10) {
                    HiB.this.TKC.uP.HiB(1000);
                }
                sPVar.dismiss();
                HiB.this.TKC.sU.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.sP.Sj
            public void sP() {
                sPVar.dismiss();
                HiB.this.uP().Ym().putBoolean("user_has_give_up_reward", true);
                HiB.this.TKC.sU.set(false);
                HiB.this.TKC.uP.vS(Integer.MAX_VALUE);
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                    return;
                }
                if (!z10) {
                    HiB.this.JcM();
                    return;
                }
                if (uP.Dq(HiB.this.TKC.sP)) {
                    if (HiB.this.TKC.uP.Sj()) {
                        HiB.this.TKC.uP.Sj(5);
                        return;
                    } else {
                        HiB.this.JcM();
                        return;
                    }
                }
                HiB.this.TKC.LqL.vS();
                if (HiB.this.TKC.uP.Sj()) {
                    HiB.this.TKC.uP.Sj(4);
                }
                HiB.this.ley();
            }
        }).show();
        return true;
    }

    private JSONObject fF() {
        JSONObject jSONObject = new JSONObject();
        int dx2 = (int) this.TKC.f21074ib.dx();
        try {
            jSONObject.put("oversea_version_type", 1);
            jSONObject.put(CampaignEx.JSON_KEY_REWARD_NAME, this.TKC.sP.uP());
            jSONObject.put(CampaignEx.JSON_KEY_REWARD_AMOUNT, this.TKC.sP.wE());
            jSONObject.put("network", TzV.TKC(this.TKC.Ei));
            jSONObject.put("sdk_version", BuildConfig.VERSION_NAME);
            int HpB = this.TKC.sP.HpB();
            String str = "unKnow";
            if (HpB == 2) {
                str = Mts.sP();
            } else if (HpB == 1) {
                str = Mts.TKC();
            }
            jSONObject.put("user_agent", str);
            JSONObject DhB = this.TKC.sP.DhB();
            DhB.put(UrlKt.KEY_MINI_GAID, com.bytedance.sdk.openadsdk.RiZ.Sj.sP.Sj.Sj().sP());
            jSONObject.put("extra", DhB);
            jSONObject.put("media_extra", this.RiZ);
            jSONObject.put("video_duration", this.TKC.sP.UHs().K());
            jSONObject.put("play_start_ts", this.vS);
            jSONObject.put("play_end_ts", this.HiB);
            jSONObject.put("duration", dx2);
            jSONObject.put("user_id", this.TzV);
            jSONObject.put("trans_id", ib.Sj().replace("-", ""));
            return jSONObject;
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.sU.Sj("TTAD.RewardAdScene", "", th2);
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Sj
    protected void Jcg() {
        Yf();
        if (this.Dq.EjP()) {
            this.TKC.wE.TEQ();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Sj, com.bytedance.sdk.openadsdk.core.aa.EjP.sP
    public void Sj(int i11) {
        if (i11 == 10000) {
            ib();
        }
    }

    public void Sj(long j11, long j12) {
        if (this.TKC.gR) {
            return;
        }
        sU sUVar = this.Dq;
        if (sUVar != null && sUVar.LqL() >= 0 && this.Dq.sP() >= 0) {
            sP(j11, this.Dq.sP());
            return;
        }
        if (j12 <= 0) {
            return;
        }
        long j13 = j11 + (this.TKC.UHs * 1000);
        if (this.sU == -1) {
            this.sU = dNu.EjP().ley(String.valueOf(this.TKC.vS)).vS;
        }
        if (j12 >= 30000 && j13 >= 27000) {
            ib();
        } else if (((float) (j13 * 100)) / ((float) j12) >= this.sU) {
            ib();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Sj, com.bytedance.sdk.openadsdk.activity.vS
    public void Sj(Activity activity, sP.HiB hiB) {
        super.Sj(activity, hiB);
        if (activity.isFinishing()) {
            return;
        }
        Intent intent = activity.getIntent();
        this.RiZ = intent.getStringExtra("media_extra");
        this.TzV = intent.getStringExtra("user_id");
        try {
            if (uvD == null) {
                uvD = com.bytedance.sdk.component.utils.ib.Sj(this.TKC.Ei, "tt_reward_msg");
                Fmk = com.bytedance.sdk.component.utils.ib.Sj(this.TKC.Ei, "tt_msgPlayable");
                Zq = com.bytedance.sdk.component.utils.ib.Sj(this.TKC.Ei, "tt_negtiveBtnBtnText");
                dNu = com.bytedance.sdk.component.utils.ib.Sj(this.TKC.Ei, "tt_postiveBtnText");
                sef = com.bytedance.sdk.component.utils.ib.Sj(this.TKC.Ei, "tt_postiveBtnTextPlayable");
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.sU.sP("TTAD.RewardAdScene", th2.getMessage());
        }
        sP uP = uP();
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.TKC;
        if (sj2 == null || uP == null) {
            return;
        }
        sj2.f21077tz = uP.sP;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Sj, com.bytedance.sdk.openadsdk.core.aa.EjP.sP
    public void Sj(Bundle bundle) {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Sj, com.bytedance.sdk.openadsdk.core.aa.EjP.sP
    public void Sj(final String str, final JSONObject jSONObject) {
        if ("skipToNextAd".equals(str) && this.TKC.HS != null && uP().Jcg() == null && Sj(uP.TKC(this.TKC.sP), false, new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.HiB.7
            @Override // java.lang.Runnable
            public void run() {
                HiB.super.Sj(str, jSONObject);
            }
        })) {
            return;
        }
        super.Sj(str, jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Sj, com.bytedance.sdk.openadsdk.core.aa.EjP.sP
    public void Sj(boolean z10) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.aa.EjP.sP
    public boolean Sj(long j11, boolean z10) {
        if (!this.Dq.EjP()) {
            Jcg jcg = new Jcg();
            jcg.Sj(System.currentTimeMillis(), 1.0f);
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.TKC;
            sj2.f21074ib.Sj(sj2.Wjd.vS(), jcg);
            b.InterfaceC0963b interfaceC0963b = new b.InterfaceC0963b() { // from class: com.bytedance.sdk.openadsdk.activity.HiB.4
                boolean Sj;

                @Override // u5.b.InterfaceC0963b
                public void Sj() {
                    ((Sj) HiB.this).Sj.removeMessages(300);
                    HiB.this.Fmk();
                    HiB.this.ib();
                    sP uP = HiB.this.uP();
                    HiB hiB = HiB.this;
                    uP.Sj(hiB, hiB.sP(6));
                }

                @Override // u5.b.InterfaceC0963b
                public void Sj(long j12, int i11) {
                    Fmk fmk;
                    if (this.Sj) {
                        return;
                    }
                    this.Sj = true;
                    ((Sj) HiB.this).Sj.removeMessages(300);
                    HiB.this.Fmk();
                    HiB hiB = HiB.this;
                    if (!hiB.TKC.gR) {
                        hiB.ib();
                    }
                    HiB.this.TKC.f21074ib.Sj(j12, j12);
                    HiB.this.TKC.RiZ.set(true);
                    if (HiB.this.TKC.sP.oDQ()) {
                        HiB.this.TKC.sP.xD(1);
                        HiB.this.TKC.Wjd.dNu();
                    }
                    if (HiB.this.TKC.sP.dx() == 21 && !HiB.this.TKC.sP.Dq()) {
                        HiB.this.TKC.sP.sP(true);
                        HiB.this.TKC.Wjd.dNu();
                    }
                    HiB.this.HiB = (int) (System.currentTimeMillis() / 1000);
                    HiB hiB2 = HiB.this;
                    com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj3 = hiB2.TKC;
                    if (sj3.gR) {
                        sP.HiB sP = hiB2.sP(5);
                        sP.HiB = true;
                        HiB.this.uP().Sj(HiB.this, sP);
                        return;
                    }
                    if (com.bytedance.sdk.openadsdk.core.model.TzV.EjP(sj3.sP) || com.bytedance.sdk.openadsdk.core.model.TzV.sP(HiB.this.TKC.sP) || com.bytedance.sdk.openadsdk.core.model.TzV.HiB(HiB.this.TKC.sP)) {
                        HiB.this.Sj(false, 5);
                        if (!com.bytedance.sdk.openadsdk.core.model.TzV.sP(HiB.this.TKC.sP) || (fmk = HiB.this.TKC.f21078xu) == null) {
                            return;
                        }
                        fmk.Sj(0L);
                        return;
                    }
                    if (com.bytedance.sdk.openadsdk.core.model.TzV.Sj(HiB.this.TKC.sP) && !HiB.this.TKC.uvD.get()) {
                        HiB.this.TKC.Sj(true);
                        HiB.this.TKC.Mts.HiB(true);
                        return;
                    }
                    com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj4 = HiB.this.TKC;
                    if (!sj4.TKC) {
                        if (sj4.sP.WM()) {
                            HiB.this.TKC.Mts.TKC();
                            return;
                        }
                        if (!sU.HiB(HiB.this.TKC.sP)) {
                            HiB.this.TKC.f21074ib.Sj("skip", true);
                        }
                        HiB.this.ley();
                        return;
                    }
                    if (sj4.sP.WM()) {
                        HiB.this.TKC.Mts.TKC();
                        return;
                    }
                    HiB.this.Sj(false, 5);
                    if (sU.HiB(HiB.this.TKC.sP)) {
                        return;
                    }
                    HiB.this.TKC.f21074ib.Sj("skip", true);
                }

                @Override // u5.b.InterfaceC0963b
                public void Sj(long j12, long j13) {
                    com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj3 = HiB.this.TKC;
                    if (!sj3.qRN && sj3.f21074ib.sP()) {
                        HiB.this.TKC.f21074ib.uvD();
                    }
                    if (HiB.this.TKC.TEQ.get()) {
                        return;
                    }
                    ((Sj) HiB.this).Sj.removeMessages(300);
                    if (j12 != HiB.this.TKC.f21074ib.Dq()) {
                        HiB.this.Fmk();
                    }
                    HiB.this.TKC.f21074ib.Sj(j12, j13);
                    HiB hiB = HiB.this;
                    long j14 = j12 / 1000;
                    double d11 = j14;
                    hiB.Jcg = (int) (hiB.TKC.f21074ib.Yf() - d11);
                    HiB hiB2 = HiB.this;
                    int i11 = hiB2.Jcg;
                    if (i11 >= 0) {
                        hiB2.TKC.Mts.Sj(String.valueOf(i11), null);
                    }
                    HiB hiB3 = HiB.this;
                    hiB3.Jcg = (int) (hiB3.TKC.f21074ib.Yf() - d11);
                    int i12 = (int) j14;
                    sU sUVar = HiB.this.Dq;
                    int TEQ = (sUVar == null || sUVar.sP() < 0) ? HiB.this.TKC != null ? dNu.EjP().TEQ(String.valueOf(HiB.this.TKC.vS)) : 30 : HiB.this.Dq.sP();
                    boolean z11 = TEQ >= 0;
                    if ((HiB.this.TKC.sU.get() || HiB.this.TKC.Ym.get()) && HiB.this.TKC.f21074ib.sP()) {
                        HiB.this.TKC.f21074ib.uvD();
                    }
                    HiB.this.TKC.Wjd.EjP(i12);
                    HiB.this.Sj(j12, j13);
                    HiB.this.Sj((((float) j12) * 1.0f) / ((float) j13));
                    HiB hiB4 = HiB.this;
                    if (hiB4.Jcg > 0) {
                        hiB4.TKC.Mts.EjP(true);
                        if (!z11 || i12 < TEQ) {
                            HiB hiB5 = HiB.this;
                            hiB5.TKC.Mts.Sj(String.valueOf(hiB5.Jcg), null);
                        } else {
                            HiB.this.TKC.Sj(true);
                            HiB hiB6 = HiB.this;
                            hiB6.TKC.Mts.Sj(String.valueOf(hiB6.Jcg), TTAdDislikeToast.getSkipText());
                            HiB.this.TKC.Mts.HiB(true);
                        }
                    }
                }

                @Override // u5.b.InterfaceC0963b
                public void sP(long j12, int i11) {
                    ((Sj) HiB.this).Sj.removeMessages(300);
                    com.bytedance.sdk.openadsdk.core.model.TzV tzV = HiB.this.TKC.Wjd.Zq;
                    if (tzV != null) {
                        tzV.TEQ();
                    }
                    if (HiB.this.TKC.f21074ib.sP()) {
                        HiB.this.HiB();
                        return;
                    }
                    HiB.this.TKC.f21074ib.sef();
                    HiB.this.ib();
                    sP uP = HiB.this.uP();
                    HiB hiB = HiB.this;
                    uP.Sj(hiB, hiB.sP(3));
                }
            };
            this.TKC.f21074ib.Sj(interfaceC0963b);
            com.bytedance.sdk.openadsdk.core.model.TzV tzV = this.TKC.Wjd.Zq;
            if (tzV != null) {
                tzV.Sj(interfaceC0963b);
            }
            boolean Sj = this.TKC.f21074ib.Sj(j11, z10, null, this.sP);
            if (Sj && !z10) {
                this.vS = (int) (System.currentTimeMillis() / 1000);
            }
            return Sj;
        }
        Dq dq2 = this.TKC.wE;
        Jcg jcg2 = (dq2 == null || dq2.Sj() == null) ? new Jcg() : this.TKC.wE.Sj().getAdShowTime();
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj3 = this.TKC;
        sj3.f21074ib.Sj(sj3.wE.sP(), jcg2);
        HashMap hashMap = new HashMap();
        Dq dq3 = this.TKC.wE;
        if (dq3 != null) {
            hashMap.put("dynamic_show_type", Integer.valueOf(dq3.uA()));
            JSONObject Sj2 = this.TKC.wE.Sj((JSONObject) null);
            if (Sj2 != null) {
                Iterator<String> keys = Sj2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        hashMap.put(next, Sj2.get(next));
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        this.TKC.f21074ib.Sj(new b.InterfaceC0963b() { // from class: com.bytedance.sdk.openadsdk.activity.HiB.3
            boolean Sj;

            @Override // u5.b.InterfaceC0963b
            public void Sj() {
                ((Sj) HiB.this).Sj.removeMessages(300);
                HiB.this.Fmk();
                HiB.this.ib();
                sP uP = HiB.this.uP();
                HiB hiB = HiB.this;
                uP.Sj(hiB, hiB.sP(6));
            }

            @Override // u5.b.InterfaceC0963b
            public void Sj(long j12, int i11) {
                if (this.Sj) {
                    return;
                }
                this.Sj = true;
                ((Sj) HiB.this).Sj.removeMessages(300);
                HiB.this.Fmk();
                HiB.this.TKC.f21074ib.Sj(j12, j12);
                HiB.this.TKC.wE.sP(true);
                if (HiB.this.TKC.sP.dx() == 36) {
                    com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj4 = HiB.this.TKC;
                    if (sj4.TKC) {
                        sj4.kF.TKC().EjP();
                        sef.sP();
                    }
                }
                if (HiB.this.TKC.sP.dx() == 21 && !HiB.this.TKC.sP.Dq()) {
                    HiB.this.TKC.sP.sP(true);
                    HiB.this.TKC.Wjd.dNu();
                }
                HiB hiB = HiB.this;
                com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj5 = hiB.TKC;
                if (sj5.gR) {
                    sP uP = hiB.uP();
                    HiB hiB2 = HiB.this;
                    uP.Sj(hiB2, hiB2.sP(5));
                } else if (sj5.TKC) {
                    if (!sj5.sP.WM()) {
                        HiB.this.Sj(false, 5);
                        if (!sU.HiB(HiB.this.TKC.sP)) {
                            HiB.this.TKC.f21074ib.Sj("skip", true);
                        }
                    } else if (HiB.this.TKC.wE.uA() == 1) {
                        HiB.this.TKC.Mts.TKC();
                    }
                } else if (!sj5.sP.WM()) {
                    if (!sU.HiB(HiB.this.TKC.sP)) {
                        HiB.this.TKC.f21074ib.Sj("skip", true);
                    }
                    HiB.this.ley();
                } else if (HiB.this.TKC.wE.uA() == 1) {
                    HiB.this.TKC.Mts.TKC();
                }
                HiB.this.HiB = (int) (System.currentTimeMillis() / 1000);
                HiB hiB3 = HiB.this;
                if (hiB3.TKC.gR) {
                    return;
                }
                hiB3.ib();
            }

            @Override // u5.b.InterfaceC0963b
            public void Sj(long j12, long j13) {
                com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj4 = HiB.this.TKC;
                if (!sj4.qRN && sj4.f21074ib.sP()) {
                    HiB.this.TKC.f21074ib.uvD();
                }
                if (HiB.this.TKC.TEQ.get()) {
                    return;
                }
                ((Sj) HiB.this).Sj.removeMessages(300);
                if (j12 != HiB.this.TKC.f21074ib.Dq()) {
                    HiB.this.Fmk();
                }
                if (HiB.this.TKC.f21074ib.sP()) {
                    HiB.this.TKC.f21074ib.Sj(j12, j13);
                    sU sUVar = HiB.this.Dq;
                    int TEQ = (sUVar == null || sUVar.sP() < 0) ? HiB.this.TKC != null ? dNu.EjP().TEQ(String.valueOf(HiB.this.TKC.vS)) : 30 : HiB.this.Dq.sP();
                    boolean z11 = HiB.this.TKC.wE.Dq() && TEQ != -1 && TEQ >= 0;
                    HiB hiB = HiB.this;
                    long j14 = j12 / 1000;
                    hiB.Jcg = (int) (hiB.TKC.f21074ib.Yf() - j14);
                    int i11 = (int) j14;
                    if ((HiB.this.TKC.sU.get() || HiB.this.TKC.Ym.get()) && HiB.this.TKC.f21074ib.sP()) {
                        HiB.this.TKC.f21074ib.uvD();
                    }
                    HiB hiB2 = HiB.this;
                    int i12 = hiB2.Jcg;
                    if (i12 >= 0) {
                        hiB2.TKC.Mts.Sj(String.valueOf(i12), null);
                    }
                    HiB.this.TKC.Wjd.EjP(i11);
                    HiB.this.Sj(j12, j13);
                    Dq dq4 = HiB.this.TKC.wE;
                    if (dq4 != null && dq4.Sj() != null) {
                        HiB.this.TKC.wE.Sj().setTime(String.valueOf(HiB.this.Jcg), i11, 0, false);
                    }
                    HiB.this.Sj((((float) j12) * 1.0f) / ((float) j13));
                    HiB hiB3 = HiB.this;
                    if (hiB3.Jcg > 0) {
                        if (!z11 || i11 < TEQ || hiB3.TKC.sP.dx() == 5) {
                            HiB hiB4 = HiB.this;
                            hiB4.TKC.Mts.Sj(String.valueOf(hiB4.Jcg), null);
                        } else {
                            HiB.this.TKC.Sj(true);
                            HiB hiB5 = HiB.this;
                            hiB5.TKC.Mts.Sj(String.valueOf(hiB5.Jcg), TTAdDislikeToast.getSkipText());
                            HiB.this.TKC.Mts.HiB(true);
                        }
                    }
                }
            }

            @Override // u5.b.InterfaceC0963b
            public void sP(long j12, int i11) {
                ((Sj) HiB.this).Sj.removeMessages(300);
                com.bytedance.sdk.openadsdk.core.model.TzV tzV2 = HiB.this.TKC.Wjd.Zq;
                if (tzV2 != null) {
                    tzV2.TEQ();
                }
                if (HiB.this.TKC.f21074ib.sP()) {
                    HiB.this.HiB();
                    return;
                }
                HiB.this.ib();
                HiB.this.TKC.f21074ib.sef();
                HiB.this.TKC.wE.Sj(true);
                sP uP = HiB.this.uP();
                HiB hiB = HiB.this;
                uP.Sj(hiB, hiB.sP(3));
            }
        });
        boolean Sj3 = this.TKC.f21074ib.Sj(j11, z10, hashMap, this.sP);
        if (Sj3 && !z10) {
            this.vS = (int) (System.currentTimeMillis() / 1000);
        }
        return Sj3;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Sj
    protected void TKC() {
        final View TEQ = this.TKC.Wjd.TEQ();
        if (TEQ != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.HiB.1
                /* JADX WARN: Removed duplicated region for block: B:21:0x00d8 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:22:0x00d9  */
                @Override // android.view.View.OnClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void onClick(android.view.View r5) {
                    /*
                        Method dump skipped, instructions count: 269
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.HiB.AnonymousClass1.onClick(android.view.View):void");
                }
            };
            TEQ.setOnClickListener(onClickListener);
            TEQ.setTag(TEQ.getId(), onClickListener);
        }
        this.TKC.Mts.Sj(new com.bytedance.sdk.openadsdk.component.reward.top.sP() { // from class: com.bytedance.sdk.openadsdk.activity.HiB.2
            @Override // com.bytedance.sdk.openadsdk.component.reward.top.sP
            public void Sj(View view) {
                if (HiB.this.TKC.sP.yr()) {
                    if (HiB.this.TKC.Wjd.Ym() != null) {
                        HiB.this.TKC.sP.xD(2);
                        HiB.this.TKC.Wjd.dNu();
                        return;
                    }
                    return;
                }
                com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = HiB.this.TKC;
                if (!sj2.TKC && sj2.sP.Snq() && !HiB.this.TKC.sP.Ph()) {
                    HiB.this.TKC.sP.xD(13);
                    try {
                        HiB.this.TKC.Wjd.dNu();
                        return;
                    } catch (Exception unused) {
                    }
                }
                HiB hiB = HiB.this;
                hiB.Sj(uP.TKC(hiB.TKC.sP), false, (Runnable) null);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.sP
            public void Sj(View view, String str) {
                com.bytedance.sdk.openadsdk.component.reward.sP.sP sPVar = HiB.this.sP;
                if (sPVar != null && sPVar.EjP() != null) {
                    HiB.this.sP.EjP().Sj(HiB.this.TKC.ndK);
                }
                HiB.this.TKC.ndK = !r3.ndK;
                StringBuilder sb2 = new StringBuilder("will set is Mute ");
                sb2.append(HiB.this.TKC.ndK);
                sb2.append(" mLastVolume=");
                sb2.append(HiB.this.TKC.fF.Sj());
                com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = HiB.this.TKC;
                sj2.f21074ib.Sj(sj2.ndK, str);
                if (!uP.RiZ(HiB.this.TKC.sP) || HiB.this.TKC.TEQ.get()) {
                    com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj3 = HiB.this.TKC;
                    sj3.JcM.HiB(sj3.ndK);
                    sU sUVar = HiB.this.TKC.sP;
                    if (sUVar == null || sUVar.GMp() == null || HiB.this.TKC.sP.GMp().Sj() == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj4 = HiB.this.TKC;
                    if (sj4.f21074ib != null) {
                        if (sj4.ndK) {
                            sj4.sP.GMp().Sj().Dq(HiB.this.TKC.f21074ib.Jcg());
                        } else {
                            sj4.sP.GMp().Sj().uA(HiB.this.TKC.f21074ib.Jcg());
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
                HiB hiB = HiB.this;
                hiB.TKC.LD.Sj(hiB.sP);
            }
        });
    }

    public void TKC(final int i11) {
        if (uP().Ym().getBoolean("reward_verify", false) || uP().Zq() || uP().Ym().getBoolean("user_has_give_up_reward", false)) {
            return;
        }
        uP().Ym().putBoolean("reward_verify", true);
        if (dNu.EjP().uvD(String.valueOf(this.TKC.vS))) {
            Sj(true, this.TKC.sP.wE(), this.TKC.sP.uP(), 0, "", i11);
        } else {
            dNu.TKC().Sj(fF(), new RiZ.sP() { // from class: com.bytedance.sdk.openadsdk.activity.HiB.6
                @Override // com.bytedance.sdk.openadsdk.core.RiZ.sP
                public void Sj(int i12, String str) {
                    HiB.this.Sj(false, 0, "", i12, str, i11);
                }

                @Override // com.bytedance.sdk.openadsdk.core.RiZ.sP
                public void Sj(sU.sP sPVar) {
                    boolean z10 = sPVar.sP;
                    HiB.this.Sj(sPVar.sP, sPVar.TKC.Sj(), sPVar.TKC.sP(), 0, "", i11);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vS
    protected boolean a_() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Sj, com.bytedance.sdk.openadsdk.core.aa.EjP.sP
    public void aa() {
        ib();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vS
    public String b_() {
        return "rewarded_video";
    }

    @Override // com.bytedance.sdk.openadsdk.core.aa.EjP.sP
    public void c_() {
        LD();
    }

    public void ib() {
        TKC(0);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Sj
    protected void sP() {
        this.TKC.Mts.Sj(null, TTAdDislikeToast.getSkipText());
        this.TKC.Mts.HiB(true);
    }

    protected void sP(long j11, long j12) {
        if (j12 <= 0) {
            return;
        }
        if (this.sU == -1) {
            this.sU = Math.min(100, this.Dq.LqL());
        }
        if (((((float) j11) / 1000.0f) / ((float) j12)) * 100.0f >= this.sU) {
            ib();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x008b, code lost:
    
        if (r1 != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003c, code lost:
    
        if (((1.0d - (r8.Jcg / r8.TKC.f21074ib.Yf())) * 100.0d) >= r0) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003e, code lost:
    
        r2 = true;
     */
    @Override // com.bytedance.sdk.openadsdk.activity.Sj, com.bytedance.sdk.openadsdk.activity.vS, com.bytedance.sdk.openadsdk.core.aa.EjP.sP
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void sef() {
        /*
            r8 = this;
            com.bytedance.sdk.openadsdk.core.model.sU r0 = r8.Dq
            boolean r0 = r0.TT()
            if (r0 != 0) goto L9
            return
        L9:
            com.bytedance.sdk.openadsdk.core.settings.vS r0 = com.bytedance.sdk.openadsdk.core.dNu.EjP()
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r1 = r8.TKC
            int r1 = r1.vS
            java.lang.String r1 = java.lang.String.valueOf(r1)
            com.bytedance.sdk.openadsdk.core.settings.sP r0 = r0.ley(r1)
            int r0 = r0.vS
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r1 = r8.TKC
            com.bytedance.sdk.openadsdk.core.model.sU r1 = r1.sP
            boolean r1 = com.bytedance.sdk.openadsdk.core.model.uP.RiZ(r1)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L40
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r1 = r8.TKC
            com.bytedance.sdk.openadsdk.component.reward.Sj.dNu r1 = r1.f21074ib
            double r4 = r1.Yf()
            int r1 = r8.Jcg
            double r6 = (double) r1
            double r6 = r6 / r4
            r4 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r4 = r4 - r6
            r6 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r4 = r4 * r6
            double r0 = (double) r0
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 < 0) goto L91
        L3e:
            r2 = r3
            goto L91
        L40:
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r1 = r8.TKC
            com.bytedance.sdk.openadsdk.core.model.sU r1 = r1.sP
            int r1 = r1.oWa()
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r4 = r8.TKC
            com.bytedance.sdk.openadsdk.component.reward.Sj.Dq r4 = r4.uP
            float r4 = r4.sP()
            float r1 = (float) r1
            float r4 = r4 / r1
            r1 = 1065353216(0x3f800000, float:1.0)
            float r1 = r1 - r4
            r4 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 * r4
            float r0 = (float) r0
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 < 0) goto L5f
            r0 = r3
            goto L60
        L5f:
            r0 = r2
        L60:
            com.bytedance.sdk.openadsdk.core.settings.vS r1 = com.bytedance.sdk.openadsdk.core.dNu.EjP()
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r4 = r8.TKC
            int r4 = r4.vS
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r1 = r1.Sj(r4)
            if (r1 != 0) goto L8e
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r1 = r8.TKC
            com.bytedance.sdk.openadsdk.component.reward.Sj.TzV r1 = r1.JcM
            com.bytedance.sdk.openadsdk.core.Yf r1 = r1.aa()
            boolean r1 = r1.vS()
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r4 = r8.TKC
            com.bytedance.sdk.openadsdk.component.reward.Sj.Dq r4 = r4.uP
            boolean r4 = r4.TKC()
            if (r4 == 0) goto L89
            r1 = r3
        L89:
            if (r0 == 0) goto L91
            if (r1 == 0) goto L91
            goto L3e
        L8e:
            if (r1 != r3) goto L91
            r2 = r0
        L91:
            if (r2 == 0) goto L96
            r8.ib()
        L96:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.HiB.sef():void");
    }
}

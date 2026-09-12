package com.bytedance.sdk.openadsdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.Dq.Dq;
import com.bytedance.sdk.component.utils.TzV;
import com.bytedance.sdk.component.utils.sU;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.EjP.Jcg;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.component.reward.Ym;
import com.bytedance.sdk.openadsdk.core.RiZ;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.core.kF;
import com.bytedance.sdk.openadsdk.core.model.uP;
import com.bytedance.sdk.openadsdk.core.sU;
import com.bytedance.sdk.openadsdk.core.widget.sP;
import com.bytedance.sdk.openadsdk.utils.Fmk;
import com.bytedance.sdk.openadsdk.utils.JcM;
import com.bytedance.sdk.openadsdk.utils.Mts;
import com.bytedance.sdk.openadsdk.utils.ib;
import com.bytedance.sdk.openadsdk.utils.sef;
import com.cloud.tmc.integration.net.UrlKt;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import u5.b;

/* loaded from: classes2.dex */
public class TTRewardVideoActivity extends TTBaseVideoActivity {
    private static String TzV;
    private static String Zq;
    private static String dNu;

    /* renamed from: dx, reason: collision with root package name */
    private static com.bytedance.sdk.openadsdk.Sj.HiB.Sj f21048dx;
    private static String sef;
    private static String uvD;
    protected com.bytedance.sdk.openadsdk.Sj.HiB.Sj Fmk;
    private String RiZ;
    protected int Ym;

    /* renamed from: aa, reason: collision with root package name */
    protected int f21049aa;
    private boolean kF;
    private String sU;
    private final AtomicBoolean zR = new AtomicBoolean(false);

    /* renamed from: ib, reason: collision with root package name */
    private int f21050ib = -1;

    private void Sj(final String str, final boolean z10, final int i11, final String str2, final int i12, final String str3) {
        JcM.TKC(new Dq("Reward_executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTRewardVideoActivity.this.sP(0).executeRewardVideoCallback(TTRewardVideoActivity.this.sP.f21072db, str, z10, i11, str2, i12, str3);
                } catch (Throwable th2) {
                    sU.sP("TTAD.RVA", "rewarded_video", "executeRewardVideoCallback execute throw Exception : ", th2);
                }
            }
        }, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(final boolean z10, final int i11, final String str, final int i12, final String str2, final int i13) {
        sU.Sj("BVA", "invoke callback onRewardVerify: " + z10 + ", " + i11 + ", " + str + ", " + i12 + ", " + str2 + "; " + this);
        if (!com.bytedance.sdk.openadsdk.multipro.sP.TKC()) {
            JcM.Sj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.Sj.HiB.Sj sj2 = TTRewardVideoActivity.this.Fmk;
                    if (sj2 != null) {
                        sj2.Sj(z10, i11, str, i12, str2);
                        Ym.Sj(TTRewardVideoActivity.this.sP.sP, z10, i13);
                    }
                }
            });
        } else {
            Sj("onRewardVerify", z10, i11, str, i12, str2);
            Ym.Sj(this.sP.sP, z10, i13);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(final boolean z10, boolean z11) {
        if (!z11 && this.kF && this.sP.TEQ.get()) {
            if (uP.Dq(this.sP.sP)) {
                this.sP.JcM.Dq();
                return;
            } else if (uP.TEQ(this.sP.sP)) {
                this.sP.uP.dNu();
                return;
            }
        }
        if (!dNu.EjP().Dq(String.valueOf(this.sP.vS))) {
            if (!z11 && this.sP.TEQ.get()) {
                if (uP.Dq(this.sP.sP)) {
                    this.sP.JcM.Dq();
                    return;
                } else if (uP.TEQ(this.sP.sP)) {
                    this.sP.uP.dNu();
                    return;
                }
            }
            if (z10) {
                finish();
                return;
            } else {
                zR();
                return;
            }
        }
        if (this.zR.get()) {
            if (this.sP.TEQ.get()) {
                if (uP.Dq(this.sP.sP)) {
                    this.sP.JcM.Dq();
                    return;
                } else if (uP.TEQ(this.sP.sP)) {
                    this.sP.uP.dNu();
                    return;
                }
            }
            if (z10) {
                finish();
                return;
            } else {
                zR();
                return;
            }
        }
        if (uP.Dq(this.sP.sP) && this.sP.JcM.Ym().getVisibility() == 0) {
            this.sP.JcM.Dq();
            return;
        }
        if (uP.TEQ(this.sP.sP) && this.sP.JcM.TEQ().getVisibility() == 0) {
            this.sP.uP.dNu();
            return;
        }
        this.sP.sU.set(true);
        this.sP.f21074ib.uvD();
        if (z10) {
            this.sP.uP.sef();
        }
        final com.bytedance.sdk.openadsdk.core.widget.sP sPVar = new com.bytedance.sdk.openadsdk.core.widget.sP(this);
        this.TKC.Fmk = sPVar;
        if (z10) {
            sPVar.Sj(Zq).sP(TzV).TKC(uvD);
        } else {
            sPVar.Sj(sef).sP(dNu).TKC(uvD);
        }
        this.TKC.Fmk.Sj(new sP.Sj() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.6
            @Override // com.bytedance.sdk.openadsdk.core.widget.sP.Sj
            public void Sj() {
                TTRewardVideoActivity.this.sP.f21074ib.Zq();
                if (z10) {
                    TTRewardVideoActivity.this.sP.uP.HiB(1000);
                }
                sPVar.dismiss();
                TTRewardVideoActivity.this.sP.sU.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.sP.Sj
            public void sP() {
                sPVar.dismiss();
                TTRewardVideoActivity.this.kF = true;
                TTRewardVideoActivity.this.sP.sU.set(false);
                TTRewardVideoActivity.this.sP.uP.vS(Integer.MAX_VALUE);
                if (z10) {
                    if (uP.TzV(TTRewardVideoActivity.this.sP.sP)) {
                        if (uP.Dq(TTRewardVideoActivity.this.sP.sP)) {
                            if (TTRewardVideoActivity.this.sP.uP.Sj()) {
                                TTRewardVideoActivity.this.sP.uP.Sj(5);
                                return;
                            } else {
                                TTRewardVideoActivity.this.sP.JcM.Dq();
                                return;
                            }
                        }
                        TTRewardVideoActivity.this.sP.LqL.vS();
                        if (TTRewardVideoActivity.this.sP.uP.Sj()) {
                            TTRewardVideoActivity.this.sP.uP.Sj(4);
                        }
                        TTRewardVideoActivity.this.finish();
                        return;
                    }
                    if (uP.vS(TTRewardVideoActivity.this.sP.sP)) {
                        if (uP.TEQ(TTRewardVideoActivity.this.sP.sP)) {
                            TTRewardVideoActivity.this.sP.uP.dNu();
                            return;
                        } else {
                            TTRewardVideoActivity.this.sP.LqL.vS();
                            TTRewardVideoActivity.this.finish();
                            return;
                        }
                    }
                }
                TTRewardVideoActivity.this.zR();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ib() {
        sU.Sj("BVA", "invoke callback onAdClicked, ".concat(String.valueOf(this)));
        if (com.bytedance.sdk.openadsdk.multipro.sP.TKC()) {
            Sj("onAdVideoBarClick");
            return;
        }
        com.bytedance.sdk.openadsdk.Sj.HiB.Sj sj2 = this.Fmk;
        if (sj2 != null) {
            sj2.onAdClicked();
        }
    }

    private JSONObject kF() {
        JSONObject jSONObject = new JSONObject();
        int dx2 = (int) this.sP.f21074ib.dx();
        try {
            jSONObject.put("oversea_version_type", 1);
            jSONObject.put(CampaignEx.JSON_KEY_REWARD_NAME, this.sP.sP.uP());
            jSONObject.put(CampaignEx.JSON_KEY_REWARD_AMOUNT, this.sP.sP.wE());
            jSONObject.put("network", TzV.TKC(getApplicationContext()));
            jSONObject.put("sdk_version", BuildConfig.VERSION_NAME);
            int HpB = this.sP.sP.HpB();
            String str = "unKnow";
            if (HpB == 2) {
                str = Mts.sP();
            } else if (HpB == 1) {
                str = Mts.TKC();
            }
            jSONObject.put("user_agent", str);
            JSONObject DhB = this.sP.sP.DhB();
            DhB.put(UrlKt.KEY_MINI_GAID, com.bytedance.sdk.openadsdk.RiZ.Sj.sP.Sj.Sj().sP());
            jSONObject.put("extra", DhB);
            jSONObject.put("media_extra", this.RiZ);
            jSONObject.put("video_duration", this.sP.sP.UHs().K());
            jSONObject.put("play_start_ts", this.Ym);
            jSONObject.put("play_end_ts", this.f21049aa);
            jSONObject.put("duration", dx2);
            jSONObject.put("user_id", this.sU);
            jSONObject.put("trans_id", ib.Sj().replace("-", ""));
            return jSONObject;
        } catch (Throwable th2) {
            sU.Sj("TTAD.RVA", "", th2);
            return null;
        }
    }

    private void uP() {
        Ym ym2;
        if (this.Dq) {
            return;
        }
        this.Dq = true;
        sU.Sj("BVA", "invoke callback onAdClose, ".concat(String.valueOf(this)));
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.sP;
        if (sj2 != null && (ym2 = sj2.f21077tz) != null) {
            ym2.EjP();
        }
        if (com.bytedance.sdk.openadsdk.multipro.sP.TKC()) {
            Sj("onAdClose");
            return;
        }
        com.bytedance.sdk.openadsdk.Sj.HiB.Sj sj3 = this.Fmk;
        if (sj3 != null) {
            sj3.sP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0094, code lost:
    
        if (r3.sP.uvD.get() == false) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void zR() {
        /*
            r3 = this;
            com.bytedance.sdk.openadsdk.EjP.HiB.sP.Zq$Sj r0 = new com.bytedance.sdk.openadsdk.EjP.HiB.sP.Zq$Sj
            r0.<init>()
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r1 = r3.sP
            com.bytedance.sdk.openadsdk.component.reward.Sj.dNu r1 = r1.f21074ib
            long r1 = r1.Jcg()
            r0.Sj(r1)
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r1 = r3.sP
            com.bytedance.sdk.openadsdk.component.reward.Sj.dNu r1 = r1.f21074ib
            long r1 = r1.sU()
            r0.TKC(r1)
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r1 = r3.sP
            com.bytedance.sdk.openadsdk.component.reward.Sj.dNu r1 = r1.f21074ib
            long r1 = r1.Ym()
            r0.sP(r1)
            r1 = 3
            r0.TKC(r1)
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r1 = r3.sP
            com.bytedance.sdk.openadsdk.component.reward.Sj.dNu r1 = r1.f21074ib
            int r1 = r1.RiZ()
            r0.EjP(r1)
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r1 = r3.sP
            com.bytedance.sdk.openadsdk.component.reward.Sj.dNu r1 = r1.f21074ib
            z5.a r1 = r1.TKC()
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r2 = r3.sP
            com.bytedance.sdk.openadsdk.component.reward.Sj.dNu r2 = r2.f21074ib
            com.bytedance.sdk.openadsdk.EjP.Jcg r2 = r2.Sj()
            com.bytedance.sdk.openadsdk.EjP.HiB.Sj.Sj.Sj(r1, r0, r2)
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r0 = r3.sP
            int r0 = r0.vS
            com.bytedance.sdk.openadsdk.core.ib.TKC(r0)
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r0 = r3.sP
            com.bytedance.sdk.openadsdk.component.reward.Sj.dNu r0 = r0.f21074ib
            java.lang.String r1 = "skip"
            r2 = 0
            r0.Sj(r1, r2)
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r0 = r3.sP
            boolean r1 = r0.TKC
            if (r1 == 0) goto L96
            com.bytedance.sdk.openadsdk.core.model.sU r0 = r0.sP
            boolean r0 = com.bytedance.sdk.openadsdk.core.model.TzV.TKC(r0)
            r1 = 4
            r2 = 1
            if (r0 == 0) goto L7f
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r0 = r3.sP
            com.bytedance.sdk.openadsdk.component.reward.view.Dq r0 = r0.wE
            com.bytedance.sdk.openadsdk.component.reward.view.sP r0 = r0.Sj()
            if (r0 == 0) goto L7b
            int r0 = r0.EjP
            if (r0 != 0) goto L7b
            r3.finish()
            goto L82
        L7b:
            r3.Sj(r2, r1)
            goto L82
        L7f:
            r3.Sj(r2, r1)
        L82:
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r0 = r3.sP
            com.bytedance.sdk.openadsdk.core.model.sU r0 = r0.sP
            boolean r0 = com.bytedance.sdk.openadsdk.core.model.TzV.Sj(r0)
            if (r0 == 0) goto L99
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r0 = r3.sP
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.uvD
            boolean r0 = r0.get()
            if (r0 != 0) goto L99
        L96:
            r3.finish()
        L99:
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r0 = r3.sP
            com.bytedance.sdk.openadsdk.core.model.sU r0 = r0.sP
            com.bytedance.sdk.openadsdk.core.Ym.Sj r0 = r0.GMp()
            if (r0 == 0) goto Lb5
            com.bytedance.sdk.openadsdk.core.Ym.EjP r0 = r0.Sj()
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r1 = r3.sP
            com.bytedance.sdk.openadsdk.component.reward.Sj.dNu r1 = r1.f21074ib
            long r1 = r1.Jcg()
            r0.vS(r1)
            r0.HiB(r1)
        Lb5:
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r0 = r3.sP
            com.bytedance.sdk.openadsdk.core.model.sU r0 = r0.sP
            r1 = 5
            com.bytedance.sdk.openadsdk.kF.sP.HiB.Sj(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.zR():void");
    }

    @Override // com.bytedance.sdk.openadsdk.core.aa.EjP.sP
    public void EjP() {
        ib();
        this.sP.sP.jU();
        this.sP.sP.Sj(true);
        if (com.bytedance.sdk.openadsdk.core.model.sU.HiB(this.sP.sP)) {
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.sP;
            com.bytedance.sdk.openadsdk.core.model.sU sUVar = sj2.sP;
            com.bytedance.sdk.openadsdk.EjP.TKC.sP(sUVar, sj2.HiB, sUVar.SPg());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void Jcg() {
        if (com.bytedance.sdk.openadsdk.multipro.sP.TKC()) {
            Sj("onAdShow");
        } else {
            com.bytedance.sdk.openadsdk.Sj.HiB.Sj sj2 = this.Fmk;
            if (sj2 != null) {
                sj2.Sj();
            }
        }
        if (sU()) {
            this.sP.wE.TEQ();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public boolean RiZ() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void Sj() {
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2;
        super.Sj();
        if (this.zR.get() || (sj2 = this.sP) == null) {
            return;
        }
        sj2.f21077tz = new Ym(new Ym.Sj() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.1
            @Override // com.bytedance.sdk.openadsdk.component.reward.Ym.Sj
            public void Sj() {
                if (TTRewardVideoActivity.this.zR.get() || TTRewardVideoActivity.this.kF) {
                    return;
                }
                TTRewardVideoActivity.this.TKC(1);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.aa.EjP.sP
    public void Sj(int i11) {
        if (i11 == 10000) {
            dx();
        }
    }

    protected void Sj(long j11, long j12) {
        if (j12 <= 0) {
            return;
        }
        if (this.f21050ib == -1) {
            this.f21050ib = Math.min(100, this.sP.sP.LqL());
        }
        if (((((float) j11) / 1000.0f) / ((float) j12)) * 100.0f >= this.f21050ib) {
            dx();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void Sj(@NonNull Intent intent) {
        super.Sj(intent);
        this.RiZ = intent.getStringExtra("media_extra");
        this.sU = intent.getStringExtra("user_id");
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.core.aa.EjP.sP
    public void Sj(Bundle bundle) {
        if (!com.bytedance.sdk.openadsdk.multipro.sP.TKC()) {
            this.Fmk = kF.Sj().TKC();
        }
        if (this.Fmk != null || bundle == null) {
            return;
        }
        this.Fmk = f21048dx;
        f21048dx = null;
    }

    protected void Sj(String str) {
        Sj(str, false, 0, "", 0, "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.aa.EjP.sP
    public void Sj(String str, JSONObject jSONObject) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.aa.EjP.sP
    public void Sj(boolean z10) {
        if (z10) {
            dx();
            return;
        }
        if ((1.0d - (this.vS / this.sP.f21074ib.Yf())) * 100.0d >= dNu.EjP().ley(String.valueOf(this.sP.vS)).vS) {
            dx();
        }
    }

    public boolean Sj(long j11, boolean z10) {
        Jcg jcg = new Jcg();
        jcg.Sj(System.currentTimeMillis(), 1.0f);
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.sP;
        sj2.f21074ib.Sj(sj2.Wjd.vS(), jcg);
        b.InterfaceC0963b interfaceC0963b = new b.InterfaceC0963b() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.7
            boolean Sj;

            @Override // u5.b.InterfaceC0963b
            public void Sj() {
                TTRewardVideoActivity.this.EjP.removeMessages(300);
                TTRewardVideoActivity.this.dNu();
                TTRewardVideoActivity.this.dx();
                TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                if (tTRewardVideoActivity.sP.TKC) {
                    tTRewardVideoActivity.Sj(false, true, 6);
                } else {
                    tTRewardVideoActivity.finish();
                }
                com.bytedance.sdk.openadsdk.component.reward.Sj.dNu dnu = TTRewardVideoActivity.this.sP.f21074ib;
                dnu.Sj(!dnu.LqL() ? 1 : 0, 1 ^ (TTRewardVideoActivity.this.sP.f21074ib.LqL() ? 1 : 0));
                TTRewardVideoActivity.this.sP.f21074ib.sef();
            }

            @Override // u5.b.InterfaceC0963b
            public void Sj(long j12, int i11) {
                Fmk fmk;
                if (this.Sj) {
                    return;
                }
                this.Sj = true;
                TTRewardVideoActivity.this.EjP.removeMessages(300);
                TTRewardVideoActivity.this.dNu();
                TTRewardVideoActivity.this.dx();
                TTRewardVideoActivity.this.sP.f21074ib.Sj(j12, j12);
                TTRewardVideoActivity.this.sP.RiZ.set(true);
                if (TTRewardVideoActivity.this.sP.sP.dx() == 36) {
                    com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj3 = TTRewardVideoActivity.this.sP;
                    if (sj3.TKC) {
                        sj3.kF.TKC().EjP();
                        sef.sP();
                    }
                }
                if (TTRewardVideoActivity.this.sP.sP.oDQ()) {
                    TTRewardVideoActivity.this.sP.sP.xD(1);
                    TTRewardVideoActivity.this.sP.Wjd.dNu();
                }
                if (TTRewardVideoActivity.this.sP.sP.dx() == 21 && !TTRewardVideoActivity.this.sP.sP.Dq()) {
                    TTRewardVideoActivity.this.sP.sP.sP(true);
                    TTRewardVideoActivity.this.sP.Wjd.dNu();
                }
                TTRewardVideoActivity.this.f21049aa = (int) (System.currentTimeMillis() / 1000);
                if (com.bytedance.sdk.openadsdk.core.model.TzV.EjP(TTRewardVideoActivity.this.sP.sP) || com.bytedance.sdk.openadsdk.core.model.TzV.sP(TTRewardVideoActivity.this.sP.sP) || com.bytedance.sdk.openadsdk.core.model.TzV.HiB(TTRewardVideoActivity.this.sP.sP)) {
                    TTRewardVideoActivity.this.Sj(false, 5);
                    if (!com.bytedance.sdk.openadsdk.core.model.TzV.sP(TTRewardVideoActivity.this.sP.sP) || (fmk = TTRewardVideoActivity.this.sP.f21078xu) == null) {
                        return;
                    }
                    fmk.Sj(0L);
                    return;
                }
                if (com.bytedance.sdk.openadsdk.core.model.TzV.Sj(TTRewardVideoActivity.this.sP.sP) && !TTRewardVideoActivity.this.sP.uvD.get()) {
                    TTRewardVideoActivity.this.sP.Sj(true);
                    TTRewardVideoActivity.this.sP.Mts.HiB(true);
                    return;
                }
                com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj4 = TTRewardVideoActivity.this.sP;
                if (!sj4.TKC) {
                    if (sj4.sP.WM()) {
                        TTRewardVideoActivity.this.sP.Mts.TKC();
                        return;
                    }
                    if (!com.bytedance.sdk.openadsdk.core.model.sU.HiB(TTRewardVideoActivity.this.sP.sP)) {
                        TTRewardVideoActivity.this.sP.f21074ib.Sj("skip", true);
                    }
                    TTRewardVideoActivity.this.finish();
                    return;
                }
                if (sj4.sP.WM()) {
                    TTRewardVideoActivity.this.sP.Mts.TKC();
                    return;
                }
                TTRewardVideoActivity.this.Sj(false, 5);
                if (com.bytedance.sdk.openadsdk.core.model.sU.HiB(TTRewardVideoActivity.this.sP.sP)) {
                    return;
                }
                TTRewardVideoActivity.this.sP.f21074ib.Sj("skip", true);
            }

            @Override // u5.b.InterfaceC0963b
            public void Sj(long j12, long j13) {
                com.bytedance.sdk.openadsdk.core.model.sU sUVar;
                com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj3 = TTRewardVideoActivity.this.sP;
                if (!sj3.qRN && sj3.f21074ib.sP()) {
                    TTRewardVideoActivity.this.sP.f21074ib.uvD();
                }
                if (TTRewardVideoActivity.this.sP.TEQ.get()) {
                    return;
                }
                TTRewardVideoActivity.this.EjP.removeMessages(300);
                if (j12 != TTRewardVideoActivity.this.sP.f21074ib.Dq()) {
                    TTRewardVideoActivity.this.dNu();
                }
                TTRewardVideoActivity.this.sP.f21074ib.Sj(j12, j13);
                TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                long j14 = j12 / 1000;
                double d11 = j14;
                tTRewardVideoActivity.vS = (int) (tTRewardVideoActivity.sP.f21074ib.Yf() - d11);
                TTRewardVideoActivity tTRewardVideoActivity2 = TTRewardVideoActivity.this;
                int i11 = tTRewardVideoActivity2.vS;
                if (i11 >= 0) {
                    tTRewardVideoActivity2.sP.Mts.Sj(String.valueOf(i11), null);
                }
                TTRewardVideoActivity tTRewardVideoActivity3 = TTRewardVideoActivity.this;
                tTRewardVideoActivity3.vS = (int) (tTRewardVideoActivity3.sP.f21074ib.Yf() - d11);
                int i12 = (int) j14;
                com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj4 = TTRewardVideoActivity.this.sP;
                int TEQ = (sj4 == null || (sUVar = sj4.sP) == null || sUVar.sP() < 0) ? TTRewardVideoActivity.this.sP != null ? dNu.EjP().TEQ(String.valueOf(TTRewardVideoActivity.this.sP.vS)) : 30 : TTRewardVideoActivity.this.sP.sP.sP();
                boolean z11 = TEQ >= 0;
                if ((TTRewardVideoActivity.this.sP.sU.get() || TTRewardVideoActivity.this.sP.Ym.get()) && TTRewardVideoActivity.this.sP.f21074ib.sP()) {
                    TTRewardVideoActivity.this.sP.f21074ib.uvD();
                }
                TTRewardVideoActivity.this.sP.Wjd.EjP(i12);
                TTRewardVideoActivity.this.sP(j12, j13);
                TTRewardVideoActivity tTRewardVideoActivity4 = TTRewardVideoActivity.this;
                if (tTRewardVideoActivity4.vS > 0) {
                    tTRewardVideoActivity4.sP.Mts.EjP(true);
                    if (!z11 || i12 < TEQ) {
                        TTRewardVideoActivity tTRewardVideoActivity5 = TTRewardVideoActivity.this;
                        tTRewardVideoActivity5.sP.Mts.Sj(String.valueOf(tTRewardVideoActivity5.vS), null);
                    } else {
                        TTRewardVideoActivity.this.sP.Sj(true);
                        TTRewardVideoActivity tTRewardVideoActivity6 = TTRewardVideoActivity.this;
                        tTRewardVideoActivity6.sP.Mts.Sj(String.valueOf(tTRewardVideoActivity6.vS), TTAdDislikeToast.getSkipText());
                        TTRewardVideoActivity.this.sP.Mts.HiB(true);
                    }
                }
            }

            @Override // u5.b.InterfaceC0963b
            public void sP(long j12, int i11) {
                TTRewardVideoActivity.this.EjP.removeMessages(300);
                com.bytedance.sdk.openadsdk.core.model.TzV tzV = TTRewardVideoActivity.this.sP.Wjd.Zq;
                if (tzV != null) {
                    tzV.TEQ();
                }
                if (TTRewardVideoActivity.this.sP.f21074ib.sP()) {
                    TTRewardVideoActivity.this.uvD();
                    return;
                }
                TTRewardVideoActivity.this.sP.f21074ib.sef();
                TTRewardVideoActivity.this.dx();
                TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                if (tTRewardVideoActivity.sP.TKC) {
                    tTRewardVideoActivity.Sj(false, true, 3);
                } else {
                    tTRewardVideoActivity.finish();
                }
                com.bytedance.sdk.openadsdk.component.reward.Sj.dNu dnu = TTRewardVideoActivity.this.sP.f21074ib;
                dnu.Sj(!dnu.LqL() ? 1 : 0, 2);
            }
        };
        this.sP.f21074ib.Sj(interfaceC0963b);
        com.bytedance.sdk.openadsdk.core.model.TzV tzV = this.sP.Wjd.Zq;
        if (tzV != null) {
            tzV.Sj(interfaceC0963b);
        }
        boolean Sj = this.sP.f21074ib.Sj(j11, z10, null, this.TKC);
        if (Sj && !z10) {
            this.Ym = (int) (System.currentTimeMillis() / 1000);
        }
        return Sj;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void TKC() {
        this.sP.Mts.Sj(null, TTAdDislikeToast.getSkipText());
        this.sP.Mts.HiB(true);
    }

    protected void TKC(final int i11) {
        if (this.zR.get() || this.kF) {
            return;
        }
        this.zR.set(true);
        Ym ym2 = this.sP.f21077tz;
        if (ym2 != null) {
            ym2.TKC();
        }
        if (dNu.EjP().uvD(String.valueOf(this.sP.vS))) {
            Sj(true, this.sP.sP.wE(), this.sP.sP.uP(), 0, "", i11);
        } else {
            dNu.TKC().Sj(kF(), new RiZ.sP() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.9
                @Override // com.bytedance.sdk.openadsdk.core.RiZ.sP
                public void Sj(int i12, String str) {
                    TTRewardVideoActivity.this.Sj(false, 0, "", i12, str, i11);
                }

                @Override // com.bytedance.sdk.openadsdk.core.RiZ.sP
                public void Sj(sU.sP sPVar) {
                    boolean z10 = sPVar.sP;
                    TTRewardVideoActivity.this.Sj(sPVar.sP, sPVar.TKC.Sj(), sPVar.TKC.sP(), 0, "", i11);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void TzV() {
        final View TEQ = this.sP.Wjd.TEQ();
        if (TEQ != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.4
                /* JADX WARN: Removed duplicated region for block: B:24:0x00ef A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:25:0x00f0  */
                @Override // android.view.View.OnClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void onClick(android.view.View r5) {
                    /*
                        Method dump skipped, instructions count: 291
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.AnonymousClass4.onClick(android.view.View):void");
                }
            };
            TEQ.setOnClickListener(onClickListener);
            TEQ.setTag(TEQ.getId(), onClickListener);
        }
        this.sP.Mts.Sj(new com.bytedance.sdk.openadsdk.component.reward.top.sP() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.5
            @Override // com.bytedance.sdk.openadsdk.component.reward.top.sP
            public void Sj(View view) {
                if (TTRewardVideoActivity.this.sP.sP.yr()) {
                    if (TTRewardVideoActivity.this.sP.Wjd.Ym() != null) {
                        TTRewardVideoActivity.this.sP.sP.xD(2);
                        TTRewardVideoActivity.this.sP.Wjd.dNu();
                        return;
                    }
                    return;
                }
                com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = TTRewardVideoActivity.this.sP;
                if (!sj2.TKC && sj2.sP.Snq() && !TTRewardVideoActivity.this.sP.sP.Ph()) {
                    TTRewardVideoActivity.this.sP.sP.xD(13);
                    try {
                        TTRewardVideoActivity.this.sP.Wjd.dNu();
                        return;
                    } catch (Exception unused) {
                    }
                }
                TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                tTRewardVideoActivity.Sj(uP.TKC(tTRewardVideoActivity.sP.sP), false);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.sP
            public void Sj(View view, String str) {
                com.bytedance.sdk.openadsdk.component.reward.sP.sP sPVar = TTRewardVideoActivity.this.TKC;
                if (sPVar != null && sPVar.EjP() != null) {
                    TTRewardVideoActivity.this.TKC.EjP().Sj(TTRewardVideoActivity.this.sP.ndK);
                }
                TTRewardVideoActivity.this.sP.ndK = !r3.ndK;
                StringBuilder sb2 = new StringBuilder("will set is Mute ");
                sb2.append(TTRewardVideoActivity.this.sP.ndK);
                sb2.append(" mLastVolume=");
                sb2.append(TTRewardVideoActivity.this.sP.fF.Sj());
                com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = TTRewardVideoActivity.this.sP;
                sj2.f21074ib.Sj(sj2.ndK, str);
                if (!uP.RiZ(TTRewardVideoActivity.this.sP.sP) || TTRewardVideoActivity.this.sP.TEQ.get()) {
                    com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj3 = TTRewardVideoActivity.this.sP;
                    sj3.JcM.HiB(sj3.ndK);
                    com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj4 = TTRewardVideoActivity.this.sP;
                    sj4.uP.vS(sj4.ndK);
                    com.bytedance.sdk.openadsdk.core.model.sU sUVar = TTRewardVideoActivity.this.sP.sP;
                    if (sUVar == null || sUVar.GMp() == null || TTRewardVideoActivity.this.sP.sP.GMp().Sj() == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj5 = TTRewardVideoActivity.this.sP;
                    if (sj5.f21074ib != null) {
                        if (sj5.ndK) {
                            sj5.sP.GMp().Sj().Dq(TTRewardVideoActivity.this.sP.f21074ib.Jcg());
                        } else {
                            sj5.sP.GMp().Sj().uA(TTRewardVideoActivity.this.sP.f21074ib.Jcg());
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
                TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                tTRewardVideoActivity.sP.LD.Sj(tTRewardVideoActivity.TKC);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void Zq() {
        com.bytedance.sdk.openadsdk.component.reward.view.sP Sj;
        super.Zq();
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.sP;
        if (sj2 == null || (Sj = sj2.wE.Sj()) == null) {
            return;
        }
        Sj.setJsbLandingPageOpenListener(new com.bytedance.sdk.openadsdk.core.widget.HiB() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.HiB
            public void Sj() {
                TTRewardVideoActivity.this.ib();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.core.aa.EjP.sP
    public void aa() {
        dx();
    }

    @Override // com.bytedance.sdk.openadsdk.core.aa.EjP.sP
    public void c_() {
        ib();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dx() {
        TKC(0);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        f21048dx = null;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void finish() {
        if (this.sP != null) {
            com.bytedance.sdk.openadsdk.vS.sP.Sj().Sj("videoForceBreak", this.sP.sP);
        }
        uP();
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2;
        com.bytedance.sdk.openadsdk.core.model.sU sUVar;
        super.onCreate(bundle);
        try {
            if (sef == null) {
                sef = com.bytedance.sdk.component.utils.ib.Sj(this, "tt_reward_msg");
                Zq = com.bytedance.sdk.component.utils.ib.Sj(this, "tt_msgPlayable");
                uvD = com.bytedance.sdk.component.utils.ib.Sj(this, "tt_negtiveBtnBtnText");
                dNu = com.bytedance.sdk.component.utils.ib.Sj(this, "tt_postiveBtnText");
                TzV = com.bytedance.sdk.component.utils.ib.Sj(this, "tt_postiveBtnTextPlayable");
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.sU.sP("TTAD.RVA", th2.getMessage());
        }
        if (bundle == null || (sj2 = this.sP) == null || (sUVar = sj2.sP) == null || !sUVar.KTL()) {
            return;
        }
        this.zR.set(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        uP();
        if (com.bytedance.sdk.openadsdk.multipro.sP.TKC()) {
            Sj("recycleRes");
        }
        this.Fmk = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onPause() {
        Ym ym2;
        super.onPause();
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.sP;
        if (sj2 == null || (ym2 = sj2.f21077tz) == null) {
            return;
        }
        ym2.Sj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onResume() {
        Ym ym2;
        super.onResume();
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.sP;
        if (sj2 == null || (ym2 = sj2.f21077tz) == null) {
            return;
        }
        ym2.sP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2;
        if (bundle == null) {
            bundle = new Bundle();
        }
        f21048dx = this.Fmk;
        if (this.zR.get() && (sj2 = this.sP) != null) {
            sj2.sP.caU();
        }
        super.onSaveInstanceState(bundle);
    }

    public void sP(long j11, long j12) {
        com.bytedance.sdk.openadsdk.core.model.sU sUVar;
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.sP;
        boolean z10 = false;
        if (sj2 != null && (sUVar = sj2.sP) != null) {
            if (sUVar.LqL() >= 0 && this.sP.sP.sP() >= 0) {
                z10 = true;
            }
            if (z10) {
                j12 = this.sP.sP.sP();
            }
        }
        long j13 = j11 + (this.sP.UHs * 1000);
        if (z10) {
            Sj(j13, j12);
            return;
        }
        if (this.f21050ib == -1) {
            this.f21050ib = dNu.EjP().ley(String.valueOf(this.sP.vS)).vS;
        }
        if (j12 <= 0) {
            return;
        }
        if (j12 >= 30000 && j13 >= 27000) {
            dx();
        } else if (((float) (j13 * 100)) / ((float) j12) >= this.f21050ib) {
            dx();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0084, code lost:
    
        if (r1 != false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0033, code lost:
    
        if (((1.0d - (r8.vS / r8.sP.f21074ib.Yf())) * 100.0d) >= r0) goto L8;
     */
    @Override // com.bytedance.sdk.openadsdk.core.aa.EjP.sP
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void sef() {
        /*
            r8 = this;
            com.bytedance.sdk.openadsdk.core.settings.vS r0 = com.bytedance.sdk.openadsdk.core.dNu.EjP()
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r1 = r8.sP
            int r1 = r1.vS
            java.lang.String r1 = java.lang.String.valueOf(r1)
            com.bytedance.sdk.openadsdk.core.settings.sP r0 = r0.ley(r1)
            int r0 = r0.vS
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r1 = r8.sP
            com.bytedance.sdk.openadsdk.core.model.sU r1 = r1.sP
            boolean r1 = com.bytedance.sdk.openadsdk.core.model.uP.RiZ(r1)
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L39
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r1 = r8.sP
            com.bytedance.sdk.openadsdk.component.reward.Sj.dNu r1 = r1.f21074ib
            double r4 = r1.Yf()
            int r1 = r8.vS
            double r6 = (double) r1
            double r6 = r6 / r4
            r4 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r4 = r4 - r6
            r6 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r4 = r4 * r6
            double r0 = (double) r0
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 < 0) goto L36
            goto L37
        L36:
            r2 = r3
        L37:
            r3 = r2
            goto L8a
        L39:
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r1 = r8.sP
            com.bytedance.sdk.openadsdk.core.model.sU r1 = r1.sP
            int r1 = r1.oWa()
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r4 = r8.sP
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
            if (r0 < 0) goto L58
            r0 = r2
            goto L59
        L58:
            r0 = r3
        L59:
            com.bytedance.sdk.openadsdk.core.settings.vS r1 = com.bytedance.sdk.openadsdk.core.dNu.EjP()
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r4 = r8.sP
            int r4 = r4.vS
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r1 = r1.Sj(r4)
            if (r1 != 0) goto L87
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r1 = r8.sP
            com.bytedance.sdk.openadsdk.component.reward.Sj.TzV r1 = r1.JcM
            com.bytedance.sdk.openadsdk.core.Yf r1 = r1.aa()
            boolean r1 = r1.vS()
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r4 = r8.sP
            com.bytedance.sdk.openadsdk.component.reward.Sj.Dq r4 = r4.uP
            boolean r4 = r4.TKC()
            if (r4 == 0) goto L82
            r1 = r2
        L82:
            if (r0 == 0) goto L36
            if (r1 == 0) goto L36
            goto L37
        L87:
            if (r1 != r2) goto L8a
            r3 = r0
        L8a:
            if (r3 == 0) goto L8f
            r8.dx()
        L8f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.sef():void");
    }
}

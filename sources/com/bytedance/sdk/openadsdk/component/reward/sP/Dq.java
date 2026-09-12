package com.bytedance.sdk.openadsdk.component.reward.sP;

import android.app.Activity;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.datastore.preferences.protobuf.DescriptorProtos$Edition;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.core.model.TzV;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.core.model.uP;
import com.bytedance.sdk.openadsdk.core.model.uvD;
import com.bytedance.sdk.openadsdk.utils.Mts;
import com.bytedance.sdk.openadsdk.utils.Zq;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class Dq extends sP {
    private String TzV;
    private final int Zq;
    private com.bytedance.sdk.openadsdk.component.reward.view.HiB dNu;
    private ViewGroup uvD;

    public Dq(com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2) {
        super(sj2);
        this.TzV = "fullscreen_interstitial_ad";
        this.Zq = this.sP.HcZ();
    }

    private boolean JcM() {
        sU sUVar = this.sP;
        return sUVar != null && sUVar.ley() == 2;
    }

    private void LD() {
        if (this.uvD == null) {
            return;
        }
        Sj((View) this.dNu);
    }

    private void Sj(ImageView imageView) {
        List<uvD> Bml;
        uvD uvd;
        sU sUVar = this.sP;
        if (sUVar == null || (Bml = sUVar.Bml()) == null || Bml.size() <= 0 || (uvd = Bml.get(0)) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.uA.EjP.Sj(Bml.get(0)).TKC(2).Sj(com.bytedance.sdk.openadsdk.uA.TKC.Sj(this.sP, uvd.Sj(), imageView));
    }

    public static boolean Sj(sU sUVar) {
        return !sU.HiB(sUVar) && sUVar.tY() == 100.0f;
    }

    private com.bytedance.sdk.openadsdk.RiZ.Sj.Sj.vS TKC(sU sUVar) {
        if (sUVar.sdp() == 4) {
            return new com.bytedance.sdk.openadsdk.RiZ.Sj.Sj.EjP(dNu.Sj(), sUVar, this.TzV);
        }
        return null;
    }

    private void Yf() {
        FrameLayout frameLayout = new FrameLayout(this.Sj.Fm);
        this.uvD = frameLayout;
        frameLayout.setId(Zq.Hs);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.uvD.setLayoutParams(layoutParams);
        View Ym = this.Sj.Wjd.Ym();
        if (Ym != null) {
            layoutParams.bottomMargin = Ym.getHeight();
        }
        com.bytedance.sdk.openadsdk.component.reward.view.HiB hiB = new com.bytedance.sdk.openadsdk.component.reward.view.HiB(this.Sj.Fm);
        this.dNu = hiB;
        hiB.setId(Zq.liH);
        FrameLayout.LayoutParams layoutParams2 = this.Sj.sP.liH() == 1 ? new FrameLayout.LayoutParams(-1, -2) : new FrameLayout.LayoutParams(-2, -1);
        layoutParams2.gravity = 17;
        this.dNu.setLayoutParams(layoutParams2);
        this.uvD.addView(this.dNu);
        LD();
    }

    private void fF() {
        uvD uvd;
        List<uvD> Bml = this.sP.Bml();
        if (Bml == null || Bml.size() <= 0 || (uvd = Bml.get(0)) == null) {
            return;
        }
        try {
            int sP = uvd.sP();
            int TKC = uvd.TKC();
            if (sP != 0 && TKC != 0) {
                this.dNu.setRatio(sP / TKC);
                return;
            }
            int i11 = this.Zq;
            if (i11 == 33) {
                this.dNu.setRatio(1.0f);
            } else if (i11 == 3) {
                this.dNu.setRatio(1.91f);
            } else {
                this.dNu.setRatio(0.56f);
            }
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.sU.sP("TTAD.RFTI", e11.getMessage());
        }
    }

    private void sP(sU sUVar) {
        if (sUVar == null || this.dNu == null) {
            return;
        }
        fF();
        Sj((ImageView) this.dNu);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.sP.sP
    public boolean HiB() {
        return JcM() || uP.Jcg(this.sP);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.sP.sP
    public void Jcg() {
        if (TzV.sP(this.sP)) {
            this.vS.sP(8);
        }
        this.Dq.TKC(false);
        this.Dq.EjP(false);
        if (this.sP.ley() == 2) {
            this.Dq.Sj(false);
            this.vS.HiB(8);
            return;
        }
        this.Dq.Sj(this.sP.RrR());
        if (this.Sj.Uc) {
            Message obtain = Message.obtain();
            obtain.what = DescriptorProtos$Edition.EDITION_LEGACY_VALUE;
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.Sj;
            int Yf = (int) (sj2.f21074ib.Yf() * 1000.0d);
            sj2.uA = Yf;
            obtain.arg1 = Yf;
            this.Sj.HpB.sendMessage(obtain);
        }
    }

    protected void Sj(View view) {
        if (view == null || this.Sj.Fm == null || this.sP == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.sP.sP sPVar = this.f21091aa;
        if (sPVar == null) {
            Activity activity = this.Sj.Fm;
            sU sUVar = this.sP;
            String str = this.TzV;
            sPVar = new com.bytedance.sdk.openadsdk.core.sP.Sj(activity, sUVar, str, Mts.Sj(str));
            sPVar.Sj(TKC(this.sP));
            HashMap hashMap = new HashMap();
            if (uP.TzV(this.sP)) {
                hashMap.put("click_scence", 3);
            } else {
                hashMap.put("click_scence", 1);
            }
            sPVar.Sj(hashMap);
        }
        Activity activity2 = this.Sj.Fm;
        if (activity2 != null) {
            sPVar.Sj(activity2);
        }
        view.setOnTouchListener(sPVar);
        view.setOnClickListener(sPVar);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.sP.sP
    public void Sj(FrameLayout frameLayout) {
        try {
            Yf();
            sP(this.sP);
            frameLayout.addView(this.uvD);
        } catch (Exception e11) {
            Log.e("TTAD.RFTI", "bindAd: ", e11);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.sP.sP
    public void Sj(com.bytedance.sdk.openadsdk.component.reward.view.Jcg jcg) {
        if (TzV.sP(this.sP)) {
            EjP.Sj(jcg, this.sP);
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.Sj;
            sj2.f21078xu.Sj((long) (sj2.f21074ib.Yf() * 1000.0d));
        } else {
            if (!TzV.EjP(this.sP) && !TzV.HiB(this.sP)) {
                super.Sj(jcg);
                return;
            }
            EjP.sP(jcg, this.sP);
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj3 = this.Sj;
            sj3.f21078xu.Sj((long) (sj3.f21074ib.Yf() * 1000.0d));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.sP.sP
    public boolean vS() {
        return JcM();
    }
}

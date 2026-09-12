package com.bytedance.sdk.openadsdk.component.reward.sP;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import androidx.datastore.preferences.protobuf.DescriptorProtos$Edition;
import com.bytedance.sdk.component.utils.LqL;
import com.bytedance.sdk.openadsdk.EjP.sP;
import com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.common.Fmk;
import com.bytedance.sdk.openadsdk.component.reward.Sj.aa;
import com.bytedance.sdk.openadsdk.component.reward.Sj.sef;
import com.bytedance.sdk.openadsdk.component.reward.view.RFEndCardBackUpLayout;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.core.model.TzV;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.core.model.uP;
import com.bytedance.sdk.openadsdk.core.model.uvD;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.FPG;
import com.bytedance.sdk.openadsdk.utils.Zq;
import com.google.logging.type.LogSeverity;
import java.util.List;
import java.util.Objects;
import y5.b;

/* loaded from: classes3.dex */
public abstract class sP extends com.bytedance.sdk.openadsdk.component.reward.sP.Sj {
    public com.bytedance.sdk.openadsdk.core.widget.sP Fmk;
    protected String Ym;
    private com.bytedance.sdk.openadsdk.aa.vS Zq;

    /* renamed from: aa, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.sP.HiB f21091aa;
    public LinearLayout sef;

    /* loaded from: classes3.dex */
    public interface Sj {
        void Sj(boolean z10);
    }

    public sP(com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2) {
        super(sj2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static FrameLayout Sj(Context context) {
        com.bytedance.sdk.openadsdk.core.HiB.TKC tkc = new com.bytedance.sdk.openadsdk.core.HiB.TKC(context);
        tkc.setId(Zq.Ym);
        tkc.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        tkc.setLayoutParams(layoutParams);
        return tkc;
    }

    private void Sj(long j11, long j12) {
        long j13 = j12 - j11;
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.Sj;
        Activity activity = sj2.Fm;
        if (activity instanceof TTRewardVideoActivity) {
            ((TTRewardVideoActivity) activity).sP(j13, j12);
            return;
        }
        com.bytedance.sdk.openadsdk.core.aa.EjP.sP sPVar = sj2.f21075jb;
        if (sPVar instanceof com.bytedance.sdk.openadsdk.activity.HiB) {
            ((com.bytedance.sdk.openadsdk.activity.HiB) sPVar).Sj(j13, j12);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void Sj(FrameLayout frameLayout, final com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2) {
        final com.bytedance.sdk.openadsdk.core.HiB.EjP ejP;
        Context context = frameLayout.getContext();
        if (sj2.Uc) {
            com.bytedance.sdk.openadsdk.core.HiB.TKC tkc = new com.bytedance.sdk.openadsdk.core.HiB.TKC(context);
            tkc.setId(Zq.TEQ);
            frameLayout.addView(tkc, new FrameLayout.LayoutParams(-1, -1));
            FrameLayout Sj2 = Sj(context);
            String str = "";
            if (sU.HiB(sj2.sP)) {
                b UHs = sj2.sP.UHs();
                if (UHs != null) {
                    str = UHs.r();
                }
            } else {
                List<uvD> Bml = sj2.sP.Bml();
                if (Bml != null && !Bml.isEmpty()) {
                    str = Bml.get(0).Sj();
                }
            }
            if (TextUtils.isEmpty(str)) {
                ejP = null;
            } else {
                ejP = new com.bytedance.sdk.openadsdk.core.HiB.EjP(context);
                int i11 = Zq.roy;
                ejP.setId(i11);
                ejP.setTag(i11, str);
                ejP.setScaleType(ImageView.ScaleType.CENTER_CROP);
                Sj2.addView(ejP);
            }
            tkc.addView(Sj2);
            View tkc2 = new com.bytedance.sdk.openadsdk.component.reward.view.TKC(context);
            tkc2.setId(Zq.f21209aa);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            frameLayout.addView(tkc2, layoutParams);
            tkc2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.sP.sP.3
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
                    int height = view.getHeight();
                    if (height <= 0) {
                        return;
                    }
                    View findViewById = com.bytedance.sdk.openadsdk.component.reward.Sj.Sj.this.xD.findViewById(520093757);
                    if (findViewById != null) {
                        ViewGroup.LayoutParams layoutParams2 = findViewById.getLayoutParams();
                        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                            ((FrameLayout.LayoutParams) layoutParams2).bottomMargin = height;
                        }
                    }
                    View findViewById2 = com.bytedance.sdk.openadsdk.component.reward.Sj.Sj.this.xD.findViewById(Zq.Ss);
                    if (findViewById2 != null) {
                        ViewGroup.LayoutParams layoutParams3 = findViewById2.getLayoutParams();
                        if (layoutParams3 instanceof FrameLayout.LayoutParams) {
                            ((FrameLayout.LayoutParams) layoutParams3).bottomMargin = height;
                        }
                    }
                    View findViewById3 = com.bytedance.sdk.openadsdk.component.reward.Sj.Sj.this.xD.findViewById(Zq.Hs);
                    if (findViewById3 != null) {
                        ViewGroup.LayoutParams layoutParams4 = findViewById3.getLayoutParams();
                        if (layoutParams4 instanceof FrameLayout.LayoutParams) {
                            ((FrameLayout.LayoutParams) layoutParams4).bottomMargin = height;
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.HiB.EjP ejP2 = ejP;
                    if (ejP2 != null) {
                        ViewGroup.LayoutParams layoutParams5 = ejP2.getLayoutParams();
                        if (layoutParams5 instanceof ViewGroup.MarginLayoutParams) {
                            ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin = height;
                            ejP.setLayoutParams(layoutParams5);
                        }
                    }
                }
            });
            com.bytedance.sdk.openadsdk.core.HiB.HiB hiB = new com.bytedance.sdk.openadsdk.core.HiB.HiB(context);
            hiB.setId(Zq.Fmk);
            hiB.setOrientation(1);
            hiB.setVisibility(8);
            frameLayout.addView(hiB, new FrameLayout.LayoutParams(-1, -1));
        }
        if (sj2.xhi) {
            View vSVar = new com.bytedance.sdk.component.uA.vS(context, true);
            vSVar.setId(Zq.sef);
            vSVar.setLayerType(2, null);
            vSVar.setVisibility(4);
            frameLayout.addView(vSVar, new FrameLayout.LayoutParams(-1, -1));
            View frameLayout2 = new FrameLayout(context);
            frameLayout2.setId(Zq.Zq);
            frameLayout2.setVisibility(4);
            frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
            if (uP.sP(sj2.sP)) {
                View tkc3 = new com.bytedance.sdk.openadsdk.core.HiB.TKC(context);
                tkc3.setId(Zq.yfI);
                tkc3.setVisibility(4);
                frameLayout.addView(tkc3, new FrameLayout.LayoutParams(-1, -1));
            }
        }
        View vSVar2 = new com.bytedance.sdk.component.uA.vS(context, true);
        vSVar2.setId(Zq.uvD);
        vSVar2.setVisibility(8);
        frameLayout.addView(vSVar2, new FrameLayout.LayoutParams(-1, -1));
    }

    public RFEndCardBackUpLayout Dq() {
        return new RFEndCardBackUpLayout(this.Sj.Ei);
    }

    public Sj EjP() {
        return null;
    }

    public void Fmk() {
    }

    public abstract boolean HiB();

    public abstract void Jcg();

    protected boolean LqL() {
        return true;
    }

    public void RiZ() {
    }

    public void Sj(int i11) {
        this.HiB.sef();
        Sj(false, true, false, i11);
        if (this.Sj.EjP) {
            this.uA.Sj(10000);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Sj(android.os.Message r13) {
        /*
            Method dump skipped, instructions count: 609
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.sP.sP.Sj(android.os.Message):void");
    }

    public abstract void Sj(FrameLayout frameLayout);

    public void Sj(com.bytedance.sdk.openadsdk.aa.vS vSVar) {
        this.Zq = vSVar;
        TKC();
        if (!this.Sj.sP.Ph() && LqL()) {
            ley();
        }
        if (LqL()) {
            this.Sj.FPG.sP();
        }
        if (TzV.EjP(this.Sj.sP) || TzV.HiB(this.Sj.sP)) {
            this.TEQ.sendEmptyMessageDelayed(500, 100L);
        }
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.Sj;
        sj2.Wjd.Sj(sj2.MuB == 100.0f);
        uP();
        Jcg();
    }

    public void Sj(com.bytedance.sdk.openadsdk.component.reward.view.Jcg jcg) {
        Sj(jcg, this.Sj);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.sP.Sj
    public void Sj(com.bytedance.sdk.openadsdk.core.aa.EjP.sP sPVar, LqL lqL) {
        super.Sj(sPVar, lqL);
        if (this.Sj.sP.EjP()) {
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.Sj;
            if (sj2.Uc) {
                sj2.JcM.Sj(false);
            }
        }
        if (uP.TzV(this.Sj.sP)) {
            this.Sj.uP.aa();
        }
    }

    public void Sj(boolean z10, boolean z11, boolean z12, int i11) {
        this.Sj.FPG.Sj(z10, z11, z12, this, i11);
    }

    public View TEQ() {
        com.bytedance.sdk.openadsdk.core.HiB.Jcg jcg;
        if (this.sP.FPG() != 5) {
            jcg = new com.bytedance.sdk.openadsdk.core.HiB.Jcg(this.Sj.Fm);
            jcg.setId(Zq.TT);
        } else {
            jcg = null;
        }
        Objects.toString(jcg);
        return jcg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void TzV() {
        int i11;
        if (this.Sj.TEQ.get()) {
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.Sj;
            if (!sj2.Jcg && sj2.f21073dx.getAndSet(false) && ((i11 = this.Sj.Dq) >= 0 || i11 == -1)) {
                Message obtain = Message.obtain();
                obtain.what = LogSeverity.ALERT_VALUE;
                com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj3 = this.Sj;
                obtain.arg1 = sj3.Dq;
                sj3.HpB.sendMessage(obtain);
            }
        }
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj4 = this.Sj;
        if (sj4.uA <= 0 || !sj4.zR.getAndSet(false)) {
            return;
        }
        Message obtain2 = Message.obtain();
        obtain2.what = DescriptorProtos$Edition.EDITION_LEGACY_VALUE;
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj5 = this.Sj;
        obtain2.arg1 = sj5.uA;
        sj5.HpB.sendMessage(obtain2);
    }

    public void Ym() {
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.Sj;
        sj2.ley.Sj(sj2.EjP);
        this.Sj.Wjd.sP();
        this.Sj.FPG.Sj();
        if (!this.Sj.sP.Ph()) {
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj3 = this.Sj;
            if (sj3.Jcg && TextUtils.isEmpty(sU.Sj(sj3.Ei, this.sP))) {
                aa();
            }
            this.Sj.JcM.Sj();
            this.Sj.WMZ.Sj();
        }
        this.Sj.uP.Zq();
        this.Sj.Mts.Sj();
        if (uP.Jcg(this.Sj.sP)) {
            com.bytedance.sdk.component.uA.vS TEQ = this.Sj.JcM.TEQ();
            if (TEQ != null) {
                TEQ.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.Sj.JcM.Ym().setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            this.Sj.Mts.TKC(true);
            if (uP.TzV(this.Sj.sP)) {
                this.Sj.Wjd.EjP();
                FPG.Sj((View) TEQ, 4);
                FPG.Sj((View) this.Sj.JcM.Ym(), 0);
            }
        }
        if (uP.vS(this.Sj.sP)) {
            this.Sj.Wjd.EjP();
            FPG.Sj((View) this.Sj.JcM.TEQ(), 4);
        }
        if (TzV.EjP(this.Sj.sP) || TzV.sP(this.Sj.sP) || TzV.HiB(this.Sj.sP)) {
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj4 = this.Sj;
        sj4.Wjd.Sj(FPG.sP(sj4.Ei, sj4.IOh), FPG.sP(this.Sj.Ei, r4.pfr));
        this.Sj.kF.Sj();
        if (uP.TzV(this.Sj.sP)) {
            this.Sj.JcM.Sj(true);
            this.Sj.JcM.HiB();
            Sj(false, false, false, sP.C0246sP.TKC);
        } else {
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj5 = this.Sj;
            if (sj5.cX) {
                sj5.Wjd.Sj(0);
            }
        }
    }

    public void Zq() {
        com.bytedance.sdk.openadsdk.activity.vS vSVar;
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.Sj;
        if (sj2.Jcg) {
            return;
        }
        sj2.Mts.HiB();
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj3 = this.Sj;
        if (!sj3.Ir || (vSVar = sj3.HS) == null || vSVar.kF()) {
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj4 = this.Sj;
            if (sj4.gR && (sj4.HS instanceof com.bytedance.sdk.openadsdk.activity.Sj)) {
                return;
            }
            sj4.Wjd.HiB(0);
        }
    }

    public void aa() {
        LinearLayout linearLayout = (LinearLayout) this.Sj.xD.findViewById(Zq.Fmk);
        this.sef = linearLayout;
        FPG.Sj((View) linearLayout, 8);
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.Sj;
        sj2.aNB = new Fmk(sj2.Fm, sj2.sP, "landingpage_endcard");
        this.Sj.aNB.TKC().setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.sP.sP.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                sP.this.Sj.Wjd.TEQ().performClick();
            }
        });
        this.sef.addView(this.Sj.aNB.HiB(), new LinearLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj3 = this.Sj;
        sj3.JcM.Sj(sj3.aNB);
    }

    public void dNu() {
        if (!uP.TEQ(this.sP) || this.Sj.JcM.xD()) {
            TzV();
        }
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.Sj;
        if (sj2 == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.utils.Fmk fmk = sj2.f21078xu;
        if (fmk != null) {
            fmk.Sj();
        }
        this.Sj.Sj();
    }

    public void dx() {
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.Sj;
        if (sj2 == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.view.TEQ teq = sj2.Wjd;
        if (teq != null) {
            teq.uvD();
        }
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj3 = this.Sj;
        boolean z10 = sj3.ndK;
        sj3.fF.Sj();
        DeviceUtils.Jcg();
        this.Sj.JcM.sU();
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj4 = this.Sj;
        if (sj4.ndK) {
            sj4.Fm.runOnUiThread(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.sP.sP.2
                @Override // java.lang.Runnable
                public void run() {
                    if (sP.this.Sj.fF.Sj() > 0) {
                        sP.this.Sj.fF.Sj(false);
                    }
                }
            });
        }
    }

    public void ib() {
        com.bytedance.sdk.openadsdk.component.reward.Sj.Dq dq2;
        sef sefVar;
        if (dNu.EjP().dx(String.valueOf(this.Sj.vS)) == 1) {
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.Sj;
            int Sj2 = sj2.EjP ? uP.TKC(sj2.sP) ? dNu.EjP().Sj(String.valueOf(this.Sj.vS), true) : this.Sj.sP.sP() >= 0 ? this.Sj.sP.sP() : dNu.EjP().TEQ(String.valueOf(this.Sj.vS)) : uP.TKC(sj2.sP) ? dNu.EjP().Sj(String.valueOf(this.Sj.vS), false) : this.Sj.sP.Sj() >= 0 ? this.Sj.sP.Sj() : dNu.EjP().RiZ(String.valueOf(this.Sj.vS));
            com.bytedance.sdk.openadsdk.component.reward.view.TEQ teq = this.Sj.Wjd;
            if (teq != null && teq.uA()) {
                com.bytedance.sdk.openadsdk.component.reward.view.TEQ teq2 = this.Sj.Wjd;
                if (teq2 != null) {
                    teq2.TEQ().performClick();
                    return;
                }
                return;
            }
            if ((!this.Sj.TEQ.get() || uP.TKC(this.Sj.sP)) && Sj2 != -1) {
                com.bytedance.sdk.openadsdk.component.reward.Sj.dNu dnu = this.Sj.f21074ib;
                if (((dnu == null || dnu.Dq() < Sj2 * 1000) && ((dq2 = this.Sj.uP) == null || !dq2.EjP(Sj2))) || (sefVar = this.Sj.Mts) == null) {
                    return;
                }
                sefVar.EjP();
            }
        }
    }

    public void kF() {
        this.Sj.Mts.TKC();
        this.Sj.Mts.HiB(true);
    }

    public final void ley() {
        if (this.Sj.Fm.isFinishing()) {
            return;
        }
        this.Sj.JcM.Zq();
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.Sj;
        String str = sj2.EjP ? "reward_endcard" : "fullscreen_endcard";
        sj2.JcM.Sj(this.Zq, str, sj2.f21075jb);
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj3 = this.Sj;
        sj3.uP.Sj(this.Zq, sj3.ndK);
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj4 = this.Sj;
        sj4.JcM.Sj(str, sj4.f21075jb);
        this.Sj.JcM.HiB();
    }

    public void sU() {
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.Sj;
        if (sj2 == null) {
            return;
        }
        sj2.qRN = false;
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj3 = this.Sj;
        boolean z10 = sj3.qRN;
        boolean z11 = sj3.ndK;
        if (!sj3.Ym.get()) {
            this.Sj.f21074ib.TEQ();
        }
        uvD();
        this.Sj.JcM.dx();
        this.Sj.uP.uvD();
        this.Sj.zR.set(true);
        if (this.Sj.TEQ.get()) {
            this.Sj.f21073dx.set(true);
        }
        com.bytedance.sdk.openadsdk.utils.Fmk fmk = this.Sj.f21078xu;
        if (fmk != null) {
            fmk.sP();
        }
        this.Sj.sP();
    }

    public void sef() {
        com.bytedance.sdk.openadsdk.core.widget.sP sPVar = this.Fmk;
        if (sPVar == null || !sPVar.isShowing()) {
            return;
        }
        this.Fmk.dismiss();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x00fc, code lost:
    
        if (r2.Sj == 1) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View uA() {
        /*
            Method dump skipped, instructions count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.sP.sP.uA():android.view.View");
    }

    public void uP() {
        this.f21091aa = this.Sj.LqL.TKC();
    }

    public void uvD() {
        this.TEQ.removeMessages(300);
    }

    public abstract boolean vS();

    public void wE() {
        sU sUVar;
        if (!vS() && ((this instanceof Dq) || (this instanceof uA))) {
            this.Sj.LqL.sP();
            return;
        }
        if (!this.uA.Sj(this.HiB.uA(), false)) {
            this.TEQ.removeMessages(300);
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.Sj;
            if (sj2.gR) {
                com.bytedance.sdk.openadsdk.activity.vS vSVar = sj2.HS;
                if (vSVar instanceof com.bytedance.sdk.openadsdk.activity.Sj) {
                    ((com.bytedance.sdk.openadsdk.activity.Sj) vSVar).dx();
                }
            }
            Sj(sP.C0246sP.Sj);
            com.bytedance.sdk.openadsdk.component.reward.Sj.dNu dnu = this.HiB;
            dnu.Sj(!dnu.LqL() ? 1 : 0, 4);
        }
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj3 = this.Sj;
        if (sj3 == null || (sUVar = sj3.sP) == null || sj3.f21078xu == null || !sUVar.Fqk()) {
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj4 = this.Sj;
        sj4.f21078xu.Sj(sj4.f21074ib.dx());
    }

    public void zR() {
        com.bytedance.sdk.openadsdk.component.reward.view.Dq dq2 = this.Sj.wE;
        if (dq2 != null) {
            dq2.vS();
        }
        com.bytedance.sdk.openadsdk.component.reward.view.TEQ teq = this.Sj.Wjd;
        if (teq != null) {
            teq.sef();
        }
        this.Sj.f21074ib.wE();
        if (!HiB()) {
            this.Sj.TEQ.get();
        }
        com.bytedance.sdk.openadsdk.component.reward.Sj.TzV tzV = this.Sj.JcM;
        if (tzV != null) {
            tzV.uvD();
        }
        com.bytedance.sdk.openadsdk.component.reward.Sj.Dq dq3 = this.Sj.uP;
        if (dq3 != null) {
            dq3.Jcg(com.bytedance.sdk.openadsdk.component.reward.Sj.Dq.Sj);
        }
        com.bytedance.sdk.openadsdk.component.reward.view.TEQ teq2 = this.Sj.Wjd;
        if (teq2 != null) {
            teq2.aa();
        }
        com.bytedance.sdk.openadsdk.component.reward.Sj.HiB hiB = this.Sj.FPG;
        if (hiB != null) {
            hiB.TKC();
        }
        aa aaVar = this.Sj.ley;
        if (aaVar != null) {
            aaVar.sP();
        }
        com.bytedance.sdk.openadsdk.utils.Fmk fmk = this.Sj.f21078xu;
        if (fmk != null) {
            fmk.TKC();
        }
    }
}

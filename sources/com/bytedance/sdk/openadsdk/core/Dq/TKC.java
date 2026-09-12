package com.bytedance.sdk.openadsdk.core.Dq;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.Dq.HiB;
import com.bytedance.sdk.openadsdk.core.uP;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.utils.FPG;
import com.bytedance.sdk.openadsdk.utils.JcM;
import com.google.android.material.card.MaterialCardView;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class TKC {
    private ScheduledFuture<?> Dq;
    private com.bytedance.sdk.component.adexpress.sP.Zq EjP;
    private RiZ HiB;
    private int Jcg;
    com.bytedance.sdk.openadsdk.core.model.sU Sj;
    private Sj TKC;
    private final Context sP;
    private int uA;
    private int vS;

    /* loaded from: classes3.dex */
    public static class Sj implements com.bytedance.sdk.component.adexpress.sP.EjP<View>, HiB.sP {
        private FrameLayout Dq;
        private String EjP;
        private int Fmk;
        private final Context HiB;
        private final int Jcg;
        AtomicBoolean Sj = new AtomicBoolean(false);
        private final int TEQ;
        private TTDislikeDialogAbstract TKC;
        private String Ym;
        private PAGExpressAdWrapperListener Zq;

        /* renamed from: aa, reason: collision with root package name */
        private HiB f21104aa;
        private com.bytedance.sdk.openadsdk.TKC.TKC sP;
        private com.bytedance.sdk.component.adexpress.sP.Jcg sef;
        private com.bytedance.sdk.openadsdk.core.model.sU uA;
        private final int vS;

        public Sj(Context context, com.bytedance.sdk.openadsdk.core.model.sU sUVar, int i11, int i12, String str, int i13) {
            this.Ym = str;
            if (sUVar != null && sUVar.Fqk()) {
                this.Ym = "fullscreen_interstitial_ad";
            }
            this.HiB = context;
            this.vS = i11;
            this.Jcg = i12;
            this.uA = sUVar;
            this.TEQ = FPG.sP(context, 3.0f);
            this.Fmk = i13;
            vS();
        }

        @SuppressLint({"ClickableViewAccessibility"})
        private HiB Dq() {
            HiB sP = EjP.Sj().sP();
            this.f21104aa = sP;
            if (sP == null) {
                this.f21104aa = new HiB(this.HiB);
            }
            EjP.Sj().TKC(this.f21104aa);
            this.f21104aa.Sj(this.uA, this, this.Ym);
            this.f21104aa.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return this.f21104aa;
        }

        private View Jcg() {
            PAGLogoView createPAGLogoViewByMaterial = PAGLogoView.createPAGLogoViewByMaterial(this.HiB, this.uA);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            com.bytedance.sdk.openadsdk.core.model.sU sUVar = this.uA;
            if (sUVar == null || !sUVar.Fqk()) {
                int i11 = this.TEQ;
                layoutParams.topMargin = i11;
                layoutParams.leftMargin = i11;
            } else {
                layoutParams.leftMargin = FPG.sP(this.HiB, 20.0f);
                layoutParams.bottomMargin = FPG.sP(this.HiB, 20.0f);
                layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_START;
            }
            createPAGLogoViewByMaterial.setLayoutParams(layoutParams);
            createPAGLogoViewByMaterial.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.Dq.TKC.Sj.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebsiteActivity.Sj(Sj.this.HiB, Sj.this.uA, Sj.this.Ym);
                }
            });
            return createPAGLogoViewByMaterial;
        }

        private void vS() {
            FrameLayout frameLayout = new FrameLayout(this.HiB);
            this.Dq = frameLayout;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(this.vS, this.Jcg);
            }
            layoutParams.width = this.vS;
            layoutParams.height = this.Jcg;
            layoutParams.gravity = 17;
            this.Dq.setLayoutParams(layoutParams);
            HiB Dq = Dq();
            this.Dq.addView(Dq);
            View Jcg = Jcg();
            this.Dq.addView(Jcg);
            com.bytedance.sdk.openadsdk.core.model.sU sUVar = this.uA;
            if (sUVar != null && sUVar.Fqk()) {
                Dq.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                Dq.Sj(((Activity) this.HiB).findViewById(com.bytedance.sdk.openadsdk.utils.Zq.Snq), FriendlyObstructionPurpose.OTHER);
            }
            FriendlyObstructionPurpose friendlyObstructionPurpose = FriendlyObstructionPurpose.OTHER;
            Dq.Sj(Jcg, friendlyObstructionPurpose);
            Context context = this.HiB;
            if (context == null || !(context instanceof Activity)) {
                return;
            }
            View findViewById = ((Activity) context).findViewById(com.bytedance.sdk.openadsdk.utils.Zq.IPx);
            if (findViewById != null) {
                Dq.Sj(findViewById, friendlyObstructionPurpose);
            }
            View findViewById2 = ((Activity) this.HiB).findViewById(com.bytedance.sdk.openadsdk.utils.Zq.TT);
            if (findViewById2 != null) {
                Dq.Sj(findViewById2, friendlyObstructionPurpose);
            }
        }

        public void EjP() {
            this.Dq = null;
            this.sP = null;
            this.TKC = null;
            this.sef = null;
            this.uA = null;
            HiB hiB = this.f21104aa;
            if (hiB != null) {
                hiB.uvD();
                EjP.Sj().Sj(this.f21104aa);
            }
            this.Sj.set(true);
        }

        @Override // com.bytedance.sdk.component.adexpress.sP.EjP
        public View HiB() {
            return this.Dq;
        }

        @Override // com.bytedance.sdk.openadsdk.core.Dq.HiB.sP
        public View Sj() {
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.core.Dq.HiB.sP
        public void Sj(int i11, int i12) {
            com.bytedance.sdk.component.adexpress.sP.Jcg jcg = this.sef;
            if (jcg != null) {
                jcg.Sj(i11, "render fail");
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.Dq.HiB.sP
        public void Sj(View view, int i11) {
            PAGExpressAdWrapperListener pAGExpressAdWrapperListener = this.Zq;
            if (pAGExpressAdWrapperListener != null) {
                pAGExpressAdWrapperListener.onAdClicked();
            }
        }

        @Override // com.bytedance.sdk.component.adexpress.sP.EjP
        public void Sj(com.bytedance.sdk.component.adexpress.sP.Jcg jcg) {
            com.bytedance.sdk.openadsdk.core.model.sU sUVar;
            if (this.Sj.get()) {
                return;
            }
            if (this.HiB == null || (sUVar = this.uA) == null) {
                jcg.Sj(106, "material null");
                return;
            }
            this.sef = jcg;
            if (TextUtils.isEmpty(sUVar.TX())) {
                jcg.Sj(106, "dsp data is null");
            } else {
                this.f21104aa.sU();
            }
        }

        public void Sj(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
            com.bytedance.sdk.openadsdk.core.model.sU sUVar;
            if (tTDislikeDialogAbstract != null && (sUVar = this.uA) != null) {
                tTDislikeDialogAbstract.setMaterialMeta(sUVar.mZN(), this.uA.nru());
            }
            this.TKC = tTDislikeDialogAbstract;
        }

        public void Sj(PAGExpressAdWrapperListener pAGExpressAdWrapperListener) {
            this.Zq = pAGExpressAdWrapperListener;
        }

        public void Sj(uP uPVar) {
            if (uPVar instanceof com.bytedance.sdk.openadsdk.TKC.TKC) {
                this.sP = (com.bytedance.sdk.openadsdk.TKC.TKC) uPVar;
            }
        }

        public void Sj(String str) {
            this.EjP = str;
        }

        @Override // com.bytedance.sdk.component.adexpress.sP.EjP
        public int TKC() {
            return 5;
        }

        @Override // com.bytedance.sdk.openadsdk.core.Dq.HiB.sP
        @SuppressLint({"ClickableViewAccessibility"})
        public void e_() {
            if (this.sef != null) {
                com.bytedance.sdk.component.adexpress.sP.sef sefVar = new com.bytedance.sdk.component.adexpress.sP.sef();
                sefVar.Sj(true);
                sefVar.Sj(FPG.TKC(this.HiB, this.vS));
                sefVar.sP(FPG.TKC(this.HiB, this.Jcg));
                this.sef.Sj(this.Dq, sefVar);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.Dq.HiB.sP
        public View sP() {
            FrameLayout frameLayout = this.Dq;
            if (frameLayout == null) {
                return null;
            }
            return (View) frameLayout.getParent();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.openadsdk.core.Dq.TKC$TKC, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0260TKC {
        void Sj();

        void Sj(int i11, int i12);

        void Sj(String str);

        void sP(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class sP implements Runnable {
        InterfaceC0260TKC Sj;

        public sP(InterfaceC0260TKC interfaceC0260TKC) {
            this.Sj = interfaceC0260TKC;
        }

        @Override // java.lang.Runnable
        public void run() {
            InterfaceC0260TKC interfaceC0260TKC = this.Sj;
            if (interfaceC0260TKC != null) {
                interfaceC0260TKC.Sj(107, 107);
            }
        }
    }

    public TKC(Context context, RiZ riZ, com.bytedance.sdk.openadsdk.core.model.sU sUVar, String str) {
        this.Sj = sUVar;
        this.sP = context;
        this.HiB = riZ;
        Sj(riZ);
        this.TKC = new Sj(context, sUVar, this.vS, this.Jcg, str, this.uA);
    }

    private void Sj(RiZ riZ) {
        com.bytedance.sdk.openadsdk.core.model.sU sUVar = this.Sj;
        if (sUVar != null && sUVar.Fqk()) {
            this.vS = -1;
            this.Jcg = -1;
            return;
        }
        dNu Sj2 = com.bytedance.sdk.openadsdk.core.TKC.Sj.Sj(riZ.getExpectExpressWidth(), riZ.getExpectExpressHeight());
        this.uA = Sj2.Sj;
        if (riZ.getExpectExpressWidth() <= 0 || riZ.getExpectExpressHeight() <= 0) {
            int TKC = FPG.TKC(this.sP);
            this.vS = TKC;
            this.Jcg = Float.valueOf(TKC / Sj2.sP).intValue();
        } else {
            this.vS = FPG.sP(this.sP, riZ.getExpectExpressWidth());
            this.Jcg = FPG.sP(this.sP, riZ.getExpectExpressHeight());
        }
        int i11 = this.vS;
        if (i11 <= 0 || i11 <= FPG.TKC(this.sP)) {
            return;
        }
        this.vS = FPG.TKC(this.sP);
        this.Jcg = Float.valueOf(this.Jcg * (FPG.TKC(this.sP) / this.vS)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TKC() {
        try {
            ScheduledFuture<?> scheduledFuture = this.Dq;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.Dq.cancel(false);
            this.Dq = null;
        } catch (Throwable unused) {
        }
    }

    public void Sj() {
        com.bytedance.sdk.openadsdk.core.model.sU sUVar = this.Sj;
        if (sUVar != null && sUVar.Fqk()) {
            this.Dq = JcM.Sj().schedule(new sP(this.TKC.f21104aa), com.bytedance.sdk.openadsdk.core.dNu.EjP().uP(), TimeUnit.MILLISECONDS);
        }
        Sj sj2 = this.TKC;
        if (sj2 == null) {
            com.bytedance.sdk.component.adexpress.sP.Zq zq2 = this.EjP;
            if (zq2 != null) {
                zq2.a_(106);
                return;
            }
            return;
        }
        sj2.Sj(new com.bytedance.sdk.component.adexpress.sP.Jcg() { // from class: com.bytedance.sdk.openadsdk.core.Dq.TKC.1
            @Override // com.bytedance.sdk.component.adexpress.sP.Jcg
            public void Sj(int i11, String str) {
                if (TKC.this.EjP != null) {
                    TKC.this.EjP.a_(106);
                }
                TKC.this.TKC();
            }

            @Override // com.bytedance.sdk.component.adexpress.sP.Jcg
            public void Sj(View view, com.bytedance.sdk.component.adexpress.sP.sef sefVar) {
                if (TKC.this.HiB == null || view == null) {
                    if (TKC.this.EjP != null) {
                        TKC.this.EjP.a_(106);
                    }
                } else if (TKC.this.EjP != null) {
                    TKC.this.EjP.Sj(TKC.this.TKC, sefVar);
                }
                TKC.this.TKC();
            }
        });
        View HiB = this.TKC.HiB();
        this.HiB.removeView(HiB);
        if (HiB.getParent() != null) {
            ((ViewGroup) HiB.getParent()).removeView(HiB);
        }
        this.HiB.addView(HiB, new ViewGroup.LayoutParams(-1, -1));
    }

    public void Sj(com.bytedance.sdk.component.adexpress.sP.Zq zq2) {
        this.EjP = zq2;
    }

    public void Sj(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        Sj sj2 = this.TKC;
        if (sj2 != null) {
            sj2.Sj(tTDislikeDialogAbstract);
        }
    }

    public void Sj(PAGExpressAdWrapperListener pAGExpressAdWrapperListener) {
        Sj sj2 = this.TKC;
        if (sj2 != null) {
            sj2.Sj(pAGExpressAdWrapperListener);
        }
    }

    public void Sj(uP uPVar) {
        Sj sj2 = this.TKC;
        if (sj2 != null) {
            sj2.Sj(uPVar);
        }
    }

    public void Sj(String str) {
        Sj sj2 = this.TKC;
        if (sj2 != null) {
            sj2.Sj(str);
        }
    }

    public void sP() {
        Sj sj2 = this.TKC;
        if (sj2 != null) {
            sj2.EjP();
            this.TKC = null;
        }
        TKC();
        this.EjP = null;
        this.HiB = null;
    }
}

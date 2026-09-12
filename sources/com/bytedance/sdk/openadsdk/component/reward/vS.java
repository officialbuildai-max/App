package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.sU;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.JcM;
import com.bytedance.sdk.openadsdk.utils.LqL;
import com.bytedance.sdk.openadsdk.utils.ib;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
class vS extends PAGInterstitialAd {
    private boolean Dq;
    private final Context Sj;
    private com.bytedance.sdk.openadsdk.Sj.TKC.sP TKC;
    private final com.bytedance.sdk.openadsdk.core.model.Sj sP;
    private boolean uA;
    private final AtomicBoolean HiB = new AtomicBoolean(false);
    private boolean vS = false;
    private boolean EjP = false;
    private final String Jcg = ib.Sj();

    /* JADX INFO: Access modifiers changed from: package-private */
    public vS(Context context, com.bytedance.sdk.openadsdk.core.model.Sj sj2) {
        this.Sj = context;
        this.sP = sj2;
    }

    private void Sj(final int i11) {
        if (com.bytedance.sdk.openadsdk.multipro.sP.TKC()) {
            JcM.TKC(new com.bytedance.sdk.component.Dq.Dq("FullScreen_registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.component.reward.vS.3
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.Sj Sj = com.bytedance.sdk.openadsdk.multipro.aidl.Sj.Sj();
                    if (i11 != 1 || vS.this.TKC == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.multipro.aidl.sP.TKC tkc = new com.bytedance.sdk.openadsdk.multipro.aidl.sP.TKC(vS.this.TKC);
                    IListenerManager asInterface = IListenerManager.Stub.asInterface(Sj.Sj(1));
                    if (asInterface != null) {
                        try {
                            asInterface.registerFullVideoListener(vS.this.Jcg, tkc);
                        } catch (RemoteException e11) {
                            sU.sP("TTFullScreenVideoAdImpl", e11.getMessage());
                        }
                    }
                }
            }, 5);
        }
    }

    private static boolean Sj(com.bytedance.sdk.openadsdk.core.model.sU sUVar) {
        if (sUVar == null) {
            return false;
        }
        int dx2 = sUVar.dx();
        return (sUVar.ley() != 2 || dx2 == 5 || dx2 == 33 || dx2 == 6 || dx2 == 19 || dx2 == 12) ? false : true;
    }

    public void Sj() {
        if (this.HiB.get()) {
            return;
        }
        this.EjP = true;
    }

    public void Sj(boolean z10) {
        this.vS = z10;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Object getExtraInfo(String str) {
        com.bytedance.sdk.openadsdk.core.model.Sj sj2 = this.sP;
        if (sj2 == null || sj2.vS() == null || this.sP.vS().QZ() == null) {
            return null;
        }
        try {
            return this.sP.vS().QZ().get(str);
        } catch (Throwable th2) {
            sU.sP("TTFullScreenVideoAdImpl", th2.getMessage());
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Map<String, Object> getMediaExtraInfo() {
        com.bytedance.sdk.openadsdk.core.model.Sj sj2 = this.sP;
        if (sj2 == null || sj2.vS() == null) {
            return null;
        }
        return this.sP.vS().QZ();
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void loss(Double d11, String str, String str2) {
        if (this.uA) {
            return;
        }
        LqL.Sj(this.sP.vS(), d11, str, str2);
        this.uA = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd
    public void setAdInteractionCallback(PAGInterstitialAdInteractionCallback pAGInterstitialAdInteractionCallback) {
        this.TKC = new com.bytedance.sdk.openadsdk.component.TKC.Sj(pAGInterstitialAdInteractionCallback);
        Sj(1);
    }

    @Override // com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd
    public void setAdInteractionListener(PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener) {
        this.TKC = new com.bytedance.sdk.openadsdk.component.TKC.Sj(pAGInterstitialAdInteractionListener);
        Sj(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fe  */
    @Override // com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void show(android.app.Activity r12) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.vS.show(android.app.Activity):void");
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void win(Double d11) {
        if (this.Dq) {
            return;
        }
        LqL.Sj(this.sP.vS(), d11);
        this.Dq = true;
    }
}

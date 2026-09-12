package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.sU;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.model.TzV;
import com.bytedance.sdk.openadsdk.utils.JcM;
import com.bytedance.sdk.openadsdk.utils.LqL;
import com.bytedance.sdk.openadsdk.utils.ib;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* loaded from: classes2.dex */
class Dq extends PAGRewardedAd {
    private boolean Dq;
    private com.bytedance.sdk.openadsdk.Sj.HiB.Sj EjP;
    private boolean HiB;
    private final Context Sj;
    private final AdSlot TKC;
    private final com.bytedance.sdk.openadsdk.core.model.Sj sP;
    private boolean uA;
    private final AtomicBoolean vS = new AtomicBoolean(false);
    private final String Jcg = ib.Sj();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Dq(Context context, com.bytedance.sdk.openadsdk.core.model.Sj sj2, AdSlot adSlot) {
        this.Sj = context;
        this.sP = sj2;
        this.TKC = adSlot;
    }

    private void Sj(final int i11) {
        if (com.bytedance.sdk.openadsdk.multipro.sP.TKC()) {
            JcM.TKC(new com.bytedance.sdk.component.Dq.Dq("Reward_registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.component.reward.Dq.3
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.Sj Sj = com.bytedance.sdk.openadsdk.multipro.aidl.Sj.Sj();
                    if (i11 != 0 || Dq.this.EjP == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.multipro.aidl.sP.EjP ejP = new com.bytedance.sdk.openadsdk.multipro.aidl.sP.EjP(Dq.this.EjP);
                    IListenerManager asInterface = IListenerManager.Stub.asInterface(Sj.Sj(0));
                    if (asInterface != null) {
                        try {
                            asInterface.registerRewardVideoListener(Dq.this.Jcg, ejP);
                        } catch (RemoteException e11) {
                            sU.sP("TTRewardVideoAdImpl", e11.getMessage());
                        }
                    }
                }
            }, 5);
        }
    }

    public static boolean Sj(com.bytedance.sdk.openadsdk.core.model.Sj sj2) {
        com.bytedance.sdk.openadsdk.core.model.sU vS;
        String Sj;
        if (sj2 == null || (vS = sj2.vS()) == null || TzV.TKC(vS)) {
            return false;
        }
        if (vS.tR()) {
            return true;
        }
        try {
            Sj = com.bytedance.sdk.openadsdk.dx.Sj.Sj("rviv_new_arch", (String) null);
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(Sj)) {
            return false;
        }
        JSONArray jSONArray = new JSONArray(Sj);
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            if (vS.dx() == jSONArray.getInt(i11)) {
                return true;
            }
        }
        return false;
    }

    private static boolean Sj(com.bytedance.sdk.openadsdk.core.model.sU sUVar) {
        if (sUVar == null) {
            return false;
        }
        int dx2 = sUVar.dx();
        return (sUVar.ley() != 2 || dx2 == 5 || dx2 == 33 || dx2 == 6 || dx2 == 19 || dx2 == 12) ? false : true;
    }

    public void Sj() {
        if (this.vS.get()) {
            return;
        }
        this.HiB = true;
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
            sU.sP("TTRewardVideoAdImpl", th2.getMessage());
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

    @Override // com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd
    public void setAdInteractionCallback(PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback) {
        this.EjP = new uA(pAGRewardedAdInteractionCallback);
        Sj(0);
    }

    @Override // com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd
    public void setAdInteractionListener(PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener) {
        this.EjP = new uA(pAGRewardedAdInteractionListener);
        Sj(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e6  */
    @Override // com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void show(@androidx.annotation.Nullable android.app.Activity r12) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.Dq.show(android.app.Activity):void");
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

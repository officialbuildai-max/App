package com.bytedance.sdk.openadsdk.EjP.Sj;

import android.content.Context;
import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.TzV;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.multipro.aidl.BinderPoolService;
import com.bytedance.sdk.openadsdk.utils.JcM;
import com.bytedance.sdk.openadsdk.utils.Mts;
import com.cloud.tmc.kernel.constants.TmcConstants;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class Ym implements com.bytedance.sdk.component.vS.Sj.HiB {
    private final String Sj = "[7114]";

    @Override // com.bytedance.sdk.component.vS.Sj.HiB
    public boolean Dq() {
        return true;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.HiB
    public Executor EjP() {
        return JcM.EjP();
    }

    @Override // com.bytedance.sdk.component.vS.Sj.HiB
    public void Fmk() {
        Sj.Sj(Sj.vS);
    }

    @Override // com.bytedance.sdk.component.vS.Sj.HiB
    public Executor HiB() {
        return JcM.Dq();
    }

    @Override // com.bytedance.sdk.component.vS.Sj.HiB
    public boolean Jcg() {
        return false;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.HiB
    public HandlerThread Sj(String str, int i11) {
        return com.bytedance.sdk.component.utils.Dq.Sj(str, i11);
    }

    @Override // com.bytedance.sdk.component.vS.Sj.HiB
    public com.bytedance.sdk.component.vS.Sj.EjP.Sj Sj(JSONObject jSONObject) {
        return null;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.HiB
    public String Sj(String str) {
        return com.bytedance.sdk.component.EjP.Sj.sP(str, com.bytedance.sdk.openadsdk.core.Sj.Sj());
    }

    @Override // com.bytedance.sdk.component.vS.Sj.HiB
    public void Sj(boolean z10) {
        Sj.Sj(Sj.vS, z10);
    }

    @Override // com.bytedance.sdk.component.vS.Sj.HiB
    public void Sj(boolean z10, int i11, long j11, com.bytedance.sdk.component.vS.Sj.vS.EjP ejP) {
        Runnable Sj;
        if (ejP == null) {
            return;
        }
        Sj.Sj(Sj.TKC, z10, i11, j11);
        if (z10) {
            com.bytedance.sdk.openadsdk.Zq.TKC.Sj("track_link_result", false, (com.bytedance.sdk.openadsdk.Zq.sP) new Fmk(true, ejP));
            return;
        }
        sef TFd = com.bytedance.sdk.openadsdk.core.settings.Fmk.gq().TFd();
        if (TFd == null || ejP.EjP() >= TFd.Sj(ejP.vS())) {
            com.bytedance.sdk.openadsdk.Zq.TKC.Sj("track_link_result", false, (com.bytedance.sdk.openadsdk.Zq.sP) new Fmk(false, ejP));
        } else {
            if (!TFd.Sj() || (Sj = ejP.Sj(com.bytedance.sdk.openadsdk.core.aa.Sj(dNu.Sj()), null)) == null) {
                return;
            }
            JcM.Sj().schedule(Sj, TFd.sP(ejP.vS()), TimeUnit.SECONDS);
        }
    }

    @Override // com.bytedance.sdk.component.vS.Sj.HiB
    public boolean Sj() {
        return false;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.HiB
    public boolean Sj(Context context) {
        return TzV.Sj(context);
    }

    @Override // com.bytedance.sdk.component.vS.Sj.HiB
    public com.bytedance.sdk.component.vS.Sj.HiB.TKC TEQ() {
        return new Jcg();
    }

    @Override // com.bytedance.sdk.component.vS.Sj.HiB
    public int TKC(String str) {
        sef TFd = com.bytedance.sdk.openadsdk.core.settings.Fmk.gq().TFd();
        if (TFd == null) {
            return 3;
        }
        return TFd.Sj(str);
    }

    @Override // com.bytedance.sdk.component.vS.Sj.HiB
    public boolean TKC() {
        return true;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.HiB
    public com.bytedance.sdk.component.vS.Sj.vS Ym() {
        com.bytedance.sdk.component.vS.Sj.vS Sj;
        synchronized (this) {
            Sj = com.bytedance.sdk.openadsdk.multipro.Sj.Sj.Sj(dNu.Sj());
        }
        return Sj;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.HiB
    public long Zq() {
        long Sj = com.bytedance.sdk.openadsdk.dx.Sj.Sj("log_queue_timeout", 40000);
        if (Sj < 30000 || Sj > TmcConstants.DEBUG_REQUEST_TIME_INTERVAL) {
            return 40000L;
        }
        return Sj;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.HiB
    public com.bytedance.sdk.component.vS.Sj.Jcg aa() {
        return null;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.HiB
    public String sP(String str) {
        return com.bytedance.sdk.component.EjP.Sj.Sj(str, com.bytedance.sdk.openadsdk.core.Sj.Sj());
    }

    @Override // com.bytedance.sdk.component.vS.Sj.HiB
    public boolean sP() {
        return false;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.HiB
    public boolean sef() {
        return BinderPoolService.Sj;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.HiB
    public String uA() {
        return Mts.TKC();
    }

    @Override // com.bytedance.sdk.component.vS.Sj.HiB
    public int vS() {
        return 1;
    }
}

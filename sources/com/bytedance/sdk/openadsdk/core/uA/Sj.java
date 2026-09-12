package com.bytedance.sdk.openadsdk.core.uA;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.bytedance.sdk.component.utils.sU;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.Zq.Sj.EjP;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.core.sef;
import com.bytedance.sdk.openadsdk.core.settings.Fmk;
import com.bytedance.sdk.openadsdk.core.uA;
import com.bytedance.sdk.openadsdk.utils.Mts;
import com.pgl.ssdk.ces.out.PglSSConfig;
import com.pgl.ssdk.ces.out.PglSSManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class Sj {
    private PglSSManager Sj;
    private volatile boolean sP;
    private volatile boolean TKC = true;
    private volatile boolean EjP = false;

    public Sj() {
        Sj();
    }

    private boolean Dq() {
        if (!this.sP && this.TKC) {
            Sj();
        }
        return this.sP;
    }

    private Class TEQ() {
        Class<PglSSManager> cls;
        try {
            cls = PglSSManager.class;
            String str = PglSSManager.REPORT_SCENE_ADSHOW;
        } catch (Throwable unused) {
            cls = null;
        }
        try {
            this.TKC = true;
        } catch (Throwable unused2) {
            this.TKC = false;
            return cls;
        }
        return cls;
    }

    private void TKC(final String str) {
        if (this.EjP || TextUtils.isEmpty(str)) {
            return;
        }
        dNu.HiB().Sj(new com.bytedance.sdk.openadsdk.Zq.sP() { // from class: com.bytedance.sdk.openadsdk.core.uA.Sj.3
            @Override // com.bytedance.sdk.openadsdk.Zq.sP
            public com.bytedance.sdk.openadsdk.Zq.Sj.TKC getLogStats() throws Exception {
                return EjP.sP().Sj("secsdk_init_error").sP(str);
            }
        }, false);
        this.EjP = true;
    }

    private void uA() {
        if (this.Sj == null) {
            this.Sj = PglSSManager.getInstance();
        }
    }

    public String EjP() {
        if (!Dq()) {
            return "";
        }
        uA();
        PglSSManager pglSSManager = this.Sj;
        return pglSSManager != null ? pglSSManager.getToken() : "";
    }

    public String HiB() {
        if (!Dq()) {
            return "";
        }
        uA();
        PglSSManager pglSSManager = this.Sj;
        return pglSSManager != null ? pglSSManager.getSofChara() : "";
    }

    public int Jcg() {
        if (this.TKC) {
            return PglSSManager.getInitStatus();
        }
        return 5;
    }

    public Map<String, String> Sj(String str, byte[] bArr) {
        Map<String, String> featureHash;
        return (!Dq() || (featureHash = this.Sj.getFeatureHash(str, bArr)) == null) ? new HashMap() : featureHash;
    }

    public synchronized void Sj() {
        Context Sj;
        String EjP;
        if (!this.sP) {
            try {
                Sj = dNu.Sj();
                EjP = uA.sP().EjP();
                if (TextUtils.isEmpty(EjP)) {
                    EjP = uA.Sj("app_id", Long.MAX_VALUE);
                }
            } catch (Throwable unused) {
                TEQ();
                this.sP = false;
            }
            if (TextUtils.isEmpty(EjP)) {
                return;
            }
            String Sj2 = aa.Sj(Sj);
            String sP = com.bytedance.sdk.openadsdk.RiZ.Sj.sP.Sj.Sj().sP();
            PglSSConfig build = PglSSConfig.builder().setAppId(EjP).setOVRegionType(2).setAdsdkVersion(BuildConfig.VERSION_NAME).build();
            String sP2 = com.bytedance.sdk.openadsdk.multipro.EjP.EjP.sP("ttopenadsdk", PglSSConfig.CUSTOMINFO_KEY_IPV6, "");
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(sP2)) {
                hashMap.put(PglSSConfig.CUSTOMINFO_KEY_IPV6, sP2);
            }
            Set<String> dLt = Fmk.gq().dLt();
            if (dLt != null && !dLt.isEmpty()) {
                hashMap.put(PglSSConfig.CUSTOMINFO_KEY_ALLOWED_FIELDS, dLt);
            }
            String Fmk = Mts.Fmk();
            if (!TextUtils.isEmpty(Fmk)) {
                hashMap.put(PglSSConfig.CUSTOMINFO_KEY_TRANSFER_HOST, Fmk);
            }
            hashMap.put(PglSSConfig.CUSTOMINFO_KEY_TARGET_IDC, Fmk.gq().oWa());
            String Sj3 = com.bytedance.sdk.openadsdk.dx.Sj.Sj(PglSSConfig.CUSTOMINFO_KEY_SEC_CONFIG_STR, "");
            if (!TextUtils.isEmpty(Sj3)) {
                hashMap.put(PglSSConfig.CUSTOMINFO_KEY_SEC_CONFIG_STR, Sj3);
            }
            build.setCustomInfo(hashMap);
            PglSSManager.init(Sj, build, null, null, Sj2, sP);
            uA();
            this.sP = true;
            try {
                if (this.TKC) {
                    TKC(PglSSManager.getLoadError());
                }
            } catch (Throwable th2) {
                sU.sP("mssdk", th2.getMessage());
            }
        }
    }

    public void Sj(MotionEvent motionEvent) {
        if (sP()) {
            uA();
            PglSSManager pglSSManager = this.Sj;
            if (pglSSManager != null) {
                pglSSManager.checkEventVirtual(motionEvent);
            }
        }
    }

    public void Sj(String str) {
        if (Dq()) {
            uA();
            PglSSManager pglSSManager = this.Sj;
            if (pglSSManager != null) {
                pglSSManager.setGaid(str);
            }
        }
    }

    public void Sj(String str, Map<String, Object> map) {
        if (Dq()) {
            uA();
            PglSSManager pglSSManager = this.Sj;
            if (pglSSManager != null) {
                pglSSManager.reportNow(str, map);
            }
        }
    }

    public void Sj(final Map<String, Object> map) {
        if (Dq()) {
            uA();
            if (this.Sj != null) {
                sef.sP().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.uA.Sj.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            Sj.this.Sj.setCustomInfo(map);
                        } catch (Throwable th2) {
                            sU.sP("MSSdkImpl", "setCustomInfo", th2.getMessage());
                        }
                    }
                });
            }
        }
    }

    public void TKC() {
        if (Dq()) {
            uA();
            if (this.Sj != null) {
                sef.sP().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.uA.Sj.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            HashMap hashMap = new HashMap();
                            hashMap.put(PglSSConfig.CUSTOMINFO_KEY_CHECKCLAZZ, dNu.EjP().QZ());
                            Sj.this.Sj.setCustomInfo(hashMap);
                        } catch (Throwable th2) {
                            sU.sP("MSSdkImpl", "setCustomInfo", th2.getMessage());
                        }
                    }
                });
            }
        }
    }

    public void sP(String str) {
        if (Dq()) {
            uA();
            PglSSManager pglSSManager = this.Sj;
            if (pglSSManager != null) {
                pglSSManager.setDeviceId(str);
            }
        }
    }

    public boolean sP() {
        return this.sP;
    }

    public long vS() {
        if (!Dq()) {
            return 0L;
        }
        uA();
        PglSSManager pglSSManager = this.Sj;
        if (pglSSManager != null) {
            return pglSSManager.getECForBidding();
        }
        return 0L;
    }
}

package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.embedapplog.PangleEncryptManager;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.bytedance.sdk.openadsdk.api.bidding.PAGBiddingRequest;
import com.cloud.tmc.integration.net.UrlKt;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import w5.b;

@Deprecated
/* loaded from: classes3.dex */
public class LqL implements wE {
    private static final Map<Integer, String> HiB = new HashMap<Integer, String>(12) { // from class: com.bytedance.sdk.openadsdk.core.LqL.1
        {
            put(1, "abtest");
            put(2, "user_data");
            put(3, UrlKt.KEY_MINI_GAID);
            put(4, "apk-sign");
            put(5, "app_set_id_scope");
            put(6, "app_set_id");
            put(7, "installed_source");
            put(8, "app_running_time");
            put(9, "vendor");
            put(10, "model");
            put(11, "user_agent_device");
            put(12, "user_agent_webview");
            put(13, "sys_compiling_time");
            put(14, "sec_did");
            put(15, "url");
            put(16, "X-Argus");
            put(17, "X-Ladon");
            put(18, "X-Khronos");
            put(19, "X-Gorgon");
            put(20, "pangle_m");
            put(21, "screen_height");
            put(22, "screen_width");
            put(23, "rom_version");
            put(24, "carrier_name");
            put(25, "os_version");
            put(26, "conn_type");
            put(27, "boot");
            put(28, "feature_data");
            put(29, "t_ver");
            put(30, CampaignEx.JSON_KEY_AAB);
            put(31, "w_ver");
            put(32, "is_fold");
            put(33, "abi");
        }
    };
    boolean Sj = false;
    boolean sP = false;
    String TKC = "com.union_test.internationad";
    String EjP = "8025677";
    private int vS = 0;

    public static void Dq() {
        try {
            com.bytedance.sdk.openadsdk.dNu.TKC.TKC(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.core.LqL.4
                @Override // com.bytedance.sdk.openadsdk.dNu.EjP
                public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                    com.bytedance.sdk.openadsdk.dNu.sP.Sj sj2 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                    sj2.sP("bidding_token");
                    return sj2;
                }
            });
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.sU.sP("TTAdManagerImpl", th2.getMessage());
        }
    }

    public static void Jcg() {
        try {
            com.bytedance.sdk.openadsdk.dNu.TKC.sP(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.core.LqL.3
                @Override // com.bytedance.sdk.openadsdk.dNu.EjP
                public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                    com.bytedance.sdk.openadsdk.dNu.sP.Sj sj2 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                    sj2.sP("bidding_token");
                    return sj2;
                }
            });
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.sU.sP("TTAdManagerImpl", th2.getMessage());
        }
    }

    private JSONObject Sj(JSONObject jSONObject, boolean z10) {
        JSONObject Sj;
        if (z10) {
            Sj = PangleEncryptManager.encryptType4(jSONObject, new dx(PangleEncryptConstant.CryptDataScene.BIDDING_TOKEN));
            zR.Sj(Sj);
        } else {
            Sj = com.bytedance.sdk.component.utils.Sj.Sj(jSONObject);
        }
        return Sj != null ? Sj : new JSONObject();
    }

    private JSONObject sP(PAGBiddingRequest pAGBiddingRequest) {
        try {
            PAGBannerSize bannerSize = pAGBiddingRequest.getBannerSize();
            if (bannerSize != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("width", bannerSize.getWidth());
                if (bannerSize.getType() == 3) {
                    jSONObject.put("height", bannerSize.getMaxHeight());
                } else {
                    jSONObject.put("height", bannerSize.getHeight());
                }
                jSONObject.put(NativeComponentConstants.KEY_COMPONENT_TYPE, bannerSize.getType());
                return jSONObject;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private boolean uA() {
        return "TX".equals(com.bytedance.sdk.openadsdk.core.settings.Fmk.gq().FPG()) || TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.settings.Fmk.gq().FPG());
    }

    public static void vS() {
        try {
            com.bytedance.sdk.openadsdk.dNu.TKC.Sj(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.core.LqL.2
                @Override // com.bytedance.sdk.openadsdk.dNu.EjP
                public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                    com.bytedance.sdk.openadsdk.dNu.sP.Sj sj2 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                    sj2.sP("bidding_token");
                    return sj2;
                }
            });
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.sU.sP("TTAdManagerImpl", th2.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wE
    public int EjP() {
        return this.vS;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wE
    /* renamed from: EjP, reason: merged with bridge method [inline-methods] */
    public LqL Sj(String str) {
        uA.sP().Sj(str);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wE
    public wE EjP(int i11) {
        uA.sP().TKC(i11);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wE
    public int HiB() {
        return uA.sP().Ym();
    }

    @Override // com.bytedance.sdk.openadsdk.core.wE
    /* renamed from: HiB, reason: merged with bridge method [inline-methods] */
    public LqL sP(String str) {
        uA.sP().TKC(str);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wE
    public wE HiB(int i11) {
        uA.sP().HiB(i11);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wE
    public wE Sj() {
        com.bytedance.sdk.component.utils.Zq.Sj("PangleSDK-7114");
        b.c("PangleSDK-7114");
        com.bytedance.sdk.component.utils.sU.Sj("PangleSDK-7114");
        com.bytedance.sdk.component.utils.Zq.sP();
        com.bytedance.sdk.component.Jcg.Sj.Sj();
        b.a();
        com.bytedance.sdk.component.utils.sU.Sj();
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wE
    public wE Sj(int i11) {
        uA.sP().vS(i11);
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x004c, code lost:
    
        if (com.bytedance.sdk.openadsdk.core.dNu.EjP().LD(r6) == false) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005c A[Catch: all -> 0x02c3, TryCatch #0 {all -> 0x02c3, blocks: (B:3:0x000c, B:5:0x0019, B:7:0x001f, B:8:0x0025, B:10:0x0033, B:13:0x004e, B:16:0x0052, B:18:0x005c, B:20:0x0060, B:23:0x0084, B:24:0x0098, B:26:0x00b3, B:29:0x00d2, B:30:0x00c1, B:31:0x00d9, B:33:0x00f1, B:34:0x0108, B:36:0x0125, B:38:0x012f, B:40:0x013c, B:41:0x0145, B:43:0x021a, B:44:0x022a, B:47:0x023d, B:49:0x0248, B:51:0x025a, B:53:0x0267, B:56:0x0274, B:58:0x027a, B:60:0x0287, B:62:0x029d, B:64:0x02a3, B:65:0x02a6, B:67:0x02ac, B:68:0x02b8, B:73:0x00f7, B:75:0x0103, B:76:0x003e, B:78:0x0044), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0060 A[Catch: all -> 0x02c3, TryCatch #0 {all -> 0x02c3, blocks: (B:3:0x000c, B:5:0x0019, B:7:0x001f, B:8:0x0025, B:10:0x0033, B:13:0x004e, B:16:0x0052, B:18:0x005c, B:20:0x0060, B:23:0x0084, B:24:0x0098, B:26:0x00b3, B:29:0x00d2, B:30:0x00c1, B:31:0x00d9, B:33:0x00f1, B:34:0x0108, B:36:0x0125, B:38:0x012f, B:40:0x013c, B:41:0x0145, B:43:0x021a, B:44:0x022a, B:47:0x023d, B:49:0x0248, B:51:0x025a, B:53:0x0267, B:56:0x0274, B:58:0x027a, B:60:0x0287, B:62:0x029d, B:64:0x02a3, B:65:0x02a6, B:67:0x02ac, B:68:0x02b8, B:73:0x00f7, B:75:0x0103, B:76:0x003e, B:78:0x0044), top: B:2:0x000c }] */
    @Override // com.bytedance.sdk.openadsdk.core.wE
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String Sj(com.bytedance.sdk.openadsdk.api.bidding.PAGBiddingRequest r19) {
        /*
            Method dump skipped, instructions count: 711
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.LqL.Sj(com.bytedance.sdk.openadsdk.api.bidding.PAGBiddingRequest):java.lang.String");
    }

    @Override // com.bytedance.sdk.openadsdk.core.wE
    public boolean Sj(String str, int i11, String str2, String str3, String str4) {
        if (!this.TKC.equals(dNu.Sj().getPackageName()) || !this.EjP.equals(uA.sP().EjP()) || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Method Sj = com.bytedance.sdk.component.utils.ley.Sj("com.bytedance.sdk.openadsdk.TTC3Proxy", "verityPlayable", String.class, Integer.TYPE, String.class, String.class, String.class);
            if (Sj != null) {
                Sj.invoke(null, str, Integer.valueOf(i11), str2, str3, str4);
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wE
    public wE TKC(int i11) {
        this.vS = i11;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wE
    public wE TKC(String str) {
        uA.sP().Dq(str);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wE
    public String TKC() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wE
    public int sP() {
        return uA.sP().TEQ();
    }

    @Override // com.bytedance.sdk.openadsdk.core.wE
    public wE sP(int i11) {
        uA.sP().EjP(i11);
        return this;
    }
}

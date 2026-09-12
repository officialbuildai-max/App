package com.bytedance.sdk.openadsdk.dx;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.embedapplog.PangleEncryptManager;
import com.bytedance.sdk.component.utils.Dq;
import com.bytedance.sdk.component.utils.sU;
import com.bytedance.sdk.component.utils.wE;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.core.dx;
import com.bytedance.sdk.openadsdk.core.sef;
import com.bytedance.sdk.openadsdk.core.settings.Fmk;
import com.bytedance.sdk.openadsdk.core.settings.Ym;
import com.bytedance.sdk.openadsdk.core.uA;
import com.bytedance.sdk.openadsdk.core.uA.sP;
import com.bytedance.sdk.openadsdk.utils.JcM;
import com.bytedance.sdk.openadsdk.utils.Mts;
import com.bytedance.sdk.openadsdk.zR.EjP;
import com.bytedance.sdk.openadsdk.zR.TKC;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.pgl.ssdk.ces.out.PglSSConfig;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Sj {
    public static final ConcurrentHashMap<String, Object> Sj = new ConcurrentHashMap<>();
    private static volatile TKC TKC;
    public static String sP;

    public static boolean EjP() {
        return sP() && Sj("ad_load_and_render_opt", "sync_barrier_switch_opt", 0) == 1;
    }

    public static int HiB() {
        if (sP()) {
            return Sj("ad_load_and_render_opt", "webview_preload_cache", 0);
        }
        return 0;
    }

    private static TKC Jcg() {
        return Sj(dNu.Sj(), uA.sP().EjP());
    }

    public static int Sj(String str, int i11) {
        TKC Jcg = Jcg();
        return Jcg != null ? Jcg.Sj(str, i11) : i11;
    }

    public static int Sj(String str, String str2, int i11) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str3 = str + "_" + str2;
            ConcurrentHashMap<String, Object> concurrentHashMap = Sj;
            Object obj = concurrentHashMap.get(str3);
            if (obj != null && (obj instanceof Integer)) {
                return ((Integer) obj).intValue();
            }
            try {
                String Sj2 = Jcg().Sj(str, "");
                if (TextUtils.isEmpty(Sj2)) {
                    return i11;
                }
                int optInt = new JSONObject(Sj2).optInt(str2, i11);
                concurrentHashMap.put(str3, Integer.valueOf(optInt));
                return optInt;
            } catch (Throwable th2) {
                sU.sP("StrategyUtils", th2.getMessage());
            }
        }
        return i11;
    }

    public static TKC Sj(final Context context, final String str) {
        if (TKC == null) {
            synchronized (Sj.class) {
                try {
                    if (TKC == null) {
                        try {
                            TKC tkc = new TKC(new EjP() { // from class: com.bytedance.sdk.openadsdk.dx.Sj.1
                                @Override // com.bytedance.sdk.openadsdk.zR.EjP
                                public Handler EjP() {
                                    return sef.sP();
                                }

                                @Override // com.bytedance.sdk.openadsdk.zR.EjP
                                public String HiB() {
                                    String Sj2 = Mts.Sj("/api/ad/union/sdk/strategies/adn", false, true);
                                    Sj.sP = Sj2;
                                    return Sj2;
                                }

                                @Override // com.bytedance.sdk.openadsdk.zR.EjP
                                public Map<String, String> Jcg() {
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("User-Agent", Mts.TKC());
                                    String sP2 = com.bytedance.sdk.openadsdk.multipro.EjP.EjP.sP("ttopenadsdk", PglSSConfig.CUSTOMINFO_KEY_IPV6, "");
                                    if (!sP2.isEmpty()) {
                                        JSONObject jSONObject = new JSONObject();
                                        try {
                                            jSONObject.put("ipv6", sP2);
                                        } catch (JSONException unused) {
                                        }
                                        JSONObject encryptType4 = PangleEncryptManager.encryptType4(jSONObject, new dx(PangleEncryptConstant.CryptDataScene.UNKNOWN));
                                        if (encryptType4 != null) {
                                            hashMap.put("transfer-param", encryptType4.optString("message"));
                                            if (encryptType4.optInt("cypher") == 4) {
                                                hashMap.put("cypher", "4");
                                            } else {
                                                hashMap.put("cypher", "3");
                                            }
                                        }
                                    }
                                    try {
                                        hashMap.put("x-pangle-target-idc", Fmk.gq().oWa());
                                    } catch (Throwable unused2) {
                                    }
                                    return hashMap;
                                }

                                @Override // com.bytedance.sdk.openadsdk.zR.EjP
                                public HandlerThread Sj(String str2, int i11) {
                                    return Dq.Sj(str2, i11);
                                }

                                @Override // com.bytedance.sdk.openadsdk.zR.EjP
                                public ExecutorService Sj() {
                                    return JcM.HiB();
                                }

                                @Override // com.bytedance.sdk.openadsdk.zR.EjP
                                public JSONObject Sj(JSONObject jSONObject) {
                                    int optInt = jSONObject.optInt("cypher", -1);
                                    if (optInt == -1 || optInt != 3) {
                                        return jSONObject;
                                    }
                                    String TKC2 = com.bytedance.sdk.component.utils.Sj.TKC(jSONObject.optString("message"));
                                    if (TextUtils.isEmpty(TKC2)) {
                                        return jSONObject;
                                    }
                                    try {
                                        return new JSONObject(TKC2);
                                    } catch (Throwable unused) {
                                        return jSONObject;
                                    }
                                }

                                @Override // com.bytedance.sdk.openadsdk.zR.EjP
                                public String TKC() {
                                    return "pag_adn_strategy_center";
                                }

                                @Override // com.bytedance.sdk.openadsdk.zR.EjP
                                public Context sP() {
                                    Context context2 = context;
                                    return context2 != null ? context2 : dNu.Sj();
                                }

                                @Override // com.bytedance.sdk.openadsdk.zR.EjP
                                public JSONObject vS() {
                                    try {
                                        JSONObject Sj2 = Ym.Sj(wE.Sj(dNu.Sj(), 0L));
                                        if (!Sj2.has("app_id")) {
                                            if (!TextUtils.isEmpty(str)) {
                                                Sj2.put("app_id", str);
                                            } else {
                                                if (TextUtils.isEmpty(uA.sP().EjP())) {
                                                    return null;
                                                }
                                                Sj2.put("app_id", uA.sP().EjP());
                                            }
                                        }
                                        return com.bytedance.sdk.component.utils.Sj.Sj(Sj2);
                                    } catch (Throwable th2) {
                                        sU.sP("StrategyUtils", th2.getMessage());
                                        return null;
                                    }
                                }
                            });
                            TKC = tkc;
                            tkc.Sj(new com.bytedance.sdk.openadsdk.zR.Sj() { // from class: com.bytedance.sdk.openadsdk.dx.Sj.2
                                @Override // com.bytedance.sdk.openadsdk.zR.Sj
                                public void Sj() {
                                    com.bytedance.sdk.openadsdk.dNu.TKC.Sj(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.dx.Sj.2.1
                                        @Override // com.bytedance.sdk.openadsdk.dNu.EjP
                                        public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                                            com.bytedance.sdk.openadsdk.dNu.sP.Sj sj2 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                                            sj2.sP("strategy_fetch");
                                            return sj2;
                                        }
                                    });
                                }

                                @Override // com.bytedance.sdk.openadsdk.zR.Sj
                                public void Sj(int i11, String str2) {
                                    com.bytedance.sdk.openadsdk.dNu.TKC.TKC(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.dx.Sj.2.3
                                        @Override // com.bytedance.sdk.openadsdk.dNu.EjP
                                        public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                                            com.bytedance.sdk.openadsdk.dNu.sP.Sj sj2 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                                            sj2.sP("strategy_fetch");
                                            return sj2;
                                        }
                                    });
                                    com.bytedance.sdk.openadsdk.utils.sU.Sj(Sj.sP);
                                }

                                @Override // com.bytedance.sdk.openadsdk.zR.Sj
                                public void sP() {
                                    com.bytedance.sdk.openadsdk.dNu.TKC.sP(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.dx.Sj.2.2
                                        @Override // com.bytedance.sdk.openadsdk.dNu.EjP
                                        public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                                            com.bytedance.sdk.openadsdk.dNu.sP.Sj sj2 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                                            sj2.sP("strategy_fetch");
                                            return sj2;
                                        }
                                    });
                                    com.bytedance.sdk.openadsdk.vS.Sj.Sj().sP();
                                    com.bytedance.sdk.openadsdk.sU.Sj.TKC.Sj().sP();
                                    com.bykv.vk.openvk.Sj.Sj.sP.EjP.EjP.TKC(!com.bytedance.sdk.openadsdk.core.aa.HiB.Sj.Sj());
                                    com.bytedance.sdk.openadsdk.utils.sU.sP();
                                    HashMap hashMap = new HashMap();
                                    String Sj2 = Sj.Sj(PglSSConfig.CUSTOMINFO_KEY_SEC_CONFIG_STR, "");
                                    if (!TextUtils.isEmpty(Sj2)) {
                                        hashMap.put(PglSSConfig.CUSTOMINFO_KEY_SEC_CONFIG_STR, Sj2);
                                    }
                                    sP.sP().Sj(hashMap);
                                }
                            });
                        } catch (Throwable th2) {
                            th2.getMessage();
                        }
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
        return TKC;
    }

    public static String Sj(String str, String str2) {
        TKC Jcg = Jcg();
        return Jcg != null ? Jcg.Sj(str, str2) : str2;
    }

    public static String Sj(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str4 = str + "_" + str2;
            ConcurrentHashMap<String, Object> concurrentHashMap = Sj;
            Object obj = concurrentHashMap.get(str4);
            if (obj != null && (obj instanceof String)) {
                return (String) obj;
            }
            try {
                String Sj2 = Jcg().Sj(str, "");
                if (TextUtils.isEmpty(Sj2)) {
                    return str3;
                }
                String optString = new JSONObject(Sj2).optString(str2, str3);
                concurrentHashMap.put(str4, optString);
                return optString;
            } catch (Throwable th2) {
                sU.sP("StrategyUtils", th2.getMessage());
            }
        }
        return str3;
    }

    public static void Sj() {
        TKC Jcg = Jcg();
        if (Jcg != null) {
            Jcg.Sj();
        }
    }

    public static boolean Sj(String str, boolean z10) {
        TKC Jcg = Jcg();
        return Jcg != null ? Jcg.Sj(str, z10) : z10;
    }

    public static boolean TKC() {
        return sP() && Sj("ad_load_and_render_opt", "thread_switch_opt", 0) == 1;
    }

    public static boolean sP() {
        return Sj("ad_load_and_render_opt", OfflineConstantsKt.OFFLINE_CONFIG_ENABLE, 0) == 1;
    }

    public static int vS() {
        if (sP()) {
            return Sj("ad_load_and_render_opt", "webview_preload_cache_v3", 0);
        }
        return 0;
    }
}

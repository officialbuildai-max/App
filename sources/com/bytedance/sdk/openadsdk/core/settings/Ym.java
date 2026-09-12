package com.bytedance.sdk.openadsdk.core.settings;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.bytedance.sdk.component.utils.wE;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.multipro.aidl.BinderPoolService;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.Mts;
import com.bytedance.sdk.openadsdk.utils.ley;
import com.bytedance.sdk.openadsdk.utils.sU;
import com.cloud.tmc.integration.net.UrlKt;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.meituan.android.walle.ChannelReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import w5.c;

/* loaded from: classes3.dex */
public class Ym extends com.bytedance.sdk.component.Dq.Dq {
    private final Sj Sj;
    private final Set<HiB> TKC;
    private final TEQ sP;

    /* loaded from: classes3.dex */
    public interface Sj {
        void Sj(boolean z10);
    }

    public Ym(Sj sj2, TEQ teq, HiB... hiBArr) {
        super("SetF");
        HashSet hashSet = new HashSet();
        this.TKC = hashSet;
        this.Sj = sj2;
        this.sP = teq;
        hashSet.addAll(Arrays.asList(hiBArr));
    }

    public static JSONObject Sj(int i11) {
        JSONObject jSONObject = new JSONObject();
        try {
            vS EjP = dNu.EjP();
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("device_city", Mts.TzV());
            if (EjP.LqL(UrlKt.KEY_MINI_GAID)) {
                jSONObject.put(UrlKt.KEY_MINI_GAID, com.bytedance.sdk.openadsdk.RiZ.Sj.sP.Sj.Sj().sP());
            }
            jSONObject.put("gdpr", com.bytedance.sdk.openadsdk.core.uA.sP().TEQ());
            jSONObject.put("pa_consent", com.bytedance.sdk.openadsdk.core.uA.sP().Ym());
            if (EjP.LqL("mcc")) {
                jSONObject.put("mcc", ley.sP());
            }
            Context Sj2 = dNu.Sj();
            jSONObject.put("conn_type", Mts.Jcg(i11));
            jSONObject.put("os", 1);
            jSONObject.put("oversea_version_type", 1);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("aos_api_level", Build.VERSION.SDK_INT);
            jSONObject.put("sdk_version", BuildConfig.VERSION_NAME);
            jSONObject.put(TmcConstants.KEY_LANGUAGE, com.bytedance.sdk.openadsdk.core.aa.sP());
            jSONObject.put("time_zone", Mts.dx());
            jSONObject.put("package_name", Mts.HiB());
            jSONObject.put(RequestParameters.POSITION, Mts.Sj() ? 1 : 2);
            jSONObject.put("app_version", Mts.Jcg());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("uuid", com.bytedance.sdk.openadsdk.core.aa.TKC(Sj2));
            String EjP2 = com.bytedance.sdk.openadsdk.core.uA.sP().EjP();
            if (EjP2 != null) {
                jSONObject.put("app_id", EjP2);
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", currentTimeMillis);
            jSONObject.put("req_sign", com.bytedance.sdk.component.utils.HiB.Sj(EjP2 != null ? EjP2.concat(String.valueOf(currentTimeMillis)).concat(BuildConfig.VERSION_NAME) : ""));
            jSONObject.put("tcstring", Fmk.TKC(Sj2));
            jSONObject.put("tcf_gdpr", Fmk.sP(Sj2));
            jSONObject.put("lmt", DeviceUtils.TKC());
            jSONObject.put("locale_language", DeviceUtils.EjP());
            jSONObject.put(ChannelReader.CHANNEL_KEY, "main");
            JSONObject HiB = EjP.HiB();
            if (HiB != null) {
                jSONObject.put("digest", HiB);
            }
            jSONObject.put("data_time", EjP.vS());
            jSONObject.put("app_set_id_scope", EjP.sP());
            jSONObject.put("app_set_id", EjP.TKC());
            jSONObject.put("installed_source", EjP.EjP());
            if (EjP.LqL(UrlKt.KEY_MINI_GAID)) {
                jSONObject.put("did", com.bytedance.sdk.openadsdk.core.aa.Sj(dNu.Sj()));
            }
            jSONObject.put(UrlKt.KEY_MINI_GAID, com.bytedance.sdk.openadsdk.RiZ.Sj.sP.Sj.Sj().sP());
            String Jcg = com.bytedance.sdk.openadsdk.core.uA.sP().Jcg();
            if (!TextUtils.isEmpty(Jcg)) {
                jSONObject.put("mediation", Jcg);
            }
            jSONObject.put("device", DeviceUtils.Sj(Sj2, true));
            jSONObject.put("adx_id", com.bytedance.sdk.openadsdk.core.uA.sP().wE());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(String str, Map<String, String> map) {
        int i11 = 1;
        try {
            if (!TextUtils.isEmpty(str) && map != null) {
                HashMap hashMap = new HashMap();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        hashMap.put(key.toLowerCase(Locale.US), entry.getValue());
                    }
                }
                int parseInt = Integer.parseInt((String) hashMap.get("active-control"));
                long parseLong = Long.parseLong((String) hashMap.get("ts"));
                String str2 = (String) hashMap.get("pst");
                String a11 = c.a(str + parseInt + parseLong);
                if (a11 != null) {
                    if (a11.equalsIgnoreCase(str2)) {
                        i11 = parseInt;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        uA.Sj(i11);
    }

    public static boolean Sj() {
        return BinderPoolService.Sj;
    }

    private JSONObject sP(JSONObject jSONObject) {
        return com.bytedance.sdk.component.utils.Sj.Sj(jSONObject);
    }

    public boolean Sj(@NonNull JSONObject jSONObject) {
        this.sP.Sj(jSONObject);
        for (HiB hiB : this.TKC) {
            if (hiB != null) {
                hiB.Sj(jSONObject);
            }
        }
        return this.sP.TKC;
    }

    @Override // java.lang.Runnable
    public void run() {
        int Sj2 = wE.Sj(dNu.Sj(), 0L);
        if (Sj2 == 0) {
            this.Sj.Sj(false);
            return;
        }
        JSONObject Sj3 = Sj(Sj2);
        com.bytedance.sdk.component.Jcg.sP.EjP sP = com.bytedance.sdk.openadsdk.TzV.sP.Sj().sP().sP();
        try {
            sP.sP(com.bytedance.sdk.openadsdk.Dq.EjP.Sj(sP, Mts.Sj("/api/ad/union/sdk/settings/", false, true)));
            sP.sP("User-Agent", Mts.TKC());
        } catch (Exception unused) {
        }
        String jSONObject = sP(Sj3).toString();
        if (dNu.EjP().db() && com.bytedance.sdk.openadsdk.core.ley.Sj().EjP() == 1) {
            Mts.Sj("Pangle_Debug_Mode", jSONObject, dNu.Sj());
        }
        sP.Sj(jSONObject, dNu.EjP().uvD());
        sP.Sj(6);
        sP.Sj("setting");
        com.bytedance.sdk.openadsdk.dNu.TKC.Sj(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.core.settings.Ym.1
            @Override // com.bytedance.sdk.openadsdk.dNu.EjP
            public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                com.bytedance.sdk.openadsdk.dNu.sP.Sj sj2 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                sj2.sP("settings_fetch");
                return sj2;
            }
        });
        sP.Sj(new com.bytedance.sdk.component.Jcg.Sj.Sj() { // from class: com.bytedance.sdk.openadsdk.core.settings.Ym.2
            @Override // com.bytedance.sdk.component.Jcg.Sj.Sj
            public void Sj(com.bytedance.sdk.component.Jcg.sP.TKC tkc, com.bytedance.sdk.component.Jcg.sP sPVar) {
                JSONObject jSONObject2;
                int optInt;
                sPVar.Sj();
                String EjP = sPVar.EjP();
                if (dNu.EjP().db() && com.bytedance.sdk.openadsdk.core.ley.Sj().EjP() == 1) {
                    Mts.Sj("Pangle_Debug_Mode", EjP, dNu.Sj());
                }
                if (!sPVar.vS() || TextUtils.isEmpty(EjP)) {
                    com.bytedance.sdk.openadsdk.dNu.TKC.TKC(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.core.settings.Ym.2.2
                        @Override // com.bytedance.sdk.openadsdk.dNu.EjP
                        public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                            com.bytedance.sdk.openadsdk.dNu.sP.Sj sj2 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                            sj2.sP("settings_fetch");
                            return sj2;
                        }
                    });
                    if (tkc != null) {
                        sU.Sj(tkc.EjP());
                    }
                } else {
                    String str = null;
                    try {
                        jSONObject2 = new JSONObject(EjP);
                    } catch (JSONException unused2) {
                        jSONObject2 = null;
                    }
                    if (jSONObject2 != null && (optInt = jSONObject2.optInt("cypher", -1)) != -1) {
                        if (optInt == 3) {
                            str = com.bytedance.sdk.component.utils.Sj.TKC(jSONObject2.optString("message"));
                            if (!TextUtils.isEmpty(str)) {
                                try {
                                    jSONObject2 = new JSONObject(str);
                                } catch (Throwable unused3) {
                                }
                            }
                        }
                        try {
                            Ym.this.Sj(str, sPVar.TKC());
                        } catch (Throwable unused4) {
                        }
                        try {
                            Ym.this.Sj(jSONObject2);
                            dNu.EjP().Sj(System.currentTimeMillis());
                            com.bytedance.sdk.openadsdk.dNu.TKC.sP(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.core.settings.Ym.2.1
                                @Override // com.bytedance.sdk.openadsdk.dNu.EjP
                                public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                                    com.bytedance.sdk.openadsdk.dNu.sP.Sj sj2 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                                    sj2.sP("settings_fetch");
                                    return sj2;
                                }
                            });
                            sU.sP();
                        } catch (Throwable unused5) {
                        }
                        Ym.this.Sj.Sj(true);
                        return;
                    }
                }
                Ym.this.Sj.Sj(false);
            }

            @Override // com.bytedance.sdk.component.Jcg.Sj.Sj
            public void Sj(com.bytedance.sdk.component.Jcg.sP.TKC tkc, IOException iOException) {
                Ym.this.Sj.Sj(false);
                com.bytedance.sdk.openadsdk.dNu.TKC.TKC(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.core.settings.Ym.2.3
                    @Override // com.bytedance.sdk.openadsdk.dNu.EjP
                    public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                        com.bytedance.sdk.openadsdk.dNu.sP.Sj sj2 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                        sj2.sP("settings_fetch");
                        return sj2;
                    }
                });
                if (tkc != null) {
                    sU.Sj(tkc.EjP());
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.Ym.sP(com.bytedance.sdk.openadsdk.core.aa.Sj(dNu.Sj()));
        DeviceUtils.Ym();
    }
}

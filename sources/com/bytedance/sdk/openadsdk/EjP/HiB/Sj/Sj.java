package com.bytedance.sdk.openadsdk.EjP.HiB.Sj;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.openvk.Sj.Sj.Sj.TKC.TKC;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.EjP.HiB.sP.Dq;
import com.bytedance.sdk.openadsdk.EjP.HiB.sP.Fmk;
import com.bytedance.sdk.openadsdk.EjP.HiB.sP.HiB;
import com.bytedance.sdk.openadsdk.EjP.HiB.sP.TEQ;
import com.bytedance.sdk.openadsdk.EjP.HiB.sP.Zq;
import com.bytedance.sdk.openadsdk.EjP.HiB.sP.sP;
import com.bytedance.sdk.openadsdk.EjP.HiB.sP.sef;
import com.bytedance.sdk.openadsdk.EjP.HiB.sP.uA;
import com.bytedance.sdk.openadsdk.EjP.HiB.sP.vS;
import com.bytedance.sdk.openadsdk.EjP.Jcg;
import com.bytedance.sdk.openadsdk.Zq.Sj.EjP;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.utils.Mts;
import com.bytedance.sdk.openadsdk.utils.ib;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import y5.b;
import z5.a;

/* loaded from: classes2.dex */
public class Sj {
    private static final Map<a, Zq> Sj = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: Access modifiers changed from: private */
    public static String EjP(TKC tkc) {
        return new File(tkc.sP(), tkc.sef()).getAbsolutePath();
    }

    public static void EjP(a aVar, Zq.Sj sj2) {
        Zq zq2;
        if (aVar == null || sj2 == null || (zq2 = Sj.get(aVar)) == null) {
            return;
        }
        TKC EjP = zq2.EjP();
        sU HiB = zq2.HiB();
        if (EjP == null || HiB == null) {
            return;
        }
        long Sj2 = sj2.Sj();
        long TKC = sj2.TKC();
        sP sPVar = new sP();
        sPVar.Sj(sj2.sP());
        sPVar.sP(TKC);
        sPVar.Sj(sj2.EjP());
        sPVar.sP(sj2.HiB());
        com.bytedance.sdk.openadsdk.EjP.HiB.sP.Sj sj3 = new com.bytedance.sdk.openadsdk.EjP.HiB.sP.Sj(HiB, Mts.Sj(HiB), Sj(HiB, zq2.sP(), zq2.TKC(), EjP), sPVar);
        sj3.Sj(sj2.TEQ());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", Sj2);
            jSONObject.put("percent", sj2.vS());
            Sj(sj3, "endcard_skip", jSONObject);
        } catch (JSONException e11) {
            com.bytedance.sdk.component.utils.sU.Sj("TTAD.VideoEventManager", "", e11);
        }
    }

    public static void HiB(a aVar, Zq.Sj sj2) {
        Zq zq2;
        if (aVar == null || sj2 == null || sj2.uA() <= 0 || (zq2 = Sj.get(aVar)) == null) {
            return;
        }
        TKC EjP = zq2.EjP();
        sU HiB = zq2.HiB();
        if (EjP == null || HiB == null) {
            return;
        }
        long TKC = sj2.TKC();
        Fmk fmk = new Fmk();
        fmk.Sj(sj2.sP());
        fmk.sP(TKC);
        fmk.Sj(sj2.uA());
        JSONObject Sj2 = Sj(HiB, zq2.sP(), zq2.TKC(), EjP);
        int i11 = EjP.EjP;
        if (i11 > 0) {
            try {
                Sj2.put("play_time", i11);
            } catch (JSONException e11) {
                com.bytedance.sdk.component.utils.sU.Sj("TTAD.VideoEventManager", "", e11);
            }
        }
        com.bytedance.sdk.openadsdk.EjP.HiB.sP.Sj sj3 = new com.bytedance.sdk.openadsdk.EjP.HiB.sP.Sj(HiB, Mts.Sj(HiB), Sj2, fmk);
        sj3.Sj(sj2.TEQ());
        Sj(sj3, "play_buffer");
    }

    public static JSONObject Sj(sU sUVar, String str, int i11, TKC tkc) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("session_id", str);
            }
            if (i11 > 0) {
                jSONObject.put("play_type", String.valueOf(i11));
            }
            if (sUVar != null) {
                b UHs = sUVar.UHs();
                if (UHs != null) {
                    jSONObject.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, UHs.H());
                    jSONObject.put(CampaignEx.JSON_KEY_VIDEO_SIZE, Long.valueOf(UHs.g()));
                    jSONObject.put(CampaignEx.JSON_KEY_VIDEO_URL, UHs.x());
                    jSONObject.put("player_type", tkc.Zq());
                    jSONObject.put("video_encode_type", tkc.Ym() ? 1 : 0);
                }
                jSONObject.put("dp_creative_type", sUVar.AE());
            }
        } catch (JSONException e11) {
            com.bytedance.sdk.component.utils.sU.Sj("TTAD.VideoEventManager", "", e11);
        }
        return jSONObject;
    }

    public static void Sj(Context context, a aVar, Zq.Sj sj2, Jcg jcg) {
        Zq zq2;
        if (context == null || aVar == null || sj2 == null || (zq2 = Sj.get(aVar)) == null) {
            return;
        }
        TKC EjP = zq2.EjP();
        sU HiB = zq2.HiB();
        if (EjP == null || HiB == null) {
            return;
        }
        if (!sj2.TEQ()) {
            Sj(HiB, EjP, sj2);
        }
        Dq dq2 = new Dq();
        dq2.Sj(sj2.Ym() ? 1 : 0);
        dq2.sP(CacheDirFactory.getICacheDir(HiB.Gn()).sP(EjP));
        dq2.Sj(SystemClock.elapsedRealtime() - zq2.Sj());
        JSONObject Sj2 = Sj(HiB, zq2.sP(), zq2.TKC(), EjP);
        int i11 = EjP.EjP;
        if (i11 > 0) {
            try {
                Sj2.put("play_time", i11);
            } catch (JSONException e11) {
                com.bytedance.sdk.component.utils.sU.Sj("TTAD.VideoEventManager", "", e11);
            }
        }
        com.bytedance.sdk.openadsdk.EjP.HiB.sP.Sj sj3 = new com.bytedance.sdk.openadsdk.EjP.HiB.sP.Sj(HiB, Mts.Sj(HiB), Sj2, dq2);
        sj3.Sj(sj2.TEQ());
        Sj(sj3, "feed_play", jcg);
    }

    public static void Sj(com.bytedance.sdk.openadsdk.EjP.HiB.sP.Sj<TEQ> sj2) {
        com.bytedance.sdk.openadsdk.Zq.TKC.Sj("load_video_error", sj2);
    }

    private static void Sj(com.bytedance.sdk.openadsdk.EjP.HiB.sP.Sj sj2, String str) {
        Sj(sj2, str, (JSONObject) null, (Jcg) null);
    }

    private static void Sj(com.bytedance.sdk.openadsdk.EjP.HiB.sP.Sj sj2, String str, Jcg jcg) {
        Sj(sj2, str, (JSONObject) null, jcg);
    }

    private static void Sj(com.bytedance.sdk.openadsdk.EjP.HiB.sP.Sj sj2, String str, JSONObject jSONObject) {
        Sj(sj2, str, jSONObject, (Jcg) null);
    }

    private static void Sj(final com.bytedance.sdk.openadsdk.EjP.HiB.sP.Sj sj2, String str, final JSONObject jSONObject, final Jcg jcg) {
        if (sj2 == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (sj2.HiB() && !TextUtils.isEmpty(sj2.sP())) {
            String sP = sj2.sP();
            sP.hashCode();
            if (sP.equals("stream") || sP.equals("embeded_ad")) {
                str = "customer_".concat(String.valueOf(str));
            }
        }
        final String str2 = str;
        com.bytedance.sdk.openadsdk.EjP.TKC.Sj(System.currentTimeMillis(), sj2.Sj(), sj2.sP(), str2, new com.bytedance.sdk.openadsdk.Zq.TKC.Sj() { // from class: com.bytedance.sdk.openadsdk.EjP.HiB.Sj.Sj.1
            @Override // com.bytedance.sdk.openadsdk.Zq.TKC.Sj
            public JSONObject Sj() {
                Jcg jcg2;
                try {
                    JSONObject TKC = com.bytedance.sdk.openadsdk.EjP.HiB.sP.Sj.this.TKC();
                    if (com.bytedance.sdk.openadsdk.EjP.HiB.sP.Sj.this.EjP() != null) {
                        com.bytedance.sdk.openadsdk.EjP.HiB.sP.Sj.this.EjP().Sj(TKC);
                    }
                    if (("feed_play".equals(str2) || "feed_over".equals(str2) || "feed_break".equals(str2)) && (jcg2 = jcg) != null) {
                        jcg2.Sj(TKC);
                    }
                    jSONObject.put("ad_extra_data", TKC.toString());
                } catch (Throwable unused) {
                }
                return jSONObject;
            }
        });
    }

    private static void Sj(final sU sUVar, final TKC tkc, final Zq.Sj sj2) {
        com.bytedance.sdk.openadsdk.Zq.TKC.Sj();
        com.bytedance.sdk.openadsdk.Zq.TKC.Sj("pangle_video_play_state", false, new com.bytedance.sdk.openadsdk.Zq.sP() { // from class: com.bytedance.sdk.openadsdk.EjP.HiB.Sj.Sj.2
            @Override // com.bytedance.sdk.openadsdk.Zq.sP
            public com.bytedance.sdk.openadsdk.Zq.Sj.TKC getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("service_duration", Sj.TKC(TKC.this));
                jSONObject.put("player_duration", sj2.TKC());
                jSONObject.put("cache_path_type", CacheDirFactory.getCacheType());
                jSONObject.put("url", TKC.this.Fmk());
                jSONObject.put("path", Sj.EjP(TKC.this));
                jSONObject.put("player_type", TKC.this.Zq());
                EjP Sj2 = EjP.sP().Sj("pangle_video_play_state");
                sU sUVar2 = sUVar;
                return Sj2.Sj(sUVar2 != null ? sUVar2.DKa() : 0).sP(jSONObject.toString());
            }
        });
    }

    public static void Sj(sU sUVar, a aVar, TKC tkc) {
        if (sUVar == null || aVar == null || tkc == null) {
            return;
        }
        String Sj2 = ib.Sj();
        int i11 = CacheDirFactory.getICacheDir(sUVar.Gn()).Sj(tkc) ? 1 : 2;
        Sj.put(aVar, new Zq(SystemClock.elapsedRealtime(), Sj2, i11, tkc, sUVar));
        JSONObject Sj3 = Sj(sUVar, Sj2, i11, tkc);
        String Sj4 = Mts.Sj(sUVar);
        try {
            int i12 = tkc.EjP;
            if (i12 > 0) {
                Sj3.put("play_time", i12);
            }
            Sj3.put("is_mute", tkc.Dq() ? 1 : 0);
        } catch (JSONException e11) {
            com.bytedance.sdk.component.utils.sU.Sj("TTAD.VideoEventManager", "", e11);
        }
        com.bytedance.sdk.openadsdk.EjP.HiB.sP.Sj sj2 = new com.bytedance.sdk.openadsdk.EjP.HiB.sP.Sj(sUVar, Sj4, Sj3, null);
        sj2.Sj(tkc.Zq() == -1);
        Sj(sj2, "play_start");
    }

    public static void Sj(a aVar, Zq.Sj sj2) {
        Zq zq2;
        if (aVar == null || sj2 == null || (zq2 = Sj.get(aVar)) == null) {
            return;
        }
        TKC EjP = zq2.EjP();
        sU HiB = zq2.HiB();
        if (EjP == null || HiB == null) {
            return;
        }
        long Sj2 = sj2.Sj();
        long TKC = sj2.TKC();
        if (TKC <= 0 || Sj2 <= 0) {
            return;
        }
        com.bytedance.sdk.openadsdk.EjP.HiB.sP.Jcg jcg = new com.bytedance.sdk.openadsdk.EjP.HiB.sP.Jcg();
        jcg.Sj(sj2.sP());
        jcg.sP(TKC);
        JSONObject Sj3 = Sj(HiB, zq2.sP(), zq2.TKC(), EjP);
        int i11 = EjP.EjP;
        if (i11 > 0) {
            try {
                Sj3.put("play_time", i11);
            } catch (JSONException e11) {
                com.bytedance.sdk.component.utils.sU.Sj("TTAD.VideoEventManager", "", e11);
            }
        }
        com.bytedance.sdk.openadsdk.EjP.HiB.sP.Sj sj3 = new com.bytedance.sdk.openadsdk.EjP.HiB.sP.Sj(HiB, Mts.Sj(HiB), Sj3, jcg);
        sj3.Sj(sj2.TEQ());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", Sj2);
            jSONObject.put("percent", sj2.vS());
            Sj(sj3, "feed_pause", jSONObject);
        } catch (JSONException e12) {
            com.bytedance.sdk.component.utils.sU.Sj("TTAD.VideoEventManager", "", e12);
        }
    }

    public static void Sj(a aVar, Zq.Sj sj2, Jcg jcg) {
        Zq zq2;
        if (aVar == null || sj2 == null || (zq2 = Sj.get(aVar)) == null) {
            return;
        }
        TKC EjP = zq2.EjP();
        sU HiB = zq2.HiB();
        if (EjP == null || HiB == null) {
            return;
        }
        long Sj2 = sj2.Sj();
        long TKC = sj2.TKC();
        com.bytedance.sdk.openadsdk.EjP.HiB.sP.EjP ejP = new com.bytedance.sdk.openadsdk.EjP.HiB.sP.EjP();
        ejP.sP(sj2.sP());
        ejP.Sj(TKC);
        ejP.Sj(sj2.Jcg());
        ejP.sP(sj2.Dq());
        JSONObject Sj3 = Sj(HiB, zq2.sP(), zq2.TKC(), EjP);
        int i11 = EjP.EjP;
        if (i11 > 0) {
            try {
                Sj3.put("play_time", i11);
            } catch (JSONException e11) {
                com.bytedance.sdk.component.utils.sU.Sj("TTAD.VideoEventManager", "", e11);
            }
        }
        com.bytedance.sdk.openadsdk.EjP.HiB.sP.Sj sj3 = new com.bytedance.sdk.openadsdk.EjP.HiB.sP.Sj(HiB, Mts.Sj(HiB), Sj3, ejP);
        sj3.Sj(sj2.TEQ());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", Sj2);
            jSONObject.put("percent", sj2.vS());
            Sj(sj3, "feed_break", jSONObject, jcg);
        } catch (JSONException e12) {
            com.bytedance.sdk.component.utils.sU.Sj("TTAD.VideoEventManager", "", e12);
        }
    }

    public static void Sj(a aVar, boolean z10, String str) {
        Zq zq2;
        if (aVar == null || (zq2 = Sj.get(aVar)) == null) {
            return;
        }
        TKC EjP = zq2.EjP();
        sU HiB = zq2.HiB();
        if (EjP == null || HiB == null) {
            return;
        }
        JSONObject Sj2 = Sj(HiB, zq2.sP(), zq2.TKC(), EjP);
        try {
            int i11 = EjP.EjP;
            if (i11 > 0) {
                Sj2.put("play_time", i11);
            }
            Sj2.put("is_mute", z10 ? 1 : 0);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("from", str);
            Sj2.put("pag_json_data", jSONObject);
        } catch (JSONException e11) {
            com.bytedance.sdk.component.utils.sU.Sj("TTAD.VideoEventManager", "", e11);
        }
        Sj(new com.bytedance.sdk.openadsdk.EjP.HiB.sP.Sj(HiB, Mts.Sj(HiB), Sj2, null), "mute_state_change");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long TKC(TKC tkc) {
        if (tkc == null) {
            return 0L;
        }
        b dx2 = tkc.Ym() ? tkc.dx() : tkc.sU();
        if (dx2 != null) {
            return Double.valueOf(dx2.K() * 1000.0d).longValue();
        }
        return 0L;
    }

    public static void TKC(a aVar, Zq.Sj sj2) {
        Zq zq2;
        if (aVar == null || sj2 == null || (zq2 = Sj.get(aVar)) == null) {
            return;
        }
        TKC EjP = zq2.EjP();
        sU HiB = zq2.HiB();
        if (EjP == null || HiB == null) {
            return;
        }
        long Sj2 = sj2.Sj();
        long TKC = sj2.TKC();
        sef sefVar = new sef(sj2.aa());
        sefVar.Sj(sj2.sP());
        sefVar.sP(TKC);
        JSONObject Sj3 = Sj(HiB, zq2.sP(), zq2.TKC(), EjP);
        int i11 = EjP.EjP;
        if (i11 > 0) {
            try {
                Sj3.put("play_time", i11);
            } catch (JSONException e11) {
                com.bytedance.sdk.component.utils.sU.Sj("TTAD.VideoEventManager", "", e11);
            }
        }
        com.bytedance.sdk.openadsdk.EjP.HiB.sP.Sj sj3 = new com.bytedance.sdk.openadsdk.EjP.HiB.sP.Sj(HiB, Mts.Sj(HiB), Sj3, sefVar);
        sj3.Sj(sj2.TEQ());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", Sj2);
            jSONObject.put("percent", sj2.vS());
            Sj(sj3, "play_error", jSONObject);
        } catch (JSONException e12) {
            com.bytedance.sdk.component.utils.sU.Sj("TTAD.VideoEventManager", "", e12);
        }
        Sj.remove(aVar);
    }

    public static void sP(com.bytedance.sdk.openadsdk.EjP.HiB.sP.Sj<uA> sj2) {
        com.bytedance.sdk.openadsdk.Zq.TKC.Sj("load_video_cancel", sj2);
    }

    public static void sP(a aVar, Zq.Sj sj2) {
        Zq zq2;
        if (aVar == null || sj2 == null || (zq2 = Sj.get(aVar)) == null) {
            return;
        }
        TKC EjP = zq2.EjP();
        sU HiB = zq2.HiB();
        if (EjP == null || HiB == null) {
            return;
        }
        long Sj2 = sj2.Sj();
        long TKC = sj2.TKC();
        if (TKC <= 0 || Sj2 <= 0) {
            return;
        }
        HiB hiB = new HiB();
        hiB.Sj(sj2.sP());
        hiB.sP(TKC);
        JSONObject Sj3 = Sj(HiB, zq2.sP(), zq2.TKC(), EjP);
        int i11 = EjP.EjP;
        if (i11 > 0) {
            try {
                Sj3.put("play_time", i11);
            } catch (JSONException e11) {
                com.bytedance.sdk.component.utils.sU.Sj("TTAD.VideoEventManager", "", e11);
            }
        }
        com.bytedance.sdk.openadsdk.EjP.HiB.sP.Sj sj3 = new com.bytedance.sdk.openadsdk.EjP.HiB.sP.Sj(HiB, Mts.Sj(HiB), Sj3, hiB);
        sj3.Sj(sj2.TEQ());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", Sj2);
            jSONObject.put("percent", sj2.vS());
            Sj(sj3, "feed_continue", jSONObject);
        } catch (JSONException e12) {
            com.bytedance.sdk.component.utils.sU.Sj("TTAD.VideoEventManager", "", e12);
        }
    }

    public static void sP(a aVar, Zq.Sj sj2, Jcg jcg) {
        if (aVar == null || sj2 == null) {
            return;
        }
        HiB(aVar, sj2);
        Zq zq2 = Sj.get(aVar);
        if (zq2 == null) {
            return;
        }
        TKC EjP = zq2.EjP();
        sU HiB = zq2.HiB();
        if (EjP == null || HiB == null) {
            return;
        }
        long Sj2 = sj2.Sj();
        long TKC = sj2.TKC();
        vS vSVar = new vS();
        vSVar.sP(sj2.sP());
        vSVar.Sj(TKC);
        vSVar.Sj(sj2.Dq());
        JSONObject Sj3 = Sj(HiB, zq2.sP(), zq2.TKC(), EjP);
        int i11 = EjP.EjP;
        if (i11 > 0) {
            try {
                Sj3.put("play_time", i11);
            } catch (JSONException e11) {
                com.bytedance.sdk.component.utils.sU.Sj("TTAD.VideoEventManager", "", e11);
            }
        }
        com.bytedance.sdk.openadsdk.EjP.HiB.sP.Sj sj3 = new com.bytedance.sdk.openadsdk.EjP.HiB.sP.Sj(HiB, Mts.Sj(HiB), Sj3, vSVar);
        sj3.Sj(sj2.TEQ());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", Sj2);
            jSONObject.put("percent", sj2.vS());
            Sj(sj3, "feed_over", jSONObject, jcg);
        } catch (JSONException e12) {
            com.bytedance.sdk.component.utils.sU.Sj("TTAD.VideoEventManager", "", e12);
        }
        Sj.remove(aVar);
    }
}

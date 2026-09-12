package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.LqL;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.model.sef;
import com.bytedance.sdk.openadsdk.core.sP.TKC;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.FPG;
import com.bytedance.sdk.openadsdk.utils.Mts;
import com.cloud.tmc.component_api_ps.ipc.constants.MiniAppIpcConfig;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.transsion.push.PushConstants;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Yf implements com.bytedance.sdk.component.adexpress.HiB.sP, LqL.Sj, com.bytedance.sdk.openadsdk.TEQ.sP {
    private static final Map<String, Boolean> Dq;
    private com.bytedance.sdk.openadsdk.core.widget.Sj.Sj Ei;
    private WeakReference<com.bytedance.sdk.component.uA.vS> EjP;
    private com.bytedance.sdk.openadsdk.EjP.EjP.HiB FPG;
    private String Fm;
    private int Fmk;
    private com.bytedance.sdk.openadsdk.aa.Dq HpB;
    private HashMap<String, TEQ> JcM;
    private com.bytedance.sdk.openadsdk.core.widget.HiB Jcg;
    private com.bytedance.sdk.openadsdk.aa.TKC LqL;
    private com.bytedance.sdk.component.adexpress.sP.Ym RiZ;
    protected Map<String, Object> Sj;
    private String TEQ;
    private JSONObject TzV;
    private com.bytedance.sdk.openadsdk.core.aa.EjP.sP UHs;
    private com.bytedance.sdk.component.Sj.dNu Wjd;
    private com.bytedance.sdk.openadsdk.aa.Ym Yf;
    private WeakReference<View> Ym;
    private int Zq;

    /* renamed from: aa, reason: collision with root package name */
    private String f21116aa;
    private com.bytedance.sdk.openadsdk.core.model.sU dNu;

    /* renamed from: db, reason: collision with root package name */
    private boolean f21117db;
    private Sj dwU;

    /* renamed from: dx, reason: collision with root package name */
    private JSONObject f21118dx;
    private List<com.bytedance.sdk.openadsdk.core.model.sU> fF;

    /* renamed from: ib, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.aa.Sj f21119ib;
    private com.bytedance.sdk.openadsdk.aa.vS kF;
    private com.bytedance.sdk.openadsdk.core.sP.EjP ley;
    private boolean ndK;
    private Context qRN;
    boolean sP;
    private com.bytedance.sdk.openadsdk.core.Dq.sef sU;
    private TKC sdp;
    private String sef;
    private com.bytedance.sdk.openadsdk.TEQ.TKC uA;
    private com.bytedance.sdk.openadsdk.aa.HiB uP;
    private String vS;
    private JSONObject wE;
    private com.bytedance.sdk.openadsdk.aa.sP xD;
    private com.bytedance.sdk.openadsdk.aa.Jcg xhi;
    private com.bytedance.sdk.openadsdk.TEQ.EjP zR;
    private boolean uvD = true;
    private boolean LD = true;
    private boolean WMZ = false;
    private boolean Mts = false;
    boolean TKC = false;

    /* renamed from: jb, reason: collision with root package name */
    private boolean f21120jb = false;
    private final com.bytedance.sdk.component.utils.LqL HiB = new com.bytedance.sdk.component.utils.LqL(Looper.getMainLooper(), this);

    /* loaded from: classes3.dex */
    public interface Sj {
        void Sj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class TKC implements Runnable {
        private final com.bytedance.sdk.openadsdk.core.Dq.sef Sj;
        private final JSONObject sP;

        public TKC(com.bytedance.sdk.openadsdk.core.Dq.sef sefVar, JSONObject jSONObject) {
            this.Sj = sefVar;
            this.sP = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Yf.sP(this.Sj, this.sP);
        }
    }

    /* loaded from: classes3.dex */
    public static class sP {
        public JSONObject EjP;
        public int HiB;
        public String Sj;
        public String TKC;
        public String sP;
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Dq = concurrentHashMap;
        Boolean bool = Boolean.TRUE;
        concurrentHashMap.put("log_event", bool);
        concurrentHashMap.put("private", bool);
        concurrentHashMap.put("dispatch_message", bool);
        concurrentHashMap.put("custom_event", bool);
        concurrentHashMap.put("log_event_v3", bool);
    }

    public Yf(Context context) {
        this.qRN = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Dq(String str) {
        if (!TextUtils.isEmpty(str) && "click_other".equals(str)) {
            return TEQ();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fmk(JSONObject jSONObject) {
        if (this.sU != null && jSONObject != null) {
            try {
                this.sU.Sj(jSONObject.optInt("stateType", -1));
            } catch (Exception unused) {
            }
        }
    }

    private void Jcg(String str) {
        try {
            JSONArray jSONArray = new JSONArray(new String(Base64.decode(str, 2)));
            int length = jSONArray.length();
            for (int i11 = 0; i11 < length; i11++) {
                sP sPVar = new sP();
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i11);
                    if (optJSONObject != null) {
                        sPVar.Sj = optJSONObject.optString("__msg_type", null);
                        sPVar.sP = optJSONObject.optString("__callback_id", null);
                        sPVar.TKC = optJSONObject.optString("func");
                        sPVar.EjP = optJSONObject.optJSONObject("params");
                        sPVar.HiB = optJSONObject.optInt("JSSDK");
                    }
                } catch (Throwable unused) {
                }
                if (!TextUtils.isEmpty(sPVar.Sj) && !TextUtils.isEmpty(sPVar.TKC)) {
                    Message obtainMessage = this.HiB.obtainMessage(11);
                    obtainMessage.obj = sPVar;
                    this.HiB.sendMessage(obtainMessage);
                }
            }
        } catch (Exception unused2) {
        }
    }

    private void RiZ() {
        com.bytedance.sdk.openadsdk.aa.Ym ym2 = this.Yf;
        if (ym2 == null) {
            return;
        }
        ym2.sP();
    }

    private boolean RiZ(JSONObject jSONObject) {
        try {
            jSONObject.put("creatives", sP(this.fF));
        } catch (Exception unused) {
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Sj(String str, String str2) {
        return com.bytedance.sdk.openadsdk.core.model.TzV.HiB(this.dNu) ? PushConstants.PUSH_SERVICE_TYPE_SHOW.equals(str2) ? Mts.Sj(this.Fmk) : "aggregate_page" : com.bytedance.sdk.openadsdk.core.model.uP.HiB(this.dNu) ? this.vS : this.LqL != null ? Mts.Sj(this.Fmk) : this.RiZ == null ? Mts.sP(this.Fmk) : str;
    }

    private void Sj(final sP sPVar, final JSONObject jSONObject) {
        if (sPVar == null) {
            return;
        }
        try {
            Sj(sPVar.EjP, new com.bytedance.sdk.openadsdk.aa.EjP() { // from class: com.bytedance.sdk.openadsdk.core.Yf.6
                @Override // com.bytedance.sdk.openadsdk.aa.EjP
                public void Sj(boolean z10, List<com.bytedance.sdk.openadsdk.core.model.sU> list) {
                    if (!z10) {
                        Yf.this.sP(sPVar.sP, jSONObject);
                        return;
                    }
                    try {
                        jSONObject.put("creatives", Yf.sP(list));
                        Yf.this.sP(sPVar.sP, jSONObject);
                    } catch (Exception unused) {
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    private void Sj(com.bytedance.sdk.openadsdk.core.model.sU sUVar, String str, boolean z10) {
        com.bytedance.sdk.openadsdk.core.sP.Sj sj2 = new com.bytedance.sdk.openadsdk.core.sP.Sj(dNu.Sj(), sUVar, str, this.Fmk);
        sj2.Sj(com.bytedance.sdk.openadsdk.RiZ.Sj.Sj.Jcg.Sj(dNu.Sj(), sUVar, str));
        if (!z10) {
            sj2.Sj(false);
        }
        sj2.onClick(null);
    }

    private void Sj(String str, boolean z10) {
        if (this.FPG == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (z10) {
            this.FPG.Sj(str);
        } else {
            this.FPG.sP(str);
        }
    }

    public static void Sj(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.sU sUVar) throws Exception {
        String aZ = sUVar.aZ();
        if (!TextUtils.isEmpty(aZ)) {
            jSONObject.put(BidResponsedEx.KEY_CID, aZ);
        }
        String mZN = sUVar.mZN();
        if (!TextUtils.isEmpty(mZN)) {
            jSONObject.put("log_extra", mZN);
        }
        String Lip = sUVar.Lip();
        if (!TextUtils.isEmpty(Lip)) {
            jSONObject.put("download_url", Lip);
        }
        jSONObject.put("dc", TextUtils.isEmpty(dNu.EjP().FPG()) ? dNu.EjP().FPG() : "TX");
        jSONObject.put(TmcConstants.KEY_LANGUAGE, aa.sP());
        jSONObject.put("isRTL", com.bytedance.sdk.openadsdk.core.settings.Fmk.gq().EZ());
    }

    private void Sj(JSONObject jSONObject, boolean z10, String str) {
        com.bytedance.sdk.openadsdk.core.widget.HiB hiB;
        if (z10) {
            try {
                String optString = jSONObject.optString("ad_extra_data");
                if (TextUtils.isEmpty(optString) || new JSONObject(optString).optInt("agg_request_type", -1) != 1 || !"click".equals(str) || (hiB = this.Jcg) == null) {
                    return;
                }
                hiB.Sj();
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.sU.Sj("TTAD.AndroidObject", "callAggClickListener faile", th2);
            }
        }
    }

    private boolean Sj(String str, int i11, com.bytedance.sdk.openadsdk.core.model.sef sefVar) {
        HashMap<String, TEQ> hashMap;
        if (TextUtils.isEmpty(str) || (hashMap = this.JcM) == null || hashMap.get(str) == null) {
            return false;
        }
        throw null;
    }

    private boolean Sj(JSONObject jSONObject, JSONObject jSONObject2) {
        String str;
        int i11;
        String str2;
        if (jSONObject != null) {
            i11 = jSONObject.optInt("landingStyle");
            str = jSONObject.optString("url");
            str2 = jSONObject.optString("fallback_url");
        } else {
            str = null;
            i11 = -1;
            str2 = null;
        }
        boolean z10 = false;
        if (i11 == 1) {
            if (!com.bytedance.sdk.component.utils.TzV.Sj(str)) {
                try {
                    jSONObject2.put("invalid_url", 1);
                } catch (JSONException e11) {
                    com.bytedance.sdk.component.utils.sU.Sj("TTAD.AndroidObject", "handleUrl, EX1->: ", e11);
                }
                return z10;
            }
        } else if (i11 == 2) {
            try {
                if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                    jSONObject2.put("empty_url", 1);
                } else if (!com.bytedance.sdk.component.utils.TzV.Sj(str2)) {
                    jSONObject2.put("invalid_url", 1);
                }
            } catch (JSONException e12) {
                com.bytedance.sdk.component.utils.sU.Sj("TTAD.AndroidObject", "handleUrl, EX2->: ", e12);
            }
            return z10;
        }
        z10 = true;
        return z10;
    }

    private void TEQ(JSONObject jSONObject) throws Exception {
        if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.model.uP.Ym(this.dNu))) {
            return;
        }
        jSONObject.put("playable_style", com.bytedance.sdk.openadsdk.core.model.uP.Ym(this.dNu));
    }

    private JSONObject TKC(com.bytedance.sdk.openadsdk.core.model.sU sUVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("is_ad_event", "1");
        jSONObject2.put(BidResponsedEx.KEY_CID, sUVar.Ci());
        jSONObject2.put("req_id", sUVar.cKW());
        jSONObject2.put("ad_id", sUVar.aZ());
        jSONObject2.put("log_extra", sUVar.mZN());
        jSONObject2.put("isRTL", com.bytedance.sdk.openadsdk.core.settings.Fmk.gq().EZ());
        jSONObject.put("ad_info", jSONObject2);
        jSONObject.put("endcard_creative", sUVar.tc());
        return jSONObject;
    }

    private void TKC(String str, JSONObject jSONObject) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", NotificationCompat.CATEGORY_EVENT);
            jSONObject2.put("__event_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            sU(jSONObject2);
        } catch (Exception unused) {
        }
    }

    private void TzV() {
        com.bytedance.sdk.openadsdk.aa.Ym ym2 = this.Yf;
        if (ym2 == null) {
            return;
        }
        ym2.Sj();
    }

    private void TzV(JSONObject jSONObject) {
        if (jSONObject == null || this.zR == null) {
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("temaiProductIds");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                this.zR.Sj(false, null);
            } else {
                this.zR.Sj(true, optJSONArray);
            }
        } catch (Exception unused) {
            this.zR.Sj(false, null);
        }
    }

    private void Ym(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.EjP.EjP.HiB hiB;
        if (jSONObject == null || (hiB = this.FPG) == null) {
            return;
        }
        hiB.sP(jSONObject);
    }

    private JSONObject Zq() {
        try {
            View view = this.Ym.get();
            com.bytedance.sdk.component.uA.vS vSVar = this.EjP.get();
            if (view != null && vSVar != null) {
                int[] sP2 = FPG.sP(view);
                int[] sP3 = FPG.sP((View) vSVar);
                if (sP2 != null && sP3 != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("x", FPG.TKC(dNu.Sj(), sP2[0] - sP3[0]));
                    jSONObject.put("y", FPG.TKC(dNu.Sj(), sP2[1] - sP3[1]));
                    jSONObject.put("w", FPG.TKC(dNu.Sj(), view.getWidth()));
                    jSONObject.put("h", FPG.TKC(dNu.Sj(), view.getHeight()));
                    jSONObject.put(TmcConstants.KEY_STORAGE_ADD_HOME_IS_EXIST, true);
                    return jSONObject;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private void Zq(JSONObject jSONObject) {
        int i11;
        double d11;
        double d12;
        boolean z10;
        double d13;
        String optString;
        int optInt;
        com.bytedance.sdk.openadsdk.aa.Dq dq2;
        Yf yf2 = this;
        if (yf2.RiZ == null || jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.EjP.EjP.HiB hiB = yf2.FPG;
        if (hiB != null) {
            hiB.uvD();
        }
        com.bytedance.sdk.component.adexpress.sP.sef sefVar = new com.bytedance.sdk.component.adexpress.sP.sef();
        sefVar.Sj(1);
        try {
            boolean optBoolean = jSONObject.optBoolean("isRenderSuc");
            JSONObject optJSONObject = jSONObject.optJSONObject("AdSize");
            if (optJSONObject != null) {
                d11 = optJSONObject.optDouble("width");
                d12 = optJSONObject.optDouble("height");
            } else {
                d11 = 0.0d;
                d12 = 0.0d;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("videoInfo");
            if (optJSONObject2 != null) {
                try {
                    double optDouble = optJSONObject2.optDouble("x");
                    double optDouble2 = optJSONObject2.optDouble("y");
                    z10 = optBoolean;
                    double optDouble3 = optJSONObject2.optDouble("width");
                    double optDouble4 = optJSONObject2.optDouble("height");
                    if (yf2.uvD(optJSONObject2)) {
                        d13 = d12;
                        sefVar.Sj((float) optJSONObject2.optDouble("borderRadiusTopLeft"));
                        sefVar.sP((float) optJSONObject2.optDouble("borderRadiusTopRight"));
                        sefVar.TKC((float) optJSONObject2.optDouble("borderRadiusBottomLeft"));
                        sefVar.EjP((float) optJSONObject2.optDouble("borderRadiusBottomRight"));
                    } else {
                        d13 = d12;
                    }
                    sefVar.TKC(optDouble);
                    sefVar.EjP(optDouble2);
                    sefVar.HiB(optDouble3);
                    sefVar.vS(optDouble4);
                } catch (Exception unused) {
                    i11 = 101;
                    yf2 = this;
                    sefVar.sP(i11);
                    sefVar.Sj(Dq.Sj(i11));
                    yf2.RiZ.Sj(sefVar);
                }
            } else {
                z10 = optBoolean;
                d13 = d12;
            }
            try {
                optString = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, Dq.Sj(101));
                optInt = jSONObject.optInt("code", 101);
            } catch (Exception unused2) {
                yf2 = this;
                i11 = 101;
                sefVar.sP(i11);
                sefVar.Sj(Dq.Sj(i11));
                yf2.RiZ.Sj(sefVar);
            }
            try {
                sefVar.Sj(z10);
                sefVar.Sj(d11);
                sefVar.sP(d13);
                sefVar.Sj(optString);
                sefVar.sP(optInt);
                yf2 = this;
                yf2.RiZ.Sj(sefVar);
                if (optJSONObject2 == null || (dq2 = yf2.HpB) == null) {
                    return;
                }
                dq2.Sj(sefVar);
            } catch (Exception unused3) {
                yf2 = this;
                i11 = 101;
                sefVar.sP(i11);
                sefVar.Sj(Dq.Sj(i11));
                yf2.RiZ.Sj(sefVar);
            }
        } catch (Exception unused4) {
        }
    }

    private void aa(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.aa.TKC tkc = this.LqL;
        if (tkc == null || jSONObject == null) {
            return;
        }
        tkc.Sj(jSONObject.optBoolean("isRenderSuc", false), jSONObject.optInt("code", -1), jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, ""));
    }

    private Context dNu() {
        WeakReference<com.bytedance.sdk.component.uA.vS> weakReference = this.EjP;
        Activity Sj2 = (weakReference == null || weakReference.get() == null) ? null : com.bytedance.sdk.component.utils.sP.Sj(this.EjP.get());
        return Sj2 == null ? this.qRN : Sj2;
    }

    private void dNu(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            Uri parse = Uri.parse(jSONObject.optString("trackData"));
            if ("bytedance".equals(parse.getScheme().toLowerCase())) {
                com.bytedance.sdk.openadsdk.utils.TzV.Sj(parse, this);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject dx(JSONObject jSONObject) {
        if (this.Sj != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                String optString = jSONObject.optString("ad_extra_data", null);
                if (optString != null) {
                    jSONObject2 = new JSONObject(optString);
                }
                for (Map.Entry<String, Object> entry : this.Sj.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (Exception e11) {
                com.bytedance.sdk.component.utils.sU.sP(e11.toString(), new Object[0]);
            }
        }
        return jSONObject;
    }

    private void dx() {
        if (this.qRN == null || TextUtils.isEmpty(dNu.EjP().JcM())) {
            return;
        }
        TTWebsiteActivity.Sj(this.qRN, this.dNu, this.Fm);
    }

    private boolean ib() {
        com.bytedance.sdk.openadsdk.core.model.sU sUVar = this.dNu;
        if (sUVar == null || sUVar.nP() == null || com.bytedance.sdk.openadsdk.core.model.uP.sP(this.dNu) || this.WMZ || this.dNu.nP().optInt("parent_type") != 2) {
            return false;
        }
        int DKa = this.dNu.DKa();
        if (DKa != 8 && DKa != 7) {
            return false;
        }
        this.WMZ = true;
        return true;
    }

    private void kF() {
        if (this.uA == null) {
            this.uA = com.bytedance.sdk.openadsdk.TEQ.Sj.Sj(this, this.dNu);
        }
    }

    public static JSONArray sP(List<com.bytedance.sdk.openadsdk.core.model.sU> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            jSONArray.put(list.get(i11).SP());
        }
        return jSONArray;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b6 A[Catch: Exception -> 0x00e4, TryCatch #0 {Exception -> 0x00e4, blocks: (B:57:0x000f, B:9:0x0017, B:11:0x001f, B:13:0x0025, B:15:0x0038, B:17:0x003e, B:18:0x004f, B:26:0x0075, B:27:0x008e, B:29:0x00a6, B:32:0x00af, B:34:0x00b6, B:35:0x00bc, B:38:0x00c7, B:39:0x00ce, B:41:0x00d6, B:44:0x00e1, B:48:0x00cb, B:51:0x0082, B:53:0x0043, B:54:0x002a), top: B:56:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c7 A[Catch: Exception -> 0x00e4, TRY_ENTER, TryCatch #0 {Exception -> 0x00e4, blocks: (B:57:0x000f, B:9:0x0017, B:11:0x001f, B:13:0x0025, B:15:0x0038, B:17:0x003e, B:18:0x004f, B:26:0x0075, B:27:0x008e, B:29:0x00a6, B:32:0x00af, B:34:0x00b6, B:35:0x00bc, B:38:0x00c7, B:39:0x00ce, B:41:0x00d6, B:44:0x00e1, B:48:0x00cb, B:51:0x0082, B:53:0x0043, B:54:0x002a), top: B:56:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cb A[Catch: Exception -> 0x00e4, TryCatch #0 {Exception -> 0x00e4, blocks: (B:57:0x000f, B:9:0x0017, B:11:0x001f, B:13:0x0025, B:15:0x0038, B:17:0x003e, B:18:0x004f, B:26:0x0075, B:27:0x008e, B:29:0x00a6, B:32:0x00af, B:34:0x00b6, B:35:0x00bc, B:38:0x00c7, B:39:0x00ce, B:41:0x00d6, B:44:0x00e1, B:48:0x00cb, B:51:0x0082, B:53:0x0043, B:54:0x002a), top: B:56:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject sP(com.bytedance.sdk.openadsdk.core.model.sU r10) {
        /*
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            com.bytedance.sdk.openadsdk.core.settings.vS r1 = com.bytedance.sdk.openadsdk.core.dNu.EjP()
            if (r1 != 0) goto Lc
            return r0
        Lc:
            r1 = 0
            if (r10 == 0) goto L14
            int r2 = r10.If()     // Catch: java.lang.Exception -> Le4
            goto L15
        L14:
            r2 = r1
        L15:
            if (r10 == 0) goto L1c
            int r3 = r10.DKa()     // Catch: java.lang.Exception -> Le4
            goto L1d
        L1c:
            r3 = r1
        L1d:
            if (r10 == 0) goto L2a
            int r4 = r10.sP()     // Catch: java.lang.Exception -> Le4
            if (r4 < 0) goto L2a
            int r4 = r10.sP()     // Catch: java.lang.Exception -> Le4
            goto L36
        L2a:
            com.bytedance.sdk.openadsdk.core.settings.vS r4 = com.bytedance.sdk.openadsdk.core.dNu.EjP()     // Catch: java.lang.Exception -> Le4
            java.lang.String r5 = java.lang.String.valueOf(r2)     // Catch: java.lang.Exception -> Le4
            int r4 = r4.TEQ(r5)     // Catch: java.lang.Exception -> Le4
        L36:
            if (r10 == 0) goto L43
            int r5 = r10.Sj()     // Catch: java.lang.Exception -> Le4
            if (r5 < 0) goto L43
            int r5 = r10.Sj()     // Catch: java.lang.Exception -> Le4
            goto L4f
        L43:
            com.bytedance.sdk.openadsdk.core.settings.vS r5 = com.bytedance.sdk.openadsdk.core.dNu.EjP()     // Catch: java.lang.Exception -> Le4
            java.lang.String r6 = java.lang.String.valueOf(r2)     // Catch: java.lang.Exception -> Le4
            int r5 = r5.RiZ(r6)     // Catch: java.lang.Exception -> Le4
        L4f:
            com.bytedance.sdk.openadsdk.core.settings.vS r6 = com.bytedance.sdk.openadsdk.core.dNu.EjP()     // Catch: java.lang.Exception -> Le4
            java.lang.String r7 = java.lang.String.valueOf(r2)     // Catch: java.lang.Exception -> Le4
            boolean r6 = r6.vS(r7)     // Catch: java.lang.Exception -> Le4
            com.bytedance.sdk.openadsdk.core.settings.vS r7 = com.bytedance.sdk.openadsdk.core.dNu.EjP()     // Catch: java.lang.Exception -> Le4
            java.lang.String r8 = java.lang.String.valueOf(r2)     // Catch: java.lang.Exception -> Le4
            int r7 = r7.Fmk(r8)     // Catch: java.lang.Exception -> Le4
            r8 = 1
            if (r7 != r8) goto L6c
            r7 = r8
            goto L6d
        L6c:
            r7 = r1
        L6d:
            r9 = 7
            if (r3 == r9) goto L82
            r9 = 8
            if (r3 != r9) goto L75
            goto L82
        L75:
            com.bytedance.sdk.openadsdk.core.settings.vS r3 = com.bytedance.sdk.openadsdk.core.dNu.EjP()     // Catch: java.lang.Exception -> Le4
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Exception -> Le4
            boolean r2 = r3.TKC(r2)     // Catch: java.lang.Exception -> Le4
            goto L8e
        L82:
            com.bytedance.sdk.openadsdk.core.settings.vS r3 = com.bytedance.sdk.openadsdk.core.dNu.EjP()     // Catch: java.lang.Exception -> Le4
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Exception -> Le4
            boolean r2 = r3.dNu(r2)     // Catch: java.lang.Exception -> Le4
        L8e:
            java.lang.String r3 = "voice_control"
            r0.put(r3, r2)     // Catch: java.lang.Exception -> Le4
            java.lang.String r2 = "rv_skip_time"
            r0.put(r2, r4)     // Catch: java.lang.Exception -> Le4
            java.lang.String r2 = "fv_skip_show"
            r0.put(r2, r6)     // Catch: java.lang.Exception -> Le4
            java.lang.String r2 = "iv_skip_time"
            r0.put(r2, r5)     // Catch: java.lang.Exception -> Le4
            java.lang.String r2 = "show_dislike"
            if (r10 == 0) goto Lae
            boolean r3 = r10.RrR()     // Catch: java.lang.Exception -> Le4
            if (r3 == 0) goto Lae
            r3 = r8
            goto Laf
        Lae:
            r3 = r1
        Laf:
            r0.put(r2, r3)     // Catch: java.lang.Exception -> Le4
            java.lang.String r2 = "video_adaptation"
            if (r10 == 0) goto Lbb
            int r3 = r10.Mts()     // Catch: java.lang.Exception -> Le4
            goto Lbc
        Lbb:
            r3 = r1
        Lbc:
            r0.put(r2, r3)     // Catch: java.lang.Exception -> Le4
            boolean r2 = com.bytedance.sdk.openadsdk.core.model.TzV.TKC(r10)     // Catch: java.lang.Exception -> Le4
            java.lang.String r3 = "skip_change_to_close"
            if (r2 == 0) goto Lcb
            r0.put(r3, r8)     // Catch: java.lang.Exception -> Le4
            goto Lce
        Lcb:
            r0.put(r3, r7)     // Catch: java.lang.Exception -> Le4
        Lce:
            java.lang.String r2 = "bar_render_platform"
            boolean r10 = r10.tR()     // Catch: java.lang.Exception -> Le4
            if (r10 == 0) goto Le1
            com.bytedance.sdk.openadsdk.core.settings.vS r10 = com.bytedance.sdk.openadsdk.core.settings.Fmk.gq()     // Catch: java.lang.Exception -> Le4
            boolean r10 = r10.eI()     // Catch: java.lang.Exception -> Le4
            if (r10 == 0) goto Le1
            r1 = r8
        Le1:
            r0.put(r2, r1)     // Catch: java.lang.Exception -> Le4
        Le4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.Yf.sP(com.bytedance.sdk.openadsdk.core.model.sU):org.json.JSONObject");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sP(com.bytedance.sdk.openadsdk.core.Dq.sef sefVar, JSONObject jSONObject) {
        if (sefVar == null || jSONObject == null) {
            return;
        }
        try {
            sefVar.Sj(jSONObject.optBoolean(CampaignEx.JSON_NATIVE_VIDEO_MUTE, false), !jSONObject.has(CampaignEx.JSON_NATIVE_VIDEO_MUTE) ? "jsb_def" : "jsb_web");
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sP(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "callback");
            jSONObject2.put("__callback_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            sU(jSONObject2);
        } catch (Exception unused) {
        }
    }

    public static void sP(JSONObject jSONObject) throws Exception {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = uvD().iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        jSONObject.put(MiniAppIpcConfig.IPC_ADDHOME_APP_NAME, com.bytedance.sdk.openadsdk.common.sP.Sj());
        jSONObject.put("innerAppName", com.bytedance.sdk.openadsdk.common.sP.HiB());
        jSONObject.put("aid", com.bytedance.sdk.openadsdk.common.sP.sP());
        jSONObject.put("sdkEdition", com.bytedance.sdk.openadsdk.common.sP.TKC());
        jSONObject.put(TmcStartParams.KEY_APP_VERSION, com.bytedance.sdk.openadsdk.common.sP.EjP());
        jSONObject.put("netType", com.bytedance.sdk.openadsdk.common.sP.vS());
        jSONObject.put("supportList", jSONArray);
        jSONObject.put("deviceId", com.bytedance.sdk.openadsdk.common.sP.Sj(dNu.Sj()));
        if (DeviceUtils.sP(dNu.Sj())) {
            jSONObject.put("device_platform", "Android_Pad");
        } else {
            jSONObject.put("device_platform", "Android");
        }
        jSONObject.put("device_type", Build.VERSION.RELEASE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sU() {
        com.bytedance.sdk.openadsdk.core.Dq.sef sefVar = this.sU;
        if (sefVar != null) {
            sefVar.Sj();
        }
    }

    private void sU(JSONObject jSONObject) {
        WebView sef;
        if (jSONObject == null || (sef = sef()) == null) {
            return;
        }
        com.bytedance.sdk.component.utils.sef.Sj(sef, "javascript:ToutiaoJSBridge._handleMessageFromToutiao(" + jSONObject + ")");
    }

    private WebView sef() {
        com.bytedance.sdk.component.uA.vS vSVar;
        WeakReference<com.bytedance.sdk.component.uA.vS> weakReference = this.EjP;
        if (weakReference == null || (vSVar = weakReference.get()) == null) {
            return null;
        }
        return vSVar.getWebView();
    }

    private boolean sef(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.Dq.sef sefVar = this.sU;
        if (sefVar != null && jSONObject != null) {
            double TKC2 = sefVar.TKC();
            int EjP = this.sU.EjP();
            try {
                jSONObject.put("currentTime", TKC2 / 1000.0d);
                jSONObject.put("state", EjP);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private void uA(String str) {
        int indexOf;
        if (str != null && str.startsWith("bytedance://")) {
            try {
                if (str.equals("bytedance://dispatch_message/")) {
                    WebView sef = sef();
                    if (sef != null) {
                        com.bytedance.sdk.component.utils.sef.Sj(sef, "javascript:ToutiaoJSBridge._fetchQueue()");
                        return;
                    }
                    return;
                }
                if (!str.startsWith("bytedance://private/setresult/") || (indexOf = str.indexOf(38, 30)) <= 0) {
                    return;
                }
                String substring = str.substring(30, indexOf);
                String substring2 = str.substring(indexOf + 1);
                if (!substring.equals("SCENE_FETCHQUEUE") || substring2.length() <= 0) {
                    return;
                }
                Jcg(substring2);
            } catch (Exception unused) {
            }
        }
    }

    private void uA(JSONObject jSONObject) throws Exception {
        if (this.f21117db) {
            com.bytedance.sdk.openadsdk.core.model.sU sUVar = this.dNu;
            if ((sUVar instanceof com.bytedance.sdk.openadsdk.core.model.dx) && ((com.bytedance.sdk.openadsdk.core.model.dx) sUVar).Qne()) {
                JSONArray jSONArray = new JSONArray();
                jSONObject.put("adInfos", jSONArray);
                for (com.bytedance.sdk.openadsdk.core.model.sU sUVar2 : ((com.bytedance.sdk.openadsdk.core.model.dx) this.dNu).GhY()) {
                    JSONObject jSONObject2 = new JSONObject();
                    Sj(jSONObject2, sUVar2);
                    jSONArray.put(jSONObject2);
                }
                return;
            }
        }
        Sj(jSONObject, this.dNu);
    }

    private static List<String> uvD() {
        return Arrays.asList(TmcConstants.EXTRA_APPINFO, "adInfo", "getTemplateInfo", "getTeMaiAds");
    }

    private boolean uvD(@NonNull JSONObject jSONObject) {
        return jSONObject.has("borderRadiusTopLeft") && jSONObject.has("borderRadiusBottomLeft") && jSONObject.has("borderRadiusTopRight") && jSONObject.has("borderRadiusBottomRight");
    }

    private JSONObject zR() {
        return sP(this.dNu);
    }

    public void Dq() {
        com.bytedance.sdk.openadsdk.core.Dq.sef sefVar = this.sU;
        if (sefVar != null) {
            sefVar.sP();
        }
    }

    public void Dq(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.Sj CBE;
        if (jSONObject == null) {
            return;
        }
        int optInt = jSONObject.optInt("index");
        com.bytedance.sdk.openadsdk.core.model.sU sUVar = this.dNu;
        if (!(sUVar instanceof com.bytedance.sdk.openadsdk.core.model.dx) || (CBE = ((com.bytedance.sdk.openadsdk.core.model.dx) sUVar).CBE()) == null) {
            return;
        }
        List<com.bytedance.sdk.openadsdk.core.model.sU> EjP = CBE.EjP();
        if (optInt < 0 || optInt >= EjP.size()) {
            return;
        }
        Sj(EjP.get(optInt), this.Fm, false);
        com.bytedance.sdk.openadsdk.core.aa.EjP.sP sPVar = this.UHs;
        if (sPVar != null) {
            sPVar.EjP();
        }
    }

    public Yf EjP(String str) {
        this.f21116aa = str;
        return this;
    }

    public com.bytedance.sdk.openadsdk.core.model.sU EjP() {
        return this.dNu;
    }

    public void EjP(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        int optInt = jSONObject.optInt("zoom_type", 1);
        JSONObject optJSONObject = jSONObject.optJSONObject("videoInfo");
        com.bytedance.sdk.component.adexpress.sP.sef sefVar = new com.bytedance.sdk.component.adexpress.sP.sef();
        if (optJSONObject != null) {
            double optDouble = optJSONObject.optDouble("x");
            double optDouble2 = optJSONObject.optDouble("y");
            double optDouble3 = optJSONObject.optDouble("width");
            double optDouble4 = optJSONObject.optDouble("height");
            sefVar.TKC(optDouble);
            sefVar.EjP(optDouble2);
            sefVar.HiB(optDouble3);
            sefVar.vS(optDouble4);
        }
        com.bytedance.sdk.openadsdk.core.Dq.sef sefVar2 = this.sU;
        if (sefVar2 != null) {
            sefVar2.Sj(optInt, sefVar);
        }
    }

    public void EjP(boolean z10) {
        this.f21117db = z10;
    }

    public void Fmk() {
        Sj sj2 = this.dwU;
        if (sj2 != null) {
            sj2.Sj();
        }
    }

    public Yf HiB(String str) {
        this.sef = str;
        return this;
    }

    public void HiB(JSONObject jSONObject) {
        String str;
        double d11;
        double d12;
        double d13;
        double d14;
        double d15;
        double d16;
        double d17;
        double d18;
        double d19;
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.component.utils.sU.Sj("TTAD.AndroidObject", "trigger Class1 method1");
        try {
            String optString = jSONObject.optString("adId");
            int optInt = jSONObject.optInt("areaType", 1);
            String optString2 = jSONObject.optString("clickAreaType");
            JSONObject optJSONObject = jSONObject.optJSONObject("clickInfo");
            double d20 = 0.0d;
            if (optJSONObject != null) {
                double optDouble = optJSONObject.optDouble("down_x", 0.0d);
                d13 = optJSONObject.optDouble("down_y", 0.0d);
                double optDouble2 = optJSONObject.optDouble("up_x", 0.0d);
                double optDouble3 = optJSONObject.optDouble("up_y", 0.0d);
                double optDouble4 = optJSONObject.optDouble("down_time", 0.0d);
                double optDouble5 = optJSONObject.optDouble("up_time", 0.0d);
                double optDouble6 = optJSONObject.optDouble("button_x", 0.0d);
                double optDouble7 = optJSONObject.optDouble("button_y", 0.0d);
                double optDouble8 = optJSONObject.optDouble("button_width", 0.0d);
                double optDouble9 = optJSONObject.optDouble("button_height", 0.0d);
                jSONObject2 = optJSONObject.optJSONObject("rectInfo");
                d19 = optDouble9;
                d20 = optDouble;
                d12 = optDouble2;
                d14 = optDouble4;
                d15 = optDouble5;
                d16 = optDouble6;
                d17 = optDouble7;
                d18 = optDouble8;
                str = optString;
                d11 = optDouble3;
            } else {
                str = optString;
                d11 = 0.0d;
                d12 = 0.0d;
                d13 = 0.0d;
                d14 = 0.0d;
                d15 = 0.0d;
                d16 = 0.0d;
                d17 = 0.0d;
                d18 = 0.0d;
                d19 = 0.0d;
                jSONObject2 = null;
            }
            com.bytedance.sdk.openadsdk.core.model.sef Sj2 = new sef.Sj().EjP((float) d20).TKC((float) d13).sP((float) d12).Sj((float) d11).sP((long) d14).Sj((long) d15).TKC((int) d16).EjP((int) d17).HiB((int) d18).vS((int) d19).Sj(optString2).Sj((SparseArray<TKC.Sj>) null).Sj(true).sP(optInt).Sj(jSONObject2).Sj(jSONObject.optInt("clickAreaCategory", -1)).sP(optJSONObject).Sj();
            com.bytedance.sdk.component.adexpress.sP.Ym ym2 = this.RiZ;
            if (ym2 != null) {
                ym2.Sj(null, optInt, Sj2);
            }
            Sj(str, optInt, Sj2);
        } catch (Exception unused) {
            com.bytedance.sdk.component.adexpress.sP.Ym ym3 = this.RiZ;
            if (ym3 != null) {
                ym3.Sj(null, -1, null);
            }
        }
    }

    public void HiB(boolean z10) {
        this.ndK = z10;
    }

    public boolean HiB() {
        com.bytedance.sdk.openadsdk.core.model.sU sUVar = this.dNu;
        return sUVar != null && sUVar.Yf();
    }

    public JSONObject Jcg(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            com.bytedance.sdk.openadsdk.core.model.sU sUVar = this.dNu;
            if (sUVar instanceof com.bytedance.sdk.openadsdk.core.model.dx) {
                List<com.bytedance.sdk.openadsdk.core.model.sU> EjP = ((com.bytedance.sdk.openadsdk.core.model.dx) sUVar).CBE().EjP();
                for (int i11 = 0; i11 < EjP.size(); i11++) {
                    jSONArray.put(TKC(EjP.get(i11)));
                }
            }
            jSONObject2.put("creatives", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    public void Jcg() {
        com.bytedance.sdk.openadsdk.aa.TKC tkc;
        if (this.ndK && (tkc = this.LqL) != null) {
            tkc.Sj();
            return;
        }
        Context context = this.qRN;
        if ((context instanceof Activity) && com.bytedance.sdk.openadsdk.utils.dx.Sj((Activity) context)) {
            ((Activity) this.qRN).finish();
        }
    }

    public com.bytedance.sdk.openadsdk.aa.sP Sj() {
        return this.xD;
    }

    public Yf Sj(int i11) {
        this.Zq = i11;
        return this;
    }

    public Yf Sj(View view) {
        this.Ym = new WeakReference<>(view);
        return this;
    }

    public Yf Sj(com.bytedance.sdk.component.adexpress.sP.Ym ym2) {
        this.RiZ = ym2;
        return this;
    }

    public Yf Sj(com.bytedance.sdk.component.uA.vS vSVar) {
        WebView webView;
        if (vSVar == null || (webView = vSVar.getWebView()) == null) {
            return this;
        }
        try {
            com.bytedance.sdk.component.Sj.dNu sP2 = com.bytedance.sdk.component.Sj.dNu.Sj(webView).Sj(new com.bytedance.sdk.openadsdk.Ym.Sj()).Sj("ToutiaoJSBridge").Sj(new com.bytedance.sdk.component.Sj.aa() { // from class: com.bytedance.sdk.openadsdk.core.Yf.1
                @Override // com.bytedance.sdk.component.Sj.aa
                @NonNull
                public <T> T Sj(@NonNull String str, @NonNull Type type) {
                    return null;
                }

                @Override // com.bytedance.sdk.component.Sj.aa
                @NonNull
                public <T> String Sj(@NonNull T t11) {
                    return null;
                }
            }).Sj(uA.sP().RiZ()).sP(true).Sj().sP();
            this.Wjd = sP2;
            com.bytedance.sdk.openadsdk.Ym.Sj.Jcg.Sj(sP2, this);
            com.bytedance.sdk.openadsdk.Ym.Sj.Sj.Sj(this.Wjd, this);
            com.bytedance.sdk.openadsdk.Ym.Sj.sP.Sj(this.Wjd, this);
            com.bytedance.sdk.openadsdk.Ym.Sj.TKC.Sj(this.Wjd, this);
            com.bytedance.sdk.openadsdk.Ym.Sj.vS.Sj(this.Wjd, this);
            com.bytedance.sdk.openadsdk.Ym.Sj.uA.Sj(this.Wjd, this);
            com.bytedance.sdk.openadsdk.Ym.Sj.aa.Sj(this.Wjd, this);
            com.bytedance.sdk.openadsdk.Ym.Sj.TEQ.Sj(this.Wjd, vSVar);
            com.bytedance.sdk.openadsdk.Ym.Sj.Dq.Sj(this.Wjd, this);
            com.bytedance.sdk.openadsdk.Ym.Sj.HiB.Sj(this.Wjd, this.f21118dx);
            com.bytedance.sdk.openadsdk.Ym.Sj.EjP.Sj(this.Wjd, this);
            com.bytedance.sdk.openadsdk.Ym.Sj.Fmk.Sj(this.Wjd, vSVar, this, this.dNu);
            com.bytedance.sdk.openadsdk.Ym.Sj.Ym.Sj(this.Wjd, this, this.dNu);
        } catch (Exception unused) {
        }
        return this;
    }

    public Yf Sj(com.bytedance.sdk.openadsdk.EjP.EjP.HiB hiB) {
        this.FPG = hiB;
        return this;
    }

    public Yf Sj(com.bytedance.sdk.openadsdk.aa.Dq dq2) {
        this.HpB = dq2;
        return this;
    }

    public Yf Sj(com.bytedance.sdk.openadsdk.aa.HiB hiB) {
        this.uP = hiB;
        return this;
    }

    public Yf Sj(com.bytedance.sdk.openadsdk.aa.Jcg jcg) {
        this.xhi = jcg;
        return this;
    }

    public Yf Sj(com.bytedance.sdk.openadsdk.aa.Sj sj2) {
        this.f21119ib = sj2;
        return this;
    }

    public Yf Sj(com.bytedance.sdk.openadsdk.aa.TKC tkc) {
        this.LqL = tkc;
        return this;
    }

    public Yf Sj(com.bytedance.sdk.openadsdk.aa.Ym ym2) {
        this.Yf = ym2;
        return this;
    }

    public Yf Sj(com.bytedance.sdk.openadsdk.aa.vS vSVar) {
        this.kF = vSVar;
        return this;
    }

    public Yf Sj(com.bytedance.sdk.openadsdk.core.Dq.sef sefVar) {
        this.sU = sefVar;
        return this;
    }

    public Yf Sj(com.bytedance.sdk.openadsdk.core.model.sU sUVar) {
        this.dNu = sUVar;
        if (sUVar != null) {
            this.TzV = sUVar.nP();
        }
        return this;
    }

    public Yf Sj(com.bytedance.sdk.openadsdk.core.sP.EjP ejP) {
        this.ley = ejP;
        return this;
    }

    public Yf Sj(com.bytedance.sdk.openadsdk.core.widget.HiB hiB) {
        this.Jcg = hiB;
        return this;
    }

    public Yf Sj(com.bytedance.sdk.openadsdk.core.widget.Sj.Sj sj2) {
        this.Ei = sj2;
        return this;
    }

    public Yf Sj(List<com.bytedance.sdk.openadsdk.core.model.sU> list) {
        this.fF = list;
        return this;
    }

    public Yf Sj(Map<String, Object> map) {
        this.Sj = map;
        return this;
    }

    public Yf Sj(JSONObject jSONObject) {
        this.f21118dx = jSONObject;
        return this;
    }

    public Yf Sj(boolean z10) {
        this.sP = z10;
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0344, code lost:
    
        if (r3 != null) goto L207;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0346, code lost:
    
        r7 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0391, code lost:
    
        if (r3 != null) goto L207;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject Sj(com.bytedance.sdk.openadsdk.core.Yf.sP r22, int r23) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.Yf.Sj(com.bytedance.sdk.openadsdk.core.Yf$sP, int):org.json.JSONObject");
    }

    @Override // com.bytedance.sdk.component.utils.LqL.Sj
    public void Sj(Message message) {
        if (message != null && message.what == 11) {
            Object obj = message.obj;
            if (obj instanceof sP) {
                try {
                    Sj((sP) obj, 1);
                } catch (Exception unused) {
                }
            }
        }
    }

    public void Sj(com.bytedance.sdk.openadsdk.aa.sP sPVar) {
        this.xD = sPVar;
    }

    public void Sj(Sj sj2) {
        this.dwU = sj2;
    }

    public void Sj(com.bytedance.sdk.openadsdk.core.aa.EjP.sP sPVar) {
        this.UHs = sPVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.HiB.sP
    public void Sj(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt(EventConstants.KEY_TIME);
            String optString = jSONObject.optString("flag");
            com.bytedance.sdk.openadsdk.core.Dq.sef sefVar = this.sU;
            if (sefVar != null) {
                sefVar.Sj(optInt, optString);
            }
        } catch (JSONException unused) {
            com.bytedance.sdk.component.utils.sU.sP("TTAD.AndroidObject", "requestPauseVideo json exception");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TEQ.sP
    public void Sj(String str, JSONObject jSONObject) {
        TKC(str, jSONObject);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0043 A[Catch: Exception -> 0x003a, TryCatch #0 {Exception -> 0x003a, blocks: (B:5:0x0003, B:7:0x000c, B:10:0x0015, B:12:0x0031, B:15:0x003f, B:17:0x0043, B:19:0x004a, B:20:0x004e, B:22:0x0054, B:24:0x0062, B:26:0x003c, B:27:0x0071), top: B:4:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004a A[Catch: Exception -> 0x003a, TryCatch #0 {Exception -> 0x003a, blocks: (B:5:0x0003, B:7:0x000c, B:10:0x0015, B:12:0x0031, B:15:0x003f, B:17:0x0043, B:19:0x004a, B:20:0x004e, B:22:0x0054, B:24:0x0062, B:26:0x003c, B:27:0x0071), top: B:4:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Sj(org.json.JSONObject r8, final com.bytedance.sdk.openadsdk.aa.EjP r9) {
        /*
            r7 = this;
            if (r9 != 0) goto L3
            return
        L3:
            com.bytedance.sdk.openadsdk.core.Yf$7 r0 = new com.bytedance.sdk.openadsdk.core.Yf$7     // Catch: java.lang.Exception -> L3a
            r0.<init>()     // Catch: java.lang.Exception -> L3a
            com.bytedance.sdk.openadsdk.core.model.sU r9 = r7.dNu     // Catch: java.lang.Exception -> L3a
            if (r9 == 0) goto L71
            java.lang.String r9 = r7.f21116aa     // Catch: java.lang.Exception -> L3a
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Exception -> L3a
            if (r9 == 0) goto L15
            goto L71
        L15:
            com.bytedance.sdk.openadsdk.core.model.sU r9 = r7.dNu     // Catch: java.lang.Exception -> L3a
            int r9 = r9.DKa()     // Catch: java.lang.Exception -> L3a
            com.bytedance.sdk.openadsdk.core.model.sU r1 = r7.dNu     // Catch: java.lang.Exception -> L3a
            com.bytedance.sdk.openadsdk.AdSlot r1 = r1.xD()     // Catch: java.lang.Exception -> L3a
            com.bytedance.sdk.openadsdk.core.model.ib r2 = new com.bytedance.sdk.openadsdk.core.model.ib     // Catch: java.lang.Exception -> L3a
            r2.<init>()     // Catch: java.lang.Exception -> L3a
            r3 = 1
            r2.vS = r3     // Catch: java.lang.Exception -> L3a
            com.bytedance.sdk.openadsdk.core.model.sU r3 = r7.dNu     // Catch: java.lang.Exception -> L3a
            com.bytedance.sdk.openadsdk.core.model.sU$Sj r3 = r3.xhi()     // Catch: java.lang.Exception -> L3a
            if (r3 != 0) goto L3c
            com.bytedance.sdk.openadsdk.core.model.sU r3 = r7.dNu     // Catch: java.lang.Exception -> L3a
            com.bytedance.sdk.openadsdk.core.model.LqL r3 = r3.ndK()     // Catch: java.lang.Exception -> L3a
            if (r3 == 0) goto L3f
            goto L3c
        L3a:
            r8 = move-exception
            goto L77
        L3c:
            r3 = 2
            r2.Dq = r3     // Catch: java.lang.Exception -> L3a
        L3f:
            org.json.JSONObject r3 = r7.TzV     // Catch: java.lang.Exception -> L3a
            if (r3 != 0) goto L48
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Exception -> L3a
            r3.<init>()     // Catch: java.lang.Exception -> L3a
        L48:
            if (r8 == 0) goto L62
            java.util.Iterator r4 = r8.keys()     // Catch: java.lang.Exception -> L3a
        L4e:
            boolean r5 = r4.hasNext()     // Catch: java.lang.Exception -> L3a
            if (r5 == 0) goto L62
            java.lang.Object r5 = r4.next()     // Catch: java.lang.Exception -> L3a
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> L3a
            java.lang.Object r6 = r8.opt(r5)     // Catch: java.lang.Exception -> L3a
            r3.put(r5, r6)     // Catch: java.lang.Exception -> L3a
            goto L4e
        L62:
            r2.Jcg = r3     // Catch: java.lang.Exception -> L3a
            com.bytedance.sdk.openadsdk.core.RiZ r8 = com.bytedance.sdk.openadsdk.core.dNu.TKC()     // Catch: java.lang.Exception -> L3a
            com.bytedance.sdk.openadsdk.core.Yf$8 r3 = new com.bytedance.sdk.openadsdk.core.Yf$8     // Catch: java.lang.Exception -> L3a
            r3.<init>()     // Catch: java.lang.Exception -> L3a
            r8.Sj(r1, r2, r9, r3)     // Catch: java.lang.Exception -> L3a
            return
        L71:
            r8 = 0
            r9 = 0
            r0.Sj(r8, r9)     // Catch: java.lang.Exception -> L3a
            return
        L77:
            java.lang.String r9 = "TTAD.AndroidObject"
            java.lang.String r0 = "get ads error"
            com.bytedance.sdk.component.utils.sU.Sj(r9, r0, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.Yf.Sj(org.json.JSONObject, com.bytedance.sdk.openadsdk.aa.EjP):void");
    }

    public void Sj(JSONObject jSONObject, String str) {
        com.bytedance.sdk.openadsdk.core.Dq.sef sefVar = this.sU;
        if (sefVar != null) {
            sefVar.Sj(str, jSONObject);
            return;
        }
        com.bytedance.sdk.openadsdk.core.aa.EjP.sP sPVar = this.UHs;
        if (sPVar != null) {
            sPVar.Sj(str, jSONObject);
        }
    }

    public boolean Sj(Uri uri) {
        if (uri == null) {
            return false;
        }
        if ("bytedance".equals(uri.getScheme())) {
            return Dq.containsKey(uri.getHost());
        }
        return false;
    }

    boolean TEQ() {
        com.bytedance.sdk.openadsdk.core.model.sU sUVar = this.dNu;
        return sUVar != null && sUVar.qRN() == 1;
    }

    public Yf TKC(String str) {
        this.TEQ = str;
        return this;
    }

    public void TKC() {
        com.bytedance.sdk.component.Sj.dNu dnu = this.Wjd;
        if (dnu == null) {
            return;
        }
        dnu.Sj();
        this.Wjd = null;
    }

    public void TKC(int i11) {
        com.bytedance.sdk.openadsdk.core.Dq.sef sefVar = this.sU;
        if (sefVar != null) {
            sefVar.sP(i11);
        }
    }

    public void TKC(JSONObject jSONObject) {
        TzV.Sj(dNu(), this.qRN instanceof Activity, jSONObject, this.dNu, this.Fm, this.Fmk, sef(), this.Jcg);
    }

    public void TKC(boolean z10) {
        this.TKC = z10;
    }

    public void Ym() {
        ib();
    }

    public void aa() {
        com.bytedance.sdk.openadsdk.TEQ.TKC tkc = this.uA;
        if (tkc != null) {
            tkc.Sj();
        }
        TKC tkc2 = this.sdp;
        if (tkc2 != null) {
            com.bytedance.sdk.openadsdk.utils.JcM.sP(tkc2);
            this.sdp = null;
        }
        this.qRN = null;
        this.UHs = null;
    }

    @Override // com.bytedance.sdk.component.adexpress.HiB.sP
    @JavascriptInterface
    public String adInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            uA(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.adexpress.HiB.sP
    @JavascriptInterface
    public String appInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            sP(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.adexpress.HiB.sP
    @JavascriptInterface
    public void changeVideoState(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            com.bytedance.sdk.openadsdk.utils.JcM.Sj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Yf.2
                @Override // java.lang.Runnable
                public void run() {
                    Yf.this.Fmk(jSONObject);
                }
            });
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.HiB.sP
    @JavascriptInterface
    public void chooseAdResult(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("video_choose");
            long optLong = jSONObject.optLong("video_choose_duration");
            com.bytedance.sdk.openadsdk.aa.Dq dq2 = this.HpB;
            if (dq2 != null) {
                dq2.Sj(optInt, optLong);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.HiB.sP
    @JavascriptInterface
    public void clickEvent(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            com.bytedance.sdk.openadsdk.utils.JcM.Sj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Yf.3
                @Override // java.lang.Runnable
                public void run() {
                    Yf.this.HiB(jSONObject);
                }
            });
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.HiB.sP
    @JavascriptInterface
    public void dynamicTrack(String str) {
        try {
            dNu(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.HiB.sP
    @JavascriptInterface
    public String getCurrentVideoState() {
        JSONObject jSONObject = new JSONObject();
        sef(jSONObject);
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.adexpress.HiB.sP
    @JavascriptInterface
    public String getData(String str) {
        if (TextUtils.isEmpty(str)) {
            return this.f21118dx.toString();
        }
        try {
            JSONObject Sj2 = com.bytedance.sdk.openadsdk.core.Dq.Sj.sP.Sj(this.f21118dx, new JSONObject(str));
            return Sj2 == null ? this.f21118dx.toString() : Sj2.toString();
        } catch (Exception unused) {
            return this.f21118dx.toString();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.HiB.sP
    @JavascriptInterface
    public String getTemplateInfo() {
        Sj("getTemplateInfo", true);
        try {
            JSONObject jSONObject = this.f21118dx;
            if (jSONObject != null) {
                jSONObject.put("setting", zR());
                com.bytedance.sdk.openadsdk.core.model.sU sUVar = this.dNu;
                if (sUVar != null) {
                    this.f21118dx.put("extension", sUVar.Grp());
                }
            }
            Sj("getTemplateInfo", false);
            return this.f21118dx.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.HiB.sP
    @JavascriptInterface
    public void initRenderFinish() {
        com.bytedance.sdk.openadsdk.utils.JcM.Sj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Yf.5
            @Override // java.lang.Runnable
            public void run() {
                if (Yf.this.Ei != null) {
                    Yf.this.Ei.Sj();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.HiB.sP
    @JavascriptInterface
    public void muteVideo(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            TKC tkc = this.sdp;
            if (tkc != null) {
                com.bytedance.sdk.openadsdk.utils.JcM.sP(tkc);
            }
            TKC tkc2 = new TKC(this.sU, jSONObject);
            this.sdp = tkc2;
            com.bytedance.sdk.openadsdk.utils.JcM.Sj(tkc2);
        } catch (Exception unused) {
            com.bytedance.sdk.component.utils.sU.sP("TTAD.AndroidObject", "");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.HiB.sP
    @JavascriptInterface
    public void renderDidFinish(String str) {
        try {
            Zq(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    public com.bytedance.sdk.component.Sj.dNu sP() {
        return this.Wjd;
    }

    public Yf sP(int i11) {
        this.Fmk = i11;
        return this;
    }

    public Yf sP(com.bytedance.sdk.component.uA.vS vSVar) {
        this.EjP = new WeakReference<>(vSVar);
        return this;
    }

    public Yf sP(String str) {
        this.vS = str;
        return this;
    }

    public Yf sP(boolean z10) {
        this.Mts = z10;
        return this;
    }

    public void sP(@NonNull final Uri uri) {
        try {
            String host = uri.getHost();
            if (!"log_event".equals(host) && !"custom_event".equals(host) && !"log_event_v3".equals(host)) {
                if ("private".equals(host) || "dispatch_message".equals(host)) {
                    uA(uri.toString());
                    return;
                }
                return;
            }
            com.bytedance.sdk.openadsdk.EjP.TKC.Sj(new com.bytedance.sdk.component.Dq.Dq("log_event_handleUri") { // from class: com.bytedance.sdk.openadsdk.core.Yf.9
                @Override // java.lang.Runnable
                public void run() {
                    long j11;
                    String str;
                    JSONObject jSONObject;
                    String queryParameter = uri.getQueryParameter("category");
                    String queryParameter2 = uri.getQueryParameter("tag");
                    Yf.this.Fm = queryParameter2;
                    String queryParameter3 = uri.getQueryParameter("label");
                    if (Yf.this.Dq(queryParameter3)) {
                        long j12 = 0;
                        try {
                            j11 = Long.parseLong(uri.getQueryParameter(AppMeasurementSdk.ConditionalUserProperty.VALUE));
                        } catch (Exception unused) {
                            j11 = 0;
                        }
                        try {
                            j12 = Long.parseLong(uri.getQueryParameter("ext_value"));
                        } catch (Exception unused2) {
                        }
                        long j13 = j12;
                        JSONObject jSONObject2 = null;
                        try {
                            String queryParameter4 = uri.getQueryParameter("extra");
                            if (!TextUtils.isEmpty(queryParameter4)) {
                                JSONObject jSONObject3 = new JSONObject(queryParameter4);
                                try {
                                    jSONObject3.putOpt("ua_policy", Integer.valueOf(Yf.this.Zq));
                                } catch (Throwable unused3) {
                                }
                                jSONObject2 = jSONObject3;
                            }
                        } catch (Throwable unused4) {
                        }
                        if ("click".equals(queryParameter3)) {
                            jSONObject2 = Yf.this.dx(jSONObject2);
                        }
                        if ("landing_perf_error".equals(queryParameter3) || "landing_perf_stats".equals(queryParameter3)) {
                            try {
                                JSONObject jSONObject4 = new JSONObject();
                                for (String str2 : uri.getQueryParameterNames()) {
                                    try {
                                        if ("extra".equals(str2)) {
                                            jSONObject4.put("ad_extra_data", new JSONObject(uri.getQueryParameter(str2)).optString("ad_extra_data"));
                                        } else {
                                            jSONObject4.put(str2, uri.getQueryParameter(str2));
                                        }
                                    } catch (Exception unused5) {
                                    }
                                }
                                str = Yf.this.vS;
                                jSONObject = jSONObject4;
                            } catch (Exception unused6) {
                                return;
                            }
                        } else {
                            str = Yf.this.Sj(queryParameter2, queryParameter3);
                            jSONObject = jSONObject2;
                        }
                        com.bytedance.sdk.openadsdk.EjP.TKC.Sj(Yf.this.dNu, queryParameter, str, queryParameter3, j11, j13, jSONObject, com.bytedance.sdk.openadsdk.core.model.TzV.HiB(Yf.this.dNu));
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.HiB.sP
    @JavascriptInterface
    public void skipVideo() {
        com.bytedance.sdk.openadsdk.utils.JcM.Sj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Yf.4
            @Override // java.lang.Runnable
            public void run() {
                Yf.this.sU();
            }
        });
    }

    public boolean uA() {
        return this.f21120jb;
    }

    public void vS(String str) {
        this.Fm = str;
    }

    public void vS(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.sU Sj2 = com.bytedance.sdk.openadsdk.core.sP.Sj(jSONObject);
        if (Sj2 != null) {
            boolean HiB = com.bytedance.sdk.openadsdk.core.model.TzV.HiB(this.dNu);
            Sj(Sj2, HiB ? Mts.sP(this.Fmk) : this.Fm, !HiB);
        }
    }

    public boolean vS() {
        return this.TKC;
    }

    @Override // com.bytedance.sdk.component.adexpress.HiB.sP
    @JavascriptInterface
    public void videoFrameChanged(String str) {
        if (this.xhi == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.bytedance.sdk.component.adexpress.sP.sef sefVar = new com.bytedance.sdk.component.adexpress.sP.sef();
            JSONObject optJSONObject = jSONObject.optJSONObject("videoInfo");
            if (optJSONObject != null) {
                double optDouble = optJSONObject.optDouble("x");
                double optDouble2 = optJSONObject.optDouble("y");
                double optDouble3 = optJSONObject.optDouble("width");
                double optDouble4 = optJSONObject.optDouble("height");
                if (uvD(optJSONObject)) {
                    sefVar.Sj((float) optJSONObject.optDouble("borderRadiusTopLeft"));
                    sefVar.sP((float) optJSONObject.optDouble("borderRadiusTopRight"));
                    sefVar.TKC((float) optJSONObject.optDouble("borderRadiusBottomLeft"));
                    sefVar.EjP((float) optJSONObject.optDouble("borderRadiusBottomRight"));
                }
                sefVar.TKC(optDouble);
                sefVar.EjP(optDouble2);
                sefVar.HiB(optDouble3);
                sefVar.vS(optDouble4);
            }
            com.bytedance.sdk.openadsdk.aa.Jcg jcg = this.xhi;
            if (jcg != null) {
                jcg.Sj(sefVar);
            }
        } catch (Throwable unused) {
        }
    }
}

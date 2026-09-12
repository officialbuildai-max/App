package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.embedapplog.PangleEncryptManager;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.RiZ;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.FPG;
import com.bytedance.sdk.openadsdk.utils.Mts;
import com.bytedance.sdk.openadsdk.utils.WMZ;
import com.cloud.tmc.ad.Constants;
import com.cloud.tmc.integration.net.UrlKt;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.miniapp.bridge.PermissionScopeBridge;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.pgl.ssdk.ces.out.DungeonFlag;
import com.transsion.api.gateway.utils.SafeStringUtils;
import com.transsion.baselib.db.download.DownloadException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import w5.c;

/* loaded from: classes3.dex */
public class sU implements RiZ<com.bytedance.sdk.openadsdk.EjP.Sj> {
    private final Context Sj;

    /* loaded from: classes3.dex */
    public static class Sj {

        @Nullable
        public final com.bytedance.sdk.openadsdk.core.model.Sj Dq;
        final int EjP;
        final String HiB;
        final String Jcg;
        final int Sj;
        final ArrayList<Integer> TEQ;
        final long TKC;
        final long sP;
        final String uA;
        final int vS;

        private Sj(String str, int i11, int i12, String str2, int i13, String str3, @Nullable com.bytedance.sdk.openadsdk.core.model.Sj sj2, long j11, long j12, ArrayList<Integer> arrayList) {
            this.Sj = i11;
            this.EjP = i12;
            this.HiB = str2;
            this.Jcg = str3;
            this.Dq = sj2;
            this.uA = str;
            this.vS = i13;
            this.sP = j11;
            this.TKC = j12;
            this.TEQ = arrayList;
        }

        public static Sj Sj(JSONObject jSONObject, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.ib ibVar, com.bytedance.sdk.openadsdk.core.model.TKC tkc) {
            Object obj;
            String optString = jSONObject.optString("did");
            int optInt = jSONObject.optInt("processing_time_ms");
            long optLong = jSONObject.optLong("s_receive_ts");
            long optLong2 = jSONObject.optLong("s_send_ts");
            int optInt2 = jSONObject.optInt("status_code");
            String optString2 = jSONObject.optString(CampaignEx.JSON_KEY_DESC);
            String optString3 = jSONObject.optString(TrackingKey.REQUEST_ID);
            int optInt3 = jSONObject.optInt("reason");
            Pair<com.bytedance.sdk.openadsdk.core.model.Sj, ArrayList<Integer>> Sj = com.bytedance.sdk.openadsdk.core.sP.Sj(jSONObject, adSlot, ibVar, tkc);
            if (Sj != null && (obj = Sj.first) != null) {
                ((com.bytedance.sdk.openadsdk.core.model.Sj) obj).Sj(jSONObject.optLong("request_after"));
            }
            return Sj == null ? new Sj(optString, optInt, optInt2, optString2, optInt3, optString3, null, optLong, optLong2, null) : new Sj(optString, optInt, optInt2, optString2, optInt3, optString3, (com.bytedance.sdk.openadsdk.core.model.Sj) Sj.first, optLong, optLong2, (ArrayList) Sj.second);
        }
    }

    /* loaded from: classes3.dex */
    public static class sP {
        public final int Sj;
        public final com.bytedance.sdk.openadsdk.core.model.Yf TKC;
        public final boolean sP;

        private sP(int i11, boolean z10, com.bytedance.sdk.openadsdk.core.model.Yf yf2) {
            this.Sj = i11;
            this.sP = z10;
            this.TKC = yf2;
        }

        public static sP Sj(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int optInt = jSONObject.optInt("code");
            boolean optBoolean = jSONObject.optBoolean("verify");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            com.bytedance.sdk.openadsdk.core.model.Yf yf2 = new com.bytedance.sdk.openadsdk.core.model.Yf();
            if (optJSONObject != null) {
                try {
                    yf2.Sj(optJSONObject.optInt("reason"));
                    yf2.sP(optJSONObject.optInt("corp_type"));
                    yf2.TKC(optJSONObject.optInt(CampaignEx.JSON_KEY_REWARD_AMOUNT));
                    yf2.Sj(optJSONObject.optString(CampaignEx.JSON_KEY_REWARD_NAME));
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.sU.sP("NetApiImpl", th2.getMessage());
                }
            }
            return new sP(optInt, optBoolean, yf2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public sU(Context context) {
        this.Sj = context;
    }

    @NonNull
    private Map<String, String> EjP(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        hashMap.put(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8");
        if (TKC(jSONObject)) {
            hashMap.put(HttpHeaders.CONTENT_ENCODING, "union_sdk_encode");
        }
        return hashMap;
    }

    private boolean EjP(String str) {
        if (com.bytedance.sdk.openadsdk.core.Jcg.sP.Sj()) {
            return true;
        }
        if (!com.bytedance.sdk.openadsdk.core.Jcg.sP.Sj(str)) {
            return false;
        }
        String sP2 = com.bytedance.sdk.openadsdk.core.Jcg.sP.sP();
        if (!TextUtils.isEmpty(sP2)) {
            com.bytedance.sdk.openadsdk.EjP.TKC.Sj(sP2, System.currentTimeMillis());
        }
        return true;
    }

    private boolean HiB(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            return jSONObject.optString("message").equalsIgnoreCase(NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS);
        } catch (Throwable unused) {
            return false;
        }
    }

    private byte[] HiB(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        byte[] bArr = new byte[0];
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    try {
                        gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    } catch (IOException e11) {
                        e = e11;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e12) {
                com.bytedance.sdk.component.utils.sU.sP("NetApiImpl", e12.toString());
            }
            try {
                gZIPOutputStream.write(str.getBytes("utf-8"));
                try {
                    gZIPOutputStream.close();
                } catch (IOException e13) {
                    com.bytedance.sdk.component.utils.sU.sP("NetApiImpl", e13.toString());
                }
                bArr = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (IOException e14) {
                e = e14;
                gZIPOutputStream2 = gZIPOutputStream;
                com.bytedance.sdk.component.utils.sU.sP("NetApiImpl", e.toString());
                if (gZIPOutputStream2 != null) {
                    try {
                        gZIPOutputStream2.close();
                    } catch (IOException e15) {
                        com.bytedance.sdk.component.utils.sU.sP("NetApiImpl", e15.toString());
                    }
                }
                if (byteArrayOutputStream != null) {
                    bArr = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                }
                return bArr;
            } catch (Throwable th3) {
                th = th3;
                gZIPOutputStream2 = gZIPOutputStream;
                if (gZIPOutputStream2 != null) {
                    try {
                        gZIPOutputStream2.close();
                    } catch (IOException e16) {
                        com.bytedance.sdk.component.utils.sU.sP("NetApiImpl", e16.toString());
                    }
                }
                if (byteArrayOutputStream == null) {
                    throw th;
                }
                byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                    throw th;
                } catch (IOException e17) {
                    com.bytedance.sdk.component.utils.sU.sP("NetApiImpl", e17.toString());
                    throw th;
                }
            }
        } catch (IOException e18) {
            e = e18;
            byteArrayOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
        }
        return bArr;
    }

    private JSONArray Sj(List<FilterWord> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<FilterWord> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().getId());
        }
        return jSONArray;
    }

    private static JSONObject Sj(PangleEncryptConstant.CryptDataScene cryptDataScene, JSONObject jSONObject) {
        if (!com.bytedance.sdk.openadsdk.core.settings.Fmk.gq().Sj(cryptDataScene)) {
            return com.bytedance.sdk.component.utils.Sj.Sj(jSONObject);
        }
        JSONObject encryptType4 = PangleEncryptManager.encryptType4(jSONObject, new dx(cryptDataScene));
        zR.Sj(encryptType4);
        return encryptType4;
    }

    public static JSONObject Sj(AdSlot adSlot) {
        ib ibVar;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("personalized_ad", dNu.EjP().jb());
            jSONObject.put("lmt", DeviceUtils.TKC());
            jSONObject.put("gdpr", uA.sP().TEQ());
            jSONObject.put("pa_consent", uA.sP().Ym());
            jSONObject.put("is_gdpr_user", dNu.EjP().Wjd());
            if (adSlot != null && ib.Sj.containsKey(Integer.valueOf(adSlot.getCodeId())) && (ibVar = ib.Sj.get(Integer.valueOf(adSlot.getCodeId()))) != null) {
                jSONObject.put("lastadomain", ibVar.sP());
                jSONObject.put("lastbundle", ibVar.TKC());
                jSONObject.put("lastclick", ibVar.EjP());
                jSONObject.put("lastskip", ibVar.HiB());
            }
            Sj(jSONObject, "keywords", uA.sP().sef());
            Sj(jSONObject, "data", sP(adSlot));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONObject Sj(AdSlot adSlot, int i11, com.bytedance.sdk.openadsdk.core.model.ib ibVar) {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", adSlot.getCodeId());
            jSONObject.put("adtype", i11);
            if (!TextUtils.isEmpty(adSlot.getAdId()) || !TextUtils.isEmpty(adSlot.getCreativeId()) || !TextUtils.isEmpty(adSlot.getExt())) {
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(adSlot.getAdId())) {
                    jSONObject2.put("ad_id", adSlot.getAdId());
                }
                if (!TextUtils.isEmpty(adSlot.getCreativeId())) {
                    jSONObject2.put(CampaignEx.JSON_KEY_CREATIVE_ID, adSlot.getCreativeId());
                }
                if (adSlot.getExt() != null) {
                    jSONObject2.put("ext", adSlot.getExt());
                }
                jSONObject.put("preview_ads", jSONObject2);
            }
            if (ibVar != null) {
                jSONObject.put("render_method", ibVar.Dq);
                int i12 = ibVar.Dq;
                if (i12 == 1) {
                    Sj(jSONObject, "accepted_size", adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
                } else if (i12 == 2) {
                    Sj(jSONObject, "accepted_size", adSlot.getExpressViewAcceptedWidth(), adSlot.getExpressViewAcceptedHeight());
                }
            } else {
                jSONObject.put("render_method", 1);
                Sj(jSONObject, "accepted_size", adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
            }
            jSONObject.put("ptpl_ids", sP(adSlot.getCodeId()));
            jSONObject.put("ugen_ptpl_ids", TKC(adSlot.getCodeId()));
            jSONObject.put("ptpl_ids_v3", TKC(adSlot.getCodeId() + "_v3"));
            jSONObject.put("pos", AdSlot.getPosition(i11));
            jSONObject.put("is_support_dpl", adSlot.isSupportDeepLink());
            if (adSlot.getNativeAdType() > 0 || i11 == 5) {
                jSONObject.put("is_origin_ad", true);
            }
            if (ibVar != null && (obj = ibVar.Jcg) != null) {
                jSONObject.put("session_params", obj);
            }
            int adCount = adSlot.getAdCount();
            if (adCount <= 0) {
                adCount = 1;
            }
            if (adCount > 3) {
                adCount = 3;
            }
            if (i11 == 7 || i11 == 8) {
                adCount = 1;
            }
            if (ibVar != null && ibVar.HiB != null) {
                adCount = adSlot.getAdCount();
            }
            jSONObject.put(TrackingKey.AD_COUNT, adCount);
            if (i11 == 1) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("is_rotate_banner", adSlot.getIsRotateBanner());
                jSONObject3.put("rotate_time", adSlot.getRotateTime());
                jSONObject3.put("rotate_order", adSlot.getRotateOrder());
                jSONObject3.put(NativeComponentConstants.KEY_COMPONENT_TYPE, adSlot.getBannerType());
                jSONObject.put("banner", jSONObject3);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:1|(2:2|3)|(13:8|9|(1:(1:14))(2:35|(1:(1:40))(2:41|(1:46)))|15|16|(1:19)|21|(1:24)|25|(1:27)|28|(1:30)|32)|47|9|(0)(0)|15|16|(1:19)|21|(1:24)|25|(0)|28|(0)|32) */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x011a A[Catch: all -> 0x001f, TryCatch #1 {all -> 0x001f, blocks: (B:3:0x000c, B:5:0x0013, B:8:0x001c, B:12:0x002d, B:14:0x0031, B:21:0x0077, B:24:0x00fb, B:25:0x010b, B:27:0x011a, B:28:0x0127, B:30:0x0143, B:38:0x003b, B:40:0x003f, B:44:0x0048, B:46:0x004c, B:47:0x0022), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0143 A[Catch: all -> 0x001f, TRY_LEAVE, TryCatch #1 {all -> 0x001f, blocks: (B:3:0x000c, B:5:0x0013, B:8:0x001c, B:12:0x002d, B:14:0x0031, B:21:0x0077, B:24:0x00fb, B:25:0x010b, B:27:0x011a, B:28:0x0127, B:30:0x0143, B:38:0x003b, B:40:0x003f, B:44:0x0048, B:46:0x004c, B:47:0x0022), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0035  */
    @com.pgl.ssdk.ces.out.DungeonFlag
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.json.JSONObject Sj(com.bytedance.sdk.openadsdk.AdSlot r12, com.bytedance.sdk.openadsdk.core.model.ib r13, int r14) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.sU.Sj(com.bytedance.sdk.openadsdk.AdSlot, com.bytedance.sdk.openadsdk.core.model.ib, int):org.json.JSONObject");
    }

    private void Sj(com.bytedance.sdk.component.Jcg.sP.EjP ejP, JSONObject jSONObject) {
        try {
            if (TKC(jSONObject) && jSONObject.optInt("cypher") == 4) {
                ejP.sP("x-pgli18n", "4");
                ejP.sP(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8");
            }
        } catch (Exception unused) {
        }
    }

    private void Sj(com.bytedance.sdk.component.sP.Sj.TEQ teq, com.bytedance.sdk.openadsdk.core.model.ib ibVar, WMZ wmz, WMZ wmz2, int i11, WMZ wmz3, com.bytedance.sdk.openadsdk.core.model.sU sUVar, String str, boolean z10) {
        if (dNu.EjP().qRN()) {
            JSONObject jSONObject = new JSONObject();
            long j11 = 0;
            if (ibVar != null) {
                try {
                    WMZ wmz4 = ibVar.uA;
                    if (wmz4.Sj > 0) {
                        j11 = wmz3.Sj(wmz4);
                        long j12 = j11;
                        Sj(teq, ibVar, wmz, wmz2, i11, wmz3, sUVar, str, z10, jSONObject, false);
                        com.bytedance.sdk.openadsdk.EjP.TKC.Sj(sUVar, str, "load_ad_time", j12, jSONObject);
                    }
                } catch (Exception unused) {
                    return;
                }
            }
            long j122 = j11;
            Sj(teq, ibVar, wmz, wmz2, i11, wmz3, sUVar, str, z10, jSONObject, false);
            com.bytedance.sdk.openadsdk.EjP.TKC.Sj(sUVar, str, "load_ad_time", j122, jSONObject);
        }
    }

    private static void Sj(com.bytedance.sdk.component.sP.Sj.TEQ teq, com.bytedance.sdk.openadsdk.core.model.ib ibVar, WMZ wmz, WMZ wmz2, int i11, WMZ wmz3, com.bytedance.sdk.openadsdk.core.model.sU sUVar, String str, boolean z10, JSONObject jSONObject, boolean z11) throws JSONException {
        if (ibVar != null) {
            WMZ wmz4 = ibVar.uA;
            if (wmz4.Sj > 0) {
                jSONObject.put("client_start_time", wmz.Sj(wmz4));
            }
        }
        jSONObject.put("network_time", wmz2.Sj(wmz));
        jSONObject.put("sever_time", i11);
        jSONObject.put("client_end_time", wmz3.Sj(wmz2));
        if (z10) {
            jSONObject.put("is_choose_ad", true);
        }
        if (str.equals("open_ad")) {
            jSONObject.put("is_icon_only", sUVar.yfI() ? 1 : 0);
        }
        if (sUVar != null) {
            jSONObject.put("render_control_type", sUVar.ley());
        }
        jSONObject.put("webview_cache_size", com.bytedance.sdk.component.adexpress.HiB.HiB.Sj().TKC());
        jSONObject.put("sync_barrier_open", z11 ? 1 : 0);
        long j11 = teq.sP;
        if (j11 > 0) {
            jSONObject.put("enqueue_2_run_ts", teq.TKC - j11);
            jSONObject.put("run_2_connect_end_ts", teq.HiB - teq.sP);
            jSONObject.put("connect_end_2_response_end_ts", teq.vS - teq.HiB);
            jSONObject.put("response_end_2_callback_end_ts", SystemClock.elapsedRealtime() - teq.vS);
        }
    }

    private void Sj(RiZ.Sj sj2, com.bytedance.sdk.openadsdk.core.model.TKC tkc) {
        sj2.Sj(-1, Dq.Sj(-1));
        tkc.Sj(-1);
        com.bytedance.sdk.openadsdk.core.model.TKC.Sj(tkc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(RiZ.sP sPVar) {
        sPVar.Sj(-1, Dq.Sj(-1));
    }

    private void Sj(com.bytedance.sdk.openadsdk.core.model.Sj sj2) {
        List<com.bytedance.sdk.openadsdk.core.model.sU> EjP = sj2.EjP();
        if (EjP == null || EjP.size() == 0) {
            return;
        }
        for (int i11 = 0; i11 < EjP.size(); i11++) {
            com.bytedance.sdk.openadsdk.core.model.sU sUVar = EjP.get(i11);
            if (sUVar != null && sUVar.uvD() == null) {
                Sj("", 0, 0, sUVar.EZ(), sUVar);
                Sj("", 0, 0, sUVar.gY(), sUVar);
                List<com.bytedance.sdk.openadsdk.core.model.uvD> Bml = sUVar.Bml();
                if (Bml != null && Bml.size() > 0) {
                    for (int i12 = 0; i12 < Bml.size(); i12++) {
                        Sj(sUVar, Bml.get(i12));
                    }
                }
                if (sUVar.UHs() != null) {
                    Sj(sUVar.UHs().r(), sUVar.UHs().t(), sUVar.UHs().C(), (com.bytedance.sdk.openadsdk.core.model.uvD) null, sUVar);
                }
            }
        }
    }

    private void Sj(com.bytedance.sdk.openadsdk.core.model.sU sUVar, com.bytedance.sdk.openadsdk.core.model.uvD uvd) {
        if (uvd == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.uA.EjP.Sj(uvd).TKC(2).Sj(new com.bytedance.sdk.openadsdk.uA.sP(sUVar, uvd.Sj(), new com.bytedance.sdk.component.HiB.uvD() { // from class: com.bytedance.sdk.openadsdk.core.sU.14
            @Override // com.bytedance.sdk.component.HiB.uvD
            public void Sj(int i11, String str, @Nullable Throwable th2) {
            }

            @Override // com.bytedance.sdk.component.HiB.uvD
            public void Sj(com.bytedance.sdk.component.HiB.Ym ym2) {
            }
        }), 4);
    }

    private void Sj(String str, int i11, int i12, com.bytedance.sdk.openadsdk.core.model.uvD uvd, com.bytedance.sdk.openadsdk.core.model.sU sUVar) {
        if (!TextUtils.isEmpty(str)) {
            com.bytedance.sdk.openadsdk.uA.EjP.Sj(str).Sj(i11).sP(i12).HiB(FPG.HiB(dNu.Sj())).EjP(FPG.TKC(dNu.Sj())).TKC(2).Sj(new com.bytedance.sdk.openadsdk.uA.sP(sUVar, str, null), 4);
        } else {
            if (uvd == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.uA.EjP.Sj(uvd).TKC(2).Sj(new com.bytedance.sdk.openadsdk.uA.sP(sUVar, uvd.Sj(), null), 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014f A[Catch: all -> 0x0060, Exception -> 0x01aa, TryCatch #0 {all -> 0x0060, blocks: (B:9:0x0032, B:11:0x004a, B:13:0x0054, B:14:0x0065, B:16:0x006e, B:19:0x007a, B:21:0x0090, B:23:0x009d, B:25:0x00a4, B:26:0x00b5, B:28:0x00ae, B:29:0x00c1, B:31:0x00c5, B:33:0x00d1, B:36:0x00d8, B:38:0x00ec, B:40:0x00f0, B:41:0x00f5, B:47:0x0106, B:49:0x010e, B:51:0x011a, B:65:0x0140, B:67:0x0148, B:56:0x014f, B:58:0x015c, B:59:0x016d, B:60:0x0165, B:61:0x0170, B:68:0x01aa, B:70:0x01c5, B:71:0x01cc, B:73:0x01d4, B:76:0x01e2), top: B:8:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0140 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01c5 A[Catch: all -> 0x0060, TryCatch #0 {all -> 0x0060, blocks: (B:9:0x0032, B:11:0x004a, B:13:0x0054, B:14:0x0065, B:16:0x006e, B:19:0x007a, B:21:0x0090, B:23:0x009d, B:25:0x00a4, B:26:0x00b5, B:28:0x00ae, B:29:0x00c1, B:31:0x00c5, B:33:0x00d1, B:36:0x00d8, B:38:0x00ec, B:40:0x00f0, B:41:0x00f5, B:47:0x0106, B:49:0x010e, B:51:0x011a, B:65:0x0140, B:67:0x0148, B:56:0x014f, B:58:0x015c, B:59:0x016d, B:60:0x0165, B:61:0x0170, B:68:0x01aa, B:70:0x01c5, B:71:0x01cc, B:73:0x01d4, B:76:0x01e2), top: B:8:0x0032 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Sj(java.lang.String r24, com.bytedance.sdk.component.Jcg.sP r25, boolean r26, java.util.Map<java.lang.String, java.lang.Object> r27, com.bytedance.sdk.openadsdk.utils.WMZ r28, final com.bytedance.sdk.openadsdk.AdSlot r29, com.bytedance.sdk.openadsdk.core.model.TKC r30, com.bytedance.sdk.openadsdk.core.RiZ.Sj r31, com.bytedance.sdk.openadsdk.core.model.ib r32, int r33) {
        /*
            Method dump skipped, instructions count: 614
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.sU.Sj(java.lang.String, com.bytedance.sdk.component.Jcg.sP, boolean, java.util.Map, com.bytedance.sdk.openadsdk.utils.WMZ, com.bytedance.sdk.openadsdk.AdSlot, com.bytedance.sdk.openadsdk.core.model.TKC, com.bytedance.sdk.openadsdk.core.RiZ$Sj, com.bytedance.sdk.openadsdk.core.model.ib, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(String str, IOException iOException, com.bytedance.sdk.component.Jcg.sP sPVar, final AdSlot adSlot, boolean z10, Map<String, Object> map, RiZ.Sj sj2, com.bytedance.sdk.openadsdk.core.model.TKC tkc) {
        com.bytedance.sdk.openadsdk.dNu.TKC.TKC(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.core.sU.10
            @Override // com.bytedance.sdk.openadsdk.dNu.EjP
            public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                com.bytedance.sdk.openadsdk.dNu.sP.Sj sj3 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                sj3.sP("get_ad");
                sj3.TKC(adSlot.getCodeId());
                sj3.EjP(Mts.TKC(adSlot.getDurationSlotType()));
                sj3.Sj(BuildConfig.VERSION_NAME);
                return sj3;
            }
        });
        String sP2 = sPVar != null ? sPVar.sP() : iOException != null ? iOException.getMessage() : "";
        WMZ sP3 = WMZ.sP();
        if (z10) {
            map.put("pgad_end", Long.valueOf(sP3.Sj));
        }
        if (dNu.EjP().db() && ley.Sj().EjP() == 1) {
            Mts.Sj("Pangle_Debug_Mode", iOException != null ? iOException.getMessage() : null, this.Sj);
        }
        int Sj2 = sPVar != null ? sPVar.Sj() : (iOException == null || !(iOException instanceof SocketTimeoutException)) ? PermissionScopeBridge.ERROR_CODE_SCOPE_NAME_IS_EMPTY : PermissionScopeBridge.ERROR_CODE_SCOPE_NAME_NOT_FOUND;
        if (sj2 != null) {
            sj2.Sj(Sj2, sP2);
        }
        tkc.Sj(Sj2);
        com.bytedance.sdk.openadsdk.core.model.TKC.Sj(tkc);
        com.bytedance.sdk.openadsdk.EjP.Sj.vS.TKC.incrementAndGet();
        com.bytedance.sdk.openadsdk.EjP.Sj.vS.Sj.incrementAndGet();
        com.bytedance.sdk.openadsdk.EjP.Sj.vS.Jcg.incrementAndGet();
        com.bytedance.sdk.openadsdk.EjP.Sj.vS.HiB();
        com.bytedance.sdk.openadsdk.EjP.Sj.vS.Sj(Sj2, sP2);
        com.bytedance.sdk.openadsdk.EjP.Sj.vS.TKC();
    }

    private void Sj(Map<String, String> map, com.bytedance.sdk.component.Jcg.sP.EjP ejP) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                try {
                    ejP.sP(entry.getKey(), entry.getValue());
                } catch (Exception e11) {
                    com.bytedance.sdk.component.utils.sU.sP("NetApiImpl", "ADD header exceptopn", e11.getMessage());
                }
            }
        }
        try {
            ejP.sP("User-Agent", Mts.TKC());
        } catch (Exception e12) {
            com.bytedance.sdk.component.utils.sU.sP("NetApiImpl", "ADD header exceptopn", e12.getMessage());
        }
    }

    private void Sj(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.ib ibVar) {
        JSONArray jSONArray;
        if (ibVar != null && (jSONArray = ibVar.HiB) != null) {
            try {
                jSONObject.put("source_temai_product_ids", jSONArray);
            } catch (Exception unused) {
            }
        }
    }

    private void Sj(JSONObject jSONObject, String str, float f11, float f12) {
        if (f11 < 0.0f || f12 < 0.0f) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", (int) f11);
            jSONObject2.put("height", (int) f12);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    private void Sj(JSONObject jSONObject, String str, int i11, int i12) {
        if (i11 <= 0 || i12 <= 0) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", i11);
            jSONObject2.put("height", i12);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    private static void Sj(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    private void Sj(JSONObject jSONObject, boolean z10) {
        Object obj;
        if (uA.sP().sU()) {
            try {
                jSONObject.getJSONObject("header").put("aid", "4562");
            } catch (Exception e11) {
                com.bytedance.sdk.component.utils.sU.sP("NetApiImpl", "reportETEvent error", e11.getMessage());
            }
            com.bytedance.sdk.component.Jcg.sP.EjP sP2 = com.bytedance.sdk.openadsdk.TzV.sP.Sj().sP().sP();
            sP2.sP(Mts.uvD());
            byte[] bArr = null;
            if (z10) {
                com.bytedance.sdk.openadsdk.core.settings.vS gq2 = com.bytedance.sdk.openadsdk.core.settings.Fmk.gq();
                PangleEncryptConstant.CryptDataScene cryptDataScene = PangleEncryptConstant.CryptDataScene.APP_LOG;
                boolean Sj2 = gq2.Sj(cryptDataScene);
                byte[] HiB = HiB(jSONObject.toString());
                if (Sj2) {
                    Pair<Integer, byte[]> encryptType4WithoutBase64 = PangleEncryptManager.encryptType4WithoutBase64(HiB);
                    if (encryptType4WithoutBase64 == null || (obj = encryptType4WithoutBase64.second) == null || ((byte[]) obj).length <= 0) {
                        int intValue = encryptType4WithoutBase64 != null ? ((Integer) encryptType4WithoutBase64.first).intValue() : 0;
                        zR.sP(false);
                        zR.Sj(1, cryptDataScene, intValue);
                    } else {
                        bArr = (byte[]) obj;
                        zR.sP(true);
                    }
                }
                if (bArr != null) {
                    sP2.sP(HttpHeaders.CONTENT_ENCODING, "union_sdk_encode");
                    sP2.sP("x-pgli18n", "4");
                    sP2.Sj("application/octet-stream;tt-data=a", bArr);
                } else {
                    bArr = PangleEncryptManager.encryptV3(HiB);
                    if (bArr != null) {
                        Sj(sP(), sP2);
                        sP2.Sj("application/octet-stream;tt-data=a", bArr);
                    }
                }
            }
            if (bArr == null) {
                JSONObject Sj3 = com.bytedance.sdk.component.utils.Sj.Sj(jSONObject);
                if (TKC(Sj3)) {
                    jSONObject = Sj3;
                }
                Sj(EjP(jSONObject), sP2);
                sP2.Sj(jSONObject.toString(), dNu.EjP().uvD());
            }
            sP2.Sj(7);
            sP2.Sj("et_applog");
            sP2.Sj(new com.bytedance.sdk.component.Jcg.Sj.Sj() { // from class: com.bytedance.sdk.openadsdk.core.sU.15
                @Override // com.bytedance.sdk.component.Jcg.Sj.Sj
                public void Sj(com.bytedance.sdk.component.Jcg.sP.TKC tkc, com.bytedance.sdk.component.Jcg.sP sPVar) {
                    if (sPVar == null || !sPVar.vS()) {
                        return;
                    }
                    sPVar.EjP();
                }

                @Override // com.bytedance.sdk.component.Jcg.Sj.Sj
                public void Sj(com.bytedance.sdk.component.Jcg.sP.TKC tkc, IOException iOException) {
                    iOException.getMessage();
                }
            });
        }
    }

    private boolean Sj(com.bytedance.sdk.openadsdk.core.model.Sj sj2, RiZ.Sj sj3) {
        if (sj2 == null) {
            sj3.Sj(40053, Dq.Sj(40053));
            return true;
        }
        List<com.bytedance.sdk.openadsdk.core.model.sU> EjP = sj2.EjP();
        if (EjP.isEmpty()) {
            return false;
        }
        for (final com.bytedance.sdk.openadsdk.core.model.sU sUVar : EjP) {
            if (TextUtils.isEmpty(sUVar.fAj().sP()) || TextUtils.isEmpty(sUVar.fAj().TKC())) {
                sj3.Sj(40053, Dq.Sj(40053));
                com.bytedance.sdk.openadsdk.EjP.TKC.Sj(System.currentTimeMillis(), sUVar, Mts.Sj(sUVar), "material_error", new com.bytedance.sdk.openadsdk.Zq.TKC.Sj() { // from class: com.bytedance.sdk.openadsdk.core.sU.13
                    @Override // com.bytedance.sdk.openadsdk.Zq.TKC.Sj
                    public JSONObject Sj() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("ad_label", sUVar.fAj().vS());
                            jSONObject2.put("pag_json_data", jSONObject3.toString());
                            jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                        } catch (Exception e11) {
                            e11.getMessage();
                        }
                        return jSONObject;
                    }
                });
                return true;
            }
        }
        return false;
    }

    public static JSONArray TKC(String str) {
        try {
            Set<com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj> Sj2 = com.bytedance.sdk.openadsdk.core.TEQ.Sj.sP.Sj().Sj(str);
            if (Sj2 != null && Sj2.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                for (com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj sj2 : Sj2) {
                    if (sj2 != null && !TextUtils.isEmpty(sj2.HiB())) {
                        JSONObject jSONObject = new JSONObject();
                        String[] split = sj2.Sj().split("_");
                        if (split.length == 2) {
                            jSONObject.put("id", split[1]);
                            jSONObject.put("md5", sj2.sP());
                            jSONArray.put(jSONObject);
                        }
                    }
                }
                return jSONArray;
            }
            return null;
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.sU.Sj("NetApiImpl", "getUgenParentTplIds: ", e11);
            return null;
        }
    }

    @DungeonFlag
    private JSONObject TKC() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SafeStringUtils.SP_APPID, uA.sP().EjP());
            jSONObject.put("name", uA.sP().Dq());
            vS(jSONObject);
            Context Sj2 = dNu.Sj();
            String str = "";
            if (Sj2 != null) {
                try {
                    str = Sj2.getPackageResourcePath();
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.sU.sP("NetApiImpl", "failed to get the application installation package path. error: " + th2.getMessage());
                }
            }
            jSONObject.put("package_install_path", str);
            jSONObject.put("is_paid_app", uA.sP().Fmk());
            jSONObject.put("apk_sign", com.bytedance.sdk.openadsdk.common.sP.Jcg());
            jSONObject.put("app_running_time", (System.currentTimeMillis() - sef.Sj()) / 1000);
            jSONObject.put("fmwname", DeviceUtils.Ym(this.Sj));
            int i11 = 0;
            jSONObject.put("is_init", sef.HiB() ? 1 : 0);
            if (Sj2 != null) {
                int rotation = ((WindowManager) Sj2.getSystemService("window")).getDefaultDisplay().getRotation();
                if (rotation == 0) {
                    i11 = 1;
                } else if (rotation == 1) {
                    i11 = 3;
                } else if (rotation == 2) {
                    i11 = 2;
                } else if (rotation == 3) {
                    i11 = 4;
                }
                jSONObject.put("orientation_support", new JSONArray().put(i11));
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private boolean TKC(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String sP(int i11, String str) {
        Object obj;
        if (i11 == 3) {
            return com.bytedance.sdk.component.utils.Sj.TKC(str);
        }
        if (i11 == 4) {
            Pair<Integer, String> decryptType4 = PangleEncryptManager.decryptType4(str);
            if (decryptType4 != null && (obj = decryptType4.second) != null) {
                String str2 = (String) obj;
                zR.Sj(true);
                return str2;
            }
            zR.Sj(false);
            zR.Sj(2, PangleEncryptConstant.CryptDataScene.GET_ADS, decryptType4 != null ? ((Integer) decryptType4.first).intValue() : 0);
        }
        return null;
    }

    private static String sP(AdSlot adSlot) {
        String Zq = uA.sP().Zq();
        if (adSlot == null) {
            return TextUtils.isEmpty(Zq) ? "" : Zq;
        }
        String userData = adSlot.getUserData();
        if (TextUtils.isEmpty(Zq)) {
            return userData;
        }
        if (TextUtils.isEmpty(userData)) {
            return Zq;
        }
        HashSet hashSet = new HashSet();
        try {
            JSONArray jSONArray = new JSONArray(userData);
            int length = jSONArray.length();
            for (int i11 = 0; i11 < length; i11++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                if (jSONObject != null) {
                    hashSet.add(jSONObject.optString("name", null));
                }
            }
            try {
                JSONArray jSONArray2 = new JSONArray(Zq);
                int length2 = jSONArray2.length();
                for (int i12 = 0; i12 < length2; i12++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i12);
                    if (jSONObject2 != null && !hashSet.contains(jSONObject2.optString("name", null))) {
                        jSONArray.put(jSONObject2);
                    }
                }
                return jSONArray.toString();
            } catch (Throwable unused) {
                return userData;
            }
        } catch (Throwable unused2) {
            return Zq;
        }
    }

    @NonNull
    private Map<String, String> sP() {
        HashMap hashMap = new HashMap();
        hashMap.put(HttpHeaders.CONTENT_TYPE, "application/octet-stream;tt-data=a");
        return hashMap;
    }

    public static JSONArray sP(String str) {
        try {
            Set<String> sP2 = com.bytedance.sdk.component.adexpress.Sj.sP.sP.sP(str);
            if (sP2 != null && sP2.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = sP2.iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.adexpress.Sj.TKC.sP Sj2 = com.bytedance.sdk.component.adexpress.Sj.sP.sP.Sj(it.next());
                    if (Sj2 != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", Sj2.sP());
                        jSONObject.put("md5", Sj2.TKC());
                        jSONArray.put(jSONObject);
                    }
                }
                return jSONArray;
            }
            return null;
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.sU.Sj("NetApiImpl", "getParentTplIds: ", e11);
            return null;
        }
    }

    @DungeonFlag
    private JSONObject sP(@NonNull String str, List<FilterWord> list, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(CampaignEx.JSON_KEY_TIMESTAMP, System.currentTimeMillis());
            jSONObject2.put(Constants.AD_FRAMEWORK_VERSION, BuildConfig.VERSION_NAME);
            JSONObject jSONObject3 = new JSONObject(str);
            jSONObject3.put(UrlKt.KEY_MINI_GAID, com.bytedance.sdk.openadsdk.RiZ.Sj.sP.Sj.Sj().sP());
            jSONObject2.put("extra", jSONObject3.toString());
            jSONObject2.put("filter_words", Sj(list));
            jSONObject2.put("dislike_source", str4);
            if (com.bytedance.sdk.openadsdk.core.settings.Fmk.gq().xhi() && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                jSONObject2.put("creative_info", com.bytedance.sdk.component.utils.Sj.Sj(new JSONObject(str2)).toString());
                jSONObject2.put("feedback_type", 1);
                jSONObject2.put("user_description", str3);
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("actions", jSONArray);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v5, types: [com.bytedance.sdk.component.Jcg.sP] */
    /* JADX WARN: Type inference failed for: r28v0, types: [com.bytedance.sdk.openadsdk.core.sU] */
    public void sP(final AdSlot adSlot, final com.bytedance.sdk.openadsdk.core.model.ib ibVar, final int i11, final RiZ.Sj sj2) {
        Map<String, Object> map;
        String str;
        com.bytedance.sdk.component.Jcg.sP sPVar;
        ?? sPVar2;
        if (!dNu.EjP().zwV()) {
            sj2.Sj(40060, Dq.Sj(40060));
            return;
        }
        boolean TKC = com.bytedance.sdk.openadsdk.dx.Sj.TKC();
        if (!TKC) {
            sef.vS();
        }
        final com.bytedance.sdk.openadsdk.core.model.TKC tkc = new com.bytedance.sdk.openadsdk.core.model.TKC();
        tkc.Sj(adSlot);
        if (!com.bytedance.sdk.openadsdk.core.settings.uA.Sj()) {
            if (sj2 != null) {
                sj2.Sj(1000, "Ad request is temporarily paused, Please contact your AM");
                tkc.Sj(1000);
                com.bytedance.sdk.openadsdk.core.model.TKC.Sj(tkc);
                return;
            }
            return;
        }
        if (!dNu.EjP().Fm()) {
            if (sj2 != null) {
                sj2.Sj(-16, Dq.Sj(-16));
                tkc.Sj(1001);
                com.bytedance.sdk.openadsdk.core.model.TKC.Sj(tkc);
                return;
            }
            return;
        }
        if (sj2 == null) {
            return;
        }
        if (EjP(adSlot.getCodeId())) {
            sj2.Sj(-8, Dq.Sj(-8));
            return;
        }
        if (!TextUtils.isEmpty(adSlot.getBidAdm()) && !ibVar.vS) {
            tkc.sP(2);
            tkc.Sj(adSlot.getBidAdm());
            if (com.bytedance.sdk.component.utils.Zq.EjP()) {
                c.a(adSlot.getBidAdm());
            }
            if (dNu.EjP().db() && ley.Sj().EjP() == 1) {
                Mts.Sj("Pangle_Debug_Mode", adSlot.getBidAdm(), this.Sj);
            }
            try {
                JSONObject Sj2 = Sj(new JSONObject(adSlot.getBidAdm()));
                if (Sj2 == null) {
                    Sj(sj2, tkc);
                    return;
                }
                Sj Sj3 = Sj.Sj(Sj2, adSlot, ibVar, tkc);
                tkc.Sj(Sj3.TEQ);
                aa.Sj(this.Sj, Sj3.uA);
                int i12 = Sj3.EjP;
                if (i12 != 20000) {
                    sj2.Sj(i12, Sj3.HiB);
                    tkc.Sj(Sj3.EjP);
                    com.bytedance.sdk.openadsdk.core.model.TKC.Sj(tkc);
                    return;
                }
                com.bytedance.sdk.openadsdk.core.model.Sj sj3 = Sj3.Dq;
                if (sj3 == null) {
                    Sj(sj2, tkc);
                    return;
                }
                if (sj3.EjP() != null && Sj3.Dq.EjP().size() > 0) {
                    com.bytedance.sdk.openadsdk.Zq.TKC.Sj(Sj3.Dq.EjP().get(0));
                }
                if (Sj(Sj3.Dq, sj2)) {
                    return;
                }
                Sj3.Dq.TKC(Sj2.toString());
                sj2.Sj(Sj3.Dq, tkc);
                Map<String, com.bytedance.sdk.openadsdk.core.model.sU> Sj4 = com.bytedance.sdk.openadsdk.core.model.Sj.Sj(Sj3.Dq);
                if (Sj4 != null) {
                    com.bytedance.sdk.openadsdk.Jcg.sP.Sj().Sj(Sj4);
                }
                Sj(Sj3.Dq);
                com.bytedance.sdk.openadsdk.core.EjP.Sj.Sj().Sj(Sj3.Dq);
                return;
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.sU.Sj("NetApiImpl", "get ad error: ", th2);
                Sj(sj2, tkc);
                return;
            }
        }
        JSONObject Sj5 = Sj(adSlot, ibVar, i11);
        if (Sj5 == null) {
            sj2.Sj(-9, Dq.Sj(-9));
            tkc.Sj(-9);
            com.bytedance.sdk.openadsdk.core.model.TKC.Sj(tkc);
            return;
        }
        if (dNu.EjP().db() && ley.Sj().EjP() == 1) {
            Mts.Sj("Pangle_Debug_Mode", Sj5.toString(), this.Sj);
        }
        final String Sj6 = Mts.Sj("/api/ad/union/sdk/get_ads/", true, false);
        com.bytedance.sdk.component.Jcg.sP.EjP sP2 = com.bytedance.sdk.openadsdk.TzV.sP.Sj().sP().sP();
        try {
            sP2.sP(com.bytedance.sdk.openadsdk.Dq.EjP.Sj(sP2, Sj6));
        } catch (Exception unused) {
        }
        sP2.Sj(Sj5.toString(), dNu.EjP().uvD());
        Map<String, String> Sj7 = com.bytedance.sdk.openadsdk.core.uA.TKC.Sj(Sj6, Sj5.toString());
        if (Sj7 != null && Sj7.size() > 0) {
            for (String str2 : Sj7.keySet()) {
                try {
                    sP2.sP(str2, Sj7.get(str2));
                } catch (Exception e11) {
                    com.bytedance.sdk.component.utils.sU.sP("NetApiImpl", e11.getMessage());
                }
            }
        }
        try {
            sP2.sP("User-Agent", Mts.TKC());
            Sj(sP2, Sj5);
        } catch (Exception unused2) {
        }
        final WMZ sP3 = WMZ.sP();
        final Map<String, Object> requestExtraMap = adSlot.getRequestExtraMap();
        boolean z10 = uA.sP().RiZ() && requestExtraMap != null;
        if (z10) {
            requestExtraMap.put("pgad_start", sP3);
        }
        sP2.Sj(10);
        sP2.Sj("get_ad");
        com.bytedance.sdk.openadsdk.dNu.TKC.Sj(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.core.sU.8
            @Override // com.bytedance.sdk.openadsdk.dNu.EjP
            public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                com.bytedance.sdk.openadsdk.dNu.sP.Sj sj4 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                sj4.sP("get_ad");
                sj4.TKC(adSlot.getCodeId());
                sj4.EjP(Mts.TKC(adSlot.getDurationSlotType()));
                return sj4;
            }
        });
        if (com.bytedance.sdk.component.utils.Zq.EjP()) {
            Thread.currentThread().getName();
        }
        if (!TKC) {
            final boolean z11 = z10;
            sP2.Sj(new com.bytedance.sdk.component.Jcg.Sj.sP() { // from class: com.bytedance.sdk.openadsdk.core.sU.9
                @Override // com.bytedance.sdk.component.Jcg.Sj.Sj
                public void Sj(com.bytedance.sdk.component.Jcg.sP.TKC tkc2, com.bytedance.sdk.component.Jcg.sP sPVar3) {
                    sU.this.Sj(Sj6, sPVar3, z11, requestExtraMap, sP3, adSlot, tkc, sj2, ibVar, i11);
                }

                @Override // com.bytedance.sdk.component.Jcg.Sj.sP
                public void Sj(com.bytedance.sdk.component.Jcg.sP.TKC tkc2, IOException iOException, com.bytedance.sdk.component.Jcg.sP sPVar3) {
                    sU.this.Sj(Sj6, iOException, sPVar3, adSlot, z11, requestExtraMap, sj2, tkc);
                    if (tkc2 != null) {
                        com.bytedance.sdk.openadsdk.utils.sU.Sj(tkc2.EjP());
                    }
                }
            });
            return;
        }
        try {
            com.bytedance.sdk.component.Jcg.sP Sj8 = sP2.Sj();
            if (Sj8 == null) {
                str = null;
                sPVar2 = new com.bytedance.sdk.component.Jcg.sP(false, 5001, "response is null, content type is not support!!", null, "REQUEST_BODY_NULL", 1L, 1L);
            }
            sPVar = Sj8;
        } catch (Throwable th3) {
            th = th3;
            map = requestExtraMap;
            str = Sj6;
        }
        try {
            if (sPVar.vS()) {
                Sj(Sj6, sPVar, z10, requestExtraMap, sP3, adSlot, tkc, sj2, ibVar, i11);
            } else {
                Sj(Sj6, new IOException(sPVar.sP()), sPVar, adSlot, z10, requestExtraMap, sj2, tkc);
                com.bytedance.sdk.openadsdk.utils.sU.Sj(sP2.EjP());
            }
        } catch (Throwable th4) {
            th = th4;
            map = sPVar2;
            Sj(str, new IOException(th.getMessage()), new com.bytedance.sdk.component.Jcg.sP(false, 5002, "execute method throw exception", null, "REQUEST_BODY_EXCEPTION", 1L, 1L), adSlot, z10, map, sj2, tkc);
        }
    }

    @DungeonFlag
    private void vS(JSONObject jSONObject) {
        try {
            jSONObject.put("package_name", Mts.HiB());
            jSONObject.put("version_code", Mts.vS());
            jSONObject.put("version", Mts.Jcg());
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.RiZ
    public com.bytedance.sdk.component.adexpress.Sj.TKC.Sj Sj() {
        com.bytedance.sdk.component.adexpress.Sj.TKC.Sj sj2 = null;
        if (!com.bytedance.sdk.openadsdk.core.settings.uA.Sj()) {
            return null;
        }
        long currentTimeMillis = (System.currentTimeMillis() / 1000) - com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj("tpl_fetch_model", "date", 0L);
        String Mts = dNu.EjP().Mts();
        String sP2 = com.bytedance.sdk.openadsdk.multipro.EjP.EjP.sP("tpl_fetch_model", "last_url", "");
        if (currentTimeMillis <= dNu.EjP().wE() && currentTimeMillis >= 0 && TextUtils.equals(Mts, sP2)) {
            String sP3 = com.bytedance.sdk.openadsdk.multipro.EjP.EjP.sP("tpl_fetch_model", "model", "");
            try {
                if (!TextUtils.isEmpty(sP3)) {
                    return com.bytedance.sdk.component.adexpress.Sj.TKC.Sj.HiB(sP3);
                }
            } catch (Exception unused) {
            }
        }
        try {
            com.bytedance.sdk.component.Jcg.sP.sP TKC = com.bytedance.sdk.openadsdk.TzV.sP.Sj().sP().TKC();
            String Sj2 = com.bytedance.sdk.openadsdk.Dq.EjP.Sj(TKC, Mts);
            TKC.sP(Sj2);
            com.bytedance.sdk.component.Jcg.sP Sj3 = TKC.Sj();
            if (Sj3 == null || !Sj3.vS()) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(Sj3.EjP());
            jSONObject.put("template_fetch_url", Sj2);
            sj2 = com.bytedance.sdk.component.adexpress.Sj.TKC.Sj.Sj(jSONObject);
            com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj("tpl_fetch_model", "date", Long.valueOf(System.currentTimeMillis() / 1000));
            com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj("tpl_fetch_model", "model", jSONObject.toString());
            com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj("tpl_fetch_model", "last_url", Mts);
            return sj2;
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.sU.sP("NetApiImpl", th2.getMessage());
            return sj2;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.RiZ
    @DungeonFlag
    public com.bytedance.sdk.openadsdk.EjP.HiB Sj(JSONObject jSONObject, String str, boolean z10) {
        Object obj;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            byte[] bArr = null;
            if (!com.bytedance.sdk.openadsdk.core.settings.uA.Sj()) {
                return null;
            }
            com.bytedance.sdk.component.Jcg.sP.EjP sP2 = com.bytedance.sdk.openadsdk.TzV.sP.Sj().sP().sP();
            sP2.sP(str);
            if (com.bytedance.sdk.openadsdk.core.settings.Fmk.gq().kb()) {
                sP2.sP("_disable_retry", "1");
            }
            boolean z11 = true;
            if (z10) {
                com.bytedance.sdk.openadsdk.core.settings.vS gq2 = com.bytedance.sdk.openadsdk.core.settings.Fmk.gq();
                PangleEncryptConstant.CryptDataScene cryptDataScene = PangleEncryptConstant.CryptDataScene.APP_LOG;
                boolean Sj2 = gq2.Sj(cryptDataScene);
                byte[] HiB = HiB(jSONObject.toString());
                if (Sj2) {
                    Pair<Integer, byte[]> encryptType4WithoutBase64 = PangleEncryptManager.encryptType4WithoutBase64(HiB);
                    if (encryptType4WithoutBase64 == null || (obj = encryptType4WithoutBase64.second) == null || ((byte[]) obj).length <= 0) {
                        int intValue = encryptType4WithoutBase64 != null ? ((Integer) encryptType4WithoutBase64.first).intValue() : 0;
                        zR.sP(false);
                        zR.Sj(1, cryptDataScene, intValue);
                    } else {
                        bArr = (byte[]) obj;
                        zR.sP(true);
                    }
                }
                if (bArr != null) {
                    sP2.sP(HttpHeaders.CONTENT_ENCODING, "union_sdk_encode");
                    sP2.sP("x-pgli18n", "4");
                    sP2.Sj("application/octet-stream;tt-data=a", bArr);
                } else {
                    bArr = PangleEncryptManager.encryptV3(HiB);
                    if (bArr != null) {
                        Sj(sP(), sP2);
                        sP2.Sj("application/octet-stream;tt-data=a", bArr);
                    }
                }
            }
            if (bArr == null) {
                try {
                    JSONObject Sj3 = com.bytedance.sdk.component.utils.Sj.Sj(jSONObject);
                    if (!TKC(Sj3)) {
                        Sj3 = jSONObject;
                    }
                    Sj(EjP(Sj3), sP2);
                    sP2.Sj(Sj3.toString(), dNu.EjP().uvD());
                } catch (OutOfMemoryError e11) {
                    com.bytedance.sdk.component.utils.sU.sP("NetApiImpl", e11.toString());
                    return new com.bytedance.sdk.openadsdk.EjP.HiB(false, -2, "encrypt_error", false);
                }
            }
            com.bytedance.sdk.component.Jcg.sP Sj4 = sP2.Sj();
            boolean HiB2 = (Sj4 == null || !Sj4.vS() || TextUtils.isEmpty(Sj4.EjP())) ? false : HiB(new JSONObject(Sj4.EjP()));
            String str2 = "error unknown";
            int Sj5 = Sj4 != null ? Sj4.Sj() : 0;
            if (HiB2 || Sj5 != 200) {
                if (Sj4 != null && Sj4.sP() != null) {
                    str2 = Sj4.sP();
                }
                z11 = false;
            } else {
                str2 = "server say not success";
            }
            Sj(jSONObject, z10);
            com.bytedance.sdk.openadsdk.EjP.Sj.Sj.Sj(com.bytedance.sdk.openadsdk.EjP.Sj.Sj.Sj, HiB2, Sj5, System.currentTimeMillis() - currentTimeMillis);
            return new com.bytedance.sdk.openadsdk.EjP.HiB(HiB2, Sj5, str2, z11);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.sU.Sj("NetApiImpl", "uploadEvent error", th2);
            return new com.bytedance.sdk.openadsdk.EjP.HiB(false, DownloadException.EXCEPTION_IO_HTTP_RETRY, "service_busy", false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.RiZ
    public JSONObject Sj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return jSONObject;
        }
        try {
            int optInt = jSONObject.optInt("cypher", -1);
            String optString = jSONObject.optString("message");
            String optString2 = jSONObject.optString("auction_price", "");
            String sP2 = sP(optInt, optString);
            if (TextUtils.isEmpty(sP2)) {
                return jSONObject;
            }
            JSONObject jSONObject2 = new JSONObject(sP2);
            try {
                jSONObject2.put("auction_price", optString2);
            } catch (Throwable unused) {
            }
            return jSONObject2;
        } catch (Throwable unused2) {
            return jSONObject;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.RiZ
    public void Sj(final AdSlot adSlot, final com.bytedance.sdk.openadsdk.core.model.ib ibVar, final int i11, RiZ.Sj sj2) {
        final com.bytedance.sdk.openadsdk.core.Sj.Sj sj3 = new com.bytedance.sdk.openadsdk.core.Sj.Sj(sj2, adSlot);
        if (ibVar != null && (ibVar.sP == 2 || ibVar.TKC == 2 || ibVar.EjP == 2)) {
            adSlot.setPreload(true);
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            sef.sP().post(new com.bytedance.sdk.component.Dq.Dq("getAd") { // from class: com.bytedance.sdk.openadsdk.core.sU.1
                @Override // java.lang.Runnable
                public void run() {
                    sU.this.sP(adSlot, ibVar, i11, sj3);
                }
            });
        } else {
            sP(adSlot, ibVar, i11, sj3);
        }
        if (com.bytedance.sdk.openadsdk.dx.Sj.TKC()) {
            sef.Jcg();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.RiZ
    public void Sj(String str) {
        com.bytedance.sdk.component.Jcg.sP.sP TKC = com.bytedance.sdk.openadsdk.TzV.sP.Sj().sP().TKC();
        TKC.sP(str);
        TKC.Sj("upload_bidding");
        TKC.Sj(7);
        TKC.Sj(new com.bytedance.sdk.component.Jcg.Sj.Sj() { // from class: com.bytedance.sdk.openadsdk.core.sU.6
            @Override // com.bytedance.sdk.component.Jcg.Sj.Sj
            public void Sj(com.bytedance.sdk.component.Jcg.sP.TKC tkc, com.bytedance.sdk.component.Jcg.sP sPVar) {
                sPVar.EjP();
            }

            @Override // com.bytedance.sdk.component.Jcg.Sj.Sj
            public void Sj(com.bytedance.sdk.component.Jcg.sP.TKC tkc, IOException iOException) {
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.RiZ
    public void Sj(@NonNull String str, List<FilterWord> list, String str2, String str3, String str4) {
        JSONObject sP2;
        if (com.bytedance.sdk.openadsdk.core.settings.uA.Sj() && (sP2 = sP(str, list, str2, str3, str4)) != null) {
            com.bytedance.sdk.component.Jcg.sP.EjP sP3 = com.bytedance.sdk.openadsdk.TzV.sP.Sj().sP().sP();
            String EjP = Mts.EjP("/api/ad/union/dislike_event/");
            JSONObject Sj2 = Sj(PangleEncryptConstant.CryptDataScene.DISLIKE, sP2);
            String jSONObject = Sj2 != null ? Sj2.toString() : null;
            Sj(sP3, Sj2);
            sP3.sP(EjP);
            sP3.EjP(jSONObject);
            sP3.Sj(7);
            sP3.Sj("dislike");
            com.bytedance.sdk.openadsdk.dNu.TKC.Sj(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.core.sU.2
                @Override // com.bytedance.sdk.openadsdk.dNu.EjP
                public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                    com.bytedance.sdk.openadsdk.dNu.sP.Sj sj2 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                    sj2.sP("dislike");
                    return sj2;
                }
            });
            sP3.Sj(new com.bytedance.sdk.component.Jcg.Sj.Sj() { // from class: com.bytedance.sdk.openadsdk.core.sU.3
                @Override // com.bytedance.sdk.component.Jcg.Sj.Sj
                public void Sj(com.bytedance.sdk.component.Jcg.sP.TKC tkc, com.bytedance.sdk.component.Jcg.sP sPVar) {
                    if (sPVar == null) {
                        com.bytedance.sdk.openadsdk.dNu.TKC.TKC(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.core.sU.3.3
                            @Override // com.bytedance.sdk.openadsdk.dNu.EjP
                            public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                                com.bytedance.sdk.openadsdk.dNu.sP.Sj sj2 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                                sj2.sP("dislike");
                                return sj2;
                            }
                        });
                    } else if (sPVar.vS()) {
                        com.bytedance.sdk.openadsdk.dNu.TKC.sP(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.core.sU.3.1
                            @Override // com.bytedance.sdk.openadsdk.dNu.EjP
                            public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                                com.bytedance.sdk.openadsdk.dNu.sP.Sj sj2 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                                sj2.sP("dislike");
                                return sj2;
                            }
                        });
                    } else {
                        com.bytedance.sdk.openadsdk.dNu.TKC.TKC(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.core.sU.3.2
                            @Override // com.bytedance.sdk.openadsdk.dNu.EjP
                            public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                                com.bytedance.sdk.openadsdk.dNu.sP.Sj sj2 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                                sj2.sP("dislike");
                                return sj2;
                            }
                        });
                    }
                }

                @Override // com.bytedance.sdk.component.Jcg.Sj.Sj
                public void Sj(com.bytedance.sdk.component.Jcg.sP.TKC tkc, IOException iOException) {
                    if (tkc != null) {
                        com.bytedance.sdk.openadsdk.utils.sU.Sj(tkc.EjP());
                    }
                    com.bytedance.sdk.openadsdk.dNu.TKC.TKC(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.core.sU.3.4
                        @Override // com.bytedance.sdk.openadsdk.dNu.EjP
                        public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                            com.bytedance.sdk.openadsdk.dNu.sP.Sj sj2 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                            sj2.sP("dislike");
                            return sj2;
                        }
                    });
                }
            });
            try {
                String optString = new JSONObject(str).optString(BidResponsedEx.KEY_CID, "");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.vS.sP.Sj().Sj("dislike", optString, (String) null, (String) null);
            } catch (JSONException e11) {
                com.bytedance.sdk.component.utils.sU.sP(e11.getMessage(), new Object[0]);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.RiZ
    public void Sj(JSONObject jSONObject, final RiZ.sP sPVar) {
        if (!com.bytedance.sdk.openadsdk.core.settings.uA.Sj()) {
            if (sPVar != null) {
                sPVar.Sj(1000, "Ad request is temporarily paused, Please contact your AM");
            }
        } else {
            if (jSONObject == null || sPVar == null) {
                return;
            }
            JSONObject Sj2 = Sj(PangleEncryptConstant.CryptDataScene.REWARD_VERIFY, jSONObject);
            com.bytedance.sdk.component.Jcg.sP.EjP sP2 = com.bytedance.sdk.openadsdk.TzV.sP.Sj().sP().sP();
            try {
                sP2.sP(com.bytedance.sdk.openadsdk.Dq.EjP.Sj(sP2, Mts.EjP("/api/ad/union/sdk/reward_video/reward/")));
            } catch (Exception e11) {
                com.bytedance.sdk.component.utils.sU.sP("NetApiImpl", e11.getMessage());
            }
            Sj(sP2, Sj2);
            sP2.EjP(Sj2 != null ? Sj2.toString() : "");
            sP2.Sj(10);
            sP2.Sj("reward");
            com.bytedance.sdk.openadsdk.dNu.TKC.Sj(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.core.sU.4
                @Override // com.bytedance.sdk.openadsdk.dNu.EjP
                public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                    com.bytedance.sdk.openadsdk.dNu.sP.Sj sj2 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                    sj2.sP("reward");
                    return sj2;
                }
            });
            sP2.Sj(new com.bytedance.sdk.component.Jcg.Sj.Sj() { // from class: com.bytedance.sdk.openadsdk.core.sU.5
                @Override // com.bytedance.sdk.component.Jcg.Sj.Sj
                public void Sj(com.bytedance.sdk.component.Jcg.sP.TKC tkc, com.bytedance.sdk.component.Jcg.sP sPVar2) {
                    sP Sj3;
                    int i11;
                    if (sPVar2 == null) {
                        com.bytedance.sdk.openadsdk.dNu.TKC.TKC(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.core.sU.5.3
                            @Override // com.bytedance.sdk.openadsdk.dNu.EjP
                            public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                                com.bytedance.sdk.openadsdk.dNu.sP.Sj sj2 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                                sj2.sP("reward");
                                return sj2;
                            }
                        });
                        sU.this.Sj(sPVar);
                        return;
                    }
                    if (!sPVar2.vS() || TextUtils.isEmpty(sPVar2.EjP())) {
                        String Sj4 = Dq.Sj(-2);
                        int Sj5 = sPVar2.Sj();
                        if (!sPVar2.vS() && !TextUtils.isEmpty(sPVar2.sP())) {
                            Sj4 = sPVar2.sP();
                        }
                        sPVar.Sj(Sj5, Sj4);
                        com.bytedance.sdk.openadsdk.dNu.TKC.TKC(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.core.sU.5.2
                            @Override // com.bytedance.sdk.openadsdk.dNu.EjP
                            public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                                com.bytedance.sdk.openadsdk.dNu.sP.Sj sj2 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                                sj2.sP("reward");
                                return sj2;
                            }
                        });
                        return;
                    }
                    try {
                        JSONObject jSONObject2 = new JSONObject(sPVar2.EjP());
                        String sP3 = sU.sP(jSONObject2.optInt("cypher", -1), jSONObject2.optString("message"));
                        if (!TextUtils.isEmpty(sP3)) {
                            try {
                                jSONObject2 = new JSONObject(sP3);
                            } catch (Throwable unused) {
                            }
                        }
                        Sj3 = sP.Sj(jSONObject2);
                        i11 = Sj3.Sj;
                    } catch (JSONException e12) {
                        com.bytedance.sdk.component.utils.sU.sP("NetApiImpl", e12.getMessage());
                        sU.this.Sj(sPVar);
                    }
                    if (i11 != 20000) {
                        sPVar.Sj(i11, Dq.Sj(i11));
                    } else if (Sj3.TKC == null) {
                        sU.this.Sj(sPVar);
                    } else {
                        sPVar.Sj(Sj3);
                        com.bytedance.sdk.openadsdk.dNu.TKC.sP(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.core.sU.5.1
                            @Override // com.bytedance.sdk.openadsdk.dNu.EjP
                            public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                                com.bytedance.sdk.openadsdk.dNu.sP.Sj sj2 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                                sj2.sP("reward");
                                return sj2;
                            }
                        });
                    }
                }

                @Override // com.bytedance.sdk.component.Jcg.Sj.Sj
                public void Sj(com.bytedance.sdk.component.Jcg.sP.TKC tkc, IOException iOException) {
                    sPVar.Sj(-2, iOException != null ? iOException.getMessage() : "");
                    if (tkc != null) {
                        com.bytedance.sdk.openadsdk.utils.sU.Sj(tkc.EjP());
                    }
                    com.bytedance.sdk.openadsdk.dNu.TKC.TKC(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.core.sU.5.4
                        @Override // com.bytedance.sdk.openadsdk.dNu.EjP
                        public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                            com.bytedance.sdk.openadsdk.dNu.sP.Sj sj2 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                            sj2.sP("reward");
                            return sj2;
                        }
                    });
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.RiZ
    public void Sj(JSONObject jSONObject, String str) {
        com.bytedance.sdk.component.Jcg.sP.EjP sP2 = com.bytedance.sdk.openadsdk.TzV.sP.Sj().sP().sP();
        sP2.sP(str);
        Pair<String, String> generateRequestHeader = ApmHelper.generateRequestHeader();
        sP2.sP("cypher", (String) generateRequestHeader.first);
        sP2.sP("transfer-param", (String) generateRequestHeader.second);
        sP2.sP("x-pangle-target-idc", dNu.EjP().oWa());
        sP2.Sj(jSONObject);
        sP2.Sj(5);
        sP2.Sj("apm_pv");
        sP2.Sj(new com.bytedance.sdk.component.Jcg.Sj.Sj() { // from class: com.bytedance.sdk.openadsdk.core.sU.7
            @Override // com.bytedance.sdk.component.Jcg.Sj.Sj
            public void Sj(com.bytedance.sdk.component.Jcg.sP.TKC tkc, com.bytedance.sdk.component.Jcg.sP sPVar) {
                sPVar.EjP();
            }

            @Override // com.bytedance.sdk.component.Jcg.Sj.Sj
            public void Sj(com.bytedance.sdk.component.Jcg.sP.TKC tkc, IOException iOException) {
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.openadsdk.core.RiZ
    public com.bytedance.sdk.openadsdk.EjP.HiB sP(JSONObject jSONObject) {
        int i11;
        boolean z10;
        boolean z11;
        boolean z12;
        String str = "error unknown";
        long currentTimeMillis = System.currentTimeMillis();
        if (!com.bytedance.sdk.openadsdk.core.settings.uA.Sj() || !dNu.EjP().zwV() || jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        com.bytedance.sdk.component.Jcg.sP.EjP sP2 = com.bytedance.sdk.openadsdk.TzV.sP.Sj().sP().sP();
        int i12 = 0;
        try {
            JSONObject Sj2 = Sj(PangleEncryptConstant.CryptDataScene.STATS_LOG, jSONObject);
            sP2.Sj(Sj2.toString(), dNu.EjP().uvD());
            sP2.sP(Mts.EjP("/api/ad/union/sdk/stats/batch/"));
            Sj(sP2, Sj2);
            sP2.sP("User-Agent", Mts.TKC());
            if (com.bytedance.sdk.openadsdk.core.settings.Fmk.gq().Uc()) {
                sP2.sP("_disable_retry", "1");
            }
            com.bytedance.sdk.component.Jcg.sP Sj3 = sP2.Sj();
            try {
            } catch (Throwable unused) {
                i11 = 0;
                z10 = false;
            }
            if (Sj3 == null) {
                return new com.bytedance.sdk.openadsdk.EjP.HiB(false, 0, "error unknown", false);
            }
            if (!Sj3.vS() || TextUtils.isEmpty(Sj3.EjP())) {
                z12 = false;
                z10 = false;
            } else {
                JSONObject jSONObject2 = new JSONObject(Sj3.EjP());
                int optInt = jSONObject2.optInt("code", -1);
                str = jSONObject2.optString("data", "");
                z10 = true;
                boolean z13 = optInt == 20000;
                z12 = z13;
                if (optInt != 60005) {
                    z10 = false;
                    z12 = z13;
                }
            }
            try {
                i12 = Sj3.Sj();
                z11 = z12;
                if (!Sj3.vS()) {
                    str = Sj3.sP();
                    com.bytedance.sdk.openadsdk.utils.sU.Sj(sP2.EjP());
                    z11 = z12;
                }
            } catch (Throwable unused2) {
                i11 = i12;
                i12 = z12 ? 1 : 0;
                z11 = i12;
                i12 = i11;
                com.bytedance.sdk.openadsdk.EjP.Sj.Sj.Sj(com.bytedance.sdk.openadsdk.EjP.Sj.Sj.sP, z11, i12, System.currentTimeMillis() - currentTimeMillis);
                return new com.bytedance.sdk.openadsdk.EjP.HiB(z11, i12, str, z10);
            }
            com.bytedance.sdk.openadsdk.EjP.Sj.Sj.Sj(com.bytedance.sdk.openadsdk.EjP.Sj.Sj.sP, z11, i12, System.currentTimeMillis() - currentTimeMillis);
            return new com.bytedance.sdk.openadsdk.EjP.HiB(z11, i12, str, z10);
        } catch (Throwable unused3) {
            com.bytedance.sdk.openadsdk.EjP.Sj.Sj.Sj(com.bytedance.sdk.openadsdk.EjP.Sj.Sj.sP, false, 0, System.currentTimeMillis() - currentTimeMillis);
            return new com.bytedance.sdk.openadsdk.EjP.HiB(false, 0, "error unknown", false);
        }
    }
}

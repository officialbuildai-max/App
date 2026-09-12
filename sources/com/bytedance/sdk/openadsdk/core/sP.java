package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.Ym.Sj.sP;
import com.bytedance.sdk.openadsdk.utils.FPG;
import com.bytedance.sdk.openadsdk.utils.Mts;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import y5.b;

/* loaded from: classes3.dex */
public class sP {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class Sj {
        public String Sj;
        public int sP;

        public Sj(String str, int i11) {
            this.Sj = str;
            this.sP = i11;
        }
    }

    private static com.bytedance.sdk.openadsdk.core.model.dNu Dq(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.dNu dnu = new com.bytedance.sdk.openadsdk.core.model.dNu();
        if (jSONObject == null) {
            dnu.EjP(5);
            dnu.HiB(30);
            dnu.vS(70);
            dnu.Jcg(1);
            dnu.Dq(com.bytedance.sdk.openadsdk.core.model.dNu.Sj);
            dnu.TKC(0);
            dnu.sP(0);
            dnu.Sj(3);
            return dnu;
        }
        dnu.EjP(jSONObject.optInt("ceiling_time", 5));
        dnu.HiB(jSONObject.optInt("ceiling_ratio", 30));
        dnu.vS(jSONObject.optInt("expand_ratio", 70));
        dnu.Jcg(jSONObject.optInt("back_type", 1));
        dnu.Dq(jSONObject.optInt("boc_return_type", com.bytedance.sdk.openadsdk.core.model.dNu.Sj));
        dnu.TKC(jSONObject.optInt("pre_render_status", 0));
        dnu.sP(jSONObject.optInt("pre_render_use_gecko", 0));
        dnu.Sj(jSONObject.optInt("pre_render_add_type", 3));
        return dnu;
    }

    private static com.bytedance.sdk.openadsdk.core.model.HiB EjP(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("splash_clickarea", 2);
        int optInt2 = jSONObject.optInt("splash_layout_id", 1);
        long optLong = jSONObject.optLong("load_wait_time", 0L);
        long j11 = optLong >= 0 ? optLong : 0L;
        int optInt3 = jSONObject.optInt("skip_time", -1);
        com.bytedance.sdk.openadsdk.core.model.HiB hiB = new com.bytedance.sdk.openadsdk.core.model.HiB();
        hiB.sP(optInt);
        hiB.TKC(optInt2);
        hiB.Sj(j11);
        hiB.Sj(optInt3);
        return hiB;
    }

    private static boolean EjP(com.bytedance.sdk.openadsdk.core.model.sU sUVar) {
        return (sUVar.Ph() || sUVar.hzV()) ? false : true;
    }

    private static FilterWord HiB(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            FilterWord filterWord = new FilterWord();
            filterWord.setId(jSONObject.optString("id"));
            filterWord.setName(jSONObject.optString("name"));
            filterWord.setIsSelected(jSONObject.optBoolean("is_selected"));
            JSONArray optJSONArray = jSONObject.optJSONArray("options");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                    FilterWord HiB = HiB(optJSONArray.optJSONObject(i11));
                    if (HiB != null && HiB.isValid()) {
                        filterWord.addOption(HiB);
                    }
                }
            }
            return filterWord;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Nullable
    private static com.bytedance.sdk.openadsdk.core.model.RiZ Jcg(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.RiZ riZ = new com.bytedance.sdk.openadsdk.core.model.RiZ();
        if (jSONObject == null) {
            riZ.Sj(10L);
            riZ.sP(20L);
            riZ.TKC(10L);
            riZ.EjP(20L);
            riZ.Sj("");
            return riZ;
        }
        riZ.Sj(jSONObject.optLong("onlylp_loading_maxtime", 10L));
        riZ.sP(jSONObject.optLong("straight_lp_showtime", 20L));
        riZ.TKC(jSONObject.optLong("onlyagg_loading_maxtime", 10L));
        riZ.EjP(jSONObject.optLong("straight_agg_showtime", 20L));
        riZ.Sj(jSONObject.optString("loading_text", ""));
        return riZ;
    }

    private static int Sj(com.bytedance.sdk.openadsdk.core.model.EjP ejP) {
        if (ejP == null) {
            return TTAdConstant.DOWNLOAD_APP_INFO_CODE;
        }
        if (TextUtils.isEmpty(ejP.Sj())) {
            return TTAdConstant.DOWNLOAD_URL_CODE;
        }
        if (TextUtils.isEmpty(ejP.TKC())) {
            return TTAdConstant.PACKAGE_NAME_CODE;
        }
        return 200;
    }

    private static int Sj(com.bytedance.sdk.openadsdk.core.model.Ym ym2) {
        if (ym2 == null) {
            return 200;
        }
        if (TextUtils.isEmpty(ym2.Sj())) {
            return TTAdConstant.DEEPLINK_UNAVAILABLE_CODE;
        }
        if (TextUtils.isEmpty(ym2.sP())) {
            return TTAdConstant.DEEPLINK_FALLBACK_CODE;
        }
        if (ym2.TKC() == 1 || ym2.TKC() == 2) {
            return 200;
        }
        return TTAdConstant.DEEPLINK_FALLBACK_TYPE_CODE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0086, code lost:
    
        if (r0 != 50) goto L52;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int Sj(com.bytedance.sdk.openadsdk.core.model.sU r5) {
        /*
            r0 = 401(0x191, float:5.62E-43)
            r1 = 0
            if (r5 != 0) goto Lb
            java.lang.String r5 = ""
            com.bytedance.sdk.openadsdk.EjP.TKC.TKC(r1, r5, r0)
            return r0
        Lb:
            int r2 = r5.DKj()
            java.lang.String r2 = com.bytedance.sdk.openadsdk.utils.Mts.TKC(r2)
            java.lang.String r3 = r5.aZ()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto Lbd
            java.lang.String r3 = r5.aZ()
            int r3 = r3.length()
            r4 = 1
            if (r3 > r4) goto L2a
            goto Lbd
        L2a:
            boolean r3 = r5.hzV()
            if (r3 == 0) goto L64
            int r3 = r5.DKj()
            if (r3 >= 0) goto L47
            com.bytedance.sdk.openadsdk.AdSlot r3 = r5.xD()
            if (r3 == 0) goto L44
            com.bytedance.sdk.openadsdk.AdSlot r3 = r5.xD()
            r3.getDurationSlotType()
            goto L47
        L44:
            r5.DKa()
        L47:
            boolean r3 = r5.Fqk()
            if (r3 == 0) goto L4f
            java.lang.String r2 = "fullscreen_interstitial_ad"
        L4f:
            java.lang.String r3 = r5.TX()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L5f
            java.lang.String r3 = "load_html_fail"
            com.bytedance.sdk.openadsdk.EjP.TKC.sP(r5, r2, r3, r1)
            return r0
        L5f:
            java.lang.String r0 = "load_html_success"
            com.bytedance.sdk.openadsdk.EjP.TKC.sP(r5, r2, r0, r1)
        L64:
            int r0 = r5.AE()
            if (r0 != 0) goto La9
            int r0 = r5.HcZ()
            r1 = 2
            r3 = 200(0xc8, float:2.8E-43)
            if (r0 == r1) goto L9b
            r1 = 3
            if (r0 == r1) goto L9b
            r1 = 4
            if (r0 == r1) goto L9b
            r1 = 5
            if (r0 == r1) goto L89
            r1 = 15
            if (r0 == r1) goto L89
            r1 = 16
            if (r0 == r1) goto L9b
            r1 = 50
            if (r0 == r1) goto L89
            goto La9
        L89:
            y5.b r0 = r5.UHs()
            boolean r1 = r5.Ph()
            int r0 = Sj(r0, r1)
            if (r0 == r3) goto La9
            com.bytedance.sdk.openadsdk.EjP.TKC.TKC(r5, r2, r0)
            return r0
        L9b:
            java.util.List r0 = r5.Bml()
            int r0 = Sj(r0)
            if (r0 == r3) goto La9
            com.bytedance.sdk.openadsdk.EjP.TKC.TKC(r5, r2, r0)
            return r0
        La9:
            com.bytedance.sdk.openadsdk.core.settings.vS r0 = com.bytedance.sdk.openadsdk.core.settings.Fmk.gq()
            boolean r0 = r0.nP()
            if (r0 == 0) goto Lb8
            int r5 = TKC(r5)
            goto Lbc
        Lb8:
            int r5 = sP(r5)
        Lbc:
            return r5
        Lbd:
            r0 = 402(0x192, float:5.63E-43)
            com.bytedance.sdk.openadsdk.EjP.TKC.TKC(r5, r2, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.sP.Sj(com.bytedance.sdk.openadsdk.core.model.sU):int");
    }

    private static int Sj(List<com.bytedance.sdk.openadsdk.core.model.uvD> list) {
        if (list == null) {
            return TTAdConstant.IMAGE_LIST_CODE;
        }
        if (list.size() <= 0) {
            return TTAdConstant.IMAGE_LIST_SIZE_CODE;
        }
        for (com.bytedance.sdk.openadsdk.core.model.uvD uvd : list) {
            if (uvd == null) {
                return TTAdConstant.IMAGE_CODE;
            }
            if (TextUtils.isEmpty(uvd.Sj())) {
                return TTAdConstant.IMAGE_URL_CODE;
            }
        }
        return 200;
    }

    private static int Sj(b bVar, boolean z10) {
        if (bVar == null) {
            return TTAdConstant.VIDEO_INFO_CODE;
        }
        if (TextUtils.isEmpty(bVar.x())) {
            return TTAdConstant.VIDEO_URL_CODE;
        }
        if (z10 || !TextUtils.isEmpty(bVar.r())) {
            return 200;
        }
        return TTAdConstant.VIDEO_COVER_URL_CODE;
    }

    private static Pair<com.bytedance.sdk.openadsdk.core.Ym.Sj, sP.Sj> Sj(String str, int i11, int i12) {
        int i13;
        int i14;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i12 == 1 || i12 == 5) {
            i13 = 0;
            i14 = 0;
        } else {
            i13 = FPG.TKC(dNu.Sj());
            i14 = FPG.HiB(dNu.Sj());
            if (i11 == 2) {
                i14 = i13;
                i13 = i14;
            }
        }
        com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj.HiB hiB = new com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj.HiB(dNu.Sj(), i13, i14);
        return new Pair<>(hiB.Sj(str, new ArrayList()), hiB.vS);
    }

    @Nullable
    public static Pair<com.bytedance.sdk.openadsdk.core.model.Sj, ArrayList<Integer>> Sj(JSONObject jSONObject, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.ib ibVar, com.bytedance.sdk.openadsdk.core.model.TKC tkc) {
        com.bytedance.sdk.openadsdk.core.model.TKC tkc2;
        if (jSONObject == null) {
            return null;
        }
        try {
            com.bytedance.sdk.openadsdk.core.model.Sj sj2 = new com.bytedance.sdk.openadsdk.core.model.Sj();
            sj2.Sj(jSONObject.optString(TrackingKey.REQUEST_ID));
            sj2.Sj(jSONObject.optInt("ret"));
            int i11 = 0;
            sj2.sP(jSONObject.optInt("multi_ad_style", 0));
            sj2.sP(jSONObject.optString("message"));
            String optString = jSONObject.optString("gdid_encrypted");
            boolean z10 = true;
            if (jSONObject.has("choose_ui_data")) {
                sj2.sP(jSONObject.optJSONObject("choose_ui_data"));
                sj2.Sj(true);
            }
            String optString2 = jSONObject.optString("auction_price");
            if (sj2.TKC() != 0) {
                return null;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("creatives");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                ArrayList arrayList2 = sj2.aa() ? new ArrayList() : null;
                int i12 = 0;
                while (i12 < optJSONArray.length()) {
                    com.bytedance.sdk.openadsdk.core.model.sU Sj2 = Sj(optJSONArray.optJSONObject(i12), adSlot, ibVar);
                    if (Sj2 != null && sj2.aa()) {
                        if (Sj2.dx() != 30 && Sj2.dx() != 39) {
                            sj2.sP(0);
                            arrayList2 = null;
                        }
                        Sj2.uA(z10);
                    }
                    int Sj3 = Sj(Sj2);
                    if (Sj3 != 200) {
                        if (Sj2 != null) {
                            com.bytedance.sdk.openadsdk.EjP.TKC.sP(Sj2, Mts.TKC(Sj2.DKj()), Sj3);
                        } else {
                            com.bytedance.sdk.openadsdk.EjP.TKC.sP((com.bytedance.sdk.openadsdk.core.model.sU) null, "", Sj3);
                        }
                        arrayList.add(Integer.valueOf(Sj3));
                        if (arrayList2 != null && Sj2 != null) {
                            arrayList2.add(new Sj(Sj2.Ci(), Sj3));
                        }
                        if (Sj2 != null && Sj2.dx() == 39) {
                            sj2.sP(0);
                        }
                    } else {
                        Sj2.uA(optString2);
                        if (!TextUtils.isEmpty(optString)) {
                            Sj2.wE(optString);
                        }
                        sj2.Sj(Sj2);
                    }
                    i12++;
                    z10 = true;
                }
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    Sj((ArrayList<Sj>) arrayList2);
                }
                tkc2 = tkc;
                i11 = length;
            } else {
                tkc2 = tkc;
            }
            Sj(i11, sj2, (ArrayList<Integer>) arrayList, tkc2);
            return new Pair<>(sj2, arrayList);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.sU.sP("TTAD.AdInfoFactory", th2.getMessage());
            return null;
        }
    }

    @Nullable
    public static com.bytedance.sdk.openadsdk.core.model.sU Sj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return Sj(jSONObject, (AdSlot) null, (com.bytedance.sdk.openadsdk.core.model.ib) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:146:0x0615, code lost:
    
        if (r16.optBoolean("is_html", false) != false) goto L148;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.bytedance.sdk.openadsdk.core.model.sU Sj(org.json.JSONObject r16, com.bytedance.sdk.openadsdk.AdSlot r17, com.bytedance.sdk.openadsdk.core.model.ib r18) {
        /*
            Method dump skipped, instructions count: 1922
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.sP.Sj(org.json.JSONObject, com.bytedance.sdk.openadsdk.AdSlot, com.bytedance.sdk.openadsdk.core.model.ib):com.bytedance.sdk.openadsdk.core.model.sU");
    }

    @Nullable
    private static b Sj(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.sU sUVar, boolean z10) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.D(jSONObject.optInt("cover_height"));
        bVar.u(jSONObject.optInt("cover_width"));
        bVar.q(jSONObject.optString("resolution"));
        bVar.p(jSONObject.optLong("size"));
        double optDouble = jSONObject.optDouble("video_duration", 0.0d);
        bVar.n(optDouble);
        int i11 = 1;
        int optInt = jSONObject.optInt("replay_time", 1);
        if (optDouble <= 15.0d && sUVar.ley() != 1 && com.bytedance.sdk.openadsdk.core.model.sU.HiB(sUVar)) {
            i11 = optInt;
        }
        bVar.s(i11);
        bVar.E(jSONObject.optString("cover_url"));
        bVar.v(jSONObject.optString(CampaignEx.JSON_KEY_VIDEO_URL));
        bVar.e(jSONObject.optString(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD));
        bVar.i(jSONObject.optString("playable_download_url"));
        bVar.M(jSONObject.optString("file_hash"));
        bVar.b(jSONObject.optInt("if_playable_loading_show", 0));
        bVar.I(jSONObject.optInt("remove_loading_page_type", 0));
        bVar.o(jSONObject.optInt("fallback_endcard_judge", 0));
        bVar.h(jSONObject.optInt("video_preload_size", 307200));
        bVar.L(jSONObject.optInt("reward_video_cached_type", 0));
        bVar.k(jSONObject.optInt("execute_cached_type", 0));
        bVar.d(z10 ? jSONObject.optInt("endcard_render", 0) : jSONObject.optInt("endcard_render", -1));
        return bVar;
    }

    private static void Sj(int i11, final com.bytedance.sdk.openadsdk.core.model.Sj sj2, final ArrayList<Integer> arrayList, final com.bytedance.sdk.openadsdk.core.model.TKC tkc) {
        if (sj2 == null || i11 < 2 || !sj2.Dq()) {
            return;
        }
        final int size = i11 - (sj2.EjP() != null ? sj2.EjP().size() : 0);
        final boolean z10 = sj2.uA() == null;
        if (size > 0 || z10) {
            com.bytedance.sdk.openadsdk.Zq.TKC.Sj();
            com.bytedance.sdk.openadsdk.Zq.TKC.Sj("choose_ad_parsing_error", false, new com.bytedance.sdk.openadsdk.Zq.sP() { // from class: com.bytedance.sdk.openadsdk.core.sP.1
                @Override // com.bytedance.sdk.openadsdk.Zq.sP
                public com.bytedance.sdk.openadsdk.Zq.Sj.TKC getLogStats() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("req_id", com.bytedance.sdk.openadsdk.core.model.Sj.this.sP());
                    jSONObject.put("material_error", size);
                    jSONObject.put("choose_ui_error", z10 ? 1 : 0);
                    ArrayList arrayList2 = arrayList;
                    if (arrayList2 != null && !arrayList2.isEmpty()) {
                        jSONObject.put("mate_unavailable_code_list", new JSONArray((Collection) arrayList).toString());
                    }
                    com.bytedance.sdk.openadsdk.core.model.TKC tkc2 = tkc;
                    if (tkc2 != null) {
                        jSONObject.put("server_res_str", tkc2.Sj());
                    }
                    return com.bytedance.sdk.openadsdk.Zq.Sj.EjP.sP().Sj("choose_ad_parsing_error").sP(jSONObject.toString());
                }
            });
        }
    }

    private static void Sj(com.bytedance.sdk.openadsdk.core.Ym.Sj sj2, com.bytedance.sdk.openadsdk.core.model.sU sUVar) {
        sj2.Sj(sUVar);
        if (!Sj(sUVar.sdp())) {
            sUVar.ib(2);
        }
        sUVar.Jcg(1);
        sUVar.Sj(sj2);
        if (!TextUtils.isEmpty(sj2.EjP())) {
            sUVar.Zq(sj2.EjP());
        }
        if (!TextUtils.isEmpty(sj2.HiB())) {
            sUVar.uvD(sj2.HiB());
        }
        sUVar.Fmk(sj2.vS());
        sUVar.Sj((com.bytedance.sdk.openadsdk.core.model.EjP) null);
        b UHs = sUVar.UHs();
        if (UHs == null) {
            UHs = new b();
        }
        UHs.v(sj2.Jcg());
        UHs.n(sj2.Dq());
        UHs.M(null);
        UHs.E(null);
        UHs.e(null);
        sUVar.Sj(UHs);
        if (sj2.sP() != null && !TextUtils.isEmpty(sj2.sP().HiB())) {
            com.bytedance.sdk.openadsdk.core.model.uvD uvd = new com.bytedance.sdk.openadsdk.core.model.uvD();
            uvd.Sj(sj2.sP().HiB());
            uvd.Sj(sj2.sP().sP());
            uvd.sP(sj2.sP().TKC());
            sUVar.Sj(uvd);
            return;
        }
        if (sUVar.EZ() == null) {
            com.bytedance.sdk.openadsdk.core.model.uvD uvd2 = new com.bytedance.sdk.openadsdk.core.model.uvD();
            uvd2.Sj("https://lf-static.tiktokpangle-cdn-us.com/obj/ad-pattern-tx/static/images/2023620white.jpeg");
            uvd2.Sj(98);
            uvd2.sP(98);
            sUVar.Sj(uvd2);
        }
    }

    private static void Sj(com.bytedance.sdk.openadsdk.core.model.sU sUVar, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("reason_code", -1);
            jSONObject.put("error_code", -1);
            com.bytedance.sdk.openadsdk.EjP.TKC.sP(sUVar, str, "load_vast_fail", jSONObject);
        } catch (Exception unused) {
        }
    }

    private static void Sj(final com.bytedance.sdk.openadsdk.core.model.sU sUVar, final String str, final com.bytedance.sdk.openadsdk.core.Ym.Sj sj2, final long j11, final sP.Sj sj3) {
        com.bytedance.sdk.openadsdk.EjP.TKC.Sj(new com.bytedance.sdk.component.Dq.Dq("vast_parser") { // from class: com.bytedance.sdk.openadsdk.core.sP.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    com.bytedance.sdk.openadsdk.core.Ym.Sj sj4 = sj2;
                    String str2 = "load_vast_fail";
                    if (sj4 != null) {
                        if (!TextUtils.isEmpty(sj4.uA()) && !TextUtils.isEmpty(sj2.vS()) && sj2.Dq() > 0.0d) {
                            jSONObject.put("duration", System.currentTimeMillis() - j11);
                            sP.Sj sj5 = sj3;
                            if (sj5 != null) {
                                jSONObject.put("wrapper_count", sj5.sP);
                                jSONObject.put("impression_links_null", sj3.TKC);
                            }
                            str2 = "load_vast_success";
                        }
                        jSONObject.put("reason_code", -3);
                        jSONObject.put("error_code", -3);
                    } else {
                        jSONObject.put("reason_code", -2);
                        sP.Sj sj6 = sj3;
                        if (sj6 != null) {
                            jSONObject.put("error_code", sj6.Sj);
                        }
                    }
                    com.bytedance.sdk.openadsdk.EjP.TKC.sP(sUVar, str, str2, jSONObject);
                    com.bytedance.sdk.openadsdk.core.Ym.Sj sj7 = sj2;
                    if (sj7 == null || sj7.sP() == null || !TextUtils.isEmpty(sj2.sP().vS())) {
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("error_code", 1000);
                        jSONObject2.put(TrackingKey.DESCRIPTION, "1000:Image url is null");
                    } catch (Throwable unused) {
                    }
                    com.bytedance.sdk.openadsdk.EjP.TKC.sP(sUVar, str, "load_vast_icon_fail", jSONObject2);
                    sj2.Sj((com.bytedance.sdk.openadsdk.core.Ym.sP) null);
                } catch (Exception unused2) {
                }
            }
        });
    }

    private static void Sj(final ArrayList<Sj> arrayList) {
        com.bytedance.sdk.openadsdk.Zq.TKC.Sj("multiple_ads_parsing_error", false, new com.bytedance.sdk.openadsdk.Zq.sP() { // from class: com.bytedance.sdk.openadsdk.core.sP.3
            @Override // com.bytedance.sdk.openadsdk.Zq.sP
            @Nullable
            public com.bytedance.sdk.openadsdk.Zq.Sj.TKC getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("material_error", arrayList.size());
                JSONArray jSONArray = new JSONArray();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Sj sj2 = (Sj) it.next();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(BidResponsedEx.KEY_CID, sj2.Sj);
                    jSONObject2.put(OfflineConstantsKt.TRACK_KEY_PRE_ERROR_MSG, sj2.sP);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("error_cid_list", jSONArray);
                return com.bytedance.sdk.openadsdk.Zq.Sj.EjP.sP().Sj("multiple_ads_parsing_error").sP(jSONObject.toString());
            }
        });
    }

    private static void Sj(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.sU sUVar) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("iv_skip_time", -1);
            int optInt2 = jSONObject.optInt("rv_skip_time", -1);
            if (optInt != -1) {
                sUVar.Sj(optInt);
            }
            if (optInt2 != -1) {
                sUVar.sP(optInt2);
            }
        }
    }

    private static boolean Sj(int i11) {
        return i11 == 2 || i11 == 3 || i11 == 8;
    }

    @Nullable
    private static com.bytedance.sdk.openadsdk.core.model.aa TEQ(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.model.aa aaVar = new com.bytedance.sdk.openadsdk.core.model.aa();
        aaVar.Sj(jSONObject.optInt("if_send_click", 0));
        return aaVar;
    }

    private static int TKC(com.bytedance.sdk.openadsdk.core.model.sU sUVar) {
        int i11;
        String TKC = Mts.TKC(sUVar.DKj());
        if (sUVar.AE() == 0) {
            i11 = Sj(sUVar.TFd());
            if (i11 != 200) {
                com.bytedance.sdk.openadsdk.EjP.TKC.TKC(sUVar, TKC, i11);
                return i11;
            }
        } else {
            i11 = 200;
        }
        int sdp = sUVar.sdp();
        if (sdp != 2 && sdp != 3) {
            if (sdp == 4) {
                int Sj2 = Sj(sUVar.tz());
                if (Sj2 == 200) {
                    return Sj2;
                }
                com.bytedance.sdk.openadsdk.EjP.TKC.TKC(sUVar, TKC, Sj2);
                return Sj2;
            }
            if (sdp != 8) {
                return i11;
            }
        }
        if (!EjP(sUVar) || !TextUtils.isEmpty(sUVar.Chv())) {
            return i11;
        }
        com.bytedance.sdk.openadsdk.EjP.TKC.TKC(sUVar, TKC, TTAdConstant.LANDING_PAGE_TYPE_CODE);
        return TTAdConstant.LANDING_PAGE_TYPE_CODE;
    }

    private static com.bytedance.sdk.openadsdk.core.TEQ.Jcg.Sj TKC(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.TEQ.Jcg.Sj sj2 = new com.bytedance.sdk.openadsdk.core.TEQ.Jcg.Sj();
        sj2.Sj(jSONObject.optString("id"));
        sj2.sP(jSONObject.optString("md5"));
        sj2.TKC(jSONObject.optString("url"));
        return sj2;
    }

    @Nullable
    private static com.bytedance.sdk.openadsdk.core.model.Ym Ym(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.model.Ym ym2 = new com.bytedance.sdk.openadsdk.core.model.Ym();
        ym2.Sj(jSONObject.optString("deeplink_url"));
        ym2.sP(jSONObject.optString("fallback_url"));
        ym2.Sj(jSONObject.optInt("fallback_type"));
        return ym2;
    }

    private static Map<String, Object> aa(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                hashMap.put(next, jSONObject.opt(next));
            }
        }
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
    
        if (r3 != 8) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int sP(com.bytedance.sdk.openadsdk.core.model.sU r8) {
        /*
            int r0 = r8.DKj()
            java.lang.String r0 = com.bytedance.sdk.openadsdk.utils.Mts.TKC(r0)
            int r1 = r8.AE()
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 != 0) goto L1c
            com.bytedance.sdk.openadsdk.core.model.Ym r1 = r8.TFd()
            int r1 = Sj(r1)
            com.bytedance.sdk.openadsdk.EjP.TKC.TKC(r8, r0, r1)
            goto L1d
        L1c:
            r1 = r2
        L1d:
            int r3 = r8.sdp()
            r4 = 2
            r5 = 406(0x196, float:5.69E-43)
            r6 = 417(0x1a1, float:5.84E-43)
            r7 = 407(0x197, float:5.7E-43)
            if (r3 == r4) goto L79
            r4 = 3
            if (r3 == r4) goto L79
            r4 = 4
            if (r3 == r4) goto L35
            r4 = 8
            if (r3 == r4) goto L79
            goto L8d
        L35:
            com.bytedance.sdk.openadsdk.core.model.EjP r3 = r8.tz()
            if (r3 != 0) goto L40
            com.bytedance.sdk.openadsdk.EjP.TKC.TKC(r8, r0, r7)
            r1 = r7
            goto L8d
        L40:
            java.lang.String r4 = r3.TKC()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L59
            java.lang.String r4 = r3.Sj()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L59
            com.bytedance.sdk.openadsdk.EjP.TKC.TKC(r8, r0, r6)
            r1 = r6
            goto L8d
        L59:
            java.lang.String r4 = r3.TKC()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L69
            r1 = 416(0x1a0, float:5.83E-43)
            com.bytedance.sdk.openadsdk.EjP.TKC.TKC(r8, r0, r1)
            goto L8d
        L69:
            java.lang.String r3 = r3.Sj()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L8d
            r1 = 408(0x198, float:5.72E-43)
            com.bytedance.sdk.openadsdk.EjP.TKC.TKC(r8, r0, r1)
            goto L8d
        L79:
            boolean r3 = EjP(r8)
            if (r3 == 0) goto L8d
            java.lang.String r3 = r8.Chv()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L8d
            com.bytedance.sdk.openadsdk.EjP.TKC.TKC(r8, r0, r5)
            r1 = r5
        L8d:
            if (r1 == r6) goto L9a
            if (r1 == r7) goto L9a
            if (r1 != r5) goto L94
            goto L9a
        L94:
            if (r1 == r2) goto L99
            com.bytedance.sdk.openadsdk.EjP.TKC.sP(r8, r0, r1)
        L99:
            return r2
        L9a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.sP.sP(com.bytedance.sdk.openadsdk.core.model.sU):int");
    }

    public static AdSlot sP(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("mCodeId", "");
        int optInt = jSONObject.optInt("mImgAcceptedWidth", 0);
        int optInt2 = jSONObject.optInt("mImgAcceptedHeight", 0);
        float optDouble = (float) jSONObject.optDouble("mExpressViewAcceptedWidth", 0.0d);
        float optDouble2 = (float) jSONObject.optDouble("mExpressViewAcceptedHeight", 0.0d);
        int optInt3 = jSONObject.optInt("mAdCount", 6);
        boolean optBoolean = jSONObject.optBoolean("mSupportDeepLink", true);
        String optString2 = jSONObject.optString("mRewardName", "");
        int optInt4 = jSONObject.optInt("mRewardAmount", 0);
        String optString3 = jSONObject.optString("mMediaExtra", "");
        String optString4 = jSONObject.optString("mUserID", "");
        jSONObject.optInt("mOrientation", 2);
        int optInt5 = jSONObject.optInt("mNativeAdType", 0);
        boolean optBoolean2 = jSONObject.optBoolean("mIsAutoPlay", false);
        boolean optBoolean3 = jSONObject.optBoolean("mIsExpressAd", false);
        String optString5 = jSONObject.optString("mBidAdm", "");
        return new AdSlot.Builder().setCodeId(optString).setImageAcceptedSize(optInt, optInt2).setExpressViewAcceptedSize(optDouble, optDouble2).setAdCount(optInt3).setSupportDeepLink(optBoolean).setRewardName(optString2).setRewardAmount(optInt4).setMediaExtra(optString3).setUserID(optString4).setNativeAdType(optInt5).setIsAutoPlay(optBoolean2).isExpressAd(optBoolean3).withBid(optString5).setDurationSlotType(jSONObject.optInt("mDurationSlotType", 0)).build();
    }

    private static com.bytedance.sdk.openadsdk.core.model.vS uA(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.vS vSVar = new com.bytedance.sdk.openadsdk.core.model.vS();
        if (jSONObject == null) {
            vSVar.TKC(0);
            vSVar.EjP(0);
            vSVar.sP(new ArrayList());
            vSVar.HiB(0);
            vSVar.Sj(new ArrayList());
            vSVar.sP(0);
            vSVar.Sj(0);
            return vSVar;
        }
        vSVar.TKC(jSONObject.optInt("interceptor_x", 0));
        vSVar.EjP(jSONObject.optInt("interceptor_y", 0));
        JSONArray optJSONArray = jSONObject.optJSONArray("interceptor_page");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                arrayList.add(Integer.valueOf(optJSONArray.optInt(i11)));
            }
        }
        vSVar.sP(arrayList);
        vSVar.HiB(jSONObject.optInt("interceptor_interval_time", 0));
        JSONArray optJSONArray2 = jSONObject.optJSONArray("url_regular");
        ArrayList arrayList2 = new ArrayList();
        if (optJSONArray2 != null) {
            for (int i12 = 0; i12 < optJSONArray2.length(); i12++) {
                arrayList2.add(optJSONArray2.optString(i12));
            }
        }
        vSVar.Sj(arrayList2);
        vSVar.sP(jSONObject.optInt("boc_index", 0));
        vSVar.Sj(jSONObject.optInt("is_act", 0));
        return vSVar;
    }

    @Nullable
    private static com.bytedance.sdk.openadsdk.core.model.EjP vS(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.model.EjP ejP = new com.bytedance.sdk.openadsdk.core.model.EjP();
        ejP.sP(jSONObject.optString("app_name"));
        ejP.TKC(jSONObject.optString("package_name"));
        ejP.Sj(jSONObject.optString("download_url"));
        ejP.Sj(jSONObject.optDouble("score", -1.0d));
        ejP.Sj(jSONObject.optInt("comment_num", -1));
        ejP.sP(jSONObject.optInt(CampaignEx.JSON_KEY_APP_SIZE, 0));
        ejP.EjP(jSONObject.optString("app_category"));
        return ejP;
    }
}

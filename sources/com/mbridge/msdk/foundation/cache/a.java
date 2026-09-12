package com.mbridge.msdk.foundation.cache;

import android.text.TextUtils;
import be.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.j;
import com.mbridge.msdk.foundation.tools.i0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.z0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    private static String f35016e = "BaseCandidateCache";

    /* renamed from: f, reason: collision with root package name */
    public static int f35017f = 4;

    /* renamed from: a, reason: collision with root package name */
    protected com.mbridge.msdk.foundation.db.c f35018a;

    /* renamed from: b, reason: collision with root package name */
    private JSONArray f35019b;

    /* renamed from: c, reason: collision with root package name */
    private JSONObject f35020c;

    /* renamed from: d, reason: collision with root package name */
    private String f35021d;

    /* renamed from: com.mbridge.msdk.foundation.cache.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C0480a implements Comparator<b> {
        C0480a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            return Double.compare(bVar.f35024b, bVar2.f35024b);
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private com.mbridge.msdk.foundation.cache.b f35023a;

        /* renamed from: b, reason: collision with root package name */
        private double f35024b;

        public b(double d11, com.mbridge.msdk.foundation.cache.b bVar) {
            this.f35024b = d11;
            this.f35023a = bVar;
        }

        public com.mbridge.msdk.foundation.cache.b a() {
            return this.f35023a;
        }
    }

    private String a(String str, int i11, String str2, String str3) {
        if (TextUtils.isEmpty(str) || str.contains("ca_sce") || str.contains("real_rid") || str.contains("real_bp")) {
            return str;
        }
        if (z0.c(str) > 0) {
            return str + "&ca_sce=" + i11 + "&real_rid=" + str2 + "&real_bp=" + str3;
        }
        return str + "?ca_sce=" + i11 + "&real_rid=" + str2 + "&real_bp=" + str3;
    }

    private String a(Map<Integer, String> map, int i11, String str, String str2) {
        if (map == null || map.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                String value = entry.getValue();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(CampaignEx.JSON_AD_IMP_KEY, entry.getKey());
                jSONObject.put("url", a(value, i11, str, str2));
                jSONArray.put(jSONObject);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return jSONArray.toString();
    }

    private List<String> a(List<String> list, int i11, String str, String str2) {
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < list.size(); i12++) {
            arrayList.add(a(list.get(i12), i11, str, str2));
        }
        return arrayList;
    }

    private String[] a(String[] strArr, int i11, String str, String str2) {
        if (strArr == null || strArr.length == 0) {
            return strArr;
        }
        String[] strArr2 = new String[strArr.length];
        for (int i12 = 0; i12 < strArr.length; i12++) {
            strArr2[i12] = a(strArr[i12], i11, str, str2);
        }
        return strArr2;
    }

    private List<Map<Integer, String>> b(List<Map<Integer, String>> list, int i11, String str, String str2) {
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < list.size(); i12++) {
            Map<Integer, String> map = list.get(i12);
            if (map != null && map.size() > 0) {
                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    map.put(entry.getKey(), a(entry.getValue(), i11, str, str2));
                }
                arrayList.add(map);
            }
        }
        return arrayList;
    }

    public long a(List<CampaignEx> list, String str) {
        if (list == null || list.size() == 0) {
            return 0L;
        }
        String ecppv = list.get(0).getEcppv();
        if (TextUtils.isEmpty(ecppv)) {
            return 0L;
        }
        String a11 = i0.a(ecppv);
        if (TextUtils.isEmpty(a11)) {
            return 0L;
        }
        try {
            if (Double.parseDouble(a11) <= 0.0d) {
                return 0L;
            }
            JSONObject c11 = c(d(str));
            int optInt = c11 != null ? c11.optInt("max_cache_num", 20) : 20;
            com.mbridge.msdk.foundation.db.c cVar = this.f35018a;
            if (cVar == null || optInt <= 0) {
                return -1L;
            }
            return cVar.a(list, this.f35021d);
        } catch (Exception e11) {
            e11.printStackTrace();
            return -1L;
        }
    }

    public c a() {
        JSONArray jSONArray;
        c cVar = new c();
        try {
            jSONArray = this.f35019b;
        } catch (Exception unused) {
            cVar.d("checkConfigAndDB exception");
            cVar.a(c.f35037k);
        }
        if (jSONArray != null && jSONArray.length() != 0) {
            if (this.f35018a == null) {
                cVar.d("db error");
                cVar.a(c.f35037k);
                return cVar;
            }
            return cVar;
        }
        cVar.d("setting config is null");
        cVar.a(c.f35035i);
        return cVar;
    }

    public c a(String str) {
        c cVar = new c();
        if (TextUtils.isEmpty(str) || str.split("_").length <= 3 || TextUtils.isEmpty(str.split("_")[3])) {
            cVar.d("bid token exception");
            cVar.a(c.f35035i);
            return cVar;
        }
        JSONArray jSONArray = this.f35019b;
        if (jSONArray == null || jSONArray.length() == 0) {
            cVar.d("config is empty");
            cVar.a(c.f35035i);
            return cVar;
        }
        String a11 = i0.a(str.split("_")[3]);
        if (TextUtils.isEmpty(a11)) {
            cVar.d("bid token exception:decode error");
            cVar.a(c.f35035i);
            return cVar;
        }
        String[] split = a11.split("\\|");
        if (split.length == 0) {
            cVar.d("bid token can not get bid price");
            cVar.a(c.f35035i);
            return cVar;
        }
        if (split.length > 0) {
            try {
                Double.parseDouble(split[0]);
            } catch (Exception unused) {
                cVar.d("bid token can not cast bid price");
                cVar.a(c.f35035i);
                return cVar;
            }
        }
        if (TextUtils.isEmpty(this.f35021d)) {
            cVar.d("unitId is empty");
            cVar.a(c.f35037k);
        }
        return cVar;
    }

    public List<com.mbridge.msdk.foundation.cache.b> a(int i11, long j11) {
        if (i11 >= 0) {
            a(i11);
        }
        com.mbridge.msdk.foundation.db.c cVar = this.f35018a;
        if (cVar != null) {
            return cVar.a(this.f35021d, j11);
        }
        return null;
    }

    public void a(int i11) {
        com.mbridge.msdk.foundation.db.c cVar = this.f35018a;
        if (cVar != null) {
            cVar.a(this.f35021d, i11);
            a(f35017f, 1, null, true, "", "", i11, this.f35021d);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0188 A[Catch: Exception -> 0x002c, TryCatch #1 {Exception -> 0x002c, blocks: (B:3:0x0011, B:6:0x0031, B:8:0x0069, B:11:0x0079, B:13:0x007f, B:17:0x0086, B:19:0x0091, B:22:0x0098, B:24:0x009e, B:26:0x00a6, B:28:0x0104, B:32:0x0108, B:36:0x0113, B:39:0x0119, B:42:0x011f, B:44:0x012d, B:46:0x0131, B:48:0x0140, B:50:0x0146, B:52:0x014e, B:54:0x0169, B:57:0x016c, B:59:0x0180, B:61:0x0188, B:62:0x018d, B:69:0x0178), top: B:2:0x0011, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(int r17, int r18, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r19, boolean r20, java.lang.String r21, java.lang.String r22, int r23, java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 415
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.cache.a.a(int, int, java.util.List, boolean, java.lang.String, java.lang.String, int, java.lang.String):void");
    }

    public void a(String str, String str2, int i11, String str3) {
        try {
            if (this.f35018a == null || TextUtils.isEmpty(str3)) {
                return;
            }
            if (i11 == 1) {
                this.f35018a.a(str2, str, this.f35021d, i11);
                a(f35017f, 3, null, true, str2, str, -1, this.f35021d);
            } else if (i11 == 2) {
                this.f35018a.a(this.f35021d, str2, str);
                a(f35017f, 1, null, true, str2, str, -1, this.f35021d);
            } else if (i11 == 3) {
                this.f35018a.b(str2, str, this.f35021d);
                a(f35017f, 4, null, true, str2, str, -1, this.f35021d);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void a(List<b> list, int i11) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    Collections.sort(list, new C0480a());
                    int size = list.size() - i11;
                    if (size > 0) {
                        List<b> subList = list.subList(0, size);
                        if (this.f35018a == null || subList.size() <= 0) {
                            return;
                        }
                        for (int i12 = 0; i12 < subList.size(); i12++) {
                            com.mbridge.msdk.foundation.cache.b bVar = subList.get(i12).f35023a;
                            this.f35018a.a(this.f35021d, bVar.e(), bVar.d());
                            a(f35017f, 1, null, true, bVar.e(), bVar.d(), -1, this.f35021d);
                        }
                    }
                }
            } catch (Exception e11) {
                o0.a(f35016e, e11);
            }
        }
    }

    public void a(List<CampaignEx> list, com.mbridge.msdk.foundation.same.report.metrics.c cVar, String str, int i11, String str2, int i12, double d11) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (int i13 = 0; i13 < list.size(); i13++) {
                        CampaignEx campaignEx = list.get(i13);
                        campaignEx.setReadyState(0);
                        if (cVar != null) {
                            campaignEx.setNLRid(cVar.o());
                        }
                        campaignEx.setNRid(str);
                        campaignEx.setReasond(str2);
                        campaignEx.setTyped(i11);
                        String b11 = i0.b(d11 + "");
                        campaignEx.setNoticeUrl(a(campaignEx.getNoticeUrl(), i12, str, b11));
                        campaignEx.setClickURL(a(campaignEx.getClickURL(), i12, str, b11));
                        campaignEx.setImpressionURL(a(campaignEx.getImpressionURL(), i12, str, b11));
                        campaignEx.setOnlyImpressionURL(a(campaignEx.getOnlyImpressionURL(), i12, str, b11));
                        campaignEx.setAdvImp(a(campaignEx.getAdvImpList(), i12, str, b11));
                        j nativeVideoTracking = campaignEx.getNativeVideoTracking();
                        if (nativeVideoTracking != null) {
                            nativeVideoTracking.d(a(nativeVideoTracking.d(), i12, str, b11));
                            nativeVideoTracking.c(a(nativeVideoTracking.c(), i12, str, b11));
                            nativeVideoTracking.k(a(nativeVideoTracking.k(), i12, str, b11));
                            nativeVideoTracking.s(a(nativeVideoTracking.t(), i12, str, b11));
                            nativeVideoTracking.a(a(nativeVideoTracking.a(), i12, str, b11));
                            nativeVideoTracking.b(a(nativeVideoTracking.b(), i12, str, b11));
                            nativeVideoTracking.e(a(nativeVideoTracking.e(), i12, str, b11));
                            nativeVideoTracking.t(a(nativeVideoTracking.u(), i12, str, b11));
                            nativeVideoTracking.u(a(nativeVideoTracking.u(), i12, str, b11));
                            nativeVideoTracking.v(a(nativeVideoTracking.w(), i12, str, b11));
                            nativeVideoTracking.f(a(nativeVideoTracking.f(), i12, str, b11));
                            nativeVideoTracking.g(a(nativeVideoTracking.g(), i12, str, b11));
                            nativeVideoTracking.h(a(nativeVideoTracking.h(), i12, str, b11));
                            nativeVideoTracking.i(a(nativeVideoTracking.i(), i12, str, b11));
                            nativeVideoTracking.j(a(nativeVideoTracking.j(), i12, str, b11));
                            nativeVideoTracking.l(a(nativeVideoTracking.l(), i12, str, b11));
                            nativeVideoTracking.q(a(nativeVideoTracking.r(), i12, str, b11));
                            nativeVideoTracking.m(a(nativeVideoTracking.m(), i12, str, b11));
                            nativeVideoTracking.r(a(nativeVideoTracking.s(), i12, str, b11));
                            nativeVideoTracking.n(a(nativeVideoTracking.n(), i12, str, b11));
                            nativeVideoTracking.a(b(nativeVideoTracking.o(), i12, str, b11));
                            nativeVideoTracking.p(a(nativeVideoTracking.q(), i12, str, b11));
                            nativeVideoTracking.o(a(nativeVideoTracking.p(), i12, str, b11));
                            campaignEx.setNativeVideoTracking(nativeVideoTracking);
                            campaignEx.setNativeVideoTrackingString(CampaignEx.object2TrackingStr(nativeVideoTracking));
                        }
                        campaignEx.setPv_urls(a(campaignEx.getPv_urls(), i12, str, b11));
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public void a(JSONArray jSONArray) {
        this.f35019b = jSONArray;
    }

    public double b(String str) {
        c a11 = a(str);
        if (a11 != null && a11.g() != c.f35037k && a11.g() != c.f35035i) {
            try {
                String[] split = i0.a(str.split("_")[3]).split("\\|");
                if (split.length > 0) {
                    return Double.parseDouble(split[0]);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return -1.0d;
    }

    public JSONObject c(String str) {
        JSONArray jSONArray = this.f35019b;
        if (jSONArray == null) {
            return null;
        }
        if (jSONArray.length() <= 1) {
            return this.f35019b.optJSONObject(0);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i11 = 0; i11 < this.f35019b.length(); i11++) {
            try {
                JSONObject optJSONObject = this.f35019b.optJSONObject(i11);
                if (optJSONObject != null && str.equals(optJSONObject.getString(g.f16474b))) {
                    this.f35020c = optJSONObject;
                    return optJSONObject;
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return null;
    }

    public String d(String str) {
        c a11 = a(str);
        if (a11 != null && a11.g() != c.f35037k && a11.g() != c.f35035i) {
            String[] split = i0.a(str.split("_")[3]).split("\\|");
            if (split.length > 1) {
                return split[1];
            }
        }
        return "";
    }

    public void e(String str) {
        this.f35021d = str;
    }
}

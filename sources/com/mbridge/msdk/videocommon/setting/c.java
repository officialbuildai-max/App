package com.mbridge.msdk.videocommon.setting;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.i0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class c {
    private static g W;
    public static String X;
    private int E;
    private int G;
    private JSONArray U;
    private JSONObject V;

    /* renamed from: a, reason: collision with root package name */
    private String f40043a;

    /* renamed from: b, reason: collision with root package name */
    private String f40044b;

    /* renamed from: c, reason: collision with root package name */
    private List<com.mbridge.msdk.videocommon.entity.b> f40045c;

    /* renamed from: d, reason: collision with root package name */
    private long f40046d;

    /* renamed from: t, reason: collision with root package name */
    private ArrayList<Integer> f40062t;

    /* renamed from: e, reason: collision with root package name */
    private int f40047e = -1;

    /* renamed from: f, reason: collision with root package name */
    private int f40048f = 0;

    /* renamed from: g, reason: collision with root package name */
    private int f40049g = 0;

    /* renamed from: h, reason: collision with root package name */
    private int f40050h = 1;

    /* renamed from: i, reason: collision with root package name */
    private int f40051i = 1;

    /* renamed from: j, reason: collision with root package name */
    private int f40052j = 1;

    /* renamed from: k, reason: collision with root package name */
    private int f40053k = 1;

    /* renamed from: l, reason: collision with root package name */
    private int f40054l = 5;

    /* renamed from: m, reason: collision with root package name */
    private int f40055m = 1;

    /* renamed from: n, reason: collision with root package name */
    private int f40056n = 3;

    /* renamed from: o, reason: collision with root package name */
    private int f40057o = 80;

    /* renamed from: p, reason: collision with root package name */
    private int f40058p = 100;

    /* renamed from: q, reason: collision with root package name */
    private int f40059q = 0;

    /* renamed from: r, reason: collision with root package name */
    private double f40060r = 1.0d;

    /* renamed from: s, reason: collision with root package name */
    private int f40061s = -1;

    /* renamed from: u, reason: collision with root package name */
    private int f40063u = 3;

    /* renamed from: v, reason: collision with root package name */
    private int f40064v = 1;

    /* renamed from: w, reason: collision with root package name */
    private int f40065w = 100;

    /* renamed from: x, reason: collision with root package name */
    private int f40066x = 60;

    /* renamed from: y, reason: collision with root package name */
    private int f40067y = 0;

    /* renamed from: z, reason: collision with root package name */
    private int f40068z = 70;
    private int A = 0;
    private int B = -1;
    private int C = -1;
    private int D = -1;
    private int F = 20;
    private int H = 0;
    private int I = 1;
    private String J = "";
    private int K = 1;
    private String L = "";
    private int M = 1;
    private String N = "Virtual Item";
    private String O = "";
    private String P = "";
    private int Q = 0;
    private int R = 1;
    private int S = 60;
    private String T = "";

    public static c a(String str) {
        JSONObject optJSONObject;
        if (W == null) {
            W = g.a(com.mbridge.msdk.foundation.controller.c.m().d());
        }
        c cVar = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("vtag", "");
                String optString2 = jSONObject.optString("rid", "");
                JSONArray optJSONArray = jSONObject.optJSONArray("unitSetting");
                if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                    return null;
                }
                String optString3 = optJSONObject.optString("unitId");
                if (TextUtils.isEmpty(optString3)) {
                    return null;
                }
                c cVar2 = new c();
                try {
                    cVar2.j(optString);
                    cVar2.g(optString2);
                    List<com.mbridge.msdk.videocommon.entity.b> a11 = com.mbridge.msdk.videocommon.entity.b.a(optJSONObject.optJSONArray("adSourceList"));
                    cVar2.h(optString3);
                    cVar2.a(a11);
                    cVar2.h(optJSONObject.optInt("callbackType"));
                    int optInt = optJSONObject.optInt("aqn", 1);
                    if (optInt <= 0) {
                        optInt = 1;
                    }
                    cVar2.e(optInt);
                    int optInt2 = optJSONObject.optInt("acn", 1);
                    if (optInt2 < 0) {
                        optInt2 = 1;
                    }
                    cVar2.b(optInt2);
                    cVar2.E(optJSONObject.optInt("vcn", 5));
                    cVar2.u(optJSONObject.optInt("offset", 5));
                    cVar2.n(optJSONObject.optInt("dlnet", 1));
                    cVar2.o(optJSONObject.optInt("endscreen_type", 2));
                    cVar2.D(optJSONObject.optInt("tv_start", 3));
                    cVar2.C(optJSONObject.optInt("tv_end", 80));
                    cVar2.y(optJSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100));
                    cVar2.i(optJSONObject.optInt("cd_rate", 0));
                    cVar2.a(jSONObject.optLong("current_time"));
                    cVar2.A(optJSONObject.optInt("orientation", 0));
                    cVar2.m(optJSONObject.optInt("daily_play_cap", 0));
                    cVar2.I(optJSONObject.optInt("video_skip_time", -1));
                    cVar2.H(optJSONObject.optInt("video_skip_result", 2));
                    cVar2.G(optJSONObject.optInt("video_interactive_type", -1));
                    cVar2.k(optJSONObject.optInt("close_button_delay", 1));
                    cVar2.w(optJSONObject.optInt("playclosebtn_tm", -1));
                    cVar2.v(optJSONObject.optInt("play_ctdown", 0));
                    cVar2.j(optJSONObject.optInt("close_alert", 0));
                    cVar2.x(optJSONObject.optInt("rdrct", 20));
                    cVar2.p(optJSONObject.optInt("load_global_timeout", 70));
                    cVar2.z(optJSONObject.optInt("rfpv", -1));
                    cVar2.a(optJSONObject.optDouble("vdcmp", 1.0d));
                    cVar2.c(optJSONObject.optString("atzu"));
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("atl_type");
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    try {
                        if (optJSONArray2 != null) {
                            for (int i11 = 0; i11 < optJSONArray2.length(); i11++) {
                                arrayList.add(Integer.valueOf(optJSONArray2.getInt(i11)));
                            }
                        } else {
                            arrayList.add(4);
                            arrayList.add(6);
                        }
                        cVar2.a(arrayList);
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                    int optInt3 = optJSONObject.optInt("atl_dyt", 0);
                    cVar2.f(optInt3 > 0 ? optInt3 : 3);
                    int optInt4 = optJSONObject.optInt("tmorl", 1);
                    if (optInt4 > 2 || optInt4 <= 0) {
                        optInt4 = 1;
                    }
                    cVar2.B(optInt4);
                    cVar2.f(optJSONObject.optString("placementid"));
                    cVar2.s(optJSONObject.optInt("ltafemty", 10));
                    cVar2.t(optJSONObject.optInt("ltorwc", 60));
                    cVar2.b(optJSONObject.optString("ab_id"));
                    cVar2.d(optJSONObject.optInt(RewardPlus.AMOUNT_MAX, 0));
                    cVar2.g(optJSONObject.optInt(RewardPlus.CALLBACK_RULE, 1));
                    cVar2.i(optJSONObject.optString(RewardPlus.VIRTUAL_CURRENCY, ""));
                    cVar2.c(optJSONObject.optInt(RewardPlus.AMOUNT, 1));
                    cVar2.d(optJSONObject.optString(RewardPlus.ICON, ""));
                    cVar2.l(optJSONObject.optInt(RewardPlus.CURRENCY_ID, 1));
                    cVar2.e(optJSONObject.optString("name", "Virtual Item"));
                    cVar2.F(optJSONObject.optInt("video_error_rule", 1));
                    cVar2.r(optJSONObject.optInt("loadtmo", 60));
                    cVar2.a(optJSONObject.optJSONArray("local_cache_info"));
                    try {
                        String optString4 = optJSONObject.optString("retry_strategy");
                        if (!TextUtils.isEmpty(optString4)) {
                            String a12 = i0.a(optString4);
                            if (!TextUtils.isEmpty(a12)) {
                                cVar2.b(new JSONObject(a12));
                            }
                        }
                    } catch (Exception unused) {
                    }
                    return cVar2;
                } catch (Exception e12) {
                    e = e12;
                    cVar = cVar2;
                    e.printStackTrace();
                    return cVar;
                }
            } catch (Exception e13) {
                e = e13;
            }
        }
        return cVar;
    }

    public static c a(JSONObject jSONObject) {
        c cVar;
        c cVar2 = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            cVar = new c();
        } catch (Exception e11) {
            e = e11;
        }
        try {
            cVar.a(com.mbridge.msdk.videocommon.entity.b.a(jSONObject.optJSONArray("adSourceList")));
            cVar.h(jSONObject.optInt("callbackType"));
            int optInt = jSONObject.optInt("aqn", 1);
            if (optInt <= 0) {
                optInt = 1;
            }
            cVar.e(optInt);
            int optInt2 = jSONObject.optInt("acn", 1);
            if (optInt2 < 0) {
                optInt2 = 1;
            }
            cVar.b(optInt2);
            cVar.E(jSONObject.optInt("vcn", 5));
            cVar.u(jSONObject.optInt("offset", 5));
            cVar.n(jSONObject.optInt("dlnet", 1));
            cVar.o(jSONObject.optInt("endscreen_type", 2));
            cVar.D(jSONObject.optInt("tv_start", 3));
            cVar.C(jSONObject.optInt("tv_end", 80));
            cVar.y(jSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100));
            cVar.a(jSONObject.optLong("current_time"));
            cVar.A(jSONObject.optInt("orientation", 0));
            cVar.m(jSONObject.optInt("daily_play_cap", 0));
            cVar.I(jSONObject.optInt("video_skip_time", -1));
            cVar.H(jSONObject.optInt("video_skip_result", 2));
            cVar.G(jSONObject.optInt("video_interactive_type", -1));
            cVar.k(jSONObject.optInt("close_button_delay", 1));
            cVar.w(jSONObject.optInt("playclosebtn_tm", -1));
            cVar.v(jSONObject.optInt("play_ctdown", 0));
            cVar.j(jSONObject.optInt("close_alert", 0));
            cVar.x(jSONObject.optInt("rdrct", 20));
            cVar.z(jSONObject.optInt("rfpv", -1));
            cVar.a(jSONObject.optDouble("vdcmp", 1.0d));
            cVar.p(jSONObject.optInt("load_global_timeout", 70));
            JSONArray optJSONArray = jSONObject.optJSONArray("atl_type");
            ArrayList<Integer> arrayList = new ArrayList<>();
            try {
                if (optJSONArray != null) {
                    for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                        arrayList.add(Integer.valueOf(optJSONArray.getInt(i11)));
                    }
                } else {
                    arrayList.add(4);
                    arrayList.add(6);
                }
                cVar.a(arrayList);
            } catch (Exception e12) {
                e12.printStackTrace();
            }
            cVar.f(jSONObject.optInt("atl_dyt", 3));
            int optInt3 = jSONObject.optInt("tmorl", 1);
            if (optInt3 > 2 || optInt3 <= 0) {
                optInt3 = 1;
            }
            cVar.B(optInt3);
            cVar.f(jSONObject.optString("placementid"));
            cVar.s(jSONObject.optInt("ltafemty", 10));
            cVar.t(jSONObject.optInt("ltorwc", 60));
            cVar.b(jSONObject.optString("ab_id"));
            cVar.g(jSONObject.optString("rid", ""));
            cVar.d(jSONObject.optInt(RewardPlus.AMOUNT_MAX, 0));
            cVar.g(jSONObject.optInt(RewardPlus.CALLBACK_RULE, 1));
            cVar.i(jSONObject.optString(RewardPlus.VIRTUAL_CURRENCY, ""));
            cVar.c(jSONObject.optInt(RewardPlus.AMOUNT, 1));
            cVar.d(jSONObject.optString(RewardPlus.ICON, ""));
            cVar.l(jSONObject.optInt(RewardPlus.CURRENCY_ID, 1));
            cVar.e(jSONObject.optString("name", "Virtual Item"));
            cVar.F(jSONObject.optInt("video_error_rule", 1));
            cVar.r(jSONObject.optInt("loadtmo", 60));
            cVar.j(jSONObject.optString("vtag", ""));
            cVar.a(jSONObject.optJSONArray("local_cache_info"));
            try {
                String optString = jSONObject.optString("retry_strategy");
                if (!TextUtils.isEmpty(optString)) {
                    String a11 = i0.a(optString);
                    if (!TextUtils.isEmpty(a11)) {
                        cVar.b(new JSONObject(a11));
                    }
                }
            } catch (Exception unused) {
            }
            return cVar;
        } catch (Exception e13) {
            e = e13;
            cVar2 = cVar;
            e.printStackTrace();
            return cVar2;
        }
    }

    public int A() {
        return this.f40064v;
    }

    public void A(int i11) {
        this.f40067y = i11;
    }

    public JSONArray B() {
        return this.U;
    }

    public void B(int i11) {
        this.f40064v = i11;
    }

    public int C() {
        return this.R;
    }

    public void C(int i11) {
        this.f40057o = i11;
    }

    public int D() {
        return this.D;
    }

    public void D(int i11) {
        this.f40056n = i11;
    }

    public int E() {
        return this.C;
    }

    public void E(int i11) {
        this.f40053k = i11;
    }

    public int F() {
        return this.B;
    }

    public void F(int i11) {
        this.R = i11;
    }

    public String G() {
        return this.T;
    }

    public void G(int i11) {
        this.D = i11;
    }

    public JSONObject H() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("unitId", this.f40043a);
            jSONObject.put("callbackType", this.f40050h);
            List<com.mbridge.msdk.videocommon.entity.b> list = this.f40045c;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (com.mbridge.msdk.videocommon.entity.b bVar : this.f40045c) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", bVar.a());
                    jSONObject2.put("timeout", bVar.b());
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("adSourceList", jSONArray);
            }
            jSONObject.put("aqn", this.f40051i);
            jSONObject.put("acn", this.f40052j);
            jSONObject.put("vcn", this.f40053k);
            jSONObject.put("offset", this.f40054l);
            jSONObject.put("dlnet", this.f40055m);
            jSONObject.put("tv_start", this.f40056n);
            jSONObject.put("tv_end", this.f40057o);
            jSONObject.put(CampaignEx.JSON_KEY_READY_RATE, this.f40058p);
            jSONObject.put("endscreen_type", this.G);
            jSONObject.put("daily_play_cap", this.A);
            jSONObject.put("video_skip_time", this.B);
            jSONObject.put("video_skip_result", this.C);
            jSONObject.put("video_interactive_type", this.D);
            jSONObject.put("orientation", this.f40067y);
            jSONObject.put("close_button_delay", this.E);
            jSONObject.put("playclosebtn_tm", this.f40047e);
            jSONObject.put("play_ctdown", this.f40048f);
            jSONObject.put("close_alert", this.f40049g);
            jSONObject.put("rfpv", this.f40061s);
            jSONObject.put("vdcmp", this.f40060r);
            JSONArray jSONArray2 = new JSONArray();
            ArrayList<Integer> arrayList = this.f40062t;
            if (arrayList != null) {
                if (arrayList.size() > 0) {
                    Iterator<Integer> it = this.f40062t.iterator();
                    while (it.hasNext()) {
                        jSONArray2.put(it.next());
                    }
                }
                jSONObject.put("atl_type", jSONArray2);
            }
            jSONObject.put("atl_dyt", this.f40063u);
            jSONObject.put("tmorl", this.f40064v);
            jSONObject.put("placementid", this.f40044b);
            jSONObject.put("ltafemty", this.f40065w);
            jSONObject.put("ltorwc", this.f40066x);
            jSONObject.put(RewardPlus.AMOUNT_MAX, this.H);
            jSONObject.put(RewardPlus.CALLBACK_RULE, this.I);
            jSONObject.put(RewardPlus.VIRTUAL_CURRENCY, this.J);
            jSONObject.put(RewardPlus.AMOUNT, this.K);
            jSONObject.put(RewardPlus.ICON, this.L);
            jSONObject.put(RewardPlus.CURRENCY_ID, this.M);
            jSONObject.put("name", this.N);
            jSONObject.put("isDefault", this.Q);
            jSONObject.put("video_error_rule", this.R);
            jSONObject.put("loadtmo", this.S);
            jSONObject.put("vtag", this.T);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }

    public void H(int i11) {
        this.C = i11;
    }

    public void I(int i11) {
        this.B = i11;
    }

    public String a() {
        return this.O;
    }

    public void a(double d11) {
        this.f40060r = d11;
    }

    public void a(long j11) {
        this.f40046d = j11;
    }

    public void a(ArrayList<Integer> arrayList) {
        this.f40062t = arrayList;
    }

    public void a(List<com.mbridge.msdk.videocommon.entity.b> list) {
        this.f40045c = list;
    }

    public void a(JSONArray jSONArray) {
        this.U = jSONArray;
    }

    public boolean a(int i11) {
        ArrayList<Integer> arrayList = this.f40062t;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return this.f40062t.contains(Integer.valueOf(i11));
    }

    public int b() {
        return this.f40052j;
    }

    public void b(int i11) {
        this.f40052j = i11;
    }

    public void b(String str) {
        this.O = str;
        com.mbridge.msdk.foundation.controller.a.f35048r.put(this.f40043a, str);
    }

    public void b(JSONObject jSONObject) {
        this.V = jSONObject;
    }

    public String c() {
        return X;
    }

    public void c(int i11) {
        if (i11 <= 0) {
            this.K = 1;
        } else {
            this.K = i11;
        }
    }

    public void c(String str) {
        X = str;
    }

    public int d() {
        return this.K;
    }

    public void d(int i11) {
        this.H = i11;
    }

    public void d(String str) {
        this.L = str;
    }

    public int e() {
        return this.f40051i;
    }

    public void e(int i11) {
        this.f40051i = i11;
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            this.N = this.J;
        } else {
            this.N = str;
        }
    }

    public int f() {
        return this.f40063u;
    }

    public void f(int i11) {
        this.f40063u = i11;
    }

    public void f(String str) {
        this.f40044b = str;
    }

    public int g() {
        return this.f40059q;
    }

    public void g(int i11) {
        this.I = i11;
    }

    public void g(String str) {
        this.P = str;
    }

    public int h() {
        return this.f40049g;
    }

    public void h(int i11) {
        this.f40050h = i11;
    }

    public void h(String str) {
        this.f40043a = str;
    }

    public int i() {
        return this.E;
    }

    public void i(int i11) {
        this.f40059q = i11;
    }

    public void i(String str) {
        this.J = str;
    }

    public long j() {
        return this.f40046d;
    }

    public void j(int i11) {
        this.f40049g = i11;
    }

    public void j(String str) {
        this.T = str;
    }

    public int k() {
        return this.A;
    }

    public void k(int i11) {
        this.E = i11;
    }

    public int l() {
        return this.f40055m;
    }

    public void l(int i11) {
        this.M = i11;
    }

    public int m() {
        return this.G;
    }

    public void m(int i11) {
        this.A = i11;
    }

    public int n() {
        return this.f40068z;
    }

    public void n(int i11) {
        this.f40055m = i11;
    }

    public int o() {
        return this.S;
    }

    public void o(int i11) {
        this.G = i11;
    }

    public int p() {
        return this.f40065w;
    }

    public void p(int i11) {
        this.f40068z = i11;
    }

    public int q() {
        return this.f40066x;
    }

    public void q(int i11) {
        this.Q = i11;
    }

    public int r() {
        return this.f40054l;
    }

    public void r(int i11) {
        this.S = i11;
    }

    public String s() {
        return this.N;
    }

    public void s(int i11) {
        this.f40065w = i11;
    }

    public String t() {
        return this.f40044b;
    }

    public void t(int i11) {
        this.f40066x = i11;
    }

    public int u() {
        return this.f40047e;
    }

    public void u(int i11) {
        this.f40054l = i11;
    }

    public int v() {
        return this.F;
    }

    public void v(int i11) {
        this.f40048f = i11;
    }

    public int w() {
        return this.f40058p;
    }

    public void w(int i11) {
        this.f40047e = i11;
    }

    public String x() {
        return this.P;
    }

    public void x(int i11) {
        this.F = i11;
    }

    public int y() {
        return this.f40067y;
    }

    public void y(int i11) {
        this.f40058p = i11;
    }

    public Queue<Integer> z() {
        LinkedList linkedList;
        Exception e11;
        List<com.mbridge.msdk.videocommon.entity.b> list;
        try {
            list = this.f40045c;
        } catch (Exception e12) {
            linkedList = null;
            e11 = e12;
        }
        if (list == null || list.size() <= 0) {
            return null;
        }
        linkedList = new LinkedList();
        for (int i11 = 0; i11 < this.f40045c.size(); i11++) {
            try {
                linkedList.add(Integer.valueOf(this.f40045c.get(i11).b()));
            } catch (Exception e13) {
                e11 = e13;
                e11.printStackTrace();
                return linkedList;
            }
        }
        return linkedList;
    }

    public void z(int i11) {
        this.f40061s = i11;
    }
}

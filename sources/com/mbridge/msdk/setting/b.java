package com.mbridge.msdk.setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.aliyun.player.BuildConfig;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.b0;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.i0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.y0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: c1, reason: collision with root package name */
    public static int f37267c1 = 1500;
    private boolean D0;
    private long F;
    private JSONArray F0;
    private JSONObject G0;
    private ArrayList<Integer> H;
    private d I;
    private long I0;
    private C0537b J;
    private long N0;
    private HashMap<String, String> O;
    private boolean O0;
    private String P;
    private int U;
    private String U0;
    private String X;
    private Map<String, String> Y;

    /* renamed from: a1, reason: collision with root package name */
    private int f37270a1;

    /* renamed from: b1, reason: collision with root package name */
    private String f37273b1;

    /* renamed from: h0, reason: collision with root package name */
    private int f37285h0;

    /* renamed from: k0, reason: collision with root package name */
    private String f37291k0;

    /* renamed from: l, reason: collision with root package name */
    private int f37292l;

    /* renamed from: l0, reason: collision with root package name */
    private String f37293l0;

    /* renamed from: n, reason: collision with root package name */
    private List<com.mbridge.msdk.foundation.entity.a> f37296n;

    /* renamed from: o0, reason: collision with root package name */
    private int f37299o0;

    /* renamed from: p, reason: collision with root package name */
    private long f37300p;

    /* renamed from: p0, reason: collision with root package name */
    private int f37301p0;

    /* renamed from: q, reason: collision with root package name */
    private com.mbridge.msdk.setting.a f37302q;

    /* renamed from: q0, reason: collision with root package name */
    private int f37303q0;

    /* renamed from: r, reason: collision with root package name */
    private String f37304r;

    /* renamed from: r0, reason: collision with root package name */
    private int f37305r0;

    /* renamed from: s, reason: collision with root package name */
    private Map<String, a> f37306s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f37308t;

    /* renamed from: u, reason: collision with root package name */
    private int f37310u;

    /* renamed from: u0, reason: collision with root package name */
    private long f37311u0;

    /* renamed from: v0, reason: collision with root package name */
    private long f37313v0;

    /* renamed from: a, reason: collision with root package name */
    private boolean f37268a = false;

    /* renamed from: b, reason: collision with root package name */
    private JSONArray f37271b = new JSONArray();

    /* renamed from: c, reason: collision with root package name */
    private JSONArray f37274c = new JSONArray();

    /* renamed from: d, reason: collision with root package name */
    private String f37276d = "";

    /* renamed from: e, reason: collision with root package name */
    private int f37278e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f37280f = 0;

    /* renamed from: g, reason: collision with root package name */
    private int f37282g = 2;

    /* renamed from: h, reason: collision with root package name */
    private int f37284h = 0;

    /* renamed from: i, reason: collision with root package name */
    private String f37286i = "";

    /* renamed from: j, reason: collision with root package name */
    private String f37288j = "";

    /* renamed from: k, reason: collision with root package name */
    private String f37290k = "";

    /* renamed from: m, reason: collision with root package name */
    private int f37294m = 0;

    /* renamed from: o, reason: collision with root package name */
    private int f37298o = 0;

    /* renamed from: v, reason: collision with root package name */
    private int f37312v = 1;

    /* renamed from: w, reason: collision with root package name */
    private boolean f37314w = false;

    /* renamed from: x, reason: collision with root package name */
    private String f37316x = "";

    /* renamed from: y, reason: collision with root package name */
    private String f37318y = "";

    /* renamed from: z, reason: collision with root package name */
    private String f37320z = "";
    private String A = "";
    private String B = "";
    private int C = 120;
    private String D = com.mbridge.msdk.foundation.same.net.utils.d.h().f35530i;
    private String E = com.mbridge.msdk.foundation.same.net.utils.d.h().f35534m;
    private int G = f37267c1;
    private int K = 0;
    private long L = 86400;
    private int M = 0;
    private int N = 3;
    private boolean Q = true;
    private int R = 0;
    private boolean S = false;
    private boolean T = false;
    private int V = 0;
    private int W = 0;
    private String Z = BuildConfig.VERSION_NAME;

    /* renamed from: a0, reason: collision with root package name */
    private int f37269a0 = 30;

    /* renamed from: b0, reason: collision with root package name */
    private int f37272b0 = 9377;

    /* renamed from: c0, reason: collision with root package name */
    private int f37275c0 = 0;

    /* renamed from: d0, reason: collision with root package name */
    private int f37277d0 = 5;

    /* renamed from: e0, reason: collision with root package name */
    private int f37279e0 = 1;

    /* renamed from: f0, reason: collision with root package name */
    private int f37281f0 = 8000;

    /* renamed from: g0, reason: collision with root package name */
    private String f37283g0 = "";

    /* renamed from: i0, reason: collision with root package name */
    private int f37287i0 = 10;

    /* renamed from: j0, reason: collision with root package name */
    private int f37289j0 = 120;

    /* renamed from: m0, reason: collision with root package name */
    private String f37295m0 = "";

    /* renamed from: n0, reason: collision with root package name */
    private String f37297n0 = "";

    /* renamed from: s0, reason: collision with root package name */
    private String f37307s0 = "";

    /* renamed from: t0, reason: collision with root package name */
    private String f37309t0 = "";

    /* renamed from: w0, reason: collision with root package name */
    private List<Integer> f37315w0 = new ArrayList();

    /* renamed from: x0, reason: collision with root package name */
    private int f37317x0 = 3;

    /* renamed from: y0, reason: collision with root package name */
    private int f37319y0 = 0;

    /* renamed from: z0, reason: collision with root package name */
    private int f37321z0 = 3;
    private int A0 = 0;
    private int B0 = 10;
    private int C0 = 600;
    private int E0 = 0;
    private String H0 = "";
    private int J0 = 8000;
    private int K0 = 1;
    private long L0 = 10;
    private int M0 = 3;
    private int P0 = 1;
    private int Q0 = 1;
    private int R0 = 1;
    private int S0 = 1;
    private String T0 = "";
    private int V0 = 1300;
    private int W0 = 0;
    private int X0 = 0;
    private long Y0 = 3600;
    private String Z0 = "";

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private List<String> f37322a;

        /* renamed from: b, reason: collision with root package name */
        private List<String> f37323b;

        /* renamed from: c, reason: collision with root package name */
        private List<String> f37324c;

        /* renamed from: d, reason: collision with root package name */
        private List<String> f37325d;

        public List<String> a() {
            return this.f37322a;
        }

        public void a(JSONObject jSONObject) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("x");
                if (optJSONArray != null) {
                    this.f37324c = b0.a(optJSONArray);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("y");
                if (optJSONArray2 != null) {
                    this.f37325d = b0.a(optJSONArray2);
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("width");
                if (optJSONArray3 != null) {
                    this.f37323b = b0.a(optJSONArray3);
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("height");
                if (optJSONArray4 != null) {
                    this.f37322a = b0.a(optJSONArray4);
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
            }
        }

        public List<String> b() {
            return this.f37323b;
        }

        public List<String> c() {
            return this.f37324c;
        }

        public List<String> d() {
            return this.f37325d;
        }
    }

    /* renamed from: com.mbridge.msdk.setting.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0537b {

        /* renamed from: a, reason: collision with root package name */
        private String f37326a;

        /* renamed from: b, reason: collision with root package name */
        private JSONArray f37327b;

        /* renamed from: c, reason: collision with root package name */
        private String f37328c;

        /* renamed from: d, reason: collision with root package name */
        private String f37329d;

        /* renamed from: e, reason: collision with root package name */
        private String f37330e;

        /* renamed from: f, reason: collision with root package name */
        private String f37331f;

        public static C0537b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            C0537b c0537b = new C0537b();
            Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
            c0537b.f37331f = jSONObject.optString(CampaignEx.JSON_KEY_TITLE, d11.getString(g0.a(d11, "mbridge_cm_feedback_dialog_title", "string")));
            c0537b.f37326a = jSONObject.optString("cancel", d11.getString(g0.a(d11, "mbridge_cm_feedback_dialog_close_close", "string")));
            c0537b.f37329d = jSONObject.optString("submit", d11.getString(g0.a(d11, "mbridge_cm_feedback_dialog_close_submit", "string")));
            c0537b.f37330e = jSONObject.optString("submit_notice", d11.getString(g0.a(d11, "mbridge_cm_feedback_dialog_submit_notice", "string")));
            c0537b.f37328c = jSONObject.optString("privacy", d11.getString(g0.a(d11, "mbridge_cm_feedback_dialog_privacy_des", "string")));
            JSONArray optJSONArray = jSONObject.optJSONArray("content");
            c0537b.f37327b = optJSONArray;
            if (optJSONArray == null) {
                JSONArray jSONArray = new JSONArray();
                c0537b.f37327b = jSONArray;
                jSONArray.put(d11.getString(g0.a(d11, "mbridge_cm_feedback_dialog_content_not_play", "string")));
                c0537b.f37327b.put(d11.getString(g0.a(d11, "mbridge_cm_feedback_dialog_content_sound_problems", "string")));
                c0537b.f37327b.put(d11.getString(g0.a(d11, "mbridge_cm_feedback_dialog_content_misleading", "string")));
                c0537b.f37327b.put(d11.getString(g0.a(d11, "mbridge_cm_feedback_dialog_content_fraud", "string")));
                c0537b.f37327b.put(d11.getString(g0.a(d11, "mbridge_cm_feedback_dialog_content_por_violence", "string")));
                c0537b.f37327b.put(d11.getString(g0.a(d11, "mbridge_cm_feedback_dialog_content_other", "string")));
            }
            return c0537b;
        }

        public String a() {
            return this.f37326a;
        }

        public JSONArray b() {
            return this.f37327b;
        }

        public String c() {
            return this.f37328c;
        }

        public String d() {
            return this.f37329d;
        }

        public String e() {
            return this.f37330e;
        }

        public String f() {
            return this.f37331f;
        }
    }

    public static String a(Context context, String str) {
        try {
            g d11 = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            if (d11 != null && d11.G() != null) {
                String host = Uri.parse(str).getHost();
                Iterator<Map.Entry<String, String>> it = d11.G().entrySet().iterator();
                while (it.hasNext()) {
                    String key = it.next().getKey();
                    if (!TextUtils.isEmpty(host) && host.contains(key)) {
                        String str2 = d11.G().get(key);
                        return TextUtils.isEmpty(str2) ? "" : str2.replace("{gaid}", com.mbridge.msdk.foundation.tools.f.d());
                    }
                }
                return "";
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static Map<String, a> a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                a aVar = new a();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                if (optJSONObject != null) {
                    aVar.a(optJSONObject);
                }
                hashMap.put(next, aVar);
            }
            return hashMap;
        } catch (JSONException e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
            return null;
        } catch (Exception e12) {
            if (MBridgeConstans.DEBUG) {
                e12.printStackTrace();
            }
            return null;
        }
    }

    private static void a(JSONObject jSONObject) {
        FastKV fastKV = null;
        if (com.mbridge.msdk.foundation.controller.d.a().e()) {
            try {
                fastKV = new FastKV.Builder(com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_CONFIG), i0.a("H+tU+FeXHM==")).build();
            } catch (Exception unused) {
            }
        }
        if (fastKV != null) {
            try {
                Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
                if (jSONObject == null || d11 == null) {
                    return;
                }
                String optString = jSONObject.optString(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
                if (!TextUtils.isEmpty(optString) && !TextUtils.equals(com.mbridge.msdk.foundation.same.a.V, optString)) {
                    com.mbridge.msdk.foundation.same.a.V = optString;
                    com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.V);
                    try {
                        fastKV.putString(i0.a("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.V);
                    } catch (Exception unused2) {
                    }
                }
                String optString2 = jSONObject.optString("c");
                if (TextUtils.isEmpty(optString2) || TextUtils.equals(com.mbridge.msdk.foundation.same.a.f35389g, optString2)) {
                    return;
                }
                com.mbridge.msdk.foundation.same.a.f35389g = optString2;
                com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("c", com.mbridge.msdk.foundation.same.a.f35389g);
                try {
                    fastKV.putString(i0.a("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.f35389g);
                    return;
                } catch (Exception unused3) {
                    return;
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                return;
            }
        }
        try {
            Context d12 = com.mbridge.msdk.foundation.controller.c.m().d();
            if (jSONObject == null || d12 == null) {
                return;
            }
            String optString3 = jSONObject.optString(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
            if (!TextUtils.isEmpty(optString3) && !TextUtils.equals(com.mbridge.msdk.foundation.same.a.V, optString3)) {
                com.mbridge.msdk.foundation.same.a.V = optString3;
                com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.V);
                SharedPreferences sharedPreferences = d12.getSharedPreferences(i0.a("H+tU+FeXHM=="), 0);
                if (sharedPreferences != null) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString(i0.a("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.V);
                    edit.apply();
                }
            }
            String optString4 = jSONObject.optString("c");
            if (TextUtils.isEmpty(optString4) || TextUtils.equals(com.mbridge.msdk.foundation.same.a.f35389g, optString4)) {
                return;
            }
            com.mbridge.msdk.foundation.same.a.f35389g = optString4;
            com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("c", com.mbridge.msdk.foundation.same.a.f35389g);
            SharedPreferences sharedPreferences2 = d12.getSharedPreferences(i0.a("H+tU+FeXHM=="), 0);
            if (sharedPreferences2 != null) {
                SharedPreferences.Editor edit2 = sharedPreferences2.edit();
                edit2.putString(i0.a("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.f35389g);
                edit2.apply();
            }
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static g b(JSONObject jSONObject) {
        g gVar = null;
        r7 = null;
        ArrayList arrayList = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            g gVar2 = new g();
            try {
                gVar2.c(jSONObject);
                gVar2.f(jSONObject.optString("cc"));
                gVar2.s(jSONObject.optString("mv_wildcard", "<mvpackage>mbridge</mvpackage>"));
                gVar2.j(jSONObject.optInt("cfc"));
                gVar2.c(jSONObject.optLong("getpf"));
                gVar2.b(jSONObject.optLong("current_time"));
                gVar2.b(jSONObject.optBoolean("cfb"));
                gVar2.a(jSONObject.optLong("awct"));
                gVar2.e(jSONObject.optLong(CampaignEx.JSON_KEY_PLCT) == 0 ? 3600L : jSONObject.optLong(CampaignEx.JSON_KEY_PLCT));
                gVar2.g(jSONObject.optBoolean("rurl"));
                gVar2.i(jSONObject.optLong("uct"));
                gVar2.h(jSONObject.optBoolean("ujds"));
                gVar2.G(jSONObject.optInt("n2"));
                gVar2.H(jSONObject.optInt("n3"));
                gVar2.r(jSONObject.optInt("is_startup_crashsystem", 1));
                gVar2.F(jSONObject.optInt("pcrn"));
                gVar2.f(jSONObject.optLong(CampaignEx.JSON_KEY_PLCTB) == 0 ? 7200L : jSONObject.optLong(CampaignEx.JSON_KEY_PLCTB));
                gVar2.F(jSONObject.optInt("pcrn", 100));
                gVar2.E(jSONObject.optInt("opent", 1));
                gVar2.g(jSONObject.optLong("sfct", 1800L));
                gVar2.U(jSONObject.optInt("upgd", 1));
                gVar2.V(jSONObject.optInt("upsrl", 1));
                gVar2.T(jSONObject.optInt("updevid", 1));
                gVar2.O(jSONObject.optInt("sc", 0));
                gVar2.S(jSONObject.optInt("up_tips", 1));
                gVar2.s(jSONObject.optInt("iseu", -1));
                gVar2.p(jSONObject.optString("jm_unit"));
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("atf");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        arrayList = new ArrayList();
                        for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                            String optString = optJSONArray.optString(i11);
                            if (y0.b(optString)) {
                                JSONObject jSONObject2 = new JSONObject(optString);
                                arrayList.add(new com.mbridge.msdk.foundation.entity.a(jSONObject2.optInt("adtype"), jSONObject2.optString("unitid")));
                            }
                        }
                    }
                    if (arrayList != null) {
                        gVar2.a((List<com.mbridge.msdk.foundation.entity.a>) arrayList);
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                gVar2.g(jSONObject.optInt("adct", 259200));
                gVar2.k(jSONObject.optString("confirm_title", ""));
                gVar2.i(jSONObject.optString("confirm_description", ""));
                gVar2.j(jSONObject.optString("confirm_t", ""));
                gVar2.h(jSONObject.optString("confirm_c_rv", ""));
                gVar2.g(jSONObject.optString("confirm_c_play", ""));
                gVar2.c(jSONObject.optString("adchoice_icon", ""));
                gVar2.d(jSONObject.optString("adchoice_link", ""));
                gVar2.e(jSONObject.optString("adchoice_size", ""));
                gVar2.w(jSONObject.optString("platform_logo", ""));
                gVar2.x(jSONObject.optString("platform_name", ""));
                gVar2.a(a(jSONObject.optString("cdnate_cfg", "")));
                gVar2.i(jSONObject.optInt("atrqt", 0));
                gVar2.t(jSONObject.optInt("iupdid", 0));
                gVar2.C(jSONObject.optInt("mcs", 120));
                gVar2.b(jSONObject.optString("ab_id", ""));
                gVar2.y(jSONObject.optString("rid", ""));
                gVar2.q(jSONObject.optString("log_rate", TmcConstants.COLD_OPEN_TYPE));
                gVar2.v(jSONObject.optString("omsdkjs_url", ""));
                gVar2.u(jSONObject.optString("omsdkjs_h5_url", ""));
                gVar2.J(jSONObject.optInt("rty_tk_clk", 0));
                gVar2.L(jSONObject.optInt("rty_tk_imp", 0));
                gVar2.K(jSONObject.optInt("rty_cnt", 3));
                gVar2.N(jSONObject.optInt("rty_to", 600));
                gVar2.M(jSONObject.optInt("rty_inr", 10));
                gVar2.n(jSONObject.optString("dns"));
                gVar2.v(jSONObject.optString("omsdkjs_url", ""));
                gVar2.u(jSONObject.optString("omsdkjs_h5_url", ""));
                long optLong = jSONObject.optLong("tcto");
                if (optLong == 0) {
                    gVar2.h(10L);
                } else {
                    gVar2.h(optLong);
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("jt");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        HashMap hashMap = new HashMap();
                        for (int i12 = 0; i12 < optJSONArray2.length(); i12++) {
                            JSONObject optJSONObject = optJSONArray2.optJSONObject(i12);
                            hashMap.put(optJSONObject.optString("domain"), optJSONObject.optString("format"));
                        }
                        gVar2.b(hashMap);
                    }
                }
                gVar2.r(jSONObject.optString("mraid_js"));
                gVar2.B(jSONObject.optString("web_env_url"));
                int optInt = jSONObject.optInt("alrbs", 0);
                if (optInt > 2 || optInt < 0) {
                    optInt = 0;
                }
                gVar2.h(optInt);
                gVar2.e(jSONObject.optBoolean("GDPR_area", false));
                gVar2.l(jSONObject.optInt("ct", 120));
                JSONArray optJSONArray3 = jSONObject.optJSONArray("ercd");
                if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                    ArrayList<Integer> arrayList2 = new ArrayList<>();
                    for (int i13 = 0; i13 < optJSONArray3.length(); i13++) {
                        int optInt2 = optJSONArray3.optInt(i13);
                        if (optInt2 != 0) {
                            arrayList2.add(Integer.valueOf(optInt2));
                        }
                    }
                    if (arrayList2.size() > 0) {
                        arrayList2.add(-1);
                        gVar2.a(arrayList2);
                    }
                }
                String optString2 = jSONObject.optString("hst");
                if (!TextUtils.isEmpty(optString2)) {
                    try {
                        JSONObject jSONObject3 = new JSONObject(i0.a(optString2));
                        Iterator<String> keys = jSONObject3.keys();
                        HashMap<String, String> hashMap2 = new HashMap<>();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(jSONObject3.optString(next)) && !TextUtils.isEmpty(i0.a(jSONObject3.optString(next)))) {
                                hashMap2.put(next, jSONObject3.optString(next));
                            }
                        }
                        if (hashMap2.size() > 0) {
                            gVar2.a(hashMap2);
                        }
                    } catch (Exception e12) {
                        o0.b("SETTING", e12.getMessage());
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("refactor_switch");
                if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                    for (int i14 = 0; i14 < optJSONArray4.length(); i14++) {
                        JSONObject jSONObject4 = optJSONArray4.getJSONObject(i14);
                        Iterator<String> keys2 = jSONObject4.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            if (!TextUtils.isEmpty(next2) && jSONObject4.getBoolean(next2)) {
                                gVar2.a(Integer.parseInt(next2));
                            }
                        }
                    }
                }
                try {
                    int optInt3 = jSONObject.optInt("lqcnt", 30);
                    int optInt4 = jSONObject.optInt("lqto", 5);
                    int optInt5 = jSONObject.optInt("lqswt", 0);
                    int optInt6 = jSONObject.optInt("lqtype", 1);
                    gVar2.x(optInt4);
                    gVar2.u(optInt3);
                    gVar2.w(optInt5);
                    gVar2.y(optInt6);
                    gVar2.a(jSONObject.optJSONArray("lg_bl"));
                    gVar2.b(jSONObject.optJSONArray("lg_wl"));
                    gVar2.X(jSONObject.optInt("lg_wl_rt"));
                    gVar2.P(jSONObject.optInt("srml", 8000));
                    gVar2.z(jSONObject.optInt("lrml", 8000));
                    gVar2.W(jSONObject.optInt("wgl_d_ms", 1300));
                    gVar2.m(jSONObject.optInt("dp_ct", f37267c1));
                    int parseInt = Integer.parseInt(i0.a(jSONObject.optString("lqpt")));
                    if (parseInt > 0 && parseInt < 65535) {
                        gVar2.v(parseInt);
                    }
                } catch (Exception unused) {
                }
                gVar2.Y(jSONObject.optInt("wvddt", 0));
                gVar2.l(jSONObject.optString("hst_st", ""));
                gVar2.m(jSONObject.optString("hst_st_t", ""));
                try {
                    int optInt7 = jSONObject.optInt("l", 3);
                    boolean z10 = jSONObject.optInt(CampaignEx.JSON_KEY_AD_K, 0) == 1;
                    boolean z11 = jSONObject.optInt("m", 1) == 1;
                    gVar2.I(optInt7);
                    gVar2.f(z10);
                    gVar2.a(z11);
                } catch (Exception e13) {
                    o0.b("Setting", e13.getMessage());
                }
                gVar2.n(jSONObject.optInt("fbk_swt", 0));
                gVar2.a(C0537b.a(jSONObject.optJSONObject("fbk")));
                try {
                    int optInt8 = jSONObject.optInt("ad_connection_timeout", com.mbridge.msdk.foundation.same.a.f35397o);
                    int optInt9 = jSONObject.optInt("ad_read_timeout", com.mbridge.msdk.foundation.same.a.f35399q);
                    int optInt10 = jSONObject.optInt("ad_write_timeout", com.mbridge.msdk.foundation.same.a.f35401s);
                    int optInt11 = jSONObject.optInt("ad_retry_count", com.mbridge.msdk.foundation.same.a.f35400r);
                    if (optInt8 <= 0) {
                        optInt8 = com.mbridge.msdk.foundation.same.a.f35397o;
                    }
                    gVar2.c(optInt8);
                    if (optInt9 <= 0) {
                        optInt9 = com.mbridge.msdk.foundation.same.a.f35399q;
                    }
                    gVar2.d(optInt9);
                    if (optInt10 <= 0) {
                        optInt10 = com.mbridge.msdk.foundation.same.a.f35401s;
                    }
                    gVar2.f(optInt10);
                    if (optInt11 < 0) {
                        optInt11 = com.mbridge.msdk.foundation.same.a.f35400r;
                    }
                    gVar2.e(optInt11);
                    int optInt12 = jSONObject.optInt("max_download_task_size", 10);
                    if (optInt12 <= 0) {
                        optInt12 = 10;
                    }
                    gVar2.B(optInt12);
                    gVar2.A(jSONObject.optInt("max_bitmap_cache_size", 10));
                    gVar2.R(jSONObject.optInt("t_t", 3));
                    gVar2.p(jSONObject.optInt("h_t", 3));
                    gVar2.o(jSONObject.optInt("gtp"));
                    gVar2.d(jSONObject.optLong("i_i_t", 3600L));
                    gVar2.t(jSONObject.optString(com.mbridge.msdk.foundation.entity.b.JSON_KEY_C_I, ""));
                    gVar2.D(jSONObject.optInt("n_c_u_p", 0));
                } catch (Exception unused2) {
                }
                try {
                    gVar2.o(jSONObject.optString("http_track_url", ""));
                } catch (Exception unused3) {
                }
                gVar2.Q(jSONObject.optInt("st_net", 1));
                gVar2.A(jSONObject.optString("vtag", ""));
                try {
                    gVar2.c(jSONObject.optInt("check_webview", 0) != 0);
                } catch (Exception unused4) {
                    gVar2.c(false);
                }
                gVar2.z(jSONObject.optString("swxid"));
                gVar2.c(jSONObject.optJSONArray("sdk_filters"));
                try {
                    gVar2.k(jSONObject.optInt("ch_nv_im_cb", 1));
                } catch (Exception unused5) {
                    gVar2.k(1);
                }
                try {
                    gVar2.d(jSONObject.optInt("do_us_fi_re", 1) != 0);
                } catch (Exception unused6) {
                    gVar2.d(true);
                }
                try {
                    a(jSONObject);
                } catch (Exception e14) {
                    e14.printStackTrace();
                }
                String optString3 = jSONObject.optString("bcp");
                if (!TextUtils.isEmpty(optString3)) {
                    gVar2.a(com.mbridge.msdk.setting.a.a(i0.a(optString3)));
                }
                String optString4 = jSONObject.optString("monitor");
                if (!TextUtils.isEmpty(optString4)) {
                    gVar2.a(d.a(i0.a(optString4)));
                }
                return gVar2;
            } catch (Exception e15) {
                e = e15;
                gVar = gVar2;
                e.printStackTrace();
                return gVar;
            }
        } catch (Exception e16) {
            e = e16;
        }
    }

    public long A() {
        return this.L;
    }

    public void A(int i11) {
        if (i11 > 0) {
            this.f37287i0 = i11;
        }
    }

    public void A(String str) {
        this.T0 = str;
    }

    public boolean A0() {
        return this.Q;
    }

    public int B() {
        return this.N;
    }

    public void B(int i11) {
        this.f37285h0 = i11;
    }

    public void B(String str) {
        this.U0 = str;
    }

    public boolean B0() {
        return this.f37308t;
    }

    public HashMap<String, String> C() {
        return this.O;
    }

    public void C(int i11) {
        this.f37289j0 = i11;
    }

    public boolean C0() {
        return this.f37314w;
    }

    public int D() {
        return this.R;
    }

    public void D(int i11) {
        this.f37270a1 = i11;
    }

    public boolean D0() {
        return this.S;
    }

    public int E() {
        return this.U;
    }

    public void E(int i11) {
        this.f37299o0 = i11;
    }

    public boolean E0() {
        return this.f37268a;
    }

    public int F() {
        return this.V;
    }

    public void F(int i11) {
        this.f37301p0 = i11;
    }

    public boolean F0() {
        return (TextUtils.isEmpty(this.B) || TextUtils.isEmpty(this.f37320z) || TextUtils.isEmpty(this.A) || TextUtils.isEmpty(this.f37316x)) ? false : true;
    }

    public Map<String, String> G() {
        return this.Y;
    }

    public void G(int i11) {
        this.f37303q0 = i11;
    }

    public boolean G0() {
        return (TextUtils.isEmpty(this.B) || TextUtils.isEmpty(this.f37320z) || TextUtils.isEmpty(this.A) || TextUtils.isEmpty(this.f37318y)) ? false : true;
    }

    public JSONArray H() {
        return this.f37271b;
    }

    public void H(int i11) {
        this.f37305r0 = i11;
    }

    public boolean H0() {
        return this.T;
    }

    public JSONArray I() {
        return this.f37274c;
    }

    public void I(int i11) {
        this.f37317x0 = i11;
    }

    public boolean I0() {
        return this.D0;
    }

    public String J() {
        return this.Z;
    }

    public void J(int i11) {
        this.f37319y0 = i11;
    }

    public boolean J0() {
        return this.O0;
    }

    public int K() {
        return this.f37279e0;
    }

    public void K(int i11) {
        this.f37321z0 = i11;
    }

    public void K0() {
        String language = Locale.getDefault().getLanguage();
        if (!G0()) {
            if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                this.B = "Confirm to close? ";
                this.f37320z = "You will not be rewarded after closing the window";
                this.A = "Close it";
                this.f37318y = "Continue";
            } else {
                this.B = "确认关闭？";
                this.f37320z = "关闭后您将不会获得任何奖励噢~ ";
                this.A = "确认关闭";
                this.f37318y = "继续观看";
            }
        }
        if (F0()) {
            return;
        }
        if (TextUtils.isEmpty(language) || !language.equals("zh")) {
            this.B = "Confirm to close? ";
            this.f37320z = "You will not be rewarded after closing the window";
            this.A = "Close it";
            this.f37316x = "Continue";
            return;
        }
        this.B = "确认关闭？";
        this.f37320z = "关闭后您将不会获得任何奖励噢~ ";
        this.A = "确认关闭";
        this.f37316x = "继续试玩";
    }

    public int L() {
        return this.f37281f0;
    }

    public void L(int i11) {
        this.A0 = i11;
    }

    public int M() {
        return this.f37285h0;
    }

    public void M(int i11) {
        this.B0 = i11;
    }

    public int N() {
        return this.f37289j0;
    }

    public void N(int i11) {
        this.C0 = i11;
    }

    public String O() {
        return this.f37291k0;
    }

    public void O(int i11) {
        this.E0 = i11;
    }

    public String P() {
        return this.f37293l0;
    }

    public void P(int i11) {
        this.J0 = i11;
    }

    public String Q() {
        return this.Z0;
    }

    public void Q(int i11) {
        this.K0 = i11;
    }

    public long R() {
        return this.Y0;
    }

    public void R(int i11) {
        this.M0 = i11;
    }

    public int S() {
        return this.f37270a1;
    }

    public void S(int i11) {
        this.P0 = i11;
    }

    public String T() {
        return this.f37295m0;
    }

    public void T(int i11) {
        this.Q0 = i11;
    }

    public String U() {
        return this.f37297n0;
    }

    public void U(int i11) {
        this.R0 = i11;
    }

    public int V() {
        return this.f37299o0;
    }

    public void V(int i11) {
        this.S0 = i11;
    }

    public int W() {
        return this.f37301p0;
    }

    public void W(int i11) {
        this.V0 = i11;
    }

    public int X() {
        return this.f37303q0;
    }

    public void X(int i11) {
        this.W0 = i11;
    }

    public int Y() {
        return this.f37305r0;
    }

    public void Y(int i11) {
        this.X0 = i11;
    }

    public long Z() {
        return this.f37311u0;
    }

    public String a() {
        return this.f37276d;
    }

    public void a(int i11) {
        this.f37315w0.add(Integer.valueOf(i11));
    }

    public void a(long j11) {
        this.f37300p = j11;
    }

    public void a(com.mbridge.msdk.setting.a aVar) {
        this.f37302q = aVar;
    }

    public void a(C0537b c0537b) {
        this.J = c0537b;
    }

    public void a(d dVar) {
        this.I = dVar;
    }

    public void a(ArrayList<Integer> arrayList) {
        this.H = arrayList;
    }

    public void a(HashMap<String, String> hashMap) {
        this.O = hashMap;
    }

    public void a(List<com.mbridge.msdk.foundation.entity.a> list) {
        this.f37296n = list;
    }

    public void a(Map<String, a> map) {
        this.f37306s = map;
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray == null) {
            jSONArray = new JSONArray();
            jSONArray.put("2000088");
        }
        this.f37271b = jSONArray;
    }

    public void a(boolean z10) {
        this.Q = z10;
    }

    public long a0() {
        if (this.f37313v0 <= 0) {
            this.f37313v0 = 7200L;
        }
        return this.f37313v0;
    }

    public String b() {
        return this.f37286i;
    }

    public void b(long j11) {
        this.F = j11;
    }

    public void b(String str) {
        this.f37276d = str;
    }

    public void b(Map<String, String> map) {
        this.Y = map;
    }

    public void b(JSONArray jSONArray) {
        if (jSONArray == null) {
            jSONArray = new JSONArray();
            jSONArray.put("2000041");
            jSONArray.put("2000042");
            jSONArray.put("2000032");
            jSONArray.put("2000079");
        }
        this.f37274c = jSONArray;
    }

    public void b(boolean z10) {
        this.f37308t = z10;
    }

    public boolean b(int i11) {
        return this.f37315w0.contains(Integer.valueOf(i11));
    }

    public int b0() {
        return this.f37317x0;
    }

    public String c() {
        return this.f37288j;
    }

    public void c(int i11) {
        this.f37278e = i11;
    }

    public void c(long j11) {
        this.L = j11;
    }

    public void c(String str) {
        this.f37286i = str;
    }

    public void c(JSONArray jSONArray) {
        this.F0 = jSONArray;
    }

    public void c(JSONObject jSONObject) {
        this.G0 = jSONObject;
    }

    public void c(boolean z10) {
        this.f37314w = z10;
    }

    public int c0() {
        return this.f37319y0;
    }

    public String d() {
        return this.f37290k;
    }

    public void d(int i11) {
        this.f37280f = i11;
    }

    public void d(long j11) {
        this.Y0 = j11;
    }

    public void d(String str) {
        this.f37288j = str;
    }

    public void d(boolean z10) {
        this.S = z10;
    }

    public int d0() {
        return this.f37321z0;
    }

    public int e() {
        return this.f37292l;
    }

    public void e(int i11) {
        this.f37282g = i11;
    }

    public void e(long j11) {
        this.f37311u0 = j11;
    }

    public void e(String str) {
        this.f37290k = str;
    }

    public void e(boolean z10) {
        this.f37268a = z10;
    }

    public int e0() {
        return this.A0;
    }

    public int f() {
        return this.f37294m;
    }

    public void f(int i11) {
        this.f37284h = i11;
    }

    public void f(long j11) {
        this.f37313v0 = j11;
    }

    public void f(String str) {
        this.f37304r = str;
    }

    public void f(boolean z10) {
        this.T = z10;
    }

    public int f0() {
        return this.B0;
    }

    public List<com.mbridge.msdk.foundation.entity.a> g() {
        return this.f37296n;
    }

    public void g(int i11) {
        this.f37292l = i11;
    }

    public void g(long j11) {
        this.I0 = j11;
    }

    public void g(String str) {
        this.f37316x = str;
    }

    public void g(boolean z10) {
        this.D0 = z10;
    }

    public int g0() {
        return this.C0;
    }

    public int h() {
        return this.f37298o;
    }

    public void h(int i11) {
        this.f37294m = i11;
    }

    public void h(long j11) {
        this.L0 = j11;
    }

    public void h(String str) {
        this.f37318y = str;
    }

    public void h(boolean z10) {
        this.O0 = z10;
    }

    public int h0() {
        return this.E0;
    }

    public long i() {
        return this.f37300p;
    }

    public void i(int i11) {
        this.f37298o = i11;
    }

    public void i(long j11) {
        this.N0 = j11;
    }

    public void i(String str) {
        this.f37320z = str;
    }

    public JSONArray i0() {
        return this.F0;
    }

    public com.mbridge.msdk.setting.a j() {
        return this.f37302q;
    }

    public void j(int i11) {
        this.f37310u = i11;
    }

    public void j(String str) {
        this.A = str;
    }

    public JSONObject j0() {
        return this.G0;
    }

    public String k() {
        return this.f37304r;
    }

    public void k(int i11) {
        this.f37312v = i11;
    }

    public void k(String str) {
        this.B = str;
    }

    public String k0() {
        return this.H0;
    }

    public Map<String, a> l() {
        return this.f37306s;
    }

    public void l(int i11) {
        this.C = i11;
    }

    public void l(String str) {
        this.D = str;
    }

    public long l0() {
        return this.I0;
    }

    public int m() {
        return this.f37310u;
    }

    public void m(int i11) {
        this.G = i11;
        com.mbridge.msdk.click.utils.a.f34500c = i11;
    }

    public void m(String str) {
        this.E = str;
    }

    public int m0() {
        return this.J0;
    }

    public int n() {
        return this.f37312v;
    }

    public void n(int i11) {
        this.K = i11;
    }

    public void n(String str) {
        this.f37273b1 = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        e.a().b(i0.a(str));
    }

    public int n0() {
        return this.K0;
    }

    public String o() {
        return this.f37316x;
    }

    public void o(int i11) {
        this.M = i11;
        com.mbridge.msdk.foundation.same.net.utils.d.h().d(i11);
    }

    public void o(String str) {
        this.P = str;
    }

    public long o0() {
        return this.L0 * 1000;
    }

    public String p() {
        return this.f37318y;
    }

    public void p(int i11) {
        this.N = i11;
    }

    public void p(String str) {
        this.X = str;
    }

    public int p0() {
        return this.M0;
    }

    public String q() {
        return this.f37320z;
    }

    public void q(int i11) {
        this.R = i11;
    }

    public void q(String str) {
        this.Z = str;
    }

    public long q0() {
        return this.N0;
    }

    public String r() {
        return this.A;
    }

    public void r(int i11) {
        this.U = i11;
    }

    public void r(String str) {
        this.f37291k0 = str;
    }

    public int r0() {
        return this.P0;
    }

    public String s() {
        return this.B;
    }

    public void s(int i11) {
        this.V = i11;
    }

    public void s(String str) {
        this.f37293l0 = str;
    }

    public int s0() {
        return this.Q0;
    }

    public int t() {
        return this.C;
    }

    public void t(int i11) {
        this.W = i11;
    }

    public void t(String str) {
        this.Z0 = str;
    }

    public int t0() {
        return this.R0;
    }

    public String toString() {
        return " cfc=" + this.f37310u + " getpf=" + this.L + " rurl=" + this.D0;
    }

    public String u() {
        return this.D;
    }

    public void u(int i11) {
        this.f37269a0 = i11;
    }

    public void u(String str) {
        this.f37295m0 = str;
    }

    public int u0() {
        return this.S0;
    }

    public String v() {
        return this.E;
    }

    public void v(int i11) {
        this.f37272b0 = i11;
        com.mbridge.msdk.foundation.same.net.utils.d.h().b(i11);
        com.mbridge.msdk.foundation.same.net.utils.d.h().c(i11);
    }

    public void v(String str) {
        this.f37297n0 = str;
    }

    public String v0() {
        return this.T0;
    }

    public long w() {
        return this.F;
    }

    public void w(int i11) {
        this.f37275c0 = i11;
    }

    public void w(String str) {
        this.f37307s0 = str;
    }

    public String w0() {
        return this.U0;
    }

    public ArrayList<Integer> x() {
        return this.H;
    }

    public void x(int i11) {
        this.f37277d0 = i11;
    }

    public void x(String str) {
        this.f37309t0 = str;
    }

    public int x0() {
        return this.V0;
    }

    public d y() {
        return this.I;
    }

    public void y(int i11) {
        this.f37279e0 = i11;
    }

    public void y(String str) {
        this.H0 = str;
    }

    public int y0() {
        return this.W0;
    }

    public C0537b z() {
        return this.J;
    }

    public void z(int i11) {
        this.f37281f0 = i11;
    }

    public void z(String str) {
        if (TextUtils.isEmpty(this.f37283g0)) {
            return;
        }
        this.f37283g0 = str;
        if (TextUtils.isEmpty(com.mbridge.msdk.foundation.controller.c.m().i())) {
            com.mbridge.msdk.foundation.controller.c.m().d(this.f37283g0);
        }
    }

    public int z0() {
        return this.X0;
    }
}

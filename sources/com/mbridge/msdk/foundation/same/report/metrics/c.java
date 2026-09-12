package com.mbridge.msdk.foundation.same.report.metrics;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
public class c implements Serializable, Cloneable {
    private int A;
    private CampaignEx B;
    private CopyOnWriteArrayList<CampaignEx> C;

    /* renamed from: a, reason: collision with root package name */
    private boolean f35648a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, Map<String, String>> f35649b;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, Map<String, String>> f35650c;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, Long> f35651d;

    /* renamed from: e, reason: collision with root package name */
    private com.mbridge.msdk.foundation.error.b f35652e;

    /* renamed from: f, reason: collision with root package name */
    private String f35653f;

    /* renamed from: g, reason: collision with root package name */
    private CopyOnWriteArrayList<CampaignEx> f35654g;

    /* renamed from: h, reason: collision with root package name */
    private String f35655h;

    /* renamed from: i, reason: collision with root package name */
    private int f35656i;

    /* renamed from: j, reason: collision with root package name */
    private String f35657j;

    /* renamed from: k, reason: collision with root package name */
    private String f35658k;

    /* renamed from: l, reason: collision with root package name */
    private String f35659l;

    /* renamed from: m, reason: collision with root package name */
    private String f35660m;

    /* renamed from: n, reason: collision with root package name */
    private String f35661n;

    /* renamed from: o, reason: collision with root package name */
    private String f35662o;

    /* renamed from: p, reason: collision with root package name */
    private String f35663p;

    /* renamed from: q, reason: collision with root package name */
    private String f35664q;

    /* renamed from: r, reason: collision with root package name */
    private int f35665r;

    /* renamed from: s, reason: collision with root package name */
    private int f35666s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f35667t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f35668u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f35669v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f35670w;

    /* renamed from: x, reason: collision with root package name */
    private int f35671x;

    /* renamed from: y, reason: collision with root package name */
    private int f35672y;

    /* renamed from: z, reason: collision with root package name */
    private int f35673z;

    public c() {
        this.f35648a = false;
        this.f35649b = new HashMap();
        this.f35650c = new HashMap();
        this.f35651d = new HashMap();
        this.f35653f = "";
        this.f35654g = new CopyOnWriteArrayList<>();
        this.f35665r = -1;
        this.f35667t = false;
        this.f35669v = false;
        this.C = new CopyOnWriteArrayList<>();
    }

    public c(boolean z10) {
        this.f35648a = false;
        this.f35649b = new HashMap();
        this.f35650c = new HashMap();
        this.f35651d = new HashMap();
        this.f35653f = "";
        this.f35654g = new CopyOnWriteArrayList<>();
        this.f35665r = -1;
        this.f35667t = false;
        this.f35669v = false;
        this.C = new CopyOnWriteArrayList<>();
        this.f35648a = z10;
    }

    private void a(e eVar) {
        if ("2000126".equals(this.f35664q)) {
            String a11 = com.mbridge.msdk.foundation.same.net.d.a(f());
            if (eVar != null) {
                eVar.a("dns_ty", Integer.valueOf(com.mbridge.msdk.setting.e.a().a(a11)));
                eVar.a("dns_hs", a11);
            }
        }
    }

    public boolean A() {
        return this.f35668u;
    }

    public boolean B() {
        return this.f35648a;
    }

    public int a() {
        return this.f35656i;
    }

    public long a(String str) {
        Map<String, Long> map;
        try {
            if (TextUtils.isEmpty(str) || (map = this.f35651d) == null || !map.containsKey(str)) {
                return 0L;
            }
            Long l11 = this.f35651d.get(str);
            return System.currentTimeMillis() - (l11 != null ? l11.longValue() : 0L);
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return 0L;
            }
            e11.printStackTrace();
            return 0L;
        }
    }

    public void a(int i11) {
        this.f35656i = i11;
    }

    public void a(CampaignEx campaignEx) {
        this.B = campaignEx;
        if (campaignEx == null) {
            return;
        }
        try {
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.C;
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                int i11 = 0;
                while (true) {
                    if (i11 >= this.C.size()) {
                        break;
                    }
                    if (this.C.get(i11) != null && this.C.get(i11).getId().equals(campaignEx.getId())) {
                        this.C.set(i11, campaignEx);
                        break;
                    }
                    i11++;
                }
            }
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = this.f35654g;
            if (copyOnWriteArrayList2 == null || copyOnWriteArrayList2.isEmpty()) {
                return;
            }
            for (int i12 = 0; i12 < this.f35654g.size(); i12++) {
                if (this.f35654g.get(i12) != null && this.f35654g.get(i12).getId().equals(campaignEx.getId())) {
                    this.f35654g.set(i12, campaignEx);
                    return;
                }
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public void a(com.mbridge.msdk.foundation.error.b bVar) {
        this.f35652e = bVar;
    }

    public void a(String str, e eVar) {
        Map<String, String> map;
        if (TextUtils.isEmpty(str) || eVar == null) {
            return;
        }
        try {
            String str2 = this.f35653f + str;
            Map<String, Map<String, String>> map2 = this.f35649b;
            if (map2 != null) {
                if (!map2.containsKey(str2) || (map = this.f35649b.get(str2)) == null) {
                    this.f35649b.put(str2, eVar.a());
                } else {
                    map.putAll(eVar.a());
                }
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public void a(List<CampaignEx> list) {
        if (list != null) {
            try {
                if (list.isEmpty()) {
                    return;
                }
                if (!this.f35654g.isEmpty()) {
                    this.f35654g.clear();
                }
                this.f35654g.addAll(list);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
            }
        }
    }

    public void a(boolean z10) {
        this.f35667t = z10;
    }

    public int b() {
        return this.f35671x;
    }

    public Map<String, String> b(String str) {
        com.mbridge.msdk.foundation.error.b p11;
        com.mbridge.msdk.foundation.error.b p12;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        e eVar = new e();
        try {
            this.f35664q = str;
            eVar.a("ts", Long.valueOf(System.currentTimeMillis()));
            if (!TextUtils.isEmpty(w())) {
                eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, w());
            }
            if (this.f35656i != 0) {
                eVar.a("adtp", Integer.valueOf(a()));
            }
            if (!TextUtils.isEmpty(n())) {
                eVar.a(CampaignEx.JSON_KEY_HB, n());
            }
            if (!TextUtils.isEmpty(f())) {
                eVar.a("bid_tk", f());
            }
            if (!TextUtils.isEmpty(str)) {
                eVar.a("key", str);
            }
            if (Arrays.asList(b.f35635a).contains(str)) {
                eVar.a("from_cache", y() ? "1" : "2");
            }
            if ("2000047".contains(str) && (p12 = p()) != null) {
                eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, Integer.valueOf(p12.c()));
                eVar.a("reason", p12.g());
                if (!TextUtils.isEmpty(p12.h())) {
                    eVar.a("reason_d", p12.h());
                    eVar.a("type_d", Integer.valueOf(p12.i()));
                }
            }
            if ("2000048".contains(str) && (p11 = p()) != null && !TextUtils.isEmpty(p11.h())) {
                eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, Integer.valueOf(p11.i()));
                eVar.a("reason", p11.h());
            }
            if (this.f35656i == 296) {
                eVar.a("auto_load", c());
                eVar.a("auto_refresh", Integer.valueOf(b()));
                eVar.a("auto_refresh_interval", Integer.valueOf(e()));
                eVar.a("content_type", Integer.valueOf(k()));
                eVar.a("temp_display_type", Integer.valueOf(v()));
            }
            a(eVar);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
        return eVar.a();
    }

    public void b(int i11) {
        this.f35671x = i11;
    }

    public void b(List<CampaignEx> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    if (!this.C.isEmpty()) {
                        this.C.clear();
                    }
                    this.C.addAll(list);
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
            }
        }
    }

    public void b(boolean z10) {
        this.f35669v = z10;
    }

    public String c() {
        return this.f35663p;
    }

    public void c(int i11) {
        this.f35672y = i11;
    }

    public void c(String str) {
        if (this.f35651d == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f35651d.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public void c(boolean z10) {
        this.f35668u = z10;
    }

    @NonNull
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void d(int i11) {
        this.f35673z = i11;
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String str2 = this.f35653f + str;
            Map<String, Map<String, String>> map = this.f35649b;
            if (map == null || !map.containsKey(str2)) {
                return;
            }
            this.f35649b.remove(str2);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public void d(boolean z10) {
        this.f35670w = z10;
    }

    public int e() {
        return this.f35672y;
    }

    public void e(int i11) {
        this.f35665r = i11;
    }

    public void e(String str) {
        this.f35663p = str;
    }

    public String f() {
        return this.f35657j;
    }

    public void f(int i11) {
        this.f35666s = i11;
    }

    public void f(String str) {
        this.f35657j = str;
    }

    public List<CampaignEx> g() {
        return this.f35654g;
    }

    public void g(int i11) {
        this.A = i11;
    }

    public void g(String str) {
        this.f35662o = str;
    }

    public void h(String str) {
        this.f35653f = str;
    }

    public CampaignEx i() {
        return this.B;
    }

    public void i(String str) {
        this.f35664q = str;
    }

    public List<CampaignEx> j() {
        return this.C;
    }

    public void j(String str) {
        this.f35658k = str;
    }

    public int k() {
        return this.f35673z;
    }

    public void k(String str) {
        this.f35661n = str;
    }

    public int l() {
        return this.f35665r;
    }

    public void l(String str) {
        this.f35659l = str;
    }

    public int m() {
        return this.f35666s;
    }

    public void m(String str) {
        this.f35655h = str;
    }

    public String n() {
        return this.f35662o;
    }

    public void n(String str) {
        this.f35660m = str;
    }

    public String o() {
        return this.f35653f;
    }

    public com.mbridge.msdk.foundation.error.b p() {
        return this.f35652e;
    }

    public Map<String, Map<String, String>> q() {
        return this.f35650c;
    }

    public Map<String, Map<String, String>> r() {
        return this.f35649b;
    }

    public String s() {
        return this.f35658k;
    }

    public String t() {
        return this.f35661n;
    }

    public String u() {
        return this.f35659l;
    }

    public int v() {
        return this.A;
    }

    public String w() {
        Map<String, String> map;
        if (!TextUtils.isEmpty(this.f35655h)) {
            return this.f35655h;
        }
        try {
            if (TextUtils.isEmpty(this.f35655h)) {
                String str = this.f35653f + this.f35664q;
                Map<String, Map<String, String>> map2 = this.f35649b;
                if (map2 != null && map2.containsKey(str) && (map = this.f35649b.get(str)) != null && map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
                    this.f35655h = map.get(MBridgeConstans.PROPERTIES_UNIT_ID);
                }
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
        return this.f35655h;
    }

    public String x() {
        return this.f35660m;
    }

    public boolean y() {
        return this.f35667t;
    }

    public boolean z() {
        return this.f35669v;
    }
}

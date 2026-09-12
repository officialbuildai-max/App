package com.mbridge.msdk.mbnative.controller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.tmc.integration.ui.p001native.NativeImgComponent;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.entity.k;
import com.mbridge.msdk.foundation.same.c;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.nativex.view.MBMediaView;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.setting.j;
import com.mbridge.msdk.setting.l;
import com.mbridge.msdk.tracker.network.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class d extends com.mbridge.msdk.mbnative.controller.b {

    /* renamed from: r, reason: collision with root package name */
    private static final String f36397r = "d";

    /* renamed from: s, reason: collision with root package name */
    private static Map<String, Map<Long, Object>> f36398s = new HashMap();

    /* renamed from: t, reason: collision with root package name */
    private static Map<String, Boolean> f36399t = new HashMap();

    /* renamed from: u, reason: collision with root package name */
    private static Map<String, k> f36400u = new HashMap();

    /* renamed from: v, reason: collision with root package name */
    private static Map<String, Integer> f36401v = new HashMap();

    /* renamed from: w, reason: collision with root package name */
    private static Map<String, Integer> f36402w = new HashMap();

    /* renamed from: x, reason: collision with root package name */
    private static d f36403x = null;

    /* renamed from: y, reason: collision with root package name */
    private static int f36404y = -1;

    /* renamed from: z, reason: collision with root package name */
    private static int f36405z = -2;

    /* renamed from: b, reason: collision with root package name */
    private j f36406b;

    /* renamed from: c, reason: collision with root package name */
    private com.mbridge.msdk.click.a f36407c;

    /* renamed from: d, reason: collision with root package name */
    private l f36408d;

    /* renamed from: e, reason: collision with root package name */
    private String f36409e;

    /* renamed from: i, reason: collision with root package name */
    private Map<String, Object> f36413i;

    /* renamed from: j, reason: collision with root package name */
    private List<Integer> f36414j;

    /* renamed from: k, reason: collision with root package name */
    protected List<Integer> f36415k;

    /* renamed from: l, reason: collision with root package name */
    private List<Integer> f36416l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f36417m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f36418n;

    /* renamed from: o, reason: collision with root package name */
    private int f36419o;

    /* renamed from: p, reason: collision with root package name */
    private int f36420p;

    /* renamed from: f, reason: collision with root package name */
    Queue<Integer> f36410f = null;

    /* renamed from: g, reason: collision with root package name */
    Queue<Long> f36411g = null;

    /* renamed from: h, reason: collision with root package name */
    private int f36412h = 0;

    /* renamed from: q, reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.task.b f36421q = new com.mbridge.msdk.foundation.same.task.b(com.mbridge.msdk.foundation.controller.c.m().d());

    /* loaded from: classes5.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
        }
    }

    /* loaded from: classes5.dex */
    public class b extends com.mbridge.msdk.mbnative.service.net.b implements com.mbridge.msdk.foundation.same.task.d {

        /* renamed from: c, reason: collision with root package name */
        private int f36423c;

        /* renamed from: d, reason: collision with root package name */
        private int f36424d;

        /* renamed from: e, reason: collision with root package name */
        private int f36425e;

        /* renamed from: f, reason: collision with root package name */
        private int f36426f;

        /* renamed from: g, reason: collision with root package name */
        private int f36427g;

        /* renamed from: j, reason: collision with root package name */
        private Runnable f36430j;

        /* renamed from: l, reason: collision with root package name */
        private com.mbridge.msdk.preload.listenter.a f36432l;

        /* renamed from: h, reason: collision with root package name */
        private List<String> f36428h = null;

        /* renamed from: i, reason: collision with root package name */
        private boolean f36429i = false;

        /* renamed from: k, reason: collision with root package name */
        private boolean f36431k = true;

        /* loaded from: classes5.dex */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CampaignUnit f36434a;

            a(CampaignUnit campaignUnit) {
                this.f36434a = campaignUnit;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z10;
                if (MBridgeConstans.PRELOAD_RESULT_IN_SUBTHREAD && Looper.myLooper() == null) {
                    Looper.prepare();
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (b.this.f36430j != null) {
                    b bVar = b.this;
                    d.this.f36385a.removeCallbacks(bVar.f36430j);
                }
                if (com.mbridge.msdk.util.b.a()) {
                    d.this.a(this.f36434a);
                }
                if (d.f36398s.containsKey("0_" + b.this.unitId)) {
                    d.f36398s.remove("0_" + b.this.unitId);
                }
                if (b.this.f36427g > 0) {
                    if (this.f36434a.ads.size() > b.this.f36427g) {
                        b bVar2 = b.this;
                        bVar2.f36424d = bVar2.f36427g;
                    } else {
                        b.this.f36424d = this.f36434a.ads.size();
                    }
                } else if (b.this.f36427g == -1) {
                    b.this.f36424d = 0;
                } else if (b.this.f36427g == -3) {
                    b.this.f36424d = this.f36434a.ads.size();
                } else if (b.this.f36427g == -2) {
                    if (this.f36434a.getTemplate() == 3) {
                        if (b.this.f36426f != 0) {
                            b bVar3 = b.this;
                            bVar3.f36424d = bVar3.f36426f;
                        }
                    } else if (b.this.f36425e != 0) {
                        b bVar4 = b.this;
                        bVar4.f36424d = bVar4.f36425e;
                    }
                    if (b.this.f36424d <= 0) {
                        b.this.f36424d = ((Integer) d.f36401v.get(b.this.unitId)).intValue();
                    }
                }
                if (this.f36434a.ads.size() < b.this.f36424d) {
                    b.this.f36424d = this.f36434a.ads.size();
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i11 = 0; i11 < this.f36434a.ads.size(); i11++) {
                    CampaignEx campaignEx = this.f36434a.ads.get(i11);
                    campaignEx.setCampaignUnitId(b.this.unitId);
                    boolean c11 = t0.c(com.mbridge.msdk.foundation.controller.c.m().d(), campaignEx.getPackageName());
                    d.this.a(com.mbridge.msdk.foundation.controller.c.m().d(), campaignEx);
                    if (arrayList.size() < b.this.f36424d && campaignEx.getOfferType() != 99) {
                        if (t0.c(campaignEx)) {
                            campaignEx.setRtinsType(c11 ? 1 : 2);
                        }
                        if (com.mbridge.msdk.foundation.same.c.b(com.mbridge.msdk.foundation.controller.c.m().d(), campaignEx)) {
                            arrayList.add(campaignEx);
                            if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                                arrayList2.add(campaignEx);
                            }
                        } else {
                            t0.a(b.this.unitId, campaignEx, com.mbridge.msdk.foundation.same.a.f35406x);
                        }
                        b.this.a(campaignEx, null, null);
                    }
                    d dVar = d.this;
                    dVar.a(dVar.f36417m, campaignEx);
                }
                b bVar5 = b.this;
                d.this.a(arrayList2, bVar5.unitId);
                com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>> a11 = com.mbridge.msdk.mbnative.cache.c.a(this.f36434a.getAds().get(0) != null ? this.f36434a.getAds().get(0).getType() : 1);
                if (a11 != null) {
                    a11.a((com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>>) b.this.unitId, (String) arrayList);
                }
                d.a(b.this.f36423c, b.this.unitId);
                if (Looper.myLooper() != null && z10) {
                    Looper.loop();
                }
                if (this.f36434a.getAds().get(0) != null) {
                    com.mbridge.msdk.click.c.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f36434a.getAds().get(0).getMaitve(), this.f36434a.getAds().get(0).getMaitve_src());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.mbridge.msdk.mbnative.controller.d$b$b, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0510b extends c.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CampaignEx f36436a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Context f36437b;

            C0510b(CampaignEx campaignEx, Context context, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
                this.f36436a = campaignEx;
                this.f36437b = context;
            }

            @Override // com.mbridge.msdk.foundation.same.c.a
            public void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
                com.mbridge.msdk.mbnative.report.a.a(str, cVar, this.f36436a, this.f36437b, (com.mbridge.msdk.foundation.same.report.metrics.callback.a) null);
            }
        }

        /* loaded from: classes5.dex */
        class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f36439a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f36440b;

            c(String str, int i11) {
                this.f36439a = str;
                this.f36440b = i11;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z10;
                if (MBridgeConstans.PRELOAD_RESULT_IN_SUBTHREAD && Looper.myLooper() == null) {
                    Looper.prepare();
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!b.this.f36429i) {
                    if (b.this.f36430j != null) {
                        b bVar = b.this;
                        d.this.f36385a.removeCallbacks(bVar.f36430j);
                    }
                    if (b.this.a() == 1 || b.this.f36431k) {
                        b bVar2 = b.this;
                        d dVar = d.this;
                        String str = this.f36439a;
                        int a11 = bVar2.a();
                        b bVar3 = b.this;
                        dVar.a(str, a11, bVar3.unitId, bVar3.placementId, bVar3.f36432l);
                    }
                } else if (b.this.f36431k) {
                    b bVar4 = b.this;
                    d dVar2 = d.this;
                    String str2 = this.f36439a;
                    int a12 = bVar4.a();
                    b bVar5 = b.this;
                    dVar2.a(str2, a12, bVar5.unitId, bVar5.placementId, bVar5.f36432l);
                }
                if (this.f36440b == -1) {
                    d.b(b.this.f36423c, b.this.unitId);
                }
                if (Looper.myLooper() == null || !z10) {
                    return;
                }
                Looper.loop();
            }
        }

        /* renamed from: com.mbridge.msdk.mbnative.controller.d$b$d, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class RunnableC0511d implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ List f36442a;

            RunnableC0511d(List list) {
                this.f36442a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z10;
                if (MBridgeConstans.PRELOAD_RESULT_IN_SUBTHREAD && Looper.myLooper() == null) {
                    Looper.prepare();
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!b.this.f36429i && b.this.f36430j != null) {
                    b bVar = b.this;
                    d.this.f36385a.removeCallbacks(bVar.f36430j);
                }
                List list = this.f36442a;
                if (list != null && list.size() > 0) {
                    Iterator it = this.f36442a.iterator();
                    while (it.hasNext()) {
                        for (CampaignEx campaignEx : ((Frame) it.next()).getCampaigns()) {
                            d dVar = d.this;
                            dVar.a(dVar.f36417m, campaignEx);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(Long.valueOf(System.currentTimeMillis()), this.f36442a);
                    if (d.f36398s.containsKey("1_" + b.this.unitId)) {
                        d.f36398s.remove("1_" + b.this.unitId);
                    }
                    d.f36398s.put("1_" + b.this.unitId, hashMap);
                }
                if (Looper.myLooper() == null || !z10) {
                    return;
                }
                Looper.loop();
            }
        }

        public b(int i11) {
            this.f36423c = i11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(CampaignEx campaignEx, com.mbridge.msdk.foundation.same.report.metrics.c cVar, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
            try {
                Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
                com.mbridge.msdk.foundation.same.c.a(campaignEx, d11, cVar, new C0510b(campaignEx, d11, aVar));
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
            }
        }

        @Override // com.mbridge.msdk.mbnative.service.net.b
        public void a(int i11, String str) {
            d.this.a(new Thread(new c(str, i11)));
        }

        public void a(com.mbridge.msdk.preload.listenter.a aVar) {
            this.f36432l = aVar;
        }

        public void a(Runnable runnable) {
            this.f36430j = runnable;
        }

        @Override // com.mbridge.msdk.mbnative.service.net.b
        public void a(List<Frame> list) {
            d.this.a(new Thread(new RunnableC0511d(list)));
        }

        @Override // com.mbridge.msdk.mbnative.service.net.b
        public void a(List<g> list, CampaignUnit campaignUnit) {
            d.this.f36418n = true;
            d.this.a(true, this.f36432l, (String) null);
            d.this.a(new Thread(new a(campaignUnit)));
        }

        @Override // com.mbridge.msdk.foundation.same.task.d
        public void a(boolean z10) {
            this.f36429i = z10;
        }

        public void b(int i11) {
            this.f36427g = i11;
        }

        public void b(List<String> list) {
            this.f36428h = list;
        }

        public void b(boolean z10) {
            this.f36431k = z10;
        }

        public void c(int i11) {
            this.f36425e = i11;
        }

        public void d(int i11) {
            this.f36424d = i11;
        }

        public void e(int i11) {
            this.f36426f = i11;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private int f36444a;

        /* renamed from: b, reason: collision with root package name */
        private com.mbridge.msdk.foundation.same.task.d f36445b;

        /* renamed from: c, reason: collision with root package name */
        private int f36446c;

        /* renamed from: d, reason: collision with root package name */
        private String f36447d;

        /* renamed from: e, reason: collision with root package name */
        private String f36448e;

        /* renamed from: f, reason: collision with root package name */
        private com.mbridge.msdk.preload.listenter.a f36449f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f36450g = false;

        public c(int i11, com.mbridge.msdk.foundation.same.task.d dVar, int i12, String str, String str2) {
            this.f36444a = i11;
            this.f36445b = dVar;
            this.f36446c = i12;
            this.f36447d = str;
            this.f36448e = str2;
        }

        public void a(com.mbridge.msdk.preload.listenter.a aVar) {
            this.f36449f = aVar;
        }

        public void a(String str) {
            this.f36447d = str;
        }

        public void a(boolean z10) {
            this.f36450g = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f36445b.a(true);
            int i11 = this.f36444a;
            if (i11 != 1) {
                if (i11 != 2) {
                    return;
                }
                d.this.a("REQUEST_TIMEOUT", this.f36446c, this.f36447d, this.f36448e, this.f36449f);
            } else {
                d.this.f36418n = true;
                if (this.f36450g || this.f36446c == 1) {
                    d.this.a("REQUEST_TIMEOUT", this.f36446c, this.f36447d, this.f36448e, this.f36449f);
                }
            }
        }
    }

    public d() {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        this.f36385a = new a();
    }

    private int a(String str) {
        if (str == null) {
            return 0;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.opt(i11);
                    if (2 == jSONObject.optInt("id", 0)) {
                        return jSONObject.optInt("ad_num");
                    }
                }
            }
        } catch (Exception e11) {
            o0.b(f36397r, com.mbridge.msdk.mbnative.common.a.a(e11));
        }
        return 0;
    }

    public static void a(int i11, String str) {
        k kVar = f36400u.containsKey(str) ? f36400u.get(str) : new k();
        int intValue = f36401v.get(str).intValue();
        int intValue2 = d().containsKey(str) ? d().get(str).intValue() : 1;
        if (i11 == 1) {
            int a11 = intValue + kVar.a();
            kVar.a(a11 <= intValue2 ? a11 : 0);
        } else if (i11 == 2) {
            int b11 = intValue + kVar.b();
            kVar.b(b11 <= intValue2 ? b11 : 0);
        }
        f36400u.put(str, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<CampaignEx> list, String str) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    try {
                        int i11 = MBMediaView.f36710p0;
                        Object invoke = com.mbridge.msdk.videocommon.download.b.class.getMethod("getInstance", null).invoke(null, null);
                        if (invoke != null) {
                            com.mbridge.msdk.videocommon.download.b.class.getMethod("createUnitCache", Context.class, String.class, CopyOnWriteArrayList.class, Integer.TYPE, com.mbridge.msdk.videocommon.listener.a.class).invoke(invoke, com.mbridge.msdk.foundation.controller.c.m().d(), str, new CopyOnWriteArrayList(list), 1, null);
                            com.mbridge.msdk.videocommon.download.b.class.getMethod(NativeImgComponent.EVENT_LOAD, String.class).invoke(invoke, str);
                        }
                    } catch (Exception unused) {
                        o0.b(f36397r, "please import the videocommon aar");
                    }
                }
            } catch (Exception e11) {
                o0.b(f36397r, com.mbridge.msdk.mbnative.common.a.a(e11));
            }
        }
    }

    public static void b(int i11, String str) {
        if (f36400u.containsKey(str)) {
            k kVar = f36400u.get(str);
            if (i11 == 1) {
                kVar.a(0);
            } else if (i11 == 2) {
                kVar.b(0);
            }
            f36400u.put(str, kVar);
        }
    }

    public static Map<String, Integer> c() {
        return f36401v;
    }

    public static Map<String, Integer> d() {
        return f36402w;
    }

    public static Map<String, k> e() {
        return f36400u;
    }

    public static Map<String, Map<Long, Object>> f() {
        return f36398s;
    }

    public static Map<String, Boolean> g() {
        return f36399t;
    }

    public List<Campaign> a(String str, int i11) {
        com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>> a11;
        l e11 = h.b().e("", str);
        this.f36408d = e11;
        if (e11 == null) {
            this.f36408d = l.i(str);
        }
        List<Integer> b11 = this.f36408d.b();
        this.f36414j = b11;
        if (b11 == null || b11.size() <= 0 || !this.f36414j.contains(1) || (a11 = com.mbridge.msdk.mbnative.cache.c.a(1)) == null) {
            return null;
        }
        return a11.a((com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>>) str, i11);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x02b5 A[Catch: Exception -> 0x009c, TryCatch #3 {Exception -> 0x009c, blocks: (B:3:0x001c, B:6:0x0069, B:8:0x006f, B:10:0x0077, B:12:0x007f, B:14:0x0087, B:16:0x0091, B:17:0x009f, B:19:0x00a9, B:20:0x00b3, B:22:0x00bd, B:23:0x00c7, B:25:0x00cd, B:27:0x00d6, B:29:0x00ef, B:30:0x00f6, B:32:0x00fc, B:33:0x0101, B:35:0x0128, B:36:0x012d, B:42:0x0148, B:45:0x0150, B:47:0x0158, B:49:0x015e, B:52:0x0163, B:54:0x0167, B:59:0x017b, B:61:0x0183, B:63:0x0189, B:67:0x0194, B:68:0x01a6, B:70:0x01aa, B:71:0x01c0, B:73:0x01c8, B:75:0x01d7, B:77:0x01ed, B:81:0x01fe, B:83:0x0204, B:88:0x0211, B:90:0x0218, B:93:0x021e, B:98:0x0269, B:99:0x0276, B:101:0x028c, B:103:0x02b5, B:104:0x02bc, B:106:0x02c4, B:108:0x02d6, B:109:0x02df, B:111:0x02ea, B:117:0x02fa, B:118:0x030a, B:123:0x0317, B:124:0x0343, B:126:0x037e, B:127:0x0383, B:129:0x038b, B:131:0x0395, B:132:0x03b5, B:134:0x03bf, B:136:0x03c9, B:137:0x03e9, B:140:0x041f, B:142:0x044d, B:143:0x047f, B:147:0x0466, B:148:0x041c, B:150:0x032f, B:152:0x02ff, B:153:0x0304, B:158:0x022b, B:160:0x0231, B:169:0x0252, B:182:0x027d, B:187:0x0485), top: B:2:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02c4 A[Catch: Exception -> 0x009c, TryCatch #3 {Exception -> 0x009c, blocks: (B:3:0x001c, B:6:0x0069, B:8:0x006f, B:10:0x0077, B:12:0x007f, B:14:0x0087, B:16:0x0091, B:17:0x009f, B:19:0x00a9, B:20:0x00b3, B:22:0x00bd, B:23:0x00c7, B:25:0x00cd, B:27:0x00d6, B:29:0x00ef, B:30:0x00f6, B:32:0x00fc, B:33:0x0101, B:35:0x0128, B:36:0x012d, B:42:0x0148, B:45:0x0150, B:47:0x0158, B:49:0x015e, B:52:0x0163, B:54:0x0167, B:59:0x017b, B:61:0x0183, B:63:0x0189, B:67:0x0194, B:68:0x01a6, B:70:0x01aa, B:71:0x01c0, B:73:0x01c8, B:75:0x01d7, B:77:0x01ed, B:81:0x01fe, B:83:0x0204, B:88:0x0211, B:90:0x0218, B:93:0x021e, B:98:0x0269, B:99:0x0276, B:101:0x028c, B:103:0x02b5, B:104:0x02bc, B:106:0x02c4, B:108:0x02d6, B:109:0x02df, B:111:0x02ea, B:117:0x02fa, B:118:0x030a, B:123:0x0317, B:124:0x0343, B:126:0x037e, B:127:0x0383, B:129:0x038b, B:131:0x0395, B:132:0x03b5, B:134:0x03bf, B:136:0x03c9, B:137:0x03e9, B:140:0x041f, B:142:0x044d, B:143:0x047f, B:147:0x0466, B:148:0x041c, B:150:0x032f, B:152:0x02ff, B:153:0x0304, B:158:0x022b, B:160:0x0231, B:169:0x0252, B:182:0x027d, B:187:0x0485), top: B:2:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02ea A[Catch: Exception -> 0x009c, TryCatch #3 {Exception -> 0x009c, blocks: (B:3:0x001c, B:6:0x0069, B:8:0x006f, B:10:0x0077, B:12:0x007f, B:14:0x0087, B:16:0x0091, B:17:0x009f, B:19:0x00a9, B:20:0x00b3, B:22:0x00bd, B:23:0x00c7, B:25:0x00cd, B:27:0x00d6, B:29:0x00ef, B:30:0x00f6, B:32:0x00fc, B:33:0x0101, B:35:0x0128, B:36:0x012d, B:42:0x0148, B:45:0x0150, B:47:0x0158, B:49:0x015e, B:52:0x0163, B:54:0x0167, B:59:0x017b, B:61:0x0183, B:63:0x0189, B:67:0x0194, B:68:0x01a6, B:70:0x01aa, B:71:0x01c0, B:73:0x01c8, B:75:0x01d7, B:77:0x01ed, B:81:0x01fe, B:83:0x0204, B:88:0x0211, B:90:0x0218, B:93:0x021e, B:98:0x0269, B:99:0x0276, B:101:0x028c, B:103:0x02b5, B:104:0x02bc, B:106:0x02c4, B:108:0x02d6, B:109:0x02df, B:111:0x02ea, B:117:0x02fa, B:118:0x030a, B:123:0x0317, B:124:0x0343, B:126:0x037e, B:127:0x0383, B:129:0x038b, B:131:0x0395, B:132:0x03b5, B:134:0x03bf, B:136:0x03c9, B:137:0x03e9, B:140:0x041f, B:142:0x044d, B:143:0x047f, B:147:0x0466, B:148:0x041c, B:150:0x032f, B:152:0x02ff, B:153:0x0304, B:158:0x022b, B:160:0x0231, B:169:0x0252, B:182:0x027d, B:187:0x0485), top: B:2:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x037e A[Catch: Exception -> 0x009c, TryCatch #3 {Exception -> 0x009c, blocks: (B:3:0x001c, B:6:0x0069, B:8:0x006f, B:10:0x0077, B:12:0x007f, B:14:0x0087, B:16:0x0091, B:17:0x009f, B:19:0x00a9, B:20:0x00b3, B:22:0x00bd, B:23:0x00c7, B:25:0x00cd, B:27:0x00d6, B:29:0x00ef, B:30:0x00f6, B:32:0x00fc, B:33:0x0101, B:35:0x0128, B:36:0x012d, B:42:0x0148, B:45:0x0150, B:47:0x0158, B:49:0x015e, B:52:0x0163, B:54:0x0167, B:59:0x017b, B:61:0x0183, B:63:0x0189, B:67:0x0194, B:68:0x01a6, B:70:0x01aa, B:71:0x01c0, B:73:0x01c8, B:75:0x01d7, B:77:0x01ed, B:81:0x01fe, B:83:0x0204, B:88:0x0211, B:90:0x0218, B:93:0x021e, B:98:0x0269, B:99:0x0276, B:101:0x028c, B:103:0x02b5, B:104:0x02bc, B:106:0x02c4, B:108:0x02d6, B:109:0x02df, B:111:0x02ea, B:117:0x02fa, B:118:0x030a, B:123:0x0317, B:124:0x0343, B:126:0x037e, B:127:0x0383, B:129:0x038b, B:131:0x0395, B:132:0x03b5, B:134:0x03bf, B:136:0x03c9, B:137:0x03e9, B:140:0x041f, B:142:0x044d, B:143:0x047f, B:147:0x0466, B:148:0x041c, B:150:0x032f, B:152:0x02ff, B:153:0x0304, B:158:0x022b, B:160:0x0231, B:169:0x0252, B:182:0x027d, B:187:0x0485), top: B:2:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x038b A[Catch: Exception -> 0x009c, TryCatch #3 {Exception -> 0x009c, blocks: (B:3:0x001c, B:6:0x0069, B:8:0x006f, B:10:0x0077, B:12:0x007f, B:14:0x0087, B:16:0x0091, B:17:0x009f, B:19:0x00a9, B:20:0x00b3, B:22:0x00bd, B:23:0x00c7, B:25:0x00cd, B:27:0x00d6, B:29:0x00ef, B:30:0x00f6, B:32:0x00fc, B:33:0x0101, B:35:0x0128, B:36:0x012d, B:42:0x0148, B:45:0x0150, B:47:0x0158, B:49:0x015e, B:52:0x0163, B:54:0x0167, B:59:0x017b, B:61:0x0183, B:63:0x0189, B:67:0x0194, B:68:0x01a6, B:70:0x01aa, B:71:0x01c0, B:73:0x01c8, B:75:0x01d7, B:77:0x01ed, B:81:0x01fe, B:83:0x0204, B:88:0x0211, B:90:0x0218, B:93:0x021e, B:98:0x0269, B:99:0x0276, B:101:0x028c, B:103:0x02b5, B:104:0x02bc, B:106:0x02c4, B:108:0x02d6, B:109:0x02df, B:111:0x02ea, B:117:0x02fa, B:118:0x030a, B:123:0x0317, B:124:0x0343, B:126:0x037e, B:127:0x0383, B:129:0x038b, B:131:0x0395, B:132:0x03b5, B:134:0x03bf, B:136:0x03c9, B:137:0x03e9, B:140:0x041f, B:142:0x044d, B:143:0x047f, B:147:0x0466, B:148:0x041c, B:150:0x032f, B:152:0x02ff, B:153:0x0304, B:158:0x022b, B:160:0x0231, B:169:0x0252, B:182:0x027d, B:187:0x0485), top: B:2:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x03bf A[Catch: Exception -> 0x009c, TryCatch #3 {Exception -> 0x009c, blocks: (B:3:0x001c, B:6:0x0069, B:8:0x006f, B:10:0x0077, B:12:0x007f, B:14:0x0087, B:16:0x0091, B:17:0x009f, B:19:0x00a9, B:20:0x00b3, B:22:0x00bd, B:23:0x00c7, B:25:0x00cd, B:27:0x00d6, B:29:0x00ef, B:30:0x00f6, B:32:0x00fc, B:33:0x0101, B:35:0x0128, B:36:0x012d, B:42:0x0148, B:45:0x0150, B:47:0x0158, B:49:0x015e, B:52:0x0163, B:54:0x0167, B:59:0x017b, B:61:0x0183, B:63:0x0189, B:67:0x0194, B:68:0x01a6, B:70:0x01aa, B:71:0x01c0, B:73:0x01c8, B:75:0x01d7, B:77:0x01ed, B:81:0x01fe, B:83:0x0204, B:88:0x0211, B:90:0x0218, B:93:0x021e, B:98:0x0269, B:99:0x0276, B:101:0x028c, B:103:0x02b5, B:104:0x02bc, B:106:0x02c4, B:108:0x02d6, B:109:0x02df, B:111:0x02ea, B:117:0x02fa, B:118:0x030a, B:123:0x0317, B:124:0x0343, B:126:0x037e, B:127:0x0383, B:129:0x038b, B:131:0x0395, B:132:0x03b5, B:134:0x03bf, B:136:0x03c9, B:137:0x03e9, B:140:0x041f, B:142:0x044d, B:143:0x047f, B:147:0x0466, B:148:0x041c, B:150:0x032f, B:152:0x02ff, B:153:0x0304, B:158:0x022b, B:160:0x0231, B:169:0x0252, B:182:0x027d, B:187:0x0485), top: B:2:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x041a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x044d A[Catch: Exception -> 0x009c, TryCatch #3 {Exception -> 0x009c, blocks: (B:3:0x001c, B:6:0x0069, B:8:0x006f, B:10:0x0077, B:12:0x007f, B:14:0x0087, B:16:0x0091, B:17:0x009f, B:19:0x00a9, B:20:0x00b3, B:22:0x00bd, B:23:0x00c7, B:25:0x00cd, B:27:0x00d6, B:29:0x00ef, B:30:0x00f6, B:32:0x00fc, B:33:0x0101, B:35:0x0128, B:36:0x012d, B:42:0x0148, B:45:0x0150, B:47:0x0158, B:49:0x015e, B:52:0x0163, B:54:0x0167, B:59:0x017b, B:61:0x0183, B:63:0x0189, B:67:0x0194, B:68:0x01a6, B:70:0x01aa, B:71:0x01c0, B:73:0x01c8, B:75:0x01d7, B:77:0x01ed, B:81:0x01fe, B:83:0x0204, B:88:0x0211, B:90:0x0218, B:93:0x021e, B:98:0x0269, B:99:0x0276, B:101:0x028c, B:103:0x02b5, B:104:0x02bc, B:106:0x02c4, B:108:0x02d6, B:109:0x02df, B:111:0x02ea, B:117:0x02fa, B:118:0x030a, B:123:0x0317, B:124:0x0343, B:126:0x037e, B:127:0x0383, B:129:0x038b, B:131:0x0395, B:132:0x03b5, B:134:0x03bf, B:136:0x03c9, B:137:0x03e9, B:140:0x041f, B:142:0x044d, B:143:0x047f, B:147:0x0466, B:148:0x041c, B:150:0x032f, B:152:0x02ff, B:153:0x0304, B:158:0x022b, B:160:0x0231, B:169:0x0252, B:182:0x027d, B:187:0x0485), top: B:2:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x032f A[Catch: Exception -> 0x009c, TryCatch #3 {Exception -> 0x009c, blocks: (B:3:0x001c, B:6:0x0069, B:8:0x006f, B:10:0x0077, B:12:0x007f, B:14:0x0087, B:16:0x0091, B:17:0x009f, B:19:0x00a9, B:20:0x00b3, B:22:0x00bd, B:23:0x00c7, B:25:0x00cd, B:27:0x00d6, B:29:0x00ef, B:30:0x00f6, B:32:0x00fc, B:33:0x0101, B:35:0x0128, B:36:0x012d, B:42:0x0148, B:45:0x0150, B:47:0x0158, B:49:0x015e, B:52:0x0163, B:54:0x0167, B:59:0x017b, B:61:0x0183, B:63:0x0189, B:67:0x0194, B:68:0x01a6, B:70:0x01aa, B:71:0x01c0, B:73:0x01c8, B:75:0x01d7, B:77:0x01ed, B:81:0x01fe, B:83:0x0204, B:88:0x0211, B:90:0x0218, B:93:0x021e, B:98:0x0269, B:99:0x0276, B:101:0x028c, B:103:0x02b5, B:104:0x02bc, B:106:0x02c4, B:108:0x02d6, B:109:0x02df, B:111:0x02ea, B:117:0x02fa, B:118:0x030a, B:123:0x0317, B:124:0x0343, B:126:0x037e, B:127:0x0383, B:129:0x038b, B:131:0x0395, B:132:0x03b5, B:134:0x03bf, B:136:0x03c9, B:137:0x03e9, B:140:0x041f, B:142:0x044d, B:143:0x047f, B:147:0x0466, B:148:0x041c, B:150:0x032f, B:152:0x02ff, B:153:0x0304, B:158:0x022b, B:160:0x0231, B:169:0x0252, B:182:0x027d, B:187:0x0485), top: B:2:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x032c  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // com.mbridge.msdk.mbnative.controller.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(int r26, long r27, int r29, com.mbridge.msdk.setting.l r30, java.lang.String r31, java.lang.String r32, com.mbridge.msdk.preload.listenter.a r33, boolean r34) {
        /*
            Method dump skipped, instructions count: 1190
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbnative.controller.d.a(int, long, int, com.mbridge.msdk.setting.l, java.lang.String, java.lang.String, com.mbridge.msdk.preload.listenter.a, boolean):void");
    }

    public void a(int i11, long j11, String str, String str2, Map<String, Object> map, int i12, l lVar, com.mbridge.msdk.preload.listenter.a aVar) {
        com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>> a11;
        if (i11 != 1 && (a11 = com.mbridge.msdk.mbnative.cache.c.a(i11)) != null) {
            List<Campaign> a12 = a11.a((com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>>) str, this.f36420p);
            if (a12 != null && a12.size() > 0) {
                a(true, aVar, (String) null);
                return;
            }
        }
        if (i11 == 1) {
            a(i11, j11, i12, lVar, str, str2, true, aVar);
        } else if (i11 != 2) {
            a(i11, j11, i12, lVar, str, str2, aVar, false);
        } else {
            a(2, j11, i12, lVar, str, str2, aVar, false);
        }
    }

    public void a(int i11, l lVar, String str, String str2, com.mbridge.msdk.preload.listenter.a aVar) {
        Queue<Integer> queue = this.f36410f;
        if (queue == null || queue.size() <= 0) {
            return;
        }
        try {
            int intValue = this.f36410f.poll().intValue();
            long j11 = MBridgeConstans.REQUEST_TIME_OUT;
            Queue<Long> queue2 = this.f36411g;
            if (queue2 != null && queue2.size() > 0) {
                j11 = this.f36411g.poll().longValue();
            }
            o0.c(f36397r, "preload start queue adsource = " + intValue);
            a(intValue, j11, str, str2, this.f36413i, i11, lVar, aVar);
        } catch (Throwable unused) {
            o0.b(f36397r, "queue poll exception");
        }
    }

    public void a(String str, int i11, String str2, String str3, com.mbridge.msdk.preload.listenter.a aVar) {
        Log.e(f36397r, str);
        try {
            Queue<Integer> queue = this.f36410f;
            if (queue != null) {
                if (queue.size() > 0) {
                }
                a(false, aVar, str);
            }
            if (this.f36410f != null) {
                a(i11, this.f36408d, str2, str3, aVar);
                return;
            }
            a(false, aVar, str);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public void a(String str, String str2, String str3) {
        if (this.f36406b == null) {
            this.f36406b = new j();
        }
        this.f36406b.a(com.mbridge.msdk.foundation.controller.c.m().d(), str, str2, str3);
    }

    public void a(Thread thread) {
        if (MBridgeConstans.PRELOAD_RESULT_IN_SUBTHREAD) {
            thread.start();
        } else {
            thread.run();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x01f1, code lost:
    
        if (android.text.TextUtils.isEmpty(r1) != false) goto L81;
     */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02df A[Catch: Exception -> 0x006a, TryCatch #3 {Exception -> 0x006a, blocks: (B:3:0x0020, B:7:0x002b, B:9:0x004f, B:12:0x006d, B:15:0x0074, B:17:0x007a, B:18:0x0086, B:20:0x008a, B:21:0x009d, B:23:0x00a3, B:24:0x00af, B:26:0x00b5, B:27:0x00bd, B:29:0x00c5, B:31:0x00d3, B:33:0x0101, B:35:0x0107, B:37:0x011b, B:38:0x0123, B:40:0x0134, B:44:0x013c, B:55:0x016d, B:57:0x017e, B:59:0x0184, B:60:0x018e, B:62:0x01a4, B:64:0x01aa, B:66:0x01b2, B:67:0x01c0, B:69:0x01cf, B:70:0x01d5, B:72:0x01dd, B:74:0x01e5, B:77:0x01fa, B:79:0x0216, B:81:0x021c, B:82:0x0229, B:84:0x022f, B:86:0x023b, B:88:0x023f, B:90:0x0245, B:91:0x0252, B:93:0x0258, B:95:0x026f, B:111:0x02ce, B:113:0x02df, B:114:0x02e9, B:145:0x03c2, B:157:0x03cc, B:162:0x0166, B:163:0x009a, B:116:0x02f4, B:118:0x030a, B:120:0x0325, B:121:0x032d, B:123:0x0333, B:124:0x0335, B:126:0x033b, B:127:0x0341, B:129:0x0347, B:131:0x0357, B:133:0x035a, B:136:0x035c, B:138:0x0362, B:46:0x0146, B:48:0x014c, B:50:0x015b, B:51:0x015d, B:53:0x0163), top: B:2:0x0020, inners: #0, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x030a A[Catch: all -> 0x03c2, TryCatch #0 {all -> 0x03c2, blocks: (B:116:0x02f4, B:118:0x030a, B:120:0x0325, B:121:0x032d, B:123:0x0333, B:124:0x0335, B:126:0x033b, B:127:0x0341, B:129:0x0347, B:131:0x0357, B:133:0x035a, B:136:0x035c, B:138:0x0362), top: B:115:0x02f4, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:144:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.util.Map<java.lang.String, java.lang.Object> r24, int r25) {
        /*
            Method dump skipped, instructions count: 988
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbnative.controller.d.a(java.util.Map, int):void");
    }

    public void a(boolean z10, Campaign campaign) {
        if (campaign == null) {
            return;
        }
        if (z10 && campaign.getIconDrawable() == null) {
            campaign.loadIconUrlAsyncWithBlock(null);
        }
        if (z10 && campaign.getBigDrawable() == null) {
            campaign.loadImageUrlAsyncWithBlock(null);
        }
    }

    public void a(boolean z10, com.mbridge.msdk.preload.listenter.a aVar, String str) {
        if (z10) {
            if (aVar == null || aVar.a()) {
                return;
            }
            aVar.a(true);
            aVar.onPreloadSucceed();
            return;
        }
        if (aVar == null || aVar.a()) {
            return;
        }
        aVar.a(true);
        aVar.onPreloadFaild(str);
    }
}

package com.mbridge.msdk.interstitial.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;
import com.mbridge.msdk.out.InterstitialListener;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.setting.j;
import com.mbridge.msdk.setting.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ast.ASTNode;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: o, reason: collision with root package name */
    public static String f35971o;

    /* renamed from: p, reason: collision with root package name */
    public static Map<String, Integer> f35972p = new HashMap();

    /* renamed from: q, reason: collision with root package name */
    public static Map<String, Integer> f35973q = new HashMap();

    /* renamed from: r, reason: collision with root package name */
    public static Map<String, d> f35974r = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private Context f35976b;

    /* renamed from: c, reason: collision with root package name */
    private String f35977c;

    /* renamed from: d, reason: collision with root package name */
    private String f35978d;

    /* renamed from: e, reason: collision with root package name */
    private String f35979e;

    /* renamed from: f, reason: collision with root package name */
    private MBridgeIds f35980f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f35981g;

    /* renamed from: h, reason: collision with root package name */
    private l f35982h;

    /* renamed from: i, reason: collision with root package name */
    private InterstitialListener f35983i;

    /* renamed from: a, reason: collision with root package name */
    private String f35975a = "InterstitialController";

    /* renamed from: j, reason: collision with root package name */
    public boolean f35984j = false;

    /* renamed from: k, reason: collision with root package name */
    private String f35985k = "";

    /* renamed from: l, reason: collision with root package name */
    private String f35986l = "";

    /* renamed from: m, reason: collision with root package name */
    private String f35987m = "";

    /* renamed from: n, reason: collision with root package name */
    private boolean f35988n = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.interstitial.controller.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class HandlerC0499a extends Handler {
        HandlerC0499a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            int i11 = message.what;
            if (i11 == 1) {
                if (a.this.f35983i != null) {
                    a.this.f35983i.onInterstitialLoadSuccess(a.this.f35980f);
                    return;
                }
                return;
            }
            String str = "";
            if (i11 == 2) {
                if (a.this.f35983i != null) {
                    Object obj = message.obj;
                    if (obj != null && (obj instanceof String)) {
                        str = (String) obj;
                    }
                    a.this.f35983i.onInterstitialLoadFail(a.this.f35980f, TextUtils.isEmpty(str) ? "can't show because unknow error" : str);
                    return;
                }
                return;
            }
            if (i11 == 3) {
                a aVar = a.this;
                aVar.f35984j = true;
                if (aVar.f35983i != null) {
                    a.this.f35983i.onInterstitialShowSuccess(a.this.f35980f);
                    return;
                }
                return;
            }
            if (i11 == 4) {
                if (a.this.f35983i != null) {
                    Object obj2 = message.obj;
                    if (obj2 != null && (obj2 instanceof String)) {
                        str = (String) obj2;
                    }
                    a.this.f35983i.onInterstitialShowFail(a.this.f35980f, TextUtils.isEmpty(str) ? "can't show because unknow error" : str);
                    return;
                }
                return;
            }
            if (i11 == 6) {
                if (a.this.f35983i != null) {
                    a.this.f35983i.onInterstitialAdClick(a.this.f35980f);
                }
            } else {
                if (i11 != 7) {
                    return;
                }
                a aVar2 = a.this;
                aVar2.f35984j = false;
                if (aVar2.f35983i != null) {
                    a.this.f35983i.onInterstitialClosed(a.this.f35980f);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        private com.mbridge.msdk.interstitial.adapter.a f35990a;

        /* renamed from: b, reason: collision with root package name */
        private c f35991b;

        public b(com.mbridge.msdk.interstitial.adapter.a aVar, c cVar) {
            this.f35990a = aVar;
            this.f35991b = cVar;
        }

        public void a(boolean z10, String str) {
            try {
                com.mbridge.msdk.interstitial.adapter.a aVar = this.f35990a;
                if (aVar != null) {
                    aVar.a((b) null);
                    this.f35990a = null;
                }
                if (this.f35991b != null) {
                    if (a.this.f35981g != null) {
                        a.this.f35981g.removeCallbacks(this.f35991b);
                    }
                    if (z10) {
                        if (a.this.f35983i != null) {
                            a.this.c(str);
                        }
                    } else if (a.this.f35983i != null) {
                        a.this.b(str);
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        public void b(boolean z10, String str) {
            try {
                a.this.f35985k = str;
                try {
                    ArrayList arrayList = new ArrayList();
                    com.mbridge.msdk.interstitial.adapter.a aVar = this.f35990a;
                    if (aVar != null && aVar.d() != null) {
                        arrayList.add(this.f35990a.d());
                    }
                    a.this.f35986l = com.mbridge.msdk.foundation.same.c.b(arrayList);
                } catch (Exception e11) {
                    o0.b(a.this.f35975a, e11.getMessage());
                }
                if (this.f35991b != null) {
                    if (a.this.f35981g != null) {
                        a.this.f35981g.removeCallbacks(this.f35991b);
                    }
                    if (z10) {
                        a.this.b(false);
                    } else if (a.this.f35983i != null) {
                        a.this.h();
                    }
                }
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private com.mbridge.msdk.interstitial.adapter.a f35993a;

        public c(com.mbridge.msdk.interstitial.adapter.a aVar) {
            this.f35993a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.mbridge.msdk.interstitial.adapter.a aVar = this.f35993a;
                if (aVar != null) {
                    if (aVar.f()) {
                        a.this.c("load timeout");
                    } else if (a.this.f35983i != null) {
                        a.this.b("load timeout");
                    }
                    this.f35993a.a((b) null);
                    this.f35993a = null;
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d {
        public d() {
        }

        public void a() {
            try {
                if (a.this.f35981g != null) {
                    a.this.f35981g.sendEmptyMessage(6);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        public void a(String str) {
            try {
                a.this.c(str);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        public void b() {
            try {
                if (a.this.f35981g != null) {
                    a.this.f35981g.sendEmptyMessage(7);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        public void c() {
            try {
                a.this.i();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public a() {
        try {
            c();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static int a(String str) {
        Map<String, Integer> map;
        Integer num;
        try {
            if (TextUtils.isEmpty(str) || (map = f35972p) == null || !map.containsKey(str) || (num = f35972p.get(str)) == null) {
                return 0;
            }
            return num.intValue();
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    private void a(CampaignEx campaignEx) {
        d dVar = new d();
        if (f35974r != null && !TextUtils.isEmpty(this.f35977c)) {
            f35974r.put(this.f35977c, dVar);
        }
        Intent intent = new Intent(this.f35976b, (Class<?>) MBInterstitialActivity.class);
        intent.addFlags(67108864);
        intent.addFlags(ASTNode.DEOP);
        if (!TextUtils.isEmpty(this.f35977c)) {
            intent.putExtra("unitId", this.f35977c);
        }
        if (campaignEx != null) {
            this.f35987m = campaignEx.getRequestId();
            intent.putExtra(MBInterstitialActivity.INTENT_CAMAPIGN, campaignEx);
        }
        Context context = this.f35976b;
        if (context != null) {
            context.startActivity(intent);
        }
    }

    public static void a(String str, int i11) {
        try {
            if (f35972p == null || TextUtils.isEmpty(str)) {
                return;
            }
            f35972p.put(str, Integer.valueOf(i11));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        try {
            if (this.f35981g != null) {
                Message obtain = Message.obtain();
                obtain.obj = str;
                obtain.what = 2;
                this.f35981g.sendMessage(obtain);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z10) {
        try {
            CampaignEx d11 = new com.mbridge.msdk.interstitial.adapter.a(this.f35976b, this.f35977c, this.f35978d, this.f35979e, true).d();
            if (d11 != null) {
                a(d11);
            } else if (z10) {
                a(true);
            } else {
                c("no ads available can show");
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            if (this.f35983i != null) {
                c("can't show because unknow error");
            }
        }
    }

    private void c() {
        try {
            this.f35981g = new HandlerC0499a(Looper.getMainLooper());
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        try {
            if (this.f35981g != null) {
                Message obtain = Message.obtain();
                obtain.obj = str;
                obtain.what = 4;
                this.f35981g.sendMessage(obtain);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void d() {
        try {
            l lVar = this.f35982h;
            if (lVar != null) {
                int e11 = lVar.e();
                int y10 = this.f35982h.y();
                if (e11 <= 0) {
                    e11 = 1;
                }
                if (y10 <= 0) {
                    y10 = 1;
                }
                int i11 = y10 * e11;
                if (f35973q == null || TextUtils.isEmpty(this.f35977c)) {
                    return;
                }
                f35973q.put(this.f35977c, Integer.valueOf(i11));
            }
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    private void e() {
        try {
            g();
            l e11 = h.b().e(com.mbridge.msdk.foundation.controller.c.m().b(), this.f35977c);
            this.f35982h = e11;
            if (e11 == null) {
                this.f35982h = l.h(this.f35977c);
            }
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Handler handler = this.f35981g;
        if (handler != null) {
            handler.sendEmptyMessage(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Handler handler = this.f35981g;
        if (handler != null) {
            handler.sendEmptyMessage(3);
        }
    }

    public String a() {
        return this.f35986l;
    }

    public void a(InterstitialListener interstitialListener) {
        this.f35983i = interstitialListener;
    }

    public void a(boolean z10) {
        try {
            com.mbridge.msdk.interstitial.adapter.a aVar = new com.mbridge.msdk.interstitial.adapter.a(this.f35976b, this.f35977c, this.f35978d, this.f35979e, z10);
            c cVar = new c(aVar);
            aVar.a(new b(aVar, cVar));
            Handler handler = this.f35981g;
            if (handler != null) {
                handler.postDelayed(cVar, 30000L);
            }
            aVar.j();
        } catch (Exception e11) {
            e11.printStackTrace();
            if (z10) {
                return;
            }
            b("can't show because unknow error");
        }
    }

    public boolean a(Context context, Map<String, Object> map) {
        try {
            this.f35988n = false;
        } catch (Exception e11) {
            e11.printStackTrace();
            this.f35988n = false;
        }
        if (map != null && context != null && map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID) && (map.get(MBridgeConstans.PROPERTIES_UNIT_ID) instanceof String)) {
            if (map.containsKey(MBridgeConstans.PROPERTIES_API_REUQEST_CATEGORY) && (map.get(MBridgeConstans.PROPERTIES_API_REUQEST_CATEGORY) instanceof String)) {
                this.f35979e = (String) map.get(MBridgeConstans.PROPERTIES_API_REUQEST_CATEGORY);
            }
            this.f35977c = (String) map.get(MBridgeConstans.PROPERTIES_UNIT_ID);
            this.f35976b = context;
            if (map.containsKey(MBridgeConstans.PLACEMENT_ID) && map.get(MBridgeConstans.PLACEMENT_ID) != null) {
                this.f35978d = (String) map.get(MBridgeConstans.PLACEMENT_ID);
            }
            this.f35980f = new MBridgeIds(this.f35978d, this.f35977c);
            this.f35988n = true;
            return this.f35988n;
        }
        return false;
    }

    public String b() {
        return this.f35984j ? this.f35987m : this.f35985k;
    }

    public void f() {
        try {
            if (this.f35976b == null) {
                b("context is null");
                return;
            }
            if (TextUtils.isEmpty(this.f35977c)) {
                b("unitid is null");
            } else {
                if (!this.f35988n) {
                    b("init error");
                    return;
                }
                e();
                d();
                a(false);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            b("can't show because unknow error");
        }
    }

    public void g() {
        try {
            new j().a(this.f35976b, (String) null, (String) null, this.f35977c);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void j() {
        try {
            if (this.f35976b == null) {
                c("context is null");
                return;
            }
            if (TextUtils.isEmpty(this.f35977c)) {
                c("unitid is null");
            } else if (!this.f35988n) {
                c("init error");
            } else {
                e();
                b(true);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            c("can't show because unknow error");
        }
    }
}

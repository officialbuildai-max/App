package com.mbridge.msdk.interstitial.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.c;
import com.mbridge.msdk.foundation.same.directory.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.z0;
import com.mbridge.msdk.interstitial.controller.a;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.setting.l;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f35950a;

    /* renamed from: b, reason: collision with root package name */
    private String f35951b;

    /* renamed from: c, reason: collision with root package name */
    private String f35952c;

    /* renamed from: d, reason: collision with root package name */
    private int f35953d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f35954e;

    /* renamed from: f, reason: collision with root package name */
    private int f35955f;

    /* renamed from: g, reason: collision with root package name */
    private String f35956g;

    /* renamed from: h, reason: collision with root package name */
    private a.b f35957h;

    /* renamed from: i, reason: collision with root package name */
    private l f35958i;

    /* renamed from: j, reason: collision with root package name */
    private Handler f35959j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.interstitial.adapter.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class HandlerC0498a extends Handler {
        HandlerC0498a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj;
            Object obj2;
            try {
                int i11 = message.what;
                if (i11 != 3) {
                    if (i11 == 4 && a.this.f35957h != null && (obj2 = message.obj) != null && (obj2 instanceof String)) {
                        a.this.f35957h.a(a.this.f35954e, (String) obj2);
                    }
                } else if (a.this.f35957h != null && (obj = message.obj) != null && (obj instanceof String)) {
                    a.this.f35957h.b(a.this.f35954e, (String) obj);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b extends com.mbridge.msdk.interstitial.request.b {
        b() {
        }

        @Override // com.mbridge.msdk.interstitial.request.b
        public void a(CampaignUnit campaignUnit) {
            try {
                a.this.a(campaignUnit);
            } catch (Exception e11) {
                e11.printStackTrace();
                a.this.b("can't show because unknow error");
                a.this.m();
            }
        }

        @Override // com.mbridge.msdk.interstitial.request.b
        public void b(int i11, String str) {
            o0.b("IntersAdapter", str);
            a.this.b(str);
            a.this.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c extends c.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f35962a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f35963b;

        c(CampaignEx campaignEx, Context context, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
            this.f35962a = campaignEx;
            this.f35963b = context;
        }

        @Override // com.mbridge.msdk.foundation.same.c.a
        public void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a(str, cVar, this.f35962a, this.f35963b, (com.mbridge.msdk.foundation.same.report.metrics.callback.a) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f35965a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f35966b;

        d(List list, List list2) {
            this.f35965a = list;
            this.f35966b = list2;
        }

        @Override // java.lang.Runnable
        public void run() {
            List list = this.f35965a;
            if (list == null || list.size() <= 0) {
                a.this.b("no ads available");
            } else {
                a aVar = a.this;
                aVar.a(aVar.f35951b, (List<CampaignEx>) a.this.a((List<CampaignEx>) this.f35965a));
                CampaignEx campaignEx = (CampaignEx) this.f35965a.get(0);
                a.this.c(campaignEx != null ? campaignEx.getRequestId() : "");
            }
            j.a(g.a(a.this.f35950a)).a();
            List list2 = this.f35966b;
            if (list2 == null || list2.size() <= 0) {
                return;
            }
            a.this.c((List<CampaignEx>) this.f35966b);
        }
    }

    public a(Context context, String str, String str2, String str3, boolean z10) {
        this.f35950a = context;
        this.f35951b = str;
        this.f35952c = str2;
        this.f35956g = str3;
        this.f35954e = z10;
        l e11 = h.b().e(com.mbridge.msdk.foundation.controller.c.m().b(), str);
        this.f35958i = e11;
        if (e11 == null) {
            this.f35958i = l.h(this.f35951b);
        }
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<CampaignEx> a(List<CampaignEx> list) {
        FileOutputStream fileOutputStream;
        File file;
        File file2;
        ArrayList arrayList = new ArrayList(list.size());
        for (CampaignEx campaignEx : list) {
            if (campaignEx.isMraid() && !TextUtils.isEmpty(campaignEx.getMraid())) {
                com.mbridge.msdk.foundation.same.report.g.a("m_download_start", campaignEx, "", this.f35951b, "5");
                FileOutputStream fileOutputStream2 = null;
                try {
                    try {
                        String b11 = e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_HTML);
                        String md5 = SameMD5.getMD5(z0.b(campaignEx.getMraid()));
                        if (TextUtils.isEmpty(md5)) {
                            md5 = String.valueOf(System.currentTimeMillis());
                        }
                        file2 = new File(b11, md5.concat(".html"));
                        fileOutputStream = new FileOutputStream(file2);
                    } catch (Exception e11) {
                        e = e11;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
                try {
                    StringBuilder sb2 = new StringBuilder();
                    String b12 = com.mbridge.msdk.setting.util.a.a().b();
                    if (!TextUtils.isEmpty(b12)) {
                        sb2.append("<script>");
                        sb2.append(b12);
                        sb2.append("</script>");
                    }
                    sb2.append(campaignEx.getMraid());
                    fileOutputStream.write(sb2.toString().getBytes());
                    fileOutputStream.flush();
                    campaignEx.setMraid(file2.getAbsolutePath());
                    com.mbridge.msdk.foundation.same.report.g.a("m_download_end", campaignEx, "", this.f35951b, "5");
                    try {
                        fileOutputStream.close();
                    } catch (Exception e12) {
                        e12.printStackTrace();
                    }
                } catch (Exception e13) {
                    e = e13;
                    fileOutputStream2 = fileOutputStream;
                    e.printStackTrace();
                    campaignEx.setMraid("");
                    com.mbridge.msdk.foundation.same.report.g.a("m_download_end", campaignEx, e.getMessage(), this.f35951b, "5");
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    file = new File(campaignEx.getMraid());
                    if (file.exists()) {
                    }
                    b("mraid resource write fail");
                } catch (Throwable th3) {
                    th = th3;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e14) {
                            e14.printStackTrace();
                        }
                    }
                    throw th;
                }
                file = new File(campaignEx.getMraid());
                if (file.exists() || !file.isFile() || !file.canRead()) {
                    b("mraid resource write fail");
                }
            }
            arrayList.add(campaignEx);
        }
        return arrayList;
    }

    private void a() {
        try {
            if (com.mbridge.msdk.interstitial.cache.a.a() != null) {
                com.mbridge.msdk.setting.g d11 = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
                if (d11 == null) {
                    d11 = h.b().a();
                }
                com.mbridge.msdk.interstitial.cache.a.a().a(d11.Z() * 1000, this.f35951b);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void a(CampaignEx campaignEx, com.mbridge.msdk.foundation.same.report.metrics.c cVar, Context context, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
        try {
            com.mbridge.msdk.foundation.same.c.a(campaignEx, this.f35950a, cVar, new c(campaignEx, context, aVar));
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignUnit campaignUnit) {
        if (campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().size() <= 0) {
            b("no server ads available");
            return;
        }
        ArrayList<CampaignEx> ads = campaignUnit.getAds();
        List<CampaignEx> b11 = b(ads);
        a(campaignUnit.getSessionId());
        n();
        a(ads, b11);
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        o0.c("IntersAdapter", "onload sessionId:" + str);
        com.mbridge.msdk.interstitial.controller.a.f35971o = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, List<CampaignEx> list) {
        if (com.mbridge.msdk.interstitial.cache.a.a() != null) {
            com.mbridge.msdk.interstitial.cache.a.a().a(str, list);
        }
    }

    private void a(List<CampaignEx> list, List<CampaignEx> list2) {
        new Thread(new d(list2, list)).start();
    }

    private int b() {
        int i11 = 0;
        try {
            int a11 = !TextUtils.isEmpty(this.f35951b) ? com.mbridge.msdk.interstitial.controller.a.a(this.f35951b) : 0;
            if (a11 <= g()) {
                i11 = a11;
            }
            o0.c("IntersAdapter", "getCurrentOffset:" + i11);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return i11;
    }

    private List<CampaignEx> b(List<CampaignEx> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            try {
                if (list.size() > 0) {
                    int e11 = this.f35958i.e();
                    for (int i11 = 0; i11 < list.size() && i11 < this.f35955f && arrayList.size() < e11; i11++) {
                        CampaignEx campaignEx = list.get(i11);
                        int i12 = 1;
                        if ((campaignEx == null || campaignEx.getOfferType() != 1 || !TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) && campaignEx != null && ((!TextUtils.isEmpty(campaignEx.getHtmlUrl()) || campaignEx.isMraid()) && campaignEx.getOfferType() != 99)) {
                            if (t0.c(campaignEx)) {
                                if (!t0.c(this.f35950a, campaignEx.getPackageName())) {
                                    i12 = 2;
                                }
                                campaignEx.setRtinsType(i12);
                            }
                            if (com.mbridge.msdk.foundation.same.c.b(this.f35950a, campaignEx)) {
                                arrayList.add(campaignEx);
                            } else {
                                t0.a(this.f35951b, campaignEx, com.mbridge.msdk.foundation.same.a.f35406x);
                            }
                            a(campaignEx, null, this.f35950a, null);
                        }
                    }
                }
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        try {
            if (this.f35959j != null) {
                Message obtain = Message.obtain();
                obtain.obj = str;
                obtain.what = 4;
                this.f35959j.sendMessage(obtain);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private String c() {
        String str;
        str = "";
        try {
            JSONArray b11 = t0.b(this.f35950a, this.f35951b);
            str = b11.length() > 0 ? t0.a(b11) : "";
            o0.c("IntersAdapter", "get excludes:" + str);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (this.f35959j != null) {
            Message obtain = Message.obtain();
            obtain.obj = str;
            obtain.what = 3;
            this.f35959j.sendMessage(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(List<CampaignEx> list) {
        if (this.f35950a == null || list == null || list.size() == 0) {
            return;
        }
        j a11 = j.a(g.a(this.f35950a));
        for (int i11 = 0; i11 < list.size(); i11++) {
            CampaignEx campaignEx = list.get(i11);
            if (campaignEx != null && a11 != null && !a11.a(campaignEx.getId())) {
                com.mbridge.msdk.foundation.entity.g gVar = new com.mbridge.msdk.foundation.entity.g();
                gVar.a(campaignEx.getId());
                gVar.b(campaignEx.getFca());
                gVar.c(campaignEx.getFcb());
                gVar.a(0);
                gVar.d(0);
                gVar.a(System.currentTimeMillis());
                a11.b(gVar);
            }
        }
    }

    private List<CampaignEx> e() {
        try {
            if (com.mbridge.msdk.interstitial.cache.a.a() != null) {
                return com.mbridge.msdk.interstitial.cache.a.a().a(this.f35951b, 1);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return null;
    }

    private int g() {
        try {
            Map<String, Integer> map = com.mbridge.msdk.interstitial.controller.a.f35973q;
            int intValue = (TextUtils.isEmpty(this.f35951b) || map == null || !map.containsKey(this.f35951b)) ? 1 : map.get(this.f35951b).intValue();
            if (intValue <= 0) {
                return 1;
            }
            return intValue;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 1;
        }
    }

    private String h() {
        try {
            if (!TextUtils.isEmpty(com.mbridge.msdk.interstitial.controller.a.f35971o)) {
                return com.mbridge.msdk.interstitial.controller.a.f35971o;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return "";
    }

    private void i() {
        this.f35959j = new HandlerC0498a(Looper.getMainLooper());
    }

    private com.mbridge.msdk.foundation.same.net.wrapper.e l() {
        String b11 = com.mbridge.msdk.foundation.controller.c.m().b();
        String md5 = SameMD5.getMD5(com.mbridge.msdk.foundation.controller.c.m().b() + com.mbridge.msdk.foundation.controller.c.m().c());
        int i11 = this.f35954e ? 3 : 2;
        this.f35955f = 1;
        if (this.f35958i.e() > 0) {
            this.f35955f = this.f35958i.e();
        }
        int f11 = this.f35958i.f() > 0 ? this.f35958i.f() : 1;
        String a11 = com.mbridge.msdk.foundation.same.buffer.b.a(this.f35951b, com.vungle.ads.internal.b.PLACEMENT_TYPE_INTERSTITIAL);
        this.f35953d = b();
        String h11 = h();
        if (TextUtils.isEmpty(this.f35956g)) {
            this.f35956g = "0";
        }
        com.mbridge.msdk.foundation.same.net.wrapper.e eVar = new com.mbridge.msdk.foundation.same.net.wrapper.e();
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "app_id", b11);
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, MBridgeConstans.PROPERTIES_UNIT_ID, this.f35951b);
        if (!TextUtils.isEmpty(this.f35952c)) {
            com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, MBridgeConstans.PLACEMENT_ID, this.f35952c);
        }
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, TmcConstants.EXTRA_APP_DEV_TOKEN, md5);
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "category", this.f35956g);
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "req_type", i11 + "");
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "ad_num", f11 + "");
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "tnum", this.f35955f + "");
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "only_impression", "1");
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "ping_mode", "1");
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, com.mbridge.msdk.foundation.same.net.wrapper.e.f35554g, a11);
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, com.mbridge.msdk.foundation.same.net.wrapper.e.f35555h, c());
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, CampaignEx.JSON_KEY_AD_SOURCE_ID, "1");
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, com.mbridge.msdk.foundation.same.net.wrapper.e.f35556i, h11);
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "ad_type", "279");
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "offset", this.f35953d + "");
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        try {
            if (TextUtils.isEmpty(this.f35951b)) {
                return;
            }
            com.mbridge.msdk.interstitial.controller.a.a(this.f35951b, 0);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void n() {
        try {
            this.f35953d += this.f35955f;
            if (this.f35953d > g()) {
                this.f35953d = 0;
            }
            if (TextUtils.isEmpty(this.f35951b)) {
                return;
            }
            com.mbridge.msdk.interstitial.controller.a.a(this.f35951b, this.f35953d);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void a(a.b bVar) {
        this.f35957h = bVar;
    }

    public CampaignEx d() {
        try {
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        if (TextUtils.isEmpty(this.f35951b)) {
            return null;
        }
        a();
        List<CampaignEx> e12 = e();
        if (e12 != null && e12.size() > 0) {
            for (int i11 = 0; i11 < e12.size(); i11++) {
                CampaignEx campaignEx = e12.get(i11);
                if (campaignEx != null && (!TextUtils.isEmpty(campaignEx.getHtmlUrl()) || !TextUtils.isEmpty(campaignEx.getMraid()))) {
                    return campaignEx;
                }
            }
            return null;
        }
        return null;
    }

    public boolean f() {
        return this.f35954e;
    }

    public void j() {
        if (this.f35950a == null) {
            b("context is null");
            return;
        }
        if (TextUtils.isEmpty(this.f35951b)) {
            b("unitid is null");
            return;
        }
        l lVar = this.f35958i;
        if (lVar == null) {
            b("unitSetting is null please call load");
            return;
        }
        if (lVar.f() <= 0) {
            b("controller don't request ad");
            return;
        }
        a();
        List<CampaignEx> e11 = e();
        if (e11 == null || e11.size() <= 0) {
            k();
        } else {
            CampaignEx campaignEx = e11.get(0);
            c(campaignEx != null ? campaignEx.getRequestId() : "");
        }
    }

    public void k() {
        try {
            if (this.f35950a == null) {
                b("context is null");
                return;
            }
            if (TextUtils.isEmpty(this.f35951b)) {
                b("unitid is null");
                return;
            }
            if (this.f35958i == null) {
                b("unitSetting is null please call load");
                return;
            }
            com.mbridge.msdk.foundation.same.net.wrapper.e l11 = l();
            if (l11 == null) {
                b("request parameter is null");
                return;
            }
            String d11 = t0.d(this.f35951b);
            if (!TextUtils.isEmpty(d11)) {
                l11.a(com.mbridge.msdk.foundation.same.report.j.f35620b, d11);
            }
            com.mbridge.msdk.interstitial.request.a aVar = new com.mbridge.msdk.interstitial.request.a(this.f35950a);
            b bVar = new b();
            bVar.setUnitId(this.f35951b);
            bVar.setPlacementId(this.f35952c);
            bVar.setAdType(279);
            aVar.choiceV3OrV5BySetting(1, l11, bVar, "", 30000L);
        } catch (Exception e11) {
            e11.printStackTrace();
            b("can't show because unknow error");
            m();
        }
    }
}

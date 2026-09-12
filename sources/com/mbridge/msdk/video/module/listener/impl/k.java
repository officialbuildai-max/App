package com.mbridge.msdk.video.module.listener.impl;

import android.content.Context;
import android.text.TextUtils;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.q0;
import com.mbridge.msdk.foundation.tools.y0;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class k extends f {

    /* renamed from: a, reason: collision with root package name */
    protected boolean f39514a;

    /* renamed from: b, reason: collision with root package name */
    protected CampaignEx f39515b;

    /* renamed from: c, reason: collision with root package name */
    protected List<CampaignEx> f39516c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f39517d;

    /* renamed from: e, reason: collision with root package name */
    protected com.mbridge.msdk.videocommon.download.a f39518e;

    /* renamed from: f, reason: collision with root package name */
    protected com.mbridge.msdk.videocommon.entity.c f39519f;

    /* renamed from: g, reason: collision with root package name */
    protected String f39520g;

    /* renamed from: h, reason: collision with root package name */
    protected String f39521h;

    /* renamed from: i, reason: collision with root package name */
    protected com.mbridge.msdk.video.module.listener.a f39522i;

    /* renamed from: j, reason: collision with root package name */
    protected int f39523j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f39524k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f39525l = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f39526m = false;

    /* loaded from: classes5.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                k kVar = k.this;
                if (!kVar.f39514a || kVar.f39515b == null || !y0.b(kVar.f39520g) || com.mbridge.msdk.foundation.controller.c.m().d() == null) {
                    return;
                }
                com.mbridge.msdk.foundation.db.i a11 = com.mbridge.msdk.foundation.db.i.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
                com.mbridge.msdk.foundation.entity.f fVar = new com.mbridge.msdk.foundation.entity.f();
                fVar.a(System.currentTimeMillis());
                fVar.b(k.this.f39520g);
                fVar.a(k.this.f39515b.getId());
                a11.a(fVar);
            } catch (Throwable th2) {
                o0.b("NotifyListener", th2.getMessage(), th2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                k kVar = k.this;
                if (kVar.f39514a && kVar.f39515b != null && y0.b(kVar.f39520g)) {
                    com.mbridge.msdk.videocommon.cache.a a11 = com.mbridge.msdk.videocommon.cache.a.a();
                    k kVar2 = k.this;
                    a11.a(kVar2.f39515b, kVar2.f39520g);
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
            }
            try {
                com.mbridge.msdk.videocommon.cache.a a12 = com.mbridge.msdk.videocommon.cache.a.a();
                k kVar3 = k.this;
                a12.b(kVar3.f39521h, kVar3.f39515b.getAdType());
            } catch (Exception e12) {
                if (MBridgeConstans.DEBUG) {
                    e12.printStackTrace();
                }
            } catch (Throwable th2) {
                o0.a("NotifyListener", th2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.mbridge.msdk.foundation.db.j.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d())).b(k.this.f39515b.getId());
            } catch (Throwable th2) {
                o0.b("NotifyListener", th2.getMessage(), th2);
            }
        }
    }

    /* loaded from: classes5.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.videocommon.download.a aVar;
            try {
                if (q0.a().a("c_r_v_f_w_s_e", false)) {
                    return;
                }
                k kVar = k.this;
                if (!kVar.f39514a || (aVar = kVar.f39518e) == null) {
                    return;
                }
                if (aVar.c() != null && !TextUtils.isEmpty(k.this.f39518e.c().getVideoUrlEncode())) {
                    com.mbridge.msdk.foundation.db.m.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d())).a(k.this.f39518e.c().getVideoUrlEncode());
                }
                if (TextUtils.isEmpty(k.this.f39518e.k())) {
                    return;
                }
                File file = new File(k.this.f39518e.k());
                if (file.exists() && file.isFile() && file.delete()) {
                    o0.a("NotifyListener", "DEL File :" + file.getAbsolutePath());
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public k(CampaignEx campaignEx, com.mbridge.msdk.videocommon.download.a aVar, com.mbridge.msdk.videocommon.entity.c cVar, String str, String str2, com.mbridge.msdk.video.module.listener.a aVar2, int i11, boolean z10) {
        this.f39517d = false;
        this.f39522i = new f();
        this.f39523j = 1;
        if (!z10 && campaignEx != null && y0.b(str2) && aVar != null && aVar2 != null) {
            this.f39515b = campaignEx;
            this.f39521h = str;
            this.f39520g = str2;
            this.f39518e = aVar;
            this.f39519f = cVar;
            this.f39522i = aVar2;
            this.f39514a = true;
            this.f39523j = i11;
            this.f39517d = false;
            return;
        }
        if (!z10 || campaignEx == null || !y0.b(str2) || aVar2 == null) {
            return;
        }
        this.f39515b = campaignEx;
        this.f39521h = str;
        this.f39520g = str2;
        this.f39518e = aVar;
        this.f39519f = cVar;
        this.f39522i = aVar2;
        this.f39514a = true;
        this.f39523j = i11;
        this.f39517d = true;
    }

    private void d() {
        if (!this.f39514a || com.mbridge.msdk.foundation.same.buffer.b.f35424k == null || TextUtils.isEmpty(this.f39515b.getId())) {
            return;
        }
        com.mbridge.msdk.foundation.same.buffer.b.a(this.f39520g, this.f39515b, "reward");
    }

    private void f() {
        if (this.f39515b != null) {
            try {
                HashMap hashMap = new HashMap();
                List<com.mbridge.msdk.foundation.entity.d> a11 = com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(this.f39515b.getCampaignUnitId(), this.f39515b.getRequestId());
                if (a11 == null || a11.size() <= 0 || a11.get(0) == null) {
                    return;
                }
                if (a11.get(0).c() == 1) {
                    hashMap.put("encrypt_p=", "encrypt_p=" + a11.get(0).b());
                    hashMap.put("irlfa=", "irlfa=1");
                    for (Map.Entry entry : hashMap.entrySet()) {
                        String str = (String) entry.getKey();
                        String str2 = (String) entry.getValue();
                        CampaignEx campaignEx = this.f39515b;
                        campaignEx.setImpressionURL(campaignEx.getImpressionURL().replaceAll(str, str2));
                        CampaignEx campaignEx2 = this.f39515b;
                        campaignEx2.setOnlyImpressionURL(campaignEx2.getOnlyImpressionURL().replaceAll(str, str2));
                    }
                }
                o0.a("BidReplaceCampignDao", "removeReplace count " + com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(this.f39515b.getRequestId()));
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    private void m() {
        new Thread(new c()).start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        com.mbridge.msdk.videocommon.download.b.getInstance().a(false);
    }

    public void a(int i11) {
        CampaignEx campaignEx = this.f39515b;
        if (campaignEx != null) {
            String noticeUrl = campaignEx.getNoticeUrl();
            if (TextUtils.isEmpty(noticeUrl)) {
                return;
            }
            if (i11 == 1 || i11 == 2) {
                if (!noticeUrl.contains("endscreen_type")) {
                    StringBuilder sb2 = new StringBuilder(noticeUrl);
                    if (noticeUrl.contains(UrlUtils.QUESTION_MARK)) {
                        sb2.append("&endscreen_type=");
                        sb2.append(i11);
                    } else {
                        sb2.append("?endscreen_type=");
                        sb2.append(i11);
                    }
                    noticeUrl = sb2.toString();
                } else if (i11 == 2) {
                    if (noticeUrl.contains("endscreen_type=1")) {
                        noticeUrl = noticeUrl.replace("endscreen_type=1", "endscreen_type=2");
                    }
                } else if (noticeUrl.contains("endscreen_type=2")) {
                    noticeUrl = noticeUrl.replace("endscreen_type=2", "endscreen_type=1");
                }
                this.f39515b.setNoticeUrl(noticeUrl);
            }
        }
    }

    @Override // com.mbridge.msdk.video.module.listener.impl.f, com.mbridge.msdk.video.module.listener.a
    public void a(int i11, Object obj) {
        super.a(i11, obj);
        this.f39522i.a(i11, obj);
    }

    public void a(int i11, String str) {
        if (this.f39515b != null) {
            com.mbridge.msdk.foundation.same.report.g.c(new com.mbridge.msdk.foundation.entity.m("2000062", this.f39515b.getId(), this.f39515b.getRequestId(), this.f39515b.getRequestIdNotice(), this.f39520g, k0.s(com.mbridge.msdk.foundation.controller.c.m().d()), i11, str), com.mbridge.msdk.foundation.controller.c.m().d(), this.f39520g);
        }
    }

    public void a(CampaignEx campaignEx) {
        this.f39515b = campaignEx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        List<CampaignEx> list;
        if (this.f39515b == null || (list = this.f39516c) == null || list.size() == 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("camp_position")) {
                this.f39515b = this.f39516c.get(jSONObject.getInt("camp_position"));
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("NotifyListener", e11.getMessage());
            }
        }
    }

    public void a(List<CampaignEx> list) {
        this.f39516c = list;
    }

    public void b() {
        try {
            b bVar = new b();
            if (com.mbridge.msdk.foundation.controller.d.a().e()) {
                com.mbridge.msdk.foundation.same.threadpool.a.b().execute(bVar);
            } else {
                bVar.run();
            }
        } catch (Throwable th2) {
            o0.b("NotifyListener", th2.getMessage(), th2);
        }
    }

    public void b(int i11) {
        if (this.f39515b != null) {
            if (i11 == 1 || i11 == 2) {
                com.mbridge.msdk.video.module.report.b.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f39515b, i11, this.f39523j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str) {
        try {
            if (this.f39515b != null) {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("url", this.f39515b.getVideoUrlEncode());
                eVar.a("reason", str);
                String noticeUrl = this.f39515b.getNoticeUrl();
                String clickURL = this.f39515b.getClickURL();
                if (!TextUtils.isEmpty(noticeUrl)) {
                    eVar.a("offer_url", noticeUrl);
                } else if (!TextUtils.isEmpty(clickURL)) {
                    eVar.a("offer_url", clickURL);
                }
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000021", this.f39515b, eVar);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void c() {
        a aVar = new a();
        if (com.mbridge.msdk.foundation.controller.d.a().e()) {
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(aVar);
        } else {
            aVar.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        d dVar = new d();
        if (com.mbridge.msdk.foundation.controller.d.a().e()) {
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(dVar);
        } else {
            dVar.run();
        }
    }

    public void g() {
        if (!this.f39514a || this.f39515b == null) {
            return;
        }
        com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m("2000061", this.f39515b.getId(), this.f39515b.getRequestId(), this.f39515b.getRequestIdNotice(), this.f39520g, k0.s(com.mbridge.msdk.foundation.controller.c.m().d()));
        mVar.b(this.f39515b.isMraid() ? com.mbridge.msdk.foundation.entity.m.N : com.mbridge.msdk.foundation.entity.m.O);
        com.mbridge.msdk.foundation.same.report.g.b(mVar, com.mbridge.msdk.foundation.controller.c.m().d(), this.f39520g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        String str;
        try {
            if (!this.f39514a || this.f39524k || TextUtils.isEmpty(this.f39515b.getImpressionURL())) {
                return;
            }
            this.f39524k = true;
            if (this.f39515b.isBidCampaign()) {
                f();
            }
            String impressionURL = this.f39515b.getImpressionURL();
            if (this.f39515b.getSpareOfferFlag() == 1) {
                str = impressionURL + "&to=1&cbt=" + this.f39515b.getCbt() + "&tmorl=" + this.f39523j;
            } else {
                str = impressionURL + "&to=0&cbt=" + this.f39515b.getCbt() + "&tmorl=" + this.f39523j;
            }
            com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f39515b, this.f39520g, str, false, true, com.mbridge.msdk.click.retry.a.f34472m);
            com.mbridge.msdk.video.module.report.b.d(com.mbridge.msdk.foundation.controller.c.m().d(), this.f39515b);
            m();
            d();
        } catch (Throwable th2) {
            o0.b("NotifyListener", th2.getMessage(), th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        CampaignEx campaignEx;
        Map<String, Long> map;
        String str;
        try {
            CampaignEx campaignEx2 = this.f39515b;
            if (campaignEx2 != null && campaignEx2.isDynamicView() && this.f39517d && !this.f39515b.isCampaignIsFiltered()) {
                this.f39525l = true;
                return;
            }
            if (!this.f39514a || (campaignEx = this.f39515b) == null || TextUtils.isEmpty(campaignEx.getOnlyImpressionURL()) || (map = com.mbridge.msdk.foundation.same.buffer.b.f35425l) == null || map.containsKey(this.f39515b.getOnlyImpressionURL()) || this.f39525l) {
                return;
            }
            com.mbridge.msdk.foundation.same.buffer.b.f35425l.put(this.f39515b.getOnlyImpressionURL(), Long.valueOf(System.currentTimeMillis()));
            String onlyImpressionURL = this.f39515b.getOnlyImpressionURL();
            if (this.f39515b.getSpareOfferFlag() == 1) {
                str = onlyImpressionURL + "&to=1&cbt=" + this.f39515b.getCbt() + "&tmorl=" + this.f39523j;
            } else {
                str = onlyImpressionURL + "&to=0&cbt=" + this.f39515b.getCbt() + "&tmorl=" + this.f39523j;
            }
            String str2 = str;
            if (!this.f39517d) {
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f39515b, this.f39520g, str2, false, true, com.mbridge.msdk.click.retry.a.f34473n);
                b();
            } else if (this.f39515b.isCampaignIsFiltered()) {
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f39515b, this.f39520g, str2, false, true, com.mbridge.msdk.click.retry.a.f34473n);
                b();
            }
            this.f39525l = true;
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        CampaignEx campaignEx;
        List<String> pv_urls;
        try {
            if (!this.f39514a || this.f39526m || (campaignEx = this.f39515b) == null) {
                return;
            }
            this.f39526m = true;
            if ((campaignEx.isDynamicView() && this.f39517d && !this.f39515b.isCampaignIsFiltered()) || (pv_urls = this.f39515b.getPv_urls()) == null || pv_urls.size() <= 0) {
                return;
            }
            Iterator<String> it = pv_urls.iterator();
            while (it.hasNext()) {
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f39515b, this.f39520g, it.next(), false, true);
            }
        } catch (Throwable th2) {
            o0.b("NotifyListener", th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        CampaignEx campaignEx = this.f39515b;
        if (campaignEx == null || TextUtils.isEmpty(campaignEx.getCampaignUnitId()) || this.f39515b.getNativeVideoTracking() == null || this.f39515b.getNativeVideoTracking().i() == null) {
            return;
        }
        Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
        CampaignEx campaignEx2 = this.f39515b;
        com.mbridge.msdk.click.a.a(d11, campaignEx2, campaignEx2.getCampaignUnitId(), this.f39515b.getNativeVideoTracking().i(), false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        com.mbridge.msdk.videocommon.download.a aVar = this.f39518e;
        if (aVar != null) {
            aVar.d(true);
        }
    }
}

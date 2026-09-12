package com.mbridge.msdk.mbbanner.common.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.c;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.foundation.tools.y0;
import com.mbridge.msdk.foundation.tools.z0;
import com.mbridge.msdk.mbbanner.common.util.BannerUtils;
import com.mbridge.msdk.out.MBridgeIds;
import com.transsion.gslb.Utils;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: n, reason: collision with root package name */
    private static final String f36124n = "b";

    /* renamed from: a, reason: collision with root package name */
    private Context f36125a;

    /* renamed from: c, reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.data.b f36127c;

    /* renamed from: d, reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.util.a f36128d;

    /* renamed from: e, reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.listener.b f36129e;

    /* renamed from: f, reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.listener.d f36130f;

    /* renamed from: b, reason: collision with root package name */
    private int f36126b = 0;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f36131g = false;

    /* renamed from: h, reason: collision with root package name */
    private Timer f36132h = new Timer();

    /* renamed from: i, reason: collision with root package name */
    private volatile List<String> f36133i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    private volatile boolean f36134j = false;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f36135k = false;

    /* renamed from: l, reason: collision with root package name */
    private volatile boolean f36136l = false;

    /* renamed from: m, reason: collision with root package name */
    private String f36137m = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f36138a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f36139b;

        a(String str, CampaignEx campaignEx) {
            this.f36138a = str;
            this.f36139b = campaignEx;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (b.this.f36131g) {
                return;
            }
            b.this.f36131g = true;
            b.this.a(this.f36138a, -1, "", false, this.f36139b);
        }
    }

    /* renamed from: com.mbridge.msdk.mbbanner.common.manager.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C0501b extends com.mbridge.msdk.mbbanner.common.response.a {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.mbbanner.common.data.a f36141c;

        C0501b(com.mbridge.msdk.mbbanner.common.data.a aVar) {
            this.f36141c = aVar;
        }

        @Override // com.mbridge.msdk.mbbanner.common.response.a
        public void a(int i11, String str) {
            o0.c(b.f36124n, "requestCampaign--> Fail errorCode:" + i11 + " msg:" + str);
            com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880003);
            bVar.c(i11 + Utils.SEPARATOR + str);
            bVar.a(new MBridgeIds(this.placementId, this.unitId));
            bVar.b(this.f36141c.b());
            b.this.f36128d.a(b.this.f36129e, bVar);
            b.this.f36130f.a(this.unitId);
        }

        @Override // com.mbridge.msdk.mbbanner.common.response.a
        public void a(CampaignUnit campaignUnit) {
            try {
                o0.c(b.f36124n, "requestCampaign--> Succeed");
                campaignUnit.setLocalRequestId(this.f36141c.b());
                b.this.f36128d.a(b.this.f36129e, campaignUnit, this.unitId);
                b.this.a(this.unitId, this.f36141c.b(), campaignUnit);
            } catch (Exception e11) {
                o0.c(b.f36124n, "requestCampaign--> Fail with exception = " + e11.getMessage());
                com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880000);
                bVar.a(new MBridgeIds(this.placementId, this.unitId));
                bVar.b(this.f36141c.b());
                bVar.a((campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().isEmpty()) ? null : campaignUnit.getAds().get(0));
                bVar.a((Throwable) e11);
                b.this.f36128d.a(b.this.f36129e, bVar);
                b.this.f36130f.a(this.unitId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c extends c.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f36143a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f36144b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f36145c;

        c(String str, CampaignEx campaignEx, Context context, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
            this.f36143a = str;
            this.f36144b = campaignEx;
            this.f36145c = context;
        }

        @Override // com.mbridge.msdk.foundation.same.c.a
        public void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, this.f36143a);
            cVar.a(str, eVar);
            com.mbridge.msdk.mbbanner.common.report.a.a(str, cVar, this.f36144b, this.f36145c, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignUnit f36147a;

        d(CampaignUnit campaignUnit) {
            this.f36147a = campaignUnit;
        }

        @Override // java.lang.Runnable
        public void run() {
            o0.c(b.f36124n, "在单独子线程保存数据库 开始");
            j.a(g.a(b.this.f36125a)).a();
            CampaignUnit campaignUnit = this.f36147a;
            if (campaignUnit != null && campaignUnit.getAds() != null && this.f36147a.getAds().size() > 0) {
                BannerUtils.uisList(b.this.f36125a, this.f36147a.getAds());
            }
            o0.c(b.f36124n, "在单独子线程保存数据库 完成");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class e implements com.mbridge.msdk.foundation.same.image.c {

        /* renamed from: a, reason: collision with root package name */
        private b f36149a;

        /* renamed from: b, reason: collision with root package name */
        private String f36150b;

        /* renamed from: c, reason: collision with root package name */
        private CampaignEx f36151c;

        public e(b bVar, String str, CampaignEx campaignEx) {
            this.f36149a = bVar;
            this.f36150b = str;
            this.f36151c = campaignEx;
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            if (MBridgeConstans.DEBUG) {
                o0.c(b.f36124n, "DownloadImageListener campaign image fail");
            }
            b bVar = this.f36149a;
            if (bVar != null) {
                bVar.a(this.f36150b, 1, str2, false, this.f36151c);
            }
            try {
                com.mbridge.msdk.foundation.same.report.metrics.c a11 = com.mbridge.msdk.mbbanner.common.report.a.a(this.f36150b, this.f36151c.getCurrentLocalRid());
                a11.a(this.f36151c);
                a11.e(10);
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                a11.e(10);
                eVar.a("resource_type", 10);
                eVar.a("result", 3);
                eVar.a("url", str2);
                com.mbridge.msdk.mbbanner.common.report.a.a("m_download_end", a11, eVar);
            } catch (Throwable th2) {
                o0.b(b.f36124n, th2.getMessage());
            }
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            if (MBridgeConstans.DEBUG) {
                o0.c(b.f36124n, "DownloadImageListener campaign image success");
            }
            b bVar = this.f36149a;
            if (bVar != null) {
                bVar.a(this.f36150b, 1, str, true, this.f36151c);
            }
            try {
                com.mbridge.msdk.foundation.same.report.metrics.c a11 = com.mbridge.msdk.mbbanner.common.report.a.a(this.f36150b, this.f36151c.getCurrentLocalRid());
                a11.a(this.f36151c);
                a11.e(10);
                a11.e(10);
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("resource_type", 10);
                eVar.a("result", 1);
                eVar.a("url", str);
                com.mbridge.msdk.mbbanner.common.report.a.a("m_download_end", a11, eVar);
            } catch (Throwable th2) {
                o0.b(b.f36124n, th2.getMessage());
            }
        }
    }

    public b(Context context, com.mbridge.msdk.mbbanner.common.data.b bVar, com.mbridge.msdk.mbbanner.common.listener.b bVar2, com.mbridge.msdk.mbbanner.common.util.a aVar) {
        this.f36125a = context.getApplicationContext();
        this.f36127c = bVar;
        this.f36129e = bVar2;
        this.f36128d = aVar;
    }

    private int a(String str) {
        try {
            int c11 = this.f36127c.c();
            if (c11 > this.f36127c.b()) {
                return 0;
            }
            return c11;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    private String a(String str, String str2, CampaignEx campaignEx) {
        File file;
        Throwable th2;
        FileOutputStream fileOutputStream;
        File file2;
        String str3 = "";
        if (!TextUtils.isEmpty(str2)) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    try {
                        String b11 = com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_HTML);
                        String md5 = SameMD5.getMD5(z0.b(str2));
                        if (TextUtils.isEmpty(md5)) {
                            md5 = String.valueOf(System.currentTimeMillis());
                        }
                        file2 = new File(b11, md5.concat(".html"));
                        Uri.parse(str2).getPath();
                        fileOutputStream = new FileOutputStream(file2);
                    } catch (Throwable th3) {
                        th2 = th3;
                        fileOutputStream = null;
                    }
                } catch (Exception e11) {
                    e = e11;
                }
            } catch (Exception e12) {
                o0.b(f36124n, e12.getMessage());
            }
            try {
                fileOutputStream.write(str2.getBytes());
                fileOutputStream.flush();
                str3 = file2.getAbsolutePath();
                fileOutputStream.close();
            } catch (Exception e13) {
                e = e13;
                fileOutputStream2 = fileOutputStream;
                o0.b(f36124n, e.getMessage());
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                file = new File(str3);
                if (!file.exists()) {
                }
                a(str, 2, str2, false, campaignEx);
                return str3;
            } catch (Throwable th4) {
                th2 = th4;
                if (fileOutputStream == null) {
                    throw th2;
                }
                try {
                    fileOutputStream.close();
                    throw th2;
                } catch (Exception e14) {
                    o0.b(f36124n, e14.getMessage());
                    throw th2;
                }
            }
            file = new File(str3);
            if (!file.exists() && file.isFile() && file.canRead()) {
                a(str, 2, str2, true, campaignEx);
            } else {
                a(str, 2, str2, false, campaignEx);
            }
        }
        return str3;
    }

    private List<CampaignEx> a(String str, CampaignUnit campaignUnit) {
        ArrayList arrayList = new ArrayList();
        if (campaignUnit != null) {
            try {
                if (campaignUnit.getAds() != null && campaignUnit.getAds().size() > 0) {
                    ArrayList<CampaignEx> ads = campaignUnit.getAds();
                    o0.c(f36124n, "getNeedShowList 总共返回的campaign有：" + ads.size());
                    w.a(ads);
                    for (int i11 = 0; i11 < ads.size(); i11++) {
                        CampaignEx campaignEx = ads.get(i11);
                        if (campaignEx != null) {
                            if (campaignEx.getOfferType() != 99) {
                                if (TextUtils.isEmpty(campaignEx.getBannerUrl()) && TextUtils.isEmpty(campaignEx.getBannerHtml()) && TextUtils.isEmpty(campaignEx.getImageUrl())) {
                                }
                                if (t0.c(campaignEx)) {
                                    campaignEx.setRtinsType(t0.c(this.f36125a, campaignEx.getPackageName()) ? 1 : 2);
                                }
                                if (com.mbridge.msdk.foundation.same.c.b(this.f36125a, campaignEx)) {
                                    arrayList.add(campaignEx);
                                } else {
                                    t0.a(str, campaignEx, com.mbridge.msdk.foundation.same.a.f35406x);
                                    this.f36137m = "APP ALREADY INSTALLED";
                                }
                                a(campaignEx, this.f36125a, (com.mbridge.msdk.foundation.same.report.metrics.c) null, str, (com.mbridge.msdk.foundation.same.report.metrics.callback.a) null);
                            }
                        }
                    }
                    o0.c(f36124n, "getNeedShowList 返回有以下带有视频素材的campaign：" + arrayList.size());
                }
            } catch (Exception e11) {
                o0.b(f36124n, e11.getMessage());
            }
        }
        return arrayList;
    }

    private void a(CampaignEx campaignEx, Context context, com.mbridge.msdk.foundation.same.report.metrics.c cVar, String str, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
        try {
            com.mbridge.msdk.foundation.same.c.a(campaignEx, context, cVar, new c(str, campaignEx, context, aVar));
        } catch (Exception e11) {
            o0.b(f36124n, e11.getMessage());
        }
    }

    private void a(CampaignUnit campaignUnit) {
        new Thread(new d(campaignUnit)).start();
    }

    private void a(String str, int i11) {
        if (this.f36136l) {
            return;
        }
        if ((this.f36134j || this.f36135k) && this.f36133i.size() == 0) {
            o0.c(f36124n, "在子线程处理业务逻辑 完成");
            this.f36131g = true;
            this.f36136l = true;
            this.f36132h.cancel();
            this.f36128d.a(this.f36129e, str, i11);
            this.f36130f.a(str);
        }
    }

    private void a(String str, int i11, CampaignEx campaignEx) {
        this.f36132h.schedule(new a(str, campaignEx), i11);
    }

    private void a(String str, CampaignEx campaignEx) {
        String str2 = f36124n;
        o0.c(str2, "在子线程处理业务逻辑 完成");
        o0.c(str2, "downloadResource--> Fail");
        this.f36131g = true;
        com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880027);
        MBridgeIds mBridgeIds = new MBridgeIds();
        mBridgeIds.setUnitId(str);
        bVar.a(mBridgeIds);
        bVar.b(this.f36127c.a());
        bVar.a(campaignEx);
        this.f36128d.b(this.f36129e, bVar);
        this.f36130f.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, CampaignUnit campaignUnit) {
        CampaignEx campaignEx;
        if (campaignUnit == null) {
            com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880003);
            MBridgeIds mBridgeIds = new MBridgeIds();
            mBridgeIds.setUnitId(str);
            bVar.a(mBridgeIds);
            bVar.b(str2);
            this.f36128d.a(this.f36129e, bVar);
            this.f36130f.a(str);
            return;
        }
        List<CampaignEx> a11 = a(str, campaignUnit);
        a(campaignUnit);
        int i11 = 0;
        if (a11 == null || a11.size() == 0) {
            o0.c(f36124n, "tryDownloadOnLoadSuccess 返回的campaign 没有符合下载规则的");
            com.mbridge.msdk.foundation.error.b bVar2 = this.f36137m.contains("INSTALLED") ? new com.mbridge.msdk.foundation.error.b(880021, "APP ALREADY INSTALLED") : new com.mbridge.msdk.foundation.error.b(880003);
            MBridgeIds mBridgeIds2 = new MBridgeIds();
            mBridgeIds2.setUnitId(str);
            bVar2.a(mBridgeIds2);
            bVar2.b(str2);
            if (campaignUnit.getAds() != null && campaignUnit.getAds().size() > 0 && (campaignEx = campaignUnit.getAds().get(0)) != null) {
                bVar2.a(campaignEx);
            }
            this.f36128d.a(this.f36129e, bVar2);
            this.f36130f.a(str);
            return;
        }
        o0.c(f36124n, "在子线程处理业务逻辑 开始");
        CampaignEx campaignEx2 = a11.get(0);
        a(str, 60000, campaignEx2);
        b(campaignUnit.getSessionId());
        a(str, a11);
        String trim = campaignEx2.getBannerUrl().trim();
        if (TextUtils.isEmpty(trim)) {
            String trim2 = campaignEx2.getBannerHtml().trim();
            if (TextUtils.isEmpty(trim2)) {
                this.f36135k = true;
                this.f36134j = true;
            } else {
                String a12 = a(str, trim2, campaignEx2);
                if (a11.size() > 0) {
                    while (i11 < a11.size()) {
                        a11.get(i11).setBannerHtml(a12);
                        a11.get(i11).setHasMBTplMark(trim2.contains("<MBTPLMARK>"));
                        i11++;
                    }
                }
            }
        } else {
            b(str, trim, campaignEx2);
            if (a11.size() > 0) {
                while (i11 < a11.size()) {
                    a11.get(i11).setBannerUrl(campaignEx2.getBannerUrl());
                    a11.get(i11).setHasMBTplMark(true);
                    i11++;
                }
            }
        }
        b(str, a11);
    }

    private void a(String str, List<CampaignEx> list) {
        int i11 = this.f36126b;
        if (list != null) {
            try {
                if (list.size() > 0) {
                    i11 += list.size();
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                return;
            }
        }
        if (i11 > this.f36127c.b()) {
            o0.c(f36124n, "saveNextOffset 重置offset为0");
            i11 = 0;
        }
        o0.c(f36124n, "saveNextOffset 算出 下次的offset是:" + i11);
        if (y0.b(str)) {
            this.f36127c.a(i11);
        }
    }

    private String b() {
        return this.f36127c.d();
    }

    private void b(String str) {
        this.f36127c.b(str);
    }

    private void b(String str, String str2, CampaignEx campaignEx) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        a(str, 3, str2, true, campaignEx);
    }

    private void b(String str, List<CampaignEx> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (CampaignEx campaignEx : list) {
            if (!TextUtils.isEmpty(campaignEx.getImageUrl())) {
                this.f36133i.add(campaignEx.getImageUrl());
                com.mbridge.msdk.foundation.same.image.b.a(this.f36125a).a(campaignEx.getImageUrl(), new e(this, str, campaignEx));
                com.mbridge.msdk.foundation.same.report.metrics.c a11 = com.mbridge.msdk.mbbanner.common.report.a.a(str, campaignEx.getCurrentLocalRid());
                a11.a(campaignEx);
                a11.e(10);
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("resource_type", 10);
                com.mbridge.msdk.mbbanner.common.report.a.a("m_download_start", a11, eVar);
            }
        }
    }

    public void a(String str, int i11, String str2, boolean z10, CampaignEx campaignEx) {
        if (!z10) {
            if (i11 == -1) {
                o0.b(f36124n, " unitId =" + str + " --> time out!");
            }
            this.f36132h.cancel();
            a(str, campaignEx);
            return;
        }
        if (i11 == 1) {
            o0.c(f36124n, "downloadResource--> Success Image");
            synchronized (this) {
                try {
                    this.f36133i.remove(str2);
                    if (this.f36133i.size() == 0) {
                        a(str, i11);
                    }
                } finally {
                }
            }
            return;
        }
        if (i11 == 2) {
            o0.c(f36124n, "downloadResource--> Success banner_html");
            this.f36135k = true;
            a(str, i11);
        } else if (i11 == 3) {
            o0.c(f36124n, "downloadResource--> Success banner_url");
            this.f36134j = true;
            a(str, i11);
        }
    }

    public void a(String str, String str2, com.mbridge.msdk.mbbanner.common.data.a aVar, com.mbridge.msdk.mbbanner.common.listener.d dVar) {
        boolean z10;
        try {
            o0.c(f36124n, "requestCampaign--> started");
            this.f36130f = dVar;
            C0501b c0501b = new C0501b(aVar);
            c0501b.setUnitId(str2);
            c0501b.setPlacementId(str);
            c0501b.setAdType(296);
            com.mbridge.msdk.mbbanner.common.request.a aVar2 = new com.mbridge.msdk.mbbanner.common.request.a(this.f36125a);
            this.f36126b = a(str2);
            com.mbridge.msdk.foundation.same.net.wrapper.e a11 = com.mbridge.msdk.mbbanner.common.data.c.a(false, this.f36125a, str2, b(), this.f36126b, aVar);
            String d11 = t0.d(str2);
            if (!TextUtils.isEmpty(d11)) {
                a11.a(com.mbridge.msdk.foundation.same.report.j.f35620b, d11);
            }
            String a12 = aVar.a();
            if (TextUtils.isEmpty(a12)) {
                z10 = false;
            } else {
                c0501b.a(a12);
                z10 = true;
            }
            this.f36128d.a(z10);
            aVar2.choiceV3OrV5BySetting(1, a11, c0501b, a12, 30000L);
        } catch (Exception e11) {
            o0.b(f36124n, e11.getMessage());
            com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880002);
            bVar.a(new MBridgeIds(str, str2));
            this.f36128d.a(this.f36129e, bVar);
            this.f36130f.a(str2);
        }
    }
}

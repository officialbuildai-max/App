package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.download.download.HTMLResourceManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.q0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
public class l {

    /* renamed from: c, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.listener.a f39990c;

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> f39992e;

    /* renamed from: h, reason: collision with root package name */
    private Context f39995h;

    /* renamed from: j, reason: collision with root package name */
    private String f39997j;

    /* renamed from: k, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.setting.c f39998k;

    /* renamed from: m, reason: collision with root package name */
    private int f40000m;

    /* renamed from: p, reason: collision with root package name */
    private k f40003p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f40004q;

    /* renamed from: a, reason: collision with root package name */
    private List<CampaignEx> f39988a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private boolean f39989b = true;

    /* renamed from: d, reason: collision with root package name */
    private String f39991d = "";

    /* renamed from: f, reason: collision with root package name */
    private c f39993f = new a();

    /* renamed from: g, reason: collision with root package name */
    private CopyOnWriteArrayList<Map<String, com.mbridge.msdk.videocommon.download.a>> f39994g = new CopyOnWriteArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    private long f39996i = 3600;

    /* renamed from: l, reason: collision with root package name */
    private int f39999l = 1;

    /* renamed from: n, reason: collision with root package name */
    com.mbridge.msdk.setting.l f40001n = null;

    /* renamed from: o, reason: collision with root package name */
    com.mbridge.msdk.setting.l f40002o = null;

    /* loaded from: classes5.dex */
    class a implements c {
        a() {
        }

        @Override // com.mbridge.msdk.videocommon.download.c
        public void onProgress(long j11, int i11) {
            if (i11 == 5 || i11 == 4) {
                l.this.f39989b = true;
                l.this.d();
            }
            if (i11 == 2) {
                l.this.f39989b = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements com.mbridge.msdk.videocommon.listener.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f40006a;

        b(CampaignEx campaignEx) {
            this.f40006a = campaignEx;
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public void a(String str) {
            if (l.this.f39990c != null) {
                l.this.f39990c.a(str);
            }
            if (l.this.f39992e == null || l.this.f39992e.size() <= 0 || this.f40006a == null) {
                return;
            }
            com.mbridge.msdk.videocommon.listener.a aVar = (com.mbridge.msdk.videocommon.listener.a) l.this.f39992e.get(this.f40006a.getRequestId() + "_" + this.f40006a.getSecondRequestIndex());
            if (aVar != null) {
                aVar.a(str);
                l.this.f39992e.remove(this.f40006a.getRequestId() + "_" + this.f40006a.getSecondRequestIndex());
            }
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public void a(String str, String str2) {
            if (l.this.f39990c != null) {
                l.this.f39990c.a(str, str2);
            }
            CampaignEx campaignEx = this.f40006a;
            if (campaignEx != null && campaignEx.getRsIgnoreCheckRule() != null && this.f40006a.getRsIgnoreCheckRule().size() > 0 && this.f40006a.getRsIgnoreCheckRule().contains(0)) {
                o0.c("UnitCacheCtroller", "Is not check video download status");
                return;
            }
            if (l.this.f39992e == null || l.this.f39992e.size() <= 0 || this.f40006a == null) {
                return;
            }
            com.mbridge.msdk.videocommon.listener.a aVar = (com.mbridge.msdk.videocommon.listener.a) l.this.f39992e.get(this.f40006a.getRequestId() + "_" + this.f40006a.getSecondRequestIndex());
            if (aVar != null) {
                aVar.a(str, str2);
                l.this.f39992e.remove(this.f40006a.getRequestId() + "_" + this.f40006a.getSecondRequestIndex());
            }
        }
    }

    public l(Context context, CampaignEx campaignEx, String str, int i11) {
        this.f40000m = 1;
        try {
            boolean b11 = j.a().b(i11);
            this.f40004q = b11;
            if (b11) {
                this.f39997j = str;
                this.f40000m = i11;
                this.f40003p = new k(campaignEx, str, i11);
                return;
            }
        } catch (Exception unused) {
            this.f40003p = null;
            this.f40004q = false;
        }
        this.f39995h = com.mbridge.msdk.foundation.controller.c.m().d();
        List<CampaignEx> list = this.f39988a;
        if (list != null && campaignEx != null) {
            list.add(campaignEx);
        }
        this.f39997j = str;
        this.f40000m = i11;
        a(this.f39988a);
    }

    public l(Context context, List<CampaignEx> list, String str, int i11) {
        this.f40000m = 1;
        try {
            boolean b11 = j.a().b(i11);
            this.f40004q = b11;
            if (b11) {
                this.f39997j = str;
                this.f40000m = i11;
                this.f40003p = new k(list, str, i11);
                return;
            }
        } catch (Exception unused) {
            this.f40003p = null;
            this.f40004q = false;
        }
        this.f39995h = com.mbridge.msdk.foundation.controller.c.m().d();
        List<CampaignEx> list2 = this.f39988a;
        if (list2 != null && list != null) {
            list2.addAll(list);
        }
        this.f39997j = str;
        this.f40000m = i11;
        a(this.f39988a);
    }

    private int a(CampaignEx campaignEx) {
        try {
            com.mbridge.msdk.setting.l lVar = this.f40001n;
            if (lVar != null) {
                return lVar.C();
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("UnitCacheCtroller", e11.getMessage());
            }
        }
        return 100;
    }

    private void a() {
        CopyOnWriteArrayList<Map<String, com.mbridge.msdk.videocommon.download.a>> copyOnWriteArrayList = this.f39994g;
        if (copyOnWriteArrayList != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    int i11 = 0;
                    while (i11 < this.f39994g.size()) {
                        try {
                            Map<String, com.mbridge.msdk.videocommon.download.a> map = this.f39994g.get(i11);
                            Iterator<Map.Entry<String, com.mbridge.msdk.videocommon.download.a>> it = map.entrySet().iterator();
                            while (it.hasNext()) {
                                com.mbridge.msdk.videocommon.download.a value = it.next().getValue();
                                if (value != null && value.c() != null && value.o()) {
                                    value.t();
                                    this.f39994g.remove(map);
                                    i11--;
                                }
                            }
                            i11++;
                        } finally {
                        }
                    }
                }
            } catch (Throwable unused) {
                o0.b("UnitCacheCtroller", "cleanDisplayTask ERROR");
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(5:56|57|58|59|(1:61)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01d4, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0202, code lost:
    
        if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0204, code lost:
    
        com.mbridge.msdk.foundation.tools.o0.b("UnitCacheCtroller", r4.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x020e, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0213, code lost:
    
        throw r12;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r12) {
        /*
            Method dump skipped, instructions count: 560
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.l.a(java.util.List):void");
    }

    private boolean a(int i11, CampaignEx campaignEx, String str) {
        if (campaignEx.isDynamicView()) {
            return true;
        }
        if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(1)) {
            o0.c("UnitCacheCtroller", "Is not check template download status");
            return true;
        }
        if (!TextUtils.isEmpty(str) && campaignEx.getLoadTimeoutState() == 0) {
            o0.a("UnitCacheCtroller", "check template 下载情况：" + H5DownLoadManager.getInstance().getH5ResAddress(str));
            if (H5DownLoadManager.getInstance().getH5ResAddress(str) == null) {
                return false;
            }
        }
        return true;
    }

    private boolean a(CampaignEx.c cVar) {
        return true;
    }

    public static boolean a(com.mbridge.msdk.videocommon.download.a aVar, int i11) {
        long h11 = aVar.h();
        long e11 = aVar.e();
        if (TextUtils.isEmpty(aVar.d())) {
            o0.a("UnitCacheCtroller", "checkVideoDownload video done return true");
            return true;
        }
        if (i11 == 0) {
            if (aVar.c() != null && !TextUtils.isEmpty(aVar.c().getVideoUrlEncode())) {
                return true;
            }
        } else if (e11 > 0 && h11 * 100 >= e11 * i11) {
            if (i11 != 100 || aVar.j() == 5) {
                return true;
            }
            aVar.b();
            return false;
        }
        return false;
    }

    public static boolean a(com.mbridge.msdk.videocommon.download.a aVar, int i11, boolean z10) {
        long h11 = aVar.h();
        long e11 = aVar.e();
        if (TextUtils.isEmpty(aVar.d())) {
            o0.a("UnitCacheCtroller", "checkVideoDownload video done return true");
            return true;
        }
        CampaignEx c11 = aVar.c();
        if (c11 != null) {
            if (c11.getRsIgnoreCheckRule() != null && c11.getRsIgnoreCheckRule().size() > 0 && c11.getRsIgnoreCheckRule().contains(0)) {
                o0.c("UnitCacheCtroller", "Is not check video download status");
                return true;
            }
            if (c11.getIsTimeoutCheckVideoStatus() == 1 && c11.getVideoCheckType() == 1) {
                return true;
            }
            if (z10 && c11.getVideoCheckType() == 1) {
                if (i11 == 0) {
                    return true;
                }
                if ((e11 != 0 || h11 != 0) && h11 >= (i11 / 100) * e11) {
                    c11.setIsTimeoutCheckVideoStatus(1);
                    return true;
                }
            }
        }
        return a(aVar, i11);
    }

    private boolean a(String str, CampaignEx campaignEx) {
        try {
            if (campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(2)) {
                return (campaignEx.isDynamicView() && !t0.l(str)) || y0.a(str) || b(str, campaignEx);
            }
            o0.c("UnitCacheCtroller", "Is not check endCard download status : " + str);
            return true;
        } catch (Throwable th2) {
            o0.b("UnitCacheCtroller", th2.getMessage(), th2);
            return false;
        }
    }

    private boolean a(CopyOnWriteArrayList<Map<String, com.mbridge.msdk.videocommon.download.a>> copyOnWriteArrayList) {
        try {
            Iterator<Map<String, com.mbridge.msdk.videocommon.download.a>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                Map<String, com.mbridge.msdk.videocommon.download.a> next = it.next();
                if (next != null) {
                    Iterator<Map.Entry<String, com.mbridge.msdk.videocommon.download.a>> it2 = next.entrySet().iterator();
                    while (it2.hasNext()) {
                        if (it2.next().getValue().j() == 1) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (Throwable th2) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            th2.printStackTrace();
            return false;
        }
    }

    private int b(CampaignEx campaignEx) {
        if (campaignEx != null) {
            return campaignEx.getReady_rate() != -1 ? campaignEx.getReady_rate() : c(campaignEx);
        }
        return -1;
    }

    private boolean b(String str, CampaignEx campaignEx) {
        if (campaignEx.isMraid() || TextUtils.isEmpty(str)) {
            return true;
        }
        if (campaignEx.getLoadTimeoutState() == 1 && !d(campaignEx)) {
            return true;
        }
        if (campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(2)) {
            return y0.b(H5DownLoadManager.getInstance().getH5ResAddress(str)) || y0.b(HTMLResourceManager.getInstance().getHtmlContentFromUrl(str));
        }
        o0.c("UnitCacheCtroller", "Is not check endCard download status : " + str);
        return true;
    }

    private int c(CampaignEx campaignEx) {
        try {
            if (campaignEx.getAdType() == 298) {
                if (this.f40002o == null) {
                    this.f40002o = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b(), this.f39997j);
                }
                return this.f40002o.C();
            }
            if (campaignEx.getAdType() == 42) {
                return a((CampaignEx) null);
            }
            if (this.f39998k == null) {
                this.f39998k = com.mbridge.msdk.videocommon.setting.b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), this.f39997j, false);
            }
            return this.f39998k.w();
        } catch (Throwable th2) {
            o0.b("UnitCacheCtroller", th2.getMessage(), th2);
            return 100;
        }
    }

    private boolean d(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return false;
        }
        try {
            return campaignEx.getPlayable_ads_without_video() == 2;
        } catch (Throwable th2) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            th2.printStackTrace();
            return false;
        }
    }

    private void e(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("cache", 1);
                eVar.a(CampaignEx.JSON_KEY_READY_RATE, Integer.valueOf(b(campaignEx)));
                if (b(campaignEx) == 100) {
                    eVar.a("resumed_breakpoint", "2");
                } else {
                    eVar.a("resumed_breakpoint", "1");
                }
                eVar.a("resource_type", 4);
                eVar.a("scenes", "1");
                eVar.a("url", campaignEx.getVideoUrlEncode());
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_download_start", campaignEx, eVar);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
            }
        }
    }

    public com.mbridge.msdk.videocommon.download.a a(int i11, boolean z10) {
        k kVar;
        if (this.f40004q && (kVar = this.f40003p) != null) {
            return kVar.d();
        }
        try {
            return b(i11, z10);
        } catch (Throwable th2) {
            o0.b("UnitCacheCtroller", th2.getMessage(), th2);
            return null;
        }
    }

    public com.mbridge.msdk.videocommon.download.a a(String str) {
        k kVar;
        if (this.f40004q && (kVar = this.f40003p) != null) {
            return kVar.a(str);
        }
        CopyOnWriteArrayList<Map<String, com.mbridge.msdk.videocommon.download.a>> copyOnWriteArrayList = this.f39994g;
        if (copyOnWriteArrayList == null) {
            return null;
        }
        synchronized (copyOnWriteArrayList) {
            try {
                try {
                    Iterator<Map<String, com.mbridge.msdk.videocommon.download.a>> it = this.f39994g.iterator();
                    while (it.hasNext()) {
                        Map<String, com.mbridge.msdk.videocommon.download.a> next = it.next();
                        if (next != null && next.containsKey(str)) {
                            return next.get(str);
                        }
                    }
                } catch (Throwable unused) {
                    o0.b("UnitCacheCtroller", "failed to get campaignTast by cid");
                }
                return null;
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x02dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<com.mbridge.msdk.videocommon.download.a> a(java.lang.String r26, int r27, boolean r28, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r29, boolean r30, com.mbridge.msdk.foundation.same.report.metrics.e r31) {
        /*
            Method dump skipped, instructions count: 753
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.l.a(java.lang.String, int, boolean, java.util.List, boolean, com.mbridge.msdk.foundation.same.report.metrics.e):java.util.List");
    }

    public void a(com.mbridge.msdk.videocommon.listener.a aVar) {
        k kVar;
        if (!this.f40004q || (kVar = this.f40003p) == null) {
            this.f39990c = aVar;
        } else {
            kVar.a(aVar);
        }
    }

    public void a(String str, com.mbridge.msdk.videocommon.listener.a aVar) {
        k kVar;
        if (this.f40004q && (kVar = this.f40003p) != null) {
            kVar.a(str, aVar);
            return;
        }
        if (this.f39992e == null) {
            this.f39992e = new ConcurrentHashMap<>();
        }
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f39992e.put(str, aVar);
    }

    public boolean a(List<CampaignEx> list, String str) {
        if (list == null || list.size() == 0) {
            return false;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            CampaignEx campaignEx = list.get(i11);
            if (campaignEx == null || !a(new com.mbridge.msdk.videocommon.download.a(com.mbridge.msdk.foundation.controller.c.m().d(), campaignEx, str, this.f39999l), b(campaignEx), false) || !a(campaignEx.getendcard_url(), campaignEx)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x021d A[Catch: all -> 0x0033, Exception -> 0x0036, TRY_ENTER, TryCatch #1 {Exception -> 0x0036, blocks: (B:12:0x0019, B:16:0x0025, B:20:0x0075, B:21:0x007a, B:23:0x0082, B:24:0x0092, B:26:0x0098, B:28:0x00a6, B:30:0x00b2, B:31:0x00bc, B:33:0x00c2, B:45:0x00e4, B:54:0x00ec, B:58:0x00f3, B:60:0x0103, B:61:0x010b, B:65:0x0166, B:67:0x0178, B:74:0x0189, B:77:0x018f, B:78:0x023b, B:83:0x019d, B:91:0x01a7, B:93:0x01ad, B:100:0x01b9, B:102:0x01c6, B:104:0x01d0, B:106:0x01de, B:112:0x0206, B:154:0x020c, B:156:0x0212, B:114:0x021d, B:122:0x0233, B:126:0x0240, B:128:0x024b, B:130:0x024f, B:132:0x0259, B:134:0x025f, B:139:0x0267, B:142:0x0271, B:144:0x027b, B:146:0x0281, B:161:0x0119, B:163:0x011f, B:165:0x0129, B:168:0x0136, B:170:0x013c, B:187:0x0142, B:172:0x0146, B:174:0x014c, B:179:0x0154, B:181:0x015e, B:198:0x0039, B:200:0x0045, B:203:0x005b, B:204:0x02a3, B:209:0x004f), top: B:11:0x0019, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x020c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0082 A[Catch: all -> 0x0033, Exception -> 0x0036, TryCatch #1 {Exception -> 0x0036, blocks: (B:12:0x0019, B:16:0x0025, B:20:0x0075, B:21:0x007a, B:23:0x0082, B:24:0x0092, B:26:0x0098, B:28:0x00a6, B:30:0x00b2, B:31:0x00bc, B:33:0x00c2, B:45:0x00e4, B:54:0x00ec, B:58:0x00f3, B:60:0x0103, B:61:0x010b, B:65:0x0166, B:67:0x0178, B:74:0x0189, B:77:0x018f, B:78:0x023b, B:83:0x019d, B:91:0x01a7, B:93:0x01ad, B:100:0x01b9, B:102:0x01c6, B:104:0x01d0, B:106:0x01de, B:112:0x0206, B:154:0x020c, B:156:0x0212, B:114:0x021d, B:122:0x0233, B:126:0x0240, B:128:0x024b, B:130:0x024f, B:132:0x0259, B:134:0x025f, B:139:0x0267, B:142:0x0271, B:144:0x027b, B:146:0x0281, B:161:0x0119, B:163:0x011f, B:165:0x0129, B:168:0x0136, B:170:0x013c, B:187:0x0142, B:172:0x0146, B:174:0x014c, B:179:0x0154, B:181:0x015e, B:198:0x0039, B:200:0x0045, B:203:0x005b, B:204:0x02a3, B:209:0x004f), top: B:11:0x0019, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.mbridge.msdk.videocommon.download.a b(int r27, boolean r28) {
        /*
            Method dump skipped, instructions count: 695
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.l.b(int, boolean):com.mbridge.msdk.videocommon.download.a");
    }

    public void b() {
        CopyOnWriteArrayList<Map<String, com.mbridge.msdk.videocommon.download.a>> copyOnWriteArrayList;
        k kVar;
        if (this.f40004q && (kVar = this.f40003p) != null) {
            kVar.a();
            return;
        }
        if (q0.a().a("u_n_c_e_d", true) || (copyOnWriteArrayList = this.f39994g) == null) {
            return;
        }
        try {
            synchronized (copyOnWriteArrayList) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    int i11 = 0;
                    while (i11 < this.f39994g.size()) {
                        Map<String, com.mbridge.msdk.videocommon.download.a> map = this.f39994g.get(i11);
                        Iterator<Map.Entry<String, com.mbridge.msdk.videocommon.download.a>> it = map.entrySet().iterator();
                        while (it.hasNext()) {
                            com.mbridge.msdk.videocommon.download.a value = it.next().getValue();
                            if (value != null) {
                                if (currentTimeMillis - value.i() > this.f39996i * 1000 && value.j() == 1) {
                                    value.c("download timeout");
                                    value.c(this.f39999l);
                                    value.b();
                                    this.f39994g.remove(map);
                                    i11--;
                                }
                                if (value.j() != 1 && value.j() != 5 && value.j() != 0) {
                                    value.b();
                                    this.f39994g.remove(map);
                                    i11--;
                                }
                            }
                        }
                        i11++;
                    }
                } finally {
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void b(String str) {
        CopyOnWriteArrayList<Map<String, com.mbridge.msdk.videocommon.download.a>> copyOnWriteArrayList;
        k kVar;
        if (this.f40004q && (kVar = this.f40003p) != null) {
            kVar.c(str);
            return;
        }
        try {
            synchronized (this.f39994g) {
                try {
                    if (!TextUtils.isEmpty(str) && (copyOnWriteArrayList = this.f39994g) != null && copyOnWriteArrayList.size() > 0) {
                        Iterator<Map<String, com.mbridge.msdk.videocommon.download.a>> it = this.f39994g.iterator();
                        while (it.hasNext()) {
                            Map<String, com.mbridge.msdk.videocommon.download.a> next = it.next();
                            if (next != null) {
                                for (Map.Entry<String, com.mbridge.msdk.videocommon.download.a> entry : next.entrySet()) {
                                    if (entry != null && TextUtils.equals(entry.getKey(), str)) {
                                        this.f39994g.remove(next);
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("UnitCacheCtroller", e11.getMessage());
            }
        }
    }

    public void b(List<CampaignEx> list) {
        k kVar;
        if (this.f40004q && (kVar = this.f40003p) != null) {
            kVar.a(list);
            return;
        }
        List<CampaignEx> list2 = this.f39988a;
        if (list2 != null && list != null) {
            list2.addAll(list);
        }
        a(this.f39988a);
    }

    public CopyOnWriteArrayList<Map<String, com.mbridge.msdk.videocommon.download.a>> c() {
        k kVar;
        return (!this.f40004q || (kVar = this.f40003p) == null) ? this.f39994g : kVar.e();
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01d8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01e4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0042 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0042 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00df A[Catch: all -> 0x0022, TryCatch #1 {all -> 0x0022, blocks: (B:12:0x0016, B:14:0x001f, B:15:0x0025, B:16:0x002b, B:18:0x0031, B:21:0x003a, B:22:0x0042, B:24:0x0048, B:27:0x0058, B:30:0x005f, B:32:0x0065, B:33:0x0067, B:36:0x0073, B:37:0x0083, B:39:0x0094, B:41:0x0098, B:42:0x00a0, B:43:0x00a4, B:49:0x00b9, B:51:0x00bd, B:52:0x00d1, B:54:0x00d5, B:55:0x00db, B:57:0x00df, B:59:0x00e3, B:60:0x00f7, B:62:0x00fb, B:63:0x0129, B:65:0x012e, B:66:0x0134, B:70:0x016b, B:71:0x016f, B:73:0x0174, B:78:0x017c, B:82:0x0182, B:84:0x0186, B:85:0x018f, B:87:0x0193, B:91:0x019d, B:92:0x01a1, B:95:0x01c3, B:99:0x01c9, B:101:0x01cd, B:106:0x01db, B:112:0x01e4, B:114:0x01ef, B:117:0x01f3, B:120:0x01f7, B:123:0x01fd, B:136:0x0208, B:141:0x0210, B:126:0x0215, B:131:0x0222, B:134:0x021f, B:155:0x0100, B:157:0x0104, B:160:0x0119, B:162:0x011f, B:164:0x0123, B:178:0x0227), top: B:11:0x0016, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x012e A[Catch: all -> 0x0022, TryCatch #1 {all -> 0x0022, blocks: (B:12:0x0016, B:14:0x001f, B:15:0x0025, B:16:0x002b, B:18:0x0031, B:21:0x003a, B:22:0x0042, B:24:0x0048, B:27:0x0058, B:30:0x005f, B:32:0x0065, B:33:0x0067, B:36:0x0073, B:37:0x0083, B:39:0x0094, B:41:0x0098, B:42:0x00a0, B:43:0x00a4, B:49:0x00b9, B:51:0x00bd, B:52:0x00d1, B:54:0x00d5, B:55:0x00db, B:57:0x00df, B:59:0x00e3, B:60:0x00f7, B:62:0x00fb, B:63:0x0129, B:65:0x012e, B:66:0x0134, B:70:0x016b, B:71:0x016f, B:73:0x0174, B:78:0x017c, B:82:0x0182, B:84:0x0186, B:85:0x018f, B:87:0x0193, B:91:0x019d, B:92:0x01a1, B:95:0x01c3, B:99:0x01c9, B:101:0x01cd, B:106:0x01db, B:112:0x01e4, B:114:0x01ef, B:117:0x01f3, B:120:0x01f7, B:123:0x01fd, B:136:0x0208, B:141:0x0210, B:126:0x0215, B:131:0x0222, B:134:0x021f, B:155:0x0100, B:157:0x0104, B:160:0x0119, B:162:0x011f, B:164:0x0123, B:178:0x0227), top: B:11:0x0016, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0167  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d() {
        /*
            Method dump skipped, instructions count: 556
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.l.d():void");
    }

    public void e() {
        k kVar;
        if (this.f40004q && (kVar = this.f40003p) != null) {
            kVar.k();
            return;
        }
        CopyOnWriteArrayList<Map<String, com.mbridge.msdk.videocommon.download.a>> copyOnWriteArrayList = this.f39994g;
        if (copyOnWriteArrayList != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    try {
                        Iterator<Map<String, com.mbridge.msdk.videocommon.download.a>> it = this.f39994g.iterator();
                        while (it.hasNext()) {
                            Map<String, com.mbridge.msdk.videocommon.download.a> next = it.next();
                            if (next != null) {
                                Iterator<Map.Entry<String, com.mbridge.msdk.videocommon.download.a>> it2 = next.entrySet().iterator();
                                while (it2.hasNext()) {
                                    com.mbridge.msdk.videocommon.download.a value = it2.next().getValue();
                                    if (value != null && value.j() == 1) {
                                        value.c("playing and stop download");
                                        value.b();
                                        this.f39994g.remove(next);
                                        return;
                                    }
                                }
                            }
                        }
                    } finally {
                    }
                }
            } catch (Throwable th2) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("UnitCacheCtroller", th2.getMessage());
                }
            }
        }
    }

    public void f(CampaignEx campaignEx) {
        k kVar;
        if (this.f40004q && (kVar = this.f40003p) != null) {
            kVar.h(campaignEx);
            return;
        }
        List<CampaignEx> list = this.f39988a;
        if (list != null && campaignEx != null) {
            list.add(campaignEx);
        }
        a(this.f39988a);
    }
}

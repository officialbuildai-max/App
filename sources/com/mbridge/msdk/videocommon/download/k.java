package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.utils.Utils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.listener.a f39977a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> f39978b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f39979c;

    /* renamed from: d, reason: collision with root package name */
    private final String f39980d;

    /* renamed from: e, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.setting.c f39981e;

    /* renamed from: f, reason: collision with root package name */
    private final int f39982f;

    /* renamed from: g, reason: collision with root package name */
    private final CopyOnWriteArrayList<CampaignEx> f39983g;

    /* renamed from: h, reason: collision with root package name */
    private final ConcurrentHashMap<String, com.mbridge.msdk.videocommon.download.a> f39984h;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a implements com.mbridge.msdk.videocommon.listener.a {

        /* renamed from: a, reason: collision with root package name */
        private final String f39985a;

        /* renamed from: b, reason: collision with root package name */
        private final ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> f39986b;

        /* renamed from: c, reason: collision with root package name */
        private final com.mbridge.msdk.videocommon.listener.a f39987c;

        public a(String str, ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> concurrentHashMap, com.mbridge.msdk.videocommon.listener.a aVar) {
            this.f39985a = str;
            this.f39986b = concurrentHashMap;
            this.f39987c = aVar;
        }

        private void b(String str) {
            com.mbridge.msdk.videocommon.listener.a aVar = this.f39987c;
            if (aVar != null) {
                try {
                    aVar.a(str);
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("RewardVideoRefactorManager", this.f39985a + " videoDownloadListener onDownLoadDone error: " + e11.getMessage());
                    }
                }
            }
            ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> concurrentHashMap = this.f39986b;
            if (concurrentHashMap != null) {
                Iterator<com.mbridge.msdk.videocommon.listener.a> it = concurrentHashMap.values().iterator();
                while (it.hasNext()) {
                    try {
                        it.next().a(str);
                    } catch (Exception e12) {
                        if (MBridgeConstans.DEBUG) {
                            o0.b("RewardVideoRefactorManager", this.f39985a + " videoDownloadListener onDownLoadDone error: " + e12.getMessage());
                        }
                    }
                }
            }
        }

        private void b(String str, String str2) {
            com.mbridge.msdk.videocommon.listener.a aVar = this.f39987c;
            if (aVar != null) {
                try {
                    aVar.a(str, str2);
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("RewardVideoRefactorManager", this.f39985a + " videoDownloadListener onDownLoadFailed error: " + e11.getMessage());
                    }
                }
            }
            ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> concurrentHashMap = this.f39986b;
            if (concurrentHashMap != null) {
                Iterator<com.mbridge.msdk.videocommon.listener.a> it = concurrentHashMap.values().iterator();
                while (it.hasNext()) {
                    try {
                        it.next().a(str, str2);
                    } catch (Exception e12) {
                        if (MBridgeConstans.DEBUG) {
                            o0.b("RewardVideoRefactorManager", this.f39985a + " videoDownloadListener onDownLoadFailed error: " + e12.getMessage());
                        }
                    }
                }
            }
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public void a(String str) {
            b(str);
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public void a(String str, String str2) {
            b(str, str2);
        }
    }

    public k(CampaignEx campaignEx, String str, int i11) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.f39983g = copyOnWriteArrayList;
        this.f39984h = new ConcurrentHashMap<>();
        this.f39979c = com.mbridge.msdk.foundation.controller.c.m().d();
        this.f39980d = str;
        this.f39982f = i11;
        if (campaignEx != null) {
            copyOnWriteArrayList.add(campaignEx);
        }
    }

    public k(List<CampaignEx> list, String str, int i11) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.f39983g = copyOnWriteArrayList;
        this.f39984h = new ConcurrentHashMap<>();
        this.f39979c = com.mbridge.msdk.foundation.controller.c.m().d();
        this.f39980d = str;
        this.f39982f = i11;
        if (list != null) {
            copyOnWriteArrayList.addAll(list);
        }
    }

    private com.mbridge.msdk.videocommon.download.a a(CampaignEx campaignEx) {
        com.mbridge.msdk.videocommon.download.a aVar;
        com.mbridge.msdk.videocommon.download.a aVar2 = null;
        try {
            aVar = new com.mbridge.msdk.videocommon.download.a(this.f39979c, campaignEx, h(), f());
        } catch (Exception e11) {
            e = e11;
        }
        try {
            aVar.e(campaignEx);
            aVar.a(b());
            aVar.d(c(campaignEx));
            aVar.b(c());
            aVar.e(d(campaignEx));
            aVar.a((c) null);
            aVar.a(new a(h(), this.f39978b, this.f39977a));
            return aVar;
        } catch (Exception e12) {
            e = e12;
            aVar2 = aVar;
            if (MBridgeConstans.DEBUG) {
                o0.a("RewardVideoRefactorManager", h() + " createAndStartCampaignDownloadTask error " + e.getMessage());
            }
            return aVar2;
        }
    }

    private com.mbridge.msdk.videocommon.download.a a(CampaignEx campaignEx, String str, com.mbridge.msdk.videocommon.download.a aVar) {
        if (aVar != null) {
            return aVar;
        }
        com.mbridge.msdk.videocommon.download.a a11 = a(campaignEx);
        a11.x();
        this.f39984h.put(str, a11);
        return a11;
    }

    private String a(int i11) {
        return i11 != 0 ? i11 != 1 ? i11 != 2 ? i11 != 4 ? i11 != 5 ? "Unknown" : "DOWNLOAD_DONE" : "DOWNLOAD_STOP" : "DOWNLOAD_PAUSE" : "DOWNLOAD_RUN" : "DOWNLOAD_READY";
    }

    private void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
            o0.a("RewardVideoRefactorManager", h() + " load campaignExes is null");
            return;
        }
        Iterator<CampaignEx> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            CampaignEx next = it.next();
            if (next != null) {
                f(next);
            }
        }
    }

    private void a(boolean z10, List<com.mbridge.msdk.videocommon.download.a> list, int i11, CampaignEx campaignEx) {
        try {
            String str = campaignEx.getRequestId() + campaignEx.getId() + campaignEx.getVideoUrlEncode();
            a(z10, list, campaignEx, a(campaignEx, str, this.f39984h.get(str)), i11);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("RewardVideoRefactorManager", h() + " isReady error", e11);
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:5|(2:6|7)|(2:9|(17:11|12|13|(2:15|(13:17|(2:20|21)|46|(2:48|(8:50|(2:53|54)|27|(1:45)(1:32)|33|(1:35)|36|(4:38|(1:40)|41|42)(1:44)))|58|(2:53|54)|27|(0)|45|33|(0)|36|(0)(0)))|60|(2:20|21)|46|(0)|58|(0)|27|(0)|45|33|(0)|36|(0)(0)))|65|12|13|(0)|60|(0)|46|(0)|58|(0)|27|(0)|45|33|(0)|36|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0080, code lost:
    
        com.mbridge.msdk.foundation.tools.o0.b("RewardVideoRefactorManager", h() + " checkResourceReadyState error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0050, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0051, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0037, code lost:
    
        r3 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0043 A[Catch: Exception -> 0x0050, TRY_LEAVE, TryCatch #0 {Exception -> 0x0050, blocks: (B:13:0x003a, B:15:0x0043), top: B:12:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0056 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0065 A[Catch: Exception -> 0x005c, TRY_LEAVE, TryCatch #1 {Exception -> 0x005c, blocks: (B:21:0x0058, B:46:0x005f, B:48:0x0065), top: B:20:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0075 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(boolean r15, java.util.List<com.mbridge.msdk.videocommon.download.a> r16, com.mbridge.msdk.foundation.entity.CampaignEx r17, com.mbridge.msdk.videocommon.download.a r18, int r19) {
        /*
            Method dump skipped, instructions count: 529
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.k.a(boolean, java.util.List, com.mbridge.msdk.foundation.entity.CampaignEx, com.mbridge.msdk.videocommon.download.a, int):void");
    }

    private boolean a(CampaignEx campaignEx, com.mbridge.msdk.videocommon.download.a aVar, int i11, boolean z10, int i12) {
        if (aVar == null || campaignEx == null) {
            return false;
        }
        if (aVar.r() || g(campaignEx) || TextUtils.isEmpty(aVar.d()) || i12 == 3) {
            return true;
        }
        if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(0)) {
            return true;
        }
        if (campaignEx.getIsTimeoutCheckVideoStatus() == 1 && campaignEx.getVideoCheckType() == 1) {
            return true;
        }
        long h11 = aVar.h();
        long e11 = aVar.e();
        if (z10 && campaignEx.getVideoCheckType() == 1) {
            if (i11 == 0) {
                return true;
            }
            if ((e11 != 0 || h11 != 0) && h11 >= (i11 / 100) * e11) {
                campaignEx.setIsTimeoutCheckVideoStatus(1);
                return true;
            }
        }
        return a(aVar, i11);
    }

    private boolean a(com.mbridge.msdk.videocommon.download.a aVar, int i11) {
        if (aVar == null || TextUtils.isEmpty(aVar.d())) {
            return true;
        }
        return i11 == 0 ? (aVar.c() == null || TextUtils.isEmpty(aVar.c().getVideoUrlEncode())) ? false : true : Utils.getDownloadRate(aVar.e(), aVar.h()) >= i11;
    }

    private boolean a(String str, CampaignEx campaignEx) {
        if (campaignEx == null) {
            return false;
        }
        if (campaignEx.isMraid() || TextUtils.isEmpty(str)) {
            return true;
        }
        if (campaignEx.getLoadTimeoutState() == 1 && !g(campaignEx)) {
            return true;
        }
        if ((campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(2)) && !y0.b(g.a(str))) {
            return y0.b(g.b(str));
        }
        return true;
    }

    private boolean a(String str, CampaignEx campaignEx, com.mbridge.msdk.videocommon.download.a aVar) {
        if (campaignEx != null && aVar != null) {
            try {
                if (aVar.p()) {
                    o0.a("RewardVideoRefactorManager", h() + " checkEndCardZipOrSourceDownLoad endCard download success");
                    return true;
                }
                if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                    return true;
                }
                if ((campaignEx.isDynamicView() && !t0.l(str)) || y0.a(str) || a(str, campaignEx)) {
                    return true;
                }
            } catch (Throwable th2) {
                if (MBridgeConstans.DEBUG) {
                    o0.a("RewardVideoRefactorManager", h() + " checkEndCardDownload error " + th2.getMessage());
                }
            }
        }
        return false;
    }

    private com.mbridge.msdk.videocommon.setting.c b(String str) {
        try {
            if (this.f39981e == null) {
                this.f39981e = com.mbridge.msdk.videocommon.setting.b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), str, b() == 287);
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.a("RewardVideoRefactorManager", h() + " getRewardUnitSetting error " + e11.getMessage());
            }
        }
        return this.f39981e;
    }

    private String b(CampaignEx campaignEx) {
        return campaignEx == null ? "" : campaignEx.getendcard_url();
    }

    private boolean b(CampaignEx campaignEx, String str, com.mbridge.msdk.videocommon.download.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if ((aVar == null || !aVar.s()) && !campaignEx.isDynamicView()) {
            return ((campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(1)) && campaignEx.getLoadTimeoutState() == 0 && g.a(str) == null) ? false : true;
        }
        return true;
    }

    private int c() {
        com.mbridge.msdk.videocommon.setting.c b11 = b(h());
        if (b11 == null) {
            return 0;
        }
        try {
            return b11.g();
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return 0;
            }
            o0.a("RewardVideoRefactorManager", h() + " getCDRate error " + e11.getMessage());
            return 0;
        }
    }

    private int c(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return -1;
        }
        return campaignEx.getReady_rate() != -1 ? campaignEx.getReady_rate() : g();
    }

    private int d(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return 1;
        }
        try {
            return campaignEx.getVideoCtnType();
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return 1;
            }
            o0.a("RewardVideoRefactorManager", h() + " getVideoCtnType error " + e11.getMessage());
            return 1;
        }
    }

    private String e(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return "";
        }
        try {
            CampaignEx.c rewardTemplateMode = campaignEx.getRewardTemplateMode();
            if (rewardTemplateMode != null) {
                return rewardTemplateMode.e();
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("RewardVideoRefactorManager", h() + " getVideoTemplateUrl error", e11);
            }
        }
        return "";
    }

    private int f() {
        if (TextUtils.isEmpty(h())) {
            return 1;
        }
        try {
            com.mbridge.msdk.videocommon.setting.c b11 = b(h());
            if (b11 != null) {
                return b11.l();
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.a("RewardVideoRefactorManager", h() + " getDlnet error " + e11.getMessage());
            }
        }
        return 1;
    }

    private void f(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return;
        }
        try {
            String str = campaignEx.getRequestId() + campaignEx.getId() + campaignEx.getVideoUrlEncode();
            if (this.f39984h.containsKey(str)) {
                return;
            }
            a(campaignEx, str, (com.mbridge.msdk.videocommon.download.a) null);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("RewardVideoRefactorManager", h() + " handlerCampaignLoadEvent error", e11);
            }
        }
    }

    private int g() {
        try {
            return b(this.f39980d).w();
        } catch (Throwable th2) {
            if (!MBridgeConstans.DEBUG) {
                return 100;
            }
            o0.a("RewardVideoRefactorManager", h() + " getRewardReadyRate error:" + th2.getMessage());
            return 100;
        }
    }

    private boolean g(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return false;
        }
        try {
            return campaignEx.getPlayable_ads_without_video() == 2;
        } catch (Throwable th2) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            o0.a("RewardVideoRefactorManager", h() + " isPlayerAbleAds error:" + th2.getMessage());
            return false;
        }
    }

    public com.mbridge.msdk.videocommon.download.a a(String str) {
        if (!TextUtils.isEmpty(str) && this.f39984h.containsKey(str)) {
            return this.f39984h.get(str);
        }
        return null;
    }

    public List<com.mbridge.msdk.videocommon.download.a> a(List<CampaignEx> list, boolean z10) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            o0.a("RewardVideoRefactorManager", h() + " isReady campaignExes is null");
            return arrayList;
        }
        int size = list.size();
        for (CampaignEx campaignEx : list) {
            if (campaignEx != null) {
                a(z10, arrayList, size, campaignEx);
            }
        }
        return arrayList;
    }

    public void a() {
    }

    public void a(com.mbridge.msdk.videocommon.listener.a aVar) {
        this.f39977a = aVar;
    }

    public void a(String str, com.mbridge.msdk.videocommon.listener.a aVar) {
        if (this.f39978b == null) {
            this.f39978b = new ConcurrentHashMap<>();
        }
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f39978b.put(str, aVar);
    }

    public void a(List<CampaignEx> list) {
        if (list != null) {
            try {
                this.f39983g.addAll(list);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("RewardVideoRefactorManager", h() + " update error", e11);
                }
            }
        }
    }

    public int b() {
        return this.f39982f;
    }

    public void c(String str) {
        com.mbridge.msdk.videocommon.download.a remove;
        CampaignEx c11;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (!this.f39984h.containsKey(str) || (remove = this.f39984h.remove(str)) == null || (c11 = remove.c()) == null) {
                return;
            }
            this.f39983g.remove(c11);
            if (MBridgeConstans.DEBUG) {
                o0.a("RewardVideoRefactorManager", h() + " removeCampaignDownloadTask campaign name: " + c11.getAppName());
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("RewardVideoRefactorManager", h() + " removeCampaignDownloadTask error:" + e11.getMessage());
            }
        }
    }

    public com.mbridge.msdk.videocommon.download.a d() {
        try {
            return i();
        } catch (Throwable th2) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            o0.b("RewardVideoRefactorManager", h() + " getCampaignDownLoadTask error:" + th2.getMessage());
            return null;
        }
    }

    public CopyOnWriteArrayList<Map<String, com.mbridge.msdk.videocommon.download.a>> e() {
        try {
            CopyOnWriteArrayList<Map<String, com.mbridge.msdk.videocommon.download.a>> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.add(this.f39984h);
            return copyOnWriteArrayList;
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            o0.b("RewardVideoRefactorManager", h() + " getCampaignDownLoadTaskList error:" + e11.getMessage());
            return null;
        }
    }

    public String h() {
        return this.f39980d;
    }

    public void h(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                this.f39983g.add(campaignEx);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("RewardVideoRefactorManager", h() + " update error", e11);
                }
            }
        }
    }

    public com.mbridge.msdk.videocommon.download.a i() {
        List<com.mbridge.msdk.videocommon.download.a> list;
        if (this.f39983g.size() == 0) {
            o0.a("RewardVideoRefactorManager", h() + " isReady campaignExes is null");
            return null;
        }
        try {
            list = a((List<CampaignEx>) this.f39983g, false);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("RewardVideoRefactorManager", h() + " isReady error", e11);
            }
            list = null;
        }
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    public void j() {
        a(this.f39983g);
    }

    public void k() {
    }
}

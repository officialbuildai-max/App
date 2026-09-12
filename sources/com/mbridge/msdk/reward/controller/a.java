package com.mbridge.msdk.reward.controller;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.cache.a;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.m0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.q0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.w0;
import com.mbridge.msdk.foundation.tools.y0;
import com.mbridge.msdk.out.MBSupportMuteAdType;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import com.mbridge.msdk.reward.adapter.b;
import com.mbridge.msdk.videocommon.a;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: b0, reason: collision with root package name */
    public static String f37117b0 = "";

    /* renamed from: c0, reason: collision with root package name */
    public static String f37118c0;

    /* renamed from: d0, reason: collision with root package name */
    private static ConcurrentHashMap<String, Integer> f37119d0 = new ConcurrentHashMap<>();

    /* renamed from: e0, reason: collision with root package name */
    private static ConcurrentHashMap<String, String> f37120e0 = new ConcurrentHashMap<>();

    /* renamed from: f0, reason: collision with root package name */
    public static ConcurrentHashMap<String, i> f37121f0 = new ConcurrentHashMap<>();
    private Queue<Integer> I;
    private String J;
    private CopyOnWriteArrayList<CampaignEx> S;
    private List<CampaignEx> T;

    /* renamed from: a, reason: collision with root package name */
    private Context f37122a;

    /* renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.reward.adapter.c f37124b;

    /* renamed from: c, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.setting.c f37125c;

    /* renamed from: d, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.setting.a f37126d;

    /* renamed from: e, reason: collision with root package name */
    private volatile InterVideoOutListener f37127e;

    /* renamed from: f, reason: collision with root package name */
    private volatile h f37128f;

    /* renamed from: g, reason: collision with root package name */
    private String f37129g;

    /* renamed from: h, reason: collision with root package name */
    private String f37130h;

    /* renamed from: i, reason: collision with root package name */
    private MBridgeIds f37131i;

    /* renamed from: j, reason: collision with root package name */
    g f37132j;

    /* renamed from: k, reason: collision with root package name */
    private String f37133k;

    /* renamed from: l, reason: collision with root package name */
    private volatile String f37134l;

    /* renamed from: m, reason: collision with root package name */
    private String f37135m;

    /* renamed from: q, reason: collision with root package name */
    private int f37139q;

    /* renamed from: r, reason: collision with root package name */
    private int f37140r;

    /* renamed from: s, reason: collision with root package name */
    private int f37141s;

    /* renamed from: x, reason: collision with root package name */
    private boolean f37146x;

    /* renamed from: n, reason: collision with root package name */
    private int f37136n = 0;

    /* renamed from: p, reason: collision with root package name */
    private int f37138p = 2;

    /* renamed from: t, reason: collision with root package name */
    private boolean f37142t = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f37143u = false;

    /* renamed from: v, reason: collision with root package name */
    private boolean f37144v = false;

    /* renamed from: w, reason: collision with root package name */
    private boolean f37145w = false;

    /* renamed from: y, reason: collision with root package name */
    private boolean f37147y = false;

    /* renamed from: z, reason: collision with root package name */
    private String f37148z = "";
    private String A = "";
    private ArrayList<Integer> B = new ArrayList<>(7);
    private boolean C = false;
    private final Object D = new Object();
    public boolean E = false;
    int F = 25;
    int G = 1;
    private List<CampaignEx> H = new ArrayList();
    private com.mbridge.msdk.foundation.db.g K = null;
    private volatile boolean L = true;
    private volatile boolean M = false;
    private volatile boolean N = false;
    private volatile boolean O = false;
    private volatile boolean P = false;
    private volatile boolean Q = false;
    private volatile boolean R = false;
    volatile boolean U = false;
    volatile boolean V = false;
    volatile boolean W = false;
    volatile boolean X = false;
    volatile boolean Y = false;
    private JSONArray Z = new JSONArray();

    /* renamed from: a0, reason: collision with root package name */
    private int f37123a0 = 1;

    /* renamed from: o, reason: collision with root package name */
    private Handler f37137o = new com.mbridge.msdk.reward.controller.b(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.reward.controller.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0528a implements com.mbridge.msdk.videocommon.net.c {
        C0528a() {
        }

        @Override // com.mbridge.msdk.videocommon.net.c
        public void a(String str) {
        }

        @Override // com.mbridge.msdk.videocommon.net.c
        public void onFailed(String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements b.h {

        /* renamed from: a, reason: collision with root package name */
        com.mbridge.msdk.foundation.same.report.metrics.c f37150a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f37151b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f37152c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.reward.adapter.c f37153d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f37154e;

        /* renamed from: com.mbridge.msdk.reward.controller.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class RunnableC0529a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CampaignEx f37156a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ CopyOnWriteArrayList f37157b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f37158c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f37159d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f37160e;

            /* renamed from: com.mbridge.msdk.reward.controller.a$b$a$a, reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            class C0530a implements b.o {
                C0530a() {
                }

                @Override // com.mbridge.msdk.reward.adapter.b.o
                public void a(String str, String str2, String str3, a.C0573a c0573a, com.mbridge.msdk.foundation.error.b bVar) {
                    RunnableC0529a runnableC0529a = RunnableC0529a.this;
                    a aVar = a.this;
                    aVar.c(runnableC0529a.f37159d, (List<CampaignEx>) aVar.T);
                    if (a.this.f37128f == null || a.this.X) {
                        return;
                    }
                    a.this.X = true;
                    bVar.c("errorCode: 3301 errorMessage: temp preload failed");
                    b bVar2 = b.this;
                    if (bVar2.f37150a == null) {
                        bVar2.f37150a = new com.mbridge.msdk.foundation.same.report.metrics.c();
                    }
                    b bVar3 = b.this;
                    bVar3.f37150a.b(a.this.S);
                    b.this.f37150a.a(bVar);
                    a.this.f37128f.b(bVar, b.this.f37150a);
                }

                @Override // com.mbridge.msdk.reward.adapter.b.o
                public void a(String str, String str2, String str3, String str4, String str5, a.C0573a c0573a) {
                    RunnableC0529a runnableC0529a = RunnableC0529a.this;
                    b bVar = b.this;
                    com.mbridge.msdk.reward.adapter.c cVar = bVar.f37153d;
                    if (cVar != null && cVar.a(runnableC0529a.f37157b, bVar.f37152c, bVar.f37154e)) {
                        if (a.this.f37128f == null || a.this.Y) {
                            return;
                        }
                        a.this.Y = true;
                        RunnableC0529a runnableC0529a2 = RunnableC0529a.this;
                        a.this.a(runnableC0529a2.f37157b);
                        a.this.f37128f.d(str2, str3, b.this.f37150a);
                        return;
                    }
                    a aVar = a.this;
                    aVar.c(str3, (List<CampaignEx>) aVar.T);
                    if (a.this.f37128f == null || a.this.X) {
                        return;
                    }
                    a.this.X = true;
                    com.mbridge.msdk.foundation.error.b a11 = com.mbridge.msdk.foundation.error.a.a(880015, "errorCode: 3502 errorMessage: temp preload success but isReady false");
                    b bVar2 = b.this;
                    if (bVar2.f37150a == null) {
                        bVar2.f37150a = new com.mbridge.msdk.foundation.same.report.metrics.c();
                    }
                    RunnableC0529a runnableC0529a3 = RunnableC0529a.this;
                    b.this.f37150a.b(runnableC0529a3.f37157b);
                    b.this.f37150a.a(a11);
                    a.this.f37128f.b(a11, b.this.f37150a);
                }
            }

            RunnableC0529a(CampaignEx campaignEx, CopyOnWriteArrayList copyOnWriteArrayList, String str, String str2, String str3) {
                this.f37156a = campaignEx;
                this.f37157b = copyOnWriteArrayList;
                this.f37158c = str;
                this.f37159d = str2;
                this.f37160e = str3;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.mbridge.msdk.reward.adapter.b.b().a(a.this.f37147y, a.this.f37137o, a.this.f37142t, a.this.f37143u, null, this.f37156a.getRewardTemplateMode().e(), a.this.f37138p, b.this.f37151b, this.f37157b, H5DownLoadManager.getInstance().getH5ResAddress(this.f37156a.getRewardTemplateMode().e()), this.f37158c, this.f37159d, this.f37160e, this.f37156a.getRequestIdNotice(), a.this.f37125c, new C0530a());
            }
        }

        /* renamed from: com.mbridge.msdk.reward.controller.a$b$b, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class RunnableC0531b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f37163a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f37164b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f37165c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ CopyOnWriteArrayList f37166d;

            /* renamed from: com.mbridge.msdk.reward.controller.a$b$b$a, reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            class C0532a implements b.o {
                C0532a() {
                }

                @Override // com.mbridge.msdk.reward.adapter.b.o
                public void a(String str, String str2, String str3, a.C0573a c0573a, com.mbridge.msdk.foundation.error.b bVar) {
                    RunnableC0531b runnableC0531b = RunnableC0531b.this;
                    a aVar = a.this;
                    aVar.c(runnableC0531b.f37165c, (List<CampaignEx>) aVar.T);
                    if (a.this.f37128f == null || a.this.X) {
                        return;
                    }
                    a.this.X = true;
                    if (bVar != null) {
                        bVar.c("errorCode: 3302 errorMessage: tpl preload failed");
                    }
                    b bVar2 = b.this;
                    if (bVar2.f37150a == null) {
                        bVar2.f37150a = new com.mbridge.msdk.foundation.same.report.metrics.c();
                    }
                    RunnableC0531b runnableC0531b2 = RunnableC0531b.this;
                    b.this.f37150a.b(runnableC0531b2.f37166d);
                    b.this.f37150a.a(bVar);
                    a.this.f37128f.b(bVar, b.this.f37150a);
                }

                @Override // com.mbridge.msdk.reward.adapter.b.o
                public void a(String str, String str2, String str3, String str4, String str5, a.C0573a c0573a) {
                    RunnableC0531b runnableC0531b = RunnableC0531b.this;
                    b bVar = b.this;
                    com.mbridge.msdk.reward.adapter.c cVar = bVar.f37153d;
                    if (cVar != null && cVar.a(runnableC0531b.f37166d, bVar.f37152c, bVar.f37154e)) {
                        if (a.this.f37128f == null || a.this.Y) {
                            return;
                        }
                        a.this.Y = true;
                        o0.a("RewardVideoController", "Cache onVideoLoadSuccessForCache");
                        RunnableC0531b runnableC0531b2 = RunnableC0531b.this;
                        a.this.a(runnableC0531b2.f37166d);
                        RunnableC0531b runnableC0531b3 = RunnableC0531b.this;
                        com.mbridge.msdk.foundation.same.report.metrics.c cVar2 = b.this.f37150a;
                        if (cVar2 != null) {
                            cVar2.b(runnableC0531b3.f37166d);
                        }
                        a.this.f37128f.d(str2, str3, b.this.f37150a);
                        return;
                    }
                    a aVar = a.this;
                    aVar.c(str3, (List<CampaignEx>) aVar.T);
                    if (a.this.f37128f == null || a.this.X) {
                        return;
                    }
                    a.this.X = true;
                    com.mbridge.msdk.foundation.error.b a11 = com.mbridge.msdk.foundation.error.a.a(880015, "errorCode: 3504 errorMessage: tpl temp preload success but isReady false");
                    b bVar2 = b.this;
                    if (bVar2.f37150a == null) {
                        bVar2.f37150a = new com.mbridge.msdk.foundation.same.report.metrics.c();
                    }
                    b.this.f37150a.a(a11);
                    RunnableC0531b runnableC0531b4 = RunnableC0531b.this;
                    b.this.f37150a.b(runnableC0531b4.f37166d);
                    a.this.f37128f.b(a11, b.this.f37150a);
                }
            }

            RunnableC0531b(String str, String str2, String str3, CopyOnWriteArrayList copyOnWriteArrayList) {
                this.f37163a = str;
                this.f37164b = str2;
                this.f37165c = str3;
                this.f37166d = copyOnWriteArrayList;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.mbridge.msdk.reward.adapter.b.b().a(a.this.f37147y, a.this.f37137o, a.this.f37142t, a.this.f37143u, this.f37163a, b.this.f37151b.getRequestIdNotice(), this.f37164b, this.f37165c, b.this.f37151b.getCMPTEntryUrl(), a.this.f37138p, b.this.f37151b, this.f37166d, H5DownLoadManager.getInstance().getH5ResAddress(b.this.f37151b.getCMPTEntryUrl()), this.f37165c, a.this.f37125c, new C0532a(), true);
            }
        }

        b(CampaignEx campaignEx, boolean z10, com.mbridge.msdk.reward.adapter.c cVar, int i11) {
            this.f37151b = campaignEx;
            this.f37152c = z10;
            this.f37153d = cVar;
            this.f37154e = i11;
            this.f37150a = com.mbridge.msdk.foundation.same.report.metrics.d.b().c().get(campaignEx.getLocalRequestId());
        }

        @Override // com.mbridge.msdk.reward.adapter.b.h
        public void a(String str, String str2, String str3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            a.this.U = true;
            if (this.f37152c) {
                if (!a.this.V || a.this.W || a.this.f37137o == null) {
                    return;
                }
                a.this.W = true;
                a.this.f37137o.post(new RunnableC0531b(str3, str, str2, copyOnWriteArrayList));
                return;
            }
            Iterator<CampaignEx> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CampaignEx next = it.next();
                if (next == null || next.getRewardTemplateMode() == null || TextUtils.isEmpty(next.getRewardTemplateMode().e()) || next.getRewardTemplateMode().e().contains(CampaignEx.KEY_IS_CMPT_ENTRY) || a.this.f37137o == null) {
                    com.mbridge.msdk.reward.adapter.c cVar = this.f37153d;
                    if (cVar == null || !cVar.a(copyOnWriteArrayList, this.f37152c, this.f37154e)) {
                        a aVar = a.this;
                        aVar.c(str2, (List<CampaignEx>) aVar.T);
                        if (a.this.f37128f != null && !a.this.X) {
                            a.this.X = true;
                            com.mbridge.msdk.foundation.error.b a11 = com.mbridge.msdk.foundation.error.a.a(880015, "errorCode: 3503 errorMessage: have no temp but isReady false");
                            if (this.f37150a == null) {
                                this.f37150a = new com.mbridge.msdk.foundation.same.report.metrics.c();
                            }
                            this.f37150a.b(a.this.S);
                            this.f37150a.a(a11);
                            a.this.f37128f.b(a11, this.f37150a);
                        }
                    } else if (a.this.f37128f != null && !a.this.Y) {
                        a.this.Y = true;
                        o0.a("RewardVideoController", "Cache onVideoLoadSuccessForCache");
                        a.this.a(copyOnWriteArrayList);
                        com.mbridge.msdk.foundation.same.report.metrics.c cVar2 = this.f37150a;
                        if (cVar2 != null) {
                            cVar2.b(copyOnWriteArrayList);
                        }
                        a.this.f37128f.d(str, str2, this.f37150a);
                    }
                } else {
                    a.this.f37137o.post(new RunnableC0529a(next, copyOnWriteArrayList, str, str2, str3));
                }
            }
        }

        @Override // com.mbridge.msdk.reward.adapter.b.h
        public void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.foundation.error.b bVar) {
            a.this.U = false;
            a aVar = a.this;
            aVar.c(aVar.f37130h, (List<CampaignEx>) a.this.T);
            if (a.this.f37128f == null || a.this.X) {
                return;
            }
            a.this.X = true;
            if (this.f37150a == null) {
                this.f37150a = new com.mbridge.msdk.foundation.same.report.metrics.c();
            }
            this.f37150a.b(copyOnWriteArrayList);
            if (bVar != null) {
                bVar.c("errorCode: 3201 errorMessage: campaign resource download failed");
            }
            this.f37150a.a(bVar);
            a.this.f37128f.b(bVar, this.f37150a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements b.n {

        /* renamed from: a, reason: collision with root package name */
        com.mbridge.msdk.foundation.same.report.metrics.c f37169a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f37170b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CopyOnWriteArrayList f37171c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f37172d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f37173e;

        c(CampaignEx campaignEx, CopyOnWriteArrayList copyOnWriteArrayList, boolean z10, int i11) {
            this.f37170b = campaignEx;
            this.f37171c = copyOnWriteArrayList;
            this.f37172d = z10;
            this.f37173e = i11;
            this.f37169a = com.mbridge.msdk.foundation.same.report.metrics.d.b().c().get(campaignEx.getLocalRequestId());
        }

        @Override // com.mbridge.msdk.reward.adapter.b.n
        public void a(String str, String str2, com.mbridge.msdk.foundation.error.b bVar) {
            String unitId = bVar == null ? "" : bVar.e().getUnitId();
            a aVar = a.this;
            aVar.c(unitId, (List<CampaignEx>) aVar.T);
            if (bVar != null) {
                bVar.c("errorCode: 3202 errorMessage: temp resource download failed");
            }
            if (this.f37169a == null) {
                this.f37169a = new com.mbridge.msdk.foundation.same.report.metrics.c();
            }
            this.f37169a.b(this.f37171c);
            this.f37169a.a(bVar);
            if (!this.f37172d && a.this.f37128f != null) {
                if (a.this.X) {
                    return;
                }
                a.this.X = true;
                a.this.f37128f.b(bVar, this.f37169a);
                return;
            }
            if (this.f37173e != 1 || a.this.X || a.this.f37128f == null) {
                return;
            }
            a.this.X = true;
            a.this.f37128f.b(bVar, this.f37169a);
        }

        @Override // com.mbridge.msdk.reward.adapter.b.n
        public void a(String str, String str2, String str3, String str4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements b.n {

        /* renamed from: a, reason: collision with root package name */
        com.mbridge.msdk.foundation.same.report.metrics.c f37175a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f37176b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CopyOnWriteArrayList f37177c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.reward.adapter.c f37178d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f37179e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f37180f;

        /* renamed from: com.mbridge.msdk.reward.controller.a$d$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class RunnableC0533a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f37182a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f37183b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f37184c;

            /* renamed from: com.mbridge.msdk.reward.controller.a$d$a$a, reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            class C0534a implements b.o {
                C0534a() {
                }

                @Override // com.mbridge.msdk.reward.adapter.b.o
                public void a(String str, String str2, String str3, a.C0573a c0573a, com.mbridge.msdk.foundation.error.b bVar) {
                    RunnableC0533a runnableC0533a = RunnableC0533a.this;
                    a aVar = a.this;
                    aVar.c(runnableC0533a.f37184c, (List<CampaignEx>) aVar.T);
                    if (a.this.f37128f == null || a.this.X) {
                        return;
                    }
                    a.this.X = true;
                    if (bVar != null) {
                        bVar.c("errorCode: 3303 errorMessage: tpl temp preload failed");
                    }
                    d dVar = d.this;
                    if (dVar.f37175a == null) {
                        dVar.f37175a = new com.mbridge.msdk.foundation.same.report.metrics.c();
                    }
                    d dVar2 = d.this;
                    dVar2.f37175a.b(dVar2.f37177c);
                    d.this.f37175a.a(bVar);
                    a.this.f37128f.b(bVar, d.this.f37175a);
                }

                @Override // com.mbridge.msdk.reward.adapter.b.o
                public void a(String str, String str2, String str3, String str4, String str5, a.C0573a c0573a) {
                    d dVar = d.this;
                    com.mbridge.msdk.reward.adapter.c cVar = dVar.f37178d;
                    if (cVar != null && cVar.a(dVar.f37177c, dVar.f37179e, dVar.f37180f)) {
                        if (a.this.f37128f == null || a.this.Y) {
                            return;
                        }
                        a.this.Y = true;
                        o0.a("RewardVideoController", "Cache onVideoLoadSuccess");
                        d dVar2 = d.this;
                        a.this.a(dVar2.f37177c);
                        d dVar3 = d.this;
                        com.mbridge.msdk.foundation.same.report.metrics.c cVar2 = dVar3.f37175a;
                        if (cVar2 != null) {
                            cVar2.b(dVar3.f37177c);
                        }
                        a.this.f37128f.d(str2, str3, d.this.f37175a);
                        return;
                    }
                    a aVar = a.this;
                    aVar.c(str3, (List<CampaignEx>) aVar.T);
                    if (a.this.f37128f == null || a.this.X) {
                        return;
                    }
                    a.this.X = true;
                    com.mbridge.msdk.foundation.error.b a11 = com.mbridge.msdk.foundation.error.a.a(880015, "errorCode: 3505 errorMessage: tpl temp preload success but isReady false");
                    d dVar4 = d.this;
                    if (dVar4.f37175a == null) {
                        dVar4.f37175a = new com.mbridge.msdk.foundation.same.report.metrics.c();
                    }
                    d dVar5 = d.this;
                    dVar5.f37175a.b(dVar5.f37177c);
                    d.this.f37175a.a(a11);
                    a.this.f37128f.b(a11, d.this.f37175a);
                }
            }

            RunnableC0533a(String str, String str2, String str3) {
                this.f37182a = str;
                this.f37183b = str2;
                this.f37184c = str3;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.mbridge.msdk.reward.adapter.b b11 = com.mbridge.msdk.reward.adapter.b.b();
                boolean z10 = a.this.f37147y;
                Handler handler = a.this.f37137o;
                boolean z11 = a.this.f37142t;
                boolean z12 = a.this.f37143u;
                String str = this.f37182a;
                String requestIdNotice = d.this.f37176b.getRequestIdNotice();
                String str2 = this.f37183b;
                String str3 = this.f37184c;
                String cMPTEntryUrl = d.this.f37176b.getCMPTEntryUrl();
                int i11 = a.this.f37138p;
                d dVar = d.this;
                b11.a(z10, handler, z11, z12, str, requestIdNotice, str2, str3, cMPTEntryUrl, i11, dVar.f37176b, dVar.f37177c, H5DownLoadManager.getInstance().getH5ResAddress(d.this.f37176b.getCMPTEntryUrl()), this.f37184c, a.this.f37125c, new C0534a(), true);
            }
        }

        d(CampaignEx campaignEx, CopyOnWriteArrayList copyOnWriteArrayList, com.mbridge.msdk.reward.adapter.c cVar, boolean z10, int i11) {
            this.f37176b = campaignEx;
            this.f37177c = copyOnWriteArrayList;
            this.f37178d = cVar;
            this.f37179e = z10;
            this.f37180f = i11;
            this.f37175a = com.mbridge.msdk.foundation.same.report.metrics.d.b().c().get(campaignEx.getLocalRequestId());
        }

        @Override // com.mbridge.msdk.reward.adapter.b.n
        public void a(String str, String str2, com.mbridge.msdk.foundation.error.b bVar) {
            String str3;
            if (bVar != null) {
                str3 = bVar.e().getUnitId();
                bVar.c("errorCode: 3203 errorMessage: tpl temp resource download failed");
            } else {
                str3 = "";
            }
            a aVar = a.this;
            aVar.c(str3, (List<CampaignEx>) aVar.T);
            if (this.f37175a == null) {
                this.f37175a = new com.mbridge.msdk.foundation.same.report.metrics.c();
            }
            this.f37175a.a(bVar);
            this.f37175a.b(this.f37177c);
            a.this.V = false;
            if (a.this.f37128f == null || a.this.X) {
                return;
            }
            a.this.X = true;
            a.this.f37128f.b(bVar, this.f37175a);
        }

        @Override // com.mbridge.msdk.reward.adapter.b.n
        public void a(String str, String str2, String str3, String str4) {
            a.this.V = true;
            if (!a.this.U || a.this.W || a.this.f37137o == null) {
                return;
            }
            a.this.W = true;
            a.this.f37137o.post(new RunnableC0533a(str3, str, str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (a.this.K == null) {
                    a.this.K = com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d());
                }
                com.mbridge.msdk.foundation.db.h a11 = com.mbridge.msdk.foundation.db.h.a(a.this.K);
                if (a11 != null) {
                    a11.b(a.this.f37130h);
                }
            } catch (Throwable unused) {
                o0.b("RewardVideoController", "can't find DailyPlayCapDao");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final com.mbridge.msdk.reward.adapter.c f37188a;

        /* renamed from: b, reason: collision with root package name */
        private final int f37189b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f37190c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f37191d = false;

        /* renamed from: e, reason: collision with root package name */
        private int f37192e;

        /* renamed from: f, reason: collision with root package name */
        private String f37193f;

        /* renamed from: g, reason: collision with root package name */
        private com.mbridge.msdk.foundation.same.report.metrics.c f37194g;

        public f(com.mbridge.msdk.reward.adapter.c cVar, int i11, boolean z10, String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar2) {
            this.f37188a = cVar;
            this.f37189b = i11;
            this.f37190c = z10;
            if (cVar != null) {
                cVar.c(false);
            }
            this.f37193f = str;
            this.f37194g = cVar2;
        }

        public void a() {
            this.f37191d = true;
        }

        public void a(int i11) {
            this.f37192e = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f37191d) {
                return;
            }
            com.mbridge.msdk.reward.adapter.c cVar = this.f37188a;
            if (cVar != null) {
                cVar.c(true);
            }
            o0.b("RewardVideoController", "adSource=" + this.f37189b + " CommonCancelTimeTask mIsDevCall：" + this.f37190c);
            a.this.a(com.mbridge.msdk.foundation.error.a.a(880023, "v3 is timeout"), this.f37194g);
        }
    }

    /* loaded from: classes5.dex */
    public class g implements com.mbridge.msdk.reward.adapter.a {

        /* renamed from: a, reason: collision with root package name */
        private com.mbridge.msdk.reward.adapter.c f37196a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f37197b;

        /* renamed from: c, reason: collision with root package name */
        private f f37198c;

        public g(com.mbridge.msdk.reward.adapter.c cVar, boolean z10) {
            this.f37196a = cVar;
            this.f37197b = z10;
        }

        public void a(f fVar) {
            this.f37198c = fVar;
        }

        @Override // com.mbridge.msdk.reward.adapter.a
        public void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            f fVar = this.f37198c;
            if (fVar != null) {
                fVar.a();
                a.this.f37137o.removeCallbacks(this.f37198c);
            }
            if (a.this.f37128f != null) {
                a.this.f37128f.a(a.this.f37134l, a.this.f37130h, cVar);
            }
        }

        @Override // com.mbridge.msdk.reward.adapter.a
        public void a(List<CampaignEx> list, com.mbridge.msdk.foundation.error.b bVar, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            f fVar = this.f37198c;
            if (fVar != null) {
                fVar.a();
                a.this.f37137o.removeCallbacks(this.f37198c);
            }
            com.mbridge.msdk.reward.adapter.c cVar2 = this.f37196a;
            if (cVar2 != null) {
                cVar2.a((com.mbridge.msdk.reward.adapter.a) null);
                this.f37196a = null;
            }
            a.this.a(list);
            if (a.this.f37128f != null) {
                a.this.f37128f.a(bVar, cVar);
            }
        }

        @Override // com.mbridge.msdk.reward.adapter.a
        public void a(List<CampaignEx> list, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            f fVar = this.f37198c;
            if (fVar != null) {
                fVar.a();
                a.this.f37137o.removeCallbacks(this.f37198c);
            }
            a.this.a(list);
            if (a.this.f37128f != null) {
                if (list != null && list.size() == 1) {
                    CampaignEx campaignEx = list.get(0);
                    if (!com.mbridge.msdk.foundation.same.c.a(a.this.f37122a, campaignEx) && campaignEx.getFilterAdsVideoCallState() == 0) {
                        if (a.this.f37123a0 > 1) {
                            a.m(a.this);
                            return;
                        }
                        com.mbridge.msdk.foundation.error.b a11 = com.mbridge.msdk.foundation.error.a.a(880020, "load exception second");
                        if (cVar != null) {
                            cVar.a(a11);
                            cVar.b(true);
                        }
                        a.this.f37128f.a(a11, cVar);
                        return;
                    }
                }
                a.this.f37128f.c(a.this.f37134l, a.this.f37130h, cVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class h {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<InterVideoOutListener> f37200a;

        /* renamed from: b, reason: collision with root package name */
        private volatile AtomicInteger f37201b;

        /* renamed from: c, reason: collision with root package name */
        private Handler f37202c;

        /* renamed from: d, reason: collision with root package name */
        private String f37203d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f37204e;

        private h(InterVideoOutListener interVideoOutListener, Handler handler, String str) {
            this.f37200a = new WeakReference<>(interVideoOutListener);
            this.f37201b = new AtomicInteger(0);
            this.f37202c = handler;
            this.f37203d = str;
        }

        /* synthetic */ h(a aVar, InterVideoOutListener interVideoOutListener, Handler handler, String str, C0528a c0528a) {
            this(interVideoOutListener, handler, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a() {
            return this.f37201b.get();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i11) {
            this.f37201b.set(i11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            this.f37201b.set(2);
            b(str, cVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, String str2, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            WeakReference<InterVideoOutListener> weakReference = this.f37200a;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if ((this.f37201b.get() != 1 && this.f37201b.get() != 3) || this.f37202c == null || a.this.N) {
                return;
            }
            a.this.N = true;
            a.this.a("2000127", cVar, interVideoOutListener);
            if (interVideoOutListener != null) {
                Message obtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                bundle.putBoolean(MBridgeConstans.PROPERTIES_IS_CACHED_CAMPAIGN, false);
                if (cVar != null) {
                    bundle.putString("metrics_data_lrid", cVar.o());
                }
                obtain.setData(bundle);
                obtain.obj = str2;
                obtain.what = 17;
                this.f37202c.sendMessage(obtain);
                if (q0.a().a("l_s_i_l_v_s", false)) {
                    c(str, str2, cVar);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(com.mbridge.msdk.foundation.error.b bVar, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            WeakReference<InterVideoOutListener> weakReference = this.f37200a;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if (this.f37201b.get() == 2 || this.f37202c == null) {
                return;
            }
            a.this.Q = true;
            String g11 = bVar != null ? bVar.g() : "";
            if (g11.contains("resource load timeout")) {
                a.this.P = true;
            }
            if (a.this.Q && a.this.P && !a.this.O) {
                this.f37201b.set(2);
                if (interVideoOutListener != null) {
                    Message obtain = Message.obtain();
                    obtain.obj = g11;
                    obtain.what = 16;
                    if (cVar != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("metrics_data_lrid", cVar.o());
                        obtain.setData(bundle);
                    }
                    this.f37202c.sendMessage(obtain);
                }
                if (cVar == null) {
                    cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
                }
                cVar.a(true);
                a.this.a("2000047", cVar, interVideoOutListener);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            WeakReference<InterVideoOutListener> weakReference = this.f37200a;
            a.this.a("2000047", cVar, weakReference != null ? weakReference.get() : null);
            if (this.f37202c != null) {
                Message obtain = Message.obtain();
                obtain.obj = str;
                obtain.what = 18;
                if (cVar != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("metrics_data_lrid", cVar.o());
                    obtain.setData(bundle);
                }
                this.f37202c.sendMessage(obtain);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str, String str2, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            WeakReference<InterVideoOutListener> weakReference = this.f37200a;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if (this.f37202c == null || a.this.N) {
                return;
            }
            a.this.N = true;
            a.this.a("2000127", cVar, interVideoOutListener);
            if (interVideoOutListener != null) {
                Message obtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                bundle.putBoolean(MBridgeConstans.PROPERTIES_IS_CACHED_CAMPAIGN, true);
                if (cVar != null) {
                    bundle.putString("metrics_data_lrid", cVar.o());
                }
                obtain.setData(bundle);
                obtain.obj = str2;
                obtain.what = 17;
                this.f37202c.sendMessage(obtain);
                if (q0.a().a("l_s_i_l_v_s", false)) {
                    d(str, str2, cVar);
                }
            }
        }

        public void a(com.mbridge.msdk.foundation.error.b bVar, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            String str;
            CampaignEx campaignEx;
            if (bVar == null || cVar == null) {
                str = "";
            } else {
                str = bVar.g();
                cVar.a(bVar);
            }
            if (a.this.f37124b != null && a.this.f37123a0 == 1) {
                a.this.f37124b.a(a.this.f37132j);
                CopyOnWriteArrayList<CampaignEx> f11 = a.this.f37124b.f();
                CampaignEx campaignEx2 = (a.this.H == null || a.this.H.size() == 0) ? null : (CampaignEx) a.this.H.get(0);
                if (campaignEx2 == null) {
                    if (f11 == null || f11.size() == 0) {
                        campaignEx = null;
                        if (!a.this.f37143u && ((campaignEx == null || TextUtils.isEmpty(campaignEx.getNLRid())) && ((f11 == null || f11.size() == 0) && a.this.f37124b.a(campaignEx, true, bVar, 2, cVar)))) {
                            return;
                        } else {
                            a.this.f37124b.a((com.mbridge.msdk.reward.adapter.a) null);
                        }
                    } else {
                        campaignEx2 = f11.get(0);
                    }
                }
                campaignEx = campaignEx2;
                if (!a.this.f37143u) {
                }
                a.this.f37124b.a((com.mbridge.msdk.reward.adapter.a) null);
            }
            Handler handler = this.f37202c;
            if (handler != null) {
                handler.removeMessages(1001002);
            }
            WeakReference<InterVideoOutListener> weakReference = this.f37200a;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if (this.f37201b.get() == 2 || this.f37202c == null) {
                return;
            }
            a.this.P = true;
            if (!a.this.R || str.contains("resource load timeout")) {
                a.this.Q = true;
            }
            if (a.this.O) {
                this.f37201b.set(2);
            }
            if (a.this.P && a.this.Q && !a.this.O) {
                if (a.this.f37123a0 > 1) {
                    a.m(a.this);
                    a.this.f37124b.a(a.this.f37132j);
                    return;
                }
                this.f37201b.set(2);
                a.this.a("2000047", cVar, interVideoOutListener);
                if (interVideoOutListener != null) {
                    Message obtain = Message.obtain();
                    obtain.obj = str;
                    obtain.what = 16;
                    if (cVar != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("metrics_data_lrid", cVar.o());
                        obtain.setData(bundle);
                    }
                    this.f37202c.sendMessage(obtain);
                }
            }
        }

        public void a(boolean z10) {
            this.f37204e = z10;
        }

        public void c(String str, String str2, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            Handler handler = this.f37202c;
            if (handler != null) {
                handler.removeMessages(1001002);
            }
            WeakReference<InterVideoOutListener> weakReference = this.f37200a;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if (this.f37201b.get() == 2 || this.f37202c == null) {
                return;
            }
            a.m(a.this);
            this.f37201b.set(2);
            if (a.this.O) {
                return;
            }
            a.this.O = true;
            if (cVar == null) {
                cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
            }
            cVar.b(a.this.H);
            a.this.a("2000048", cVar, interVideoOutListener);
            if (interVideoOutListener != null) {
                Message obtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                bundle.putString("metrics_data_lrid", cVar.o());
                obtain.setData(bundle);
                obtain.obj = str2;
                obtain.what = 9;
                this.f37202c.sendMessage(obtain);
            }
        }

        public void d(String str, String str2, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            Handler handler = this.f37202c;
            if (handler != null) {
                handler.removeMessages(1001002);
            }
            WeakReference<InterVideoOutListener> weakReference = this.f37200a;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if (this.f37201b.get() == 2 || this.f37202c == null) {
                return;
            }
            if (this.f37201b.get() == 1) {
                this.f37201b.set(3);
            }
            if (a.this.O) {
                return;
            }
            a.this.O = true;
            if (cVar == null) {
                cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
            }
            cVar.a(true);
            cVar.b(a.this.H);
            a.this.a("2000048", cVar, interVideoOutListener);
            if (interVideoOutListener != null) {
                Message obtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                bundle.putSerializable("metrics_data_lrid", cVar.o());
                obtain.setData(bundle);
                obtain.obj = str2;
                obtain.what = 9;
                this.f37202c.sendMessage(obtain);
            }
            if (a.this.P) {
                this.f37201b.set(2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class i extends com.mbridge.msdk.video.bt.module.orglistener.b {

        /* renamed from: c, reason: collision with root package name */
        private a f37206c;

        /* renamed from: d, reason: collision with root package name */
        private Handler f37207d;

        /* renamed from: e, reason: collision with root package name */
        private int f37208e;

        /* renamed from: com.mbridge.msdk.reward.controller.a$i$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class RunnableC0535a implements Runnable {
            RunnableC0535a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (i.this.f37206c != null) {
                    i.this.f37206c.a(false, com.mbridge.msdk.foundation.same.report.metrics.d.b().a(0, a.this.f37142t ? MBSupportMuteAdType.INTERSTITIAL_VIDEO : 94, a.this.f37130h, true, 1));
                }
            }
        }

        private i(a aVar, Handler handler) {
            this.f37208e = 0;
            this.f37206c = aVar;
            this.f37207d = handler;
        }

        /* synthetic */ i(a aVar, a aVar2, Handler handler, C0528a c0528a) {
            this(aVar2, handler);
        }

        @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
        public void a(int i11, String str, String str2) {
            this.f37208e = i11;
            a aVar = this.f37206c;
            if (aVar == null || aVar.f37143u || this.f37206c.f37142t || this.f37206c.f37125c == null || !this.f37206c.f37125c.a(this.f37208e) || this.f37206c.f37128f == null || this.f37206c.f37128f.a() == 1 || this.f37206c.f37128f.a() == 3 || a.this.B.contains(Integer.valueOf(this.f37208e))) {
                return;
            }
            a.this.B.add(Integer.valueOf(this.f37208e));
            int f11 = this.f37206c.f37125c.f() * 1000;
            if (this.f37208e == 4) {
                f11 = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;
            }
            Handler handler = this.f37207d;
            if (handler == null) {
                new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0535a(), f11);
            } else {
                handler.removeMessages(1001001);
                this.f37207d.sendEmptyMessageDelayed(1001001, f11);
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
        public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            a.this.E = false;
            try {
                com.mbridge.msdk.reward.candidate.a aVar = new com.mbridge.msdk.reward.candidate.a(a.this.f37130h, a.this.f37142t);
                a aVar2 = this.f37206c;
                aVar.a(cVar.o(), (aVar2 == null || aVar2.f37124b == null) ? "" : this.f37206c.f37124b.H, 3, a.f37117b0);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("RewardVideoController", e11.getMessage());
                }
            }
            try {
                a aVar3 = this.f37206c;
                if (aVar3 != null) {
                    aVar3.C = true;
                    if (this.f37206c.f37124b != null) {
                        this.f37206c.f37124b.H = "";
                    }
                    this.f37206c.q();
                    if (a.this.f37143u) {
                        a.this.a();
                    }
                    a aVar4 = a.this;
                    aVar4.a("2000130", cVar, aVar4.f37127e, "");
                    b();
                    if (this.f37206c.f37127e != null) {
                        this.f37206c.f37127e.onAdShow(a.this.f37131i);
                        this.f37208e = 2;
                    }
                }
            } catch (Throwable th2) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("RewardVideoController", th2.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
        public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar, String str) {
            try {
                a aVar = a.this;
                aVar.E = false;
                if (this.f37206c != null) {
                    if (aVar.f37143u) {
                        a.this.a();
                    }
                    this.f37206c.C = false;
                    a.this.a("2000131", cVar, this.f37206c.f37127e, str);
                    a();
                    if (this.f37206c.f37127e != null) {
                        try {
                            this.f37206c.f37127e.onShowFail(cVar, a.this.f37131i, str);
                        } catch (Exception e11) {
                            if (MBridgeConstans.DEBUG) {
                                o0.b("RewardVideoController", e11.getMessage());
                            }
                        }
                        this.f37208e = 4;
                    }
                }
            } catch (Exception e12) {
                this.f37208e = 0;
                if (MBridgeConstans.DEBUG) {
                    o0.b("RewardVideoController", e12.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
        public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar, boolean z10, com.mbridge.msdk.videocommon.entity.c cVar2) {
            try {
                a aVar = this.f37206c;
                if (aVar != null && aVar.f37127e != null) {
                    if (cVar2 == null) {
                        cVar2 = com.mbridge.msdk.videocommon.entity.c.a(this.f37206c.f37135m);
                    }
                    if (a.this.f37143u) {
                        a.this.a();
                        a.this.v();
                        com.mbridge.msdk.foundation.same.buffer.b.d(a.this.f37130h, a.this.m());
                    }
                    this.f37206c.f37127e.onAdClose(a.this.f37131i, new RewardInfo(z10, cVar2.c(), String.valueOf(cVar2.a())));
                    this.f37208e = 7;
                    this.f37206c.C = false;
                    e();
                }
                com.mbridge.msdk.foundation.same.report.metrics.d.b().b("2000152", cVar, null);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("RewardVideoController", e11.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
        public void a(String str, String str2) {
            try {
                a aVar = this.f37206c;
                if (aVar == null || aVar.f37127e == null) {
                    return;
                }
                try {
                    this.f37206c.f37127e.onEndcardShow(a.this.f37131i);
                    com.mbridge.msdk.foundation.feedback.b.b().a(str2 + "_2", 2);
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("RewardVideoController", e11.getMessage());
                    }
                }
                this.f37208e = 6;
            } catch (Exception e12) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("RewardVideoController", e12.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
        public void a(boolean z10, int i11) {
            try {
                a aVar = this.f37206c;
                if (aVar != null && aVar.f37127e != null) {
                    try {
                        this.f37206c.f37127e.onAdCloseWithIVReward(a.this.f37131i, new RewardInfo(z10, i11));
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            o0.b("RewardVideoController", e11.getMessage());
                        }
                    }
                }
            } catch (Exception e12) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("RewardVideoController", e12.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
        public void a(boolean z10, String str, String str2) {
            try {
                a aVar = this.f37206c;
                if (aVar == null || aVar.f37127e == null) {
                    return;
                }
                if (a.this.f37143u) {
                    a.this.a();
                }
                this.f37206c.C = false;
                try {
                    this.f37206c.f37127e.onVideoAdClicked(z10, a.this.f37131i);
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("RewardVideoController", e11.getMessage());
                    }
                }
            } catch (Exception e12) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("RewardVideoController", e12.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
        public void b(String str, String str2) {
            try {
                a aVar = this.f37206c;
                if (aVar == null || aVar.f37127e == null) {
                    return;
                }
                try {
                    this.f37206c.f37127e.onVideoComplete(a.this.f37131i);
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("RewardVideoController", e11.getMessage());
                    }
                }
                this.f37208e = 5;
            } catch (Exception e12) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("RewardVideoController", e12.getMessage());
                }
            }
        }

        public void e() {
            a.this.B.clear();
            this.f37206c = null;
        }
    }

    /* loaded from: classes5.dex */
    public class j {
        public j() {
        }

        public void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            a.this.f37123a0++;
            a aVar = a.this;
            aVar.b(aVar.f37146x, str, cVar);
        }
    }

    private com.mbridge.msdk.foundation.same.report.metrics.c a(com.mbridge.msdk.foundation.same.report.metrics.e eVar) {
        com.mbridge.msdk.foundation.same.report.metrics.c cVar;
        CopyOnWriteArrayList<CampaignEx> b11;
        String str;
        com.mbridge.msdk.foundation.same.report.metrics.c cVar2;
        CampaignEx campaignEx;
        try {
            b11 = com.mbridge.msdk.videocommon.download.b.getInstance().b(this.f37130h);
            str = "";
            if (b11 != null && b11.size() > 0 && (campaignEx = b11.get(0)) != null) {
                str = campaignEx.getCurrentLocalRid();
            }
            cVar2 = TextUtils.isEmpty(str) ? null : com.mbridge.msdk.foundation.same.report.metrics.d.b().c().get(str);
        } catch (Exception e11) {
            e = e11;
            cVar = null;
        }
        if (cVar2 != null) {
            cVar2.b(b11);
            cVar2.a("2000128", eVar);
            cVar2.h(str);
            cVar2.m(this.f37130h);
            com.mbridge.msdk.reward.report.metrics.a.a().a("2000128", cVar2);
            return cVar2;
        }
        cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
        try {
            cVar.m(this.f37130h);
            eVar.a("metrics_data_reason", "未获取到待展示的campaign信息 本地new metricsData");
            cVar.a("2000128", eVar);
            if (TextUtils.isEmpty(str)) {
                cVar.h(SameMD5.getMD5(t0.d()));
            } else {
                cVar.h(str);
                cVar.b(b11);
                com.mbridge.msdk.foundation.same.report.metrics.d.b().c().put(str, cVar);
            }
            com.mbridge.msdk.reward.report.metrics.a.a().a("2000128", cVar);
        } catch (Exception e12) {
            e = e12;
            if (MBridgeConstans.DEBUG) {
                o0.b("RewardVideoController", e.getMessage());
            }
            return cVar;
        }
        return cVar;
    }

    private String a(String str) {
        try {
            String md5 = TextUtils.isEmpty(str) ? SameMD5.getMD5(t0.d()) : "";
            String[] split = str.split("_");
            if (split != null && split.length >= 3) {
                md5 = split[2];
            }
            return TextUtils.isEmpty(md5) ? SameMD5.getMD5(t0.d()) : md5;
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return "";
            }
            e11.printStackTrace();
            return "";
        }
    }

    private CopyOnWriteArrayList<CampaignEx> a(String str, List<CampaignEx> list) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            for (CampaignEx campaignEx : list) {
                if (campaignEx != null && str.equals(campaignEx.getBidToken())) {
                    copyOnWriteArrayList.add(campaignEx);
                }
            }
        }
        return copyOnWriteArrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.mbridge.msdk.foundation.error.b bVar, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        if (this.f37128f != null) {
            this.Q = true;
            this.f37128f.a(bVar, cVar);
        }
    }

    private void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        if (this.f37128f != null) {
            com.mbridge.msdk.foundation.error.b a11 = com.mbridge.msdk.foundation.error.a.a(880035, "");
            if (cVar != null) {
                cVar.a(a11);
                cVar.b(true);
            }
            this.f37128f.a("bidToken is empty", cVar);
        }
    }

    public static void a(String str, int i11) {
        try {
            if (f37119d0 == null || !y0.b(str)) {
                return;
            }
            f37119d0.put(str, Integer.valueOf(i11));
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("RewardVideoController", e11.getMessage());
            }
        }
    }

    private void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        com.mbridge.msdk.videocommon.setting.c cVar2;
        com.mbridge.msdk.videocommon.setting.c cVar3;
        try {
            if (this.f37124b == null) {
                f();
            }
            if (this.f37124b != null) {
                o0.b("RewardVideoController", "controller 819");
                C0528a c0528a = null;
                if (this.f37143u ? a(false) : this.f37124b.l()) {
                    o0.c("RewardVideoController", "invoke adapter show isReady");
                    i iVar = new i(this, this, this.f37137o, c0528a);
                    f37121f0.put(this.f37130h, iVar);
                    this.f37124b.a(iVar, str, this.f37129g, this.f37138p, this.f37133k, cVar);
                    this.E = false;
                    return;
                }
                if (this.f37143u ? b() : this.f37124b.m()) {
                    o0.c("RewardVideoController", "invoke adapter show isSpareOfferReady");
                    i iVar2 = new i(this, this, this.f37137o, c0528a);
                    f37121f0.put(this.f37130h, iVar2);
                    this.f37124b.a(iVar2, str, this.f37129g, this.f37138p, this.f37133k, cVar);
                    this.E = false;
                    return;
                }
            }
            this.E = false;
            a("2000131", cVar, this.f37127e, "can't show because load is failed");
            if (this.f37127e != null) {
                try {
                    this.f37127e.onShowFail(cVar, this.f37131i, "can't show because load is failed");
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("RewardVideoController", e11.getMessage());
                    }
                }
            }
            if (this.f37142t || this.f37143u || (cVar3 = this.f37125c) == null || !cVar3.a(4) || this.f37128f == null || this.f37128f.a() == 1 || this.f37128f.a() == 3) {
                return;
            }
            a(false, com.mbridge.msdk.foundation.same.report.metrics.d.b().a(0, 94, this.f37130h, true, 1));
        } catch (Exception e12) {
            this.E = false;
            if (MBridgeConstans.DEBUG) {
                o0.b("RewardVideoController", e12.getLocalizedMessage());
            }
            a("2000131", cVar, this.f37127e, "show exception");
            if (this.f37127e != null) {
                try {
                    this.f37127e.onShowFail(cVar, this.f37131i, "show exception");
                } catch (Exception unused) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("RewardVideoController", e12.getMessage());
                    }
                }
            }
            if (this.f37142t || this.f37143u || (cVar2 = this.f37125c) == null || !cVar2.a(4) || this.f37128f == null || this.f37128f.a() == 1 || this.f37128f.a() == 3) {
                return;
            }
            a(false, com.mbridge.msdk.foundation.same.report.metrics.d.b().a(0, 94, this.f37130h, true, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar, InterVideoOutListener interVideoOutListener) {
        if (this.f37146x) {
            if (cVar == null) {
                cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
                cVar.b(this.H);
            }
            try {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                if (interVideoOutListener != null) {
                    eVar.a("listener_state", 1);
                } else {
                    eVar.a("listener_state", 2);
                }
                cVar.a(str, eVar);
                com.mbridge.msdk.reward.report.metrics.a.a().a(str, cVar);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar, InterVideoOutListener interVideoOutListener, String str2) {
        if (cVar == null) {
            try {
                cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
                cVar.b(this.H);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                    return;
                }
                return;
            }
        }
        com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
        if (!TextUtils.isEmpty(str2)) {
            eVar.a("reason", str2);
        }
        if (interVideoOutListener != null) {
            eVar.a("listener_state", 1);
        } else {
            eVar.a("listener_state", 2);
        }
        cVar.a(str, eVar);
        com.mbridge.msdk.reward.report.metrics.a.a().a(str, cVar);
    }

    public static void a(String str, String str2) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (concurrentHashMap = f37120e0) == null || concurrentHashMap.containsKey(str)) {
            return;
        }
        f37120e0.put(str, str2);
    }

    private void a(Queue<Integer> queue, boolean z10, String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        Integer poll;
        try {
            this.F = 25;
            this.G = 1;
            if (queue != null && queue.size() > 0 && (poll = queue.poll()) != null) {
                this.F = poll.intValue();
            }
            try {
                a(this.G, this.F, z10, str, cVar);
            } catch (Exception e11) {
                com.mbridge.msdk.foundation.error.b a11 = com.mbridge.msdk.foundation.error.a.a(880020, "load mv api error:" + e11.getMessage());
                if (cVar != null) {
                    cVar.a(a11);
                    cVar.b(true);
                }
                a(a11, cVar);
                if (MBridgeConstans.DEBUG) {
                    o0.b("RewardVideoController", e11.getMessage());
                }
            }
        } catch (Exception e12) {
            com.mbridge.msdk.foundation.error.b a12 = com.mbridge.msdk.foundation.error.a.a(880020, "load mv api error:" + e12.getMessage());
            if (cVar != null) {
                cVar.a(a12);
                cVar.b(true);
            }
            a(a12, cVar);
            if (MBridgeConstans.DEBUG) {
                o0.b("RewardVideoController", e12.getMessage());
            }
        }
    }

    private void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.reward.adapter.c cVar) {
        CampaignEx campaignEx = copyOnWriteArrayList.get(0);
        boolean isEmpty = TextUtils.isEmpty(campaignEx.getCMPTEntryUrl());
        boolean z10 = !isEmpty;
        int nscpt = campaignEx.getNscpt();
        this.U = false;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = false;
        com.mbridge.msdk.reward.adapter.b.b().a(this.f37122a, z10, nscpt, this.f37143u, this.f37142t ? MBSupportMuteAdType.INTERSTITIAL_VIDEO : 94, this.f37134l, this.f37130h, campaignEx.getRequestId(), copyOnWriteArrayList, new b(campaignEx, z10, cVar, nscpt), new c(campaignEx, copyOnWriteArrayList, z10, nscpt));
        if (isEmpty) {
            return;
        }
        com.mbridge.msdk.reward.adapter.b.b().a(this.f37122a, campaignEx, this.f37134l, this.f37130h, campaignEx.getRequestId(), new d(campaignEx, copyOnWriteArrayList, cVar, z10, nscpt));
    }

    private void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        try {
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a("cache", 1);
            cVar.a("2000127", eVar);
            cVar.a("2000048", eVar);
            cVar.a(copyOnWriteArrayList);
        } catch (Exception e11) {
            o0.b("RewardVideoController", e11.getMessage());
        }
        this.R = true;
        this.f37128f.a(this.f37143u);
        this.f37128f.b(this.f37134l, this.f37130h, cVar);
        CampaignEx campaignEx = copyOnWriteArrayList.get(0);
        a(campaignEx.getRequestId(), str);
        com.mbridge.msdk.reward.adapter.c cVar2 = this.f37124b;
        if (cVar2 == null || !cVar2.a(copyOnWriteArrayList, true ^ TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()), campaignEx.getNscpt())) {
            a(copyOnWriteArrayList, this.f37124b);
        } else {
            a(copyOnWriteArrayList);
            this.f37128f.d(this.f37134l, this.f37130h, cVar);
        }
    }

    private void a(boolean z10, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        if (!this.f37146x) {
            if (z10) {
                this.f37146x = z10;
            }
        } else if (z10) {
            String b11 = com.mbridge.msdk.foundation.error.a.b(880016, "errorCode: 3501 errorMessage: current unit is loading");
            com.mbridge.msdk.foundation.error.b a11 = com.mbridge.msdk.foundation.error.a.a(880016, "errorCode: 3501 errorMessage: current unit is loading");
            if (cVar != null) {
                cVar.a(a11);
                cVar.b(true);
            }
            this.f37128f.b(b11, cVar);
        }
    }

    private void a(boolean z10, com.mbridge.msdk.foundation.same.report.metrics.c cVar, com.mbridge.msdk.foundation.same.report.metrics.e eVar) {
        if (eVar == null) {
            eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
        }
        cVar.m(this.f37130h);
        cVar.a(this.f37142t ? MBSupportMuteAdType.INTERSTITIAL_VIDEO : 94);
        eVar.a("result", Integer.valueOf(z10 ? 1 : 2));
        eVar.a(CampaignEx.JSON_KEY_HB, Integer.valueOf(this.f37143u ? 1 : 0));
        cVar.a("m_offer_ready", eVar);
        com.mbridge.msdk.reward.report.metrics.a.a().a("m_offer_ready", cVar);
    }

    private void a(boolean z10, com.mbridge.msdk.foundation.same.report.metrics.c cVar, List<CampaignEx> list) {
        if (cVar == null) {
            cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
        }
        if (list != null && list.size() > 0) {
            CampaignEx campaignEx = list.get(0);
            if (campaignEx != null) {
                cVar.h(campaignEx.getLocalRequestId());
                cVar.f(campaignEx.getBidToken());
            }
            cVar.b(list);
        }
        a(z10, cVar, (com.mbridge.msdk.foundation.same.report.metrics.e) null);
    }

    private void a(boolean z10, String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        com.mbridge.msdk.reward.candidate.a aVar;
        com.mbridge.msdk.reward.candidate.a aVar2;
        if (this.f37128f != null) {
            if (!this.f37143u) {
                this.R = b(this.f37130h, cVar.o());
                if (!this.R) {
                    if (!c()) {
                        this.R = false;
                        com.mbridge.msdk.reward.adapter.c cVar2 = this.f37124b;
                        if (cVar2 != null) {
                            cVar2.c(this.S);
                        }
                        this.f37128f.a(this.f37143u);
                        a(this.I, z10, str, cVar);
                        return;
                    }
                    if (z10) {
                        if (this.f37128f != null) {
                            String b11 = com.mbridge.msdk.foundation.error.a.b(880019, "");
                            cVar.a(com.mbridge.msdk.foundation.error.a.a(880019, ""));
                            cVar.b(true);
                            this.f37128f.a(b11, cVar);
                            return;
                        }
                        return;
                    }
                    this.R = false;
                    com.mbridge.msdk.reward.adapter.c cVar3 = this.f37124b;
                    if (cVar3 != null) {
                        cVar3.c(this.S);
                    }
                    this.f37128f.a(this.f37143u);
                    a(this.I, z10, str, cVar);
                    return;
                }
                if (c()) {
                    o0.a("RewardVideoController", "非BID，本地存在可用的缓存，超过上限");
                    CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.S;
                    if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                        Iterator<CampaignEx> it = this.S.iterator();
                        while (it.hasNext()) {
                            com.mbridge.msdk.videocommon.cache.a.a().a(it.next(), this.f37130h);
                        }
                    }
                    com.mbridge.msdk.reward.adapter.c cVar4 = this.f37124b;
                    if (cVar4 != null) {
                        cVar4.c(this.S);
                    }
                    if (!z10) {
                        this.R = false;
                        this.f37128f.a(this.f37143u);
                        a(this.I, z10, str, cVar);
                        return;
                    } else {
                        if (this.f37128f != null) {
                            String b12 = com.mbridge.msdk.foundation.error.a.b(880019, "");
                            cVar.a(com.mbridge.msdk.foundation.error.a.a(880019, ""));
                            cVar.b(true);
                            this.f37128f.a(b12, cVar);
                            return;
                        }
                        return;
                    }
                }
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = this.S;
                if (copyOnWriteArrayList2 == null || copyOnWriteArrayList2.size() <= 0) {
                    return;
                }
                try {
                    com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                    eVar.a("cache", 1);
                    cVar.a("2000127", eVar);
                    cVar.a("2000048", eVar);
                    cVar.a(copyOnWriteArrayList2);
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("RewardVideoController", e11.getMessage());
                    }
                }
                this.f37128f.b(this.f37134l, this.f37130h, cVar);
                CampaignEx campaignEx = copyOnWriteArrayList2.get(0);
                this.f37128f.a(this.f37143u);
                com.mbridge.msdk.reward.adapter.c cVar5 = this.f37124b;
                if (cVar5 == null || !cVar5.a(copyOnWriteArrayList2, !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()), campaignEx.getNscpt())) {
                    a(copyOnWriteArrayList2, this.f37124b);
                } else {
                    a(copyOnWriteArrayList2);
                    this.f37128f.d(this.f37134l, this.f37130h, cVar);
                }
                if (this.L) {
                    com.mbridge.msdk.reward.adapter.c cVar6 = this.f37124b;
                    if (cVar6 != null) {
                        cVar6.c(this.S);
                    }
                    a(this.I, z10, str, cVar);
                    return;
                }
                return;
            }
            CopyOnWriteArrayList<CampaignEx> b13 = com.mbridge.msdk.videocommon.cache.a.a().b(this.f37130h, 1, this.f37143u, "");
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList3 = null;
            if (b13 != null && b13.size() > 0) {
                if (c()) {
                    com.mbridge.msdk.videocommon.cache.a.a().b(this.f37130h, str);
                    if (!z10 || this.f37128f == null) {
                        return;
                    }
                    String b14 = com.mbridge.msdk.foundation.error.a.b(880019, "");
                    com.mbridge.msdk.foundation.error.b a11 = com.mbridge.msdk.foundation.error.a.a(880019, "");
                    if (cVar != null) {
                        cVar.a(a11);
                        cVar.b(true);
                    }
                    this.f37128f.a(b14, cVar);
                    return;
                }
                if (this.f37124b == null) {
                    f();
                }
                CopyOnWriteArrayList<CampaignEx> a12 = a(str, b13);
                if (a12 != null && a12.size() > 0) {
                    a(a12, str, cVar);
                    return;
                }
                try {
                    com.mbridge.msdk.reward.candidate.a aVar3 = new com.mbridge.msdk.reward.candidate.a(this.f37130h, this.f37142t);
                    com.mbridge.msdk.foundation.cache.c cVar7 = new com.mbridge.msdk.foundation.cache.c();
                    if (aVar3.a(str)) {
                        aVar2 = aVar3;
                        cVar7 = aVar3.a(str, cVar, (CampaignEx) null, new com.mbridge.msdk.foundation.error.b(880038), 1, this.f37124b);
                        if (cVar7 != null && cVar7.g() == com.mbridge.msdk.foundation.cache.c.f35038l && cVar7.c() != null && cVar7.c().size() > 0 && this.f37124b != null) {
                            CopyOnWriteArrayList<CampaignEx> c11 = cVar7.c();
                            ArrayList arrayList = new ArrayList();
                            Iterator<CampaignEx> it2 = b13.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                CampaignEx next = it2.next();
                                if (next != null) {
                                    String requestId = next.getRequestId();
                                    if (!TextUtils.isEmpty(requestId)) {
                                        for (int i11 = 0; i11 < c11.size(); i11++) {
                                            CampaignEx campaignEx2 = c11.get(i11);
                                            if (campaignEx2 != null) {
                                                if (requestId.equals(campaignEx2.getRequestId())) {
                                                    break;
                                                } else if (i11 == c11.size() - 1) {
                                                    arrayList.add(next);
                                                }
                                            }
                                        }
                                        if (c11.size() == 0) {
                                            arrayList.add(next);
                                        }
                                    }
                                }
                            }
                            this.f37124b.c(arrayList);
                            this.f37124b.a(cVar7.c(), false, true, true);
                            copyOnWriteArrayList3 = new CopyOnWriteArrayList<>(cVar7.c());
                        }
                    } else {
                        aVar2 = aVar3;
                        copyOnWriteArrayList3 = b(str, b13);
                        if (copyOnWriteArrayList3.size() > 0) {
                            com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(str, copyOnWriteArrayList3);
                        }
                        cVar7.d("cb is closed");
                        cVar7.a(com.mbridge.msdk.foundation.cache.c.f35037k);
                    }
                    aVar2.a(cVar, str, cVar7, (List<a.b>) null, (JSONObject) null, 1);
                    if (copyOnWriteArrayList3 != null && copyOnWriteArrayList3.size() > 0) {
                        a(copyOnWriteArrayList3, str, cVar);
                        if (this.f37124b != null && !aVar2.a(str)) {
                            this.f37124b.c(copyOnWriteArrayList3);
                        }
                    }
                } catch (Exception e12) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("RewardVideoController", e12.getMessage());
                    }
                }
                this.R = false;
                this.f37128f.a(this.f37143u);
                a(this.I, z10, str, cVar);
                return;
            }
            if (c()) {
                com.mbridge.msdk.videocommon.cache.a.a().b(this.f37130h, str);
                if (!z10 || this.f37128f == null) {
                    return;
                }
                String b15 = com.mbridge.msdk.foundation.error.a.b(880019, "");
                com.mbridge.msdk.foundation.error.b a13 = com.mbridge.msdk.foundation.error.a.a(880019, "");
                if (cVar != null) {
                    cVar.a(a13);
                    cVar.b(true);
                }
                this.f37128f.a(b15, cVar);
                return;
            }
            try {
                com.mbridge.msdk.reward.candidate.a aVar4 = new com.mbridge.msdk.reward.candidate.a(this.f37130h, this.f37142t);
                com.mbridge.msdk.foundation.cache.c cVar8 = new com.mbridge.msdk.foundation.cache.c();
                if (aVar4.a(str)) {
                    if (this.f37124b == null) {
                        com.mbridge.msdk.reward.adapter.c cVar9 = new com.mbridge.msdk.reward.adapter.c(this.f37122a, this.f37134l, this.f37130h);
                        this.f37124b = cVar9;
                        cVar9.d(this.f37142t);
                        this.f37124b.e(this.f37143u);
                        if (this.f37142t) {
                            this.f37124b.a(this.f37139q, this.f37140r, this.f37141s);
                        }
                        this.f37124b.a(this.f37138p);
                        this.f37124b.a(this.f37125c);
                    }
                    aVar = aVar4;
                    cVar8 = aVar4.a(str, cVar, (CampaignEx) null, new com.mbridge.msdk.foundation.error.b(880038), 1, this.f37124b);
                    if (cVar8 != null && cVar8.g() == com.mbridge.msdk.foundation.cache.c.f35038l && cVar8.c() != null && cVar8.c().size() > 0 && this.f37124b != null) {
                        CopyOnWriteArrayList<CampaignEx> c12 = cVar8.c();
                        if (b13 != null) {
                            ArrayList arrayList2 = new ArrayList();
                            Iterator<CampaignEx> it3 = b13.iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    break;
                                }
                                CampaignEx next2 = it3.next();
                                if (next2 != null) {
                                    String requestId2 = next2.getRequestId();
                                    if (!TextUtils.isEmpty(requestId2)) {
                                        for (int i12 = 0; i12 < c12.size(); i12++) {
                                            CampaignEx campaignEx3 = c12.get(i12);
                                            if (campaignEx3 != null) {
                                                if (requestId2.equals(campaignEx3.getRequestId())) {
                                                    break;
                                                } else if (i12 == c12.size() - 1) {
                                                    arrayList2.add(next2);
                                                }
                                            }
                                        }
                                        if (c12.size() == 0) {
                                            arrayList2.add(next2);
                                        }
                                    }
                                }
                            }
                            this.f37124b.c(arrayList2);
                        }
                        this.f37124b.a(cVar8.c(), false, true, true);
                        copyOnWriteArrayList3 = new CopyOnWriteArrayList<>(cVar8.c());
                    }
                } else {
                    aVar = aVar4;
                    copyOnWriteArrayList3 = b(str, b13);
                    if (copyOnWriteArrayList3.size() > 0) {
                        com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(str, copyOnWriteArrayList3);
                    }
                    cVar8.d("cb is closed 2");
                    cVar8.a(com.mbridge.msdk.foundation.cache.c.f35037k);
                }
                aVar.a(cVar, str, cVar8, (List<a.b>) null, (JSONObject) null, 1);
                if (copyOnWriteArrayList3 != null && copyOnWriteArrayList3.size() > 0) {
                    a(copyOnWriteArrayList3, str, cVar);
                    if (this.f37124b != null && !aVar.a(str)) {
                        this.f37124b.c(copyOnWriteArrayList3);
                    }
                }
            } catch (Exception e13) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("RewardVideoController", e13.getMessage());
                }
            }
            this.R = false;
            this.f37128f.a(this.f37143u);
            a(this.I, z10, str, cVar);
        }
    }

    private boolean a(List<com.mbridge.msdk.foundation.entity.c> list, String str, boolean z10) {
        if (list == null) {
            return false;
        }
        for (com.mbridge.msdk.foundation.entity.c cVar : list) {
            if (cVar != null && str.equals(cVar.b())) {
                this.f37124b.c(cVar.a());
                this.f37124b.b(cVar.d());
                if (this.f37124b.l()) {
                    if (z10) {
                        com.mbridge.msdk.foundation.same.report.metrics.c cVar2 = new com.mbridge.msdk.foundation.same.report.metrics.c();
                        cVar2.h(cVar.d());
                        a(false, cVar2, (List<CampaignEx>) this.f37124b.h());
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private boolean a(boolean z10) {
        if (this.f37124b == null) {
            f();
        }
        List<com.mbridge.msdk.foundation.entity.c> a11 = com.mbridge.msdk.videocommon.cache.a.a().a(this.f37130h);
        String str = this.A;
        if (a11 == null || a11.size() <= 0) {
            if (!z10) {
                return false;
            }
            d("is_ready_ctir_false", "no effective campaign list");
            com.mbridge.msdk.foundation.same.report.metrics.c cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
            cVar.h(str);
            cVar.f(this.f37148z);
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, 8);
            cVar.a("m_offer_ready", eVar);
            a(false, cVar, (List<CampaignEx>) this.f37124b.h());
            return false;
        }
        String d11 = com.mbridge.msdk.foundation.same.buffer.b.d(this.f37130h);
        boolean a12 = TextUtils.isEmpty(d11) ? false : a(a11, d11, z10);
        if (z10) {
            d("is_ready_ctir_" + a12, "");
        }
        if (a12) {
            if (!z10) {
                return a12;
            }
            com.mbridge.msdk.foundation.same.report.metrics.c cVar2 = new com.mbridge.msdk.foundation.same.report.metrics.c();
            cVar2.h(str);
            a(a12, cVar2, this.f37124b.h());
            return a12;
        }
        for (com.mbridge.msdk.foundation.entity.c cVar3 : a11) {
            if (cVar3 != null) {
                this.f37124b.c(cVar3.a());
                this.f37124b.b(cVar3.d());
                if (this.f37124b.b(z10)) {
                    cVar3.d();
                    return true;
                }
            }
        }
        return a12;
    }

    private com.mbridge.msdk.foundation.same.report.metrics.c b(boolean z10, String str, com.mbridge.msdk.foundation.same.report.metrics.e eVar) {
        com.mbridge.msdk.foundation.same.report.metrics.c cVar;
        com.mbridge.msdk.foundation.same.report.metrics.c cVar2 = new com.mbridge.msdk.foundation.same.report.metrics.c();
        try {
            b(z10);
            String md5 = TextUtils.isEmpty(str) ? SameMD5.getMD5(t0.d()) : a(str);
            this.A = md5;
            cVar2 = com.mbridge.msdk.foundation.same.report.metrics.d.b().a(md5);
            if (cVar2 == null) {
                cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
                try {
                    com.mbridge.msdk.foundation.same.report.metrics.d.b().c().put(md5, cVar);
                    cVar.d(true);
                    cVar2 = cVar;
                } catch (Exception e11) {
                    e = e11;
                    if (MBridgeConstans.DEBUG) {
                        o0.b("RewardVideoController", e.getMessage());
                    }
                    return cVar;
                }
            }
            cVar2.h(md5);
            cVar2.m(this.f37130h);
            if (eVar != null) {
                if (eVar.a("adtp")) {
                    cVar2.a(Integer.parseInt((String) eVar.b("adtp")));
                }
                if (eVar.a(CampaignEx.JSON_KEY_HB)) {
                    String str2 = (String) eVar.b(CampaignEx.JSON_KEY_HB);
                    cVar2.g(str2);
                    if (str2.equals("1")) {
                        cVar2.f(str);
                    }
                }
            }
            cVar2.e(z10 ? "2" : "1");
            if (!z10) {
                return cVar2;
            }
            com.mbridge.msdk.reward.report.metrics.a.a().a("2000123", cVar2);
            return cVar2;
        } catch (Exception e12) {
            e = e12;
            cVar = cVar2;
        }
    }

    private CopyOnWriteArrayList<CampaignEx> b(String str, List<CampaignEx> list) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (list != null) {
            try {
                if (list.size() > 0) {
                    int i11 = 1;
                    for (CampaignEx campaignEx : list) {
                        if (campaignEx != null) {
                            if (campaignEx.getVcn() > i11) {
                                i11 = campaignEx.getVcn();
                            }
                            if (campaignEx.getTokenRule() == 1) {
                                String requestId = campaignEx.getRequestId();
                                if (!TextUtils.isEmpty(requestId)) {
                                    if (linkedHashMap.containsKey(requestId)) {
                                        List list2 = (List) linkedHashMap.get(requestId);
                                        if (list2 != null) {
                                            list2.add(campaignEx);
                                        }
                                    } else {
                                        ArrayList arrayList = new ArrayList();
                                        arrayList.add(campaignEx);
                                        linkedHashMap.put(requestId, arrayList);
                                    }
                                }
                            } else {
                                String requestId2 = campaignEx.getRequestId();
                                if (!TextUtils.isEmpty(requestId2)) {
                                    if (linkedHashMap2.containsKey(requestId2)) {
                                        List list3 = (List) linkedHashMap2.get(requestId2);
                                        if (list3 != null) {
                                            list3.add(campaignEx);
                                        }
                                    } else {
                                        ArrayList arrayList2 = new ArrayList();
                                        arrayList2.add(campaignEx);
                                        linkedHashMap2.put(requestId2, arrayList2);
                                    }
                                }
                            }
                        }
                    }
                    if (linkedHashMap2.size() + linkedHashMap.size() >= i11 && linkedHashMap.size() > 0 && linkedHashMap.entrySet() != null && linkedHashMap.entrySet().iterator() != null && linkedHashMap.entrySet().iterator().next() != null && ((Map.Entry) linkedHashMap.entrySet().iterator().next()).getValue() != null) {
                        copyOnWriteArrayList.addAll((Collection) ((Map.Entry) linkedHashMap.entrySet().iterator().next()).getValue());
                        com.mbridge.msdk.foundation.same.buffer.b.a(this.f37130h, str, i11);
                    }
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("RewardVideoController", e11.getMessage());
                }
            }
        }
        return copyOnWriteArrayList;
    }

    private void b(com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        if (this.f37128f != null) {
            String b11 = com.mbridge.msdk.foundation.error.a.b(880001, "");
            com.mbridge.msdk.foundation.error.b a11 = com.mbridge.msdk.foundation.error.a.a(880001, "");
            if (cVar != null) {
                cVar.a(a11);
                cVar.b(true);
            }
            this.f37128f.a(b11, cVar);
        }
    }

    private void b(boolean z10) {
        List<String> e11;
        if (z10) {
            try {
                com.mbridge.msdk.foundation.db.e a11 = com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(this.f37122a));
                if (a11 != null && (e11 = a11.e(this.f37130h)) != null && e11.size() > 0) {
                    Iterator<String> it = e11.iterator();
                    while (it.hasNext()) {
                        com.mbridge.msdk.foundation.same.report.metrics.d.b().c(it.next());
                    }
                }
                LinkedHashMap<String, com.mbridge.msdk.foundation.same.report.metrics.c> c11 = com.mbridge.msdk.foundation.same.report.metrics.d.b().c();
                if (c11 == null || c11.size() <= 0) {
                    return;
                }
                Iterator<Map.Entry<String, com.mbridge.msdk.foundation.same.report.metrics.c>> it2 = c11.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry<String, com.mbridge.msdk.foundation.same.report.metrics.c> next = it2.next();
                    if (next != null && next.getValue().z()) {
                        it2.remove();
                    }
                }
            } catch (Exception e12) {
                if (MBridgeConstans.DEBUG) {
                    e12.printStackTrace();
                }
            }
        }
    }

    private boolean b() {
        if (this.f37124b == null) {
            f();
        }
        List<com.mbridge.msdk.foundation.entity.c> a11 = com.mbridge.msdk.videocommon.cache.a.a().a(this.f37130h);
        if (a11 == null || a11.size() <= 0) {
            return false;
        }
        for (com.mbridge.msdk.foundation.entity.c cVar : a11) {
            if (cVar != null) {
                this.f37124b.c(cVar.a());
                this.f37124b.b(cVar.d());
                if (this.f37124b.m()) {
                    return true;
                }
                com.mbridge.msdk.videocommon.cache.a.a().d(this.f37130h, cVar.a());
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean b(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            com.mbridge.msdk.reward.adapter.c r0 = r4.f37124b     // Catch: java.lang.Exception -> Lf
            if (r0 == 0) goto L11
            java.lang.String r0 = r0.j()     // Catch: java.lang.Exception -> Lf
            boolean r0 = r5.equals(r0)     // Catch: java.lang.Exception -> Lf
            if (r0 != 0) goto L28
            goto L11
        Lf:
            r0 = move-exception
            goto L37
        L11:
            com.mbridge.msdk.reward.adapter.c r0 = new com.mbridge.msdk.reward.adapter.c     // Catch: java.lang.Exception -> Lf
            android.content.Context r1 = r4.f37122a     // Catch: java.lang.Exception -> Lf
            java.lang.String r2 = r4.f37134l     // Catch: java.lang.Exception -> Lf
            r0.<init>(r1, r2, r5)     // Catch: java.lang.Exception -> Lf
            r4.f37124b = r0     // Catch: java.lang.Exception -> Lf
            boolean r1 = r4.f37142t     // Catch: java.lang.Exception -> Lf
            r0.d(r1)     // Catch: java.lang.Exception -> Lf
            com.mbridge.msdk.reward.adapter.c r0 = r4.f37124b     // Catch: java.lang.Exception -> Lf
            boolean r1 = r4.f37143u     // Catch: java.lang.Exception -> Lf
            r0.e(r1)     // Catch: java.lang.Exception -> Lf
        L28:
            com.mbridge.msdk.reward.adapter.c r0 = r4.f37124b     // Catch: java.lang.Exception -> Lf
            int r1 = r4.f37138p     // Catch: java.lang.Exception -> Lf
            r0.a(r1)     // Catch: java.lang.Exception -> Lf
            com.mbridge.msdk.reward.adapter.c r0 = r4.f37124b     // Catch: java.lang.Exception -> Lf
            com.mbridge.msdk.videocommon.setting.c r1 = r4.f37125c     // Catch: java.lang.Exception -> Lf
            r0.a(r1)     // Catch: java.lang.Exception -> Lf
            goto L44
        L37:
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r1 == 0) goto L44
            java.lang.String r0 = r0.getMessage()
            java.lang.String r1 = "RewardVideoController"
            com.mbridge.msdk.foundation.tools.o0.b(r1, r0)
        L44:
            com.mbridge.msdk.videocommon.cache.a r0 = com.mbridge.msdk.videocommon.cache.a.a()
            boolean r1 = r4.f37143u
            r2 = 1
            java.util.List r0 = r0.b(r5, r2, r1)
            com.mbridge.msdk.videocommon.cache.a r1 = com.mbridge.msdk.videocommon.cache.a.a()
            boolean r3 = r4.f37143u
            java.util.List r1 = r1.a(r5, r2, r3)
            r4.T = r1
            if (r0 == 0) goto L98
            int r1 = r0.size()
            if (r1 <= 0) goto L98
            com.mbridge.msdk.videocommon.cache.a r1 = com.mbridge.msdk.videocommon.cache.a.a()
            r1.a(r5, r0, r6)
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r5 = r4.S
            if (r5 != 0) goto L76
            java.util.concurrent.CopyOnWriteArrayList r5 = new java.util.concurrent.CopyOnWriteArrayList
            r5.<init>()
            r4.S = r5
            goto L79
        L76:
            r5.clear()
        L79:
            java.util.Iterator r5 = r0.iterator()
        L7d:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L92
            java.lang.Object r0 = r5.next()
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0
            r0.setLocalRequestId(r6)
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r1 = r4.S
            r1.add(r0)
            goto L7d
        L92:
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r5 = r4.S
            r4.a(r5)
            return r2
        L98:
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r5 = r4.S
            if (r5 == 0) goto L9f
            r5.clear()
        L9f:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.controller.a.b(java.lang.String, java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, List<CampaignEx> list) {
        if (list != null) {
            try {
                if (list.size() <= 0 || this.O) {
                    return;
                }
                com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d())).b(list, str);
            } catch (Throwable th2) {
                o0.b("RewardVideoController", th2.getMessage());
            }
        }
    }

    private boolean c() {
        try {
            if (this.K == null) {
                this.K = com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d());
            }
            com.mbridge.msdk.foundation.db.h a11 = com.mbridge.msdk.foundation.db.h.a(this.K);
            if (this.f37125c == null) {
                this.f37125c = com.mbridge.msdk.videocommon.setting.b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), this.f37130h, this.f37142t);
            }
            int k11 = this.f37125c.k();
            if (a11 != null) {
                if (a11.a(this.f37130h, k11)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
            o0.b("RewardVideoController", "cap check error");
        }
        return false;
    }

    private void d(String str, String str2) {
        try {
            com.mbridge.msdk.foundation.same.report.metrics.c cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
            cVar.m(this.f37130h);
            cVar.a(this.f37142t ? MBSupportMuteAdType.INTERSTITIAL_VIDEO : 94);
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a("event_name", str);
            eVar.a("reason", str2);
            cVar.a("m_temp_is_ready_check", eVar);
            com.mbridge.msdk.reward.report.metrics.a.a().a("m_temp_is_ready_check", cVar);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    private boolean d() {
        if (this.f37124b == null) {
            f();
        }
        com.mbridge.msdk.reward.adapter.c cVar = this.f37124b;
        if (cVar != null) {
            return cVar.b(true);
        }
        return false;
    }

    private void f() {
        com.mbridge.msdk.reward.adapter.c cVar = new com.mbridge.msdk.reward.adapter.c(this.f37122a, this.f37134l, this.f37130h);
        this.f37124b = cVar;
        cVar.d(this.f37142t);
        this.f37124b.e(this.f37143u);
        if (this.f37142t) {
            this.f37124b.a(this.f37139q, this.f37140r, this.f37141s);
        }
        this.f37124b.a(this.f37125c);
    }

    static /* synthetic */ int m(a aVar) {
        int i11 = aVar.f37123a0;
        aVar.f37123a0 = i11 - 1;
        return i11;
    }

    private void w() {
        com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(this.f37122a)).b(this.f37130h);
    }

    private void x() {
        try {
            List<CampaignEx> c11 = com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(this.f37122a)).c(this.f37130h);
            if (c11 == null || c11.size() <= 0) {
                return;
            }
            for (CampaignEx campaignEx : c11) {
                if (TextUtils.isEmpty(campaignEx.getCMPTEntryUrl())) {
                    com.mbridge.msdk.videocommon.a.b(campaignEx.getAdType(), campaignEx);
                } else {
                    com.mbridge.msdk.videocommon.a.e(this.f37130h + "_" + campaignEx.getRequestId() + "_" + campaignEx.getCMPTEntryUrl());
                    if (campaignEx.getRewardTemplateMode() != null && !TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                        com.mbridge.msdk.videocommon.a.e(this.f37130h + "_" + campaignEx.getId() + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e());
                    }
                }
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("RewardVideoController", e11.getMessage());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:7:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.mbridge.msdk.foundation.same.report.metrics.c a(android.os.Message r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L1f
            android.os.Bundle r3 = r3.getData()     // Catch: java.lang.Exception -> L17
            if (r3 == 0) goto L1f
            com.mbridge.msdk.foundation.same.report.metrics.d r0 = com.mbridge.msdk.foundation.same.report.metrics.d.b()     // Catch: java.lang.Exception -> L17
            java.lang.String r1 = "metrics_data_lrid"
            java.lang.String r3 = r3.getString(r1)     // Catch: java.lang.Exception -> L17
            com.mbridge.msdk.foundation.same.report.metrics.c r3 = r0.a(r3)     // Catch: java.lang.Exception -> L17
            goto L20
        L17:
            r3 = move-exception
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r0 == 0) goto L1f
            r3.printStackTrace()
        L1f:
            r3 = 0
        L20:
            if (r3 != 0) goto L27
            com.mbridge.msdk.foundation.same.report.metrics.c r3 = new com.mbridge.msdk.foundation.same.report.metrics.c
            r3.<init>()
        L27:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.controller.a.a(android.os.Message):com.mbridge.msdk.foundation.same.report.metrics.c");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x003f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0040 A[Catch: Exception -> 0x002b, TryCatch #0 {Exception -> 0x002b, blocks: (B:25:0x0009, B:27:0x000f, B:29:0x0016, B:30:0x002f, B:4:0x0039, B:8:0x0040, B:11:0x0075, B:13:0x0088, B:15:0x0096), top: B:24:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.mbridge.msdk.foundation.same.report.metrics.c a(java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r5, com.mbridge.msdk.foundation.same.report.metrics.c r6) {
        /*
            r4 = this;
            com.mbridge.msdk.foundation.same.report.metrics.c r0 = new com.mbridge.msdk.foundation.same.report.metrics.c
            r0.<init>()
            java.lang.String r1 = ""
            if (r5 == 0) goto L38
            int r2 = r5.size()     // Catch: java.lang.Exception -> L2b
            if (r2 <= 0) goto L38
            r2 = 0
            java.lang.Object r3 = r5.get(r2)     // Catch: java.lang.Exception -> L2b
            if (r3 == 0) goto L2e
            java.lang.Object r1 = r5.get(r2)     // Catch: java.lang.Exception -> L2b
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = (com.mbridge.msdk.foundation.entity.CampaignEx) r1     // Catch: java.lang.Exception -> L2b
            java.lang.String r1 = r1.getLocalRequestId()     // Catch: java.lang.Exception -> L2b
            java.lang.Object r2 = r5.get(r2)     // Catch: java.lang.Exception -> L2b
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = (com.mbridge.msdk.foundation.entity.CampaignEx) r2     // Catch: java.lang.Exception -> L2b
            java.lang.String r2 = r2.getNLRid()     // Catch: java.lang.Exception -> L2b
            goto L2f
        L2b:
            r5 = move-exception
            goto La2
        L2e:
            r2 = r1
        L2f:
            r0.h(r1)     // Catch: java.lang.Exception -> L2b
            r0.b(r5)     // Catch: java.lang.Exception -> L2b
            r5 = r1
            r1 = r2
            goto L39
        L38:
            r5 = r1
        L39:
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L2b
            if (r1 == 0) goto L40
            return r6
        L40:
            com.mbridge.msdk.foundation.same.report.metrics.e r6 = new com.mbridge.msdk.foundation.same.report.metrics.e     // Catch: java.lang.Exception -> L2b
            r6.<init>()     // Catch: java.lang.Exception -> L2b
            java.lang.String r1 = "cache"
            r2 = 1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> L2b
            r6.a(r1, r3)     // Catch: java.lang.Exception -> L2b
            java.lang.String r1 = "hb"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> L2b
            r6.a(r1, r2)     // Catch: java.lang.Exception -> L2b
            java.lang.String r1 = "auto_load"
            r2 = 2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> L2b
            r6.a(r1, r2)     // Catch: java.lang.Exception -> L2b
            java.lang.String r1 = "2000127"
            r0.a(r1, r6)     // Catch: java.lang.Exception -> L2b
            java.lang.String r1 = "2000048"
            r0.a(r1, r6)     // Catch: java.lang.Exception -> L2b
            boolean r6 = r4.f37142t     // Catch: java.lang.Exception -> L2b
            if (r6 == 0) goto L73
            r6 = 287(0x11f, float:4.02E-43)
            goto L75
        L73:
            r6 = 94
        L75:
            r0.a(r6)     // Catch: java.lang.Exception -> L2b
            java.lang.String r6 = "1"
            r0.g(r6)     // Catch: java.lang.Exception -> L2b
            java.lang.String r6 = "2"
            r0.e(r6)     // Catch: java.lang.Exception -> L2b
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> L2b
            if (r6 != 0) goto La9
            com.mbridge.msdk.foundation.same.report.metrics.d r6 = com.mbridge.msdk.foundation.same.report.metrics.d.b()     // Catch: java.lang.Exception -> L2b
            java.util.LinkedHashMap r6 = r6.c()     // Catch: java.lang.Exception -> L2b
            boolean r6 = r6.containsKey(r5)     // Catch: java.lang.Exception -> L2b
            if (r6 != 0) goto La9
            com.mbridge.msdk.foundation.same.report.metrics.d r6 = com.mbridge.msdk.foundation.same.report.metrics.d.b()     // Catch: java.lang.Exception -> L2b
            java.util.LinkedHashMap r6 = r6.c()     // Catch: java.lang.Exception -> L2b
            r6.put(r5, r0)     // Catch: java.lang.Exception -> L2b
            goto La9
        La2:
            boolean r6 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r6 == 0) goto La9
            r5.printStackTrace()
        La9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.controller.a.a(java.util.List, com.mbridge.msdk.foundation.same.report.metrics.c):com.mbridge.msdk.foundation.same.report.metrics.c");
    }

    public void a() {
        try {
            String str = "";
            MBridgeIds mBridgeIds = this.f37131i;
            if (mBridgeIds != null) {
                if (!this.C) {
                    mBridgeIds.setBidToken("");
                    return;
                }
                String m11 = m();
                if (TextUtils.isEmpty(m11)) {
                    return;
                }
                ConcurrentHashMap<String, String> concurrentHashMap = f37120e0;
                if (concurrentHashMap != null && concurrentHashMap.containsKey(m11) && !TextUtils.isEmpty(f37120e0.get(m11))) {
                    str = f37120e0.get(m11);
                }
                this.f37131i.setBidToken(str);
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public void a(int i11) {
        this.f37138p = i11;
    }

    public void a(int i11, int i12, int i13) {
        this.f37139q = i11;
        this.f37140r = i12;
        if (i12 == com.mbridge.msdk.foundation.same.a.K) {
            this.f37141s = i13 < 0 ? 5 : i13;
        }
        if (i12 == com.mbridge.msdk.foundation.same.a.J) {
            this.f37141s = i13 < 0 ? 80 : i13;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ivRewardEnable", 1);
            jSONObject.put("ivRewardMode", i11 == com.mbridge.msdk.foundation.same.a.H ? 0 : 1);
            jSONObject.put("ivRewardPlayValueMode", i12 == com.mbridge.msdk.foundation.same.a.J ? 0 : 1);
            jSONObject.put("ivRewardPlayValue", i13);
            com.mbridge.msdk.setting.h.b().i(this.f37130h, jSONObject.toString());
        } catch (Exception unused) {
            o0.b("RewardVideoController", "setIVRewardEnable to SP was ERROR");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0031 A[Catch: Exception -> 0x0011, TryCatch #0 {Exception -> 0x0011, blocks: (B:2:0x0000, B:4:0x0004, B:7:0x002d, B:9:0x0031, B:10:0x003c, B:14:0x0014), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(int r11, int r12, boolean r13, java.lang.String r14, com.mbridge.msdk.foundation.same.report.metrics.c r15) {
        /*
            r10 = this;
            com.mbridge.msdk.reward.adapter.c r0 = r10.f37124b     // Catch: java.lang.Exception -> L11
            if (r0 == 0) goto L14
            java.lang.String r1 = r10.f37130h     // Catch: java.lang.Exception -> L11
            java.lang.String r0 = r0.j()     // Catch: java.lang.Exception -> L11
            boolean r0 = r1.equals(r0)     // Catch: java.lang.Exception -> L11
            if (r0 != 0) goto L2d
            goto L14
        L11:
            r11 = move-exception
            goto L9b
        L14:
            com.mbridge.msdk.reward.adapter.c r0 = new com.mbridge.msdk.reward.adapter.c     // Catch: java.lang.Exception -> L11
            android.content.Context r1 = r10.f37122a     // Catch: java.lang.Exception -> L11
            java.lang.String r2 = r10.f37134l     // Catch: java.lang.Exception -> L11
            java.lang.String r3 = r10.f37130h     // Catch: java.lang.Exception -> L11
            r0.<init>(r1, r2, r3)     // Catch: java.lang.Exception -> L11
            r10.f37124b = r0     // Catch: java.lang.Exception -> L11
            boolean r1 = r10.f37142t     // Catch: java.lang.Exception -> L11
            r0.d(r1)     // Catch: java.lang.Exception -> L11
            com.mbridge.msdk.reward.adapter.c r0 = r10.f37124b     // Catch: java.lang.Exception -> L11
            boolean r1 = r10.f37143u     // Catch: java.lang.Exception -> L11
            r0.e(r1)     // Catch: java.lang.Exception -> L11
        L2d:
            boolean r0 = r10.f37142t     // Catch: java.lang.Exception -> L11
            if (r0 == 0) goto L3c
            com.mbridge.msdk.reward.adapter.c r0 = r10.f37124b     // Catch: java.lang.Exception -> L11
            int r1 = r10.f37139q     // Catch: java.lang.Exception -> L11
            int r2 = r10.f37140r     // Catch: java.lang.Exception -> L11
            int r3 = r10.f37141s     // Catch: java.lang.Exception -> L11
            r0.a(r1, r2, r3)     // Catch: java.lang.Exception -> L11
        L3c:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Exception -> L11
            r0.<init>()     // Catch: java.lang.Exception -> L11
            r10.H = r0     // Catch: java.lang.Exception -> L11
            com.mbridge.msdk.reward.adapter.c r0 = r10.f37124b     // Catch: java.lang.Exception -> L11
            int r1 = r10.f37138p     // Catch: java.lang.Exception -> L11
            r0.a(r1)     // Catch: java.lang.Exception -> L11
            com.mbridge.msdk.reward.adapter.c r0 = r10.f37124b     // Catch: java.lang.Exception -> L11
            com.mbridge.msdk.videocommon.setting.c r1 = r10.f37125c     // Catch: java.lang.Exception -> L11
            r0.a(r1)     // Catch: java.lang.Exception -> L11
            com.mbridge.msdk.reward.controller.a$f r0 = new com.mbridge.msdk.reward.controller.a$f     // Catch: java.lang.Exception -> L11
            com.mbridge.msdk.reward.adapter.c r4 = r10.f37124b     // Catch: java.lang.Exception -> L11
            r2 = r0
            r3 = r10
            r5 = r11
            r6 = r13
            r7 = r14
            r8 = r15
            r2.<init>(r4, r5, r6, r7, r8)     // Catch: java.lang.Exception -> L11
            r0.a(r12)     // Catch: java.lang.Exception -> L11
            com.mbridge.msdk.reward.controller.a$g r1 = new com.mbridge.msdk.reward.controller.a$g     // Catch: java.lang.Exception -> L11
            com.mbridge.msdk.reward.adapter.c r2 = r10.f37124b     // Catch: java.lang.Exception -> L11
            r1.<init>(r2, r13)     // Catch: java.lang.Exception -> L11
            r10.f37132j = r1     // Catch: java.lang.Exception -> L11
            r1.a(r0)     // Catch: java.lang.Exception -> L11
            com.mbridge.msdk.reward.adapter.c r1 = r10.f37124b     // Catch: java.lang.Exception -> L11
            com.mbridge.msdk.reward.controller.a$g r2 = r10.f37132j     // Catch: java.lang.Exception -> L11
            r1.a(r2)     // Catch: java.lang.Exception -> L11
            com.mbridge.msdk.reward.adapter.c r1 = r10.f37124b     // Catch: java.lang.Exception -> L11
            java.lang.String r2 = ""
            r3 = 0
            r1.a(r3, r2)     // Catch: java.lang.Exception -> L11
            com.mbridge.msdk.reward.adapter.c r1 = r10.f37124b     // Catch: java.lang.Exception -> L11
            com.mbridge.msdk.reward.controller.a$j r2 = new com.mbridge.msdk.reward.controller.a$j     // Catch: java.lang.Exception -> L11
            r2.<init>()     // Catch: java.lang.Exception -> L11
            r1.a(r2)     // Catch: java.lang.Exception -> L11
            com.mbridge.msdk.reward.adapter.c r3 = r10.f37124b     // Catch: java.lang.Exception -> L11
            boolean r8 = r10.f37147y     // Catch: java.lang.Exception -> L11
            r4 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r9 = r15
            r3.a(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L11
            android.os.Handler r11 = r10.f37137o     // Catch: java.lang.Exception -> L11
            int r12 = r12 * 1000
            long r12 = (long) r12     // Catch: java.lang.Exception -> L11
            r11.postDelayed(r0, r12)     // Catch: java.lang.Exception -> L11
            goto Lbf
        L9b:
            java.lang.String r12 = r11.getMessage()
            r13 = 880020(0xd6d94, float:1.23317E-39)
            com.mbridge.msdk.foundation.error.b r12 = com.mbridge.msdk.foundation.error.a.a(r13, r12)
            if (r15 == 0) goto Laf
            r15.a(r12)
            r13 = 1
            r15.b(r13)
        Laf:
            r10.a(r12, r15)
            boolean r12 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r12 == 0) goto Lbf
            java.lang.String r11 = r11.getMessage()
            java.lang.String r12 = "RewardVideoController"
            com.mbridge.msdk.foundation.tools.o0.b(r12, r11)
        Lbf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.controller.a.a(int, int, boolean, java.lang.String, com.mbridge.msdk.foundation.same.report.metrics.c):void");
    }

    public void a(InterVideoOutListener interVideoOutListener) {
        this.f37127e = interVideoOutListener;
        this.f37128f = new h(this, interVideoOutListener, this.f37137o, this.f37130h, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:135:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.lang.String r11, java.lang.String r12, java.lang.String r13, com.mbridge.msdk.foundation.same.report.metrics.e r14) {
        /*
            Method dump skipped, instructions count: 586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.controller.a.a(java.lang.String, java.lang.String, java.lang.String, com.mbridge.msdk.foundation.same.report.metrics.e):void");
    }

    public void a(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str)) {
            w0.b(this.f37122a, "MBridge_ConfirmTitle" + this.f37130h, str.trim());
        }
        if (!TextUtils.isEmpty(str2)) {
            w0.b(this.f37122a, "MBridge_ConfirmContent" + this.f37130h, str2.trim());
        }
        if (!TextUtils.isEmpty(str4)) {
            w0.b(this.f37122a, "MBridge_CancelText" + this.f37130h, str4.trim());
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        w0.b(this.f37122a, "MBridge_ConfirmText" + this.f37130h, str3.trim());
    }

    public void a(List<CampaignEx> list) {
        if (list == null || list.size() <= 0) {
            this.H = new ArrayList();
        } else {
            this.H = list;
        }
    }

    public void a(boolean z10, com.mbridge.msdk.foundation.same.report.metrics.e eVar) {
        a(z10, "", eVar);
    }

    public void a(boolean z10, String str, com.mbridge.msdk.foundation.same.report.metrics.e eVar) {
        com.mbridge.msdk.foundation.same.report.metrics.c b11 = b(z10, str, eVar);
        this.f37148z = str;
        if (this.f37128f == null) {
            this.f37128f = new h(this, null, this.f37137o, this.f37130h, null);
        }
        if (this.f37128f != null && this.f37128f.a() == 1) {
            a(z10, b11);
            return;
        }
        this.f37123a0 = 1;
        if (this.f37128f == null || this.f37128f.a() != 3) {
            this.L = true;
            if (this.f37128f != null) {
                this.f37128f.a(1);
            }
        } else {
            this.L = false;
        }
        this.f37146x = z10;
        this.f37137o.removeMessages(1001001);
        this.O = false;
        this.N = false;
        this.P = false;
        this.Q = false;
        x();
        w();
        com.mbridge.msdk.reward.adapter.b.b().c();
        try {
            if (TextUtils.isEmpty(str)) {
                if (this.f37142t) {
                    com.mbridge.msdk.timer.b.getInstance().addInterstitialList(this.f37134l, this.f37130h);
                } else {
                    com.mbridge.msdk.timer.b.getInstance().addRewardList(this.f37134l, this.f37130h);
                }
            }
            if (this.f37143u && TextUtils.isEmpty(str)) {
                a(b11);
                return;
            }
            if (com.mbridge.msdk.system.a.map == null) {
                b(b11);
                return;
            }
            com.mbridge.msdk.videocommon.setting.c c11 = com.mbridge.msdk.videocommon.setting.b.b().c(com.mbridge.msdk.foundation.controller.c.m().b(), this.f37130h);
            this.f37125c = c11;
            if (c11 == null) {
                this.J = com.mbridge.msdk.foundation.controller.c.m().b();
                com.mbridge.msdk.videocommon.setting.b.b().a(this.J, com.mbridge.msdk.foundation.controller.c.m().c(), this.f37130h, new C0528a());
                this.f37125c = com.mbridge.msdk.videocommon.setting.b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), this.f37130h, this.f37142t);
            }
            if (!TextUtils.isEmpty(this.f37134l)) {
                this.f37125c.f(this.f37134l);
            }
            int n11 = this.f37125c.n() * 1000;
            if (this.f37137o != null) {
                Message obtain = Message.obtain();
                obtain.what = 1001002;
                if (b11 != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("metrics_data_lrid", b11.o());
                    obtain.setData(bundle);
                }
                this.f37137o.sendMessageDelayed(obtain, n11);
            }
            this.I = this.f37125c.z();
            try {
                a(z10, str, b11);
            } catch (Exception e11) {
                if (this.f37128f != null) {
                    com.mbridge.msdk.foundation.error.b a11 = com.mbridge.msdk.foundation.error.a.a(880020, "load exception");
                    if (b11 != null) {
                        b11.a(a11);
                        b11.b(true);
                    }
                    this.f37128f.a(a11, b11);
                }
                if (MBridgeConstans.DEBUG) {
                    o0.b("RewardVideoController", e11.getMessage());
                }
            }
        } catch (Exception e12) {
            if (this.f37128f != null) {
                com.mbridge.msdk.foundation.error.b a12 = com.mbridge.msdk.foundation.error.a.a(880001, "");
                if (b11 != null) {
                    b11.a(a12);
                    b11.b(true);
                }
                this.f37128f.a(a12, b11);
            }
            if (MBridgeConstans.DEBUG) {
                o0.b("RewardVideoController", e12.getMessage());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005d A[Catch: Exception -> 0x003d, TryCatch #0 {Exception -> 0x003d, blocks: (B:3:0x002c, B:5:0x0030, B:8:0x0059, B:10:0x005d, B:11:0x0068, B:13:0x006e, B:15:0x0078, B:16:0x008c, B:20:0x0040), top: B:2:0x002c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(boolean r10, java.lang.String r11, com.mbridge.msdk.foundation.same.report.metrics.c r12) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.controller.a.b(boolean, java.lang.String, com.mbridge.msdk.foundation.same.report.metrics.c):void");
    }

    public void c(String str, String str2) {
        try {
            this.f37122a = com.mbridge.msdk.foundation.controller.c.m().d();
            this.f37130h = str2;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            this.f37134l = str;
            this.f37131i = new MBridgeIds(this.f37134l, this.f37130h);
            this.f37126d = com.mbridge.msdk.videocommon.setting.b.b().c();
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new com.mbridge.msdk.reward.controller.c(this.f37122a, this.f37130h));
            if (this.K == null) {
                this.K = com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d());
            }
        } catch (Throwable th2) {
            o0.b("RewardVideoController", th2.getMessage(), th2);
        }
    }

    public boolean c(boolean z10) {
        boolean a11;
        try {
            if (c()) {
                if (!z10) {
                    return false;
                }
                d("is_ready_start", "over cap check error");
                com.mbridge.msdk.foundation.same.report.metrics.c cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, 10);
                cVar.a("m_offer_ready", eVar);
                a(false, cVar, (List<CampaignEx>) this.f37124b.h());
                return false;
            }
            if (this.f37143u) {
                try {
                    a11 = a(z10);
                } catch (Exception e11) {
                    if (!MBridgeConstans.DEBUG) {
                        return false;
                    }
                    o0.b("RewardVideoController", e11.getMessage());
                    return false;
                }
            } else {
                a11 = d();
            }
            return a11;
        } catch (Throwable th2) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            o0.b("RewardVideoController", th2.getMessage());
            return false;
        }
    }

    public void d(boolean z10) {
        this.f37142t = z10;
        if (z10) {
            this.f37138p = com.mbridge.msdk.foundation.same.a.X;
        } else {
            this.f37138p = com.mbridge.msdk.foundation.same.a.W;
        }
    }

    public void e() {
        m0.b();
    }

    public void e(boolean z10) {
        this.f37143u = z10;
    }

    public void f(boolean z10) {
        this.f37147y = z10;
    }

    public MBridgeIds g() {
        return this.f37131i;
    }

    public List<CampaignEx> h() {
        return this.T;
    }

    public CopyOnWriteArrayList<CampaignEx> i() {
        return this.S;
    }

    public String j() {
        com.mbridge.msdk.reward.adapter.c cVar = this.f37124b;
        return cVar != null ? cVar.g() : "";
    }

    public h k() {
        return this.f37128f;
    }

    public String l() {
        return this.f37134l;
    }

    public String m() {
        com.mbridge.msdk.reward.adapter.c cVar = this.f37124b;
        return cVar != null ? cVar.a(this.C) : "";
    }

    public com.mbridge.msdk.reward.adapter.c n() {
        return this.f37124b;
    }

    public InterVideoOutListener o() {
        return this.f37127e;
    }

    public String p() {
        return this.f37130h;
    }

    public void q() {
        com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new e());
    }

    public boolean r() {
        return this.f37143u;
    }

    public boolean s() {
        return this.f37146x;
    }

    public boolean t() {
        return this.f37142t;
    }

    public boolean u() {
        return (this.f37127e == null || this.f37128f == null) ? false : true;
    }

    public void v() {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (!this.C || (concurrentHashMap = f37120e0) == null || concurrentHashMap.containsKey(m())) {
            return;
        }
        f37120e0.remove(m());
    }
}

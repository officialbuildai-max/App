package com.mbridge.msdk.reward.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.cache.a;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.c;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.y0;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.mbridge.msdk.out.MBSupportMuteAdType;
import com.mbridge.msdk.reward.adapter.b;
import com.mbridge.msdk.reward.controller.a;
import com.mbridge.msdk.reward.player.MBRewardVideoActivity;
import com.mbridge.msdk.videocommon.a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
import org.mvel2.ast.ASTNode;

/* loaded from: classes5.dex */
public class c {
    private String C;
    private h D;
    public String K;
    private List<CampaignEx> V;
    private CopyOnWriteArrayList<CampaignEx> W;
    private List<CampaignEx> X;

    /* renamed from: a, reason: collision with root package name */
    private Context f37021a;

    /* renamed from: b, reason: collision with root package name */
    private String f37022b;

    /* renamed from: c, reason: collision with root package name */
    private String f37023c;

    /* renamed from: d, reason: collision with root package name */
    private int f37024d;

    /* renamed from: e, reason: collision with root package name */
    private int f37025e;

    /* renamed from: f, reason: collision with root package name */
    private int f37026f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f37027g;

    /* renamed from: h, reason: collision with root package name */
    private String f37028h;

    /* renamed from: i, reason: collision with root package name */
    private com.mbridge.msdk.video.bt.module.orglistener.h f37029i;

    /* renamed from: j, reason: collision with root package name */
    private volatile com.mbridge.msdk.reward.adapter.a f37030j;

    /* renamed from: k, reason: collision with root package name */
    private volatile a.j f37031k;

    /* renamed from: l, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.setting.c f37032l;

    /* renamed from: r, reason: collision with root package name */
    private boolean f37038r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f37039s;

    /* renamed from: u, reason: collision with root package name */
    private String f37041u;

    /* renamed from: v, reason: collision with root package name */
    private int f37042v;

    /* renamed from: w, reason: collision with root package name */
    private int f37043w;

    /* renamed from: x, reason: collision with root package name */
    private int f37044x;

    /* renamed from: y, reason: collision with root package name */
    private CampaignUnit f37045y;

    /* renamed from: z, reason: collision with root package name */
    private CopyOnWriteArrayList<CampaignEx> f37046z;

    /* renamed from: m, reason: collision with root package name */
    private boolean f37033m = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f37034n = false;

    /* renamed from: o, reason: collision with root package name */
    public Object f37035o = new Object();

    /* renamed from: p, reason: collision with root package name */
    private CopyOnWriteArrayList<CampaignEx> f37036p = new CopyOnWriteArrayList<>();

    /* renamed from: q, reason: collision with root package name */
    private int f37037q = 2;

    /* renamed from: t, reason: collision with root package name */
    private String f37040t = "";
    private boolean A = false;
    private long B = 0;
    private boolean E = false;
    private boolean F = false;
    public String G = "";
    public String H = "";
    public String I = "";
    public int J = 0;
    private Handler L = new a(Looper.getMainLooper());
    private boolean M = false;
    private long N = 0;
    volatile boolean O = false;
    volatile boolean P = false;
    volatile boolean Q = false;
    volatile boolean R = false;
    volatile boolean S = false;
    public volatile boolean T = false;
    private String U = "";

    /* loaded from: classes5.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Removed duplicated region for block: B:162:0x03ae A[Catch: all -> 0x005b, Exception -> 0x02ff, TryCatch #0 {Exception -> 0x02ff, blocks: (B:151:0x02e3, B:153:0x02ed, B:155:0x02f5, B:156:0x0303, B:158:0x0311, B:160:0x03a8, B:162:0x03ae, B:164:0x03bd, B:165:0x03c1, B:166:0x03c5, B:169:0x031e, B:171:0x0328, B:173:0x0330, B:174:0x0339, B:176:0x0347, B:177:0x0352, B:179:0x035a, B:180:0x0363, B:182:0x036b, B:188:0x037f, B:189:0x0393), top: B:150:0x02e3 }] */
        /* JADX WARN: Removed duplicated region for block: B:194:0x03de A[Catch: all -> 0x005b, Exception -> 0x005f, TryCatch #1 {Exception -> 0x005f, blocks: (B:3:0x000e, B:10:0x0023, B:12:0x0046, B:14:0x0051, B:15:0x0063, B:17:0x006b, B:19:0x0071, B:25:0x0086, B:27:0x008e, B:29:0x0096, B:31:0x00a2, B:33:0x00cc, B:35:0x00f3, B:38:0x0107, B:40:0x0124, B:41:0x0136, B:43:0x013e, B:45:0x014a, B:47:0x015a, B:49:0x0162, B:51:0x016e, B:52:0x017a, B:54:0x0180, B:57:0x0188, B:62:0x0192, B:64:0x01a1, B:65:0x01a4, B:67:0x01bb, B:69:0x01c7, B:70:0x01d2, B:72:0x01d8, B:133:0x02b6, B:136:0x02ba, B:146:0x02c3, B:148:0x02cb, B:192:0x03d6, B:194:0x03de, B:195:0x03e7, B:197:0x041a, B:198:0x0426, B:201:0x0437, B:203:0x043f, B:204:0x044a, B:206:0x0453, B:207:0x0464, B:209:0x046b, B:212:0x0475, B:214:0x047d, B:217:0x048d, B:219:0x0495, B:221:0x049b, B:223:0x04a7), top: B:2:0x000e }] */
        /* JADX WARN: Removed duplicated region for block: B:197:0x041a A[Catch: all -> 0x005b, Exception -> 0x005f, TryCatch #1 {Exception -> 0x005f, blocks: (B:3:0x000e, B:10:0x0023, B:12:0x0046, B:14:0x0051, B:15:0x0063, B:17:0x006b, B:19:0x0071, B:25:0x0086, B:27:0x008e, B:29:0x0096, B:31:0x00a2, B:33:0x00cc, B:35:0x00f3, B:38:0x0107, B:40:0x0124, B:41:0x0136, B:43:0x013e, B:45:0x014a, B:47:0x015a, B:49:0x0162, B:51:0x016e, B:52:0x017a, B:54:0x0180, B:57:0x0188, B:62:0x0192, B:64:0x01a1, B:65:0x01a4, B:67:0x01bb, B:69:0x01c7, B:70:0x01d2, B:72:0x01d8, B:133:0x02b6, B:136:0x02ba, B:146:0x02c3, B:148:0x02cb, B:192:0x03d6, B:194:0x03de, B:195:0x03e7, B:197:0x041a, B:198:0x0426, B:201:0x0437, B:203:0x043f, B:204:0x044a, B:206:0x0453, B:207:0x0464, B:209:0x046b, B:212:0x0475, B:214:0x047d, B:217:0x048d, B:219:0x0495, B:221:0x049b, B:223:0x04a7), top: B:2:0x000e }] */
        /* JADX WARN: Removed duplicated region for block: B:93:0x0234  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x0236  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void handleMessage(android.os.Message r19) {
            /*
                Method dump skipped, instructions count: 1240
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.c.a.handleMessage(android.os.Message):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b extends com.mbridge.msdk.reward.request.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.foundation.same.report.metrics.c f37048e;

        b(com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            this.f37048e = cVar;
        }

        @Override // com.mbridge.msdk.reward.request.a
        public void a(CampaignUnit campaignUnit) {
            CampaignEx campaignEx;
            try {
                c.this.c(campaignUnit);
                c.this.a(campaignUnit);
                if (campaignUnit != null) {
                    c.this.G = campaignUnit.getRequestId();
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
                if (c.this.f37046z != null && c.this.f37046z.size() > 0 && (campaignEx = (CampaignEx) c.this.f37046z.get(0)) != null && TextUtils.isEmpty(campaignEx.getNLRid())) {
                    c.this.f37046z.clear();
                }
                if (c.this.V != null) {
                    c.this.V.clear();
                }
                c.this.O = false;
                c.this.P = false;
                synchronized (c.this.f37035o) {
                    try {
                        if (c.this.Q) {
                            c.this.Q = false;
                        }
                        c.this.S = false;
                        c.this.R = false;
                        c.this.b("exception after load success", this.f37048e);
                        c.this.n();
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }

        @Override // com.mbridge.msdk.reward.request.a
        public void b(int i11, String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            CampaignEx campaignEx;
            if (i11 == -1) {
                c.this.B = System.currentTimeMillis();
            }
            if (c.this.f37046z != null && c.this.f37046z.size() > 0 && (campaignEx = (CampaignEx) c.this.f37046z.get(0)) != null && TextUtils.isEmpty(campaignEx.getNLRid())) {
                c.this.f37046z.clear();
            }
            if (c.this.V != null) {
                c.this.V.clear();
            }
            c.this.O = false;
            c.this.P = false;
            synchronized (c.this.f37035o) {
                try {
                    if (c.this.Q) {
                        c.this.Q = false;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            c.this.a(cVar, i11);
            c.this.S = false;
            c.this.R = false;
            if (!c.this.M) {
                c.this.a(i11, str, cVar);
            }
            c.this.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.reward.adapter.c$c, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0524c implements b.h {

        /* renamed from: a, reason: collision with root package name */
        com.mbridge.msdk.foundation.same.report.metrics.c f37050a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f37051b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f37052c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CopyOnWriteArrayList f37053d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f37054e;

        /* renamed from: com.mbridge.msdk.reward.adapter.c$c$a */
        /* loaded from: classes5.dex */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CampaignEx f37056a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f37057b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f37058c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f37059d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ CopyOnWriteArrayList f37060e;

            /* renamed from: com.mbridge.msdk.reward.adapter.c$c$a$a, reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            class C0525a implements b.o {
                C0525a() {
                }

                @Override // com.mbridge.msdk.reward.adapter.b.o
                public void a(String str, String str2, String str3, a.C0573a c0573a, com.mbridge.msdk.foundation.error.b bVar) {
                    if (bVar != null) {
                        bVar.a("his_reason", "preload template failed is tpl :" + C0524c.this.f37052c);
                    }
                    if (C0524c.this.f37051b.getRsIgnoreCheckRule() != null && C0524c.this.f37051b.getRsIgnoreCheckRule().size() > 0 && C0524c.this.f37051b.getRsIgnoreCheckRule().contains(1)) {
                        o0.c("RewardMVVideoAdapter", "template download fail but hit ignoreCheckRule");
                        return;
                    }
                    a aVar = a.this;
                    c cVar = c.this;
                    cVar.a(aVar.f37058c, (List<CampaignEx>) cVar.V, c.this.f37039s, str2);
                    if (c.this.L != null) {
                        c.this.L.removeMessages(5);
                    }
                    if (c.this.f37030j == null || c.this.S) {
                        return;
                    }
                    c.this.S = false;
                    C0524c c0524c = C0524c.this;
                    if (c0524c.f37050a == null) {
                        c0524c.f37050a = new com.mbridge.msdk.foundation.same.report.metrics.c();
                    }
                    C0524c c0524c2 = C0524c.this;
                    c0524c2.f37050a.b(c0524c2.f37053d);
                    C0524c.this.f37050a.a(bVar);
                    c.this.f37030j.a(c.this.V, bVar, C0524c.this.f37050a);
                    o0.a("RewardMVVideoAdapter", "Campaign 下载失败： 非大模板，播放模板预加载失败 onVideoLoadFail");
                }

                @Override // com.mbridge.msdk.reward.adapter.b.o
                public void a(String str, String str2, String str3, String str4, String str5, a.C0573a c0573a) {
                    C0524c c0524c = C0524c.this;
                    if (c.this.a(c0524c.f37053d, c0524c.f37052c, c0524c.f37054e)) {
                        c cVar = c.this;
                        String str6 = cVar.f37022b;
                        a aVar = a.this;
                        cVar.a(str6, aVar.f37060e, (List<CampaignEx>) c.this.X, c.this.f37039s);
                        if (c.this.L != null) {
                            c.this.L.removeMessages(5);
                        }
                        if (c.this.f37030j == null || c.this.R) {
                            return;
                        }
                        c.this.R = true;
                        C0524c c0524c2 = C0524c.this;
                        com.mbridge.msdk.foundation.same.report.metrics.c cVar2 = c0524c2.f37050a;
                        if (cVar2 != null) {
                            cVar2.b(c0524c2.f37053d);
                        }
                        com.mbridge.msdk.reward.adapter.a aVar2 = c.this.f37030j;
                        C0524c c0524c3 = C0524c.this;
                        aVar2.a(c0524c3.f37053d, c0524c3.f37050a);
                        return;
                    }
                    c cVar3 = c.this;
                    cVar3.a(str3, (List<CampaignEx>) cVar3.V, c.this.f37039s, str4);
                    if (c.this.L != null) {
                        c.this.L.removeMessages(5);
                    }
                    if (c.this.f37030j == null || c.this.S) {
                        return;
                    }
                    c.this.S = false;
                    com.mbridge.msdk.foundation.error.b a11 = com.mbridge.msdk.foundation.error.a.a(880015, "errorCode: 3502 errorMessage: temp preload success but isReady false");
                    C0524c c0524c4 = C0524c.this;
                    if (c0524c4.f37050a == null) {
                        c0524c4.f37050a = new com.mbridge.msdk.foundation.same.report.metrics.c();
                    }
                    C0524c c0524c5 = C0524c.this;
                    c0524c5.f37050a.b(c0524c5.f37053d);
                    C0524c.this.f37050a.a(a11);
                    com.mbridge.msdk.reward.adapter.a aVar3 = c.this.f37030j;
                    C0524c c0524c6 = C0524c.this;
                    aVar3.a(c0524c6.f37053d, a11, c0524c6.f37050a);
                    o0.a("RewardMVVideoAdapter", "Campaign 下载成功： 非大模板，播放模板预加载成功,isReay false onVideoLoadFail");
                }
            }

            a(CampaignEx campaignEx, String str, String str2, String str3, CopyOnWriteArrayList copyOnWriteArrayList) {
                this.f37056a = campaignEx;
                this.f37057b = str;
                this.f37058c = str2;
                this.f37059d = str3;
                this.f37060e = copyOnWriteArrayList;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.mbridge.msdk.reward.adapter.b b11 = com.mbridge.msdk.reward.adapter.b.b();
                boolean z10 = c.this.A;
                Handler handler = c.this.L;
                boolean z11 = c.this.f37038r;
                boolean z12 = c.this.f37039s;
                String e11 = this.f37056a.getRewardTemplateMode().e();
                int i11 = c.this.f37037q;
                C0524c c0524c = C0524c.this;
                b11.a(z10, handler, z11, z12, null, e11, i11, c0524c.f37051b, c0524c.f37053d, H5DownLoadManager.getInstance().getH5ResAddress(this.f37056a.getRewardTemplateMode().e()), this.f37057b, this.f37058c, this.f37059d, this.f37056a.getRequestIdNotice(), c.this.f37032l, new C0525a());
            }
        }

        /* renamed from: com.mbridge.msdk.reward.adapter.c$c$b */
        /* loaded from: classes5.dex */
        class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f37063a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f37064b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ CopyOnWriteArrayList f37065c;

            /* renamed from: com.mbridge.msdk.reward.adapter.c$c$b$a */
            /* loaded from: classes5.dex */
            class a implements b.o {
                a() {
                }

                @Override // com.mbridge.msdk.reward.adapter.b.o
                public void a(String str, String str2, String str3, a.C0573a c0573a, com.mbridge.msdk.foundation.error.b bVar) {
                    if (bVar != null) {
                        bVar.a("his_reason", "errorCode: 3303 errorMessage: tpl temp preload failed");
                    }
                    if (C0524c.this.f37051b.getRsIgnoreCheckRule() != null && C0524c.this.f37051b.getRsIgnoreCheckRule().size() > 0 && C0524c.this.f37051b.getRsIgnoreCheckRule().contains(3)) {
                        o0.c("RewardMVVideoAdapter", "template download fail but hit ignoreCheckRule");
                        return;
                    }
                    b bVar2 = b.this;
                    c cVar = c.this;
                    cVar.a(bVar2.f37064b, (List<CampaignEx>) cVar.V, c.this.f37039s, str2);
                    if (c.this.L != null) {
                        c.this.L.removeMessages(5);
                    }
                    if (c.this.f37030j == null || c.this.S) {
                        return;
                    }
                    c.this.S = false;
                    C0524c c0524c = C0524c.this;
                    if (c0524c.f37050a == null) {
                        c0524c.f37050a = new com.mbridge.msdk.foundation.same.report.metrics.c();
                    }
                    C0524c c0524c2 = C0524c.this;
                    c0524c2.f37050a.b(c0524c2.f37053d);
                    C0524c.this.f37050a.a(bVar);
                    c.this.f37030j.a(c.this.V, bVar, C0524c.this.f37050a);
                    o0.a("RewardMVVideoAdapter", "Campaign 下载成功： 大模板预加载失败 onVideoLoadFail");
                }

                @Override // com.mbridge.msdk.reward.adapter.b.o
                public void a(String str, String str2, String str3, String str4, String str5, a.C0573a c0573a) {
                    C0524c c0524c = C0524c.this;
                    if (c.this.a(c0524c.f37053d, c0524c.f37052c, c0524c.f37054e)) {
                        c cVar = c.this;
                        String str6 = cVar.f37022b;
                        b bVar = b.this;
                        cVar.a(str6, bVar.f37065c, (List<CampaignEx>) c.this.X, c.this.f37039s);
                        if (c.this.L != null) {
                            c.this.L.removeMessages(5);
                        }
                        if (c.this.f37030j == null || c.this.R) {
                            return;
                        }
                        c.this.R = true;
                        C0524c c0524c2 = C0524c.this;
                        com.mbridge.msdk.foundation.same.report.metrics.c cVar2 = c0524c2.f37050a;
                        if (cVar2 != null) {
                            cVar2.b(c0524c2.f37053d);
                        }
                        com.mbridge.msdk.reward.adapter.a aVar = c.this.f37030j;
                        C0524c c0524c3 = C0524c.this;
                        aVar.a(c0524c3.f37053d, c0524c3.f37050a);
                        return;
                    }
                    c cVar3 = c.this;
                    cVar3.a(str3, (List<CampaignEx>) cVar3.V, c.this.f37039s, str4);
                    if (c.this.L != null) {
                        c.this.L.removeMessages(5);
                    }
                    if (c.this.f37030j == null || c.this.S) {
                        return;
                    }
                    c.this.S = false;
                    com.mbridge.msdk.foundation.error.b a11 = com.mbridge.msdk.foundation.error.a.a(880015, "errorCode: 3505 errorMessage: tpl temp preload success but isReady false");
                    C0524c c0524c4 = C0524c.this;
                    if (c0524c4.f37050a == null) {
                        c0524c4.f37050a = new com.mbridge.msdk.foundation.same.report.metrics.c();
                    }
                    C0524c c0524c5 = C0524c.this;
                    c0524c5.f37050a.b(c0524c5.f37053d);
                    C0524c.this.f37050a.a(a11);
                    c.this.f37030j.a(c.this.V, a11, C0524c.this.f37050a);
                    o0.a("RewardMVVideoAdapter", "Campaign 下载成功： 大模板预加载成功,isReady false onVideoLoadFail");
                }
            }

            b(String str, String str2, CopyOnWriteArrayList copyOnWriteArrayList) {
                this.f37063a = str;
                this.f37064b = str2;
                this.f37065c = copyOnWriteArrayList;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.mbridge.msdk.reward.adapter.b b11 = com.mbridge.msdk.reward.adapter.b.b();
                boolean z10 = c.this.A;
                Handler handler = c.this.L;
                boolean z11 = c.this.f37038r;
                boolean z12 = c.this.f37039s;
                String str = this.f37063a;
                String requestIdNotice = C0524c.this.f37051b.getRequestIdNotice();
                String str2 = c.this.f37023c;
                String str3 = this.f37064b;
                String cMPTEntryUrl = C0524c.this.f37051b.getCMPTEntryUrl();
                int i11 = c.this.f37037q;
                C0524c c0524c = C0524c.this;
                b11.a(z10, handler, z11, z12, str, requestIdNotice, str2, str3, cMPTEntryUrl, i11, c0524c.f37051b, c0524c.f37053d, H5DownLoadManager.getInstance().getH5ResAddress(C0524c.this.f37051b.getCMPTEntryUrl()), this.f37064b, c.this.f37032l, new a(), false);
            }
        }

        /* renamed from: com.mbridge.msdk.reward.adapter.c$c$c, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class RunnableC0526c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CopyOnWriteArrayList f37068a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.mbridge.msdk.foundation.error.b f37069b;

            RunnableC0526c(CopyOnWriteArrayList copyOnWriteArrayList, com.mbridge.msdk.foundation.error.b bVar) {
                this.f37068a = copyOnWriteArrayList;
                this.f37069b = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                cVar.a(cVar.f37022b, this.f37068a, c.this.f37039s, "");
                if (c.this.L != null) {
                    c.this.L.removeMessages(5);
                }
                if (c.this.S || c.this.f37030j == null) {
                    return;
                }
                c.this.S = false;
                C0524c c0524c = C0524c.this;
                if (c0524c.f37050a == null) {
                    c0524c.f37050a = new com.mbridge.msdk.foundation.same.report.metrics.c();
                }
                C0524c c0524c2 = C0524c.this;
                c0524c2.f37050a.b(c0524c2.f37053d);
                com.mbridge.msdk.foundation.error.b bVar = this.f37069b;
                if (bVar != null) {
                    bVar.c("errorCode: 3201 errorMessage: campaign resource download failed");
                }
                C0524c.this.f37050a.a(this.f37069b);
                c.this.f37030j.a(this.f37068a, this.f37069b, C0524c.this.f37050a);
                o0.a("RewardMVVideoAdapter", "Campaign 下载失败：onVideoLoadFail");
            }
        }

        C0524c(CampaignEx campaignEx, boolean z10, CopyOnWriteArrayList copyOnWriteArrayList, int i11) {
            this.f37051b = campaignEx;
            this.f37052c = z10;
            this.f37053d = copyOnWriteArrayList;
            this.f37054e = i11;
            this.f37050a = com.mbridge.msdk.foundation.same.report.metrics.d.b().c().get(campaignEx.getLocalRequestId());
        }

        @Override // com.mbridge.msdk.reward.adapter.b.h
        public void a(String str, String str2, String str3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            c.this.O = true;
            if (this.f37052c) {
                if (!c.this.P || c.this.Q || c.this.L == null) {
                    return;
                }
                synchronized (c.this.f37035o) {
                    try {
                        if (c.this.Q) {
                            return;
                        }
                        c.this.Q = true;
                        c.this.L.post(new b(str3, str2, copyOnWriteArrayList));
                        return;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            Iterator<CampaignEx> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CampaignEx next = it.next();
                if (next != null && next.getRewardTemplateMode() != null && !TextUtils.isEmpty(next.getRewardTemplateMode().e()) && !next.getRewardTemplateMode().e().contains(CampaignEx.KEY_IS_CMPT_ENTRY) && c.this.L != null) {
                    c.this.L.post(new a(next, str, str2, str3, copyOnWriteArrayList));
                } else if (c.this.a(this.f37053d, this.f37052c, this.f37054e)) {
                    c cVar = c.this;
                    cVar.a(cVar.f37022b, copyOnWriteArrayList, (List<CampaignEx>) c.this.X, c.this.f37039s);
                    if (c.this.L != null) {
                        c.this.L.removeMessages(5);
                    }
                    if (c.this.f37030j != null && !c.this.R) {
                        c.this.R = true;
                        com.mbridge.msdk.foundation.same.report.metrics.c cVar2 = this.f37050a;
                        if (cVar2 != null) {
                            cVar2.b(this.f37053d);
                        }
                        c.this.f37030j.a(this.f37053d, this.f37050a);
                    }
                } else {
                    c cVar3 = c.this;
                    cVar3.a(str2, (List<CampaignEx>) cVar3.V, c.this.f37039s, str3);
                    if (c.this.L != null) {
                        c.this.L.removeMessages(5);
                    }
                    if (c.this.f37030j != null && !c.this.S) {
                        c.this.S = false;
                        com.mbridge.msdk.foundation.error.b a11 = com.mbridge.msdk.foundation.error.a.a(880015, "errorCode: 3503 errorMessage: have no temp but isReady false");
                        if (this.f37050a == null) {
                            this.f37050a = new com.mbridge.msdk.foundation.same.report.metrics.c();
                        }
                        this.f37050a.b(this.f37053d);
                        this.f37050a.a(a11);
                        c.this.f37030j.a(this.f37053d, a11, this.f37050a);
                        o0.a("RewardMVVideoAdapter", "Campaign 下载成功： 非大模板，不存在播放模板,isReay false onVideoLoadFail");
                    }
                }
            }
        }

        @Override // com.mbridge.msdk.reward.adapter.b.h
        public void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.foundation.error.b bVar) {
            c.this.O = false;
            if (c.this.f37030j == null || c.this.L == null) {
                return;
            }
            c.this.L.post(new RunnableC0526c(copyOnWriteArrayList, bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements b.n {

        /* renamed from: a, reason: collision with root package name */
        com.mbridge.msdk.foundation.same.report.metrics.c f37071a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f37072b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f37073c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CopyOnWriteArrayList f37074d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f37075e;

        /* loaded from: classes5.dex */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f37077a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.mbridge.msdk.foundation.error.b f37078b;

            a(String str, com.mbridge.msdk.foundation.error.b bVar) {
                this.f37077a = str;
                this.f37078b = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                cVar.a(cVar.f37022b, (List<CampaignEx>) c.this.V, c.this.f37039s, this.f37077a);
                if (c.this.L != null) {
                    c.this.L.removeMessages(5);
                }
                if (c.this.S || c.this.f37030j == null) {
                    return;
                }
                c.this.S = false;
                com.mbridge.msdk.foundation.error.b bVar = this.f37078b;
                if (bVar != null) {
                    bVar.c("errorCode: 3202 errorMessage: temp resource download failed");
                }
                d dVar = d.this;
                if (dVar.f37071a == null) {
                    dVar.f37071a = new com.mbridge.msdk.foundation.same.report.metrics.c();
                }
                d dVar2 = d.this;
                dVar2.f37071a.b(dVar2.f37074d);
                d.this.f37071a.a(this.f37078b);
                c.this.f37030j.a(c.this.V, this.f37078b, d.this.f37071a);
                o0.a("RewardMVVideoAdapter", "播放模板下载失败，非大模板 onVideoLoadFail");
            }
        }

        /* loaded from: classes5.dex */
        class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f37080a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.mbridge.msdk.foundation.error.b f37081b;

            b(String str, com.mbridge.msdk.foundation.error.b bVar) {
                this.f37080a = str;
                this.f37081b = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                cVar.a(cVar.f37022b, (List<CampaignEx>) c.this.V, c.this.f37039s, this.f37080a);
                if (c.this.L != null) {
                    c.this.L.removeMessages(5);
                }
                if (c.this.S || c.this.f37030j == null) {
                    return;
                }
                c.this.S = false;
                com.mbridge.msdk.foundation.error.b bVar = this.f37081b;
                if (bVar != null) {
                    bVar.c("errorCode: 3203 errorMessage: tpl temp resource download failed");
                }
                d dVar = d.this;
                if (dVar.f37071a == null) {
                    dVar.f37071a = new com.mbridge.msdk.foundation.same.report.metrics.c();
                }
                d dVar2 = d.this;
                dVar2.f37071a.b(dVar2.f37074d);
                d.this.f37071a.a(this.f37081b);
                c.this.f37030j.a(c.this.V, this.f37081b, d.this.f37071a);
                o0.a("RewardMVVideoAdapter", "播放模板下载失败，大模板，nscpt 1 onVideoLoadFail");
            }
        }

        d(CampaignEx campaignEx, boolean z10, CopyOnWriteArrayList copyOnWriteArrayList, int i11) {
            this.f37072b = campaignEx;
            this.f37073c = z10;
            this.f37074d = copyOnWriteArrayList;
            this.f37075e = i11;
            this.f37071a = com.mbridge.msdk.foundation.same.report.metrics.d.b().c().get(campaignEx.getLocalRequestId());
        }

        @Override // com.mbridge.msdk.reward.adapter.b.n
        public void a(String str, String str2, com.mbridge.msdk.foundation.error.b bVar) {
            o0.a("RewardMVVideoAdapter", "template 下载失败： ");
            if (bVar != null) {
                bVar.c("errorCode: 3202 errorMessage: temp resource download failed");
            }
            if (!this.f37073c && c.this.f37030j != null && c.this.L != null) {
                o0.a("RewardMVVideoAdapter", "播放模板下载失败，非大模板");
                if (this.f37072b.getRsIgnoreCheckRule() == null || this.f37072b.getRsIgnoreCheckRule().size() <= 0 || !this.f37072b.getRsIgnoreCheckRule().contains(1)) {
                    c.this.L.post(new a(str2, bVar));
                    return;
                } else {
                    o0.c("RewardMVVideoAdapter", "template download fail but hit ignoreCheckRule");
                    return;
                }
            }
            if (this.f37075e == 1) {
                if (this.f37072b.getRsIgnoreCheckRule() != null && this.f37072b.getRsIgnoreCheckRule().size() > 0) {
                    if (this.f37072b.getRsIgnoreCheckRule().contains(3)) {
                        o0.c("RewardMVVideoAdapter", "tpl download fail but hit ignoreCheckRule");
                        return;
                    } else if (this.f37072b.getCMPTEntryUrl().equals(this.f37072b.getendcard_url()) && this.f37072b.getRsIgnoreCheckRule().contains(2)) {
                        o0.c("RewardMVVideoAdapter", "endcard download fail but hit ignoreCheckRule at 3203");
                        return;
                    }
                }
                if (c.this.f37030j == null || c.this.L == null) {
                    return;
                }
                c.this.L.post(new b(str2, bVar));
            }
        }

        @Override // com.mbridge.msdk.reward.adapter.b.n
        public void a(String str, String str2, String str3, String str4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e implements b.n {

        /* renamed from: a, reason: collision with root package name */
        com.mbridge.msdk.foundation.same.report.metrics.c f37083a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f37084b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CopyOnWriteArrayList f37085c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f37086d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f37087e;

        /* loaded from: classes5.dex */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f37089a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f37090b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f37091c;

            /* renamed from: com.mbridge.msdk.reward.adapter.c$e$a$a, reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            class C0527a implements b.o {
                C0527a() {
                }

                @Override // com.mbridge.msdk.reward.adapter.b.o
                public void a(String str, String str2, String str3, a.C0573a c0573a, com.mbridge.msdk.foundation.error.b bVar) {
                    o0.a("RewardMVVideoAdapter", "大模板业务，大模板预加载失败");
                    o0.b("HBOPTIMIZE", "模板加载失败 requestId " + str2);
                    a aVar = a.this;
                    c cVar = c.this;
                    cVar.a(aVar.f37091c, (List<CampaignEx>) cVar.V, c.this.f37039s, str2);
                    if (c.this.L != null) {
                        c.this.L.removeMessages(5);
                    }
                    if (c.this.f37030j == null || c.this.S) {
                        return;
                    }
                    c.this.S = false;
                    e eVar = e.this;
                    if (eVar.f37083a == null) {
                        eVar.f37083a = new com.mbridge.msdk.foundation.same.report.metrics.c();
                    }
                    e eVar2 = e.this;
                    eVar2.f37083a.b(eVar2.f37085c);
                    e.this.f37083a.a(bVar);
                    c.this.f37030j.a(c.this.V, bVar, e.this.f37083a);
                    o0.a("RewardMVVideoAdapter", "大模板业务，大模板预加载失败 onVideoLoadFail");
                }

                @Override // com.mbridge.msdk.reward.adapter.b.o
                public void a(String str, String str2, String str3, String str4, String str5, a.C0573a c0573a) {
                    o0.a("HBOPTIMIZE", "模板加载成功 requestId " + str4);
                    e eVar = e.this;
                    if (c.this.a(eVar.f37085c, eVar.f37086d, eVar.f37087e)) {
                        c cVar = c.this;
                        cVar.a(cVar.f37022b, (List<CampaignEx>) c.this.V, (List<CampaignEx>) c.this.X, c.this.f37039s);
                        if (c.this.L != null) {
                            c.this.L.removeMessages(5);
                        }
                        if (c.this.f37030j == null || c.this.R) {
                            return;
                        }
                        c.this.R = true;
                        e eVar2 = e.this;
                        com.mbridge.msdk.foundation.same.report.metrics.c cVar2 = eVar2.f37083a;
                        if (cVar2 != null) {
                            cVar2.b(eVar2.f37085c);
                        }
                        com.mbridge.msdk.reward.adapter.a aVar = c.this.f37030j;
                        e eVar3 = e.this;
                        aVar.a(eVar3.f37085c, eVar3.f37083a);
                        return;
                    }
                    c cVar3 = c.this;
                    cVar3.a(str3, (List<CampaignEx>) cVar3.V, c.this.f37039s, a.this.f37089a);
                    if (c.this.L != null) {
                        c.this.L.removeMessages(5);
                    }
                    if (c.this.f37030j == null || c.this.S) {
                        return;
                    }
                    c.this.S = false;
                    com.mbridge.msdk.foundation.error.b a11 = com.mbridge.msdk.foundation.error.a.a(880008, "errorCode: 3505 errorMessage: tpl temp preload success but isReady false");
                    e eVar4 = e.this;
                    if (eVar4.f37083a == null) {
                        eVar4.f37083a = new com.mbridge.msdk.foundation.same.report.metrics.c();
                    }
                    e eVar5 = e.this;
                    eVar5.f37083a.b(eVar5.f37085c);
                    e.this.f37083a.a(a11);
                    c.this.f37030j.a(c.this.V, a11, e.this.f37083a);
                    o0.a("RewardMVVideoAdapter", "大模板业务，大模板预加载成功 isReady false  onVideoLoadFail");
                }
            }

            a(String str, String str2, String str3) {
                this.f37089a = str;
                this.f37090b = str2;
                this.f37091c = str3;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.mbridge.msdk.reward.adapter.b b11 = com.mbridge.msdk.reward.adapter.b.b();
                boolean z10 = c.this.A;
                Handler handler = c.this.L;
                boolean z11 = c.this.f37038r;
                boolean z12 = c.this.f37039s;
                String str = this.f37089a;
                String requestIdNotice = e.this.f37084b.getRequestIdNotice();
                String str2 = this.f37090b;
                String str3 = this.f37091c;
                String cMPTEntryUrl = e.this.f37084b.getCMPTEntryUrl();
                int i11 = c.this.f37037q;
                e eVar = e.this;
                b11.a(z10, handler, z11, z12, str, requestIdNotice, str2, str3, cMPTEntryUrl, i11, eVar.f37084b, eVar.f37085c, H5DownLoadManager.getInstance().getH5ResAddress(e.this.f37084b.getCMPTEntryUrl()), this.f37091c, c.this.f37032l, new C0527a(), false);
            }
        }

        e(CampaignEx campaignEx, CopyOnWriteArrayList copyOnWriteArrayList, boolean z10, int i11) {
            this.f37084b = campaignEx;
            this.f37085c = copyOnWriteArrayList;
            this.f37086d = z10;
            this.f37087e = i11;
            this.f37083a = com.mbridge.msdk.foundation.same.report.metrics.d.b().c().get(campaignEx.getLocalRequestId());
        }

        @Override // com.mbridge.msdk.reward.adapter.b.n
        public void a(String str, String str2, com.mbridge.msdk.foundation.error.b bVar) {
            o0.a("RewardMVVideoAdapter", "大模板业务，大模板下载失败");
            if (this.f37084b.getRsIgnoreCheckRule() != null && this.f37084b.getRsIgnoreCheckRule().size() > 0) {
                if (this.f37084b.getRsIgnoreCheckRule().contains(3)) {
                    o0.c("RewardMVVideoAdapter", "tpl download fail but hit ignoreCheckRule");
                    return;
                } else if (this.f37084b.getCMPTEntryUrl().equals(this.f37084b.getendcard_url()) && this.f37084b.getRsIgnoreCheckRule().contains(2)) {
                    o0.c("RewardMVVideoAdapter", "endcard download fail but hit ignoreCheckRule at 3203");
                    return;
                }
            }
            c cVar = c.this;
            cVar.a(cVar.f37022b, (List<CampaignEx>) c.this.V, c.this.f37039s, str2);
            c.this.P = false;
            if (c.this.L != null) {
                c.this.L.removeMessages(5);
            }
            if (c.this.f37030j == null || c.this.S) {
                return;
            }
            c.this.S = false;
            if (bVar != null) {
                bVar.c("errorCode: 3203 errorMessage: tpl temp resource download failed");
            }
            if (this.f37083a == null) {
                this.f37083a = new com.mbridge.msdk.foundation.same.report.metrics.c();
            }
            this.f37083a.b(this.f37085c);
            this.f37083a.a(bVar);
            c.this.f37030j.a(c.this.V, bVar, this.f37083a);
            o0.a("RewardMVVideoAdapter", "大模板业务，大模板下载失败 onVideoLoadFail");
        }

        @Override // com.mbridge.msdk.reward.adapter.b.n
        public void a(String str, String str2, String str3, String str4) {
            o0.a("RewardMVVideoAdapter", "大模板业务，大模板下载成功");
            c.this.P = true;
            if (!c.this.O || c.this.Q || c.this.L == null) {
                return;
            }
            synchronized (c.this.f37035o) {
                try {
                    if (c.this.Q) {
                        return;
                    }
                    c.this.Q = true;
                    c.this.L.post(new a(str3, str, str2));
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class f extends c.a {
        f() {
        }

        @Override // com.mbridge.msdk.foundation.same.c.a
        public void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            com.mbridge.msdk.reward.report.metrics.a.a().a(str, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignUnit f37095a;

        g(CampaignUnit campaignUnit) {
            this.f37095a = campaignUnit;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.a(com.mbridge.msdk.foundation.db.g.a(c.this.f37021a)).a();
            CampaignUnit campaignUnit = this.f37095a;
            if (campaignUnit == null || campaignUnit.getAds() == null || this.f37095a.getAds().size() <= 0) {
                return;
            }
            c.this.d(this.f37095a.getAds());
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private String f37097a;

        /* renamed from: b, reason: collision with root package name */
        private com.mbridge.msdk.foundation.same.report.metrics.c f37098b;

        public h(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            this.f37097a = str;
            this.f37098b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (c.this.E) {
                    return;
                }
                c.this.F = true;
                if (c.this.L != null) {
                    Message obtainMessage = c.this.L.obtainMessage();
                    obtainMessage.obj = this.f37097a;
                    obtainMessage.what = 2;
                    if (this.f37098b != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("metrics_data_lrid", this.f37098b.o());
                        obtainMessage.setData(bundle);
                    }
                    c.this.L.sendMessage(obtainMessage);
                }
            } catch (Exception e11) {
                o0.b("RewardMVVideoAdapter", e11.getMessage());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private String f37100a;

        /* renamed from: b, reason: collision with root package name */
        private com.mbridge.msdk.foundation.same.report.metrics.c f37101b;

        public i(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            this.f37100a = str;
            this.f37101b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.mbridge.msdk.util.b.a()) {
                    c cVar = c.this;
                    cVar.f37041u = com.mbridge.msdk.b.a(cVar.f37022b, c.this.f37021a);
                }
                c cVar2 = c.this;
                cVar2.f37028h = t0.a(cVar2.f37021a, c.this.f37022b);
                if (c.this.F) {
                    return;
                }
                if (c.this.D != null && c.this.L != null) {
                    c.this.L.removeCallbacks(c.this.D);
                }
                c.this.E = true;
                if (c.this.L != null) {
                    Message obtainMessage = c.this.L.obtainMessage();
                    obtainMessage.obj = this.f37100a;
                    obtainMessage.what = 1;
                    if (this.f37101b != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("metrics_data_lrid", this.f37101b.o());
                        obtainMessage.setData(bundle);
                    }
                    c.this.L.sendMessage(obtainMessage);
                }
                if (TextUtils.isEmpty(c.this.f37028h)) {
                    return;
                }
                o0.b("RewardMVVideoAdapter", "excludeId : " + c.this.f37028h);
            } catch (Exception e11) {
                o0.b("RewardMVVideoAdapter", e11.getMessage());
            }
        }
    }

    public c(Context context, String str, String str2) {
        try {
            this.f37021a = context.getApplicationContext();
            this.f37022b = str2;
            this.f37023c = str;
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.mbridge.msdk.foundation.same.report.metrics.c a(Message message) {
        com.mbridge.msdk.foundation.same.report.metrics.c cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
        if (message == null) {
            return cVar;
        }
        try {
            Bundle data = message.getData();
            return data != null ? com.mbridge.msdk.foundation.same.report.metrics.d.b().a(data.getString("metrics_data_lrid")) : cVar;
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return cVar;
            }
            e11.printStackTrace();
            return cVar;
        }
    }

    private com.mbridge.msdk.foundation.same.report.metrics.c a(List<CampaignEx> list) {
        String str;
        com.mbridge.msdk.foundation.same.report.metrics.c cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
        str = "";
        if (list != null) {
            try {
                if (list.size() > 0) {
                    str = list.get(0) != null ? list.get(0).getLocalRequestId() : "";
                    if (com.mbridge.msdk.foundation.same.report.metrics.d.b().c().containsKey(str)) {
                        com.mbridge.msdk.foundation.same.report.metrics.c cVar2 = com.mbridge.msdk.foundation.same.report.metrics.d.b().c().get(str);
                        if (cVar2 == null) {
                            try {
                                cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
                            } catch (Exception e11) {
                                e = e11;
                                cVar = cVar2;
                                if (MBridgeConstans.DEBUG) {
                                    e.printStackTrace();
                                }
                                return cVar;
                            }
                        } else {
                            cVar = cVar2;
                        }
                    }
                    cVar.h(str);
                    cVar.b(list);
                }
            } catch (Exception e12) {
                e = e12;
            }
        }
        com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
        eVar.a("cache", 1);
        eVar.a(CampaignEx.JSON_KEY_HB, 1);
        eVar.a("auto_load", 2);
        cVar.a("2000127", eVar);
        cVar.a("2000048", eVar);
        cVar.a(this.f37038r ? MBSupportMuteAdType.INTERSTITIAL_VIDEO : 94);
        cVar.g("1");
        cVar.e("2");
        if (!TextUtils.isEmpty(str)) {
            com.mbridge.msdk.foundation.same.report.metrics.d.b().c().put(str, cVar);
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.mbridge.msdk.reward.adapter.d a(CampaignUnit campaignUnit) {
        boolean z10;
        this.f37045y = campaignUnit;
        com.mbridge.msdk.reward.adapter.d b11 = b(campaignUnit);
        new com.mbridge.msdk.reward.candidate.a(this.f37022b, this.f37038r).a(b11.b(), this.C, this, this.f37022b);
        CopyOnWriteArrayList<CampaignEx> b12 = b11.b();
        if (b11.e()) {
            if (b11.d() == 0) {
                b12.clear();
            } else if (b11.a()) {
                b(campaignUnit.getMetricsData());
            }
            if (b11.c() == 0) {
                z10 = false;
                a(b12, true, false, z10);
                return b11;
            }
        }
        z10 = true;
        a(b12, true, false, z10);
        return b11;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0078 A[Catch: Exception -> 0x0042, TryCatch #0 {Exception -> 0x0042, blocks: (B:11:0x0027, B:13:0x002d, B:14:0x0072, B:16:0x0078, B:18:0x0080, B:24:0x0044, B:26:0x004a, B:27:0x004e, B:29:0x0054, B:32:0x005c, B:35:0x0066), top: B:8:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a() {
        /*
            r4 = this;
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r0 = r0.d()
            com.mbridge.msdk.foundation.db.b r0 = com.mbridge.msdk.foundation.db.b.a(r0)
            java.lang.String r1 = r4.f37022b
            java.lang.String r2 = r4.H
            java.util.List r0 = r0.a(r1, r2)
            if (r0 == 0) goto La7
            int r1 = r0.size()
            java.lang.String r2 = r4.f37022b
            java.lang.String r2 = com.mbridge.msdk.foundation.same.buffer.b.d(r2)
            if (r1 != 0) goto L23
            return
        L23:
            r3 = 1
            if (r1 != r3) goto L44
            r1 = 0
            java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Exception -> L42
            if (r3 == 0) goto L6f
            java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Exception -> L42
            com.mbridge.msdk.foundation.entity.d r3 = (com.mbridge.msdk.foundation.entity.d) r3     // Catch: java.lang.Exception -> L42
            java.lang.String r3 = r3.d()     // Catch: java.lang.Exception -> L42
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> L42
            com.mbridge.msdk.foundation.entity.d r0 = (com.mbridge.msdk.foundation.entity.d) r0     // Catch: java.lang.Exception -> L42
            java.lang.String r0 = r0.b()     // Catch: java.lang.Exception -> L42
            goto L72
        L42:
            r0 = move-exception
            goto L9e
        L44:
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Exception -> L42
            if (r1 != 0) goto L6f
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> L42
        L4e:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Exception -> L42
            if (r1 == 0) goto L6f
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Exception -> L42
            com.mbridge.msdk.foundation.entity.d r1 = (com.mbridge.msdk.foundation.entity.d) r1     // Catch: java.lang.Exception -> L42
            if (r1 == 0) goto L4e
            java.lang.String r3 = r1.a()     // Catch: java.lang.Exception -> L42
            boolean r3 = r2.equals(r3)     // Catch: java.lang.Exception -> L42
            if (r3 == 0) goto L4e
            java.lang.String r3 = r1.d()     // Catch: java.lang.Exception -> L42
            java.lang.String r0 = r1.b()     // Catch: java.lang.Exception -> L42
            goto L72
        L6f:
            java.lang.String r0 = ""
            r3 = r0
        L72:
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L42
            if (r1 != 0) goto La7
            java.lang.String r1 = r4.H     // Catch: java.lang.Exception -> L42
            boolean r1 = r3.equals(r1)     // Catch: java.lang.Exception -> L42
            if (r1 == 0) goto La7
            com.mbridge.msdk.foundation.controller.c r1 = com.mbridge.msdk.foundation.controller.c.m()     // Catch: java.lang.Exception -> L42
            android.content.Context r1 = r1.d()     // Catch: java.lang.Exception -> L42
            com.mbridge.msdk.foundation.db.b r1 = com.mbridge.msdk.foundation.db.b.a(r1)     // Catch: java.lang.Exception -> L42
            java.lang.String r3 = r4.f37022b     // Catch: java.lang.Exception -> L42
            r1.b(r2, r3)     // Catch: java.lang.Exception -> L42
            java.lang.String r1 = r4.f37022b     // Catch: java.lang.Exception -> L42
            java.lang.String r2 = r4.H     // Catch: java.lang.Exception -> L42
            com.mbridge.msdk.foundation.same.buffer.b.a(r1, r2, r0)     // Catch: java.lang.Exception -> L42
            java.lang.String r0 = r4.f37022b     // Catch: java.lang.Exception -> L42
            com.mbridge.msdk.foundation.same.buffer.b.e(r0)     // Catch: java.lang.Exception -> L42
            goto La7
        L9e:
            java.lang.String r0 = r0.getMessage()
            java.lang.String r1 = "RewardMVVideoAdapter"
            com.mbridge.msdk.foundation.tools.o0.a(r1, r0)
        La7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.c.a():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i11, String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        if (this.L != null) {
            if (TextUtils.isEmpty(str)) {
                str = "load fail exception";
            }
            Message obtain = Message.obtain();
            obtain.what = 4;
            obtain.obj = str;
            obtain.arg1 = i11;
            if (cVar != null) {
                cVar.b(true);
                Bundle bundle = new Bundle();
                bundle.putString("metrics_data_lrid", cVar.o());
                obtain.setData(bundle);
            }
            if (str.contains("exception")) {
                this.L.sendMessageAtFrontOfQueue(obtain);
            } else {
                this.L.sendMessage(obtain);
            }
        }
    }

    private void a(j jVar, CampaignEx campaignEx) {
        if (jVar == null || jVar.a(campaignEx.getId())) {
            return;
        }
        com.mbridge.msdk.foundation.entity.g gVar = new com.mbridge.msdk.foundation.entity.g();
        gVar.a(campaignEx.getId());
        gVar.b(campaignEx.getFca());
        gVar.c(campaignEx.getFcb());
        gVar.a(0);
        gVar.d(0);
        gVar.a(System.currentTimeMillis());
        jVar.b(gVar);
    }

    private void a(CampaignEx campaignEx) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>(this.f37046z);
        boolean isEmpty = TextUtils.isEmpty(campaignEx.getCMPTEntryUrl());
        boolean z10 = !isEmpty;
        int nscpt = campaignEx.getNscpt();
        this.O = false;
        this.P = false;
        synchronized (this.f37035o) {
            try {
                if (this.Q) {
                    this.Q = false;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.S = false;
        this.R = false;
        if (this.f37039s) {
            com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(campaignEx.getBidToken(), campaignEx.getCampaignUnitId(), campaignEx.getEncryptPrice());
        }
        com.mbridge.msdk.reward.adapter.b.b().a(this.f37021a, z10, nscpt, this.f37039s, this.f37038r ? MBSupportMuteAdType.INTERSTITIAL_VIDEO : 94, this.f37023c, this.f37022b, campaignEx.getRequestId(), copyOnWriteArrayList, new C0524c(campaignEx, z10, copyOnWriteArrayList, nscpt), new d(campaignEx, z10, copyOnWriteArrayList, nscpt));
        if (isEmpty) {
            return;
        }
        com.mbridge.msdk.reward.adapter.b.b().a(this.f37021a, campaignEx, this.f37023c, this.f37022b, campaignEx.getRequestId(), new e(campaignEx, copyOnWriteArrayList, z10, nscpt));
    }

    private void a(CampaignEx campaignEx, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        try {
            com.mbridge.msdk.foundation.same.c.a(campaignEx, this.f37021a, cVar, new f());
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    private void a(CampaignUnit campaignUnit, List<CampaignEx> list) {
        com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new g(campaignUnit));
    }

    private void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        if (this.L != null) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            if (cVar != null) {
                Bundle bundle = new Bundle();
                bundle.putString("metrics_data_lrid", cVar.o());
                obtain.setData(bundle);
            }
            this.L.sendMessage(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062 A[Catch: Exception -> 0x0027, TRY_ENTER, TryCatch #0 {Exception -> 0x0027, blocks: (B:4:0x0004, B:6:0x000a, B:14:0x0021, B:15:0x002f, B:17:0x004d, B:19:0x0055, B:21:0x0059, B:24:0x0062, B:25:0x007b, B:26:0x0070, B:27:0x0091, B:31:0x002a), top: B:3:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0070 A[Catch: Exception -> 0x0027, TryCatch #0 {Exception -> 0x0027, blocks: (B:4:0x0004, B:6:0x000a, B:14:0x0021, B:15:0x002f, B:17:0x004d, B:19:0x0055, B:21:0x0059, B:24:0x0062, B:25:0x007b, B:26:0x0070, B:27:0x0091, B:31:0x002a), top: B:3:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.mbridge.msdk.foundation.same.report.metrics.c r6, int r7) {
        /*
            r5 = this;
            java.lang.String r0 = "2000126"
            if (r6 == 0) goto Lb6
            boolean r1 = r6.A()     // Catch: java.lang.Exception -> L27
            if (r1 != 0) goto Lb6
            com.mbridge.msdk.foundation.same.report.metrics.e r1 = new com.mbridge.msdk.foundation.same.report.metrics.e     // Catch: java.lang.Exception -> L27
            r1.<init>()     // Catch: java.lang.Exception -> L27
            r2 = 3
            java.lang.String r3 = "result"
            if (r7 == r2) goto L2a
            r2 = 880023(0xd6d97, float:1.233175E-39)
            if (r7 == r2) goto L2a
            r2 = 880041(0xd6da9, float:1.2332E-39)
            if (r7 == r2) goto L2a
            switch(r7) {
                case 10: goto L2a;
                case 11: goto L2a;
                case 12: goto L2a;
                default: goto L21;
            }
        L21:
            java.lang.String r7 = "1"
            r1.a(r3, r7)     // Catch: java.lang.Exception -> L27
            goto L2f
        L27:
            r6 = move-exception
            goto Laf
        L2a:
            java.lang.String r7 = "2"
            r1.a(r3, r7)     // Catch: java.lang.Exception -> L27
        L2f:
            java.lang.String r7 = "timeout"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L27
            r2.<init>()     // Catch: java.lang.Exception -> L27
            int r3 = r5.f37026f     // Catch: java.lang.Exception -> L27
            r2.append(r3)     // Catch: java.lang.Exception -> L27
            java.lang.String r3 = ""
            r2.append(r3)     // Catch: java.lang.Exception -> L27
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L27
            r1.a(r7, r2)     // Catch: java.lang.Exception -> L27
            com.mbridge.msdk.foundation.error.b r7 = r6.p()     // Catch: java.lang.Exception -> L27
            if (r7 == 0) goto L91
            java.lang.String r2 = "campaign_request_error"
            java.lang.Object r2 = r7.a(r2)     // Catch: java.lang.Exception -> L27
            if (r2 == 0) goto L91
            boolean r3 = r2 instanceof com.mbridge.msdk.foundation.same.net.exception.a     // Catch: java.lang.Exception -> L27
            if (r3 == 0) goto L91
            r3 = r2
            com.mbridge.msdk.foundation.same.net.exception.a r3 = (com.mbridge.msdk.foundation.same.net.exception.a) r3     // Catch: java.lang.Exception -> L27
            com.mbridge.msdk.foundation.same.net.toolbox.a r3 = r3.f35485c     // Catch: java.lang.Exception -> L27
            java.lang.String r4 = "code"
            if (r3 == 0) goto L70
            com.mbridge.msdk.foundation.same.net.exception.a r2 = (com.mbridge.msdk.foundation.same.net.exception.a) r2     // Catch: java.lang.Exception -> L27
            com.mbridge.msdk.foundation.same.net.toolbox.a r2 = r2.f35485c     // Catch: java.lang.Exception -> L27
            int r2 = r2.f35506d     // Catch: java.lang.Exception -> L27
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> L27
            r1.a(r4, r2)     // Catch: java.lang.Exception -> L27
            goto L7b
        L70:
            int r2 = r7.b()     // Catch: java.lang.Exception -> L27
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> L27
            r1.a(r4, r2)     // Catch: java.lang.Exception -> L27
        L7b:
            java.lang.String r2 = "reason"
            java.lang.String r3 = r7.g()     // Catch: java.lang.Exception -> L27
            r1.a(r2, r3)     // Catch: java.lang.Exception -> L27
            java.lang.String r2 = "err_desc"
            java.lang.String r7 = r7.d()     // Catch: java.lang.Exception -> L27
            r1.a(r2, r7)     // Catch: java.lang.Exception -> L27
            r7 = 0
            r6.a(r7)     // Catch: java.lang.Exception -> L27
        L91:
            java.lang.String r7 = "hst"
            java.lang.String r2 = r5.k()     // Catch: java.lang.Exception -> L27
            r1.a(r7, r2)     // Catch: java.lang.Exception -> L27
            java.lang.String r7 = "126_exclude"
            r2 = 1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> L27
            r1.a(r7, r2)     // Catch: java.lang.Exception -> L27
            r6.a(r0, r1)     // Catch: java.lang.Exception -> L27
            com.mbridge.msdk.reward.report.metrics.a r7 = com.mbridge.msdk.reward.report.metrics.a.a()     // Catch: java.lang.Exception -> L27
            r7.a(r0, r6)     // Catch: java.lang.Exception -> L27
            goto Lb6
        Laf:
            boolean r7 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r7 == 0) goto Lb6
            r6.printStackTrace()
        Lb6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.c.a(com.mbridge.msdk.foundation.same.report.metrics.c, int):void");
    }

    private void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar, com.mbridge.msdk.foundation.same.report.metrics.e eVar, List<CampaignEx> list) {
        if (cVar != null) {
            if (list != null) {
                try {
                    if (list.size() > 0) {
                        cVar.b(list);
                        CampaignEx campaignEx = list.get(0);
                        if (campaignEx != null) {
                            cVar.h(campaignEx.getLocalRequestId());
                        }
                        cVar.b(list);
                    }
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        e11.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            a(false, cVar, eVar);
        }
    }

    private void a(String str) {
        if (y0.b(str)) {
            com.mbridge.msdk.reward.controller.a.f37118c0 = str;
        }
    }

    private void a(String str, String str2, List<CampaignEx> list) {
        if (com.mbridge.msdk.videocommon.cache.a.a() != null) {
            com.mbridge.msdk.videocommon.cache.a.a().a(str, str2, list);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0071 A[Catch: Exception -> 0x002e, TryCatch #0 {Exception -> 0x002e, blocks: (B:50:0x0004, B:52:0x000a, B:54:0x0013, B:56:0x0029, B:4:0x0034, B:6:0x003a, B:7:0x004f, B:9:0x0055, B:11:0x005e, B:13:0x0064, B:14:0x006b, B:16:0x0071, B:19:0x0079, B:25:0x009b, B:27:0x00a1, B:28:0x00a5, B:30:0x00ab, B:33:0x00b3, B:38:0x00bf), top: B:49:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ab A[Catch: Exception -> 0x002e, TryCatch #0 {Exception -> 0x002e, blocks: (B:50:0x0004, B:52:0x000a, B:54:0x0013, B:56:0x0029, B:4:0x0034, B:6:0x003a, B:7:0x004f, B:9:0x0055, B:11:0x005e, B:13:0x0064, B:14:0x006b, B:16:0x0071, B:19:0x0079, B:25:0x009b, B:27:0x00a1, B:28:0x00a5, B:30:0x00ab, B:33:0x00b3, B:38:0x00bf), top: B:49:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x003a A[Catch: Exception -> 0x002e, TryCatch #0 {Exception -> 0x002e, blocks: (B:50:0x0004, B:52:0x000a, B:54:0x0013, B:56:0x0029, B:4:0x0034, B:6:0x003a, B:7:0x004f, B:9:0x0055, B:11:0x005e, B:13:0x0064, B:14:0x006b, B:16:0x0071, B:19:0x0079, B:25:0x009b, B:27:0x00a1, B:28:0x00a5, B:30:0x00ab, B:33:0x00b3, B:38:0x00bf), top: B:49:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0055 A[Catch: Exception -> 0x002e, TryCatch #0 {Exception -> 0x002e, blocks: (B:50:0x0004, B:52:0x000a, B:54:0x0013, B:56:0x0029, B:4:0x0034, B:6:0x003a, B:7:0x004f, B:9:0x0055, B:11:0x005e, B:13:0x0064, B:14:0x006b, B:16:0x0071, B:19:0x0079, B:25:0x009b, B:27:0x00a1, B:28:0x00a5, B:30:0x00ab, B:33:0x00b3, B:38:0x00bf), top: B:49:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(java.lang.String r12, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r13, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r14) {
        /*
            r11 = this;
            java.lang.String r0 = ""
            if (r13 == 0) goto L31
            int r1 = r13.size()     // Catch: java.lang.Exception -> L2e
            if (r1 <= 0) goto L31
            r1 = 0
            java.lang.Object r1 = r13.get(r1)     // Catch: java.lang.Exception -> L2e
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = (com.mbridge.msdk.foundation.entity.CampaignEx) r1     // Catch: java.lang.Exception -> L2e
            if (r1 == 0) goto L31
            java.lang.String r2 = r1.getRequestId()     // Catch: java.lang.Exception -> L2e
            int r3 = r1.getVcn()     // Catch: java.lang.Exception -> L2e
            java.lang.String r4 = r1.getBidToken()     // Catch: java.lang.Exception -> L2e
            java.lang.String r5 = r1.getNLRid()     // Catch: java.lang.Exception -> L2e
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> L2e
            if (r5 == 0) goto L34
            java.lang.String r0 = r1.getLocalRequestId()     // Catch: java.lang.Exception -> L2e
            goto L34
        L2e:
            r12 = move-exception
            goto Ld2
        L31:
            r3 = 1
            r2 = r0
            r4 = r2
        L34:
            com.mbridge.msdk.videocommon.cache.a r1 = com.mbridge.msdk.videocommon.cache.a.a()     // Catch: java.lang.Exception -> L2e
            if (r1 == 0) goto L4f
            com.mbridge.msdk.videocommon.cache.a r1 = com.mbridge.msdk.videocommon.cache.a.a()     // Catch: java.lang.Exception -> L2e
            r1.c(r12, r0)     // Catch: java.lang.Exception -> L2e
            com.mbridge.msdk.videocommon.cache.a r1 = com.mbridge.msdk.videocommon.cache.a.a()     // Catch: java.lang.Exception -> L2e
            r1.b(r12)     // Catch: java.lang.Exception -> L2e
            com.mbridge.msdk.videocommon.cache.a r1 = com.mbridge.msdk.videocommon.cache.a.a()     // Catch: java.lang.Exception -> L2e
            r1.a(r12, r0)     // Catch: java.lang.Exception -> L2e
        L4f:
            com.mbridge.msdk.videocommon.cache.a r0 = com.mbridge.msdk.videocommon.cache.a.a()     // Catch: java.lang.Exception -> L2e
            if (r0 == 0) goto L5c
            com.mbridge.msdk.videocommon.cache.a r0 = com.mbridge.msdk.videocommon.cache.a.a()     // Catch: java.lang.Exception -> L2e
            r0.a(r12, r3)     // Catch: java.lang.Exception -> L2e
        L5c:
            if (r13 == 0) goto L99
            int r0 = r13.size()     // Catch: java.lang.Exception -> L2e
            if (r0 <= 0) goto L99
            com.mbridge.msdk.reward.controller.a.a(r2, r4)     // Catch: java.lang.Exception -> L2e
            java.util.Iterator r13 = r13.iterator()     // Catch: java.lang.Exception -> L2e
        L6b:
            boolean r0 = r13.hasNext()     // Catch: java.lang.Exception -> L2e
            if (r0 == 0) goto L99
            java.lang.Object r0 = r13.next()     // Catch: java.lang.Exception -> L2e
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0     // Catch: java.lang.Exception -> L2e
            if (r0 == 0) goto L6b
            java.lang.String r1 = r0.getCampaignUnitId()     // Catch: java.lang.Exception -> L2e
            java.lang.String r2 = r0.getRequestId()     // Catch: java.lang.Exception -> L2e
            java.lang.String r3 = r0.getId()     // Catch: java.lang.Exception -> L2e
            long r4 = r0.getPlct()     // Catch: java.lang.Exception -> L2e
            long r6 = r0.getPlctb()     // Catch: java.lang.Exception -> L2e
            long r8 = r0.getTimestamp()     // Catch: java.lang.Exception -> L2e
            java.lang.String r10 = r0.getLocalRequestId()     // Catch: java.lang.Exception -> L2e
            com.mbridge.msdk.foundation.same.buffer.b.a(r1, r2, r3, r4, r6, r8, r10)     // Catch: java.lang.Exception -> L2e
            goto L6b
        L99:
            if (r14 == 0) goto Lbf
            int r13 = r14.size()     // Catch: java.lang.Exception -> L2e
            if (r13 <= 0) goto Lbf
            java.util.Iterator r13 = r14.iterator()     // Catch: java.lang.Exception -> L2e
        La5:
            boolean r14 = r13.hasNext()     // Catch: java.lang.Exception -> L2e
            if (r14 == 0) goto Lbf
            java.lang.Object r14 = r13.next()     // Catch: java.lang.Exception -> L2e
            com.mbridge.msdk.foundation.entity.CampaignEx r14 = (com.mbridge.msdk.foundation.entity.CampaignEx) r14     // Catch: java.lang.Exception -> L2e
            if (r14 == 0) goto La5
            java.lang.String r0 = r14.getCampaignUnitId()     // Catch: java.lang.Exception -> L2e
            java.lang.String r14 = r14.getRequestId()     // Catch: java.lang.Exception -> L2e
            com.mbridge.msdk.foundation.same.buffer.b.c(r0, r14)     // Catch: java.lang.Exception -> L2e
            goto La5
        Lbf:
            com.mbridge.msdk.foundation.same.buffer.b.e(r12)     // Catch: java.lang.Exception -> L2e
            com.mbridge.msdk.foundation.controller.c r12 = com.mbridge.msdk.foundation.controller.c.m()     // Catch: java.lang.Exception -> L2e
            android.content.Context r12 = r12.d()     // Catch: java.lang.Exception -> L2e
            com.mbridge.msdk.foundation.db.b r12 = com.mbridge.msdk.foundation.db.b.a(r12)     // Catch: java.lang.Exception -> L2e
            r12.a()     // Catch: java.lang.Exception -> L2e
            goto Ld9
        Ld2:
            boolean r13 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r13 == 0) goto Ld9
            r12.printStackTrace()
        Ld9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.c.a(java.lang.String, java.util.List, java.util.List):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, List<CampaignEx> list, List<CampaignEx> list2, boolean z10) {
        com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d())).a(str, list, list2, z10);
        if (list2 != null && list2.size() > 0) {
            for (CampaignEx campaignEx : list2) {
                if (campaignEx.getRewardTemplateMode() != null && !TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                    com.mbridge.msdk.videocommon.a.e(str + "_" + campaignEx.getId() + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e());
                    com.mbridge.msdk.videocommon.a.b(campaignEx.getAdType(), campaignEx);
                }
            }
        }
        if (z10) {
            a(str, list, list2);
        }
        if (list == null || list.size() <= 0) {
            return;
        }
        try {
            CampaignEx campaignEx2 = list.get(0);
            com.mbridge.msdk.reward.candidate.a aVar = new com.mbridge.msdk.reward.candidate.a(str, this.f37038r);
            if (campaignEx2 == null || !TextUtils.isEmpty(campaignEx2.getNLRid())) {
                return;
            }
            aVar.a(campaignEx2.getLocalRequestId(), campaignEx2.getRequestId(), 1, campaignEx2.getEcppv());
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, List<CampaignEx> list, boolean z10, String str2) {
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
            com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d())).a(str, (CampaignEx) null, z10, str2);
            return;
        }
        CampaignEx campaignEx = list.get(0);
        if (campaignEx == null || TextUtils.isEmpty(campaignEx.getEcppv()) || TextUtils.isEmpty(str2)) {
            com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d())).a(str, list, z10);
        } else {
            com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d())).a(str, (CampaignEx) null, z10, str2);
        }
    }

    private void a(boolean z10, com.mbridge.msdk.foundation.same.report.metrics.c cVar, com.mbridge.msdk.foundation.same.report.metrics.e eVar) {
        if (eVar == null) {
            eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
        }
        cVar.m(this.f37022b);
        cVar.a(this.f37038r ? MBSupportMuteAdType.INTERSTITIAL_VIDEO : 94);
        eVar.a("result", Integer.valueOf(z10 ? 1 : 2));
        eVar.a("bid_tk", this.C);
        eVar.a(CampaignEx.JSON_KEY_HB, Integer.valueOf(this.f37039s ? 1 : 0));
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
            }
            cVar.b(list);
        }
        a(z10, cVar, (com.mbridge.msdk.foundation.same.report.metrics.e) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:142:0x01ba, code lost:
    
        if (com.mbridge.msdk.foundation.tools.y0.a(r15.getVideoUrlEncode()) != false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0225, code lost:
    
        if (com.mbridge.msdk.MBridgeConstans.DEBUG == false) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0234, code lost:
    
        if (com.mbridge.msdk.MBridgeConstans.DEBUG == false) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0236, code lost:
    
        com.mbridge.msdk.foundation.tools.o0.b("RewardMVVideoAdapter", r15.getMessage());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.mbridge.msdk.reward.adapter.d b(com.mbridge.msdk.foundation.entity.CampaignUnit r15) {
        /*
            Method dump skipped, instructions count: 594
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.c.b(com.mbridge.msdk.foundation.entity.CampaignUnit):com.mbridge.msdk.reward.adapter.d");
    }

    private void b() {
        if (com.mbridge.msdk.videocommon.cache.a.a() != null) {
            try {
                com.mbridge.msdk.setting.g d11 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
                if (d11 == null) {
                    d11 = com.mbridge.msdk.setting.h.b().a();
                }
                com.mbridge.msdk.videocommon.cache.a.a().a(d11.a0() * 1000, this.f37022b);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
            }
        }
    }

    private void b(com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        if (this.L != null) {
            Message obtain = Message.obtain();
            obtain.what = 18;
            if (cVar != null) {
                Bundle bundle = new Bundle();
                bundle.putString("metrics_data_lrid", cVar.o());
                obtain.setData(bundle);
            }
            this.L.sendMessage(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        if (this.L != null) {
            if (TextUtils.isEmpty(str)) {
                str = "load fail exception";
            }
            Message obtain = Message.obtain();
            obtain.what = 4;
            obtain.obj = str;
            if (cVar != null) {
                cVar.b(true);
                Bundle bundle = new Bundle();
                bundle.putString("metrics_data_lrid", cVar.o());
                obtain.setData(bundle);
            }
            if (str.contains("exception")) {
                this.L.sendMessageAtFrontOfQueue(obtain);
            } else {
                this.L.sendMessage(obtain);
            }
        }
    }

    private void b(List<CampaignEx> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    this.f37024d += list.size();
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                return;
            }
        }
        com.mbridge.msdk.videocommon.setting.c cVar = this.f37032l;
        if (cVar == null || this.f37024d > cVar.r()) {
            this.f37024d = 0;
        }
        if (y0.b(this.f37022b)) {
            com.mbridge.msdk.reward.controller.a.a(this.f37022b, this.f37024d);
        }
    }

    private boolean b(CampaignEx campaignEx) {
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

    private void c() {
        try {
            com.mbridge.msdk.foundation.db.i.a(com.mbridge.msdk.foundation.db.g.a(this.f37021a)).a(this.f37022b);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(CampaignUnit campaignUnit) {
        if (campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().size() <= 0) {
            return;
        }
        try {
            com.mbridge.msdk.foundation.same.report.metrics.c metricsData = campaignUnit.getMetricsData();
            if (metricsData != null) {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("result", 1);
                eVar.a("timeout", Integer.valueOf(this.f37026f));
                eVar.a("hst", k());
                metricsData.b(campaignUnit.getAds());
                metricsData.a("2000126", eVar);
                campaignUnit.setLocalRequestId(metricsData.o());
                com.mbridge.msdk.reward.report.metrics.a.a().a("2000126", metricsData);
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("RewardMVVideoAdapter", e11.getMessage());
            }
        }
    }

    private void d() {
        try {
            Map<String, Long> map = com.mbridge.msdk.foundation.same.buffer.b.f35425l;
            if (map == null || map.size() <= 0) {
                return;
            }
            com.mbridge.msdk.foundation.same.buffer.b.f35425l.clear();
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<CampaignEx> list) {
        if (this.f37021a == null || list == null || list.size() == 0) {
            return;
        }
        j a11 = j.a(com.mbridge.msdk.foundation.db.g.a(this.f37021a));
        for (int i11 = 0; i11 < list.size(); i11++) {
            CampaignEx campaignEx = list.get(i11);
            if (campaignEx != null) {
                if (!com.mbridge.msdk.util.b.a()) {
                    a(a11, campaignEx);
                } else if (t0.c(this.f37021a, campaignEx.getPackageName())) {
                    com.mbridge.msdk.b.a(campaignEx);
                } else {
                    a(a11, campaignEx);
                }
            }
        }
    }

    private String e() {
        return com.mbridge.msdk.b.a();
    }

    private String i() {
        try {
            if (y0.b(com.mbridge.msdk.reward.controller.a.f37118c0)) {
                return com.mbridge.msdk.reward.controller.a.f37118c0;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return "";
    }

    private String k() {
        com.mbridge.msdk.setting.g b11 = com.mbridge.msdk.setting.h.b().b(com.mbridge.msdk.foundation.controller.c.m().b());
        return com.mbridge.msdk.foundation.same.net.utils.d.h().a(this.C, TextUtils.isEmpty(this.C) ? b11.p0() : b11.B());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        try {
            if (y0.b(this.f37022b)) {
                com.mbridge.msdk.reward.controller.a.a(this.f37022b, 0);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public String a(boolean z10) {
        CopyOnWriteArrayList<CampaignEx> b11;
        CampaignEx campaignEx;
        if (!z10) {
            return this.G;
        }
        if (TextUtils.isEmpty(this.H) && (b11 = com.mbridge.msdk.videocommon.download.b.getInstance().b(this.f37022b)) != null && b11.size() > 0 && (campaignEx = b11.get(0)) != null) {
            this.H = campaignEx.getRequestId();
        }
        return this.H;
    }

    public void a(int i11) {
        this.f37037q = i11;
    }

    public void a(int i11, int i12, int i13) {
        this.f37042v = i11;
        this.f37043w = i12;
        this.f37044x = i13;
    }

    public void a(int i11, int i12, boolean z10, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        a(i11, i12, z10, "", this.A, cVar);
    }

    public void a(int i11, int i12, boolean z10, String str, boolean z11, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        CampaignEx campaignEx;
        this.f37025e = i11;
        this.f37026f = i12;
        this.f37027g = z10;
        this.C = str;
        this.A = z11;
        boolean z12 = false;
        this.T = false;
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.f37046z;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0 && (campaignEx = this.f37046z.get(0)) != null && TextUtils.isEmpty(campaignEx.getNLRid())) {
            this.f37046z.clear();
        }
        List<CampaignEx> list = this.V;
        if (list != null) {
            list.clear();
        }
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = this.W;
        if (copyOnWriteArrayList2 != null) {
            copyOnWriteArrayList2.clear();
        }
        this.O = false;
        this.P = false;
        synchronized (this.f37035o) {
            try {
                if (this.Q) {
                    this.Q = false;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.S = false;
        this.R = false;
        try {
            z12 = com.mbridge.msdk.mbsignalcommon.webEnvCheck.a.b(this.f37021a);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("RewardMVVideoAdapter", e11.getMessage());
            }
        }
        if (!z12) {
            com.mbridge.msdk.foundation.error.b a11 = com.mbridge.msdk.foundation.error.a.a(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is WebView is not available");
            if (cVar != null) {
                cVar.a(a11);
            }
            b("errorCode: 3507 errorMessage: data load failed, errorMsg is WebView is not available", cVar);
            return;
        }
        if (this.f37021a == null) {
            com.mbridge.msdk.foundation.error.b a12 = com.mbridge.msdk.foundation.error.a.a(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is Context is null");
            if (cVar != null) {
                cVar.a(a12);
            }
            b("errorCode: 3507 errorMessage: data load failed, errorMsg is Context is null", cVar);
            return;
        }
        if (y0.a(this.f37022b)) {
            com.mbridge.msdk.foundation.error.b a13 = com.mbridge.msdk.foundation.error.a.a(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is UnitId is null");
            if (cVar != null) {
                cVar.a(a13);
            }
            b("errorCode: 3507 errorMessage: data load failed, errorMsg is UnitId is null", cVar);
            return;
        }
        if (this.f37032l != null) {
            d();
            c();
            o0.c("RewardMVVideoAdapter", "load 开始清除过期数据");
            b();
            a(str, z11, cVar);
            return;
        }
        com.mbridge.msdk.foundation.error.b a14 = com.mbridge.msdk.foundation.error.a.a(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is RewardUnitSetting is null");
        if (cVar != null) {
            cVar.a(a14);
        }
        b("RewardUnitSetting is null", cVar);
    }

    public void a(int i11, String str) {
        this.J = i11;
        this.K = str;
    }

    public void a(com.mbridge.msdk.reward.adapter.a aVar) {
        this.f37030j = aVar;
    }

    public void a(a.j jVar) {
        this.f37031k = jVar;
    }

    public void a(com.mbridge.msdk.video.bt.module.orglistener.h hVar, String str, String str2, int i11, String str3, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        try {
            this.f37029i = hVar;
            if (this.f37021a != null && !y0.a(this.f37022b)) {
                Intent intent = new Intent(this.f37021a, (Class<?>) MBRewardVideoActivity.class);
                intent.putExtra(MBRewardVideoActivity.INTENT_UNITID, this.f37022b);
                intent.putExtra(MBridgeConstans.PLACEMENT_ID, this.f37023c);
                intent.putExtra(MBRewardVideoActivity.INTENT_REWARD, str);
                intent.putExtra(MBRewardVideoActivity.INTENT_MUTE, i11);
                intent.putExtra(MBRewardVideoActivity.INTENT_ISIV, this.f37038r);
                intent.putExtra(MBRewardVideoActivity.INTENT_ISBID, this.f37039s);
                intent.putExtra(MBRewardVideoActivity.INTENT_EXTRADATA, str3);
                CopyOnWriteArrayList<CampaignEx> b11 = com.mbridge.msdk.videocommon.download.b.getInstance().b(this.f37022b);
                boolean z10 = false;
                if (b11 == null || b11.size() <= 0) {
                    com.mbridge.msdk.video.bt.module.orglistener.h hVar2 = this.f37029i;
                    if (hVar2 != null) {
                        hVar2.a(cVar, "load failed");
                        return;
                    }
                } else {
                    CampaignEx campaignEx = b11.get(0);
                    if (b11.size() == 1 && !com.mbridge.msdk.foundation.same.c.a(this.f37021a, campaignEx) && campaignEx.getFilterAdsShowCallState() == 1) {
                        com.mbridge.msdk.videocommon.cache.a.a().b(this.f37022b, campaignEx);
                        com.mbridge.msdk.video.bt.module.orglistener.h hVar3 = this.f37029i;
                        if (hVar3 != null) {
                            hVar3.a(cVar, "show_campaign_filtered");
                            return;
                        }
                    }
                    if (campaignEx != null) {
                        this.H = campaignEx.getRequestId();
                    }
                    if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl())) {
                        z10 = true;
                    }
                    a();
                }
                intent.putExtra(MBRewardVideoActivity.INTENT_ISBIG_OFFER, z10);
                if (this.f37038r) {
                    intent.putExtra(MBRewardVideoActivity.INTENT_IVREWARD_MODETYPE, this.f37042v);
                    intent.putExtra(MBRewardVideoActivity.INTENT_IVREWARD_VALUETYPE, this.f37043w);
                    intent.putExtra(MBRewardVideoActivity.INTENT_IVREWARD_VALUE, this.f37044x);
                }
                if (!TextUtils.isEmpty(str2)) {
                    intent.putExtra(MBRewardVideoActivity.INTENT_USERID, str2);
                }
                RewardUnitCacheManager.getInstance().add(this.f37023c, this.f37022b, this.f37032l);
                try {
                    if (com.mbridge.msdk.foundation.controller.c.m() != null && com.mbridge.msdk.foundation.controller.c.m().f() != null) {
                        ((Activity) com.mbridge.msdk.foundation.controller.c.m().f()).startActivity(intent);
                        return;
                    }
                } catch (Throwable th2) {
                    o0.b("RewardMVVideoAdapter", th2.getMessage());
                }
                intent.addFlags(ASTNode.DEOP);
                this.f37021a.startActivity(intent);
                return;
            }
            com.mbridge.msdk.video.bt.module.orglistener.h hVar4 = this.f37029i;
            if (hVar4 != null) {
                hVar4.a(cVar, "context or unitid is null");
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            com.mbridge.msdk.video.bt.module.orglistener.h hVar5 = this.f37029i;
            if (hVar5 != null) {
                hVar5.a(cVar, "show failed, exception is " + e11.getMessage());
            }
        }
    }

    public void a(com.mbridge.msdk.videocommon.setting.c cVar) {
        try {
            this.f37032l = cVar;
            if (cVar == null || cVar.o() * 1000 == com.mbridge.msdk.foundation.same.a.L) {
                return;
            }
            com.mbridge.msdk.foundation.same.a.L = this.f37032l.o() * 1000;
        } catch (Throwable th2) {
            o0.b("RewardMVVideoAdapter", th2.getMessage(), th2);
        }
    }

    public void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        if (this.f37032l != null && TextUtils.isEmpty(str)) {
            int q11 = this.f37032l.q() * 1000;
            List<CampaignEx> list = this.X;
            if (list != null && list.size() > 0) {
                if (System.currentTimeMillis() - this.X.get(0).getTimestamp() < q11) {
                    b("hit ltorwc", cVar);
                    return;
                }
            }
        }
        b(str, this.A, cVar);
    }

    public void a(String str, boolean z10, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        com.mbridge.msdk.foundation.same.threadpool.a.f().execute(new i(str, cVar));
        if (this.L == null) {
            b(str, z10, cVar);
            return;
        }
        h hVar = new h(str, cVar);
        this.D = hVar;
        this.L.postDelayed(hVar, 90000L);
    }

    public void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
        CampaignUnit campaignUnit = this.f37045y;
        if (campaignUnit != null) {
            a(campaignUnit.getSessionId());
        }
        b(copyOnWriteArrayList);
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            o0.c("RewardMVVideoAdapter", "#######onload 把广告存在本地 size:" + copyOnWriteArrayList.size());
            a(this.f37023c, this.f37022b, copyOnWriteArrayList);
        }
        CampaignEx campaignEx = copyOnWriteArrayList.get(0);
        this.f37046z = copyOnWriteArrayList;
        a(campaignEx);
    }

    public void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, boolean z10, boolean z11, boolean z12) {
        com.mbridge.msdk.foundation.same.report.metrics.c cVar;
        try {
            if (z11) {
                this.V = copyOnWriteArrayList;
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>(copyOnWriteArrayList);
                this.W = copyOnWriteArrayList2;
                cVar = a((List<CampaignEx>) copyOnWriteArrayList2);
            } else {
                cVar = this.f37045y.getMetricsData();
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("RewardMVVideoAdapter", e11.getMessage());
            }
            cVar = null;
        }
        a(this.f37045y, copyOnWriteArrayList);
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            o0.c("RewardMVVideoAdapter", "onload load fail, callback campaign have not video");
            if (TextUtils.isEmpty(this.U)) {
                this.U = "APP ALREADY INSTALLED";
            }
            a(this.U.contains("INSTALL") ? 880021 : 880003, this.U, cVar);
            return;
        }
        o0.c("RewardMVVideoAdapter", "onload load success size:" + copyOnWriteArrayList.size());
        if (z10) {
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            if (z11) {
                eVar.a("cache", 1);
            } else {
                eVar.a("cache", 2);
            }
            if (cVar != null) {
                cVar.a("2000127", eVar);
                cVar.a("2000048", eVar);
            }
            a(cVar);
        }
        List<CampaignEx> b11 = com.mbridge.msdk.videocommon.cache.a.a().b(this.f37022b, 1, this.f37039s);
        if (b11 != null && b11.size() > 0 && cVar != null) {
            com.mbridge.msdk.foundation.same.report.metrics.e eVar2 = new com.mbridge.msdk.foundation.same.report.metrics.e();
            CampaignEx campaignEx = copyOnWriteArrayList.get(0);
            eVar2.a(BidResponsedEx.KEY_CID, campaignEx.getId());
            eVar2.a(BidResponsed.KEY_PRICE, "");
            eVar2.a("bid_tk", this.C);
            eVar2.a("lrid", campaignEx.getLocalRequestId());
            CampaignEx campaignEx2 = b11.get(0);
            eVar2.a("cid_old", com.mbridge.msdk.foundation.same.c.a(b11));
            eVar2.a("price_old", "");
            eVar2.a("bid_tk_old", campaignEx2.getBidToken());
            eVar2.a("lrid_old", campaignEx2.getLocalRequestId());
            cVar.a("m_load_overwrite", eVar2);
            com.mbridge.msdk.reward.report.metrics.a.a().a("m_load_overwrite", cVar);
        }
        if (z12) {
            a(copyOnWriteArrayList);
        } else {
            this.U = "campaign filtered";
            a(880021, "campaign filtered", cVar);
        }
    }

    public boolean a(CampaignEx campaignEx, boolean z10, com.mbridge.msdk.foundation.error.b bVar, int i11, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        com.mbridge.msdk.foundation.cache.c cVar2;
        com.mbridge.msdk.foundation.cache.c cVar3 = new com.mbridge.msdk.foundation.cache.c();
        com.mbridge.msdk.reward.candidate.a aVar = new com.mbridge.msdk.reward.candidate.a(this.f37022b, this.f37038r);
        boolean z11 = false;
        if (aVar.a(this.C)) {
            return false;
        }
        if (!this.T) {
            this.T = true;
            cVar3 = aVar.a(this.C, cVar, campaignEx, bVar, i11, this);
            if (cVar3 != null && cVar3.g() > com.mbridge.msdk.foundation.cache.c.f35035i) {
                if (cVar3.c() != null && cVar3.c().size() > 0) {
                    a(cVar3.c(), true, true, true);
                } else if (cVar3.g() == com.mbridge.msdk.foundation.cache.c.f35037k && bVar != null) {
                    bVar.a(com.mbridge.msdk.foundation.error.a.b(880038));
                    bVar.d(cVar3.e());
                }
            }
            cVar2 = cVar3;
            aVar.a(cVar, this.C, cVar2, (List<a.b>) null, (JSONObject) null, 3);
            return z11;
        }
        cVar3.d("isCandidate:false");
        cVar3.a(com.mbridge.msdk.foundation.cache.c.f35037k);
        cVar2 = cVar3;
        z11 = true;
        aVar.a(cVar, this.C, cVar2, (List<a.b>) null, (JSONObject) null, 3);
        return z11;
    }

    public boolean a(List<CampaignEx> list, boolean z10) {
        if (list == null || list.size() <= 0) {
            o0.a("RewardVideoController", "数据为空");
        } else {
            CampaignEx campaignEx = list.get(0);
            if (campaignEx != null && com.mbridge.msdk.videocommon.download.b.getInstance().a(94, this.f37022b, list)) {
                if (z10) {
                    if (campaignEx.isDynamicView()) {
                        return true;
                    }
                    if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0) {
                        if (campaignEx.getRsIgnoreCheckRule().contains(3)) {
                            o0.c("RewardMVVideoAdapter", "Is not check big template download status");
                            return true;
                        }
                        if (campaignEx.getCMPTEntryUrl().equals(campaignEx.getendcard_url()) && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                            o0.c("RewardMVVideoAdapter", "Is not check big template ENDCARD download status");
                            return true;
                        }
                    }
                    if (ResDownloadCheckManager.getInstance().checkPreLoadState(this.f37022b + "_" + campaignEx.getRequestId() + "_" + campaignEx.getCMPTEntryUrl())) {
                        o0.a("RewardVideoController", "大模板业务，开始检查大模板预加载情况，大模板预加载成功");
                        return true;
                    }
                } else {
                    if (campaignEx.isDynamicView()) {
                        return true;
                    }
                    if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(1)) {
                        o0.c("RewardMVVideoAdapter", "Is not check template download status");
                        return true;
                    }
                    if (campaignEx.getRewardTemplateMode() == null || TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                        o0.a("RewardVideoController", "非大模板 没有 template");
                        return true;
                    }
                    if (ResDownloadCheckManager.getInstance().checkPreLoadState(this.f37022b + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e())) {
                        o0.a("RewardVideoController", "非大模板业务，存在播放模板，播放模板预加载成功");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean a(List<CampaignEx> list, boolean z10, int i11) {
        return a(list, z10, i11, false, false);
    }

    public boolean a(List<CampaignEx> list, boolean z10, int i11, boolean z11) {
        return a(list, z10, i11, false, z11);
    }

    public boolean a(List<CampaignEx> list, boolean z10, int i11, boolean z11, boolean z12) {
        List<CampaignEx> list2;
        com.mbridge.msdk.foundation.same.report.metrics.c cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
        com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
        if (list == null || list.size() <= 0) {
            list2 = list;
            eVar.a("event_name", "is_ready_crwtpl_empty");
            eVar.a("reason", "campaign list is empty error");
            eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, 8);
        } else {
            CampaignEx campaignEx = list.get(0);
            cVar.h(campaignEx.getCurrentLocalRid());
            boolean a11 = com.mbridge.msdk.videocommon.download.b.getInstance().a(94, this.f37022b, this.f37039s, list.size(), z10, i11, list, z11, eVar);
            eVar.a("event_name", "is_ready_crwtpl_" + a11);
            if (a11) {
                if (!z10) {
                    list2 = list;
                    if (campaignEx.isDynamicView()) {
                        return true;
                    }
                    if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(1)) {
                        o0.c("RewardMVVideoAdapter", "Is not check template download status");
                        return true;
                    }
                    if (campaignEx.getRewardTemplateMode() == null || TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                        return true;
                    }
                    String str = this.f37022b + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e();
                    if (z12) {
                        ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(str, true);
                    }
                    if (ResDownloadCheckManager.getInstance().checkPreLoadState(str)) {
                        return true;
                    }
                    if (z12) {
                        eVar.a("event_name", "is_ready_crwtpl_" + a11);
                        eVar.a("reason", "h5 template checkPreLoadState error");
                        eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, 5);
                        a(cVar, eVar, list2);
                    }
                } else {
                    if (campaignEx.isDynamicView()) {
                        return true;
                    }
                    if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0) {
                        if (campaignEx.getRsIgnoreCheckRule().contains(3)) {
                            o0.c("RewardMVVideoAdapter", "Is not check big template download status");
                            return true;
                        }
                        if (campaignEx.getCMPTEntryUrl().equals(campaignEx.getendcard_url()) && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                            o0.c("RewardMVVideoAdapter", "Is not check big template of ENDCARD download status");
                            return true;
                        }
                    }
                    if (ResDownloadCheckManager.getInstance().checkPreLoadState(this.f37022b + "_" + campaignEx.getRequestId() + "_" + campaignEx.getCMPTEntryUrl())) {
                        return true;
                    }
                    if (z12) {
                        eVar.a("event_name", "is_ready_crwtpl_" + a11);
                        eVar.a("reason", "h5 big template checkPreLoadState error");
                        eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, 5);
                        list2 = list;
                        a(cVar, eVar, list2);
                    }
                }
            }
            list2 = list;
        }
        a(cVar, eVar, list2);
        return false;
    }

    public void b(String str) {
        this.I = str;
    }

    public void b(String str, boolean z10, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        boolean z11;
        try {
            if (this.f37021a == null) {
                com.mbridge.msdk.foundation.error.b a11 = com.mbridge.msdk.foundation.error.a.a(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is Context is null");
                if (cVar != null) {
                    cVar.a(a11);
                }
                b("errorCode: 3507 errorMessage: data load failed, errorMsg is Context is null", cVar);
                return;
            }
            if (y0.a(this.f37022b)) {
                com.mbridge.msdk.foundation.error.b a12 = com.mbridge.msdk.foundation.error.a.a(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is UnitId is null");
                if (cVar != null) {
                    cVar.a(a12);
                }
                b("errorCode: 3507 errorMessage: data load failed, errorMsg is UnitId is null", cVar);
                return;
            }
            if (this.f37032l == null) {
                com.mbridge.msdk.foundation.error.b a13 = com.mbridge.msdk.foundation.error.a.a(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is RewardUnitSetting is null");
                if (cVar != null) {
                    cVar.a(a13);
                }
                b("errorCode: 3507 errorMessage: data load failed, errorMsg is RewardUnitSetting is null", cVar);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                if (System.currentTimeMillis() - this.B < this.f37032l.p() * 1000) {
                    com.mbridge.msdk.foundation.error.b a14 = com.mbridge.msdk.foundation.error.a.a(880018, "errorCode: 3507 errorMessage: data load failed, errorMsg is EXCEPTION_RETURN_EMPTY");
                    if (cVar != null) {
                        cVar.a(a14);
                        cVar.b(true);
                    }
                    b("errorCode: 3507 errorMessage: data load failed, errorMsg is EXCEPTION_RETURN_EMPTY", cVar);
                    return;
                }
            }
            com.mbridge.msdk.foundation.same.net.wrapper.e a15 = new com.mbridge.msdk.reward.adapter.e(this.f37023c, this.f37022b, this.f37038r, this.f37032l, cVar != null ? cVar.o() : "").a(this.f37027g, this.f37028h, this.f37024d, i(), e(), this.f37041u, str, z10, this.f37042v);
            if (a15 == null) {
                com.mbridge.msdk.foundation.error.b a16 = com.mbridge.msdk.foundation.error.a.a(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is Load param is null");
                if (cVar != null) {
                    cVar.a(a16);
                }
                b("errorCode: 3507 errorMessage: data load failed, errorMsg is Load param is null", cVar);
                return;
            }
            if (this.J != 0) {
                a15.a("r_index", this.J + "");
            }
            if (!TextUtils.isEmpty(this.K)) {
                a15.a("invalid_ad_ids", this.K);
            }
            this.N = System.currentTimeMillis();
            com.mbridge.msdk.reward.request.b bVar = new com.mbridge.msdk.reward.request.b(this.f37021a);
            b bVar2 = new b(cVar);
            bVar2.a(str);
            bVar2.setUnitId(this.f37022b);
            bVar2.setPlacementId(this.f37023c);
            bVar2.setAdType(this.f37038r ? 287 : 94);
            bVar2.a(cVar);
            try {
                z11 = com.mbridge.msdk.videocommon.download.j.a().a(this.f37038r ? 287 : 94);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("RewardMVVideoAdapter", "isRewardVideoRefactorForCampaignRequest exception " + e11.getMessage());
                }
                z11 = false;
            }
            boolean z12 = z11;
            try {
                if (com.mbridge.msdk.foundation.same.net.utils.c.b().a(a15) == null) {
                    com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                    eVar.a("hst", k());
                    if (this.J != 0) {
                        eVar.a("r_index", this.J + "");
                    }
                    cVar.a("2000125", eVar);
                    com.mbridge.msdk.reward.report.metrics.a.a().a("2000125", cVar);
                }
            } catch (Exception e12) {
                if (MBridgeConstans.DEBUG) {
                    e12.printStackTrace();
                }
            }
            if (z12) {
                bVar.getCampaign(1, str, a15, bVar2, com.mbridge.msdk.foundation.same.c.a(this.f37026f * 1000, 30000L));
            } else {
                bVar.choiceV3OrV5BySetting(1, a15, bVar2, str, com.mbridge.msdk.foundation.same.c.a(this.f37026f * 1000, 30000L));
            }
        } catch (Exception e13) {
            e13.printStackTrace();
            b("Load exception", cVar);
            n();
        }
    }

    public boolean b(boolean z10) {
        com.mbridge.msdk.foundation.same.report.metrics.c cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
        CopyOnWriteArrayList<CampaignEx> b11 = com.mbridge.msdk.videocommon.cache.a.a().b(this.f37022b, 1, this.f37039s, this.f37040t);
        if (b11 == null || b11.size() <= 0) {
            o0.a("RewardVideoController", "database has not can use data");
            if (z10) {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("event_name", "is_ready_cse");
                eVar.a("reason", "no effective campaign list");
                eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, 8);
                a(cVar, eVar, b11);
            }
            return false;
        }
        CampaignEx campaignEx = b11.get(0);
        cVar.h(campaignEx.getCurrentLocalRid());
        int a11 = com.mbridge.msdk.videocommon.cache.a.a().a(this.f37022b, 1, this.f37039s, this.f37040t);
        if (TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()) || campaignEx.getNscpt() != 1 || b11.size() >= a11) {
            boolean a12 = a(b11, !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()), campaignEx.getNscpt(), z10);
            if (z10) {
                a(a12, cVar, b11);
            }
            return a12;
        }
        if (z10) {
            com.mbridge.msdk.foundation.same.report.metrics.e eVar2 = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar2.a("event_name", "is_ready_cltr");
            eVar2.a("reason", "nscpt error");
            eVar2.a(NativeComponentConstants.KEY_COMPONENT_TYPE, 8);
            a(cVar, eVar2, b11);
        }
        return false;
    }

    public void c(String str) {
        this.f37040t = str;
    }

    public void c(List<CampaignEx> list) {
        this.X = list;
    }

    public void c(boolean z10) {
        this.M = z10;
    }

    public void d(boolean z10) {
        this.f37038r = z10;
    }

    public void e(boolean z10) {
        this.f37039s = z10;
    }

    public CopyOnWriteArrayList<CampaignEx> f() {
        return this.W;
    }

    public void f(boolean z10) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList;
        if (z10 || (copyOnWriteArrayList = this.f37046z) == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        com.mbridge.msdk.videocommon.cache.a.a().a(this.f37022b, this.f37046z);
    }

    public String g() {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.f37046z;
        return (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) ? com.mbridge.msdk.foundation.same.c.b(this.X) : com.mbridge.msdk.foundation.same.c.b(this.f37046z);
    }

    public boolean g(boolean z10) {
        if (z10) {
            List<CampaignEx> list = this.X;
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (CampaignEx campaignEx : this.X) {
                if (campaignEx != null) {
                    campaignEx.setLoadTimeoutState(1);
                    if (campaignEx.getRewardTemplateMode() != null && !TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                        ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f37022b + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e(), true);
                    }
                }
            }
            com.mbridge.msdk.videocommon.cache.a.a().a(this.f37022b, this.X, "load_timeout", 1);
            return true;
        }
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.f37046z;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return false;
        }
        Iterator<CampaignEx> it = this.f37046z.iterator();
        while (it.hasNext()) {
            CampaignEx next = it.next();
            if (next != null) {
                next.setLoadTimeoutState(1);
                if (next.getRewardTemplateMode() != null && !TextUtils.isEmpty(next.getRewardTemplateMode().e())) {
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f37022b + "_" + next.getRequestId() + "_" + next.getRewardTemplateMode().e(), true);
                }
            }
        }
        com.mbridge.msdk.videocommon.cache.a.a().a(this.f37022b, this.f37046z, "load_timeout", 1);
        return true;
    }

    public CopyOnWriteArrayList<CampaignEx> h() {
        return this.f37046z;
    }

    public void h(boolean z10) {
        if (z10) {
            List<CampaignEx> list = this.X;
            if (list == null || list.size() <= 0) {
                return;
            }
            for (CampaignEx campaignEx : this.X) {
                if (campaignEx != null) {
                    campaignEx.setLoadTimeoutState(0);
                    if (campaignEx.getRewardTemplateMode() != null && !TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                        ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f37022b + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e(), false);
                    }
                }
            }
            com.mbridge.msdk.videocommon.cache.a.a().a(this.f37022b, this.X, "load_timeout", 0);
            return;
        }
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.f37046z;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        Iterator<CampaignEx> it = this.f37046z.iterator();
        while (it.hasNext()) {
            CampaignEx next = it.next();
            if (next != null) {
                next.setLoadTimeoutState(0);
                if (next.getRewardTemplateMode() != null && !TextUtils.isEmpty(next.getRewardTemplateMode().e())) {
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f37022b + "_" + next.getRequestId() + "_" + next.getRewardTemplateMode().e(), false);
                }
            }
        }
        com.mbridge.msdk.videocommon.cache.a.a().a(this.f37022b, this.f37046z, "load_timeout", 0);
    }

    public String j() {
        return this.f37022b;
    }

    public boolean l() {
        return b(false);
    }

    public boolean m() {
        List<CampaignEx> c11 = com.mbridge.msdk.videocommon.cache.a.a().c(this.f37022b, 1, this.f37039s, this.f37040t);
        if (c11 == null || c11.size() <= 0) {
            o0.a("test_isReay_db", "database has not can use data");
            return false;
        }
        CampaignEx campaignEx = c11.get(0);
        int a11 = com.mbridge.msdk.videocommon.cache.a.a().a(this.f37022b, 1, this.f37039s, this.f37040t);
        if (TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()) || campaignEx.getNscpt() != 1 || c11.size() >= a11) {
            return a(c11, !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()), campaignEx.getNscpt());
        }
        return false;
    }
}

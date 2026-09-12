package com.mbridge.msdk.mbnative.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.cloud.tmc.integration.ui.p001native.NativeImgComponent;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.iab.omid.library.mmadbridge.adsession.FriendlyObstructionPurpose;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.download.download.HTMLResourceManager;
import com.mbridge.msdk.foundation.download.download.ResourceManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.c;
import com.mbridge.msdk.foundation.same.task.a;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.i0;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.m0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;
import com.mbridge.msdk.mbnative.controller.c;
import com.mbridge.msdk.nativex.view.MBMediaView;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class NativeController extends com.mbridge.msdk.mbnative.controller.a {

    /* renamed from: c0, reason: collision with root package name */
    private static final String f36291c0 = "NativeController";

    /* renamed from: d0, reason: collision with root package name */
    public static Map<String, Long> f36292d0 = new HashMap();

    /* renamed from: e0, reason: collision with root package name */
    private static boolean f36293e0;
    private int A;
    private int B;
    private com.mbridge.msdk.foundation.same.task.b C;
    private List<com.mbridge.msdk.mbnative.controller.c> D;
    private List<c.d> E;
    private CopyOnWriteArrayList<com.mbridge.msdk.foundation.same.task.a> F;
    private Hashtable<String, com.iab.omid.library.mmadbridge.adsession.b> G;
    private int H;
    private int I;
    private n J;
    private boolean K;
    private boolean L;
    private Timer M;
    private String N;
    private String O;
    private ViewTreeObserver.OnGlobalLayoutListener P;
    private com.mbridge.msdk.setting.l Q;
    private long R;
    private int S;
    private int T;
    private boolean U;
    private int V;
    private int W;
    private boolean X;
    private List<Campaign> Y;
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    private com.iab.omid.library.mmadbridge.adsession.b f36294a0;

    /* renamed from: b, reason: collision with root package name */
    protected List<Integer> f36295b;

    /* renamed from: b0, reason: collision with root package name */
    private com.iab.omid.library.mmadbridge.adsession.a f36296b0;

    /* renamed from: c, reason: collision with root package name */
    protected List<Integer> f36297c;

    /* renamed from: d, reason: collision with root package name */
    Map<String, Object> f36298d;

    /* renamed from: e, reason: collision with root package name */
    private com.mbridge.msdk.setting.j f36299e;

    /* renamed from: f, reason: collision with root package name */
    private com.mbridge.msdk.mbnative.listener.a f36300f;

    /* renamed from: g, reason: collision with root package name */
    private NativeListener.NativeTrackingListener f36301g;

    /* renamed from: h, reason: collision with root package name */
    private Context f36302h;

    /* renamed from: i, reason: collision with root package name */
    private String f36303i;

    /* renamed from: j, reason: collision with root package name */
    private String f36304j;

    /* renamed from: k, reason: collision with root package name */
    private Queue<Integer> f36305k;

    /* renamed from: l, reason: collision with root package name */
    private Queue<Long> f36306l;

    /* renamed from: m, reason: collision with root package name */
    private String f36307m;

    /* renamed from: n, reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.report.h f36308n;

    /* renamed from: o, reason: collision with root package name */
    private String f36309o;

    /* renamed from: p, reason: collision with root package name */
    private com.mbridge.msdk.click.a f36310p;

    /* renamed from: q, reason: collision with root package name */
    private int f36311q;

    /* renamed from: r, reason: collision with root package name */
    private int f36312r;

    /* renamed from: s, reason: collision with root package name */
    private int f36313s;

    /* renamed from: t, reason: collision with root package name */
    private int f36314t;

    /* renamed from: u, reason: collision with root package name */
    private String f36315u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f36316v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f36317w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f36318x;

    /* renamed from: y, reason: collision with root package name */
    private int f36319y;

    /* renamed from: z, reason: collision with root package name */
    private int f36320z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f36321a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ NativeListener.NativeAdListener f36322b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f36323c;

        a(List list, NativeListener.NativeAdListener nativeAdListener, int i11) {
            this.f36321a = list;
            this.f36322b = nativeAdListener;
            this.f36323c = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            List list = this.f36321a;
            if (list != null && list.size() > 0) {
                CampaignEx campaignEx = (CampaignEx) this.f36321a.get(0);
                NativeController.this.O = campaignEx.getRequestId();
                NativeController.this.Y = this.f36321a;
            }
            NativeController.this.f36316v = true;
            this.f36322b.onAdLoaded(this.f36321a, this.f36323c);
            com.mbridge.msdk.mbnative.report.a.a(NativeController.this.f36302h, (List<Campaign>) this.f36321a, NativeController.this.f36303i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.mbnative.listener.a f36325a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f36326b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f36327c;

        b(com.mbridge.msdk.mbnative.listener.a aVar, CampaignEx campaignEx, String str) {
            this.f36325a = aVar;
            this.f36326b = campaignEx;
            this.f36327c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f36325a.a(this.f36326b, this.f36327c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements com.mbridge.msdk.foundation.same.image.c {
        c() {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f36330a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ o f36331b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f36332c;

        d(long j11, o oVar, List list) {
            this.f36330a = j11;
            this.f36331b = oVar;
            this.f36332c = list;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            boolean z10;
            if (System.currentTimeMillis() - this.f36330a >= 60000) {
                this.f36331b.a();
                NativeController.this.c();
                return;
            }
            int s11 = k0.s(NativeController.this.f36302h);
            int q11 = NativeController.this.h().q();
            if (s11 != 9 && q11 == 2) {
                this.f36331b.a();
                NativeController.this.c();
                return;
            }
            if (q11 == 3) {
                this.f36331b.a();
                NativeController.this.c();
                return;
            }
            loop0: while (true) {
                z10 = false;
                for (Campaign campaign : this.f36332c) {
                    String id2 = campaign.getId();
                    if (campaign instanceof CampaignEx) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(id2);
                        CampaignEx campaignEx = (CampaignEx) campaign;
                        sb2.append(campaignEx.getVideoUrlEncode());
                        sb2.append(campaignEx.getBidToken());
                        id2 = sb2.toString();
                    }
                    com.mbridge.msdk.videocommon.download.a a11 = com.mbridge.msdk.videocommon.download.b.getInstance().a(NativeController.this.f36303i, id2);
                    if (a11 != null && com.mbridge.msdk.videocommon.download.l.a(a11, NativeController.this.h().C())) {
                        z10 = true;
                    }
                }
                break loop0;
            }
            if (z10) {
                this.f36331b.a();
                NativeController.this.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f36334a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f36335b;

        e(ImageView imageView, View view) {
            this.f36334a = imageView;
            this.f36335b = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (this.f36334a != null) {
                this.f36334a.setLayoutParams(new FrameLayout.LayoutParams(this.f36335b.getWidth(), this.f36335b.getHeight()));
            }
        }
    }

    /* loaded from: classes5.dex */
    class f extends com.mbridge.msdk.widget.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f36337b;

        f(CampaignEx campaignEx) {
            this.f36337b = campaignEx;
        }

        @Override // com.mbridge.msdk.widget.a
        protected void a(View view) {
            NativeController.this.b(view.getContext(), this.f36337b);
        }
    }

    /* loaded from: classes5.dex */
    class g extends com.mbridge.msdk.widget.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f36339b;

        g(CampaignEx campaignEx) {
            this.f36339b = campaignEx;
        }

        @Override // com.mbridge.msdk.widget.a
        protected void a(View view) {
            NativeController.this.b(view.getContext(), this.f36339b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class h implements com.mbridge.msdk.widget.dialog.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f36341a;

        h(CampaignEx campaignEx) {
            this.f36341a = campaignEx;
        }

        @Override // com.mbridge.msdk.widget.dialog.b
        public void a() {
        }

        @Override // com.mbridge.msdk.widget.dialog.b
        public void b() {
            NativeController.this.f36310p.a(this.f36341a, NativeController.this.f36300f);
            NativeController.this.b(this.f36341a);
        }

        @Override // com.mbridge.msdk.widget.dialog.b
        public void c() {
        }
    }

    /* loaded from: classes5.dex */
    class i extends com.mbridge.msdk.widget.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f36343b;

        i(CampaignEx campaignEx) {
            this.f36343b = campaignEx;
        }

        @Override // com.mbridge.msdk.widget.a
        protected void a(View view) {
            NativeController.this.b(view.getContext(), this.f36343b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class j implements a.InterfaceC0493a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ s f36345a;

        j(s sVar) {
            this.f36345a = sVar;
        }

        @Override // com.mbridge.msdk.foundation.same.task.a.InterfaceC0493a
        public void a(a.b bVar) {
            if (bVar != a.b.FINISH || NativeController.this.F == null || NativeController.this.F.size() <= 0 || !NativeController.this.F.contains(this.f36345a)) {
                return;
            }
            NativeController.this.F.remove(this.f36345a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class k implements c.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f36347a;

        k(CampaignEx campaignEx) {
            this.f36347a = campaignEx;
        }

        @Override // com.mbridge.msdk.mbnative.controller.c.d
        public void a(ArrayList<View> arrayList, ArrayList<View> arrayList2) {
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            com.mbridge.msdk.mbnative.report.b.a(this.f36347a, NativeController.this.f36302h, NativeController.this.f36303i, NativeController.this.f36300f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class l implements o {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f36349a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f36350b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.mbnative.listener.a f36351c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f36352d;

        l(List list, int i11, com.mbridge.msdk.mbnative.listener.a aVar, List list2) {
            this.f36349a = list;
            this.f36350b = i11;
            this.f36351c = aVar;
            this.f36352d = list2;
        }

        @Override // com.mbridge.msdk.mbnative.controller.NativeController.o
        public void a() {
            List a11 = NativeController.this.a((List<Campaign>) this.f36349a, true);
            if (a11 == null || a11.size() <= 0) {
                NativeController.this.a(this.f36351c, "has no ads", (CampaignEx) this.f36352d.get(0));
            } else {
                NativeController.this.a((List<Campaign>) a11, this.f36350b, this.f36351c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class m implements o {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f36354a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f36355b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.mbnative.listener.a f36356c;

        m(List list, int i11, com.mbridge.msdk.mbnative.listener.a aVar) {
            this.f36354a = list;
            this.f36355b = i11;
            this.f36356c = aVar;
        }

        @Override // com.mbridge.msdk.mbnative.controller.NativeController.o
        public void a() {
            List a11 = NativeController.this.a((List<Campaign>) this.f36354a, false);
            if (a11 == null || a11.size() <= 0) {
                NativeController.this.a(this.f36356c, "has no ads", (CampaignEx) null);
            } else {
                NativeController.this.a((List<Campaign>) a11, this.f36355b, this.f36356c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n extends com.mbridge.msdk.mbnative.service.net.b implements com.mbridge.msdk.foundation.same.task.d {

        /* renamed from: d, reason: collision with root package name */
        private Runnable f36359d;

        /* renamed from: c, reason: collision with root package name */
        private boolean f36358c = false;

        /* renamed from: e, reason: collision with root package name */
        private boolean f36360e = true;

        /* renamed from: f, reason: collision with root package name */
        private List<String> f36361f = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public class a extends c.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CampaignEx f36363a;

            a(CampaignEx campaignEx, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
                this.f36363a = campaignEx;
            }

            @Override // com.mbridge.msdk.foundation.same.c.a
            public void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
                com.mbridge.msdk.mbnative.report.a.a(str, cVar, this.f36363a, NativeController.this.f36302h, (com.mbridge.msdk.foundation.same.report.metrics.callback.a) null);
            }
        }

        public n() {
        }

        private void a(CampaignEx campaignEx, com.mbridge.msdk.foundation.same.report.metrics.c cVar, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
            try {
                com.mbridge.msdk.foundation.same.c.a(campaignEx, NativeController.this.f36302h, cVar, new a(campaignEx, aVar));
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
            }
        }

        @Override // com.mbridge.msdk.mbnative.service.net.b
        public void a(int i11, String str) {
            NativeController.this.U = true;
            if (this.f36358c) {
                if (NativeController.this.f36316v || !this.f36360e) {
                    return;
                }
                NativeController.this.a(str, a(), b(), (CampaignEx) null);
                return;
            }
            if (i11 == -1) {
                com.mbridge.msdk.mbnative.controller.d.b(NativeController.this.f36313s, this.unitId);
                NativeController.this.f36314t = 0;
            }
            Runnable runnable = this.f36359d;
            if (runnable != null) {
                NativeController.this.f36384a.removeCallbacks(runnable);
            }
            if (NativeController.this.f36316v) {
                return;
            }
            if (a() == 1 || this.f36360e) {
                NativeController.this.a(str, a(), b(), (CampaignEx) null);
            }
        }

        public void a(Runnable runnable) {
            this.f36359d = runnable;
        }

        @Override // com.mbridge.msdk.mbnative.service.net.b
        public void a(List<Frame> list) {
            if (this.f36358c) {
                return;
            }
            Runnable runnable = this.f36359d;
            if (runnable != null) {
                NativeController.this.f36384a.removeCallbacks(runnable);
            }
            if (list == null || list.size() == 0) {
                if (NativeController.this.f36300f != null) {
                    NativeController.this.f36316v = true;
                    NativeController.this.f36300f.onAdLoadError("frame is empty");
                    return;
                }
                return;
            }
            Iterator<Frame> it = list.iterator();
            while (it.hasNext()) {
                List<CampaignEx> campaigns = it.next().getCampaigns();
                if (campaigns == null || campaigns.size() == 0) {
                    if (NativeController.this.f36300f != null) {
                        NativeController.this.f36316v = true;
                        NativeController.this.f36300f.onAdLoadError("ads in frame is empty");
                        return;
                    }
                    return;
                }
                for (CampaignEx campaignEx : campaigns) {
                    if (NativeController.f36293e0) {
                        campaignEx.loadImageUrlAsyncWithBlock(null);
                        campaignEx.loadIconUrlAsyncWithBlock(null);
                    }
                }
            }
            if (NativeController.this.f36300f != null) {
                NativeController.this.f36300f.onAdFramesLoaded(list);
            }
        }

        @Override // com.mbridge.msdk.mbnative.service.net.b
        public void a(List<com.mbridge.msdk.tracker.network.g> list, CampaignUnit campaignUnit) {
            Integer num;
            boolean z10 = true;
            NativeController.this.U = true;
            com.mbridge.msdk.foundation.db.j a11 = com.mbridge.msdk.foundation.db.j.a(com.mbridge.msdk.foundation.db.g.a(NativeController.this.f36302h));
            a11.a();
            Runnable runnable = this.f36359d;
            if (runnable != null) {
                NativeController.this.f36384a.removeCallbacks(runnable);
            }
            if (com.mbridge.msdk.util.b.a()) {
                NativeController.this.a(campaignUnit);
            }
            if (campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().size() <= 0) {
                this.unitId = "0_" + this.unitId;
                com.mbridge.msdk.mbnative.controller.d.b(NativeController.this.f36313s, this.unitId);
                NativeController.this.f36314t = 0;
                return;
            }
            NativeController.this.f36309o = campaignUnit.getSessionId();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (NativeController.this.S <= 0) {
                if (NativeController.this.S == -3) {
                    NativeController.this.S = campaignUnit.getAds().size();
                } else {
                    NativeController nativeController = NativeController.this;
                    nativeController.S = nativeController.f36312r;
                }
                if (NativeController.this.V != 0 && campaignUnit.getTemplate() == 2) {
                    NativeController nativeController2 = NativeController.this;
                    nativeController2.S = nativeController2.V;
                }
                if (NativeController.this.W != 0 && campaignUnit.getTemplate() == 3) {
                    NativeController nativeController3 = NativeController.this;
                    nativeController3.S = nativeController3.W;
                }
            }
            int i11 = 0;
            while (i11 < campaignUnit.getAds().size()) {
                CampaignEx campaignEx = campaignUnit.getAds().get(i11);
                campaignEx.setCampaignUnitId(this.unitId);
                if (!TextUtils.isEmpty(NativeController.this.N)) {
                    campaignEx.setBidToken(NativeController.this.N);
                    campaignEx.setIsBidCampaign(z10);
                }
                if (NativeController.f36293e0) {
                    campaignEx.loadIconUrlAsyncWithBlock(null);
                    campaignEx.loadImageUrlAsyncWithBlock(null);
                }
                boolean c11 = t0.c(NativeController.this.f36302h, campaignEx.getPackageName());
                NativeController nativeController4 = NativeController.this;
                nativeController4.a(nativeController4.f36302h, campaignEx);
                if (i11 < NativeController.this.f36312r && campaignEx.getOfferType() != 99) {
                    if (t0.c(campaignEx)) {
                        campaignEx.setRtinsType(c11 ? z10 : 2);
                    }
                    if (com.mbridge.msdk.foundation.same.c.b(NativeController.this.f36302h, campaignEx)) {
                        arrayList.add(campaignEx);
                        if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                            arrayList3.add(campaignEx);
                        }
                    } else {
                        t0.a(this.unitId, campaignEx, com.mbridge.msdk.foundation.same.a.f35406x);
                        NativeController.this.Z = "APP ALREADY INSTALLED";
                    }
                    a(campaignEx, null, null);
                }
                if (i11 < NativeController.this.S && campaignEx.getOfferType() != 99) {
                    if (t0.c(campaignEx)) {
                        campaignEx.setRtinsType(c11 ? 1 : 2);
                    }
                    if (!c11) {
                        arrayList2.add(campaignEx);
                    } else if (t0.c(campaignEx)) {
                        arrayList2.add(campaignEx);
                    }
                }
                if (!a11.a(campaignEx.getId())) {
                    com.mbridge.msdk.foundation.entity.g gVar = new com.mbridge.msdk.foundation.entity.g();
                    gVar.a(campaignEx.getId());
                    gVar.b(campaignEx.getFca());
                    gVar.c(campaignEx.getFcb());
                    gVar.a(0);
                    gVar.d(0);
                    gVar.a(System.currentTimeMillis());
                    a11.b(gVar);
                }
                com.mbridge.msdk.click.c.a(NativeController.this.f36302h, campaignEx.getMaitve(), campaignEx.getMaitve_src());
                i11++;
                z10 = true;
            }
            NativeController.this.d(arrayList3);
            int type = campaignUnit.getAds().get(0) != null ? campaignUnit.getAds().get(0).getType() : 1;
            com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>> a12 = com.mbridge.msdk.mbnative.cache.c.a(type);
            if (a12 != null) {
                a12.a((com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>>) this.unitId, (String) arrayList2, NativeController.this.N);
            }
            if (arrayList.size() == 0) {
                if (NativeController.this.Z.contains("INSTALLED")) {
                    NativeController.this.a("APP ALREADY INSTALLED", a(), b(), campaignUnit.getAds().get(0));
                    new com.mbridge.msdk.foundation.error.b(880021, "APP ALREADY INSTALLED");
                    return;
                } else {
                    NativeController.this.a("v3 response error", a(), b(), campaignUnit.getAds().get(0));
                    new com.mbridge.msdk.foundation.error.b(880003);
                    return;
                }
            }
            NativeController nativeController5 = NativeController.this;
            nativeController5.c((List<Campaign>) nativeController5.a(type, (List<Campaign>) nativeController5.a(arrayList)));
            if (com.mbridge.msdk.mbnative.controller.d.g().containsKey(this.unitId) && Boolean.TRUE.equals(com.mbridge.msdk.mbnative.controller.d.g().get(this.unitId))) {
                com.mbridge.msdk.mbnative.controller.d.a(NativeController.this.f36313s, this.unitId);
                return;
            }
            int intValue = (!com.mbridge.msdk.mbnative.controller.d.d().containsKey(this.unitId) || (num = com.mbridge.msdk.mbnative.controller.d.d().get(this.unitId)) == null) ? 1 : num.intValue();
            int i12 = NativeController.this.f36312r + NativeController.this.f36314t;
            NativeController.this.f36314t = i12 <= intValue ? i12 : 0;
        }

        @Override // com.mbridge.msdk.foundation.same.task.d
        public void a(boolean z10) {
            this.f36358c = z10;
        }

        public void b(List<String> list) {
            this.f36361f = list;
        }

        public void b(boolean z10) {
            this.f36360e = z10;
        }
    }

    /* loaded from: classes5.dex */
    public interface o {
        void a();
    }

    /* loaded from: classes5.dex */
    public class p implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private int f36365a;

        /* renamed from: b, reason: collision with root package name */
        private com.mbridge.msdk.foundation.same.task.d f36366b;

        /* renamed from: c, reason: collision with root package name */
        private int f36367c;

        /* renamed from: d, reason: collision with root package name */
        private String f36368d;

        public p(int i11, com.mbridge.msdk.foundation.same.task.d dVar, int i12, String str) {
            this.f36365a = i11;
            this.f36366b = dVar;
            this.f36367c = i12;
            this.f36368d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f36366b.a(true);
            int i11 = this.f36365a;
            if (i11 == 1) {
                NativeController.this.U = true;
                NativeController.this.a("REQUEST_TIMEOUT", this.f36367c, this.f36368d, (CampaignEx) null);
            } else {
                if (i11 != 2) {
                    return;
                }
                if (!NativeController.this.f36316v || this.f36367c == 1) {
                    NativeController.this.a("REQUEST_TIMEOUT", this.f36367c, this.f36368d, (CampaignEx) null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class q implements H5DownLoadManager.IH5SourceDownloadListener {

        /* renamed from: a, reason: collision with root package name */
        private String f36370a;

        /* renamed from: b, reason: collision with root package name */
        private CampaignEx f36371b;

        /* renamed from: c, reason: collision with root package name */
        private long f36372c = System.currentTimeMillis();

        /* renamed from: d, reason: collision with root package name */
        private boolean f36373d;

        public q(String str, CampaignEx campaignEx, boolean z10) {
            this.f36373d = true;
            this.f36370a = str;
            this.f36371b = campaignEx;
            this.f36373d = z10;
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onFailed(String str, String str2) {
            try {
                if (this.f36373d) {
                    long currentTimeMillis = System.currentTimeMillis() - this.f36372c;
                    com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
                    com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m("2000043", 3, currentTimeMillis + "", str, this.f36371b.getId(), this.f36370a, str2, "2");
                    mVar.n(this.f36371b.getRequestId());
                    mVar.k(this.f36371b.getCurrentLocalRid());
                    mVar.o(this.f36371b.getRequestIdNotice());
                    CampaignEx campaignEx = this.f36371b;
                    if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getId())) {
                        mVar.b(this.f36371b.getId());
                    }
                    CampaignEx campaignEx2 = this.f36371b;
                    if (campaignEx2 != null) {
                        mVar.a(campaignEx2.getAdSpaceT());
                    }
                    mVar.a("1");
                    com.mbridge.msdk.foundation.same.report.g.a(mVar, this.f36370a, this.f36371b);
                }
            } catch (Exception e11) {
                o0.b(NativeController.f36291c0, com.mbridge.msdk.mbnative.common.a.a(e11));
            }
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onSuccess(String str, String str2, boolean z10) {
            try {
                if (this.f36373d) {
                    long currentTimeMillis = System.currentTimeMillis() - this.f36372c;
                    com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
                    com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m("2000043", 1, currentTimeMillis + "", str, this.f36371b.getId(), this.f36370a, "", "2");
                    CampaignEx campaignEx = this.f36371b;
                    if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getId())) {
                        mVar.b(this.f36371b.getId());
                    }
                    CampaignEx campaignEx2 = this.f36371b;
                    if (campaignEx2 != null) {
                        mVar.n(campaignEx2.getRequestId());
                        mVar.o(this.f36371b.getRequestIdNotice());
                        mVar.k(this.f36371b.getCurrentLocalRid());
                        mVar.a(this.f36371b.getAdSpaceT());
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        mVar.q(str2);
                    }
                    mVar.a("1");
                    com.mbridge.msdk.foundation.same.report.g.a(mVar, this.f36370a, this.f36371b);
                }
            } catch (Exception e11) {
                o0.b(NativeController.f36291c0, com.mbridge.msdk.mbnative.common.a.a(e11));
            }
        }
    }

    /* loaded from: classes5.dex */
    protected static class r extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<NativeController> f36374a;

        public r(NativeController nativeController) {
            this.f36374a = new WeakReference<>(nativeController);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference<NativeController> weakReference;
            NativeController nativeController;
            super.handleMessage(message);
            try {
                if (message.what == 0 && (weakReference = this.f36374a) != null && (nativeController = weakReference.get()) != null) {
                    nativeController.f36308n.a(message.arg1, (String) message.obj);
                }
                if (message.what == 1) {
                    WeakReference<NativeController> weakReference2 = this.f36374a;
                    NativeController nativeController2 = (weakReference2 == null || weakReference2.get() == null) ? null : this.f36374a.get();
                    if (nativeController2 != null) {
                        nativeController2.f36317w = true;
                        List<Campaign> a11 = nativeController2.a(nativeController2.f36303i, nativeController2.f36312r, nativeController2.N);
                        if (nativeController2.f36316v) {
                            return;
                        }
                        nativeController2.c(a11);
                    }
                }
            } catch (Exception e11) {
                o0.b(NativeController.f36291c0, com.mbridge.msdk.mbnative.common.a.a(e11));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class s extends com.mbridge.msdk.foundation.same.task.a {

        /* renamed from: a, reason: collision with root package name */
        private CampaignEx f36375a;

        /* renamed from: b, reason: collision with root package name */
        private WeakReference<View> f36376b;

        /* renamed from: c, reason: collision with root package name */
        private WeakReference<List<View>> f36377c;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<NativeController> f36378d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<com.iab.omid.library.mmadbridge.adsession.b> f36379e;

        public s(CampaignEx campaignEx, View view, List<View> list, NativeController nativeController, com.iab.omid.library.mmadbridge.adsession.b bVar) {
            this.f36375a = campaignEx;
            this.f36376b = new WeakReference<>(view);
            this.f36377c = new WeakReference<>(list);
            this.f36378d = new WeakReference<>(nativeController);
            this.f36379e = new WeakReference<>(bVar);
        }

        @Override // com.mbridge.msdk.foundation.same.task.a
        public void cancelTask() {
        }

        @Override // com.mbridge.msdk.foundation.same.task.a
        public void pauseTask(boolean z10) {
        }

        @Override // com.mbridge.msdk.foundation.same.task.a
        public void runTask() {
            WeakReference<View> weakReference;
            try {
                if (this.f36378d == null || (weakReference = this.f36376b) == null || this.f36377c == null) {
                    return;
                }
                View view = weakReference.get();
                List<View> list = this.f36377c.get();
                NativeController nativeController = this.f36378d.get();
                WeakReference<com.iab.omid.library.mmadbridge.adsession.b> weakReference2 = this.f36379e;
                com.iab.omid.library.mmadbridge.adsession.b bVar = weakReference2 != null ? weakReference2.get() : null;
                if (view == null || nativeController == null) {
                    return;
                }
                nativeController.a(this.f36375a, view, list, bVar);
            } catch (Exception e11) {
                o0.b(NativeController.f36291c0, com.mbridge.msdk.mbnative.common.a.a(e11));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class t implements H5DownLoadManager.ZipDownloadListener {

        /* renamed from: a, reason: collision with root package name */
        String f36380a;

        /* renamed from: b, reason: collision with root package name */
        CampaignEx f36381b;

        /* renamed from: c, reason: collision with root package name */
        private long f36382c = System.currentTimeMillis();

        /* renamed from: d, reason: collision with root package name */
        private boolean f36383d;

        public t(String str, CampaignEx campaignEx, boolean z10) {
            this.f36383d = true;
            this.f36380a = str;
            this.f36381b = campaignEx;
            this.f36383d = z10;
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onFailed(String str, String str2) {
            try {
                if (this.f36383d) {
                    long currentTimeMillis = System.currentTimeMillis() - this.f36382c;
                    com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
                    com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m("2000043", 3, currentTimeMillis + "", str2, this.f36381b.getId(), this.f36380a, str, "1");
                    CampaignEx campaignEx = this.f36381b;
                    if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getId())) {
                        mVar.b(this.f36381b.getId());
                    }
                    CampaignEx campaignEx2 = this.f36381b;
                    if (campaignEx2 != null) {
                        mVar.n(campaignEx2.getRequestId());
                        mVar.k(this.f36381b.getCurrentLocalRid());
                        mVar.o(this.f36381b.getRequestIdNotice());
                        mVar.a(this.f36381b.getAdSpaceT());
                    }
                    mVar.a("2");
                    com.mbridge.msdk.foundation.same.report.g.a(mVar, this.f36380a, this.f36381b);
                }
            } catch (Exception e11) {
                o0.b(NativeController.f36291c0, com.mbridge.msdk.mbnative.common.a.a(e11));
            }
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onSuccess(String str, String str2, boolean z10) {
            try {
                if (this.f36383d) {
                    long currentTimeMillis = System.currentTimeMillis() - this.f36382c;
                    com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
                    com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m("2000043", 1, currentTimeMillis + "", str, this.f36381b.getId(), this.f36380a, "", "1");
                    CampaignEx campaignEx = this.f36381b;
                    if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getId())) {
                        mVar.b(this.f36381b.getId());
                    }
                    CampaignEx campaignEx2 = this.f36381b;
                    if (campaignEx2 != null) {
                        mVar.n(campaignEx2.getRequestId());
                        mVar.k(this.f36381b.getCurrentLocalRid());
                        mVar.o(this.f36381b.getRequestIdNotice());
                        mVar.a(this.f36381b.getAdSpaceT());
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        mVar.q(str2);
                    }
                    mVar.a("2");
                    com.mbridge.msdk.foundation.same.report.g.a(mVar, this.f36380a, this.f36381b);
                }
            } catch (Exception e11) {
                o0.b(NativeController.f36291c0, com.mbridge.msdk.mbnative.common.a.a(e11));
            }
        }
    }

    public NativeController() {
        this.f36311q = 1;
        this.f36312r = 1;
        this.f36313s = -1;
        this.f36314t = 0;
        this.f36316v = false;
        this.f36317w = false;
        this.f36318x = false;
        this.f36319y = 0;
        this.f36320z = 0;
        this.A = 0;
        this.B = 0;
        this.F = new CopyOnWriteArrayList<>();
        this.G = new Hashtable<>();
        this.H = 1;
        this.I = 2;
        this.N = "";
        this.O = "";
        this.Z = "";
    }

    public NativeController(com.mbridge.msdk.mbnative.listener.a aVar, NativeListener.NativeTrackingListener nativeTrackingListener, Map<String, Object> map, Context context) {
        int i11;
        Object obj;
        this.f36311q = 1;
        this.f36312r = 1;
        this.f36313s = -1;
        this.f36314t = 0;
        this.f36316v = false;
        this.f36317w = false;
        this.f36318x = false;
        this.f36319y = 0;
        this.f36320z = 0;
        this.A = 0;
        this.B = 0;
        this.F = new CopyOnWriteArrayList<>();
        this.G = new Hashtable<>();
        this.H = 1;
        this.I = 2;
        this.N = "";
        this.O = "";
        this.Z = "";
        this.f36302h = context;
        this.f36298d = map;
        this.f36299e = new com.mbridge.msdk.setting.j();
        this.f36300f = aVar;
        this.f36301g = nativeTrackingListener;
        this.D = new ArrayList();
        this.E = new ArrayList();
        String str = (String) map.get(MBridgeConstans.PROPERTIES_UNIT_ID);
        this.f36303i = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!map.containsKey(MBridgeConstans.PLACEMENT_ID) || map.get(MBridgeConstans.PLACEMENT_ID) == null) {
            this.f36304j = "";
        } else {
            this.f36304j = (String) map.get(MBridgeConstans.PLACEMENT_ID);
        }
        if (map.containsKey(MBridgeConstans.PREIMAGE) && (obj = map.get(MBridgeConstans.PREIMAGE)) != null) {
            f36293e0 = ((Boolean) obj).booleanValue();
        }
        this.f36305k = new LinkedList();
        this.f36306l = new LinkedList();
        this.C = new com.mbridge.msdk.foundation.same.task.b(this.f36302h);
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        this.f36384a = new r(this);
        if (map.containsKey(MBridgeConstans.PROPERTIES_API_REUQEST_CATEGORY)) {
            this.f36315u = (String) map.get(MBridgeConstans.PROPERTIES_API_REUQEST_CATEGORY);
        }
        try {
            boolean equals = com.mbridge.msdk.mbnative.controller.d.g().containsKey(this.f36303i) ? Boolean.TRUE.equals(com.mbridge.msdk.mbnative.controller.d.g().get(this.f36303i)) : false;
            Object obj2 = map.get("ad_num");
            Object obj3 = map.get(MBridgeConstans.PROPERTIES_AD_FRAME_NUM);
            if (!equals) {
                if (map.containsKey("ad_num") && obj2 != null) {
                    try {
                        i11 = ((Integer) obj2).intValue();
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            o0.b(f36291c0, e11.getMessage());
                        }
                        i11 = 1;
                    }
                    i11 = i11 < 1 ? 1 : i11;
                    i11 = i11 > 10 ? 10 : i11;
                    this.f36312r = i11;
                    this.f36311q = i11;
                }
                if (map.containsKey(MBridgeConstans.PROPERTIES_AD_FRAME_NUM) && obj3 != null) {
                    try {
                        this.A = ((Integer) obj3).intValue();
                    } catch (Exception e12) {
                        if (MBridgeConstans.DEBUG) {
                            o0.b(f36291c0, e12.getMessage());
                        }
                    }
                }
            } else if (com.mbridge.msdk.mbnative.controller.d.c().containsKey(this.f36303i)) {
                Integer num = com.mbridge.msdk.mbnative.controller.d.c().get(this.f36303i);
                if (num != null) {
                    this.f36312r = num.intValue();
                }
                if (map.containsKey("ad_num") && obj2 != null) {
                    int intValue = ((Integer) obj2).intValue();
                    this.f36319y = intValue;
                    this.f36311q = intValue;
                }
                if (map.containsKey(MBridgeConstans.PROPERTIES_AD_FRAME_NUM) && obj3 != null) {
                    int intValue2 = ((Integer) obj3).intValue();
                    this.f36320z = intValue2;
                    this.A = intValue2;
                }
            }
        } catch (Exception e13) {
            o0.b(f36291c0, com.mbridge.msdk.mbnative.common.a.a(e13));
        }
        this.f36308n = new com.mbridge.msdk.foundation.same.report.h(this.f36302h);
        this.f36310p = new com.mbridge.msdk.click.a(this.f36302h, this.f36303i);
        try {
            int i12 = MBMediaView.f36710p0;
            this.L = true;
            Map<String, Object> map2 = this.f36298d;
            if (map2 != null && (map2.containsKey(MBridgeConstans.NATIVE_VIDEO_WIDTH) || this.f36298d.containsKey(MBridgeConstans.NATIVE_VIDEO_HEIGHT) || map.containsKey(MBridgeConstans.NATIVE_VIDEO_SUPPORT))) {
                this.K = true;
            }
            com.mbridge.msdk.mbnative.controller.e.a(this.f36302h, this.f36303i);
            m0.a();
            if (TextUtils.isEmpty(this.f36303i)) {
                return;
            }
            com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(this.f36302h)).a();
            int a11 = a(map.containsKey(MBridgeConstans.NATIVE_INFO) ? (String) map.get(MBridgeConstans.NATIVE_INFO) : null);
            List<Campaign> a12 = a(this.f36303i, a11 <= 0 ? this.f36311q : a11);
            if (a12 != null) {
                ArrayList arrayList = new ArrayList();
                for (int i13 = 0; i13 < a12.size(); i13++) {
                    CampaignEx campaignEx = (CampaignEx) a12.get(i13);
                    if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                        arrayList.add(campaignEx);
                    }
                }
                if (arrayList.size() > 0) {
                    Object invoke = com.mbridge.msdk.videocommon.download.b.class.getMethod("getInstance", null).invoke(null, null);
                    com.mbridge.msdk.videocommon.download.b.class.getMethod("createUnitCache", Context.class, String.class, CopyOnWriteArrayList.class, Integer.TYPE, com.mbridge.msdk.videocommon.listener.a.class).invoke(invoke, context, this.f36303i, new CopyOnWriteArrayList(arrayList), 1, null);
                    com.mbridge.msdk.videocommon.download.b.class.getMethod(NativeImgComponent.EVENT_LOAD, String.class).invoke(invoke, this.f36303i);
                }
            }
        } catch (Throwable unused) {
            o0.b(f36291c0, "please import the nativex aar");
        }
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
            o0.b(f36291c0, com.mbridge.msdk.mbnative.common.a.a(e11));
        }
        return 0;
    }

    private com.iab.omid.library.mmadbridge.adsession.b a(CampaignEx campaignEx) {
        if (this.G == null) {
            this.G = new Hashtable<>();
        }
        String requestIdNotice = campaignEx.getRequestIdNotice();
        com.iab.omid.library.mmadbridge.adsession.b bVar = this.G.get(requestIdNotice);
        if (bVar == null && campaignEx.isActiveOm() && TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            bVar = com.mbridge.msdk.omsdk.b.a(this.f36302h, true, campaignEx.getOmid(), campaignEx.getRequestId(), campaignEx.getId(), this.f36303i, "", campaignEx.getRequestIdNotice());
        }
        if (bVar != null) {
            this.G.put(requestIdNotice, bVar);
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Campaign> a(int i11, List<Campaign> list) {
        if (i11 != 1 || !this.f36298d.containsKey(MBridgeConstans.NATIVE_INFO) || list == null || list.size() <= 0) {
            return list;
        }
        CampaignEx campaignEx = (CampaignEx) list.get(0);
        int template = campaignEx != null ? campaignEx.getTemplate() : 1;
        if (template == 2) {
            int size = list.size();
            int i12 = this.V;
            return size >= i12 ? list.subList(0, i12) : list;
        }
        if (template != 3) {
            return list;
        }
        int size2 = list.size();
        int i13 = this.W;
        return size2 >= i13 ? list.subList(0, i13) : list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Campaign> a(List<Campaign> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        for (Campaign campaign : list) {
            if (campaign instanceof CampaignEx) {
                CampaignEx campaignEx = (CampaignEx) campaign;
                if (TextUtils.isEmpty(this.N) && TextUtils.isEmpty(campaignEx.getBidToken()) && !campaignEx.isBidCampaign()) {
                    arrayList2.add(campaignEx);
                } else if (!TextUtils.isEmpty(this.N) && TextUtils.equals(campaignEx.getBidToken(), this.N)) {
                    arrayList.add(campaign);
                }
            } else {
                arrayList2.add(campaign);
            }
        }
        return TextUtils.isEmpty(this.N) ? arrayList2 : arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Campaign> a(List<Campaign> list, boolean z10) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                Campaign campaign = list.get(size);
                String id2 = campaign.getId();
                boolean z11 = campaign instanceof CampaignEx;
                if (z11) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(id2);
                    CampaignEx campaignEx = (CampaignEx) campaign;
                    sb2.append(campaignEx.getVideoUrlEncode());
                    sb2.append(campaignEx.getBidToken());
                    id2 = sb2.toString();
                }
                com.mbridge.msdk.videocommon.download.a a11 = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f36303i, id2);
                if (z10) {
                    if (a11 == null || !com.mbridge.msdk.videocommon.download.l.a(a11, h().C())) {
                        com.mbridge.msdk.mbnative.cache.c.a(campaign.getType()).a(this.f36303i, list.remove(size), this.N);
                    }
                } else if (z11) {
                    CampaignEx campaignEx2 = (CampaignEx) campaign;
                    if (TextUtils.isEmpty(campaignEx2.getImageUrl()) && !TextUtils.isEmpty(campaignEx2.getVideoUrlEncode()) && (a11 == null || !com.mbridge.msdk.videocommon.download.l.a(a11, h().C()))) {
                        com.mbridge.msdk.mbnative.cache.c.a(campaign.getType()).a(this.f36303i, list.remove(size), this.N);
                    }
                }
            }
        }
        return list;
    }

    public static List<String> a(Map<String, Object> map) {
        Exception e11;
        ArrayList arrayList = null;
        try {
            if (!(map.get(MBridgeConstans.KEY_WORD) instanceof String)) {
                return null;
            }
            String str = (String) map.get(MBridgeConstans.KEY_WORD);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i11);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString(TtmlNode.TAG_P);
                        if (!TextUtils.isEmpty(optString)) {
                            arrayList2.add(optString);
                        }
                    }
                } catch (Exception e12) {
                    e11 = e12;
                    arrayList = arrayList2;
                    o0.b(f36291c0, com.mbridge.msdk.mbnative.common.a.a(e11));
                    return arrayList;
                }
            }
            return arrayList2;
        } catch (Exception e13) {
            e11 = e13;
        }
    }

    private void a(View view, View.OnClickListener onClickListener, Class cls) {
        if (view == null || onClickListener == null) {
            return;
        }
        if (cls != null) {
            try {
                if (cls.isInstance(view)) {
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        view.setOnClickListener(onClickListener);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                a(viewGroup.getChildAt(i11), onClickListener, cls);
            }
        }
    }

    private void a(View view, CampaignEx campaignEx) {
        BitmapDrawable a11;
        ImageView imageView;
        if (!(view instanceof FrameLayout) || (a11 = com.mbridge.msdk.foundation.controller.c.m().a(this.f36303i, campaignEx.getAdType())) == null) {
            return;
        }
        try {
            int childCount = ((ViewGroup) view).getChildCount();
            int i11 = 0;
            while (true) {
                if (i11 >= childCount) {
                    imageView = null;
                    break;
                }
                View childAt = ((ViewGroup) view).getChildAt(i11);
                if ((childAt instanceof ImageView) && childAt.getTag() != null && "mb_wm".equals((String) childAt.getTag())) {
                    ((ImageView) childAt).setLayoutParams(new FrameLayout.LayoutParams(view.getWidth(), view.getHeight()));
                    imageView = (ImageView) childAt;
                    break;
                }
                i11++;
            }
            if (imageView == null) {
                imageView = new ImageView(com.mbridge.msdk.foundation.controller.c.m().d());
                imageView.setTag("mb_wm");
                t0.a(imageView, a11, view.getResources().getDisplayMetrics());
                if (imageView.getParent() == null) {
                    ((FrameLayout) view).addView(imageView, new FrameLayout.LayoutParams(view.getWidth(), view.getHeight()));
                }
                com.iab.omid.library.mmadbridge.adsession.b bVar = this.f36294a0;
                if (bVar != null) {
                    bVar.a(imageView, FriendlyObstructionPurpose.OTHER, null);
                }
            }
            this.P = new e(imageView, view);
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.P);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void a(View view, Class cls) {
        if (view == null) {
            return;
        }
        if (cls != null) {
            try {
                if (cls.isInstance(view)) {
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        view.setOnClickListener(null);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                a(viewGroup.getChildAt(i11), cls);
            }
        }
    }

    private void a(CampaignEx campaignEx, View view, List<View> list) {
        com.iab.omid.library.mmadbridge.adsession.b bVar;
        try {
            if (this.f36302h == null || campaignEx == null) {
                bVar = null;
            } else {
                bVar = a(campaignEx);
                if (bVar != null) {
                    bVar.d(view);
                    bVar.g();
                }
            }
            com.iab.omid.library.mmadbridge.adsession.b bVar2 = bVar;
            com.mbridge.msdk.setting.l lVar = this.Q;
            int s11 = lVar != null ? lVar.s() : 0;
            if (campaignEx != null && campaignEx.getImpReportType() == 1) {
                s11 = 0;
            }
            s sVar = new s(campaignEx, view, list, this, bVar2);
            if (this.F == null) {
                this.F = new CopyOnWriteArrayList<>();
            }
            this.F.add(sVar);
            sVar.setOnStateChangeListener(new j(sVar));
            Handler handler = this.f36384a;
            if (handler != null) {
                handler.postDelayed(sVar, s11 * 1000);
            }
        } catch (Exception e11) {
            o0.b(f36291c0, com.mbridge.msdk.mbnative.common.a.a(e11));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignEx campaignEx, View view, List<View> list, com.iab.omid.library.mmadbridge.adsession.b bVar) {
        try {
            k kVar = new k(campaignEx);
            com.mbridge.msdk.mbnative.controller.c cVar = new com.mbridge.msdk.mbnative.controller.c(list, kVar, new Handler(Looper.getMainLooper()), campaignEx.getImpReportType());
            cVar.a(view);
            List<com.mbridge.msdk.mbnative.controller.c> list2 = this.D;
            if (list2 != null) {
                list2.add(cVar);
            }
            List<c.d> list3 = this.E;
            if (list3 != null) {
                list3.add(kVar);
            }
            com.iab.omid.library.mmadbridge.adsession.a aVar = this.f36296b0;
            if (aVar != null) {
                aVar.b();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.mbridge.msdk.mbnative.listener.a aVar, String str, CampaignEx campaignEx) {
        this.f36384a.post(new b(aVar, campaignEx, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<Campaign> list, int i11, NativeListener.NativeAdListener nativeAdListener) {
        this.f36384a.post(new a(list, nativeAdListener, i11));
    }

    private void a(List<Campaign> list, o oVar) {
        c();
        long currentTimeMillis = System.currentTimeMillis();
        Timer timer = new Timer();
        this.M = timer;
        timer.schedule(new d(currentTimeMillis, oVar, list), 0L, 1000L);
    }

    private void a(boolean z10, int i11) {
        boolean z11;
        if (z10 && i11 == 1 && a(i11)) {
            return;
        }
        String b11 = com.mbridge.msdk.foundation.controller.c.m().b();
        String c11 = com.mbridge.msdk.foundation.controller.c.m().c();
        if (this.f36298d.containsKey("app_id") && this.f36298d.containsKey(MBridgeConstans.APP_KEY) && this.f36298d.containsKey(MBridgeConstans.KEY_WORD)) {
            b11 = (String) this.f36298d.get("app_id");
            c11 = (String) this.f36298d.get(MBridgeConstans.APP_KEY);
        }
        a(b11, c11);
        com.mbridge.msdk.setting.l e11 = com.mbridge.msdk.setting.h.b().e(b11, this.f36303i);
        this.Q = e11;
        if (e11 == null) {
            this.Q = com.mbridge.msdk.setting.l.i(this.f36303i);
        }
        com.mbridge.msdk.mbnative.controller.d.d().put(this.f36303i, Integer.valueOf(this.Q.y() * this.f36312r));
        this.f36295b = this.Q.b();
        this.f36297c = this.Q.c();
        this.T = this.Q.f();
        this.S = this.Q.e();
        this.f36312r = this.f36311q;
        List<Integer> list = this.f36295b;
        if (list == null || list.size() == 0) {
            com.mbridge.msdk.mbnative.listener.a aVar = this.f36300f;
            if (aVar != null) {
                this.f36316v = true;
                aVar.onAdLoadError("do not have sorceList");
                return;
            }
            return;
        }
        try {
            z11 = com.mbridge.msdk.mbsignalcommon.webEnvCheck.a.b(com.mbridge.msdk.foundation.controller.c.m().d());
        } catch (Exception unused) {
            z11 = false;
        }
        if (!z11) {
            com.mbridge.msdk.mbnative.listener.a aVar2 = this.f36300f;
            if (aVar2 != null) {
                aVar2.onAdLoadError("webview is not available");
                return;
            }
            return;
        }
        if (this.f36298d.containsKey(MBridgeConstans.NATIVE_INFO) && this.f36307m == null) {
            this.f36307m = (String) this.f36298d.get(MBridgeConstans.NATIVE_INFO);
            f();
        }
        if ((!this.f36295b.contains(1) || this.f36295b.get(0).intValue() == 1) && i11 == 0 && c(a(this.f36303i, this.f36312r, this.N))) {
            return;
        }
        this.X = true;
        if (this.f36295b.contains(1) && i11 == 0 && this.f36295b.get(0).intValue() != 1) {
            int intValue = this.f36295b.get(0).intValue();
            com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>> a11 = com.mbridge.msdk.mbnative.cache.c.a(intValue);
            if (intValue == 2 && this.f36298d.containsKey(MBridgeConstans.NATIVE_INFO)) {
                this.f36312r = this.H;
            } else {
                this.f36312r = this.f36311q;
            }
            if (a11 != null && c(a(intValue, a(a11.a((com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>>) this.f36303i, this.f36312r))))) {
                return;
            }
            this.X = false;
            try {
                a(this.f36297c.get(this.f36295b.indexOf(1)).intValue() * 1000, i11, false, this.f36303i, this.N);
            } catch (Exception unused2) {
            }
        }
        this.f36384a.sendEmptyMessageDelayed(1, this.Q.K() * 1000);
        j();
        b(i11, this.N);
    }

    private List<Campaign> b(List<Campaign> list) {
        ArrayList arrayList = null;
        if (list != null) {
            for (Campaign campaign : list) {
                if (campaign instanceof CampaignEx) {
                    CampaignEx campaignEx = (CampaignEx) campaign;
                    if (TextUtils.isEmpty(campaignEx.getImageUrl()) && !TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(campaign);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                if (campaignEx.needShowIDialog() && com.mbridge.msdk.util.b.a()) {
                    h hVar = new h(campaignEx);
                    if (com.mbridge.msdk.click.c.a(campaignEx) && campaignEx.needShowIDialog()) {
                        if (a(this.f36310p, context, campaignEx, this.f36303i, hVar)) {
                            return;
                        }
                        b(campaignEx);
                        this.f36300f.onAdClick(campaignEx);
                        return;
                    }
                }
            } catch (Throwable th2) {
                o0.a(f36291c0, th2.getMessage());
            }
        }
        this.f36310p.a(campaignEx, this.f36300f);
        b(campaignEx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CampaignEx campaignEx) {
        if (campaignEx == null || campaignEx.isReportClick()) {
            return;
        }
        campaignEx.setReportClick(true);
        if (campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().d() == null) {
            return;
        }
        com.mbridge.msdk.click.a.a(this.f36302h, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().d(), false, false);
    }

    public static boolean b(Map<String, Object> map) {
        if (map == null) {
            return false;
        }
        try {
            if (map.containsKey("app_id") && map.containsKey(MBridgeConstans.APP_KEY) && map.containsKey(MBridgeConstans.KEY_WORD)) {
                return map.get(MBridgeConstans.KEY_WORD) != null;
            }
            return false;
        } catch (Exception e11) {
            o0.b(f36291c0, com.mbridge.msdk.mbnative.common.a.a(e11));
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Timer timer = this.M;
        if (timer != null) {
            timer.cancel();
            this.M = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(List<Campaign> list) {
        if ((!TextUtils.isEmpty(this.N) && list != null && list.size() == 0) || list == null || list.size() <= 0) {
            return false;
        }
        com.mbridge.msdk.mbnative.listener.a aVar = this.f36300f;
        if (aVar == null) {
            return true;
        }
        CampaignEx campaignEx = (CampaignEx) list.get(0);
        if (campaignEx != null && campaignEx.isActiveOm()) {
            com.iab.omid.library.mmadbridge.adsession.b a11 = a(campaignEx);
            this.f36294a0 = a11;
            if (a11 != null) {
                a11.g();
                com.iab.omid.library.mmadbridge.adsession.a a12 = com.iab.omid.library.mmadbridge.adsession.a.a(this.f36294a0);
                this.f36296b0 = a12;
                a12.c();
            }
        }
        int template = campaignEx != null ? campaignEx.getTemplate() : 2;
        com.mbridge.msdk.foundation.db.j a13 = com.mbridge.msdk.foundation.db.j.a(com.mbridge.msdk.foundation.db.g.a(this.f36302h));
        a13.a();
        for (int i11 = 0; i11 < list.size(); i11++) {
            CampaignEx campaignEx2 = (CampaignEx) list.get(i11);
            if (!a13.a(campaignEx2.getId())) {
                com.mbridge.msdk.foundation.entity.g gVar = new com.mbridge.msdk.foundation.entity.g();
                gVar.a(campaignEx2.getId());
                gVar.b(campaignEx2.getFca());
                gVar.c(campaignEx2.getFcb());
                gVar.a(0);
                gVar.d(0);
                gVar.a(System.currentTimeMillis());
                a13.b(gVar);
            }
        }
        if (!this.L || !this.K) {
            if (list.size() <= 0) {
                a(aVar, "has no ads", (CampaignEx) null);
                return true;
            }
            Iterator<Campaign> it = list.iterator();
            while (it.hasNext()) {
                it.next().setVideoLength(0);
            }
            a(list, template, aVar);
            return true;
        }
        if (h().m() == 3) {
            List<Campaign> e11 = e(list);
            if (list.size() > 0) {
                a(list, new l(e11, template, aVar, list));
                return true;
            }
            a(aVar, "has no ads", (CampaignEx) null);
            return true;
        }
        List<Campaign> b11 = b(list);
        if (b11 == null || b11.size() <= 0) {
            a(list, template, aVar);
            return true;
        }
        a(b11, new m(list, template, aVar));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<CampaignEx> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    try {
                        int i11 = MBMediaView.f36710p0;
                        Object invoke = com.mbridge.msdk.videocommon.download.b.class.getMethod("getInstance", null).invoke(null, null);
                        if (invoke != null) {
                            com.mbridge.msdk.videocommon.download.b.class.getMethod("createUnitCache", Context.class, String.class, CopyOnWriteArrayList.class, Integer.TYPE, com.mbridge.msdk.videocommon.listener.a.class).invoke(invoke, this.f36302h, this.f36303i, new CopyOnWriteArrayList(list), 1, null);
                            com.mbridge.msdk.videocommon.download.b.class.getMethod(NativeImgComponent.EVENT_LOAD, String.class).invoke(invoke, this.f36303i);
                        }
                        Iterator<CampaignEx> it = list.iterator();
                        while (it.hasNext()) {
                            CampaignEx next = it.next();
                            if (next != null && !TextUtils.isEmpty(next.getImageUrl())) {
                                com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(next.getImageUrl(), new c());
                            }
                            String str = "";
                            if (next != null) {
                                try {
                                    str = next.getendcard_url();
                                } catch (Exception unused) {
                                }
                            }
                            com.mbridge.msdk.foundation.same.report.metrics.c cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
                            cVar.a(next);
                            if (!TextUtils.isEmpty(str)) {
                                cVar.f((next == null || next.getAabEntity() == null) ? 0 : next.getAabEntity().h3c);
                                if (str.contains(".zip") && str.contains(ResourceManager.KEY_MD5FILENAME)) {
                                    H5DownLoadManager.getInstance().downloadH5Res(cVar, str, new t(this.f36303i, next, TextUtils.isEmpty(H5DownLoadManager.getInstance().getH5ResAddress(str))));
                                } else {
                                    H5DownLoadManager.getInstance().downloadH5Res(cVar, str, new q(this.f36303i, next, TextUtils.isEmpty(HTMLResourceManager.getInstance().getHtmlContentFromUrl(str))));
                                }
                            }
                        }
                    } catch (Throwable unused2) {
                        o0.b(f36291c0, "please import the videocommon and nativex aar");
                    }
                }
            } catch (Throwable th2) {
                if (MBridgeConstans.DEBUG) {
                    th2.printStackTrace();
                }
            }
        }
    }

    private List<Campaign> e(List<Campaign> list) {
        if (list != null) {
            CampaignEx campaignEx = null;
            for (int size = list.size() - 1; size >= 0; size--) {
                try {
                    campaignEx = (CampaignEx) list.get(size);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                if (campaignEx != null && TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                    Campaign remove = list.remove(size);
                    com.mbridge.msdk.mbnative.cache.c.a(campaignEx.getType()).a(this.f36303i, remove, this.N);
                    o0.a(f36291c0, "remove no videoURL ads:" + remove);
                }
            }
        }
        return list;
    }

    private void f() {
        try {
            if (this.f36307m == null) {
                return;
            }
            JSONArray jSONArray = new JSONArray(this.f36307m);
            if (jSONArray.length() > 0) {
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.opt(i11);
                    int optInt = jSONObject.optInt("id", 0);
                    if (2 == optInt) {
                        this.V = jSONObject.optInt("ad_num");
                        if (this.T > 0) {
                            jSONObject.remove("ad_num");
                            jSONObject.put("ad_num", this.T);
                        }
                    } else if (3 == optInt) {
                        this.W = jSONObject.optInt("ad_num");
                        if (this.T > 0) {
                            jSONObject.remove("ad_num");
                            jSONObject.put("ad_num", this.T);
                        }
                    }
                }
            }
            this.H = Math.max(this.V, this.W);
            this.f36307m = jSONArray.toString();
        } catch (JSONException e11) {
            o0.b(f36291c0, com.mbridge.msdk.mbnative.common.a.a(e11));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.mbridge.msdk.setting.l h() {
        com.mbridge.msdk.setting.l e11 = com.mbridge.msdk.setting.h.b().e("", this.f36303i);
        this.Q = e11;
        if (e11 == null) {
            this.Q = com.mbridge.msdk.setting.l.i(this.f36303i);
        }
        return this.Q;
    }

    public List<Campaign> a(String str, int i11) {
        com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>> a11;
        com.mbridge.msdk.setting.l e11 = com.mbridge.msdk.setting.h.b().e("", str);
        this.Q = e11;
        if (e11 == null) {
            this.Q = com.mbridge.msdk.setting.l.i(str);
        }
        List<Integer> b11 = this.Q.b();
        this.f36295b = b11;
        if (b11 == null || b11.size() <= 0 || !this.f36295b.contains(1) || (a11 = com.mbridge.msdk.mbnative.cache.c.a(1)) == null) {
            return null;
        }
        return a11.a((com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>>) str, i11);
    }

    public List<Campaign> a(String str, int i11, String str2) {
        List<Campaign> list = null;
        if (this.f36295b != null) {
            ArrayList arrayList = new ArrayList(this.f36295b);
            for (int i12 = 0; i12 < arrayList.size(); i12++) {
                com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>> a11 = com.mbridge.msdk.mbnative.cache.c.a(((Integer) arrayList.get(i12)).intValue());
                if (a11 != null) {
                    list = a(((Integer) arrayList.get(i12)).intValue(), a11.a((com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>>) str, ((((Integer) arrayList.get(i12)).intValue() == 1 || ((Integer) arrayList.get(i12)).intValue() == 2) && this.f36298d.containsKey(MBridgeConstans.NATIVE_INFO)) ? this.H : this.f36311q));
                    if (list != null) {
                        break;
                    }
                }
            }
            if (list == null) {
                for (int i13 = 0; i13 < arrayList.size(); i13++) {
                    list = a(((Integer) arrayList.get(i13)).intValue(), com.mbridge.msdk.mbnative.cache.c.a(((Integer) arrayList.get(i13)).intValue()).b(str, ((((Integer) arrayList.get(i13)).intValue() == 1 || ((Integer) arrayList.get(i13)).intValue() == 2) && this.f36298d.containsKey(MBridgeConstans.NATIVE_INFO)) ? this.H : this.f36311q));
                    if (list != null) {
                        break;
                    }
                }
            }
        }
        return a(list);
    }

    @Override // com.mbridge.msdk.mbnative.controller.a
    public synchronized void a(int i11, long j11, int i12, String str) {
        n nVar;
        com.mbridge.msdk.foundation.same.net.wrapper.e eVar;
        com.mbridge.msdk.mbnative.service.net.a aVar;
        p pVar;
        int i13;
        com.mbridge.msdk.foundation.entity.k kVar;
        try {
            try {
                if (this.f36298d.containsKey(MBridgeConstans.NATIVE_INFO)) {
                    this.f36312r = Math.max(this.V, this.W);
                }
                if (i12 == 0) {
                    com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>> a11 = com.mbridge.msdk.mbnative.cache.c.a(i11);
                    if (a11 != null && c(a(1, a(a11.a((com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>>) this.f36303i, this.f36312r))))) {
                        return;
                    }
                    n nVar2 = this.J;
                    if (nVar2 != null && !this.U) {
                        nVar2.b(true);
                    }
                    if (this.U && !this.f36316v) {
                        a("mb load failed", i12, str, (CampaignEx) null);
                    }
                    if (!this.X) {
                        return;
                    }
                }
                int i14 = this.f36313s;
                if (i14 == -1) {
                    this.f36313s = i11;
                } else if (i14 != i11) {
                    this.f36314t = 0;
                }
                com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(this.f36302h)).a();
                com.mbridge.msdk.mbnative.service.net.a aVar2 = new com.mbridge.msdk.mbnative.service.net.a(this.f36302h);
                com.mbridge.msdk.foundation.same.net.wrapper.e eVar2 = new com.mbridge.msdk.foundation.same.net.wrapper.e();
                String b11 = com.mbridge.msdk.foundation.controller.c.m().b();
                String c11 = com.mbridge.msdk.foundation.controller.c.m().c();
                Map<String, Object> map = this.f36298d;
                if (map != null && map.containsKey("app_id") && this.f36298d.containsKey(MBridgeConstans.APP_KEY) && this.f36298d.containsKey(MBridgeConstans.KEY_WORD) && this.f36298d.get(MBridgeConstans.KEY_WORD) != null) {
                    if (this.f36298d.get("app_id") instanceof String) {
                        b11 = (String) this.f36298d.get("app_id");
                    }
                    if (this.f36298d.get(MBridgeConstans.APP_KEY) instanceof String) {
                        c11 = (String) this.f36298d.get(MBridgeConstans.APP_KEY);
                    }
                    String str2 = this.f36298d.get(MBridgeConstans.KEY_WORD) instanceof String ? (String) this.f36298d.get(MBridgeConstans.KEY_WORD) : null;
                    if (!TextUtils.isEmpty(str2)) {
                        eVar2.a("smart", i0.b(str2));
                    }
                }
                eVar2.a("app_id", b11);
                eVar2.a(MBridgeConstans.PROPERTIES_UNIT_ID, this.f36303i);
                if (!TextUtils.isEmpty(this.f36304j)) {
                    eVar2.a(MBridgeConstans.PLACEMENT_ID, this.f36304j);
                }
                eVar2.a("req_type", "2");
                if (!TextUtils.isEmpty(this.f36315u)) {
                    eVar2.a("category", this.f36315u);
                }
                eVar2.a(TmcConstants.EXTRA_APP_DEV_TOKEN, SameMD5.getMD5(b11 + c11));
                if (this.T <= 0 || i12 != 0) {
                    eVar2.a("ad_num", this.f36311q + "");
                } else {
                    eVar2.a("ad_num", this.T + "");
                }
                String d11 = t0.d(this.f36303i);
                if (!TextUtils.isEmpty(d11)) {
                    eVar2.a(com.mbridge.msdk.foundation.same.report.j.f35620b, d11);
                }
                eVar2.a("only_impression", "1");
                eVar2.a("ping_mode", "1");
                if (this.A != 0) {
                    eVar2.a("frame_num", this.A + "");
                }
                if (!TextUtils.isEmpty(this.f36307m)) {
                    eVar2.a(MBridgeConstans.NATIVE_INFO, this.f36307m);
                    if (i11 == 1) {
                        eVar2.a("tnum", this.H + "");
                    }
                } else if (i11 == 1) {
                    eVar2.a("tnum", this.f36311q + "");
                }
                a(eVar2, i11);
                String a12 = com.mbridge.msdk.foundation.same.buffer.b.a(this.f36303i, "native");
                if (!TextUtils.isEmpty(a12)) {
                    eVar2.a(com.mbridge.msdk.foundation.same.net.wrapper.e.f35554g, a12);
                }
                if (this.f36298d.containsKey(MBridgeConstans.NATIVE_VIDEO_WIDTH) && (this.f36298d.get(MBridgeConstans.NATIVE_VIDEO_WIDTH) instanceof Integer)) {
                    eVar2.a("video_width", ((Integer) this.f36298d.get(MBridgeConstans.NATIVE_VIDEO_WIDTH)).intValue() + "");
                }
                if (this.f36298d.containsKey(MBridgeConstans.NATIVE_VIDEO_HEIGHT) && (this.f36298d.get(MBridgeConstans.NATIVE_VIDEO_HEIGHT) instanceof Integer)) {
                    eVar2.a("video_height", ((Integer) this.f36298d.get(MBridgeConstans.NATIVE_VIDEO_HEIGHT)).intValue() + "");
                }
                if (this.f36298d.containsKey(MBridgeConstans.NATIVE_VIDEO_SUPPORT) && (this.f36298d.get(MBridgeConstans.NATIVE_VIDEO_SUPPORT) instanceof Boolean)) {
                    ((Boolean) this.f36298d.get(MBridgeConstans.NATIVE_VIDEO_SUPPORT)).booleanValue();
                }
                eVar2.a("video_version", MBridgeConstans.NATIVE_VIDEO_VERSION);
                if (com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b()) == null) {
                    com.mbridge.msdk.setting.h.b().a();
                }
                if (!b(this.f36298d)) {
                    JSONArray b12 = t0.b(this.f36302h, this.f36303i);
                    if (b12.length() > 0) {
                        eVar2.a(com.mbridge.msdk.foundation.same.net.wrapper.e.f35555h, t0.a(b12));
                    }
                }
                if (com.mbridge.msdk.mbnative.controller.d.g().containsKey(this.f36303i) && com.mbridge.msdk.mbnative.controller.d.g().get(this.f36303i).booleanValue() && com.mbridge.msdk.mbnative.controller.d.e().get(this.f36303i) != null && (kVar = com.mbridge.msdk.mbnative.controller.d.e().get(this.f36303i)) != null) {
                    if (i11 == 1) {
                        this.f36314t = kVar.a();
                    } else if (i11 == 2) {
                        this.f36314t = kVar.b();
                    }
                }
                eVar2.a("offset", this.f36314t + "");
                eVar2.a("ad_type", "42");
                eVar2.a(CampaignEx.JSON_KEY_AD_SOURCE_ID, i11 + "");
                if (!TextUtils.isEmpty(this.f36309o)) {
                    eVar2.a(com.mbridge.msdk.foundation.same.net.wrapper.e.f35556i, this.f36309o);
                }
                n nVar3 = new n();
                nVar3.b(a(this.f36298d));
                nVar3.setUnitId(this.f36303i);
                nVar3.setPlacementId(this.f36304j);
                nVar3.setAdType(42);
                nVar3.b(true);
                p pVar2 = new p(1, nVar3, i12, str);
                nVar3.a(pVar2);
                nVar3.a(i12);
                nVar3.a(str);
                if (i12 == 0) {
                    if (!TextUtils.isEmpty(str)) {
                        eVar2.a("token", str);
                    }
                    nVar = nVar3;
                    eVar = eVar2;
                    aVar = aVar2;
                    pVar = pVar2;
                    i13 = 1;
                    aVar2.choiceV3OrV5BySetting(1, eVar, nVar, str, com.mbridge.msdk.foundation.same.c.a(j11, 30000L));
                } else {
                    nVar = nVar3;
                    eVar = eVar2;
                    aVar = aVar2;
                    pVar = pVar2;
                    i13 = 1;
                }
                if (i12 == i13) {
                    aVar.getLoadOrSetting(1, com.mbridge.msdk.foundation.same.net.utils.d.h().f35519b0, eVar, nVar, MBInterstitialActivity.INTENT_CAMAPIGN, com.mbridge.msdk.foundation.same.c.a(j11, 30000L));
                }
                this.f36384a.postDelayed(pVar, j11);
            } catch (Exception e11) {
                String str3 = f36291c0;
                o0.b(str3, com.mbridge.msdk.mbnative.common.a.a(e11));
                o0.b(str3, e11.getMessage());
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void a(int i11, String str) {
        boolean z10 = false;
        this.f36316v = false;
        this.f36317w = false;
        this.f36318x = false;
        this.U = false;
        this.N = str;
        this.f36300f.a(!TextUtils.isEmpty(str));
        this.J = null;
        Map<String, Long> map = f36292d0;
        if (map != null && map.size() > 0) {
            f36292d0.clear();
        }
        if (com.mbridge.msdk.mbnative.controller.d.g() != null && com.mbridge.msdk.mbnative.controller.d.g().containsKey(this.f36303i)) {
            z10 = Boolean.TRUE.equals(com.mbridge.msdk.mbnative.controller.d.g().get(this.f36303i));
        }
        a(z10, i11);
    }

    public void a(Campaign campaign, View view) {
        try {
            NativeListener.NativeTrackingListener nativeTrackingListener = this.f36301g;
            if (nativeTrackingListener != null) {
                this.f36310p.a(nativeTrackingListener);
            }
            com.mbridge.msdk.mbnative.cache.c.a(campaign.getType()).a(this.f36303i, campaign, this.N);
            CampaignEx campaignEx = (CampaignEx) campaign;
            com.mbridge.msdk.foundation.same.buffer.b.a(this.f36303i, campaignEx, "native");
            i iVar = new i(campaignEx);
            try {
                int i11 = MBMediaView.f36710p0;
                a(view, iVar, MBMediaView.class);
            } catch (Throwable unused) {
                a(view, iVar, (Class) null);
            }
            if (!com.mbridge.msdk.util.b.a()) {
                a(view, (CampaignEx) campaign);
            }
            if (campaignEx.isReport()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(view);
            a(campaignEx, view, (List<View>) arrayList);
            o0.c(f36291c0, "sendImpression" + campaignEx);
        } catch (Exception unused2) {
            o0.b(f36291c0, "registerview exception!");
        }
    }

    public void a(Campaign campaign, View view, List<View> list) {
        Class<MBMediaView> cls;
        try {
            a(view, (CampaignEx) campaign);
            NativeListener.NativeTrackingListener nativeTrackingListener = this.f36301g;
            if (nativeTrackingListener != null) {
                this.f36310p.a(nativeTrackingListener);
            }
            com.mbridge.msdk.mbnative.cache.c.a(campaign.getType()).a(this.f36303i, campaign, this.N);
            CampaignEx campaignEx = (CampaignEx) campaign;
            try {
                cls = MBMediaView.class;
                int i11 = MBMediaView.f36710p0;
            } catch (Throwable unused) {
                cls = null;
            }
            com.mbridge.msdk.foundation.same.buffer.b.a(this.f36303i, campaignEx, "native");
            if (view != null) {
                if (cls != null && cls.isInstance(view)) {
                    return;
                } else {
                    view.setOnClickListener(new f(campaignEx));
                }
            }
            if (list != null && list.size() > 0) {
                for (View view2 : list) {
                    if (cls != null && cls.isInstance(view2)) {
                        break;
                    } else {
                        view2.setOnClickListener(new g(campaignEx));
                    }
                }
            }
            if (campaignEx.isReport()) {
                return;
            }
            a(campaignEx, view, list);
            Log.e(f36291c0, "sendImpression" + campaignEx);
        } catch (Exception unused2) {
            o0.b(f36291c0, "registerview exception!");
        }
    }

    public void a(String str, int i11, String str2, CampaignEx campaignEx) {
        Queue<Integer> queue = this.f36305k;
        if ((queue == null || queue.size() > 0) && this.f36305k != null) {
            b(i11, str2);
            return;
        }
        com.mbridge.msdk.mbnative.listener.a aVar = this.f36300f;
        if (aVar == null || this.f36316v) {
            return;
        }
        this.f36316v = true;
        aVar.a(campaignEx, str);
    }

    public void a(String str, String str2) {
        this.f36299e.a(this.f36302h, str, str2, this.f36303i);
    }

    public boolean a(int i11) {
        int i12;
        int i13;
        int i14;
        com.mbridge.msdk.mbnative.listener.a aVar;
        int i15 = 0;
        if (com.mbridge.msdk.mbnative.controller.d.g().containsKey(this.f36303i) && Boolean.TRUE.equals(com.mbridge.msdk.mbnative.controller.d.g().get(this.f36303i))) {
            Map<String, Map<Long, Object>> f11 = com.mbridge.msdk.mbnative.controller.d.f();
            Map<Long, Object> map = f11.get(i11 + "_" + this.f36303i);
            Integer num = com.mbridge.msdk.mbnative.controller.d.c().get(this.f36303i);
            com.mbridge.msdk.setting.g d11 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            if (num != null) {
                this.f36312r = num.intValue();
            }
            if (map != null && map.size() > 0) {
                Long next = map.keySet().iterator().next();
                long currentTimeMillis = System.currentTimeMillis();
                if (d11 == null) {
                    d11 = com.mbridge.msdk.setting.h.b().a();
                }
                if (currentTimeMillis - next.longValue() >= d11.Z() * 1000) {
                    f11.remove(i11 + "_" + this.f36303i);
                } else {
                    if (i11 == 1) {
                        List<Frame> list = (List) map.get(next);
                        if (list == null || list.size() <= 0 || (aVar = this.f36300f) == null) {
                            return false;
                        }
                        if (this.A >= list.size()) {
                            f11.remove(i11 + "_" + this.f36303i);
                            aVar.onAdFramesLoaded(list);
                            return true;
                        }
                        if (this.A == 0) {
                            return false;
                        }
                        List<Frame> subList = list.subList(0, this.f36320z);
                        aVar.onAdFramesLoaded(list);
                        list.removeAll(subList);
                        map.put(next, subList);
                        ArrayList arrayList = new ArrayList();
                        for (Frame frame : list) {
                            if (i15 >= this.A) {
                                arrayList.add(frame);
                            }
                            i15++;
                        }
                        map.put(next, arrayList);
                        f11.put(i11 + "_" + this.f36303i, map);
                        aVar.onAdFramesLoaded(subList);
                        return true;
                    }
                    List list2 = (List) map.get(next);
                    if (list2 != null && list2.size() > 0) {
                        List<Campaign> arrayList2 = new ArrayList<>();
                        if (((CampaignEx) list2.get(0)).getType() == 1) {
                            if (TextUtils.isEmpty(this.f36307m)) {
                                i12 = Math.min(this.f36319y, list2.size());
                            } else {
                                try {
                                    JSONArray jSONArray = new JSONArray(this.f36307m);
                                    if (jSONArray.length() > 0) {
                                        i13 = 0;
                                        i14 = 0;
                                        for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                                            JSONObject jSONObject = (JSONObject) jSONArray.opt(i16);
                                            int optInt = jSONObject.optInt("id", 0);
                                            if (2 == optInt) {
                                                i13 = jSONObject.optInt("ad_num");
                                            } else if (3 == optInt) {
                                                i14 = jSONObject.optInt("ad_num");
                                            }
                                        }
                                    } else {
                                        i13 = 0;
                                        i14 = 0;
                                    }
                                    i12 = 3 == ((CampaignEx) list2.get(0)).getTemplate() ? Math.min(i14, list2.size()) : Math.min(i13, list2.size());
                                } catch (Exception unused) {
                                    o0.b(f36291c0, "load from catch error in get nativeinfo adnum");
                                    i12 = 0;
                                }
                            }
                            if (i12 <= 0) {
                                return false;
                            }
                            Iterator it = list2.iterator();
                            while (it.hasNext() && i15 != i12) {
                                CampaignEx campaignEx = (CampaignEx) it.next();
                                campaignEx.getTemplate();
                                arrayList2.add(campaignEx);
                                it.remove();
                                i15++;
                            }
                        } else {
                            int min = Math.min(this.f36319y, list2.size());
                            if (min > 0) {
                                Iterator it2 = list2.iterator();
                                while (it2.hasNext() && i15 != min) {
                                    CampaignEx campaignEx2 = (CampaignEx) it2.next();
                                    campaignEx2.getTemplate();
                                    arrayList2.add(campaignEx2);
                                    it2.remove();
                                    i15++;
                                }
                            }
                        }
                        c(arrayList2);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void b(int i11, long j11, int i12, String str) {
        com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>> a11;
        if (i12 == 0 && (a11 = com.mbridge.msdk.mbnative.cache.c.a(i11)) != null) {
            if ((i11 == 1 || i11 == 2) && this.f36298d.containsKey(MBridgeConstans.NATIVE_INFO)) {
                this.f36312r = this.H;
            } else {
                this.f36312r = this.f36311q;
            }
            if (c(a(i11, a(a11.a((com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>>) this.f36303i, this.f36312r))))) {
                return;
            }
        }
        if (i11 == 1) {
            a(j11, i12, true, this.f36303i, str);
        } else if (i11 != 2) {
            a(i11, j11, i12, str);
        } else {
            a(2, j11, i12, str);
        }
    }

    public void b(int i11, String str) {
        com.mbridge.msdk.mbnative.listener.a aVar;
        Long poll;
        Queue<Integer> queue = this.f36305k;
        if (queue == null || queue.size() <= 0) {
            if (this.f36316v || (aVar = this.f36300f) == null) {
                return;
            }
            this.f36316v = true;
            aVar.onAdLoadError("no ad source");
            return;
        }
        Integer poll2 = this.f36305k.poll();
        int intValue = poll2 != null ? poll2.intValue() : 1;
        this.R = MBridgeConstans.REQUEST_TIME_OUT;
        Queue<Long> queue2 = this.f36306l;
        if (queue2 != null && queue2.size() > 0 && (poll = this.f36306l.poll()) != null) {
            this.R = poll.longValue();
        }
        b(intValue, this.R, i11, str);
    }

    public void b(Campaign campaign, View view) {
        b(campaign, view, null);
    }

    public void b(Campaign campaign, View view, List<View> list) {
        Class<MBMediaView> cls;
        if (view != null && this.P != null) {
            try {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this.P);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        if (campaign != null) {
            int type = campaign.getType();
            if (type == 1 || type == 2) {
                try {
                    cls = MBMediaView.class;
                    int i11 = MBMediaView.f36710p0;
                } catch (Throwable unused) {
                    cls = null;
                }
                if (list == null || list.size() <= 0) {
                    if (view != null) {
                        a(view, cls);
                    }
                } else {
                    Iterator<View> it = list.iterator();
                    while (it.hasNext()) {
                        a(it.next(), cls);
                    }
                }
            }
        }
    }

    public void d() {
        m0.b();
    }

    public String e() {
        ArrayList arrayList = new ArrayList();
        List<Campaign> list = this.Y;
        if (list != null) {
            for (Campaign campaign : list) {
                CampaignEx campaignEx = new CampaignEx();
                campaignEx.setCreativeId(campaign.getCreativeId());
                arrayList.add(campaignEx);
            }
        }
        return com.mbridge.msdk.foundation.same.c.b(arrayList);
    }

    public String g() {
        return this.O;
    }

    public void i() {
        com.mbridge.msdk.foundation.same.task.a next;
        com.mbridge.msdk.foundation.same.task.b bVar = this.C;
        if (bVar != null) {
            bVar.a();
            this.C = null;
        }
        Hashtable<String, com.iab.omid.library.mmadbridge.adsession.b> hashtable = this.G;
        if (hashtable != null) {
            for (com.iab.omid.library.mmadbridge.adsession.b bVar2 : hashtable.values()) {
                if (bVar2 != null) {
                    bVar2.c();
                }
            }
            this.G.clear();
        }
        Handler handler = this.f36384a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.f36301g = null;
        this.f36310p.c();
        try {
            Context context = this.f36302h;
            if (context != null) {
                com.mbridge.msdk.foundation.same.image.b.a(context).b();
            }
            List<com.mbridge.msdk.mbnative.controller.c> list = this.D;
            if (list != null && list.size() > 0) {
                Iterator<com.mbridge.msdk.mbnative.controller.c> it = this.D.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
                this.D.clear();
                this.D = null;
            }
            List<c.d> list2 = this.E;
            if (list2 != null && list2.size() > 0) {
                for (c.d dVar : this.E) {
                }
                this.E.clear();
                this.E = null;
            }
            CopyOnWriteArrayList<com.mbridge.msdk.foundation.same.task.a> copyOnWriteArrayList = this.F;
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                return;
            }
            Iterator<com.mbridge.msdk.foundation.same.task.a> it2 = this.F.iterator();
            if (it2.hasNext() && (next = it2.next()) != null) {
                next.cancel();
                this.f36384a.removeCallbacks(next);
            }
            this.F.clear();
        } catch (Exception unused) {
        }
    }

    public void j() {
        List<Integer> list = this.f36295b;
        if (list != null && list.size() > 0) {
            Queue<Integer> queue = this.f36305k;
            if (queue != null && queue.size() > 0) {
                this.f36305k.clear();
            }
            for (Integer num : this.f36295b) {
                Queue<Integer> queue2 = this.f36305k;
                if (queue2 != null) {
                    queue2.add(num);
                }
            }
        }
        List<Integer> list2 = this.f36297c;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        Queue<Long> queue3 = this.f36306l;
        if (queue3 != null && queue3.size() > 0) {
            this.f36306l.clear();
        }
        for (Integer num2 : this.f36297c) {
            Queue<Long> queue4 = this.f36306l;
            if (queue4 != null) {
                queue4.add(Long.valueOf(num2.intValue() * 1000));
            }
        }
    }
}

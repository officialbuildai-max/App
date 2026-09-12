package com.mbridge.msdk.reward.player;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.iab.omid.library.mmadbridge.adsession.FriendlyObstructionPurpose;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.out.MBSupportMuteAdType;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.reward.adapter.RewardUnitCacheManager;
import com.mbridge.msdk.scheme.applet.AppletModelManager;
import com.mbridge.msdk.video.bt.module.MBTempContainer;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;
import com.mbridge.msdk.video.bt.module.orglistener.h;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.signal.activity.AbstractJSActivity;
import com.mbridge.msdk.video.signal.impl.k;
import com.mbridge.msdk.videocommon.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class MBRewardVideoActivity extends AbstractJSActivity {
    public static String INTENT_EXTRADATA = "extraData";
    public static String INTENT_ISBID = "isBid";
    public static String INTENT_ISBIG_OFFER = "isBigOffer";
    public static String INTENT_ISIV = "isIV";
    public static String INTENT_IVREWARD_MODETYPE = "ivRewardMode";
    public static String INTENT_IVREWARD_VALUE = "ivRewardValue";
    public static String INTENT_IVREWARD_VALUETYPE = "ivRewardValueType";
    public static String INTENT_LOCAL_REQUEST_ID = "lRid";
    public static String INTENT_MUTE = "mute";
    public static String INTENT_REWARD = "reward";
    public static String INTENT_UNITID = "unitId";
    public static String INTENT_USERID = "userId";
    public static String SAVE_STATE_KEY_REPORT = "hasRelease";
    private MBridgeBTContainer A;
    private WindVaneWebView B;
    private com.mbridge.msdk.video.bt.module.listener.a C;
    private String D;
    private String E;
    private boolean F;
    private String N;
    private com.mbridge.msdk.foundation.same.report.metrics.c O;
    private boolean Q;

    /* renamed from: f, reason: collision with root package name */
    private String f37217f;

    /* renamed from: g, reason: collision with root package name */
    private String f37218g;

    /* renamed from: h, reason: collision with root package name */
    private String f37219h;

    /* renamed from: i, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.entity.c f37220i;

    /* renamed from: m, reason: collision with root package name */
    private int f37224m;

    /* renamed from: n, reason: collision with root package name */
    private int f37225n;

    /* renamed from: o, reason: collision with root package name */
    private int f37226o;

    /* renamed from: r, reason: collision with root package name */
    private h f37229r;

    /* renamed from: s, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.setting.c f37230s;

    /* renamed from: v, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.download.a f37233v;

    /* renamed from: w, reason: collision with root package name */
    private CampaignEx f37234w;

    /* renamed from: x, reason: collision with root package name */
    private List<com.mbridge.msdk.videocommon.download.a> f37235x;

    /* renamed from: y, reason: collision with root package name */
    private List<CampaignEx> f37236y;

    /* renamed from: z, reason: collision with root package name */
    private MBTempContainer f37237z;

    /* renamed from: j, reason: collision with root package name */
    private int f37221j = 2;

    /* renamed from: k, reason: collision with root package name */
    private boolean f37222k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f37223l = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f37227p = false;

    /* renamed from: q, reason: collision with root package name */
    private boolean f37228q = false;

    /* renamed from: t, reason: collision with root package name */
    private boolean f37231t = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f37232u = false;
    private int G = 1;
    private int H = 0;
    private int I = 0;
    private int J = 0;
    private int K = 0;
    private int L = 0;
    private int M = 0;
    private boolean P = false;
    private com.iab.omid.library.mmadbridge.adsession.b R = null;
    private com.iab.omid.library.mmadbridge.adsession.media.a S = null;
    private com.iab.omid.library.mmadbridge.adsession.a T = null;
    private long U = 0;
    private String V = "";
    private Boolean W = null;
    private int X = 0;
    private boolean Y = false;
    private boolean Z = false;

    /* renamed from: a0, reason: collision with root package name */
    private com.mbridge.msdk.video.dynview.listener.a f37215a0 = new a();

    /* renamed from: b0, reason: collision with root package name */
    private com.mbridge.msdk.video.dynview.listener.d f37216b0 = new b();

    /* loaded from: classes5.dex */
    class a implements com.mbridge.msdk.video.dynview.listener.a {
        a() {
        }

        @Override // com.mbridge.msdk.video.dynview.listener.a
        public void a(Map<String, Object> map) {
            if (map == null) {
                return;
            }
            if (map.containsKey(CampaignEx.JSON_NATIVE_VIDEO_MUTE)) {
                MBRewardVideoActivity.this.f37221j = ((Integer) map.get(CampaignEx.JSON_NATIVE_VIDEO_MUTE)).intValue();
            }
            if (map.containsKey(RequestParameters.POSITION)) {
                int intValue = ((Integer) map.get(RequestParameters.POSITION)).intValue();
                if (MBRewardVideoActivity.this.f37236y == null || MBRewardVideoActivity.this.f37236y.size() <= 0 || intValue < 1) {
                    return;
                }
                MBRewardVideoActivity mBRewardVideoActivity = MBRewardVideoActivity.this;
                mBRewardVideoActivity.f37234w = (CampaignEx) mBRewardVideoActivity.f37236y.get(intValue);
                MBRewardVideoActivity.m(MBRewardVideoActivity.this);
                int i11 = intValue - 1;
                if (MBRewardVideoActivity.this.f37236y.get(i11) != null) {
                    MBRewardVideoActivity mBRewardVideoActivity2 = MBRewardVideoActivity.this;
                    MBRewardVideoActivity.b(mBRewardVideoActivity2, ((CampaignEx) mBRewardVideoActivity2.f37236y.get(i11)).getVideoLength());
                }
                MBRewardVideoActivity mBRewardVideoActivity3 = MBRewardVideoActivity.this;
                MBRewardVideoActivity.this.f37234w.setVideoCompleteTime(mBRewardVideoActivity3.a(mBRewardVideoActivity3.f37234w.getVideoCompleteTime(), MBRewardVideoActivity.this.G));
                MBRewardVideoActivity.this.f37234w.setShowIndex(MBRewardVideoActivity.this.G);
                MBRewardVideoActivity.this.f37234w.setShowType(1);
                MBRewardVideoActivity mBRewardVideoActivity4 = MBRewardVideoActivity.this;
                mBRewardVideoActivity4.c(mBRewardVideoActivity4.f37234w);
            }
        }
    }

    /* loaded from: classes5.dex */
    class b implements com.mbridge.msdk.video.dynview.listener.d {
        b() {
        }

        @Override // com.mbridge.msdk.video.dynview.listener.d
        public void a() {
            if (MBRewardVideoActivity.this.A != null) {
                new com.mbridge.msdk.video.dynview.ui.b().b(MBRewardVideoActivity.this.A, 500L);
            }
            MBRewardVideoActivity.this.f37227p = true;
            MBRewardVideoActivity.this.j();
            if (MBRewardVideoActivity.this.f37237z != null) {
                MBRewardVideoActivity.this.f37237z.setNotchPadding(MBRewardVideoActivity.this.M, MBRewardVideoActivity.this.I, MBRewardVideoActivity.this.K, MBRewardVideoActivity.this.J, MBRewardVideoActivity.this.L);
            }
        }

        @Override // com.mbridge.msdk.video.dynview.listener.d
        public void a(CampaignEx campaignEx) {
            if (campaignEx == null) {
                MBRewardVideoActivity.this.b("campaign is null");
                return;
            }
            if (MBRewardVideoActivity.this.A != null) {
                new com.mbridge.msdk.video.dynview.ui.b().b(MBRewardVideoActivity.this.A, 500L);
            }
            MBRewardVideoActivity.this.f37234w = campaignEx;
            MBRewardVideoActivity.this.f37234w.setShowType(2);
            MBRewardVideoActivity mBRewardVideoActivity = MBRewardVideoActivity.this;
            mBRewardVideoActivity.c(mBRewardVideoActivity.f37234w);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements com.mbridge.msdk.video.bt.module.listener.a {
        c() {
        }

        @Override // com.mbridge.msdk.video.bt.module.listener.a
        public void a() {
            if (MBRewardVideoActivity.this.f37229r != null) {
                MBRewardVideoActivity.this.f37229r.a(MBRewardVideoActivity.this.O);
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.listener.a
        public void a(int i11, String str, String str2) {
            if (MBRewardVideoActivity.this.f37229r != null) {
                MBRewardVideoActivity.this.f37229r.a(i11, str, str2);
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.listener.a
        public void a(String str) {
            if (MBRewardVideoActivity.this.f37229r != null) {
                MBRewardVideoActivity.this.f37229r.a(MBRewardVideoActivity.this.O, str);
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.listener.a
        public void a(String str, String str2) {
            if (MBRewardVideoActivity.this.f37229r != null) {
                MBRewardVideoActivity.this.f37229r.a(str, str2);
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.listener.a
        public void a(boolean z10, int i11) {
            if (MBRewardVideoActivity.this.f37229r != null) {
                MBRewardVideoActivity.this.f37229r.a(z10, i11);
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.listener.a
        public void a(boolean z10, com.mbridge.msdk.videocommon.entity.c cVar) {
            if (MBRewardVideoActivity.this.f37229r != null) {
                MBRewardVideoActivity.this.f37229r.a(MBRewardVideoActivity.this.O, z10, cVar);
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.listener.a
        public void a(boolean z10, String str, String str2) {
            if (MBRewardVideoActivity.this.f37229r != null) {
                MBRewardVideoActivity.this.f37229r.a(z10, str, str2);
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.listener.a
        public void b(String str, String str2) {
            if (MBRewardVideoActivity.this.f37229r != null) {
                MBRewardVideoActivity.this.f37229r.b(str, str2);
            }
        }
    }

    /* loaded from: classes5.dex */
    class d implements com.mbridge.msdk.foundation.feedback.a {
        d() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
            MBRewardVideoActivity.this.onPause();
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            MBRewardVideoActivity.this.onResume();
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            MBRewardVideoActivity.this.onResume();
        }
    }

    /* loaded from: classes5.dex */
    private static final class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final List<com.mbridge.msdk.videocommon.download.a> f37242a;

        /* renamed from: b, reason: collision with root package name */
        private final String f37243b;

        /* renamed from: c, reason: collision with root package name */
        private final String f37244c;

        public e(List<com.mbridge.msdk.videocommon.download.a> list, String str, String str2) {
            this.f37242a = list;
            this.f37243b = str;
            this.f37244c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                List<com.mbridge.msdk.videocommon.download.a> list = this.f37242a;
                if (list == null || list.size() <= 0) {
                    return;
                }
                for (com.mbridge.msdk.videocommon.download.a aVar : this.f37242a) {
                    if (aVar != null && aVar.c() != null) {
                        CampaignEx c11 = aVar.c();
                        try {
                            AppletModelManager.getInstance().remove(c11);
                        } catch (Exception e11) {
                            if (MBridgeConstans.DEBUG) {
                                o0.b("MBRewardVideoActivity", "AppletModelManager remove error", e11);
                            }
                        }
                        com.mbridge.msdk.videocommon.download.b.getInstance().c(this.f37243b, c11.getRequestId() + c11.getId() + c11.getVideoUrlEncode());
                        if (c11.getRewardTemplateMode() != null) {
                            if (!TextUtils.isEmpty(c11.getRewardTemplateMode().e())) {
                                com.mbridge.msdk.videocommon.a.e(this.f37243b + "_" + c11.getId() + "_" + this.f37244c + "_" + c11.getRewardTemplateMode().e());
                                com.mbridge.msdk.videocommon.a.b(c11.getAdType(), c11);
                            }
                            if (!TextUtils.isEmpty(c11.getCMPTEntryUrl())) {
                                com.mbridge.msdk.videocommon.a.e(this.f37243b + "_" + this.f37244c + "_" + c11.getCMPTEntryUrl());
                            }
                            com.mbridge.msdk.videocommon.cache.a.a().a(this.f37243b, c11);
                        }
                    }
                }
            } catch (Exception e12) {
                o0.a("MBRewardVideoActivity", e12.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final List<com.mbridge.msdk.videocommon.download.a> f37245a;

        /* renamed from: b, reason: collision with root package name */
        private final String f37246b;

        public f(String str, List<com.mbridge.msdk.videocommon.download.a> list) {
            this.f37245a = list;
            this.f37246b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                List<com.mbridge.msdk.videocommon.download.a> list = this.f37245a;
                if (list == null || list.size() <= 0) {
                    return;
                }
                for (com.mbridge.msdk.videocommon.download.a aVar : this.f37245a) {
                    if (aVar != null && aVar.c() != null) {
                        com.mbridge.msdk.videocommon.cache.a.a().a(aVar.c(), this.f37246b);
                    }
                }
            } catch (Throwable th2) {
                o0.b("MBRewardVideoActivity", th2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i11, int i12) {
        List<CampaignEx> list = this.f37236y;
        if (list == null || list.size() == 0) {
            return i11;
        }
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < this.f37236y.size(); i15++) {
            if (this.f37236y.get(0) != null) {
                if (i15 == 0) {
                    i14 = this.f37236y.get(0).getVideoCompleteTime();
                }
                i13 += this.f37236y.get(i15).getVideoLength();
            }
        }
        if (i12 == 1) {
            if (i11 == 0) {
                if (i13 >= 45) {
                    return 45;
                }
            } else if (i13 > i11) {
                if (i11 > 45) {
                    return 45;
                }
                return i11;
            }
            return i13;
        }
        int i16 = 0;
        for (int i17 = 0; i17 < i12 - 1; i17++) {
            if (this.f37236y.get(i17) != null) {
                i16 += this.f37236y.get(i17).getVideoLength();
            }
        }
        if (i14 > i16) {
            return i14 - i16;
        }
        return 0;
    }

    private WindVaneWebView a(String str) {
        a.C0573a b11 = com.mbridge.msdk.videocommon.a.b(str);
        if (b11 != null) {
            return b11.b();
        }
        return null;
    }

    private void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            if (!TextUtils.isEmpty(campaignEx.getImageUrl())) {
                com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(campaignEx.getImageUrl());
            }
            if (TextUtils.isEmpty(campaignEx.getIconUrl())) {
                return;
            }
            com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(campaignEx.getIconUrl());
        }
    }

    private void a(List<CampaignEx> list) {
        CampaignEx campaignEx;
        if (this.Q) {
            return;
        }
        if (list == null) {
            try {
                if (this.f37227p) {
                    list = this.f37236y;
                } else {
                    list = new ArrayList<>();
                    List<com.mbridge.msdk.videocommon.download.a> list2 = this.f37235x;
                    if (list2 != null && list2.get(0) != null && this.f37235x.get(0).c() != null) {
                        list.add(this.f37235x.get(0).c());
                    }
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                    return;
                }
                return;
            }
        }
        String str = "";
        if (list != null && !list.isEmpty() && (campaignEx = list.get(0)) != null) {
            str = campaignEx.getCurrentLocalRid();
        }
        if (!TextUtils.isEmpty(str)) {
            this.O = com.mbridge.msdk.foundation.same.report.metrics.d.b().a(str);
        }
        if (this.O == null) {
            this.O = new com.mbridge.msdk.foundation.same.report.metrics.c();
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, this.f37217f);
            eVar.a(CampaignEx.JSON_KEY_HB, Integer.valueOf(this.f37223l ? 1 : 0));
            eVar.a("adtp", Integer.valueOf(this.f37222k ? MBSupportMuteAdType.INTERSTITIAL_VIDEO : 94));
            eVar.a("lrid", this.N);
            eVar.a("his_reason", "show campaign is null");
            this.O.a("2000129", eVar);
        }
        if (list != null) {
            this.O.b(list);
        }
        this.Q = true;
        com.mbridge.msdk.reward.report.metrics.a.a().a("2000129", this.O);
    }

    static /* synthetic */ int b(MBRewardVideoActivity mBRewardVideoActivity, int i11) {
        int i12 = mBRewardVideoActivity.H - i11;
        mBRewardVideoActivity.H = i12;
        return i12;
    }

    private void b(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                if (campaignEx.isActiveOm() && this.R == null) {
                    com.iab.omid.library.mmadbridge.adsession.b a11 = com.mbridge.msdk.omsdk.b.a(getApplicationContext(), false, campaignEx.getOmid(), campaignEx.getRequestId(), campaignEx.getId(), this.f37217f, campaignEx.getVideoUrlEncode(), campaignEx.getRequestIdNotice());
                    this.R = a11;
                    if (a11 != null) {
                        this.T = com.iab.omid.library.mmadbridge.adsession.a.a(a11);
                        this.S = com.iab.omid.library.mmadbridge.adsession.media.a.g(this.R);
                    }
                }
            } catch (Throwable th2) {
                o0.b("MBRewardVideoActivity", th2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        o0.b("MBRewardVideoActivity", str);
        a(this.f37236y);
        h hVar = this.f37229r;
        if (hVar != null) {
            hVar.a(this.O, str);
        }
        finish();
    }

    private void b(List<CampaignEx> list) {
        int i11;
        if (list == null) {
            b("no available campaign");
            return;
        }
        if (list.size() == 0) {
            b("no available campaign");
            return;
        }
        if (list.get(0) != null) {
            i11 = list.get(0).getDynamicTempCode();
            this.N = list.get(0).getCurrentLocalRid();
        } else {
            i11 = 0;
        }
        if (i11 != 5) {
            k();
            return;
        }
        for (CampaignEx campaignEx : list) {
            if (campaignEx != null) {
                this.H += campaignEx.getVideoLength();
            }
        }
        e(list.get(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(CampaignEx campaignEx) {
        CampaignEx c11;
        try {
            List<com.mbridge.msdk.videocommon.download.a> list = this.f37235x;
            if (list != null && list.size() > 0) {
                for (com.mbridge.msdk.videocommon.download.a aVar : this.f37235x) {
                    if (aVar != null && (c11 = aVar.c()) != null && TextUtils.equals(c11.getId(), campaignEx.getId()) && TextUtils.equals(c11.getRequestId(), campaignEx.getRequestId())) {
                        this.f37233v = aVar;
                    }
                }
            }
            this.f37227p = true;
            j();
            MBTempContainer mBTempContainer = this.f37237z;
            if (mBTempContainer != null) {
                mBTempContainer.setNotchPadding(this.M, this.I, this.K, this.J, this.L);
            }
        } catch (Exception e11) {
            o0.b("MBRewardVideoActivity", e11.getMessage());
            b("more offer to one offer exception");
        }
    }

    private void d(CampaignEx campaignEx) {
        com.mbridge.msdk.reward.player.a.a(this, campaignEx, this.f37230s, this.f37217f);
    }

    private void e() {
        try {
            ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
            BitmapDrawable a11 = com.mbridge.msdk.foundation.controller.c.m().a(this.f37217f, this.f37222k ? MBSupportMuteAdType.INTERSTITIAL_VIDEO : 94);
            if (a11 != null) {
                ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.c.m().d());
                t0.a(imageView, a11, getResources().getDisplayMetrics());
                ((ViewGroup) ((ViewGroup) ((ViewGroup) viewGroup.getChildAt(0)).getChildAt(1)).getChildAt(0)).addView(imageView, new ViewGroup.LayoutParams(-1, -1));
                com.iab.omid.library.mmadbridge.adsession.b bVar = this.R;
                if (bVar != null) {
                    bVar.a(imageView, FriendlyObstructionPurpose.OTHER, null);
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void e(CampaignEx campaignEx) {
        if (campaignEx == null) {
            b("campaign is less");
            return;
        }
        int a11 = a(campaignEx.getVideoCompleteTime(), this.G);
        this.f37234w = campaignEx;
        campaignEx.setCampaignIsFiltered(true);
        this.G = 1;
        this.f37234w.setVideoCompleteTime(a11);
        this.f37234w.setShowIndex(this.G);
        this.f37234w.setShowType(1);
        c(this.f37234w);
    }

    private void f() {
        h hVar = this.f37229r;
        if (hVar == null || !(hVar instanceof com.mbridge.msdk.video.bt.module.orglistener.b)) {
            return;
        }
        try {
            com.mbridge.msdk.video.bt.module.orglistener.b bVar = (com.mbridge.msdk.video.bt.module.orglistener.b) hVar;
            Boolean d11 = bVar.d();
            Boolean c11 = bVar.c();
            if (d11 == null && c11 == null) {
                this.W = null;
            } else {
                Boolean bool = Boolean.FALSE;
                this.W = Boolean.valueOf(bool.equals(d11) && bool.equals(c11));
            }
        } catch (Throwable th2) {
            o0.b("MBRewardVideoActivity", th2.getMessage());
        }
    }

    private void g() {
        try {
            Boolean bool = this.W;
            if (bool != null && !bool.booleanValue()) {
                return;
            }
            h hVar = this.f37229r;
            if (hVar != null) {
                hVar.a(this.O, "show fail : unexpected destroy");
            }
        } catch (Throwable th2) {
            o0.b("MBRewardVideoActivity", th2.getMessage());
        }
    }

    private void h() {
        try {
            List<CampaignEx> list = this.f37236y;
            if (list != null && list.size() > 0) {
                Iterator<CampaignEx> it = this.f37236y.iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
            }
            CampaignEx campaignEx = this.f37234w;
            if (campaignEx != null) {
                a(campaignEx);
            }
        } catch (Throwable th2) {
            o0.b("MBRewardVideoActivity", th2.getMessage());
        }
    }

    private com.mbridge.msdk.video.bt.module.listener.a i() {
        if (this.C == null) {
            this.C = new c();
        }
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        List<CampaignEx> list;
        RewardPlus rewardPlus;
        CampaignEx campaignEx;
        List<CampaignEx> list2;
        int findID = findID("mbridge_temp_container");
        if (!g0.a(findID)) {
            b("no id mbridge_bt_container in mbridge_more_offer_activity layout");
        }
        MBTempContainer mBTempContainer = (MBTempContainer) findViewById(findID);
        this.f37237z = mBTempContainer;
        if (mBTempContainer == null) {
            b("env error");
        }
        List<CampaignEx> list3 = this.f37236y;
        if (list3 == null || list3.size() <= 0 || !this.f37236y.get(0).isDynamicView()) {
            this.f37237z.setVisibility(0);
        } else {
            new com.mbridge.msdk.video.dynview.ui.b().a(this.f37237z, 500L);
        }
        changeHalfScreenPadding(-1);
        this.f37237z.setActivity(this);
        this.f37237z.setBidCampaign(this.f37223l);
        this.f37237z.setBigOffer(this.f37227p);
        this.f37237z.setUnitId(this.f37217f);
        this.f37237z.setCampaign(this.f37234w);
        if (this.f37234w.getDynamicTempCode() == 5 && (list2 = this.f37236y) != null && list2.size() > 1) {
            View findViewById = findViewById(findID("mbridge_reward_root_container"));
            if (findViewById != null) {
                findViewById.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.f37237z.removeAllViews();
            this.f37237z.setCampOrderViewData(this.f37236y, this.H);
            this.f37237z.setCamPlayOrderCallback(this.f37215a0, this.G);
        }
        this.f37237z.setCampaignDownLoadTask(this.f37233v);
        this.f37237z.setIV(this.f37222k);
        CampaignEx campaignEx2 = this.f37234w;
        if (campaignEx2 == null || campaignEx2.getAdSpaceT() != 2) {
            this.f37237z.setIVRewardEnable(this.f37224m, this.f37225n, this.f37226o);
        } else {
            this.f37237z.setIVRewardEnable(0, 0, 0);
        }
        this.f37237z.setMute(this.f37221j);
        CampaignEx campaignEx3 = this.f37234w;
        if (((campaignEx3 != null && (rewardPlus = campaignEx3.getRewardPlus()) != null) || ((list = this.f37236y) != null && list.size() > 0 && this.f37236y.get(0) != null && (rewardPlus = this.f37236y.get(0).getRewardPlus()) != null)) && !TextUtils.isEmpty(rewardPlus.getName()) && rewardPlus.getAmount() > 0) {
            com.mbridge.msdk.videocommon.entity.c cVar = new com.mbridge.msdk.videocommon.entity.c(rewardPlus.getName(), rewardPlus.getAmount());
            if (cVar.a() < 0) {
                cVar.a(1);
            }
            this.f37220i = cVar;
        }
        this.f37237z.setReward(this.f37220i);
        this.f37237z.setRewardUnitSetting(this.f37230s);
        this.f37237z.setPlacementId(this.f37218g);
        this.f37237z.setUserId(this.f37219h);
        this.f37237z.setShowRewardListener(this.f37229r);
        this.f37237z.setDeveloperExtraData(this.E);
        this.f37237z.init(this);
        this.f37237z.setAdSession(this.R);
        this.f37237z.setAdEvents(this.T);
        this.f37237z.setVideoEvents(this.S);
        this.f37237z.onCreate();
        if (!com.mbridge.msdk.util.b.a() || (campaignEx = this.f37234w) == null) {
            return;
        }
        d(campaignEx);
    }

    private void k() {
        RewardPlus rewardPlus;
        List<CampaignEx> list;
        int findID = findID("mbridge_bt_container");
        if (!g0.a(findID)) {
            b("no mbridge_webview_framelayout in mbridge_more_offer_activity layout");
        }
        MBridgeBTContainer mBridgeBTContainer = (MBridgeBTContainer) findViewById(findID);
        this.A = mBridgeBTContainer;
        if (mBridgeBTContainer == null) {
            b("env error");
        }
        this.A.setVisibility(0);
        com.mbridge.msdk.video.bt.module.listener.a i11 = i();
        this.C = i11;
        this.A.setBTContainerCallback(i11);
        this.A.setShowRewardVideoListener(this.f37229r);
        this.A.setChoiceOneCallback(this.f37216b0);
        this.A.setCampaigns(this.f37236y);
        this.A.setCampaignDownLoadTasks(this.f37235x);
        this.A.setRewardUnitSetting(this.f37230s);
        this.A.setUnitId(this.f37217f);
        this.A.setPlacementId(this.f37218g);
        this.A.setUserId(this.f37219h);
        this.A.setActivity(this);
        CampaignEx campaignEx = this.f37234w;
        if (((campaignEx != null && (rewardPlus = campaignEx.getRewardPlus()) != null) || (this.f37236y.get(0) != null && (rewardPlus = this.f37236y.get(0).getRewardPlus()) != null)) && !TextUtils.isEmpty(rewardPlus.getName()) && rewardPlus.getAmount() > 0) {
            com.mbridge.msdk.videocommon.entity.c cVar = new com.mbridge.msdk.videocommon.entity.c(rewardPlus.getName(), rewardPlus.getAmount());
            if (cVar.a() < 0) {
                cVar.a(1);
            }
            this.f37220i = cVar;
        }
        this.A.setReward(this.f37220i);
        this.A.setIVRewardEnable(this.f37224m, this.f37225n, this.f37226o);
        this.A.setIV(this.f37222k);
        this.A.setMute(this.f37221j);
        this.A.setJSFactory((com.mbridge.msdk.video.signal.factory.b) this.jsFactory);
        this.A.setDeveloperExtraData(this.E);
        this.A.init(this);
        this.A.setAdSession(this.R);
        this.A.setVideoEvents(this.S);
        this.A.setAdEvents(this.T);
        this.A.onCreate(this.P);
        if (!com.mbridge.msdk.util.b.a() || (list = this.f37236y) == null || list.size() <= 0 || this.f37236y.get(0) == null) {
            return;
        }
        d(this.f37236y.get(0));
    }

    static /* synthetic */ int m(MBRewardVideoActivity mBRewardVideoActivity) {
        int i11 = mBRewardVideoActivity.G;
        mBRewardVideoActivity.G = i11 + 1;
        return i11;
    }

    public void changeHalfScreenPadding(int i11) {
        int f11;
        int g11;
        int g12;
        float f12;
        try {
            CampaignEx campaignEx = this.f37234w;
            if (campaignEx == null || campaignEx.getAdSpaceT() != 2) {
                return;
            }
            getWindow().getDecorView().setBackgroundColor(-1728053248);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f37237z.getLayoutParams();
            layoutParams.gravity = 17;
            if (this.f37234w.getRewardTemplateMode().b() == 0) {
                if (i11 == 2) {
                    f11 = (int) (t0.f(this) * 0.6f);
                    g12 = t0.g(this);
                    f12 = g12 * 0.6f;
                } else {
                    f11 = (int) (t0.f(this) * 0.6f);
                    g11 = t0.g(this);
                    f12 = g11 * 0.7f;
                }
            } else if (this.f37234w.getRewardTemplateMode().b() == 2) {
                f11 = (int) (t0.f(this) * 0.6f);
                g12 = t0.g(this);
                f12 = g12 * 0.6f;
            } else {
                f11 = (int) (t0.f(this) * 0.6f);
                g11 = t0.g(this);
                f12 = g11 * 0.7f;
            }
            int i12 = (int) f12;
            layoutParams.height = f11;
            layoutParams.width = i12;
            this.f37237z.setLayoutParams(layoutParams);
        } catch (Throwable th2) {
            o0.b("MBRewardVideoActivity", th2.getMessage());
        }
    }

    public int findID(String str) {
        return g0.a(getApplicationContext(), str, "id");
    }

    public int findLayout(String str) {
        return g0.a(getApplicationContext(), str, TtmlNode.TAG_LAYOUT);
    }

    @Override // android.app.Activity
    public void finish() {
        this.Y = true;
        com.mbridge.msdk.foundation.controller.c.m().b(0);
        MBTempContainer mBTempContainer = this.f37237z;
        if (mBTempContainer != null) {
            mBTempContainer.onDestroy();
            this.f37237z = null;
        }
        com.mbridge.msdk.foundation.feedback.b.b().d(this.f37217f);
        if (this.R != null) {
            o0.b("omsdk", "mbrewardvideoac finish");
            this.R.e();
            this.R.c();
            this.R = null;
        }
        MBridgeBTContainer mBridgeBTContainer = this.A;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onDestroy();
            this.A = null;
        }
        super.finish();
    }

    @Override // com.mbridge.msdk.video.signal.activity.AbstractJSActivity, android.app.Activity
    public void onBackPressed() {
        this.Z = true;
        super.onBackPressed();
        MBTempContainer mBTempContainer = this.f37237z;
        if (mBTempContainer != null) {
            mBTempContainer.onBackPressed();
        }
        MBridgeBTContainer mBridgeBTContainer = this.A;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onBackPressed();
        }
    }

    @Override // com.mbridge.msdk.video.signal.activity.AbstractJSActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f37237z != null) {
            changeHalfScreenPadding(configuration.orientation);
            this.f37237z.onConfigurationChanged(configuration);
        }
        MBridgeBTContainer mBridgeBTContainer = this.A;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onConfigurationChanged(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.activity.MBBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        List<com.mbridge.msdk.videocommon.download.a> list;
        String str2 = "";
        super.onCreate(bundle);
        MBridgeConstans.isRewardActivityShowing = true;
        com.mbridge.msdk.foundation.controller.c.m().a(this);
        this.U = SystemClock.elapsedRealtime();
        if (TextUtils.isEmpty(this.V)) {
            str = "onCreate";
        } else {
            str = this.V + "_onCreate";
        }
        this.V = str;
        try {
            Intent intent = getIntent();
            this.f37217f = intent.getStringExtra(INTENT_UNITID);
            this.f37218g = intent.getStringExtra(MBridgeConstans.PLACEMENT_ID);
            this.f37220i = com.mbridge.msdk.videocommon.entity.c.a(intent.getStringExtra(INTENT_REWARD));
            this.f37219h = intent.getStringExtra(INTENT_USERID);
            this.f37221j = intent.getIntExtra(INTENT_MUTE, 2);
            this.f37222k = intent.getBooleanExtra(INTENT_ISIV, false);
            com.mbridge.msdk.foundation.controller.c.m().b(this.f37222k ? 287 : 94);
            this.f37223l = intent.getBooleanExtra(INTENT_ISBID, false);
            this.E = intent.getStringExtra(INTENT_EXTRADATA);
            boolean booleanExtra = intent.getBooleanExtra("is_refactor", false);
            this.P = booleanExtra;
            if (booleanExtra) {
                this.f37229r = MBridgeGlobalCommon.showRewardListenerMap.get(this.f37217f);
            } else {
                this.f37229r = com.mbridge.msdk.reward.controller.a.f37121f0.get(this.f37217f);
            }
            if (this.f37222k) {
                this.f37224m = intent.getIntExtra(INTENT_IVREWARD_MODETYPE, 0);
                this.f37225n = intent.getIntExtra(INTENT_IVREWARD_VALUETYPE, 0);
                this.f37226o = intent.getIntExtra(INTENT_IVREWARD_VALUE, 0);
            }
            this.f37227p = intent.getBooleanExtra(INTENT_ISBIG_OFFER, false);
            this.f37235x = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f37217f);
            this.f37236y = com.mbridge.msdk.videocommon.download.b.getInstance().b(this.f37217f);
            int findLayout = findLayout("mbridge_more_offer_activity");
            if (!g0.a(findLayout)) {
                b("no mbridge_more_offer_activity layout");
                return;
            }
            setContentView(findLayout);
            if (TextUtils.isEmpty(this.f37217f)) {
                b("data empty error");
                return;
            }
            com.mbridge.msdk.video.signal.factory.b bVar = new com.mbridge.msdk.video.signal.factory.b(this);
            this.jsFactory = bVar;
            registerJsFactory(bVar);
            h hVar = this.f37229r;
            if (hVar == null) {
                b("showRewardListener is null");
                return;
            }
            this.X = hVar.hashCode();
            com.mbridge.msdk.videocommon.setting.c cVar = RewardUnitCacheManager.getInstance().get(this.f37218g, this.f37217f);
            this.f37230s = cVar;
            if (cVar == null) {
                com.mbridge.msdk.videocommon.setting.c c11 = com.mbridge.msdk.videocommon.setting.b.b().c(com.mbridge.msdk.foundation.controller.c.m().b(), this.f37217f);
                this.f37230s = c11;
                if (c11 == null) {
                    this.f37230s = com.mbridge.msdk.videocommon.setting.b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), this.f37217f, this.f37222k);
                }
            }
            com.mbridge.msdk.videocommon.setting.c cVar2 = this.f37230s;
            if (cVar2 != null) {
                this.f37220i.a(cVar2.d());
                this.f37220i.b(this.f37230s.s());
            }
            com.mbridge.msdk.videocommon.entity.c cVar3 = this.f37220i;
            if (cVar3 != null && cVar3.a() <= 0) {
                this.f37220i.a(1);
            }
            int a11 = g0.a(this, "mbridge_reward_activity_open", "anim");
            int a12 = g0.a(this, "mbridge_reward_activity_stay", "anim");
            if (g0.a(a11) && g0.a(a12)) {
                overridePendingTransition(a11, a12);
            }
            if (bundle != null) {
                try {
                    this.f37232u = bundle.getBoolean(SAVE_STATE_KEY_REPORT);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
            o0.a("DynamicViewCampaignResourceDownloader", "进入 show，大模板 " + this.f37227p);
            if (!this.f37227p) {
                List<com.mbridge.msdk.videocommon.download.a> list2 = this.f37235x;
                if (list2 != null && list2.size() > 0) {
                    this.f37233v = this.f37235x.get(0);
                }
                com.mbridge.msdk.videocommon.download.a aVar = this.f37233v;
                if (aVar != null) {
                    this.f37234w = aVar.c();
                    this.f37233v.b(true);
                    this.f37233v.d(false);
                    CampaignEx campaignEx = this.f37234w;
                    if (campaignEx != null) {
                        this.N = campaignEx.getCurrentLocalRid();
                        this.f37234w.setShowIndex(1);
                        this.f37234w.setShowType(1);
                        com.mbridge.msdk.reward.controller.a.f37117b0 = this.f37234w.getEcppv();
                        com.mbridge.msdk.click.c.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f37234w.getMaitve(), this.f37234w.getMaitve_src());
                    }
                }
                if (this.f37233v != null && this.f37234w != null && this.f37220i != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.f37234w);
                    a(arrayList);
                    b(this.f37234w);
                    j();
                    if (com.mbridge.msdk.util.b.a()) {
                        return;
                    }
                    e();
                    return;
                }
                b("data empty error");
                return;
            }
            a(this.f37236y);
            this.D = "";
            List<CampaignEx> list3 = this.f37236y;
            if (list3 != null && list3.size() > 0) {
                CampaignEx campaignEx2 = this.f37236y.get(0);
                b(campaignEx2);
                str2 = campaignEx2.getCMPTEntryUrl();
                this.D = campaignEx2.getRequestId();
                this.N = campaignEx2.getCurrentLocalRid();
                com.mbridge.msdk.reward.controller.a.f37117b0 = campaignEx2.getEcppv();
                com.mbridge.msdk.click.c.a(com.mbridge.msdk.foundation.controller.c.m().d(), campaignEx2.getMaitve(), campaignEx2.getMaitve_src());
            }
            WindVaneWebView a13 = a(this.f37217f + "_" + this.D + "_" + str2);
            this.B = a13;
            if (a13 == null) {
                if (this.f37233v == null && (list = this.f37235x) != null && list.size() > 0) {
                    this.f37233v = this.f37235x.get(0);
                }
                if (this.f37233v == null) {
                    this.f37233v = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f37222k ? 287 : 94, this.f37217f, this.f37223l);
                }
                com.mbridge.msdk.videocommon.download.a aVar2 = this.f37233v;
                if (aVar2 != null) {
                    this.f37234w = aVar2.c();
                    this.f37233v.b(true);
                    this.f37233v.d(false);
                }
                if (this.f37233v != null && this.f37234w != null && this.f37220i != null) {
                    this.f37227p = false;
                    List<CampaignEx> a14 = com.mbridge.msdk.videocommon.cache.a.a().a(this.f37236y);
                    if (a14 == null) {
                        b("no available campaign");
                        return;
                    }
                    int size = a14.size();
                    if (size == 0) {
                        b("no available campaign");
                        return;
                    }
                    if (a14.get(0) == null || !a14.get(0).isDynamicView()) {
                        j();
                    } else if (size == 1) {
                        CampaignEx campaignEx3 = a14.get(0);
                        this.f37234w = campaignEx3;
                        if (campaignEx3 != null) {
                            this.N = campaignEx3.getCurrentLocalRid();
                            this.f37234w.setCampaignIsFiltered(true);
                        }
                        c(this.f37234w);
                    } else {
                        b(a14);
                    }
                }
                b("data empty error");
                return;
            }
            b(this.f37236y.get(0));
            WindVaneWebView windVaneWebView = this.B;
            if (windVaneWebView != null) {
                try {
                    k kVar = (k) windVaneWebView.getObject();
                    kVar.setAdEvents(this.T);
                    kVar.setAdSession(this.R);
                    kVar.setVideoEvents(this.S);
                    this.B.setObject(kVar);
                } catch (Exception e12) {
                    o0.b("MBRewardVideoActivity", e12.getMessage());
                }
            }
            k();
            if (com.mbridge.msdk.util.b.a()) {
                return;
            }
            e();
        } catch (Throwable th2) {
            a(this.f37236y);
            b("onCreate error" + th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.activity.AbstractJSActivity, com.mbridge.msdk.activity.MBBaseActivity, android.app.Activity
    public void onDestroy() {
        String str;
        if (TextUtils.isEmpty(this.V)) {
            str = "onDestroy";
        } else {
            str = this.V + "_onDestroy";
        }
        this.V = str;
        super.onDestroy();
        f();
        com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
        eVar.a("activity_life_cycle", TextUtils.isEmpty(this.V) ? "unKnown" : this.V);
        eVar.a("activity_duration", Long.valueOf(SystemClock.elapsedRealtime() - this.U));
        Boolean bool = this.W;
        eVar.a("is_unexpected_destroy", Integer.valueOf(bool == null ? 0 : bool.booleanValue() ? 1 : 2));
        eVar.a("is_listener_null", Integer.valueOf(this.f37229r == null ? 1 : 2));
        eVar.a("is_called_finish", Integer.valueOf(this.Y ? 1 : 2));
        eVar.a("is_back_pressed", Integer.valueOf(this.Z ? 1 : 2));
        h hVar = this.f37229r;
        eVar.a("is_listener_change", Integer.valueOf(hVar != null ? hVar.hashCode() == this.X ? 1 : 2 : 0));
        com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000151", this.f37234w, eVar);
        g();
        com.mbridge.msdk.video.module.report.b.a(this.f37217f);
        h();
        MBTempContainer mBTempContainer = this.f37237z;
        if (mBTempContainer != null) {
            mBTempContainer.onDestroy();
            this.f37237z = null;
        }
        MBridgeBTContainer mBridgeBTContainer = this.A;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onDestroy();
            this.A = null;
        }
        this.f37215a0 = null;
        this.f37216b0 = null;
        com.mbridge.msdk.foundation.feedback.b.b().d(this.f37217f + "_1");
        com.mbridge.msdk.foundation.feedback.b.b().d(this.f37217f + "_2");
        com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new e(this.f37235x, this.f37217f, this.D));
    }

    @Override // com.mbridge.msdk.video.signal.activity.AbstractJSActivity, android.app.Activity
    public void onPause() {
        String str;
        super.onPause();
        if (TextUtils.isEmpty(this.V)) {
            str = "onPause";
        } else {
            str = this.V + "_onPause";
        }
        this.V = str;
        MBTempContainer mBTempContainer = this.f37237z;
        if (mBTempContainer != null) {
            mBTempContainer.onPause();
        }
        MBridgeBTContainer mBridgeBTContainer = this.A;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onPause();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        String str;
        super.onRestart();
        if (TextUtils.isEmpty(this.V)) {
            str = "onRestart";
        } else {
            str = this.V + "_onRestart";
        }
        this.V = str;
        MBTempContainer mBTempContainer = this.f37237z;
        if (mBTempContainer != null) {
            mBTempContainer.onRestart();
        }
        MBridgeBTContainer mBridgeBTContainer = this.A;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onRestart();
        }
    }

    @Override // com.mbridge.msdk.video.signal.activity.AbstractJSActivity, com.mbridge.msdk.activity.MBBaseActivity, android.app.Activity
    public void onResume() {
        String str;
        MBridgeVideoView mBridgeVideoView;
        super.onResume();
        if (TextUtils.isEmpty(this.V)) {
            str = "onResume";
        } else {
            str = this.V + "_onResume";
        }
        this.V = str;
        if (com.mbridge.msdk.foundation.feedback.b.f35343f) {
            MBTempContainer mBTempContainer = this.f37237z;
            if (mBTempContainer == null || (mBridgeVideoView = mBTempContainer.mbridgeVideoView) == null) {
                return;
            }
            mBridgeVideoView.setCover(false);
            return;
        }
        com.mbridge.msdk.foundation.controller.c.m().a(this);
        try {
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new f(this.f37217f, this.f37235x));
        } catch (Throwable th2) {
            o0.b("MBRewardVideoActivity", th2.getMessage());
        }
        MBTempContainer mBTempContainer2 = this.f37237z;
        if (mBTempContainer2 != null) {
            mBTempContainer2.onResume();
        }
        MBridgeBTContainer mBridgeBTContainer = this.A;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onResume();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(SAVE_STATE_KEY_REPORT, this.f37232u);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onStart() {
        String str;
        super.onStart();
        if (TextUtils.isEmpty(this.V)) {
            str = TmcConstants.NAVIGATION_ON_START;
        } else {
            str = this.V + "_onStart";
        }
        this.V = str;
        if (com.mbridge.msdk.foundation.feedback.b.f35343f) {
            return;
        }
        new d();
        MBTempContainer mBTempContainer = this.f37237z;
        if (mBTempContainer != null) {
            mBTempContainer.onStart();
            this.f37234w.setCampaignUnitId(this.f37217f);
            com.mbridge.msdk.foundation.feedback.b.b().a(this.f37217f + "_1", this.f37234w);
        }
        MBridgeBTContainer mBridgeBTContainer = this.A;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onStart();
            List<CampaignEx> list = this.f37236y;
            if (list != null && list.size() > 0) {
                CampaignEx campaignEx = this.f37236y.get(0);
                campaignEx.setCampaignUnitId(this.f37217f);
                com.mbridge.msdk.foundation.feedback.b.b().a(this.f37217f + "_1", campaignEx);
            }
        }
        if (this.F) {
            return;
        }
        com.mbridge.msdk.foundation.feedback.b.b().a(this.f37217f + "_1", 1);
        com.mbridge.msdk.foundation.feedback.b.b().d(this.f37217f + "_2");
        this.F = true;
    }

    @Override // android.app.Activity
    protected void onStop() {
        String str;
        if (TextUtils.isEmpty(this.V)) {
            str = "onStop";
        } else {
            str = this.V + "_onStop";
        }
        this.V = str;
        MBridgeConstans.isRewardActivityShowing = false;
        super.onStop();
        MBTempContainer mBTempContainer = this.f37237z;
        if (mBTempContainer != null) {
            mBTempContainer.onStop();
        }
        MBridgeBTContainer mBridgeBTContainer = this.A;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onStop();
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i11) {
        super.setTheme(g0.a(this, "mbridge_transparent_theme", TtmlNode.TAG_STYLE));
    }

    @Override // com.mbridge.msdk.activity.MBBaseActivity
    public void setTopControllerPadding(int i11, int i12, int i13, int i14, int i15) {
        this.I = i12;
        this.K = i13;
        this.J = i14;
        this.L = i15;
        this.M = i11;
        MBTempContainer mBTempContainer = this.f37237z;
        if (mBTempContainer != null) {
            mBTempContainer.setNotchPadding(i11, i12, i13, i14, i15);
        }
        MBridgeBTContainer mBridgeBTContainer = this.A;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.setNotchPadding(i11, i12, i13, i14, i15);
        }
        com.mbridge.msdk.video.dynview.constant.a.a(i11, i12, i13, i14, i15);
    }
}

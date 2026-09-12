package com.mbridge.msdk.video.bt.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.aliyun.player.BuildConfig;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.iab.omid.library.mmadbridge.adsession.media.InteractionType;
import com.iab.omid.library.mmadbridge.adsession.media.Position;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.b0;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.s0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.video.bt.module.orglistener.h;
import com.mbridge.msdk.video.signal.container.AbstractJSContainer;
import com.mbridge.msdk.video.signal.impl.a;
import com.mbridge.msdk.video.signal.impl.k;
import com.mbridge.msdk.videocommon.a;
import com.mbridge.msdk.widget.FeedBackButton;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class MBridgeBTContainer extends AbstractJSContainer implements com.mbridge.msdk.video.signal.c {
    private static final String V = "MBridgeBTContainer";
    private boolean A;
    private boolean B;
    private String C;
    private boolean D;
    private List<CampaignEx> E;
    private List<com.mbridge.msdk.videocommon.download.a> F;
    private com.mbridge.msdk.video.bt.module.listener.a G;
    private h H;
    private h I;
    private com.mbridge.msdk.video.bt.module.listener.b J;
    private String K;
    private String L;
    private String M;
    private boolean N;
    private int O;
    private String P;
    private com.mbridge.msdk.video.dynview.listener.d Q;
    private com.mbridge.msdk.foundation.same.report.metrics.c R;
    private com.iab.omid.library.mmadbridge.adsession.b S;
    private com.iab.omid.library.mmadbridge.adsession.media.a T;
    private com.iab.omid.library.mmadbridge.adsession.a U;

    /* renamed from: r, reason: collision with root package name */
    private int f38922r;

    /* renamed from: s, reason: collision with root package name */
    private int f38923s;

    /* renamed from: t, reason: collision with root package name */
    private FrameLayout f38924t;

    /* renamed from: u, reason: collision with root package name */
    private MBridgeBTLayout f38925u;

    /* renamed from: v, reason: collision with root package name */
    private WindVaneWebView f38926v;

    /* renamed from: w, reason: collision with root package name */
    private LayoutInflater f38927w;

    /* renamed from: x, reason: collision with root package name */
    private Context f38928x;

    /* renamed from: y, reason: collision with root package name */
    private TextView f38929y;

    /* renamed from: z, reason: collision with root package name */
    private ImageView f38930z;

    /* loaded from: classes5.dex */
    class a implements com.mbridge.msdk.foundation.feedback.a {
        a() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
            String str;
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, 1);
                }
                str = jSONObject.toString();
            } catch (Throwable th2) {
                o0.b(MBridgeBTContainer.V, th2.getMessage(), th2);
                str = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) MBridgeBTContainer.this.f38926v, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            String str2;
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                }
                str2 = jSONObject.toString();
            } catch (Throwable th2) {
                o0.b(MBridgeBTContainer.V, th2.getMessage(), th2);
                str2 = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) MBridgeBTContainer.this.f38926v, "onFeedbackAlertStatusNotify", Base64.encodeToString(str2.getBytes(), 2));
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            String str;
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                }
                str = jSONObject.toString();
            } catch (Throwable th2) {
                o0.b(MBridgeBTContainer.V, th2.getMessage(), th2);
                str = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) MBridgeBTContainer.this.f38926v, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements com.mbridge.msdk.video.dynview.listener.h {
        b() {
        }

        @Override // com.mbridge.msdk.video.dynview.listener.h
        public void a(com.mbridge.msdk.video.dynview.a aVar) {
            CampaignEx campaignEx;
            String str;
            if (aVar != null) {
                if (MBridgeBTContainer.this.f38924t == null || aVar.b() == null) {
                    MBridgeBTContainer.this.b("nativeview is null");
                    return;
                }
                MBridgeBTContainer.this.f38924t.removeAllViews();
                MBridgeBTContainer.this.f38924t.addView(aVar.b());
                MBridgeBTContainer mBridgeBTContainer = MBridgeBTContainer.this;
                mBridgeBTContainer.f38929y = (TextView) mBridgeBTContainer.findViewById(mBridgeBTContainer.findID("mbridge_choice_one_countdown_tv"));
                MBridgeBTContainer mBridgeBTContainer2 = MBridgeBTContainer.this;
                mBridgeBTContainer2.f38930z = (ImageView) mBridgeBTContainer2.findViewById(mBridgeBTContainer2.findID("mbridge_iv_link"));
                if (MBridgeBTContainer.this.G != null) {
                    MBridgeBTContainer.this.G.a();
                    MBridgeBTContainer.this.G.a(2, ((AbstractJSContainer) MBridgeBTContainer.this).f39837e, ((AbstractJSContainer) MBridgeBTContainer.this).f39836d);
                }
                if (MBridgeBTContainer.this.E == null || MBridgeBTContainer.this.E.size() <= 0 || (campaignEx = (CampaignEx) MBridgeBTContainer.this.E.get(0)) == null) {
                    return;
                }
                if (campaignEx.isBidCampaign()) {
                    MBridgeBTContainer.this.d(campaignEx);
                }
                String onlyImpressionURL = campaignEx.getOnlyImpressionURL();
                com.mbridge.msdk.videocommon.setting.c c11 = com.mbridge.msdk.videocommon.setting.b.b().c(com.mbridge.msdk.foundation.controller.c.m().b(), ((AbstractJSContainer) MBridgeBTContainer.this).f39836d);
                int A = c11 != null ? c11.A() : 1;
                if (campaignEx.getSpareOfferFlag() == 1) {
                    str = onlyImpressionURL + "&to=1&cbt=" + campaignEx.getCbt() + "&tmorl=" + A;
                } else {
                    str = onlyImpressionURL + "&to=0&cbt=" + campaignEx.getCbt() + "&tmorl=" + A;
                }
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), campaignEx, ((AbstractJSContainer) MBridgeBTContainer.this).f39836d, str, false, true, com.mbridge.msdk.click.retry.a.f34473n);
                com.mbridge.msdk.foundation.same.buffer.b.f35425l.put(campaignEx.getOnlyImpressionURL(), Long.valueOf(System.currentTimeMillis()));
                MBridgeBTContainer.this.e(campaignEx);
                try {
                    com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                    eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, "choseFromTwoShow");
                    com.mbridge.msdk.video.module.report.a.a("2000103", campaignEx, eVar);
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        e11.printStackTrace();
                    }
                }
            }
        }

        @Override // com.mbridge.msdk.video.dynview.listener.h
        public void a(com.mbridge.msdk.video.dynview.error.a aVar) {
            String str;
            if (aVar != null) {
                str = "errorCode:" + aVar.b() + "Msg:" + aVar.c();
            } else {
                str = "";
            }
            MBridgeBTContainer.this.b("nativeview is null" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements com.mbridge.msdk.video.bt.module.listener.b {
        c() {
        }

        @Override // com.mbridge.msdk.video.bt.module.listener.b
        public void a(String str) {
            if (MBridgeBTContainer.this.f38926v != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", str);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(MBridgeConstans.PLACEMENT_ID, ((AbstractJSContainer) MBridgeBTContainer.this).f39837e);
                    jSONObject2.put("unitId", ((AbstractJSContainer) MBridgeBTContainer.this).f39836d);
                    jSONObject.put("data", jSONObject2);
                    o0.a(MBridgeBTContainer.V, " BT Call H5 onAdShow " + jSONObject.toString());
                } catch (JSONException e11) {
                    o0.a(MBridgeBTContainer.V, e11.getMessage());
                }
                com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) MBridgeBTContainer.this.f38926v, "onSubPlayTemplateViewPlayStart", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.listener.b
        public void a(String str, int i11, String str2, String str3) {
            if (MBridgeBTContainer.this.H != null) {
                MBridgeBTContainer.this.H.a(i11, str2, str3);
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.listener.b
        public void a(String str, String str2) {
            if (MBridgeBTContainer.this.f38926v != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", str);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(MBridgeConstans.PLACEMENT_ID, ((AbstractJSContainer) MBridgeBTContainer.this).f39837e);
                    jSONObject2.put("unitId", ((AbstractJSContainer) MBridgeBTContainer.this).f39836d);
                    jSONObject2.put("error", str2);
                    jSONObject.put("data", jSONObject2);
                    o0.a(MBridgeBTContainer.V, " BT Call H5 onShowFail " + jSONObject.toString());
                } catch (JSONException e11) {
                    o0.a(MBridgeBTContainer.V, e11.getMessage());
                }
                com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) MBridgeBTContainer.this.f38926v, "onSubPlayTemplateViewPlayFailed", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.listener.b
        public void a(String str, String str2, String str3) {
            if (MBridgeBTContainer.this.f38926v != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", str);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("convert", true);
                    jSONObject2.put(MBridgeConstans.PLACEMENT_ID, str2);
                    jSONObject2.put("unitId", str3);
                    jSONObject.put("data", jSONObject2);
                    o0.a(MBridgeBTContainer.V, " BT Call H5 onVideoComplete " + jSONObject.toString());
                } catch (JSONException e11) {
                    o0.a(MBridgeBTContainer.V, e11.getMessage());
                }
                com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) MBridgeBTContainer.this.f38926v, "onSubPlayTemplateViewPlayCompleted", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.listener.b
        public void a(String str, boolean z10, com.mbridge.msdk.videocommon.entity.c cVar) {
            if (MBridgeBTContainer.this.f38926v != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", str);
                    JSONObject jSONObject2 = new JSONObject();
                    if (cVar != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("name", cVar.c());
                        jSONObject3.put(RewardPlus.AMOUNT, cVar.a());
                        jSONObject2.put("reward", jSONObject3);
                    }
                    jSONObject2.put("isComplete", z10);
                    jSONObject2.put("convert", z10 ? 1 : 2);
                    jSONObject.put("data", jSONObject2);
                    o0.a(MBridgeBTContainer.V, " BT Call H5 onAdClose " + jSONObject.toString());
                } catch (JSONException e11) {
                    o0.a(MBridgeBTContainer.V, e11.getMessage());
                }
                com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) MBridgeBTContainer.this.f38926v, "onSubPlayTemplateViewCloseBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) MBridgeBTContainer.this.f38926v, "onSubPlayTemplateViewDismissed", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.listener.b
        public void a(boolean z10, int i11) {
            MBridgeBTContainer.this.N = z10;
            MBridgeBTContainer.this.O = i11;
        }

        @Override // com.mbridge.msdk.video.bt.module.listener.b
        public void b(String str, String str2, String str3) {
            if (MBridgeBTContainer.this.f38926v != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", str);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(MBridgeConstans.PLACEMENT_ID, str2);
                    jSONObject2.put("unitId", str3);
                    jSONObject.put("data", jSONObject2);
                    o0.a(MBridgeBTContainer.V, " BT Call H5 onVideoAdClicked " + jSONObject.toString());
                } catch (JSONException e11) {
                    o0.a(MBridgeBTContainer.V, e11.getMessage());
                }
                com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) MBridgeBTContainer.this.f38926v, "onSubPlayTemplateViewClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.listener.b
        public void c(String str, String str2, String str3) {
            if (MBridgeBTContainer.this.f38926v != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", str);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(MBridgeConstans.PLACEMENT_ID, str2);
                    jSONObject2.put("unitId", str3);
                    jSONObject.put("data", jSONObject2);
                    o0.a(MBridgeBTContainer.V, " BT Call H5 onEndcardShow " + jSONObject.toString());
                } catch (JSONException e11) {
                    o0.a(MBridgeBTContainer.V, e11.getMessage());
                }
                com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) MBridgeBTContainer.this.f38926v, "onSubPlayTemplateViewEndcardShowSuccess", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MBridgeBTContainer.this.onAdClose();
        }
    }

    /* loaded from: classes5.dex */
    private static final class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private List<CampaignEx> f38935a;

        /* renamed from: b, reason: collision with root package name */
        private Context f38936b;

        /* renamed from: c, reason: collision with root package name */
        private String f38937c;

        /* renamed from: d, reason: collision with root package name */
        private String f38938d;

        public e(List<CampaignEx> list, Context context, String str, String str2) {
            this.f38935a = list;
            this.f38936b = context;
            this.f38937c = str;
            this.f38938d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<CampaignEx> list = this.f38935a;
            if (list == null || list.size() <= 0) {
                return;
            }
            try {
                com.mbridge.msdk.foundation.db.e.a(g.a(this.f38936b)).a(this.f38937c, this.f38935a);
                com.mbridge.msdk.videocommon.cache.a.a().b(this.f38938d, this.f38935a.get(0).getAdType());
            } catch (Exception unused) {
                o0.a(MBridgeBTContainer.V, "remove campaign failed");
            }
        }
    }

    /* loaded from: classes5.dex */
    private class f extends a.C0572a {
        private f() {
        }

        /* synthetic */ f(MBridgeBTContainer mBridgeBTContainer, a aVar) {
            this();
        }

        @Override // com.mbridge.msdk.video.signal.impl.a.C0572a, com.mbridge.msdk.video.signal.a.InterfaceC0571a
        public void a() {
            super.a();
        }

        @Override // com.mbridge.msdk.video.signal.impl.a.C0572a, com.mbridge.msdk.video.signal.a.InterfaceC0571a
        public void a(int i11, String str) {
            super.a(i11, str);
        }

        @Override // com.mbridge.msdk.video.signal.impl.a.C0572a, com.mbridge.msdk.video.signal.a.InterfaceC0571a
        public void a(boolean z10) {
            super.a(z10);
            if (MBridgeBTContainer.this.T != null) {
                try {
                    MBridgeBTContainer.this.T.a(InteractionType.CLICK);
                    o0.a("omsdk", "btc adUserInteraction click");
                } catch (Exception e11) {
                    o0.a("omsdk", e11.getMessage());
                }
            }
            MBridgeBTContainer.this.I.a(z10, ((AbstractJSContainer) MBridgeBTContainer.this).f39837e, ((AbstractJSContainer) MBridgeBTContainer.this).f39836d);
        }

        @Override // com.mbridge.msdk.video.signal.impl.a.C0572a, com.mbridge.msdk.out.BaseTrackingListener
        public void onFinishRedirection(Campaign campaign, String str) {
            super.onFinishRedirection(campaign, str);
            s0.a(campaign, MBridgeBTContainer.this.f38924t);
            if (campaign == null || !(campaign instanceof CampaignEx)) {
                return;
            }
            try {
                CampaignEx campaignEx = (CampaignEx) campaign;
                String optString = new JSONObject(MBridgeBTContainer.this.getJSVideoModule().getCurrentProgress()).optString(NotificationCompat.CATEGORY_PROGRESS, "");
                if (campaignEx.getLinkType() == 3 && campaignEx.getEndcard_click_result() == 2 && optString.equals(BuildConfig.VERSION_NAME) && ((AbstractJSContainer) MBridgeBTContainer.this).f39835c != null) {
                    if (MBridgeBTContainer.this.B) {
                        MBridgeBTContainer.this.onAdClose();
                    } else {
                        ((AbstractJSContainer) MBridgeBTContainer.this).f39835c.finish();
                    }
                }
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
        }

        @Override // com.mbridge.msdk.video.signal.impl.a.C0572a, com.mbridge.msdk.video.signal.a.InterfaceC0571a
        public void onInitSuccess() {
            super.onInitSuccess();
        }

        @Override // com.mbridge.msdk.video.signal.impl.a.C0572a, com.mbridge.msdk.out.BaseTrackingListener
        public void onRedirectionFailed(Campaign campaign, String str) {
            super.onRedirectionFailed(campaign, str);
            s0.a(campaign, MBridgeBTContainer.this.f38924t);
        }

        @Override // com.mbridge.msdk.video.signal.impl.a.C0572a, com.mbridge.msdk.out.BaseTrackingListener
        public void onStartRedirection(Campaign campaign, String str) {
            super.onStartRedirection(campaign, str);
            s0.b(campaign, MBridgeBTContainer.this.f38924t);
        }
    }

    public MBridgeBTContainer(Context context) {
        super(context);
        this.f38922r = 0;
        this.f38923s = 1;
        this.A = false;
        this.B = true;
        this.D = false;
        this.S = null;
        this.T = null;
        this.U = null;
        init(context);
    }

    public MBridgeBTContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f38922r = 0;
        this.f38923s = 1;
        this.A = false;
        this.B = true;
        this.D = false;
        this.S = null;
        this.T = null;
        this.U = null;
        init(context);
    }

    private void a(int i11, int i12, int i13, int i14) {
        TextView textView;
        FrameLayout.LayoutParams layoutParams;
        List<CampaignEx> list = this.E;
        if (list == null || list.size() <= 0) {
            return;
        }
        try {
            if (!this.E.get(0).isDynamicView() || (textView = this.f38929y) == null || (layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams()) == null) {
                return;
            }
            if (i11 > 0) {
                layoutParams.leftMargin = i11;
            }
            if (i13 > 0) {
                layoutParams.rightMargin = i13;
            }
            if (i12 > 0) {
                layoutParams.topMargin = i12;
            }
            if (i14 > 0) {
                layoutParams.bottomMargin = i14;
            }
            this.f38929y.setLayoutParams(layoutParams);
            if (this.f38930z != null) {
                try {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.f38930z.getLayoutParams());
                    layoutParams2.leftMargin = layoutParams.rightMargin;
                    layoutParams2.topMargin = layoutParams.topMargin;
                    this.f38930z.setLayoutParams(layoutParams2);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        } catch (Exception e12) {
            o0.b(V, e12.getMessage());
        }
    }

    private void a(Context context) {
        if (this.Q == null) {
            b("ChoiceOneCallback is null");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("choice_one_callback", this.Q);
        com.mbridge.msdk.video.dynview.b.a().a(context, this.E, new b(), hashMap);
    }

    private WindVaneWebView c(String str) {
        a.C0573a b11 = com.mbridge.msdk.videocommon.a.b(str);
        if (b11 == null) {
            return null;
        }
        this.C = b11.a();
        o0.a(V, "get BT wraper.getTag = " + this.C);
        b11.a("");
        return b11.b();
    }

    private com.mbridge.msdk.videocommon.download.a c(CampaignEx campaignEx) {
        List<com.mbridge.msdk.videocommon.download.a> list = this.F;
        if (list == null || campaignEx == null) {
            return null;
        }
        for (com.mbridge.msdk.videocommon.download.a aVar : list) {
            if (aVar.c().getId().equals(campaignEx.getId())) {
                o0.a(V, "tempContainer task initSuccess");
                return aVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                HashMap hashMap = new HashMap();
                List<com.mbridge.msdk.foundation.entity.d> a11 = com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(campaignEx.getCampaignUnitId(), campaignEx.getRequestId());
                if (a11 == null || a11.size() <= 0 || a11.get(0) == null) {
                    return;
                }
                int c11 = a11.get(0).c();
                String b11 = a11.get(0).b();
                if (c11 == 1) {
                    hashMap.put("encrypt_p=", "encrypt_p=" + b11);
                    hashMap.put("irlfa=", "irlfa=1");
                    for (Map.Entry entry : hashMap.entrySet()) {
                        campaignEx.setOnlyImpressionURL(campaignEx.getOnlyImpressionURL().replaceAll((String) entry.getKey(), (String) entry.getValue()));
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    private com.mbridge.msdk.video.bt.module.listener.b k() {
        if (this.J == null) {
            this.J = new c();
        }
        return this.J;
    }

    private void l() {
        com.iab.omid.library.mmadbridge.adsession.b bVar = this.S;
        if (bVar != null) {
            try {
                bVar.d(this);
                this.S.g();
                o0.a("omsdk", "btc:  adSession.start();");
                if (this.U != null) {
                    o0.a("omsdk", "btc:   adEvents.loaded");
                    this.U.d(com.iab.omid.library.mmadbridge.adsession.media.b.b(true, Position.STANDALONE));
                    o0.a("omsdk", "btc:   adEvents.impressionOccurred");
                    this.U.b();
                }
            } catch (Exception e11) {
                o0.a("omsdk", e11.getMessage());
            }
        }
    }

    public void addNativeCloseButtonWhenWebViewCrash() {
        try {
            ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.c.m().d());
            int a11 = t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 48.0f);
            int a12 = t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 20.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a11, a11);
            layoutParams.setMargins(a12, a12, a12, a12);
            layoutParams.gravity = 5;
            imageView.setLayoutParams(layoutParams);
            imageView.setImageResource(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_close", "drawable"));
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setOnClickListener(new d());
            addView(imageView);
        } catch (Throwable th2) {
            o0.b(V, th2.getMessage());
        }
    }

    public void appendSubView(MBridgeBTContainer mBridgeBTContainer, MBTempContainer mBTempContainer, JSONObject jSONObject) {
        try {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            if (jSONObject != null) {
                Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
                int optInt = jSONObject.optInt(TtmlNode.LEFT, -999);
                int optInt2 = jSONObject.optInt(IntegrationConstants.TAB_BAR_POSITION_TOP, -999);
                int optInt3 = jSONObject.optInt(TtmlNode.RIGHT, -999);
                int optInt4 = jSONObject.optInt(IntegrationConstants.TAB_BAR_POSITION_DEFAULT, -999);
                if (optInt != -999 && d11 != null) {
                    layoutParams.leftMargin = t0.a(d11, optInt);
                }
                if (optInt2 != -999 && d11 != null) {
                    layoutParams.topMargin = t0.a(d11, optInt2);
                }
                if (optInt3 != -999 && d11 != null) {
                    layoutParams.rightMargin = t0.a(d11, optInt3);
                }
                if (optInt4 != -999 && d11 != null) {
                    layoutParams.bottomMargin = t0.a(d11, optInt4);
                }
                int optInt5 = jSONObject.optInt("width");
                int optInt6 = jSONObject.optInt("height");
                if (optInt5 > 0) {
                    layoutParams.width = optInt5;
                }
                if (optInt6 > 0) {
                    layoutParams.height = optInt6;
                }
            }
            mBridgeBTContainer.addView(mBTempContainer, layoutParams);
            mBTempContainer.setActivity(this.f39835c);
            mBTempContainer.setMute(this.f39842j);
            mBTempContainer.setBidCampaign(this.A);
            mBTempContainer.setIV(this.f39843k);
            mBTempContainer.setBigOffer(this.B);
            mBTempContainer.setIVRewardEnable(this.f39845m, this.f39846n, this.f39847o);
            mBTempContainer.setShowRewardListener(this.I);
            mBTempContainer.setCampaignDownLoadTask(c(mBTempContainer.getCampaign()));
            mBTempContainer.setMBridgeTempCallback(k());
            mBTempContainer.setWebViewFront(getJSCommon().b());
            mBTempContainer.init(this.f38928x);
            mBTempContainer.onCreate();
        } catch (Throwable th2) {
            o0.a(V, th2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    protected void b(String str) {
        h hVar = this.H;
        if (hVar != null) {
            hVar.a(this.R, str);
        }
        super.b(str);
    }

    public void broadcast(String str, JSONObject jSONObject) {
        if (this.f38926v != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", this.f38922r);
                jSONObject2.put("id", this.C);
                jSONObject2.put(EventConstants.KEY_EVENT_NAME, str);
                jSONObject2.put("data", jSONObject);
                com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) this.f38926v, "broadcast", Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (Exception unused) {
                com.mbridge.msdk.video.bt.component.d.c().a((WebView) this.f38926v, "broadcast", this.C);
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.e
    public void click(int i11, String str) {
    }

    protected void e(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                List<String> pv_urls = campaignEx.getPv_urls();
                if (pv_urls == null || pv_urls.size() <= 0) {
                    return;
                }
                Iterator<String> it = pv_urls.iterator();
                while (it.hasNext()) {
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), campaignEx, this.f39836d, it.next(), false, true);
                }
            } catch (Throwable th2) {
                o0.b(V, th2.getMessage());
            }
        }
    }

    public int findID(String str) {
        return g0.a(getContext(), str, "id");
    }

    public int findLayout(String str) {
        return g0.a(getContext(), str, TtmlNode.TAG_LAYOUT);
    }

    public com.iab.omid.library.mmadbridge.adsession.a getAdEvents() {
        return this.U;
    }

    public com.iab.omid.library.mmadbridge.adsession.b getAdSession() {
        return this.S;
    }

    public List<CampaignEx> getCampaigns() {
        return this.E;
    }

    public com.iab.omid.library.mmadbridge.adsession.media.a getVideoEvents() {
        return this.T;
    }

    @Override // com.mbridge.msdk.video.signal.e
    public void handlerH5Exception(int i11, String str) {
    }

    public void init(Context context) {
        this.f38928x = context;
        this.f38927w = LayoutInflater.from(context);
    }

    public void onAdClose() {
        Activity activity = this.f39835c;
        if (activity != null) {
            activity.finish();
        }
    }

    public void onBackPressed() {
        try {
            LinkedHashMap<String, View> b11 = com.mbridge.msdk.video.bt.component.d.c().b(this.f39836d, this.L);
            if (b11 == null || b11.size() <= 0) {
                return;
            }
            for (View view : b11.values()) {
                if (view instanceof MBTempContainer) {
                    ((MBTempContainer) view).onBackPressed();
                } else if (view instanceof MBridgeBTWebView) {
                    ((MBridgeBTWebView) view).onBackPressed();
                } else if (view instanceof MBridgeBTLayout) {
                    ((MBridgeBTLayout) view).onBackPressed();
                }
            }
        } catch (Throwable th2) {
            o0.a(V, th2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        try {
            LinkedHashMap<String, View> b11 = com.mbridge.msdk.video.bt.component.d.c().b(this.f39836d, this.L);
            if (b11 == null || b11.size() <= 0) {
                return;
            }
            for (View view : b11.values()) {
                if (view instanceof MBTempContainer) {
                    ((MBTempContainer) view).onConfigurationChanged(configuration);
                } else if (view instanceof MBridgeBTWebView) {
                    ((MBridgeBTWebView) view).onConfigurationChanged(configuration);
                } else if (view instanceof MBridgeBTLayout) {
                    ((MBridgeBTLayout) view).onConfigurationChanged(configuration);
                }
            }
        } catch (Throwable th2) {
            o0.a(V, th2.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(boolean z10) {
        String str;
        CampaignEx campaignEx;
        try {
            int findLayout = findLayout("mbridge_bt_container");
            if (!g0.a(findLayout)) {
                b("mbridge_bt_container layout null");
                return;
            }
            FrameLayout frameLayout = (FrameLayout) this.f38927w.inflate(findLayout, this);
            this.f38924t = frameLayout;
            if (frameLayout == null) {
                b("ViewIds null");
                return;
            }
            this.L = "";
            List<CampaignEx> list = this.E;
            if (list == null || list.size() <= 0) {
                str = "";
            } else {
                CampaignEx campaignEx2 = this.E.get(0);
                str = campaignEx2.getCMPTEntryUrl();
                this.L = campaignEx2.getRequestId();
                this.M = campaignEx2.getCurrentLocalRid();
            }
            this.f38926v = c(this.f39836d + "_" + this.L + "_" + str);
            com.mbridge.msdk.videocommon.a.e(this.f39836d + "_" + this.L + "_" + str);
            l();
            WindVaneWebView windVaneWebView = this.f38926v;
            if (windVaneWebView == null) {
                List<CampaignEx> list2 = this.E;
                if (list2 == null || list2.size() <= 0 || (campaignEx = this.E.get(0)) == null || !(z10 || campaignEx.isDynamicView())) {
                    b("big template webview is null");
                    return;
                } else {
                    a(this.f38928x);
                    return;
                }
            }
            com.mbridge.msdk.video.signal.factory.b bVar = new com.mbridge.msdk.video.signal.factory.b(this.f39835c, this, windVaneWebView);
            registerJsFactory(bVar);
            this.f38926v.setApiManagerJSFactory(bVar);
            if (this.f38926v.getParent() != null) {
                b("preload template webview is null or load error");
                return;
            }
            RelativeLayout.LayoutParams layoutParams = null;
            if (this.f38926v.getObject() instanceof k) {
                bVar.a((k) this.f38926v.getObject());
                if (this.f38926v != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(com.mbridge.msdk.foundation.same.a.f35394l, t0.d(getContext()));
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("name", this.f39840h.c());
                        jSONObject2.put(RewardPlus.AMOUNT, this.f39840h.a());
                        jSONObject2.put("id", this.f39841i);
                        jSONObject.put("userId", this.f39839g);
                        jSONObject.put("reward", jSONObject2);
                        jSONObject.put("playVideoMute", this.f39842j);
                        jSONObject.put("extra", this.P);
                    } catch (JSONException e11) {
                        o0.a(V, e11.getMessage());
                    } catch (Exception e12) {
                        o0.a(V, e12.getMessage());
                    }
                    this.I = new com.mbridge.msdk.video.bt.module.orglistener.c(k(), "");
                    String jSONObject3 = jSONObject.toString();
                    try {
                        com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                        eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, 1);
                        com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000133", this.E, eVar);
                    } catch (Exception unused) {
                    }
                    getJSNotifyProxy().a(jSONObject3);
                    getJSCommon().b(true);
                    getJSCommon().a(new f(this, null == true ? 1 : 0));
                }
                ((com.mbridge.msdk.video.signal.impl.d) getJSCommon()).f39878m.onInitSuccess();
            }
            this.f38926v.setBackgroundColor(0);
            LinkedHashMap<String, View> b11 = com.mbridge.msdk.video.bt.component.d.c().b(this.f39836d, this.L);
            if (b11 == null || !b11.containsKey(this.C)) {
                b("big template webviewLayout is null");
                return;
            }
            View view = b11.get(this.C);
            if (view instanceof MBridgeBTLayout) {
                MBridgeBTLayout mBridgeBTLayout = (MBridgeBTLayout) view;
                this.f38925u = mBridgeBTLayout;
                try {
                    WindVaneWebView windVaneWebView2 = (WindVaneWebView) mBridgeBTLayout.getBtWebView();
                    k kVar = (k) windVaneWebView2.getObject();
                    kVar.setAdEvents(this.U);
                    kVar.setVideoEvents(this.T);
                    kVar.setAdSession(this.S);
                    windVaneWebView2.setObject(kVar);
                } catch (Exception e13) {
                    o0.b(V, e13.getMessage());
                }
                com.mbridge.msdk.foundation.feedback.b.b().a(this.f39836d + "_1", new a());
                this.f38925u.addView(this.f38926v, 0, new FrameLayout.LayoutParams(-1, -1));
                com.mbridge.msdk.foundation.feedback.b.b().d(this.f39836d + "_2");
                FeedBackButton a11 = com.mbridge.msdk.foundation.feedback.b.b().a(this.f39836d + "_1");
                if (com.mbridge.msdk.foundation.feedback.b.b().a() && a11 != null) {
                    try {
                        layoutParams = (RelativeLayout.LayoutParams) a11.getLayoutParams();
                    } catch (Exception e14) {
                        e14.printStackTrace();
                    }
                    if (layoutParams == null) {
                        layoutParams = new RelativeLayout.LayoutParams(com.mbridge.msdk.foundation.feedback.b.f35342e, com.mbridge.msdk.foundation.feedback.b.f35341d);
                    }
                    layoutParams.topMargin = t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 10.0f);
                    layoutParams.leftMargin = t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 10.0f);
                    a11.setLayoutParams(layoutParams);
                    ViewGroup viewGroup = (ViewGroup) a11.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(a11);
                    }
                    this.f38925u.addView(a11);
                }
                this.f38925u.setTag(this.C);
                b11.put(this.C, this.f38925u);
                Iterator<View> it = b11.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    View next = it.next();
                    if (next instanceof MBridgeBTRootLayout) {
                        MBridgeBTRootLayout mBridgeBTRootLayout = (MBridgeBTRootLayout) next;
                        this.K = mBridgeBTRootLayout.getInstanceId();
                        this.f38924t.addView(mBridgeBTRootLayout, new FrameLayout.LayoutParams(-1, -1));
                        break;
                    }
                }
                b11.remove(this.K);
                b11.put(this.K, this);
            }
            com.mbridge.msdk.video.bt.component.d.c().a(this.f39836d, this.f39842j);
            com.mbridge.msdk.video.bt.component.d.c().d(this.C, this.L);
            com.mbridge.msdk.video.bt.component.d.c().d(this.K, this.L);
            com.mbridge.msdk.video.bt.component.d.c().a(this.f39836d + "_" + this.L, this.f39835c);
            try {
                com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new e(this.E, getContext().getApplicationContext(), this.f39836d, this.f39837e));
            } catch (Throwable unused2) {
                o0.a(V, "remove campaign failed");
            }
            List<CampaignEx> list3 = this.E;
            if (list3 == null || list3.size() <= 0) {
                return;
            }
            a(this.f39838f, this.E.get(0));
        } catch (Throwable th2) {
            b("onCreate exception " + th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onDestroy() {
        if (this.D) {
            return;
        }
        this.D = true;
        if (this.S != null) {
            o0.b("omsdk", "btc onDestroy");
            this.S.c();
        }
        super.onDestroy();
        com.mbridge.msdk.video.bt.component.d.c().h(this.f39836d + "_" + this.L);
        try {
            WindVaneWebView windVaneWebView = this.f38926v;
            if (windVaneWebView != null) {
                ViewGroup viewGroup = (ViewGroup) windVaneWebView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                }
                this.f38926v.clearWebView();
                this.f38926v.release();
            }
            if (this.J != null) {
                this.J = null;
            }
            if (this.G != null) {
                this.G = null;
            }
            if (this.f38928x != null) {
                this.f38928x = null;
            }
            List<CampaignEx> list = this.E;
            if (list != null && list.size() > 0) {
                for (CampaignEx campaignEx : this.E) {
                    if (campaignEx != null && campaignEx.getRewardTemplateMode() != null) {
                        com.mbridge.msdk.videocommon.a.e(this.f39836d + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e());
                    }
                }
                com.mbridge.msdk.video.dynview.energize.a.a().d();
            }
            com.mbridge.msdk.video.bt.component.d.c().a(this.C);
            com.mbridge.msdk.video.bt.component.d.c().b(this.f39836d);
            com.mbridge.msdk.video.bt.component.d.c().b(this.f39836d, this.L).remove(this.C);
            com.mbridge.msdk.video.bt.component.d.c().b(this.f39836d, this.L).remove(this.K);
            com.mbridge.msdk.video.bt.component.d.c().b(this.f39836d, this.L).clear();
        } catch (Throwable th2) {
            o0.a(V, th2.getMessage());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onPause() {
        CampaignEx campaignEx;
        super.onPause();
        List<CampaignEx> list = this.E;
        if (list != null && list.size() > 0 && (campaignEx = this.E.get(0)) != null && campaignEx.isDynamicView()) {
            com.mbridge.msdk.video.dynview.energize.a.a().b();
        }
        try {
            LinkedHashMap<String, View> b11 = com.mbridge.msdk.video.bt.component.d.c().b(this.f39836d, this.L);
            if (b11 == null || b11.size() <= 0) {
                return;
            }
            for (View view : b11.values()) {
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).onPause();
                }
            }
        } catch (Throwable th2) {
            o0.a(V, th2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onResume() {
        CampaignEx campaignEx;
        super.onResume();
        List<CampaignEx> list = this.E;
        if (list != null && list.size() > 0 && (campaignEx = this.E.get(0)) != null && campaignEx.isDynamicView()) {
            com.mbridge.msdk.video.dynview.energize.a.a().c();
        }
        if (com.mbridge.msdk.foundation.feedback.b.f35343f) {
            return;
        }
        try {
            LinkedHashMap<String, View> b11 = com.mbridge.msdk.video.bt.component.d.c().b(this.f39836d, this.L);
            if (b11 == null || b11.size() <= 0) {
                return;
            }
            for (View view : b11.values()) {
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).onResume();
                }
            }
        } catch (Throwable th2) {
            o0.a(V, th2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onStop() {
        CampaignEx campaignEx;
        super.onStop();
        List<CampaignEx> list = this.E;
        if (list != null && list.size() > 0 && (campaignEx = this.E.get(0)) != null && campaignEx.isDynamicView()) {
            com.mbridge.msdk.video.dynview.energize.a.a().d();
        }
        try {
            LinkedHashMap<String, View> b11 = com.mbridge.msdk.video.bt.component.d.c().b(this.f39836d, this.L);
            if (b11 == null || b11.size() <= 0) {
                return;
            }
            for (View view : b11.values()) {
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).onStop();
                }
            }
        } catch (Throwable th2) {
            o0.a(V, th2.getMessage());
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x0058. Please report as an issue. */
    @Override // com.mbridge.msdk.video.signal.c
    public void reactDeveloper(Object obj, String str) {
        JSONObject jSONObject;
        int i11;
        if (this.G == null || TextUtils.isEmpty(str)) {
            a(obj, "listener is null");
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            int optInt = jSONObject2.optInt(NativeComponentConstants.KEY_COMPONENT_TYPE);
            String optString = jSONObject2.optString("unitId", getUnitId());
            String optString2 = jSONObject2.optString(MBridgeConstans.PLACEMENT_ID, getPlacementId());
            JSONObject optJSONObject = jSONObject2.optJSONObject("data");
            CampaignEx campaignEx = this.E.get(0);
            boolean z10 = true;
            if (optInt == 1 && optJSONObject != null) {
                boolean optBoolean = optJSONObject.optBoolean("expired");
                if (campaignEx != null) {
                    if (optBoolean) {
                        campaignEx.setSpareOfferFlag(1);
                    } else {
                        campaignEx.setSpareOfferFlag(0);
                    }
                }
            }
            setCBT(campaignEx);
            switch (optInt) {
                case 1:
                    this.G.a();
                    this.G.a(2, optString2, optString);
                    a(obj);
                    return;
                case 2:
                    JSONObject optJSONObject2 = optJSONObject != null ? optJSONObject.optJSONObject("error") : null;
                    this.G.a(optJSONObject2 != null ? optJSONObject2.optString(NotificationCompat.CATEGORY_MESSAGE) : "");
                    this.G.a(4, optString2, optString);
                    a(obj);
                    return;
                case 3:
                    this.G.b(optString2, optString);
                    this.G.a(5, optString2, optString);
                    a(obj);
                    return;
                case 4:
                    try {
                        com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                        eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, 2);
                        com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000147", this.E, eVar);
                    } catch (Throwable th2) {
                        o0.b(V, th2.getMessage());
                    }
                    this.G.a(optString2, optString);
                    this.G.a(6, optString2, optString);
                    a(obj);
                    return;
                case 5:
                    this.G.a(jSONObject2.optBoolean("isAutoClick"), optString2, optString);
                    a(obj);
                    return;
                case 6:
                    if (optJSONObject != null) {
                        if (optJSONObject.optInt("convert") != 1) {
                            z10 = false;
                        }
                        jSONObject = optJSONObject.optJSONObject("reward");
                        String optString3 = optJSONObject.optString("extra");
                        if (!TextUtils.isEmpty(optString3)) {
                            this.P = optString3;
                        }
                    } else {
                        z10 = false;
                        jSONObject = null;
                    }
                    CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(optJSONObject.optJSONObject(MBInterstitialActivity.INTENT_CAMAPIGN));
                    com.mbridge.msdk.videocommon.entity.c a11 = com.mbridge.msdk.videocommon.entity.c.a(jSONObject);
                    if (a11 == null) {
                        a11 = this.f39840h;
                    }
                    this.G.a(7, optString2, optString);
                    try {
                        com.mbridge.msdk.foundation.same.report.metrics.e eVar2 = new com.mbridge.msdk.foundation.same.report.metrics.e();
                        eVar2.a(NativeComponentConstants.KEY_COMPONENT_TYPE, 2);
                        com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000152", eVar2);
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            e11.printStackTrace();
                        }
                    }
                    if (this.f39843k && ((i11 = this.f39845m) == com.mbridge.msdk.foundation.same.a.H || i11 == com.mbridge.msdk.foundation.same.a.I)) {
                        this.G.a(this.N, this.O);
                    }
                    if (!z10) {
                        a11.a(0);
                        o0.a("omsdk", "bt videoEvents :" + this.T);
                        com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.T;
                        if (aVar != null) {
                            try {
                                aVar.m();
                                this.T = null;
                            } catch (Exception e12) {
                                o0.a("omsdk", e12.getMessage());
                            }
                        }
                    }
                    this.G.a(z10, a11);
                    o0.a(V, "sendToServerRewardInfo");
                    if (!this.f39843k && z10) {
                        if (parseCampaignWithBackData != null) {
                            com.mbridge.msdk.video.module.report.b.a(parseCampaignWithBackData, a11, optString, this.f39839g, this.P);
                        } else {
                            com.mbridge.msdk.video.module.report.b.a(campaignEx, a11, optString, this.f39839g, this.P);
                        }
                    }
                    com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000134", parseCampaignWithBackData);
                    a(obj);
                    return;
                default:
                    a(obj);
                    return;
            }
        } catch (JSONException e13) {
            a(obj, e13.getMessage());
            o0.a(V, e13.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.c
    public void reportUrls(Object obj, String str) {
        o0.a(V, "reportUrls:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                int optInt = jSONObject.optInt(NativeComponentConstants.KEY_COMPONENT_TYPE);
                String a11 = t0.a(jSONObject.optString("url"), "&tun=", k0.y() + "");
                int optInt2 = jSONObject.optInt("report");
                if (optInt2 == 0) {
                    Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
                    List<CampaignEx> list = this.E;
                    com.mbridge.msdk.click.a.a(d11, list != null ? list.get(0) : null, "", a11, false, optInt != 0);
                } else {
                    Context d12 = com.mbridge.msdk.foundation.controller.c.m().d();
                    List<CampaignEx> list2 = this.E;
                    com.mbridge.msdk.click.a.a(d12, list2 != null ? list2.get(0) : null, "", a11, false, optInt != 0, optInt2);
                }
            }
            b(obj, "");
        } catch (Throwable th2) {
            o0.b(V, "reportUrls", th2);
        }
    }

    public void setAdEvents(com.iab.omid.library.mmadbridge.adsession.a aVar) {
        this.U = aVar;
    }

    public void setAdSession(com.iab.omid.library.mmadbridge.adsession.b bVar) {
        this.S = bVar;
    }

    public void setBTContainerCallback(com.mbridge.msdk.video.bt.module.listener.a aVar) {
        this.G = aVar;
    }

    public void setCBT(CampaignEx campaignEx) {
        if (campaignEx != null) {
            if (campaignEx.getSpareOfferFlag() != 1) {
                campaignEx.setCbt(0);
                return;
            }
            com.mbridge.msdk.videocommon.setting.c cVar = this.f39838f;
            if (cVar != null) {
                if (cVar.A() == 1) {
                    campaignEx.setCbt(1);
                } else {
                    campaignEx.setCbt(0);
                }
            }
        }
    }

    public void setCampaignDownLoadTasks(List<com.mbridge.msdk.videocommon.download.a> list) {
        this.F = list;
    }

    public void setCampaigns(List<CampaignEx> list) {
        CampaignEx campaignEx;
        this.E = list;
        String str = "";
        if (list != null) {
            try {
                if (list.size() > 0 && (campaignEx = list.get(0)) != null) {
                    str = campaignEx.getCurrentLocalRid();
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                    return;
                }
                return;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            this.R = com.mbridge.msdk.foundation.same.report.metrics.d.b().a(str);
        }
        if (this.R == null) {
            this.R = new com.mbridge.msdk.foundation.same.report.metrics.c();
        }
        this.R.h(str);
        this.R.b(list);
    }

    public void setChoiceOneCallback(com.mbridge.msdk.video.dynview.listener.d dVar) {
        this.Q = dVar;
    }

    public void setDeveloperExtraData(String str) {
        this.P = str;
    }

    public void setJSFactory(com.mbridge.msdk.video.signal.factory.b bVar) {
        this.f39849q = bVar;
    }

    public void setNotchPadding(int i11, int i12, int i13, int i14, int i15) {
        try {
            String a11 = b0.a(i11, i12, i13, i14, i15);
            o0.b(V, a11);
            WindVaneWebView windVaneWebView = this.f38926v;
            if (windVaneWebView != null && (windVaneWebView.getObject() instanceof k) && !TextUtils.isEmpty(a11)) {
                ((k) this.f38926v.getObject()).a(a11);
                com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) this.f38926v, "oncutoutfetched", Base64.encodeToString(a11.getBytes(), 0));
            }
            a(i12, i14, i13, i15);
            com.mbridge.msdk.video.bt.component.d.c().a(i11, i12, i13, i14, i15);
            LinkedHashMap<String, View> b11 = com.mbridge.msdk.video.bt.component.d.c().b(this.f39836d, this.L);
            if (b11 == null || b11.size() <= 0) {
                return;
            }
            for (View view : b11.values()) {
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).setNotchPadding(i12, i13, i14, i15);
                }
                if (view instanceof MBTempContainer) {
                    ((MBTempContainer) view).setNotchPadding(i11, i12, i13, i14, i15);
                }
                if ((view instanceof WindVaneWebView) && !TextUtils.isEmpty(a11)) {
                    com.mbridge.msdk.mbsignalcommon.windvane.f.a().a(view, "oncutoutfetched", Base64.encodeToString(a11.getBytes(), 0));
                }
            }
        } catch (Throwable th2) {
            o0.a(V, th2.getMessage());
        }
    }

    public void setShowRewardVideoListener(h hVar) {
        this.H = hVar;
    }

    public void setVideoEvents(com.iab.omid.library.mmadbridge.adsession.media.a aVar) {
        this.T = aVar;
    }
}

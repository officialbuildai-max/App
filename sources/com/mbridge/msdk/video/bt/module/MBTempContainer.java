package com.mbridge.msdk.video.bt.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import com.aliyun.player.BuildConfig;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.iab.omid.library.mmadbridge.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.mmadbridge.adsession.media.InteractionType;
import com.iab.omid.library.mmadbridge.adsession.media.Position;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.b0;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.q0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.mbsignalcommon.mraid.d;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.MBSupportMuteAdType;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.scheme.applet.AppletModelManager;
import com.mbridge.msdk.scheme.applet.AppletSchemeCallBack;
import com.mbridge.msdk.scheme.applet.AppletsModel;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.signal.container.AbstractJSContainer;
import com.mbridge.msdk.video.signal.impl.a;
import com.mbridge.msdk.videocommon.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class MBTempContainer extends MBTempContainerDiff {

    /* renamed from: s0, reason: collision with root package name */
    private static final String f38878s0 = "MBTempContainer";
    private int A;
    private int B;
    private boolean C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private String I;
    private String J;
    private List<CampaignEx> K;
    private int L;
    private com.mbridge.msdk.foundation.same.report.metrics.c M;
    protected boolean N;
    private LayoutInflater O;
    protected boolean P;
    protected k Q;
    protected WindVaneWebView R;
    protected MBridgeContainerView S;
    protected Handler T;
    private int U;
    private int V;
    protected Runnable W;

    /* renamed from: a0, reason: collision with root package name */
    protected Runnable f38879a0;

    /* renamed from: b0, reason: collision with root package name */
    private View f38880b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f38881c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f38882d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f38883e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f38884f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f38885g0;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f38886h0;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f38887i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f38888j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f38889k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f38890l0;

    /* renamed from: m0, reason: collision with root package name */
    private com.mbridge.msdk.mbsignalcommon.mraid.d f38891m0;

    /* renamed from: n0, reason: collision with root package name */
    private com.iab.omid.library.mmadbridge.adsession.b f38892n0;

    /* renamed from: o0, reason: collision with root package name */
    private com.iab.omid.library.mmadbridge.adsession.media.a f38893o0;

    /* renamed from: p0, reason: collision with root package name */
    private com.iab.omid.library.mmadbridge.adsession.a f38894p0;

    /* renamed from: q0, reason: collision with root package name */
    private Runnable f38895q0;

    /* renamed from: r, reason: collision with root package name */
    private View f38896r;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f38897r0;

    /* renamed from: s, reason: collision with root package name */
    private CampaignEx f38898s;

    /* renamed from: t, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.download.a f38899t;

    /* renamed from: u, reason: collision with root package name */
    private com.mbridge.msdk.video.bt.module.orglistener.h f38900u;

    /* renamed from: v, reason: collision with root package name */
    private com.mbridge.msdk.video.bt.module.listener.b f38901v;

    /* renamed from: w, reason: collision with root package name */
    private com.mbridge.msdk.video.dynview.listener.a f38902w;

    /* renamed from: x, reason: collision with root package name */
    private int f38903x;

    /* renamed from: y, reason: collision with root package name */
    private String f38904y;

    /* renamed from: z, reason: collision with root package name */
    private com.mbridge.msdk.video.signal.factory.b f38905z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MBTempContainer.this.f38880b0.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MBTempContainer.this.getActivityProxy().a() == 0) {
                MBTempContainer.this.defaultLoad(-1, "WebView load timeout");
            } else {
                MBTempContainer.this.U = -3;
            }
        }
    }

    /* loaded from: classes5.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MBTempContainer.this.getActivityProxy().a() == 0) {
                MBTempContainer.this.defaultLoad(-3, "Signal Communication connect timeout");
            } else {
                MBTempContainer.this.U = -4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements MBridgeVideoView.u {
        d() {
        }

        @Override // com.mbridge.msdk.video.module.MBridgeVideoView.u
        public void a() {
            if (MBTempContainer.this.f38898s != null) {
                MBTempContainer.this.l();
                if (!MBTempContainer.this.f38898s.isDynamicView()) {
                    MBTempContainer.this.f38900u.a(MBTempContainer.this.M);
                } else if (!((AbstractJSContainer) MBTempContainer.this).f39848p) {
                    MBTempContainer.this.f38900u.a(MBTempContainer.this.M);
                } else if (MBTempContainer.this.f38898s.isCampaignIsFiltered()) {
                    MBTempContainer.this.f38900u.a(MBTempContainer.this.M);
                }
                com.mbridge.msdk.video.bt.module.orglistener.f.a(MBTempContainer.this.getContext(), MBTempContainer.this.f38898s, ((AbstractJSContainer) MBTempContainer.this).f39836d, MBTempContainer.this.f38903x);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e implements com.mbridge.msdk.video.dynview.listener.f {
        e() {
        }

        @Override // com.mbridge.msdk.video.dynview.listener.f
        public void a() {
            MBTempContainer.this.w();
        }
    }

    /* loaded from: classes5.dex */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MBTempContainer.this.f38880b0 != null) {
                MBTempContainer.this.f38880b0.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((AbstractJSContainer) MBTempContainer.this).f39835c != null) {
                ((AbstractJSContainer) MBTempContainer.this).f39835c.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class h implements com.mbridge.msdk.foundation.feedback.a {
        h() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
            String str;
            MBTempContainer.this.onPause();
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, 1);
                }
                str = jSONObject.toString();
            } catch (Throwable th2) {
                o0.b(MBTempContainer.f38878s0, th2.getMessage(), th2);
                str = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) MBTempContainer.this.R, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            String str2;
            MBTempContainer.this.onResume();
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                }
                str2 = jSONObject.toString();
            } catch (Throwable th2) {
                o0.b(MBTempContainer.f38878s0, th2.getMessage(), th2);
                str2 = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) MBTempContainer.this.R, "onFeedbackAlertStatusNotify", Base64.encodeToString(str2.getBytes(), 2));
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            String str;
            MBTempContainer.this.onResume();
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                }
                str = jSONObject.toString();
            } catch (Throwable th2) {
                o0.b(MBTempContainer.f38878s0, th2.getMessage(), th2);
                str = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) MBTempContainer.this.R, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class i implements d.b {
        i() {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.mraid.d.b
        public void a(double d11) {
            MBridgeContainerView mBridgeContainerView;
            o0.b(MBTempContainer.f38878s0, "volume is : " + d11);
            try {
                if (!MBTempContainer.this.f38898s.isMraid() || (mBridgeContainerView = MBTempContainer.this.S) == null || mBridgeContainerView.getH5EndCardView() == null) {
                    return;
                }
                MBTempContainer.this.S.getH5EndCardView().volumeChange(d11);
            } catch (Exception e11) {
                o0.b(MBTempContainer.f38878s0, e11.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MBTempContainer.this.f38880b0.setBackgroundColor(0);
            MBTempContainer.this.f38880b0.setVisibility(0);
            MBTempContainer.this.f38880b0.bringToFront();
        }
    }

    /* loaded from: classes5.dex */
    public interface k {

        /* loaded from: classes5.dex */
        public static class a implements k {

            /* renamed from: a, reason: collision with root package name */
            private boolean f38916a = false;

            @Override // com.mbridge.msdk.video.bt.module.MBTempContainer.k
            public void a(boolean z10) {
                this.f38916a = z10;
            }

            @Override // com.mbridge.msdk.video.bt.module.MBTempContainer.k
            public void onError(String str) {
                o0.b("ActivityErrorListener", str);
                this.f38916a = true;
            }
        }

        void a(boolean z10);

        void onError(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class l extends AppletSchemeCallBack {

        /* renamed from: a, reason: collision with root package name */
        private CampaignEx f38917a;

        public l(CampaignEx campaignEx) {
            this.f38917a = campaignEx;
        }

        @Override // com.mbridge.msdk.scheme.applet.AppletSchemeCallBack
        protected void onRequestFailed(int i11, String str, String str2) {
            if (MBridgeConstans.DEBUG) {
                o0.a(MBTempContainer.f38878s0, "request wx scheme failed: errorCode: " + i11 + " errorMessage: " + str);
            }
            try {
                CampaignEx campaignEx = this.f38917a;
                if (campaignEx != null) {
                    campaignEx.setClickURL(str2);
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b(MBTempContainer.f38878s0, e11.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.scheme.applet.AppletSchemeCallBack
        protected void onRequestStart() {
            if (MBridgeConstans.DEBUG) {
                o0.a(MBTempContainer.f38878s0, "start request wx scheme");
            }
        }

        @Override // com.mbridge.msdk.scheme.applet.AppletSchemeCallBack
        protected void onRequestSuccess(String str) {
            if (MBridgeConstans.DEBUG) {
                o0.a(MBTempContainer.f38878s0, "request wx scheme success");
            }
            try {
                CampaignEx campaignEx = this.f38917a;
                if (campaignEx != null) {
                    campaignEx.setDeepLinkUrl(str);
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b(MBTempContainer.f38878s0, e11.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class m extends com.mbridge.msdk.video.module.listener.impl.a {
        public m(Activity activity, CampaignEx campaignEx) {
            super(activity, campaignEx);
        }

        @Override // com.mbridge.msdk.video.module.listener.impl.a, com.mbridge.msdk.video.module.listener.impl.f, com.mbridge.msdk.video.module.listener.a
        public void a(int i11, Object obj) {
            if (com.mbridge.msdk.util.b.a()) {
                MBTempContainer.this.setChinaJsCommonContext();
            }
            if (i11 != 108) {
                if (i11 != 113) {
                    if (i11 == 117) {
                        MBridgeVideoView mBridgeVideoView = MBTempContainer.this.mbridgeVideoView;
                        if (mBridgeVideoView != null) {
                            mBridgeVideoView.setVisible(4);
                        }
                        MBTempContainer.this.f38888j0 = true;
                        MBTempContainer.this.f38900u.a(((AbstractJSContainer) MBTempContainer.this).f39837e, ((AbstractJSContainer) MBTempContainer.this).f39836d);
                    } else if (i11 == 126 || i11 == 128) {
                        MBTempContainer.this.f38900u.a(false, ((AbstractJSContainer) MBTempContainer.this).f39837e, ((AbstractJSContainer) MBTempContainer.this).f39836d);
                    } else if (i11 != 131) {
                        switch (i11) {
                            case 103:
                            case 104:
                                MBTempContainer.this.onAdClose();
                                break;
                            case 105:
                                if (com.mbridge.msdk.util.b.a()) {
                                    MBTempContainer.this.setChinaCTACallBack();
                                }
                                MBTempContainer.this.getJSCommon().click(1, obj != null ? obj.toString() : "");
                                break;
                            case 106:
                                if (com.mbridge.msdk.util.b.a()) {
                                    MBTempContainer mBTempContainer = MBTempContainer.this;
                                    mBTempContainer.setChinaBrowserCallBack(mBTempContainer.f38901v, MBTempContainer.this.f38904y, MBTempContainer.this.f38900u, MBTempContainer.this.f38898s);
                                    if (((AbstractJSContainer) MBTempContainer.this).f39835c != null && MBTempContainer.this.f38898s != null) {
                                        MBTempContainer.this.onAdClose();
                                        break;
                                    }
                                }
                                break;
                        }
                    } else {
                        MBTempContainer.this.f38900u.a(true, ((AbstractJSContainer) MBTempContainer.this).f39837e, ((AbstractJSContainer) MBTempContainer.this).f39836d);
                    }
                }
                MBTempContainer.this.f38900u.a(true, ((AbstractJSContainer) MBTempContainer.this).f39837e, ((AbstractJSContainer) MBTempContainer.this).f39836d);
            } else {
                if (com.mbridge.msdk.util.b.a()) {
                    MBTempContainer mBTempContainer2 = MBTempContainer.this;
                    mBTempContainer2.setChinaCallBackStatus(mBTempContainer2.R);
                }
                MBTempContainer.this.getJSCommon().a(new a.b(MBTempContainer.this.getJSCommon(), new o(MBTempContainer.this, null)));
                MBTempContainer.this.getJSCommon().click(1, obj != null ? obj.toString() : "");
            }
            super.a(i11, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class n extends com.mbridge.msdk.video.module.listener.impl.f {
        private n() {
        }

        /* synthetic */ n(MBTempContainer mBTempContainer, b bVar) {
            this();
        }

        @Override // com.mbridge.msdk.video.module.listener.impl.f, com.mbridge.msdk.video.module.listener.a
        public void a(int i11, Object obj) {
            super.a(i11, obj);
            try {
                String obj2 = obj instanceof JSONObject ? obj.toString() : (String) obj;
                if (((AbstractJSContainer) MBTempContainer.this).f39843k && !TextUtils.isEmpty(obj2)) {
                    JSONObject jSONObject = new JSONObject(obj2);
                    int optInt = jSONObject.optInt(NativeComponentConstants.KEY_COMPONENT_TYPE);
                    int optInt2 = jSONObject.optInt(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE);
                    if (optInt == 2) {
                        MBTempContainer.this.A = com.mbridge.msdk.foundation.same.a.D;
                    } else if (optInt != 3) {
                        MBTempContainer.this.A = com.mbridge.msdk.foundation.same.a.F;
                    } else {
                        MBTempContainer.this.A = com.mbridge.msdk.foundation.same.a.E;
                    }
                    MBTempContainer.this.B = optInt2;
                }
            } catch (Exception unused) {
                o0.b("NotifyListener", "PlayableResultListener ERROR");
            }
            if (i11 == 120) {
                MBTempContainer.this.f38900u.a(((AbstractJSContainer) MBTempContainer.this).f39837e, ((AbstractJSContainer) MBTempContainer.this).f39836d);
                return;
            }
            if (i11 == 131) {
                MBTempContainer.this.getJSCommon().click(4, obj != null ? obj.toString() : "");
                return;
            }
            if (i11 == 126) {
                MBTempContainer.this.f38900u.a(false, ((AbstractJSContainer) MBTempContainer.this).f39837e, ((AbstractJSContainer) MBTempContainer.this).f39836d);
                return;
            }
            if (i11 == 127) {
                MBTempContainer.this.f38882d0 = true;
                MBTempContainer.this.f38900u.a(MBTempContainer.this.M);
                MBTempContainer.this.f38900u.a(((AbstractJSContainer) MBTempContainer.this).f39837e, ((AbstractJSContainer) MBTempContainer.this).f39836d);
                MBTempContainer.this.getJSContainerModule().showEndcard(100);
                return;
            }
            switch (i11) {
                case 100:
                    MBTempContainer.this.f38889k0 = true;
                    MBTempContainer mBTempContainer = MBTempContainer.this;
                    mBTempContainer.T.postDelayed(mBTempContainer.f38895q0, 250L);
                    MBTempContainer.this.f38900u.a(MBTempContainer.this.M);
                    return;
                case 101:
                case 102:
                    MBTempContainer.this.getJSCommon().f();
                    return;
                case 103:
                    MBTempContainer.this.f38882d0 = true;
                    if (MBTempContainer.this.f38898s.isMraid()) {
                        MBTempContainer.this.onAdClose();
                        return;
                    } else {
                        MBTempContainer.this.getJSCommon().f();
                        return;
                    }
                case 104:
                    MBTempContainer.this.onAdClose();
                    return;
                case 105:
                    if (com.mbridge.msdk.util.b.a()) {
                        MBTempContainer.this.setChinaCTACallBack();
                    }
                    MBTempContainer.this.getJSCommon().click(1, obj != null ? obj.toString() : "");
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class o extends a.C0572a {
        private o() {
        }

        /* synthetic */ o(MBTempContainer mBTempContainer, b bVar) {
            this();
        }

        @Override // com.mbridge.msdk.video.signal.impl.a.C0572a, com.mbridge.msdk.video.signal.a.InterfaceC0571a
        public void a() {
            super.a();
            MBTempContainer mBTempContainer = MBTempContainer.this;
            Handler handler = mBTempContainer.T;
            if (handler != null) {
                handler.removeCallbacks(mBTempContainer.W);
            }
        }

        @Override // com.mbridge.msdk.video.signal.impl.a.C0572a, com.mbridge.msdk.video.signal.a.InterfaceC0571a
        public void a(int i11, String str) {
            super.a(i11, str);
            MBTempContainer.this.defaultLoad(i11, str);
        }

        @Override // com.mbridge.msdk.video.signal.impl.a.C0572a, com.mbridge.msdk.video.signal.a.InterfaceC0571a
        public void a(boolean z10) {
            if (MBTempContainer.this.f38893o0 != null) {
                try {
                    MBTempContainer.this.f38893o0.a(InteractionType.CLICK);
                    o0.a("omsdk", "mbtc adUserInteraction click");
                } catch (Exception e11) {
                    o0.b("omsdk", e11.getMessage());
                }
            }
            super.a(z10);
            MBTempContainer.this.f38900u.a(z10, ((AbstractJSContainer) MBTempContainer.this).f39837e, ((AbstractJSContainer) MBTempContainer.this).f39836d);
        }

        @Override // com.mbridge.msdk.video.signal.impl.a.C0572a, com.mbridge.msdk.out.BaseTrackingListener
        public void onFinishRedirection(Campaign campaign, String str) {
            super.onFinishRedirection(campaign, str);
            MBTempContainer.this.f38886h0 = true;
            MBTempContainer.this.m();
            if (campaign != null && (campaign instanceof CampaignEx)) {
                try {
                    CampaignEx campaignEx = (CampaignEx) campaign;
                    String optString = new JSONObject(MBTempContainer.this.getJSVideoModule().getCurrentProgress()).optString(NotificationCompat.CATEGORY_PROGRESS, "");
                    if (campaignEx.getLinkType() == 3 && campaignEx.getEndcard_click_result() == 2 && optString.equals(BuildConfig.VERSION_NAME) && ((AbstractJSContainer) MBTempContainer.this).f39835c != null) {
                        if (((AbstractJSContainer) MBTempContainer.this).f39848p) {
                            MBTempContainer.this.onAdClose();
                        } else {
                            ((AbstractJSContainer) MBTempContainer.this).f39835c.finish();
                        }
                    }
                } catch (JSONException e11) {
                    e11.printStackTrace();
                }
            }
            if (MBTempContainer.this.f38897r0) {
                MBTempContainer.this.onResume();
            }
        }

        @Override // com.mbridge.msdk.video.signal.impl.a.C0572a, com.mbridge.msdk.video.signal.a.InterfaceC0571a
        public void onInitSuccess() {
            super.onInitSuccess();
            MBTempContainer.this.receiveSuccess();
        }

        @Override // com.mbridge.msdk.video.signal.impl.a.C0572a, com.mbridge.msdk.out.BaseTrackingListener
        public void onRedirectionFailed(Campaign campaign, String str) {
            super.onRedirectionFailed(campaign, str);
            MBTempContainer.this.m();
            MBTempContainer.this.f38886h0 = true;
        }

        @Override // com.mbridge.msdk.video.signal.impl.a.C0572a, com.mbridge.msdk.out.BaseTrackingListener
        public void onStartRedirection(Campaign campaign, String str) {
            super.onStartRedirection(campaign, str);
            MBTempContainer.this.y();
            if (MBTempContainer.this.f38897r0) {
                MBTempContainer.this.onPause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class p extends com.mbridge.msdk.video.module.listener.impl.f {
        private p() {
        }

        /* synthetic */ p(MBTempContainer mBTempContainer, b bVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:69:0x0161  */
        @Override // com.mbridge.msdk.video.module.listener.impl.f, com.mbridge.msdk.video.module.listener.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(int r7, java.lang.Object r8) {
            /*
                Method dump skipped, instructions count: 556
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBTempContainer.p.a(int, java.lang.Object):void");
        }
    }

    public MBTempContainer(Context context) {
        super(context);
        this.f38903x = 1;
        this.f38904y = "";
        this.A = com.mbridge.msdk.foundation.same.a.F;
        this.C = false;
        this.I = "";
        this.K = new ArrayList();
        this.L = 0;
        this.N = false;
        this.P = false;
        this.Q = new k.a();
        this.T = new Handler();
        this.U = 0;
        this.V = 0;
        this.W = new b();
        this.f38879a0 = new c();
        this.f38881c0 = false;
        this.f38882d0 = false;
        this.f38883e0 = false;
        this.f38885g0 = false;
        this.f38886h0 = false;
        this.f38887i0 = false;
        this.f38888j0 = false;
        this.f38889k0 = false;
        this.f38890l0 = false;
        this.f38892n0 = null;
        this.f38893o0 = null;
        this.f38894p0 = null;
        this.f38895q0 = new f();
        this.f38897r0 = false;
        init(context);
    }

    public MBTempContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f38903x = 1;
        this.f38904y = "";
        this.A = com.mbridge.msdk.foundation.same.a.F;
        this.C = false;
        this.I = "";
        this.K = new ArrayList();
        this.L = 0;
        this.N = false;
        this.P = false;
        this.Q = new k.a();
        this.T = new Handler();
        this.U = 0;
        this.V = 0;
        this.W = new b();
        this.f38879a0 = new c();
        this.f38881c0 = false;
        this.f38882d0 = false;
        this.f38883e0 = false;
        this.f38885g0 = false;
        this.f38886h0 = false;
        this.f38887i0 = false;
        this.f38888j0 = false;
        this.f38889k0 = false;
        this.f38890l0 = false;
        this.f38892n0 = null;
        this.f38893o0 = null;
        this.f38894p0 = null;
        this.f38895q0 = new f();
        this.f38897r0 = false;
        init(context);
    }

    private void A() {
        AppletsModel appletsModel;
        if (this.f38898s == null) {
            return;
        }
        try {
            appletsModel = AppletModelManager.getInstance().get(this.f38898s);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
            appletsModel = null;
        }
        if (appletsModel != null) {
            try {
                if (appletsModel.can(0)) {
                    appletsModel.setUserClick(false);
                    appletsModel.requestWxAppletsScheme(0, new l(this.f38898s));
                }
            } catch (Exception e12) {
                appletsModel.clearRequestState();
                if (MBridgeConstans.DEBUG) {
                    e12.printStackTrace();
                }
            }
        }
    }

    private int a(int i11, int i12) {
        List<CampaignEx> list;
        if (i11 < 0 || (list = this.K) == null || list.size() == 0 || i12 <= 1) {
            return i11;
        }
        int i13 = 0;
        for (int i14 = 0; i14 < i12 - 1; i14++) {
            if (this.K.get(i14) != null) {
                i13 += this.K.get(i14).getVideoLength();
            }
        }
        if (i11 > i13) {
            return i11 - i13;
        }
        return 0;
    }

    private void b(int i11, String str) {
        try {
            com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m();
            mVar.j("2000037");
            mVar.h("code=" + i11 + ",desc=" + str);
            CampaignEx campaignEx = this.f38898s;
            mVar.t((campaignEx == null || campaignEx.getRewardTemplateMode() == null) ? "" : this.f38898s.getRewardTemplateMode().e());
            mVar.u(this.f39836d);
            CampaignEx campaignEx2 = this.f38898s;
            mVar.b(campaignEx2 != null ? campaignEx2.getId() : "");
            CampaignEx campaignEx3 = this.f38898s;
            if (campaignEx3 != null && !TextUtils.isEmpty(campaignEx3.getRequestId())) {
                mVar.n(this.f38898s.getRequestId());
            }
            CampaignEx campaignEx4 = this.f38898s;
            if (campaignEx4 != null && !TextUtils.isEmpty(campaignEx4.getRequestIdNotice())) {
                mVar.o(this.f38898s.getRequestIdNotice());
            }
            int s11 = k0.s(getContext());
            mVar.c(s11);
            mVar.l(k0.a(getContext(), s11));
            com.mbridge.msdk.foundation.same.report.o.i(mVar);
        } catch (Throwable th2) {
            o0.b(f38878s0, th2.getMessage(), th2);
        }
    }

    private int getBufferTimeout() {
        try {
            com.mbridge.msdk.videocommon.setting.a c11 = com.mbridge.msdk.videocommon.setting.b.b().c();
            if (c11 == null) {
                com.mbridge.msdk.videocommon.setting.b.b().a();
            }
            if (c11 != null) {
                return (int) c11.i();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return 5;
    }

    private int getCloseBtnTime() {
        CampaignEx campaignEx = this.f38898s;
        if (campaignEx == null) {
            return 1;
        }
        boolean a11 = t0.a(MBridgeConstans.DYNAMIC_VIEW_KEY_CLOSE_BTN_DELATE, campaignEx.getendcard_url());
        int c11 = t0.c(this.f38898s.getendcard_url(), MBridgeConstans.DYNAMIC_VIEW_KEY_CLOSE_BTN_DELATE);
        return (!a11 || c11 < 0) ? this.f38898s.getCbd() > -2 ? this.f38898s.getCbd() : this.f39838f.i() : c11;
    }

    private void k() {
        if (this.f39838f == null) {
            this.f39838f = com.mbridge.msdk.videocommon.setting.b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), this.f39836d, this.f39843k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
            if (mBridgeVideoView == null || mBridgeVideoView.notifyListener == null) {
                eVar.a("notify_listener", 0);
            } else {
                eVar.a("notify_listener", 1);
                com.mbridge.msdk.video.module.listener.a aVar = this.mbridgeVideoView.notifyListener;
                if (aVar instanceof com.mbridge.msdk.video.module.listener.impl.n) {
                    eVar.a("listener_type", 1);
                } else if (aVar instanceof com.mbridge.msdk.video.module.listener.impl.m) {
                    eVar.a("listener_type", 2);
                } else {
                    eVar.a("listener_type", 3);
                }
            }
            com.mbridge.msdk.foundation.same.report.metrics.c cVar = this.M;
            if (cVar != null) {
                cVar.a("2000130", eVar);
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (isLoadSuccess()) {
            this.f39835c.runOnUiThread(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdClose() {
        int i11;
        try {
            com.mbridge.msdk.video.bt.module.listener.b bVar = this.f38901v;
            if (bVar == null) {
                Activity activity = this.f39835c;
                if (activity != null) {
                    activity.finish();
                    return;
                }
                return;
            }
            if (this.f39843k && ((i11 = this.f39845m) == com.mbridge.msdk.foundation.same.a.H || i11 == com.mbridge.msdk.foundation.same.a.I)) {
                boolean z10 = true;
                if (this.B != 1) {
                    z10 = false;
                }
                bVar.a(z10, this.A);
            }
            this.f38901v.a(this.f38904y, this.f38882d0, this.f39840h);
        } catch (Exception unused) {
            Activity activity2 = this.f39835c;
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }

    private void q() {
        com.iab.omid.library.mmadbridge.adsession.b bVar = this.f38892n0;
        if (bVar != null) {
            try {
                MBridgeContainerView mBridgeContainerView = this.S;
                FriendlyObstructionPurpose friendlyObstructionPurpose = FriendlyObstructionPurpose.OTHER;
                bVar.a(mBridgeContainerView, friendlyObstructionPurpose, null);
                View view = this.f38880b0;
                if (view != null) {
                    this.f38892n0.a(view, friendlyObstructionPurpose, null);
                }
                WindVaneWebView windVaneWebView = this.R;
                if (windVaneWebView != null) {
                    this.f38892n0.a(windVaneWebView, friendlyObstructionPurpose, null);
                }
                this.mbridgeVideoView.setVideoEvents(this.f38893o0);
                this.f38892n0.g();
                if (this.f38894p0 != null) {
                    com.iab.omid.library.mmadbridge.adsession.media.b b11 = com.iab.omid.library.mmadbridge.adsession.media.b.b(true, Position.STANDALONE);
                    o0.a("omsdk", "bt:   adEvents.loaded");
                    this.f38894p0.d(b11);
                    this.f38894p0.b();
                }
            } catch (Exception e11) {
                o0.a("omsdk", e11.getMessage());
            }
        }
    }

    private void r() {
        CampaignEx campaignEx;
        int i11;
        boolean z10 = true;
        try {
            this.f38881c0 = true;
            CampaignEx campaignEx2 = this.f38898s;
            if (campaignEx2 != null && campaignEx2.getPlayable_ads_without_video() == 2) {
                this.f38882d0 = true;
            }
            com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.f38893o0;
            if (aVar != null && !this.f38882d0) {
                try {
                    aVar.m();
                    this.f38893o0 = null;
                } catch (Exception e11) {
                    o0.a("omsdk", e11.getMessage());
                }
            }
            com.mbridge.msdk.video.bt.module.orglistener.h hVar = this.f38900u;
            if (hVar != null) {
                if (this.f39843k && ((i11 = this.f39845m) == com.mbridge.msdk.foundation.same.a.H || i11 == com.mbridge.msdk.foundation.same.a.I)) {
                    if (this.B != 1) {
                        z10 = false;
                    }
                    hVar.a(z10, this.A);
                }
                if (!this.f38882d0) {
                    this.f39840h.a(0);
                }
                this.M.a(this.f38898s);
                this.f38900u.a(this.M, this.f38882d0, this.f39840h);
            }
            this.T.removeCallbacks(this.f38895q0);
            if ((!this.f39843k && !this.f39848p) || ((campaignEx = this.f38898s) != null && campaignEx.isDynamicView())) {
                u();
            }
            if (!this.f39848p) {
                if (this.f39843k) {
                    com.mbridge.msdk.videocommon.a.b(MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.f38898s);
                } else {
                    com.mbridge.msdk.videocommon.a.b(94, this.f38898s);
                }
            }
            MBridgeContainerView mBridgeContainerView = this.S;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.release();
            }
        } catch (Throwable th2) {
            o0.b(f38878s0, th2.getMessage(), th2);
        }
    }

    private void s() {
        com.mbridge.msdk.foundation.same.report.h hVar = new com.mbridge.msdk.foundation.same.report.h(getContext());
        CampaignEx campaignEx = this.f38898s;
        if (campaignEx != null) {
            hVar.b(campaignEx.getRequestId(), this.f38898s.getRequestIdNotice(), this.f38898s.getId(), this.f39836d, com.mbridge.msdk.mbsignalcommon.mraid.c.b(this.f38898s.getId()), this.f38898s.isBidCampaign());
            com.mbridge.msdk.mbsignalcommon.mraid.c.a(this.f38898s.getId());
            this.f38884f0 = true;
        }
    }

    private void t() {
        int i11 = this.U;
        Runnable runnable = i11 == -3 ? this.W : i11 == -4 ? this.f38879a0 : null;
        if (runnable != null) {
            runnable.run();
            this.U = 0;
        }
    }

    private void u() {
        if (this.f38882d0) {
            if (com.mbridge.msdk.util.b.a() && checkChinaSendToServerDiff(this.f38900u)) {
                return;
            }
            o0.a(f38878s0, "sendToServerRewardInfo");
            com.mbridge.msdk.video.module.report.b.a(this.f38898s, this.f39840h, this.f39836d, this.f39839g, this.J);
        }
    }

    private void v() {
        getJSCommon().setAdEvents(this.f38894p0);
        getJSCommon().setAdSession(this.f38892n0);
        getJSCommon().setVideoEvents(this.f38893o0);
        getJSCommon().g(this.f39842j);
        getJSCommon().setUnitId(this.f39836d);
        getJSCommon().setRewardUnitSetting(this.f39838f);
        getJSCommon().a(new o(this, null));
        CampaignEx campaignEx = this.f38898s;
        if (campaignEx != null) {
            if (campaignEx.isMraid() || this.f38898s.isActiveOm()) {
                com.mbridge.msdk.mbsignalcommon.mraid.d dVar = new com.mbridge.msdk.mbsignalcommon.mraid.d(getContext());
                this.f38891m0 = dVar;
                dVar.c();
                this.f38891m0.a();
                this.f38891m0.a(new i());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        try {
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a("temp_container", getWidth() + "x" + getHeight());
            if (this.R != null) {
                eVar.a("web_view", this.R.getWidth() + "x" + this.R.getHeight());
            }
            if (this.mbridgeVideoView != null) {
                eVar.a("mbridge_video_view", this.mbridgeVideoView.getWidth() + "x" + this.mbridgeVideoView.getHeight());
                if (this.mbridgeVideoView.mPlayerView != null) {
                    eVar.a("player_view", this.mbridgeVideoView.mPlayerView.getWidth() + "x" + this.mbridgeVideoView.mPlayerView.getHeight());
                }
            }
            com.mbridge.msdk.foundation.same.report.metrics.c cVar = this.M;
            if (cVar != null) {
                cVar.a("2000136", eVar);
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (isLoadSuccess()) {
            this.f39835c.runOnUiThread(new j());
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    protected void b(String str) {
        com.mbridge.msdk.video.bt.module.orglistener.h hVar = this.f38900u;
        if (hVar != null) {
            hVar.a(this.M, str);
        }
        super.b(str);
    }

    public boolean canBackPress() {
        MBridgeContainerView mBridgeContainerView = this.S;
        return mBridgeContainerView == null || mBridgeContainerView.canBackPress();
    }

    public void defaultLoad(int i11, String str) {
        int i12;
        superDefaultLoad(i11, str);
        CampaignEx campaignEx = this.f38898s;
        if (campaignEx != null && !campaignEx.isDynamicView()) {
            this.f38898s.setTemplateRenderSucc(false);
        }
        if (!isLoadSuccess()) {
            b(i11, str);
            Activity activity = this.f39835c;
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        b bVar = null;
        if (this.f38898s.getPlayable_ads_without_video() == 2) {
            this.S.setCampaign(this.f38898s);
            this.S.addOrderViewData(this.K);
            this.S.setUnitID(this.f39836d);
            this.S.setCloseDelayTime(getCloseBtnTime());
            this.S.setPlayCloseBtnTm(this.f39838f.u());
            this.S.setNotifyListener(new com.mbridge.msdk.video.module.listener.impl.h(this.f38898s, this.f38899t, this.f39840h, getInnerPlacementId(), this.f39836d, new n(this, bVar), this.f39838f.A(), this.f39848p));
            this.S.preLoadData(this.f38905z);
            this.f38905z.getJSCommon().g(this.f39842j);
            this.S.showPlayableView();
        } else {
            b(i11, str);
            this.f38880b0.setVisibility(8);
            loadModuleDatas();
            int E = this.f39838f.E();
            int h5CloseType = getH5CloseType();
            int i13 = h5CloseType != 0 ? h5CloseType : E;
            CampaignEx campaignEx2 = this.f38898s;
            if (campaignEx2 != null && campaignEx2.isDynamicView()) {
                this.mbridgeVideoView.setContainerViewOnNotifyListener(new m(this.f39835c, this.f38898s));
            }
            CampaignEx campaignEx3 = this.f38898s;
            int F = (campaignEx3 == null || campaignEx3.getVst() <= -2) ? this.f39838f.F() : this.f38898s.getVst();
            CampaignEx campaignEx4 = this.f38898s;
            if (campaignEx4 != null && campaignEx4.getDynamicTempCode() == 5 && (i12 = this.f38903x) > 1) {
                F = a(F, i12);
                this.f38898s.setVst(F);
            }
            int i14 = F;
            this.mbridgeVideoView.setVideoSkipTime(i14);
            MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
            mBridgeVideoView.setNotifyListener(new com.mbridge.msdk.video.module.listener.impl.m(mBridgeVideoView, this.S, this.f38898s, this.f39840h, this.f38899t, getInnerPlacementId(), this.f39836d, i13, i14, new p(this, bVar), this.f39838f.A(), this.f39848p, this.f39838f.C()));
            this.mbridgeVideoView.setAdSession(this.f38892n0);
            this.mbridgeVideoView.setVideoEvents(this.f38893o0);
            this.mbridgeVideoView.defaultShow();
            MBridgeContainerView mBridgeContainerView = this.S;
            mBridgeContainerView.setNotifyListener(new com.mbridge.msdk.video.module.listener.impl.b(this.mbridgeVideoView, mBridgeContainerView, this.f38898s, this.f39840h, this.f38899t, getInnerPlacementId(), this.f39836d, new m(this.f39835c, this.f38898s), this.f39838f.A(), this.f39848p));
            this.S.defaultShow();
        }
        q();
    }

    public int findID(String str) {
        return g0.a(getContext(), str, "id");
    }

    public int findLayout(String str) {
        return g0.a(getContext(), str, TtmlNode.TAG_LAYOUT);
    }

    public MBridgeContainerView findMBridgeContainerView() {
        return (MBridgeContainerView) findViewById(findID("mbridge_video_templete_container"));
    }

    public MBridgeVideoView findMBridgeVideoView() {
        return (MBridgeVideoView) findViewById(findID("mbridge_video_templete_videoview"));
    }

    public WindVaneWebView findWindVaneWebView() {
        try {
            if (!this.f39848p) {
                a.C0573a a11 = this.f39843k ? com.mbridge.msdk.videocommon.a.a(MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.f38898s) : com.mbridge.msdk.videocommon.a.a(94, this.f38898s);
                if (a11 == null || !a11.c()) {
                    return null;
                }
                if (this.f39843k) {
                    com.mbridge.msdk.videocommon.a.b(MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.f38898s);
                } else {
                    com.mbridge.msdk.videocommon.a.b(94, this.f38898s);
                }
                WindVaneWebView b11 = a11.b();
                if (this.f38885g0) {
                    b11.setWebViewTransparent();
                }
                return b11;
            }
            CampaignEx campaignEx = this.f38898s;
            if (campaignEx == null || campaignEx.getRewardTemplateMode() == null) {
                return null;
            }
            a.C0573a b12 = com.mbridge.msdk.videocommon.a.b(this.f39836d + "_" + this.f38898s.getId() + "_" + this.f38898s.getRequestId() + "_" + this.f38898s.getRewardTemplateMode().e());
            if (b12 != null) {
                return b12.b();
            }
            return null;
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            e11.printStackTrace();
            return null;
        }
    }

    public com.iab.omid.library.mmadbridge.adsession.a getAdEvents() {
        return this.f38894p0;
    }

    public com.iab.omid.library.mmadbridge.adsession.b getAdSession() {
        return this.f38892n0;
    }

    public CampaignEx getCampaign() {
        return this.f38898s;
    }

    protected RelativeLayout.LayoutParams getContentLayoutParams() {
        return new RelativeLayout.LayoutParams(-1, -1);
    }

    protected int getH5CloseType() {
        com.mbridge.msdk.video.signal.impl.k b11 = b(this.f38898s);
        if (b11 != null) {
            return b11.l();
        }
        return 0;
    }

    protected int getH5DialogRole() {
        if (getJSCommon() != null) {
            return getJSCommon().d();
        }
        return 1;
    }

    protected int getH5MuteState() {
        com.mbridge.msdk.video.signal.impl.k b11 = b(this.f38898s);
        if (b11 != null) {
            return b11.m();
        }
        return 0;
    }

    public String getInstanceId() {
        return this.f38904y;
    }

    protected boolean getIsShowingTransparent() {
        com.mbridge.msdk.video.signal.impl.k b11 = b(this.f38898s);
        if (b11 != null) {
            return b11.p();
        }
        return false;
    }

    public int getLayoutID() {
        return findLayout(this.f38885g0 ? "mbridge_reward_activity_video_templete_transparent" : "mbridge_reward_activity_video_templete");
    }

    public com.iab.omid.library.mmadbridge.adsession.media.a getVideoEvents() {
        return this.f38893o0;
    }

    public void init(Context context) {
        this.O = LayoutInflater.from(context);
    }

    public boolean initViews() {
        View findViewById = findViewById(findID("mbridge_video_templete_progressbar"));
        this.f38880b0 = findViewById;
        return findViewById != null;
    }

    public boolean isHasDestoryed() {
        return this.C;
    }

    public boolean isLoadSuccess() {
        return this.P;
    }

    public void loadModuleDatas() {
        int i11;
        int i12;
        int h5MuteState = getH5MuteState();
        if (h5MuteState != 0) {
            this.f39842j = h5MuteState;
        }
        int E = this.f39838f.E();
        int h5CloseType = getH5CloseType();
        int i13 = h5CloseType != 0 ? h5CloseType : E;
        this.mbridgeVideoView.setSoundState(this.f39842j);
        this.mbridgeVideoView.setCampaign(this.f38898s);
        this.mbridgeVideoView.setPlayURL(this.f38899t.g());
        CampaignEx campaignEx = this.f38898s;
        int F = (campaignEx == null || campaignEx.getVst() <= -2) ? this.f39838f.F() : this.f38898s.getVst();
        CampaignEx campaignEx2 = this.f38898s;
        if (campaignEx2 != null && campaignEx2.getDynamicTempCode() == 5 && (i12 = this.f38903x) > 1) {
            F = a(F, i12);
            this.f38898s.setVst(F);
        }
        this.mbridgeVideoView.setVideoSkipTime(F);
        this.mbridgeVideoView.setCloseAlert(this.f39838f.h());
        this.mbridgeVideoView.setBufferTimeout(getBufferTimeout());
        int i14 = F;
        this.mbridgeVideoView.setNotifyListener(new com.mbridge.msdk.video.module.listener.impl.n(this.f38905z, this.f38898s, this.f39840h, this.f38899t, getInnerPlacementId(), this.f39836d, i13, F, new p(this, null), this.f39838f.A(), this.f39848p, this.f39838f.C()));
        this.mbridgeVideoView.setShowingTransparent(this.f38885g0);
        this.mbridgeVideoView.setAdSession(this.f38892n0);
        if (this.f39843k && ((i11 = this.f39845m) == com.mbridge.msdk.foundation.same.a.H || i11 == com.mbridge.msdk.foundation.same.a.I)) {
            this.mbridgeVideoView.setIVRewardEnable(i11, this.f39846n, this.f39847o);
            this.mbridgeVideoView.setDialogRole(getH5DialogRole());
        }
        this.S.setCampaign(this.f38898s);
        this.S.addOrderViewData(this.K);
        this.S.setUnitID(this.f39836d);
        this.S.setCloseDelayTime(getCloseBtnTime());
        this.S.setPlayCloseBtnTm(this.f39838f.u());
        this.S.setVideoInteractiveType(this.f39838f.D());
        this.S.setEndscreenType(this.f39838f.m());
        this.S.setVideoSkipTime(i14);
        this.S.setShowingTransparent(this.f38885g0);
        this.S.setJSFactory(this.f38905z);
        this.f38905z.getJSCommon().g(this.f39842j);
        if (this.f38898s.getPlayable_ads_without_video() == 2) {
            this.S.setNotifyListener(new com.mbridge.msdk.video.module.listener.impl.h(this.f38898s, this.f38899t, this.f39840h, getInnerPlacementId(), this.f39836d, new n(this, null), this.f39838f.A(), this.f39848p));
            this.S.preLoadData(this.f38905z);
            this.S.showPlayableView();
        } else {
            this.S.setNotifyListener(new com.mbridge.msdk.video.module.listener.impl.c(this.f38905z, this.f38898s, this.f39840h, this.f38899t, getInnerPlacementId(), this.f39836d, new m(this.f39835c, this.f38898s), this.f39838f.A(), this.f39848p));
            this.S.preLoadData(this.f38905z);
            this.mbridgeVideoView.preLoadData(this.f38905z);
        }
        if (this.f38885g0) {
            this.S.setMBridgeClickMiniCardViewTransparent();
        }
    }

    protected boolean n() {
        this.R = findWindVaneWebView();
        MBridgeVideoView findMBridgeVideoView = findMBridgeVideoView();
        this.mbridgeVideoView = findMBridgeVideoView;
        findMBridgeVideoView.setVideoLayout(this.f38898s);
        this.mbridgeVideoView.setIsIV(this.f39843k);
        this.mbridgeVideoView.setUnitId(this.f39836d);
        this.mbridgeVideoView.setCamPlayOrderCallback(this.f38902w, this.K, this.f38903x, this.L);
        if (this.f39848p) {
            this.mbridgeVideoView.setNotchPadding(this.E, this.F, this.G, this.H);
        }
        MBridgeContainerView findMBridgeContainerView = findMBridgeContainerView();
        this.S = findMBridgeContainerView;
        if (this.f39848p) {
            findMBridgeContainerView.setNotchPadding(this.D, this.E, this.F, this.G, this.H);
        }
        if (q0.a().a("i_l_s_t_r_i", false)) {
            this.mbridgeVideoView.setPlayerViewAttachListener(new d());
        }
        this.mbridgeVideoView.setIPlayVideoViewLayoutCallBack(new e());
        return (this.mbridgeVideoView == null || this.S == null || !initViews()) ? false : true;
    }

    protected boolean o() {
        if (this.mbridgeVideoView != null) {
            return com.mbridge.msdk.util.b.a() ? this.mbridgeVideoView.isShowingAlertView() || checkChinaShowingAlertViewState() || this.mbridgeVideoView.isRewardPopViewShowing() : this.mbridgeVideoView.isShowingAlertView() || this.mbridgeVideoView.isRewardPopViewShowing();
        }
        return false;
    }

    public void onBackPressed() {
        MBridgeContainerView mBridgeContainerView;
        MBridgeContainerView mBridgeContainerView2;
        MBridgeVideoView mBridgeVideoView;
        MBridgeVideoView mBridgeVideoView2;
        if (this.f38885g0 && (mBridgeVideoView2 = this.mbridgeVideoView) != null) {
            mBridgeVideoView2.notifyVideoClose();
            return;
        }
        CampaignEx campaignEx = this.f38898s;
        if (((campaignEx != null && campaignEx.getRewardTemplateMode() != null && this.f38898s.getRewardTemplateMode().f() == 5002010) || this.f38887i0) && (mBridgeVideoView = this.mbridgeVideoView) != null) {
            if (!mBridgeVideoView.isMiniCardShowing()) {
                this.mbridgeVideoView.onBackPress();
                return;
            }
            MBridgeContainerView mBridgeContainerView3 = this.S;
            if (mBridgeContainerView3 != null) {
                mBridgeContainerView3.onMiniEndcardBackPress();
                return;
            }
            return;
        }
        if (this.f38889k0 && (mBridgeContainerView2 = this.S) != null) {
            mBridgeContainerView2.onPlayableBackPress();
            return;
        }
        if (this.f38888j0 && (mBridgeContainerView = this.S) != null) {
            mBridgeContainerView.onEndcardBackPress();
        }
        if (getJSCommon().a()) {
            if (getJSContainerModule() == null || !getJSContainerModule().miniCardShowing()) {
                getActivityProxy().e();
                return;
            }
            return;
        }
        if (!canBackPress()) {
            o0.a(f38878s0, "onBackPressed can't excute");
            return;
        }
        Activity activity = this.f39835c;
        if (activity == null || this.f39848p || this.f38890l0) {
            return;
        }
        this.f38890l0 = true;
        activity.onBackPressed();
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate() {
        k();
        try {
            A();
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
        this.f38890l0 = false;
        try {
            if (this.f39848p) {
                CampaignEx campaignEx = this.f38898s;
                if (campaignEx == null || !campaignEx.isDynamicView()) {
                    this.f38900u = new com.mbridge.msdk.video.bt.module.orglistener.c(this.f38901v, this.f38904y);
                } else {
                    this.f38900u = new com.mbridge.msdk.video.bt.module.orglistener.d(getContext(), this.f39843k, this.f39838f, this.f38898s, this.f38900u, getInnerPlacementId(), this.f39836d);
                }
            } else {
                this.f38900u = new com.mbridge.msdk.video.bt.module.orglistener.d(getContext(), this.f39843k, this.f39838f, this.f38898s, this.f38900u, getInnerPlacementId(), this.f39836d);
            }
            registerErrorListener(new com.mbridge.msdk.video.bt.module.orglistener.e(this.M, this.f38900u));
            a(this.f39838f, this.f38898s);
            setShowingTransparent();
            int layoutID = getLayoutID();
            if (!g0.a(layoutID)) {
                b("layoutID not found");
                return;
            }
            View inflate = this.O.inflate(layoutID, (ViewGroup) null);
            this.f38896r = inflate;
            addView(inflate, getContentLayoutParams());
            x();
            if (n()) {
                this.P = true;
                p();
                return;
            }
            this.Q.onError("not found View IDS");
            Activity activity = this.f39835c;
            if (activity != null) {
                activity.finish();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            b("onCreate error" + th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onDestroy() {
        if (this.C) {
            return;
        }
        this.C = true;
        super.onDestroy();
        try {
            if (com.mbridge.msdk.util.b.a()) {
                setChinaDestroy();
            }
            MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
            if (mBridgeVideoView != null) {
                mBridgeVideoView.releasePlayer();
            }
            WindVaneWebView windVaneWebView = this.R;
            if (windVaneWebView != null) {
                ViewGroup viewGroup = (ViewGroup) windVaneWebView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                }
                this.R.clearWebView();
                this.R.release();
            }
            if (this.f38901v != null) {
                this.f38901v = null;
            }
            this.T.removeCallbacks(this.W);
            this.T.removeCallbacks(this.f38879a0);
            getJSCommon().release();
            if (this.f39843k) {
                com.mbridge.msdk.setting.h.b().g(this.f39836d);
            }
            if (!this.f38881c0) {
                r();
            }
            if (!this.f38884f0) {
                s();
            }
            com.mbridge.msdk.mbsignalcommon.mraid.d dVar = this.f38891m0;
            if (dVar != null) {
                dVar.d();
            }
            if (this.f38892n0 != null) {
                o0.b("omsdk", "tc onDestroy");
                this.f38892n0.e();
                this.f38892n0.c();
                this.f38892n0 = null;
            }
            if (!this.f39848p) {
                if (isLoadSuccess()) {
                    this.T.postDelayed(new g(), 100L);
                } else {
                    Activity activity = this.f39835c;
                    if (activity != null) {
                        activity.finish();
                    }
                }
            }
            if (!this.f38884f0) {
                s();
            }
            com.mbridge.msdk.video.bt.component.d.c().a(this.f38904y);
        } catch (Throwable th2) {
            o0.a(f38878s0, th2.getMessage());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onPause() {
        super.onPause();
        this.f38883e0 = true;
        try {
            getJSVideoModule().videoOperate(2);
            MBridgeContainerView mBridgeContainerView = this.S;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.setOnPause();
            }
            MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
            if (mBridgeVideoView != null) {
                mBridgeVideoView.onActivityPause();
            }
        } catch (Throwable th2) {
            o0.b(f38878s0, th2.getMessage(), th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onResume() {
        Activity activity;
        super.onResume();
        t();
        try {
            if (this.mbridgeVideoView != null && !o() && !this.mbridgeVideoView.isMiniCardShowing() && !com.mbridge.msdk.foundation.feedback.b.f35343f) {
                this.mbridgeVideoView.setCover(false);
            }
            MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
            if (mBridgeVideoView != null) {
                mBridgeVideoView.onActivityResume();
            }
            MBridgeContainerView mBridgeContainerView = this.S;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.setOnResume();
            }
            if (this.f38883e0 && !o() && !com.mbridge.msdk.foundation.feedback.b.f35343f) {
                getJSVideoModule().videoOperate(1);
            }
            Activity activity2 = this.f39835c;
            if (activity2 != null) {
                t0.a(activity2.getWindow().getDecorView());
            }
            if (this.f38885g0 && this.f38886h0 && (activity = this.f39835c) != null) {
                activity.finish();
            }
        } catch (Throwable th2) {
            o0.b(f38878s0, th2.getMessage(), th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onStop() {
        super.onStop();
        MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setCover(true);
            this.mbridgeVideoView.onActivityStop();
        }
    }

    protected void p() {
        ViewGroup viewGroup;
        List<CampaignEx> list;
        WindVaneWebView windVaneWebView = this.R;
        this.f38905z = new com.mbridge.msdk.video.signal.factory.b(this.f39835c, windVaneWebView, this.mbridgeVideoView, this.S, this.f38898s, new o(this, null));
        CampaignEx campaignEx = this.f38898s;
        if (campaignEx != null && campaignEx.getDynamicTempCode() == 5 && (list = this.K) != null) {
            this.f38905z.a(list);
        }
        registerJsFactory(this.f38905z);
        com.mbridge.msdk.foundation.feedback.b.b().a(this.f39836d + "_1", new h());
        q();
        if (windVaneWebView == null) {
            defaultLoad(0, "preload template webview is null or load error");
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.f38896r.findViewById(g0.a(getContext(), "mbridge_video_templete_webview_parent", "id"));
        windVaneWebView.setApiManagerJSFactory(this.f38905z);
        if (windVaneWebView.getParent() != null) {
            defaultLoad(0, "preload template webview is null or load error");
            return;
        }
        if (windVaneWebView.getObject() instanceof com.mbridge.msdk.video.signal.impl.k) {
            v();
            getJSContainerModule().readyStatus(((com.mbridge.msdk.video.signal.impl.k) windVaneWebView.getObject()).v());
            z();
            ((com.mbridge.msdk.video.signal.impl.k) windVaneWebView.getObject()).f39878m.onInitSuccess();
            if (this.f39848p) {
                getJSCommon().setWebViewFront(this.V);
            }
        }
        if (getJSCommon().b() == 1 && (viewGroup = (ViewGroup) this.f38896r.findViewById(g0.a(getContext(), "mbridge_video_templete_webview_parent", "id"))) != null) {
            ((ViewGroup) this.f38896r).removeView(viewGroup);
            ((ViewGroup) this.f38896r).addView(viewGroup, 1);
        }
        viewGroup2.addView(windVaneWebView, new ViewGroup.LayoutParams(-1, -1));
    }

    public void preload() {
    }

    public void receiveSuccess() {
        o0.a(f38878s0, "receiveSuccess ,start hybrid");
        this.T.removeCallbacks(this.f38879a0);
        this.T.postDelayed(this.f38895q0, 250L);
    }

    public void registerErrorListener(k kVar) {
        this.Q = kVar;
    }

    public void setAdEvents(com.iab.omid.library.mmadbridge.adsession.a aVar) {
        this.f38894p0 = aVar;
        com.mbridge.msdk.video.signal.factory.b bVar = this.f38905z;
        if (bVar == null || bVar.getJSCommon() == null) {
            return;
        }
        this.f38905z.getJSCommon().setAdEvents(aVar);
    }

    public void setAdSession(com.iab.omid.library.mmadbridge.adsession.b bVar) {
        this.f38892n0 = bVar;
        com.mbridge.msdk.video.signal.factory.b bVar2 = this.f38905z;
        if (bVar2 != null && bVar2.getJSCommon() != null) {
            this.f38905z.getJSCommon().setAdSession(bVar);
        }
        MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setAdSession(bVar);
        }
    }

    public void setCamPlayOrderCallback(com.mbridge.msdk.video.dynview.listener.a aVar, int i11) {
        this.f38902w = aVar;
        this.f38903x = i11;
    }

    public void setCampOrderViewData(List<CampaignEx> list, int i11) {
        if (list != null) {
            this.K = list;
        }
        this.L = i11;
    }

    public void setCampaign(CampaignEx campaignEx) {
        this.f38898s = campaignEx;
        if (campaignEx != null) {
            com.mbridge.msdk.foundation.same.report.metrics.c a11 = com.mbridge.msdk.foundation.same.report.metrics.d.b().a(campaignEx.getCurrentLocalRid());
            this.M = a11;
            if (a11 == null) {
                this.M = new com.mbridge.msdk.foundation.same.report.metrics.c();
            }
            this.M.h(campaignEx.getCurrentLocalRid());
            this.M.a(campaignEx);
            if (TextUtils.isEmpty(campaignEx.getCampaignUnitId()) && !TextUtils.isEmpty(this.f39836d)) {
                campaignEx.setCampaignUnitId(this.f39836d);
            }
            AppletsModel appletsModel = AppletModelManager.getInstance().get(campaignEx);
            if (appletsModel != null) {
                this.f38897r0 = appletsModel.isSupportWxScheme();
            }
            com.mbridge.msdk.foundation.feedback.b.b().a(campaignEx.getCampaignUnitId() + "_1", campaignEx);
        }
    }

    public void setCampaignDownLoadTask(com.mbridge.msdk.videocommon.download.a aVar) {
        this.f38899t = aVar;
    }

    public void setCampaignExpired(boolean z10) {
        try {
            CampaignEx campaignEx = this.f38898s;
            if (campaignEx != null) {
                if (z10) {
                    campaignEx.setSpareOfferFlag(1);
                    if (!com.mbridge.msdk.util.b.a()) {
                        com.mbridge.msdk.videocommon.setting.c cVar = this.f39838f;
                        if (cVar != null) {
                            if (cVar.A() == 1) {
                                this.f38898s.setCbt(1);
                            } else {
                                this.f38898s.setCbt(0);
                            }
                        }
                    } else if (this.f39844l) {
                        this.f38898s.setCbt(0);
                    } else {
                        com.mbridge.msdk.videocommon.setting.c cVar2 = this.f39838f;
                        if (cVar2 != null) {
                            if (cVar2.A() == 1) {
                                this.f38898s.setCbt(1);
                            } else {
                                this.f38898s.setCbt(0);
                            }
                        }
                    }
                } else {
                    campaignEx.setSpareOfferFlag(0);
                    this.f38898s.setCbt(0);
                }
            }
        } catch (Exception e11) {
            o0.b(f38878s0, e11.getMessage());
        }
    }

    public void setDeveloperExtraData(String str) {
        this.J = str;
    }

    public void setInstanceId(String str) {
        this.f38904y = str;
    }

    public void setJSFactory(com.mbridge.msdk.video.signal.factory.b bVar) {
        this.f38905z = bVar;
    }

    public void setMBridgeTempCallback(com.mbridge.msdk.video.bt.module.listener.b bVar) {
        this.f38901v = bVar;
    }

    public void setMatchParent() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        } else {
            layoutParams.height = -1;
            layoutParams.width = -1;
        }
    }

    public void setMediaPlayerUrl(String str) {
    }

    public void setNotchPadding(int i11, int i12, int i13, int i14, int i15) {
        this.D = i11;
        this.E = i12;
        this.F = i13;
        this.G = i14;
        this.H = i15;
        String a11 = b0.a(i11, i12, i13, i14, i15);
        this.I = a11;
        o0.b(f38878s0, a11);
        if (getJSCommon() != null && !TextUtils.isEmpty(this.I)) {
            getJSCommon().a(this.I);
            if (this.R != null && !TextUtils.isEmpty(this.I)) {
                com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) this.R, "oncutoutfetched", Base64.encodeToString(this.I.getBytes(), 0));
            }
        }
        MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setNotchPadding(i12, i13, i14, i15);
        }
        MBridgeContainerView mBridgeContainerView = this.S;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.setNotchPadding(i11, i12, i13, i14, i15);
        }
    }

    public void setShowRewardListener(com.mbridge.msdk.video.bt.module.orglistener.h hVar) {
        this.f38900u = hVar;
    }

    public void setShowingTransparent() {
        Activity activity;
        boolean isShowingTransparent = getIsShowingTransparent();
        this.f38885g0 = isShowingTransparent;
        if (isShowingTransparent) {
            return;
        }
        int a11 = g0.a(getContext(), "mbridge_reward_theme", TtmlNode.TAG_STYLE);
        if (!g0.a(a11) || (activity = this.f39835c) == null) {
            return;
        }
        activity.setTheme(a11);
    }

    public void setVideoEvents(com.iab.omid.library.mmadbridge.adsession.media.a aVar) {
        this.f38893o0 = aVar;
        com.mbridge.msdk.video.signal.factory.b bVar = this.f38905z;
        if (bVar != null && bVar.getJSCommon() != null) {
            this.f38905z.getJSCommon().setVideoEvents(aVar);
        }
        MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setVideoEvents(aVar);
        }
    }

    public void setWebViewFront(int i11) {
        this.V = i11;
    }

    public void superDefaultLoad(int i11, String str) {
        this.T.removeCallbacks(this.W);
        this.T.removeCallbacks(this.f38879a0);
        this.Q.a(true);
        WindVaneWebView windVaneWebView = this.R;
        if (windVaneWebView != null) {
            windVaneWebView.setVisibility(8);
        }
    }

    protected void x() {
        if (this.N) {
            setMatchParent();
        }
    }

    protected void z() {
        int g11;
        int f11;
        try {
            if (this.R != null) {
                int i11 = getResources().getConfiguration().orientation;
                if (getIsShowingTransparent()) {
                    g11 = t0.i(getContext());
                    f11 = t0.h(getContext());
                    if (com.mbridge.msdk.foundation.tools.e.a(getContext())) {
                        int c11 = t0.c(getContext());
                        if (i11 == 2) {
                            g11 += c11;
                        } else {
                            f11 += c11;
                        }
                    }
                } else {
                    g11 = t0.g(getContext());
                    f11 = t0.f(getContext());
                }
                int b11 = this.f38898s.getRewardTemplateMode().b();
                if (a(this.f38898s) == 1) {
                    b11 = i11;
                }
                getJSNotifyProxy().a(i11, b11, g11, f11);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.mbridge.msdk.foundation.same.a.f35394l, t0.d(getContext()));
                try {
                    if (this.f39840h != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("name", this.f39840h.c());
                        jSONObject2.put(RewardPlus.AMOUNT, this.f39840h.a());
                        jSONObject2.put("id", this.f39841i);
                        jSONObject.put("userId", this.f39839g);
                        jSONObject.put("reward", jSONObject2);
                        jSONObject.put("playVideoMute", this.f39842j);
                        jSONObject.put("extra", this.J);
                    }
                } catch (JSONException e11) {
                    o0.a(f38878s0, e11.getMessage());
                } catch (Exception e12) {
                    o0.a(f38878s0, e12.getMessage());
                }
                String jSONObject3 = jSONObject.toString();
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, 2);
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000133", this.f38898s, eVar);
                getJSNotifyProxy().a(jSONObject3);
                com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) this.R, "oncutoutfetched", Base64.encodeToString(this.I.getBytes(), 0));
                getJSCommon().b(true);
                if (com.mbridge.msdk.util.b.a()) {
                    setChinaCallBackStatus(this.R);
                }
                loadModuleDatas();
                this.T.postDelayed(this.W, 2000L);
            }
        } catch (Exception e13) {
            if (MBridgeConstans.DEBUG) {
                e13.printStackTrace();
            }
        }
    }
}
